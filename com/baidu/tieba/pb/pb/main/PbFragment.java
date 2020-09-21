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
/* loaded from: classes21.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.pb.videopb.b, a.InterfaceC0774a {
    private bd dWg;
    private com.baidu.tbadk.core.message.a eqK;
    private com.baidu.tieba.tbadkCore.data.e equ;
    private com.baidu.adp.lib.d.b<TbImageView> exy;
    private LikeModel ezi;
    private com.baidu.adp.lib.d.b<ImageView> ffj;
    private com.baidu.adp.lib.d.b<GifView> ffk;
    private com.baidu.adp.lib.d.b<TextView> fiD;
    private com.baidu.adp.lib.d.b<View> fiE;
    private com.baidu.adp.lib.d.b<LinearLayout> fiF;
    private com.baidu.adp.lib.d.b<RelativeLayout> fiG;
    private VoiceManager hZU;
    private com.baidu.tieba.callfans.a hrE;
    private com.baidu.tieba.f.b ieU;
    private com.baidu.tieba.frs.profession.permission.c ieu;
    public com.baidu.tbadk.core.util.am jOf;
    public bb jSk;
    private String kId;
    private PbActivity kLA;
    private com.baidu.tieba.pb.pb.main.b.b kLC;
    private com.baidu.tieba.pb.pb.main.emotion.model.a kLS;
    private View kLT;
    int kLV;
    private bf kLY;
    private Runnable kMA;
    private com.baidu.adp.widget.ImageView.a kMB;
    private String kMC;
    private TbRichTextMemeInfo kMD;
    private List<a> kMG;
    public String kMI;
    private com.baidu.tieba.pb.pb.report.a kMc;
    private com.baidu.tbadk.core.dialog.i kMj;
    private com.baidu.tbadk.core.dialog.k kMk;
    private boolean kMl;
    private com.baidu.tieba.tbadkCore.data.f kMp;
    private com.baidu.tbadk.editortools.pb.g kMq;
    private com.baidu.tbadk.editortools.pb.e kMr;
    private com.baidu.tieba.frs.profession.permission.c kMt;
    private EmotionImageData kMu;
    private com.baidu.adp.base.e kMx;
    private com.baidu.tbadk.core.view.c kMy;
    private BdUniqueId kMz;
    private boolean kNl;
    private String kNu;
    private com.baidu.tbadk.core.data.r kNv;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a kNr = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cr(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cZV();
            } else {
                com.baidu.tieba.pb.a.b.cZU();
            }
        }
    };
    private boolean kLB = false;
    private boolean kLD = false;
    private boolean bsQ = false;
    private boolean khJ = false;
    private boolean kLE = true;
    private int kLF = 0;
    private com.baidu.tbadk.core.dialog.b kLG = null;
    private long hCy = -1;
    private long eUN = 0;
    private long kLH = 0;
    private long createTime = 0;
    private long eUE = 0;
    private boolean kLI = false;
    private com.baidu.tbadk.n.b kLJ = null;
    private long kLK = 0;
    private boolean kLL = false;
    private long kLM = 0;
    private int iDZ = 1;
    private String ePo = null;
    private boolean kLN = false;
    private boolean isFullScreen = false;
    private boolean kLO = false;
    private String kLP = "";
    private boolean kLQ = true;
    private boolean kLR = false;
    private String source = "";
    private int mSkinType = 3;
    int[] kLU = new int[2];
    private int kLW = -1;
    private int kLX = -1;
    public BdUniqueId kLZ = BdUniqueId.gen();
    private boolean kMa = false;
    private boolean kJC = com.baidu.tbadk.a.d.baU();
    private PbInterviewStatusView.a kMb = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.kMf.tE(!PbFragment.this.kLQ);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.kIh != null && PbFragment.this.kIh.bbu()) {
                        PbFragment.this.dbq();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel kIh = null;
    private com.baidu.tbadk.baseEditMark.a kMd = null;
    private ForumManageModel hrC = null;
    private com.baidu.tbadk.coreExtra.model.a emW = null;
    private com.baidu.tieba.pb.data.q kMe = null;
    private ShareSuccessReplyToServerModel itk = null;
    private az kMf = null;
    private boolean kMg = false;
    private boolean kMh = false;
    private boolean kMi = false;
    private boolean fww = false;
    private boolean kMm = false;
    private boolean kMn = false;
    private boolean kMo = false;
    private boolean kMs = false;
    public boolean kMv = false;
    private com.baidu.tbadk.editortools.pb.c ePr = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bta() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ePs = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bsZ() {
            if (PbFragment.this.jSk == null || PbFragment.this.jSk.dfj() == null || !PbFragment.this.jSk.dfj().dJz()) {
                return !PbFragment.this.ED(com.baidu.tbadk.core.util.am.emR);
            }
            PbFragment.this.showToast(PbFragment.this.jSk.dfj().dJB());
            if (PbFragment.this.kMr != null && (PbFragment.this.kMr.btq() || PbFragment.this.kMr.btr())) {
                PbFragment.this.kMr.a(false, PbFragment.this.jSk.dfm());
            }
            PbFragment.this.jSk.tR(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b kMw = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bsZ() {
            if (PbFragment.this.jSk == null || PbFragment.this.jSk.dfk() == null || !PbFragment.this.jSk.dfk().dJz()) {
                return !PbFragment.this.ED(com.baidu.tbadk.core.util.am.emS);
            }
            PbFragment.this.showToast(PbFragment.this.jSk.dfk().dJB());
            if (PbFragment.this.kMf != null && PbFragment.this.kMf.ddS() != null && PbFragment.this.kMf.ddS().daR() != null && PbFragment.this.kMf.ddS().daR().btr()) {
                PbFragment.this.kMf.ddS().daR().a(PbFragment.this.jSk.dfm());
            }
            PbFragment.this.jSk.tS(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean iaJ = false;
    private int kME = 0;
    private int kMF = -1;
    public int kMH = 0;
    private final a kMJ = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.kMf != null && PbFragment.this.kMf.ddS() != null) {
                v ddS = PbFragment.this.kMf.ddS();
                if (ddS.daP()) {
                    ddS.daO();
                    return true;
                }
            }
            if (PbFragment.this.kMf != null && PbFragment.this.kMf.deQ()) {
                PbFragment.this.kMf.deR();
                return true;
            }
            return false;
        }
    };
    private final ai.a kMK = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bh(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.kMf.showToast(str);
            }
        }
    };
    private final CustomMessageListener kML = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kIh != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.kMr != null) {
                    PbFragment.this.kMf.tJ(PbFragment.this.kMr.btj());
                }
                PbFragment.this.kMf.ddU();
                PbFragment.this.kMf.deI();
            }
        }
    };
    CustomMessageListener ibA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.kIh.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.kMf != null && PbFragment.this.kIh != null) {
                    PbFragment.this.kMf.b(PbFragment.this.kIh.getPbData(), PbFragment.this.kIh.dch(), PbFragment.this.kIh.dcE(), PbFragment.this.kMf.getSkinType());
                }
                if (PbFragment.this.kMf != null && PbFragment.this.kMf.del() != null) {
                    PbFragment.this.kMf.del().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener kMM = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.kMf != null) {
                    if (booleanValue) {
                        PbFragment.this.kMf.cKd();
                    } else {
                        PbFragment.this.kMf.cKc();
                    }
                }
            }
        }
    };
    private CustomMessageListener kMN = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.kMr != null) {
                    PbFragment.this.kMf.tJ(PbFragment.this.kMr.btj());
                }
                PbFragment.this.kMf.tL(false);
            }
        }
    };
    private CustomMessageListener kMO = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener kMP = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kMf != null && PbFragment.this.kMf.del() != null) {
                PbFragment.this.kMf.del().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jpv = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener ibw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bsQ) {
                PbFragment.this.dbI();
            }
        }
    };
    private View.OnClickListener eQa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.ePo);
        }
    };
    private CustomMessageListener kMQ = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ag)) {
                com.baidu.tbadk.core.data.ag agVar = (com.baidu.tbadk.core.data.ag) customResponsedMessage.getData();
                ax.a aVar = new ax.a();
                aVar.giftId = agVar.id;
                aVar.giftName = agVar.name;
                aVar.thumbnailUrl = agVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kIh.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.kIh.dcv() != null && PbFragment.this.kIh.dcv().getUserIdLong() == agVar.toUserId) {
                        PbFragment.this.kMf.a(agVar.sendCount, PbFragment.this.kIh.getPbData(), PbFragment.this.kIh.dch(), PbFragment.this.kIh.dcE());
                    }
                    if (pbData.cYT() != null && pbData.cYT().size() >= 1 && pbData.cYT().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cYT().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.kIh.dcf(), 0L);
                        if (j == agVar.postId && j2 == agVar.threadId) {
                            com.baidu.tbadk.core.data.ax dAL = pbData.cYT().get(0).dAL();
                            if (dAL == null) {
                                dAL = new com.baidu.tbadk.core.data.ax();
                            }
                            ArrayList<ax.a> beq = dAL.beq();
                            if (beq == null) {
                                beq = new ArrayList<>();
                            }
                            beq.add(0, aVar);
                            dAL.setTotal(agVar.sendCount + dAL.getTotal());
                            dAL.D(beq);
                            pbData.cYT().get(0).a(dAL);
                            PbFragment.this.kMf.del().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener kMR = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                PbFragment.this.kIh.getPbData().cZl();
                PbFragment.this.kIh.dcA();
                if (PbFragment.this.kMf.del() != null) {
                    PbFragment.this.kMf.s(PbFragment.this.kIh.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener iuE = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.NU(str);
                PbFragment.this.kIh.dcA();
                if (!TextUtils.isEmpty(str) && PbFragment.this.kIh.getPbData().cYT() != null) {
                    ArrayList<PostData> cYT = PbFragment.this.kIh.getPbData().cYT();
                    Iterator<PostData> it = cYT.iterator();
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
                        cYT.remove(nVar);
                        if (PbFragment.this.kMf.del() != null && PbFragment.this.kMf.del().getDataList() != null) {
                            PbFragment.this.kMf.del().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.kMf.getListView() != null && PbFragment.this.kMf.getListView().getData() != null) {
                            PbFragment.this.kMf.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.kMf.del() != null) {
                            PbFragment.this.kMf.del().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.kMf.del() != null) {
                    PbFragment.this.kMf.s(PbFragment.this.kIh.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a kMS = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dfC()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a kMT = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void bh(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.kMf != null) {
                PbFragment.this.kMf.eK(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean kMU = false;
    private PraiseModel kMV = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Ej(String str) {
            PbFragment.this.kMU = false;
            if (PbFragment.this.kMV != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kIh.getPbData();
                if (pbData.cYR().bfj().getIsLike() == 1) {
                    PbFragment.this.yH(0);
                } else {
                    PbFragment.this.yH(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cYR()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.kMU = false;
            if (PbFragment.this.kMV != null && str != null) {
                if (AntiHelper.bC(i, str)) {
                    AntiHelper.bh(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a kMW = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void ti(boolean z) {
            PbFragment.this.tg(z);
            if (PbFragment.this.kMf.deW() != null && z) {
                PbFragment.this.kMf.tE(false);
            }
            PbFragment.this.kMf.tG(z);
        }
    };
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().eEj != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().eEj, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cZa().bfy() != null && PbFragment.this.cZa().bfy().getGodUserData() != null) {
                            PbFragment.this.cZa().bfy().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().bfy() != null) {
                            PbFragment.this.kIh.getPbData().cYR().bfy().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h hYY = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.kLA.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a kMX = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.kMf.bXZ();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.EF(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.cyZ();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c eHq = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.dba();
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
                        if (PbFragment.this.cV(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.kMf.daY() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dF("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cZW() != null && PbFragment.this.cZW().hJr != null) {
                                PbFragment.this.cZW().hJr.onClick(view);
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
                if (PbFragment.this.kMr != null) {
                    PbFragment.this.kMf.tJ(PbFragment.this.kMr.btj());
                }
                PbFragment.this.kMf.ddU();
                PbFragment.this.kMf.deI();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener kMY = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kMz) {
                PbFragment.this.kMf.bXZ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kIh.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cZh().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.kMy.showSuccessToast(PbFragment.this.kMx.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.kMx.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.CA(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dbE();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.kMx.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.kMy.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kMZ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kMz) {
                PbFragment.this.kMf.bXZ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.kMy.showSuccessToast(PbFragment.this.kMx.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.kMx.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.kMy.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kNa = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kMz) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.kMf.bXZ();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.mDo;
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
                    PbFragment.this.kMf.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener kNb = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kMf.ddV() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dba();
            }
        }
    };
    private CustomMessageListener ibI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.iaJ = true;
                }
            }
        }
    };
    public a.b ksR = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cpF();
            com.baidu.tbadk.core.data.av pageData = PbFragment.this.kIh.getPageData();
            int pageNum = PbFragment.this.kMf.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bej()) {
                PbFragment.this.kMf.deI();
                PbFragment.this.cpE();
                PbFragment.this.kMf.dep();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.kIh.EJ(PbFragment.this.kMf.getPageNum());
                    if (PbFragment.this.kLC != null) {
                        PbFragment.this.kLC.showFloatingView();
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
    private k.c kNc = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.kMj != null) {
                PbFragment.this.kMj.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.kMB != null && !TextUtils.isEmpty(PbFragment.this.kMC)) {
                        if (PbFragment.this.kMD == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.kMC));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.kMC;
                            aVar.pkgId = PbFragment.this.kMD.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.kMD.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.kMB = null;
                        PbFragment.this.kMC = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.kMB != null && !TextUtils.isEmpty(PbFragment.this.kMC)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.dWg == null) {
                                PbFragment.this.dWg = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.dWg.j(PbFragment.this.kMC, PbFragment.this.kMB.getImageByte());
                            PbFragment.this.kMB = null;
                            PbFragment.this.kMC = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.jds != null) {
                        PbFragment.this.jds.fL(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.jds = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").ai("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cW(view);
                        if (PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().bfy() != null && PbFragment.this.kIh.getPbData().cYR().bfy().getUserId() != null && PbFragment.this.kMd != null) {
                            int h = PbFragment.this.h(PbFragment.this.kIh.getPbData());
                            bw cYR = PbFragment.this.kIh.getPbData().cYR();
                            if (cYR.beg()) {
                                i2 = 2;
                            } else if (cYR.beh()) {
                                i2 = 3;
                            } else if (cYR.bht()) {
                                i2 = 4;
                            } else {
                                i2 = cYR.bhu() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dF("tid", PbFragment.this.kIh.kPr).ai("obj_locate", 2).dF("obj_id", PbFragment.this.kIh.getPbData().cYR().bfy().getUserId()).ai("obj_type", PbFragment.this.kMd.bbu() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i2));
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
                        PbFragment.this.NW((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").ai("obj_locate", 4));
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
                        PbFragment.this.kMf.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.kMf.dc(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.kMf.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bhp() != null) {
                            PbFragment.this.d(postData.bhp());
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
    public SortSwitchButton.a kNd = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean yk(int i) {
            PbFragment.this.kMf.deI();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.kIh == null || PbFragment.this.kIh.isLoading) {
                    return false;
                }
                PbFragment.this.cpE();
                PbFragment.this.kMf.dep();
                if (PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().kFn != null && PbFragment.this.kIh.getPbData().kFn.size() > i) {
                    int intValue = PbFragment.this.kIh.getPbData().kFn.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dF("tid", PbFragment.this.kIh.dcg()).dF("fid", PbFragment.this.kIh.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_type", EH(intValue)));
                    if (PbFragment.this.kIh.EO(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.kMf.tz(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int EH(int i) {
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
    public final View.OnClickListener icH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
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
            boolean z3;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.kMf.deE()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.kIh.to(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.kMf.deq();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddu()) {
                        if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddv()) {
                            if (view == PbFragment.this.kMf.kTk.eXg) {
                                if (PbFragment.this.kMf.tI(PbFragment.this.kIh.dcm())) {
                                    PbFragment.this.cpE();
                                    return;
                                }
                                PbFragment.this.kLE = false;
                                PbFragment.this.kLD = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.kLA, PbFragment.this.kMf.kTk.eXg);
                                PbFragment.this.kLA.finish();
                            } else if (view != PbFragment.this.kMf.den() && (PbFragment.this.kMf.kTk.dfP() == null || (view != PbFragment.this.kMf.kTk.dfP().ddt() && view != PbFragment.this.kMf.kTk.dfP().ddr()))) {
                                if (view == PbFragment.this.kMf.deM()) {
                                    if (PbFragment.this.kIh != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kIh.getPbData().cYR().bfx().getLink());
                                    }
                                } else if (view != PbFragment.this.kMf.kTk.kZA) {
                                    if (view == PbFragment.this.kMf.kTk.kZB) {
                                        if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                            ArrayList<PostData> cYT = PbFragment.this.kIh.getPbData().cYT();
                                            if ((cYT == null || cYT.size() <= 0) && PbFragment.this.kIh.dch()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dF("tid", PbFragment.this.kIh.dcf()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", PbFragment.this.kIh.getForumId()));
                                            if (!PbFragment.this.kMf.dfb()) {
                                                PbFragment.this.kMf.ddU();
                                            }
                                            PbFragment.this.dbi();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.kMf.sV(true);
                                            PbFragment.this.kMf.ddU();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.kMf.cKd();
                                                PbFragment.this.cpE();
                                                PbFragment.this.kMf.dep();
                                                PbFragment.this.kIh.Ob(PbFragment.this.dbu());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddq()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.kMf.kTk.dfP() != null && view == PbFragment.this.kMf.kTk.dfP().ddp()) {
                                                PbFragment.this.kMf.kTk.aSz();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.EE(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.EG(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddn()) {
                                                    if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddx()) {
                                                        if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddo()) {
                                                            if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddy()) {
                                                                if (PbFragment.this.kMf.deW() == view) {
                                                                    if (PbFragment.this.kMf.deW().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.kIh.getPbData();
                                                                        if (pbData2 != null && pbData2.cYR() != null && pbData2.cYR().bfe() != null) {
                                                                            String beU = pbData2.cYR().bfe().beU();
                                                                            if (StringUtils.isNull(beU)) {
                                                                                beU = pbData2.cYR().bfe().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dF("obj_id", beU));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.ge("c10725", null);
                                                                    }
                                                                    PbFragment.this.dbB();
                                                                } else if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddw()) {
                                                                    if (PbFragment.this.kMf.kTk.dfP() != null && view == PbFragment.this.kMf.kTk.dfP().dds()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.kMf.b(PbFragment.this.kIh.getPbData(), PbFragment.this.kIh.dch(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.kMf.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.kMf.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.kMf.kTk.aSz();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dF("tid", PbFragment.this.kIh.dcf());
                                                                            aqVar.dF("fid", PbFragment.this.kIh.getForumId());
                                                                            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.ai("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                                                                PbFragment.this.kMf.deI();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dAP() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.mpw != null) {
                                                                                        com.baidu.tbadk.core.util.aq bkh = postData.mpw.bkh();
                                                                                        bkh.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bkh.ai("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bkh.ai("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bkh);
                                                                                    }
                                                                                    String dcf = PbFragment.this.kIh.dcf();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.kIh.getPbData() != null) {
                                                                                        i3 = PbFragment.this.kIh.getPbData().cZg();
                                                                                    }
                                                                                    PbFragment.this.cpE();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a NZ = PbFragment.this.NZ(id);
                                                                                        if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && NZ != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dcf, id, "pb", true, null, true, null, i3, postData.dgO(), PbFragment.this.kIh.getPbData().getAnti(), false, postData.bfy().getIconInfo()).addBigImageData(NZ.kIp, NZ.dXc, NZ.dXa, NZ.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.kIh.dcP());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.kIh.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.kIh.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.kIh.dco());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a NZ2 = PbFragment.this.NZ(id);
                                                                                        if (postData != null && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && NZ2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dcf, id, "pb", true, null, false, str2, i3, postData.dgO(), PbFragment.this.kIh.getPbData().getAnti(), false, postData.bfy().getIconInfo()).addBigImageData(NZ2.kIp, NZ2.dXc, NZ2.dXa, NZ2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.kIh.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.kIh.dco());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.kIh.dcP());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.kIh.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").ai("obj_locate", 3).dF("fid", PbFragment.this.kIh.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.kIh != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dF("tid", PbFragment.this.kIh.dcf());
                                                                            aqVar2.dF("fid", PbFragment.this.kIh.getForumId());
                                                                            aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.ai("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.mpw != null) {
                                                                                        com.baidu.tbadk.core.util.aq bkh2 = postData3.mpw.bkh();
                                                                                        bkh2.delete("obj_locate");
                                                                                        bkh2.ai("obj_locate", 8);
                                                                                        TiebaStatic.log(bkh2);
                                                                                    }
                                                                                    if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                                                                        String dcf2 = PbFragment.this.kIh.dcf();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.kIh.getPbData() != null) {
                                                                                            i4 = PbFragment.this.kIh.getPbData().cZg();
                                                                                        }
                                                                                        PbActivity.a NZ3 = PbFragment.this.NZ(id2);
                                                                                        if (NZ3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dcf2, id2, "pb", true, null, false, null, i4, postData3.dgO(), PbFragment.this.kIh.getPbData().getAnti(), false, postData3.bfy().getIconInfo()).addBigImageData(NZ3.kIp, NZ3.dXc, NZ3.dXa, NZ3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.kIh.dcP());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.kIh.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.kIh.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.kIh.dco());
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
                                                                        if (PbFragment.this.kIh != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dF("tid", PbFragment.this.kIh.dcf());
                                                                                aqVar3.dF("fid", PbFragment.this.kIh.getForumId());
                                                                                aqVar3.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.ai("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.mpw != null) {
                                                                                        com.baidu.tbadk.core.util.aq bkh3 = postData4.mpw.bkh();
                                                                                        bkh3.delete("obj_locate");
                                                                                        bkh3.ai("obj_locate", 8);
                                                                                        TiebaStatic.log(bkh3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dF("tid", PbFragment.this.kIh.dcg()).dF("fid", PbFragment.this.kIh.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", postData4.getId()).ai("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.daX().ddR() != null && postData4.bfy() != null && postData4.dAD() != 1) {
                                                                                        if (PbFragment.this.daX().ddS() != null) {
                                                                                            PbFragment.this.daX().ddS().daN();
                                                                                        }
                                                                                        if ((PbFragment.this.kJC || com.baidu.tbadk.a.d.baK()) && postData4.dAA() != null && postData4.dAA().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.baL()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.kIh.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.kIh.getPbData().cYR());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.daX().ddR().d(pVar);
                                                                                            PbFragment.this.daX().ddR().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.bfy().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.kMr != null) {
                                                                                                PbFragment.this.kMf.tJ(PbFragment.this.kMr.btj());
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
                                                                        if (view != PbFragment.this.kMf.dar()) {
                                                                            if (view == PbFragment.this.kMf.kTk.dfQ()) {
                                                                                PbFragment.this.kMf.dew();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (cbVar = (cb) view.getTag()) != null && !StringUtils.isNull(cbVar.bhO())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        com.baidu.tbadk.core.util.be.bkp().b(PbFragment.this.getPageContext(), new String[]{cbVar.bhO()});
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dF("tid", PbFragment.this.kIh.kPr));
                                                                                            }
                                                                                            if (PbFragment.this.kMk == null) {
                                                                                                PbFragment.this.kMk = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.kMk.a(PbFragment.this.kNc);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.cX(view);
                                                                                            if (!PbFragment.this.cX(view) || PbFragment.this.kMB == null || !PbFragment.this.kMB.isGif()) {
                                                                                            }
                                                                                            boolean z4 = false;
                                                                                            boolean z5 = false;
                                                                                            boolean z6 = false;
                                                                                            boolean z7 = false;
                                                                                            boolean z8 = false;
                                                                                            String str3 = null;
                                                                                            if (sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                                ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                                z4 = ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z5 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                                z6 = ((Boolean) sparseArray5.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z7 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                                z8 = ((Boolean) sparseArray5.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                                                                                str3 = (String) sparseArray5.get(R.id.tag_forbid_user_post_id);
                                                                                            }
                                                                                            if (postData5 != null) {
                                                                                                if (postData5.dAF() != null && postData5.dAF().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kMk);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.mTextView.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.jds = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.kIh.getPbData().bbu()) {
                                                                                                String bbt = PbFragment.this.kIh.getPbData().bbt();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bbt) && bbt.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kMk);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kMk);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.jds);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z6 && z5) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kMk);
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
                                                                                                            if (PbFragment.this.tc(z4) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kMk);
                                                                                                                gVar7.mTextView.setTag(str3);
                                                                                                                arrayList.add(gVar7);
                                                                                                            }
                                                                                                        }
                                                                                                        if (z6) {
                                                                                                            SparseArray sparseArray9 = new SparseArray();
                                                                                                            sparseArray9.put(R.id.tag_should_manage_visible, true);
                                                                                                            sparseArray9.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name, sparseArray5.get(R.id.tag_forbid_user_name));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name_show, sparseArray5.get(R.id.tag_forbid_user_name_show));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_portrait, sparseArray5.get(R.id.tag_forbid_user_portrait));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_post_id, str3);
                                                                                                            if (z7) {
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
                                                                                                            if (z8) {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                                sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                                                                                                                sparseArray9.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                                sparseArray9.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kMk);
                                                                                                                gVar2.mTextView.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kMk);
                                                                                                            gVar3.mTextView.setTag(sparseArray9);
                                                                                                        } else if (!z8) {
                                                                                                            gVar2 = null;
                                                                                                            gVar3 = null;
                                                                                                        } else {
                                                                                                            SparseArray sparseArray10 = new SparseArray();
                                                                                                            sparseArray10.put(R.id.tag_should_manage_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_user_mute_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_should_delete_visible, true);
                                                                                                            sparseArray10.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                                                                                                            sparseArray10.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray10.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            if (PbFragment.this.kIh.getPbData().cZg() == 1002 && !z4) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kMk);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kMk);
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
                                                                                                    PbFragment.this.kMk.aX(arrayList);
                                                                                                    PbFragment.this.kMj = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kMk);
                                                                                                    PbFragment.this.kMj.NY();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.jds);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.kMk.aX(arrayList);
                                                                                            PbFragment.this.kMj = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kMk);
                                                                                            PbFragment.this.kMj.NY();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.kIh.getPbData().cYR().getActUrl());
                                                                                        if (PbFragment.this.kIh.getPbData().cYR().bgl() != 1) {
                                                                                            if (PbFragment.this.kIh.getPbData().cYR().bgl() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dF("fid", PbFragment.this.kIh.getPbData().getForumId()).dF("tid", PbFragment.this.kIh.getPbData().getThreadId()).dF("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.kIh.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.kMf.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bg.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.bjf().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.kMf.ddU();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dbg() == 1 && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dF("fid", PbFragment.this.kIh.getPbData().getForumId()).dF("tid", PbFragment.this.kIh.getPbData().getThreadId()).dF("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dbg() == 1 && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dF("fid", PbFragment.this.kIh.getPbData().getForumId()).dF("tid", PbFragment.this.kIh.getPbData().getThreadId()).dF("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dbw();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dbx();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cZn() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.kIh.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dF("fid", pbData3.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.bkp().b(PbFragment.this.getPageContext(), new String[]{pbData3.cZn().cZz()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cZn() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.kIh.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dF("fid", pbData4.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.bkp().b(PbFragment.this.getPageContext(), new String[]{pbData4.cZn().cZz()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.kME >= 0) {
                                                                                        if (PbFragment.this.kIh != null) {
                                                                                            PbFragment.this.kIh.dcQ();
                                                                                        }
                                                                                        if (PbFragment.this.kIh != null && PbFragment.this.kMf.del() != null) {
                                                                                            PbFragment.this.kMf.del().a(PbFragment.this.kIh.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.kME = 0;
                                                                                        if (PbFragment.this.kIh != null) {
                                                                                            PbFragment.this.kMf.getListView().setSelection(PbFragment.this.kIh.dcT());
                                                                                            PbFragment.this.kIh.cX(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.EE(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.EG(8);
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
                                                                                    if (PbFragment.this.kMf.getListView() != null && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.kMf.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.kMf.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean cZr = PbFragment.this.kIh.getPbData().cZr();
                                                                                        boolean z9 = PbFragment.this.kMf.ddT() != null && PbFragment.this.kMf.ddT().bOo();
                                                                                        boolean deF = PbFragment.this.kMf.deF();
                                                                                        boolean z10 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (cZr && PbFragment.this.kMf.ddT() != null && PbFragment.this.kMf.ddT().bHA() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.kMf.ddT().dfz();
                                                                                            z10 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.kMf.ddT().bHA().getHeight() - PbFragment.this.kMf.ddT().dfz());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.Oa("c13568");
                                                                                        if ((PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().bfp() <= 0) || (deF && z10)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dbd();
                                                                                                if (PbFragment.this.kIh.getPbData().cYR().bfy() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dF("tid", PbFragment.this.kIh.kPr).dF("fid", PbFragment.this.kIh.getPbData().getForumId()).ai("obj_locate", 2).dF("uid", PbFragment.this.kIh.getPbData().cYR().bfy().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z11 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (cZr) {
                                                                                                if (PbFragment.this.kMf.kUu != null && PbFragment.this.kMf.kUu.kVz != null && PbFragment.this.kMf.kUu.kVz.getView() != null) {
                                                                                                    if (PbFragment.this.kMf.kUu.kVz.getView().getParent() == null) {
                                                                                                        z11 = firstVisiblePosition >= PbFragment.this.dbm();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.kMf.ddT() != null && PbFragment.this.kMf.ddT().bHA() != null) {
                                                                                                            i6 = PbFragment.this.kMf.ddT().bHA().getBottom();
                                                                                                        }
                                                                                                        z11 = PbFragment.this.kMf.kUu.kVz.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.kMf.dec() != null) {
                                                                                                z11 = PbFragment.this.kMf.dec().getVisibility() == 0;
                                                                                                if (!z11 && PbFragment.this.kMf.kUu != null && PbFragment.this.kMf.kUu.kVz != null && PbFragment.this.kMf.kUu.kVz.getView() != null && PbFragment.this.kMf.kUu.kVz.getView().getParent() != null && PbFragment.this.kMf.kTk != null && PbFragment.this.kMf.kTk.mNavigationBar != null) {
                                                                                                    z11 = PbFragment.this.kMf.kUu.kVz.getView().getTop() - PbFragment.this.kMf.kTk.mNavigationBar.getBottom() < PbFragment.this.kMf.kUu.kVz.kSJ.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z11 || deF) {
                                                                                                PbFragment.this.kLW = firstVisiblePosition;
                                                                                                PbFragment.this.kLX = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.kMf.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.kMf.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.kMf.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.kLW > 0) {
                                                                                                if (PbFragment.this.kMf.getListView().getChildAt(PbFragment.this.kLW) != null) {
                                                                                                    PbFragment.this.kMf.getListView().smoothScrollToPosition(PbFragment.this.kLW, PbFragment.this.kLX, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.kMf.getListView().setSelectionFromTop(PbFragment.this.kLW, PbFragment.this.kLX + equipmentHeight);
                                                                                                    PbFragment.this.kMf.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dbm = PbFragment.this.dbm();
                                                                                                if (PbFragment.this.dbl() != -1) {
                                                                                                    dbm--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dbm < 0) {
                                                                                                    i = PbFragment.this.kMf.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.kMf.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = dbm;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z9) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!cZr || PbFragment.this.kMf.ddT() == null) {
                                                                                                    if (PbFragment.this.kMf.kTk != null && PbFragment.this.kMf.kTk.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.kMf.kTk.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.kMf.ddT().dfy();
                                                                                                }
                                                                                                if (PbFragment.this.kMf.kUu == null || PbFragment.this.kMf.kUu.kVz == null || PbFragment.this.kMf.kUu.kVz.getView() == null || PbFragment.this.kMf.kUu.kVz.getView().getParent() == null) {
                                                                                                    PbFragment.this.kMf.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.kMf.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z9) {
                                                                                                    PbFragment.this.kMf.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.kMf.getListView().smoothScrollBy(PbFragment.this.kMf.kUu.kVz.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().bfy() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dF("tid", PbFragment.this.kIh.kPr).dF("fid", PbFragment.this.kIh.getPbData().getForumId()).ai("obj_locate", 2).dF("uid", PbFragment.this.kIh.getPbData().cYR().bfy().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.kIh.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.kIh.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.kIh.cZY()) || PbFragment.this.kIh.getAppealInfo() == null) {
                                                                                                PbFragment.this.kLA.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.kIh.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.kIh.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.kLA.finish();
                                                                                            return;
                                                                                        }
                                                                                        String cZY = PbFragment.this.kIh.cZY();
                                                                                        if (PbFragment.this.kIh.dci() && cZY != null && cZY.equals(name)) {
                                                                                            PbFragment.this.kLA.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.kIh.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dF("tid", PbFragment.this.kIh.dcf());
                                                                                        aqVar4.dF("fid", PbFragment.this.kIh.getForumId());
                                                                                        aqVar4.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.kIh.getPbData().cYR() != null) {
                                                                                            aqVar4.dF("nid", PbFragment.this.kIh.getPbData().cYR().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar = (bw) view.getTag();
                                                                                        if (PbFragment.this.kIh.dcP() == 3 && PbFragment.this.cZX() && PbFragment.this.kIh.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.kIh.getPbData().cZo())) {
                                                                                            PbFragment.this.kLA.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar.bfC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar5 = new com.baidu.tbadk.core.util.aq("c13399");
                                                                                        aqVar5.dF("tid", bwVar.getId());
                                                                                        aqVar5.u("fid", bwVar.getFid());
                                                                                        aqVar5.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar5.dF("nid", bwVar.getNid());
                                                                                        TiebaStatic.log(aqVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.kIh != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dF("tid", PbFragment.this.kIh.dcf());
                                                                                        aqVar6.dF("fid", PbFragment.this.kIh.getForumId());
                                                                                        aqVar6.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.ai("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.kIh.getPbData();
                                                                                        if (PbFragment.this.kMe == null) {
                                                                                            PbFragment.this.kMe = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").u("forum_id", j2).bki();
                                                                                        PbFragment.this.registerListener(PbFragment.this.kNg);
                                                                                        PbFragment.this.kMe.E(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dF("fid", PbFragment.this.kIh.getForumId()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("obj_name", smartApp.name).u("obj_id", smartApp.swan_app_id.longValue()).dF("obj_source", "PB_card").dF("tid", PbFragment.this.kIh.dcf()).ai("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar2 = (bw) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar2.bfC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dF("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 9).ai("obj_locate", 9).u("obj_id", bwVar2.getFid()).dF("tid", bwVar2.getId()).ai("thread_type", bwVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bw) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bw bwVar3 = (bw) view.getTag();
                                                                                        if (PbFragment.this.ezi != null) {
                                                                                            PbFragment.this.ezi.gd(bwVar3.bfC(), String.valueOf(bwVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dF("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 10).ai("obj_locate", 11).u("obj_id", bwVar3.getFid()).dF("tid", bwVar3.getId()).ai("thread_type", bwVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.kIh.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.kIh.dcf(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.kIh.getPbData().cYR().bfT())));
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
                                                                            if (PbFragment.this.kMk == null) {
                                                                                PbFragment.this.kMk = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.kMk.a(PbFragment.this.kNc);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z12 = PbFragment.this.dah().getPbData() != null && PbFragment.this.dah().getPbData().cZu();
                                                                            if (view != null && sparseArray != null) {
                                                                                boolean z13 = false;
                                                                                boolean z14 = false;
                                                                                boolean z15 = false;
                                                                                boolean z16 = false;
                                                                                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                                    z2 = false;
                                                                                } else {
                                                                                    z2 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z13 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                    z14 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z15 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                    z16 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                }
                                                                                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                                                                                }
                                                                                if (postData6.bhp() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bhp().hasAgree && postData6.bgZ() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.kMk);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.mTextView.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z14 && z13) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kMk);
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
                                                                                        if ((PbFragment.this.tc(z2) && TbadkCoreApplication.isLogin()) && !z12) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kMk);
                                                                                            gVar10.mTextView.setTag(str);
                                                                                            arrayList2.add(gVar10);
                                                                                        }
                                                                                    }
                                                                                    com.baidu.tbadk.core.dialog.g gVar11 = null;
                                                                                    if (z14) {
                                                                                        SparseArray sparseArray14 = new SparseArray();
                                                                                        sparseArray14.put(R.id.tag_should_manage_visible, true);
                                                                                        sparseArray14.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_post_id, str);
                                                                                        if (z15) {
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
                                                                                        if (z16) {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray14.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray14.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray14.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kMk);
                                                                                            gVar11.mTextView.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kMk);
                                                                                        gVar4.mTextView.setTag(sparseArray14);
                                                                                    } else {
                                                                                        if (z16) {
                                                                                            SparseArray sparseArray15 = new SparseArray();
                                                                                            sparseArray15.put(R.id.tag_should_manage_visible, false);
                                                                                            sparseArray15.put(R.id.tag_user_mute_visible, false);
                                                                                            sparseArray15.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray15.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                            sparseArray15.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray15.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray15.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            if (PbFragment.this.kIh.getPbData().cZg() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kMk);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kMk);
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
                                                                                PbFragment.this.kMk.aX(arrayList2);
                                                                                PbFragment.this.kMj = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kMk);
                                                                                PbFragment.this.kMj.NY();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.kMf.deI();
                                                                    SparseArray<Object> b3 = PbFragment.this.kMf.b(PbFragment.this.kIh.getPbData(), PbFragment.this.kIh.dch(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kIh.getPbData().getForum().getId(), PbFragment.this.kIh.getPbData().getForum().getName(), PbFragment.this.kIh.getPbData().cYR().getId(), String.valueOf(PbFragment.this.kIh.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).ai("obj_type", 0).ai("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).ai("obj_type", 1).ai("obj_source", 1));
                                                                }
                                                                PbFragment.this.kMf.kTk.dfO();
                                                            }
                                                        } else if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cYR() != null) {
                                                            PbFragment.this.kMf.kTk.aSz();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.NW(PbFragment.this.kIh.getPbData().cYR().bfP());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.kMf.deI();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.kIh.dcy()));
                                                                return;
                                                            }
                                                            PbFragment.this.cpE();
                                                            PbFragment.this.kMf.dep();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.kIh.getPbData().kFn == null || PbFragment.this.kIh.getPbData().kFn.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.kIh.getPbData().kFn.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.kIh.getPbData().kFn.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.kIh.getPbData().kFn.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.kIh.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.kIh.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.kIh.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.kIh.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").ai("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ai("obj_type", i10));
                                                                    if (PbFragment.this.kIh.getPbData().kFn != null && PbFragment.this.kIh.getPbData().kFn.size() > i9) {
                                                                        i9 = PbFragment.this.kIh.getPbData().kFn.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean EO = PbFragment.this.kIh.EO(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.kIh.dcy()));
                                                                    if (EO) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.kMf.tz(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.NY();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.kMf.deI();
                                                    if (PbFragment.this.dah().getPbData().kFo != 2) {
                                                        if (PbFragment.this.kIh.getPageData() != null) {
                                                            PbFragment.this.kMf.a(PbFragment.this.kIh.getPageData(), PbFragment.this.ksR);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.kIh.getPbData()) != null) {
                                                bw cYR = pbData.cYR();
                                                if (cYR != null && cYR.bfy() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dF("tid", PbFragment.this.kIh.kPr).dF("fid", pbData.getForumId()).ai("obj_locate", 4).dF("uid", cYR.bfy().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (cYR != null) {
                                                    if (cYR.beg()) {
                                                        i9 = 2;
                                                    } else if (cYR.beh()) {
                                                        i9 = 3;
                                                    } else if (cYR.bht()) {
                                                        i9 = 4;
                                                    } else if (cYR.bhu()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar7.dF("tid", PbFragment.this.kIh.dcf());
                                                aqVar7.dF("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar7.dF("fid", PbFragment.this.kIh.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar7.ai("obj_locate", 5);
                                                } else {
                                                    aqVar7.ai("obj_locate", 6);
                                                }
                                                aqVar7.ai("obj_name", i9);
                                                aqVar7.ai("obj_type", 1);
                                                if (cYR != null) {
                                                    if (cYR.beg()) {
                                                        aqVar7.ai("obj_type", 10);
                                                    } else if (cYR.beh()) {
                                                        aqVar7.ai("obj_type", 9);
                                                    } else if (cYR.bhu()) {
                                                        aqVar7.ai("obj_type", 8);
                                                    } else if (cYR.bht()) {
                                                        aqVar7.ai("obj_type", 7);
                                                    } else if (cYR.isShareThread) {
                                                        aqVar7.ai("obj_type", 6);
                                                    } else if (cYR.threadType == 0) {
                                                        aqVar7.ai("obj_type", 1);
                                                    } else if (cYR.threadType == 40) {
                                                        aqVar7.ai("obj_type", 2);
                                                    } else if (cYR.threadType == 49) {
                                                        aqVar7.ai("obj_type", 3);
                                                    } else if (cYR.threadType == 54) {
                                                        aqVar7.ai("obj_type", 4);
                                                    } else {
                                                        aqVar7.ai("obj_type", 5);
                                                    }
                                                    aqVar7.ai(IntentConfig.CARD_TYPE, cYR.bhx());
                                                    aqVar7.dF(IntentConfig.RECOM_SOURCE, cYR.mRecomSource);
                                                    aqVar7.dF("ab_tag", cYR.mRecomAbTag);
                                                    aqVar7.dF("weight", cYR.mRecomWeight);
                                                    aqVar7.dF("extra", cYR.mRecomExtra);
                                                    aqVar7.dF("nid", cYR.getNid());
                                                    if (cYR.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(cYR.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar7.dF("obj_param6", cYR.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar7.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dbM() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dbM(), aqVar7);
                                                }
                                                TiebaStatic.log(aqVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> cYT2 = PbFragment.this.kIh.getPbData().cYT();
                                                    if ((cYT2 != null && cYT2.size() > 0) || !PbFragment.this.kIh.dch()) {
                                                        PbFragment.this.kMf.deI();
                                                        PbFragment.this.cpE();
                                                        if (pbData.cZn() != null && !StringUtils.isNull(pbData.cZn().bdu(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dF("fid", PbFragment.this.kIh.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), cYR)) {
                                                            if (PbFragment.this.kMf != null) {
                                                                PbFragment.this.kMf.deL();
                                                                PbFragment.this.kMf.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.kMf.showLoadingDialog();
                                                                PbFragment.this.kIh.dcK().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.EF(i10);
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
                                            PbFragment.this.kMf.deI();
                                            if (PbFragment.this.kMf.kTk.dfP() != null && view == PbFragment.this.kMf.kTk.dfP().ddq() && !PbFragment.this.kMf.dfb()) {
                                                PbFragment.this.kMf.ddU();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cpE();
                                                PbFragment.this.kMf.dep();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    z3 = PbFragment.this.kIh.z(true, PbFragment.this.dbu());
                                                } else {
                                                    z3 = view.getId() == R.id.reply_title ? PbFragment.this.kIh.z(false, PbFragment.this.dbu()) : PbFragment.this.kIh.Ob(PbFragment.this.dbu());
                                                }
                                                view.setTag(Boolean.valueOf(z3));
                                                if (z3) {
                                                    PbFragment.this.kMf.sV(true);
                                                    PbFragment.this.kMf.cKd();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.kMf.tz(true);
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
                                        PbFragment.this.kMf.deI();
                                        if (PbFragment.this.EE(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.kIh.EP(PbFragment.this.kMf.deu()) != null) {
                                            PbFragment.this.dbp();
                                            if (PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().bfy() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dF("tid", PbFragment.this.kIh.kPr).dF("fid", PbFragment.this.kIh.getPbData().getForumId()).ai("obj_locate", 3).dF("uid", PbFragment.this.kIh.getPbData().cYR().bfy().getUserId()));
                                            }
                                            if (PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().bfy() != null && PbFragment.this.kIh.getPbData().cYR().bfy().getUserId() != null && PbFragment.this.kMd != null) {
                                                int h = PbFragment.this.h(PbFragment.this.kIh.getPbData());
                                                bw cYR2 = PbFragment.this.kIh.getPbData().cYR();
                                                int i11 = 1;
                                                if (cYR2.beg()) {
                                                    i11 = 2;
                                                } else if (cYR2.beh()) {
                                                    i11 = 3;
                                                } else if (cYR2.bht()) {
                                                    i11 = 4;
                                                } else if (cYR2.bhu()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dF("tid", PbFragment.this.kIh.kPr).ai("obj_locate", 1).dF("obj_id", PbFragment.this.kIh.getPbData().cYR().bfy().getUserId()).ai("obj_type", PbFragment.this.kMd.bbu() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i11));
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
                                    if (PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().bee() && PbFragment.this.kIh.getPbData().cYR().bfQ() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.kIh.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.kIh.cZY()) || PbFragment.this.kIh.getAppealInfo() == null) {
                                            PbFragment.this.kLA.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.kIh.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.kIh.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.kLA.finish();
                                        return;
                                    }
                                    String cZY2 = PbFragment.this.kIh.cZY();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.kIh.dci() && cZY2 != null && cZY2.equals(name2)) {
                                        PbFragment.this.kLA.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.kIh.getPbData() != null) {
                                    if ((PbFragment.this.kIh.getPbData().cZg() == 1 || PbFragment.this.kIh.getPbData().cZg() == 3) && !PbFragment.this.hrC.dBo()) {
                                        PbFragment.this.kMf.deI();
                                        int i12 = 0;
                                        if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddr()) {
                                            if (PbFragment.this.kMf.kTk.dfP() == null || view != PbFragment.this.kMf.kTk.dfP().ddt()) {
                                                if (view == PbFragment.this.kMf.den()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.kIh.getPbData().cYR().bfu() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.kIh.getPbData().cYR().bft() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.kIh.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.kIh.getPbData().cYR().getId();
                                        PbFragment.this.kMf.dem();
                                        PbFragment.this.hrC.b(id4, name3, id5, i12, PbFragment.this.kMf.deo());
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
                            PbFragment.this.kMf.kTk.dfO();
                            if (PbFragment.this.kIh != null) {
                                PbFragment.this.hrE.setThreadId(PbFragment.this.kIh.dcf());
                            }
                            int i13 = 1;
                            if (PbFragment.this.kIh == null || !PbFragment.this.kIh.isPrivacy()) {
                                PbFragment.this.hrE.ceJ();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dah() != null && PbFragment.this.dah().getPbData() != null && PbFragment.this.dah().getPbData().getThreadId() != null && PbFragment.this.dah().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.dah() != null && PbFragment.this.dah().getPbData() != null) {
                                    PbFragment.this.hrE.j(3, i13, PbFragment.this.dah().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dah() != null && PbFragment.this.dah().getPbData() != null) {
                                    PbFragment.this.hrE.j(3, 3, PbFragment.this.dah().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.kMf.deI();
                        PbFragment.this.cpE();
                        PbFragment.this.kMf.dep();
                        PbFragment.this.kMf.showLoadingDialog();
                        if (PbFragment.this.kMf.dec() != null) {
                            PbFragment.this.kMf.dec().setVisibility(8);
                        }
                        PbFragment.this.kIh.EJ(1);
                        if (PbFragment.this.kLC != null) {
                            PbFragment.this.kLC.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dbe = PbFragment.this.dbe();
                        if (!TextUtils.isEmpty(dbe)) {
                            com.baidu.tbadk.core.util.be.bkp().b(PbFragment.this.getPageContext(), new String[]{dbe});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar8.dF("tid", PbFragment.this.kIh.dcf());
                aqVar8.dF("fid", PbFragment.this.kIh.getForumId());
                aqVar8.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar8.ai("obj_locate", 1);
                TiebaStatic.log(aqVar8);
                if (PbFragment.this.kLL) {
                    PbFragment.this.kLL = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.daX().ddR() != null && postData7.bfy() != null && postData7.dAD() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.daX().ddS() != null) {
                                PbFragment.this.daX().ddS().daN();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.kIh.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.kIh.getPbData().cYR());
                            pVar2.g(postData7);
                            PbFragment.this.daX().ddR().d(pVar2);
                            PbFragment.this.daX().ddR().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.bfy().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kIh.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.kMr != null) {
                                PbFragment.this.kMf.tJ(PbFragment.this.kMr.btj());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener kNe = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kIh != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.kIh.kPr)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kIh.getPbData() != null) {
                    aqVar.dF("fid", PbFragment.this.kIh.getPbData().getForumId());
                }
                aqVar.dF("tid", PbFragment.this.kIh.dcf());
                aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.cpE();
            PbFragment.this.kMf.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.kIh.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.kIh.getPbData();
                            if (pbData != null && pbData.cYR() != null && pbData.cYR().bfy() != null && (userId = pbData.cYR().bfy().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.kIh.dcr()) {
                                PbFragment.this.kMf.dep();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.kIh.dcr()) {
                            PbFragment.this.kMf.dep();
                        }
                    } else if (floor != null) {
                        PbFragment.this.kMf.s(PbFragment.this.kIh.getPbData());
                    }
                    if (PbFragment.this.kIh.dcl()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dF("tid", PbFragment.this.kIh.dcf()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.tb(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.kMr.btq() || PbFragment.this.kMr.btr()) {
                    PbFragment.this.kMr.a(false, postWriteCallBackData);
                }
                PbFragment.this.jSk.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.jOf != null) {
                    PbFragment.this.jOf.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.zV(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zV(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bia();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d kNf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                    aqVar.dF("fid", PbFragment.this.kIh.getPbData().getForumId());
                }
                if (PbFragment.this.kIh != null) {
                    aqVar.dF("tid", PbFragment.this.kIh.dcf());
                }
                aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.jSk != null) {
                    PbFragment.this.jSk.dfh();
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
                if (PbFragment.this.jOf != null) {
                    PbFragment.this.jOf.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.zV(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zV(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bia();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.jSk != null) {
                if (PbFragment.this.kMf != null && PbFragment.this.kMf.ddS() != null && PbFragment.this.kMf.ddS().daR() != null && PbFragment.this.kMf.ddS().daR().btr()) {
                    PbFragment.this.kMf.ddS().daR().a(postWriteCallBackData);
                }
                PbFragment.this.jSk.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a kNg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dfe;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.kLA.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.kMf != null && (dfe = PbFragment.this.kMf.dfe()) != null && PbFragment.this.kMf.getListView() != null) {
                            PbFragment.this.kMf.getListView().removeHeaderView(dfe);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a kNh = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qo;
            if (!z || fVar == null || fVar.cZe() != null || com.baidu.tbadk.core.util.y.getCount(fVar.cYT()) >= 1) {
                PbFragment.this.khJ = true;
                PbFragment.this.kMf.der();
                if (fVar == null || !fVar.cYZ()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.kMf.getView());
                }
                PbFragment.this.kMf.cKc();
                if (PbFragment.this.isFullScreen || PbFragment.this.kMf.dfb()) {
                    PbFragment.this.kMf.deS();
                } else if (!PbFragment.this.kMf.deP()) {
                    PbFragment.this.kMf.tL(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.fww = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.kMf.getView());
                    PbFragment.this.kMf.deA();
                }
                if (z && fVar != null) {
                    bw cYR = fVar.cYR();
                    if (cYR == null || !cYR.bei()) {
                        PbFragment.this.d(PbFragment.this.kMq);
                    } else {
                        dbO();
                    }
                    PbFragment.this.kMf.ddS().setPbData(fVar);
                    PbFragment.this.kMf.bMD();
                    if (cYR != null && cYR.bgJ() != null) {
                        PbFragment.this.a(cYR.bgJ());
                    }
                    if (PbFragment.this.kMr != null) {
                        PbFragment.this.kMf.tJ(PbFragment.this.kMr.btj());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.cYT() != null && fVar.cYT().size() >= 1 && fVar.cYT().get(0) != null) {
                        PbFragment.this.kIh.Od(fVar.cYT().get(0).getId());
                    } else if (fVar.cZe() != null) {
                        PbFragment.this.kIh.Od(fVar.cZe().getId());
                    }
                    if (PbFragment.this.kMr != null) {
                        PbFragment.this.kMr.a(fVar.getAnti());
                        PbFragment.this.kMr.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.kMr.setThreadData(cYR);
                        PbFragment.this.kMr.a(PbFragment.this.kIh.dcv(), PbFragment.this.kIh.dcf(), PbFragment.this.kIh.dcM());
                        if (cYR != null) {
                            PbFragment.this.kMr.jr(cYR.bgV());
                        }
                    }
                    if (PbFragment.this.kMd != null) {
                        PbFragment.this.kMd.hy(fVar.bbu());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.cZu()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.kMf.tK(PbFragment.this.mIsFromCDN);
                    PbFragment.this.kMf.a(fVar, i2, i3, PbFragment.this.kIh.dch(), i4, PbFragment.this.kIh.getIsFromMark());
                    PbFragment.this.kMf.d(fVar, PbFragment.this.kIh.dch());
                    PbFragment.this.kMf.tH(PbFragment.this.kIh.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.ePo = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.ePo) && PbFragment.this.kMr != null && PbFragment.this.kMr.bsv() != null && (qo = PbFragment.this.kMr.bsv().qo(6)) != null && !TextUtils.isEmpty(PbFragment.this.ePo)) {
                            ((View) qo).setOnClickListener(PbFragment.this.eQa);
                        }
                    }
                    if (PbFragment.this.kMm) {
                        PbFragment.this.kMm = false;
                        final int dbl = PbFragment.this.dbl();
                        if (!fVar.cZr()) {
                            PbFragment.this.kMf.EW(dbl);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dbl, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.kMn) {
                        PbFragment.this.kMn = false;
                        final int dbl2 = PbFragment.this.dbl();
                        final boolean z2 = dbl2 != -1;
                        if (!z2) {
                            dbl2 = PbFragment.this.dbm();
                        }
                        if (PbFragment.this.kMf != null) {
                            if (!fVar.cZr()) {
                                PbFragment.this.kMf.EW(dbl2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dbl2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.kMf.setSelectionFromTop(dbl2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.kMf.setSelectionFromTop(dbl2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.kMf.tM(true);
                                PbFragment.this.kMf.tL(false);
                            }
                        }
                    } else if (PbFragment.this.kMo) {
                        PbFragment.this.kMo = false;
                        PbFragment.this.kMf.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.kMf.dev();
                    }
                    PbFragment.this.kIh.a(fVar.getForum(), PbFragment.this.kMS);
                    PbFragment.this.kIh.a(PbFragment.this.kMT);
                    if (PbFragment.this.jOf != null && cYR != null && cYR.bfy() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cYR.bfy());
                        PbFragment.this.jOf.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.fww && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.kIh.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.kIh.getAppealInfo().kFf)) {
                                    PbFragment.this.kMf.a(PbFragment.this.kIh.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.kMf.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.kMf.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.kMf.deS();
                            PbFragment.this.kMf.dez();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.kIh.dcf());
                            jSONObject.put("fid", PbFragment.this.kIh.getForumId());
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
                        PbFragment.this.kMf.Oj("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                            arrayList = PbFragment.this.kIh.getPbData().cYT();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dAD() != 1)) {
                            PbFragment.this.kMf.Oj(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dbF()) {
                                PbFragment.this.kMf.Ok(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.kMf.Ok(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.kMf.s(PbFragment.this.kIh.getPbData());
                        }
                    }
                    PbFragment.this.kMf.endLoadData();
                }
                if (fVar != null && fVar.kFu && PbFragment.this.eUN == 0) {
                    PbFragment.this.eUN = System.currentTimeMillis() - PbFragment.this.hCy;
                }
                if (!PbFragment.this.dah().dch() || PbFragment.this.dah().getPbData().getPage().bep() != 0 || PbFragment.this.dah().dcH()) {
                    PbFragment.this.kMs = true;
                    return;
                }
                return;
            }
            PbFragment.this.kIh.EJ(1);
            if (PbFragment.this.kLC != null) {
                PbFragment.this.kLC.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dbO() {
            if (PbFragment.this.kIh != null) {
                if (PbFragment.this.kMr == null || !PbFragment.this.kMr.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.kMr = (com.baidu.tbadk.editortools.pb.e) dVar.eb(PbFragment.this.getContext());
                    PbFragment.this.kMr.a(PbFragment.this.kLA.getPageContext());
                    PbFragment.this.kMr.a(PbFragment.this.ePy);
                    PbFragment.this.kMr.a(PbFragment.this.ePr);
                    PbFragment.this.kMr.a(PbFragment.this.kLA.getPageContext(), PbFragment.this.kLA.getIntent() == null ? null : PbFragment.this.kLA.getIntent().getExtras());
                    PbFragment.this.kMr.bsv().jh(true);
                    PbFragment.this.kMf.setEditorTools(PbFragment.this.kMr.bsv());
                    if (!PbFragment.this.kIh.dcm()) {
                        PbFragment.this.kMr.Cv(PbFragment.this.kIh.dcf());
                    }
                    if (PbFragment.this.kIh.dcN()) {
                        PbFragment.this.kMr.Ct(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.kMf != null) {
                        PbFragment.this.kMr.Ct(PbFragment.this.kMf.ddW());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.kMf.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.bvs().bvt()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.hCy : j;
                if (PbFragment.this.eUN == 0) {
                    PbFragment.this.eUN = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.eUE, PbFragment.this.createTime, PbFragment.this.eUN, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.eUE = 0L;
                if (iVar != null) {
                    iVar.bvp();
                }
                if (z2) {
                    iVar.eUW = currentTimeMillis;
                    iVar.jD(true);
                }
                if (!z2 && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cYR() != null) {
                    int threadType = PbFragment.this.kIh.getPbData().cYR().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.kLP, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.kLP, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.eUY = currentTimeMillis;
                                iVar2.qR(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.eUY = currentTimeMillis;
                        dVar.qR(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener kNi = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dbh();
            }
        }
    };
    private final a.InterfaceC0530a kNj = new a.InterfaceC0530a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0530a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.kMf.der();
            if (z) {
                if (PbFragment.this.kMd != null) {
                    PbFragment.this.kMd.hy(z2);
                }
                PbFragment.this.kIh.tq(z2);
                if (PbFragment.this.kIh.bbu()) {
                    PbFragment.this.dbq();
                } else {
                    PbFragment.this.kMf.s(PbFragment.this.kIh.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.kMd != null) {
                        if (PbFragment.this.kMd.bbx() != null && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.kIh.getPbData().cYR() != null && PbFragment.this.kIh.getPbData().cYR().bfy() != null) {
                            MarkData bbx = PbFragment.this.kMd.bbx();
                            MetaData bfy = PbFragment.this.kIh.getPbData().cYR().bfy();
                            if (bbx != null && bfy != null) {
                                if (!com.baidu.tbadk.core.util.at.equals(TbadkCoreApplication.getCurrentAccount(), bfy.getUserId()) && !bfy.hadConcerned()) {
                                    PbFragment.this.b(bfy);
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
                    PbFragment.this.dbn();
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
            if (!PbFragment.this.Eu(PbFragment.this.mLastScrollState) && PbFragment.this.Eu(i)) {
                if (PbFragment.this.kMf != null) {
                    PbFragment.this.kMf.deI();
                    if (PbFragment.this.kMr != null && !PbFragment.this.kMf.ddV()) {
                        PbFragment.this.kMf.tJ(PbFragment.this.kMr.btj());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.kMf.ddU();
                    }
                }
                if (!PbFragment.this.kLI) {
                    PbFragment.this.kLI = true;
                    if (PbFragment.this.kMf != null) {
                        PbFragment.this.kMf.deO();
                    }
                }
            }
            if (PbFragment.this.kMf != null) {
                PbFragment.this.kMf.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.kLC != null) {
                PbFragment.this.kLC.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.kLJ == null) {
                PbFragment.this.kLJ = new com.baidu.tbadk.n.b();
                PbFragment.this.kLJ.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.kLJ.bvj();
            } else {
                PbFragment.this.kLJ.bvi();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dzC().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cYT;
            if (PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null && PbFragment.this.kMf != null && PbFragment.this.kMf.del() != null) {
                PbFragment.this.kMf.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.kLC != null) {
                    PbFragment.this.kLC.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.kIh.dcD() && (cYT = PbFragment.this.kIh.getPbData().cYT()) != null && !cYT.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.kMf.del().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.kIh.getPbData();
                    if (pbData != null) {
                        if (pbData.cYU() != null && pbData.cYU().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cYV() != null && pbData.cYV().hasData()) {
                            headerCount--;
                        }
                        int size = cYT.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d hrJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.hrC.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.kIh.dcA();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.lby != 1002 || bVar.gkE) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.kMf.a(1, dVar.Qx, dVar.mro, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.hrC.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.kMf.a(PbFragment.this.hrC.getLoadDataMode(), gVar.Qx, gVar.mro, false);
                            PbFragment.this.kMf.aZ(gVar.mrr);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.kMf.a(PbFragment.this.hrC.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c kNk = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c fuf = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dbv()) {
                PbFragment.this.kLA.finish();
            }
            if (!PbFragment.this.kIh.tp(true)) {
                PbFragment.this.kMf.des();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e kNm = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.kNl && PbFragment.this.dbv()) {
                PbFragment.this.dbx();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.kMa && PbFragment.this.kMf != null && PbFragment.this.kMf.dfg() && PbFragment.this.kIh != null) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13999");
                    aqVar.dF("tid", PbFragment.this.kIh.dcf());
                    aqVar.dF("fid", PbFragment.this.kIh.getForumId());
                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    PbFragment.this.kMa = true;
                }
                if (PbFragment.this.kIh.to(false)) {
                    PbFragment.this.kMf.deq();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.kIh.getPbData() != null) {
                    PbFragment.this.kMf.deN();
                }
                PbFragment.this.kNl = true;
            }
        }
    };
    private int kNn = 0;
    private final TbRichTextView.i ffu = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g del;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.kMf.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dF("tid", PbFragment.this.kIh.dcf());
                aqVar.dF("fid", PbFragment.this.kIh.getForumId());
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.ai("obj_locate", 3);
                aqVar.ai("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.kIh.kJe.cZu()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().byH() != null) {
                            ArrayList<TbRichTextImageInfo> byH = tbRichTextView.getRichText().byH();
                            int i4 = 0;
                            while (i4 < byH.size()) {
                                if (byH.get(i4) != null) {
                                    arrayList.add(byH.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(byH.get(i4).getSrc()) || str.equals(byH.get(i4).bzc()) || str.equals(byH.get(i4).byZ()) || str.equals(byH.get(i4).bzb()) || str.equals(byH.get(i4).bzf()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = byH.get(i4).getSrc();
                                    imageUrlData.originalUrl = byH.get(i4).getSrc();
                                    imageUrlData.isLongPic = byH.get(i4).bzh();
                                    concurrentHashMap.put(byH.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).mX(i3).hF(false).hG(PbFragment.this.kIh.dcx()).a(concurrentHashMap).hH(true).hI(false).hJ(PbFragment.this.dbF()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.kIh != null) {
                            aVar.zq(PbFragment.this.kIh.getFromForumId());
                            if (PbFragment.this.kIh.getPbData() != null) {
                                aVar.s(PbFragment.this.kIh.getPbData().cYR());
                            }
                        }
                        ImageViewerConfig dO = aVar.dO(PbFragment.this.getPageContext().getPageActivity());
                        dO.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.kIq) {
                        TbRichText bv = PbFragment.this.bv(str, i);
                        if (bv != null && PbFragment.this.kNn >= 0 && PbFragment.this.kNn < bv.byG().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bv.byG().get(PbFragment.this.kNn));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.kIp.size()) {
                                    break;
                                } else if (!aVar2.kIp.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bv.getPostId() != 0 && (del = PbFragment.this.kMf.del()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = del.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bv.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bv.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.kIh.dcM(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kIh.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.dXc.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).zl(aVar2.forumName).zm(aVar2.forumId).zn(aVar2.threadId).hF(aVar2.dXa).hH(true).zo(aVar2.lastId).hG(PbFragment.this.kIh.dcx()).a(concurrentHashMap2).hI(false).hJ(PbFragment.this.dbF()).zp(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.kIh != null) {
                                aVar3.zq(PbFragment.this.kIh.getFromForumId());
                                if (PbFragment.this.kIh.getPbData() != null) {
                                    aVar3.s(PbFragment.this.kIh.getPbData().cYR());
                                }
                            }
                            ImageViewerConfig dO2 = aVar3.dO(PbFragment.this.getPageContext().getPageActivity());
                            dO2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.kIp, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.dXc.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).zl(aVar2.forumName).zm(aVar2.forumId).zn(aVar2.threadId).hF(aVar2.dXa).hH(true).zo(aVar2.kIp.get(0)).hG(PbFragment.this.kIh.dcx()).a(concurrentHashMap3).hI(false).hJ(PbFragment.this.dbF()).zp(aVar2.postId).hK(false);
                    if (PbFragment.this.kIh != null) {
                        aVar4.zq(PbFragment.this.kIh.getFromForumId());
                        if (PbFragment.this.kIh.getPbData() != null) {
                            aVar4.s(PbFragment.this.kIh.getPbData().cYR());
                        }
                    }
                    ImageViewerConfig dO3 = aVar4.dO(PbFragment.this.getPageContext().getPageActivity());
                    dO3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.kLT = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean kNo = false;
    PostData jds = null;
    private final b.InterfaceC0533b kNp = new b.InterfaceC0533b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jds != null) {
                if (i == 0) {
                    PbFragment.this.jds.fL(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.jds = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.jds);
                }
            }
        }
    };
    private final b.InterfaceC0533b kNq = new b.InterfaceC0533b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.kMB != null && !TextUtils.isEmpty(PbFragment.this.kMC)) {
                if (i == 0) {
                    if (PbFragment.this.kMD == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.kMC));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.kMC;
                        aVar.pkgId = PbFragment.this.kMD.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.kMD.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.dWg == null) {
                            PbFragment.this.dWg = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.dWg.j(PbFragment.this.kMC, PbFragment.this.kMB.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.kMB = null;
                PbFragment.this.kMC = null;
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
                if (PbFragment.this.kMf != null) {
                    if (!PbFragment.this.kMf.dbX()) {
                        PbFragment.this.kMf.dff();
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
                    if (PbFragment.this.cX(view)) {
                        if (view instanceof TbImageView) {
                            PbFragment.this.kMB = ((TbImageView) view).getBdImage();
                            PbFragment.this.kMC = ((TbImageView) view).getUrl();
                            if (PbFragment.this.kMB == null || TextUtils.isEmpty(PbFragment.this.kMC)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.kMD = null;
                            } else {
                                PbFragment.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else if (view instanceof GifView) {
                            if (((GifView) view).getBdImage() != null) {
                                PbFragment.this.kMB = ((GifView) view).getBdImage();
                                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                    PbFragment.this.kMC = ((GifView) view).getBdImage().getUrl();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    PbFragment.this.kMD = null;
                                } else {
                                    PbFragment.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                }
                            } else {
                                return true;
                            }
                        } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                            PbFragment.this.kMB = ((TbMemeImageView) view).getBdImage();
                            if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                                PbFragment.this.kMC = ((TbMemeImageView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.kMD = null;
                            } else {
                                PbFragment.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                            PbFragment.this.kMf.a(PbFragment.this.kNq, PbFragment.this.kMB.isGif());
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
                PbFragment.this.jds = (PostData) sparseArray2.get(R.id.tag_clip_board);
                if (PbFragment.this.jds == null) {
                    return true;
                }
                if (PbFragment.this.jds.dAD() != 1 || !PbFragment.this.cX(view)) {
                    if (PbFragment.this.kMd != null) {
                        if (!PbFragment.this.kMd.bbu() || PbFragment.this.jds.getId() == null || !PbFragment.this.jds.getId().equals(PbFragment.this.kIh.bfG())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        boolean z3 = PbFragment.this.dah().getPbData() != null && PbFragment.this.dah().getPbData().cZu();
                        if (PbFragment.this.jds.dAD() != 1) {
                            if (PbFragment.this.kMk == null) {
                                PbFragment.this.kMk = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                PbFragment.this.kMk.a(PbFragment.this.kNc);
                            }
                            ArrayList arrayList = new ArrayList();
                            if (view != null && sparseArray2 != null) {
                                boolean z4 = PbFragment.this.cX(view) && !z3;
                                boolean z5 = (!PbFragment.this.cX(view) || PbFragment.this.kMB == null || PbFragment.this.kMB.isGif()) ? false : true;
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
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.kMk));
                                }
                                if (z5) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.kMk));
                                }
                                if (!z4 && !z5) {
                                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kMk);
                                    SparseArray sparseArray3 = new SparseArray();
                                    sparseArray3.put(R.id.tag_clip_board, PbFragment.this.jds);
                                    gVar3.mTextView.setTag(sparseArray3);
                                    arrayList.add(gVar3);
                                }
                                if (!z2 && !z3) {
                                    if (z) {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kMk);
                                    } else {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kMk);
                                    }
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(R.id.tag_clip_board, PbFragment.this.jds);
                                    sparseArray4.put(R.id.tag_is_subpb, false);
                                    gVar2.mTextView.setTag(sparseArray4);
                                    arrayList.add(gVar2);
                                }
                                if (PbFragment.this.mIsLogin && !PbFragment.this.kJC) {
                                    if (!z8 && z7) {
                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kMk);
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
                                        if ((PbFragment.this.tc(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kMk);
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
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kMk);
                                            gVar6.mTextView.setTag(sparseArray6);
                                        } else {
                                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                                        }
                                        gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kMk);
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
                                            if (PbFragment.this.kIh.getPbData().cZg() == 1002 && !z6) {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kMk);
                                            } else {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kMk);
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
                                PbFragment.this.kMk.aX(arrayList);
                                PbFragment.this.kMj = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kMk);
                                PbFragment.this.kMj.NY();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dF("tid", PbFragment.this.kIh.kPr).dF("fid", PbFragment.this.kIh.getForumId()).dF("uid", PbFragment.this.kIh.getPbData().cYR().bfy().getUserId()).dF("post_id", PbFragment.this.kIh.bsX()).ai("obj_source", z2 ? 2 : 1));
                            }
                            return true;
                        }
                        if (!z3) {
                            PbFragment.this.kMf.a(PbFragment.this.kNp, z, false);
                        }
                        return true;
                    }
                    return true;
                }
                PbFragment.this.kMf.a(PbFragment.this.kNq, PbFragment.this.kMB.isGif());
                return true;
            }
            return true;
        }
    };
    private final NoNetworkView.a hXf = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bsQ && z && !PbFragment.this.kIh.dcn()) {
                PbFragment.this.dbs();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener eYy = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.ieU.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0671a hyK = new a.InterfaceC0671a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int gkk = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void H(int i, int i2) {
            if (al(i2) && PbFragment.this.kMf != null && PbFragment.this.kLC != null) {
                PbFragment.this.kLC.oH(true);
                if (Math.abs(i2) > this.gkk) {
                    PbFragment.this.kLC.hideFloatingView();
                }
                if (PbFragment.this.dbv()) {
                    PbFragment.this.kMf.dei();
                    PbFragment.this.kMf.dej();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void I(int i, int i2) {
            if (al(i2) && PbFragment.this.kMf != null && PbFragment.this.kLC != null) {
                PbFragment.this.kMf.deT();
                PbFragment.this.kLC.oH(false);
                PbFragment.this.kLC.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void J(int i, int i2) {
        }

        private boolean al(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final q.a kKE = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.kMf.Ol(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int kNs = -1;
    private int kNt = -1;

    /* loaded from: classes21.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes21.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e daS() {
        return this.kMr;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.cZH() != null) {
            String id = pVar.cZH().getId();
            ArrayList<PostData> cYT = this.kIh.getPbData().cYT();
            int i = 0;
            while (true) {
                if (i >= cYT.size()) {
                    z = true;
                    break;
                }
                PostData postData = cYT.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cZP = pVar.cZP();
                    postData.Ir(pVar.getTotalCount());
                    if (postData.dAA() == null || cZP == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = cZP.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bfy() != null && (metaData = postData.getUserMap().get(next.bfy().getUserId())) != null) {
                                next.a(metaData);
                                next.wn(true);
                                next.a(getPageContext(), this.kIh.Oc(metaData.getUserId()));
                            }
                        }
                        z = cZP.size() != postData.dAA().size();
                        if (postData.dAA() != null && postData.dAA().size() < 2) {
                            postData.dAA().clear();
                            postData.dAA().addAll(cZP);
                        }
                    }
                    if (postData.dAw() != null) {
                        postData.dAx();
                    }
                }
            }
            if (!this.kIh.getIsFromMark() && z) {
                this.kMf.s(this.kIh.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NU(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n cZj = this.kIh.getPbData().cZj();
            if (cZj != null && str.equals(cZj.getAdId())) {
                if (cZj.dAr() != null) {
                    cZj.dAr().legoCard = null;
                }
                this.kIh.getPbData().cZk();
            }
            com.baidu.tieba.tbadkCore.data.n dct = this.kIh.dct();
            if (dct != null && str.equals(dct.getAdId())) {
                this.kIh.dcu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kMj != null && this.kMj.isShowing()) {
                this.kMj.dismiss();
                this.kMj = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.kMj != null) {
                            PbFragment.this.kMj.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.kMf.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.kMz);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.kMz);
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
                kVar.aX(arrayList);
                this.kMj = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.kMj.NY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(int i) {
        bw cYR;
        if (this.kIh != null && this.kIh.getPbData() != null && (cYR = this.kIh.getPbData().cYR()) != null) {
            if (i == 1) {
                PraiseData bfj = cYR.bfj();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bfj == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cYR.a(praiseData);
                    } else {
                        cYR.bfj().getUser().add(0, metaData);
                        cYR.bfj().setNum(cYR.bfj().getNum() + 1);
                        cYR.bfj().setIsLike(i);
                    }
                }
                if (cYR.bfj() != null) {
                    if (cYR.bfj().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(cYR.bfj().getNum());
                    }
                }
            } else if (cYR.bfj() != null) {
                cYR.bfj().setIsLike(i);
                cYR.bfj().setNum(cYR.bfj().getNum() - 1);
                ArrayList<MetaData> user = cYR.bfj().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cYR.bfj().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cYR.bfj().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cYR.bfj().getNum() + "";
                }
            }
            if (this.kIh.dch()) {
                this.kMf.del().notifyDataSetChanged();
            } else {
                this.kMf.t(this.kIh.getPbData());
            }
        }
    }

    public static PbFragment daT() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.kLA = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kIh.aC(bundle);
        if (this.hZU != null) {
            this.hZU.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.kMr.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.kLH = System.currentTimeMillis();
        this.kMx = getPageContext();
        final Intent intent = this.kLA.getIntent();
        if (intent != null) {
            this.hCy = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.kLP = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.kLP)) {
                    this.kLP = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.kLP)) {
                this.kLD = true;
            }
            this.kNs = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.kNt = intent.getIntExtra("key_manga_next_chapter", -1);
            this.kNu = intent.getStringExtra("key_manga_title");
            this.kMm = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.kMn = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.kMo = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dbv()) {
                this.kLA.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.kMF = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.kLY = new bf();
            this.kLY.C(intent);
            this.kMH = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.kMH == 0) {
                this.kMH = intent.getIntExtra("key_start_from", 0);
            }
            this.kMI = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.hCy = System.currentTimeMillis();
        }
        this.eUE = this.kLH - this.hCy;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.kLF = 0;
        aB(bundle);
        if (this.kIh.getPbData() != null) {
            this.kIh.getPbData().NO(this.source);
        }
        daW();
        if (intent != null && this.kMf != null) {
            this.kMf.kTi = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.kMA == null) {
                    this.kMA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.kMf.On(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mX().postDelayed(this.kMA, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.kIh.getPbData() != null) {
                this.kIh.Of(stringExtra);
            }
        }
        this.hZU = new VoiceManager();
        this.hZU.onCreate(getPageContext());
        initData(bundle);
        this.kMq = new com.baidu.tbadk.editortools.pb.g();
        d(this.kMq);
        this.kMr = (com.baidu.tbadk.editortools.pb.e) this.kMq.eb(getActivity());
        this.kMr.a(this.kLA.getPageContext());
        this.kMr.a(this.ePy);
        this.kMr.a(this.ePr);
        this.kMr.setFrom(1);
        this.kMr.a(this.kLA.getPageContext(), bundle);
        this.kMr.bsv().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.kMr.bsv().jh(true);
        ta(true);
        this.kMr.a(this.kIh.dcv(), this.kIh.dcf(), this.kIh.dcM());
        registerListener(this.kMN);
        if (!this.kIh.dcm()) {
            this.kMr.Cv(this.kIh.dcf());
        }
        if (this.kIh.dcN()) {
            this.kMr.Ct(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.kMf != null) {
            this.kMr.Ct(this.kMf.ddW());
        }
        registerListener(this.kMM);
        registerListener(this.kMO);
        registerListener(this.kMP);
        registerListener(this.ibA);
        registerListener(this.kNb);
        registerListener(this.kML);
        this.kMp = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.moa);
        this.kMp.dAj();
        registerListener(this.kMQ);
        registerListener(this.ena);
        this.kIh.dcF();
        registerListener(this.kNi);
        registerListener(this.ibI);
        registerListener(this.kNe);
        if (this.kMf != null && this.kMf.deX() != null && this.kMf.deY() != null) {
            this.kLC = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.kMf.deX(), this.kMf.deY(), this.kMf.dec());
            this.kLC.a(this.kMW);
        }
        if (this.kLB && this.kMf != null && this.kMf.deY() != null) {
            this.kMf.deY().setVisibility(8);
        }
        this.kMy = new com.baidu.tbadk.core.view.c();
        this.kMy.toastTime = 1000L;
        registerListener(this.kNa);
        registerListener(this.kMY);
        registerListener(this.kMZ);
        registerListener(this.iuE);
        registerListener(this.ibw);
        this.kMR.setSelfListener(true);
        this.kMR.setTag(this.kLA.getUniqueId());
        this.kMR.setPriority(-1);
        MessageManager.getInstance().registerListener(this.kMR);
        registerResponsedEventListener(TipEvent.class, this.hYY);
        this.kMz = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.kMz;
        userMuteAddAndDelCustomMessage.setTag(this.kMz);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.kMz;
        userMuteCheckCustomMessage.setTag(this.kMz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kIh.dcK().a(this.kMX);
        this.jSk = new bb();
        if (this.kMr.btb() != null) {
            this.jSk.e(this.kMr.btb().getInputView());
        }
        this.kMr.a(this.ePs);
        this.itk = new ShareSuccessReplyToServerModel();
        a(this.kMJ);
        this.jOf = new com.baidu.tbadk.core.util.am(getPageContext());
        this.jOf.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.emR) {
                        PbFragment.this.kMr.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.emS && PbFragment.this.kMf != null && PbFragment.this.kMf.ddS() != null && PbFragment.this.kMf.ddS().daR() != null) {
                        PbFragment.this.kMf.ddS().daR().btz();
                    } else if (i == com.baidu.tbadk.core.util.am.emT) {
                        PbFragment.this.c(PbFragment.this.kMu);
                    }
                }
            }
        });
        this.kMc = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.kMc.w(getUniqueId());
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
        com.baidu.tbadk.core.business.a.bcS().dt("3", "");
        this.hrE = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.kLH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.kIh != null) {
            gVar.setForumName(this.kIh.cZY());
            if (this.kIh.getPbData() != null && this.kIh.getPbData().getForum() != null) {
                gVar.a(this.kIh.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.kIh);
        }
    }

    public String daU() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b daV() {
        return this.kLC;
    }

    private void ta(boolean z) {
        this.kMr.jo(z);
        this.kMr.jp(z);
        this.kMr.jq(z);
    }

    private void daW() {
        this.ezi = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hZU != null) {
            this.hZU.onStart(getPageContext());
        }
    }

    public az daX() {
        return this.kMf;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dah() {
        return this.kIh;
    }

    public void NV(String str) {
        if (this.kIh != null && !StringUtils.isNull(str) && this.kMf != null) {
            this.kMf.tO(true);
            this.kIh.NV(str);
            this.kLN = true;
            this.kMf.deI();
            this.kMf.deS();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bsQ = false;
        } else {
            this.bsQ = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.kLF = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.kLF == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.hZU != null) {
            this.hZU.onPause(getPageContext());
        }
        if (this.kMf != null) {
            this.kMf.onPause();
        }
        if (!this.kIh.dcm()) {
            this.kMr.Cu(this.kIh.dcf());
        }
        if (this.kIh != null) {
            this.kIh.dcG();
        }
        com.baidu.tbadk.BdToken.c.aZe().aZp();
        MessageManager.getInstance().unRegisterListener(this.jpv);
        cDk();
        MessageManager.getInstance().unRegisterListener(this.kMY);
        MessageManager.getInstance().unRegisterListener(this.kMZ);
        MessageManager.getInstance().unRegisterListener(this.kNa);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean daY() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.kIh.getPbData(), this.kIh.dch(), this.kIh.dcE());
        return (a2 == null || a2.bfy() == null || a2.bfy().getGodUserData() == null || a2.bfy().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bsQ = false;
        super.onResume();
        if (this.kLR) {
            this.kLR = false;
            dbB();
        }
        if (daY()) {
            this.kLK = System.currentTimeMillis();
        } else {
            this.kLK = -1L;
        }
        if (this.kMf != null && this.kMf.getView() != null) {
            if (!this.khJ) {
                dbt();
            } else {
                hideLoadingView(this.kMf.getView());
            }
            this.kMf.onResume();
        }
        if (this.kLF == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.kMf != null) {
            noNetworkView = this.kMf.ddP();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.hZU != null) {
            this.hZU.onResume(getPageContext());
        }
        registerListener(this.jpv);
        this.kMl = false;
        dbA();
        registerListener(this.kMY);
        registerListener(this.kMZ);
        registerListener(this.kNa);
        if (this.iaJ) {
            dbs();
            this.iaJ = false;
        }
        dbI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.kMf.tD(z);
        if (this.kMj != null) {
            this.kMj.dismiss();
        }
        if (z && this.kMl) {
            this.kMf.deq();
            this.kIh.to(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.kLK > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dF("obj_duration", (System.currentTimeMillis() - this.kLK) + ""));
            this.kLK = 0L;
        }
        if (daX().ddS() != null) {
            daX().ddS().onStop();
        }
        if (this.kMf.kTk != null && !this.kMf.kTk.dfR()) {
            this.kMf.kTk.releaseResources();
        }
        if (this.kIh != null && this.kIh.getPbData() != null && this.kIh.getPbData().getForum() != null && this.kIh.getPbData().cYR() != null) {
            com.baidu.tbadk.distribute.a.bsi().b(getPageContext().getPageActivity(), "pb", this.kIh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kIh.getPbData().cYR().getId(), 0L));
        }
        if (this.hZU != null) {
            this.hZU.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.kLZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dF("fid", this.kIh.getPbData().getForumId());
            aqVar.dF("tid", this.kIh.dcf());
            aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.kLI && this.kMf != null) {
            this.kLI = true;
            this.kMf.deO();
            a(false, (PostData) null);
        }
        if (this.kIh != null) {
            this.kIh.cancelLoadData();
            this.kIh.destory();
            if (this.kIh.dcJ() != null) {
                this.kIh.dcJ().onDestroy();
            }
        }
        if (this.kMr != null) {
            this.kMr.onDestroy();
        }
        if (this.hrC != null) {
            this.hrC.cancelLoadData();
        }
        if (this.ezi != null) {
            this.ezi.dzW();
        }
        if (this.kMf != null) {
            this.kMf.onDestroy();
            if (this.kMf.kTk != null) {
                this.kMf.kTk.releaseResources();
            }
        }
        if (this.kLJ != null) {
            this.kLJ.bvk();
        }
        if (this.kLC != null) {
            this.kLC.crw();
        }
        super.onDestroy();
        if (this.hZU != null) {
            this.hZU.onDestory(getPageContext());
        }
        if (this.kMf != null) {
            this.kMf.deI();
        }
        MessageManager.getInstance().unRegisterListener(this.kMY);
        MessageManager.getInstance().unRegisterListener(this.kMZ);
        MessageManager.getInstance().unRegisterListener(this.kNa);
        MessageManager.getInstance().unRegisterListener(this.kMz);
        MessageManager.getInstance().unRegisterListener(this.kNb);
        MessageManager.getInstance().unRegisterListener(this.ibI);
        MessageManager.getInstance().unRegisterListener(this.iuE);
        MessageManager.getInstance().unRegisterListener(this.kNg);
        MessageManager.getInstance().unRegisterListener(this.kMR);
        this.kMx = null;
        this.kMy = null;
        com.baidu.tieba.recapp.d.a.drI().drL();
        if (this.kMA != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.kMA);
        }
        if (this.kLS != null) {
            this.kLS.cancelLoadData();
        }
        if (this.kMf != null && this.kMf.kTk != null) {
            this.kMf.kTk.dfU();
        }
        if (this.itk != null) {
            this.itk.cancelLoadData();
        }
        this.jSk.onDestroy();
        if (this.kIh != null && this.kIh.dcL() != null) {
            this.kIh.dcL().onDestroy();
        }
        if (this.jOf != null) {
            this.jOf.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g del;
        ArrayList<PostData> daD;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bnm() && this.kMf != null && (del = this.kMf.del()) != null && (daD = del.daD()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = daD.iterator();
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
                        bVar.htF = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eeM == 1 && !TextUtils.isEmpty(id)) {
                    next.eeM = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.htF = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.kIh == null || this.kIh.getPbData() == null || this.kIh.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.kIh.getPbData().getForum().getFirst_class();
                    str2 = this.kIh.getPbData().getForum().getSecond_class();
                    str = this.kIh.getPbData().getForum().getId();
                    str4 = this.kIh.dcf();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.bnp());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.kMf.onChangeSkinType(i);
            if (this.kMr != null && this.kMr.bsv() != null) {
                this.kMr.bsv().onChangeSkinType(i);
            }
            if (this.kMf.ddP() != null) {
                this.kMf.ddP().onChangeSkinType(getPageContext(), i);
            }
            this.jSk.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
            cpE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kMf = new az(this, this.icH, this.eHq);
        this.ieU = new com.baidu.tieba.f.b(getActivity());
        this.ieU.a(kNr);
        this.ieU.a(this.hyK);
        this.kMf.setOnScrollListener(this.mOnScrollListener);
        this.kMf.d(this.kNm);
        this.kMf.setListPullRefreshListener(this.fuf);
        this.kMf.sM(com.baidu.tbadk.core.k.bcG().isShowImages());
        this.kMf.setOnImageClickListener(this.ffu);
        this.kMf.b(this.mOnLongClickListener);
        this.kMf.g(this.hXf);
        this.kMf.a(this.kNk);
        this.kMf.tD(this.mIsLogin);
        if (this.kLA.getIntent() != null) {
            this.kMf.tP(this.kLA.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.kMf.ddR().setFromForumId(this.kIh.getFromForumId());
        this.kMf.setEditorTools(this.kMr.bsv());
        this.kMr.Ct(this.kMf.ddW());
        this.kMf.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.kIh.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kIh.getPbData().getForum().getId(), PbFragment.this.kIh.getPbData().getForum().getName(), PbFragment.this.kIh.getPbData().cYR().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.kMf.tQ(this.kIh.dck());
        this.kMf.EQ(this.kIh.dcP());
        return this.kMf.getView();
    }

    public void daZ() {
        if (this.kMf != null && this.kIh != null) {
            if ((this.kIh.getPbData() != null || this.kIh.getPbData().cZq() != null) && checkUpIsLogin() && this.kMf.del() != null && this.kMf.del().daI() != null) {
                this.kMf.del().daI().Bb(this.kIh.dcf());
            }
        }
    }

    public void dba() {
        TiebaStatic.log("c12181");
        if (this.kMf != null && this.kIh != null) {
            if ((this.kMf == null || this.kMf.ddV()) && this.kIh.getPbData() != null && this.kIh.getPbData().cZq() != null) {
                com.baidu.tieba.pb.data.o cZq = this.kIh.getPbData().cZq();
                if (checkUpIsLogin()) {
                    if ((!cZq.cZJ() || cZq.bgZ() != 2) && this.kMf.del() != null && this.kMf.del().daI() != null) {
                        this.kMf.del().daI().Bb(this.kIh.dcf());
                    }
                    if (System.currentTimeMillis() - this.kLM > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).uy(false);
                        this.kLM = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cV(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.edx && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bcG().isShowImages()) {
                    return NY(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.kIh == null || this.kIh.getPbData() == null) {
                        return true;
                    }
                    if (daX().ddS() != null) {
                        daX().ddS().daN();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.kIh.getPbData().getForum());
                    pVar.setThreadData(this.kIh.getPbData().cYR());
                    pVar.g(postData);
                    daX().ddR().d(pVar);
                    daX().ddR().setPostId(postData.getId());
                    a(view, postData.bfy().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.kMr != null) {
                        this.kMf.tJ(this.kMr.btj());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dbb() {
        if (this.kLG == null) {
            this.kLG = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.kLG.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0533b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.kId = PbFragment.this.kId.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kId);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kIh.dcf(), PbFragment.this.kId, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.kId = PbFragment.this.kId.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kId);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kIh.dcf(), PbFragment.this.kId, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.kId = PbFragment.this.kId.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kId);
                        bVar.dismiss();
                    }
                }
            }).nK(b.a.BOTTOM_TO_TOP).nL(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.kNh.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).dhU(), "", 1);
    }

    private void aB(Bundle bundle) {
        this.kIh = this.kLA.dah();
        if (this.kIh.dcI() != null) {
            this.kIh.dcI().a(this.kKE);
        }
        if (this.kIh.dcJ() != null) {
            this.kIh.dcJ().b(this.kMK);
        }
        if (StringUtils.isNull(this.kIh.dcf())) {
            this.kLA.finish();
        } else if ("from_tieba_kuang".equals(this.kLP) && this.kLP != null) {
            this.kIh.EQ(6);
        }
    }

    private void initData(Bundle bundle) {
        this.kMd = com.baidu.tbadk.baseEditMark.a.a(this.kLA);
        if (this.kMd != null) {
            this.kMd.a(this.kNj);
        }
        this.hrC = new ForumManageModel(this.kLA);
        this.hrC.setLoadDataCallBack(this.hrJ);
        this.emW = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kMV.setUniqueId(getUniqueId());
        this.kMV.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.kMf.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.kMz;
        userMuteCheckCustomMessage.setTag(this.kMz);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean dbc() {
        if (this.kIh == null || this.kIh.getPbData() == null) {
            return false;
        }
        bw cYR = this.kIh.getPbData().cYR();
        this.kIh.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cYR);
    }

    public void dbd() {
        if (checkUpIsLogin() && this.kIh != null && this.kIh.getPbData() != null && this.kIh.getPbData().getForum() != null && !dbc()) {
            if (this.kIh.getPbData().cZu()) {
                this.kMf.cCL();
                return;
            }
            if (this.ieu == null) {
                this.ieu = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.ieu.yQ(0);
                this.ieu.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void oC(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void oD(boolean z) {
                        if (z) {
                            if (PbFragment.this.kMr != null && PbFragment.this.kMr.bsv() != null) {
                                PbFragment.this.kMr.bsv().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.kMf.cCL();
                        }
                    }
                });
            }
            this.ieu.D(this.kIh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kIh.dcf(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dbe() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.kIh == null || (pbData = this.kIh.getPbData()) == null) {
            return null;
        }
        return pbData.cZf().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cYR() != null) {
            if (fVar.cYR().getThreadType() == 0) {
                return 1;
            }
            if (fVar.cYR().getThreadType() == 54) {
                return 2;
            }
            if (fVar.cYR().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dbc() && dbf()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kLU);
                this.kLV = ((View) view.getParent()).getMeasuredHeight();
            }
            if (daX().ddS() != null && postData != null) {
                String str3 = "";
                if (postData.dAF() != null) {
                    str3 = postData.dAF().toString();
                }
                daX().ddS().NT(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bfy().getName_show(), str3));
            }
            if (this.kIh.getPbData() != null && this.kIh.getPbData().cZu()) {
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.kLA.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.daX().getListView().smoothScrollBy((PbFragment.this.kLU[1] + PbFragment.this.kLV) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.daX().ddS() != null) {
                            PbFragment.this.kMr.bsv().setVisibility(8);
                            PbFragment.this.daX().ddS().h(str, str2, PbFragment.this.daX().ddW(), (PbFragment.this.kIh == null || PbFragment.this.kIh.getPbData() == null || PbFragment.this.kIh.getPbData().cYR() == null || !PbFragment.this.kIh.getPbData().cYR().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h daR = PbFragment.this.daX().ddS().daR();
                            if (daR != null && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                daR.a(PbFragment.this.kIh.getPbData().getAnti());
                                daR.setThreadData(PbFragment.this.kIh.getPbData().cYR());
                            }
                            if (PbFragment.this.jSk.dfl() == null && PbFragment.this.daX().ddS().daR().btH() != null) {
                                PbFragment.this.daX().ddS().daR().btH().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jSk != null && PbFragment.this.jSk.dfk() != null) {
                                            if (!PbFragment.this.jSk.dfk().dJA()) {
                                                PbFragment.this.jSk.tS(false);
                                            }
                                            PbFragment.this.jSk.dfk().xj(false);
                                        }
                                    }
                                });
                                PbFragment.this.jSk.f(PbFragment.this.daX().ddS().daR().btH().getInputView());
                                PbFragment.this.daX().ddS().daR().a(PbFragment.this.kMw);
                            }
                        }
                        PbFragment.this.daX().deS();
                    }
                }, 0L);
                return;
            }
            if (this.kMt == null) {
                this.kMt = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kMt.yQ(1);
                this.kMt.a(new AnonymousClass39(str, str2));
            }
            if (this.kIh != null && this.kIh.getPbData() != null && this.kIh.getPbData().getForum() != null) {
                this.kMt.D(this.kIh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kIh.dcf(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes21.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String kNB;
        final /* synthetic */ String kNC;

        AnonymousClass39(String str, String str2) {
            this.kNB = str;
            this.kNC = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void oC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void oD(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.daX().getListView().smoothScrollBy((PbFragment.this.kLU[1] + PbFragment.this.kLV) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.daX().ddS() != null) {
                            PbFragment.this.kMr.bsv().setVisibility(8);
                            PbFragment.this.daX().ddS().h(AnonymousClass39.this.kNB, AnonymousClass39.this.kNC, PbFragment.this.daX().ddW(), (PbFragment.this.kIh == null || PbFragment.this.kIh.getPbData() == null || PbFragment.this.kIh.getPbData().cYR() == null || !PbFragment.this.kIh.getPbData().cYR().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h daR = PbFragment.this.daX().ddS().daR();
                            if (daR != null && PbFragment.this.kIh != null && PbFragment.this.kIh.getPbData() != null) {
                                daR.a(PbFragment.this.kIh.getPbData().getAnti());
                                daR.setThreadData(PbFragment.this.kIh.getPbData().cYR());
                            }
                            if (PbFragment.this.jSk.dfl() == null && PbFragment.this.daX().ddS().daR().btH() != null) {
                                PbFragment.this.daX().ddS().daR().btH().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jSk != null && PbFragment.this.jSk.dfk() != null) {
                                            if (!PbFragment.this.jSk.dfk().dJA()) {
                                                PbFragment.this.jSk.tS(false);
                                            }
                                            PbFragment.this.jSk.dfk().xj(false);
                                        }
                                    }
                                });
                                PbFragment.this.jSk.f(PbFragment.this.daX().ddS().daR().btH().getInputView());
                                PbFragment.this.daX().ddS().daR().a(PbFragment.this.kMw);
                            }
                        }
                        PbFragment.this.daX().deS();
                    }
                }, 0L);
            }
        }
    }

    public boolean dbf() {
        if ((this.kIh.getPbData() != null && this.kIh.getPbData().cZu()) || this.jOf == null || this.kIh.getPbData() == null || this.kIh.getPbData().getAnti() == null) {
            return true;
        }
        return this.jOf.ob(this.kIh.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean ED(int i) {
        if (this.jOf == null || this.kIh.getPbData() == null || this.kIh.getPbData().getAnti() == null) {
            return true;
        }
        return this.jOf.aN(this.kIh.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.kIh != null && this.kIh.getPbData() != null && postData.dAD() != 1) {
            String dcf = this.kIh.dcf();
            String id = postData.getId();
            int i = 0;
            if (this.kIh.getPbData() != null) {
                i = this.kIh.getPbData().cZg();
            }
            PbActivity.a NZ = NZ(id);
            if (NZ != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dcf, id, "pb", true, null, false, null, i, postData.dgO(), this.kIh.getPbData().getAnti(), false, postData.bfy() != null ? postData.bfy().getIconInfo() : null).addBigImageData(NZ.kIp, NZ.dXc, NZ.dXa, NZ.index);
                addBigImageData.setKeyPageStartFrom(this.kIh.dcP());
                addBigImageData.setFromFrsForumId(this.kIh.getFromForumId());
                addBigImageData.setKeyFromForumId(this.kIh.getForumId());
                addBigImageData.setBjhData(this.kIh.dco());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dbg() {
        if (this.kIh.getPbData() == null || this.kIh.getPbData().cYR() == null) {
            return -1;
        }
        return this.kIh.getPbData().cYR().bgl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dah() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dah().Oe(postWriteCallBackData.getPostId());
            this.kME = this.kMf.ddY();
            this.kIh.cX(this.kME, this.kMf.ddZ());
        }
        this.kMf.deI();
        this.jSk.dfi();
        if (this.kMr != null) {
            this.kMf.tJ(this.kMr.btj());
        }
        this.kMf.ddQ();
        this.kMf.tL(true);
        this.kIh.dcA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(boolean z) {
        if (this.kIh != null && this.kIh.kJe != null && this.kIh.kJe.cYR() != null) {
            bw cYR = this.kIh.kJe.cYR();
            cYR.mRecomAbTag = this.kIh.dda();
            cYR.mRecomWeight = this.kIh.dcY();
            cYR.mRecomSource = this.kIh.dcZ();
            cYR.mRecomExtra = this.kIh.ddb();
            if (cYR.getFid() == 0) {
                cYR.setFid(com.baidu.adp.lib.f.b.toLong(this.kIh.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cYR, "c13563");
            TbPageTag en = com.baidu.tbadk.pageInfo.c.en(getContext());
            if (en != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(en.locatePage)) {
                a2.dF("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dF("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (en != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(en.locatePage)) {
                a2.dF("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dF("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.ai("reply_type", 1);
                if (z) {
                    a2.ai("obj_type", 2);
                } else {
                    a2.ai("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbh() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Qx(this.kIh.getForumId()) && this.kIh.getPbData() != null && this.kIh.getPbData().getForum() != null) {
            if (this.kIh.getPbData().getForum().isLike() == 1) {
                this.kIh.dcL().fW(this.kIh.getForumId(), this.kIh.dcf());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tc(boolean z) {
        if (this.kIh == null || this.kIh.getPbData() == null) {
            return false;
        }
        return ((this.kIh.getPbData().cZg() != 0) || this.kIh.getPbData().cYR() == null || this.kIh.getPbData().cYR().bfy() == null || TextUtils.equals(this.kIh.getPbData().cYR().bfy().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean td(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ab abVar;
        if (this.kIh == null || this.kIh.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.kIh.getPbData();
        bw cYR = pbData.cYR();
        if (cYR != null) {
            if (cYR.beg() || cYR.beh()) {
                return false;
            }
            if (cYR.bht() || cYR.bhu()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cZg() != 0) {
                return pbData.cZg() != 3;
            }
            List<bs> cZo = pbData.cZo();
            if (com.baidu.tbadk.core.util.y.getCount(cZo) > 0) {
                for (bs bsVar : cZo) {
                    if (bsVar != null && (abVar = bsVar.ecI) != null && abVar.eau && !abVar.eav && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean te(boolean z) {
        if (z || this.kIh == null || this.kIh.getPbData() == null) {
            return false;
        }
        return ((this.kIh.getPbData().getForum() != null && this.kIh.getPbData().getForum().isBlockBawuDelete) || this.kIh.getPbData().cZg() == 0 || this.kIh.getPbData().cZg() == 3) ? false : true;
    }

    public void dbi() {
        com.baidu.tieba.pb.data.f pbData;
        bw cYR;
        boolean z = true;
        if (this.kIh != null && this.kIh.getPbData() != null && (cYR = (pbData = this.kIh.getPbData()).cYR()) != null && cYR.bfy() != null) {
            this.kMf.ddQ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cYR.bfy().getUserId());
            ak akVar = new ak();
            int cZg = this.kIh.getPbData().cZg();
            if (cZg == 1 || cZg == 3) {
                akVar.kRy = true;
                akVar.kRx = true;
                akVar.kRD = cYR.bft() == 1;
                akVar.kRC = cYR.bfu() == 1;
            } else {
                akVar.kRy = false;
                akVar.kRx = false;
            }
            if (cZg == 1002 && !equals) {
                akVar.kRE = true;
            }
            akVar.kRv = td(equals);
            akVar.kRz = dbj();
            akVar.kRw = te(equals);
            akVar.EK = this.kIh.dch();
            akVar.kRs = true;
            akVar.kRr = tc(equals);
            akVar.kRq = equals && this.kMf.dex();
            akVar.kRB = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.kRA = true;
            akVar.isHostOnly = this.kIh.getHostMode();
            akVar.kRu = true;
            if (cYR.bfQ() == null) {
                akVar.kRt = true;
            } else {
                akVar.kRt = false;
            }
            if (pbData.cZu()) {
                akVar.kRs = false;
                akVar.kRu = false;
                akVar.kRt = false;
                akVar.kRx = false;
                akVar.kRy = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cZu()) {
                z = false;
            }
            akVar.kRF = z;
            this.kMf.kTk.a(akVar);
        }
    }

    private boolean dbj() {
        if (this.kIh != null && this.kIh.dch()) {
            return this.kIh.getPageData() == null || this.kIh.getPageData().bep() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(View view) {
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
    public PbModel.a dbk() {
        return this.kNh;
    }

    public int dbl() {
        if (daX() == null || daX().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = daX().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).Vf == com.baidu.tieba.pb.data.n.kGD) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dbm() {
        if (daX() == null || daX().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = daX().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.moB) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dbs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbn() {
        if (this.kIh != null && this.kIh.kJe != null && this.kIh.kJe.cYR() != null) {
            bw cYR = this.kIh.kJe.cYR();
            cYR.mRecomAbTag = this.kIh.dda();
            cYR.mRecomWeight = this.kIh.dcY();
            cYR.mRecomSource = this.kIh.dcZ();
            cYR.mRecomExtra = this.kIh.ddb();
            if (cYR.getFid() == 0) {
                cYR.setFid(com.baidu.adp.lib.f.b.toLong(this.kIh.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cYR, "c13562");
            TbPageTag en = com.baidu.tbadk.pageInfo.c.en(getContext());
            if (en != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(en.locatePage)) {
                a2.dF("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dF("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (en != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(en.locatePage)) {
                a2.dF("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dF("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
            aVar.zU(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.zV(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.id(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dF("obj_id", metaData.getUserId()).ai("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dF("obj_id", metaData.getUserId()).ai("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.emW.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.kIh.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bia();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.kMf.der();
        this.kIh.tq(z);
        if (this.kMd != null) {
            this.kMd.hy(z);
            if (markData != null) {
                this.kMd.a(markData);
            }
        }
        if (this.kIh.bbu()) {
            dbq();
        } else {
            this.kMf.s(this.kIh.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Eu(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NW(String str) {
        if (this.kIh != null && this.kIh.getPbData() != null && this.kIh.getPbData().cZu()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kIh.dcf(), str);
            bw cYR = this.kIh.getPbData().cYR();
            if (cYR.beg()) {
                format = format + "&channelid=33833";
            } else if (cYR.bhs()) {
                format = format + "&channelid=33842";
            } else if (cYR.beh()) {
                format = format + "&channelid=33840";
            }
            NX(format);
            return;
        }
        this.kMc.Ox(str);
    }

    private void NX(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.kIh.dcm()) {
                    antiData.setBlock_forum_name(this.kIh.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.kIh.getPbData().getForum().getId());
                    antiData.setUser_name(this.kIh.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.kIh.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (daX() != null) {
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
        if (AntiHelper.bC(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            CA(str);
        } else {
            this.kMf.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.mro) ? bVar.mro : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.zV(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.id(true);
                aVar.b(getPageContext());
                aVar.bia();
            } else {
                this.kMf.a(0, bVar.Qx, bVar.mro, z);
            }
            if (bVar.Qx) {
                if (bVar.hGO == 1) {
                    ArrayList<PostData> cYT = this.kIh.getPbData().cYT();
                    int size = cYT.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cYT.get(i).getId())) {
                            i++;
                        } else {
                            cYT.remove(i);
                            break;
                        }
                    }
                    this.kIh.getPbData().cYR().nr(this.kIh.getPbData().cYR().bfp() - 1);
                    this.kMf.s(this.kIh.getPbData());
                } else if (bVar.hGO == 0) {
                    dbo();
                } else if (bVar.hGO == 2) {
                    ArrayList<PostData> cYT2 = this.kIh.getPbData().cYT();
                    int size2 = cYT2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cYT2.get(i2).dAA().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cYT2.get(i2).dAA().get(i3).getId())) {
                                i3++;
                            } else {
                                cYT2.get(i2).dAA().remove(i3);
                                cYT2.get(i2).dAC();
                                z2 = true;
                                break;
                            }
                        }
                        cYT2.get(i2).Rn(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.kMf.s(this.kIh.getPbData());
                    }
                    a(bVar, this.kMf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.kMf.a(this.hrC.getLoadDataMode(), gVar.Qx, gVar.mro, false);
            if (gVar.Qx) {
                this.kMg = true;
                if (i == 2 || i == 3) {
                    this.kMh = true;
                    this.kMi = false;
                } else if (i == 4 || i == 5) {
                    this.kMh = false;
                    this.kMi = true;
                }
                if (i == 2) {
                    this.kIh.getPbData().cYR().nu(1);
                    this.kIh.setIsGood(1);
                } else if (i == 3) {
                    this.kIh.getPbData().cYR().nu(0);
                    this.kIh.setIsGood(0);
                } else if (i == 4) {
                    this.kIh.getPbData().cYR().nt(1);
                    this.kIh.EI(1);
                } else if (i == 5) {
                    this.kIh.getPbData().cYR().nt(0);
                    this.kIh.EI(0);
                }
                this.kMf.c(this.kIh.getPbData(), this.kIh.dch());
            }
        }
    }

    private void dbo() {
        if (this.kIh.dci() || this.kIh.dck()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.kIh.dcf());
            PbActivity pbActivity = this.kLA;
            PbActivity pbActivity2 = this.kLA;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.kIh.dcf()));
        if (dbr()) {
            this.kLA.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dau() {
        this.kLA.dau();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cZd;
        boolean z = false;
        if (this.kMf != null) {
            this.kMf.deI();
        }
        if (this.kIh != null && this.kIh.getPbData() != null && !this.kIh.getPbData().cZu()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.kIh.getPbData().cYR().getId();
            if (this.kIh.isShareThread() && this.kIh.getPbData().cYR().efS != null) {
                historyMessage.threadName = this.kIh.getPbData().cYR().efS.showText;
            } else {
                historyMessage.threadName = this.kIh.getPbData().cYR().getTitle();
            }
            if (this.kIh.isShareThread() && !cZX()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.kIh.getPbData().getForum().getName();
            }
            ArrayList<PostData> cYT = this.kIh.getPbData().cYT();
            int det = this.kMf != null ? this.kMf.det() : 0;
            if (cYT != null && det >= 0 && det < cYT.size()) {
                historyMessage.postID = cYT.get(det).getId();
            }
            historyMessage.isHostOnly = this.kIh.getHostMode();
            historyMessage.isSquence = this.kIh.dch();
            historyMessage.isShareThread = this.kIh.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kMr != null) {
            this.kMr.onDestroy();
        }
        if (this.kLE && daX() != null) {
            daX().dfc();
        }
        if (this.kIh != null && (this.kIh.dci() || this.kIh.dck())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.kIh.dcf());
            if (this.kMg) {
                if (this.kMi) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.kIh.chY());
                }
                if (this.kMh) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.kIh.getIsGood());
                }
            }
            if (this.kIh.getPbData() != null && System.currentTimeMillis() - this.kLH >= 40000 && (cZd = this.kIh.getPbData().cZd()) != null && !com.baidu.tbadk.core.util.y.isEmpty(cZd.getDataList())) {
                intent.putExtra("guess_like_data", cZd);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.kMF);
            }
            PbActivity pbActivity = this.kLA;
            PbActivity pbActivity2 = this.kLA;
            pbActivity.setResult(-1, intent);
        }
        if (dbr()) {
            if (this.kIh != null && this.kMf != null && this.kMf.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.kIh.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cYZ() && !this.kLN && pbData.kFp == null) {
                        as ddA = as.ddA();
                        com.baidu.tieba.pb.data.f dcp = this.kIh.dcp();
                        Parcelable onSaveInstanceState = this.kMf.getListView().onSaveInstanceState();
                        boolean dch = this.kIh.dch();
                        boolean hostMode = this.kIh.getHostMode();
                        if (this.kMf.dec() != null && this.kMf.dec().getVisibility() == 0) {
                            z = true;
                        }
                        ddA.a(dcp, onSaveInstanceState, dch, hostMode, z);
                        if (this.kME >= 0 || this.kIh.dcR() != null) {
                            as.ddA().q(this.kIh.dcR());
                            as.ddA().p(this.kIh.dcS());
                            as.ddA().ES(this.kIh.dcT());
                        }
                    }
                }
            } else {
                as.ddA().reset();
            }
            dau();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.kMf == null || !this.kMf.EY(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EE(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.kLA;
        if (i == 0) {
            this.kMf.ddQ();
            this.kMf.ddS().daN();
            this.kMf.tL(false);
        }
        this.kMf.ddU();
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
                        this.kMr.resetData();
                        this.kMr.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kMr.b(writeData);
                        com.baidu.tbadk.editortools.m qr = this.kMr.bsv().qr(6);
                        if (qr != null && qr.eMS != null) {
                            qr.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.kLA;
                        if (i == -1) {
                            this.kMr.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.kMf.ddS() != null && this.kMf.ddS().daR() != null) {
                            com.baidu.tbadk.editortools.pb.h daR = this.kMf.ddS().daR();
                            daR.setThreadData(this.kIh.getPbData().cYR());
                            daR.b(writeData);
                            daR.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m qr2 = daR.bsv().qr(6);
                            if (qr2 != null && qr2.eMS != null) {
                                qr2.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.kLA;
                            if (i == -1) {
                                daR.btz();
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
        this.kMr.onActivityResult(i, i2, intent);
        if (this.kLS != null) {
            this.kLS.onActivityResult(i, i2, intent);
        }
        if (daX().ddS() != null) {
            daX().ddS().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dbp();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.ddA().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.kIh != null) {
                                PbFragment.this.kIh.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dqz().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.kIh != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    U(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (intent != null) {
                        aqVar.dF("tid", intent.getStringExtra("tid"));
                        aqVar.dF("pid", intent.getStringExtra("pid"));
                        aqVar.ai("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(aqVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dqz().F(getPageContext());
                        dbh();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.itk != null && shareItem != null && shareItem.linkUrl != null) {
                            this.itk.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bpT() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60.1
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
                    this.kMf.sR(false);
                    if (this.kIh.getPbData() != null && this.kIh.getPbData().cYR() != null && this.kIh.getPbData().cYR().bfT() != null) {
                        this.kIh.getPbData().cYR().bfT().setStatus(2);
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
                        this.kMu = emotionImageData;
                        if (ED(com.baidu.tbadk.core.util.am.emT)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.kLT != null) {
                        this.kMf.dd(this.kLT);
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
            if (this.kLS == null) {
                this.kLS = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.kLA);
                this.kLS.b(this.ePr);
                this.kLS.c(this.ePy);
            }
            this.kLS.a(emotionImageData, dah(), dah().getPbData());
        }
    }

    private void U(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbp() {
        MarkData EP;
        if (this.kMd != null) {
            if (this.kIh.getPbData() != null && this.kIh.getPbData().cZu()) {
                EP = this.kIh.EP(0);
            } else {
                EP = this.kIh.EP(this.kMf.deu());
            }
            if (EP != null) {
                if (!EP.isApp() || (EP = this.kIh.EP(this.kMf.deu() + 1)) != null) {
                    this.kMf.dep();
                    this.kMd.a(EP);
                    if (!this.kMd.bbu()) {
                        this.kMd.bbw();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.kMd.bbv();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbq() {
        com.baidu.tieba.pb.data.f pbData = this.kIh.getPbData();
        this.kIh.tq(true);
        if (this.kMd != null) {
            pbData.NN(this.kMd.bbt());
        }
        this.kMf.s(pbData);
    }

    private boolean dbr() {
        if (this.kIh == null) {
            return true;
        }
        if (this.kIh.getPbData() == null || !this.kIh.getPbData().cZu()) {
            if (this.kIh.bbu()) {
                final MarkData dcz = this.kIh.dcz();
                if (dcz == null || !this.kIh.getIsFromMark()) {
                    return true;
                }
                final MarkData EP = this.kIh.EP(this.kMf.det());
                if (EP == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dcz);
                    this.kLA.setResult(-1, intent);
                    return true;
                } else if (EP.getPostId() == null || EP.getPostId().equals(dcz.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dcz);
                    this.kLA.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.zV(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.kMd != null) {
                                if (PbFragment.this.kMd.bbu()) {
                                    PbFragment.this.kMd.bbv();
                                    PbFragment.this.kMd.hy(false);
                                }
                                PbFragment.this.kMd.a(EP);
                                PbFragment.this.kMd.hy(true);
                                PbFragment.this.kMd.bbw();
                            }
                            dcz.setPostId(EP.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dcz);
                            PbFragment.this.kLA.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dau();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dcz);
                            PbFragment.this.kLA.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dau();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.kMf != null && PbFragment.this.kMf.getView() != null) {
                                PbFragment.this.kMf.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dcz);
                                PbFragment.this.kLA.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dau();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bia();
                    return false;
                }
            } else if (this.kIh.getPbData() == null || this.kIh.getPbData().cYT() == null || this.kIh.getPbData().cYT().size() <= 0 || !this.kIh.getIsFromMark()) {
                return true;
            } else {
                this.kLA.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.i
    public BdListView getListView() {
        if (this.kMf == null) {
            return null;
        }
        return this.kMf.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bzr() {
        if (this.kMf == null) {
            return 0;
        }
        return this.kMf.deG();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bzs() {
        if (this.ffj == null) {
            this.ffj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bzE */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bcG().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
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
        return this.ffj;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bzt() {
        if (this.fiD == null) {
            this.fiD = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fiD;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bzu() {
        if (this.ffk == null) {
            this.ffk = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cjO */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bcG().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
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
                    gifView.btZ();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.ffk;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bzv() {
        if (this.fiE == null) {
            this.fiE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dbP */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cY */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cZ */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bQr();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: da */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fiE;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bzx() {
        this.fiG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dbQ */
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
        return this.fiG;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> blY() {
        if (this.exy == null) {
            this.exy = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.exy;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void at(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kLL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (be.Oo(str) && this.kIh != null && this.kIh.dcf() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").ai("obj_param1", 1).dF("post_id", this.kIh.dcf()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.eLR = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            be.dfn().f(getPageContext(), str);
        }
        this.kLL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void au(Context context, String str) {
        be.dfn().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.kLL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aw(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void av(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.kMf != null && this.kMf.deX() != null && rect.top <= this.kMf.deX().getHeight()) {
            rect.top += this.kMf.deX().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.kIh.getPbData();
            TbRichText bv = bv(str, i);
            if (bv != null && (tbRichTextData = bv.byG().get(this.kNn)) != null) {
                aVar.postId = String.valueOf(bv.getPostId());
                aVar.kIp = new ArrayList<>();
                aVar.dXc = new ConcurrentHashMap<>();
                if (!tbRichTextData.byM().bza()) {
                    aVar.kIq = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.kIp.add(c2);
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
                    imageUrlData.postId = bv.getPostId();
                    imageUrlData.mIsReserver = this.kIh.dcx();
                    imageUrlData.mIsSeeHost = this.kIh.getHostMode();
                    aVar.dXc.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cYR() != null) {
                            aVar.threadId = pbData.cYR().getId();
                        }
                        aVar.dXa = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kIq = true;
                int size = pbData.cYT().size();
                this.kNo = false;
                aVar.index = -1;
                int a2 = pbData.cZa() != null ? a(pbData.cZa().dAF(), bv, i, i, aVar.kIp, aVar.dXc) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cYT().get(i2);
                    if (postData.getId() == null || pbData.cZa() == null || pbData.cZa().getId() == null || !postData.getId().equals(pbData.cZa().getId())) {
                        a2 = a(postData.dAF(), bv, a2, i, aVar.kIp, aVar.dXc);
                    }
                }
                if (aVar.kIp.size() > 0) {
                    aVar.lastId = aVar.kIp.get(aVar.kIp.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cYR() != null) {
                        aVar.threadId = pbData.cYR().getId();
                    }
                    aVar.dXa = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.byM() == null) {
            return null;
        }
        return tbRichTextData.byM().bzf();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.byM() == null) {
            return 0L;
        }
        return tbRichTextData.byM().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.byM() == null) {
            return false;
        }
        return tbRichTextData.byM().bzg();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.byM() == null) {
            return false;
        }
        return tbRichTextData.byM().bzh();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo byM;
        String str;
        if (tbRichText == tbRichText2) {
            this.kNo = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.byG().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.byG().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.byM().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.byM().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.byM().bza()) {
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
                            if (tbRichTextData != null && (byM = tbRichTextData.byM()) != null) {
                                String bzc = byM.bzc();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = byM.bzd();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bzc;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kIh.dcf(), -1L);
                                imageUrlData.mIsReserver = this.kIh.dcx();
                                imageUrlData.mIsSeeHost = this.kIh.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.kNo) {
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
        PostData cZa;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kIh.bfG())) {
                z = true;
            }
            MarkData o = this.kIh.o(postData);
            if (this.kIh.getPbData() != null && this.kIh.getPbData().cZu() && (cZa = cZa()) != null) {
                o = this.kIh.o(cZa);
            }
            if (o != null) {
                this.kMf.dep();
                if (this.kMd != null) {
                    this.kMd.a(o);
                    if (!z) {
                        this.kMd.bbw();
                    } else {
                        this.kMd.bbv();
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

    public boolean cX(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bv(String str, int i) {
        TbRichText tbRichText = null;
        if (this.kIh == null || this.kIh.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.kIh.getPbData();
        if (pbData.cZa() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cZa());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cYT = pbData.cYT();
            c(pbData, cYT);
            return c(cYT, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eqK == null) {
                this.eqK = new com.baidu.tbadk.core.message.a();
            }
            if (this.equ == null) {
                this.equ = new com.baidu.tieba.tbadkCore.data.e();
                this.equ.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dYY = 5;
            cVar.dZe = 8;
            cVar.dZd = 2;
            if (dah() != null) {
                cVar.dZc = dah().dcP();
            }
            cVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dZf = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dZf = 1;
                        i = 0;
                    }
                }
                this.eqK.a(agreeData, i, getUniqueId(), false);
                this.eqK.a(agreeData, this.equ);
                if (this.kIh == null && this.kIh.getPbData() != null) {
                    this.eqK.a(dbM(), cVar, agreeData, this.kIh.getPbData().cYR());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dZf = 1;
            }
            i = 0;
            this.eqK.a(agreeData, i, getUniqueId(), false);
            this.eqK.a(agreeData, this.equ);
            if (this.kIh == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cZf() != null && fVar.cZf().kGS != null && (list = fVar.cZf().kGS) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> byG;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dAF = arrayList.get(i2).dAF();
            if (dAF != null && (byG = dAF.byG()) != null) {
                int size = byG.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (byG.get(i4) != null && byG.get(i4).getType() == 8) {
                        i3++;
                        if (byG.get(i4).byM().bzc().equals(str) || byG.get(i4).byM().bzd().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = byG.get(i4).byM().getWidth() * equipmentDensity;
                            int height = byG.get(i4).byM().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kNn = i4;
                            return dAF;
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
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kId = str;
            if (this.kLG == null) {
                dbb();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.kLG.getItemView(1).setVisibility(8);
            } else {
                this.kLG.getItemView(1).setVisibility(0);
            }
            this.kLG.bic();
            this.kLL = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hZU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbs() {
        hideNetRefreshView(this.kMf.getView());
        dbt();
        if (this.kIh.dcs()) {
            this.kMf.dep();
        }
        this.kMf.deA();
    }

    private void dbt() {
        showLoadingView(this.kMf.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.kMf.deX().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpE() {
        if (this.hZU != null) {
            this.hZU.stopPlay();
        }
        if (this.kLA != null) {
            this.kLA.cpE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EF(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, dbg(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bzw() {
        if (this.fiF == null) {
            this.fiF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dbR */
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
        return this.fiF;
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

    public void cpF() {
        if (this.kLA != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.kLA.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kLA.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData coh() {
        if (this.kIh == null || this.kIh.getPbData() == null) {
            return null;
        }
        return this.kIh.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.kUy)).intValue();
            if (intValue == az.kUz) {
                if (!this.hrC.dBo()) {
                    this.kMf.dem();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.hrC.Rp(com.baidu.tbadk.core.util.at.R(jSONArray));
                    }
                    this.hrC.a(this.kIh.getPbData().getForum().getId(), this.kIh.getPbData().getForum().getName(), this.kIh.getPbData().cYR().getId(), str, intValue3, intValue2, booleanValue, this.kIh.getPbData().cYR().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.kUA || intValue == az.kUC) {
                if (this.kIh.dcI() != null) {
                    this.kIh.dcI().Ez(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.kUA) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.kMz);
        userMuteAddAndDelCustomMessage.setTag(this.kMz);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean NY(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0774a
    public void tf(boolean z) {
        this.kMl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dbu() {
        ArrayList<PostData> cYT;
        int count;
        if (this.kIh == null || this.kIh.getPbData() == null || this.kIh.getPbData().cYT() == null || (count = com.baidu.tbadk.core.util.y.getCount((cYT = this.kIh.getPbData().cYT()))) == 0) {
            return "";
        }
        if (this.kIh.dcx()) {
            Iterator<PostData> it = cYT.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dAD() == 1) {
                    return next.getId();
                }
            }
        }
        int det = this.kMf.det();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cYT, det);
        if (postData == null || postData.bfy() == null) {
            return "";
        }
        if (this.kIh.Oc(postData.bfy().getUserId())) {
            return postData.getId();
        }
        for (int i = det - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(cYT, i);
            if (postData2 == null || postData2.bfy() == null || postData2.bfy().getUserId() == null) {
                break;
            } else if (this.kIh.Oc(postData2.bfy().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = det + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(cYT, i2);
            if (postData3 == null || postData3.bfy() == null || postData3.bfy().getUserId() == null) {
                return "";
            }
            if (this.kIh.Oc(postData3.bfy().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        this.kLL = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a NZ(String str) {
        String str2;
        if (this.kIh.getPbData() == null || this.kIh.getPbData().cYT() == null || this.kIh.getPbData().cYT().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kIh.getPbData().cYT().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kIh.getPbData().cYT().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kIh.getPbData().cYT().get(i);
        if (postData.dAF() == null || postData.dAF().byG() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dAF().byG().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.byM() != null) {
                    str2 = next.byM().bzc();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dbv() {
        return (!this.kLB && this.kNs == -1 && this.kNt == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null) {
            this.kNv = rVar;
            this.kLB = true;
            this.kMf.ded();
            this.kMf.Om(this.kNu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbw() {
        if (this.kNv != null) {
            if (this.kNs == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kNv.getCartoonId(), this.kNs, 0)));
                this.kLA.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbx() {
        if (this.kNv != null) {
            if (this.kNt == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kNv.getCartoonId(), this.kNt, 0)));
                this.kLA.finish();
            }
        }
    }

    public int dby() {
        return this.kNs;
    }

    public int dbz() {
        return this.kNt;
    }

    private void cDk() {
        if (this.kIh != null && this.kIh.getPbData() != null && this.kIh.getPbData().cYR() != null && this.kIh.getPbData().cYR().bee()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dbA() {
        if (this.kIh != null && this.kIh.getPbData() != null && this.kIh.getPbData().cYR() != null && this.kIh.getPbData().cYR().bee()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dbB() {
        if (this.bsQ) {
            this.kLR = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.kIh.getPbData() != null && this.kIh.getPbData().cYR() != null && this.kIh.getPbData().cYR().bfe() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.kIh.getPbData().cYR().bfe().getThreadId(), this.kIh.getPbData().cYR().bfe().getTaskId(), this.kIh.getPbData().cYR().bfe().getForumId(), this.kIh.getPbData().cYR().bfe().getForumName(), this.kIh.getPbData().cYR().bft(), this.kIh.getPbData().cYR().bfu())));
            this.kLD = true;
            this.kLA.finish();
        }
    }

    public String dbC() {
        return this.kLP;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dbD() {
        return this.kMb;
    }

    public void tg(boolean z) {
        this.kLQ = z;
    }

    public boolean bdg() {
        if (this.kIh != null) {
            return this.kIh.dci();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.zV(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.kMx).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.kMx.getPageActivity(), 2, true, 4);
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
        aVar.b(this.kMx).bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kMx != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kMx.getPageActivity());
            aVar.zV(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kMx).bia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.kMf.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kMx.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.zV(this.kMx.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zV(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.kMf.showLoadingDialog();
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
        aVar.b(this.kMx).bia();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.Oo(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.iDZ) {
            this.iDZ = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.kMf != null) {
                this.kMf.onConfigurationChanged(configuration);
            }
            if (this.kMj != null) {
                this.kMj.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dbF() {
        if (this.kIh != null) {
            return this.kIh.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.kIh.getPbData().cZf().kGS;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dAA().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dAA().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dAA().remove(i2);
                    list.get(i).dAC();
                    z = true;
                    break;
                }
            }
            list.get(i).Rn(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.kIh.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.cZH().getId();
        List<PostData> list = this.kIh.getPbData().cZf().kGS;
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
                ArrayList<PostData> cZP = pVar.cZP();
                postData.Ir(pVar.getTotalCount());
                if (postData.dAA() != null) {
                    postData.dAA().clear();
                    postData.dAA().addAll(cZP);
                }
            }
        }
        if (!this.kIh.getIsFromMark()) {
            this.kMf.s(this.kIh.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cZW() {
        return this.kLA.cZW();
    }

    public boolean cZX() {
        if (this.kIh == null) {
            return false;
        }
        return this.kIh.cZX();
    }

    public void th(boolean z) {
        this.kLO = z;
    }

    public boolean dbG() {
        return this.kLO;
    }

    public void dbH() {
        if (this.kMf != null) {
            this.kMf.ddQ();
            cpF();
        }
    }

    public PostData cZa() {
        return this.kMf.b(this.kIh.kJe, this.kIh.dch());
    }

    public void onBackPressed() {
        if (this.kMG != null && !this.kMG.isEmpty()) {
            int size = this.kMG.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.kMG.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.kMG == null) {
                this.kMG = new ArrayList();
            }
            if (!this.kMG.contains(aVar)) {
                this.kMG.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.kMG == null) {
                this.kMG = new ArrayList();
            }
            if (!this.kMG.contains(aVar)) {
                this.kMG.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.kMG != null) {
            this.kMG.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbI() {
        if (this.kIh != null && !com.baidu.tbadk.core.util.at.isEmpty(this.kIh.dcf())) {
            com.baidu.tbadk.BdToken.c.aZe().p(com.baidu.tbadk.BdToken.b.dPM, com.baidu.adp.lib.f.b.toLong(this.kIh.dcf(), 0L));
        }
    }

    public bf dbJ() {
        return this.kLY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa(String str) {
        if (this.kIh != null && this.kIh.getPbData() != null && this.kIh.getPbData().cYR() != null && this.kIh.getPbData().cYR().bei()) {
            bw cYR = this.kIh.getPbData().cYR();
            int i = 0;
            if (cYR.beg()) {
                i = 1;
            } else if (cYR.beh()) {
                i = 2;
            } else if (cYR.bht()) {
                i = 3;
            } else if (cYR.bhu()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str);
            aqVar.ai("obj_source", 4);
            aqVar.ai("obj_type", i);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(final int i) {
        com.baidu.tbadk.util.ae.a(new com.baidu.tbadk.util.ad<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bcB */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.dbg(), i2, PbFragment.this.kIh);
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
        aqVar.ai("obj_locate", 1);
        if (i == 3) {
            aqVar.ai("obj_type", 1);
        } else if (i == 8) {
            aqVar.ai("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dbK() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dbL() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dbM() {
        return this.kLA;
    }
}
