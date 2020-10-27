package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.q;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.pb.videopb.b, a.InterfaceC0807a {
    private com.baidu.tieba.tbadkCore.data.e eLc;
    private com.baidu.tbadk.core.message.a eLs;
    private com.baidu.adp.lib.d.b<TbImageView> eSd;
    private LikeModel eTL;
    private bd eqG;
    private com.baidu.adp.lib.d.b<TextView> fDm;
    private com.baidu.adp.lib.d.b<View> fDn;
    private com.baidu.adp.lib.d.b<LinearLayout> fDo;
    private com.baidu.adp.lib.d.b<RelativeLayout> fDp;
    private com.baidu.adp.lib.d.b<ImageView> fzV;
    private com.baidu.adp.lib.d.b<GifView> fzW;
    private com.baidu.tieba.callfans.a hSV;
    private VoiceManager iBr;
    private com.baidu.tieba.frs.profession.permission.c iFN;
    private com.baidu.tieba.f.b iGn;
    public com.baidu.tbadk.core.util.am kpC;
    public bb ktH;
    private String ljN;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lnD;
    private View lnE;
    int lnG;
    private bf lnJ;
    private com.baidu.tieba.pb.pb.report.a lnN;
    private com.baidu.tbadk.core.dialog.i lnU;
    private com.baidu.tbadk.core.dialog.k lnV;
    private boolean lnW;
    private PbActivity lnl;
    private com.baidu.tieba.pb.pb.main.b.b lnn;
    private com.baidu.tieba.tbadkCore.data.f loa;
    private com.baidu.tbadk.editortools.pb.g lob;
    private com.baidu.tbadk.editortools.pb.e lod;
    private com.baidu.tieba.frs.profession.permission.c lof;
    private EmotionImageData loh;
    private com.baidu.adp.base.e lok;
    private com.baidu.tbadk.core.view.c lol;
    private BdUniqueId lom;
    private Runnable loo;
    private com.baidu.adp.widget.ImageView.a lop;
    private String loq;
    private TbRichTextMemeInfo lor;
    private List<a> lou;
    public String lox;
    private boolean lpa;
    private String lpj;
    private com.baidu.tbadk.core.data.r lpk;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a lpg = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cz(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dgM();
            } else {
                com.baidu.tieba.pb.a.b.dgL();
            }
        }
    };
    private boolean lnm = false;
    private boolean lno = false;
    private boolean byS = false;
    private boolean kJt = false;
    private boolean lnp = true;
    private int lnq = 0;
    private com.baidu.tbadk.core.dialog.b lnr = null;
    private long idU = -1;
    private long fpw = 0;
    private long lns = 0;
    private long createTime = 0;
    private long fpl = 0;
    private boolean lnt = false;
    private com.baidu.tbadk.n.b lnu = null;
    private long lnv = 0;
    private boolean lnw = false;
    private long lnx = 0;
    private int jfl = 1;
    private String fjU = null;
    private boolean lny = false;
    private boolean isFullScreen = false;
    private boolean lnz = false;
    private String lnA = "";
    private boolean lnB = true;
    private boolean lnC = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lnF = new int[2];
    private int lnH = -1;
    private int lnI = -1;
    public BdUniqueId lnK = BdUniqueId.gen();
    private boolean lnL = false;
    private boolean llm = com.baidu.tbadk.a.d.bfv();
    private PbInterviewStatusView.a lnM = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lnQ.uC(!PbFragment.this.lnB);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.ljR != null && PbFragment.this.ljR.bfV()) {
                        PbFragment.this.dig();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel ljR = null;
    private com.baidu.tbadk.baseEditMark.a lnO = null;
    private ForumManageModel hST = null;
    private com.baidu.tbadk.coreExtra.model.a eHC = null;
    private com.baidu.tieba.pb.data.q lnP = null;
    private ShareSuccessReplyToServerModel iUz = null;
    private az lnQ = null;
    private boolean lnR = false;
    private boolean lnS = false;
    private boolean lnT = false;
    private boolean fRa = false;
    private boolean lnX = false;
    private boolean lnY = false;
    private boolean lnZ = false;
    private boolean loe = false;
    public boolean loi = false;
    private com.baidu.tbadk.editortools.pb.c fjX = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bxD() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fjY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bxC() {
            if (PbFragment.this.ktH == null || PbFragment.this.ktH.dlZ() == null || !PbFragment.this.ktH.dlZ().dQt()) {
                return !PbFragment.this.FC(com.baidu.tbadk.core.util.am.eHx);
            }
            PbFragment.this.showToast(PbFragment.this.ktH.dlZ().dQv());
            if (PbFragment.this.lod != null && (PbFragment.this.lod.bxT() || PbFragment.this.lod.bxU())) {
                PbFragment.this.lod.a(false, PbFragment.this.ktH.dmc());
            }
            PbFragment.this.ktH.uP(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b loj = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bxC() {
            if (PbFragment.this.ktH == null || PbFragment.this.ktH.dma() == null || !PbFragment.this.ktH.dma().dQt()) {
                return !PbFragment.this.FC(com.baidu.tbadk.core.util.am.eHy);
            }
            PbFragment.this.showToast(PbFragment.this.ktH.dma().dQv());
            if (PbFragment.this.lnQ != null && PbFragment.this.lnQ.dkI() != null && PbFragment.this.lnQ.dkI().dhH() != null && PbFragment.this.lnQ.dkI().dhH().bxU()) {
                PbFragment.this.lnQ.dkI().dhH().a(PbFragment.this.ktH.dmc());
            }
            PbFragment.this.ktH.uQ(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean iCg = false;
    private int los = 0;
    private int lot = -1;
    public int lov = 0;
    private final a loy = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lnQ != null && PbFragment.this.lnQ.dkI() != null) {
                v dkI = PbFragment.this.lnQ.dkI();
                if (dkI.dhF()) {
                    dkI.dhE();
                    return true;
                }
            }
            if (PbFragment.this.lnQ != null && PbFragment.this.lnQ.dlG()) {
                PbFragment.this.lnQ.dlH();
                return true;
            }
            return false;
        }
    };
    private final ai.a loz = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void aa(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lnQ.showToast(str);
            }
        }
    };
    private final CustomMessageListener loA = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.ljR != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lod != null) {
                    PbFragment.this.lnQ.uH(PbFragment.this.lod.bxM());
                }
                PbFragment.this.lnQ.dkK();
                PbFragment.this.lnQ.dly();
            }
        }
    };
    CustomMessageListener iCX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.ljR.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.lnQ != null && PbFragment.this.ljR != null) {
                    PbFragment.this.lnQ.b(PbFragment.this.ljR.getPbData(), PbFragment.this.ljR.diX(), PbFragment.this.ljR.dju(), PbFragment.this.lnQ.getSkinType());
                }
                if (PbFragment.this.lnQ != null && PbFragment.this.lnQ.dlb() != null) {
                    PbFragment.this.lnQ.dlb().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener loB = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lnQ != null) {
                    if (booleanValue) {
                        PbFragment.this.lnQ.cQT();
                    } else {
                        PbFragment.this.lnQ.cQS();
                    }
                }
            }
        }
    };
    private CustomMessageListener loC = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lod != null) {
                    PbFragment.this.lnQ.uH(PbFragment.this.lod.bxM());
                }
                PbFragment.this.lnQ.uJ(false);
            }
        }
    };
    private CustomMessageListener loD = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.p) eVar.getData());
                        return;
                    case 1:
                        PbFragment.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            PbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbFragment.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener loE = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lnQ != null && PbFragment.this.lnQ.dlb() != null) {
                PbFragment.this.lnQ.dlb().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jQR = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener iCT = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.byS) {
                PbFragment.this.diy();
            }
        }
    };
    private View.OnClickListener fkG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fjU);
        }
    };
    private CustomMessageListener loF = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ag)) {
                com.baidu.tbadk.core.data.ag agVar = (com.baidu.tbadk.core.data.ag) customResponsedMessage.getData();
                ax.a aVar = new ax.a();
                aVar.giftId = agVar.id;
                aVar.giftName = agVar.name;
                aVar.thumbnailUrl = agVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.ljR.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.ljR.djl() != null && PbFragment.this.ljR.djl().getUserIdLong() == agVar.toUserId) {
                        PbFragment.this.lnQ.a(agVar.sendCount, PbFragment.this.ljR.getPbData(), PbFragment.this.ljR.diX(), PbFragment.this.ljR.dju());
                    }
                    if (pbData.dfK() != null && pbData.dfK().size() >= 1 && pbData.dfK().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dfK().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.ljR.diV(), 0L);
                        if (j == agVar.postId && j2 == agVar.threadId) {
                            com.baidu.tbadk.core.data.ax dHF = pbData.dfK().get(0).dHF();
                            if (dHF == null) {
                                dHF = new com.baidu.tbadk.core.data.ax();
                            }
                            ArrayList<ax.a> biS = dHF.biS();
                            if (biS == null) {
                                biS = new ArrayList<>();
                            }
                            biS.add(0, aVar);
                            dHF.setTotal(agVar.sendCount + dHF.getTotal());
                            dHF.D(biS);
                            pbData.dfK().get(0).a(dHF);
                            PbFragment.this.lnQ.dlb().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener loG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                PbFragment.this.ljR.getPbData().dgc();
                PbFragment.this.ljR.djq();
                if (PbFragment.this.lnQ.dlb() != null) {
                    PbFragment.this.lnQ.s(PbFragment.this.ljR.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener iVT = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Ph(str);
                PbFragment.this.ljR.djq();
                if (!TextUtils.isEmpty(str) && PbFragment.this.ljR.getPbData().dfK() != null) {
                    ArrayList<PostData> dfK = PbFragment.this.ljR.getPbData().dfK();
                    Iterator<PostData> it = dfK.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            nVar = null;
                            break;
                        }
                        PostData next = it.next();
                        if ((next instanceof com.baidu.tieba.tbadkCore.data.n) && str.equals(((com.baidu.tieba.tbadkCore.data.n) next).getAdId())) {
                            nVar = (com.baidu.tieba.tbadkCore.data.n) next;
                            break;
                        }
                    }
                    if (nVar != null) {
                        dfK.remove(nVar);
                        if (PbFragment.this.lnQ.dlb() != null && PbFragment.this.lnQ.dlb().getDataList() != null) {
                            PbFragment.this.lnQ.dlb().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.lnQ.getListView() != null && PbFragment.this.lnQ.getListView().getData() != null) {
                            PbFragment.this.lnQ.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.lnQ.dlb() != null) {
                            PbFragment.this.lnQ.dlb().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lnQ.dlb() != null) {
                    PbFragment.this.lnQ.s(PbFragment.this.ljR.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a loH = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dms()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a loI = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aa(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.lnQ != null) {
                PbFragment.this.lnQ.eW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean loJ = false;
    private PraiseModel loK = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Fn(String str) {
            PbFragment.this.loJ = false;
            if (PbFragment.this.loK != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.ljR.getPbData();
                if (pbData.dfI().bjL().getIsLike() == 1) {
                    PbFragment.this.zG(0);
                } else {
                    PbFragment.this.zG(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dfI()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.loJ = false;
            if (PbFragment.this.loK != null && str != null) {
                if (AntiHelper.bN(i, str)) {
                    AntiHelper.bm(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a loL = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void ug(boolean z) {
            PbFragment.this.ue(z);
            if (PbFragment.this.lnQ.dlM() != null && z) {
                PbFragment.this.lnQ.uC(false);
            }
            PbFragment.this.lnQ.uE(z);
        }
    };
    private CustomMessageListener eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().eYM != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().eYM, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.dfR().bka() != null && PbFragment.this.dfR().bka().getGodUserData() != null) {
                            PbFragment.this.dfR().bka().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().bka() != null) {
                            PbFragment.this.ljR.getPbData().dfI().bka().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h iAv = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.lnl.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a loM = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lnQ.ceD();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.FE(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.cFE();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c fbT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.dhQ();
            }
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                if (view != null) {
                    if (view.getId() == R.id.richText) {
                        if (PbFragment.this.dd(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.lnQ.dhO() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dR("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.dgN() != null && PbFragment.this.dgN().ikM != null) {
                                PbFragment.this.dgN().ikM.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view.getTag();
                        }
                        if (sparseArray != null) {
                            PbFragment.this.d(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (PbFragment.this.lod != null) {
                    PbFragment.this.lnQ.uH(PbFragment.this.lod.bxM());
                }
                PbFragment.this.lnQ.dkK();
                PbFragment.this.lnQ.dly();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener loN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lom) {
                PbFragment.this.lnQ.ceD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.ljR.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dfY().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lol.showSuccessToast(PbFragment.this.lok.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lok.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.DF(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.diu();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lok.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lol.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener loO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lom) {
                PbFragment.this.lnQ.ceD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lol.showSuccessToast(PbFragment.this.lok.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lok.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lol.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener loP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lom) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lnQ.ceD();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nfE;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    PbFragment.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbFragment.this.lnQ.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener loQ = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lnQ.dkL() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dhQ();
            }
        }
    };
    private CustomMessageListener iDf = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.iCg = true;
                }
            }
        }
    };
    public a.b kUA = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cwk();
            com.baidu.tbadk.core.data.av pageData = PbFragment.this.ljR.getPageData();
            int pageNum = PbFragment.this.lnQ.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.biL()) {
                PbFragment.this.lnQ.dly();
                PbFragment.this.cwj();
                PbFragment.this.lnQ.dlf();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.ljR.FI(PbFragment.this.lnQ.getPageNum());
                    if (PbFragment.this.lnn != null) {
                        PbFragment.this.lnn.showFloatingView();
                    }
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
                aVar.dismiss();
            } else {
                PbFragment.this.showToast(R.string.pb_page_error);
            }
        }
    };
    private k.c loR = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lnU != null) {
                PbFragment.this.lnU.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.lop != null && !TextUtils.isEmpty(PbFragment.this.loq)) {
                        if (PbFragment.this.lor == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.loq));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.loq;
                            aVar.pkgId = PbFragment.this.lor.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lor.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lop = null;
                        PbFragment.this.loq = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lop != null && !TextUtils.isEmpty(PbFragment.this.loq)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eqG == null) {
                                PbFragment.this.eqG = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eqG.j(PbFragment.this.loq, PbFragment.this.lop.getImageByte());
                            PbFragment.this.lop = null;
                            PbFragment.this.loq = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.jER != null) {
                        PbFragment.this.jER.fT(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.jER = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").aj("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.de(view);
                        if (PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().bka() != null && PbFragment.this.ljR.getPbData().dfI().bka().getUserId() != null && PbFragment.this.lnO != null) {
                            int h = PbFragment.this.h(PbFragment.this.ljR.getPbData());
                            bw dfI = PbFragment.this.ljR.getPbData().dfI();
                            if (dfI.biI()) {
                                i2 = 2;
                            } else if (dfI.biJ()) {
                                i2 = 3;
                            } else if (dfI.blV()) {
                                i2 = 4;
                            } else {
                                i2 = dfI.blW() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dR("tid", PbFragment.this.ljR.lrg).aj("obj_locate", 2).dR("obj_id", PbFragment.this.ljR.getPbData().dfI().bka().getUserId()).aj("obj_type", PbFragment.this.lnO.bfV() ? 0 : 1).aj("obj_source", h).aj("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13079"));
                        PbFragment.this.Pj((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").aj("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.c(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.lnQ.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null) {
                        boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray4.put(R.id.tag_from, 1);
                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                PbFragment.this.c(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.lnQ.dk(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lnQ.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.blR() != null) {
                            PbFragment.this.d(postData.blR());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public SortSwitchButton.a loS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zj(int i) {
            PbFragment.this.lnQ.dly();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.ljR == null || PbFragment.this.ljR.isLoading) {
                    return false;
                }
                PbFragment.this.cwj();
                PbFragment.this.lnQ.dlf();
                if (PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().lgX != null && PbFragment.this.ljR.getPbData().lgX.size() > i) {
                    int intValue = PbFragment.this.ljR.getPbData().lgX.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dR("tid", PbFragment.this.ljR.diW()).dR("fid", PbFragment.this.ljR.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).aj("obj_type", FG(intValue)));
                    if (PbFragment.this.ljR.FN(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lnQ.ux(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int FG(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            return 0;
        }
    };
    public final View.OnClickListener iEe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        /* JADX WARN: Removed duplicated region for block: B:787:0x22e3  */
        /* JADX WARN: Removed duplicated region for block: B:790:0x2327  */
        /* JADX WARN: Removed duplicated region for block: B:807:0x2500  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            String name;
            int i;
            int i2;
            cb cbVar;
            SparseArray sparseArray;
            boolean z2;
            String str;
            com.baidu.tbadk.core.dialog.g gVar4;
            String[] strArr;
            com.baidu.tieba.pb.data.f pbData;
            boolean B;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.lnQ.dlu()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.ljR.um(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lnQ.dlg();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dkk()) {
                        if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dkl()) {
                            if (view == PbFragment.this.lnQ.lva.frR) {
                                if (PbFragment.this.lnQ.uG(PbFragment.this.ljR.djc())) {
                                    PbFragment.this.cwj();
                                    return;
                                }
                                PbFragment.this.lnp = false;
                                PbFragment.this.lno = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lnl, PbFragment.this.lnQ.lva.frR);
                                PbFragment.this.lnl.finish();
                            } else if (view != PbFragment.this.lnQ.dld() && (PbFragment.this.lnQ.lva.dmF() == null || (view != PbFragment.this.lnQ.lva.dmF().dkj() && view != PbFragment.this.lnQ.lva.dmF().dkh()))) {
                                if (view == PbFragment.this.lnQ.dlC()) {
                                    if (PbFragment.this.ljR != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.ljR.getPbData().dfI().bjZ().getLink());
                                    }
                                } else if (view != PbFragment.this.lnQ.lva.lBr) {
                                    if (view == PbFragment.this.lnQ.lva.lBs) {
                                        if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                            ArrayList<PostData> dfK = PbFragment.this.ljR.getPbData().dfK();
                                            if ((dfK == null || dfK.size() <= 0) && PbFragment.this.ljR.diX()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dR("tid", PbFragment.this.ljR.diV()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", PbFragment.this.ljR.getForumId()));
                                            if (!PbFragment.this.lnQ.dlR()) {
                                                PbFragment.this.lnQ.dkK();
                                            }
                                            PbFragment.this.dhY();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lnQ.tT(true);
                                            PbFragment.this.lnQ.dkK();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lnQ.cQT();
                                                PbFragment.this.cwj();
                                                PbFragment.this.lnQ.dlf();
                                                PbFragment.this.ljR.Po(PbFragment.this.dik());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dkg()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lnQ.lva.dmF() != null && view == PbFragment.this.lnQ.lva.dmF().dkf()) {
                                                PbFragment.this.lnQ.lva.aXc();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.FD(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.FF(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dkd()) {
                                                    if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dkn()) {
                                                        if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dke()) {
                                                            if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dko()) {
                                                                if (PbFragment.this.lnQ.dlM() == view) {
                                                                    if (PbFragment.this.lnQ.dlM().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.ljR.getPbData();
                                                                        if (pbData2 != null && pbData2.dfI() != null && pbData2.dfI().bjG() != null) {
                                                                            String bjw = pbData2.dfI().bjG().bjw();
                                                                            if (StringUtils.isNull(bjw)) {
                                                                                bjw = pbData2.dfI().bjG().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dR("obj_id", bjw));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gq("c10725", null);
                                                                    }
                                                                    PbFragment.this.dir();
                                                                } else if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dkm()) {
                                                                    if (PbFragment.this.lnQ.lva.dmF() != null && view == PbFragment.this.lnQ.lva.dmF().dki()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lnQ.b(PbFragment.this.ljR.getPbData(), PbFragment.this.ljR.diX(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lnQ.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lnQ.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lnQ.lva.aXc();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dR("tid", PbFragment.this.ljR.diV());
                                                                            aqVar.dR("fid", PbFragment.this.ljR.getForumId());
                                                                            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.aj("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                                                                PbFragment.this.lnQ.dly();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dHJ() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.mRJ != null) {
                                                                                        com.baidu.tbadk.core.util.aq boJ = postData.mRJ.boJ();
                                                                                        boJ.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            boJ.aj("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            boJ.aj("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(boJ);
                                                                                    }
                                                                                    String diV = PbFragment.this.ljR.diV();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.ljR.getPbData() != null) {
                                                                                        i3 = PbFragment.this.ljR.getPbData().dfX();
                                                                                    }
                                                                                    PbFragment.this.cwj();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a Pm = PbFragment.this.Pm(id);
                                                                                        if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && Pm != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(diV, id, "pb", true, null, true, null, i3, postData.dnF(), PbFragment.this.ljR.getPbData().getAnti(), false, postData.bka().getIconInfo()).addBigImageData(Pm.ljZ, Pm.erD, Pm.erB, Pm.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.ljR.djF());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.ljR.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.ljR.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.ljR.dje());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a Pm2 = PbFragment.this.Pm(id);
                                                                                        if (postData != null && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && Pm2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(diV, id, "pb", true, null, false, str2, i3, postData.dnF(), PbFragment.this.ljR.getPbData().getAnti(), false, postData.bka().getIconInfo()).addBigImageData(Pm2.ljZ, Pm2.erD, Pm2.erB, Pm2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.ljR.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.ljR.dje());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.ljR.djF());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.ljR.getFromForumId());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData2));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").aj("obj_locate", 3).dR("fid", PbFragment.this.ljR.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.ljR != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dR("tid", PbFragment.this.ljR.diV());
                                                                            aqVar2.dR("fid", PbFragment.this.ljR.getForumId());
                                                                            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.aj("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.mRJ != null) {
                                                                                        com.baidu.tbadk.core.util.aq boJ2 = postData3.mRJ.boJ();
                                                                                        boJ2.delete("obj_locate");
                                                                                        boJ2.aj("obj_locate", 8);
                                                                                        TiebaStatic.log(boJ2);
                                                                                    }
                                                                                    if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                                                                        String diV2 = PbFragment.this.ljR.diV();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.ljR.getPbData() != null) {
                                                                                            i4 = PbFragment.this.ljR.getPbData().dfX();
                                                                                        }
                                                                                        PbActivity.a Pm3 = PbFragment.this.Pm(id2);
                                                                                        if (Pm3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(diV2, id2, "pb", true, null, false, null, i4, postData3.dnF(), PbFragment.this.ljR.getPbData().getAnti(), false, postData3.bka().getIconInfo()).addBigImageData(Pm3.ljZ, Pm3.erD, Pm3.erB, Pm3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.ljR.djF());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.ljR.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.ljR.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.ljR.dje());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData3));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                        if (PbFragment.this.ljR != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dR("tid", PbFragment.this.ljR.diV());
                                                                                aqVar3.dR("fid", PbFragment.this.ljR.getForumId());
                                                                                aqVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.aj("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.mRJ != null) {
                                                                                        com.baidu.tbadk.core.util.aq boJ3 = postData4.mRJ.boJ();
                                                                                        boJ3.delete("obj_locate");
                                                                                        boJ3.aj("obj_locate", 8);
                                                                                        TiebaStatic.log(boJ3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", PbFragment.this.ljR.diW()).dR("fid", PbFragment.this.ljR.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).aj("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.dhN().dkH() != null && postData4.bka() != null && postData4.dHx() != 1) {
                                                                                        if (PbFragment.this.dhN().dkI() != null) {
                                                                                            PbFragment.this.dhN().dkI().dhD();
                                                                                        }
                                                                                        if ((PbFragment.this.llm || com.baidu.tbadk.a.d.bfl()) && postData4.dHu() != null && postData4.dHu().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.bfm()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.ljR.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.ljR.getPbData().dfI());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.dhN().dkH().d(pVar);
                                                                                            PbFragment.this.dhN().dkH().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.bka().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lod != null) {
                                                                                                PbFragment.this.lnQ.uH(PbFragment.this.lod.bxM());
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                        if (view != PbFragment.this.lnQ.dhh()) {
                                                                            if (view == PbFragment.this.lnQ.lva.dmG()) {
                                                                                PbFragment.this.lnQ.dlm();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (cbVar = (cb) view.getTag()) != null && !StringUtils.isNull(cbVar.bmq())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        com.baidu.tbadk.core.util.be.boR().b(PbFragment.this.getPageContext(), new String[]{cbVar.bmq()});
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11740"));
                                                                                        if (view != null && view.getTag() != null) {
                                                                                            SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                            PostData postData5 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                            if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dR("tid", PbFragment.this.ljR.lrg));
                                                                                            }
                                                                                            if (PbFragment.this.lnV == null) {
                                                                                                PbFragment.this.lnV = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lnV.a(PbFragment.this.loR);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.df(view);
                                                                                            if (!PbFragment.this.df(view) || PbFragment.this.lop == null || !PbFragment.this.lop.isGif()) {
                                                                                            }
                                                                                            boolean z3 = false;
                                                                                            boolean z4 = false;
                                                                                            boolean z5 = false;
                                                                                            boolean z6 = false;
                                                                                            boolean z7 = false;
                                                                                            String str3 = null;
                                                                                            if (sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                                ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                                z3 = ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z4 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                                z5 = ((Boolean) sparseArray5.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z6 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                                z7 = ((Boolean) sparseArray5.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                                                                                str3 = (String) sparseArray5.get(R.id.tag_forbid_user_post_id);
                                                                                            }
                                                                                            if (postData5 != null) {
                                                                                                if (postData5.dHz() != null && postData5.dHz().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lnV);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.mTextView.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.jER = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.ljR.getPbData().bfV()) {
                                                                                                String bfU = PbFragment.this.ljR.getPbData().bfU();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bfU) && bfU.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lnV);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lnV);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.jER);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lnV);
                                                                                                            SparseArray sparseArray8 = new SparseArray();
                                                                                                            sparseArray8.put(R.id.tag_user_mute_visible, true);
                                                                                                            sparseArray8.put(R.id.tag_is_mem, sparseArray5.get(R.id.tag_is_mem));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_userid, sparseArray5.get(R.id.tag_user_mute_mute_userid));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_username, sparseArray5.get(R.id.tag_user_mute_mute_username));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_nameshow, sparseArray5.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_post_id, sparseArray5.get(R.id.tag_user_mute_post_id));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_thread_id, sparseArray5.get(R.id.tag_user_mute_thread_id));
                                                                                                            sparseArray8.put(R.id.tag_del_post_is_self, sparseArray5.get(R.id.tag_del_post_is_self));
                                                                                                            sparseArray8.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            sparseArray8.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray8.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            gVar.mTextView.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar6);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.ua(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lnV);
                                                                                                                gVar7.mTextView.setTag(str3);
                                                                                                                arrayList.add(gVar7);
                                                                                                            }
                                                                                                        }
                                                                                                        if (z5) {
                                                                                                            SparseArray sparseArray9 = new SparseArray();
                                                                                                            sparseArray9.put(R.id.tag_should_manage_visible, true);
                                                                                                            sparseArray9.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name, sparseArray5.get(R.id.tag_forbid_user_name));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name_show, sparseArray5.get(R.id.tag_forbid_user_name_show));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_portrait, sparseArray5.get(R.id.tag_forbid_user_portrait));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_post_id, str3);
                                                                                                            if (z6) {
                                                                                                                sparseArray9.put(R.id.tag_user_mute_visible, true);
                                                                                                                sparseArray9.put(R.id.tag_is_mem, sparseArray5.get(R.id.tag_is_mem));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_userid, sparseArray5.get(R.id.tag_user_mute_mute_userid));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_username, sparseArray5.get(R.id.tag_user_mute_mute_username));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_nameshow, sparseArray5.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_post_id, sparseArray5.get(R.id.tag_user_mute_post_id));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_thread_id, sparseArray5.get(R.id.tag_user_mute_thread_id));
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                            }
                                                                                                            if (z7) {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                                sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                                sparseArray9.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                                sparseArray9.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lnV);
                                                                                                                gVar2.mTextView.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lnV);
                                                                                                            gVar3.mTextView.setTag(sparseArray9);
                                                                                                        } else if (!z7) {
                                                                                                            gVar2 = null;
                                                                                                            gVar3 = null;
                                                                                                        } else {
                                                                                                            SparseArray sparseArray10 = new SparseArray();
                                                                                                            sparseArray10.put(R.id.tag_should_manage_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_user_mute_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_should_delete_visible, true);
                                                                                                            sparseArray10.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                            sparseArray10.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray10.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            if (PbFragment.this.ljR.getPbData().dfX() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lnV);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lnV);
                                                                                                            }
                                                                                                            gVar2.mTextView.setTag(sparseArray10);
                                                                                                            gVar3 = null;
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar3 != null) {
                                                                                                            arrayList.add(gVar3);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.lnV.bk(arrayList);
                                                                                                    PbFragment.this.lnU = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lnV);
                                                                                                    PbFragment.this.lnU.PJ();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.jER);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lnV.bk(arrayList);
                                                                                            PbFragment.this.lnU = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lnV);
                                                                                            PbFragment.this.lnU.PJ();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.ljR.getPbData().dfI().getActUrl());
                                                                                        if (PbFragment.this.ljR.getPbData().dfI().bkN() != 1) {
                                                                                            if (PbFragment.this.ljR.getPbData().dfI().bkN() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dR("fid", PbFragment.this.ljR.getPbData().getForumId()).dR("tid", PbFragment.this.ljR.getPbData().getThreadId()).dR("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.ljR.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lnQ.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bg.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.bnH().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.lnQ.dkK();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dhW() == 1 && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dR("fid", PbFragment.this.ljR.getPbData().getForumId()).dR("tid", PbFragment.this.ljR.getPbData().getThreadId()).dR("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dhW() == 1 && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dR("fid", PbFragment.this.ljR.getPbData().getForumId()).dR("tid", PbFragment.this.ljR.getPbData().getThreadId()).dR("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dim();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.din();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dge() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.ljR.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dR("fid", pbData3.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.boR().b(PbFragment.this.getPageContext(), new String[]{pbData3.dge().dgq()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dge() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.ljR.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dR("fid", pbData4.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.boR().b(PbFragment.this.getPageContext(), new String[]{pbData4.dge().dgq()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.los >= 0) {
                                                                                        if (PbFragment.this.ljR != null) {
                                                                                            PbFragment.this.ljR.djG();
                                                                                        }
                                                                                        if (PbFragment.this.ljR != null && PbFragment.this.lnQ.dlb() != null) {
                                                                                            PbFragment.this.lnQ.dlb().a(PbFragment.this.ljR.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.los = 0;
                                                                                        if (PbFragment.this.ljR != null) {
                                                                                            PbFragment.this.lnQ.getListView().setSelection(PbFragment.this.ljR.djJ());
                                                                                            PbFragment.this.ljR.cZ(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.FD(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.FF(8);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                                    SparseArray sparseArray11 = null;
                                                                                    if (view.getTag() instanceof SparseArray) {
                                                                                        sparseArray11 = (SparseArray) view.getTag();
                                                                                    }
                                                                                    if (sparseArray11 != null) {
                                                                                        PbFragment.this.d(sparseArray11);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                                    if (PbFragment.this.lnQ.getListView() != null && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lnQ.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lnQ.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dgi = PbFragment.this.ljR.getPbData().dgi();
                                                                                        boolean z8 = PbFragment.this.lnQ.dkJ() != null && PbFragment.this.lnQ.dkJ().bUC();
                                                                                        boolean dlv = PbFragment.this.lnQ.dlv();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (dgi && PbFragment.this.lnQ.dkJ() != null && PbFragment.this.lnQ.dkJ().bMO() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lnQ.dkJ().dmp();
                                                                                            z9 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.lnQ.dkJ().bMO().getHeight() - PbFragment.this.lnQ.dkJ().dmp());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.Pn("c13568");
                                                                                        if ((PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().bjR() <= 0) || (dlv && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dhT();
                                                                                                if (PbFragment.this.ljR.getPbData().dfI().bka() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", PbFragment.this.ljR.lrg).dR("fid", PbFragment.this.ljR.getPbData().getForumId()).aj("obj_locate", 2).dR("uid", PbFragment.this.ljR.getPbData().dfI().bka().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dgi) {
                                                                                                if (PbFragment.this.lnQ.lwk != null && PbFragment.this.lnQ.lwk.lxp != null && PbFragment.this.lnQ.lwk.lxp.getView() != null) {
                                                                                                    if (PbFragment.this.lnQ.lwk.lxp.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dic();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.lnQ.dkJ() != null && PbFragment.this.lnQ.dkJ().bMO() != null) {
                                                                                                            i6 = PbFragment.this.lnQ.dkJ().bMO().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lnQ.lwk.lxp.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lnQ.dkS() != null) {
                                                                                                z10 = PbFragment.this.lnQ.dkS().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lnQ.lwk != null && PbFragment.this.lnQ.lwk.lxp != null && PbFragment.this.lnQ.lwk.lxp.getView() != null && PbFragment.this.lnQ.lwk.lxp.getView().getParent() != null && PbFragment.this.lnQ.lva != null && PbFragment.this.lnQ.lva.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lnQ.lwk.lxp.getView().getTop() - PbFragment.this.lnQ.lva.mNavigationBar.getBottom() < PbFragment.this.lnQ.lwk.lxp.luz.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || dlv) {
                                                                                                PbFragment.this.lnH = firstVisiblePosition;
                                                                                                PbFragment.this.lnI = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lnQ.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.lnQ.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lnQ.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lnH > 0) {
                                                                                                if (PbFragment.this.lnQ.getListView().getChildAt(PbFragment.this.lnH) != null) {
                                                                                                    PbFragment.this.lnQ.getListView().smoothScrollToPosition(PbFragment.this.lnH, PbFragment.this.lnI, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lnQ.getListView().setSelectionFromTop(PbFragment.this.lnH, PbFragment.this.lnI + equipmentHeight);
                                                                                                    PbFragment.this.lnQ.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dic = PbFragment.this.dic();
                                                                                                if (PbFragment.this.dib() != -1) {
                                                                                                    dic--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dic < 0) {
                                                                                                    i = PbFragment.this.lnQ.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.lnQ.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = dic;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!dgi || PbFragment.this.lnQ.dkJ() == null) {
                                                                                                    if (PbFragment.this.lnQ.lva != null && PbFragment.this.lnQ.lva.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.lnQ.lva.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.lnQ.dkJ().dmo();
                                                                                                }
                                                                                                if (PbFragment.this.lnQ.lwk == null || PbFragment.this.lnQ.lwk.lxp == null || PbFragment.this.lnQ.lwk.lxp.getView() == null || PbFragment.this.lnQ.lwk.lxp.getView().getParent() == null) {
                                                                                                    PbFragment.this.lnQ.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.lnQ.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lnQ.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lnQ.getListView().smoothScrollBy(PbFragment.this.lnQ.lwk.lxp.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().bka() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", PbFragment.this.ljR.lrg).dR("fid", PbFragment.this.ljR.getPbData().getForumId()).aj("obj_locate", 2).dR("uid", PbFragment.this.ljR.getPbData().dfI().bka().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.ljR.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.ljR.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.ljR.dgP()) || PbFragment.this.ljR.getAppealInfo() == null) {
                                                                                                PbFragment.this.lnl.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.ljR.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.ljR.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lnl.finish();
                                                                                            return;
                                                                                        }
                                                                                        String dgP = PbFragment.this.ljR.dgP();
                                                                                        if (PbFragment.this.ljR.diY() && dgP != null && dgP.equals(name)) {
                                                                                            PbFragment.this.lnl.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.ljR.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dR("tid", PbFragment.this.ljR.diV());
                                                                                        aqVar4.dR("fid", PbFragment.this.ljR.getForumId());
                                                                                        aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.ljR.getPbData().dfI() != null) {
                                                                                            aqVar4.dR("nid", PbFragment.this.ljR.getPbData().dfI().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar = (bw) view.getTag();
                                                                                        if (PbFragment.this.ljR.djF() == 3 && PbFragment.this.dgO() && PbFragment.this.ljR.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.ljR.getPbData().dgf())) {
                                                                                            PbFragment.this.lnl.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar.bke(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar5 = new com.baidu.tbadk.core.util.aq("c13399");
                                                                                        aqVar5.dR("tid", bwVar.getId());
                                                                                        aqVar5.w("fid", bwVar.getFid());
                                                                                        aqVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar5.dR("nid", bwVar.getNid());
                                                                                        TiebaStatic.log(aqVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.ljR != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dR("tid", PbFragment.this.ljR.diV());
                                                                                        aqVar6.dR("fid", PbFragment.this.ljR.getForumId());
                                                                                        aqVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.aj("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.ljR.getPbData();
                                                                                        if (PbFragment.this.lnP == null) {
                                                                                            PbFragment.this.lnP = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").w("forum_id", j2).boK();
                                                                                        PbFragment.this.registerListener(PbFragment.this.loV);
                                                                                        PbFragment.this.lnP.F(j, j2);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_video_thread_smart_app_layout) {
                                                                                    if (view.getTag() instanceof SmartApp) {
                                                                                        SmartApp smartApp = (SmartApp) view.getTag();
                                                                                        if (!com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                            if (!StringUtils.isNull(smartApp.h5_url)) {
                                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), smartApp.h5_url);
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dR("fid", PbFragment.this.ljR.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", smartApp.name).w("obj_id", smartApp.swan_app_id.longValue()).dR("obj_source", "PB_card").dR("tid", PbFragment.this.ljR.diV()).aj("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar2 = (bw) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar2.bke(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_adlocate", 9).aj("obj_locate", 9).w("obj_id", bwVar2.getFid()).dR("tid", bwVar2.getId()).aj("thread_type", bwVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bw) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bw bwVar3 = (bw) view.getTag();
                                                                                        if (PbFragment.this.eTL != null) {
                                                                                            PbFragment.this.eTL.gp(bwVar3.bke(), String.valueOf(bwVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_adlocate", 10).aj("obj_locate", 11).w("obj_id", bwVar3.getFid()).dR("tid", bwVar3.getId()).aj("thread_type", bwVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.ljR.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.ljR.diV(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.ljR.getPbData().dfI().bkv())));
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            sparseArray = (SparseArray) view.getTag();
                                                                        } catch (ClassCastException e) {
                                                                            e.printStackTrace();
                                                                            sparseArray = null;
                                                                        }
                                                                        PostData postData6 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                        if (postData6 != null) {
                                                                            if (PbFragment.this.lnV == null) {
                                                                                PbFragment.this.lnV = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lnV.a(PbFragment.this.loR);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dgX().getPbData() != null && PbFragment.this.dgX().getPbData().dgl();
                                                                            if (view != null && sparseArray != null) {
                                                                                boolean z12 = false;
                                                                                boolean z13 = false;
                                                                                boolean z14 = false;
                                                                                boolean z15 = false;
                                                                                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                                    z2 = false;
                                                                                } else {
                                                                                    z2 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z12 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                    z13 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z14 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                    z15 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                }
                                                                                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                                                                                }
                                                                                if (postData6.blR() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.blR().hasAgree && postData6.blB() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lnV);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.mTextView.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lnV);
                                                                                        SparseArray sparseArray13 = new SparseArray();
                                                                                        sparseArray13.put(R.id.tag_user_mute_visible, true);
                                                                                        sparseArray13.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                                                                        sparseArray13.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                                                                        sparseArray13.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                                                                                        sparseArray13.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                                                                                        sparseArray13.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                        sparseArray13.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                        sparseArray13.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                        gVar9.mTextView.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar9);
                                                                                    } else {
                                                                                        if ((PbFragment.this.ua(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lnV);
                                                                                            gVar10.mTextView.setTag(str);
                                                                                            arrayList2.add(gVar10);
                                                                                        }
                                                                                    }
                                                                                    com.baidu.tbadk.core.dialog.g gVar11 = null;
                                                                                    if (z13) {
                                                                                        SparseArray sparseArray14 = new SparseArray();
                                                                                        sparseArray14.put(R.id.tag_should_manage_visible, true);
                                                                                        sparseArray14.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_post_id, str);
                                                                                        if (z14) {
                                                                                            sparseArray14.put(R.id.tag_user_mute_visible, true);
                                                                                            sparseArray14.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                                                                            sparseArray14.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                                                                            sparseArray14.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_user_mute_visible, false);
                                                                                        }
                                                                                        if (z15) {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray14.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray14.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray14.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lnV);
                                                                                            gVar11.mTextView.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lnV);
                                                                                        gVar4.mTextView.setTag(sparseArray14);
                                                                                    } else {
                                                                                        if (z15) {
                                                                                            SparseArray sparseArray15 = new SparseArray();
                                                                                            sparseArray15.put(R.id.tag_should_manage_visible, false);
                                                                                            sparseArray15.put(R.id.tag_user_mute_visible, false);
                                                                                            sparseArray15.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray15.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                            sparseArray15.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray15.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray15.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            if (PbFragment.this.ljR.getPbData().dfX() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lnV);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lnV);
                                                                                            }
                                                                                            gVar11.mTextView.setTag(sparseArray15);
                                                                                        }
                                                                                        gVar4 = null;
                                                                                    }
                                                                                    if (gVar11 != null) {
                                                                                        arrayList2.add(gVar11);
                                                                                    }
                                                                                    if (gVar4 != null) {
                                                                                        arrayList2.add(gVar4);
                                                                                    }
                                                                                }
                                                                                PbFragment.this.lnV.bk(arrayList2);
                                                                                PbFragment.this.lnU = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lnV);
                                                                                PbFragment.this.lnU.PJ();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lnQ.dly();
                                                                    SparseArray<Object> b3 = PbFragment.this.lnQ.b(PbFragment.this.ljR.getPbData(), PbFragment.this.ljR.diX(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.ljR.getPbData().getForum().getId(), PbFragment.this.ljR.getPbData().getForum().getName(), PbFragment.this.ljR.getPbData().dfI().getId(), String.valueOf(PbFragment.this.ljR.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } else {
                                                                    PbFragment.this.showToast(R.string.network_not_available);
                                                                    return;
                                                                }
                                                            } else {
                                                                int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                if (skinType == 1) {
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    com.baidu.tbadk.core.util.ap.C(true, false);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).aj("obj_type", 0).aj("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).aj("obj_type", 1).aj("obj_source", 1));
                                                                }
                                                                PbFragment.this.lnQ.lva.dmE();
                                                            }
                                                        } else if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dfI() != null) {
                                                            PbFragment.this.lnQ.lva.aXc();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.Pj(PbFragment.this.ljR.getPbData().dfI().bkr());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lnQ.dly();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.ljR.djo()));
                                                                return;
                                                            }
                                                            PbFragment.this.cwj();
                                                            PbFragment.this.lnQ.dlf();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.ljR.getPbData().lgX == null || PbFragment.this.ljR.getPbData().lgX.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.ljR.getPbData().lgX.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.ljR.getPbData().lgX.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.ljR.getPbData().lgX.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.ljR.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.ljR.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.ljR.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.ljR.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").aj("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).aj("obj_type", i10));
                                                                    if (PbFragment.this.ljR.getPbData().lgX != null && PbFragment.this.ljR.getPbData().lgX.size() > i9) {
                                                                        i9 = PbFragment.this.ljR.getPbData().lgX.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean FN = PbFragment.this.ljR.FN(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.ljR.djo()));
                                                                    if (FN) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lnQ.ux(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.PJ();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.lnQ.dly();
                                                    if (PbFragment.this.dgX().getPbData().lgY != 2) {
                                                        if (PbFragment.this.ljR.getPageData() != null) {
                                                            PbFragment.this.lnQ.a(PbFragment.this.ljR.getPageData(), PbFragment.this.kUA);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.ljR.getPbData()) != null) {
                                                bw dfI = pbData.dfI();
                                                if (dfI != null && dfI.bka() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", PbFragment.this.ljR.lrg).dR("fid", pbData.getForumId()).aj("obj_locate", 4).dR("uid", dfI.bka().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (dfI != null) {
                                                    if (dfI.biI()) {
                                                        i9 = 2;
                                                    } else if (dfI.biJ()) {
                                                        i9 = 3;
                                                    } else if (dfI.blV()) {
                                                        i9 = 4;
                                                    } else if (dfI.blW()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar7.dR("tid", PbFragment.this.ljR.diV());
                                                aqVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar7.dR("fid", PbFragment.this.ljR.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar7.aj("obj_locate", 5);
                                                } else {
                                                    aqVar7.aj("obj_locate", 6);
                                                }
                                                aqVar7.aj("obj_name", i9);
                                                aqVar7.aj("obj_type", 1);
                                                if (dfI != null) {
                                                    if (dfI.biI()) {
                                                        aqVar7.aj("obj_type", 10);
                                                    } else if (dfI.biJ()) {
                                                        aqVar7.aj("obj_type", 9);
                                                    } else if (dfI.blW()) {
                                                        aqVar7.aj("obj_type", 8);
                                                    } else if (dfI.blV()) {
                                                        aqVar7.aj("obj_type", 7);
                                                    } else if (dfI.isShareThread) {
                                                        aqVar7.aj("obj_type", 6);
                                                    } else if (dfI.threadType == 0) {
                                                        aqVar7.aj("obj_type", 1);
                                                    } else if (dfI.threadType == 40) {
                                                        aqVar7.aj("obj_type", 2);
                                                    } else if (dfI.threadType == 49) {
                                                        aqVar7.aj("obj_type", 3);
                                                    } else if (dfI.threadType == 54) {
                                                        aqVar7.aj("obj_type", 4);
                                                    } else {
                                                        aqVar7.aj("obj_type", 5);
                                                    }
                                                    aqVar7.aj(IntentConfig.CARD_TYPE, dfI.blZ());
                                                    aqVar7.dR(IntentConfig.RECOM_SOURCE, dfI.mRecomSource);
                                                    aqVar7.dR("ab_tag", dfI.mRecomAbTag);
                                                    aqVar7.dR("weight", dfI.mRecomWeight);
                                                    aqVar7.dR("extra", dfI.mRecomExtra);
                                                    aqVar7.dR("nid", dfI.getNid());
                                                    if (dfI.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(dfI.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar7.dR("obj_param6", dfI.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar7.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.diC() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.diC(), aqVar7);
                                                }
                                                TiebaStatic.log(aqVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dfK2 = PbFragment.this.ljR.getPbData().dfK();
                                                    if ((dfK2 != null && dfK2.size() > 0) || !PbFragment.this.ljR.diX()) {
                                                        PbFragment.this.lnQ.dly();
                                                        PbFragment.this.cwj();
                                                        if (pbData.dge() != null && !StringUtils.isNull(pbData.dge().bhW(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dR("fid", PbFragment.this.ljR.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dfI)) {
                                                            if (PbFragment.this.lnQ != null) {
                                                                PbFragment.this.lnQ.dlB();
                                                                PbFragment.this.lnQ.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lnQ.showLoadingDialog();
                                                                PbFragment.this.ljR.djA().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.FE(i10);
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                        return;
                                                    }
                                                } else {
                                                    com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lnQ.dly();
                                            if (PbFragment.this.lnQ.lva.dmF() != null && view == PbFragment.this.lnQ.lva.dmF().dkg() && !PbFragment.this.lnQ.dlR()) {
                                                PbFragment.this.lnQ.dkK();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cwj();
                                                PbFragment.this.lnQ.dlf();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    B = PbFragment.this.ljR.B(true, PbFragment.this.dik());
                                                } else {
                                                    B = view.getId() == R.id.reply_title ? PbFragment.this.ljR.B(false, PbFragment.this.dik()) : PbFragment.this.ljR.Po(PbFragment.this.dik());
                                                }
                                                view.setTag(Boolean.valueOf(B));
                                                if (B) {
                                                    PbFragment.this.lnQ.tT(true);
                                                    PbFragment.this.lnQ.cQT();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lnQ.ux(true);
                                                }
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.lnQ.dly();
                                        if (PbFragment.this.FD(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.ljR.FO(PbFragment.this.lnQ.dlk()) != null) {
                                            PbFragment.this.dif();
                                            if (PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().bka() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", PbFragment.this.ljR.lrg).dR("fid", PbFragment.this.ljR.getPbData().getForumId()).aj("obj_locate", 3).dR("uid", PbFragment.this.ljR.getPbData().dfI().bka().getUserId()));
                                            }
                                            if (PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().bka() != null && PbFragment.this.ljR.getPbData().dfI().bka().getUserId() != null && PbFragment.this.lnO != null) {
                                                int h = PbFragment.this.h(PbFragment.this.ljR.getPbData());
                                                bw dfI2 = PbFragment.this.ljR.getPbData().dfI();
                                                int i11 = 1;
                                                if (dfI2.biI()) {
                                                    i11 = 2;
                                                } else if (dfI2.biJ()) {
                                                    i11 = 3;
                                                } else if (dfI2.blV()) {
                                                    i11 = 4;
                                                } else if (dfI2.blW()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dR("tid", PbFragment.this.ljR.lrg).aj("obj_locate", 1).dR("obj_id", PbFragment.this.ljR.getPbData().dfI().bka().getUserId()).aj("obj_type", PbFragment.this.lnO.bfV() ? 0 : 1).aj("obj_source", h).aj("obj_param1", i11));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else {
                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                    if (PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().biG() && PbFragment.this.ljR.getPbData().dfI().bks() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.ljR.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.ljR.dgP()) || PbFragment.this.ljR.getAppealInfo() == null) {
                                            PbFragment.this.lnl.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.ljR.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.ljR.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lnl.finish();
                                        return;
                                    }
                                    String dgP2 = PbFragment.this.ljR.dgP();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.ljR.diY() && dgP2 != null && dgP2.equals(name2)) {
                                        PbFragment.this.lnl.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.ljR.getPbData() != null) {
                                    if ((PbFragment.this.ljR.getPbData().dfX() == 1 || PbFragment.this.ljR.getPbData().dfX() == 3) && !PbFragment.this.hST.dIi()) {
                                        PbFragment.this.lnQ.dly();
                                        int i12 = 0;
                                        if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dkh()) {
                                            if (PbFragment.this.lnQ.lva.dmF() == null || view != PbFragment.this.lnQ.lva.dmF().dkj()) {
                                                if (view == PbFragment.this.lnQ.dld()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.ljR.getPbData().dfI().bjW() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.ljR.getPbData().dfI().bjV() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.ljR.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.ljR.getPbData().dfI().getId();
                                        PbFragment.this.lnQ.dlc();
                                        PbFragment.this.hST.b(id4, name3, id5, i12, PbFragment.this.lnQ.dle());
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.lnQ.lva.dmE();
                            if (PbFragment.this.ljR != null) {
                                PbFragment.this.hSV.setThreadId(PbFragment.this.ljR.diV());
                            }
                            int i13 = 1;
                            if (PbFragment.this.ljR == null || !PbFragment.this.ljR.isPrivacy()) {
                                PbFragment.this.hSV.clm();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dgX() != null && PbFragment.this.dgX().getPbData() != null && PbFragment.this.dgX().getPbData().getThreadId() != null && PbFragment.this.dgX().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.dgX() != null && PbFragment.this.dgX().getPbData() != null) {
                                    PbFragment.this.hSV.l(3, i13, PbFragment.this.dgX().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dgX() != null && PbFragment.this.dgX().getPbData() != null) {
                                    PbFragment.this.hSV.l(3, 3, PbFragment.this.dgX().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lnQ.dly();
                        PbFragment.this.cwj();
                        PbFragment.this.lnQ.dlf();
                        PbFragment.this.lnQ.showLoadingDialog();
                        if (PbFragment.this.lnQ.dkS() != null) {
                            PbFragment.this.lnQ.dkS().setVisibility(8);
                        }
                        PbFragment.this.ljR.FI(1);
                        if (PbFragment.this.lnn != null) {
                            PbFragment.this.lnn.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dhU = PbFragment.this.dhU();
                        if (!TextUtils.isEmpty(dhU)) {
                            com.baidu.tbadk.core.util.be.boR().b(PbFragment.this.getPageContext(), new String[]{dhU});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar8.dR("tid", PbFragment.this.ljR.diV());
                aqVar8.dR("fid", PbFragment.this.ljR.getForumId());
                aqVar8.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar8.aj("obj_locate", 1);
                TiebaStatic.log(aqVar8);
                if (PbFragment.this.lnw) {
                    PbFragment.this.lnw = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.dhN().dkH() != null && postData7.bka() != null && postData7.dHx() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.dhN().dkI() != null) {
                                PbFragment.this.dhN().dkI().dhD();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.ljR.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.ljR.getPbData().dfI());
                            pVar2.g(postData7);
                            PbFragment.this.dhN().dkH().d(pVar2);
                            PbFragment.this.dhN().dkH().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.bka().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.ljR.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lod != null) {
                                PbFragment.this.lnQ.uH(PbFragment.this.lod.bxM());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener loT = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.ljR != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.ljR.lrg)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.ljR.getPbData() != null) {
                    aqVar.dR("fid", PbFragment.this.ljR.getPbData().getForumId());
                }
                aqVar.dR("tid", PbFragment.this.ljR.diV());
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.cwj();
            PbFragment.this.lnQ.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbFragment.this.g(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.ljR.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.ljR.getPbData();
                            if (pbData != null && pbData.dfI() != null && pbData.dfI().bka() != null && (userId = pbData.dfI().bka().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.ljR.djh()) {
                                PbFragment.this.lnQ.dlf();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.ljR.djh()) {
                            PbFragment.this.lnQ.dlf();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lnQ.s(PbFragment.this.ljR.getPbData());
                    }
                    if (PbFragment.this.ljR.djb()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dR("tid", PbFragment.this.ljR.diV()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.tZ(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lod.bxT() || PbFragment.this.lod.bxU()) {
                    PbFragment.this.lod.a(false, postWriteCallBackData);
                }
                PbFragment.this.ktH.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kpC != null) {
                    PbFragment.this.kpC.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ba(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ba(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bmC();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d loU = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                    aqVar.dR("fid", PbFragment.this.ljR.getPbData().getForumId());
                }
                if (PbFragment.this.ljR != null) {
                    aqVar.dR("tid", PbFragment.this.ljR.diV());
                }
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.ktH != null) {
                    PbFragment.this.ktH.dlX();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(PbFragment.this.getPageContext(), postWriteCallBackData);
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.kpC != null) {
                    PbFragment.this.kpC.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ba(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ba(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bmC();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.ktH != null) {
                if (PbFragment.this.lnQ != null && PbFragment.this.lnQ.dkI() != null && PbFragment.this.lnQ.dkI().dhH() != null && PbFragment.this.lnQ.dkI().dhH().bxU()) {
                    PbFragment.this.lnQ.dkI().dhH().a(postWriteCallBackData);
                }
                PbFragment.this.ktH.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a loV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dlU;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lnl.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lnQ != null && (dlU = PbFragment.this.lnQ.dlU()) != null && PbFragment.this.lnQ.getListView() != null) {
                            PbFragment.this.lnQ.getListView().removeHeaderView(dlU);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a loW = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qX;
            if (!z || fVar == null || fVar.dfV() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dfK()) >= 1) {
                PbFragment.this.kJt = true;
                PbFragment.this.lnQ.dlh();
                if (fVar == null || !fVar.dfQ()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lnQ.getView());
                }
                PbFragment.this.lnQ.cQS();
                if (PbFragment.this.isFullScreen || PbFragment.this.lnQ.dlR()) {
                    PbFragment.this.lnQ.dlI();
                } else if (!PbFragment.this.lnQ.dlF()) {
                    PbFragment.this.lnQ.uJ(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.fRa = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lnQ.getView());
                    PbFragment.this.lnQ.dlq();
                }
                if (z && fVar != null) {
                    bw dfI = fVar.dfI();
                    if (dfI == null || !dfI.biK()) {
                        PbFragment.this.d(PbFragment.this.lob);
                    } else {
                        diE();
                    }
                    PbFragment.this.lnQ.dkI().setPbData(fVar);
                    PbFragment.this.lnQ.bSR();
                    if (dfI != null && dfI.bll() != null) {
                        PbFragment.this.a(dfI.bll());
                    }
                    if (PbFragment.this.lod != null) {
                        PbFragment.this.lnQ.uH(PbFragment.this.lod.bxM());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dfK() != null && fVar.dfK().size() >= 1 && fVar.dfK().get(0) != null) {
                        PbFragment.this.ljR.Pq(fVar.dfK().get(0).getId());
                    } else if (fVar.dfV() != null) {
                        PbFragment.this.ljR.Pq(fVar.dfV().getId());
                    }
                    if (PbFragment.this.lod != null) {
                        PbFragment.this.lod.a(fVar.getAnti());
                        PbFragment.this.lod.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lod.setThreadData(dfI);
                        PbFragment.this.lod.a(PbFragment.this.ljR.djl(), PbFragment.this.ljR.diV(), PbFragment.this.ljR.djC());
                        if (dfI != null) {
                            PbFragment.this.lod.kc(dfI.blx());
                        }
                    }
                    if (PbFragment.this.lnO != null) {
                        PbFragment.this.lnO.ih(fVar.bfV());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dgl()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lnQ.uI(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lnQ.a(fVar, i2, i3, PbFragment.this.ljR.diX(), i4, PbFragment.this.ljR.getIsFromMark());
                    PbFragment.this.lnQ.d(fVar, PbFragment.this.ljR.diX());
                    PbFragment.this.lnQ.uF(PbFragment.this.ljR.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fjU = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fjU) && PbFragment.this.lod != null && PbFragment.this.lod.bwY() != null && (qX = PbFragment.this.lod.bwY().qX(6)) != null && !TextUtils.isEmpty(PbFragment.this.fjU)) {
                            ((View) qX).setOnClickListener(PbFragment.this.fkG);
                        }
                    }
                    if (PbFragment.this.lnX) {
                        PbFragment.this.lnX = false;
                        final int dib = PbFragment.this.dib();
                        if (!fVar.dgi()) {
                            PbFragment.this.lnQ.FV(dib);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dib, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lnY) {
                        PbFragment.this.lnY = false;
                        final int dib2 = PbFragment.this.dib();
                        final boolean z2 = dib2 != -1;
                        if (!z2) {
                            dib2 = PbFragment.this.dic();
                        }
                        if (PbFragment.this.lnQ != null) {
                            if (!fVar.dgi()) {
                                PbFragment.this.lnQ.FV(dib2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dib2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lnQ.setSelectionFromTop(dib2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lnQ.setSelectionFromTop(dib2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lnQ.uK(true);
                                PbFragment.this.lnQ.uJ(false);
                            }
                        }
                    } else if (PbFragment.this.lnZ) {
                        PbFragment.this.lnZ = false;
                        PbFragment.this.lnQ.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lnQ.dll();
                    }
                    PbFragment.this.ljR.a(fVar.getForum(), PbFragment.this.loH);
                    PbFragment.this.ljR.a(PbFragment.this.loI);
                    if (PbFragment.this.kpC != null && dfI != null && dfI.bka() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dfI.bka());
                        PbFragment.this.kpC.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.fRa && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.ljR.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.ljR.getAppealInfo().lgP)) {
                                    PbFragment.this.lnQ.a(PbFragment.this.ljR.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lnQ.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lnQ.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lnQ.dlI();
                            PbFragment.this.lnQ.dlp();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.ljR.diV());
                            jSONObject.put("fid", PbFragment.this.ljR.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                        kVar.setOpType("2");
                        kVar.start();
                    }
                    if (i == -1) {
                        PbFragment.this.lnQ.Pw("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                            arrayList = PbFragment.this.ljR.getPbData().dfK();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dHx() != 1)) {
                            PbFragment.this.lnQ.Pw(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.div()) {
                                PbFragment.this.lnQ.Px(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lnQ.Px(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lnQ.s(PbFragment.this.ljR.getPbData());
                        }
                    }
                    PbFragment.this.lnQ.endLoadData();
                }
                if (fVar != null && fVar.lhe && PbFragment.this.fpw == 0) {
                    PbFragment.this.fpw = System.currentTimeMillis() - PbFragment.this.idU;
                }
                if (!PbFragment.this.dgX().diX() || PbFragment.this.dgX().getPbData().getPage().biR() != 0 || PbFragment.this.dgX().djx()) {
                    PbFragment.this.loe = true;
                    return;
                }
                return;
            }
            PbFragment.this.ljR.FI(1);
            if (PbFragment.this.lnn != null) {
                PbFragment.this.lnn.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void diE() {
            if (PbFragment.this.ljR != null) {
                if (PbFragment.this.lod == null || !PbFragment.this.lod.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lod = (com.baidu.tbadk.editortools.pb.e) dVar.ei(PbFragment.this.getContext());
                    PbFragment.this.lod.a(PbFragment.this.lnl.getPageContext());
                    PbFragment.this.lod.a(PbFragment.this.fke);
                    PbFragment.this.lod.a(PbFragment.this.fjX);
                    PbFragment.this.lod.a(PbFragment.this.lnl.getPageContext(), PbFragment.this.lnl.getIntent() == null ? null : PbFragment.this.lnl.getIntent().getExtras());
                    PbFragment.this.lod.bwY().jS(true);
                    PbFragment.this.lnQ.setEditorTools(PbFragment.this.lod.bwY());
                    if (!PbFragment.this.ljR.djc()) {
                        PbFragment.this.lod.DA(PbFragment.this.ljR.diV());
                    }
                    if (PbFragment.this.ljR.djD()) {
                        PbFragment.this.lod.Dy(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lnQ != null) {
                        PbFragment.this.lod.Dy(PbFragment.this.lnQ.dkM());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lnQ.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.bzV().bzW()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.idU : j;
                if (PbFragment.this.fpw == 0) {
                    PbFragment.this.fpw = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.fpl, PbFragment.this.createTime, PbFragment.this.fpw, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fpl = 0L;
                if (iVar != null) {
                    iVar.bzS();
                }
                if (z2) {
                    iVar.fpF = currentTimeMillis;
                    iVar.ko(true);
                }
                if (!z2 && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dfI() != null) {
                    int threadType = PbFragment.this.ljR.getPbData().dfI().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.lnA, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.lnA, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.fpH = currentTimeMillis;
                                iVar2.rA(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fpH = currentTimeMillis;
                        dVar.rA(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener loX = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dhX();
            }
        }
    };
    private final a.InterfaceC0561a loY = new a.InterfaceC0561a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0561a
        public void d(boolean z, boolean z2, String str) {
            PbFragment.this.lnQ.dlh();
            if (z) {
                if (PbFragment.this.lnO != null) {
                    PbFragment.this.lnO.ih(z2);
                }
                PbFragment.this.ljR.uo(z2);
                if (PbFragment.this.ljR.bfV()) {
                    PbFragment.this.dig();
                } else {
                    PbFragment.this.lnQ.s(PbFragment.this.ljR.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lnO != null) {
                        if (PbFragment.this.lnO.bfY() != null && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.ljR.getPbData().dfI() != null && PbFragment.this.ljR.getPbData().dfI().bka() != null) {
                            MarkData bfY = PbFragment.this.lnO.bfY();
                            MetaData bka = PbFragment.this.ljR.getPbData().dfI().bka();
                            if (bfY != null && bka != null) {
                                if (!com.baidu.tbadk.core.util.at.equals(TbadkCoreApplication.getCurrentAccount(), bka.getUserId()) && !bka.hadConcerned()) {
                                    PbFragment.this.b(bka);
                                } else {
                                    PbFragment.this.showToast(R.string.add_mark_on_pb);
                                    if (com.baidu.tbadk.coreExtra.c.a.w(PbFragment.this.getContext(), 0)) {
                                        com.baidu.tbadk.coreExtra.c.a.a(PbFragment.this.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    PbFragment.this.did();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.Ft(PbFragment.this.mLastScrollState) && PbFragment.this.Ft(i)) {
                if (PbFragment.this.lnQ != null) {
                    PbFragment.this.lnQ.dly();
                    if (PbFragment.this.lod != null && !PbFragment.this.lnQ.dkL()) {
                        PbFragment.this.lnQ.uH(PbFragment.this.lod.bxM());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lnQ.dkK();
                    }
                }
                if (!PbFragment.this.lnt) {
                    PbFragment.this.lnt = true;
                    if (PbFragment.this.lnQ != null) {
                        PbFragment.this.lnQ.dlE();
                    }
                }
            }
            if (PbFragment.this.lnQ != null) {
                PbFragment.this.lnQ.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lnn != null) {
                PbFragment.this.lnn.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lnu == null) {
                PbFragment.this.lnu = new com.baidu.tbadk.n.b();
                PbFragment.this.lnu.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lnu.bzM();
            } else {
                PbFragment.this.lnu.bzL();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dGv().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dfK;
            if (PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null && PbFragment.this.lnQ != null && PbFragment.this.lnQ.dlb() != null) {
                PbFragment.this.lnQ.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lnn != null) {
                    PbFragment.this.lnn.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.ljR.djt() && (dfK = PbFragment.this.ljR.getPbData().dfK()) != null && !dfK.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lnQ.dlb().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.ljR.getPbData();
                    if (pbData != null) {
                        if (pbData.dfL() != null && pbData.dfL().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dfM() != null && pbData.dfM().hasData()) {
                            headerCount--;
                        }
                        int size = dfK.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d hTa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.hST.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.ljR.djq();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.lDo != 1002 || bVar.gKL) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lnQ.a(1, dVar.QP, dVar.mTG, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.hST.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lnQ.a(PbFragment.this.hST.getLoadDataMode(), gVar.QP, gVar.mTG, false);
                            PbFragment.this.lnQ.bc(gVar.mTJ);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lnQ.a(PbFragment.this.hST.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c loZ = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c fOJ = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dil()) {
                PbFragment.this.lnl.finish();
            }
            if (!PbFragment.this.ljR.un(true)) {
                PbFragment.this.lnQ.dli();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lpb = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lpa && PbFragment.this.dil()) {
                PbFragment.this.din();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lnL && PbFragment.this.lnQ != null && PbFragment.this.lnQ.dlW() && PbFragment.this.ljR != null) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13999");
                    aqVar.dR("tid", PbFragment.this.ljR.diV());
                    aqVar.dR("fid", PbFragment.this.ljR.getForumId());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    PbFragment.this.lnL = true;
                }
                if (PbFragment.this.ljR.um(false)) {
                    PbFragment.this.lnQ.dlg();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.ljR.getPbData() != null) {
                    PbFragment.this.lnQ.dlD();
                }
                PbFragment.this.lpa = true;
            }
        }
    };
    private int lpc = 0;
    private final TbRichTextView.i fAg = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dlb;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lnQ.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dR("tid", PbFragment.this.ljR.diV());
                aqVar.dR("fid", PbFragment.this.ljR.getForumId());
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.aj("obj_locate", 3);
                aqVar.aj("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.ljR.lkO.dgl()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bDk() != null) {
                            ArrayList<TbRichTextImageInfo> bDk = tbRichTextView.getRichText().bDk();
                            int i4 = 0;
                            while (i4 < bDk.size()) {
                                if (bDk.get(i4) != null) {
                                    arrayList.add(bDk.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bDk.get(i4).getSrc()) || str.equals(bDk.get(i4).bDF()) || str.equals(bDk.get(i4).bDC()) || str.equals(bDk.get(i4).bDE()) || str.equals(bDk.get(i4).bDI()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bDk.get(i4).getSrc();
                                    imageUrlData.originalUrl = bDk.get(i4).getSrc();
                                    imageUrlData.isLongPic = bDk.get(i4).bDK();
                                    concurrentHashMap.put(bDk.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).nF(i3).io(false).ip(PbFragment.this.ljR.djn()).a(concurrentHashMap).iq(true).ir(false).is(PbFragment.this.div()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.ljR != null) {
                            aVar.Av(PbFragment.this.ljR.getFromForumId());
                            if (PbFragment.this.ljR.getPbData() != null) {
                                aVar.s(PbFragment.this.ljR.getPbData().dfI());
                            }
                        }
                        ImageViewerConfig dU = aVar.dU(PbFragment.this.getPageContext().getPageActivity());
                        dU.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.lka) {
                        TbRichText bx = PbFragment.this.bx(str, i);
                        if (bx != null && PbFragment.this.lpc >= 0 && PbFragment.this.lpc < bx.bDj().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bx.bDj().get(PbFragment.this.lpc));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.ljZ.size()) {
                                    break;
                                } else if (!aVar2.ljZ.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bx.getPostId() != 0 && (dlb = PbFragment.this.lnQ.dlb()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = dlb.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bx.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bx.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.ljR.djC(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.ljR.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.erD.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).Aq(aVar2.forumName).Ar(aVar2.forumId).As(aVar2.threadId).io(aVar2.erB).iq(true).At(aVar2.lastId).ip(PbFragment.this.ljR.djn()).a(concurrentHashMap2).ir(false).is(PbFragment.this.div()).Au(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.ljR != null) {
                                aVar3.Av(PbFragment.this.ljR.getFromForumId());
                                if (PbFragment.this.ljR.getPbData() != null) {
                                    aVar3.s(PbFragment.this.ljR.getPbData().dfI());
                                }
                            }
                            ImageViewerConfig dU2 = aVar3.dU(PbFragment.this.getPageContext().getPageActivity());
                            dU2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.ljZ, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.erD.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).Aq(aVar2.forumName).Ar(aVar2.forumId).As(aVar2.threadId).io(aVar2.erB).iq(true).At(aVar2.ljZ.get(0)).ip(PbFragment.this.ljR.djn()).a(concurrentHashMap3).ir(false).is(PbFragment.this.div()).Au(aVar2.postId).it(false);
                    if (PbFragment.this.ljR != null) {
                        aVar4.Av(PbFragment.this.ljR.getFromForumId());
                        if (PbFragment.this.ljR.getPbData() != null) {
                            aVar4.s(PbFragment.this.ljR.getPbData().dfI());
                        }
                    }
                    ImageViewerConfig dU3 = aVar4.dU(PbFragment.this.getPageContext().getPageActivity());
                    dU3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.lnE = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lpd = false;
    PostData jER = null;
    private final b.InterfaceC0564b lpe = new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jER != null) {
                if (i == 0) {
                    PbFragment.this.jER.fT(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.jER = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.jER);
                }
            }
        }
    };
    private final b.InterfaceC0564b lpf = new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lop != null && !TextUtils.isEmpty(PbFragment.this.loq)) {
                if (i == 0) {
                    if (PbFragment.this.lor == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.loq));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.loq;
                        aVar.pkgId = PbFragment.this.lor.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lor.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.eqG == null) {
                            PbFragment.this.eqG = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.eqG.j(PbFragment.this.loq, PbFragment.this.lop.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lop = null;
                PbFragment.this.loq = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c7 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0214  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            SparseArray sparseArray;
            if (PbFragment.this.isAdded()) {
                if (PbFragment.this.lnQ != null) {
                    if (!PbFragment.this.lnQ.diN()) {
                        PbFragment.this.lnQ.dlV();
                    } else {
                        return true;
                    }
                }
                SparseArray sparseArray2 = null;
                try {
                    sparseArray2 = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray2 == null) {
                    if (PbFragment.this.df(view)) {
                        if (view instanceof TbImageView) {
                            PbFragment.this.lop = ((TbImageView) view).getBdImage();
                            PbFragment.this.loq = ((TbImageView) view).getUrl();
                            if (PbFragment.this.lop == null || TextUtils.isEmpty(PbFragment.this.loq)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.lor = null;
                            } else {
                                PbFragment.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else if (view instanceof GifView) {
                            if (((GifView) view).getBdImage() != null) {
                                PbFragment.this.lop = ((GifView) view).getBdImage();
                                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                    PbFragment.this.loq = ((GifView) view).getBdImage().getUrl();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    PbFragment.this.lor = null;
                                } else {
                                    PbFragment.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                }
                            } else {
                                return true;
                            }
                        } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                            PbFragment.this.lop = ((TbMemeImageView) view).getBdImage();
                            if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                                PbFragment.this.loq = ((TbMemeImageView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.lor = null;
                            } else {
                                PbFragment.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        }
                        if (view.getParent() instanceof TbRichTextView) {
                            try {
                                sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                            } catch (ClassCastException e2) {
                                e2.printStackTrace();
                                sparseArray = sparseArray2;
                            }
                        } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                            PbFragment.this.lnQ.a(PbFragment.this.lpf, PbFragment.this.lop.isGif());
                        } else {
                            try {
                                sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                            } catch (ClassCastException e3) {
                                e3.printStackTrace();
                                sparseArray = sparseArray2;
                            }
                        }
                        if (sparseArray != null) {
                            return true;
                        }
                        sparseArray2 = sparseArray;
                    }
                    sparseArray = sparseArray2;
                    if (sparseArray != null) {
                    }
                }
                PbFragment.this.jER = (PostData) sparseArray2.get(R.id.tag_clip_board);
                if (PbFragment.this.jER == null) {
                    return true;
                }
                if (PbFragment.this.jER.dHx() != 1 || !PbFragment.this.df(view)) {
                    if (PbFragment.this.lnO != null) {
                        if (!PbFragment.this.lnO.bfV() || PbFragment.this.jER.getId() == null || !PbFragment.this.jER.getId().equals(PbFragment.this.ljR.bki())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        boolean z3 = PbFragment.this.dgX().getPbData() != null && PbFragment.this.dgX().getPbData().dgl();
                        if (PbFragment.this.jER.dHx() != 1) {
                            if (PbFragment.this.lnV == null) {
                                PbFragment.this.lnV = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                PbFragment.this.lnV.a(PbFragment.this.loR);
                            }
                            ArrayList arrayList = new ArrayList();
                            if (view != null && sparseArray2 != null) {
                                boolean z4 = PbFragment.this.df(view) && !z3;
                                boolean z5 = (!PbFragment.this.df(view) || PbFragment.this.lop == null || PbFragment.this.lop.isGif()) ? false : true;
                                boolean z6 = false;
                                boolean z7 = false;
                                boolean z8 = false;
                                boolean z9 = false;
                                boolean z10 = false;
                                String str = null;
                                if (!(sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean)) {
                                    z2 = false;
                                } else {
                                    z2 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                                }
                                if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                    z6 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                                }
                                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                    z7 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                                }
                                if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                    z8 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                                }
                                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                    z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                                }
                                if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                    z10 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                                }
                                if (sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                    str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                                }
                                if (z4) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.lnV));
                                }
                                if (z5) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.lnV));
                                }
                                if (!z4 && !z5) {
                                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lnV);
                                    SparseArray sparseArray3 = new SparseArray();
                                    sparseArray3.put(R.id.tag_clip_board, PbFragment.this.jER);
                                    gVar3.mTextView.setTag(sparseArray3);
                                    arrayList.add(gVar3);
                                }
                                if (!z2 && !z3) {
                                    if (z) {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lnV);
                                    } else {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lnV);
                                    }
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(R.id.tag_clip_board, PbFragment.this.jER);
                                    sparseArray4.put(R.id.tag_is_subpb, false);
                                    gVar2.mTextView.setTag(sparseArray4);
                                    arrayList.add(gVar2);
                                }
                                if (PbFragment.this.mIsLogin && !PbFragment.this.llm) {
                                    if (!z8 && z7) {
                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lnV);
                                        SparseArray sparseArray5 = new SparseArray();
                                        sparseArray5.put(R.id.tag_user_mute_visible, true);
                                        sparseArray5.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                                        sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                                        sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                                        sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                                        sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                                        sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                                        sparseArray5.put(R.id.tag_del_post_is_self, sparseArray2.get(R.id.tag_del_post_is_self));
                                        sparseArray5.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                        sparseArray5.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                        sparseArray5.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                        gVar4.mTextView.setTag(sparseArray5);
                                        arrayList.add(gVar4);
                                    } else {
                                        if ((PbFragment.this.ua(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lnV);
                                            gVar5.mTextView.setTag(str);
                                            arrayList.add(gVar5);
                                        }
                                    }
                                    com.baidu.tbadk.core.dialog.g gVar6 = null;
                                    if (z8) {
                                        SparseArray sparseArray6 = new SparseArray();
                                        sparseArray6.put(R.id.tag_should_manage_visible, true);
                                        sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                        sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                                        sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                                        sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                                        sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                                        if (z9) {
                                            sparseArray6.put(R.id.tag_user_mute_visible, true);
                                            sparseArray6.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                                            sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                                            sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                                            sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                                            sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                                            sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                                        } else {
                                            sparseArray6.put(R.id.tag_user_mute_visible, false);
                                        }
                                        if (z10) {
                                            sparseArray6.put(R.id.tag_should_delete_visible, true);
                                            sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                            sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                            sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lnV);
                                            gVar6.mTextView.setTag(sparseArray6);
                                        } else {
                                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                                        }
                                        gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lnV);
                                        gVar.mTextView.setTag(sparseArray6);
                                    } else {
                                        if (z10) {
                                            SparseArray sparseArray7 = new SparseArray();
                                            sparseArray7.put(R.id.tag_should_manage_visible, false);
                                            sparseArray7.put(R.id.tag_user_mute_visible, false);
                                            sparseArray7.put(R.id.tag_should_delete_visible, true);
                                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                            sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                            sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                            if (PbFragment.this.ljR.getPbData().dfX() == 1002 && !z6) {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lnV);
                                            } else {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lnV);
                                            }
                                            gVar6.mTextView.setTag(sparseArray7);
                                        }
                                        gVar = null;
                                    }
                                    if (gVar6 != null) {
                                        arrayList.add(gVar6);
                                    }
                                    if (gVar != null) {
                                        arrayList.add(gVar);
                                    }
                                }
                                PbFragment.this.lnV.bk(arrayList);
                                PbFragment.this.lnU = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lnV);
                                PbFragment.this.lnU.PJ();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dR("tid", PbFragment.this.ljR.lrg).dR("fid", PbFragment.this.ljR.getForumId()).dR("uid", PbFragment.this.ljR.getPbData().dfI().bka().getUserId()).dR("post_id", PbFragment.this.ljR.bxA()).aj("obj_source", z2 ? 2 : 1));
                            }
                            return true;
                        }
                        if (!z3) {
                            PbFragment.this.lnQ.a(PbFragment.this.lpe, z, false);
                        }
                        return true;
                    }
                    return true;
                }
                PbFragment.this.lnQ.a(PbFragment.this.lpf, PbFragment.this.lop.isGif());
                return true;
            }
            return true;
        }
    };
    private final NoNetworkView.a iyC = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.byS && z && !PbFragment.this.ljR.djd()) {
                PbFragment.this.dii();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener ftj = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.iGn.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0705a iac = new a.InterfaceC0705a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int gKr = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void H(int i, int i2) {
            if (at(i2) && PbFragment.this.lnQ != null && PbFragment.this.lnn != null) {
                PbFragment.this.lnn.pE(true);
                if (Math.abs(i2) > this.gKr) {
                    PbFragment.this.lnn.hideFloatingView();
                }
                if (PbFragment.this.dil()) {
                    PbFragment.this.lnQ.dkY();
                    PbFragment.this.lnQ.dkZ();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void I(int i, int i2) {
            if (at(i2) && PbFragment.this.lnQ != null && PbFragment.this.lnn != null) {
                PbFragment.this.lnQ.dlJ();
                PbFragment.this.lnn.pE(false);
                PbFragment.this.lnn.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void ce(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void J(int i, int i2) {
        }

        private boolean at(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final q.a lmo = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lnQ.Py(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lph = -1;
    private int lpi = -1;

    /* loaded from: classes22.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes22.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes22.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e dhI() {
        return this.lod;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.dgy() != null) {
            String id = pVar.dgy().getId();
            ArrayList<PostData> dfK = this.ljR.getPbData().dfK();
            int i = 0;
            while (true) {
                if (i >= dfK.size()) {
                    z = true;
                    break;
                }
                PostData postData = dfK.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dgG = pVar.dgG();
                    postData.Jp(pVar.getTotalCount());
                    if (postData.dHu() == null || dgG == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dgG.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bka() != null && (metaData = postData.getUserMap().get(next.bka().getUserId())) != null) {
                                next.a(metaData);
                                next.xl(true);
                                next.a(getPageContext(), this.ljR.Pp(metaData.getUserId()));
                            }
                        }
                        z = dgG.size() != postData.dHu().size();
                        if (postData.dHu() != null && postData.dHu().size() < 2) {
                            postData.dHu().clear();
                            postData.dHu().addAll(dgG);
                        }
                    }
                    if (postData.dHq() != null) {
                        postData.dHr();
                    }
                }
            }
            if (!this.ljR.getIsFromMark() && z) {
                this.lnQ.s(this.ljR.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n dga = this.ljR.getPbData().dga();
            if (dga != null && str.equals(dga.getAdId())) {
                if (dga.dHl() != null) {
                    dga.dHl().legoCard = null;
                }
                this.ljR.getPbData().dgb();
            }
            com.baidu.tieba.tbadkCore.data.n djj = this.ljR.djj();
            if (djj != null && str.equals(djj.getAdId())) {
                this.ljR.djk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lnU != null && this.lnU.isShowing()) {
                this.lnU.dismiss();
                this.lnU = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lnU != null) {
                            PbFragment.this.lnU.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lnQ.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lom);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lom);
                            PbFragment.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int i = -1;
                if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(0, getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getResources().getString(R.string.mute), kVar));
                }
                kVar.bk(arrayList);
                this.lnU = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lnU.PJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zG(int i) {
        bw dfI;
        if (this.ljR != null && this.ljR.getPbData() != null && (dfI = this.ljR.getPbData().dfI()) != null) {
            if (i == 1) {
                PraiseData bjL = dfI.bjL();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bjL == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dfI.a(praiseData);
                    } else {
                        dfI.bjL().getUser().add(0, metaData);
                        dfI.bjL().setNum(dfI.bjL().getNum() + 1);
                        dfI.bjL().setIsLike(i);
                    }
                }
                if (dfI.bjL() != null) {
                    if (dfI.bjL().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(dfI.bjL().getNum());
                    }
                }
            } else if (dfI.bjL() != null) {
                dfI.bjL().setIsLike(i);
                dfI.bjL().setNum(dfI.bjL().getNum() - 1);
                ArrayList<MetaData> user = dfI.bjL().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dfI.bjL().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dfI.bjL().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dfI.bjL().getNum() + "";
                }
            }
            if (this.ljR.diX()) {
                this.lnQ.dlb().notifyDataSetChanged();
            } else {
                this.lnQ.t(this.ljR.getPbData());
            }
        }
    }

    public static PbFragment dhJ() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lnl = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ljR.aC(bundle);
        if (this.iBr != null) {
            this.iBr.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lod.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lns = System.currentTimeMillis();
        this.lok = getPageContext();
        final Intent intent = this.lnl.getIntent();
        if (intent != null) {
            this.idU = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lnA = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lnA)) {
                    this.lnA = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lnA)) {
                this.lno = true;
            }
            this.lph = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lpi = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lpj = intent.getStringExtra("key_manga_title");
            this.lnX = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lnY = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lnZ = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dil()) {
                this.lnl.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.lot = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lnJ = new bf();
            this.lnJ.C(intent);
            this.lov = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lov == 0) {
                this.lov = intent.getIntExtra("key_start_from", 0);
            }
            this.lox = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.idU = System.currentTimeMillis();
        }
        this.fpl = this.lns - this.idU;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lnq = 0;
        aB(bundle);
        if (this.ljR.getPbData() != null) {
            this.ljR.getPbData().Pb(this.source);
        }
        dhM();
        if (intent != null && this.lnQ != null) {
            this.lnQ.luY = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.loo == null) {
                    this.loo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lnQ.PA(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.loo, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.ljR.getPbData() != null) {
                this.ljR.Ps(stringExtra);
            }
        }
        this.iBr = new VoiceManager();
        this.iBr.onCreate(getPageContext());
        initData(bundle);
        this.lob = new com.baidu.tbadk.editortools.pb.g();
        d(this.lob);
        this.lod = (com.baidu.tbadk.editortools.pb.e) this.lob.ei(getActivity());
        this.lod.a(this.lnl.getPageContext());
        this.lod.a(this.fke);
        this.lod.a(this.fjX);
        this.lod.setFrom(1);
        this.lod.a(this.lnl.getPageContext(), bundle);
        this.lod.bwY().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lod.bwY().jS(true);
        tY(true);
        this.lod.a(this.ljR.djl(), this.ljR.diV(), this.ljR.djC());
        registerListener(this.loC);
        if (!this.ljR.djc()) {
            this.lod.DA(this.ljR.diV());
        }
        if (this.ljR.djD()) {
            this.lod.Dy(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lnQ != null) {
            this.lod.Dy(this.lnQ.dkM());
        }
        registerListener(this.loB);
        registerListener(this.loD);
        registerListener(this.loE);
        registerListener(this.iCX);
        registerListener(this.loQ);
        registerListener(this.loA);
        this.loa = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.mQn);
        this.loa.dHd();
        registerListener(this.loF);
        registerListener(this.eHG);
        this.ljR.djv();
        registerListener(this.loX);
        registerListener(this.iDf);
        registerListener(this.loT);
        if (this.lnQ != null && this.lnQ.dlN() != null && this.lnQ.dlO() != null) {
            this.lnn = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lnQ.dlN(), this.lnQ.dlO(), this.lnQ.dkS());
            this.lnn.a(this.loL);
        }
        if (this.lnm && this.lnQ != null && this.lnQ.dlO() != null) {
            this.lnQ.dlO().setVisibility(8);
        }
        this.lol = new com.baidu.tbadk.core.view.c();
        this.lol.toastTime = 1000L;
        registerListener(this.loP);
        registerListener(this.loN);
        registerListener(this.loO);
        registerListener(this.iVT);
        registerListener(this.iCT);
        this.loG.setSelfListener(true);
        this.loG.setTag(this.lnl.getUniqueId());
        this.loG.setPriority(-1);
        MessageManager.getInstance().registerListener(this.loG);
        registerResponsedEventListener(TipEvent.class, this.iAv);
        this.lom = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lom;
        userMuteAddAndDelCustomMessage.setTag(this.lom);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lom;
        userMuteCheckCustomMessage.setTag(this.lom);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.ljR.djA().a(this.loM);
        this.ktH = new bb();
        if (this.lod.bxE() != null) {
            this.ktH.e(this.lod.bxE().getInputView());
        }
        this.lod.a(this.fjY);
        this.iUz = new ShareSuccessReplyToServerModel();
        a(this.loy);
        this.kpC = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kpC.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.eHx) {
                        PbFragment.this.lod.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.eHy && PbFragment.this.lnQ != null && PbFragment.this.lnQ.dkI() != null && PbFragment.this.lnQ.dkI().dhH() != null) {
                        PbFragment.this.lnQ.dkI().dhH().byc();
                    } else if (i == com.baidu.tbadk.core.util.am.eHz) {
                        PbFragment.this.c(PbFragment.this.loh);
                    }
                }
            }
        });
        this.lnN = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lnN.w(getUniqueId());
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
        com.baidu.tbadk.core.business.a.bht().dF("3", "");
        this.hSV = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lns;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.ljR != null) {
            gVar.setForumName(this.ljR.dgP());
            if (this.ljR.getPbData() != null && this.ljR.getPbData().getForum() != null) {
                gVar.a(this.ljR.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.ljR);
        }
    }

    public String dhK() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b dhL() {
        return this.lnn;
    }

    private void tY(boolean z) {
        this.lod.jZ(z);
        this.lod.ka(z);
        this.lod.kb(z);
    }

    private void dhM() {
        this.eTL = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iBr != null) {
            this.iBr.onStart(getPageContext());
        }
    }

    public az dhN() {
        return this.lnQ;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dgX() {
        return this.ljR;
    }

    public void Pi(String str) {
        if (this.ljR != null && !StringUtils.isNull(str) && this.lnQ != null) {
            this.lnQ.uM(true);
            this.ljR.Pi(str);
            this.lny = true;
            this.lnQ.dly();
            this.lnQ.dlI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.byS = false;
        } else {
            this.byS = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.lnq = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lnq == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.iBr != null) {
            this.iBr.onPause(getPageContext());
        }
        if (this.lnQ != null) {
            this.lnQ.onPause();
        }
        if (!this.ljR.djc()) {
            this.lod.Dz(this.ljR.diV());
        }
        if (this.ljR != null) {
            this.ljR.djw();
        }
        com.baidu.tbadk.BdToken.c.bdF().bdQ();
        MessageManager.getInstance().unRegisterListener(this.jQR);
        cKa();
        MessageManager.getInstance().unRegisterListener(this.loN);
        MessageManager.getInstance().unRegisterListener(this.loO);
        MessageManager.getInstance().unRegisterListener(this.loP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean dhO() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.ljR.getPbData(), this.ljR.diX(), this.ljR.dju());
        return (a2 == null || a2.bka() == null || a2.bka().getGodUserData() == null || a2.bka().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.byS = false;
        super.onResume();
        if (this.lnC) {
            this.lnC = false;
            dir();
        }
        if (dhO()) {
            this.lnv = System.currentTimeMillis();
        } else {
            this.lnv = -1L;
        }
        if (this.lnQ != null && this.lnQ.getView() != null) {
            if (!this.kJt) {
                dij();
            } else {
                hideLoadingView(this.lnQ.getView());
            }
            this.lnQ.onResume();
        }
        if (this.lnq == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lnQ != null) {
            noNetworkView = this.lnQ.dkF();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.iBr != null) {
            this.iBr.onResume(getPageContext());
        }
        registerListener(this.jQR);
        this.lnW = false;
        diq();
        registerListener(this.loN);
        registerListener(this.loO);
        registerListener(this.loP);
        if (this.iCg) {
            dii();
            this.iCg = false;
        }
        diy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lnQ.uB(z);
        if (this.lnU != null) {
            this.lnU.dismiss();
        }
        if (z && this.lnW) {
            this.lnQ.dlg();
            this.ljR.um(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lnv > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dR("obj_duration", (System.currentTimeMillis() - this.lnv) + ""));
            this.lnv = 0L;
        }
        if (dhN().dkI() != null) {
            dhN().dkI().onStop();
        }
        if (this.lnQ.lva != null && !this.lnQ.lva.dmH()) {
            this.lnQ.lva.releaseResources();
        }
        if (this.ljR != null && this.ljR.getPbData() != null && this.ljR.getPbData().getForum() != null && this.ljR.getPbData().dfI() != null) {
            com.baidu.tbadk.distribute.a.bwL().b(getPageContext().getPageActivity(), "pb", this.ljR.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.ljR.getPbData().dfI().getId(), 0L));
        }
        if (this.iBr != null) {
            this.iBr.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lnK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("fid", this.ljR.getPbData().getForumId());
            aqVar.dR("tid", this.ljR.diV());
            aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lnt && this.lnQ != null) {
            this.lnt = true;
            this.lnQ.dlE();
            a(false, (PostData) null);
        }
        if (this.ljR != null) {
            this.ljR.cancelLoadData();
            this.ljR.destory();
            if (this.ljR.djz() != null) {
                this.ljR.djz().onDestroy();
            }
        }
        if (this.lod != null) {
            this.lod.onDestroy();
        }
        if (this.hST != null) {
            this.hST.cancelLoadData();
        }
        if (this.eTL != null) {
            this.eTL.dGQ();
        }
        if (this.lnQ != null) {
            this.lnQ.onDestroy();
            if (this.lnQ.lva != null) {
                this.lnQ.lva.releaseResources();
            }
        }
        if (this.lnu != null) {
            this.lnu.bzN();
        }
        if (this.lnn != null) {
            this.lnn.cyb();
        }
        super.onDestroy();
        if (this.iBr != null) {
            this.iBr.onDestory(getPageContext());
        }
        if (this.lnQ != null) {
            this.lnQ.dly();
        }
        MessageManager.getInstance().unRegisterListener(this.loN);
        MessageManager.getInstance().unRegisterListener(this.loO);
        MessageManager.getInstance().unRegisterListener(this.loP);
        MessageManager.getInstance().unRegisterListener(this.lom);
        MessageManager.getInstance().unRegisterListener(this.loQ);
        MessageManager.getInstance().unRegisterListener(this.iDf);
        MessageManager.getInstance().unRegisterListener(this.iVT);
        MessageManager.getInstance().unRegisterListener(this.loV);
        MessageManager.getInstance().unRegisterListener(this.loG);
        this.lok = null;
        this.lol = null;
        com.baidu.tieba.recapp.d.a.dyA().dyD();
        if (this.loo != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.loo);
        }
        if (this.lnD != null) {
            this.lnD.cancelLoadData();
        }
        if (this.lnQ != null && this.lnQ.lva != null) {
            this.lnQ.lva.dmK();
        }
        if (this.iUz != null) {
            this.iUz.cancelLoadData();
        }
        this.ktH.onDestroy();
        if (this.ljR != null && this.ljR.djB() != null) {
            this.ljR.djB().onDestroy();
        }
        if (this.kpC != null) {
            this.kpC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dlb;
        ArrayList<PostData> dht;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.brP() && this.lnQ != null && (dlb = this.lnQ.dlb()) != null && (dht = dlb.dht()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = dht.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                String id = next.getId();
                i++;
                if (z) {
                    if (next == postData) {
                        a.b bVar = new a.b();
                        bVar.mPid = id;
                        bVar.hUW = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ezs == 1 && !TextUtils.isEmpty(id)) {
                    next.ezs = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.hUW = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.ljR == null || this.ljR.getPbData() == null || this.ljR.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.ljR.getPbData().getForum().getFirst_class();
                    str2 = this.ljR.getPbData().getForum().getSecond_class();
                    str = this.ljR.getPbData().getForum().getId();
                    str4 = this.ljR.diV();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.brS());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lnQ.onChangeSkinType(i);
            if (this.lod != null && this.lod.bwY() != null) {
                this.lod.bwY().onChangeSkinType(i);
            }
            if (this.lnQ.dkF() != null) {
                this.lnQ.dkF().onChangeSkinType(getPageContext(), i);
            }
            this.ktH.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
            cwj();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lnQ = new az(this, this.iEe, this.fbT);
        this.iGn = new com.baidu.tieba.f.b(getActivity());
        this.iGn.a(lpg);
        this.iGn.a(this.iac);
        this.lnQ.setOnScrollListener(this.mOnScrollListener);
        this.lnQ.d(this.lpb);
        this.lnQ.setListPullRefreshListener(this.fOJ);
        this.lnQ.tK(com.baidu.tbadk.core.k.bhh().isShowImages());
        this.lnQ.setOnImageClickListener(this.fAg);
        this.lnQ.b(this.mOnLongClickListener);
        this.lnQ.g(this.iyC);
        this.lnQ.a(this.loZ);
        this.lnQ.uB(this.mIsLogin);
        if (this.lnl.getIntent() != null) {
            this.lnQ.uN(this.lnl.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lnQ.dkH().setFromForumId(this.ljR.getFromForumId());
        this.lnQ.setEditorTools(this.lod.bwY());
        this.lod.Dy(this.lnQ.dkM());
        this.lnQ.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.ljR.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                String str3 = "";
                if (objArr.length > 3) {
                    str3 = String.valueOf(objArr[3]);
                }
                String str4 = "";
                if (objArr.length > 4) {
                    str4 = String.valueOf(objArr[4]);
                }
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.ljR.getPbData().getForum().getId(), PbFragment.this.ljR.getPbData().getForum().getName(), PbFragment.this.ljR.getPbData().dfI().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lnQ.uO(this.ljR.dja());
        this.lnQ.FP(this.ljR.djF());
        return this.lnQ.getView();
    }

    public void dhP() {
        if (this.lnQ != null && this.ljR != null) {
            if ((this.ljR.getPbData() != null || this.ljR.getPbData().dgh() != null) && checkUpIsLogin() && this.lnQ.dlb() != null && this.lnQ.dlb().dhy() != null) {
                this.lnQ.dlb().dhy().Cg(this.ljR.diV());
            }
        }
    }

    public void dhQ() {
        TiebaStatic.log("c12181");
        if (this.lnQ != null && this.ljR != null) {
            if ((this.lnQ == null || this.lnQ.dkL()) && this.ljR.getPbData() != null && this.ljR.getPbData().dgh() != null) {
                com.baidu.tieba.pb.data.o dgh = this.ljR.getPbData().dgh();
                if (checkUpIsLogin()) {
                    if ((!dgh.dgA() || dgh.blB() != 2) && this.lnQ.dlb() != null && this.lnQ.dlb().dhy() != null) {
                        this.lnQ.dlb().dhy().Cg(this.ljR.diV());
                    }
                    if (System.currentTimeMillis() - this.lnx > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).vw(false);
                        this.lnx = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dd(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.eya && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bhh().isShowImages()) {
                    return Pl(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.ljR == null || this.ljR.getPbData() == null) {
                        return true;
                    }
                    if (dhN().dkI() != null) {
                        dhN().dkI().dhD();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.ljR.getPbData().getForum());
                    pVar.setThreadData(this.ljR.getPbData().dfI());
                    pVar.g(postData);
                    dhN().dkH().d(pVar);
                    dhN().dkH().setPostId(postData.getId());
                    a(view, postData.bka().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lod != null) {
                        this.lnQ.uH(this.lod.bxM());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dhR() {
        if (this.lnr == null) {
            this.lnr = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lnr.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.ljN = PbFragment.this.ljN.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.ljN);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.ljR.diV(), PbFragment.this.ljN, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.ljN = PbFragment.this.ljN.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.ljN);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.ljR.diV(), PbFragment.this.ljN, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.ljN = PbFragment.this.ljN.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.ljN);
                        bVar.dismiss();
                    }
                }
            }).os(b.a.BOTTOM_TO_TOP).ot(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.loW.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).doL(), "", 1);
    }

    private void aB(Bundle bundle) {
        this.ljR = this.lnl.dgX();
        if (this.ljR.djy() != null) {
            this.ljR.djy().a(this.lmo);
        }
        if (this.ljR.djz() != null) {
            this.ljR.djz().b(this.loz);
        }
        if (StringUtils.isNull(this.ljR.diV())) {
            this.lnl.finish();
        } else if ("from_tieba_kuang".equals(this.lnA) && this.lnA != null) {
            this.ljR.FP(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lnO = com.baidu.tbadk.baseEditMark.a.a(this.lnl);
        if (this.lnO != null) {
            this.lnO.a(this.loY);
        }
        this.hST = new ForumManageModel(this.lnl);
        this.hST.setLoadDataCallBack(this.hTa);
        this.eHC = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.loK.setUniqueId(getUniqueId());
        this.loK.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lnQ.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lom;
        userMuteCheckCustomMessage.setTag(this.lom);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean dhS() {
        if (this.ljR == null || this.ljR.getPbData() == null) {
            return false;
        }
        bw dfI = this.ljR.getPbData().dfI();
        this.ljR.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dfI);
    }

    public void dhT() {
        if (checkUpIsLogin() && this.ljR != null && this.ljR.getPbData() != null && this.ljR.getPbData().getForum() != null && !dhS()) {
            if (this.ljR.getPbData().dgl()) {
                this.lnQ.cJB();
                return;
            }
            if (this.iFN == null) {
                this.iFN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iFN.zP(0);
                this.iFN.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pz(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pA(boolean z) {
                        if (z) {
                            if (PbFragment.this.lod != null && PbFragment.this.lod.bwY() != null) {
                                PbFragment.this.lod.bwY().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lnQ.cJB();
                        }
                    }
                });
            }
            this.iFN.G(this.ljR.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.ljR.diV(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dhU() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.ljR == null || (pbData = this.ljR.getPbData()) == null) {
            return null;
        }
        return pbData.dfW().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dfI() != null) {
            if (fVar.dfI().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dfI().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dfI().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dhS() && dhV()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lnF);
                this.lnG = ((View) view.getParent()).getMeasuredHeight();
            }
            if (dhN().dkI() != null && postData != null) {
                String str3 = "";
                if (postData.dHz() != null) {
                    str3 = postData.dHz().toString();
                }
                dhN().dkI().Pg(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bka().getName_show(), str3));
            }
            if (this.ljR.getPbData() != null && this.ljR.getPbData().dgl()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lnl.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.dhN().getListView().smoothScrollBy((PbFragment.this.lnF[1] + PbFragment.this.lnG) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dhN().dkI() != null) {
                            PbFragment.this.lod.bwY().setVisibility(8);
                            PbFragment.this.dhN().dkI().h(str, str2, PbFragment.this.dhN().dkM(), (PbFragment.this.ljR == null || PbFragment.this.ljR.getPbData() == null || PbFragment.this.ljR.getPbData().dfI() == null || !PbFragment.this.ljR.getPbData().dfI().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dhH = PbFragment.this.dhN().dkI().dhH();
                            if (dhH != null && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                dhH.a(PbFragment.this.ljR.getPbData().getAnti());
                                dhH.setThreadData(PbFragment.this.ljR.getPbData().dfI());
                            }
                            if (PbFragment.this.ktH.dmb() == null && PbFragment.this.dhN().dkI().dhH().byk() != null) {
                                PbFragment.this.dhN().dkI().dhH().byk().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.ktH != null && PbFragment.this.ktH.dma() != null) {
                                            if (!PbFragment.this.ktH.dma().dQu()) {
                                                PbFragment.this.ktH.uQ(false);
                                            }
                                            PbFragment.this.ktH.dma().yh(false);
                                        }
                                    }
                                });
                                PbFragment.this.ktH.f(PbFragment.this.dhN().dkI().dhH().byk().getInputView());
                                PbFragment.this.dhN().dkI().dhH().a(PbFragment.this.loj);
                            }
                        }
                        PbFragment.this.dhN().dlI();
                    }
                }, 0L);
                return;
            }
            if (this.lof == null) {
                this.lof = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lof.zP(1);
                this.lof.a(new AnonymousClass39(str, str2));
            }
            if (this.ljR != null && this.ljR.getPbData() != null && this.ljR.getPbData().getForum() != null) {
                this.lof.G(this.ljR.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.ljR.diV(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lpq;
        final /* synthetic */ String lpr;

        AnonymousClass39(String str, String str2) {
            this.lpq = str;
            this.lpr = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pz(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pA(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        }
                        PbFragment.this.dhN().getListView().smoothScrollBy((PbFragment.this.lnF[1] + PbFragment.this.lnG) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dhN().dkI() != null) {
                            PbFragment.this.lod.bwY().setVisibility(8);
                            PbFragment.this.dhN().dkI().h(AnonymousClass39.this.lpq, AnonymousClass39.this.lpr, PbFragment.this.dhN().dkM(), (PbFragment.this.ljR == null || PbFragment.this.ljR.getPbData() == null || PbFragment.this.ljR.getPbData().dfI() == null || !PbFragment.this.ljR.getPbData().dfI().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dhH = PbFragment.this.dhN().dkI().dhH();
                            if (dhH != null && PbFragment.this.ljR != null && PbFragment.this.ljR.getPbData() != null) {
                                dhH.a(PbFragment.this.ljR.getPbData().getAnti());
                                dhH.setThreadData(PbFragment.this.ljR.getPbData().dfI());
                            }
                            if (PbFragment.this.ktH.dmb() == null && PbFragment.this.dhN().dkI().dhH().byk() != null) {
                                PbFragment.this.dhN().dkI().dhH().byk().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.ktH != null && PbFragment.this.ktH.dma() != null) {
                                            if (!PbFragment.this.ktH.dma().dQu()) {
                                                PbFragment.this.ktH.uQ(false);
                                            }
                                            PbFragment.this.ktH.dma().yh(false);
                                        }
                                    }
                                });
                                PbFragment.this.ktH.f(PbFragment.this.dhN().dkI().dhH().byk().getInputView());
                                PbFragment.this.dhN().dkI().dhH().a(PbFragment.this.loj);
                            }
                        }
                        PbFragment.this.dhN().dlI();
                    }
                }, 0L);
            }
        }
    }

    public boolean dhV() {
        if ((this.ljR.getPbData() != null && this.ljR.getPbData().dgl()) || this.kpC == null || this.ljR.getPbData() == null || this.ljR.getPbData().getAnti() == null) {
            return true;
        }
        return this.kpC.oJ(this.ljR.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean FC(int i) {
        if (this.kpC == null || this.ljR.getPbData() == null || this.ljR.getPbData().getAnti() == null) {
            return true;
        }
        return this.kpC.aN(this.ljR.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.ljR != null && this.ljR.getPbData() != null && postData.dHx() != 1) {
            String diV = this.ljR.diV();
            String id = postData.getId();
            int i = 0;
            if (this.ljR.getPbData() != null) {
                i = this.ljR.getPbData().dfX();
            }
            PbActivity.a Pm = Pm(id);
            if (Pm != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(diV, id, "pb", true, null, false, null, i, postData.dnF(), this.ljR.getPbData().getAnti(), false, postData.bka() != null ? postData.bka().getIconInfo() : null).addBigImageData(Pm.ljZ, Pm.erD, Pm.erB, Pm.index);
                addBigImageData.setKeyPageStartFrom(this.ljR.djF());
                addBigImageData.setFromFrsForumId(this.ljR.getFromForumId());
                addBigImageData.setKeyFromForumId(this.ljR.getForumId());
                addBigImageData.setBjhData(this.ljR.dje());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dhW() {
        if (this.ljR.getPbData() == null || this.ljR.getPbData().dfI() == null) {
            return -1;
        }
        return this.ljR.getPbData().dfI().bkN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dgX() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dgX().Pr(postWriteCallBackData.getPostId());
            this.los = this.lnQ.dkO();
            this.ljR.cZ(this.los, this.lnQ.dkP());
        }
        this.lnQ.dly();
        this.ktH.dlY();
        if (this.lod != null) {
            this.lnQ.uH(this.lod.bxM());
        }
        this.lnQ.dkG();
        this.lnQ.uJ(true);
        this.ljR.djq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(boolean z) {
        if (this.ljR != null && this.ljR.lkO != null && this.ljR.lkO.dfI() != null) {
            bw dfI = this.ljR.lkO.dfI();
            dfI.mRecomAbTag = this.ljR.djQ();
            dfI.mRecomWeight = this.ljR.djO();
            dfI.mRecomSource = this.ljR.djP();
            dfI.mRecomExtra = this.ljR.djR();
            if (dfI.getFid() == 0) {
                dfI.setFid(com.baidu.adp.lib.f.b.toLong(this.ljR.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dfI, "c13563");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (eu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (eu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.aj("reply_type", 1);
                if (z) {
                    a2.aj("obj_type", 2);
                } else {
                    a2.aj("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhX() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.RK(this.ljR.getForumId()) && this.ljR.getPbData() != null && this.ljR.getPbData().getForum() != null) {
            if (this.ljR.getPbData().getForum().isLike() == 1) {
                this.ljR.djB().gi(this.ljR.getForumId(), this.ljR.diV());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ua(boolean z) {
        if (this.ljR == null || this.ljR.getPbData() == null) {
            return false;
        }
        return ((this.ljR.getPbData().dfX() != 0) || this.ljR.getPbData().dfI() == null || this.ljR.getPbData().dfI().bka() == null || TextUtils.equals(this.ljR.getPbData().dfI().bka().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean ub(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ab abVar;
        if (this.ljR == null || this.ljR.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.ljR.getPbData();
        bw dfI = pbData.dfI();
        if (dfI != null) {
            if (dfI.biI() || dfI.biJ()) {
                return false;
            }
            if (dfI.blV() || dfI.blW()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.dfX() != 0) {
                return pbData.dfX() != 3;
            }
            List<bs> dgf = pbData.dgf();
            if (com.baidu.tbadk.core.util.y.getCount(dgf) > 0) {
                for (bs bsVar : dgf) {
                    if (bsVar != null && (abVar = bsVar.exk) != null && abVar.euW && !abVar.euX && (abVar.type == 1 || abVar.type == 2)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            return z2;
        }
        return false;
    }

    private boolean uc(boolean z) {
        if (z || this.ljR == null || this.ljR.getPbData() == null) {
            return false;
        }
        return ((this.ljR.getPbData().getForum() != null && this.ljR.getPbData().getForum().isBlockBawuDelete) || this.ljR.getPbData().dfX() == 0 || this.ljR.getPbData().dfX() == 3) ? false : true;
    }

    public void dhY() {
        com.baidu.tieba.pb.data.f pbData;
        bw dfI;
        boolean z = true;
        if (this.ljR != null && this.ljR.getPbData() != null && (dfI = (pbData = this.ljR.getPbData()).dfI()) != null && dfI.bka() != null) {
            this.lnQ.dkG();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dfI.bka().getUserId());
            ak akVar = new ak();
            int dfX = this.ljR.getPbData().dfX();
            if (dfX == 1 || dfX == 3) {
                akVar.ltn = true;
                akVar.ltm = true;
                akVar.ltt = dfI.bjV() == 1;
                akVar.lts = dfI.bjW() == 1;
            } else {
                akVar.ltn = false;
                akVar.ltm = false;
            }
            if (dfX == 1002 && !equals) {
                akVar.ltu = true;
            }
            akVar.ltk = ub(equals);
            akVar.lto = dhZ();
            akVar.ltl = uc(equals);
            akVar.Fc = this.ljR.diX();
            akVar.lth = true;
            akVar.ltg = ua(equals);
            akVar.ltf = equals && this.lnQ.dln();
            akVar.ltq = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.ltp = true;
            akVar.isHostOnly = this.ljR.getHostMode();
            akVar.ltj = true;
            if (dfI.bks() == null) {
                akVar.lti = true;
            } else {
                akVar.lti = false;
            }
            if (pbData.dgl()) {
                akVar.lth = false;
                akVar.ltj = false;
                akVar.lti = false;
                akVar.ltm = false;
                akVar.ltn = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dgl()) {
                z = false;
            }
            akVar.ltv = z;
            this.lnQ.lva.a(akVar);
        }
    }

    private boolean dhZ() {
        if (this.ljR != null && this.ljR.diX()) {
            return this.ljR.getPageData() == null || this.ljR.getPageData().biR() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            n(postData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dia() {
        return this.loW;
    }

    public int dib() {
        if (dhN() == null || dhN().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dhN().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).Vw == com.baidu.tieba.pb.data.n.lin) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dic() {
        if (dhN() == null || dhN().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dhN().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.mQN) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void did() {
        if (this.ljR != null && this.ljR.lkO != null && this.ljR.lkO.dfI() != null) {
            bw dfI = this.ljR.lkO.dfI();
            dfI.mRecomAbTag = this.ljR.djQ();
            dfI.mRecomWeight = this.ljR.djO();
            dfI.mRecomSource = this.ljR.djP();
            dfI.mRecomExtra = this.ljR.djR();
            if (dfI.getFid() == 0) {
                dfI.setFid(com.baidu.adp.lib.f.b.toLong(this.ljR.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dfI, "c13562");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (eu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (eu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.AZ(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Ba(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.iM(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dR("obj_id", metaData.getUserId()).aj("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dR("obj_id", metaData.getUserId()).aj("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.eHC.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.ljR.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bmC();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lnQ.dlh();
        this.ljR.uo(z);
        if (this.lnO != null) {
            this.lnO.ih(z);
            if (markData != null) {
                this.lnO.a(markData);
            }
        }
        if (this.ljR.bfV()) {
            dig();
        } else {
            this.lnQ.s(this.ljR.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ft(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pj(String str) {
        if (this.ljR != null && this.ljR.getPbData() != null && this.ljR.getPbData().dgl()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.ljR.diV(), str);
            bw dfI = this.ljR.getPbData().dfI();
            if (dfI.biI()) {
                format = format + "&channelid=33833";
            } else if (dfI.blU()) {
                format = format + "&channelid=33842";
            } else if (dfI.biJ()) {
                format = format + "&channelid=33840";
            }
            Pk(format);
            return;
        }
        this.lnN.PK(str);
    }

    private void Pk(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.ljR.djc()) {
                    antiData.setBlock_forum_name(this.ljR.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.ljR.getPbData().getForum().getId());
                    antiData.setUser_name(this.ljR.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.ljR.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (dhN() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
                } else {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bN(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            DF(str);
        } else {
            this.lnQ.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.mTG) ? bVar.mTG : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Ba(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.iM(true);
                aVar.b(getPageContext());
                aVar.bmC();
            } else {
                this.lnQ.a(0, bVar.QP, bVar.mTG, z);
            }
            if (bVar.QP) {
                if (bVar.iij == 1) {
                    ArrayList<PostData> dfK = this.ljR.getPbData().dfK();
                    int size = dfK.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dfK.get(i).getId())) {
                            i++;
                        } else {
                            dfK.remove(i);
                            break;
                        }
                    }
                    this.ljR.getPbData().dfI().nZ(this.ljR.getPbData().dfI().bjR() - 1);
                    this.lnQ.s(this.ljR.getPbData());
                } else if (bVar.iij == 0) {
                    die();
                } else if (bVar.iij == 2) {
                    ArrayList<PostData> dfK2 = this.ljR.getPbData().dfK();
                    int size2 = dfK2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dfK2.get(i2).dHu().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dfK2.get(i2).dHu().get(i3).getId())) {
                                i3++;
                            } else {
                                dfK2.get(i2).dHu().remove(i3);
                                dfK2.get(i2).dHw();
                                z2 = true;
                                break;
                            }
                        }
                        dfK2.get(i2).SA(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lnQ.s(this.ljR.getPbData());
                    }
                    a(bVar, this.lnQ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.lnQ.a(this.hST.getLoadDataMode(), gVar.QP, gVar.mTG, false);
            if (gVar.QP) {
                this.lnR = true;
                if (i == 2 || i == 3) {
                    this.lnS = true;
                    this.lnT = false;
                } else if (i == 4 || i == 5) {
                    this.lnS = false;
                    this.lnT = true;
                }
                if (i == 2) {
                    this.ljR.getPbData().dfI().oc(1);
                    this.ljR.setIsGood(1);
                } else if (i == 3) {
                    this.ljR.getPbData().dfI().oc(0);
                    this.ljR.setIsGood(0);
                } else if (i == 4) {
                    this.ljR.getPbData().dfI().ob(1);
                    this.ljR.FH(1);
                } else if (i == 5) {
                    this.ljR.getPbData().dfI().ob(0);
                    this.ljR.FH(0);
                }
                this.lnQ.c(this.ljR.getPbData(), this.ljR.diX());
            }
        }
    }

    private void die() {
        if (this.ljR.diY() || this.ljR.dja()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.ljR.diV());
            PbActivity pbActivity = this.lnl;
            PbActivity pbActivity2 = this.lnl;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.ljR.diV()));
        if (dih()) {
            this.lnl.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhk() {
        this.lnl.dhk();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dfU;
        boolean z = false;
        if (this.lnQ != null) {
            this.lnQ.dly();
        }
        if (this.ljR != null && this.ljR.getPbData() != null && !this.ljR.getPbData().dgl()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.ljR.getPbData().dfI().getId();
            if (this.ljR.isShareThread() && this.ljR.getPbData().dfI().eAy != null) {
                historyMessage.threadName = this.ljR.getPbData().dfI().eAy.showText;
            } else {
                historyMessage.threadName = this.ljR.getPbData().dfI().getTitle();
            }
            if (this.ljR.isShareThread() && !dgO()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.ljR.getPbData().getForum().getName();
            }
            ArrayList<PostData> dfK = this.ljR.getPbData().dfK();
            int dlj = this.lnQ != null ? this.lnQ.dlj() : 0;
            if (dfK != null && dlj >= 0 && dlj < dfK.size()) {
                historyMessage.postID = dfK.get(dlj).getId();
            }
            historyMessage.isHostOnly = this.ljR.getHostMode();
            historyMessage.isSquence = this.ljR.diX();
            historyMessage.isShareThread = this.ljR.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lod != null) {
            this.lod.onDestroy();
        }
        if (this.lnp && dhN() != null) {
            dhN().dlS();
        }
        if (this.ljR != null && (this.ljR.diY() || this.ljR.dja())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.ljR.diV());
            if (this.lnR) {
                if (this.lnT) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.ljR.coB());
                }
                if (this.lnS) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.ljR.getIsGood());
                }
            }
            if (this.ljR.getPbData() != null && System.currentTimeMillis() - this.lns >= 40000 && (dfU = this.ljR.getPbData().dfU()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dfU.getDataList())) {
                intent.putExtra("guess_like_data", dfU);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lot);
            }
            PbActivity pbActivity = this.lnl;
            PbActivity pbActivity2 = this.lnl;
            pbActivity.setResult(-1, intent);
        }
        if (dih()) {
            if (this.ljR != null && this.lnQ != null && this.lnQ.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.ljR.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dfQ() && !this.lny && pbData.lgZ == null) {
                        as dkq = as.dkq();
                        com.baidu.tieba.pb.data.f djf = this.ljR.djf();
                        Parcelable onSaveInstanceState = this.lnQ.getListView().onSaveInstanceState();
                        boolean diX = this.ljR.diX();
                        boolean hostMode = this.ljR.getHostMode();
                        if (this.lnQ.dkS() != null && this.lnQ.dkS().getVisibility() == 0) {
                            z = true;
                        }
                        dkq.a(djf, onSaveInstanceState, diX, hostMode, z);
                        if (this.los >= 0 || this.ljR.djH() != null) {
                            as.dkq().q(this.ljR.djH());
                            as.dkq().p(this.ljR.djI());
                            as.dkq().FR(this.ljR.djJ());
                        }
                    }
                }
            } else {
                as.dkq().reset();
            }
            dhk();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lnQ == null || !this.lnQ.FX(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FD(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lnl;
        if (i == 0) {
            this.lnQ.dkG();
            this.lnQ.dkI().dhD();
            this.lnQ.uJ(false);
        }
        this.lnQ.dkK();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.lod.resetData();
                        this.lod.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lod.b(writeData);
                        com.baidu.tbadk.editortools.m ra = this.lod.bwY().ra(6);
                        if (ra != null && ra.fhv != null) {
                            ra.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lnl;
                        if (i == -1) {
                            this.lod.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lnQ.dkI() != null && this.lnQ.dkI().dhH() != null) {
                            com.baidu.tbadk.editortools.pb.h dhH = this.lnQ.dkI().dhH();
                            dhH.setThreadData(this.ljR.getPbData().dfI());
                            dhH.b(writeData);
                            dhH.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m ra2 = dhH.bwY().ra(6);
                            if (ra2 != null && ra2.fhv != null) {
                                ra2.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lnl;
                            if (i == -1) {
                                dhH.byc();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lod.onActivityResult(i, i2, intent);
        if (this.lnD != null) {
            this.lnD.onActivityResult(i, i2, intent);
        }
        if (dhN().dkI() != null) {
            dhN().dkI().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dif();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.dkq().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.ljR != null) {
                                PbFragment.this.ljR.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dxr().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.ljR != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (intent != null) {
                        aqVar.dR("tid", intent.getStringExtra("tid"));
                        aqVar.dR("post_id", intent.getStringExtra("pid"));
                        aqVar.aj("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(aqVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dxr().F(getPageContext());
                        dhX();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.iUz != null && shareItem != null && shareItem.linkUrl != null) {
                            this.iUz.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void buw() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbFragment.this.getPageContext(), customDialogData).show();
                                        }
                                    }, 1000L);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                    this.lnQ.tP(false);
                    if (this.ljR.getPbData() != null && this.ljR.getPbData().dfI() != null && this.ljR.getPbData().dfI().bkv() != null) {
                        this.ljR.getPbData().dfI().bkv().setStatus(2);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SELECT_LIKE_FORUM /* 25012 */:
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                    return;
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.loh = emotionImageData;
                        if (FC(com.baidu.tbadk.core.util.am.eHz)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lnE != null) {
                        this.lnQ.dl(this.lnE);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.lnD == null) {
                this.lnD = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lnl);
                this.lnD.b(this.fjX);
                this.lnD.c(this.fke);
            }
            this.lnD.a(emotionImageData, dgX(), dgX().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dif() {
        MarkData FO;
        if (this.lnO != null) {
            if (this.ljR.getPbData() != null && this.ljR.getPbData().dgl()) {
                FO = this.ljR.FO(0);
            } else {
                FO = this.ljR.FO(this.lnQ.dlk());
            }
            if (FO != null) {
                if (!FO.isApp() || (FO = this.ljR.FO(this.lnQ.dlk() + 1)) != null) {
                    this.lnQ.dlf();
                    this.lnO.a(FO);
                    if (!this.lnO.bfV()) {
                        this.lnO.bfX();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lnO.bfW();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dig() {
        com.baidu.tieba.pb.data.f pbData = this.ljR.getPbData();
        this.ljR.uo(true);
        if (this.lnO != null) {
            pbData.Pa(this.lnO.bfU());
        }
        this.lnQ.s(pbData);
    }

    private boolean dih() {
        if (this.ljR == null) {
            return true;
        }
        if (this.ljR.getPbData() == null || !this.ljR.getPbData().dgl()) {
            if (this.ljR.bfV()) {
                final MarkData djp = this.ljR.djp();
                if (djp == null || !this.ljR.getIsFromMark()) {
                    return true;
                }
                final MarkData FO = this.ljR.FO(this.lnQ.dlj());
                if (FO == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", djp);
                    this.lnl.setResult(-1, intent);
                    return true;
                } else if (FO.getPostId() == null || FO.getPostId().equals(djp.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", djp);
                    this.lnl.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Ba(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lnO != null) {
                                if (PbFragment.this.lnO.bfV()) {
                                    PbFragment.this.lnO.bfW();
                                    PbFragment.this.lnO.ih(false);
                                }
                                PbFragment.this.lnO.a(FO);
                                PbFragment.this.lnO.ih(true);
                                PbFragment.this.lnO.bfX();
                            }
                            djp.setPostId(FO.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", djp);
                            PbFragment.this.lnl.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dhk();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", djp);
                            PbFragment.this.lnl.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dhk();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lnQ != null && PbFragment.this.lnQ.getView() != null) {
                                PbFragment.this.lnQ.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", djp);
                                PbFragment.this.lnl.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dhk();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bmC();
                    return false;
                }
            } else if (this.ljR.getPbData() == null || this.ljR.getPbData().dfK() == null || this.ljR.getPbData().dfK().size() <= 0 || !this.ljR.getIsFromMark()) {
                return true;
            } else {
                this.lnl.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.i
    public BdListView getListView() {
        if (this.lnQ == null) {
            return null;
        }
        return this.lnQ.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bDU() {
        if (this.lnQ == null) {
            return 0;
        }
        return this.lnQ.dlw();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bDV() {
        if (this.fzV == null) {
            this.fzV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bEh */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bhh().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.bhh().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.fzV;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bDW() {
        if (this.fDm == null) {
            this.fDm = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fDm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bDX() {
        if (this.fzW == null) {
            this.fzW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cqr */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bhh().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.setBackgroundDrawable(null);
                    gifView.setImageDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (com.baidu.tbadk.core.k.bhh().isShowImages()) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.byC();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fzW;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bDY() {
        if (this.fDn == null) {
            this.fDn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: diF */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dg */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dh */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bWJ();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: di */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fDn;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bEa() {
        this.fDp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: diG */
            public RelativeLayout makeObject() {
                return new RelativeLayout(PbFragment.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.fDp;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bqB() {
        if (this.eSd == null) {
            this.eSd = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eSd;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lnw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (be.PB(str) && this.ljR != null && this.ljR.diV() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").aj("obj_param1", 1).dR("post_id", this.ljR.diV()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.fgu = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            be.dmd().f(getPageContext(), str);
        }
        this.lnw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
        be.dmd().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lnw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void az(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.lnQ != null && this.lnQ.dlN() != null && rect.top <= this.lnQ.dlN().getHeight()) {
            rect.top += this.lnQ.dlN().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.ljR.getPbData();
            TbRichText bx = bx(str, i);
            if (bx != null && (tbRichTextData = bx.bDj().get(this.lpc)) != null) {
                aVar.postId = String.valueOf(bx.getPostId());
                aVar.ljZ = new ArrayList<>();
                aVar.erD = new ConcurrentHashMap<>();
                if (!tbRichTextData.bDp().bDD()) {
                    aVar.lka = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.ljZ.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bx.getPostId();
                    imageUrlData.mIsReserver = this.ljR.djn();
                    imageUrlData.mIsSeeHost = this.ljR.getHostMode();
                    aVar.erD.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dfI() != null) {
                            aVar.threadId = pbData.dfI().getId();
                        }
                        aVar.erB = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lka = true;
                int size = pbData.dfK().size();
                this.lpd = false;
                aVar.index = -1;
                int a2 = pbData.dfR() != null ? a(pbData.dfR().dHz(), bx, i, i, aVar.ljZ, aVar.erD) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dfK().get(i2);
                    if (postData.getId() == null || pbData.dfR() == null || pbData.dfR().getId() == null || !postData.getId().equals(pbData.dfR().getId())) {
                        a2 = a(postData.dHz(), bx, a2, i, aVar.ljZ, aVar.erD);
                    }
                }
                if (aVar.ljZ.size() > 0) {
                    aVar.lastId = aVar.ljZ.get(aVar.ljZ.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dfI() != null) {
                        aVar.threadId = pbData.dfI().getId();
                    }
                    aVar.erB = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bDp() == null) {
            return null;
        }
        return tbRichTextData.bDp().bDI();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bDp() == null) {
            return 0L;
        }
        return tbRichTextData.bDp().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bDp() == null) {
            return false;
        }
        return tbRichTextData.bDp().bDJ();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bDp() == null) {
            return false;
        }
        return tbRichTextData.bDp().bDK();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bDp;
        String str;
        if (tbRichText == tbRichText2) {
            this.lpd = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bDj().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bDj().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bDp().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bDp().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bDp().bDD()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else if (tbRichTextData.getType() == 20) {
                        i3 = i8;
                        i4 = i7;
                    } else {
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (bDp = tbRichTextData.bDp()) != null) {
                                String bDF = bDp.bDF();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bDp.bDG();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bDF;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.ljR.diV(), -1L);
                                imageUrlData.mIsReserver = this.ljR.djn();
                                imageUrlData.mIsSeeHost = this.ljR.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lpd) {
                            i4 = i7 + 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    protected void n(PostData postData) {
        PostData dfR;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.ljR.bki())) {
                z = true;
            }
            MarkData o = this.ljR.o(postData);
            if (this.ljR.getPbData() != null && this.ljR.getPbData().dgl() && (dfR = dfR()) != null) {
                o = this.ljR.o(dfR);
            }
            if (o != null) {
                this.lnQ.dlf();
                if (this.lnO != null) {
                    this.lnO.a(o);
                    if (!z) {
                        this.lnO.bfX();
                    } else {
                        this.lnO.bfW();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(postData, false);
        }
    }

    public boolean df(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bx(String str, int i) {
        TbRichText tbRichText = null;
        if (this.ljR == null || this.ljR.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.ljR.getPbData();
        if (pbData.dfR() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dfR());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dfK = pbData.dfK();
            c(pbData, dfK);
            return c(dfK, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eLs == null) {
                this.eLs = new com.baidu.tbadk.core.message.a();
            }
            if (this.eLc == null) {
                this.eLc = new com.baidu.tieba.tbadkCore.data.e();
                this.eLc.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.etA = 5;
            cVar.etG = 8;
            cVar.etF = 2;
            if (dgX() != null) {
                cVar.etE = dgX().djF();
            }
            cVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.etH = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.etH = 1;
                        i = 0;
                    }
                }
                this.eLs.a(agreeData, i, getUniqueId(), false);
                this.eLs.a(agreeData, this.eLc);
                if (this.ljR == null && this.ljR.getPbData() != null) {
                    this.eLs.a(diC(), cVar, agreeData, this.ljR.getPbData().dfI());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.etH = 1;
            }
            i = 0;
            this.eLs.a(agreeData, i, getUniqueId(), false);
            this.eLs.a(agreeData, this.eLc);
            if (this.ljR == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dfW() != null && fVar.dfW().liC != null && (list = fVar.dfW().liC) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<PostData> it = arrayList.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            PostData postData = (PostData) it2.next();
                            if (postData != null && !TextUtils.isEmpty(next.getId()) && !TextUtils.isEmpty(postData.getId()) && next.getId().equals(postData.getId())) {
                                arrayList2.add(postData);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList3.removeAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
    }

    private TbRichText c(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> bDj;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dHz = arrayList.get(i2).dHz();
            if (dHz != null && (bDj = dHz.bDj()) != null) {
                int size = bDj.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bDj.get(i4) != null && bDj.get(i4).getType() == 8) {
                        i3++;
                        if (bDj.get(i4).bDp().bDF().equals(str) || bDj.get(i4).bDp().bDG().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bDj.get(i4).bDp().getWidth() * equipmentDensity;
                            int height = bDj.get(i4).bDp().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lpc = i4;
                            return dHz;
                        } else if (i3 <= i) {
                        }
                    }
                    i4++;
                    i3 = i3;
                }
                continue;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.ljN = str;
            if (this.lnr == null) {
                dhR();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lnr.getItemView(1).setVisibility(8);
            } else {
                this.lnr.getItemView(1).setVisibility(0);
            }
            this.lnr.bmE();
            this.lnw = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iBr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dii() {
        hideNetRefreshView(this.lnQ.getView());
        dij();
        if (this.ljR.dji()) {
            this.lnQ.dlf();
        }
        this.lnQ.dlq();
    }

    private void dij() {
        showLoadingView(this.lnQ.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lnQ.dlN().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwj() {
        if (this.iBr != null) {
            this.iBr.stopPlay();
        }
        if (this.lnl != null) {
            this.lnl.cwj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FE(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, dhW(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bDZ() {
        if (this.fDo == null) {
            this.fDo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: diH */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(PbFragment.this.getPageContext().getPageActivity());
                    linearLayout.setId(R.id.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fDo;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void cwk() {
        if (this.lnl != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lnl.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lnl.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cuM() {
        if (this.ljR == null || this.ljR.getPbData() == null) {
            return null;
        }
        return this.ljR.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.lwo)).intValue();
            if (intValue == az.lwp) {
                if (!this.hST.dIi()) {
                    this.lnQ.dlc();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.hST.SC(com.baidu.tbadk.core.util.at.R(jSONArray));
                    }
                    this.hST.a(this.ljR.getPbData().getForum().getId(), this.ljR.getPbData().getForum().getName(), this.ljR.getPbData().dfI().getId(), str, intValue3, intValue2, booleanValue, this.ljR.getPbData().dfI().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.lwq || intValue == az.lws) {
                if (this.ljR.djy() != null) {
                    this.ljR.djy().Fy(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.lwq) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lom);
        userMuteAddAndDelCustomMessage.setTag(this.lom);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Pl(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0807a
    public void ud(boolean z) {
        this.lnW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dik() {
        ArrayList<PostData> dfK;
        int count;
        if (this.ljR == null || this.ljR.getPbData() == null || this.ljR.getPbData().dfK() == null || (count = com.baidu.tbadk.core.util.y.getCount((dfK = this.ljR.getPbData().dfK()))) == 0) {
            return "";
        }
        if (this.ljR.djn()) {
            Iterator<PostData> it = dfK.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dHx() == 1) {
                    return next.getId();
                }
            }
        }
        int dlj = this.lnQ.dlj();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dfK, dlj);
        if (postData == null || postData.bka() == null) {
            return "";
        }
        if (this.ljR.Pp(postData.bka().getUserId())) {
            return postData.getId();
        }
        for (int i = dlj - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dfK, i);
            if (postData2 == null || postData2.bka() == null || postData2.bka().getUserId() == null) {
                break;
            } else if (this.ljR.Pp(postData2.bka().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dlj + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dfK, i2);
            if (postData3 == null || postData3.bka() == null || postData3.bka().getUserId() == null) {
                return "";
            }
            if (this.ljR.Pp(postData3.bka().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aB(Context context, String str) {
        this.lnw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Pm(String str) {
        String str2;
        if (this.ljR.getPbData() == null || this.ljR.getPbData().dfK() == null || this.ljR.getPbData().dfK().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.ljR.getPbData().dfK().size()) {
                i = 0;
                break;
            } else if (str.equals(this.ljR.getPbData().dfK().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.ljR.getPbData().dfK().get(i);
        if (postData.dHz() == null || postData.dHz().bDj() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dHz().bDj().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bDp() != null) {
                    str2 = next.bDp().bDF();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dil() {
        return (!this.lnm && this.lph == -1 && this.lpi == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null) {
            this.lpk = rVar;
            this.lnm = true;
            this.lnQ.dkT();
            this.lnQ.Pz(this.lpj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dim() {
        if (this.lpk != null) {
            if (this.lph == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lpk.getCartoonId(), this.lph, 0)));
                this.lnl.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void din() {
        if (this.lpk != null) {
            if (this.lpi == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lpk.getCartoonId(), this.lpi, 0)));
                this.lnl.finish();
            }
        }
    }

    public int dio() {
        return this.lph;
    }

    public int dip() {
        return this.lpi;
    }

    private void cKa() {
        if (this.ljR != null && this.ljR.getPbData() != null && this.ljR.getPbData().dfI() != null && this.ljR.getPbData().dfI().biG()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void diq() {
        if (this.ljR != null && this.ljR.getPbData() != null && this.ljR.getPbData().dfI() != null && this.ljR.getPbData().dfI().biG()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dir() {
        if (this.byS) {
            this.lnC = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.ljR.getPbData() != null && this.ljR.getPbData().dfI() != null && this.ljR.getPbData().dfI().bjG() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.ljR.getPbData().dfI().bjG().getThreadId(), this.ljR.getPbData().dfI().bjG().getTaskId(), this.ljR.getPbData().dfI().bjG().getForumId(), this.ljR.getPbData().dfI().bjG().getForumName(), this.ljR.getPbData().dfI().bjV(), this.ljR.getPbData().dfI().bjW())));
            this.lno = true;
            this.lnl.finish();
        }
    }

    public String dis() {
        return this.lnA;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dit() {
        return this.lnM;
    }

    public void ue(boolean z) {
        this.lnB = z;
    }

    public boolean bhI() {
        if (this.ljR != null) {
            return this.ljR.diY();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Ba(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lok).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lok.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lok).bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lok != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lok.getPageActivity());
            aVar.Ba(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lok).bmC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lnQ.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lok.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Ba(this.lok.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Ba(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lnQ.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.84
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lok).bmC();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.PB(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.d(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    spannableStringBuilder.setSpan(objArr[i], spannableStringBuilder.getSpanStart(objArr[i]), spannableStringBuilder.length(), 18);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.jfl) {
            this.jfl = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lnQ != null) {
                this.lnQ.onConfigurationChanged(configuration);
            }
            if (this.lnU != null) {
                this.lnU.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean div() {
        if (this.ljR != null) {
            return this.ljR.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.ljR.getPbData().dfW().liC;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dHu().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dHu().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dHu().remove(i2);
                    list.get(i).dHw();
                    z = true;
                    break;
                }
            }
            list.get(i).SA(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.ljR.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.dgy().getId();
        List<PostData> list = this.ljR.getPbData().dfW().liC;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            PostData postData = list.get(i2);
            if (postData.getId() == null || !postData.getId().equals(id)) {
                i = i2 + 1;
            } else {
                ArrayList<PostData> dgG = pVar.dgG();
                postData.Jp(pVar.getTotalCount());
                if (postData.dHu() != null) {
                    postData.dHu().clear();
                    postData.dHu().addAll(dgG);
                }
            }
        }
        if (!this.ljR.getIsFromMark()) {
            this.lnQ.s(this.ljR.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a dgN() {
        return this.lnl.dgN();
    }

    public boolean dgO() {
        if (this.ljR == null) {
            return false;
        }
        return this.ljR.dgO();
    }

    public void uf(boolean z) {
        this.lnz = z;
    }

    public boolean diw() {
        return this.lnz;
    }

    public void dix() {
        if (this.lnQ != null) {
            this.lnQ.dkG();
            cwk();
        }
    }

    public PostData dfR() {
        return this.lnQ.b(this.ljR.lkO, this.ljR.diX());
    }

    public void onBackPressed() {
        if (this.lou != null && !this.lou.isEmpty()) {
            int size = this.lou.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lou.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lou == null) {
                this.lou = new ArrayList();
            }
            if (!this.lou.contains(aVar)) {
                this.lou.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lou == null) {
                this.lou = new ArrayList();
            }
            if (!this.lou.contains(aVar)) {
                this.lou.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lou != null) {
            this.lou.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diy() {
        if (this.ljR != null && !com.baidu.tbadk.core.util.at.isEmpty(this.ljR.diV())) {
            com.baidu.tbadk.BdToken.c.bdF().q(com.baidu.tbadk.BdToken.b.ekj, com.baidu.adp.lib.f.b.toLong(this.ljR.diV(), 0L));
        }
    }

    public bf diz() {
        return this.lnJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pn(String str) {
        if (this.ljR != null && this.ljR.getPbData() != null && this.ljR.getPbData().dfI() != null && this.ljR.getPbData().dfI().biK()) {
            bw dfI = this.ljR.getPbData().dfI();
            int i = 0;
            if (dfI.biI()) {
                i = 1;
            } else if (dfI.biJ()) {
                i = 2;
            } else if (dfI.blV()) {
                i = 3;
            } else if (dfI.blW()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str);
            aqVar.aj("obj_source", 4);
            aqVar.aj("obj_type", i);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF(final int i) {
        com.baidu.tbadk.util.ae.a(new com.baidu.tbadk.util.ad<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bhc */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.dhW(), i2, PbFragment.this.ljR);
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.86
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.ae(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), i, shareItem, false));
            }
        });
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13833");
        aqVar.aj("obj_locate", 1);
        if (i == 3) {
            aqVar.aj("obj_type", 1);
        } else if (i == 8) {
            aqVar.aj("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment diA() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment diB() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity diC() {
        return this.lnl;
    }
}
