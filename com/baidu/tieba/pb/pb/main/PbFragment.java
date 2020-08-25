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
    private bd dTS;
    private com.baidu.tieba.tbadkCore.data.e enZ;
    private com.baidu.tbadk.core.message.a eoq;
    private com.baidu.adp.lib.d.b<TbImageView> evp;
    private LikeModel ewX;
    private com.baidu.adp.lib.d.b<ImageView> fcm;
    private com.baidu.adp.lib.d.b<GifView> fcn;
    private com.baidu.adp.lib.d.b<TextView> ffF;
    private com.baidu.adp.lib.d.b<View> ffG;
    private com.baidu.adp.lib.d.b<LinearLayout> ffH;
    private com.baidu.adp.lib.d.b<RelativeLayout> ffI;
    private VoiceManager hSO;
    private com.baidu.tieba.f.b hXK;
    private com.baidu.tieba.frs.profession.permission.c hXk;
    private com.baidu.tieba.callfans.a hkx;
    public com.baidu.tbadk.core.util.am jFx;
    public bb jJC;
    private PbActivity kCV;
    private com.baidu.tieba.pb.pb.main.b.b kCX;
    private com.baidu.tbadk.core.dialog.i kDD;
    private com.baidu.tbadk.core.dialog.k kDE;
    private boolean kDF;
    private com.baidu.tieba.tbadkCore.data.f kDJ;
    private com.baidu.tbadk.editortools.pb.g kDK;
    private com.baidu.tbadk.editortools.pb.e kDL;
    private com.baidu.tieba.frs.profession.permission.c kDN;
    private EmotionImageData kDO;
    private com.baidu.adp.base.e kDR;
    private com.baidu.tbadk.core.view.c kDS;
    private BdUniqueId kDT;
    private Runnable kDU;
    private com.baidu.adp.widget.ImageView.a kDV;
    private String kDW;
    private TbRichTextMemeInfo kDX;
    private com.baidu.tieba.pb.pb.main.emotion.model.a kDn;
    private View kDo;
    int kDq;
    private bf kDt;
    private com.baidu.tieba.pb.pb.report.a kDw;
    private boolean kEF;
    private String kEO;
    private com.baidu.tbadk.core.data.r kEP;
    private List<a> kEa;
    public String kEc;
    private String kzz;
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
    private static final b.a kEL = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cp(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cWr();
            } else {
                com.baidu.tieba.pb.a.b.cWq();
            }
        }
    };
    private boolean kCW = false;
    private boolean kCY = false;
    private boolean bpE = false;
    private boolean jYZ = false;
    private boolean kCZ = true;
    private int kDa = 0;
    private com.baidu.tbadk.core.dialog.b kDb = null;
    private long hvn = -1;
    private long eRT = 0;
    private long kDc = 0;
    private long createTime = 0;
    private long eRJ = 0;
    private boolean kDd = false;
    private com.baidu.tbadk.n.b kDe = null;
    private long kDf = 0;
    private boolean kDg = false;
    private long kDh = 0;
    private int iwx = 1;
    private String eMt = null;
    private boolean kDi = false;
    private boolean isFullScreen = false;
    private boolean kDj = false;
    private String kDk = "";
    private boolean kDl = true;
    private boolean kDm = false;
    private String source = "";
    private int mSkinType = 3;
    int[] kDp = new int[2];
    private int kDr = -1;
    private int kDs = -1;
    public BdUniqueId kDu = BdUniqueId.gen();
    private boolean kAY = com.baidu.tbadk.a.d.baf();
    private PbInterviewStatusView.a kDv = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.kDz.tv(!PbFragment.this.kDl);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.kzD != null && PbFragment.this.kzD.baA()) {
                        PbFragment.this.cXM();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel kzD = null;
    private com.baidu.tbadk.baseEditMark.a kDx = null;
    private ForumManageModel hkv = null;
    private com.baidu.tbadk.coreExtra.model.a ekD = null;
    private com.baidu.tieba.pb.data.q kDy = null;
    private ShareSuccessReplyToServerModel ilV = null;
    private az kDz = null;
    private boolean kDA = false;
    private boolean kDB = false;
    private boolean kDC = false;
    private boolean ftg = false;
    private boolean kDG = false;
    private boolean kDH = false;
    private boolean kDI = false;
    private boolean kDM = false;
    public boolean kDP = false;
    private com.baidu.tbadk.editortools.pb.c eMw = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void brV() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b eMx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brU() {
            if (PbFragment.this.jJC == null || PbFragment.this.jJC.dbE() == null || !PbFragment.this.jJC.dbE().dFw()) {
                return !PbFragment.this.Ec(com.baidu.tbadk.core.util.am.eky);
            }
            PbFragment.this.showToast(PbFragment.this.jJC.dbE().dFy());
            if (PbFragment.this.kDL != null && (PbFragment.this.kDL.bsl() || PbFragment.this.kDL.bsm())) {
                PbFragment.this.kDL.a(false, PbFragment.this.jJC.dbH());
            }
            PbFragment.this.jJC.tI(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b kDQ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brU() {
            if (PbFragment.this.jJC == null || PbFragment.this.jJC.dbF() == null || !PbFragment.this.jJC.dbF().dFw()) {
                return !PbFragment.this.Ec(com.baidu.tbadk.core.util.am.ekz);
            }
            PbFragment.this.showToast(PbFragment.this.jJC.dbF().dFy());
            if (PbFragment.this.kDz != null && PbFragment.this.kDz.dao() != null && PbFragment.this.kDz.dao().cXn() != null && PbFragment.this.kDz.dao().cXn().bsm()) {
                PbFragment.this.kDz.dao().cXn().a(PbFragment.this.jJC.dbH());
            }
            PbFragment.this.jJC.tJ(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean hTD = false;
    private int kDY = 0;
    private int kDZ = -1;
    public int kEb = 0;
    private final a kEd = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.kDz != null && PbFragment.this.kDz.dao() != null) {
                v dao = PbFragment.this.kDz.dao();
                if (dao.cXl()) {
                    dao.cXk();
                    return true;
                }
            }
            if (PbFragment.this.kDz != null && PbFragment.this.kDz.dbm()) {
                PbFragment.this.kDz.dbn();
                return true;
            }
            return false;
        }
    };
    private final ai.a kEe = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bd(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.kDz.showToast(str);
            }
        }
    };
    private final CustomMessageListener kEf = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kzD != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.kDL != null) {
                    PbFragment.this.kDz.tA(PbFragment.this.kDL.bse());
                }
                PbFragment.this.kDz.daq();
                PbFragment.this.kDz.dbe();
            }
        }
    };
    CustomMessageListener hUu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbFragment.this.kzD.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbFragment.this.kDz != null && PbFragment.this.kzD != null) {
                    PbFragment.this.kDz.b(PbFragment.this.kzD.getPbData(), PbFragment.this.kzD.cYD(), PbFragment.this.kzD.cZa(), PbFragment.this.kDz.getSkinType());
                }
                if (PbFragment.this.kDz != null && PbFragment.this.kDz.daH() != null) {
                    PbFragment.this.kDz.daH().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener kEg = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.kDz != null) {
                    if (booleanValue) {
                        PbFragment.this.kDz.cGw();
                    } else {
                        PbFragment.this.kDz.cGv();
                    }
                }
            }
        }
    };
    private CustomMessageListener kEh = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.kDL != null) {
                    PbFragment.this.kDz.tA(PbFragment.this.kDL.bse());
                }
                PbFragment.this.kDz.tC(false);
            }
        }
    };
    private CustomMessageListener kEi = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener kEj = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kDz != null && PbFragment.this.kDz.daH() != null) {
                PbFragment.this.kDz.daH().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jgJ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener hUq = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bpE) {
                PbFragment.this.cYe();
            }
        }
    };
    private View.OnClickListener eNf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.eMt);
        }
    };
    private CustomMessageListener kEk = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ag)) {
                com.baidu.tbadk.core.data.ag agVar = (com.baidu.tbadk.core.data.ag) customResponsedMessage.getData();
                ax.a aVar = new ax.a();
                aVar.giftId = agVar.id;
                aVar.giftName = agVar.name;
                aVar.thumbnailUrl = agVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzD.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.kzD.cYR() != null && PbFragment.this.kzD.cYR().getUserIdLong() == agVar.toUserId) {
                        PbFragment.this.kDz.a(agVar.sendCount, PbFragment.this.kzD.getPbData(), PbFragment.this.kzD.cYD(), PbFragment.this.kzD.cZa());
                    }
                    if (pbData.cVn() != null && pbData.cVn().size() >= 1 && pbData.cVn().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cVn().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.kzD.cYB(), 0L);
                        if (j == agVar.postId && j2 == agVar.threadId) {
                            com.baidu.tbadk.core.data.ax dwN = pbData.cVn().get(0).dwN();
                            if (dwN == null) {
                                dwN = new com.baidu.tbadk.core.data.ax();
                            }
                            ArrayList<ax.a> bdw = dwN.bdw();
                            if (bdw == null) {
                                bdw = new ArrayList<>();
                            }
                            bdw.add(0, aVar);
                            dwN.setTotal(agVar.sendCount + dwN.getTotal());
                            dwN.D(bdw);
                            pbData.cVn().get(0).a(dwN);
                            PbFragment.this.kDz.daH().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener kEl = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                PbFragment.this.kzD.getPbData().cVF();
                PbFragment.this.kzD.cYW();
                if (PbFragment.this.kDz.daH() != null) {
                    PbFragment.this.kDz.s(PbFragment.this.kzD.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener inh = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Ns(str);
                PbFragment.this.kzD.cYW();
                if (!TextUtils.isEmpty(str) && PbFragment.this.kzD.getPbData().cVn() != null) {
                    ArrayList<PostData> cVn = PbFragment.this.kzD.getPbData().cVn();
                    Iterator<PostData> it = cVn.iterator();
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
                        cVn.remove(nVar);
                        if (PbFragment.this.kDz.daH() != null && PbFragment.this.kDz.daH().getDataList() != null) {
                            PbFragment.this.kDz.daH().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.kDz.getListView() != null && PbFragment.this.kDz.getListView().getData() != null) {
                            PbFragment.this.kDz.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.kDz.daH() != null) {
                            PbFragment.this.kDz.daH().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.kDz.daH() != null) {
                    PbFragment.this.kDz.s(PbFragment.this.kzD.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a kEm = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dbX()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a kEn = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void bd(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.kDz != null) {
                PbFragment.this.kDz.eC(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean kEo = false;
    private PraiseModel kEp = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void DL(String str) {
            PbFragment.this.kEo = false;
            if (PbFragment.this.kEp != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzD.getPbData();
                if (pbData.cVl().bep().getIsLike() == 1) {
                    PbFragment.this.yi(0);
                } else {
                    PbFragment.this.yi(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cVl()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.kEo = false;
            if (PbFragment.this.kEp != null && str != null) {
                if (AntiHelper.bz(i, str)) {
                    AntiHelper.bb(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a kEq = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void sZ(boolean z) {
            PbFragment.this.sX(z);
            if (PbFragment.this.kDz.dbs() != null && z) {
                PbFragment.this.kDz.tv(false);
            }
            PbFragment.this.kDz.tx(z);
        }
    };
    private CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().eCa != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().eCa, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cVu().beE() != null && PbFragment.this.cVu().beE().getGodUserData() != null) {
                            PbFragment.this.cVu().beE().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().beE() != null) {
                            PbFragment.this.kzD.getPbData().cVl().beE().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h hRS = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.kCV.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a kEr = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.kDz.bWq();
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
                    com.baidu.tieba.j.a.cvF();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c eFf = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cXw();
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
                        if (PbFragment.this.kDz.cXu() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dD("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cWs() != null && PbFragment.this.cWs().hCj != null) {
                                PbFragment.this.cWs().hCj.onClick(view);
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
                if (PbFragment.this.kDL != null) {
                    PbFragment.this.kDz.tA(PbFragment.this.kDL.bse());
                }
                PbFragment.this.kDz.daq();
                PbFragment.this.kDz.dbe();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener kEs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kDT) {
                PbFragment.this.kDz.bWq();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzD.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cVB().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.kDS.showSuccessToast(PbFragment.this.kDR.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.kDR.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Cd(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cYa();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.kDR.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.kDS.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kEt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kDT) {
                PbFragment.this.kDz.bWq();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.kDS.showSuccessToast(PbFragment.this.kDR.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.kDR.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.kDS.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kEu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kDT) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.kDz.bWq();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.mtn;
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
                    PbFragment.this.kDz.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener kEv = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kDz.dar() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cXw();
            }
        }
    };
    private CustomMessageListener hUC = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.hTD = true;
                }
            }
        }
    };
    public a.b kkl = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cms();
            com.baidu.tbadk.core.data.av pageData = PbFragment.this.kzD.getPageData();
            int pageNum = PbFragment.this.kDz.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bdp()) {
                PbFragment.this.kDz.dbe();
                PbFragment.this.cmr();
                PbFragment.this.kDz.daL();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.kzD.Ei(PbFragment.this.kDz.getPageNum());
                    if (PbFragment.this.kCX != null) {
                        PbFragment.this.kCX.showFloatingView();
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
    private k.c kEw = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.kDD != null) {
                PbFragment.this.kDD.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.kDV != null && !TextUtils.isEmpty(PbFragment.this.kDW)) {
                        if (PbFragment.this.kDX == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.kDW));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.kDW;
                            aVar.pkgId = PbFragment.this.kDX.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.kDX.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.kDV = null;
                        PbFragment.this.kDW = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.kDV != null && !TextUtils.isEmpty(PbFragment.this.kDW)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.dTS == null) {
                                PbFragment.this.dTS = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.dTS.j(PbFragment.this.kDW, PbFragment.this.kDV.getImageByte());
                            PbFragment.this.kDV = null;
                            PbFragment.this.kDW = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.iUG != null) {
                        PbFragment.this.iUG.fF(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.iUG = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").ai("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cN(view);
                        if (PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().beE() != null && PbFragment.this.kzD.getPbData().cVl().beE().getUserId() != null && PbFragment.this.kDx != null) {
                            int h = PbFragment.this.h(PbFragment.this.kzD.getPbData());
                            bw cVl = PbFragment.this.kzD.getPbData().cVl();
                            if (cVl.bdm()) {
                                i2 = 2;
                            } else if (cVl.bdn()) {
                                i2 = 3;
                            } else if (cVl.bgz()) {
                                i2 = 4;
                            } else {
                                i2 = cVl.bgA() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dD("tid", PbFragment.this.kzD.kGK).ai("obj_locate", 2).dD("obj_id", PbFragment.this.kzD.getPbData().cVl().beE().getUserId()).ai("obj_type", PbFragment.this.kDx.baA() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i2));
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
                        PbFragment.this.Nu((String) tag);
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
                        PbFragment.this.kDz.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.kDz.cT(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.kDz.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
    public SortSwitchButton.a kEx = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean xL(int i) {
            PbFragment.this.kDz.dbe();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.kzD == null || PbFragment.this.kzD.isLoading) {
                    return false;
                }
                PbFragment.this.cmr();
                PbFragment.this.kDz.daL();
                if (PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().kwH != null && PbFragment.this.kzD.getPbData().kwH.size() > i) {
                    int intValue = PbFragment.this.kzD.getPbData().kwH.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dD("tid", PbFragment.this.kzD.cYC()).dD("fid", PbFragment.this.kzD.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_type", Eg(intValue)));
                    if (PbFragment.this.kzD.En(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.kDz.tq(true);
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
    public final View.OnClickListener hVB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
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
                    if (view == PbFragment.this.kDz.dba()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.kzD.tf(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.kDz.daM();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZQ()) {
                        if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZR()) {
                            if (view == PbFragment.this.kDz.kKD.eUm) {
                                if (PbFragment.this.kDz.tz(PbFragment.this.kzD.cYI())) {
                                    PbFragment.this.cmr();
                                    return;
                                }
                                PbFragment.this.kCZ = false;
                                PbFragment.this.kCY = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.kCV, PbFragment.this.kDz.kKD.eUm);
                                PbFragment.this.kCV.finish();
                            } else if (view != PbFragment.this.kDz.daJ() && (PbFragment.this.kDz.kKD.dck() == null || (view != PbFragment.this.kDz.kKD.dck().cZP() && view != PbFragment.this.kDz.kKD.dck().cZN()))) {
                                if (view == PbFragment.this.kDz.dbi()) {
                                    if (PbFragment.this.kzD != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzD.getPbData().cVl().beD().getLink());
                                    }
                                } else if (view != PbFragment.this.kDz.kKD.kQR) {
                                    if (view == PbFragment.this.kDz.kKD.kQS) {
                                        if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                            ArrayList<PostData> cVn = PbFragment.this.kzD.getPbData().cVn();
                                            if ((cVn == null || cVn.size() <= 0) && PbFragment.this.kzD.cYD()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dD("tid", PbFragment.this.kzD.cYB()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", PbFragment.this.kzD.getForumId()));
                                            if (!PbFragment.this.kDz.dbx()) {
                                                PbFragment.this.kDz.daq();
                                            }
                                            PbFragment.this.cXE();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.kDz.sM(true);
                                            PbFragment.this.kDz.daq();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.kDz.cGw();
                                                PbFragment.this.cmr();
                                                PbFragment.this.kDz.daL();
                                                PbFragment.this.kzD.Nz(PbFragment.this.cXQ());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZM()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.kDz.kKD.dck() != null && view == PbFragment.this.kDz.kKD.dck().cZL()) {
                                                PbFragment.this.kDz.kKD.aRN();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.Ef(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZJ()) {
                                                    if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZT()) {
                                                        if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZK()) {
                                                            if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZU()) {
                                                                if (PbFragment.this.kDz.dbs() == view) {
                                                                    if (PbFragment.this.kDz.dbs().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.kzD.getPbData();
                                                                        if (pbData2 != null && pbData2.cVl() != null && pbData2.cVl().bek() != null) {
                                                                            String bea = pbData2.cVl().bek().bea();
                                                                            if (StringUtils.isNull(bea)) {
                                                                                bea = pbData2.cVl().bek().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dD("obj_id", bea));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.fR("c10725", null);
                                                                    }
                                                                    PbFragment.this.cXX();
                                                                } else if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZS()) {
                                                                    if (PbFragment.this.kDz.kKD.dck() != null && view == PbFragment.this.kDz.kKD.dck().cZO()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.kDz.b(PbFragment.this.kzD.getPbData(), PbFragment.this.kzD.cYD(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.kDz.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.kDz.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.kDz.kKD.aRN();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dD("tid", PbFragment.this.kzD.cYB());
                                                                            aqVar.dD("fid", PbFragment.this.kzD.getForumId());
                                                                            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.ai("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                                                                PbFragment.this.kDz.dbe();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dwR() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.mfI != null) {
                                                                                        com.baidu.tbadk.core.util.aq bjm = postData.mfI.bjm();
                                                                                        bjm.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bjm.ai("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bjm.ai("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bjm);
                                                                                    }
                                                                                    String cYB = PbFragment.this.kzD.cYB();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.kzD.getPbData() != null) {
                                                                                        i3 = PbFragment.this.kzD.getPbData().cVA();
                                                                                    }
                                                                                    PbFragment.this.cmr();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a Nx = PbFragment.this.Nx(id);
                                                                                        if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && Nx != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cYB, id, "pb", true, null, true, null, i3, postData.ddj(), PbFragment.this.kzD.getPbData().getAnti(), false, postData.beE().getIconInfo()).addBigImageData(Nx.kzL, Nx.dUO, Nx.dUM, Nx.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.kzD.cZl());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.kzD.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.kzD.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.kzD.cYK());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a Nx2 = PbFragment.this.Nx(id);
                                                                                        if (postData != null && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && Nx2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cYB, id, "pb", true, null, false, str2, i3, postData.ddj(), PbFragment.this.kzD.getPbData().getAnti(), false, postData.beE().getIconInfo()).addBigImageData(Nx2.kzL, Nx2.dUO, Nx2.dUM, Nx2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.kzD.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.kzD.cYK());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.kzD.cZl());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.kzD.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").ai("obj_locate", 3).dD("fid", PbFragment.this.kzD.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.kzD != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dD("tid", PbFragment.this.kzD.cYB());
                                                                            aqVar2.dD("fid", PbFragment.this.kzD.getForumId());
                                                                            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.ai("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.mfI != null) {
                                                                                        com.baidu.tbadk.core.util.aq bjm2 = postData3.mfI.bjm();
                                                                                        bjm2.delete("obj_locate");
                                                                                        bjm2.ai("obj_locate", 8);
                                                                                        TiebaStatic.log(bjm2);
                                                                                    }
                                                                                    if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                                                                        String cYB2 = PbFragment.this.kzD.cYB();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.kzD.getPbData() != null) {
                                                                                            i4 = PbFragment.this.kzD.getPbData().cVA();
                                                                                        }
                                                                                        PbActivity.a Nx3 = PbFragment.this.Nx(id2);
                                                                                        if (Nx3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cYB2, id2, "pb", true, null, false, null, i4, postData3.ddj(), PbFragment.this.kzD.getPbData().getAnti(), false, postData3.beE().getIconInfo()).addBigImageData(Nx3.kzL, Nx3.dUO, Nx3.dUM, Nx3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.kzD.cZl());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.kzD.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.kzD.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.kzD.cYK());
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
                                                                        if (PbFragment.this.kzD != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dD("tid", PbFragment.this.kzD.cYB());
                                                                                aqVar3.dD("fid", PbFragment.this.kzD.getForumId());
                                                                                aqVar3.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.ai("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.mfI != null) {
                                                                                        com.baidu.tbadk.core.util.aq bjm3 = postData4.mfI.bjm();
                                                                                        bjm3.delete("obj_locate");
                                                                                        bjm3.ai("obj_locate", 8);
                                                                                        TiebaStatic.log(bjm3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", PbFragment.this.kzD.cYC()).dD("fid", PbFragment.this.kzD.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData4.getId()).ai("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.cXt().dan() != null && postData4.beE() != null && postData4.dwF() != 1) {
                                                                                        if (PbFragment.this.cXt().dao() != null) {
                                                                                            PbFragment.this.cXt().dao().cXj();
                                                                                        }
                                                                                        if ((PbFragment.this.kAY || com.baidu.tbadk.a.d.aZV()) && postData4.dwC() != null && postData4.dwC().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.aZW()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.kzD.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.kzD.getPbData().cVl());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.cXt().dan().d(pVar);
                                                                                            PbFragment.this.cXt().dan().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.beE().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.kDL != null) {
                                                                                                PbFragment.this.kDz.tA(PbFragment.this.kDL.bse());
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
                                                                        if (view != PbFragment.this.kDz.cWN()) {
                                                                            if (view == PbFragment.this.kDz.kKD.dcl()) {
                                                                                PbFragment.this.kDz.daS();
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dD("tid", PbFragment.this.kzD.kGK));
                                                                                            }
                                                                                            if (PbFragment.this.kDE == null) {
                                                                                                PbFragment.this.kDE = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.kDE.a(PbFragment.this.kEw);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.cO(view);
                                                                                            if (!PbFragment.this.cO(view) || PbFragment.this.kDV == null || !PbFragment.this.kDV.isGif()) {
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
                                                                                                if (postData5.dwH() != null && postData5.dwH().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kDE);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.mTextView.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.iUG = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.kzD.getPbData().baA()) {
                                                                                                String baz = PbFragment.this.kzD.getPbData().baz();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(baz) && baz.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kDE);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kDE);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.iUG);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z6 && z5) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kDE);
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
                                                                                                            if (PbFragment.this.sT(z4) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDE);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDE);
                                                                                                                gVar2.mTextView.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kDE);
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
                                                                                                            if (PbFragment.this.kzD.getPbData().cVA() == 1002 && !z4) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDE);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDE);
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
                                                                                                    PbFragment.this.kDE.aT(arrayList);
                                                                                                    PbFragment.this.kDD = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kDE);
                                                                                                    PbFragment.this.kDD.Nv();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.iUG);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.kDE.aT(arrayList);
                                                                                            PbFragment.this.kDD = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kDE);
                                                                                            PbFragment.this.kDD.Nv();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.kzD.getPbData().cVl().getActUrl());
                                                                                        if (PbFragment.this.kzD.getPbData().cVl().bfr() != 1) {
                                                                                            if (PbFragment.this.kzD.getPbData().cVl().bfr() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dD("fid", PbFragment.this.kzD.getPbData().getForumId()).dD("tid", PbFragment.this.kzD.getPbData().getThreadId()).dD("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.kzD.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.kDz.setSelection(0);
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
                                                                                        PbFragment.this.kDz.daq();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.cXC() == 1 && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dD("fid", PbFragment.this.kzD.getPbData().getForumId()).dD("tid", PbFragment.this.kzD.getPbData().getThreadId()).dD("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.cXC() == 1 && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dD("fid", PbFragment.this.kzD.getPbData().getForumId()).dD("tid", PbFragment.this.kzD.getPbData().getThreadId()).dD("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.cXS();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.cXT();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVH() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.kzD.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dD("fid", pbData3.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.bju().b(PbFragment.this.getPageContext(), new String[]{pbData3.cVH().cVT()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVH() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.kzD.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dD("fid", pbData4.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.bju().b(PbFragment.this.getPageContext(), new String[]{pbData4.cVH().cVT()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.kDY >= 0) {
                                                                                        if (PbFragment.this.kzD != null) {
                                                                                            PbFragment.this.kzD.cZm();
                                                                                        }
                                                                                        if (PbFragment.this.kzD != null && PbFragment.this.kDz.daH() != null) {
                                                                                            PbFragment.this.kDz.daH().a(PbFragment.this.kzD.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.kDY = 0;
                                                                                        if (PbFragment.this.kzD != null) {
                                                                                            PbFragment.this.kDz.getListView().setSelection(PbFragment.this.kzD.cZp());
                                                                                            PbFragment.this.kzD.cU(0, 0);
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
                                                                                    if (PbFragment.this.kDz.getListView() != null && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.kDz.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.kDz.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean cVL = PbFragment.this.kzD.getPbData().cVL();
                                                                                        boolean z9 = PbFragment.this.kDz.dap() != null && PbFragment.this.kDz.dap().bNe();
                                                                                        boolean dbb = PbFragment.this.kDz.dbb();
                                                                                        boolean z10 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (cVL && PbFragment.this.kDz.dap() != null && PbFragment.this.kDz.dap().bGj() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.kDz.dap().dbU();
                                                                                            z10 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.kDz.dap().bGj().getHeight() - PbFragment.this.kDz.dap().dbU());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.Ny("c13568");
                                                                                        if ((PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().bev() <= 0) || (dbb && z10)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.cXz();
                                                                                                if (PbFragment.this.kzD.getPbData().cVl().beE() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", PbFragment.this.kzD.kGK).dD("fid", PbFragment.this.kzD.getPbData().getForumId()).ai("obj_locate", 2).dD("uid", PbFragment.this.kzD.getPbData().cVl().beE().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z11 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (cVL) {
                                                                                                if (PbFragment.this.kDz.kLN != null && PbFragment.this.kDz.kLN.kMS != null && PbFragment.this.kDz.kLN.kMS.getView() != null) {
                                                                                                    if (PbFragment.this.kDz.kLN.kMS.getView().getParent() == null) {
                                                                                                        z11 = firstVisiblePosition >= PbFragment.this.cXI();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.kDz.dap() != null && PbFragment.this.kDz.dap().bGj() != null) {
                                                                                                            i6 = PbFragment.this.kDz.dap().bGj().getBottom();
                                                                                                        }
                                                                                                        z11 = PbFragment.this.kDz.kLN.kMS.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.kDz.day() != null) {
                                                                                                z11 = PbFragment.this.kDz.day().getVisibility() == 0;
                                                                                                if (!z11 && PbFragment.this.kDz.kLN != null && PbFragment.this.kDz.kLN.kMS != null && PbFragment.this.kDz.kLN.kMS.getView() != null && PbFragment.this.kDz.kLN.kMS.getView().getParent() != null && PbFragment.this.kDz.kKD != null && PbFragment.this.kDz.kKD.mNavigationBar != null) {
                                                                                                    z11 = PbFragment.this.kDz.kLN.kMS.getView().getTop() - PbFragment.this.kDz.kKD.mNavigationBar.getBottom() < PbFragment.this.kDz.kLN.kMS.kKc.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z11 || dbb) {
                                                                                                PbFragment.this.kDr = firstVisiblePosition;
                                                                                                PbFragment.this.kDs = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.kDz.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.kDz.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.kDz.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.kDr > 0) {
                                                                                                if (PbFragment.this.kDz.getListView().getChildAt(PbFragment.this.kDr) != null) {
                                                                                                    PbFragment.this.kDz.getListView().smoothScrollToPosition(PbFragment.this.kDr, PbFragment.this.kDs, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.kDz.getListView().setSelectionFromTop(PbFragment.this.kDr, PbFragment.this.kDs + equipmentHeight);
                                                                                                    PbFragment.this.kDz.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int cXI = PbFragment.this.cXI();
                                                                                                if (PbFragment.this.cXH() != -1) {
                                                                                                    cXI--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (cXI < 0) {
                                                                                                    i = PbFragment.this.kDz.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.kDz.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = cXI;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z9) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!cVL || PbFragment.this.kDz.dap() == null) {
                                                                                                    if (PbFragment.this.kDz.kKD != null && PbFragment.this.kDz.kKD.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.kDz.kKD.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.kDz.dap().dbT();
                                                                                                }
                                                                                                if (PbFragment.this.kDz.kLN == null || PbFragment.this.kDz.kLN.kMS == null || PbFragment.this.kDz.kLN.kMS.getView() == null || PbFragment.this.kDz.kLN.kMS.getView().getParent() == null) {
                                                                                                    PbFragment.this.kDz.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.kDz.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z9) {
                                                                                                    PbFragment.this.kDz.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.kDz.getListView().smoothScrollBy(PbFragment.this.kDz.kLN.kMS.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().beE() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", PbFragment.this.kzD.kGK).dD("fid", PbFragment.this.kzD.getPbData().getForumId()).ai("obj_locate", 2).dD("uid", PbFragment.this.kzD.getPbData().cVl().beE().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.kzD.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.kzD.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.kzD.cWu()) || PbFragment.this.kzD.getAppealInfo() == null) {
                                                                                                PbFragment.this.kCV.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.kzD.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.kzD.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.kCV.finish();
                                                                                            return;
                                                                                        }
                                                                                        String cWu = PbFragment.this.kzD.cWu();
                                                                                        if (PbFragment.this.kzD.cYE() && cWu != null && cWu.equals(name)) {
                                                                                            PbFragment.this.kCV.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.kzD.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dD("tid", PbFragment.this.kzD.cYB());
                                                                                        aqVar4.dD("fid", PbFragment.this.kzD.getForumId());
                                                                                        aqVar4.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.kzD.getPbData().cVl() != null) {
                                                                                            aqVar4.dD("nid", PbFragment.this.kzD.getPbData().cVl().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar = (bw) view.getTag();
                                                                                        if (PbFragment.this.kzD.cZl() == 3 && PbFragment.this.cWt() && PbFragment.this.kzD.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.kzD.getPbData().cVI())) {
                                                                                            PbFragment.this.kCV.finish();
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
                                                                                    if (PbFragment.this.kzD != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dD("tid", PbFragment.this.kzD.cYB());
                                                                                        aqVar6.dD("fid", PbFragment.this.kzD.getForumId());
                                                                                        aqVar6.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.ai("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.kzD.getPbData();
                                                                                        if (PbFragment.this.kDy == null) {
                                                                                            PbFragment.this.kDy = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").u("forum_id", j2).bjn();
                                                                                        PbFragment.this.registerListener(PbFragment.this.kEA);
                                                                                        PbFragment.this.kDy.H(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dD("fid", PbFragment.this.kzD.getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_name", smartApp.name).u("obj_id", smartApp.swan_app_id.longValue()).dD("obj_source", "PB_card").dD("tid", PbFragment.this.kzD.cYB()).ai("obj_param1", smartApp.is_game.intValue()));
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
                                                                                        if (PbFragment.this.ewX != null) {
                                                                                            PbFragment.this.ewX.fQ(bwVar3.beI(), String.valueOf(bwVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dD("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 10).ai("obj_locate", 11).u("obj_id", bwVar3.getFid()).dD("tid", bwVar3.getId()).ai("thread_type", bwVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.kzD.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.kzD.cYB(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.kzD.getPbData().cVl().beZ())));
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
                                                                            if (PbFragment.this.kDE == null) {
                                                                                PbFragment.this.kDE = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.kDE.a(PbFragment.this.kEw);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z12 = PbFragment.this.cWD().getPbData() != null && PbFragment.this.cWD().getPbData().cVO();
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
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bgv().hasAgree && postData6.bgf() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.kDE);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.mTextView.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z14 && z13) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kDE);
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
                                                                                        if ((PbFragment.this.sT(z2) && TbadkCoreApplication.isLogin()) && !z12) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDE);
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
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDE);
                                                                                            gVar11.mTextView.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kDE);
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
                                                                                            if (PbFragment.this.kzD.getPbData().cVA() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDE);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDE);
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
                                                                                PbFragment.this.kDE.aT(arrayList2);
                                                                                PbFragment.this.kDD = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kDE);
                                                                                PbFragment.this.kDD.Nv();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.kDz.dbe();
                                                                    SparseArray<Object> b3 = PbFragment.this.kDz.b(PbFragment.this.kzD.getPbData(), PbFragment.this.kzD.cYD(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzD.getPbData().getForum().getId(), PbFragment.this.kzD.getPbData().getForum().getName(), PbFragment.this.kzD.getPbData().cVl().getId(), String.valueOf(PbFragment.this.kzD.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                PbFragment.this.kDz.kKD.dcj();
                                                            }
                                                        } else if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVl() != null) {
                                                            PbFragment.this.kDz.kKD.aRN();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.Nu(PbFragment.this.kzD.getPbData().cVl().beV());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.kDz.dbe();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.kzD.cYU()));
                                                                return;
                                                            }
                                                            PbFragment.this.cmr();
                                                            PbFragment.this.kDz.daL();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.kzD.getPbData().kwH == null || PbFragment.this.kzD.getPbData().kwH.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.kzD.getPbData().kwH.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.kzD.getPbData().kwH.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.kzD.getPbData().kwH.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.kzD.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.kzD.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.kzD.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.kzD.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").ai("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ai("obj_type", i10));
                                                                    if (PbFragment.this.kzD.getPbData().kwH != null && PbFragment.this.kzD.getPbData().kwH.size() > i9) {
                                                                        i9 = PbFragment.this.kzD.getPbData().kwH.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean En = PbFragment.this.kzD.En(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.kzD.cYU()));
                                                                    if (En) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.kDz.tq(true);
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
                                                    PbFragment.this.kDz.dbe();
                                                    if (PbFragment.this.cWD().getPbData().kwI != 2) {
                                                        if (PbFragment.this.kzD.getPageData() != null) {
                                                            PbFragment.this.kDz.a(PbFragment.this.kzD.getPageData(), PbFragment.this.kkl);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.kzD.getPbData()) != null) {
                                                bw cVl = pbData.cVl();
                                                if (cVl != null && cVl.beE() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", PbFragment.this.kzD.kGK).dD("fid", pbData.getForumId()).ai("obj_locate", 4).dD("uid", cVl.beE().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (cVl != null) {
                                                    if (cVl.bdm()) {
                                                        i9 = 2;
                                                    } else if (cVl.bdn()) {
                                                        i9 = 3;
                                                    } else if (cVl.bgz()) {
                                                        i9 = 4;
                                                    } else if (cVl.bgA()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar7.dD("tid", PbFragment.this.kzD.cYB());
                                                aqVar7.dD("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar7.dD("fid", PbFragment.this.kzD.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar7.ai("obj_locate", 5);
                                                } else {
                                                    aqVar7.ai("obj_locate", 6);
                                                }
                                                aqVar7.ai("obj_name", i9);
                                                aqVar7.ai("obj_type", 1);
                                                if (cVl != null) {
                                                    if (cVl.bdm()) {
                                                        aqVar7.ai("obj_type", 10);
                                                    } else if (cVl.bdn()) {
                                                        aqVar7.ai("obj_type", 9);
                                                    } else if (cVl.bgA()) {
                                                        aqVar7.ai("obj_type", 8);
                                                    } else if (cVl.bgz()) {
                                                        aqVar7.ai("obj_type", 7);
                                                    } else if (cVl.isShareThread) {
                                                        aqVar7.ai("obj_type", 6);
                                                    } else if (cVl.threadType == 0) {
                                                        aqVar7.ai("obj_type", 1);
                                                    } else if (cVl.threadType == 40) {
                                                        aqVar7.ai("obj_type", 2);
                                                    } else if (cVl.threadType == 49) {
                                                        aqVar7.ai("obj_type", 3);
                                                    } else if (cVl.threadType == 54) {
                                                        aqVar7.ai("obj_type", 4);
                                                    } else {
                                                        aqVar7.ai("obj_type", 5);
                                                    }
                                                    aqVar7.ai(IntentConfig.CARD_TYPE, cVl.bgD());
                                                    aqVar7.dD(IntentConfig.RECOM_SOURCE, cVl.mRecomSource);
                                                    aqVar7.dD("ab_tag", cVl.mRecomAbTag);
                                                    aqVar7.dD("weight", cVl.mRecomWeight);
                                                    aqVar7.dD("extra", cVl.mRecomExtra);
                                                    aqVar7.dD("nid", cVl.getNid());
                                                    if (cVl.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(cVl.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar7.dD("obj_param6", cVl.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar7.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.cYi() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.cYi(), aqVar7);
                                                }
                                                TiebaStatic.log(aqVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> cVn2 = PbFragment.this.kzD.getPbData().cVn();
                                                    if ((cVn2 != null && cVn2.size() > 0) || !PbFragment.this.kzD.cYD()) {
                                                        PbFragment.this.kDz.dbe();
                                                        PbFragment.this.cmr();
                                                        if (pbData.cVH() != null && !StringUtils.isNull(pbData.cVH().bcA(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dD("fid", PbFragment.this.kzD.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), cVl)) {
                                                            if (PbFragment.this.kDz != null) {
                                                                PbFragment.this.kDz.dbh();
                                                                PbFragment.this.kDz.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.kDz.showLoadingDialog();
                                                                PbFragment.this.kzD.cZg().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
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
                                            PbFragment.this.kDz.dbe();
                                            if (PbFragment.this.kDz.kKD.dck() != null && view == PbFragment.this.kDz.kKD.dck().cZM() && !PbFragment.this.kDz.dbx()) {
                                                PbFragment.this.kDz.daq();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cmr();
                                                PbFragment.this.kDz.daL();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    z3 = PbFragment.this.kzD.z(true, PbFragment.this.cXQ());
                                                } else {
                                                    z3 = view.getId() == R.id.reply_title ? PbFragment.this.kzD.z(false, PbFragment.this.cXQ()) : PbFragment.this.kzD.Nz(PbFragment.this.cXQ());
                                                }
                                                view.setTag(Boolean.valueOf(z3));
                                                if (z3) {
                                                    PbFragment.this.kDz.sM(true);
                                                    PbFragment.this.kDz.cGw();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.kDz.tq(true);
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
                                        PbFragment.this.kDz.dbe();
                                        if (PbFragment.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.kzD.Eo(PbFragment.this.kDz.daQ()) != null) {
                                            PbFragment.this.cXL();
                                            if (PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().beE() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dD("tid", PbFragment.this.kzD.kGK).dD("fid", PbFragment.this.kzD.getPbData().getForumId()).ai("obj_locate", 3).dD("uid", PbFragment.this.kzD.getPbData().cVl().beE().getUserId()));
                                            }
                                            if (PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().beE() != null && PbFragment.this.kzD.getPbData().cVl().beE().getUserId() != null && PbFragment.this.kDx != null) {
                                                int h = PbFragment.this.h(PbFragment.this.kzD.getPbData());
                                                bw cVl2 = PbFragment.this.kzD.getPbData().cVl();
                                                int i11 = 1;
                                                if (cVl2.bdm()) {
                                                    i11 = 2;
                                                } else if (cVl2.bdn()) {
                                                    i11 = 3;
                                                } else if (cVl2.bgz()) {
                                                    i11 = 4;
                                                } else if (cVl2.bgA()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dD("tid", PbFragment.this.kzD.kGK).ai("obj_locate", 1).dD("obj_id", PbFragment.this.kzD.getPbData().cVl().beE().getUserId()).ai("obj_type", PbFragment.this.kDx.baA() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i11));
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
                                    if (PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().bdk() && PbFragment.this.kzD.getPbData().cVl().beW() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.kzD.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.kzD.cWu()) || PbFragment.this.kzD.getAppealInfo() == null) {
                                            PbFragment.this.kCV.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.kzD.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.kzD.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.kCV.finish();
                                        return;
                                    }
                                    String cWu2 = PbFragment.this.kzD.cWu();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.kzD.cYE() && cWu2 != null && cWu2.equals(name2)) {
                                        PbFragment.this.kCV.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.kzD.getPbData() != null) {
                                    if ((PbFragment.this.kzD.getPbData().cVA() == 1 || PbFragment.this.kzD.getPbData().cVA() == 3) && !PbFragment.this.hkv.dxq()) {
                                        PbFragment.this.kDz.dbe();
                                        int i12 = 0;
                                        if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZN()) {
                                            if (PbFragment.this.kDz.kKD.dck() == null || view != PbFragment.this.kDz.kKD.dck().cZP()) {
                                                if (view == PbFragment.this.kDz.daJ()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.kzD.getPbData().cVl().beA() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.kzD.getPbData().cVl().bez() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.kzD.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.kzD.getPbData().cVl().getId();
                                        PbFragment.this.kDz.daI();
                                        PbFragment.this.hkv.b(id4, name3, id5, i12, PbFragment.this.kDz.daK());
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
                            PbFragment.this.kDz.kKD.dcj();
                            if (PbFragment.this.kzD != null) {
                                PbFragment.this.hkx.setThreadId(PbFragment.this.kzD.cYB());
                            }
                            int i13 = 1;
                            if (PbFragment.this.kzD == null || !PbFragment.this.kzD.isPrivacy()) {
                                PbFragment.this.hkx.cbt();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.cWD() != null && PbFragment.this.cWD().getPbData() != null && PbFragment.this.cWD().getPbData().getThreadId() != null && PbFragment.this.cWD().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.cWD() != null && PbFragment.this.cWD().getPbData() != null) {
                                    PbFragment.this.hkx.i(3, i13, PbFragment.this.cWD().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.cWD() != null && PbFragment.this.cWD().getPbData() != null) {
                                    PbFragment.this.hkx.i(3, 3, PbFragment.this.cWD().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.kDz.dbe();
                        PbFragment.this.cmr();
                        PbFragment.this.kDz.daL();
                        PbFragment.this.kDz.showLoadingDialog();
                        if (PbFragment.this.kDz.day() != null) {
                            PbFragment.this.kDz.day().setVisibility(8);
                        }
                        PbFragment.this.kzD.Ei(1);
                        if (PbFragment.this.kCX != null) {
                            PbFragment.this.kCX.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cXA = PbFragment.this.cXA();
                        if (!TextUtils.isEmpty(cXA)) {
                            com.baidu.tbadk.core.util.be.bju().b(PbFragment.this.getPageContext(), new String[]{cXA});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar8.dD("tid", PbFragment.this.kzD.cYB());
                aqVar8.dD("fid", PbFragment.this.kzD.getForumId());
                aqVar8.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar8.ai("obj_locate", 1);
                TiebaStatic.log(aqVar8);
                if (PbFragment.this.kDg) {
                    PbFragment.this.kDg = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.cXt().dan() != null && postData7.beE() != null && postData7.dwF() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cXt().dao() != null) {
                                PbFragment.this.cXt().dao().cXj();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.kzD.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.kzD.getPbData().cVl());
                            pVar2.g(postData7);
                            PbFragment.this.cXt().dan().d(pVar2);
                            PbFragment.this.cXt().dan().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.beE().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kzD.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.kDL != null) {
                                PbFragment.this.kDz.tA(PbFragment.this.kDL.bse());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener kEy = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kzD != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.kzD.kGK)) {
                PbFragment.this.f((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ag agVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kzD.getPbData() != null) {
                    aqVar.dD("fid", PbFragment.this.kzD.getPbData().getForumId());
                }
                aqVar.dD("tid", PbFragment.this.kzD.cYB());
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.cmr();
            PbFragment.this.kDz.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.kzD.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzD.getPbData();
                            if (pbData != null && pbData.cVl() != null && pbData.cVl().beE() != null && (userId = pbData.cVl().beE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.kzD.cYN()) {
                                PbFragment.this.kDz.daL();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.kzD.cYN()) {
                            PbFragment.this.kDz.daL();
                        }
                    } else if (floor != null) {
                        PbFragment.this.kDz.s(PbFragment.this.kzD.getPbData());
                    }
                    if (PbFragment.this.kzD.cYH()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dD("tid", PbFragment.this.kzD.cYB()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.sS(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.kDL.bsl() || PbFragment.this.kDL.bsm()) {
                    PbFragment.this.kDL.a(false, postWriteCallBackData);
                }
                PbFragment.this.jJC.g(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.jFx != null) {
                    PbFragment.this.jFx.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.zz(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zz(postWriteCallBackData.getErrorString());
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
    public NewWriteModel.d kEz = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ag agVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                    aqVar.dD("fid", PbFragment.this.kzD.getPbData().getForumId());
                }
                if (PbFragment.this.kzD != null) {
                    aqVar.dD("tid", PbFragment.this.kzD.cYB());
                }
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.jJC != null) {
                    PbFragment.this.jJC.dbC();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.jFx != null) {
                    PbFragment.this.jFx.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.zz(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zz(postWriteCallBackData.getErrorString());
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
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.jJC != null) {
                if (PbFragment.this.kDz != null && PbFragment.this.kDz.dao() != null && PbFragment.this.kDz.dao().cXn() != null && PbFragment.this.kDz.dao().cXn().bsm()) {
                    PbFragment.this.kDz.dao().cXn().a(postWriteCallBackData);
                }
                PbFragment.this.jJC.h(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a kEA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dbA;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.kCV.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.kDz != null && (dbA = PbFragment.this.kDz.dbA()) != null && PbFragment.this.kDz.getListView() != null) {
                            PbFragment.this.kDz.getListView().removeHeaderView(dbA);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a kEB = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qb;
            if (!z || fVar == null || fVar.cVy() != null || com.baidu.tbadk.core.util.y.getCount(fVar.cVn()) >= 1) {
                PbFragment.this.jYZ = true;
                PbFragment.this.kDz.daN();
                if (fVar == null || !fVar.cVt()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.kDz.getView());
                }
                PbFragment.this.kDz.cGv();
                if (PbFragment.this.isFullScreen || PbFragment.this.kDz.dbx()) {
                    PbFragment.this.kDz.dbo();
                } else if (!PbFragment.this.kDz.dbl()) {
                    PbFragment.this.kDz.tC(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.ftg = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.kDz.getView());
                    PbFragment.this.kDz.daW();
                }
                if (z && fVar != null) {
                    bw cVl = fVar.cVl();
                    if (cVl == null || !cVl.bdo()) {
                        PbFragment.this.d(PbFragment.this.kDK);
                    } else {
                        cYk();
                    }
                    PbFragment.this.kDz.dao().setPbData(fVar);
                    PbFragment.this.kDz.bLs();
                    if (cVl != null && cVl.bfP() != null) {
                        PbFragment.this.a(cVl.bfP());
                    }
                    if (PbFragment.this.kDL != null) {
                        PbFragment.this.kDz.tA(PbFragment.this.kDL.bse());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.cVn() != null && fVar.cVn().size() >= 1 && fVar.cVn().get(0) != null) {
                        PbFragment.this.kzD.NB(fVar.cVn().get(0).getId());
                    } else if (fVar.cVy() != null) {
                        PbFragment.this.kzD.NB(fVar.cVy().getId());
                    }
                    if (PbFragment.this.kDL != null) {
                        PbFragment.this.kDL.a(fVar.getAnti());
                        PbFragment.this.kDL.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.kDL.setThreadData(cVl);
                        PbFragment.this.kDL.a(PbFragment.this.kzD.cYR(), PbFragment.this.kzD.cYB(), PbFragment.this.kzD.cZi());
                        if (cVl != null) {
                            PbFragment.this.kDL.jo(cVl.bgb());
                        }
                    }
                    if (PbFragment.this.kDx != null) {
                        PbFragment.this.kDx.hA(fVar.baA());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.cVO()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.kDz.tB(PbFragment.this.mIsFromCDN);
                    PbFragment.this.kDz.a(fVar, i2, i3, PbFragment.this.kzD.cYD(), i4, PbFragment.this.kzD.getIsFromMark());
                    PbFragment.this.kDz.d(fVar, PbFragment.this.kzD.cYD());
                    PbFragment.this.kDz.ty(PbFragment.this.kzD.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.eMt = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.eMt) && PbFragment.this.kDL != null && PbFragment.this.kDL.brv() != null && (qb = PbFragment.this.kDL.brv().qb(6)) != null && !TextUtils.isEmpty(PbFragment.this.eMt)) {
                            ((View) qb).setOnClickListener(PbFragment.this.eNf);
                        }
                    }
                    if (PbFragment.this.kDG) {
                        PbFragment.this.kDG = false;
                        final int cXH = PbFragment.this.cXH();
                        if (!fVar.cVL()) {
                            PbFragment.this.kDz.Ev(cXH);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cXH, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.kDH) {
                        PbFragment.this.kDH = false;
                        final int cXH2 = PbFragment.this.cXH();
                        final boolean z2 = cXH2 != -1;
                        if (!z2) {
                            cXH2 = PbFragment.this.cXI();
                        }
                        if (PbFragment.this.kDz != null) {
                            if (!fVar.cVL()) {
                                PbFragment.this.kDz.Ev(cXH2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cXH2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.kDz.setSelectionFromTop(cXH2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.kDz.setSelectionFromTop(cXH2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.kDz.tD(true);
                                PbFragment.this.kDz.tC(false);
                            }
                        }
                    } else if (PbFragment.this.kDI) {
                        PbFragment.this.kDI = false;
                        PbFragment.this.kDz.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.kDz.daR();
                    }
                    PbFragment.this.kzD.a(fVar.getForum(), PbFragment.this.kEm);
                    PbFragment.this.kzD.a(PbFragment.this.kEn);
                    if (PbFragment.this.jFx != null && cVl != null && cVl.beE() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cVl.beE());
                        PbFragment.this.jFx.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.ftg && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.kzD.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.kzD.getAppealInfo().kwz)) {
                                    PbFragment.this.kDz.a(PbFragment.this.kzD.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.kDz.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.kDz.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.kDz.dbo();
                            PbFragment.this.kDz.daV();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.kzD.cYB());
                            jSONObject.put("fid", PbFragment.this.kzD.getForumId());
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
                        PbFragment.this.kDz.NH("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                            arrayList = PbFragment.this.kzD.getPbData().cVn();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dwF() != 1)) {
                            PbFragment.this.kDz.NH(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.cYb()) {
                                PbFragment.this.kDz.NI(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.kDz.NI(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.kDz.s(PbFragment.this.kzD.getPbData());
                        }
                    }
                    PbFragment.this.kDz.endLoadData();
                }
                if (fVar != null && fVar.kwO && PbFragment.this.eRT == 0) {
                    PbFragment.this.eRT = System.currentTimeMillis() - PbFragment.this.hvn;
                }
                if (!PbFragment.this.cWD().cYD() || PbFragment.this.cWD().getPbData().getPage().bdv() != 0 || PbFragment.this.cWD().cZd()) {
                    PbFragment.this.kDM = true;
                    return;
                }
                return;
            }
            PbFragment.this.kzD.Ei(1);
            if (PbFragment.this.kCX != null) {
                PbFragment.this.kCX.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cYk() {
            if (PbFragment.this.kzD != null) {
                if (PbFragment.this.kDL == null || !PbFragment.this.kDL.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.kDL = (com.baidu.tbadk.editortools.pb.e) dVar.ec(PbFragment.this.getContext());
                    PbFragment.this.kDL.a(PbFragment.this.kCV.getPageContext());
                    PbFragment.this.kDL.a(PbFragment.this.eMD);
                    PbFragment.this.kDL.a(PbFragment.this.eMw);
                    PbFragment.this.kDL.a(PbFragment.this.kCV.getPageContext(), PbFragment.this.kCV.getIntent() == null ? null : PbFragment.this.kCV.getIntent().getExtras());
                    PbFragment.this.kDL.brv().jh(true);
                    PbFragment.this.kDz.setEditorTools(PbFragment.this.kDL.brv());
                    if (!PbFragment.this.kzD.cYI()) {
                        PbFragment.this.kDL.BY(PbFragment.this.kzD.cYB());
                    }
                    if (PbFragment.this.kzD.cZj()) {
                        PbFragment.this.kDL.BW(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.kDz != null) {
                        PbFragment.this.kDL.BW(PbFragment.this.kDz.das());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.kDz.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.bun().buo()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.hvn : j;
                if (PbFragment.this.eRT == 0) {
                    PbFragment.this.eRT = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.eRJ, PbFragment.this.createTime, PbFragment.this.eRT, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.eRJ = 0L;
                if (iVar != null) {
                    iVar.buk();
                }
                if (z2) {
                    iVar.eSc = currentTimeMillis;
                    iVar.jA(true);
                }
                if (!z2 && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVl() != null) {
                    int threadType = PbFragment.this.kzD.getPbData().cVl().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.kDk, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.kDk, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.eSe = currentTimeMillis;
                                iVar2.qA(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.eSe = currentTimeMillis;
                        dVar.qA(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener kEC = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cXD();
            }
        }
    };
    private final a.InterfaceC0535a kED = new a.InterfaceC0535a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0535a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.kDz.daN();
            if (z) {
                if (PbFragment.this.kDx != null) {
                    PbFragment.this.kDx.hA(z2);
                }
                PbFragment.this.kzD.th(z2);
                if (PbFragment.this.kzD.baA()) {
                    PbFragment.this.cXM();
                } else {
                    PbFragment.this.kDz.s(PbFragment.this.kzD.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.kDx != null) {
                        if (PbFragment.this.kDx.baD() != null && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.kzD.getPbData().cVl() != null && PbFragment.this.kzD.getPbData().cVl().beE() != null) {
                            MarkData baD = PbFragment.this.kDx.baD();
                            MetaData beE = PbFragment.this.kzD.getPbData().cVl().beE();
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
                    PbFragment.this.cXJ();
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
                if (PbFragment.this.kDz != null) {
                    PbFragment.this.kDz.dbe();
                    if (PbFragment.this.kDL != null && !PbFragment.this.kDz.dar()) {
                        PbFragment.this.kDz.tA(PbFragment.this.kDL.bse());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.kDz.daq();
                    }
                }
                if (!PbFragment.this.kDd) {
                    PbFragment.this.kDd = true;
                    if (PbFragment.this.kDz != null) {
                        PbFragment.this.kDz.dbk();
                    }
                }
            }
            if (PbFragment.this.kDz != null) {
                PbFragment.this.kDz.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.kCX != null) {
                PbFragment.this.kCX.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.kDe == null) {
                PbFragment.this.kDe = new com.baidu.tbadk.n.b();
                PbFragment.this.kDe.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.kDe.bue();
            } else {
                PbFragment.this.kDe.bud();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dvE().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cVn;
            if (PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null && PbFragment.this.kDz != null && PbFragment.this.kDz.daH() != null) {
                PbFragment.this.kDz.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.kCX != null) {
                    PbFragment.this.kCX.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.kzD.cYZ() && (cVn = PbFragment.this.kzD.getPbData().cVn()) != null && !cVn.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.kDz.daH().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.kzD.getPbData();
                    if (pbData != null) {
                        if (pbData.cVo() != null && pbData.cVo().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cVp() != null && pbData.cVp().hasData()) {
                            headerCount--;
                        }
                        int size = cVn.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d hkC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.hkv.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.kzD.cYW();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.kSN != 1002 || bVar.ghr) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.kDz.a(1, dVar.Qf, dVar.mhz, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.hkv.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.kDz.a(PbFragment.this.hkv.getLoadDataMode(), gVar.Qf, gVar.mhz, false);
                            PbFragment.this.kDz.aX(gVar.mhC);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.kDz.a(PbFragment.this.hkv.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c kEE = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c fqN = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cXR()) {
                PbFragment.this.kCV.finish();
            }
            if (!PbFragment.this.kzD.tg(true)) {
                PbFragment.this.kDz.daO();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e kEG = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.kEF && PbFragment.this.cXR()) {
                PbFragment.this.cXT();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.kzD.tf(false)) {
                    PbFragment.this.kDz.daM();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.kzD.getPbData() != null) {
                    PbFragment.this.kDz.dbj();
                }
                PbFragment.this.kEF = true;
            }
        }
    };
    private int kEH = 0;
    private final TbRichTextView.i fcy = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g daH;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.kDz.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dD("tid", PbFragment.this.kzD.cYB());
                aqVar.dD("fid", PbFragment.this.kzD.getForumId());
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.ai("obj_locate", 3);
                aqVar.ai("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.kzD.kAA.cVO()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bxx() != null) {
                            ArrayList<TbRichTextImageInfo> bxx = tbRichTextView.getRichText().bxx();
                            int i4 = 0;
                            while (i4 < bxx.size()) {
                                if (bxx.get(i4) != null) {
                                    arrayList.add(bxx.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bxx.get(i4).getSrc()) || str.equals(bxx.get(i4).bxS()) || str.equals(bxx.get(i4).bxP()) || str.equals(bxx.get(i4).bxR()) || str.equals(bxx.get(i4).bxV()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bxx.get(i4).getSrc();
                                    imageUrlData.originalUrl = bxx.get(i4).getSrc();
                                    imageUrlData.isLongPic = bxx.get(i4).bxX();
                                    concurrentHashMap.put(bxx.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).mM(i3).hH(false).hI(PbFragment.this.kzD.cYT()).a(concurrentHashMap).hJ(true).hK(false).hL(PbFragment.this.cYb()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.kzD != null) {
                            aVar.yU(PbFragment.this.kzD.getFromForumId());
                            if (PbFragment.this.kzD.getPbData() != null) {
                                aVar.r(PbFragment.this.kzD.getPbData().cVl());
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
                    if (aVar2.kzM) {
                        TbRichText bv = PbFragment.this.bv(str, i);
                        if (bv != null && PbFragment.this.kEH >= 0 && PbFragment.this.kEH < bv.bxw().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bv.bxw().get(PbFragment.this.kEH));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.kzL.size()) {
                                    break;
                                } else if (!aVar2.kzL.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bv.getPostId() != 0 && (daH = PbFragment.this.kDz.daH()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = daH.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bv.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bv.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.kzD.cZi(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kzD.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.dUO.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).yP(aVar2.forumName).yQ(aVar2.forumId).yR(aVar2.threadId).hH(aVar2.dUM).hJ(true).yS(aVar2.lastId).hI(PbFragment.this.kzD.cYT()).a(concurrentHashMap2).hK(false).hL(PbFragment.this.cYb()).yT(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.kzD != null) {
                                aVar3.yU(PbFragment.this.kzD.getFromForumId());
                                if (PbFragment.this.kzD.getPbData() != null) {
                                    aVar3.r(PbFragment.this.kzD.getPbData().cVl());
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
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.kzL, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.dUO.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).yP(aVar2.forumName).yQ(aVar2.forumId).yR(aVar2.threadId).hH(aVar2.dUM).hJ(true).yS(aVar2.kzL.get(0)).hI(PbFragment.this.kzD.cYT()).a(concurrentHashMap3).hK(false).hL(PbFragment.this.cYb()).yT(aVar2.postId).hM(false);
                    if (PbFragment.this.kzD != null) {
                        aVar4.yU(PbFragment.this.kzD.getFromForumId());
                        if (PbFragment.this.kzD.getPbData() != null) {
                            aVar4.r(PbFragment.this.kzD.getPbData().cVl());
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
                PbFragment.this.kDo = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean kEI = false;
    PostData iUG = null;
    private final b.InterfaceC0538b kEJ = new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iUG != null) {
                if (i == 0) {
                    PbFragment.this.iUG.fF(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.iUG = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.iUG);
                }
            }
        }
    };
    private final b.InterfaceC0538b kEK = new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.kDV != null && !TextUtils.isEmpty(PbFragment.this.kDW)) {
                if (i == 0) {
                    if (PbFragment.this.kDX == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.kDW));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.kDW;
                        aVar.pkgId = PbFragment.this.kDX.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.kDX.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.dTS == null) {
                            PbFragment.this.dTS = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.dTS.j(PbFragment.this.kDW, PbFragment.this.kDV.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.kDV = null;
                PbFragment.this.kDW = null;
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
                if (PbFragment.this.kDz != null) {
                    if (!PbFragment.this.kDz.cYt()) {
                        PbFragment.this.kDz.dbB();
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
                            PbFragment.this.kDV = ((TbImageView) view).getBdImage();
                            PbFragment.this.kDW = ((TbImageView) view).getUrl();
                            if (PbFragment.this.kDV == null || TextUtils.isEmpty(PbFragment.this.kDW)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.kDX = null;
                            } else {
                                PbFragment.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else if (view instanceof GifView) {
                            if (((GifView) view).getBdImage() != null) {
                                PbFragment.this.kDV = ((GifView) view).getBdImage();
                                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                    PbFragment.this.kDW = ((GifView) view).getBdImage().getUrl();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    PbFragment.this.kDX = null;
                                } else {
                                    PbFragment.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                }
                            } else {
                                return true;
                            }
                        } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                            PbFragment.this.kDV = ((TbMemeImageView) view).getBdImage();
                            if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                                PbFragment.this.kDW = ((TbMemeImageView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.kDX = null;
                            } else {
                                PbFragment.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                            PbFragment.this.kDz.a(PbFragment.this.kEK, PbFragment.this.kDV.isGif());
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
                PbFragment.this.iUG = (PostData) sparseArray2.get(R.id.tag_clip_board);
                if (PbFragment.this.iUG == null) {
                    return true;
                }
                if (PbFragment.this.iUG.dwF() != 1 || !PbFragment.this.cO(view)) {
                    if (PbFragment.this.kDx != null) {
                        if (!PbFragment.this.kDx.baA() || PbFragment.this.iUG.getId() == null || !PbFragment.this.iUG.getId().equals(PbFragment.this.kzD.beM())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        boolean z3 = PbFragment.this.cWD().getPbData() != null && PbFragment.this.cWD().getPbData().cVO();
                        if (PbFragment.this.iUG.dwF() != 1) {
                            if (PbFragment.this.kDE == null) {
                                PbFragment.this.kDE = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                PbFragment.this.kDE.a(PbFragment.this.kEw);
                            }
                            ArrayList arrayList = new ArrayList();
                            if (view != null && sparseArray2 != null) {
                                boolean z4 = PbFragment.this.cO(view) && !z3;
                                boolean z5 = (!PbFragment.this.cO(view) || PbFragment.this.kDV == null || PbFragment.this.kDV.isGif()) ? false : true;
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
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.kDE));
                                }
                                if (z5) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.kDE));
                                }
                                if (!z4 && !z5) {
                                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kDE);
                                    SparseArray sparseArray3 = new SparseArray();
                                    sparseArray3.put(R.id.tag_clip_board, PbFragment.this.iUG);
                                    gVar3.mTextView.setTag(sparseArray3);
                                    arrayList.add(gVar3);
                                }
                                if (!z2 && !z3) {
                                    if (z) {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kDE);
                                    } else {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kDE);
                                    }
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(R.id.tag_clip_board, PbFragment.this.iUG);
                                    sparseArray4.put(R.id.tag_is_subpb, false);
                                    gVar2.mTextView.setTag(sparseArray4);
                                    arrayList.add(gVar2);
                                }
                                if (PbFragment.this.mIsLogin && !PbFragment.this.kAY) {
                                    if (!z8 && z7) {
                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kDE);
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
                                        if ((PbFragment.this.sT(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDE);
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
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDE);
                                            gVar6.mTextView.setTag(sparseArray6);
                                        } else {
                                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                                        }
                                        gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kDE);
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
                                            if (PbFragment.this.kzD.getPbData().cVA() == 1002 && !z6) {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kDE);
                                            } else {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kDE);
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
                                PbFragment.this.kDE.aT(arrayList);
                                PbFragment.this.kDD = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kDE);
                                PbFragment.this.kDD.Nv();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dD("tid", PbFragment.this.kzD.kGK).dD("fid", PbFragment.this.kzD.getForumId()).dD("uid", PbFragment.this.kzD.getPbData().cVl().beE().getUserId()).dD("post_id", PbFragment.this.kzD.brS()).ai("obj_source", z2 ? 2 : 1));
                            }
                            return true;
                        }
                        if (!z3) {
                            PbFragment.this.kDz.a(PbFragment.this.kEJ, z, false);
                        }
                        return true;
                    }
                    return true;
                }
                PbFragment.this.kDz.a(PbFragment.this.kEK, PbFragment.this.kDV.isGif());
                return true;
            }
            return true;
        }
    };
    private final NoNetworkView.a hPZ = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bpE && z && !PbFragment.this.kzD.cYJ()) {
                PbFragment.this.cXO();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener eVD = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.hXK.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0674a hrz = new a.InterfaceC0674a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int ggV = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            if (al(i2) && PbFragment.this.kDz != null && PbFragment.this.kCX != null) {
                PbFragment.this.kCX.oz(true);
                if (Math.abs(i2) > this.ggV) {
                    PbFragment.this.kCX.hideFloatingView();
                }
                if (PbFragment.this.cXR()) {
                    PbFragment.this.kDz.daE();
                    PbFragment.this.kDz.daF();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            if (al(i2) && PbFragment.this.kDz != null && PbFragment.this.kCX != null) {
                PbFragment.this.kDz.dbp();
                PbFragment.this.kCX.oz(false);
                PbFragment.this.kCX.showFloatingView();
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
    private final q.a kBZ = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void n(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.kDz.NJ(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int kEM = -1;
    private int kEN = -1;

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

    public com.baidu.tbadk.editortools.pb.e cXo() {
        return this.kDL;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.cWh() != null) {
            String id = pVar.cWh().getId();
            ArrayList<PostData> cVn = this.kzD.getPbData().cVn();
            int i = 0;
            while (true) {
                if (i >= cVn.size()) {
                    z = true;
                    break;
                }
                PostData postData = cVn.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cWl = pVar.cWl();
                    postData.HO(pVar.getTotalCount());
                    if (postData.dwC() == null || cWl == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = cWl.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.beE() != null && (metaData = postData.getUserMap().get(next.beE().getUserId())) != null) {
                                next.a(metaData);
                                next.wc(true);
                                next.a(getPageContext(), this.kzD.NA(metaData.getUserId()));
                            }
                        }
                        z = cWl.size() != postData.dwC().size();
                        if (postData.dwC() != null && postData.dwC().size() < 2) {
                            postData.dwC().clear();
                            postData.dwC().addAll(cWl);
                        }
                    }
                    if (postData.dwy() != null) {
                        postData.dwz();
                    }
                }
            }
            if (!this.kzD.getIsFromMark() && z) {
                this.kDz.s(this.kzD.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n cVD = this.kzD.getPbData().cVD();
            if (cVD != null && str.equals(cVD.getAdId())) {
                if (cVD.dwt() != null) {
                    cVD.dwt().legoCard = null;
                }
                this.kzD.getPbData().cVE();
            }
            com.baidu.tieba.tbadkCore.data.n cYP = this.kzD.cYP();
            if (cYP != null && str.equals(cYP.getAdId())) {
                this.kzD.cYQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kDD != null && this.kDD.isShowing()) {
                this.kDD.dismiss();
                this.kDD = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.kDD != null) {
                            PbFragment.this.kDD.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.kDz.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.kDT);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.kDT);
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
                this.kDD = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.kDD.Nv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(int i) {
        bw cVl;
        if (this.kzD != null && this.kzD.getPbData() != null && (cVl = this.kzD.getPbData().cVl()) != null) {
            if (i == 1) {
                PraiseData bep = cVl.bep();
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
                        cVl.a(praiseData);
                    } else {
                        cVl.bep().getUser().add(0, metaData);
                        cVl.bep().setNum(cVl.bep().getNum() + 1);
                        cVl.bep().setIsLike(i);
                    }
                }
                if (cVl.bep() != null) {
                    if (cVl.bep().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(cVl.bep().getNum());
                    }
                }
            } else if (cVl.bep() != null) {
                cVl.bep().setIsLike(i);
                cVl.bep().setNum(cVl.bep().getNum() - 1);
                ArrayList<MetaData> user = cVl.bep().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cVl.bep().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cVl.bep().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cVl.bep().getNum() + "";
                }
            }
            if (this.kzD.cYD()) {
                this.kDz.daH().notifyDataSetChanged();
            } else {
                this.kDz.t(this.kzD.getPbData());
            }
        }
    }

    public static PbFragment cXp() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.kCV = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kzD.aC(bundle);
        if (this.hSO != null) {
            this.hSO.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.kDL.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.kDc = System.currentTimeMillis();
        this.kDR = getPageContext();
        final Intent intent = this.kCV.getIntent();
        if (intent != null) {
            this.hvn = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.kDk = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.kDk)) {
                    this.kDk = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.kDk)) {
                this.kCY = true;
            }
            this.kEM = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.kEN = intent.getIntExtra("key_manga_next_chapter", -1);
            this.kEO = intent.getStringExtra("key_manga_title");
            this.kDG = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.kDH = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.kDI = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cXR()) {
                this.kCV.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.kDZ = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.kDt = new bf();
            this.kDt.C(intent);
            this.kEb = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.kEb == 0) {
                this.kEb = intent.getIntExtra("key_start_from", 0);
            }
            this.kEc = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.hvn = System.currentTimeMillis();
        }
        this.eRJ = this.kDc - this.hvn;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.kDa = 0;
        aB(bundle);
        if (this.kzD.getPbData() != null) {
            this.kzD.getPbData().Nl(this.source);
        }
        cXs();
        if (intent != null && this.kDz != null) {
            this.kDz.kKB = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.kDU == null) {
                    this.kDU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.kDz.NL(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(this.kDU, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.kzD.getPbData() != null) {
                this.kzD.ND(stringExtra);
            }
        }
        this.hSO = new VoiceManager();
        this.hSO.onCreate(getPageContext());
        initData(bundle);
        this.kDK = new com.baidu.tbadk.editortools.pb.g();
        d(this.kDK);
        this.kDL = (com.baidu.tbadk.editortools.pb.e) this.kDK.ec(getActivity());
        this.kDL.a(this.kCV.getPageContext());
        this.kDL.a(this.eMD);
        this.kDL.a(this.eMw);
        this.kDL.a(this.kCV.getPageContext(), bundle);
        this.kDL.brv().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.kDL.brv().jh(true);
        sR(true);
        this.kDL.a(this.kzD.cYR(), this.kzD.cYB(), this.kzD.cZi());
        registerListener(this.kEh);
        if (!this.kzD.cYI()) {
            this.kDL.BY(this.kzD.cYB());
        }
        if (this.kzD.cZj()) {
            this.kDL.BW(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.kDz != null) {
            this.kDL.BW(this.kDz.das());
        }
        registerListener(this.kEg);
        registerListener(this.kEi);
        registerListener(this.kEj);
        registerListener(this.hUu);
        registerListener(this.kEv);
        registerListener(this.kEf);
        this.kDJ = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.men);
        this.kDJ.dwl();
        registerListener(this.kEk);
        registerListener(this.ekH);
        this.kzD.cZb();
        registerListener(this.kEC);
        registerListener(this.hUC);
        registerListener(this.kEy);
        if (this.kDz != null && this.kDz.dbt() != null && this.kDz.dbu() != null) {
            this.kCX = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.kDz.dbt(), this.kDz.dbu(), this.kDz.day());
            this.kCX.a(this.kEq);
        }
        if (this.kCW && this.kDz != null && this.kDz.dbu() != null) {
            this.kDz.dbu().setVisibility(8);
        }
        this.kDS = new com.baidu.tbadk.core.view.c();
        this.kDS.toastTime = 1000L;
        registerListener(this.kEu);
        registerListener(this.kEs);
        registerListener(this.kEt);
        registerListener(this.inh);
        registerListener(this.hUq);
        this.kEl.setSelfListener(true);
        this.kEl.setTag(this.kCV.getUniqueId());
        this.kEl.setPriority(-1);
        MessageManager.getInstance().registerListener(this.kEl);
        registerResponsedEventListener(TipEvent.class, this.hRS);
        this.kDT = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.kDT;
        userMuteAddAndDelCustomMessage.setTag(this.kDT);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.kDT;
        userMuteCheckCustomMessage.setTag(this.kDT);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kzD.cZg().a(this.kEr);
        this.jJC = new bb();
        if (this.kDL.brW() != null) {
            this.jJC.f(this.kDL.brW().getInputView());
        }
        this.kDL.a(this.eMx);
        this.ilV = new ShareSuccessReplyToServerModel();
        a(this.kEd);
        this.jFx = new com.baidu.tbadk.core.util.am(getPageContext());
        this.jFx.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.eky) {
                        PbFragment.this.kDL.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.ekz && PbFragment.this.kDz != null && PbFragment.this.kDz.dao() != null && PbFragment.this.kDz.dao().cXn() != null) {
                        PbFragment.this.kDz.dao().cXn().bsu();
                    } else if (i == com.baidu.tbadk.core.util.am.ekA) {
                        PbFragment.this.c(PbFragment.this.kDO);
                    }
                }
            }
        });
        this.kDw = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.kDw.x(getUniqueId());
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
        com.baidu.tbadk.core.business.a.bbY().dt("3", "");
        this.hkx = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.kDc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.kzD != null) {
            gVar.setForumName(this.kzD.cWu());
            if (this.kzD.getPbData() != null && this.kzD.getPbData().getForum() != null) {
                gVar.a(this.kzD.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.kzD);
        }
    }

    public String cXq() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cXr() {
        return this.kCX;
    }

    private void sR(boolean z) {
        this.kDL.jl(z);
        this.kDL.jm(z);
        this.kDL.jn(z);
    }

    private void cXs() {
        this.ewX = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hSO != null) {
            this.hSO.onStart(getPageContext());
        }
    }

    public az cXt() {
        return this.kDz;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cWD() {
        return this.kzD;
    }

    public void Nt(String str) {
        if (this.kzD != null && !StringUtils.isNull(str) && this.kDz != null) {
            this.kDz.tF(true);
            this.kzD.Nt(str);
            this.kDi = true;
            this.kDz.dbe();
            this.kDz.dbo();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bpE = false;
        } else {
            this.bpE = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.kDa = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.kDa == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.hSO != null) {
            this.hSO.onPause(getPageContext());
        }
        if (this.kDz != null) {
            this.kDz.onPause();
        }
        if (!this.kzD.cYI()) {
            this.kDL.BX(this.kzD.cYB());
        }
        if (this.kzD != null) {
            this.kzD.cZc();
        }
        com.baidu.tbadk.BdToken.c.aYs().aYC();
        MessageManager.getInstance().unRegisterListener(this.jgJ);
        czC();
        MessageManager.getInstance().unRegisterListener(this.kEs);
        MessageManager.getInstance().unRegisterListener(this.kEt);
        MessageManager.getInstance().unRegisterListener(this.kEu);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cXu() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.kzD.getPbData(), this.kzD.cYD(), this.kzD.cZa());
        return (a2 == null || a2.beE() == null || a2.beE().getGodUserData() == null || a2.beE().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bpE = false;
        super.onResume();
        if (this.kDm) {
            this.kDm = false;
            cXX();
        }
        if (cXu()) {
            this.kDf = System.currentTimeMillis();
        } else {
            this.kDf = -1L;
        }
        if (this.kDz != null && this.kDz.getView() != null) {
            if (!this.jYZ) {
                cXP();
            } else {
                hideLoadingView(this.kDz.getView());
            }
            this.kDz.onResume();
        }
        if (this.kDa == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.kDz != null) {
            noNetworkView = this.kDz.dal();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.hSO != null) {
            this.hSO.onResume(getPageContext());
        }
        registerListener(this.jgJ);
        this.kDF = false;
        cXW();
        registerListener(this.kEs);
        registerListener(this.kEt);
        registerListener(this.kEu);
        if (this.hTD) {
            cXO();
            this.hTD = false;
        }
        cYe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.kDz.tu(z);
        if (this.kDD != null) {
            this.kDD.dismiss();
        }
        if (z && this.kDF) {
            this.kDz.daM();
            this.kzD.tf(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.kDf > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dD("obj_duration", (System.currentTimeMillis() - this.kDf) + ""));
            this.kDf = 0L;
        }
        if (cXt().dao() != null) {
            cXt().dao().onStop();
        }
        if (this.kDz.kKD != null && !this.kDz.kKD.dcm()) {
            this.kDz.kKD.releaseResources();
        }
        if (this.kzD != null && this.kzD.getPbData() != null && this.kzD.getPbData().getForum() != null && this.kzD.getPbData().cVl() != null) {
            com.baidu.tbadk.distribute.a.bri().b(getPageContext().getPageActivity(), "pb", this.kzD.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kzD.getPbData().cVl().getId(), 0L));
        }
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.kDu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dD("fid", this.kzD.getPbData().getForumId());
            aqVar.dD("tid", this.kzD.cYB());
            aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.kDd && this.kDz != null) {
            this.kDd = true;
            this.kDz.dbk();
            a(false, (PostData) null);
        }
        if (this.kzD != null) {
            this.kzD.cancelLoadData();
            this.kzD.destory();
            if (this.kzD.cZf() != null) {
                this.kzD.cZf().onDestroy();
            }
        }
        if (this.kDL != null) {
            this.kDL.onDestroy();
        }
        if (this.hkv != null) {
            this.hkv.cancelLoadData();
        }
        if (this.ewX != null) {
            this.ewX.dvY();
        }
        if (this.kDz != null) {
            this.kDz.onDestroy();
            if (this.kDz.kKD != null) {
                this.kDz.kKD.releaseResources();
            }
        }
        if (this.kDe != null) {
            this.kDe.buf();
        }
        if (this.kCX != null) {
            this.kCX.coi();
        }
        super.onDestroy();
        if (this.hSO != null) {
            this.hSO.onDestory(getPageContext());
        }
        if (this.kDz != null) {
            this.kDz.dbe();
        }
        MessageManager.getInstance().unRegisterListener(this.kEs);
        MessageManager.getInstance().unRegisterListener(this.kEt);
        MessageManager.getInstance().unRegisterListener(this.kEu);
        MessageManager.getInstance().unRegisterListener(this.kDT);
        MessageManager.getInstance().unRegisterListener(this.kEv);
        MessageManager.getInstance().unRegisterListener(this.hUC);
        MessageManager.getInstance().unRegisterListener(this.inh);
        MessageManager.getInstance().unRegisterListener(this.kEA);
        MessageManager.getInstance().unRegisterListener(this.kEl);
        this.kDR = null;
        this.kDS = null;
        com.baidu.tieba.recapp.d.a.dnW().dnZ();
        if (this.kDU != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kDU);
        }
        if (this.kDn != null) {
            this.kDn.cancelLoadData();
        }
        if (this.kDz != null && this.kDz.kKD != null) {
            this.kDz.kKD.dcp();
        }
        if (this.ilV != null) {
            this.ilV.cancelLoadData();
        }
        this.jJC.onDestroy();
        if (this.kzD != null && this.kzD.cZh() != null) {
            this.kzD.cZh().onDestroy();
        }
        if (this.jFx != null) {
            this.jFx.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g daH;
        ArrayList<PostData> cWZ;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bms() && this.kDz != null && (daH = this.kDz.daH()) != null && (cWZ = daH.cWZ()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cWZ.iterator();
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
                        bVar.hmy = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ecy == 1 && !TextUtils.isEmpty(id)) {
                    next.ecy = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.hmy = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.kzD == null || this.kzD.getPbData() == null || this.kzD.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.kzD.getPbData().getForum().getFirst_class();
                    str2 = this.kzD.getPbData().getForum().getSecond_class();
                    str = this.kzD.getPbData().getForum().getId();
                    str4 = this.kzD.cYB();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.bmv());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.kDz.onChangeSkinType(i);
            if (this.kDL != null && this.kDL.brv() != null) {
                this.kDL.brv().onChangeSkinType(i);
            }
            if (this.kDz.dal() != null) {
                this.kDz.dal().onChangeSkinType(getPageContext(), i);
            }
            this.jJC.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
            cmr();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kDz = new az(this, this.hVB, this.eFf);
        this.hXK = new com.baidu.tieba.f.b(getActivity());
        this.hXK.a(kEL);
        this.hXK.a(this.hrz);
        this.kDz.setOnScrollListener(this.mOnScrollListener);
        this.kDz.d(this.kEG);
        this.kDz.setListPullRefreshListener(this.fqN);
        this.kDz.sD(com.baidu.tbadk.core.k.bbM().isShowImages());
        this.kDz.setOnImageClickListener(this.fcy);
        this.kDz.b(this.mOnLongClickListener);
        this.kDz.g(this.hPZ);
        this.kDz.a(this.kEE);
        this.kDz.tu(this.mIsLogin);
        if (this.kCV.getIntent() != null) {
            this.kDz.tG(this.kCV.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.kDz.dan().setFromForumId(this.kzD.getFromForumId());
        this.kDz.setEditorTools(this.kDL.brv());
        this.kDL.BW(this.kDz.das());
        this.kDz.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.kzD.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzD.getPbData().getForum().getId(), PbFragment.this.kzD.getPbData().getForum().getName(), PbFragment.this.kzD.getPbData().cVl().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.kDz.tH(this.kzD.cYG());
        this.kDz.Ep(this.kzD.cZl());
        return this.kDz.getView();
    }

    public void cXv() {
        if (this.kDz != null && this.kzD != null) {
            if ((this.kzD.getPbData() != null || this.kzD.getPbData().cVK() != null) && checkUpIsLogin() && this.kDz.daH() != null && this.kDz.daH().cXe() != null) {
                this.kDz.daH().cXe().AE(this.kzD.cYB());
            }
        }
    }

    public void cXw() {
        TiebaStatic.log("c12181");
        if (this.kDz != null && this.kzD != null) {
            if ((this.kDz == null || this.kDz.dar()) && this.kzD.getPbData() != null && this.kzD.getPbData().cVK() != null) {
                com.baidu.tieba.pb.data.o cVK = this.kzD.getPbData().cVK();
                if (checkUpIsLogin()) {
                    if ((!cVK.cWe() || cVK.bgf() != 2) && this.kDz.daH() != null && this.kDz.daH().cXe() != null) {
                        this.kDz.daH().cXe().AE(this.kzD.cYB());
                    }
                    if (System.currentTimeMillis() - this.kDh > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).uo(false);
                        this.kDh = System.currentTimeMillis();
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
                if (postData.getType() != PostData.ebj && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bbM().isShowImages()) {
                    return Nw(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.kzD == null || this.kzD.getPbData() == null) {
                        return true;
                    }
                    if (cXt().dao() != null) {
                        cXt().dao().cXj();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.kzD.getPbData().getForum());
                    pVar.setThreadData(this.kzD.getPbData().cVl());
                    pVar.g(postData);
                    cXt().dan().d(pVar);
                    cXt().dan().setPostId(postData.getId());
                    a(view, postData.beE().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.kDL != null) {
                        this.kDz.tA(this.kDL.bse());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cXx() {
        if (this.kDb == null) {
            this.kDb = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.kDb.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.kzz = PbFragment.this.kzz.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzz);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kzD.cYB(), PbFragment.this.kzz, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.kzz = PbFragment.this.kzz.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzz);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kzD.cYB(), PbFragment.this.kzz, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.kzz = PbFragment.this.kzz.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kzz);
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
        this.kEB.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).dep(), "", 1);
    }

    private void aB(Bundle bundle) {
        this.kzD = this.kCV.cWD();
        if (this.kzD.cZe() != null) {
            this.kzD.cZe().a(this.kBZ);
        }
        if (this.kzD.cZf() != null) {
            this.kzD.cZf().b(this.kEe);
        }
        if (StringUtils.isNull(this.kzD.cYB())) {
            this.kCV.finish();
        } else if ("from_tieba_kuang".equals(this.kDk) && this.kDk != null) {
            this.kzD.Ep(6);
        }
    }

    private void initData(Bundle bundle) {
        this.kDx = com.baidu.tbadk.baseEditMark.a.a(this.kCV);
        if (this.kDx != null) {
            this.kDx.a(this.kED);
        }
        this.hkv = new ForumManageModel(this.kCV);
        this.hkv.setLoadDataCallBack(this.hkC);
        this.ekD = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kEp.setUniqueId(getUniqueId());
        this.kEp.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.kDz.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.kDT;
        userMuteCheckCustomMessage.setTag(this.kDT);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cXy() {
        if (this.kzD == null || this.kzD.getPbData() == null) {
            return false;
        }
        bw cVl = this.kzD.getPbData().cVl();
        this.kzD.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cVl);
    }

    public void cXz() {
        if (checkUpIsLogin() && this.kzD != null && this.kzD.getPbData() != null && this.kzD.getPbData().getForum() != null && !cXy()) {
            if (this.kzD.getPbData().cVO()) {
                this.kDz.czd();
                return;
            }
            if (this.hXk == null) {
                this.hXk = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hXk.yr(0);
                this.hXk.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ou(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ov(boolean z) {
                        if (z) {
                            if (PbFragment.this.kDL != null && PbFragment.this.kDL.brv() != null) {
                                PbFragment.this.kDL.brv().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.kDz.czd();
                        }
                    }
                });
            }
            this.hXk.C(this.kzD.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kzD.cYB(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cXA() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.kzD == null || (pbData = this.kzD.getPbData()) == null) {
            return null;
        }
        return pbData.cVz().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVl() != null) {
            if (fVar.cVl().getThreadType() == 0) {
                return 1;
            }
            if (fVar.cVl().getThreadType() == 54) {
                return 2;
            }
            if (fVar.cVl().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !cXy() && cXB()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kDp);
                this.kDq = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cXt().dao() != null && postData != null) {
                String str3 = "";
                if (postData.dwH() != null) {
                    str3 = postData.dwH().toString();
                }
                cXt().dao().Nr(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.beE().getName_show(), str3));
            }
            if (this.kzD.getPbData() != null && this.kzD.getPbData().cVO()) {
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.kCV.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cXt().getListView().smoothScrollBy((PbFragment.this.kDp[1] + PbFragment.this.kDq) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cXt().dao() != null) {
                            PbFragment.this.kDL.brv().setVisibility(8);
                            PbFragment.this.cXt().dao().g(str, str2, PbFragment.this.cXt().das(), (PbFragment.this.kzD == null || PbFragment.this.kzD.getPbData() == null || PbFragment.this.kzD.getPbData().cVl() == null || !PbFragment.this.kzD.getPbData().cVl().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cXn = PbFragment.this.cXt().dao().cXn();
                            if (cXn != null && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                cXn.a(PbFragment.this.kzD.getPbData().getAnti());
                                cXn.setThreadData(PbFragment.this.kzD.getPbData().cVl());
                            }
                            if (PbFragment.this.jJC.dbG() == null && PbFragment.this.cXt().dao().cXn().bsC() != null) {
                                PbFragment.this.cXt().dao().cXn().bsC().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jJC != null && PbFragment.this.jJC.dbF() != null) {
                                            if (!PbFragment.this.jJC.dbF().dFx()) {
                                                PbFragment.this.jJC.tJ(false);
                                            }
                                            PbFragment.this.jJC.dbF().wY(false);
                                        }
                                    }
                                });
                                PbFragment.this.jJC.g(PbFragment.this.cXt().dao().cXn().bsC().getInputView());
                                PbFragment.this.cXt().dao().cXn().a(PbFragment.this.kDQ);
                            }
                        }
                        PbFragment.this.cXt().dbo();
                    }
                }, 0L);
                return;
            }
            if (this.kDN == null) {
                this.kDN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kDN.yr(1);
                this.kDN.a(new AnonymousClass39(str, str2));
            }
            if (this.kzD != null && this.kzD.getPbData() != null && this.kzD.getPbData().getForum() != null) {
                this.kDN.C(this.kzD.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kzD.cYB(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String kEV;
        final /* synthetic */ String kEW;

        AnonymousClass39(String str, String str2) {
            this.kEV = str;
            this.kEW = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ou(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ov(boolean z) {
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
                        PbFragment.this.cXt().getListView().smoothScrollBy((PbFragment.this.kDp[1] + PbFragment.this.kDq) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cXt().dao() != null) {
                            PbFragment.this.kDL.brv().setVisibility(8);
                            PbFragment.this.cXt().dao().g(AnonymousClass39.this.kEV, AnonymousClass39.this.kEW, PbFragment.this.cXt().das(), (PbFragment.this.kzD == null || PbFragment.this.kzD.getPbData() == null || PbFragment.this.kzD.getPbData().cVl() == null || !PbFragment.this.kzD.getPbData().cVl().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cXn = PbFragment.this.cXt().dao().cXn();
                            if (cXn != null && PbFragment.this.kzD != null && PbFragment.this.kzD.getPbData() != null) {
                                cXn.a(PbFragment.this.kzD.getPbData().getAnti());
                                cXn.setThreadData(PbFragment.this.kzD.getPbData().cVl());
                            }
                            if (PbFragment.this.jJC.dbG() == null && PbFragment.this.cXt().dao().cXn().bsC() != null) {
                                PbFragment.this.cXt().dao().cXn().bsC().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jJC != null && PbFragment.this.jJC.dbF() != null) {
                                            if (!PbFragment.this.jJC.dbF().dFx()) {
                                                PbFragment.this.jJC.tJ(false);
                                            }
                                            PbFragment.this.jJC.dbF().wY(false);
                                        }
                                    }
                                });
                                PbFragment.this.jJC.g(PbFragment.this.cXt().dao().cXn().bsC().getInputView());
                                PbFragment.this.cXt().dao().cXn().a(PbFragment.this.kDQ);
                            }
                        }
                        PbFragment.this.cXt().dbo();
                    }
                }, 0L);
            }
        }
    }

    public boolean cXB() {
        if ((this.kzD.getPbData() != null && this.kzD.getPbData().cVO()) || this.jFx == null || this.kzD.getPbData() == null || this.kzD.getPbData().getAnti() == null) {
            return true;
        }
        return this.jFx.nP(this.kzD.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Ec(int i) {
        if (this.jFx == null || this.kzD.getPbData() == null || this.kzD.getPbData().getAnti() == null) {
            return true;
        }
        return this.jFx.aN(this.kzD.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.kzD != null && this.kzD.getPbData() != null && postData.dwF() != 1) {
            String cYB = this.kzD.cYB();
            String id = postData.getId();
            int i = 0;
            if (this.kzD.getPbData() != null) {
                i = this.kzD.getPbData().cVA();
            }
            PbActivity.a Nx = Nx(id);
            if (Nx != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cYB, id, "pb", true, null, false, null, i, postData.ddj(), this.kzD.getPbData().getAnti(), false, postData.beE() != null ? postData.beE().getIconInfo() : null).addBigImageData(Nx.kzL, Nx.dUO, Nx.dUM, Nx.index);
                addBigImageData.setKeyPageStartFrom(this.kzD.cZl());
                addBigImageData.setFromFrsForumId(this.kzD.getFromForumId());
                addBigImageData.setKeyFromForumId(this.kzD.getForumId());
                addBigImageData.setBjhData(this.kzD.cYK());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cXC() {
        if (this.kzD.getPbData() == null || this.kzD.getPbData().cVl() == null) {
            return -1;
        }
        return this.kzD.getPbData().cVl().bfr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && cWD() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            cWD().NC(postWriteCallBackData.getPostId());
            this.kDY = this.kDz.dau();
            this.kzD.cU(this.kDY, this.kDz.dav());
        }
        this.kDz.dbe();
        this.jJC.dbD();
        if (this.kDL != null) {
            this.kDz.tA(this.kDL.bse());
        }
        this.kDz.dam();
        this.kDz.tC(true);
        this.kzD.cYW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(boolean z) {
        if (this.kzD != null && this.kzD.kAA != null && this.kzD.kAA.cVl() != null) {
            bw cVl = this.kzD.kAA.cVl();
            cVl.mRecomAbTag = this.kzD.cZw();
            cVl.mRecomWeight = this.kzD.cZu();
            cVl.mRecomSource = this.kzD.cZv();
            cVl.mRecomExtra = this.kzD.cZx();
            if (cVl.getFid() == 0) {
                cVl.setFid(com.baidu.adp.lib.f.b.toLong(this.kzD.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cVl, "c13563");
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
    public void cXD() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.PX(this.kzD.getForumId()) && this.kzD.getPbData() != null && this.kzD.getPbData().getForum() != null) {
            if (this.kzD.getPbData().getForum().isLike() == 1) {
                this.kzD.cZh().fJ(this.kzD.getForumId(), this.kzD.cYB());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sT(boolean z) {
        if (this.kzD == null || this.kzD.getPbData() == null) {
            return false;
        }
        return ((this.kzD.getPbData().cVA() != 0) || this.kzD.getPbData().cVl() == null || this.kzD.getPbData().cVl().beE() == null || TextUtils.equals(this.kzD.getPbData().cVl().beE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean sU(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ab abVar;
        if (this.kzD == null || this.kzD.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.kzD.getPbData();
        bw cVl = pbData.cVl();
        if (cVl != null) {
            if (cVl.bdm() || cVl.bdn()) {
                return false;
            }
            if (cVl.bgz() || cVl.bgA()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cVA() != 0) {
                return pbData.cVA() != 3;
            }
            List<bs> cVI = pbData.cVI();
            if (com.baidu.tbadk.core.util.y.getCount(cVI) > 0) {
                for (bs bsVar : cVI) {
                    if (bsVar != null && (abVar = bsVar.eau) != null && abVar.dYg && !abVar.dYh && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean sV(boolean z) {
        if (z || this.kzD == null || this.kzD.getPbData() == null) {
            return false;
        }
        return ((this.kzD.getPbData().getForum() != null && this.kzD.getPbData().getForum().isBlockBawuDelete) || this.kzD.getPbData().cVA() == 0 || this.kzD.getPbData().cVA() == 3) ? false : true;
    }

    public void cXE() {
        com.baidu.tieba.pb.data.f pbData;
        bw cVl;
        boolean z = true;
        if (this.kzD != null && this.kzD.getPbData() != null && (cVl = (pbData = this.kzD.getPbData()).cVl()) != null && cVl.beE() != null) {
            this.kDz.dam();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cVl.beE().getUserId());
            ak akVar = new ak();
            int cVA = this.kzD.getPbData().cVA();
            if (cVA == 1 || cVA == 3) {
                akVar.kIR = true;
                akVar.kIQ = true;
                akVar.kIW = cVl.bez() == 1;
                akVar.kIV = cVl.beA() == 1;
            } else {
                akVar.kIR = false;
                akVar.kIQ = false;
            }
            if (cVA == 1002 && !equals) {
                akVar.kIX = true;
            }
            akVar.kIO = sU(equals);
            akVar.kIS = cXF();
            akVar.kIP = sV(equals);
            akVar.EK = this.kzD.cYD();
            akVar.kIL = true;
            akVar.kIK = sT(equals);
            akVar.kIJ = equals && this.kDz.daT();
            akVar.kIU = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.kIT = true;
            akVar.isHostOnly = this.kzD.getHostMode();
            akVar.kIN = true;
            if (cVl.beW() == null) {
                akVar.kIM = true;
            } else {
                akVar.kIM = false;
            }
            if (pbData.cVO()) {
                akVar.kIL = false;
                akVar.kIN = false;
                akVar.kIM = false;
                akVar.kIQ = false;
                akVar.kIR = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cVO()) {
                z = false;
            }
            akVar.kIY = z;
            this.kDz.kKD.a(akVar);
        }
    }

    private boolean cXF() {
        if (this.kzD != null && this.kzD.cYD()) {
            return this.kzD.getPageData() == null || this.kzD.getPageData().bdv() != 0;
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
    public PbModel.a cXG() {
        return this.kEB;
    }

    public int cXH() {
        if (cXt() == null || cXt().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cXt().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).UM == com.baidu.tieba.pb.data.n.kxZ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cXI() {
        if (cXt() == null || cXt().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cXt().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.meN) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cXO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXJ() {
        if (this.kzD != null && this.kzD.kAA != null && this.kzD.kAA.cVl() != null) {
            bw cVl = this.kzD.kAA.cVl();
            cVl.mRecomAbTag = this.kzD.cZw();
            cVl.mRecomWeight = this.kzD.cZu();
            cVl.mRecomSource = this.kzD.cZv();
            cVl.mRecomExtra = this.kzD.cZx();
            if (cVl.getFid() == 0) {
                cVl.setFid(com.baidu.adp.lib.f.b.toLong(this.kzD.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cVl, "c13562");
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
            aVar.zy(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.zz(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.m39if(false);
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
                    PbFragment.this.ekD.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.kzD.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bhg();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.kDz.daN();
        this.kzD.th(z);
        if (this.kDx != null) {
            this.kDx.hA(z);
            if (markData != null) {
                this.kDx.a(markData);
            }
        }
        if (this.kzD.baA()) {
            cXM();
        } else {
            this.kDz.s(this.kzD.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean DT(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nu(String str) {
        if (this.kzD != null && this.kzD.getPbData() != null && this.kzD.getPbData().cVO()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kzD.cYB(), str);
            bw cVl = this.kzD.getPbData().cVl();
            if (cVl.bdm()) {
                format = format + "&channelid=33833";
            } else if (cVl.bgy()) {
                format = format + "&channelid=33842";
            } else if (cVl.bdn()) {
                format = format + "&channelid=33840";
            }
            Nv(format);
            return;
        }
        this.kDw.NV(str);
    }

    private void Nv(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.kzD.cYI()) {
                    antiData.setBlock_forum_name(this.kzD.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.kzD.getPbData().getForum().getId());
                    antiData.setUser_name(this.kzD.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.kzD.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cXt() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bz(i, str)) {
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
            Cd(str);
        } else {
            this.kDz.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.mhz) ? bVar.mhz : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.zz(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.m39if(true);
                aVar.b(getPageContext());
                aVar.bhg();
            } else {
                this.kDz.a(0, bVar.Qf, bVar.mhz, z);
            }
            if (bVar.Qf) {
                if (bVar.hzG == 1) {
                    ArrayList<PostData> cVn = this.kzD.getPbData().cVn();
                    int size = cVn.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cVn.get(i).getId())) {
                            i++;
                        } else {
                            cVn.remove(i);
                            break;
                        }
                    }
                    this.kzD.getPbData().cVl().ng(this.kzD.getPbData().cVl().bev() - 1);
                    this.kDz.s(this.kzD.getPbData());
                } else if (bVar.hzG == 0) {
                    cXK();
                } else if (bVar.hzG == 2) {
                    ArrayList<PostData> cVn2 = this.kzD.getPbData().cVn();
                    int size2 = cVn2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cVn2.get(i2).dwC().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cVn2.get(i2).dwC().get(i3).getId())) {
                                i3++;
                            } else {
                                cVn2.get(i2).dwC().remove(i3);
                                cVn2.get(i2).dwE();
                                z2 = true;
                                break;
                            }
                        }
                        cVn2.get(i2).QN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.kDz.s(this.kzD.getPbData());
                    }
                    a(bVar, this.kDz);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.kDz.a(this.hkv.getLoadDataMode(), gVar.Qf, gVar.mhz, false);
            if (gVar.Qf) {
                this.kDA = true;
                if (i == 2 || i == 3) {
                    this.kDB = true;
                    this.kDC = false;
                } else if (i == 4 || i == 5) {
                    this.kDB = false;
                    this.kDC = true;
                }
                if (i == 2) {
                    this.kzD.getPbData().cVl().nj(1);
                    this.kzD.setIsGood(1);
                } else if (i == 3) {
                    this.kzD.getPbData().cVl().nj(0);
                    this.kzD.setIsGood(0);
                } else if (i == 4) {
                    this.kzD.getPbData().cVl().ni(1);
                    this.kzD.Eh(1);
                } else if (i == 5) {
                    this.kzD.getPbData().cVl().ni(0);
                    this.kzD.Eh(0);
                }
                this.kDz.c(this.kzD.getPbData(), this.kzD.cYD());
            }
        }
    }

    private void cXK() {
        if (this.kzD.cYE() || this.kzD.cYG()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.kzD.cYB());
            PbActivity pbActivity = this.kCV;
            PbActivity pbActivity2 = this.kCV;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.kzD.cYB()));
        if (cXN()) {
            this.kCV.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWQ() {
        this.kCV.cWQ();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cVx;
        boolean z = false;
        if (this.kDz != null) {
            this.kDz.dbe();
        }
        if (this.kzD != null && this.kzD.getPbData() != null && !this.kzD.getPbData().cVO()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.kzD.getPbData().cVl().getId();
            if (this.kzD.isShareThread() && this.kzD.getPbData().cVl().edE != null) {
                historyMessage.threadName = this.kzD.getPbData().cVl().edE.showText;
            } else {
                historyMessage.threadName = this.kzD.getPbData().cVl().getTitle();
            }
            if (this.kzD.isShareThread() && !cWt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.kzD.getPbData().getForum().getName();
            }
            ArrayList<PostData> cVn = this.kzD.getPbData().cVn();
            int daP = this.kDz != null ? this.kDz.daP() : 0;
            if (cVn != null && daP >= 0 && daP < cVn.size()) {
                historyMessage.postID = cVn.get(daP).getId();
            }
            historyMessage.isHostOnly = this.kzD.getHostMode();
            historyMessage.isSquence = this.kzD.cYD();
            historyMessage.isShareThread = this.kzD.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kDL != null) {
            this.kDL.onDestroy();
        }
        if (this.kCZ && cXt() != null) {
            cXt().dby();
        }
        if (this.kzD != null && (this.kzD.cYE() || this.kzD.cYG())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.kzD.cYB());
            if (this.kDA) {
                if (this.kDC) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.kzD.ceI());
                }
                if (this.kDB) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.kzD.getIsGood());
                }
            }
            if (this.kzD.getPbData() != null && System.currentTimeMillis() - this.kDc >= 40000 && (cVx = this.kzD.getPbData().cVx()) != null && !com.baidu.tbadk.core.util.y.isEmpty(cVx.getDataList())) {
                intent.putExtra("guess_like_data", cVx);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.kDZ);
            }
            PbActivity pbActivity = this.kCV;
            PbActivity pbActivity2 = this.kCV;
            pbActivity.setResult(-1, intent);
        }
        if (cXN()) {
            if (this.kzD != null && this.kDz != null && this.kDz.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.kzD.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cVt() && !this.kDi && pbData.kwJ == null) {
                        as cZW = as.cZW();
                        com.baidu.tieba.pb.data.f cYL = this.kzD.cYL();
                        Parcelable onSaveInstanceState = this.kDz.getListView().onSaveInstanceState();
                        boolean cYD = this.kzD.cYD();
                        boolean hostMode = this.kzD.getHostMode();
                        if (this.kDz.day() != null && this.kDz.day().getVisibility() == 0) {
                            z = true;
                        }
                        cZW.a(cYL, onSaveInstanceState, cYD, hostMode, z);
                        if (this.kDY >= 0 || this.kzD.cZn() != null) {
                            as.cZW().q(this.kzD.cZn());
                            as.cZW().p(this.kzD.cZo());
                            as.cZW().Er(this.kzD.cZp());
                        }
                    }
                }
            } else {
                as.cZW().reset();
            }
            cWQ();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.kDz == null || !this.kDz.Ex(i)) ? false : true;
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
        PbActivity pbActivity = this.kCV;
        if (i == 0) {
            this.kDz.dam();
            this.kDz.dao().cXj();
            this.kDz.tC(false);
        }
        this.kDz.daq();
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
                        this.kDL.resetData();
                        this.kDL.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kDL.b(writeData);
                        com.baidu.tbadk.editortools.m qe = this.kDL.brv().qe(6);
                        if (qe != null && qe.eKx != null) {
                            qe.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.kCV;
                        if (i == -1) {
                            this.kDL.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.kDz.dao() != null && this.kDz.dao().cXn() != null) {
                            com.baidu.tbadk.editortools.pb.h cXn = this.kDz.dao().cXn();
                            cXn.setThreadData(this.kzD.getPbData().cVl());
                            cXn.b(writeData);
                            cXn.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m qe2 = cXn.brv().qe(6);
                            if (qe2 != null && qe2.eKx != null) {
                                qe2.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.kCV;
                            if (i == -1) {
                                cXn.bsu();
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
        this.kDL.onActivityResult(i, i2, intent);
        if (this.kDn != null) {
            this.kDn.onActivityResult(i, i2, intent);
        }
        if (cXt().dao() != null) {
            cXt().dao().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cXL();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.cZW().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.kzD != null) {
                                PbFragment.this.kzD.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dmM().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.kzD != null) {
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
                        com.baidu.tieba.o.a.dmM().F(getPageContext());
                        cXD();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.ilV != null && shareItem != null && shareItem.linkUrl != null) {
                            this.ilV.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void boY() {
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
                    this.kDz.sI(false);
                    if (this.kzD.getPbData() != null && this.kzD.getPbData().cVl() != null && this.kzD.getPbData().cVl().beZ() != null) {
                        this.kzD.getPbData().cVl().beZ().setStatus(2);
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
                        this.kDO = emotionImageData;
                        if (Ec(com.baidu.tbadk.core.util.am.ekA)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.kDo != null) {
                        this.kDz.cU(this.kDo);
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
            if (this.kDn == null) {
                this.kDn = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.kCV);
                this.kDn.b(this.eMw);
                this.kDn.c(this.eMD);
            }
            this.kDn.a(emotionImageData, cWD(), cWD().getPbData());
        }
    }

    private void V(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXL() {
        MarkData Eo;
        if (this.kDx != null) {
            if (this.kzD.getPbData() != null && this.kzD.getPbData().cVO()) {
                Eo = this.kzD.Eo(0);
            } else {
                Eo = this.kzD.Eo(this.kDz.daQ());
            }
            if (Eo != null) {
                if (!Eo.isApp() || (Eo = this.kzD.Eo(this.kDz.daQ() + 1)) != null) {
                    this.kDz.daL();
                    this.kDx.a(Eo);
                    if (!this.kDx.baA()) {
                        this.kDx.baC();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.kDx.baB();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXM() {
        com.baidu.tieba.pb.data.f pbData = this.kzD.getPbData();
        this.kzD.th(true);
        if (this.kDx != null) {
            pbData.Nk(this.kDx.baz());
        }
        this.kDz.s(pbData);
    }

    private boolean cXN() {
        if (this.kzD == null) {
            return true;
        }
        if (this.kzD.getPbData() == null || !this.kzD.getPbData().cVO()) {
            if (this.kzD.baA()) {
                final MarkData cYV = this.kzD.cYV();
                if (cYV == null || !this.kzD.getIsFromMark()) {
                    return true;
                }
                final MarkData Eo = this.kzD.Eo(this.kDz.daP());
                if (Eo == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cYV);
                    this.kCV.setResult(-1, intent);
                    return true;
                } else if (Eo.getPostId() == null || Eo.getPostId().equals(cYV.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cYV);
                    this.kCV.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.zz(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.kDx != null) {
                                if (PbFragment.this.kDx.baA()) {
                                    PbFragment.this.kDx.baB();
                                    PbFragment.this.kDx.hA(false);
                                }
                                PbFragment.this.kDx.a(Eo);
                                PbFragment.this.kDx.hA(true);
                                PbFragment.this.kDx.baC();
                            }
                            cYV.setPostId(Eo.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cYV);
                            PbFragment.this.kCV.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cWQ();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cYV);
                            PbFragment.this.kCV.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cWQ();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.kDz != null && PbFragment.this.kDz.getView() != null) {
                                PbFragment.this.kDz.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cYV);
                                PbFragment.this.kCV.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cWQ();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bhg();
                    return false;
                }
            } else if (this.kzD.getPbData() == null || this.kzD.getPbData().cVn() == null || this.kzD.getPbData().cVn().size() <= 0 || !this.kzD.getIsFromMark()) {
                return true;
            } else {
                this.kCV.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.i
    public BdListView getListView() {
        if (this.kDz == null) {
            return null;
        }
        return this.kDz.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int byh() {
        if (this.kDz == null) {
            return 0;
        }
        return this.kDz.dbc();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> byi() {
        if (this.fcm == null) {
            this.fcm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: byu */
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
        return this.fcm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> byj() {
        if (this.ffF == null) {
            this.ffF = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.ffF;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> byk() {
        if (this.fcn == null) {
            this.fcn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cgy */
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
                    gifView.bsU();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fcn;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> byl() {
        if (this.ffG == null) {
            this.ffG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYl */
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
                    ((PlayVoiceBntNew) view).bPe();
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
        return this.ffG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> byn() {
        this.ffI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cYm */
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
        return this.ffI;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bld() {
        if (this.evp == null) {
            this.evp = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.evp;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kDg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (be.NM(str) && this.kzD != null && this.kzD.cYB() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").ai("obj_param1", 1).dD("post_id", this.kzD.cYB()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.eJB = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            be.dbI().f(getPageContext(), str);
        }
        this.kDg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ar(Context context, String str) {
        be.dbI().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.kDg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void at(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void as(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.kDz != null && this.kDz.dbt() != null && rect.top <= this.kDz.dbt().getHeight()) {
            rect.top += this.kDz.dbt().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.kzD.getPbData();
            TbRichText bv = bv(str, i);
            if (bv != null && (tbRichTextData = bv.bxw().get(this.kEH)) != null) {
                aVar.postId = String.valueOf(bv.getPostId());
                aVar.kzL = new ArrayList<>();
                aVar.dUO = new ConcurrentHashMap<>();
                if (!tbRichTextData.bxC().bxQ()) {
                    aVar.kzM = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.kzL.add(c2);
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
                    imageUrlData.mIsReserver = this.kzD.cYT();
                    imageUrlData.mIsSeeHost = this.kzD.getHostMode();
                    aVar.dUO.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cVl() != null) {
                            aVar.threadId = pbData.cVl().getId();
                        }
                        aVar.dUM = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kzM = true;
                int size = pbData.cVn().size();
                this.kEI = false;
                aVar.index = -1;
                int a2 = pbData.cVu() != null ? a(pbData.cVu().dwH(), bv, i, i, aVar.kzL, aVar.dUO) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cVn().get(i2);
                    if (postData.getId() == null || pbData.cVu() == null || pbData.cVu().getId() == null || !postData.getId().equals(pbData.cVu().getId())) {
                        a2 = a(postData.dwH(), bv, a2, i, aVar.kzL, aVar.dUO);
                    }
                }
                if (aVar.kzL.size() > 0) {
                    aVar.lastId = aVar.kzL.get(aVar.kzL.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cVl() != null) {
                        aVar.threadId = pbData.cVl().getId();
                    }
                    aVar.dUM = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxC() == null) {
            return null;
        }
        return tbRichTextData.bxC().bxV();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxC() == null) {
            return 0L;
        }
        return tbRichTextData.bxC().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxC() == null) {
            return false;
        }
        return tbRichTextData.bxC().bxW();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxC() == null) {
            return false;
        }
        return tbRichTextData.bxC().bxX();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bxC;
        String str;
        if (tbRichText == tbRichText2) {
            this.kEI = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bxw().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bxw().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bxC().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bxC().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bxC().bxQ()) {
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
                            if (tbRichTextData != null && (bxC = tbRichTextData.bxC()) != null) {
                                String bxS = bxC.bxS();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bxC.bxT();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bxS;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kzD.cYB(), -1L);
                                imageUrlData.mIsReserver = this.kzD.cYT();
                                imageUrlData.mIsSeeHost = this.kzD.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.kEI) {
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
        PostData cVu;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kzD.beM())) {
                z = true;
            }
            MarkData o = this.kzD.o(postData);
            if (this.kzD.getPbData() != null && this.kzD.getPbData().cVO() && (cVu = cVu()) != null) {
                o = this.kzD.o(cVu);
            }
            if (o != null) {
                this.kDz.daL();
                if (this.kDx != null) {
                    this.kDx.a(o);
                    if (!z) {
                        this.kDx.baC();
                    } else {
                        this.kDx.baB();
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
        if (this.kzD == null || this.kzD.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.kzD.getPbData();
        if (pbData.cVu() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cVu());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cVn = pbData.cVn();
            c(pbData, cVn);
            return c(cVn, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eoq == null) {
                this.eoq = new com.baidu.tbadk.core.message.a();
            }
            if (this.enZ == null) {
                this.enZ = new com.baidu.tieba.tbadkCore.data.e();
                this.enZ.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dWK = 5;
            cVar.dWQ = 8;
            cVar.dWP = 2;
            if (cWD() != null) {
                cVar.dWO = cWD().cZl();
            }
            cVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dWR = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dWR = 1;
                        i = 0;
                    }
                }
                this.eoq.a(agreeData, i, getUniqueId(), false);
                this.eoq.a(agreeData, this.enZ);
                if (this.kzD == null && this.kzD.getPbData() != null) {
                    this.eoq.a(cYi(), cVar, agreeData, this.kzD.getPbData().cVl());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dWR = 1;
            }
            i = 0;
            this.eoq.a(agreeData, i, getUniqueId(), false);
            this.eoq.a(agreeData, this.enZ);
            if (this.kzD == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cVz() != null && fVar.cVz().kyo != null && (list = fVar.cVz().kyo) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bxw;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dwH = arrayList.get(i2).dwH();
            if (dwH != null && (bxw = dwH.bxw()) != null) {
                int size = bxw.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bxw.get(i4) != null && bxw.get(i4).getType() == 8) {
                        i3++;
                        if (bxw.get(i4).bxC().bxS().equals(str) || bxw.get(i4).bxC().bxT().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bxw.get(i4).bxC().getWidth() * equipmentDensity;
                            int height = bxw.get(i4).bxC().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kEH = i4;
                            return dwH;
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
            this.kzz = str;
            if (this.kDb == null) {
                cXx();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.kDb.getItemView(1).setVisibility(8);
            } else {
                this.kDb.getItemView(1).setVisibility(0);
            }
            this.kDb.bhi();
            this.kDg = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hSO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXO() {
        hideNetRefreshView(this.kDz.getView());
        cXP();
        if (this.kzD.cYO()) {
            this.kDz.daL();
        }
        this.kDz.daW();
    }

    private void cXP() {
        showLoadingView(this.kDz.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.kDz.dbt().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmr() {
        if (this.hSO != null) {
            this.hSO.stopPlay();
        }
        if (this.kCV != null) {
            this.kCV.cmr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ee(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cXC(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bym() {
        if (this.ffH == null) {
            this.ffH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYn */
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
        return this.ffH;
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

    public void cms() {
        if (this.kCV != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.kCV.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kCV.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData ckT() {
        if (this.kzD == null || this.kzD.getPbData() == null) {
            return null;
        }
        return this.kzD.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.kLR)).intValue();
            if (intValue == az.kLS) {
                if (!this.hkv.dxq()) {
                    this.kDz.daI();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.hkv.QP(com.baidu.tbadk.core.util.at.R(jSONArray));
                    }
                    this.hkv.a(this.kzD.getPbData().getForum().getId(), this.kzD.getPbData().getForum().getName(), this.kzD.getPbData().cVl().getId(), str, intValue3, intValue2, booleanValue, this.kzD.getPbData().cVl().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.kLT || intValue == az.kLV) {
                if (this.kzD.cZe() != null) {
                    this.kzD.cZe().DY(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.kLT) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.kDT);
        userMuteAddAndDelCustomMessage.setTag(this.kDT);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Nw(String str) {
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
    public void sW(boolean z) {
        this.kDF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cXQ() {
        ArrayList<PostData> cVn;
        int count;
        if (this.kzD == null || this.kzD.getPbData() == null || this.kzD.getPbData().cVn() == null || (count = com.baidu.tbadk.core.util.y.getCount((cVn = this.kzD.getPbData().cVn()))) == 0) {
            return "";
        }
        if (this.kzD.cYT()) {
            Iterator<PostData> it = cVn.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dwF() == 1) {
                    return next.getId();
                }
            }
        }
        int daP = this.kDz.daP();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cVn, daP);
        if (postData == null || postData.beE() == null) {
            return "";
        }
        if (this.kzD.NA(postData.beE().getUserId())) {
            return postData.getId();
        }
        for (int i = daP - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(cVn, i);
            if (postData2 == null || postData2.beE() == null || postData2.beE().getUserId() == null) {
                break;
            } else if (this.kzD.NA(postData2.beE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = daP + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(cVn, i2);
            if (postData3 == null || postData3.beE() == null || postData3.beE().getUserId() == null) {
                return "";
            }
            if (this.kzD.NA(postData3.beE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void au(Context context, String str) {
        this.kDg = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Nx(String str) {
        String str2;
        if (this.kzD.getPbData() == null || this.kzD.getPbData().cVn() == null || this.kzD.getPbData().cVn().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kzD.getPbData().cVn().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kzD.getPbData().cVn().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kzD.getPbData().cVn().get(i);
        if (postData.dwH() == null || postData.dwH().bxw() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dwH().bxw().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bxC() != null) {
                    str2 = next.bxC().bxS();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean cXR() {
        return (!this.kCW && this.kEM == -1 && this.kEN == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null) {
            this.kEP = rVar;
            this.kCW = true;
            this.kDz.daz();
            this.kDz.NK(this.kEO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXS() {
        if (this.kEP != null) {
            if (this.kEM == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kEP.getCartoonId(), this.kEM, 0)));
                this.kCV.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXT() {
        if (this.kEP != null) {
            if (this.kEN == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kEP.getCartoonId(), this.kEN, 0)));
                this.kCV.finish();
            }
        }
    }

    public int cXU() {
        return this.kEM;
    }

    public int cXV() {
        return this.kEN;
    }

    private void czC() {
        if (this.kzD != null && this.kzD.getPbData() != null && this.kzD.getPbData().cVl() != null && this.kzD.getPbData().cVl().bdk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cXW() {
        if (this.kzD != null && this.kzD.getPbData() != null && this.kzD.getPbData().cVl() != null && this.kzD.getPbData().cVl().bdk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cXX() {
        if (this.bpE) {
            this.kDm = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.kzD.getPbData() != null && this.kzD.getPbData().cVl() != null && this.kzD.getPbData().cVl().bek() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.kzD.getPbData().cVl().bek().getThreadId(), this.kzD.getPbData().cVl().bek().getTaskId(), this.kzD.getPbData().cVl().bek().getForumId(), this.kzD.getPbData().cVl().bek().getForumName(), this.kzD.getPbData().cVl().bez(), this.kzD.getPbData().cVl().beA())));
            this.kCY = true;
            this.kCV.finish();
        }
    }

    public String cXY() {
        return this.kDk;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cXZ() {
        return this.kDv;
    }

    public void sX(boolean z) {
        this.kDl = z;
    }

    public boolean bcm() {
        if (this.kzD != null) {
            return this.kzD.cYE();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYa() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.zz(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.kDR).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.kDR.getPageActivity(), 2, true, 4);
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
        aVar.b(this.kDR).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cd(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kDR != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDR.getPageActivity());
            aVar.zz(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kDR).bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.kDz.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDR.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.zz(this.kDR.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zz(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.kDz.showLoadingDialog();
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
        aVar.b(this.kDR).bhg();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.NM(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.iwx) {
            this.iwx = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.kDz != null) {
                this.kDz.onConfigurationChanged(configuration);
            }
            if (this.kDD != null) {
                this.kDD.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cYb() {
        if (this.kzD != null) {
            return this.kzD.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.kzD.getPbData().cVz().kyo;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dwC().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dwC().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dwC().remove(i2);
                    list.get(i).dwE();
                    z = true;
                    break;
                }
            }
            list.get(i).QN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.kzD.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.cWh().getId();
        List<PostData> list = this.kzD.getPbData().cVz().kyo;
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
                ArrayList<PostData> cWl = pVar.cWl();
                postData.HO(pVar.getTotalCount());
                if (postData.dwC() != null) {
                    postData.dwC().clear();
                    postData.dwC().addAll(cWl);
                }
            }
        }
        if (!this.kzD.getIsFromMark()) {
            this.kDz.s(this.kzD.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cWs() {
        return this.kCV.cWs();
    }

    public boolean cWt() {
        if (this.kzD == null) {
            return false;
        }
        return this.kzD.cWt();
    }

    public void sY(boolean z) {
        this.kDj = z;
    }

    public boolean cYc() {
        return this.kDj;
    }

    public void cYd() {
        if (this.kDz != null) {
            this.kDz.dam();
            cms();
        }
    }

    public PostData cVu() {
        return this.kDz.b(this.kzD.kAA, this.kzD.cYD());
    }

    public void onBackPressed() {
        if (this.kEa != null && !this.kEa.isEmpty()) {
            int size = this.kEa.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.kEa.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.kEa == null) {
                this.kEa = new ArrayList();
            }
            if (!this.kEa.contains(aVar)) {
                this.kEa.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.kEa == null) {
                this.kEa = new ArrayList();
            }
            if (!this.kEa.contains(aVar)) {
                this.kEa.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.kEa != null) {
            this.kEa.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYe() {
        if (this.kzD != null && !com.baidu.tbadk.core.util.at.isEmpty(this.kzD.cYB())) {
            com.baidu.tbadk.BdToken.c.aYs().p(com.baidu.tbadk.BdToken.b.dNF, com.baidu.adp.lib.f.b.toLong(this.kzD.cYB(), 0L));
        }
    }

    public bf cYf() {
        return this.kDt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ny(String str) {
        if (this.kzD != null && this.kzD.getPbData() != null && this.kzD.getPbData().cVl() != null && this.kzD.getPbData().cVl().bdo()) {
            bw cVl = this.kzD.getPbData().cVl();
            int i = 0;
            if (cVl.bdm()) {
                i = 1;
            } else if (cVl.bdn()) {
                i = 2;
            } else if (cVl.bgz()) {
                i = 3;
            } else if (cVl.bgA()) {
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
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.cXC(), i2, PbFragment.this.kzD);
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
    public PbFragment cYg() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cYh() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cYi() {
        return this.kCV;
    }
}
