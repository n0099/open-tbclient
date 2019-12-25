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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.account.contants.LoginConstants;
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
import com.baidu.tbadk.core.atomData.GodFansCallWebViewActivityConfig;
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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
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
import com.baidu.tbadk.switchs.FansCallSwitch;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.TbMemeImageView;
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
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.d.a;
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
/* loaded from: classes6.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0572a {
    private com.baidu.adp.lib.d.b<ImageView> dHY;
    private com.baidu.adp.lib.d.b<GifView> dHZ;
    private com.baidu.adp.lib.d.b<TextView> dKO;
    private com.baidu.adp.lib.d.b<View> dKP;
    private com.baidu.adp.lib.d.b<LinearLayout> dKQ;
    private com.baidu.adp.lib.d.b<RelativeLayout> dKR;
    private com.baidu.adp.lib.d.b<TbImageView> deJ;
    private LikeModel dfB;
    private au gLl;
    private VoiceManager giZ;
    private com.baidu.tieba.frs.profession.permission.c gmA;
    private com.baidu.tieba.f.b gnc;
    public com.baidu.tbadk.core.util.aj hJV;
    private PbActivity iBR;
    private com.baidu.tieba.pb.pb.main.b.b iBT;
    private boolean iCA;
    private com.baidu.tieba.tbadkCore.data.f iCE;
    private com.baidu.tbadk.editortools.pb.g iCF;
    private com.baidu.tbadk.editortools.pb.e iCG;
    private com.baidu.tieba.frs.profession.permission.c iCI;
    private EmotionImageData iCJ;
    private com.baidu.adp.base.e iCM;
    private com.baidu.tbadk.core.view.d iCN;
    private BdUniqueId iCO;
    private Runnable iCP;
    private com.baidu.adp.widget.ImageView.a iCQ;
    private String iCR;
    private TbRichTextMemeInfo iCS;
    private List<a> iCV;
    public String iCX;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iCi;
    private View iCj;
    int iCl;
    private ax iCo;
    private com.baidu.tieba.pb.pb.report.a iCq;
    public as iCx;
    private com.baidu.tbadk.core.dialog.i iCy;
    private com.baidu.tbadk.core.dialog.k iCz;
    private String iDG;
    private com.baidu.tbadk.core.data.p iDH;
    private boolean iDx;
    private String iyO;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a iDD = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.f.b.a
        public void aY(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.ciH();
            } else {
                com.baidu.tieba.pb.a.b.ciG();
            }
        }
    };
    private boolean iBS = false;
    private boolean iBU = false;
    private boolean isPaused = false;
    private boolean ick = false;
    private boolean iBV = true;
    private int iBW = 0;
    private com.baidu.tbadk.core.dialog.b iBX = null;
    private long fPB = -1;
    private long dzt = 0;
    private long iBY = 0;
    private long createTime = 0;
    private long dzl = 0;
    private boolean iBZ = false;
    private com.baidu.tbadk.n.b iCa = null;
    private long iCb = 0;
    private boolean iCc = false;
    private long iCd = 0;
    private int gIQ = 1;
    private String dtY = null;
    private boolean iCe = false;
    private boolean isFullScreen = false;
    private String iCf = "";
    private boolean iCg = true;
    private boolean iCh = false;
    private String source = "";
    private int mSkinType = 3;
    int[] iCk = new int[2];
    private int iCm = -1;
    private int iCn = -1;
    private PbInterviewStatusView.a iCp = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.iCt.pV(!PbFragment.this.iCg);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.iyT != null && PbFragment.this.iyT.awd()) {
                        PbFragment.this.ckj();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel iyT = null;
    private com.baidu.tbadk.baseEditMark.a iCr = null;
    private ForumManageModel fEP = null;
    private com.baidu.tbadk.coreExtra.model.a cVO = null;
    private com.baidu.tieba.pb.data.n iCs = null;
    private ShareSuccessReplyToServerModel gzi = null;
    private aq iCt = null;
    private boolean iCu = false;
    private boolean iCv = false;
    private boolean iCw = false;
    private boolean dZy = false;
    private boolean iCB = false;
    private boolean iCC = false;
    private boolean iCD = false;
    private boolean iCH = false;
    public boolean iCK = false;
    private com.baidu.tbadk.editortools.pb.c dub = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aMa() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b duc = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aLZ() {
            if (PbFragment.this.iCx == null || PbFragment.this.iCx.cnW() == null || !PbFragment.this.iCx.cnW().cRJ()) {
                return !PbFragment.this.yB(com.baidu.tbadk.core.util.aj.cVJ);
            }
            PbFragment.this.showToast(PbFragment.this.iCx.cnW().cRL());
            if (PbFragment.this.iCG != null && (PbFragment.this.iCG.aMp() || PbFragment.this.iCG.aMq())) {
                PbFragment.this.iCG.a(false, PbFragment.this.iCx.cnZ());
            }
            PbFragment.this.iCx.qh(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b iCL = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aLZ() {
            if (PbFragment.this.iCx == null || PbFragment.this.iCx.cnX() == null || !PbFragment.this.iCx.cnX().cRJ()) {
                return !PbFragment.this.yB(com.baidu.tbadk.core.util.aj.cVK);
            }
            PbFragment.this.showToast(PbFragment.this.iCx.cnX().cRL());
            if (PbFragment.this.iCt != null && PbFragment.this.iCt.cmI() != null && PbFragment.this.iCt.cmI().cjJ() != null && PbFragment.this.iCt.cmI().cjJ().aMq()) {
                PbFragment.this.iCt.cmI().cjJ().a(PbFragment.this.iCx.cnZ());
            }
            PbFragment.this.iCx.qi(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean gjL = false;
    private int iCT = 0;
    private int iCU = -1;
    public int iCW = 0;
    private final a iCY = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.iCt != null && PbFragment.this.iCt.cmI() != null) {
                t cmI = PbFragment.this.iCt.cmI();
                if (cmI.cjH()) {
                    cmI.cjG();
                    return true;
                }
            }
            if (PbFragment.this.iCt != null && PbFragment.this.iCt.cnF()) {
                PbFragment.this.iCt.cnG();
                return true;
            }
            return false;
        }
    };
    private final aa.a iCZ = new aa.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.aa.a
        public void onSuccess(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.aa.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.iCt.showToast(str);
            }
        }
    };
    private final CustomMessageListener iDa = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iyT != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.iCG != null) {
                    PbFragment.this.iCt.qa(PbFragment.this.iCG.aMi());
                }
                PbFragment.this.iCt.cmK();
                PbFragment.this.iCt.cny();
            }
        }
    };
    CustomMessageListener gko = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.iyT.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.iCt != null && PbFragment.this.iyT != null) {
                    PbFragment.this.iCt.b(PbFragment.this.iyT.getPbData(), PbFragment.this.iyT.ckV(), PbFragment.this.iyT.clt(), PbFragment.this.iCt.getSkinType());
                }
                if (PbFragment.this.iCt != null && PbFragment.this.iCt.cnb() != null) {
                    PbFragment.this.iCt.cnb().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener iDb = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.iCt != null) {
                    if (booleanValue) {
                        PbFragment.this.iCt.bTG();
                    } else {
                        PbFragment.this.iCt.bTF();
                    }
                }
            }
        }
    };
    private CustomMessageListener iDc = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.iCG != null) {
                    PbFragment.this.iCt.qa(PbFragment.this.iCG.aMi());
                }
                PbFragment.this.iCt.qc(false);
            }
        }
    };
    private CustomMessageListener iDd = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.f fVar = (com.baidu.tieba.pb.f) customResponsedMessage.getData();
                switch (fVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.m) fVar.getData());
                        return;
                    case 1:
                        PbFragment.this.a((ForumManageModel.b) fVar.getData(), false);
                        return;
                    case 2:
                        if (fVar.getData() == null) {
                            PbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbFragment.this.a(true, (MarkData) fVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener iDe = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iCt != null && PbFragment.this.iCt.cnb() != null) {
                PbFragment.this.iCt.cnb().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hnU = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener gkl = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.ckA();
            }
        }
    };
    private j.a iDf = new j.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void z(int i, long j) {
            boolean z;
            if (i == 0) {
                PbFragment.this.yD(2);
                ak.cmq().reset();
                PbFragment.this.iyT.clu();
                boolean z2 = false;
                ArrayList<PostData> chM = PbFragment.this.iyT.getPbData().chM();
                if (chM != null) {
                    Iterator<PostData> it = chM.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.o(next) && next.cIC().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbFragment.this.iCt.o(PbFragment.this.iyT.getPbData());
                    }
                    PbFragment.this.showToast(R.string.operation_success);
                    return;
                }
                return;
            }
            PbFragment.this.showToast(R.string.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.j.a
        public void onError(int i, String str) {
            PbFragment.this.showToast(R.string.operation_failed);
        }
    };
    private View.OnClickListener duK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.dtY);
        }
    };
    private CustomMessageListener iDg = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                ar.a aVar = new ar.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.thumbnailUrl = abVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.iyT.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.iyT.clj() != null && PbFragment.this.iyT.clj().getUserIdLong() == abVar.toUserId) {
                        PbFragment.this.iCt.a(abVar.sendCount, PbFragment.this.iyT.getPbData(), PbFragment.this.iyT.ckV(), PbFragment.this.iyT.clt());
                    }
                    if (pbData.chM() != null && pbData.chM().size() >= 1 && pbData.chM().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.chM().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.iyT.ckU(), 0L);
                        if (j == abVar.postId && j2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.ar cIB = pbData.chM().get(0).cIB();
                            if (cIB == null) {
                                cIB = new com.baidu.tbadk.core.data.ar();
                            }
                            ArrayList<ar.a> ayA = cIB.ayA();
                            if (ayA == null) {
                                ayA = new ArrayList<>();
                            }
                            ayA.add(0, aVar);
                            cIB.setTotal(abVar.sendCount + cIB.getTotal());
                            cIB.u(ayA);
                            pbData.chM().get(0).a(cIB);
                            PbFragment.this.iCt.cnb().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gAq = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                PbFragment.this.Fo((String) customResponsedMessage.getData());
                PbFragment.this.iyT.clp();
                if (PbFragment.this.iCt.cnb() != null) {
                    PbFragment.this.iCt.o(PbFragment.this.iyT.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a iDh = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.con()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a iDi = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onSuccess(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.iCt != null) {
                PbFragment.this.iCt.dL(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean iDj = false;
    private PraiseModel iDk = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void wS(String str) {
            PbFragment.this.iDj = false;
            if (PbFragment.this.iDk != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.iyT.getPbData();
                if (pbData.chK().azp().getIsLike() == 1) {
                    PbFragment.this.tx(0);
                } else {
                    PbFragment.this.tx(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.chK()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.iDj = false;
            if (PbFragment.this.iDk != null && str != null) {
                if (AntiHelper.aW(i, str)) {
                    AntiHelper.bj(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a iDl = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void pB(boolean z) {
            PbFragment.this.pA(z);
            if (PbFragment.this.iCt.cnL() != null && z) {
                PbFragment.this.iCt.pV(false);
            }
            PbFragment.this.iCt.pX(z);
        }
    };
    private CustomMessageListener cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().djy != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().djy, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.chR().azE() != null && PbFragment.this.chR().azE().getGodUserData() != null) {
                            PbFragment.this.chR().azE().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().azE() != null) {
                            PbFragment.this.iyT.getPbData().chK().azE().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h gih = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.iBR.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a iDm = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.iCt.bnJ();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.yE(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.bJU();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c dmm = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cjS();
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
                        if (PbFragment.this.cp(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.c((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.iCt.cjQ() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").cp("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.ciI() != null && PbFragment.this.ciI().gLG != null) {
                                PbFragment.this.ciI().gLG.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view.getTag();
                        }
                        if (sparseArray != null) {
                            PbFragment.this.c(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (PbFragment.this.iCG != null) {
                    PbFragment.this.iCt.qa(PbFragment.this.iCG.aMi());
                }
                PbFragment.this.iCt.cmK();
                PbFragment.this.iCt.cny();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener iDn = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iCO) {
                PbFragment.this.iCt.bnJ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.iyT.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.chX().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iCN.showSuccessToast(PbFragment.this.iCM.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.iCM.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.uU(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.ckx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.iCM.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.iCN.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iDo = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iCO) {
                PbFragment.this.iCt.bnJ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iCN.showSuccessToast(PbFragment.this.iCM.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.iCM.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.iCN.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iDp = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iCO) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.iCt.bnJ();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.kpZ;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
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
                    PbFragment.this.iCt.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener iDq = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iCt.cmL() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cjS();
            }
        }
    };
    private CustomMessageListener gkv = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.gjL = true;
                }
            }
        }
    };

    /* renamed from: int  reason: not valid java name */
    public a.b f8int = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bBE();
            com.baidu.tbadk.core.data.ap pageData = PbFragment.this.iyT.getPageData();
            int pageNum = PbFragment.this.iCt.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.ayt()) {
                PbFragment.this.iCt.cny();
                PbFragment.this.yD(2);
                PbFragment.this.bBD();
                PbFragment.this.iCt.cnf();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.iyT.yG(PbFragment.this.iCt.getPageNum());
                    if (PbFragment.this.iBT != null) {
                        PbFragment.this.iBT.showFloatingView();
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
    public final View.OnClickListener gle = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        /* JADX WARN: Removed duplicated region for block: B:600:0x1cdd  */
        /* JADX WARN: Removed duplicated region for block: B:603:0x1d26  */
        /* JADX WARN: Removed duplicated region for block: B:620:0x1f3c  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            boolean z3;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            long j;
            String str2;
            int i;
            int i2;
            int i3;
            bo boVar;
            String[] strArr;
            boolean u;
            String name;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.iCt.cnu()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.iyT.pG(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.iCt.cng();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cmk()) {
                        if (view == PbFragment.this.iCt.iIK.dBy) {
                            if (PbFragment.this.iCt.pZ(PbFragment.this.iyT.cla())) {
                                PbFragment.this.bBD();
                                return;
                            }
                            PbFragment.this.iBV = false;
                            PbFragment.this.iBU = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.iBR, PbFragment.this.iCt.iIK.dBy);
                            PbFragment.this.iBR.finish();
                        } else if (view != PbFragment.this.iCt.cnd() && (PbFragment.this.iCt.iIK.coB() == null || (view != PbFragment.this.iCt.iIK.coB().cmj() && view != PbFragment.this.iCt.iIK.coB().cmh()))) {
                            if (view == PbFragment.this.iCt.cnB()) {
                                if (PbFragment.this.iyT != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iyT.getPbData().chK().azD().getLink());
                                }
                            } else if (view != PbFragment.this.iCt.iIK.iOM) {
                                if (view == PbFragment.this.iCt.iIK.iON) {
                                    if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                        ArrayList<PostData> chM = PbFragment.this.iyT.getPbData().chM();
                                        if ((chM == null || chM.size() <= 0) && PbFragment.this.iyT.ckV()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").cp("tid", PbFragment.this.iyT.ckU()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", PbFragment.this.iyT.getForumId()));
                                        if (!PbFragment.this.iCt.cnQ()) {
                                            PbFragment.this.iCt.cmK();
                                        }
                                        PbFragment.this.ckb();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.iCt.pq(true);
                                        PbFragment.this.iCt.cmK();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.iCt.bTG();
                                            PbFragment.this.bBD();
                                            PbFragment.this.iCt.cnf();
                                            PbFragment.this.iyT.Fw(PbFragment.this.ckn());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbFragment.this.yD(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cmg()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.iCt.iIK.coB() != null && view == PbFragment.this.iCt.iIK.coB().cmf()) {
                                            PbFragment.this.iCt.iIK.apm();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cmd()) {
                                                if ((PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cmm()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cme()) {
                                                        if (PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cmn()) {
                                                            if (PbFragment.this.iCt.cnL() == view) {
                                                                if (PbFragment.this.iCt.cnL().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.iyT.getPbData();
                                                                    if (pbData != null && pbData.chK() != null && pbData.chK().azj() != null) {
                                                                        String aza = pbData.chK().azj().aza();
                                                                        if (StringUtils.isNull(aza)) {
                                                                            aza = pbData.chK().azj().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").cp("obj_id", aza));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.es("c10725", null);
                                                                }
                                                                PbFragment.this.cku();
                                                            } else if (PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cml()) {
                                                                if (PbFragment.this.iCt.iIK.coB() != null && view == PbFragment.this.iCt.iIK.coB().cmi()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.iCt.b(PbFragment.this.iyT.getPbData(), PbFragment.this.iyT.ckV(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.iCt.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.iCt.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.iCt.iIK.apm();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.cp("tid", PbFragment.this.iyT.ckU());
                                                                        anVar.cp("fid", PbFragment.this.iyT.getForumId());
                                                                        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.Z("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                                                            PbFragment.this.iCt.cny();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cIF() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.kcG != null) {
                                                                                    com.baidu.tbadk.core.util.an aDS = postData.kcG.aDS();
                                                                                    aDS.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aDS.Z("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aDS.Z("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aDS);
                                                                                }
                                                                                String ckU = PbFragment.this.iyT.ckU();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbFragment.this.iyT.getPbData() != null) {
                                                                                    i4 = PbFragment.this.iyT.getPbData().chW();
                                                                                }
                                                                                PbFragment.this.bBD();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a Fu = PbFragment.this.Fu(id);
                                                                                    if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && Fu != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(ckU, id, "pb", true, null, true, null, i4, postData.cpy(), PbFragment.this.iyT.getPbData().getAnti(), false, postData.azE().getIconInfo()).addBigImageData(Fu.iyY, Fu.iyZ, Fu.iza, Fu.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.iyT.clG());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.iyT.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.iyT.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.iyT.clc());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a Fu2 = PbFragment.this.Fu(id);
                                                                                    if (postData != null && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && Fu2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(ckU, id, "pb", true, null, false, null, i4, postData.cpy(), PbFragment.this.iyT.getPbData().getAnti(), false, postData.azE().getIconInfo()).addBigImageData(Fu2.iyY, Fu2.iyZ, Fu2.iza, Fu2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.iyT.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.iyT.clc());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.iyT.clG());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.iyT.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").Z("obj_locate", 3).cp("fid", PbFragment.this.iyT.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.iyT != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.cp("tid", PbFragment.this.iyT.ckU());
                                                                        anVar2.cp("fid", PbFragment.this.iyT.getForumId());
                                                                        anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.Z("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                                                                    String ckU2 = PbFragment.this.iyT.ckU();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbFragment.this.iyT.getPbData() != null) {
                                                                                        i5 = PbFragment.this.iyT.getPbData().chW();
                                                                                    }
                                                                                    PbActivity.a Fu3 = PbFragment.this.Fu(id2);
                                                                                    if (Fu3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(ckU2, id2, "pb", true, null, false, null, i5, postData2.cpy(), PbFragment.this.iyT.getPbData().getAnti(), false, postData2.azE().getIconInfo()).addBigImageData(Fu3.iyY, Fu3.iyZ, Fu3.iza, Fu3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.iyT.clG());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.iyT.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.iyT.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.iyT.clc());
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
                                                                } else if (view.getId() == R.id.pb_post_reply) {
                                                                    if (PbFragment.this.iyT != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.cp("tid", PbFragment.this.iyT.ckU());
                                                                        anVar3.cp("fid", PbFragment.this.iyT.getForumId());
                                                                        anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.Z("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.cjP().cmH() != null && postData3.azE() != null && postData3.cIt() != 1) {
                                                                                    if (PbFragment.this.cjP().cmI() != null) {
                                                                                        PbFragment.this.cjP().cmI().cjF();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                                                                                    mVar.a(PbFragment.this.iyT.getPbData().getForum());
                                                                                    mVar.setThreadData(PbFragment.this.iyT.getPbData().chK());
                                                                                    mVar.f(postData3);
                                                                                    PbFragment.this.cjP().cmH().d(mVar);
                                                                                    PbFragment.this.cjP().cmH().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.azE().getUserId(), "");
                                                                                    if (PbFragment.this.iCG != null) {
                                                                                        PbFragment.this.iCt.qa(PbFragment.this.iCG.aMi());
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
                                                                } else if (view != PbFragment.this.iCt.cjf()) {
                                                                    if (view == PbFragment.this.iCt.iIK.coC()) {
                                                                        PbFragment.this.iCt.cnm();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (boVar = (bo) view.getTag()) != null && !StringUtils.isNull(boVar.aBO())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aEa().b(PbFragment.this.getPageContext(), new String[]{boVar.aBO()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right || id3 == R.id.image_more_tip) {
                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").cp("tid", PbFragment.this.iyT.iET));
                                                                                    }
                                                                                    if (PbFragment.this.iCz == null) {
                                                                                        PbFragment.this.iCz = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.iCz.a(PbFragment.this.iDC);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cr(view);
                                                                                    if (!PbFragment.this.cr(view) || PbFragment.this.iCQ == null || !PbFragment.this.iCQ.isGif()) {
                                                                                    }
                                                                                    boolean z4 = false;
                                                                                    boolean z5 = false;
                                                                                    boolean z6 = false;
                                                                                    boolean z7 = false;
                                                                                    boolean z8 = false;
                                                                                    if (!(sparseArray4.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                        z = false;
                                                                                    } else {
                                                                                        z = ((Boolean) sparseArray4.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                        ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                        z4 = ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                        z6 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z7 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                        z8 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                    }
                                                                                    if (!(sparseArray4.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                                                                        str = null;
                                                                                    } else {
                                                                                        str = (String) sparseArray4.get(R.id.tag_forbid_user_post_id);
                                                                                    }
                                                                                    if (z) {
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_template_id) instanceof Long)) {
                                                                                            j = 0;
                                                                                        } else {
                                                                                            j = ((Long) sparseArray4.get(R.id.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_monitor_id) instanceof String)) {
                                                                                            str2 = "";
                                                                                        } else {
                                                                                            str2 = (String) sparseArray4.get(R.id.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_hide_day) instanceof Integer)) {
                                                                                            i = 0;
                                                                                        } else {
                                                                                            i = ((Integer) sparseArray4.get(R.id.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbFragment.this.getString(R.string.no_interesting), PbFragment.this.iCz);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cIv() != null && postData4.cIv().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iCz);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbFragment.this.hbU = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.iyT.getPbData().awd()) {
                                                                                        String awc = PbFragment.this.iyT.getPbData().awc();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(awc) && awc.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iCz);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iCz);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.hbU);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z6 && z5) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iCz);
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_user_mute_visible, true);
                                                                                                    sparseArray7.put(R.id.tag_is_mem, sparseArray4.get(R.id.tag_is_mem));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_mute_userid, sparseArray4.get(R.id.tag_user_mute_mute_userid));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_mute_username, sparseArray4.get(R.id.tag_user_mute_mute_username));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_mute_nameshow, sparseArray4.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_post_id, sparseArray4.get(R.id.tag_user_mute_post_id));
                                                                                                    sparseArray7.put(R.id.tag_user_mute_thread_id, sparseArray4.get(R.id.tag_user_mute_thread_id));
                                                                                                    sparseArray7.put(R.id.tag_del_post_is_self, sparseArray4.get(R.id.tag_del_post_is_self));
                                                                                                    sparseArray7.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                    sparseArray7.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar6);
                                                                                                } else {
                                                                                                    if (!ap.o(PbFragment.this.hbU)) {
                                                                                                        z3 = PbFragment.this.pw(z4) && TbadkCoreApplication.isLogin();
                                                                                                    } else {
                                                                                                        z3 = false;
                                                                                                    }
                                                                                                    if (z3) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iCz);
                                                                                                        gVar7.mTextView.setTag(str);
                                                                                                        arrayList.add(gVar7);
                                                                                                    }
                                                                                                }
                                                                                                if (z6) {
                                                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                                                    sparseArray8.put(R.id.tag_should_manage_visible, true);
                                                                                                    sparseArray8.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name, sparseArray4.get(R.id.tag_forbid_user_name));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name_show, sparseArray4.get(R.id.tag_forbid_user_name_show));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_portrait, sparseArray4.get(R.id.tag_forbid_user_portrait));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_post_id, str);
                                                                                                    if (z7) {
                                                                                                        sparseArray8.put(R.id.tag_user_mute_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_is_mem, sparseArray4.get(R.id.tag_is_mem));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_mute_userid, sparseArray4.get(R.id.tag_user_mute_mute_userid));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_mute_username, sparseArray4.get(R.id.tag_user_mute_mute_username));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_mute_nameshow, sparseArray4.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_post_id, sparseArray4.get(R.id.tag_user_mute_post_id));
                                                                                                        sparseArray8.put(R.id.tag_user_mute_thread_id, sparseArray4.get(R.id.tag_user_mute_thread_id));
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_user_mute_visible, false);
                                                                                                    }
                                                                                                    if (z8) {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                                                                                                        sparseArray8.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                        sparseArray8.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iCz);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iCz);
                                                                                                    gVar3.mTextView.setTag(sparseArray8);
                                                                                                } else if (!z8) {
                                                                                                    gVar2 = null;
                                                                                                    gVar3 = null;
                                                                                                } else {
                                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                                    sparseArray9.put(R.id.tag_should_manage_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                    sparseArray9.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                                                                                                    sparseArray9.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                    sparseArray9.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                    if (PbFragment.this.iyT.getPbData().chW() == 1002 && !z4) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iCz);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iCz);
                                                                                                    }
                                                                                                    gVar2.mTextView.setTag(sparseArray9);
                                                                                                    gVar3 = null;
                                                                                                }
                                                                                                if (gVar2 != null) {
                                                                                                    arrayList.add(gVar2);
                                                                                                }
                                                                                                if (gVar3 != null) {
                                                                                                    arrayList.add(gVar3);
                                                                                                }
                                                                                            }
                                                                                            PbFragment.this.iCz.aA(arrayList);
                                                                                            PbFragment.this.iCy = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iCz);
                                                                                            PbFragment.this.iCy.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.hbU);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.iCz.aA(arrayList);
                                                                                    PbFragment.this.iCy = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iCz);
                                                                                    PbFragment.this.iCy.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.iyT.getPbData().chK().getActUrl());
                                                                                if (PbFragment.this.iyT.getPbData().chK().aAo() != 1) {
                                                                                    if (PbFragment.this.iyT.getPbData().chK().aAo() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").cp("fid", PbFragment.this.iyT.getPbData().getForumId()).cp("tid", PbFragment.this.iyT.getPbData().getThreadId()).cp("lotterytail", StringUtils.string(str3, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.iyT.getPbData().getThreadId().equals(str3)) {
                                                                                    PbFragment.this.iCt.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.iCt.cmK();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cjX() == 1 && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").cp("fid", PbFragment.this.iyT.getPbData().getForumId()).cp("tid", PbFragment.this.iyT.getPbData().getThreadId()).cp("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cjX() == 1 && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").cp("fid", PbFragment.this.iyT.getPbData().getForumId()).cp("tid", PbFragment.this.iyT.getPbData().getThreadId()).cp("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.ckp();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.ckq();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().cid() != null) {
                                                                                com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.iyT.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").cp("fid", pbData2.getForumId()));
                                                                                ba.aEa().b(PbFragment.this.getPageContext(), new String[]{pbData2.cid().cio()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().cid() != null) {
                                                                                com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.iyT.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cp("fid", pbData3.getForumId()));
                                                                                ba.aEa().b(PbFragment.this.getPageContext(), new String[]{pbData3.cid().cio()});
                                                                            }
                                                                        } else if (PbFragment.this.iCt.iIK.coB() != null && view == PbFragment.this.iCt.iIK.coB().cmo()) {
                                                                            if (PbFragment.this.iyT == null || PbFragment.this.iyT.getPbData() == null || PbFragment.this.iyT.getPbData().chK() == null) {
                                                                                PbFragment.this.iCt.iIK.apm();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                                                PbFragment.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbFragment.this.iyT.getPbData().chK().azk() == 0) {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iyT.ckU(), RequestResponseCode.FANS_CALL_JUMP_BACK)));
                                                                                } else {
                                                                                    BdToast.b(PbFragment.this.getPageContext().getContext(), PbFragment.this.getPageContext().getContext().getString(R.string.haved_fans_called)).aCb();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").Z("obj_locate", PbFragment.this.aB(PbFragment.this.iyT.getPbData().chK())).cp("tid", PbFragment.this.iyT.getPbData().chK().getTid()).Z("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.iCT >= 0) {
                                                                                if (PbFragment.this.iyT != null) {
                                                                                    PbFragment.this.iyT.clH();
                                                                                }
                                                                                if (PbFragment.this.iyT != null && PbFragment.this.iCt.cnb() != null) {
                                                                                    PbFragment.this.iCt.cnb().a(PbFragment.this.iyT.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.iCT = 0;
                                                                                if (PbFragment.this.iyT != null) {
                                                                                    PbFragment.this.iCt.getListView().setSelection(PbFragment.this.iyT.clK());
                                                                                    PbFragment.this.iyT.cr(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cjU();
                                                                        } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbFragment.this.c(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                            if (PbFragment.this.iCt.getListView() != null && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.iCt.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.iCt.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean cih = PbFragment.this.iyT.getPbData().cih();
                                                                                boolean z9 = PbFragment.this.iCt.cmJ() != null && PbFragment.this.iCt.cmJ().bfB();
                                                                                boolean cnv = PbFragment.this.iCt.cnv();
                                                                                boolean z10 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (cih && PbFragment.this.iCt.cmJ() != null && PbFragment.this.iCt.cmJ().aZU() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.iCt.cmJ().col();
                                                                                    z10 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.iCt.cmJ().aZU().getHeight() - PbFragment.this.iCt.cmJ().col());
                                                                                    i7 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.Fv("c13568");
                                                                                if ((PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().azv() <= 0) || (cnv && z10)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cjU();
                                                                                        if (PbFragment.this.iyT.getPbData().chK().azE() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", PbFragment.this.iyT.iET).cp("fid", PbFragment.this.iyT.getPbData().getForumId()).Z("obj_locate", 2).cp("uid", PbFragment.this.iyT.getPbData().chK().azE().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z11 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (cih) {
                                                                                        if (PbFragment.this.iCt.iJQ != null && PbFragment.this.iCt.iJQ.iKU != null && PbFragment.this.iCt.iJQ.iKU.getView() != null) {
                                                                                            if (PbFragment.this.iCt.iJQ.iKU.getView().getParent() == null) {
                                                                                                z11 = firstVisiblePosition >= PbFragment.this.ckf();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbFragment.this.iCt.cmJ() != null && PbFragment.this.iCt.cmJ().aZU() != null) {
                                                                                                    i8 = PbFragment.this.iCt.cmJ().aZU().getBottom();
                                                                                                }
                                                                                                z11 = PbFragment.this.iCt.iJQ.iKU.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.iCt.cmS() != null) {
                                                                                        z11 = PbFragment.this.iCt.cmS().getVisibility() == 0;
                                                                                        if (!z11 && PbFragment.this.iCt.iJQ != null && PbFragment.this.iCt.iJQ.iKU != null && PbFragment.this.iCt.iJQ.iKU.getView() != null && PbFragment.this.iCt.iJQ.iKU.getView().getParent() != null && PbFragment.this.iCt.iIK != null && PbFragment.this.iCt.iIK.mNavigationBar != null) {
                                                                                            z11 = PbFragment.this.iCt.iJQ.iKU.getView().getTop() - PbFragment.this.iCt.iIK.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z11 || cnv) {
                                                                                        PbFragment.this.iCm = firstVisiblePosition;
                                                                                        PbFragment.this.iCn = top;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                            PbFragment.this.iCt.getListView().setSelectionFromTop(0, i7 - equipmentHeight);
                                                                                            PbFragment.this.iCt.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.iCt.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.iCm > 0) {
                                                                                        if (PbFragment.this.iCt.getListView().getChildAt(PbFragment.this.iCm) != null) {
                                                                                            PbFragment.this.iCt.getListView().smoothScrollToPosition(PbFragment.this.iCm, PbFragment.this.iCn, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iCt.getListView().setSelectionFromTop(PbFragment.this.iCm, PbFragment.this.iCn + equipmentHeight);
                                                                                            PbFragment.this.iCt.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int ckf = PbFragment.this.ckf();
                                                                                        if (PbFragment.this.cke() != -1) {
                                                                                            ckf--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (ckf < 0) {
                                                                                            i2 = PbFragment.this.iCt.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.iCt.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = ckf;
                                                                                            i3 = dimens;
                                                                                        }
                                                                                        if (z9) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!cih || PbFragment.this.iCt.cmJ() == null) {
                                                                                            if (PbFragment.this.iCt.iIK != null && PbFragment.this.iCt.iIK.mNavigationBar != null) {
                                                                                                i3 += PbFragment.this.iCt.iIK.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbFragment.this.iCt.cmJ().cok();
                                                                                        }
                                                                                        if (PbFragment.this.iCt.iJQ == null || PbFragment.this.iCt.iJQ.iKU == null || PbFragment.this.iCt.iJQ.iKU.getView() == null || PbFragment.this.iCt.iJQ.iKU.getView().getParent() == null) {
                                                                                            PbFragment.this.iCt.getListView().setSelectionFromTop(i2, i3 + equipmentHeight);
                                                                                            PbFragment.this.iCt.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z9) {
                                                                                            PbFragment.this.iCt.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iCt.getListView().smoothScrollBy(PbFragment.this.iCt.iJQ.iKU.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().azE() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", PbFragment.this.iyT.iET).cp("fid", PbFragment.this.iyT.getPbData().getForumId()).Z("obj_locate", 2).cp("uid", PbFragment.this.iyT.getPbData().chK().azE().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.iyT.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.iyT.clG() == 3) {
                                                                                    PbFragment.this.iBR.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.iyT.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.cp("tid", PbFragment.this.iyT.ckU());
                                                                                anVar4.cp("fid", PbFragment.this.iyT.getForumId());
                                                                                anVar4.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar = (bj) view.getTag();
                                                                                if (PbFragment.this.iyT.clG() == 3 && PbFragment.this.ciJ() && PbFragment.this.iyT.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.iyT.getPbData().cie())) {
                                                                                    PbFragment.this.iBR.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar.azJ(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.cp("tid", bjVar.getId());
                                                                                anVar5.s("fid", bjVar.getFid());
                                                                                anVar5.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbFragment.this.iyT != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.cp("tid", PbFragment.this.iyT.ckU());
                                                                                anVar6.cp("fid", PbFragment.this.iyT.getForumId());
                                                                                anVar6.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.Z("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.iyT.getPbData();
                                                                                if (PbFragment.this.iCs == null) {
                                                                                    PbFragment.this.iCs = new com.baidu.tieba.pb.data.n(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData4.getThreadId(), 0L);
                                                                                long j3 = com.baidu.adp.lib.f.b.toLong(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").s("forum_id", j3).aDT();
                                                                                PbFragment.this.registerListener(PbFragment.this.iDs);
                                                                                PbFragment.this.iCs.D(j2, j3);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").cp("fid", PbFragment.this.iyT.getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).cp("obj_source", "PB_card").cp("tid", PbFragment.this.iyT.ckU()).Z("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar2 = (bj) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar2.azJ(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_adlocate", 9).Z("obj_locate", 9).s("obj_id", bjVar2.getFid()).cp("tid", bjVar2.getId()).Z("thread_type", bjVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bj) && PbFragment.this.checkUpIsLogin()) {
                                                                                bj bjVar3 = (bj) view.getTag();
                                                                                if (PbFragment.this.dfB != null) {
                                                                                    PbFragment.this.dfB.er(bjVar3.azJ(), String.valueOf(bjVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_adlocate", 10).Z("obj_locate", 11).s("obj_id", bjVar3.getFid()).cp("tid", bjVar3.getId()).Z("thread_type", bjVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.iyT.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.iyT.ckU(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.iyT.getPbData().chK().azY())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.iCt.cny();
                                                                SparseArray<Object> b3 = PbFragment.this.iCt.b(PbFragment.this.iyT.getPbData(), PbFragment.this.iyT.ckV(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iyT.getPbData().getForum().getId(), PbFragment.this.iyT.getPbData().getForum().getName(), PbFragment.this.iyT.getPbData().chK().getId(), String.valueOf(PbFragment.this.iyT.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.t(true, false);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).Z("obj_type", 0).Z("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).Z("obj_type", 1).Z("obj_source", 1));
                                                            }
                                                            PbFragment.this.iCt.iIK.coA();
                                                        }
                                                    } else if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null) {
                                                        PbFragment.this.iCt.iIK.apm();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.Fq(PbFragment.this.iyT.getPbData().chK().azU());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.iCt.cny();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.iyT.cln()));
                                                            return;
                                                        }
                                                        PbFragment.this.yD(2);
                                                        PbFragment.this.bBD();
                                                        PbFragment.this.iCt.cnf();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.iyT.getPbData().iwf == null || PbFragment.this.iyT.getPbData().iwf.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.iyT.getPbData().iwf.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbFragment.this.iyT.getPbData().iwf.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbFragment.this.iyT.getPbData().iwf.get(i10).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.iyT.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbFragment.this.iyT.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbFragment.this.iyT.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbFragment.this.iyT.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").Z("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).Z("obj_type", i12));
                                                                if (PbFragment.this.iyT.getPbData().iwf != null && PbFragment.this.iyT.getPbData().iwf.size() > i11) {
                                                                    i11 = PbFragment.this.iyT.getPbData().iwf.get(i11).sort_type.intValue();
                                                                }
                                                                boolean yL = PbFragment.this.iyT.yL(i11);
                                                                view.setTag(Integer.valueOf(PbFragment.this.iyT.cln()));
                                                                if (yL) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.iCt.pQ(true);
                                                                }
                                                            }
                                                        });
                                                        iVar.showDialog();
                                                    } else {
                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                        return;
                                                    }
                                                }
                                            } else {
                                                PbFragment.this.iCt.cny();
                                                if (PbFragment.this.ciU().getPbData().iwg != 2) {
                                                    if (PbFragment.this.iyT.getPageData() != null) {
                                                        PbFragment.this.iCt.a(PbFragment.this.iyT.getPageData(), PbFragment.this.f8int);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) {
                                            if (PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().azE() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", PbFragment.this.iyT.iET).cp("fid", PbFragment.this.iyT.getPbData().getForumId()).Z("obj_locate", 4).cp("uid", PbFragment.this.iyT.getPbData().chK().azE().getUserId()));
                                            }
                                            int i11 = 1;
                                            if (PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null) {
                                                bj chK = PbFragment.this.iyT.getPbData().chK();
                                                if (chK.ays()) {
                                                    i11 = 2;
                                                } else if (chK.aBz()) {
                                                    i11 = 3;
                                                } else if (chK.aBA()) {
                                                    i11 = 4;
                                                } else if (chK.aBB()) {
                                                    i11 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.cp("tid", PbFragment.this.iyT.ckU());
                                            anVar7.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.cp("fid", PbFragment.this.iyT.getForumId());
                                            anVar7.Z("obj_locate", 6);
                                            anVar7.Z("obj_name", i11);
                                            anVar7.Z("obj_type", 1);
                                            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                anVar7.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                            }
                                            TiebaStatic.log(anVar7);
                                            if (com.baidu.adp.lib.util.l.isNetOk()) {
                                                if (PbFragment.this.iyT.getPbData() != null) {
                                                    ArrayList<PostData> chM2 = PbFragment.this.iyT.getPbData().chM();
                                                    if ((chM2 != null && chM2.size() > 0) || !PbFragment.this.iyT.ckV()) {
                                                        PbFragment.this.iCt.cny();
                                                        PbFragment.this.bBD();
                                                        PbFragment.this.yD(2);
                                                        if (PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().cid() != null && !StringUtils.isNull(PbFragment.this.iyT.getPbData().cid().axX(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cp("fid", PbFragment.this.iyT.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                        if (ShareSwitch.isOn()) {
                                                            PbFragment.this.yE(6);
                                                        } else {
                                                            PbFragment.this.iCt.showLoadingDialog();
                                                            PbFragment.this.iyT.clB().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
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
                                                PbFragment.this.showToast(R.string.neterror);
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.iCt.cny();
                                        if (PbFragment.this.iCt.iIK.coB() != null && view == PbFragment.this.iCt.iIK.coB().cmg() && !PbFragment.this.iCt.cnQ()) {
                                            PbFragment.this.iCt.cmK();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bBD();
                                            PbFragment.this.iCt.cnf();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                u = PbFragment.this.iyT.u(true, PbFragment.this.ckn());
                                            } else {
                                                u = view.getId() == R.id.reply_title ? PbFragment.this.iyT.u(false, PbFragment.this.ckn()) : PbFragment.this.iyT.Fw(PbFragment.this.ckn());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbFragment.this.iCt.pq(true);
                                                PbFragment.this.iCt.bTG();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.iCt.pQ(true);
                                            }
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbFragment.this.yD(2);
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
                                    PbFragment.this.iCt.cny();
                                    if (PbFragment.this.yC(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.iyT.yM(PbFragment.this.iCt.cnk()) != null) {
                                        PbFragment.this.cki();
                                        if (PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().azE() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", PbFragment.this.iyT.iET).cp("fid", PbFragment.this.iyT.getPbData().getForumId()).Z("obj_locate", 3).cp("uid", PbFragment.this.iyT.getPbData().chK().azE().getUserId()));
                                        }
                                        if (PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().azE() != null && PbFragment.this.iyT.getPbData().chK().azE().getUserId() != null && PbFragment.this.iCr != null) {
                                            int g = PbFragment.this.g(PbFragment.this.iyT.getPbData());
                                            bj chK2 = PbFragment.this.iyT.getPbData().chK();
                                            int i12 = 1;
                                            if (chK2.ays()) {
                                                i12 = 2;
                                            } else if (chK2.aBz()) {
                                                i12 = 3;
                                            } else if (chK2.aBA()) {
                                                i12 = 4;
                                            } else if (chK2.aBB()) {
                                                i12 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cp("tid", PbFragment.this.iyT.iET).Z("obj_locate", 1).cp("obj_id", PbFragment.this.iyT.getPbData().chK().azE().getUserId()).Z("obj_type", PbFragment.this.iCr.awd() ? 0 : 1).Z("obj_source", g).Z("obj_param1", i12));
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
                                if (PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().aAE() && PbFragment.this.iyT.getPbData().chK().azV() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.iyT.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.iyT.ciK()) || PbFragment.this.iyT.getAppealInfo() == null) {
                                        PbFragment.this.iBR.finish();
                                        return;
                                    }
                                    name = PbFragment.this.iyT.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.iyT.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.iBR.finish();
                                    return;
                                }
                                String ciK = PbFragment.this.iyT.ciK();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.iyT.ckW() && ciK != null && ciK.equals(name)) {
                                    PbFragment.this.iBR.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.iyT.getPbData() != null) {
                                if ((PbFragment.this.iyT.getPbData().chW() == 1 || PbFragment.this.iyT.getPbData().chW() == 3) && !PbFragment.this.fEP.cJi()) {
                                    PbFragment.this.iCt.cny();
                                    int i13 = 0;
                                    if (PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cmh()) {
                                        if (PbFragment.this.iCt.iIK.coB() == null || view != PbFragment.this.iCt.iIK.coB().cmj()) {
                                            if (view == PbFragment.this.iCt.cnd()) {
                                                i13 = 2;
                                            }
                                        } else if (PbFragment.this.iyT.getPbData().chK().azA() == 1) {
                                            i13 = 3;
                                        } else {
                                            i13 = 6;
                                        }
                                    } else if (PbFragment.this.iyT.getPbData().chK().azz() == 1) {
                                        i13 = 5;
                                    } else {
                                        i13 = 4;
                                    }
                                    ForumData forum = PbFragment.this.iyT.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.iyT.getPbData().chK().getId();
                                    PbFragment.this.iCt.cnc();
                                    PbFragment.this.fEP.b(id4, name2, id5, i13, PbFragment.this.iCt.cne());
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
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.iCt.cny();
                        PbFragment.this.bBD();
                        PbFragment.this.iCt.cnf();
                        PbFragment.this.iCt.showLoadingDialog();
                        if (PbFragment.this.iCt.cmS() != null) {
                            PbFragment.this.iCt.cmS().setVisibility(8);
                        }
                        PbFragment.this.iyT.yG(1);
                        if (PbFragment.this.iBT != null) {
                            PbFragment.this.iBT.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cjV = PbFragment.this.cjV();
                        if (!TextUtils.isEmpty(cjV)) {
                            ba.aEa().b(PbFragment.this.getPageContext(), new String[]{cjV});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.cp("tid", PbFragment.this.iyT.ckU());
                anVar8.cp("fid", PbFragment.this.iyT.getForumId());
                anVar8.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.Z("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.iCc) {
                    PbFragment.this.iCc = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.cjP().cmH() != null && postData5.azE() != null && postData5.cIt() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cjP().cmI() != null) {
                                PbFragment.this.cjP().cmI().cjF();
                            }
                            com.baidu.tieba.pb.data.m mVar2 = new com.baidu.tieba.pb.data.m();
                            mVar2.a(PbFragment.this.iyT.getPbData().getForum());
                            mVar2.setThreadData(PbFragment.this.iyT.getPbData().chK());
                            mVar2.f(postData5);
                            PbFragment.this.cjP().cmH().d(mVar2);
                            PbFragment.this.cjP().cmH().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.azE().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iyT.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.iCG != null) {
                                PbFragment.this.iCt.qa(PbFragment.this.iCG.aMi());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iyT.getPbData() != null) {
                    anVar.cp("fid", PbFragment.this.iyT.getPbData().getForumId());
                }
                anVar.cp("tid", PbFragment.this.iyT.ckU());
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bBD();
            PbFragment.this.iCt.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.ciU() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.ciU().Fz(postWriteCallBackData.getPostId());
                    PbFragment.this.iCT = PbFragment.this.iCt.cmO();
                    PbFragment.this.iyT.cr(PbFragment.this.iCT, PbFragment.this.iCt.cmP());
                }
                PbFragment.this.iCt.cny();
                PbFragment.this.iCx.cnV();
                if (PbFragment.this.iCG != null) {
                    PbFragment.this.iCt.qa(PbFragment.this.iCG.aMi());
                }
                PbFragment.this.iCt.cmG();
                PbFragment.this.iCt.qc(true);
                PbFragment.this.iyT.clp();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.iyT.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.iyT.getPbData();
                            if (pbData != null && pbData.chK() != null && pbData.chK().azE() != null && (userId = pbData.chK().azE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.iyT.clf()) {
                                PbFragment.this.iCt.cnf();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.iyT.clf()) {
                            PbFragment.this.iCt.cnf();
                        }
                    } else if (floor != null) {
                        PbFragment.this.iCt.o(PbFragment.this.iyT.getPbData());
                    }
                    if (PbFragment.this.iyT.ckZ()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").cp("tid", PbFragment.this.iyT.ckU()));
                    }
                    PbFragment.this.cjY();
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.iCG.aMp() || PbFragment.this.iCG.aMq()) {
                    PbFragment.this.iCG.a(false, postWriteCallBackData);
                }
                PbFragment.this.iCx.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.hJV != null) {
                    PbFragment.this.hJV.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (yVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d iDr = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                    anVar.cp("fid", PbFragment.this.iyT.getPbData().getForumId());
                }
                if (PbFragment.this.iyT != null) {
                    anVar.cp("tid", PbFragment.this.iyT.ckU());
                }
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.iCx != null) {
                    PbFragment.this.iCx.cnU();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.hJV != null) {
                    PbFragment.this.hJV.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.iCx != null) {
                if (PbFragment.this.iCt != null && PbFragment.this.iCt.cmI() != null && PbFragment.this.iCt.cmI().cjJ() != null && PbFragment.this.iCt.cmI().cjJ().aMq()) {
                    PbFragment.this.iCt.cmI().cjJ().a(postWriteCallBackData);
                }
                PbFragment.this.iCx.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iDs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cnT;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.iBR.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.iCt != null && (cnT = PbFragment.this.iCt.cnT()) != null && PbFragment.this.iCt.getListView() != null) {
                            PbFragment.this.iCt.getListView().removeHeaderView(cnT);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a iDt = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.g lU;
            if (!z || fVar == null || fVar.chU() != null || com.baidu.tbadk.core.util.v.getCount(fVar.chM()) >= 1) {
                PbFragment.this.ick = true;
                PbFragment.this.iCt.cnh();
                if (fVar == null || !fVar.chQ()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.iCt.getView());
                }
                PbFragment.this.iCt.bTF();
                if (PbFragment.this.isFullScreen || PbFragment.this.iCt.cnQ()) {
                    PbFragment.this.iCt.cnH();
                } else if (!PbFragment.this.iCt.cnE()) {
                    PbFragment.this.iCt.qc(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.dZy = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.iCt.getView());
                    PbFragment.this.iCt.cnq();
                }
                if (z && fVar != null) {
                    bj chK = fVar.chK();
                    if (chK == null || !chK.aBC()) {
                        PbFragment.this.d(PbFragment.this.iCF);
                    } else {
                        ckG();
                    }
                    PbFragment.this.iCt.cmI().setPbData(fVar);
                    PbFragment.this.iCt.bdR();
                    if (chK != null && chK.aAN() != null) {
                        PbFragment.this.a(chK.aAN());
                    }
                    if (PbFragment.this.iCG != null) {
                        PbFragment.this.iCt.qa(PbFragment.this.iCG.aMi());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.chM() != null && fVar.chM().size() >= 1 && fVar.chM().get(0) != null) {
                        PbFragment.this.iyT.Fy(fVar.chM().get(0).getId());
                    } else if (fVar.chU() != null) {
                        PbFragment.this.iyT.Fy(fVar.chU().getId());
                    }
                    if (PbFragment.this.iCG != null) {
                        PbFragment.this.iCG.a(fVar.getAnti());
                        PbFragment.this.iCG.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.iCG.setThreadData(chK);
                        PbFragment.this.iCG.a(PbFragment.this.iyT.clj(), PbFragment.this.iyT.ckU(), PbFragment.this.iyT.clD());
                        if (chK != null) {
                            PbFragment.this.iCG.gw(chK.aAY());
                        }
                    }
                    if (PbFragment.this.iCr != null) {
                        PbFragment.this.iCr.fa(fVar.awd());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.cik()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.iCt.qb(PbFragment.this.mIsFromCDN);
                    PbFragment.this.iCt.a(fVar, i2, i3, PbFragment.this.iyT.ckV(), i4, PbFragment.this.iyT.getIsFromMark());
                    PbFragment.this.iCt.d(fVar, PbFragment.this.iyT.ckV());
                    PbFragment.this.iCt.pY(PbFragment.this.iyT.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.dtY = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.dtY) && PbFragment.this.iCG != null && PbFragment.this.iCG.aLC() != null && (lU = PbFragment.this.iCG.aLC().lU(6)) != null && !TextUtils.isEmpty(PbFragment.this.dtY)) {
                            ((View) lU).setOnClickListener(PbFragment.this.duK);
                        }
                    }
                    if (PbFragment.this.iCB) {
                        PbFragment.this.iCB = false;
                        final int cke = PbFragment.this.cke();
                        if (!fVar.cih()) {
                            PbFragment.this.iCt.yT(cke);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cke, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.iCC) {
                        PbFragment.this.iCC = false;
                        final int cke2 = PbFragment.this.cke();
                        final boolean z2 = cke2 != -1;
                        if (!z2) {
                            cke2 = PbFragment.this.ckf();
                        }
                        if (PbFragment.this.iCt != null) {
                            if (!fVar.cih()) {
                                PbFragment.this.iCt.yT(cke2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cke2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.iCt.setSelectionFromTop(cke2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.iCt.setSelectionFromTop(cke2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.iCt.qd(true);
                                PbFragment.this.iCt.qc(false);
                            }
                        }
                    } else if (PbFragment.this.iCD) {
                        PbFragment.this.iCD = false;
                        PbFragment.this.iCt.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.iCt.cnl();
                    }
                    PbFragment.this.iyT.a(fVar.getForum(), PbFragment.this.iDh);
                    PbFragment.this.iyT.a(PbFragment.this.iDi);
                    if (PbFragment.this.hJV != null && chK != null && chK.azE() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(chK.azE());
                        PbFragment.this.hJV.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.dZy && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.iyT.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.iyT.getAppealInfo().ivY)) {
                                    PbFragment.this.iCt.a(PbFragment.this.iyT.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.iCt.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.iCt.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.iCt.cnH();
                            PbFragment.this.iCt.cnp();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.iyT.ckU());
                            jSONObject.put("fid", PbFragment.this.iyT.getForumId());
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
                        PbFragment.this.iCt.FD("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                            arrayList = PbFragment.this.iyT.getPbData().chM();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cIt() != 1)) {
                            PbFragment.this.iCt.FD(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbFragment.this.cky()) {
                            PbFragment.this.iCt.FE(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbFragment.this.iCt.FE(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbFragment.this.iCt.endLoadData();
                }
                if (fVar != null && fVar.iwm && PbFragment.this.dzt == 0) {
                    PbFragment.this.dzt = System.currentTimeMillis() - PbFragment.this.fPB;
                }
                if (!PbFragment.this.ciU().ckV() || PbFragment.this.ciU().getPbData().getPage().ayz() != 0 || PbFragment.this.ciU().clx()) {
                    PbFragment.this.iCH = true;
                    return;
                }
                return;
            }
            PbFragment.this.iyT.yG(1);
            if (PbFragment.this.iBT != null) {
                PbFragment.this.iBT.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void ckG() {
            if (PbFragment.this.iyT != null) {
                if (PbFragment.this.iCG == null || !PbFragment.this.iCG.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.iCG = (com.baidu.tbadk.editortools.pb.e) dVar.dR(PbFragment.this.getContext());
                    PbFragment.this.iCG.a(PbFragment.this.iBR.getPageContext());
                    PbFragment.this.iCG.a(PbFragment.this.dui);
                    PbFragment.this.iCG.a(PbFragment.this.dub);
                    PbFragment.this.iCG.a(PbFragment.this.iBR.getPageContext(), PbFragment.this.iBR.getIntent() == null ? null : PbFragment.this.iBR.getIntent().getExtras());
                    PbFragment.this.iCG.aLC().gp(true);
                    PbFragment.this.iCt.setEditorTools(PbFragment.this.iCG.aLC());
                    if (!PbFragment.this.iyT.cla()) {
                        PbFragment.this.iCG.uP(PbFragment.this.iyT.ckU());
                    }
                    if (PbFragment.this.iyT.clE()) {
                        PbFragment.this.iCG.uO(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.iCt != null) {
                        PbFragment.this.iCG.uO(PbFragment.this.iCt.cmM());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.iCt.o(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.aOA().aOB()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.fPB : j;
                if (PbFragment.this.dzt == 0) {
                    PbFragment.this.dzt = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.dzl, PbFragment.this.createTime, PbFragment.this.dzt, z2, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.dzl = 0L;
                if (iVar != null) {
                    iVar.aOx();
                }
                if (z2) {
                    iVar.dzC = currentTimeMillis;
                    iVar.gH(true);
                }
                if (!z2 && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null) {
                    int threadType = PbFragment.this.iyT.getPbData().chK().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iCf, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iCf, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.dzE = currentTimeMillis;
                                iVar2.mu(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.dzE = currentTimeMillis;
                        dVar.mu(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener iDu = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cjZ();
            }
        }
    };
    private final a.InterfaceC0362a iDv = new a.InterfaceC0362a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0362a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.iCt.cnh();
            if (z) {
                if (PbFragment.this.iCr != null) {
                    PbFragment.this.iCr.fa(z2);
                }
                PbFragment.this.iyT.pI(z2);
                if (PbFragment.this.iyT.awd()) {
                    PbFragment.this.ckj();
                } else {
                    PbFragment.this.iCt.o(PbFragment.this.iyT.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.iCr != null) {
                        if (PbFragment.this.iCr.awg() != null && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().azE() != null) {
                            MarkData awg = PbFragment.this.iCr.awg();
                            MetaData azE = PbFragment.this.iyT.getPbData().chK().azE();
                            if (awg != null && azE != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), azE.getUserId()) && !azE.hadConcerned()) {
                                    PbFragment.this.b(azE);
                                } else {
                                    PbFragment.this.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    PbFragment.this.ckg();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.ys(PbFragment.this.mLastScrollState) && PbFragment.this.ys(i)) {
                if (PbFragment.this.iCt != null) {
                    PbFragment.this.iCt.cny();
                    if (PbFragment.this.iCG != null && !PbFragment.this.iCt.cmL()) {
                        PbFragment.this.iCt.qa(PbFragment.this.iCG.aMi());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.iCt.cmK();
                    }
                }
                if (!PbFragment.this.iBZ) {
                    PbFragment.this.iBZ = true;
                    if (PbFragment.this.iCt != null) {
                        PbFragment.this.iCt.cnD();
                    }
                }
            }
            if (PbFragment.this.iCt != null) {
                PbFragment.this.iCt.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iBT != null) {
                PbFragment.this.iBT.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iCa == null) {
                PbFragment.this.iCa = new com.baidu.tbadk.n.b();
                PbFragment.this.iCa.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.iCa.aOr();
            } else {
                PbFragment.this.iCa.aOq();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.r.c.cHo().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> chM;
            if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null && PbFragment.this.iCt != null && PbFragment.this.iCt.cnb() != null) {
                PbFragment.this.iCt.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.iBT != null) {
                    PbFragment.this.iBT.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.iyT.cls() && (chM = PbFragment.this.iyT.getPbData().chM()) != null && !chM.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.iCt.cnb().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.iyT.getPbData();
                    if (pbData != null) {
                        if (pbData.chN() != null && pbData.chN().hasData()) {
                            headerCount--;
                        }
                        if (pbData.chO() != null && pbData.chO().hasData()) {
                            headerCount--;
                        }
                        int size = chM.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d fEU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbFragment.this.fEP.getLoadDataMode()) {
                    case 0:
                        PbFragment.this.iyT.clp();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iQH != 1002 || bVar.eGA) {
                            z = true;
                        }
                        PbFragment.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbFragment.this.iCt.a(1, dVar.mSuccess, dVar.kew, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment.this.a(PbFragment.this.fEP.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbFragment.this.iCt.a(PbFragment.this.fEP.getLoadDataMode(), gVar.mSuccess, gVar.kew, false);
                        PbFragment.this.iCt.aM(gVar.keA);
                        return;
                    default:
                        return;
                }
            }
            PbFragment.this.iCt.a(PbFragment.this.fEP.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final c iDw = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
    };
    private final g.c dXo = new g.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cko()) {
                PbFragment.this.iBR.finish();
            }
            if (!PbFragment.this.iyT.pH(true)) {
                PbFragment.this.iCt.cni();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e gDt = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.iDx && PbFragment.this.cko()) {
                PbFragment.this.ckq();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.iyT.pG(false)) {
                    PbFragment.this.iCt.cng();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.iyT.getPbData() != null) {
                    PbFragment.this.iCt.cnC();
                }
                PbFragment.this.iDx = true;
            }
        }
    };
    private int iDy = 0;
    private final TbRichTextView.i dIi = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f cnb;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.iCt.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.cp("tid", PbFragment.this.iyT.ckU());
                anVar.cp("fid", PbFragment.this.iyT.getForumId());
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.Z("obj_locate", 3);
                anVar.Z("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.iyT.izO.cik()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        if (view.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aRg() != null) {
                                ArrayList<TbRichTextImageInfo> aRg = tbRichTextView.getRichText().aRg();
                                int i4 = 0;
                                while (i4 < aRg.size()) {
                                    if (aRg.get(i4) != null) {
                                        arrayList.add(aRg.get(i4).getSrc());
                                        if (i3 == -1 && str != null && str.equals(aRg.get(i4).getSrc())) {
                                            i3 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = aRg.get(i4).getSrc();
                                        imageUrlData.originalUrl = aRg.get(i4).getSrc();
                                        imageUrlData.isLongPic = aRg.get(i4).aRE();
                                        concurrentHashMap.put(aRg.get(i4).getSrc(), imageUrlData);
                                    }
                                    i4++;
                                    i3 = i3;
                                }
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.iyT.clm(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.iyT.getPbData().chK());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.izb) {
                        TbRichText bk = PbFragment.this.bk(str, i);
                        if (bk != null && PbFragment.this.iDy >= 0 && PbFragment.this.iDy < bk.aRf().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.g.b(bk.aRf().get(PbFragment.this.iDy));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.iyY.size()) {
                                    break;
                                } else if (!aVar.iyY.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bk.getPostId() != 0 && (cnb = PbFragment.this.iCt.cnb()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = cnb.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bk.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bk.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.iyT.clD(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iyT.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.iyZ.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iza, aVar.lastId, PbFragment.this.iyT.clm(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.iyT.getPbData().chK());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.iyY, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.iyZ.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iza, aVar.iyY.get(0), PbFragment.this.iyT.clm(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.iyT.getPbData().chK());
                    }
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.iCj = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean iDz = false;
    PostData hbU = null;
    private final b.a iDA = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.hbU != null) {
                if (i == 0) {
                    PbFragment.this.hbU.fu(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.hbU = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.k(PbFragment.this.hbU);
                }
            }
        }
    };
    private final b.a iDB = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iCQ != null && !TextUtils.isEmpty(PbFragment.this.iCR)) {
                if (i == 0) {
                    if (PbFragment.this.iCS == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iCR));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.iCR;
                        aVar.pkgId = PbFragment.this.iCS.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iCS.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.gLl == null) {
                            PbFragment.this.gLl = new au(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.gLl.j(PbFragment.this.iCR, PbFragment.this.iCQ.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.iCQ = null;
                PbFragment.this.iCR = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01f8  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            int i;
            SparseArray sparseArray;
            if (!PbFragment.this.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (PbFragment.this.cr(view)) {
                    if (view instanceof TbImageView) {
                        PbFragment.this.iCQ = ((TbImageView) view).getBdImage();
                        PbFragment.this.iCR = ((TbImageView) view).getUrl();
                        if (PbFragment.this.iCQ == null || TextUtils.isEmpty(PbFragment.this.iCR)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iCS = null;
                        } else {
                            PbFragment.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.iCQ = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.iCR = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.iCS = null;
                            } else {
                                PbFragment.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.iCQ = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.iCR = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iCS = null;
                        } else {
                            PbFragment.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.iCt.a(PbFragment.this.iDB, PbFragment.this.iCQ.isGif());
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
            PbFragment.this.hbU = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.hbU == null) {
                return true;
            }
            if (PbFragment.this.hbU.cIt() != 1 || !PbFragment.this.cr(view)) {
                if (PbFragment.this.iCr != null) {
                    if (!PbFragment.this.iCr.awd() || PbFragment.this.hbU.getId() == null || !PbFragment.this.hbU.getId().equals(PbFragment.this.iyT.azN())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.ciU().getPbData() != null && PbFragment.this.ciU().getPbData().cik();
                    if (PbFragment.this.hbU.cIt() != 1) {
                        if (PbFragment.this.iCz == null) {
                            PbFragment.this.iCz = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.iCz.a(PbFragment.this.iDC);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = false;
                            boolean z5 = PbFragment.this.cr(view) && !z3;
                            boolean z6 = (!PbFragment.this.cr(view) || PbFragment.this.iCQ == null || PbFragment.this.iCQ.isGif()) ? false : true;
                            boolean z7 = false;
                            boolean z8 = false;
                            boolean z9 = false;
                            boolean z10 = false;
                            boolean z11 = false;
                            boolean z12 = false;
                            if (sparseArray2.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean) {
                                z4 = ((Boolean) sparseArray2.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean) {
                                z7 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                z8 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                z10 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                z11 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                            }
                            if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                z12 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                            }
                            if (!(sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                str = null;
                            } else {
                                str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                            }
                            if (z4) {
                                long j = 0;
                                String str2 = "";
                                if (sparseArray2.get(R.id.tag_chudian_template_id) instanceof Long) {
                                    j = ((Long) sparseArray2.get(R.id.tag_chudian_template_id)).longValue();
                                }
                                if (sparseArray2.get(R.id.tag_chudian_monitor_id) instanceof String) {
                                    str2 = (String) sparseArray2.get(R.id.tag_chudian_monitor_id);
                                }
                                if (!(sparseArray2.get(R.id.tag_chudian_hide_day) instanceof Integer)) {
                                    i = 0;
                                } else {
                                    i = ((Integer) sparseArray2.get(R.id.tag_chudian_hide_day)).intValue();
                                }
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbFragment.this.getString(R.string.no_interesting), PbFragment.this.iCz);
                                gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                arrayList.add(gVar3);
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.iCz));
                            }
                            if (z6) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.iCz));
                            }
                            if (!z5 && !z6) {
                                com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iCz);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.hbU);
                                gVar4.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar4);
                            }
                            if (!z7 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iCz);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iCz);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.hbU);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z10 && z9) {
                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iCz);
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
                                    gVar5.mTextView.setTag(sparseArray5);
                                    arrayList.add(gVar5);
                                } else {
                                    if (!ap.o(PbFragment.this.hbU)) {
                                        z2 = PbFragment.this.pw(z8) && TbadkCoreApplication.isLogin();
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2 && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iCz);
                                        gVar6.mTextView.setTag(str);
                                        arrayList.add(gVar6);
                                    }
                                }
                                com.baidu.tbadk.core.dialog.g gVar7 = null;
                                if (z10) {
                                    SparseArray sparseArray6 = new SparseArray();
                                    sparseArray6.put(R.id.tag_should_manage_visible, true);
                                    sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                    sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                                    sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                                    sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                                    sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                                    if (z11) {
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
                                    if (z12) {
                                        sparseArray6.put(R.id.tag_should_delete_visible, true);
                                        sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                                        sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                        sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iCz);
                                        gVar7.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iCz);
                                    gVar.mTextView.setTag(sparseArray6);
                                } else {
                                    if (z12) {
                                        SparseArray sparseArray7 = new SparseArray();
                                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                        if (PbFragment.this.iyT.getPbData().chW() == 1002 && !z8) {
                                            gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iCz);
                                        } else {
                                            gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iCz);
                                        }
                                        gVar7.mTextView.setTag(sparseArray7);
                                    }
                                    gVar = null;
                                }
                                if (gVar7 != null) {
                                    arrayList.add(gVar7);
                                }
                                if (gVar != null) {
                                    arrayList.add(gVar);
                                }
                            }
                            PbFragment.this.iCz.aA(arrayList);
                            PbFragment.this.iCy = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iCz);
                            PbFragment.this.iCy.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").cp("tid", PbFragment.this.iyT.iET).cp("fid", PbFragment.this.iyT.getForumId()).cp("uid", PbFragment.this.iyT.getPbData().chK().azE().getUserId()).cp("post_id", PbFragment.this.iyT.aLX()).Z("obj_source", z7 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.iCt.a(PbFragment.this.iDA, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.iCt.a(PbFragment.this.iDB, PbFragment.this.iCQ.isGif());
            return true;
        }
    };
    private k.c iDC = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbFragment.this.iCy != null) {
                PbFragment.this.iCy.dismiss();
            }
            switch (i) {
                case 0:
                    long j = -1;
                    String str = "";
                    int i2 = 0;
                    if (view.getTag(R.id.tag_chudian_template_id) instanceof Long) {
                        j = ((Long) view.getTag(R.id.tag_chudian_template_id)).longValue();
                    }
                    if (view.getTag(R.id.tag_chudian_monitor_id) instanceof String) {
                        str = (String) view.getTag(R.id.tag_chudian_monitor_id);
                    }
                    if (view.getTag(R.id.tag_chudian_hide_day) instanceof Integer) {
                        i2 = ((Integer) view.getTag(R.id.tag_chudian_hide_day)).intValue();
                    }
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.iyT.getPbData();
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    if (pbData != null && pbData.getForum() != null) {
                        str2 = pbData.getForum().getId();
                        str3 = pbData.getForum().getName();
                        str4 = pbData.getThreadId();
                    }
                    com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                    PbFragment.this.a(j, str, str2, str3, str4, i2);
                    return;
                case 1:
                    if (PbFragment.this.iCQ != null && !TextUtils.isEmpty(PbFragment.this.iCR)) {
                        if (PbFragment.this.iCS == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iCR));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.iCR;
                            aVar.pkgId = PbFragment.this.iCS.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iCS.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.iCQ = null;
                        PbFragment.this.iCR = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.iCQ != null && !TextUtils.isEmpty(PbFragment.this.iCR)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.gLl == null) {
                                PbFragment.this.gLl = new au(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.gLl.j(PbFragment.this.iCR, PbFragment.this.iCQ.getImageByte());
                            PbFragment.this.iCQ = null;
                            PbFragment.this.iCR = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.hbU != null) {
                        PbFragment.this.hbU.fu(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.hbU = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").Z("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cq(view);
                        if (PbFragment.this.iyT.getPbData().chK() != null && PbFragment.this.iyT.getPbData().chK().azE() != null && PbFragment.this.iyT.getPbData().chK().azE().getUserId() != null && PbFragment.this.iCr != null) {
                            int g = PbFragment.this.g(PbFragment.this.iyT.getPbData());
                            bj chK = PbFragment.this.iyT.getPbData().chK();
                            int i3 = 1;
                            if (chK.ays()) {
                                i3 = 2;
                            } else if (chK.aBz()) {
                                i3 = 3;
                            } else if (chK.aBA()) {
                                i3 = 4;
                            } else if (chK.aBB()) {
                                i3 = 5;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cp("tid", PbFragment.this.iyT.iET).Z("obj_locate", 2).cp("obj_id", PbFragment.this.iyT.getPbData().chK().azE().getUserId()).Z("obj_type", PbFragment.this.iCr.awd() ? 0 : 1).Z("obj_source", g).Z("obj_param1", i3));
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13079"));
                        PbFragment.this.Fq((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").Z("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.b(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.iCt.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray3.put(R.id.tag_from, 1);
                                sparseArray3.put(R.id.tag_check_mute_from, 2);
                                PbFragment.this.b(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.iCt.cw(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.iCt.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final NoNetworkView.a ggy = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.iyT.clb()) {
                PbFragment.this.ckl();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener dne = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.gnc.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0488a fLT = new a.InterfaceC0488a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        final int eGd = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void u(int i, int i2) {
            if (ax(i2) && PbFragment.this.iCt != null && PbFragment.this.iBT != null) {
                PbFragment.this.iBT.lo(true);
                if (Math.abs(i2) > this.eGd) {
                    PbFragment.this.iBT.hideFloatingView();
                }
                if (PbFragment.this.cko()) {
                    PbFragment.this.iCt.cmY();
                    PbFragment.this.iCt.cmZ();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void v(int i, int i2) {
            if (ax(i2) && PbFragment.this.iCt != null && PbFragment.this.iBT != null) {
                PbFragment.this.iCt.cnI();
                PbFragment.this.iBT.lo(false);
                PbFragment.this.iBT.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void w(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final o.a iAZ = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.iCt.FF(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int iDE = -1;
    private int iDF = -1;

    /* loaded from: classes6.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes6.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e cjK() {
        return this.iCG;
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        MetaData metaData;
        boolean z = true;
        if (mVar.cix() != null) {
            String id = mVar.cix().getId();
            ArrayList<PostData> chM = this.iyT.getPbData().chM();
            int i = 0;
            while (true) {
                if (i >= chM.size()) {
                    break;
                }
                PostData postData = chM.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> ciB = mVar.ciB();
                    postData.Ck(mVar.getTotalCount());
                    if (postData.cIq() != null && ciB != null) {
                        Iterator<PostData> it = ciB.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.azE() != null && (metaData = postData.getUserMap().get(next.azE().getUserId())) != null) {
                                next.a(metaData);
                                next.sy(true);
                                next.a(getPageContext(), this.iyT.Fx(metaData.getUserId()));
                            }
                        }
                        boolean z2 = ciB.size() != postData.cIq().size();
                        postData.cIq().clear();
                        postData.cIq().addAll(ciB);
                        z = z2;
                    }
                    if (postData.cIm() != null) {
                        postData.cIn();
                    }
                }
            }
            if (!this.iyT.getIsFromMark() && z) {
                this.iCt.o(this.iyT.getPbData());
            }
            if (z) {
                c(mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fo(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m chZ = this.iyT.getPbData().chZ();
            if (chZ != null && str.equals(chZ.getAdId())) {
                if (chZ.cIh() != null) {
                    chZ.cIh().legoCard = null;
                }
                this.iyT.getPbData().cia();
            }
            com.baidu.tieba.tbadkCore.data.m clh = this.iyT.clh();
            if (clh != null && str.equals(clh.getAdId())) {
                this.iyT.cli();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iCy != null && this.iCy.isShowing()) {
                this.iCy.dismiss();
                this.iCy = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.iCy != null) {
                            PbFragment.this.iCy.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.iCt.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.iCO);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.iCO);
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
                kVar.aA(arrayList);
                this.iCy = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.iCy.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx(int i) {
        bj chK;
        if (this.iyT != null && this.iyT.getPbData() != null && (chK = this.iyT.getPbData().chK()) != null) {
            if (i == 1) {
                PraiseData azp = chK.azp();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (azp == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        chK.a(praiseData);
                    } else {
                        chK.azp().getUser().add(0, metaData);
                        chK.azp().setNum(chK.azp().getNum() + 1);
                        chK.azp().setIsLike(i);
                    }
                }
                if (chK.azp() != null) {
                    if (chK.azp().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(chK.azp().getNum());
                    }
                }
            } else if (chK.azp() != null) {
                chK.azp().setIsLike(i);
                chK.azp().setNum(chK.azp().getNum() - 1);
                ArrayList<MetaData> user = chK.azp().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            chK.azp().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (chK.azp().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = chK.azp().getNum() + "";
                }
            }
            if (this.iyT.ckV()) {
                this.iCt.cnb().notifyDataSetChanged();
            } else {
                this.iCt.p(this.iyT.getPbData());
            }
        }
    }

    public static PbFragment cjL() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iBR = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iyT.au(bundle);
        if (this.giZ != null) {
            this.giZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.iCG.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iBY = System.currentTimeMillis();
        this.iCM = getPageContext();
        final Intent intent = this.iBR.getIntent();
        if (intent != null) {
            this.fPB = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.iCf = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.iCf)) {
                    this.iCf = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.iCf)) {
                this.iBU = true;
            }
            this.iDE = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.iDF = intent.getIntExtra("key_manga_next_chapter", -1);
            this.iDG = intent.getStringExtra("key_manga_title");
            this.iCB = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.iCC = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.iCD = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cko()) {
                this.iBR.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.iCU = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.iCo = new ax();
            this.iCo.R(intent);
            this.iCW = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.iCW == 0) {
                this.iCW = intent.getIntExtra("key_start_from", 0);
            }
            this.iCX = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.fPB = System.currentTimeMillis();
        }
        this.dzl = this.iBY - this.fPB;
        super.onCreate(bundle);
        this.iBW = 0;
        at(bundle);
        if (this.iyT.getPbData() != null) {
            this.iyT.getPbData().Fk(this.source);
        }
        cjO();
        if (intent != null && this.iCt != null) {
            this.iCt.iII = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.iCP == null) {
                    this.iCP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.iCt.FH("@" + intent.getStringExtra("big_pic_type") + HanziToPinyin.Token.SEPARATOR);
                        }
                    };
                }
                com.baidu.adp.lib.f.e.gy().postDelayed(this.iCP, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.iyT.getPbData() != null) {
                this.iyT.FA(stringExtra);
            }
        }
        this.giZ = new VoiceManager();
        this.giZ.onCreate(getPageContext());
        initData(bundle);
        this.iCF = new com.baidu.tbadk.editortools.pb.g();
        d(this.iCF);
        this.iCG = (com.baidu.tbadk.editortools.pb.e) this.iCF.dR(getActivity());
        this.iCG.a(this.iBR.getPageContext());
        this.iCG.a(this.dui);
        this.iCG.a(this.dub);
        this.iCG.a(this.iBR.getPageContext(), bundle);
        this.iCG.aLC().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iCG.aLC().gp(true);
        pv(true);
        this.iCG.a(this.iyT.clj(), this.iyT.ckU(), this.iyT.clD());
        registerListener(this.iDc);
        if (!this.iyT.cla()) {
            this.iCG.uP(this.iyT.ckU());
        }
        if (this.iyT.clE()) {
            this.iCG.uO(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.iCt != null) {
            this.iCG.uO(this.iCt.cmM());
        }
        registerListener(this.iDb);
        registerListener(this.iDd);
        registerListener(this.iDe);
        registerListener(this.gko);
        registerListener(this.iDq);
        registerListener(this.iDa);
        this.iCE = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.kbj);
        this.iCE.cHV();
        registerListener(this.iDg);
        registerListener(this.cVS);
        this.iyT.clv();
        registerListener(this.iDu);
        registerListener(this.gkv);
        if (this.iCt != null && this.iCt.cnM() != null && this.iCt.cnN() != null) {
            this.iBT = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.iCt.cnM(), this.iCt.cnN(), this.iCt.cmS());
            this.iBT.a(this.iDl);
        }
        if (this.iBS && this.iCt != null && this.iCt.cnN() != null) {
            this.iCt.cnN().setVisibility(8);
        }
        this.iCN = new com.baidu.tbadk.core.view.d();
        this.iCN.toastTime = 1000L;
        registerListener(this.iDp);
        registerListener(this.iDn);
        registerListener(this.iDo);
        registerListener(this.gAq);
        registerListener(this.gkl);
        registerResponsedEventListener(TipEvent.class, this.gih);
        this.iCO = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iCO;
        userMuteAddAndDelCustomMessage.setTag(this.iCO);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iCO;
        userMuteCheckCustomMessage.setTag(this.iCO);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iyT.clB().a(this.iDm);
        this.iCx = new as();
        if (this.iCG.aMb() != null) {
            this.iCx.e(this.iCG.aMb().getInputView());
        }
        this.iCG.a(this.duc);
        this.gzi = new ShareSuccessReplyToServerModel();
        a(this.iCY);
        this.hJV = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.hJV.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.aj.a
            public void j(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.cVJ) {
                        PbFragment.this.iCG.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.cVK && PbFragment.this.iCt != null && PbFragment.this.iCt.cmI() != null && PbFragment.this.iCt.cmI().cjJ() != null) {
                        PbFragment.this.iCt.cmI().cjJ().aMx();
                    } else if (i == com.baidu.tbadk.core.util.aj.cVL) {
                        PbFragment.this.c(PbFragment.this.iCJ);
                    }
                }
            }
        });
        this.iCq = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.iCq.t(getUniqueId());
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
        com.baidu.tbadk.core.business.a.axr().cf("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.iBY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.iyT != null) {
            gVar.setForumName(this.iyT.ciK());
            if (this.iyT.getPbData() != null && this.iyT.getPbData().getForum() != null) {
                gVar.a(this.iyT.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.iyT);
        }
    }

    public String cjM() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cjN() {
        return this.iBT;
    }

    private void pv(boolean z) {
        this.iCG.gt(z);
        this.iCG.gu(z);
        this.iCG.gv(z);
    }

    private void cjO() {
        this.dfB = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.giZ != null) {
            this.giZ.onStart(getPageContext());
        }
    }

    public aq cjP() {
        return this.iCt;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel ciU() {
        return this.iyT;
    }

    public void Fp(String str) {
        if (this.iyT != null && !StringUtils.isNull(str) && this.iCt != null) {
            this.iCt.qf(true);
            this.iyT.Fp(str);
            this.iCe = true;
            this.iCt.cny();
            this.iCt.cnH();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.isPaused = false;
        } else {
            this.isPaused = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.iBW = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.iBW == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.giZ != null) {
            this.giZ.onPause(getPageContext());
        }
        if (this.iCt != null) {
            this.iCt.onPause();
        }
        if (!this.iyT.cla()) {
            this.iCG.saveDraft(this.iyT.ckU());
        }
        if (this.iyT != null) {
            this.iyT.clw();
        }
        com.baidu.tbadk.BdToken.c.auQ().auV();
        MessageManager.getInstance().unRegisterListener(this.hnU);
        bNj();
        MessageManager.getInstance().unRegisterListener(this.iDn);
        MessageManager.getInstance().unRegisterListener(this.iDo);
        MessageManager.getInstance().unRegisterListener(this.iDp);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cjQ() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.iyT.getPbData(), this.iyT.ckV(), this.iyT.clt());
        return (a2 == null || a2.azE() == null || a2.azE().getGodUserData() == null || a2.azE().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.iCh) {
            this.iCh = false;
            cku();
        }
        if (cjQ()) {
            this.iCb = System.currentTimeMillis();
        } else {
            this.iCb = -1L;
        }
        if (this.iCt != null && this.iCt.getView() != null) {
            if (!this.ick) {
                ckm();
            } else {
                hideLoadingView(this.iCt.getView());
            }
            this.iCt.onResume();
        }
        if (this.iBW == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.iCt != null) {
            noNetworkView = this.iCt.cmF();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.giZ != null) {
            this.giZ.onResume(getPageContext());
        }
        registerListener(this.hnU);
        this.iCA = false;
        ckt();
        registerListener(this.iDn);
        registerListener(this.iDo);
        registerListener(this.iDp);
        if (this.gjL) {
            ckl();
            this.gjL = false;
        }
        ckA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.iCt.pU(z);
        if (this.iCy != null) {
            this.iCy.dismiss();
        }
        if (z && this.iCA) {
            this.iCt.cng();
            this.iyT.pG(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iCb > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").cp("obj_duration", (System.currentTimeMillis() - this.iCb) + ""));
            this.iCb = 0L;
        }
        if (cjP().cmI() != null) {
            cjP().cmI().onStop();
        }
        if (this.iCt.iIK != null && !this.iCt.iIK.coD()) {
            this.iCt.iIK.releaseResources();
        }
        if (this.iyT != null && this.iyT.getPbData() != null && this.iyT.getPbData().getForum() != null && this.iyT.getPbData().chK() != null) {
            com.baidu.tbadk.distribute.a.aLq().a(getPageContext().getPageActivity(), "pb", this.iyT.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iyT.getPbData().chK().getId(), 0L));
        }
        if (this.giZ != null) {
            this.giZ.onStop(getPageContext());
        }
        com.baidu.tieba.r.c.cHo().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cp("fid", this.iyT.getPbData().getForumId());
            anVar.cp("tid", this.iyT.ckU());
            anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.iBZ && this.iCt != null) {
            this.iBZ = true;
            this.iCt.cnD();
            a(false, (PostData) null);
        }
        if (this.iyT != null) {
            this.iyT.cancelLoadData();
            this.iyT.destory();
            if (this.iyT.clA() != null) {
                this.iyT.clA().onDestroy();
            }
        }
        if (this.iCG != null) {
            this.iCG.onDestroy();
        }
        if (this.fEP != null) {
            this.fEP.cancelLoadData();
        }
        if (this.dfB != null) {
            this.dfB.cHI();
        }
        if (this.iCt != null) {
            this.iCt.onDestroy();
            if (this.iCt.iIK != null) {
                this.iCt.iIK.releaseResources();
            }
        }
        if (this.iCa != null) {
            this.iCa.aOs();
        }
        if (this.iBT != null) {
            this.iBT.aTW();
        }
        super.onDestroy();
        if (this.giZ != null) {
            this.giZ.onDestory(getPageContext());
        }
        if (this.iCt != null) {
            this.iCt.cny();
        }
        MessageManager.getInstance().unRegisterListener(this.iDn);
        MessageManager.getInstance().unRegisterListener(this.iDo);
        MessageManager.getInstance().unRegisterListener(this.iDp);
        MessageManager.getInstance().unRegisterListener(this.iCO);
        MessageManager.getInstance().unRegisterListener(this.iDq);
        MessageManager.getInstance().unRegisterListener(this.gkv);
        MessageManager.getInstance().unRegisterListener(this.gAq);
        MessageManager.getInstance().unRegisterListener(this.iDs);
        this.iCM = null;
        this.iCN = null;
        com.baidu.tieba.recapp.d.a.cAE().cAG();
        if (this.iCP != null) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iCP);
        }
        if (this.iCi != null) {
            this.iCi.cancelLoadData();
        }
        if (this.iCt != null && this.iCt.iIK != null) {
            this.iCt.iIK.coG();
        }
        if (this.gzi != null) {
            this.gzi.cancelLoadData();
        }
        this.iCx.onDestroy();
        if (this.iyT != null && this.iyT.clC() != null) {
            this.iyT.clC().onDestroy();
        }
        if (this.hJV != null) {
            this.hJV.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f cnb;
        ArrayList<PostData> cju;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aGu() && this.iCt != null && (cnb = this.iCt.cnb()) != null && (cju = cnb.cju()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cju.iterator();
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
                        bVar.fGK = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.cOx == 1 && !TextUtils.isEmpty(id)) {
                    next.cOx = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.fGK = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.iyT == null || this.iyT.getPbData() == null || this.iyT.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.iyT.getPbData().getForum().getFirst_class();
                    str2 = this.iyT.getPbData().getForum().getSecond_class();
                    str = this.iyT.getPbData().getForum().getId();
                    str4 = this.iyT.ckU();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aGx());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.iCt.onChangeSkinType(i);
            if (this.iCG != null && this.iCG.aLC() != null) {
                this.iCG.aLC().onChangeSkinType(i);
            }
            if (this.iCt.cmF() != null) {
                this.iCt.cmF().onChangeSkinType(getPageContext(), i);
            }
            this.iCx.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iCt = new aq(this, this.gle, this.dmm);
        this.gnc = new com.baidu.tieba.f.b(getActivity());
        this.gnc.a(iDD);
        this.gnc.a(this.fLT);
        this.iCt.setOnScrollListener(this.mOnScrollListener);
        this.iCt.d(this.gDt);
        this.iCt.setListPullRefreshListener(this.dXo);
        this.iCt.ph(com.baidu.tbadk.core.i.axf().isShowImages());
        this.iCt.setOnImageClickListener(this.dIi);
        this.iCt.b(this.mOnLongClickListener);
        this.iCt.g(this.ggy);
        this.iCt.a(this.iDw);
        this.iCt.pU(this.mIsLogin);
        if (this.iBR.getIntent() != null) {
            this.iCt.qg(this.iBR.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.iCt.cmH().setFromForumId(this.iyT.getFromForumId());
        this.iCt.setEditorTools(this.iCG.aLC());
        this.iCG.uO(this.iCt.cmM());
        this.iCt.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.iyT.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iyT.getPbData().getForum().getId(), PbFragment.this.iyT.getPbData().getForum().getName(), PbFragment.this.iyT.getPbData().chK().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.iCt.getView();
    }

    public void cjR() {
        if (this.iCt != null && this.iyT != null) {
            if ((this.iyT.getPbData() != null || this.iyT.getPbData().cig() != null) && checkUpIsLogin() && this.iCt.cnb() != null && this.iCt.cnb().cjz() != null) {
                this.iCt.cnb().cjz().tD(this.iyT.ckU());
            }
        }
    }

    public void cjS() {
        TiebaStatic.log("c12181");
        if (this.iCt != null && this.iyT != null) {
            if ((this.iCt == null || this.iCt.cmL()) && this.iyT.getPbData() != null && this.iyT.getPbData().cig() != null) {
                com.baidu.tieba.pb.data.l cig = this.iyT.getPbData().cig();
                if (checkUpIsLogin()) {
                    if ((!cig.ciu() || cig.aBc() != 2) && this.iCt.cnb() != null && this.iCt.cnb().cjz() != null) {
                        this.iCt.cnb().cjz().tD(this.iyT.ckU());
                    }
                    if (System.currentTimeMillis() - this.iCd > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).qL(false);
                        this.iCd = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cp(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.kbK && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.axf().isShowImages()) {
                    return Ft(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.iyT == null || this.iyT.getPbData() == null) {
                        return true;
                    }
                    if (cjP().cmI() != null) {
                        cjP().cmI().cjF();
                    }
                    com.baidu.tieba.pb.data.m mVar = new com.baidu.tieba.pb.data.m();
                    mVar.a(this.iyT.getPbData().getForum());
                    mVar.setThreadData(this.iyT.getPbData().chK());
                    mVar.f(postData);
                    cjP().cmH().d(mVar);
                    cjP().cmH().setPostId(postData.getId());
                    b(view, postData.azE().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iCG != null) {
                        this.iCt.qa(this.iCG.aMi());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cjT() {
        if (this.iBX == null) {
            this.iBX = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.iBX.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.iyO = PbFragment.this.iyO.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iyO);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iyT.ckU(), PbFragment.this.iyO, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.iyO = PbFragment.this.iyO.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iyO);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iyT.ckU(), PbFragment.this.iyO, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.iyO = PbFragment.this.iyO.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iyO);
                        bVar.dismiss();
                    }
                }
            }).jK(R.style.dialog_ani_b2t).jL(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.iDt.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).cqA(), "", 1);
    }

    private void at(Bundle bundle) {
        this.iyT = this.iBR.ciU();
        if (this.iyT.clz() != null) {
            this.iyT.clz().a(this.iAZ);
        }
        if (this.iyT.cly() != null) {
            this.iyT.cly().a(this.iDf);
        }
        if (this.iyT.clA() != null) {
            this.iyT.clA().b(this.iCZ);
        }
        if (StringUtils.isNull(this.iyT.ckU())) {
            this.iBR.finish();
        } else if ("from_tieba_kuang".equals(this.iCf) && this.iCf != null) {
            this.iyT.yN(6);
        }
    }

    private void initData(Bundle bundle) {
        this.iCr = com.baidu.tbadk.baseEditMark.a.a(this.iBR);
        if (this.iCr != null) {
            this.iCr.a(this.iDv);
        }
        this.fEP = new ForumManageModel(this.iBR);
        this.fEP.setLoadDataCallBack(this.fEU);
        this.cVO = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iDk.setUniqueId(getUniqueId());
        this.iDk.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iCt.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iCO;
        userMuteCheckCustomMessage.setTag(this.iCO);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cjU() {
        if (checkUpIsLogin() && this.iyT != null && this.iyT.getPbData() != null && this.iyT.getPbData().getForum() != null) {
            if (this.iyT.getPbData().cik()) {
                this.iCt.bML();
                return;
            }
            if (this.gmA == null) {
                this.gmA = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.gmA.tE(0);
                this.gmA.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void li(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void r(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lj(boolean z) {
                        if (z) {
                            PbFragment.this.iCt.bML();
                        }
                    }
                });
            }
            this.gmA.B(this.iyT.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iyT.ckU(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cjV() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.iyT == null || (pbData = this.iyT.getPbData()) == null) {
            return null;
        }
        return pbData.chV().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.chK() != null) {
            if (fVar.chK().getThreadType() == 0) {
                return 1;
            }
            if (fVar.chK().getThreadType() == 54) {
                return 2;
            }
            if (fVar.chK().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && cjW()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iCk);
                this.iCl = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.iyT.getPbData() != null && this.iyT.getPbData().cik()) {
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.iBR.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cjP().getListView().smoothScrollBy((PbFragment.this.iCk[1] + PbFragment.this.iCl) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cjP().cmI() != null) {
                            PbFragment.this.iCG.aLC().setVisibility(8);
                            PbFragment.this.cjP().cmI().g(str, str2, PbFragment.this.cjP().cmM(), (PbFragment.this.iyT == null || PbFragment.this.iyT.getPbData() == null || PbFragment.this.iyT.getPbData().chK() == null || !PbFragment.this.iyT.getPbData().chK().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cjJ = PbFragment.this.cjP().cmI().cjJ();
                            if (cjJ != null && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                cjJ.a(PbFragment.this.iyT.getPbData().getAnti());
                                cjJ.setThreadData(PbFragment.this.iyT.getPbData().chK());
                            }
                            if (PbFragment.this.iCx.cnY() == null && PbFragment.this.cjP().cmI().cjJ().aMF() != null) {
                                PbFragment.this.cjP().cmI().cjJ().aMF().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iCx != null && PbFragment.this.iCx.cnX() != null) {
                                            if (!PbFragment.this.iCx.cnX().cRK()) {
                                                PbFragment.this.iCx.qi(false);
                                            }
                                            PbFragment.this.iCx.cnX().tr(false);
                                        }
                                    }
                                });
                                PbFragment.this.iCx.f(PbFragment.this.cjP().cmI().cjJ().aMF().getInputView());
                                PbFragment.this.cjP().cmI().cjJ().a(PbFragment.this.iCL);
                            }
                        }
                        PbFragment.this.cjP().cnH();
                    }
                }, 0L);
                return;
            }
            if (this.iCI == null) {
                this.iCI = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iCI.tE(1);
                this.iCI.a(new AnonymousClass38(str, str2));
            }
            if (this.iyT != null && this.iyT.getPbData() != null && this.iyT.getPbData().getForum() != null) {
                this.iCI.B(this.iyT.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iyT.ckU(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$38  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass38 implements c.a {
        final /* synthetic */ String iDP;
        final /* synthetic */ String iDQ;

        AnonymousClass38(String str, String str2) {
            this.iDP = str;
            this.iDQ = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void li(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void r(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lj(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cjP().getListView().smoothScrollBy((PbFragment.this.iCk[1] + PbFragment.this.iCl) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cjP().cmI() != null) {
                            PbFragment.this.iCG.aLC().setVisibility(8);
                            PbFragment.this.cjP().cmI().g(AnonymousClass38.this.iDP, AnonymousClass38.this.iDQ, PbFragment.this.cjP().cmM(), (PbFragment.this.iyT == null || PbFragment.this.iyT.getPbData() == null || PbFragment.this.iyT.getPbData().chK() == null || !PbFragment.this.iyT.getPbData().chK().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cjJ = PbFragment.this.cjP().cmI().cjJ();
                            if (cjJ != null && PbFragment.this.iyT != null && PbFragment.this.iyT.getPbData() != null) {
                                cjJ.a(PbFragment.this.iyT.getPbData().getAnti());
                                cjJ.setThreadData(PbFragment.this.iyT.getPbData().chK());
                            }
                            if (PbFragment.this.iCx.cnY() == null && PbFragment.this.cjP().cmI().cjJ().aMF() != null) {
                                PbFragment.this.cjP().cmI().cjJ().aMF().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iCx != null && PbFragment.this.iCx.cnX() != null) {
                                            if (!PbFragment.this.iCx.cnX().cRK()) {
                                                PbFragment.this.iCx.qi(false);
                                            }
                                            PbFragment.this.iCx.cnX().tr(false);
                                        }
                                    }
                                });
                                PbFragment.this.iCx.f(PbFragment.this.cjP().cmI().cjJ().aMF().getInputView());
                                PbFragment.this.cjP().cmI().cjJ().a(PbFragment.this.iCL);
                            }
                        }
                        PbFragment.this.cjP().cnH();
                    }
                }, 0L);
            }
        }
    }

    public boolean cjW() {
        if ((this.iyT.getPbData() != null && this.iyT.getPbData().cik()) || this.hJV == null || this.iyT.getPbData() == null || this.iyT.getPbData().getAnti() == null) {
            return true;
        }
        return this.hJV.kb(this.iyT.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean yB(int i) {
        if (this.hJV == null || this.iyT.getPbData() == null || this.iyT.getPbData().getAnti() == null) {
            return true;
        }
        return this.hJV.at(this.iyT.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iyT != null && this.iyT.getPbData() != null && postData.cIt() != 1) {
            String ckU = this.iyT.ckU();
            String id = postData.getId();
            int chW = this.iyT.getPbData() != null ? this.iyT.getPbData().chW() : 0;
            PbActivity.a Fu = Fu(id);
            if (Fu != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(ckU, id, "pb", true, null, false, null, chW, postData.cpy(), this.iyT.getPbData().getAnti(), false, postData.azE() != null ? postData.azE().getIconInfo() : null).addBigImageData(Fu.iyY, Fu.iyZ, Fu.iza, Fu.index);
                addBigImageData.setKeyPageStartFrom(this.iyT.clG());
                addBigImageData.setFromFrsForumId(this.iyT.getFromForumId());
                addBigImageData.setKeyFromForumId(this.iyT.getForumId());
                addBigImageData.setBjhData(this.iyT.clc());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cjX() {
        if (this.iyT.getPbData() == null || this.iyT.getPbData().chK() == null) {
            return -1;
        }
        return this.iyT.getPbData().chK().aAo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjY() {
        if (this.iyT != null && this.iyT.izO != null && this.iyT.izO.chK() != null) {
            bj chK = this.iyT.izO.chK();
            chK.mRecomAbTag = this.iyT.clR();
            chK.mRecomWeight = this.iyT.clP();
            chK.mRecomSource = this.iyT.clQ();
            chK.mRecomExtra = this.iyT.clS();
            if (chK.getFid() == 0) {
                chK.setFid(com.baidu.adp.lib.f.b.toLong(this.iyT.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), chK, "c13563");
            if (a2 != null) {
                a2.Z("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjZ() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.HY(this.iyT.getForumId()) && this.iyT.getPbData() != null && this.iyT.getPbData().getForum() != null) {
            if (this.iyT.getPbData().getForum().isLike() == 1) {
                this.iyT.clC().ek(this.iyT.getForumId(), this.iyT.ckU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pw(boolean z) {
        if (this.iyT == null || this.iyT.getPbData() == null) {
            return false;
        }
        return ((this.iyT.getPbData().chW() != 0) || this.iyT.getPbData().chK() == null || this.iyT.getPbData().chK().azE() == null || TextUtils.equals(this.iyT.getPbData().chK().azE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String cka() {
        com.baidu.tieba.pb.data.f pbData;
        if (!FansCallSwitch.getIsOn()) {
            return "";
        }
        PostData chR = chR();
        if (this.iyT == null || (pbData = this.iyT.getPbData()) == null || pbData.getUserData() == null || pbData.chK() == null || chR == null || chR.azE() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !chR.azE().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.chK().azk() == 0) {
            return "";
        }
        if (pbData.chK().azk() == 0) {
            return getPageContext().getString(R.string.fans_call);
        }
        return getPageContext().getString(R.string.haved_fans_call);
    }

    private boolean px(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.w wVar;
        if (this.iyT == null || this.iyT.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.iyT.getPbData();
        bj chK = pbData.chK();
        if (chK != null) {
            if (chK.ays() || chK.aBz()) {
                return false;
            }
            if (chK.aBA() || chK.aBB()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.chW() != 0) {
                return pbData.chW() != 3;
            }
            List<bf> cie = pbData.cie();
            if (com.baidu.tbadk.core.util.v.getCount(cie) > 0) {
                for (bf bfVar : cie) {
                    if (bfVar != null && (wVar = bfVar.cMB) != null && wVar.cKu && !wVar.cKv && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean py(boolean z) {
        if (z || this.iyT == null || this.iyT.getPbData() == null) {
            return false;
        }
        return ((this.iyT.getPbData().getForum() != null && this.iyT.getPbData().getForum().isBlockBawuDelete) || this.iyT.getPbData().chW() == 0 || this.iyT.getPbData().chW() == 3) ? false : true;
    }

    public void ckb() {
        com.baidu.tieba.pb.data.f pbData;
        bj chK;
        if (this.iyT != null && this.iyT.getPbData() != null && (chK = (pbData = this.iyT.getPbData()).chK()) != null && chK.azE() != null) {
            this.iCt.cmG();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), chK.azE().getUserId());
            ac acVar = new ac();
            int chW = this.iyT.getPbData().chW();
            if (chW == 1 || chW == 3) {
                acVar.iGZ = true;
                acVar.iGY = true;
                acVar.iHf = chK.azz() == 1;
                acVar.iHe = chK.azA() == 1;
            } else {
                acVar.iGZ = false;
                acVar.iGY = false;
            }
            if (chW == 1002 && !equals) {
                acVar.iHg = true;
            }
            acVar.iGW = px(equals);
            acVar.iHa = ckc();
            acVar.iGX = py(equals);
            acVar.hS = this.iyT.ckV();
            acVar.iGT = true;
            acVar.iGS = pw(equals);
            acVar.iHc = cka();
            acVar.iGR = equals && this.iCt.cnn();
            acVar.iHd = TbadkCoreApplication.getInst().getSkinType() == 1;
            acVar.iHb = true;
            acVar.isHostOnly = this.iyT.getHostMode();
            acVar.iGV = true;
            if (chK.azV() == null) {
                acVar.iGU = true;
            } else {
                acVar.iGU = false;
            }
            if (pbData.cik()) {
                acVar.iGT = false;
                acVar.iGV = false;
                acVar.iGU = false;
                acVar.iGY = false;
                acVar.iGZ = false;
            }
            this.iCt.iIK.a(acVar);
        }
    }

    private boolean ckc() {
        if (this.iyT != null && this.iyT.ckV()) {
            return this.iyT.getPageData() == null || this.iyT.getPageData().ayz() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            k(postData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a ckd() {
        return this.iDt;
    }

    public int cke() {
        if (cjP() == null || cjP().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cjP().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.k) && ((com.baidu.tieba.pb.data.k) mVar).zJ == com.baidu.tieba.pb.data.k.ixf) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ckf() {
        if (cjP() == null || cjP().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cjP().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.kbJ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        ckl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckg() {
        if (this.iyT != null && this.iyT.izO != null && this.iyT.izO.chK() != null) {
            bj chK = this.iyT.izO.chK();
            chK.mRecomAbTag = this.iyT.clR();
            chK.mRecomWeight = this.iyT.clP();
            chK.mRecomSource = this.iyT.clQ();
            chK.mRecomExtra = this.iyT.clS();
            if (chK.getFid() == 0) {
                chK.setFid(com.baidu.adp.lib.f.b.toLong(this.iyT.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), chK, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.sy(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sz(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fu(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cp("obj_id", metaData.getUserId()).Z("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cp("obj_id", metaData.getUserId()).Z("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.cVO.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.iyT.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aBW();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.iCt.cnh();
        this.iyT.pI(z);
        if (this.iCr != null) {
            this.iCr.fa(z);
            if (markData != null) {
                this.iCr.a(markData);
            }
        }
        if (this.iyT.awd()) {
            ckj();
        } else {
            this.iCt.o(this.iyT.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ys(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fq(String str) {
        if (this.iyT != null && this.iyT.getPbData() != null && this.iyT.getPbData().cik()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iyT.ckU(), str);
            bj chK = this.iyT.getPbData().chK();
            if (chK.ays()) {
                format = format + "&channelid=33833";
            } else if (chK.aBy()) {
                format = format + "&channelid=33842";
            } else if (chK.aBz()) {
                format = format + "&channelid=33840";
            }
            Fr(format);
            return;
        }
        this.iCq.FQ(str);
    }

    private void Fr(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.iyT.cla()) {
                    antiData.setBlock_forum_name(this.iyT.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.iyT.getPbData().getForum().getId());
                    antiData.setUser_name(this.iyT.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.iyT.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cjP() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aW(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            uU(str);
        } else {
            this.iCt.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.kew) ? bVar.kew : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sz(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fu(true);
                aVar.b(getPageContext());
                aVar.aBW();
            } else {
                this.iCt.a(0, bVar.mSuccess, bVar.kew, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fSL == 1) {
                    ArrayList<PostData> chM = this.iyT.getPbData().chM();
                    int size = chM.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(chM.get(i).getId())) {
                            i++;
                        } else {
                            chM.remove(i);
                            break;
                        }
                    }
                    this.iyT.getPbData().chK().js(this.iyT.getPbData().chK().azv() - 1);
                    this.iCt.o(this.iyT.getPbData());
                } else if (bVar.fSL == 0) {
                    ckh();
                } else if (bVar.fSL == 2) {
                    ArrayList<PostData> chM2 = this.iyT.getPbData().chM();
                    int size2 = chM2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= chM2.get(i2).cIq().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(chM2.get(i2).cIq().get(i3).getId())) {
                                i3++;
                            } else {
                                chM2.get(i2).cIq().remove(i3);
                                chM2.get(i2).cIs();
                                z2 = true;
                                break;
                            }
                        }
                        chM2.get(i2).ID(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.iCt.o(this.iyT.getPbData());
                    }
                    a(bVar, this.iCt);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.iCt.a(this.fEP.getLoadDataMode(), gVar.mSuccess, gVar.kew, false);
            if (gVar.mSuccess) {
                this.iCu = true;
                if (i == 2 || i == 3) {
                    this.iCv = true;
                    this.iCw = false;
                } else if (i == 4 || i == 5) {
                    this.iCv = false;
                    this.iCw = true;
                }
                if (i == 2) {
                    this.iyT.getPbData().chK().jv(1);
                    this.iyT.setIsGood(1);
                } else if (i == 3) {
                    this.iyT.getPbData().chK().jv(0);
                    this.iyT.setIsGood(0);
                } else if (i == 4) {
                    this.iyT.getPbData().chK().ju(1);
                    this.iyT.yF(1);
                } else if (i == 5) {
                    this.iyT.getPbData().chK().ju(0);
                    this.iyT.yF(0);
                }
                this.iCt.c(this.iyT.getPbData(), this.iyT.ckV());
            }
        }
    }

    private void ckh() {
        if (this.iyT.ckW() || this.iyT.ckY()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.iyT.ckU());
            PbActivity pbActivity = this.iBR;
            PbActivity pbActivity2 = this.iBR;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.iyT.ckU()));
        if (ckk()) {
            this.iBR.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjj() {
        this.iBR.cjj();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData chT;
        boolean z = false;
        if (this.iCt != null) {
            this.iCt.cny();
        }
        if (this.iyT != null && this.iyT.getPbData() != null && !this.iyT.getPbData().cik()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.iyT.getPbData().chK().getId();
            if (this.iyT.isShareThread() && this.iyT.getPbData().chK().cPD != null) {
                historyMessage.threadName = this.iyT.getPbData().chK().cPD.showText;
            } else {
                historyMessage.threadName = this.iyT.getPbData().chK().getTitle();
            }
            if (this.iyT.isShareThread() && !ciJ()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.iyT.getPbData().getForum().getName();
            }
            ArrayList<PostData> chM = this.iyT.getPbData().chM();
            int cnj = this.iCt != null ? this.iCt.cnj() : 0;
            if (chM != null && cnj >= 0 && cnj < chM.size()) {
                historyMessage.postID = chM.get(cnj).getId();
            }
            historyMessage.isHostOnly = this.iyT.getHostMode();
            historyMessage.isSquence = this.iyT.ckV();
            historyMessage.isShareThread = this.iyT.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iCG != null) {
            this.iCG.onDestroy();
        }
        if (this.iBV && cjP() != null) {
            cjP().cnR();
        }
        if (this.iyT != null && (this.iyT.ckW() || this.iyT.ckY())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.iyT.ckU());
            if (this.iCu) {
                if (this.iCw) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.iyT.bvj());
                }
                if (this.iCv) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.iyT.getIsGood());
                }
            }
            if (this.iyT.getPbData() != null && System.currentTimeMillis() - this.iBY >= 40000 && (chT = this.iyT.getPbData().chT()) != null && !com.baidu.tbadk.core.util.v.isEmpty(chT.getDataList())) {
                intent.putExtra("guess_like_data", chT);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.iCU);
            }
            PbActivity pbActivity = this.iBR;
            PbActivity pbActivity2 = this.iBR;
            pbActivity.setResult(-1, intent);
        }
        if (ckk()) {
            if (this.iyT != null && this.iCt != null && this.iCt.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.iyT.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.chQ() && !this.iCe && pbData.iwh == null) {
                        ak cmq = ak.cmq();
                        com.baidu.tieba.pb.data.f cld = this.iyT.cld();
                        Parcelable onSaveInstanceState = this.iCt.getListView().onSaveInstanceState();
                        boolean ckV = this.iyT.ckV();
                        boolean hostMode = this.iyT.getHostMode();
                        if (this.iCt.cmS() != null && this.iCt.cmS().getVisibility() == 0) {
                            z = true;
                        }
                        cmq.a(cld, onSaveInstanceState, ckV, hostMode, z);
                        if (this.iCT >= 0 || this.iyT.clI() != null) {
                            ak.cmq().n(this.iyT.clI());
                            ak.cmq().m(this.iyT.clJ());
                            ak.cmq().yP(this.iyT.clK());
                        }
                    }
                }
            } else {
                ak.cmq().reset();
            }
            cjj();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.iCt == null || !this.iCt.yV(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yC(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iBR;
        if (i == 0) {
            this.iCt.cmG();
            this.iCt.cmI().cjF();
            this.iCt.qc(false);
        }
        this.iCt.cmK();
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
                        this.iCG.resetData();
                        this.iCG.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iCG.b(writeData);
                        com.baidu.tbadk.editortools.l lX = this.iCG.aLC().lX(6);
                        if (lX != null && lX.dsh != null) {
                            lX.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iBR;
                        if (i == -1) {
                            this.iCG.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iCt.cmI() != null && this.iCt.cmI().cjJ() != null) {
                            com.baidu.tbadk.editortools.pb.h cjJ = this.iCt.cmI().cjJ();
                            cjJ.setThreadData(this.iyT.getPbData().chK());
                            cjJ.b(writeData);
                            cjJ.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l lX2 = cjJ.aLC().lX(6);
                            if (lX2 != null && lX2.dsh != null) {
                                lX2.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iBR;
                            if (i == -1) {
                                cjJ.aMx();
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
        this.iCG.onActivityResult(i, i2, intent);
        if (this.iCi != null) {
            this.iCi.onActivityResult(i, i2, intent);
        }
        if (cjP().cmI() != null) {
            cjP().cmI().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cki();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ak.cmq().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.iyT != null) {
                                PbFragment.this.iyT.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.n.a.czt().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.iyT != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    aj(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.czt().A(getPageContext());
                        cjZ();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.gzi != null && shareItem != null && shareItem.linkUrl != null) {
                            this.gzi.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aIV() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57.1
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
                    this.iCt.pm(false);
                    if (this.iyT.getPbData() != null && this.iyT.getPbData().chK() != null && this.iyT.getPbData().chK().azY() != null) {
                        this.iyT.getPbData().chK().azY().setStatus(2);
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
                        this.iCJ = emotionImageData;
                        if (yB(com.baidu.tbadk.core.util.aj.cVL)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.FANS_CALL_JUMP_BACK /* 25028 */:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.iCt != null && this.iCt.iIK != null) {
                        this.iCt.iIK.apm();
                        this.iCt.iIK.coy();
                        if (this.iyT != null && this.iyT.getPbData() != null && this.iyT.getPbData().chK() != null) {
                            this.iyT.getPbData().chK().jp(1);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.iCj != null) {
                        this.iCt.cx(this.iCj);
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
            if (this.iCi == null) {
                this.iCi = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iBR);
                this.iCi.b(this.dub);
                this.iCi.c(this.dui);
            }
            this.iCi.a(emotionImageData, ciU(), ciU().getPbData());
        }
    }

    private void aj(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cki() {
        MarkData yM;
        if (this.iCr != null) {
            if (this.iyT.getPbData() != null && this.iyT.getPbData().cik()) {
                yM = this.iyT.yM(0);
            } else {
                yM = this.iyT.yM(this.iCt.cnk());
            }
            if (yM != null) {
                if (!yM.isApp() || (yM = this.iyT.yM(this.iCt.cnk() + 1)) != null) {
                    this.iCt.cnf();
                    this.iCr.a(yM);
                    if (!this.iCr.awd()) {
                        this.iCr.awf();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iCr.awe();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckj() {
        com.baidu.tieba.pb.data.f pbData = this.iyT.getPbData();
        this.iyT.pI(true);
        if (this.iCr != null) {
            pbData.Fj(this.iCr.awc());
        }
        this.iCt.o(pbData);
    }

    private boolean ckk() {
        if (this.iyT == null) {
            return true;
        }
        if (this.iyT.getPbData() == null || !this.iyT.getPbData().cik()) {
            if (this.iyT.awd()) {
                final MarkData clo = this.iyT.clo();
                if (clo == null || !this.iyT.getIsFromMark()) {
                    return true;
                }
                final MarkData yM = this.iyT.yM(this.iCt.cnj());
                if (yM == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", clo);
                    this.iBR.setResult(-1, intent);
                    return true;
                } else if (yM.getPostId() == null || yM.getPostId().equals(clo.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", clo);
                    this.iBR.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.sz(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.iCr != null) {
                                if (PbFragment.this.iCr.awd()) {
                                    PbFragment.this.iCr.awe();
                                    PbFragment.this.iCr.fa(false);
                                }
                                PbFragment.this.iCr.a(yM);
                                PbFragment.this.iCr.fa(true);
                                PbFragment.this.iCr.awf();
                            }
                            clo.setPostId(yM.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", clo);
                            PbFragment.this.iBR.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cjj();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", clo);
                            PbFragment.this.iBR.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cjj();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.iCt != null && PbFragment.this.iCt.getView() != null) {
                                PbFragment.this.iCt.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", clo);
                                PbFragment.this.iBR.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cjj();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aBW();
                    return false;
                }
            } else if (this.iyT.getPbData() == null || this.iyT.getPbData().chM() == null || this.iyT.getPbData().chM().size() <= 0 || !this.iyT.getIsFromMark()) {
                return true;
            } else {
                this.iBR.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.iCt == null) {
            return null;
        }
        return this.iCt.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aRM() {
        if (this.iCt == null) {
            return 0;
        }
        return this.iCt.cnw();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aRN() {
        if (this.dHY == null) {
            this.dHY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aRZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.axf().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.i.axf().isShowImages()) {
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
        return this.dHY;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aRO() {
        if (this.dKO == null) {
            this.dKO = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dKO;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aRP() {
        if (this.dHZ == null) {
            this.dHZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bEt */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.axf().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.i.axf().isShowImages()) {
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
                    gifView.aMX();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dHZ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aRQ() {
        if (this.dKP == null) {
            this.dKP = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ckH */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cs */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ct */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cJE();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cu */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dKP;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aRS() {
        this.dKR = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: ckI */
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
        return this.dKR;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aFy() {
        if (this.deJ == null) {
            this.deJ = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.deJ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aB(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iCc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (av.FI(str) && this.iyT != null && this.iyT.ckU() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").Z("obj_param1", 1).cp("post_id", this.iyT.ckU()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.drj = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            av.coa().c(getPageContext(), str);
        }
        this.iCc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        av.coa().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iCc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.iCt != null && this.iCt.cnM() != null && rect.top <= this.iCt.cnM().getHeight()) {
            rect.top += this.iCt.cnM().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.iyT.getPbData();
            TbRichText bk = bk(str, i);
            if (bk != null && (tbRichTextData = bk.aRf().get(this.iDy)) != null) {
                aVar.postId = String.valueOf(bk.getPostId());
                aVar.iyY = new ArrayList<>();
                aVar.iyZ = new ConcurrentHashMap<>();
                if (!tbRichTextData.aRl().aRx()) {
                    aVar.izb = false;
                    String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                    aVar.iyY.add(b2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bk.getPostId();
                    imageUrlData.mIsReserver = this.iyT.clm();
                    imageUrlData.mIsSeeHost = this.iyT.getHostMode();
                    aVar.iyZ.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.chK() != null) {
                            aVar.threadId = pbData.chK().getId();
                        }
                        aVar.iza = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.izb = true;
                int size = pbData.chM().size();
                this.iDz = false;
                aVar.index = -1;
                if (pbData.chR() != null) {
                    PostData chR = pbData.chR();
                    TbRichText cIv = chR.cIv();
                    if (!ap.o(chR)) {
                        i2 = a(cIv, bk, i, i, aVar.iyY, aVar.iyZ);
                    } else {
                        i2 = a(chR, i, aVar.iyY, aVar.iyZ);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.chM().get(i4);
                    if (postData.getId() == null || pbData.chR() == null || pbData.chR().getId() == null || !postData.getId().equals(pbData.chR().getId())) {
                        TbRichText cIv2 = postData.cIv();
                        if (!ap.o(postData)) {
                            i3 = a(cIv2, bk, i3, i, aVar.iyY, aVar.iyZ);
                        } else {
                            i3 = a(postData, i3, aVar.iyY, aVar.iyZ);
                        }
                    }
                }
                if (aVar.iyY.size() > 0) {
                    aVar.lastId = aVar.iyY.get(aVar.iyY.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.chK() != null) {
                        aVar.threadId = pbData.chK().getId();
                    }
                    aVar.iza = pbData.getIsNewUrl() == 1;
                }
                aVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRl() == null) {
            return null;
        }
        return tbRichTextData.aRl().aRC();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRl() == null) {
            return 0L;
        }
        return tbRichTextData.aRl().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRl() == null) {
            return false;
        }
        return tbRichTextData.aRl().aRD();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRl() == null) {
            return false;
        }
        return tbRichTextData.aRl().aRE();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aRl;
        String str;
        if (tbRichText == tbRichText2) {
            this.iDz = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aRf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aRf().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aRl().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aRl().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aRl().aRx()) {
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
                        String b2 = com.baidu.tieba.pb.data.g.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (aRl = tbRichTextData.aRl()) != null) {
                                String aRz = aRl.aRz();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aRl.aRA();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = aRz;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iyT.ckU(), -1L);
                                imageUrlData.mIsReserver = this.iyT.clm();
                                imageUrlData.mIsSeeHost = this.iyT.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.iDz) {
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

    private int a(PostData postData, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        com.baidu.tieba.tbadkCore.data.i cIC;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cHY;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cHY = (cIC = postData.cIC()).cHY()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cHY.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cHY.get(i3);
                if (kVar != null) {
                    String cIc = kVar.cIc();
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(cIc)) {
                        arrayList.add(cIc);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cIc;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cIb();
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iyT.ckU(), -1L);
                        imageUrlData.mIsReserver = this.iyT.clm();
                        imageUrlData.mIsSeeHost = this.iyT.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cIC.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cIc, imageUrlData);
                        }
                        if (!this.iDz) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    protected void k(PostData postData) {
        PostData chR;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iyT.azN())) {
                z = true;
            }
            MarkData l = this.iyT.l(postData);
            if (this.iyT.getPbData() != null && this.iyT.getPbData().cik() && (chR = chR()) != null) {
                l = this.iyT.l(chR);
            }
            if (l != null) {
                this.iCt.cnf();
                if (this.iCr != null) {
                    this.iCr.a(l);
                    if (!z) {
                        this.iCr.awf();
                    } else {
                        this.iCr.awe();
                    }
                }
            }
        }
    }

    public boolean cr(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bk(String str, int i) {
        TbRichText tbRichText = null;
        if (this.iyT == null || this.iyT.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.iyT.getPbData();
        if (pbData.chR() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.chR());
            tbRichText = b(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> chM = pbData.chM();
            c(pbData, chM);
            return b(chM, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.chV() != null && fVar.chV().ixt != null && (list = fVar.chV().ixt) != null && arrayList != null) {
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

    private long Fs(String str) {
        ArrayList<PostData> chM;
        com.baidu.tieba.pb.data.f pbData = this.iyT.getPbData();
        if (pbData != null && (chM = pbData.chM()) != null && !chM.isEmpty()) {
            Iterator<PostData> it = chM.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cIC = next.cIC();
                if (cIC != null && cIC.kbq) {
                    Iterator<TbRichTextData> it2 = next.cIv().aRf().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.aRu().getLink().equals(str)) {
                            return cIC.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText b(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> aRf;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cIv = arrayList.get(i2).cIv();
            if (cIv != null && (aRf = cIv.aRf()) != null) {
                int size = aRf.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aRf.get(i4) != null && aRf.get(i4).getType() == 8) {
                        i3++;
                        if (aRf.get(i4).aRl().aRz().equals(str) || aRf.get(i4).aRl().aRA().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aRf.get(i4).aRl().getWidth() * equipmentDensity;
                            int height = aRf.get(i4).aRl().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iDy = i4;
                            return cIv;
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

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.iyO = str;
            if (this.iBX == null) {
                cjT();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.iBX.getItemView(1).setVisibility(8);
            } else {
                this.iBX.getItemView(1).setVisibility(0);
            }
            this.iBX.aBX();
            this.iCc = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.giZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckl() {
        hideNetRefreshView(this.iCt.getView());
        ckm();
        if (this.iyT.clg()) {
            this.iCt.cnf();
        }
        this.iCt.cnq();
    }

    private void ckm() {
        showLoadingView(this.iCt.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.iCt.cnM().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBD() {
        if (this.giZ != null) {
            this.giZ.stopPlay();
        }
        if (this.iBR != null) {
            this.iBR.bBD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cjX(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aRR() {
        if (this.dKQ == null) {
            this.dKQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ckJ */
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
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.dKQ;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bBE() {
        if (this.iBR.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iBR.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bAs() {
        if (this.iyT == null || this.iyT.getPbData() == null) {
            return null;
        }
        return this.iyT.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(aq.iJU)).intValue();
            if (intValue == aq.iJV) {
                if (!this.fEP.cJi()) {
                    this.iCt.cnc();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.fEP.IJ(com.baidu.tbadk.core.util.aq.N(jSONArray));
                    }
                    this.fEP.a(this.iyT.getPbData().getForum().getId(), this.iyT.getPbData().getForum().getName(), this.iyT.getPbData().chK().getId(), str, intValue3, intValue2, booleanValue, this.iyT.getPbData().chK().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == aq.iJW || intValue == aq.iJY) {
                if (this.iyT.clz() != null) {
                    this.iyT.clz().yw(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.iJW) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iCO);
        userMuteAddAndDelCustomMessage.setTag(this.iCO);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Ft(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0572a
    public void pz(boolean z) {
        this.iCA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ckn() {
        ArrayList<PostData> chM;
        int count;
        if (this.iyT == null || this.iyT.getPbData() == null || this.iyT.getPbData().chM() == null || (count = com.baidu.tbadk.core.util.v.getCount((chM = this.iyT.getPbData().chM()))) == 0) {
            return "";
        }
        if (this.iyT.clm()) {
            Iterator<PostData> it = chM.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cIt() == 1) {
                    return next.getId();
                }
            }
        }
        int cnj = this.iCt.cnj();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(chM, cnj);
        if (postData == null || postData.azE() == null) {
            return "";
        }
        if (this.iyT.Fx(postData.azE().getUserId())) {
            return postData.getId();
        }
        for (int i = cnj - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(chM, i);
            if (postData2 == null || postData2.azE() == null || postData2.azE().getUserId() == null) {
                break;
            } else if (this.iyT.Fx(postData2.azE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cnj + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(chM, i2);
            if (postData3 == null || postData3.azE() == null || postData3.azE().getUserId() == null) {
                return "";
            }
            if (this.iyT.Fx(postData3.azE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.aEa().b(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.b.a(Fs(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.iyT.getPbData().getForum().getId(), this.iyT.getPbData().getForum().getName(), this.iyT.getPbData().chK().getTid());
            }
            this.iCc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.sz(getResources().getString(R.string.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.sz(getResources().getString(R.string.make_sure_hide));
        }
        aVar.a(getResources().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbFragment.this.checkUpIsLogin() && PbFragment.this.iyT.cly() != null) {
                    PbFragment.this.iyT.cly().eo(j);
                }
            }
        });
        aVar.b(getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.b.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.fv(false);
        aVar.b(getPageContext());
        aVar.aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Fu(String str) {
        String str2;
        if (this.iyT.getPbData() == null || this.iyT.getPbData().chM() == null || this.iyT.getPbData().chM().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iyT.getPbData().chM().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iyT.getPbData().chM().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iyT.getPbData().chM().get(i);
        if (postData.cIv() == null || postData.cIv().aRf() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cIv().aRf().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aRl() != null) {
                    str2 = next.aRl().aRz();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean cko() {
        return (!this.iBS && this.iDE == -1 && this.iDF == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            this.iDH = pVar;
            this.iBS = true;
            this.iCt.cmT();
            this.iCt.FG(this.iDG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckp() {
        if (this.iDH != null) {
            if (this.iDE == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iDH.getCartoonId(), this.iDE, 0)));
                this.iBR.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckq() {
        if (this.iDH != null) {
            if (this.iDF == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iDH.getCartoonId(), this.iDF, 0)));
                this.iBR.finish();
            }
        }
    }

    public int ckr() {
        return this.iDE;
    }

    public int cks() {
        return this.iDF;
    }

    private void bNj() {
        if (this.iyT != null && this.iyT.getPbData() != null && this.iyT.getPbData().chK() != null && this.iyT.getPbData().chK().aAE()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void ckt() {
        if (this.iyT != null && this.iyT.getPbData() != null && this.iyT.getPbData().chK() != null && this.iyT.getPbData().chK().aAE()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cku() {
        if (this.isPaused) {
            this.iCh = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.iyT.getPbData() != null && this.iyT.getPbData().chK() != null && this.iyT.getPbData().chK().azj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iyT.getPbData().chK().azj().getThreadId(), this.iyT.getPbData().chK().azj().getTaskId(), this.iyT.getPbData().chK().azj().getForumId(), this.iyT.getPbData().chK().azj().getForumName(), this.iyT.getPbData().chK().azz(), this.iyT.getPbData().chK().azA())));
            this.iBU = true;
            this.iBR.finish();
        }
    }

    public String ckv() {
        return this.iCf;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a ckw() {
        return this.iCp;
    }

    public void pA(boolean z) {
        this.iCg = z;
    }

    public boolean aBv() {
        if (this.iyT != null) {
            return this.iyT.ckW();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sz(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.iCM).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.iCM.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iCM).aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iCM != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iCM.getPageActivity());
            aVar.sz(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iCM).aBW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iCt.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iCM.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.sz(this.iCM.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sz(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.iCt.showLoadingDialog();
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
        aVar.b(this.iCM).aBW();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.FI(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.c(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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
        if (configuration.orientation != this.gIQ) {
            this.gIQ = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.iCt != null) {
                this.iCt.onConfigurationChanged(configuration);
            }
            if (this.iCy != null) {
                this.iCy.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cky() {
        if (this.iyT != null) {
            return this.iyT.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.iyT.getPbData().chV().ixt;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cIq().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cIq().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cIq().remove(i2);
                    list.get(i).cIs();
                    z = true;
                    break;
                }
            }
            list.get(i).ID(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.o(this.iyT.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.m mVar) {
        String id = mVar.cix().getId();
        List<PostData> list = this.iyT.getPbData().chV().ixt;
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
                ArrayList<PostData> ciB = mVar.ciB();
                postData.Ck(mVar.getTotalCount());
                if (postData.cIq() != null) {
                    postData.cIq().clear();
                    postData.cIq().addAll(ciB);
                }
            }
        }
        if (!this.iyT.getIsFromMark()) {
            this.iCt.o(this.iyT.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a ciI() {
        return this.iBR.ciI();
    }

    public boolean ciJ() {
        if (this.iyT == null) {
            return false;
        }
        return this.iyT.ciJ();
    }

    public void ckz() {
        if (this.iCt != null) {
            this.iCt.cmG();
            bBE();
        }
    }

    public PostData chR() {
        return this.iCt.b(this.iyT.izO, this.iyT.ckV());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aB(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.isLinkThread()) {
                return 3;
            }
            if (bjVar.aAT()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public void onBackPressed() {
        if (this.iCV != null && !this.iCV.isEmpty()) {
            int size = this.iCV.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.iCV.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.iCV == null) {
                this.iCV = new ArrayList();
            }
            if (!this.iCV.contains(aVar)) {
                this.iCV.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.iCV == null) {
                this.iCV = new ArrayList();
            }
            if (!this.iCV.contains(aVar)) {
                this.iCV.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.iCV != null) {
            this.iCV.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckA() {
        if (this.iyT != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.iyT.ckU())) {
            com.baidu.tbadk.BdToken.c.auQ().o(com.baidu.tbadk.BdToken.b.cCB, com.baidu.adp.lib.f.b.toLong(this.iyT.ckU(), 0L));
        }
    }

    public ax ckB() {
        return this.iCo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fv(String str) {
        if (this.iyT != null && this.iyT.getPbData() != null && this.iyT.getPbData().chK() != null && this.iyT.getPbData().chK().aBC()) {
            bj chK = this.iyT.getPbData().chK();
            int i = 0;
            if (chK.ays()) {
                i = 1;
            } else if (chK.aBz()) {
                i = 2;
            } else if (chK.aBA()) {
                i = 3;
            } else if (chK.aBB()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.Z("obj_source", 4);
            anVar.Z("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment ckC() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment ckD() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity ckE() {
        return this.iBR;
    }
}
