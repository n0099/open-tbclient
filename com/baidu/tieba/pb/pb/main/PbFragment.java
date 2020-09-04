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
/* loaded from: classes16.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.pb.videopb.b, a.InterfaceC0777a {
    private bd dTW;
    private com.baidu.tieba.tbadkCore.data.e eod;
    private com.baidu.tbadk.core.message.a eou;
    private com.baidu.adp.lib.d.b<TbImageView> evt;
    private LikeModel exb;
    private com.baidu.adp.lib.d.b<ImageView> fcr;
    private com.baidu.adp.lib.d.b<GifView> fcs;
    private com.baidu.adp.lib.d.b<TextView> ffJ;
    private com.baidu.adp.lib.d.b<View> ffK;
    private com.baidu.adp.lib.d.b<LinearLayout> ffL;
    private com.baidu.adp.lib.d.b<RelativeLayout> ffM;
    private VoiceManager hSU;
    private com.baidu.tieba.f.b hXQ;
    private com.baidu.tieba.frs.profession.permission.c hXq;
    private com.baidu.tieba.callfans.a hkB;
    public com.baidu.tbadk.core.util.am jFD;
    public bb jJI;
    private bf kDA;
    private com.baidu.tieba.pb.pb.report.a kDD;
    private com.baidu.tbadk.core.dialog.i kDK;
    private com.baidu.tbadk.core.dialog.k kDL;
    private boolean kDM;
    private com.baidu.tieba.tbadkCore.data.f kDQ;
    private com.baidu.tbadk.editortools.pb.g kDR;
    private com.baidu.tbadk.editortools.pb.e kDS;
    private com.baidu.tieba.frs.profession.permission.c kDU;
    private EmotionImageData kDV;
    private com.baidu.adp.base.e kDY;
    private com.baidu.tbadk.core.view.c kDZ;
    private PbActivity kDc;
    private com.baidu.tieba.pb.pb.main.b.b kDe;
    private com.baidu.tieba.pb.pb.main.emotion.model.a kDu;
    private View kDv;
    int kDx;
    private boolean kEM;
    private String kEV;
    private com.baidu.tbadk.core.data.r kEW;
    private BdUniqueId kEa;
    private Runnable kEb;
    private com.baidu.adp.widget.ImageView.a kEc;
    private String kEd;
    private TbRichTextMemeInfo kEe;
    private List<a> kEh;
    public String kEj;
    private String kzG;
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
    private static final b.a kES = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cq(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cWs();
            } else {
                com.baidu.tieba.pb.a.b.cWr();
            }
        }
    };
    private boolean kDd = false;
    private boolean kDf = false;
    private boolean bpH = false;
    private boolean jZg = false;
    private boolean kDg = true;
    private int kDh = 0;
    private com.baidu.tbadk.core.dialog.b kDi = null;
    private long hvt = -1;
    private long eRX = 0;
    private long kDj = 0;
    private long createTime = 0;
    private long eRN = 0;
    private boolean kDk = false;
    private com.baidu.tbadk.n.b kDl = null;
    private long kDm = 0;
    private boolean kDn = false;
    private long kDo = 0;
    private int iwD = 1;
    private String eMx = null;
    private boolean kDp = false;
    private boolean isFullScreen = false;
    private boolean kDq = false;
    private String kDr = "";
    private boolean kDs = true;
    private boolean kDt = false;
    private String source = "";
    private int mSkinType = 3;
    int[] kDw = new int[2];
    private int kDy = -1;
    private int kDz = -1;
    public BdUniqueId kDB = BdUniqueId.gen();
    private boolean kBf = com.baidu.tbadk.a.d.baf();
    private PbInterviewStatusView.a kDC = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.kDG.tx(!PbFragment.this.kDs);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.kzK != null && PbFragment.this.kzK.baA()) {
                        PbFragment.this.cXN();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel kzK = null;
    private com.baidu.tbadk.baseEditMark.a kDE = null;
    private ForumManageModel hkz = null;
    private com.baidu.tbadk.coreExtra.model.a ekH = null;
    private com.baidu.tieba.pb.data.q kDF = null;
    private ShareSuccessReplyToServerModel imb = null;
    private az kDG = null;
    private boolean kDH = false;
    private boolean kDI = false;
    private boolean kDJ = false;
    private boolean ftk = false;
    private boolean kDN = false;
    private boolean kDO = false;
    private boolean kDP = false;
    private boolean kDT = false;
    public boolean kDW = false;
    private com.baidu.tbadk.editortools.pb.c eMA = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void brW() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b eMB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brV() {
            if (PbFragment.this.jJI == null || PbFragment.this.jJI.dbF() == null || !PbFragment.this.jJI.dbF().dFF()) {
                return !PbFragment.this.Ec(com.baidu.tbadk.core.util.am.ekC);
            }
            PbFragment.this.showToast(PbFragment.this.jJI.dbF().dFH());
            if (PbFragment.this.kDS != null && (PbFragment.this.kDS.bsm() || PbFragment.this.kDS.bsn())) {
                PbFragment.this.kDS.a(false, PbFragment.this.jJI.dbI());
            }
            PbFragment.this.jJI.tK(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b kDX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brV() {
            if (PbFragment.this.jJI == null || PbFragment.this.jJI.dbG() == null || !PbFragment.this.jJI.dbG().dFF()) {
                return !PbFragment.this.Ec(com.baidu.tbadk.core.util.am.ekD);
            }
            PbFragment.this.showToast(PbFragment.this.jJI.dbG().dFH());
            if (PbFragment.this.kDG != null && PbFragment.this.kDG.dap() != null && PbFragment.this.kDG.dap().cXo() != null && PbFragment.this.kDG.dap().cXo().bsn()) {
                PbFragment.this.kDG.dap().cXo().a(PbFragment.this.jJI.dbI());
            }
            PbFragment.this.jJI.tL(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean hTJ = false;
    private int kEf = 0;
    private int kEg = -1;
    public int kEi = 0;
    private final a kEk = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.kDG != null && PbFragment.this.kDG.dap() != null) {
                v dap = PbFragment.this.kDG.dap();
                if (dap.cXm()) {
                    dap.cXl();
                    return true;
                }
            }
            if (PbFragment.this.kDG != null && PbFragment.this.kDG.dbn()) {
                PbFragment.this.kDG.dbo();
                return true;
            }
            return false;
        }
    };
    private final ai.a kEl = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bd(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.kDG.showToast(str);
            }
        }
    };
    private final CustomMessageListener kEm = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kzK != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.kDS != null) {
                    PbFragment.this.kDG.tC(PbFragment.this.kDS.bsf());
                }
                PbFragment.this.kDG.dar();
                PbFragment.this.kDG.dbf();
            }
        }
    };
    CustomMessageListener hUA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbFragment.this.kzK.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbFragment.this.kDG != null && PbFragment.this.kzK != null) {
                    PbFragment.this.kDG.b(PbFragment.this.kzK.getPbData(), PbFragment.this.kzK.cYE(), PbFragment.this.kzK.cZb(), PbFragment.this.kDG.getSkinType());
                }
                if (PbFragment.this.kDG != null && PbFragment.this.kDG.daI() != null) {
                    PbFragment.this.kDG.daI().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener kEn = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.kDG != null) {
                    if (booleanValue) {
                        PbFragment.this.kDG.cGx();
                    } else {
                        PbFragment.this.kDG.cGw();
                    }
                }
            }
        }
    };
    private CustomMessageListener kEo = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.kDS != null) {
                    PbFragment.this.kDG.tC(PbFragment.this.kDS.bsf());
                }
                PbFragment.this.kDG.tE(false);
            }
        }
    };
    private CustomMessageListener kEp = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener kEq = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kDG != null && PbFragment.this.kDG.daI() != null) {
                PbFragment.this.kDG.daI().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jgP = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener hUw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bpH) {
                PbFragment.this.cYf();
            }
        }
    };
    private View.OnClickListener eNj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.eMx);
        }
    };
    private CustomMessageListener kEr = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ag)) {
                com.baidu.tbadk.core.data.ag agVar = (com.baidu.tbadk.core.data.ag) customResponsedMessage.getData();
                ax.a aVar = new ax.a();
                aVar.giftId = agVar.id;
                aVar.giftName = agVar.name;
                aVar.thumbnailUrl = agVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzK.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.kzK.cYS() != null && PbFragment.this.kzK.cYS().getUserIdLong() == agVar.toUserId) {
                        PbFragment.this.kDG.a(agVar.sendCount, PbFragment.this.kzK.getPbData(), PbFragment.this.kzK.cYE(), PbFragment.this.kzK.cZb());
                    }
                    if (pbData.cVo() != null && pbData.cVo().size() >= 1 && pbData.cVo().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cVo().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.kzK.cYC(), 0L);
                        if (j == agVar.postId && j2 == agVar.threadId) {
                            com.baidu.tbadk.core.data.ax dwS = pbData.cVo().get(0).dwS();
                            if (dwS == null) {
                                dwS = new com.baidu.tbadk.core.data.ax();
                            }
                            ArrayList<ax.a> bdw = dwS.bdw();
                            if (bdw == null) {
                                bdw = new ArrayList<>();
                            }
                            bdw.add(0, aVar);
                            dwS.setTotal(agVar.sendCount + dwS.getTotal());
                            dwS.D(bdw);
                            pbData.cVo().get(0).a(dwS);
                            PbFragment.this.kDG.daI().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener kEs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                PbFragment.this.kzK.getPbData().cVG();
                PbFragment.this.kzK.cYX();
                if (PbFragment.this.kDG.daI() != null) {
                    PbFragment.this.kDG.s(PbFragment.this.kzK.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener inn = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Nt(str);
                PbFragment.this.kzK.cYX();
                if (!TextUtils.isEmpty(str) && PbFragment.this.kzK.getPbData().cVo() != null) {
                    ArrayList<PostData> cVo = PbFragment.this.kzK.getPbData().cVo();
                    Iterator<PostData> it = cVo.iterator();
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
                        cVo.remove(nVar);
                        if (PbFragment.this.kDG.daI() != null && PbFragment.this.kDG.daI().getDataList() != null) {
                            PbFragment.this.kDG.daI().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.kDG.getListView() != null && PbFragment.this.kDG.getListView().getData() != null) {
                            PbFragment.this.kDG.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.kDG.daI() != null) {
                            PbFragment.this.kDG.daI().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.kDG.daI() != null) {
                    PbFragment.this.kDG.s(PbFragment.this.kzK.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a kEt = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dbY()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a kEu = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void bd(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.kDG != null) {
                PbFragment.this.kDG.eC(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean kEv = false;
    private PraiseModel kEw = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void DM(String str) {
            PbFragment.this.kEv = false;
            if (PbFragment.this.kEw != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzK.getPbData();
                if (pbData.cVm().bep().getIsLike() == 1) {
                    PbFragment.this.yi(0);
                } else {
                    PbFragment.this.yi(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cVm()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.kEv = false;
            if (PbFragment.this.kEw != null && str != null) {
                if (AntiHelper.by(i, str)) {
                    AntiHelper.bb(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a kEx = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void tb(boolean z) {
            PbFragment.this.sZ(z);
            if (PbFragment.this.kDG.dbt() != null && z) {
                PbFragment.this.kDG.tx(false);
            }
            PbFragment.this.kDG.tz(z);
        }
    };
    private CustomMessageListener ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().eCe != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().eCe, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cVv().beE() != null && PbFragment.this.cVv().beE().getGodUserData() != null) {
                            PbFragment.this.cVv().beE().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().beE() != null) {
                            PbFragment.this.kzK.getPbData().cVm().beE().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h hRY = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.kDc.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a kEy = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.kDG.bWr();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.Ee(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.cvG();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c eFj = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cXx();
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
                        if (PbFragment.this.cM(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.kDG.cXv() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dD("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cWt() != null && PbFragment.this.cWt().hCp != null) {
                                PbFragment.this.cWt().hCp.onClick(view);
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
                if (PbFragment.this.kDS != null) {
                    PbFragment.this.kDG.tC(PbFragment.this.kDS.bsf());
                }
                PbFragment.this.kDG.dar();
                PbFragment.this.kDG.dbf();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener kEz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kEa) {
                PbFragment.this.kDG.bWr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzK.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cVC().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.kDZ.showSuccessToast(PbFragment.this.kDY.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.kDY.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Ce(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cYb();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.kDY.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.kDZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kEA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kEa) {
                PbFragment.this.kDG.bWr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.kDZ.showSuccessToast(PbFragment.this.kDY.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.kDY.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.kDZ.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kEB = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kEa) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.kDG.bWr();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.mtF;
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
                    PbFragment.this.kDG.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener kEC = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kDG.das() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cXx();
            }
        }
    };
    private CustomMessageListener hUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.hTJ = true;
                }
            }
        }
    };
    public a.b kks = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cmt();
            com.baidu.tbadk.core.data.av pageData = PbFragment.this.kzK.getPageData();
            int pageNum = PbFragment.this.kDG.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bdp()) {
                PbFragment.this.kDG.dbf();
                PbFragment.this.cms();
                PbFragment.this.kDG.daM();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.kzK.Ei(PbFragment.this.kDG.getPageNum());
                    if (PbFragment.this.kDe != null) {
                        PbFragment.this.kDe.showFloatingView();
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
    private k.c kED = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.kDK != null) {
                PbFragment.this.kDK.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.kEc != null && !TextUtils.isEmpty(PbFragment.this.kEd)) {
                        if (PbFragment.this.kEe == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.kEd));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.kEd;
                            aVar.pkgId = PbFragment.this.kEe.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.kEe.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.kEc = null;
                        PbFragment.this.kEd = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.kEc != null && !TextUtils.isEmpty(PbFragment.this.kEd)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.dTW == null) {
                                PbFragment.this.dTW = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.dTW.j(PbFragment.this.kEd, PbFragment.this.kEc.getImageByte());
                            PbFragment.this.kEc = null;
                            PbFragment.this.kEd = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.iUM != null) {
                        PbFragment.this.iUM.fF(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.iUM = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").ai("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cN(view);
                        if (PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().beE() != null && PbFragment.this.kzK.getPbData().cVm().beE().getUserId() != null && PbFragment.this.kDE != null) {
                            int h = PbFragment.this.h(PbFragment.this.kzK.getPbData());
                            bw cVm = PbFragment.this.kzK.getPbData().cVm();
                            if (cVm.bdm()) {
                                i2 = 2;
                            } else if (cVm.bdn()) {
                                i2 = 3;
                            } else if (cVm.bgz()) {
                                i2 = 4;
                            } else {
                                i2 = cVm.bgA() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dD("tid", PbFragment.this.kzK.kGR).ai("obj_locate", 2).dD("obj_id", PbFragment.this.kzK.getPbData().cVm().beE().getUserId()).ai("obj_type", PbFragment.this.kDE.baA() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i2));
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
                        PbFragment.this.Nv((String) tag);
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
                        PbFragment.this.kDG.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.kDG.cT(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.kDG.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bgv() != null) {
                            PbFragment.this.d(postData.bgv());
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
    public SortSwitchButton.a kEE = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean xL(int i) {
            PbFragment.this.kDG.dbf();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.kzK == null || PbFragment.this.kzK.isLoading) {
                    return false;
                }
                PbFragment.this.cms();
                PbFragment.this.kDG.daM();
                if (PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().kwO != null && PbFragment.this.kzK.getPbData().kwO.size() > i) {
                    int intValue = PbFragment.this.kzK.getPbData().kwO.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dD("tid", PbFragment.this.kzK.cYD()).dD("fid", PbFragment.this.kzK.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_type", Eg(intValue)));
                    if (PbFragment.this.kzK.En(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.kDG.ts(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Eg(int i) {
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
    public final View.OnClickListener hVH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
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
                    if (view == PbFragment.this.kDG.dbb()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.kzK.th(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.kDG.daN();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZR()) {
                        if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZS()) {
                            if (view == PbFragment.this.kDG.kKK.eUq) {
                                if (PbFragment.this.kDG.tB(PbFragment.this.kzK.cYJ())) {
                                    PbFragment.this.cms();
                                    return;
                                }
                                PbFragment.this.kDg = false;
                                PbFragment.this.kDf = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.kDc, PbFragment.this.kDG.kKK.eUq);
                                PbFragment.this.kDc.finish();
                            } else if (view != PbFragment.this.kDG.daK() && (PbFragment.this.kDG.kKK.dcl() == null || (view != PbFragment.this.kDG.kKK.dcl().cZQ() && view != PbFragment.this.kDG.kKK.dcl().cZO()))) {
                                if (view == PbFragment.this.kDG.dbj()) {
                                    if (PbFragment.this.kzK != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzK.getPbData().cVm().beD().getLink());
                                    }
                                } else if (view != PbFragment.this.kDG.kKK.kQY) {
                                    if (view == PbFragment.this.kDG.kKK.kQZ) {
                                        if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                            ArrayList<PostData> cVo = PbFragment.this.kzK.getPbData().cVo();
                                            if ((cVo == null || cVo.size() <= 0) && PbFragment.this.kzK.cYE()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dD("tid", PbFragment.this.kzK.cYC()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", PbFragment.this.kzK.getForumId()));
                                            if (!PbFragment.this.kDG.dby()) {
                                                PbFragment.this.kDG.dar();
                                            }
                                            PbFragment.this.cXF();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.kDG.sO(true);
                                            PbFragment.this.kDG.dar();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.kDG.cGx();
                                                PbFragment.this.cms();
                                                PbFragment.this.kDG.daM();
                                                PbFragment.this.kzK.NA(PbFragment.this.cXR());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZN()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.kDG.kKK.dcl() != null && view == PbFragment.this.kDG.kKK.dcl().cZM()) {
                                                PbFragment.this.kDG.kKK.aRN();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.Ef(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZK()) {
                                                    if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZU()) {
                                                        if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZL()) {
                                                            if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZV()) {
                                                                if (PbFragment.this.kDG.dbt() == view) {
                                                                    if (PbFragment.this.kDG.dbt().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.kzK.getPbData();
                                                                        if (pbData2 != null && pbData2.cVm() != null && pbData2.cVm().bek() != null) {
                                                                            String bea = pbData2.cVm().bek().bea();
                                                                            if (StringUtils.isNull(bea)) {
                                                                                bea = pbData2.cVm().bek().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dD("obj_id", bea));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.fS("c10725", null);
                                                                    }
                                                                    PbFragment.this.cXY();
                                                                } else if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZT()) {
                                                                    if (PbFragment.this.kDG.kKK.dcl() != null && view == PbFragment.this.kDG.kKK.dcl().cZP()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.kDG.b(PbFragment.this.kzK.getPbData(), PbFragment.this.kzK.cYE(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.kDG.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.kDG.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.kDG.kKK.aRN();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dD("tid", PbFragment.this.kzK.cYC());
                                                                            aqVar.dD("fid", PbFragment.this.kzK.getForumId());
                                                                            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.ai("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                                                                PbFragment.this.kDG.dbf();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dwW() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.mfX != null) {
                                                                                        com.baidu.tbadk.core.util.aq bjm = postData.mfX.bjm();
                                                                                        bjm.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bjm.ai("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bjm.ai("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bjm);
                                                                                    }
                                                                                    String cYC = PbFragment.this.kzK.cYC();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.kzK.getPbData() != null) {
                                                                                        i3 = PbFragment.this.kzK.getPbData().cVB();
                                                                                    }
                                                                                    PbFragment.this.cms();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a Ny = PbFragment.this.Ny(id);
                                                                                        if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && Ny != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cYC, id, "pb", true, null, true, null, i3, postData.ddk(), PbFragment.this.kzK.getPbData().getAnti(), false, postData.beE().getIconInfo()).addBigImageData(Ny.kzS, Ny.dUS, Ny.dUQ, Ny.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.kzK.cZm());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.kzK.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.kzK.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.kzK.cYL());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a Ny2 = PbFragment.this.Ny(id);
                                                                                        if (postData != null && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && Ny2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cYC, id, "pb", true, null, false, str2, i3, postData.ddk(), PbFragment.this.kzK.getPbData().getAnti(), false, postData.beE().getIconInfo()).addBigImageData(Ny2.kzS, Ny2.dUS, Ny2.dUQ, Ny2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.kzK.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.kzK.cYL());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.kzK.cZm());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.kzK.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").ai("obj_locate", 3).dD("fid", PbFragment.this.kzK.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.kzK != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dD("tid", PbFragment.this.kzK.cYC());
                                                                            aqVar2.dD("fid", PbFragment.this.kzK.getForumId());
                                                                            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.ai("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.mfX != null) {
                                                                                        com.baidu.tbadk.core.util.aq bjm2 = postData3.mfX.bjm();
                                                                                        bjm2.delete("obj_locate");
                                                                                        bjm2.ai("obj_locate", 8);
                                                                                        TiebaStatic.log(bjm2);
                                                                                    }
                                                                                    if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                                                                        String cYC2 = PbFragment.this.kzK.cYC();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.kzK.getPbData() != null) {
                                                                                            i4 = PbFragment.this.kzK.getPbData().cVB();
                                                                                        }
                                                                                        PbActivity.a Ny3 = PbFragment.this.Ny(id2);
                                                                                        if (Ny3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cYC2, id2, "pb", true, null, false, null, i4, postData3.ddk(), PbFragment.this.kzK.getPbData().getAnti(), false, postData3.beE().getIconInfo()).addBigImageData(Ny3.kzS, Ny3.dUS, Ny3.dUQ, Ny3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.kzK.cZm());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.kzK.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.kzK.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.kzK.cYL());
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
                                                                        if (PbFragment.this.kzK != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dD("tid", PbFragment.this.kzK.cYC());
                                                                                aqVar3.dD("fid", PbFragment.this.kzK.getForumId());
                                                                                aqVar3.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.ai("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.mfX != null) {
                                                                                        com.baidu.tbadk.core.util.aq bjm3 = postData4.mfX.bjm();
                                                                                        bjm3.delete("obj_locate");
                                                                                        bjm3.ai("obj_locate", 8);
                                                                                        TiebaStatic.log(bjm3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", PbFragment.this.kzK.cYD()).dD("fid", PbFragment.this.kzK.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData4.getId()).ai("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.cXu().dao() != null && postData4.beE() != null && postData4.dwK() != 1) {
                                                                                        if (PbFragment.this.cXu().dap() != null) {
                                                                                            PbFragment.this.cXu().dap().cXk();
                                                                                        }
                                                                                        if ((PbFragment.this.kBf || com.baidu.tbadk.a.d.aZV()) && postData4.dwH() != null && postData4.dwH().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.aZW()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.kzK.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.kzK.getPbData().cVm());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.cXu().dao().d(pVar);
                                                                                            PbFragment.this.cXu().dao().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.beE().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.kDS != null) {
                                                                                                PbFragment.this.kDG.tC(PbFragment.this.kDS.bsf());
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
                                                                        if (view != PbFragment.this.kDG.cWO()) {
                                                                            if (view == PbFragment.this.kDG.kKK.dcm()) {
                                                                                PbFragment.this.kDG.daT();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (cbVar = (cb) view.getTag()) != null && !StringUtils.isNull(cbVar.bgU())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        com.baidu.tbadk.core.util.be.bju().b(PbFragment.this.getPageContext(), new String[]{cbVar.bgU()});
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dD("tid", PbFragment.this.kzK.kGR));
                                                                                            }
                                                                                            if (PbFragment.this.kDL == null) {
                                                                                                PbFragment.this.kDL = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.kDL.a(PbFragment.this.kED);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.cO(view);
                                                                                            if (!PbFragment.this.cO(view) || PbFragment.this.kEc == null || !PbFragment.this.kEc.isGif()) {
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
                                                                                                if (postData5.dwM() != null && postData5.dwM().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kDL);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.mTextView.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.iUM = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.kzK.getPbData().baA()) {
                                                                                                String baz = PbFragment.this.kzK.getPbData().baz();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(baz) && baz.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kDL);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kDL);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.iUM);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z6 && z5) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kDL);
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
                                                                                                            if (PbFragment.this.sV(z4) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDL);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDL);
                                                                                                                gVar2.mTextView.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kDL);
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
                                                                                                            if (PbFragment.this.kzK.getPbData().cVB() == 1002 && !z4) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDL);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDL);
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
                                                                                                    PbFragment.this.kDL.aT(arrayList);
                                                                                                    PbFragment.this.kDK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kDL);
                                                                                                    PbFragment.this.kDK.Nv();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.iUM);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.kDL.aT(arrayList);
                                                                                            PbFragment.this.kDK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kDL);
                                                                                            PbFragment.this.kDK.Nv();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.kzK.getPbData().cVm().getActUrl());
                                                                                        if (PbFragment.this.kzK.getPbData().cVm().bfr() != 1) {
                                                                                            if (PbFragment.this.kzK.getPbData().cVm().bfr() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dD("fid", PbFragment.this.kzK.getPbData().getForumId()).dD("tid", PbFragment.this.kzK.getPbData().getThreadId()).dD("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.kzK.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.kDG.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bg.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.bik().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.kDG.dar();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.cXD() == 1 && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dD("fid", PbFragment.this.kzK.getPbData().getForumId()).dD("tid", PbFragment.this.kzK.getPbData().getThreadId()).dD("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.cXD() == 1 && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dD("fid", PbFragment.this.kzK.getPbData().getForumId()).dD("tid", PbFragment.this.kzK.getPbData().getThreadId()).dD("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.cXT();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.cXU();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVI() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.kzK.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dD("fid", pbData3.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.bju().b(PbFragment.this.getPageContext(), new String[]{pbData3.cVI().cVU()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVI() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.kzK.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dD("fid", pbData4.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.bju().b(PbFragment.this.getPageContext(), new String[]{pbData4.cVI().cVU()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.kEf >= 0) {
                                                                                        if (PbFragment.this.kzK != null) {
                                                                                            PbFragment.this.kzK.cZn();
                                                                                        }
                                                                                        if (PbFragment.this.kzK != null && PbFragment.this.kDG.daI() != null) {
                                                                                            PbFragment.this.kDG.daI().a(PbFragment.this.kzK.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.kEf = 0;
                                                                                        if (PbFragment.this.kzK != null) {
                                                                                            PbFragment.this.kDG.getListView().setSelection(PbFragment.this.kzK.cZq());
                                                                                            PbFragment.this.kzK.cU(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.Ef(8);
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
                                                                                    if (PbFragment.this.kDG.getListView() != null && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.kDG.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.kDG.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean cVM = PbFragment.this.kzK.getPbData().cVM();
                                                                                        boolean z9 = PbFragment.this.kDG.daq() != null && PbFragment.this.kDG.daq().bNf();
                                                                                        boolean dbc = PbFragment.this.kDG.dbc();
                                                                                        boolean z10 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (cVM && PbFragment.this.kDG.daq() != null && PbFragment.this.kDG.daq().bGk() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.kDG.daq().dbV();
                                                                                            z10 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.kDG.daq().bGk().getHeight() - PbFragment.this.kDG.daq().dbV());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.Nz("c13568");
                                                                                        if ((PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().bev() <= 0) || (dbc && z10)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.cXA();
                                                                                                if (PbFragment.this.kzK.getPbData().cVm().beE() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", PbFragment.this.kzK.kGR).dD("fid", PbFragment.this.kzK.getPbData().getForumId()).ai("obj_locate", 2).dD("uid", PbFragment.this.kzK.getPbData().cVm().beE().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z11 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (cVM) {
                                                                                                if (PbFragment.this.kDG.kLU != null && PbFragment.this.kDG.kLU.kMZ != null && PbFragment.this.kDG.kLU.kMZ.getView() != null) {
                                                                                                    if (PbFragment.this.kDG.kLU.kMZ.getView().getParent() == null) {
                                                                                                        z11 = firstVisiblePosition >= PbFragment.this.cXJ();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.kDG.daq() != null && PbFragment.this.kDG.daq().bGk() != null) {
                                                                                                            i6 = PbFragment.this.kDG.daq().bGk().getBottom();
                                                                                                        }
                                                                                                        z11 = PbFragment.this.kDG.kLU.kMZ.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.kDG.daz() != null) {
                                                                                                z11 = PbFragment.this.kDG.daz().getVisibility() == 0;
                                                                                                if (!z11 && PbFragment.this.kDG.kLU != null && PbFragment.this.kDG.kLU.kMZ != null && PbFragment.this.kDG.kLU.kMZ.getView() != null && PbFragment.this.kDG.kLU.kMZ.getView().getParent() != null && PbFragment.this.kDG.kKK != null && PbFragment.this.kDG.kKK.mNavigationBar != null) {
                                                                                                    z11 = PbFragment.this.kDG.kLU.kMZ.getView().getTop() - PbFragment.this.kDG.kKK.mNavigationBar.getBottom() < PbFragment.this.kDG.kLU.kMZ.kKj.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z11 || dbc) {
                                                                                                PbFragment.this.kDy = firstVisiblePosition;
                                                                                                PbFragment.this.kDz = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.kDG.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.kDG.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.kDG.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.kDy > 0) {
                                                                                                if (PbFragment.this.kDG.getListView().getChildAt(PbFragment.this.kDy) != null) {
                                                                                                    PbFragment.this.kDG.getListView().smoothScrollToPosition(PbFragment.this.kDy, PbFragment.this.kDz, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.kDG.getListView().setSelectionFromTop(PbFragment.this.kDy, PbFragment.this.kDz + equipmentHeight);
                                                                                                    PbFragment.this.kDG.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int cXJ = PbFragment.this.cXJ();
                                                                                                if (PbFragment.this.cXI() != -1) {
                                                                                                    cXJ--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (cXJ < 0) {
                                                                                                    i = PbFragment.this.kDG.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.kDG.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = cXJ;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z9) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!cVM || PbFragment.this.kDG.daq() == null) {
                                                                                                    if (PbFragment.this.kDG.kKK != null && PbFragment.this.kDG.kKK.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.kDG.kKK.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.kDG.daq().dbU();
                                                                                                }
                                                                                                if (PbFragment.this.kDG.kLU == null || PbFragment.this.kDG.kLU.kMZ == null || PbFragment.this.kDG.kLU.kMZ.getView() == null || PbFragment.this.kDG.kLU.kMZ.getView().getParent() == null) {
                                                                                                    PbFragment.this.kDG.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.kDG.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z9) {
                                                                                                    PbFragment.this.kDG.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.kDG.getListView().smoothScrollBy(PbFragment.this.kDG.kLU.kMZ.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().beE() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", PbFragment.this.kzK.kGR).dD("fid", PbFragment.this.kzK.getPbData().getForumId()).ai("obj_locate", 2).dD("uid", PbFragment.this.kzK.getPbData().cVm().beE().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.kzK.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.kzK.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.kzK.cWv()) || PbFragment.this.kzK.getAppealInfo() == null) {
                                                                                                PbFragment.this.kDc.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.kzK.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.kzK.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.kDc.finish();
                                                                                            return;
                                                                                        }
                                                                                        String cWv = PbFragment.this.kzK.cWv();
                                                                                        if (PbFragment.this.kzK.cYF() && cWv != null && cWv.equals(name)) {
                                                                                            PbFragment.this.kDc.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.kzK.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dD("tid", PbFragment.this.kzK.cYC());
                                                                                        aqVar4.dD("fid", PbFragment.this.kzK.getForumId());
                                                                                        aqVar4.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.kzK.getPbData().cVm() != null) {
                                                                                            aqVar4.dD("nid", PbFragment.this.kzK.getPbData().cVm().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar = (bw) view.getTag();
                                                                                        if (PbFragment.this.kzK.cZm() == 3 && PbFragment.this.cWu() && PbFragment.this.kzK.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.kzK.getPbData().cVJ())) {
                                                                                            PbFragment.this.kDc.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar.beI(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar5 = new com.baidu.tbadk.core.util.aq("c13399");
                                                                                        aqVar5.dD("tid", bwVar.getId());
                                                                                        aqVar5.u("fid", bwVar.getFid());
                                                                                        aqVar5.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar5.dD("nid", bwVar.getNid());
                                                                                        TiebaStatic.log(aqVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.kzK != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dD("tid", PbFragment.this.kzK.cYC());
                                                                                        aqVar6.dD("fid", PbFragment.this.kzK.getForumId());
                                                                                        aqVar6.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.ai("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.kzK.getPbData();
                                                                                        if (PbFragment.this.kDF == null) {
                                                                                            PbFragment.this.kDF = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").u("forum_id", j2).bjn();
                                                                                        PbFragment.this.registerListener(PbFragment.this.kEH);
                                                                                        PbFragment.this.kDF.H(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dD("fid", PbFragment.this.kzK.getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_name", smartApp.name).u("obj_id", smartApp.swan_app_id.longValue()).dD("obj_source", "PB_card").dD("tid", PbFragment.this.kzK.cYC()).ai("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar2 = (bw) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar2.beI(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dD("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 9).ai("obj_locate", 9).u("obj_id", bwVar2.getFid()).dD("tid", bwVar2.getId()).ai("thread_type", bwVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bw) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bw bwVar3 = (bw) view.getTag();
                                                                                        if (PbFragment.this.exb != null) {
                                                                                            PbFragment.this.exb.fR(bwVar3.beI(), String.valueOf(bwVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dD("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 10).ai("obj_locate", 11).u("obj_id", bwVar3.getFid()).dD("tid", bwVar3.getId()).ai("thread_type", bwVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.kzK.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.kzK.cYC(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.kzK.getPbData().cVm().beZ())));
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
                                                                            if (PbFragment.this.kDL == null) {
                                                                                PbFragment.this.kDL = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.kDL.a(PbFragment.this.kED);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z12 = PbFragment.this.cWE().getPbData() != null && PbFragment.this.cWE().getPbData().cVP();
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
                                                                                if (postData6.bgv() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bgv().hasAgree && postData6.bgf() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.kDL);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.mTextView.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z14 && z13) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kDL);
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
                                                                                        if ((PbFragment.this.sV(z2) && TbadkCoreApplication.isLogin()) && !z12) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDL);
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
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDL);
                                                                                            gVar11.mTextView.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kDL);
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
                                                                                            if (PbFragment.this.kzK.getPbData().cVB() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDL);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDL);
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
                                                                                PbFragment.this.kDL.aT(arrayList2);
                                                                                PbFragment.this.kDK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kDL);
                                                                                PbFragment.this.kDK.Nv();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.kDG.dbf();
                                                                    SparseArray<Object> b3 = PbFragment.this.kDG.b(PbFragment.this.kzK.getPbData(), PbFragment.this.kzK.cYE(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzK.getPbData().getForum().getId(), PbFragment.this.kzK.getPbData().getForum().getName(), PbFragment.this.kzK.getPbData().cVm().getId(), String.valueOf(PbFragment.this.kzK.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                PbFragment.this.kDG.kKK.dck();
                                                            }
                                                        } else if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVm() != null) {
                                                            PbFragment.this.kDG.kKK.aRN();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.Nv(PbFragment.this.kzK.getPbData().cVm().beV());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.kDG.dbf();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.kzK.cYV()));
                                                                return;
                                                            }
                                                            PbFragment.this.cms();
                                                            PbFragment.this.kDG.daM();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.kzK.getPbData().kwO == null || PbFragment.this.kzK.getPbData().kwO.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.kzK.getPbData().kwO.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.kzK.getPbData().kwO.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.kzK.getPbData().kwO.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.kzK.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.kzK.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.kzK.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.kzK.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").ai("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ai("obj_type", i10));
                                                                    if (PbFragment.this.kzK.getPbData().kwO != null && PbFragment.this.kzK.getPbData().kwO.size() > i9) {
                                                                        i9 = PbFragment.this.kzK.getPbData().kwO.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean En = PbFragment.this.kzK.En(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.kzK.cYV()));
                                                                    if (En) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.kDG.ts(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.Nv();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.kDG.dbf();
                                                    if (PbFragment.this.cWE().getPbData().kwP != 2) {
                                                        if (PbFragment.this.kzK.getPageData() != null) {
                                                            PbFragment.this.kDG.a(PbFragment.this.kzK.getPageData(), PbFragment.this.kks);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.kzK.getPbData()) != null) {
                                                bw cVm = pbData.cVm();
                                                if (cVm != null && cVm.beE() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", PbFragment.this.kzK.kGR).dD("fid", pbData.getForumId()).ai("obj_locate", 4).dD("uid", cVm.beE().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (cVm != null) {
                                                    if (cVm.bdm()) {
                                                        i9 = 2;
                                                    } else if (cVm.bdn()) {
                                                        i9 = 3;
                                                    } else if (cVm.bgz()) {
                                                        i9 = 4;
                                                    } else if (cVm.bgA()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar7.dD("tid", PbFragment.this.kzK.cYC());
                                                aqVar7.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar7.dD("fid", PbFragment.this.kzK.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar7.ai("obj_locate", 5);
                                                } else {
                                                    aqVar7.ai("obj_locate", 6);
                                                }
                                                aqVar7.ai("obj_name", i9);
                                                aqVar7.ai("obj_type", 1);
                                                if (cVm != null) {
                                                    if (cVm.bdm()) {
                                                        aqVar7.ai("obj_type", 10);
                                                    } else if (cVm.bdn()) {
                                                        aqVar7.ai("obj_type", 9);
                                                    } else if (cVm.bgA()) {
                                                        aqVar7.ai("obj_type", 8);
                                                    } else if (cVm.bgz()) {
                                                        aqVar7.ai("obj_type", 7);
                                                    } else if (cVm.isShareThread) {
                                                        aqVar7.ai("obj_type", 6);
                                                    } else if (cVm.threadType == 0) {
                                                        aqVar7.ai("obj_type", 1);
                                                    } else if (cVm.threadType == 40) {
                                                        aqVar7.ai("obj_type", 2);
                                                    } else if (cVm.threadType == 49) {
                                                        aqVar7.ai("obj_type", 3);
                                                    } else if (cVm.threadType == 54) {
                                                        aqVar7.ai("obj_type", 4);
                                                    } else {
                                                        aqVar7.ai("obj_type", 5);
                                                    }
                                                    aqVar7.ai(IntentConfig.CARD_TYPE, cVm.bgD());
                                                    aqVar7.dD(IntentConfig.RECOM_SOURCE, cVm.mRecomSource);
                                                    aqVar7.dD("ab_tag", cVm.mRecomAbTag);
                                                    aqVar7.dD("weight", cVm.mRecomWeight);
                                                    aqVar7.dD("extra", cVm.mRecomExtra);
                                                    aqVar7.dD("nid", cVm.getNid());
                                                    if (cVm.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(cVm.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar7.dD("obj_param6", cVm.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar7.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.cYj() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.cYj(), aqVar7);
                                                }
                                                TiebaStatic.log(aqVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> cVo2 = PbFragment.this.kzK.getPbData().cVo();
                                                    if ((cVo2 != null && cVo2.size() > 0) || !PbFragment.this.kzK.cYE()) {
                                                        PbFragment.this.kDG.dbf();
                                                        PbFragment.this.cms();
                                                        if (pbData.cVI() != null && !StringUtils.isNull(pbData.cVI().bcA(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dD("fid", PbFragment.this.kzK.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), cVm)) {
                                                            if (PbFragment.this.kDG != null) {
                                                                PbFragment.this.kDG.dbi();
                                                                PbFragment.this.kDG.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.kDG.showLoadingDialog();
                                                                PbFragment.this.kzK.cZh().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.Ee(i10);
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
                                            PbFragment.this.kDG.dbf();
                                            if (PbFragment.this.kDG.kKK.dcl() != null && view == PbFragment.this.kDG.kKK.dcl().cZN() && !PbFragment.this.kDG.dby()) {
                                                PbFragment.this.kDG.dar();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cms();
                                                PbFragment.this.kDG.daM();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    z3 = PbFragment.this.kzK.z(true, PbFragment.this.cXR());
                                                } else {
                                                    z3 = view.getId() == R.id.reply_title ? PbFragment.this.kzK.z(false, PbFragment.this.cXR()) : PbFragment.this.kzK.NA(PbFragment.this.cXR());
                                                }
                                                view.setTag(Boolean.valueOf(z3));
                                                if (z3) {
                                                    PbFragment.this.kDG.sO(true);
                                                    PbFragment.this.kDG.cGx();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.kDG.ts(true);
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
                                        PbFragment.this.kDG.dbf();
                                        if (PbFragment.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.kzK.Eo(PbFragment.this.kDG.daR()) != null) {
                                            PbFragment.this.cXM();
                                            if (PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().beE() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", PbFragment.this.kzK.kGR).dD("fid", PbFragment.this.kzK.getPbData().getForumId()).ai("obj_locate", 3).dD("uid", PbFragment.this.kzK.getPbData().cVm().beE().getUserId()));
                                            }
                                            if (PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().beE() != null && PbFragment.this.kzK.getPbData().cVm().beE().getUserId() != null && PbFragment.this.kDE != null) {
                                                int h = PbFragment.this.h(PbFragment.this.kzK.getPbData());
                                                bw cVm2 = PbFragment.this.kzK.getPbData().cVm();
                                                int i11 = 1;
                                                if (cVm2.bdm()) {
                                                    i11 = 2;
                                                } else if (cVm2.bdn()) {
                                                    i11 = 3;
                                                } else if (cVm2.bgz()) {
                                                    i11 = 4;
                                                } else if (cVm2.bgA()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dD("tid", PbFragment.this.kzK.kGR).ai("obj_locate", 1).dD("obj_id", PbFragment.this.kzK.getPbData().cVm().beE().getUserId()).ai("obj_type", PbFragment.this.kDE.baA() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i11));
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
                                    if (PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().bdk() && PbFragment.this.kzK.getPbData().cVm().beW() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.kzK.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.kzK.cWv()) || PbFragment.this.kzK.getAppealInfo() == null) {
                                            PbFragment.this.kDc.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.kzK.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.kzK.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.kDc.finish();
                                        return;
                                    }
                                    String cWv2 = PbFragment.this.kzK.cWv();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.kzK.cYF() && cWv2 != null && cWv2.equals(name2)) {
                                        PbFragment.this.kDc.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.kzK.getPbData() != null) {
                                    if ((PbFragment.this.kzK.getPbData().cVB() == 1 || PbFragment.this.kzK.getPbData().cVB() == 3) && !PbFragment.this.hkz.dxv()) {
                                        PbFragment.this.kDG.dbf();
                                        int i12 = 0;
                                        if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZO()) {
                                            if (PbFragment.this.kDG.kKK.dcl() == null || view != PbFragment.this.kDG.kKK.dcl().cZQ()) {
                                                if (view == PbFragment.this.kDG.daK()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.kzK.getPbData().cVm().beA() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.kzK.getPbData().cVm().bez() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.kzK.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.kzK.getPbData().cVm().getId();
                                        PbFragment.this.kDG.daJ();
                                        PbFragment.this.hkz.b(id4, name3, id5, i12, PbFragment.this.kDG.daL());
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
                            PbFragment.this.kDG.kKK.dck();
                            if (PbFragment.this.kzK != null) {
                                PbFragment.this.hkB.setThreadId(PbFragment.this.kzK.cYC());
                            }
                            int i13 = 1;
                            if (PbFragment.this.kzK == null || !PbFragment.this.kzK.isPrivacy()) {
                                PbFragment.this.hkB.cbu();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.cWE() != null && PbFragment.this.cWE().getPbData() != null && PbFragment.this.cWE().getPbData().getThreadId() != null && PbFragment.this.cWE().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.cWE() != null && PbFragment.this.cWE().getPbData() != null) {
                                    PbFragment.this.hkB.i(3, i13, PbFragment.this.cWE().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.cWE() != null && PbFragment.this.cWE().getPbData() != null) {
                                    PbFragment.this.hkB.i(3, 3, PbFragment.this.cWE().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.kDG.dbf();
                        PbFragment.this.cms();
                        PbFragment.this.kDG.daM();
                        PbFragment.this.kDG.showLoadingDialog();
                        if (PbFragment.this.kDG.daz() != null) {
                            PbFragment.this.kDG.daz().setVisibility(8);
                        }
                        PbFragment.this.kzK.Ei(1);
                        if (PbFragment.this.kDe != null) {
                            PbFragment.this.kDe.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cXB = PbFragment.this.cXB();
                        if (!TextUtils.isEmpty(cXB)) {
                            com.baidu.tbadk.core.util.be.bju().b(PbFragment.this.getPageContext(), new String[]{cXB});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar8.dD("tid", PbFragment.this.kzK.cYC());
                aqVar8.dD("fid", PbFragment.this.kzK.getForumId());
                aqVar8.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar8.ai("obj_locate", 1);
                TiebaStatic.log(aqVar8);
                if (PbFragment.this.kDn) {
                    PbFragment.this.kDn = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.cXu().dao() != null && postData7.beE() != null && postData7.dwK() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cXu().dap() != null) {
                                PbFragment.this.cXu().dap().cXk();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.kzK.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.kzK.getPbData().cVm());
                            pVar2.g(postData7);
                            PbFragment.this.cXu().dao().d(pVar2);
                            PbFragment.this.cXu().dao().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.beE().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kzK.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.kDS != null) {
                                PbFragment.this.kDG.tC(PbFragment.this.kDS.bsf());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener kEF = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kzK != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.kzK.kGR)) {
                PbFragment.this.f((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ag agVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kzK.getPbData() != null) {
                    aqVar.dD("fid", PbFragment.this.kzK.getPbData().getForumId());
                }
                aqVar.dD("tid", PbFragment.this.kzK.cYC());
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.cms();
            PbFragment.this.kDG.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbFragment.this.f(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.kzK.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzK.getPbData();
                            if (pbData != null && pbData.cVm() != null && pbData.cVm().beE() != null && (userId = pbData.cVm().beE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.kzK.cYO()) {
                                PbFragment.this.kDG.daM();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.kzK.cYO()) {
                            PbFragment.this.kDG.daM();
                        }
                    } else if (floor != null) {
                        PbFragment.this.kDG.s(PbFragment.this.kzK.getPbData());
                    }
                    if (PbFragment.this.kzK.cYI()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dD("tid", PbFragment.this.kzK.cYC()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.sU(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.kDS.bsm() || PbFragment.this.kDS.bsn()) {
                    PbFragment.this.kDS.a(false, postWriteCallBackData);
                }
                PbFragment.this.jJI.g(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.jFD != null) {
                    PbFragment.this.jFD.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.zA(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zA(postWriteCallBackData.getErrorString());
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
                aVar.b(PbFragment.this.getPageContext()).bhg();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (agVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d kEG = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ag agVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                    aqVar.dD("fid", PbFragment.this.kzK.getPbData().getForumId());
                }
                if (PbFragment.this.kzK != null) {
                    aqVar.dD("tid", PbFragment.this.kzK.cYC());
                }
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.jJI != null) {
                    PbFragment.this.jJI.dbD();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.jFD != null) {
                    PbFragment.this.jFD.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.zA(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zA(postWriteCallBackData.getErrorString());
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
                aVar.b(PbFragment.this.getPageContext()).bhg();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.jJI != null) {
                if (PbFragment.this.kDG != null && PbFragment.this.kDG.dap() != null && PbFragment.this.kDG.dap().cXo() != null && PbFragment.this.kDG.dap().cXo().bsn()) {
                    PbFragment.this.kDG.dap().cXo().a(postWriteCallBackData);
                }
                PbFragment.this.jJI.h(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a kEH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dbB;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.kDc.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.kDG != null && (dbB = PbFragment.this.kDG.dbB()) != null && PbFragment.this.kDG.getListView() != null) {
                            PbFragment.this.kDG.getListView().removeHeaderView(dbB);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a kEI = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qb;
            if (!z || fVar == null || fVar.cVz() != null || com.baidu.tbadk.core.util.y.getCount(fVar.cVo()) >= 1) {
                PbFragment.this.jZg = true;
                PbFragment.this.kDG.daO();
                if (fVar == null || !fVar.cVu()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.kDG.getView());
                }
                PbFragment.this.kDG.cGw();
                if (PbFragment.this.isFullScreen || PbFragment.this.kDG.dby()) {
                    PbFragment.this.kDG.dbp();
                } else if (!PbFragment.this.kDG.dbm()) {
                    PbFragment.this.kDG.tE(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.ftk = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.kDG.getView());
                    PbFragment.this.kDG.daX();
                }
                if (z && fVar != null) {
                    bw cVm = fVar.cVm();
                    if (cVm == null || !cVm.bdo()) {
                        PbFragment.this.d(PbFragment.this.kDR);
                    } else {
                        cYl();
                    }
                    PbFragment.this.kDG.dap().setPbData(fVar);
                    PbFragment.this.kDG.bLt();
                    if (cVm != null && cVm.bfP() != null) {
                        PbFragment.this.a(cVm.bfP());
                    }
                    if (PbFragment.this.kDS != null) {
                        PbFragment.this.kDG.tC(PbFragment.this.kDS.bsf());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.cVo() != null && fVar.cVo().size() >= 1 && fVar.cVo().get(0) != null) {
                        PbFragment.this.kzK.NC(fVar.cVo().get(0).getId());
                    } else if (fVar.cVz() != null) {
                        PbFragment.this.kzK.NC(fVar.cVz().getId());
                    }
                    if (PbFragment.this.kDS != null) {
                        PbFragment.this.kDS.a(fVar.getAnti());
                        PbFragment.this.kDS.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.kDS.setThreadData(cVm);
                        PbFragment.this.kDS.a(PbFragment.this.kzK.cYS(), PbFragment.this.kzK.cYC(), PbFragment.this.kzK.cZj());
                        if (cVm != null) {
                            PbFragment.this.kDS.jq(cVm.bgb());
                        }
                    }
                    if (PbFragment.this.kDE != null) {
                        PbFragment.this.kDE.hB(fVar.baA());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.cVP()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.kDG.tD(PbFragment.this.mIsFromCDN);
                    PbFragment.this.kDG.a(fVar, i2, i3, PbFragment.this.kzK.cYE(), i4, PbFragment.this.kzK.getIsFromMark());
                    PbFragment.this.kDG.d(fVar, PbFragment.this.kzK.cYE());
                    PbFragment.this.kDG.tA(PbFragment.this.kzK.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.eMx = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.eMx) && PbFragment.this.kDS != null && PbFragment.this.kDS.brw() != null && (qb = PbFragment.this.kDS.brw().qb(6)) != null && !TextUtils.isEmpty(PbFragment.this.eMx)) {
                            ((View) qb).setOnClickListener(PbFragment.this.eNj);
                        }
                    }
                    if (PbFragment.this.kDN) {
                        PbFragment.this.kDN = false;
                        final int cXI = PbFragment.this.cXI();
                        if (!fVar.cVM()) {
                            PbFragment.this.kDG.Ev(cXI);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cXI, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.kDO) {
                        PbFragment.this.kDO = false;
                        final int cXI2 = PbFragment.this.cXI();
                        final boolean z2 = cXI2 != -1;
                        if (!z2) {
                            cXI2 = PbFragment.this.cXJ();
                        }
                        if (PbFragment.this.kDG != null) {
                            if (!fVar.cVM()) {
                                PbFragment.this.kDG.Ev(cXI2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cXI2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.kDG.setSelectionFromTop(cXI2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.kDG.setSelectionFromTop(cXI2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.kDG.tF(true);
                                PbFragment.this.kDG.tE(false);
                            }
                        }
                    } else if (PbFragment.this.kDP) {
                        PbFragment.this.kDP = false;
                        PbFragment.this.kDG.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.kDG.daS();
                    }
                    PbFragment.this.kzK.a(fVar.getForum(), PbFragment.this.kEt);
                    PbFragment.this.kzK.a(PbFragment.this.kEu);
                    if (PbFragment.this.jFD != null && cVm != null && cVm.beE() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cVm.beE());
                        PbFragment.this.jFD.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.ftk && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.kzK.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.kzK.getAppealInfo().kwG)) {
                                    PbFragment.this.kDG.a(PbFragment.this.kzK.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.kDG.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.kDG.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.kDG.dbp();
                            PbFragment.this.kDG.daW();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.kzK.cYC());
                            jSONObject.put("fid", PbFragment.this.kzK.getForumId());
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
                        PbFragment.this.kDG.NI("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                            arrayList = PbFragment.this.kzK.getPbData().cVo();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dwK() != 1)) {
                            PbFragment.this.kDG.NI(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.cYc()) {
                                PbFragment.this.kDG.NJ(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.kDG.NJ(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.kDG.s(PbFragment.this.kzK.getPbData());
                        }
                    }
                    PbFragment.this.kDG.endLoadData();
                }
                if (fVar != null && fVar.kwV && PbFragment.this.eRX == 0) {
                    PbFragment.this.eRX = System.currentTimeMillis() - PbFragment.this.hvt;
                }
                if (!PbFragment.this.cWE().cYE() || PbFragment.this.cWE().getPbData().getPage().bdv() != 0 || PbFragment.this.cWE().cZe()) {
                    PbFragment.this.kDT = true;
                    return;
                }
                return;
            }
            PbFragment.this.kzK.Ei(1);
            if (PbFragment.this.kDe != null) {
                PbFragment.this.kDe.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cYl() {
            if (PbFragment.this.kzK != null) {
                if (PbFragment.this.kDS == null || !PbFragment.this.kDS.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.kDS = (com.baidu.tbadk.editortools.pb.e) dVar.ec(PbFragment.this.getContext());
                    PbFragment.this.kDS.a(PbFragment.this.kDc.getPageContext());
                    PbFragment.this.kDS.a(PbFragment.this.eMH);
                    PbFragment.this.kDS.a(PbFragment.this.eMA);
                    PbFragment.this.kDS.a(PbFragment.this.kDc.getPageContext(), PbFragment.this.kDc.getIntent() == null ? null : PbFragment.this.kDc.getIntent().getExtras());
                    PbFragment.this.kDS.brw().jj(true);
                    PbFragment.this.kDG.setEditorTools(PbFragment.this.kDS.brw());
                    if (!PbFragment.this.kzK.cYJ()) {
                        PbFragment.this.kDS.BZ(PbFragment.this.kzK.cYC());
                    }
                    if (PbFragment.this.kzK.cZk()) {
                        PbFragment.this.kDS.BX(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.kDG != null) {
                        PbFragment.this.kDS.BX(PbFragment.this.kDG.dat());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.kDG.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.buo().bup()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.hvt : j;
                if (PbFragment.this.eRX == 0) {
                    PbFragment.this.eRX = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.eRN, PbFragment.this.createTime, PbFragment.this.eRX, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.eRN = 0L;
                if (iVar != null) {
                    iVar.bul();
                }
                if (z2) {
                    iVar.eSg = currentTimeMillis;
                    iVar.jC(true);
                }
                if (!z2 && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVm() != null) {
                    int threadType = PbFragment.this.kzK.getPbData().cVm().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.kDr, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.kDr, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.eSi = currentTimeMillis;
                                iVar2.qA(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.eSi = currentTimeMillis;
                        dVar.qA(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener kEJ = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cXE();
            }
        }
    };
    private final a.InterfaceC0535a kEK = new a.InterfaceC0535a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0535a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.kDG.daO();
            if (z) {
                if (PbFragment.this.kDE != null) {
                    PbFragment.this.kDE.hB(z2);
                }
                PbFragment.this.kzK.tj(z2);
                if (PbFragment.this.kzK.baA()) {
                    PbFragment.this.cXN();
                } else {
                    PbFragment.this.kDG.s(PbFragment.this.kzK.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.kDE != null) {
                        if (PbFragment.this.kDE.baD() != null && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.kzK.getPbData().cVm() != null && PbFragment.this.kzK.getPbData().cVm().beE() != null) {
                            MarkData baD = PbFragment.this.kDE.baD();
                            MetaData beE = PbFragment.this.kzK.getPbData().cVm().beE();
                            if (baD != null && beE != null) {
                                if (!com.baidu.tbadk.core.util.at.equals(TbadkCoreApplication.getCurrentAccount(), beE.getUserId()) && !beE.hadConcerned()) {
                                    PbFragment.this.b(beE);
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
                    PbFragment.this.cXK();
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
            if (!PbFragment.this.DT(PbFragment.this.mLastScrollState) && PbFragment.this.DT(i)) {
                if (PbFragment.this.kDG != null) {
                    PbFragment.this.kDG.dbf();
                    if (PbFragment.this.kDS != null && !PbFragment.this.kDG.das()) {
                        PbFragment.this.kDG.tC(PbFragment.this.kDS.bsf());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.kDG.dar();
                    }
                }
                if (!PbFragment.this.kDk) {
                    PbFragment.this.kDk = true;
                    if (PbFragment.this.kDG != null) {
                        PbFragment.this.kDG.dbl();
                    }
                }
            }
            if (PbFragment.this.kDG != null) {
                PbFragment.this.kDG.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.kDe != null) {
                PbFragment.this.kDe.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.kDl == null) {
                PbFragment.this.kDl = new com.baidu.tbadk.n.b();
                PbFragment.this.kDl.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.kDl.buf();
            } else {
                PbFragment.this.kDl.bue();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dvJ().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cVo;
            if (PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null && PbFragment.this.kDG != null && PbFragment.this.kDG.daI() != null) {
                PbFragment.this.kDG.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.kDe != null) {
                    PbFragment.this.kDe.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.kzK.cZa() && (cVo = PbFragment.this.kzK.getPbData().cVo()) != null && !cVo.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.kDG.daI().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzK.getPbData();
                    if (pbData != null) {
                        if (pbData.cVp() != null && pbData.cVp().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cVq() != null && pbData.cVq().hasData()) {
                            headerCount--;
                        }
                        int size = cVo.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d hkG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.hkz.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.kzK.cYX();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.kSU != 1002 || bVar.ghv) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.kDG.a(1, dVar.Qf, dVar.mhO, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.hkz.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.kDG.a(PbFragment.this.hkz.getLoadDataMode(), gVar.Qf, gVar.mhO, false);
                            PbFragment.this.kDG.aX(gVar.mhR);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.kDG.a(PbFragment.this.hkz.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c kEL = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c fqR = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cXS()) {
                PbFragment.this.kDc.finish();
            }
            if (!PbFragment.this.kzK.ti(true)) {
                PbFragment.this.kDG.daP();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e kEN = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.kEM && PbFragment.this.cXS()) {
                PbFragment.this.cXU();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.kzK.th(false)) {
                    PbFragment.this.kDG.daN();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.kzK.getPbData() != null) {
                    PbFragment.this.kDG.dbk();
                }
                PbFragment.this.kEM = true;
            }
        }
    };
    private int kEO = 0;
    private final TbRichTextView.i fcC = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g daI;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.kDG.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dD("tid", PbFragment.this.kzK.cYC());
                aqVar.dD("fid", PbFragment.this.kzK.getForumId());
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.ai("obj_locate", 3);
                aqVar.ai("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.kzK.kAH.cVP()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bxy() != null) {
                            ArrayList<TbRichTextImageInfo> bxy = tbRichTextView.getRichText().bxy();
                            int i4 = 0;
                            while (i4 < bxy.size()) {
                                if (bxy.get(i4) != null) {
                                    arrayList.add(bxy.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bxy.get(i4).getSrc()) || str.equals(bxy.get(i4).bxT()) || str.equals(bxy.get(i4).bxQ()) || str.equals(bxy.get(i4).bxS()) || str.equals(bxy.get(i4).bxW()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bxy.get(i4).getSrc();
                                    imageUrlData.originalUrl = bxy.get(i4).getSrc();
                                    imageUrlData.isLongPic = bxy.get(i4).bxY();
                                    concurrentHashMap.put(bxy.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).mM(i3).hI(false).hJ(PbFragment.this.kzK.cYU()).a(concurrentHashMap).hK(true).hL(false).hM(PbFragment.this.cYc()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.kzK != null) {
                            aVar.yV(PbFragment.this.kzK.getFromForumId());
                            if (PbFragment.this.kzK.getPbData() != null) {
                                aVar.r(PbFragment.this.kzK.getPbData().cVm());
                            }
                        }
                        ImageViewerConfig dP = aVar.dP(PbFragment.this.getPageContext().getPageActivity());
                        dP.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.kzT) {
                        TbRichText bv = PbFragment.this.bv(str, i);
                        if (bv != null && PbFragment.this.kEO >= 0 && PbFragment.this.kEO < bv.bxx().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bv.bxx().get(PbFragment.this.kEO));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.kzS.size()) {
                                    break;
                                } else if (!aVar2.kzS.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bv.getPostId() != 0 && (daI = PbFragment.this.kDG.daI()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = daI.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bv.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bv.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.kzK.cZj(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kzK.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.dUS.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).yQ(aVar2.forumName).yR(aVar2.forumId).yS(aVar2.threadId).hI(aVar2.dUQ).hK(true).yT(aVar2.lastId).hJ(PbFragment.this.kzK.cYU()).a(concurrentHashMap2).hL(false).hM(PbFragment.this.cYc()).yU(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.kzK != null) {
                                aVar3.yV(PbFragment.this.kzK.getFromForumId());
                                if (PbFragment.this.kzK.getPbData() != null) {
                                    aVar3.r(PbFragment.this.kzK.getPbData().cVm());
                                }
                            }
                            ImageViewerConfig dP2 = aVar3.dP(PbFragment.this.getPageContext().getPageActivity());
                            dP2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.kzS, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.dUS.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).yQ(aVar2.forumName).yR(aVar2.forumId).yS(aVar2.threadId).hI(aVar2.dUQ).hK(true).yT(aVar2.kzS.get(0)).hJ(PbFragment.this.kzK.cYU()).a(concurrentHashMap3).hL(false).hM(PbFragment.this.cYc()).yU(aVar2.postId).hN(false);
                    if (PbFragment.this.kzK != null) {
                        aVar4.yV(PbFragment.this.kzK.getFromForumId());
                        if (PbFragment.this.kzK.getPbData() != null) {
                            aVar4.r(PbFragment.this.kzK.getPbData().cVm());
                        }
                    }
                    ImageViewerConfig dP3 = aVar4.dP(PbFragment.this.getPageContext().getPageActivity());
                    dP3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.kDv = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean kEP = false;
    PostData iUM = null;
    private final b.InterfaceC0538b kEQ = new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iUM != null) {
                if (i == 0) {
                    PbFragment.this.iUM.fF(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.iUM = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.iUM);
                }
            }
        }
    };
    private final b.InterfaceC0538b kER = new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.kEc != null && !TextUtils.isEmpty(PbFragment.this.kEd)) {
                if (i == 0) {
                    if (PbFragment.this.kEe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.kEd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.kEd;
                        aVar.pkgId = PbFragment.this.kEe.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.kEe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.dTW == null) {
                            PbFragment.this.dTW = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.dTW.j(PbFragment.this.kEd, PbFragment.this.kEc.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.kEc = null;
                PbFragment.this.kEd = null;
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
                if (PbFragment.this.kDG != null) {
                    if (!PbFragment.this.kDG.cYu()) {
                        PbFragment.this.kDG.dbC();
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
                    if (PbFragment.this.cO(view)) {
                        if (view instanceof TbImageView) {
                            PbFragment.this.kEc = ((TbImageView) view).getBdImage();
                            PbFragment.this.kEd = ((TbImageView) view).getUrl();
                            if (PbFragment.this.kEc == null || TextUtils.isEmpty(PbFragment.this.kEd)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.kEe = null;
                            } else {
                                PbFragment.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else if (view instanceof GifView) {
                            if (((GifView) view).getBdImage() != null) {
                                PbFragment.this.kEc = ((GifView) view).getBdImage();
                                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                    PbFragment.this.kEd = ((GifView) view).getBdImage().getUrl();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    PbFragment.this.kEe = null;
                                } else {
                                    PbFragment.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                }
                            } else {
                                return true;
                            }
                        } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                            PbFragment.this.kEc = ((TbMemeImageView) view).getBdImage();
                            if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                                PbFragment.this.kEd = ((TbMemeImageView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.kEe = null;
                            } else {
                                PbFragment.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                            PbFragment.this.kDG.a(PbFragment.this.kER, PbFragment.this.kEc.isGif());
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
                PbFragment.this.iUM = (PostData) sparseArray2.get(R.id.tag_clip_board);
                if (PbFragment.this.iUM == null) {
                    return true;
                }
                if (PbFragment.this.iUM.dwK() != 1 || !PbFragment.this.cO(view)) {
                    if (PbFragment.this.kDE != null) {
                        if (!PbFragment.this.kDE.baA() || PbFragment.this.iUM.getId() == null || !PbFragment.this.iUM.getId().equals(PbFragment.this.kzK.beM())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        boolean z3 = PbFragment.this.cWE().getPbData() != null && PbFragment.this.cWE().getPbData().cVP();
                        if (PbFragment.this.iUM.dwK() != 1) {
                            if (PbFragment.this.kDL == null) {
                                PbFragment.this.kDL = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                PbFragment.this.kDL.a(PbFragment.this.kED);
                            }
                            ArrayList arrayList = new ArrayList();
                            if (view != null && sparseArray2 != null) {
                                boolean z4 = PbFragment.this.cO(view) && !z3;
                                boolean z5 = (!PbFragment.this.cO(view) || PbFragment.this.kEc == null || PbFragment.this.kEc.isGif()) ? false : true;
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
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.kDL));
                                }
                                if (z5) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.kDL));
                                }
                                if (!z4 && !z5) {
                                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kDL);
                                    SparseArray sparseArray3 = new SparseArray();
                                    sparseArray3.put(R.id.tag_clip_board, PbFragment.this.iUM);
                                    gVar3.mTextView.setTag(sparseArray3);
                                    arrayList.add(gVar3);
                                }
                                if (!z2 && !z3) {
                                    if (z) {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kDL);
                                    } else {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kDL);
                                    }
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(R.id.tag_clip_board, PbFragment.this.iUM);
                                    sparseArray4.put(R.id.tag_is_subpb, false);
                                    gVar2.mTextView.setTag(sparseArray4);
                                    arrayList.add(gVar2);
                                }
                                if (PbFragment.this.mIsLogin && !PbFragment.this.kBf) {
                                    if (!z8 && z7) {
                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kDL);
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
                                        if ((PbFragment.this.sV(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDL);
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
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDL);
                                            gVar6.mTextView.setTag(sparseArray6);
                                        } else {
                                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                                        }
                                        gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kDL);
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
                                            if (PbFragment.this.kzK.getPbData().cVB() == 1002 && !z6) {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDL);
                                            } else {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDL);
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
                                PbFragment.this.kDL.aT(arrayList);
                                PbFragment.this.kDK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kDL);
                                PbFragment.this.kDK.Nv();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dD("tid", PbFragment.this.kzK.kGR).dD("fid", PbFragment.this.kzK.getForumId()).dD("uid", PbFragment.this.kzK.getPbData().cVm().beE().getUserId()).dD("post_id", PbFragment.this.kzK.brT()).ai("obj_source", z2 ? 2 : 1));
                            }
                            return true;
                        }
                        if (!z3) {
                            PbFragment.this.kDG.a(PbFragment.this.kEQ, z, false);
                        }
                        return true;
                    }
                    return true;
                }
                PbFragment.this.kDG.a(PbFragment.this.kER, PbFragment.this.kEc.isGif());
                return true;
            }
            return true;
        }
    };
    private final NoNetworkView.a hQf = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bpH && z && !PbFragment.this.kzK.cYK()) {
                PbFragment.this.cXP();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener eVH = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.hXQ.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0674a hrF = new a.InterfaceC0674a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int ggZ = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            if (al(i2) && PbFragment.this.kDG != null && PbFragment.this.kDe != null) {
                PbFragment.this.kDe.oB(true);
                if (Math.abs(i2) > this.ggZ) {
                    PbFragment.this.kDe.hideFloatingView();
                }
                if (PbFragment.this.cXS()) {
                    PbFragment.this.kDG.daF();
                    PbFragment.this.kDG.daG();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            if (al(i2) && PbFragment.this.kDG != null && PbFragment.this.kDe != null) {
                PbFragment.this.kDG.dbq();
                PbFragment.this.kDe.oB(false);
                PbFragment.this.kDe.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void bZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void J(int i, int i2) {
        }

        private boolean al(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final q.a kCg = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.kDG.NK(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int kET = -1;
    private int kEU = -1;

    /* loaded from: classes16.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes16.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes16.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e cXp() {
        return this.kDS;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.cWi() != null) {
            String id = pVar.cWi().getId();
            ArrayList<PostData> cVo = this.kzK.getPbData().cVo();
            int i = 0;
            while (true) {
                if (i >= cVo.size()) {
                    z = true;
                    break;
                }
                PostData postData = cVo.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cWm = pVar.cWm();
                    postData.HO(pVar.getTotalCount());
                    if (postData.dwH() == null || cWm == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = cWm.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.beE() != null && (metaData = postData.getUserMap().get(next.beE().getUserId())) != null) {
                                next.a(metaData);
                                next.we(true);
                                next.a(getPageContext(), this.kzK.NB(metaData.getUserId()));
                            }
                        }
                        z = cWm.size() != postData.dwH().size();
                        if (postData.dwH() != null && postData.dwH().size() < 2) {
                            postData.dwH().clear();
                            postData.dwH().addAll(cWm);
                        }
                    }
                    if (postData.dwD() != null) {
                        postData.dwE();
                    }
                }
            }
            if (!this.kzK.getIsFromMark() && z) {
                this.kDG.s(this.kzK.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nt(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n cVE = this.kzK.getPbData().cVE();
            if (cVE != null && str.equals(cVE.getAdId())) {
                if (cVE.dwy() != null) {
                    cVE.dwy().legoCard = null;
                }
                this.kzK.getPbData().cVF();
            }
            com.baidu.tieba.tbadkCore.data.n cYQ = this.kzK.cYQ();
            if (cYQ != null && str.equals(cYQ.getAdId())) {
                this.kzK.cYR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kDK != null && this.kDK.isShowing()) {
                this.kDK.dismiss();
                this.kDK = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.kDK != null) {
                            PbFragment.this.kDK.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.kDG.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.kEa);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.kEa);
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
                kVar.aT(arrayList);
                this.kDK = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.kDK.Nv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(int i) {
        bw cVm;
        if (this.kzK != null && this.kzK.getPbData() != null && (cVm = this.kzK.getPbData().cVm()) != null) {
            if (i == 1) {
                PraiseData bep = cVm.bep();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bep == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cVm.a(praiseData);
                    } else {
                        cVm.bep().getUser().add(0, metaData);
                        cVm.bep().setNum(cVm.bep().getNum() + 1);
                        cVm.bep().setIsLike(i);
                    }
                }
                if (cVm.bep() != null) {
                    if (cVm.bep().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(cVm.bep().getNum());
                    }
                }
            } else if (cVm.bep() != null) {
                cVm.bep().setIsLike(i);
                cVm.bep().setNum(cVm.bep().getNum() - 1);
                ArrayList<MetaData> user = cVm.bep().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cVm.bep().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cVm.bep().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cVm.bep().getNum() + "";
                }
            }
            if (this.kzK.cYE()) {
                this.kDG.daI().notifyDataSetChanged();
            } else {
                this.kDG.t(this.kzK.getPbData());
            }
        }
    }

    public static PbFragment cXq() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.kDc = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kzK.aC(bundle);
        if (this.hSU != null) {
            this.hSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.kDS.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.kDj = System.currentTimeMillis();
        this.kDY = getPageContext();
        final Intent intent = this.kDc.getIntent();
        if (intent != null) {
            this.hvt = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.kDr = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.kDr)) {
                    this.kDr = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.kDr)) {
                this.kDf = true;
            }
            this.kET = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.kEU = intent.getIntExtra("key_manga_next_chapter", -1);
            this.kEV = intent.getStringExtra("key_manga_title");
            this.kDN = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.kDO = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.kDP = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cXS()) {
                this.kDc.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.kEg = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.kDA = new bf();
            this.kDA.C(intent);
            this.kEi = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.kEi == 0) {
                this.kEi = intent.getIntExtra("key_start_from", 0);
            }
            this.kEj = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.hvt = System.currentTimeMillis();
        }
        this.eRN = this.kDj - this.hvt;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.kDh = 0;
        aB(bundle);
        if (this.kzK.getPbData() != null) {
            this.kzK.getPbData().Nm(this.source);
        }
        cXt();
        if (intent != null && this.kDG != null) {
            this.kDG.kKI = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.kEb == null) {
                    this.kEb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.kDG.NM(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(this.kEb, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.kzK.getPbData() != null) {
                this.kzK.NE(stringExtra);
            }
        }
        this.hSU = new VoiceManager();
        this.hSU.onCreate(getPageContext());
        initData(bundle);
        this.kDR = new com.baidu.tbadk.editortools.pb.g();
        d(this.kDR);
        this.kDS = (com.baidu.tbadk.editortools.pb.e) this.kDR.ec(getActivity());
        this.kDS.a(this.kDc.getPageContext());
        this.kDS.a(this.eMH);
        this.kDS.a(this.eMA);
        this.kDS.a(this.kDc.getPageContext(), bundle);
        this.kDS.brw().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.kDS.brw().jj(true);
        sT(true);
        this.kDS.a(this.kzK.cYS(), this.kzK.cYC(), this.kzK.cZj());
        registerListener(this.kEo);
        if (!this.kzK.cYJ()) {
            this.kDS.BZ(this.kzK.cYC());
        }
        if (this.kzK.cZk()) {
            this.kDS.BX(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.kDG != null) {
            this.kDS.BX(this.kDG.dat());
        }
        registerListener(this.kEn);
        registerListener(this.kEp);
        registerListener(this.kEq);
        registerListener(this.hUA);
        registerListener(this.kEC);
        registerListener(this.kEm);
        this.kDQ = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.meC);
        this.kDQ.dwq();
        registerListener(this.kEr);
        registerListener(this.ekL);
        this.kzK.cZc();
        registerListener(this.kEJ);
        registerListener(this.hUI);
        registerListener(this.kEF);
        if (this.kDG != null && this.kDG.dbu() != null && this.kDG.dbv() != null) {
            this.kDe = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.kDG.dbu(), this.kDG.dbv(), this.kDG.daz());
            this.kDe.a(this.kEx);
        }
        if (this.kDd && this.kDG != null && this.kDG.dbv() != null) {
            this.kDG.dbv().setVisibility(8);
        }
        this.kDZ = new com.baidu.tbadk.core.view.c();
        this.kDZ.toastTime = 1000L;
        registerListener(this.kEB);
        registerListener(this.kEz);
        registerListener(this.kEA);
        registerListener(this.inn);
        registerListener(this.hUw);
        this.kEs.setSelfListener(true);
        this.kEs.setTag(this.kDc.getUniqueId());
        this.kEs.setPriority(-1);
        MessageManager.getInstance().registerListener(this.kEs);
        registerResponsedEventListener(TipEvent.class, this.hRY);
        this.kEa = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.kEa;
        userMuteAddAndDelCustomMessage.setTag(this.kEa);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.kEa;
        userMuteCheckCustomMessage.setTag(this.kEa);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kzK.cZh().a(this.kEy);
        this.jJI = new bb();
        if (this.kDS.brX() != null) {
            this.jJI.f(this.kDS.brX().getInputView());
        }
        this.kDS.a(this.eMB);
        this.imb = new ShareSuccessReplyToServerModel();
        a(this.kEk);
        this.jFD = new com.baidu.tbadk.core.util.am(getPageContext());
        this.jFD.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.ekC) {
                        PbFragment.this.kDS.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.ekD && PbFragment.this.kDG != null && PbFragment.this.kDG.dap() != null && PbFragment.this.kDG.dap().cXo() != null) {
                        PbFragment.this.kDG.dap().cXo().bsv();
                    } else if (i == com.baidu.tbadk.core.util.am.ekE) {
                        PbFragment.this.c(PbFragment.this.kDV);
                    }
                }
            }
        });
        this.kDD = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.kDD.x(getUniqueId());
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
        com.baidu.tbadk.core.business.a.bbY().dt("3", "");
        this.hkB = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.kDj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.kzK != null) {
            gVar.setForumName(this.kzK.cWv());
            if (this.kzK.getPbData() != null && this.kzK.getPbData().getForum() != null) {
                gVar.a(this.kzK.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.kzK);
        }
    }

    public String cXr() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cXs() {
        return this.kDe;
    }

    private void sT(boolean z) {
        this.kDS.jn(z);
        this.kDS.jo(z);
        this.kDS.jp(z);
    }

    private void cXt() {
        this.exb = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hSU != null) {
            this.hSU.onStart(getPageContext());
        }
    }

    public az cXu() {
        return this.kDG;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cWE() {
        return this.kzK;
    }

    public void Nu(String str) {
        if (this.kzK != null && !StringUtils.isNull(str) && this.kDG != null) {
            this.kDG.tH(true);
            this.kzK.Nu(str);
            this.kDp = true;
            this.kDG.dbf();
            this.kDG.dbp();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bpH = false;
        } else {
            this.bpH = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.kDh = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.kDh == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.hSU != null) {
            this.hSU.onPause(getPageContext());
        }
        if (this.kDG != null) {
            this.kDG.onPause();
        }
        if (!this.kzK.cYJ()) {
            this.kDS.BY(this.kzK.cYC());
        }
        if (this.kzK != null) {
            this.kzK.cZd();
        }
        com.baidu.tbadk.BdToken.c.aYs().aYC();
        MessageManager.getInstance().unRegisterListener(this.jgP);
        czD();
        MessageManager.getInstance().unRegisterListener(this.kEz);
        MessageManager.getInstance().unRegisterListener(this.kEA);
        MessageManager.getInstance().unRegisterListener(this.kEB);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cXv() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.kzK.getPbData(), this.kzK.cYE(), this.kzK.cZb());
        return (a2 == null || a2.beE() == null || a2.beE().getGodUserData() == null || a2.beE().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bpH = false;
        super.onResume();
        if (this.kDt) {
            this.kDt = false;
            cXY();
        }
        if (cXv()) {
            this.kDm = System.currentTimeMillis();
        } else {
            this.kDm = -1L;
        }
        if (this.kDG != null && this.kDG.getView() != null) {
            if (!this.jZg) {
                cXQ();
            } else {
                hideLoadingView(this.kDG.getView());
            }
            this.kDG.onResume();
        }
        if (this.kDh == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.kDG != null) {
            noNetworkView = this.kDG.dam();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.hSU != null) {
            this.hSU.onResume(getPageContext());
        }
        registerListener(this.jgP);
        this.kDM = false;
        cXX();
        registerListener(this.kEz);
        registerListener(this.kEA);
        registerListener(this.kEB);
        if (this.hTJ) {
            cXP();
            this.hTJ = false;
        }
        cYf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.kDG.tw(z);
        if (this.kDK != null) {
            this.kDK.dismiss();
        }
        if (z && this.kDM) {
            this.kDG.daN();
            this.kzK.th(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.kDm > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dD("obj_duration", (System.currentTimeMillis() - this.kDm) + ""));
            this.kDm = 0L;
        }
        if (cXu().dap() != null) {
            cXu().dap().onStop();
        }
        if (this.kDG.kKK != null && !this.kDG.kKK.dcn()) {
            this.kDG.kKK.releaseResources();
        }
        if (this.kzK != null && this.kzK.getPbData() != null && this.kzK.getPbData().getForum() != null && this.kzK.getPbData().cVm() != null) {
            com.baidu.tbadk.distribute.a.brj().b(getPageContext().getPageActivity(), "pb", this.kzK.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kzK.getPbData().cVm().getId(), 0L));
        }
        if (this.hSU != null) {
            this.hSU.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.kDB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dD("fid", this.kzK.getPbData().getForumId());
            aqVar.dD("tid", this.kzK.cYC());
            aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.kDk && this.kDG != null) {
            this.kDk = true;
            this.kDG.dbl();
            a(false, (PostData) null);
        }
        if (this.kzK != null) {
            this.kzK.cancelLoadData();
            this.kzK.destory();
            if (this.kzK.cZg() != null) {
                this.kzK.cZg().onDestroy();
            }
        }
        if (this.kDS != null) {
            this.kDS.onDestroy();
        }
        if (this.hkz != null) {
            this.hkz.cancelLoadData();
        }
        if (this.exb != null) {
            this.exb.dwd();
        }
        if (this.kDG != null) {
            this.kDG.onDestroy();
            if (this.kDG.kKK != null) {
                this.kDG.kKK.releaseResources();
            }
        }
        if (this.kDl != null) {
            this.kDl.bug();
        }
        if (this.kDe != null) {
            this.kDe.coj();
        }
        super.onDestroy();
        if (this.hSU != null) {
            this.hSU.onDestory(getPageContext());
        }
        if (this.kDG != null) {
            this.kDG.dbf();
        }
        MessageManager.getInstance().unRegisterListener(this.kEz);
        MessageManager.getInstance().unRegisterListener(this.kEA);
        MessageManager.getInstance().unRegisterListener(this.kEB);
        MessageManager.getInstance().unRegisterListener(this.kEa);
        MessageManager.getInstance().unRegisterListener(this.kEC);
        MessageManager.getInstance().unRegisterListener(this.hUI);
        MessageManager.getInstance().unRegisterListener(this.inn);
        MessageManager.getInstance().unRegisterListener(this.kEH);
        MessageManager.getInstance().unRegisterListener(this.kEs);
        this.kDY = null;
        this.kDZ = null;
        com.baidu.tieba.recapp.d.a.dnZ().doc();
        if (this.kEb != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kEb);
        }
        if (this.kDu != null) {
            this.kDu.cancelLoadData();
        }
        if (this.kDG != null && this.kDG.kKK != null) {
            this.kDG.kKK.dcq();
        }
        if (this.imb != null) {
            this.imb.cancelLoadData();
        }
        this.jJI.onDestroy();
        if (this.kzK != null && this.kzK.cZi() != null) {
            this.kzK.cZi().onDestroy();
        }
        if (this.jFD != null) {
            this.jFD.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g daI;
        ArrayList<PostData> cXa;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bms() && this.kDG != null && (daI = this.kDG.daI()) != null && (cXa = daI.cXa()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cXa.iterator();
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
                        bVar.hmC = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ecC == 1 && !TextUtils.isEmpty(id)) {
                    next.ecC = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.hmC = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.kzK == null || this.kzK.getPbData() == null || this.kzK.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.kzK.getPbData().getForum().getFirst_class();
                    str2 = this.kzK.getPbData().getForum().getSecond_class();
                    str = this.kzK.getPbData().getForum().getId();
                    str4 = this.kzK.cYC();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.bmv());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.kDG.onChangeSkinType(i);
            if (this.kDS != null && this.kDS.brw() != null) {
                this.kDS.brw().onChangeSkinType(i);
            }
            if (this.kDG.dam() != null) {
                this.kDG.dam().onChangeSkinType(getPageContext(), i);
            }
            this.jJI.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
            cms();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kDG = new az(this, this.hVH, this.eFj);
        this.hXQ = new com.baidu.tieba.f.b(getActivity());
        this.hXQ.a(kES);
        this.hXQ.a(this.hrF);
        this.kDG.setOnScrollListener(this.mOnScrollListener);
        this.kDG.d(this.kEN);
        this.kDG.setListPullRefreshListener(this.fqR);
        this.kDG.sF(com.baidu.tbadk.core.k.bbM().isShowImages());
        this.kDG.setOnImageClickListener(this.fcC);
        this.kDG.b(this.mOnLongClickListener);
        this.kDG.g(this.hQf);
        this.kDG.a(this.kEL);
        this.kDG.tw(this.mIsLogin);
        if (this.kDc.getIntent() != null) {
            this.kDG.tI(this.kDc.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.kDG.dao().setFromForumId(this.kzK.getFromForumId());
        this.kDG.setEditorTools(this.kDS.brw());
        this.kDS.BX(this.kDG.dat());
        this.kDG.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.kzK.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzK.getPbData().getForum().getId(), PbFragment.this.kzK.getPbData().getForum().getName(), PbFragment.this.kzK.getPbData().cVm().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.kDG.tJ(this.kzK.cYH());
        this.kDG.Ep(this.kzK.cZm());
        return this.kDG.getView();
    }

    public void cXw() {
        if (this.kDG != null && this.kzK != null) {
            if ((this.kzK.getPbData() != null || this.kzK.getPbData().cVL() != null) && checkUpIsLogin() && this.kDG.daI() != null && this.kDG.daI().cXf() != null) {
                this.kDG.daI().cXf().AF(this.kzK.cYC());
            }
        }
    }

    public void cXx() {
        TiebaStatic.log("c12181");
        if (this.kDG != null && this.kzK != null) {
            if ((this.kDG == null || this.kDG.das()) && this.kzK.getPbData() != null && this.kzK.getPbData().cVL() != null) {
                com.baidu.tieba.pb.data.o cVL = this.kzK.getPbData().cVL();
                if (checkUpIsLogin()) {
                    if ((!cVL.cWf() || cVL.bgf() != 2) && this.kDG.daI() != null && this.kDG.daI().cXf() != null) {
                        this.kDG.daI().cXf().AF(this.kzK.cYC());
                    }
                    if (System.currentTimeMillis() - this.kDo > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).uq(false);
                        this.kDo = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cM(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.ebn && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bbM().isShowImages()) {
                    return Nx(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.kzK == null || this.kzK.getPbData() == null) {
                        return true;
                    }
                    if (cXu().dap() != null) {
                        cXu().dap().cXk();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.kzK.getPbData().getForum());
                    pVar.setThreadData(this.kzK.getPbData().cVm());
                    pVar.g(postData);
                    cXu().dao().d(pVar);
                    cXu().dao().setPostId(postData.getId());
                    a(view, postData.beE().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.kDS != null) {
                        this.kDG.tC(this.kDS.bsf());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cXy() {
        if (this.kDi == null) {
            this.kDi = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.kDi.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.kzG = PbFragment.this.kzG.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzG);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kzK.cYC(), PbFragment.this.kzG, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.kzG = PbFragment.this.kzG.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzG);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kzK.cYC(), PbFragment.this.kzG, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.kzG = PbFragment.this.kzG.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzG);
                        bVar.dismiss();
                    }
                }
            }).ny(b.a.BOTTOM_TO_TOP).nz(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.kEI.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).deq(), "", 1);
    }

    private void aB(Bundle bundle) {
        this.kzK = this.kDc.cWE();
        if (this.kzK.cZf() != null) {
            this.kzK.cZf().a(this.kCg);
        }
        if (this.kzK.cZg() != null) {
            this.kzK.cZg().b(this.kEl);
        }
        if (StringUtils.isNull(this.kzK.cYC())) {
            this.kDc.finish();
        } else if ("from_tieba_kuang".equals(this.kDr) && this.kDr != null) {
            this.kzK.Ep(6);
        }
    }

    private void initData(Bundle bundle) {
        this.kDE = com.baidu.tbadk.baseEditMark.a.a(this.kDc);
        if (this.kDE != null) {
            this.kDE.a(this.kEK);
        }
        this.hkz = new ForumManageModel(this.kDc);
        this.hkz.setLoadDataCallBack(this.hkG);
        this.ekH = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kEw.setUniqueId(getUniqueId());
        this.kEw.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.kDG.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.kEa;
        userMuteCheckCustomMessage.setTag(this.kEa);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cXz() {
        if (this.kzK == null || this.kzK.getPbData() == null) {
            return false;
        }
        bw cVm = this.kzK.getPbData().cVm();
        this.kzK.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cVm);
    }

    public void cXA() {
        if (checkUpIsLogin() && this.kzK != null && this.kzK.getPbData() != null && this.kzK.getPbData().getForum() != null && !cXz()) {
            if (this.kzK.getPbData().cVP()) {
                this.kDG.cze();
                return;
            }
            if (this.hXq == null) {
                this.hXq = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hXq.yr(0);
                this.hXq.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ow(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ox(boolean z) {
                        if (z) {
                            if (PbFragment.this.kDS != null && PbFragment.this.kDS.brw() != null) {
                                PbFragment.this.kDS.brw().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.kDG.cze();
                        }
                    }
                });
            }
            this.hXq.C(this.kzK.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kzK.cYC(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cXB() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.kzK == null || (pbData = this.kzK.getPbData()) == null) {
            return null;
        }
        return pbData.cVA().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVm() != null) {
            if (fVar.cVm().getThreadType() == 0) {
                return 1;
            }
            if (fVar.cVm().getThreadType() == 54) {
                return 2;
            }
            if (fVar.cVm().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !cXz() && cXC()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kDw);
                this.kDx = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cXu().dap() != null && postData != null) {
                String str3 = "";
                if (postData.dwM() != null) {
                    str3 = postData.dwM().toString();
                }
                cXu().dap().Ns(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.beE().getName_show(), str3));
            }
            if (this.kzK.getPbData() != null && this.kzK.getPbData().cVP()) {
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.kDc.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cXu().getListView().smoothScrollBy((PbFragment.this.kDw[1] + PbFragment.this.kDx) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cXu().dap() != null) {
                            PbFragment.this.kDS.brw().setVisibility(8);
                            PbFragment.this.cXu().dap().g(str, str2, PbFragment.this.cXu().dat(), (PbFragment.this.kzK == null || PbFragment.this.kzK.getPbData() == null || PbFragment.this.kzK.getPbData().cVm() == null || !PbFragment.this.kzK.getPbData().cVm().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cXo = PbFragment.this.cXu().dap().cXo();
                            if (cXo != null && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                cXo.a(PbFragment.this.kzK.getPbData().getAnti());
                                cXo.setThreadData(PbFragment.this.kzK.getPbData().cVm());
                            }
                            if (PbFragment.this.jJI.dbH() == null && PbFragment.this.cXu().dap().cXo().bsD() != null) {
                                PbFragment.this.cXu().dap().cXo().bsD().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jJI != null && PbFragment.this.jJI.dbG() != null) {
                                            if (!PbFragment.this.jJI.dbG().dFG()) {
                                                PbFragment.this.jJI.tL(false);
                                            }
                                            PbFragment.this.jJI.dbG().xa(false);
                                        }
                                    }
                                });
                                PbFragment.this.jJI.g(PbFragment.this.cXu().dap().cXo().bsD().getInputView());
                                PbFragment.this.cXu().dap().cXo().a(PbFragment.this.kDX);
                            }
                        }
                        PbFragment.this.cXu().dbp();
                    }
                }, 0L);
                return;
            }
            if (this.kDU == null) {
                this.kDU = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kDU.yr(1);
                this.kDU.a(new AnonymousClass39(str, str2));
            }
            if (this.kzK != null && this.kzK.getPbData() != null && this.kzK.getPbData().getForum() != null) {
                this.kDU.C(this.kzK.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kzK.cYC(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String kFc;
        final /* synthetic */ String kFd;

        AnonymousClass39(String str, String str2) {
            this.kFc = str;
            this.kFd = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ow(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ox(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.cXu().getListView().smoothScrollBy((PbFragment.this.kDw[1] + PbFragment.this.kDx) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cXu().dap() != null) {
                            PbFragment.this.kDS.brw().setVisibility(8);
                            PbFragment.this.cXu().dap().g(AnonymousClass39.this.kFc, AnonymousClass39.this.kFd, PbFragment.this.cXu().dat(), (PbFragment.this.kzK == null || PbFragment.this.kzK.getPbData() == null || PbFragment.this.kzK.getPbData().cVm() == null || !PbFragment.this.kzK.getPbData().cVm().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cXo = PbFragment.this.cXu().dap().cXo();
                            if (cXo != null && PbFragment.this.kzK != null && PbFragment.this.kzK.getPbData() != null) {
                                cXo.a(PbFragment.this.kzK.getPbData().getAnti());
                                cXo.setThreadData(PbFragment.this.kzK.getPbData().cVm());
                            }
                            if (PbFragment.this.jJI.dbH() == null && PbFragment.this.cXu().dap().cXo().bsD() != null) {
                                PbFragment.this.cXu().dap().cXo().bsD().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jJI != null && PbFragment.this.jJI.dbG() != null) {
                                            if (!PbFragment.this.jJI.dbG().dFG()) {
                                                PbFragment.this.jJI.tL(false);
                                            }
                                            PbFragment.this.jJI.dbG().xa(false);
                                        }
                                    }
                                });
                                PbFragment.this.jJI.g(PbFragment.this.cXu().dap().cXo().bsD().getInputView());
                                PbFragment.this.cXu().dap().cXo().a(PbFragment.this.kDX);
                            }
                        }
                        PbFragment.this.cXu().dbp();
                    }
                }, 0L);
            }
        }
    }

    public boolean cXC() {
        if ((this.kzK.getPbData() != null && this.kzK.getPbData().cVP()) || this.jFD == null || this.kzK.getPbData() == null || this.kzK.getPbData().getAnti() == null) {
            return true;
        }
        return this.jFD.nP(this.kzK.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Ec(int i) {
        if (this.jFD == null || this.kzK.getPbData() == null || this.kzK.getPbData().getAnti() == null) {
            return true;
        }
        return this.jFD.aN(this.kzK.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.kzK != null && this.kzK.getPbData() != null && postData.dwK() != 1) {
            String cYC = this.kzK.cYC();
            String id = postData.getId();
            int i = 0;
            if (this.kzK.getPbData() != null) {
                i = this.kzK.getPbData().cVB();
            }
            PbActivity.a Ny = Ny(id);
            if (Ny != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cYC, id, "pb", true, null, false, null, i, postData.ddk(), this.kzK.getPbData().getAnti(), false, postData.beE() != null ? postData.beE().getIconInfo() : null).addBigImageData(Ny.kzS, Ny.dUS, Ny.dUQ, Ny.index);
                addBigImageData.setKeyPageStartFrom(this.kzK.cZm());
                addBigImageData.setFromFrsForumId(this.kzK.getFromForumId());
                addBigImageData.setKeyFromForumId(this.kzK.getForumId());
                addBigImageData.setBjhData(this.kzK.cYL());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cXD() {
        if (this.kzK.getPbData() == null || this.kzK.getPbData().cVm() == null) {
            return -1;
        }
        return this.kzK.getPbData().cVm().bfr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && cWE() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            cWE().ND(postWriteCallBackData.getPostId());
            this.kEf = this.kDG.dav();
            this.kzK.cU(this.kEf, this.kDG.daw());
        }
        this.kDG.dbf();
        this.jJI.dbE();
        if (this.kDS != null) {
            this.kDG.tC(this.kDS.bsf());
        }
        this.kDG.dan();
        this.kDG.tE(true);
        this.kzK.cYX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sU(boolean z) {
        if (this.kzK != null && this.kzK.kAH != null && this.kzK.kAH.cVm() != null) {
            bw cVm = this.kzK.kAH.cVm();
            cVm.mRecomAbTag = this.kzK.cZx();
            cVm.mRecomWeight = this.kzK.cZv();
            cVm.mRecomSource = this.kzK.cZw();
            cVm.mRecomExtra = this.kzK.cZy();
            if (cVm.getFid() == 0) {
                cVm.setFid(com.baidu.adp.lib.f.b.toLong(this.kzK.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cVm, "c13563");
            TbPageTag el = com.baidu.tbadk.pageInfo.c.el(getContext());
            if (el != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(el.locatePage)) {
                a2.dD("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dD("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (el != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(el.locatePage)) {
                a2.dD("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
    public void cXE() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.PX(this.kzK.getForumId()) && this.kzK.getPbData() != null && this.kzK.getPbData().getForum() != null) {
            if (this.kzK.getPbData().getForum().isLike() == 1) {
                this.kzK.cZi().fK(this.kzK.getForumId(), this.kzK.cYC());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sV(boolean z) {
        if (this.kzK == null || this.kzK.getPbData() == null) {
            return false;
        }
        return ((this.kzK.getPbData().cVB() != 0) || this.kzK.getPbData().cVm() == null || this.kzK.getPbData().cVm().beE() == null || TextUtils.equals(this.kzK.getPbData().cVm().beE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean sW(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ab abVar;
        if (this.kzK == null || this.kzK.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.kzK.getPbData();
        bw cVm = pbData.cVm();
        if (cVm != null) {
            if (cVm.bdm() || cVm.bdn()) {
                return false;
            }
            if (cVm.bgz() || cVm.bgA()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cVB() != 0) {
                return pbData.cVB() != 3;
            }
            List<bs> cVJ = pbData.cVJ();
            if (com.baidu.tbadk.core.util.y.getCount(cVJ) > 0) {
                for (bs bsVar : cVJ) {
                    if (bsVar != null && (abVar = bsVar.eay) != null && abVar.dYk && !abVar.dYl && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean sX(boolean z) {
        if (z || this.kzK == null || this.kzK.getPbData() == null) {
            return false;
        }
        return ((this.kzK.getPbData().getForum() != null && this.kzK.getPbData().getForum().isBlockBawuDelete) || this.kzK.getPbData().cVB() == 0 || this.kzK.getPbData().cVB() == 3) ? false : true;
    }

    public void cXF() {
        com.baidu.tieba.pb.data.f pbData;
        bw cVm;
        boolean z = true;
        if (this.kzK != null && this.kzK.getPbData() != null && (cVm = (pbData = this.kzK.getPbData()).cVm()) != null && cVm.beE() != null) {
            this.kDG.dan();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cVm.beE().getUserId());
            ak akVar = new ak();
            int cVB = this.kzK.getPbData().cVB();
            if (cVB == 1 || cVB == 3) {
                akVar.kIY = true;
                akVar.kIX = true;
                akVar.kJd = cVm.bez() == 1;
                akVar.kJc = cVm.beA() == 1;
            } else {
                akVar.kIY = false;
                akVar.kIX = false;
            }
            if (cVB == 1002 && !equals) {
                akVar.kJe = true;
            }
            akVar.kIV = sW(equals);
            akVar.kIZ = cXG();
            akVar.kIW = sX(equals);
            akVar.EK = this.kzK.cYE();
            akVar.kIS = true;
            akVar.kIR = sV(equals);
            akVar.kIQ = equals && this.kDG.daU();
            akVar.kJb = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.kJa = true;
            akVar.isHostOnly = this.kzK.getHostMode();
            akVar.kIU = true;
            if (cVm.beW() == null) {
                akVar.kIT = true;
            } else {
                akVar.kIT = false;
            }
            if (pbData.cVP()) {
                akVar.kIS = false;
                akVar.kIU = false;
                akVar.kIT = false;
                akVar.kIX = false;
                akVar.kIY = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cVP()) {
                z = false;
            }
            akVar.kJf = z;
            this.kDG.kKK.a(akVar);
        }
    }

    private boolean cXG() {
        if (this.kzK != null && this.kzK.cYE()) {
            return this.kzK.getPageData() == null || this.kzK.getPageData().bdv() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(View view) {
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
    public PbModel.a cXH() {
        return this.kEI;
    }

    public int cXI() {
        if (cXu() == null || cXu().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cXu().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).UM == com.baidu.tieba.pb.data.n.kyg) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cXJ() {
        if (cXu() == null || cXu().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cXu().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.mfc) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cXP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXK() {
        if (this.kzK != null && this.kzK.kAH != null && this.kzK.kAH.cVm() != null) {
            bw cVm = this.kzK.kAH.cVm();
            cVm.mRecomAbTag = this.kzK.cZx();
            cVm.mRecomWeight = this.kzK.cZv();
            cVm.mRecomSource = this.kzK.cZw();
            cVm.mRecomExtra = this.kzK.cZy();
            if (cVm.getFid() == 0) {
                cVm.setFid(com.baidu.adp.lib.f.b.toLong(this.kzK.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cVm, "c13562");
            TbPageTag el = com.baidu.tbadk.pageInfo.c.el(getContext());
            if (el != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(el.locatePage)) {
                a2.dD("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dD("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (el != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(el.locatePage)) {
                a2.dD("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
            aVar.zz(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.zA(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.ig(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dD("obj_id", metaData.getUserId()).ai("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dD("obj_id", metaData.getUserId()).ai("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.ekH.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.kzK.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bhg();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.kDG.daO();
        this.kzK.tj(z);
        if (this.kDE != null) {
            this.kDE.hB(z);
            if (markData != null) {
                this.kDE.a(markData);
            }
        }
        if (this.kzK.baA()) {
            cXN();
        } else {
            this.kDG.s(this.kzK.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean DT(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nv(String str) {
        if (this.kzK != null && this.kzK.getPbData() != null && this.kzK.getPbData().cVP()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kzK.cYC(), str);
            bw cVm = this.kzK.getPbData().cVm();
            if (cVm.bdm()) {
                format = format + "&channelid=33833";
            } else if (cVm.bgy()) {
                format = format + "&channelid=33842";
            } else if (cVm.bdn()) {
                format = format + "&channelid=33840";
            }
            Nw(format);
            return;
        }
        this.kDD.NW(str);
    }

    private void Nw(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.kzK.cYJ()) {
                    antiData.setBlock_forum_name(this.kzK.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.kzK.getPbData().getForum().getId());
                    antiData.setUser_name(this.kzK.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.kzK.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cXu() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.by(i, str)) {
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
            Ce(str);
        } else {
            this.kDG.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.mhO) ? bVar.mhO : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.zA(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.ig(true);
                aVar.b(getPageContext());
                aVar.bhg();
            } else {
                this.kDG.a(0, bVar.Qf, bVar.mhO, z);
            }
            if (bVar.Qf) {
                if (bVar.hzM == 1) {
                    ArrayList<PostData> cVo = this.kzK.getPbData().cVo();
                    int size = cVo.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cVo.get(i).getId())) {
                            i++;
                        } else {
                            cVo.remove(i);
                            break;
                        }
                    }
                    this.kzK.getPbData().cVm().ng(this.kzK.getPbData().cVm().bev() - 1);
                    this.kDG.s(this.kzK.getPbData());
                } else if (bVar.hzM == 0) {
                    cXL();
                } else if (bVar.hzM == 2) {
                    ArrayList<PostData> cVo2 = this.kzK.getPbData().cVo();
                    int size2 = cVo2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cVo2.get(i2).dwH().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cVo2.get(i2).dwH().get(i3).getId())) {
                                i3++;
                            } else {
                                cVo2.get(i2).dwH().remove(i3);
                                cVo2.get(i2).dwJ();
                                z2 = true;
                                break;
                            }
                        }
                        cVo2.get(i2).QN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.kDG.s(this.kzK.getPbData());
                    }
                    a(bVar, this.kDG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.kDG.a(this.hkz.getLoadDataMode(), gVar.Qf, gVar.mhO, false);
            if (gVar.Qf) {
                this.kDH = true;
                if (i == 2 || i == 3) {
                    this.kDI = true;
                    this.kDJ = false;
                } else if (i == 4 || i == 5) {
                    this.kDI = false;
                    this.kDJ = true;
                }
                if (i == 2) {
                    this.kzK.getPbData().cVm().nj(1);
                    this.kzK.setIsGood(1);
                } else if (i == 3) {
                    this.kzK.getPbData().cVm().nj(0);
                    this.kzK.setIsGood(0);
                } else if (i == 4) {
                    this.kzK.getPbData().cVm().ni(1);
                    this.kzK.Eh(1);
                } else if (i == 5) {
                    this.kzK.getPbData().cVm().ni(0);
                    this.kzK.Eh(0);
                }
                this.kDG.c(this.kzK.getPbData(), this.kzK.cYE());
            }
        }
    }

    private void cXL() {
        if (this.kzK.cYF() || this.kzK.cYH()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.kzK.cYC());
            PbActivity pbActivity = this.kDc;
            PbActivity pbActivity2 = this.kDc;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.kzK.cYC()));
        if (cXO()) {
            this.kDc.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWR() {
        this.kDc.cWR();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cVy;
        boolean z = false;
        if (this.kDG != null) {
            this.kDG.dbf();
        }
        if (this.kzK != null && this.kzK.getPbData() != null && !this.kzK.getPbData().cVP()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.kzK.getPbData().cVm().getId();
            if (this.kzK.isShareThread() && this.kzK.getPbData().cVm().edI != null) {
                historyMessage.threadName = this.kzK.getPbData().cVm().edI.showText;
            } else {
                historyMessage.threadName = this.kzK.getPbData().cVm().getTitle();
            }
            if (this.kzK.isShareThread() && !cWu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.kzK.getPbData().getForum().getName();
            }
            ArrayList<PostData> cVo = this.kzK.getPbData().cVo();
            int daQ = this.kDG != null ? this.kDG.daQ() : 0;
            if (cVo != null && daQ >= 0 && daQ < cVo.size()) {
                historyMessage.postID = cVo.get(daQ).getId();
            }
            historyMessage.isHostOnly = this.kzK.getHostMode();
            historyMessage.isSquence = this.kzK.cYE();
            historyMessage.isShareThread = this.kzK.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kDS != null) {
            this.kDS.onDestroy();
        }
        if (this.kDg && cXu() != null) {
            cXu().dbz();
        }
        if (this.kzK != null && (this.kzK.cYF() || this.kzK.cYH())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.kzK.cYC());
            if (this.kDH) {
                if (this.kDJ) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.kzK.ceJ());
                }
                if (this.kDI) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.kzK.getIsGood());
                }
            }
            if (this.kzK.getPbData() != null && System.currentTimeMillis() - this.kDj >= 40000 && (cVy = this.kzK.getPbData().cVy()) != null && !com.baidu.tbadk.core.util.y.isEmpty(cVy.getDataList())) {
                intent.putExtra("guess_like_data", cVy);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.kEg);
            }
            PbActivity pbActivity = this.kDc;
            PbActivity pbActivity2 = this.kDc;
            pbActivity.setResult(-1, intent);
        }
        if (cXO()) {
            if (this.kzK != null && this.kDG != null && this.kDG.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.kzK.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cVu() && !this.kDp && pbData.kwQ == null) {
                        as cZX = as.cZX();
                        com.baidu.tieba.pb.data.f cYM = this.kzK.cYM();
                        Parcelable onSaveInstanceState = this.kDG.getListView().onSaveInstanceState();
                        boolean cYE = this.kzK.cYE();
                        boolean hostMode = this.kzK.getHostMode();
                        if (this.kDG.daz() != null && this.kDG.daz().getVisibility() == 0) {
                            z = true;
                        }
                        cZX.a(cYM, onSaveInstanceState, cYE, hostMode, z);
                        if (this.kEf >= 0 || this.kzK.cZo() != null) {
                            as.cZX().q(this.kzK.cZo());
                            as.cZX().p(this.kzK.cZp());
                            as.cZX().Er(this.kzK.cZq());
                        }
                    }
                }
            } else {
                as.cZX().reset();
            }
            cWR();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.kDG == null || !this.kDG.Ex(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ed(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.kDc;
        if (i == 0) {
            this.kDG.dan();
            this.kDG.dap().cXk();
            this.kDG.tE(false);
        }
        this.kDG.dar();
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
                        this.kDS.resetData();
                        this.kDS.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kDS.b(writeData);
                        com.baidu.tbadk.editortools.m qe = this.kDS.brw().qe(6);
                        if (qe != null && qe.eKB != null) {
                            qe.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.kDc;
                        if (i == -1) {
                            this.kDS.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.kDG.dap() != null && this.kDG.dap().cXo() != null) {
                            com.baidu.tbadk.editortools.pb.h cXo = this.kDG.dap().cXo();
                            cXo.setThreadData(this.kzK.getPbData().cVm());
                            cXo.b(writeData);
                            cXo.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m qe2 = cXo.brw().qe(6);
                            if (qe2 != null && qe2.eKB != null) {
                                qe2.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.kDc;
                            if (i == -1) {
                                cXo.bsv();
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
        this.kDS.onActivityResult(i, i2, intent);
        if (this.kDu != null) {
            this.kDu.onActivityResult(i, i2, intent);
        }
        if (cXu().dap() != null) {
            cXu().dap().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cXM();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.cZX().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.kzK != null) {
                                PbFragment.this.kzK.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dmP().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.kzK != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    V(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (intent != null) {
                        aqVar.dD("tid", intent.getStringExtra("tid"));
                        aqVar.dD("pid", intent.getStringExtra("pid"));
                        aqVar.ai("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(aqVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dmP().F(getPageContext());
                        cXE();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.imb != null && shareItem != null && shareItem.linkUrl != null) {
                            this.imb.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void boZ() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60.1
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
                    this.kDG.sK(false);
                    if (this.kzK.getPbData() != null && this.kzK.getPbData().cVm() != null && this.kzK.getPbData().cVm().beZ() != null) {
                        this.kzK.getPbData().cVm().beZ().setStatus(2);
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
                        this.kDV = emotionImageData;
                        if (Ec(com.baidu.tbadk.core.util.am.ekE)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.kDv != null) {
                        this.kDG.cU(this.kDv);
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
            if (this.kDu == null) {
                this.kDu = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.kDc);
                this.kDu.b(this.eMA);
                this.kDu.c(this.eMH);
            }
            this.kDu.a(emotionImageData, cWE(), cWE().getPbData());
        }
    }

    private void V(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXM() {
        MarkData Eo;
        if (this.kDE != null) {
            if (this.kzK.getPbData() != null && this.kzK.getPbData().cVP()) {
                Eo = this.kzK.Eo(0);
            } else {
                Eo = this.kzK.Eo(this.kDG.daR());
            }
            if (Eo != null) {
                if (!Eo.isApp() || (Eo = this.kzK.Eo(this.kDG.daR() + 1)) != null) {
                    this.kDG.daM();
                    this.kDE.a(Eo);
                    if (!this.kDE.baA()) {
                        this.kDE.baC();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.kDE.baB();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXN() {
        com.baidu.tieba.pb.data.f pbData = this.kzK.getPbData();
        this.kzK.tj(true);
        if (this.kDE != null) {
            pbData.Nl(this.kDE.baz());
        }
        this.kDG.s(pbData);
    }

    private boolean cXO() {
        if (this.kzK == null) {
            return true;
        }
        if (this.kzK.getPbData() == null || !this.kzK.getPbData().cVP()) {
            if (this.kzK.baA()) {
                final MarkData cYW = this.kzK.cYW();
                if (cYW == null || !this.kzK.getIsFromMark()) {
                    return true;
                }
                final MarkData Eo = this.kzK.Eo(this.kDG.daQ());
                if (Eo == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cYW);
                    this.kDc.setResult(-1, intent);
                    return true;
                } else if (Eo.getPostId() == null || Eo.getPostId().equals(cYW.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cYW);
                    this.kDc.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.zA(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.kDE != null) {
                                if (PbFragment.this.kDE.baA()) {
                                    PbFragment.this.kDE.baB();
                                    PbFragment.this.kDE.hB(false);
                                }
                                PbFragment.this.kDE.a(Eo);
                                PbFragment.this.kDE.hB(true);
                                PbFragment.this.kDE.baC();
                            }
                            cYW.setPostId(Eo.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cYW);
                            PbFragment.this.kDc.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cWR();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cYW);
                            PbFragment.this.kDc.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cWR();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.kDG != null && PbFragment.this.kDG.getView() != null) {
                                PbFragment.this.kDG.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cYW);
                                PbFragment.this.kDc.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cWR();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bhg();
                    return false;
                }
            } else if (this.kzK.getPbData() == null || this.kzK.getPbData().cVo() == null || this.kzK.getPbData().cVo().size() <= 0 || !this.kzK.getIsFromMark()) {
                return true;
            } else {
                this.kDc.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.i
    public BdListView getListView() {
        if (this.kDG == null) {
            return null;
        }
        return this.kDG.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int byi() {
        if (this.kDG == null) {
            return 0;
        }
        return this.kDG.dbd();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> byj() {
        if (this.fcr == null) {
            this.fcr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: byv */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bbM().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
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
        return this.fcr;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> byk() {
        if (this.ffJ == null) {
            this.ffJ = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.ffJ;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> byl() {
        if (this.fcs == null) {
            this.fcs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cgz */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bbM().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
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
                    gifView.bsV();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fcs;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bym() {
        if (this.ffK == null) {
            this.ffK = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYm */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cP */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cQ */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bPf();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cR */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.ffK;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> byo() {
        this.ffM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cYn */
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
        return this.ffM;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bld() {
        if (this.evt == null) {
            this.evt = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.evt;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kDn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (be.NN(str) && this.kzK != null && this.kzK.cYC() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").ai("obj_param1", 1).dD("post_id", this.kzK.cYC()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.eJF = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            be.dbJ().f(getPageContext(), str);
        }
        this.kDn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ar(Context context, String str) {
        be.dbJ().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.kDn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void at(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void as(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.kDG != null && this.kDG.dbu() != null && rect.top <= this.kDG.dbu().getHeight()) {
            rect.top += this.kDG.dbu().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.kzK.getPbData();
            TbRichText bv = bv(str, i);
            if (bv != null && (tbRichTextData = bv.bxx().get(this.kEO)) != null) {
                aVar.postId = String.valueOf(bv.getPostId());
                aVar.kzS = new ArrayList<>();
                aVar.dUS = new ConcurrentHashMap<>();
                if (!tbRichTextData.bxD().bxR()) {
                    aVar.kzT = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.kzS.add(c2);
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
                    imageUrlData.mIsReserver = this.kzK.cYU();
                    imageUrlData.mIsSeeHost = this.kzK.getHostMode();
                    aVar.dUS.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cVm() != null) {
                            aVar.threadId = pbData.cVm().getId();
                        }
                        aVar.dUQ = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kzT = true;
                int size = pbData.cVo().size();
                this.kEP = false;
                aVar.index = -1;
                int a2 = pbData.cVv() != null ? a(pbData.cVv().dwM(), bv, i, i, aVar.kzS, aVar.dUS) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cVo().get(i2);
                    if (postData.getId() == null || pbData.cVv() == null || pbData.cVv().getId() == null || !postData.getId().equals(pbData.cVv().getId())) {
                        a2 = a(postData.dwM(), bv, a2, i, aVar.kzS, aVar.dUS);
                    }
                }
                if (aVar.kzS.size() > 0) {
                    aVar.lastId = aVar.kzS.get(aVar.kzS.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cVm() != null) {
                        aVar.threadId = pbData.cVm().getId();
                    }
                    aVar.dUQ = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxD() == null) {
            return null;
        }
        return tbRichTextData.bxD().bxW();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxD() == null) {
            return 0L;
        }
        return tbRichTextData.bxD().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxD() == null) {
            return false;
        }
        return tbRichTextData.bxD().bxX();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxD() == null) {
            return false;
        }
        return tbRichTextData.bxD().bxY();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bxD;
        String str;
        if (tbRichText == tbRichText2) {
            this.kEP = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bxx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bxx().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bxD().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bxD().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bxD().bxR()) {
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
                            if (tbRichTextData != null && (bxD = tbRichTextData.bxD()) != null) {
                                String bxT = bxD.bxT();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bxD.bxU();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bxT;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kzK.cYC(), -1L);
                                imageUrlData.mIsReserver = this.kzK.cYU();
                                imageUrlData.mIsSeeHost = this.kzK.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.kEP) {
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
        PostData cVv;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kzK.beM())) {
                z = true;
            }
            MarkData o = this.kzK.o(postData);
            if (this.kzK.getPbData() != null && this.kzK.getPbData().cVP() && (cVv = cVv()) != null) {
                o = this.kzK.o(cVv);
            }
            if (o != null) {
                this.kDG.daM();
                if (this.kDE != null) {
                    this.kDE.a(o);
                    if (!z) {
                        this.kDE.baC();
                    } else {
                        this.kDE.baB();
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

    public boolean cO(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bv(String str, int i) {
        TbRichText tbRichText = null;
        if (this.kzK == null || this.kzK.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.kzK.getPbData();
        if (pbData.cVv() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cVv());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cVo = pbData.cVo();
            c(pbData, cVo);
            return c(cVo, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eou == null) {
                this.eou = new com.baidu.tbadk.core.message.a();
            }
            if (this.eod == null) {
                this.eod = new com.baidu.tieba.tbadkCore.data.e();
                this.eod.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dWO = 5;
            cVar.dWU = 8;
            cVar.dWT = 2;
            if (cWE() != null) {
                cVar.dWS = cWE().cZm();
            }
            cVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dWV = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dWV = 1;
                        i = 0;
                    }
                }
                this.eou.a(agreeData, i, getUniqueId(), false);
                this.eou.a(agreeData, this.eod);
                if (this.kzK == null && this.kzK.getPbData() != null) {
                    this.eou.a(cYj(), cVar, agreeData, this.kzK.getPbData().cVm());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dWV = 1;
            }
            i = 0;
            this.eou.a(agreeData, i, getUniqueId(), false);
            this.eou.a(agreeData, this.eod);
            if (this.kzK == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cVA() != null && fVar.cVA().kyv != null && (list = fVar.cVA().kyv) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bxx;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dwM = arrayList.get(i2).dwM();
            if (dwM != null && (bxx = dwM.bxx()) != null) {
                int size = bxx.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bxx.get(i4) != null && bxx.get(i4).getType() == 8) {
                        i3++;
                        if (bxx.get(i4).bxD().bxT().equals(str) || bxx.get(i4).bxD().bxU().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bxx.get(i4).bxD().getWidth() * equipmentDensity;
                            int height = bxx.get(i4).bxD().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kEO = i4;
                            return dwM;
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
            this.kzG = str;
            if (this.kDi == null) {
                cXy();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.kDi.getItemView(1).setVisibility(8);
            } else {
                this.kDi.getItemView(1).setVisibility(0);
            }
            this.kDi.bhi();
            this.kDn = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hSU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXP() {
        hideNetRefreshView(this.kDG.getView());
        cXQ();
        if (this.kzK.cYP()) {
            this.kDG.daM();
        }
        this.kDG.daX();
    }

    private void cXQ() {
        showLoadingView(this.kDG.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.kDG.dbu().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cms() {
        if (this.hSU != null) {
            this.hSU.stopPlay();
        }
        if (this.kDc != null) {
            this.kDc.cms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ee(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cXD(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> byn() {
        if (this.ffL == null) {
            this.ffL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYo */
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
        return this.ffL;
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

    public void cmt() {
        if (this.kDc != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.kDc.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kDc.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData ckU() {
        if (this.kzK == null || this.kzK.getPbData() == null) {
            return null;
        }
        return this.kzK.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.kLY)).intValue();
            if (intValue == az.kLZ) {
                if (!this.hkz.dxv()) {
                    this.kDG.daJ();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.hkz.QP(com.baidu.tbadk.core.util.at.R(jSONArray));
                    }
                    this.hkz.a(this.kzK.getPbData().getForum().getId(), this.kzK.getPbData().getForum().getName(), this.kzK.getPbData().cVm().getId(), str, intValue3, intValue2, booleanValue, this.kzK.getPbData().cVm().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.kMa || intValue == az.kMc) {
                if (this.kzK.cZf() != null) {
                    this.kzK.cZf().DY(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.kMa) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.kEa);
        userMuteAddAndDelCustomMessage.setTag(this.kEa);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Nx(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0777a
    public void sY(boolean z) {
        this.kDM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cXR() {
        ArrayList<PostData> cVo;
        int count;
        if (this.kzK == null || this.kzK.getPbData() == null || this.kzK.getPbData().cVo() == null || (count = com.baidu.tbadk.core.util.y.getCount((cVo = this.kzK.getPbData().cVo()))) == 0) {
            return "";
        }
        if (this.kzK.cYU()) {
            Iterator<PostData> it = cVo.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dwK() == 1) {
                    return next.getId();
                }
            }
        }
        int daQ = this.kDG.daQ();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cVo, daQ);
        if (postData == null || postData.beE() == null) {
            return "";
        }
        if (this.kzK.NB(postData.beE().getUserId())) {
            return postData.getId();
        }
        for (int i = daQ - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(cVo, i);
            if (postData2 == null || postData2.beE() == null || postData2.beE().getUserId() == null) {
                break;
            } else if (this.kzK.NB(postData2.beE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = daQ + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(cVo, i2);
            if (postData3 == null || postData3.beE() == null || postData3.beE().getUserId() == null) {
                return "";
            }
            if (this.kzK.NB(postData3.beE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void au(Context context, String str) {
        this.kDn = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Ny(String str) {
        String str2;
        if (this.kzK.getPbData() == null || this.kzK.getPbData().cVo() == null || this.kzK.getPbData().cVo().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kzK.getPbData().cVo().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kzK.getPbData().cVo().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kzK.getPbData().cVo().get(i);
        if (postData.dwM() == null || postData.dwM().bxx() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dwM().bxx().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bxD() != null) {
                    str2 = next.bxD().bxT();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean cXS() {
        return (!this.kDd && this.kET == -1 && this.kEU == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null) {
            this.kEW = rVar;
            this.kDd = true;
            this.kDG.daA();
            this.kDG.NL(this.kEV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXT() {
        if (this.kEW != null) {
            if (this.kET == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kEW.getCartoonId(), this.kET, 0)));
                this.kDc.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXU() {
        if (this.kEW != null) {
            if (this.kEU == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kEW.getCartoonId(), this.kEU, 0)));
                this.kDc.finish();
            }
        }
    }

    public int cXV() {
        return this.kET;
    }

    public int cXW() {
        return this.kEU;
    }

    private void czD() {
        if (this.kzK != null && this.kzK.getPbData() != null && this.kzK.getPbData().cVm() != null && this.kzK.getPbData().cVm().bdk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cXX() {
        if (this.kzK != null && this.kzK.getPbData() != null && this.kzK.getPbData().cVm() != null && this.kzK.getPbData().cVm().bdk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cXY() {
        if (this.bpH) {
            this.kDt = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.kzK.getPbData() != null && this.kzK.getPbData().cVm() != null && this.kzK.getPbData().cVm().bek() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.kzK.getPbData().cVm().bek().getThreadId(), this.kzK.getPbData().cVm().bek().getTaskId(), this.kzK.getPbData().cVm().bek().getForumId(), this.kzK.getPbData().cVm().bek().getForumName(), this.kzK.getPbData().cVm().bez(), this.kzK.getPbData().cVm().beA())));
            this.kDf = true;
            this.kDc.finish();
        }
    }

    public String cXZ() {
        return this.kDr;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cYa() {
        return this.kDC;
    }

    public void sZ(boolean z) {
        this.kDs = z;
    }

    public boolean bcm() {
        if (this.kzK != null) {
            return this.kzK.cYF();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.zA(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.kDY).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.kDY.getPageActivity(), 2, true, 4);
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
        aVar.b(this.kDY).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kDY != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDY.getPageActivity());
            aVar.zA(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kDY).bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.kDG.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDY.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.zA(this.kDY.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zA(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.kDG.showLoadingDialog();
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
        aVar.b(this.kDY).bhg();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.NN(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.iwD) {
            this.iwD = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.kDG != null) {
                this.kDG.onConfigurationChanged(configuration);
            }
            if (this.kDK != null) {
                this.kDK.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cYc() {
        if (this.kzK != null) {
            return this.kzK.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.kzK.getPbData().cVA().kyv;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dwH().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dwH().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dwH().remove(i2);
                    list.get(i).dwJ();
                    z = true;
                    break;
                }
            }
            list.get(i).QN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.kzK.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.cWi().getId();
        List<PostData> list = this.kzK.getPbData().cVA().kyv;
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
                ArrayList<PostData> cWm = pVar.cWm();
                postData.HO(pVar.getTotalCount());
                if (postData.dwH() != null) {
                    postData.dwH().clear();
                    postData.dwH().addAll(cWm);
                }
            }
        }
        if (!this.kzK.getIsFromMark()) {
            this.kDG.s(this.kzK.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cWt() {
        return this.kDc.cWt();
    }

    public boolean cWu() {
        if (this.kzK == null) {
            return false;
        }
        return this.kzK.cWu();
    }

    public void ta(boolean z) {
        this.kDq = z;
    }

    public boolean cYd() {
        return this.kDq;
    }

    public void cYe() {
        if (this.kDG != null) {
            this.kDG.dan();
            cmt();
        }
    }

    public PostData cVv() {
        return this.kDG.b(this.kzK.kAH, this.kzK.cYE());
    }

    public void onBackPressed() {
        if (this.kEh != null && !this.kEh.isEmpty()) {
            int size = this.kEh.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.kEh.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.kEh == null) {
                this.kEh = new ArrayList();
            }
            if (!this.kEh.contains(aVar)) {
                this.kEh.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.kEh == null) {
                this.kEh = new ArrayList();
            }
            if (!this.kEh.contains(aVar)) {
                this.kEh.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.kEh != null) {
            this.kEh.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYf() {
        if (this.kzK != null && !com.baidu.tbadk.core.util.at.isEmpty(this.kzK.cYC())) {
            com.baidu.tbadk.BdToken.c.aYs().p(com.baidu.tbadk.BdToken.b.dNJ, com.baidu.adp.lib.f.b.toLong(this.kzK.cYC(), 0L));
        }
    }

    public bf cYg() {
        return this.kDA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nz(String str) {
        if (this.kzK != null && this.kzK.getPbData() != null && this.kzK.getPbData().cVm() != null && this.kzK.getPbData().cVm().bdo()) {
            bw cVm = this.kzK.getPbData().cVm();
            int i = 0;
            if (cVm.bdm()) {
                i = 1;
            } else if (cVm.bdn()) {
                i = 2;
            } else if (cVm.bgz()) {
                i = 3;
            } else if (cVm.bgA()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str);
            aqVar.ai("obj_source", 4);
            aqVar.ai("obj_type", i);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ef(final int i) {
        com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bbH */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.cXD(), i2, PbFragment.this.kzK);
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.86
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
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
    public PbFragment cYh() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cYi() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cYj() {
        return this.kDc;
    }
}
