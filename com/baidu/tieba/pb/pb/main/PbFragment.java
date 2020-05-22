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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
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
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
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
/* loaded from: classes9.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0697a {
    private com.baidu.adp.lib.d.b<TbImageView> dXO;
    private LikeModel dYI;
    private com.baidu.adp.lib.d.b<ImageView> eBr;
    private com.baidu.adp.lib.d.b<GifView> eBs;
    private com.baidu.adp.lib.d.b<TextView> eEf;
    private com.baidu.adp.lib.d.b<View> eEg;
    private com.baidu.adp.lib.d.b<LinearLayout> eEh;
    private com.baidu.adp.lib.d.b<RelativeLayout> eEi;
    private az hQO;
    private VoiceManager hnh;
    private com.baidu.tieba.frs.profession.permission.c hqP;
    private com.baidu.tieba.f.b hrk;
    public com.baidu.tbadk.core.util.aj iPP;
    private String jGL;
    private PbActivity jJW;
    private com.baidu.tieba.pb.pb.main.b.b jJY;
    public ax jKD;
    private com.baidu.tbadk.core.dialog.i jKE;
    private com.baidu.tbadk.core.dialog.k jKF;
    private boolean jKG;
    private com.baidu.tieba.tbadkCore.data.f jKK;
    private com.baidu.tbadk.editortools.pb.g jKL;
    private com.baidu.tbadk.editortools.pb.e jKM;
    private com.baidu.tieba.frs.profession.permission.c jKO;
    private EmotionImageData jKP;
    private com.baidu.adp.base.e jKS;
    private com.baidu.tbadk.core.view.c jKT;
    private BdUniqueId jKU;
    private Runnable jKV;
    private com.baidu.adp.widget.ImageView.a jKW;
    private String jKX;
    private TbRichTextMemeInfo jKY;
    private com.baidu.tieba.pb.pb.main.emotion.model.a jKn;
    private View jKo;
    int jKq;
    private com.baidu.tbadk.core.data.ay jKt;
    private com.baidu.tieba.pb.pb.report.a jKw;
    private boolean jLD;
    private String jLN;
    private com.baidu.tbadk.core.data.o jLO;
    private List<a> jLb;
    public String jLd;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a jLK = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.f.b.a
        public void bZ(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cDm();
            } else {
                com.baidu.tieba.pb.a.b.cDl();
            }
        }
    };
    private boolean jJX = false;
    private boolean jJZ = false;
    private boolean beu = false;
    private boolean jiP = false;
    private boolean jKa = true;
    private int jKb = 0;
    private com.baidu.tbadk.core.dialog.b jKc = null;
    private long gPK = -1;
    private long esg = 0;
    private long jKd = 0;
    private long createTime = 0;
    private long erW = 0;
    private boolean jKe = false;
    private com.baidu.tbadk.n.b jKf = null;
    private long jKg = 0;
    private boolean jKh = false;
    private long jKi = 0;
    private int hOp = 1;
    private String emL = null;
    private boolean jKj = false;
    private boolean isFullScreen = false;
    private String jKk = "";
    private boolean jKl = true;
    private boolean jKm = false;
    private String source = "";
    private int mSkinType = 3;
    int[] jKp = new int[2];
    private int jKr = -1;
    private int jKs = -1;
    public BdUniqueId jKu = BdUniqueId.gen();
    private PbInterviewStatusView.a jKv = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.jKz.rT(!PbFragment.this.jKl);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.jGP != null && PbFragment.this.jGP.aML()) {
                        PbFragment.this.cEH();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel jGP = null;
    private com.baidu.tbadk.baseEditMark.a jKx = null;
    private ForumManageModel gEV = null;
    private com.baidu.tbadk.coreExtra.model.a dNL = null;
    private com.baidu.tieba.pb.data.o jKy = null;
    private ShareSuccessReplyToServerModel hDS = null;
    private av jKz = null;
    private boolean jKA = false;
    private boolean jKB = false;
    private boolean jKC = false;
    private boolean eSG = false;
    private boolean jKH = false;
    private boolean jKI = false;
    private boolean jKJ = false;
    private boolean jKN = false;
    public boolean jKQ = false;
    private com.baidu.tbadk.editortools.pb.c emO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bdu() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b emP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdt() {
            if (PbFragment.this.jKD == null || PbFragment.this.jKD.cIt() == null || !PbFragment.this.jKD.cIt().dmi()) {
                return !PbFragment.this.Af(com.baidu.tbadk.core.util.aj.dNG);
            }
            PbFragment.this.showToast(PbFragment.this.jKD.cIt().dmk());
            if (PbFragment.this.jKM != null && (PbFragment.this.jKM.bdJ() || PbFragment.this.jKM.bdK())) {
                PbFragment.this.jKM.a(false, PbFragment.this.jKD.cIw());
            }
            PbFragment.this.jKD.sf(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b jKR = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdt() {
            if (PbFragment.this.jKD == null || PbFragment.this.jKD.cIu() == null || !PbFragment.this.jKD.cIu().dmi()) {
                return !PbFragment.this.Af(com.baidu.tbadk.core.util.aj.dNH);
            }
            PbFragment.this.showToast(PbFragment.this.jKD.cIu().dmk());
            if (PbFragment.this.jKz != null && PbFragment.this.jKz.cHe() != null && PbFragment.this.jKz.cHe().cEi() != null && PbFragment.this.jKz.cHe().cEi().bdK()) {
                PbFragment.this.jKz.cHe().cEi().a(PbFragment.this.jKD.cIw());
            }
            PbFragment.this.jKD.sg(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean hnT = false;
    private int jKZ = 0;
    private int jLa = -1;
    public int jLc = 0;
    private final a jLe = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.jKz != null && PbFragment.this.jKz.cHe() != null) {
                t cHe = PbFragment.this.jKz.cHe();
                if (cHe.cEg()) {
                    cHe.cEf();
                    return true;
                }
            }
            if (PbFragment.this.jKz != null && PbFragment.this.jKz.cIc()) {
                PbFragment.this.jKz.cId();
                return true;
            }
            return false;
        }
    };
    private final ae.a jLf = new ae.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void aN(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.jKz.showToast(str);
            }
        }
    };
    private final CustomMessageListener jLg = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jGP != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.jKM != null) {
                    PbFragment.this.jKz.rY(PbFragment.this.jKM.bdC());
                }
                PbFragment.this.jKz.cHg();
                PbFragment.this.jKz.cHU();
            }
        }
    };
    CustomMessageListener hoy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbFragment.this.jGP.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbFragment.this.jKz != null && PbFragment.this.jGP != null) {
                    PbFragment.this.jKz.b(PbFragment.this.jGP.getPbData(), PbFragment.this.jGP.cFv(), PbFragment.this.jGP.cFS(), PbFragment.this.jKz.getSkinType());
                }
                if (PbFragment.this.jKz != null && PbFragment.this.jKz.cHx() != null) {
                    PbFragment.this.jKz.cHx().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener jLh = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.jKz != null) {
                    if (booleanValue) {
                        PbFragment.this.jKz.cnI();
                    } else {
                        PbFragment.this.jKz.cnH();
                    }
                }
            }
        }
    };
    private CustomMessageListener jLi = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.jKM != null) {
                    PbFragment.this.jKz.rY(PbFragment.this.jKM.bdC());
                }
                PbFragment.this.jKz.sa(false);
            }
        }
    };
    private CustomMessageListener jLj = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.n) eVar.getData());
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
    private CustomMessageListener jLk = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jKz != null && PbFragment.this.jKz.cHx() != null) {
                PbFragment.this.jKz.cHx().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener itM = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener hov = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.beu) {
                PbFragment.this.cEY();
            }
        }
    };
    private View.OnClickListener eny = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.emL);
        }
    };
    private CustomMessageListener jLl = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                aq.a aVar = new aq.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jGP.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.jGP.cFJ() != null && PbFragment.this.jGP.cFJ().getUserIdLong() == aaVar.toUserId) {
                        PbFragment.this.jKz.a(aaVar.sendCount, PbFragment.this.jGP.getPbData(), PbFragment.this.jGP.cFv(), PbFragment.this.jGP.cFS());
                    }
                    if (pbData.cCk() != null && pbData.cCk().size() >= 1 && pbData.cCk().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cCk().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.jGP.cFt(), 0L);
                        if (j == aaVar.postId && j2 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.aq ddC = pbData.cCk().get(0).ddC();
                            if (ddC == null) {
                                ddC = new com.baidu.tbadk.core.data.aq();
                            }
                            ArrayList<aq.a> aPv = ddC.aPv();
                            if (aPv == null) {
                                aPv = new ArrayList<>();
                            }
                            aPv.add(0, aVar);
                            ddC.setTotal(aaVar.sendCount + ddC.getTotal());
                            ddC.w(aPv);
                            pbData.cCk().get(0).a(ddC);
                            PbFragment.this.jKz.cHx().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hEY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                PbFragment.this.Jj((String) customResponsedMessage.getData());
                PbFragment.this.jGP.cFO();
                if (PbFragment.this.jKz.cHx() != null) {
                    PbFragment.this.jKz.r(PbFragment.this.jGP.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a jLm = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cIM()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a jLn = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aN(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.jKz != null) {
                PbFragment.this.jKz.dY(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean jLo = false;
    private PraiseModel jLp = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void An(String str) {
            PbFragment.this.jLo = false;
            if (PbFragment.this.jLp != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jGP.getPbData();
                if (pbData.cCi().aQi().getIsLike() == 1) {
                    PbFragment.this.uQ(0);
                } else {
                    PbFragment.this.uQ(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cCi()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.jLo = false;
            if (PbFragment.this.jLp != null && str != null) {
                if (AntiHelper.bv(i, str)) {
                    AntiHelper.aX(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a jLq = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void rz(boolean z) {
            PbFragment.this.ry(z);
            if (PbFragment.this.jKz.cIi() != null && z) {
                PbFragment.this.jKz.rT(false);
            }
            PbFragment.this.jKz.rV(z);
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().ecK != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().ecK, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cCr().aQx() != null && PbFragment.this.cCr().aQx().getGodUserData() != null) {
                            PbFragment.this.cCr().aQx().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().aQx() != null) {
                            PbFragment.this.jGP.getPbData().cCi().aQx().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h hmn = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.jJW.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a jLr = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.jKz.bGf();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.Ah(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.cdR();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c efF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cEr();
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
                        if (PbFragment.this.cB(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.jKz.cEp() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").dh("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cDn() != null && PbFragment.this.cDn().gWJ != null) {
                                PbFragment.this.cDn().gWJ.onClick(view);
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
                if (PbFragment.this.jKM != null) {
                    PbFragment.this.jKz.rY(PbFragment.this.jKM.bdC());
                }
                PbFragment.this.jKz.cHg();
                PbFragment.this.jKz.cHU();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener jLs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jKU) {
                PbFragment.this.jKz.bGf();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.jGP.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cCy().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.jKT.showSuccessToast(PbFragment.this.jKS.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.jKS.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.yo(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cEV();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.jKS.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.jKT.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jLt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jKU) {
                PbFragment.this.jKz.bGf();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.jKT.showSuccessToast(PbFragment.this.jKS.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.jKS.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.jKT.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener jLu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.jKU) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.jKz.bGf();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.lzt;
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
                    PbFragment.this.jKz.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener jLv = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.jKz.cHh() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cEr();
            }
        }
    };
    private CustomMessageListener hoG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.hnT = true;
                }
            }
        }
    };
    public a.b jtS = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bVo();
            com.baidu.tbadk.core.data.ao pageData = PbFragment.this.jGP.getPageData();
            int pageNum = PbFragment.this.jKz.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aPo()) {
                PbFragment.this.jKz.cHU();
                PbFragment.this.bVn();
                PbFragment.this.jKz.cHB();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.jGP.Al(PbFragment.this.jKz.getPageNum());
                    if (PbFragment.this.jJY != null) {
                        PbFragment.this.jJY.showFloatingView();
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
    public final View.OnClickListener hpu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        /* JADX WARN: Removed duplicated region for block: B:648:0x1d64  */
        /* JADX WARN: Removed duplicated region for block: B:651:0x1dab  */
        /* JADX WARN: Removed duplicated region for block: B:668:0x1fb9  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            com.baidu.tieba.pb.data.e pbData;
            boolean z;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            int i;
            int i2;
            bp bpVar;
            String[] strArr;
            boolean w;
            String name;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.jKz.cHQ()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.jGP.rE(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.jKz.cHC();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGH()) {
                        if (view == PbFragment.this.jKz.jRd.eun) {
                            if (PbFragment.this.jKz.rX(PbFragment.this.jGP.cFA())) {
                                PbFragment.this.bVn();
                                return;
                            }
                            PbFragment.this.jKa = false;
                            PbFragment.this.jJZ = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.jJW, PbFragment.this.jKz.jRd.eun);
                            PbFragment.this.jJW.finish();
                        } else if (view != PbFragment.this.jKz.cHz() && (PbFragment.this.jKz.jRd.cIZ() == null || (view != PbFragment.this.jKz.jRd.cIZ().cGG() && view != PbFragment.this.jKz.jRd.cIZ().cGE()))) {
                            if (view == PbFragment.this.jKz.cHY()) {
                                if (PbFragment.this.jGP != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jGP.getPbData().cCi().aQw().getLink());
                                }
                            } else if (view != PbFragment.this.jKz.jRd.jXv) {
                                if (view == PbFragment.this.jKz.jRd.jXw) {
                                    if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                        ArrayList<PostData> cCk = PbFragment.this.jGP.getPbData().cCk();
                                        if ((cCk == null || cCk.size() <= 0) && PbFragment.this.jGP.cFv()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").dh("tid", PbFragment.this.jGP.cFt()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", PbFragment.this.jGP.getForumId()));
                                        if (!PbFragment.this.jKz.cIn()) {
                                            PbFragment.this.jKz.cHg();
                                        }
                                        PbFragment.this.cEz();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.jKz.rn(true);
                                        PbFragment.this.jKz.cHg();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.jKz.cnI();
                                            PbFragment.this.bVn();
                                            PbFragment.this.jKz.cHB();
                                            PbFragment.this.jGP.Jq(PbFragment.this.cEL());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGD()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.jKz.jRd.cIZ() != null && view == PbFragment.this.jKz.jRd.cIZ().cGC()) {
                                            PbFragment.this.jKz.jRd.aEa();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGA()) {
                                                if ((PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGJ()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGB()) {
                                                        if (PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGK()) {
                                                            if (PbFragment.this.jKz.cIi() == view) {
                                                                if (PbFragment.this.jKz.cIi().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.jGP.getPbData();
                                                                    if (pbData2 != null && pbData2.cCi() != null && pbData2.cCi().aQd() != null) {
                                                                        String aPU = pbData2.cCi().aQd().aPU();
                                                                        if (StringUtils.isNull(aPU)) {
                                                                            aPU = pbData2.cCi().aQd().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").dh("obj_id", aPU));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.fr("c10725", null);
                                                                }
                                                                PbFragment.this.cES();
                                                            } else if (PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGI()) {
                                                                if (PbFragment.this.jKz.jRd.cIZ() != null && view == PbFragment.this.jKz.jRd.cIZ().cGF()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.jKz.b(PbFragment.this.jGP.getPbData(), PbFragment.this.jGP.cFv(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.jKz.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.jKz.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.jKz.jRd.aEa();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.dh("tid", PbFragment.this.jGP.cFt());
                                                                        anVar.dh("fid", PbFragment.this.jGP.getForumId());
                                                                        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.ag("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                                                            PbFragment.this.jKz.cHU();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.ddG() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.llH != null) {
                                                                                    com.baidu.tbadk.core.util.an aUR = postData.llH.aUR();
                                                                                    aUR.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aUR.ag("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aUR.ag("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aUR);
                                                                                }
                                                                                String cFt = PbFragment.this.jGP.cFt();
                                                                                String id = postData.getId();
                                                                                int i3 = 0;
                                                                                if (PbFragment.this.jGP.getPbData() != null) {
                                                                                    i3 = PbFragment.this.jGP.getPbData().cCx();
                                                                                }
                                                                                PbFragment.this.bVn();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a Jo = PbFragment.this.Jo(id);
                                                                                    if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && Jo != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cFt, id, "pb", true, null, true, null, i3, postData.cJX(), PbFragment.this.jGP.getPbData().getAnti(), false, postData.aQx().getIconInfo()).addBigImageData(Jo.jGX, Jo.jGY, Jo.jGZ, Jo.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.jGP.cGd());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.jGP.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.jGP.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.jGP.cFC());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a Jo2 = PbFragment.this.Jo(id);
                                                                                    if (postData != null && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && Jo2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cFt, id, "pb", true, null, false, null, i3, postData.cJX(), PbFragment.this.jGP.getPbData().getAnti(), false, postData.aQx().getIconInfo()).addBigImageData(Jo2.jGX, Jo2.jGY, Jo2.jGZ, Jo2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.jGP.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.jGP.cFC());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.jGP.cGd());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.jGP.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").ag("obj_locate", 3).dh("fid", PbFragment.this.jGP.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.jGP != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.dh("tid", PbFragment.this.jGP.cFt());
                                                                        anVar2.dh("fid", PbFragment.this.jGP.getForumId());
                                                                        anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.ag("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.llH != null) {
                                                                                    com.baidu.tbadk.core.util.an aUR2 = postData2.llH.aUR();
                                                                                    aUR2.delete("obj_locate");
                                                                                    aUR2.ag("obj_locate", 8);
                                                                                    TiebaStatic.log(aUR2);
                                                                                }
                                                                                if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                                                                    String cFt2 = PbFragment.this.jGP.cFt();
                                                                                    String id2 = postData2.getId();
                                                                                    int i4 = 0;
                                                                                    if (PbFragment.this.jGP.getPbData() != null) {
                                                                                        i4 = PbFragment.this.jGP.getPbData().cCx();
                                                                                    }
                                                                                    PbActivity.a Jo3 = PbFragment.this.Jo(id2);
                                                                                    if (Jo3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cFt2, id2, "pb", true, null, false, null, i4, postData2.cJX(), PbFragment.this.jGP.getPbData().getAnti(), false, postData2.aQx().getIconInfo()).addBigImageData(Jo3.jGX, Jo3.jGY, Jo3.jGZ, Jo3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.jGP.cGd());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.jGP.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.jGP.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.jGP.cFC());
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
                                                                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img) {
                                                                    if (PbFragment.this.jGP != null) {
                                                                        if (view.getId() == R.id.pb_post_reply) {
                                                                            com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                            anVar3.dh("tid", PbFragment.this.jGP.cFt());
                                                                            anVar3.dh("fid", PbFragment.this.jGP.getForumId());
                                                                            anVar3.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            anVar3.ag("obj_locate", 6);
                                                                            TiebaStatic.log(anVar3);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (view.getId() == R.id.pb_post_reply && postData3.llH != null) {
                                                                                    com.baidu.tbadk.core.util.an aUR3 = postData3.llH.aUR();
                                                                                    aUR3.delete("obj_locate");
                                                                                    aUR3.ag("obj_locate", 8);
                                                                                    TiebaStatic.log(aUR3);
                                                                                } else if (view.getId() == R.id.post_info_commont_img) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13700").dh("tid", PbFragment.this.jGP.cFu()).dh("fid", PbFragment.this.jGP.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData3.getId()).ag("obj_type", 3));
                                                                                }
                                                                                if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.cEo().cHd() != null && postData3.aQx() != null && postData3.ddu() != 1) {
                                                                                    if (PbFragment.this.cEo().cHe() != null) {
                                                                                        PbFragment.this.cEo().cHe().cEe();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                                                                    nVar.a(PbFragment.this.jGP.getPbData().getForum());
                                                                                    nVar.setThreadData(PbFragment.this.jGP.getPbData().cCi());
                                                                                    nVar.g(postData3);
                                                                                    PbFragment.this.cEo().cHd().d(nVar);
                                                                                    PbFragment.this.cEo().cHd().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.aQx().getUserId(), "");
                                                                                    if (PbFragment.this.jKM != null) {
                                                                                        PbFragment.this.jKz.rY(PbFragment.this.jKM.bdC());
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
                                                                } else if (view != PbFragment.this.jKz.cDI()) {
                                                                    if (view == PbFragment.this.jKz.jRd.cJa()) {
                                                                        PbFragment.this.jKz.cHI();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (bpVar = (bp) view.getTag()) != null && !StringUtils.isNull(bpVar.aSL())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                com.baidu.tbadk.core.util.ba.aUZ().b(PbFragment.this.getPageContext(), new String[]{bpVar.aSL()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").dh("tid", PbFragment.this.jGP.jNm));
                                                                                    }
                                                                                    if (PbFragment.this.jKF == null) {
                                                                                        PbFragment.this.jKF = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.jKF.a(PbFragment.this.jLJ);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cD(view);
                                                                                    if (!PbFragment.this.cD(view) || PbFragment.this.jKW == null || !PbFragment.this.jKW.isGif()) {
                                                                                    }
                                                                                    boolean z2 = false;
                                                                                    boolean z3 = false;
                                                                                    boolean z4 = false;
                                                                                    boolean z5 = false;
                                                                                    boolean z6 = false;
                                                                                    String str = null;
                                                                                    if (sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                        ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                        z2 = ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                        z4 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                        z6 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                                                                        str = (String) sparseArray4.get(R.id.tag_forbid_user_post_id);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.ddw() != null && postData4.ddw().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.jKF);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar4.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar4);
                                                                                        }
                                                                                        PbFragment.this.ihL = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.jGP.getPbData().aML()) {
                                                                                        String aMK = PbFragment.this.jGP.getPbData().aMK();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aMK) && aMK.equals(postData4.getId())) {
                                                                                            z = true;
                                                                                            if (!z) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.jKF);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.jKF);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.ihL);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z4 && z3) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.jKF);
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
                                                                                                    arrayList.add(gVar5);
                                                                                                } else {
                                                                                                    if (PbFragment.this.ru(z2) && TbadkCoreApplication.isLogin()) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.jKF);
                                                                                                        gVar6.mTextView.setTag(str);
                                                                                                        arrayList.add(gVar6);
                                                                                                    }
                                                                                                }
                                                                                                if (z4) {
                                                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                                                    sparseArray8.put(R.id.tag_should_manage_visible, true);
                                                                                                    sparseArray8.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name, sparseArray4.get(R.id.tag_forbid_user_name));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name_show, sparseArray4.get(R.id.tag_forbid_user_name_show));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_portrait, sparseArray4.get(R.id.tag_forbid_user_portrait));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_post_id, str);
                                                                                                    if (z5) {
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
                                                                                                    if (z6) {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                        sparseArray8.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                        sparseArray8.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jKF);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.jKF);
                                                                                                    gVar3.mTextView.setTag(sparseArray8);
                                                                                                } else if (!z6) {
                                                                                                    gVar2 = null;
                                                                                                    gVar3 = null;
                                                                                                } else {
                                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                                    sparseArray9.put(R.id.tag_should_manage_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                    sparseArray9.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                    sparseArray9.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                    sparseArray9.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                    if (PbFragment.this.jGP.getPbData().cCx() == 1002 && !z2) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.jKF);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jKF);
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
                                                                                            PbFragment.this.jKF.aD(arrayList);
                                                                                            PbFragment.this.jKE = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jKF);
                                                                                            PbFragment.this.jKE.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (!z) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.ihL);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.jKF.aD(arrayList);
                                                                                    PbFragment.this.jKE = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jKF);
                                                                                    PbFragment.this.jKE.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.jGP.getPbData().cCi().getActUrl());
                                                                                if (PbFragment.this.jGP.getPbData().cCi().aRl() != 1) {
                                                                                    if (PbFragment.this.jGP.getPbData().cCi().aRl() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").dh("fid", PbFragment.this.jGP.getPbData().getForumId()).dh("tid", PbFragment.this.jGP.getPbData().getThreadId()).dh("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.jGP.getPbData().getThreadId().equals(str2)) {
                                                                                    PbFragment.this.jKz.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.jKz.cHg();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cEx() == 1 && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").dh("fid", PbFragment.this.jGP.getPbData().getForumId()).dh("tid", PbFragment.this.jGP.getPbData().getThreadId()).dh("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cEx() == 1 && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").dh("fid", PbFragment.this.jGP.getPbData().getForumId()).dh("tid", PbFragment.this.jGP.getPbData().getThreadId()).dh("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.cEN();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cEO();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCD() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.jGP.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").dh("fid", pbData3.getForumId()));
                                                                                com.baidu.tbadk.core.util.ba.aUZ().b(PbFragment.this.getPageContext(), new String[]{pbData3.cCD().cCO()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCD() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.jGP.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").dh("fid", pbData4.getForumId()));
                                                                                com.baidu.tbadk.core.util.ba.aUZ().b(PbFragment.this.getPageContext(), new String[]{pbData4.cCD().cCO()});
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.jKZ >= 0) {
                                                                                if (PbFragment.this.jGP != null) {
                                                                                    PbFragment.this.jGP.cGe();
                                                                                }
                                                                                if (PbFragment.this.jGP != null && PbFragment.this.jKz.cHx() != null) {
                                                                                    PbFragment.this.jKz.cHx().a(PbFragment.this.jGP.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.jKZ = 0;
                                                                                if (PbFragment.this.jGP != null) {
                                                                                    PbFragment.this.jKz.getListView().setSelection(PbFragment.this.jGP.cGh());
                                                                                    PbFragment.this.jGP.cD(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cEu();
                                                                        } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbFragment.this.d(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                            if (PbFragment.this.jKz.getListView() != null && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.jKz.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.jKz.getListView().getChildAt(0);
                                                                                int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                boolean aWi = PbFragment.this.jGP.getPbData().aWi();
                                                                                boolean z7 = PbFragment.this.jKz.cHf() != null && PbFragment.this.jKz.cHf().bxC();
                                                                                boolean cHR = PbFragment.this.jKz.cHR();
                                                                                boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                int i5 = 0;
                                                                                if (aWi && PbFragment.this.jKz.cHf() != null && PbFragment.this.jKz.cHf().brc() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.jKz.cHf().cIJ();
                                                                                    z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.jKz.cHf().brc().getHeight() - PbFragment.this.jKz.cHf().cIJ());
                                                                                    i5 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.Jp("c13568");
                                                                                if ((PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().aQo() <= 0) || (cHR && z8)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cEu();
                                                                                        if (PbFragment.this.jGP.getPbData().cCi().aQx() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", PbFragment.this.jGP.jNm).dh("fid", PbFragment.this.jGP.getPbData().getForumId()).ag("obj_locate", 2).dh("uid", PbFragment.this.jGP.getPbData().cCi().aQx().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z9 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (aWi) {
                                                                                        if (PbFragment.this.jKz.jSn != null && PbFragment.this.jKz.jSn.jTr != null && PbFragment.this.jKz.jSn.jTr.getView() != null) {
                                                                                            if (PbFragment.this.jKz.jSn.jTr.getView().getParent() == null) {
                                                                                                z9 = firstVisiblePosition >= PbFragment.this.cED();
                                                                                            } else {
                                                                                                int i6 = 0;
                                                                                                if (PbFragment.this.jKz.cHf() != null && PbFragment.this.jKz.cHf().brc() != null) {
                                                                                                    i6 = PbFragment.this.jKz.cHf().brc().getBottom();
                                                                                                }
                                                                                                z9 = PbFragment.this.jKz.jSn.jTr.getView().getTop() <= i6;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.jKz.cHo() != null) {
                                                                                        z9 = PbFragment.this.jKz.cHo().getVisibility() == 0;
                                                                                        if (!z9 && PbFragment.this.jKz.jSn != null && PbFragment.this.jKz.jSn.jTr != null && PbFragment.this.jKz.jSn.jTr.getView() != null && PbFragment.this.jKz.jSn.jTr.getView().getParent() != null && PbFragment.this.jKz.jRd != null && PbFragment.this.jKz.jRd.mNavigationBar != null) {
                                                                                            z9 = PbFragment.this.jKz.jSn.jTr.getView().getTop() - PbFragment.this.jKz.jRd.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z9 || cHR) {
                                                                                        PbFragment.this.jKr = firstVisiblePosition;
                                                                                        PbFragment.this.jKs = top2;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                            PbFragment.this.jKz.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                            PbFragment.this.jKz.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.jKz.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.jKr > 0) {
                                                                                        if (PbFragment.this.jKz.getListView().getChildAt(PbFragment.this.jKr) != null) {
                                                                                            PbFragment.this.jKz.getListView().smoothScrollToPosition(PbFragment.this.jKr, PbFragment.this.jKs, 200);
                                                                                        } else {
                                                                                            PbFragment.this.jKz.getListView().setSelectionFromTop(PbFragment.this.jKr, PbFragment.this.jKs + equipmentHeight);
                                                                                            PbFragment.this.jKz.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cED = PbFragment.this.cED();
                                                                                        if (PbFragment.this.cEC() != -1) {
                                                                                            cED--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cED < 0) {
                                                                                            i = PbFragment.this.jKz.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.jKz.getListView().getData()) - 1);
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i = cED;
                                                                                            i2 = dimens;
                                                                                        }
                                                                                        if (z7) {
                                                                                            i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!aWi || PbFragment.this.jKz.cHf() == null) {
                                                                                            if (PbFragment.this.jKz.jRd != null && PbFragment.this.jKz.jRd.mNavigationBar != null) {
                                                                                                i2 += PbFragment.this.jKz.jRd.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i2 += PbFragment.this.jKz.cHf().cII();
                                                                                        }
                                                                                        if (PbFragment.this.jKz.jSn == null || PbFragment.this.jKz.jSn.jTr == null || PbFragment.this.jKz.jSn.jTr.getView() == null || PbFragment.this.jKz.jSn.jTr.getView().getParent() == null) {
                                                                                            PbFragment.this.jKz.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                            PbFragment.this.jKz.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z7) {
                                                                                            PbFragment.this.jKz.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                        } else {
                                                                                            PbFragment.this.jKz.getListView().smoothScrollBy(PbFragment.this.jKz.jSn.jTr.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().aQx() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", PbFragment.this.jGP.jNm).dh("fid", PbFragment.this.jGP.getPbData().getForumId()).ag("obj_locate", 2).dh("uid", PbFragment.this.jGP.getPbData().cCi().aQx().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.jGP.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.jGP.cGd() == 3) {
                                                                                    PbFragment.this.jJW.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.jGP.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.dh("tid", PbFragment.this.jGP.cFt());
                                                                                anVar4.dh("fid", PbFragment.this.jGP.getForumId());
                                                                                anVar4.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                if (PbFragment.this.jGP.getPbData().cCi() != null) {
                                                                                    anVar4.dh("nid", PbFragment.this.jGP.getPbData().cCi().getNid());
                                                                                }
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                            if (view.getTag() instanceof bk) {
                                                                                bk bkVar = (bk) view.getTag();
                                                                                if (PbFragment.this.jGP.cGd() == 3 && PbFragment.this.cDo() && PbFragment.this.jGP.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.jGP.getPbData().cCE())) {
                                                                                    PbFragment.this.jJW.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bkVar.aQC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.dh("tid", bkVar.getId());
                                                                                anVar5.s("fid", bkVar.getFid());
                                                                                anVar5.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar5.dh("nid", bkVar.getNid());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbFragment.this.jGP != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.dh("tid", PbFragment.this.jGP.cFt());
                                                                                anVar6.dh("fid", PbFragment.this.jGP.getForumId());
                                                                                anVar6.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.ag("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.jGP.getPbData();
                                                                                if (PbFragment.this.jKy == null) {
                                                                                    PbFragment.this.jKy = new com.baidu.tieba.pb.data.o(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").s("forum_id", j2).aUS();
                                                                                PbFragment.this.registerListener(PbFragment.this.jLy);
                                                                                PbFragment.this.jKy.F(j, j2);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").dh("fid", PbFragment.this.jGP.getForumId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).dh("obj_source", "PB_card").dh("tid", PbFragment.this.jGP.cFt()).ag("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bk) {
                                                                                bk bkVar2 = (bk) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bkVar2.aQC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").dh("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 9).ag("obj_locate", 9).s("obj_id", bkVar2.getFid()).dh("tid", bkVar2.getId()).ag("thread_type", bkVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bk) && PbFragment.this.checkUpIsLogin()) {
                                                                                bk bkVar3 = (bk) view.getTag();
                                                                                if (PbFragment.this.dYI != null) {
                                                                                    PbFragment.this.dYI.fq(bkVar3.aQC(), String.valueOf(bkVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").dh("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 10).ag("obj_locate", 11).s("obj_id", bkVar3.getFid()).dh("tid", bkVar3.getId()).ag("thread_type", bkVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.jGP.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.jGP.cFt(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.jGP.getPbData().cCi().aQT())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.jKz.cHU();
                                                                SparseArray<Object> b3 = PbFragment.this.jKz.b(PbFragment.this.jGP.getPbData(), PbFragment.this.jGP.cFv(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jGP.getPbData().getForum().getId(), PbFragment.this.jGP.getPbData().getForum().getName(), PbFragment.this.jGP.getPbData().cCi().getId(), String.valueOf(PbFragment.this.jGP.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.y(true, false);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 0).ag("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 1).ag("obj_source", 1));
                                                            }
                                                            PbFragment.this.jKz.jRd.cIY();
                                                        }
                                                    } else if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCi() != null) {
                                                        PbFragment.this.jKz.jRd.aEa();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.Jl(PbFragment.this.jGP.getPbData().cCi().aQP());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.jKz.cHU();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.jGP.cFM()));
                                                            return;
                                                        }
                                                        PbFragment.this.bVn();
                                                        PbFragment.this.jKz.cHB();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.jGP.getPbData().jDV == null || PbFragment.this.jGP.getPbData().jDV.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.jGP.getPbData().jDV.size()];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int i8 = i7;
                                                                if (i8 >= PbFragment.this.jGP.getPbData().jDV.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i8] = PbFragment.this.jGP.getPbData().jDV.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i7 = i8 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                int i10 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.jGP.getSortType() == 1 && i9 == 1) {
                                                                    i10 = 0;
                                                                } else if (PbFragment.this.jGP.getSortType() == 2 && i9 == 0) {
                                                                    i10 = 1;
                                                                } else if (PbFragment.this.jGP.getSortType() != 3 || i9 == 2) {
                                                                    i10 = (i9 != 2 || PbFragment.this.jGP.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").ag("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ag("obj_type", i10));
                                                                if (PbFragment.this.jGP.getPbData().jDV != null && PbFragment.this.jGP.getPbData().jDV.size() > i9) {
                                                                    i9 = PbFragment.this.jGP.getPbData().jDV.get(i9).sort_type.intValue();
                                                                }
                                                                boolean Aq = PbFragment.this.jGP.Aq(i9);
                                                                view.setTag(Integer.valueOf(PbFragment.this.jGP.cFM()));
                                                                if (Aq) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.jKz.rO(true);
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
                                                PbFragment.this.jKz.cHU();
                                                if (PbFragment.this.cDy().getPbData().jDW != 2) {
                                                    if (PbFragment.this.jGP.getPageData() != null) {
                                                        PbFragment.this.jKz.a(PbFragment.this.jGP.getPageData(), PbFragment.this.jtS);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.jGP.getPbData()) != null) {
                                            bk cCi = pbData.cCi();
                                            if (cCi != null && cCi.aQx() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", PbFragment.this.jGP.jNm).dh("fid", pbData.getForumId()).ag("obj_locate", 4).dh("uid", cCi.aQx().getUserId()));
                                            }
                                            int i9 = 1;
                                            if (cCi != null) {
                                                if (cCi.aPm()) {
                                                    i9 = 2;
                                                } else if (cCi.aPn()) {
                                                    i9 = 3;
                                                } else if (cCi.aSv()) {
                                                    i9 = 4;
                                                } else if (cCi.aSw()) {
                                                    i9 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.dh("tid", PbFragment.this.jGP.cFt());
                                            anVar7.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.dh("fid", PbFragment.this.jGP.getForumId());
                                            if (view.getId() == R.id.share_num_container) {
                                                anVar7.ag("obj_locate", 5);
                                            } else {
                                                anVar7.ag("obj_locate", 6);
                                            }
                                            anVar7.ag("obj_name", i9);
                                            anVar7.ag("obj_type", 1);
                                            if (cCi != null) {
                                                if (cCi.aPm()) {
                                                    anVar7.ag("obj_type", 10);
                                                } else if (cCi.aPn()) {
                                                    anVar7.ag("obj_type", 9);
                                                } else if (cCi.aSw()) {
                                                    anVar7.ag("obj_type", 8);
                                                } else if (cCi.aSv()) {
                                                    anVar7.ag("obj_type", 7);
                                                } else if (cCi.isShareThread) {
                                                    anVar7.ag("obj_type", 6);
                                                } else if (cCi.threadType == 0) {
                                                    anVar7.ag("obj_type", 1);
                                                } else if (cCi.threadType == 40) {
                                                    anVar7.ag("obj_type", 2);
                                                } else if (cCi.threadType == 49) {
                                                    anVar7.ag("obj_type", 3);
                                                } else if (cCi.threadType == 54) {
                                                    anVar7.ag("obj_type", 4);
                                                } else {
                                                    anVar7.ag("obj_type", 5);
                                                }
                                                anVar7.ag(IntentConfig.CARD_TYPE, cCi.aSA());
                                                anVar7.dh(IntentConfig.RECOM_SOURCE, cCi.mRecomSource);
                                                anVar7.dh("ab_tag", cCi.mRecomAbTag);
                                                anVar7.dh("weight", cCi.mRecomWeight);
                                                anVar7.dh("extra", cCi.mRecomExtra);
                                                anVar7.dh("nid", cCi.getNid());
                                                if (cCi.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.aq.isEmpty(cCi.getBaijiahaoData().oriUgcVid)) {
                                                    anVar7.dh("obj_param6", cCi.getBaijiahaoData().oriUgcVid);
                                                }
                                            }
                                            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                anVar7.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                            }
                                            if (PbFragment.this.cFc() != null) {
                                                com.baidu.tbadk.pageInfo.c.b(PbFragment.this.cFc(), anVar7);
                                            }
                                            TiebaStatic.log(anVar7);
                                            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                PbFragment.this.showToast(R.string.neterror);
                                                return;
                                            } else if (pbData != null) {
                                                ArrayList<PostData> cCk2 = PbFragment.this.jGP.getPbData().cCk();
                                                if ((cCk2 != null && cCk2.size() > 0) || !PbFragment.this.jGP.cFv()) {
                                                    PbFragment.this.jKz.cHU();
                                                    PbFragment.this.bVn();
                                                    if (pbData.cCD() != null && !StringUtils.isNull(pbData.cCD().aOP(), true)) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").dh("fid", PbFragment.this.jGP.getPbData().getForumId()));
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                    if (!AntiHelper.d(PbFragment.this.getContext(), cCi)) {
                                                        if (PbFragment.this.jKz != null) {
                                                            PbFragment.this.jKz.cHX();
                                                            PbFragment.this.jKz.w(pbData);
                                                        }
                                                        int i10 = 6;
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.jKz.showLoadingDialog();
                                                            PbFragment.this.jGP.cFY().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i10 = 2;
                                                            } else if (view.getId() == R.id.share_num_container) {
                                                                i10 = 1;
                                                            }
                                                            PbFragment.this.Ah(i10);
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
                                        PbFragment.this.jKz.cHU();
                                        if (PbFragment.this.jKz.jRd.cIZ() != null && view == PbFragment.this.jKz.jRd.cIZ().cGD() && !PbFragment.this.jKz.cIn()) {
                                            PbFragment.this.jKz.cHg();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bVn();
                                            PbFragment.this.jKz.cHB();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                w = PbFragment.this.jGP.w(true, PbFragment.this.cEL());
                                            } else {
                                                w = view.getId() == R.id.reply_title ? PbFragment.this.jGP.w(false, PbFragment.this.cEL()) : PbFragment.this.jGP.Jq(PbFragment.this.cEL());
                                            }
                                            view.setTag(Boolean.valueOf(w));
                                            if (w) {
                                                PbFragment.this.jKz.rn(true);
                                                PbFragment.this.jKz.cnI();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.jKz.rO(true);
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
                                    PbFragment.this.jKz.cHU();
                                    if (PbFragment.this.Ag(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.jGP.Ar(PbFragment.this.jKz.cHG()) != null) {
                                        PbFragment.this.cEG();
                                        if (PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().aQx() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", PbFragment.this.jGP.jNm).dh("fid", PbFragment.this.jGP.getPbData().getForumId()).ag("obj_locate", 3).dh("uid", PbFragment.this.jGP.getPbData().cCi().aQx().getUserId()));
                                        }
                                        if (PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().aQx() != null && PbFragment.this.jGP.getPbData().cCi().aQx().getUserId() != null && PbFragment.this.jKx != null) {
                                            int h = PbFragment.this.h(PbFragment.this.jGP.getPbData());
                                            bk cCi2 = PbFragment.this.jGP.getPbData().cCi();
                                            int i11 = 1;
                                            if (cCi2.aPm()) {
                                                i11 = 2;
                                            } else if (cCi2.aPn()) {
                                                i11 = 3;
                                            } else if (cCi2.aSv()) {
                                                i11 = 4;
                                            } else if (cCi2.aSw()) {
                                                i11 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").dh("tid", PbFragment.this.jGP.jNm).ag("obj_locate", 1).dh("obj_id", PbFragment.this.jGP.getPbData().cCi().aQx().getUserId()).ag("obj_type", PbFragment.this.jKx.aML() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i11));
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
                                if (PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().aPk() && PbFragment.this.jGP.getPbData().cCi().aQQ() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.jGP.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.jGP.cDp()) || PbFragment.this.jGP.getAppealInfo() == null) {
                                        PbFragment.this.jJW.finish();
                                        return;
                                    }
                                    name = PbFragment.this.jGP.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.jGP.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.jJW.finish();
                                    return;
                                }
                                String cDp = PbFragment.this.jGP.cDp();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.jGP.cFw() && cDp != null && cDp.equals(name)) {
                                    PbFragment.this.jJW.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.jGP.getPbData() != null) {
                                if ((PbFragment.this.jGP.getPbData().cCx() == 1 || PbFragment.this.jGP.getPbData().cCx() == 3) && !PbFragment.this.gEV.dek()) {
                                    PbFragment.this.jKz.cHU();
                                    int i12 = 0;
                                    if (PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGE()) {
                                        if (PbFragment.this.jKz.jRd.cIZ() == null || view != PbFragment.this.jKz.jRd.cIZ().cGG()) {
                                            if (view == PbFragment.this.jKz.cHz()) {
                                                i12 = 2;
                                            }
                                        } else if (PbFragment.this.jGP.getPbData().cCi().aQt() == 1) {
                                            i12 = 3;
                                        } else {
                                            i12 = 6;
                                        }
                                    } else if (PbFragment.this.jGP.getPbData().cCi().aQs() == 1) {
                                        i12 = 5;
                                    } else {
                                        i12 = 4;
                                    }
                                    ForumData forum = PbFragment.this.jGP.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.jGP.getPbData().cCi().getId();
                                    PbFragment.this.jKz.cHy();
                                    PbFragment.this.gEV.b(id4, name2, id5, i12, PbFragment.this.jKz.cHA());
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
                        PbFragment.this.jKz.cHU();
                        PbFragment.this.bVn();
                        PbFragment.this.jKz.cHB();
                        PbFragment.this.jKz.showLoadingDialog();
                        if (PbFragment.this.jKz.cHo() != null) {
                            PbFragment.this.jKz.cHo().setVisibility(8);
                        }
                        PbFragment.this.jGP.Al(1);
                        if (PbFragment.this.jJY != null) {
                            PbFragment.this.jJY.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cEv = PbFragment.this.cEv();
                        if (!TextUtils.isEmpty(cEv)) {
                            com.baidu.tbadk.core.util.ba.aUZ().b(PbFragment.this.getPageContext(), new String[]{cEv});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.dh("tid", PbFragment.this.jGP.cFt());
                anVar8.dh("fid", PbFragment.this.jGP.getForumId());
                anVar8.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.ag("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.jKh) {
                    PbFragment.this.jKh = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.cEo().cHd() != null && postData5.aQx() != null && postData5.ddu() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cEo().cHe() != null) {
                                PbFragment.this.cEo().cHe().cEe();
                            }
                            com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                            nVar2.a(PbFragment.this.jGP.getPbData().getForum());
                            nVar2.setThreadData(PbFragment.this.jGP.getPbData().cCi());
                            nVar2.g(postData5);
                            PbFragment.this.cEo().cHd().d(nVar2);
                            PbFragment.this.cEo().cHd().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aQx().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.jGP.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.jKM != null) {
                                PbFragment.this.jKz.rY(PbFragment.this.jKM.bdC());
                            }
                        }
                    }
                }
            }
        }
    };
    public SortSwitchButton.a jLw = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean ut(int i) {
            PbFragment.this.jKz.cHU();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.jGP == null || PbFragment.this.jGP.isLoading) {
                    return false;
                }
                PbFragment.this.bVn();
                PbFragment.this.jKz.cHB();
                if (PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().jDV != null && PbFragment.this.jGP.getPbData().jDV.size() > i) {
                    int intValue = PbFragment.this.jGP.getPbData().jDV.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13699").dh("tid", PbFragment.this.jGP.cFu()).dh("fid", PbFragment.this.jGP.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", Ai(intValue)));
                    if (PbFragment.this.jGP.Aq(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.jKz.rO(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Ai(int i) {
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
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.jGP.getPbData() != null) {
                    anVar.dh("fid", PbFragment.this.jGP.getPbData().getForumId());
                }
                anVar.dh("tid", PbFragment.this.jGP.cFt());
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bVn();
            PbFragment.this.jKz.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.cDy() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.cDy().Jt(postWriteCallBackData.getPostId());
                    PbFragment.this.jKZ = PbFragment.this.jKz.cHk();
                    PbFragment.this.jGP.cD(PbFragment.this.jKZ, PbFragment.this.jKz.cHl());
                }
                PbFragment.this.jKz.cHU();
                PbFragment.this.jKD.cIs();
                if (PbFragment.this.jKM != null) {
                    PbFragment.this.jKz.rY(PbFragment.this.jKM.bdC());
                }
                PbFragment.this.jKz.cHc();
                PbFragment.this.jKz.sa(true);
                PbFragment.this.jGP.cFO();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.jGP.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.jGP.getPbData();
                            if (pbData != null && pbData.cCi() != null && pbData.cCi().aQx() != null && (userId = pbData.cCi().aQx().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.jGP.cFF()) {
                                PbFragment.this.jKz.cHB();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.jGP.cFF()) {
                            PbFragment.this.jKz.cHB();
                        }
                    } else if (floor != null) {
                        PbFragment.this.jKz.r(PbFragment.this.jGP.getPbData());
                    }
                    if (PbFragment.this.jGP.cFz()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").dh("tid", PbFragment.this.jGP.cFt()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.rt(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.jKM.bdJ() || PbFragment.this.jKM.bdK()) {
                    PbFragment.this.jKM.a(false, postWriteCallBackData);
                }
                PbFragment.this.jKD.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.iPP != null) {
                    PbFragment.this.iPP.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d jLx = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                    anVar.dh("fid", PbFragment.this.jGP.getPbData().getForumId());
                }
                if (PbFragment.this.jGP != null) {
                    anVar.dh("tid", PbFragment.this.jGP.cFt());
                }
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.jKD != null) {
                    PbFragment.this.jKD.cIr();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.iPP != null) {
                    PbFragment.this.iPP.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.jKD != null) {
                if (PbFragment.this.jKz != null && PbFragment.this.jKz.cHe() != null && PbFragment.this.jKz.cHe().cEi() != null && PbFragment.this.jKz.cHe().cEi().bdK()) {
                    PbFragment.this.jKz.cHe().cEi().a(postWriteCallBackData);
                }
                PbFragment.this.jKD.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jLy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cIq;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.jJW.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.jKz != null && (cIq = PbFragment.this.jKz.cIq()) != null && PbFragment.this.jKz.getListView() != null) {
                            PbFragment.this.jKz.getListView().removeHeaderView(cIq);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a jLz = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g nc;
            if (!z || eVar == null || eVar.cCv() != null || com.baidu.tbadk.core.util.v.getCount(eVar.cCk()) >= 1) {
                PbFragment.this.jiP = true;
                PbFragment.this.jKz.cHD();
                if (eVar == null || !eVar.cCq()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.jKz.getView());
                }
                PbFragment.this.jKz.cnH();
                if (PbFragment.this.isFullScreen || PbFragment.this.jKz.cIn()) {
                    PbFragment.this.jKz.cIe();
                } else if (!PbFragment.this.jKz.cIb()) {
                    PbFragment.this.jKz.sa(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.eSG = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.jKz.getView());
                    PbFragment.this.jKz.cHM();
                }
                if (z && eVar != null) {
                    bk cCi = eVar.cCi();
                    if (cCi == null || !cCi.aSx()) {
                        PbFragment.this.d(PbFragment.this.jKL);
                    } else {
                        cFe();
                    }
                    PbFragment.this.jKz.cHe().setPbData(eVar);
                    PbFragment.this.jKz.bvM();
                    if (cCi != null && cCi.aRJ() != null) {
                        PbFragment.this.a(cCi.aRJ());
                    }
                    if (PbFragment.this.jKM != null) {
                        PbFragment.this.jKz.rY(PbFragment.this.jKM.bdC());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.cCk() != null && eVar.cCk().size() >= 1 && eVar.cCk().get(0) != null) {
                        PbFragment.this.jGP.Js(eVar.cCk().get(0).getId());
                    } else if (eVar.cCv() != null) {
                        PbFragment.this.jGP.Js(eVar.cCv().getId());
                    }
                    if (PbFragment.this.jKM != null) {
                        PbFragment.this.jKM.a(eVar.getAnti());
                        PbFragment.this.jKM.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.jKM.setThreadData(cCi);
                        PbFragment.this.jKM.a(PbFragment.this.jGP.cFJ(), PbFragment.this.jGP.cFt(), PbFragment.this.jGP.cGa());
                        if (cCi != null) {
                            PbFragment.this.jKM.id(cCi.aRV());
                        }
                    }
                    if (PbFragment.this.jKx != null) {
                        PbFragment.this.jKx.gC(eVar.aML());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.cCJ()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.jKz.rZ(PbFragment.this.mIsFromCDN);
                    PbFragment.this.jKz.a(eVar, i2, i3, PbFragment.this.jGP.cFv(), i4, PbFragment.this.jGP.getIsFromMark());
                    PbFragment.this.jKz.d(eVar, PbFragment.this.jGP.cFv());
                    PbFragment.this.jKz.rW(PbFragment.this.jGP.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.emL = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.emL) && PbFragment.this.jKM != null && PbFragment.this.jKM.bcW() != null && (nc = PbFragment.this.jKM.bcW().nc(6)) != null && !TextUtils.isEmpty(PbFragment.this.emL)) {
                            ((View) nc).setOnClickListener(PbFragment.this.eny);
                        }
                    }
                    if (PbFragment.this.jKH) {
                        PbFragment.this.jKH = false;
                        final int cEC = PbFragment.this.cEC();
                        if (!eVar.aWi()) {
                            PbFragment.this.jKz.Ay(cEC);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cEC, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.jKI) {
                        PbFragment.this.jKI = false;
                        final int cEC2 = PbFragment.this.cEC();
                        final boolean z2 = cEC2 != -1;
                        if (!z2) {
                            cEC2 = PbFragment.this.cED();
                        }
                        if (PbFragment.this.jKz != null) {
                            if (!eVar.aWi()) {
                                PbFragment.this.jKz.Ay(cEC2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cEC2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.jKz.setSelectionFromTop(cEC2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.jKz.setSelectionFromTop(cEC2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.jKz.sb(true);
                                PbFragment.this.jKz.sa(false);
                            }
                        }
                    } else if (PbFragment.this.jKJ) {
                        PbFragment.this.jKJ = false;
                        PbFragment.this.jKz.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.jKz.cHH();
                    }
                    PbFragment.this.jGP.a(eVar.getForum(), PbFragment.this.jLm);
                    PbFragment.this.jGP.a(PbFragment.this.jLn);
                    if (PbFragment.this.iPP != null && cCi != null && cCi.aQx() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cCi.aQx());
                        PbFragment.this.iPP.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.eSG && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.jGP.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.jGP.getAppealInfo().jDO)) {
                                    PbFragment.this.jKz.a(PbFragment.this.jGP.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.jKz.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.jKz.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.jKz.cIe();
                            PbFragment.this.jKz.cHL();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.jGP.cFt());
                            jSONObject.put("fid", PbFragment.this.jGP.getForumId());
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
                        PbFragment.this.jKz.Jy("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                            arrayList = PbFragment.this.jGP.getPbData().cCk();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).ddu() != 1)) {
                            PbFragment.this.jKz.Jy(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.cEW()) {
                                PbFragment.this.jKz.Jz(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.jKz.Jz(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.jKz.r(PbFragment.this.jGP.getPbData());
                        }
                    }
                    PbFragment.this.jKz.endLoadData();
                }
                if (eVar != null && eVar.jEc && PbFragment.this.esg == 0) {
                    PbFragment.this.esg = System.currentTimeMillis() - PbFragment.this.gPK;
                }
                if (!PbFragment.this.cDy().cFv() || PbFragment.this.cDy().getPbData().getPage().aPu() != 0 || PbFragment.this.cDy().cFV()) {
                    PbFragment.this.jKN = true;
                    return;
                }
                return;
            }
            PbFragment.this.jGP.Al(1);
            if (PbFragment.this.jJY != null) {
                PbFragment.this.jJY.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cFe() {
            if (PbFragment.this.jGP != null) {
                if (PbFragment.this.jKM == null || !PbFragment.this.jKM.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.jKM = (com.baidu.tbadk.editortools.pb.e) dVar.dN(PbFragment.this.getContext());
                    PbFragment.this.jKM.a(PbFragment.this.jJW.getPageContext());
                    PbFragment.this.jKM.a(PbFragment.this.emV);
                    PbFragment.this.jKM.a(PbFragment.this.emO);
                    PbFragment.this.jKM.a(PbFragment.this.jJW.getPageContext(), PbFragment.this.jJW.getIntent() == null ? null : PbFragment.this.jJW.getIntent().getExtras());
                    PbFragment.this.jKM.bcW().hW(true);
                    PbFragment.this.jKz.setEditorTools(PbFragment.this.jKM.bcW());
                    if (!PbFragment.this.jGP.cFA()) {
                        PbFragment.this.jKM.yj(PbFragment.this.jGP.cFt());
                    }
                    if (PbFragment.this.jGP.cGb()) {
                        PbFragment.this.jKM.yh(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.jKz != null) {
                        PbFragment.this.jKM.yh(PbFragment.this.jKz.cHi());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.jKz.r(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.bfI().bfJ()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.gPK : j;
                if (PbFragment.this.esg == 0) {
                    PbFragment.this.esg = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.erW, PbFragment.this.createTime, PbFragment.this.esg, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.erW = 0L;
                if (iVar != null) {
                    iVar.bfF();
                }
                if (z2) {
                    iVar.esp = currentTimeMillis;
                    iVar.io(true);
                }
                if (!z2 && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCi() != null) {
                    int threadType = PbFragment.this.jGP.getPbData().cCi().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.jKk, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.jKk, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.esr = currentTimeMillis;
                                iVar2.nA(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.esr = currentTimeMillis;
                        dVar.nA(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener jLA = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cEy();
            }
        }
    };
    private final a.InterfaceC0471a jLB = new a.InterfaceC0471a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0471a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.jKz.cHD();
            if (z) {
                if (PbFragment.this.jKx != null) {
                    PbFragment.this.jKx.gC(z2);
                }
                PbFragment.this.jGP.rG(z2);
                if (PbFragment.this.jGP.aML()) {
                    PbFragment.this.cEH();
                } else {
                    PbFragment.this.jKz.r(PbFragment.this.jGP.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.jKx != null) {
                        if (PbFragment.this.jKx.aMO() != null && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().aQx() != null) {
                            MarkData aMO = PbFragment.this.jKx.aMO();
                            MetaData aQx = PbFragment.this.jGP.getPbData().cCi().aQx();
                            if (aMO != null && aQx != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aQx.getUserId()) && !aQx.hadConcerned()) {
                                    PbFragment.this.b(aQx);
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
                    PbFragment.this.cEE();
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
            if (!PbFragment.this.zX(PbFragment.this.mLastScrollState) && PbFragment.this.zX(i)) {
                if (PbFragment.this.jKz != null) {
                    PbFragment.this.jKz.cHU();
                    if (PbFragment.this.jKM != null && !PbFragment.this.jKz.cHh()) {
                        PbFragment.this.jKz.rY(PbFragment.this.jKM.bdC());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.jKz.cHg();
                    }
                }
                if (!PbFragment.this.jKe) {
                    PbFragment.this.jKe = true;
                    if (PbFragment.this.jKz != null) {
                        PbFragment.this.jKz.cIa();
                    }
                }
            }
            if (PbFragment.this.jKz != null) {
                PbFragment.this.jKz.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.jJY != null) {
                PbFragment.this.jJY.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.jKf == null) {
                PbFragment.this.jKf = new com.baidu.tbadk.n.b();
                PbFragment.this.jKf.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.jKf.bfz();
            } else {
                PbFragment.this.jKf.bfy();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dct().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cCk;
            if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null && PbFragment.this.jKz != null && PbFragment.this.jKz.cHx() != null) {
                PbFragment.this.jKz.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.jJY != null) {
                    PbFragment.this.jJY.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.jGP.cFR() && (cCk = PbFragment.this.jGP.getPbData().cCk()) != null && !cCk.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.jKz.cHx().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.jGP.getPbData();
                    if (pbData != null) {
                        if (pbData.cCl() != null && pbData.cCl().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cCm() != null && pbData.cCm().hasData()) {
                            headerCount--;
                        }
                        int size = cCk.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d gFa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gEV.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.jGP.cFO();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.jZp != 1002 || bVar.fEF) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.jKz.a(1, dVar.OU, dVar.lnC, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gEV.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.jKz.a(PbFragment.this.gEV.getLoadDataMode(), gVar.OU, gVar.lnC, false);
                            PbFragment.this.jKz.aP(gVar.lnF);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.jKz.a(PbFragment.this.gEV.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c jLC = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
    };
    private final f.c eQw = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cEM()) {
                PbFragment.this.jJW.finish();
            }
            if (!PbFragment.this.jGP.rF(true)) {
                PbFragment.this.jKz.cHE();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e jLE = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.jLD && PbFragment.this.cEM()) {
                PbFragment.this.cEO();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.jGP.rE(false)) {
                    PbFragment.this.jKz.cHC();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.jGP.getPbData() != null) {
                    PbFragment.this.jKz.cHZ();
                }
                PbFragment.this.jLD = true;
            }
        }
    };
    private int jLF = 0;
    private final TbRichTextView.i eBC = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g cHx;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.jKz.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.dh("tid", PbFragment.this.jGP.cFt());
                anVar.dh("fid", PbFragment.this.jGP.getForumId());
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.ag("obj_locate", 3);
                anVar.ag("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.jGP.jHO.cCJ()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bir() != null) {
                            ArrayList<TbRichTextImageInfo> bir = tbRichTextView.getRichText().bir();
                            int i4 = 0;
                            while (i4 < bir.size()) {
                                if (bir.get(i4) != null) {
                                    arrayList.add(bir.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bir.get(i4).getSrc()) || str.equals(bir.get(i4).biJ()) || str.equals(bir.get(i4).biG()) || str.equals(bir.get(i4).biI()) || str.equals(bir.get(i4).biM()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bir.get(i4).getSrc();
                                    imageUrlData.originalUrl = bir.get(i4).getSrc();
                                    imageUrlData.isLongPic = bir.get(i4).biO();
                                    concurrentHashMap.put(bir.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.jGP.cFL(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.jGP.getPbData().cCi());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.jHa) {
                        TbRichText bu = PbFragment.this.bu(str, i);
                        if (bu != null && PbFragment.this.jLF >= 0 && PbFragment.this.jLF < bu.biq().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.f.b(bu.biq().get(PbFragment.this.jLF));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.jGX.size()) {
                                    break;
                                } else if (!aVar.jGX.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bu.getPostId() != 0 && (cHx = PbFragment.this.jKz.cHx()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.o> dataList = cHx.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.o> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.o next = it.next();
                                        if ((next instanceof PostData) && bu.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bu.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.jGP.cGa(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.jGP.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.jGY.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jGZ, aVar.lastId, PbFragment.this.jGP.cFL(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.jGP.getPbData().cCi());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.jGX, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.jGY.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jGZ, aVar.jGX.get(0), PbFragment.this.jGP.cFL(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.jGP.getPbData().cCi());
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
                PbFragment.this.jKo = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean jLG = false;
    PostData ihL = null;
    private final b.a jLH = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.ihL != null) {
                if (i == 0) {
                    PbFragment.this.ihL.fp(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.ihL = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.ihL);
                }
            }
        }
    };
    private final b.a jLI = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jKW != null && !TextUtils.isEmpty(PbFragment.this.jKX)) {
                if (i == 0) {
                    if (PbFragment.this.jKY == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.jKX));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.jKX;
                        aVar.pkgId = PbFragment.this.jKY.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.jKY.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.hQO == null) {
                            PbFragment.this.hQO = new az(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.hQO.j(PbFragment.this.jKX, PbFragment.this.jKW.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.jKW = null;
                PbFragment.this.jKX = null;
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
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
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
                if (PbFragment.this.cD(view)) {
                    if (view instanceof TbImageView) {
                        PbFragment.this.jKW = ((TbImageView) view).getBdImage();
                        PbFragment.this.jKX = ((TbImageView) view).getUrl();
                        if (PbFragment.this.jKW == null || TextUtils.isEmpty(PbFragment.this.jKX)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.jKY = null;
                        } else {
                            PbFragment.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.jKW = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.jKX = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.jKY = null;
                            } else {
                                PbFragment.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.jKW = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.jKX = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.jKY = null;
                        } else {
                            PbFragment.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.jKz.a(PbFragment.this.jLI, PbFragment.this.jKW.isGif());
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
            PbFragment.this.ihL = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.ihL == null) {
                return true;
            }
            if (PbFragment.this.ihL.ddu() != 1 || !PbFragment.this.cD(view)) {
                if (PbFragment.this.jKx != null) {
                    if (!PbFragment.this.jKx.aML() || PbFragment.this.ihL.getId() == null || !PbFragment.this.ihL.getId().equals(PbFragment.this.jGP.aQG())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.cDy().getPbData() != null && PbFragment.this.cDy().getPbData().cCJ();
                    if (PbFragment.this.ihL.ddu() != 1) {
                        if (PbFragment.this.jKF == null) {
                            PbFragment.this.jKF = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.jKF.a(PbFragment.this.jLJ);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cD(view) && !z3;
                            boolean z5 = (!PbFragment.this.cD(view) || PbFragment.this.jKW == null || PbFragment.this.jKW.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.jKF));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.jKF));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.jKF);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.ihL);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.jKF);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.jKF);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.ihL);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.jKF);
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
                                    if ((PbFragment.this.ru(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.jKF);
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jKF);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.jKF);
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
                                        if (PbFragment.this.jGP.getPbData().cCx() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.jKF);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.jKF);
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
                            PbFragment.this.jKF.aD(arrayList);
                            PbFragment.this.jKE = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.jKF);
                            PbFragment.this.jKE.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").dh("tid", PbFragment.this.jGP.jNm).dh("fid", PbFragment.this.jGP.getForumId()).dh("uid", PbFragment.this.jGP.getPbData().cCi().aQx().getUserId()).dh("post_id", PbFragment.this.jGP.bdr()).ag("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.jKz.a(PbFragment.this.jLH, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.jKz.a(PbFragment.this.jLI, PbFragment.this.jKW.isGif());
            return true;
        }
    };
    private k.c jLJ = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.jKE != null) {
                PbFragment.this.jKE.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.jKW != null && !TextUtils.isEmpty(PbFragment.this.jKX)) {
                        if (PbFragment.this.jKY == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.jKX));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.jKX;
                            aVar.pkgId = PbFragment.this.jKY.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.jKY.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.jKW = null;
                        PbFragment.this.jKX = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.jKW != null && !TextUtils.isEmpty(PbFragment.this.jKX)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.hQO == null) {
                                PbFragment.this.hQO = new az(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.hQO.j(PbFragment.this.jKX, PbFragment.this.jKW.getImageByte());
                            PbFragment.this.jKW = null;
                            PbFragment.this.jKX = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.ihL != null) {
                        PbFragment.this.ihL.fp(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.ihL = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").ag("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cC(view);
                        if (PbFragment.this.jGP.getPbData().cCi() != null && PbFragment.this.jGP.getPbData().cCi().aQx() != null && PbFragment.this.jGP.getPbData().cCi().aQx().getUserId() != null && PbFragment.this.jKx != null) {
                            int h = PbFragment.this.h(PbFragment.this.jGP.getPbData());
                            bk cCi = PbFragment.this.jGP.getPbData().cCi();
                            if (cCi.aPm()) {
                                i2 = 2;
                            } else if (cCi.aPn()) {
                                i2 = 3;
                            } else if (cCi.aSv()) {
                                i2 = 4;
                            } else {
                                i2 = cCi.aSw() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").dh("tid", PbFragment.this.jGP.jNm).ag("obj_locate", 2).dh("obj_id", PbFragment.this.jGP.getPbData().cCi().aQx().getUserId()).ag("obj_type", PbFragment.this.jKx.aML() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
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
                        PbFragment.this.Jl((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").ag("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.c(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.jKz.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                PbFragment.this.c(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.jKz.cI(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.jKz.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a hkE = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.beu && z && !PbFragment.this.jGP.cFB()) {
                PbFragment.this.cEJ();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.hrk.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0607a gLT = new a.InterfaceC0607a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        final int fEj = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            if (ad(i2) && PbFragment.this.jKz != null && PbFragment.this.jJY != null) {
                PbFragment.this.jJY.nf(true);
                if (Math.abs(i2) > this.fEj) {
                    PbFragment.this.jJY.hideFloatingView();
                }
                if (PbFragment.this.cEM()) {
                    PbFragment.this.jKz.cHu();
                    PbFragment.this.jKz.cHv();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            if (ad(i2) && PbFragment.this.jKz != null && PbFragment.this.jJY != null) {
                PbFragment.this.jKz.cIf();
                PbFragment.this.jJY.nf(false);
                PbFragment.this.jJY.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final o.a jJd = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void n(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.jKz.JA(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int jLL = -1;
    private int jLM = -1;

    /* loaded from: classes9.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes9.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e cEj() {
        return this.jKM;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        MetaData metaData;
        boolean z = true;
        if (nVar.cDc() != null) {
            String id = nVar.cDc().getId();
            ArrayList<PostData> cCk = this.jGP.getPbData().cCk();
            int i = 0;
            while (true) {
                if (i >= cCk.size()) {
                    break;
                }
                PostData postData = cCk.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cDg = nVar.cDg();
                    postData.DR(nVar.getTotalCount());
                    if (postData.ddr() != null && cDg != null) {
                        Iterator<PostData> it = cDg.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aQx() != null && (metaData = postData.getUserMap().get(next.aQx().getUserId())) != null) {
                                next.a(metaData);
                                next.uu(true);
                                next.a(getPageContext(), this.jGP.Jr(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cDg.size() != postData.ddr().size();
                        postData.ddr().clear();
                        postData.ddr().addAll(cDg);
                        z = z2;
                    }
                    if (postData.ddn() != null) {
                        postData.ddo();
                    }
                }
            }
            if (!this.jGP.getIsFromMark() && z) {
                this.jKz.r(this.jGP.getPbData());
            }
            if (z) {
                c(nVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n cCA = this.jGP.getPbData().cCA();
            if (cCA != null && str.equals(cCA.getAdId())) {
                if (cCA.ddi() != null) {
                    cCA.ddi().legoCard = null;
                }
                this.jGP.getPbData().cCB();
            }
            com.baidu.tieba.tbadkCore.data.n cFH = this.jGP.cFH();
            if (cFH != null && str.equals(cFH.getAdId())) {
                this.jGP.cFI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.jKE != null && this.jKE.isShowing()) {
                this.jKE.dismiss();
                this.jKE = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.jKE != null) {
                            PbFragment.this.jKE.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.jKz.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.jKU);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.jKU);
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
                kVar.aD(arrayList);
                this.jKE = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.jKE.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(int i) {
        bk cCi;
        if (this.jGP != null && this.jGP.getPbData() != null && (cCi = this.jGP.getPbData().cCi()) != null) {
            if (i == 1) {
                PraiseData aQi = cCi.aQi();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aQi == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cCi.a(praiseData);
                    } else {
                        cCi.aQi().getUser().add(0, metaData);
                        cCi.aQi().setNum(cCi.aQi().getNum() + 1);
                        cCi.aQi().setIsLike(i);
                    }
                }
                if (cCi.aQi() != null) {
                    if (cCi.aQi().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(cCi.aQi().getNum());
                    }
                }
            } else if (cCi.aQi() != null) {
                cCi.aQi().setIsLike(i);
                cCi.aQi().setNum(cCi.aQi().getNum() - 1);
                ArrayList<MetaData> user = cCi.aQi().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cCi.aQi().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cCi.aQi().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cCi.aQi().getNum() + "";
                }
            }
            if (this.jGP.cFv()) {
                this.jKz.cHx().notifyDataSetChanged();
            } else {
                this.jKz.s(this.jGP.getPbData());
            }
        }
    }

    public static PbFragment cEk() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jJW = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jGP.aA(bundle);
        if (this.hnh != null) {
            this.hnh.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.jKM.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.jKd = System.currentTimeMillis();
        this.jKS = getPageContext();
        final Intent intent = this.jJW.getIntent();
        if (intent != null) {
            this.gPK = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.jKk = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.jKk)) {
                    this.jKk = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.jKk)) {
                this.jJZ = true;
            }
            this.jLL = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.jLM = intent.getIntExtra("key_manga_next_chapter", -1);
            this.jLN = intent.getStringExtra("key_manga_title");
            this.jKH = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.jKI = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.jKJ = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cEM()) {
                this.jJW.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.jLa = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.jKt = new com.baidu.tbadk.core.data.ay();
            this.jKt.A(intent);
            this.jLc = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.jLc == 0) {
                this.jLc = intent.getIntExtra("key_start_from", 0);
            }
            this.jLd = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.gPK = System.currentTimeMillis();
        }
        this.erW = this.jKd - this.gPK;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.jKb = 0;
        az(bundle);
        if (this.jGP.getPbData() != null) {
            this.jGP.getPbData().Jd(this.source);
        }
        cEn();
        if (intent != null && this.jKz != null) {
            this.jKz.jRb = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.jKV == null) {
                    this.jKV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.jKz.JC(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(this.jKV, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.jGP.getPbData() != null) {
                this.jGP.Ju(stringExtra);
            }
        }
        this.hnh = new VoiceManager();
        this.hnh.onCreate(getPageContext());
        initData(bundle);
        this.jKL = new com.baidu.tbadk.editortools.pb.g();
        d(this.jKL);
        this.jKM = (com.baidu.tbadk.editortools.pb.e) this.jKL.dN(getActivity());
        this.jKM.a(this.jJW.getPageContext());
        this.jKM.a(this.emV);
        this.jKM.a(this.emO);
        this.jKM.a(this.jJW.getPageContext(), bundle);
        this.jKM.bcW().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.jKM.bcW().hW(true);
        rs(true);
        this.jKM.a(this.jGP.cFJ(), this.jGP.cFt(), this.jGP.cGa());
        registerListener(this.jLi);
        if (!this.jGP.cFA()) {
            this.jKM.yj(this.jGP.cFt());
        }
        if (this.jGP.cGb()) {
            this.jKM.yh(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.jKz != null) {
            this.jKM.yh(this.jKz.cHi());
        }
        registerListener(this.jLh);
        registerListener(this.jLj);
        registerListener(this.jLk);
        registerListener(this.hoy);
        registerListener(this.jLv);
        registerListener(this.jLg);
        this.jKK = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.lki);
        this.jKK.dda();
        registerListener(this.jLl);
        registerListener(this.dNP);
        this.jGP.cFT();
        registerListener(this.jLA);
        registerListener(this.hoG);
        if (this.jKz != null && this.jKz.cIj() != null && this.jKz.cIk() != null) {
            this.jJY = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.jKz.cIj(), this.jKz.cIk(), this.jKz.cHo());
            this.jJY.a(this.jLq);
        }
        if (this.jJX && this.jKz != null && this.jKz.cIk() != null) {
            this.jKz.cIk().setVisibility(8);
        }
        this.jKT = new com.baidu.tbadk.core.view.c();
        this.jKT.toastTime = 1000L;
        registerListener(this.jLu);
        registerListener(this.jLs);
        registerListener(this.jLt);
        registerListener(this.hEY);
        registerListener(this.hov);
        registerResponsedEventListener(TipEvent.class, this.hmn);
        this.jKU = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.jKU;
        userMuteAddAndDelCustomMessage.setTag(this.jKU);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.jKU;
        userMuteCheckCustomMessage.setTag(this.jKU);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jGP.cFY().a(this.jLr);
        this.jKD = new ax();
        if (this.jKM.bdv() != null) {
            this.jKD.d(this.jKM.bdv().getInputView());
        }
        this.jKM.a(this.emP);
        this.hDS = new ShareSuccessReplyToServerModel();
        a(this.jLe);
        this.iPP = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.iPP.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.aj.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.dNG) {
                        PbFragment.this.jKM.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.dNH && PbFragment.this.jKz != null && PbFragment.this.jKz.cHe() != null && PbFragment.this.jKz.cHe().cEi() != null) {
                        PbFragment.this.jKz.cHe().cEi().bdR();
                    } else if (i == com.baidu.tbadk.core.util.aj.dNI) {
                        PbFragment.this.c(PbFragment.this.jKP);
                    }
                }
            }
        });
        this.jKw = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.jKw.w(getUniqueId());
        com.baidu.tieba.s.c.dct().z(getUniqueId());
        com.baidu.tbadk.core.business.a.aOc().cX("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.jKd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.jGP != null) {
            gVar.setForumName(this.jGP.cDp());
            if (this.jGP.getPbData() != null && this.jGP.getPbData().getForum() != null) {
                gVar.a(this.jGP.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.jGP);
        }
    }

    public String cEl() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cEm() {
        return this.jJY;
    }

    private void rs(boolean z) {
        this.jKM.ia(z);
        this.jKM.ib(z);
        this.jKM.ic(z);
    }

    private void cEn() {
        this.dYI = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hnh != null) {
            this.hnh.onStart(getPageContext());
        }
    }

    public av cEo() {
        return this.jKz;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cDy() {
        return this.jGP;
    }

    public void Jk(String str) {
        if (this.jGP != null && !StringUtils.isNull(str) && this.jKz != null) {
            this.jKz.sd(true);
            this.jGP.Jk(str);
            this.jKj = true;
            this.jKz.cHU();
            this.jKz.cIe();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.beu = false;
        } else {
            this.beu = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.jKb = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.jKb == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.hnh != null) {
            this.hnh.onPause(getPageContext());
        }
        if (this.jKz != null) {
            this.jKz.onPause();
        }
        if (!this.jGP.cFA()) {
            this.jKM.yi(this.jGP.cFt());
        }
        if (this.jGP != null) {
            this.jGP.cFU();
        }
        com.baidu.tbadk.BdToken.c.aLi().aLn();
        MessageManager.getInstance().unRegisterListener(this.itM);
        chn();
        MessageManager.getInstance().unRegisterListener(this.jLs);
        MessageManager.getInstance().unRegisterListener(this.jLt);
        MessageManager.getInstance().unRegisterListener(this.jLu);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cEp() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.jGP.getPbData(), this.jGP.cFv(), this.jGP.cFS());
        return (a2 == null || a2.aQx() == null || a2.aQx().getGodUserData() == null || a2.aQx().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.beu = false;
        super.onResume();
        if (this.jKm) {
            this.jKm = false;
            cES();
        }
        if (cEp()) {
            this.jKg = System.currentTimeMillis();
        } else {
            this.jKg = -1L;
        }
        if (this.jKz != null && this.jKz.getView() != null) {
            if (!this.jiP) {
                cEK();
            } else {
                hideLoadingView(this.jKz.getView());
            }
            this.jKz.onResume();
        }
        if (this.jKb == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.jKz != null) {
            noNetworkView = this.jKz.cHb();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.hnh != null) {
            this.hnh.onResume(getPageContext());
        }
        registerListener(this.itM);
        this.jKG = false;
        cER();
        registerListener(this.jLs);
        registerListener(this.jLt);
        registerListener(this.jLu);
        if (this.hnT) {
            cEJ();
            this.hnT = false;
        }
        cEY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.jKz.rS(z);
        if (this.jKE != null) {
            this.jKE.dismiss();
        }
        if (z && this.jKG) {
            this.jKz.cHC();
            this.jGP.rE(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.jKg > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").dh("obj_duration", (System.currentTimeMillis() - this.jKg) + ""));
            this.jKg = 0L;
        }
        if (cEo().cHe() != null) {
            cEo().cHe().onStop();
        }
        if (this.jKz.jRd != null && !this.jKz.jRd.cJb()) {
            this.jKz.jRd.releaseResources();
        }
        if (this.jGP != null && this.jGP.getPbData() != null && this.jGP.getPbData().getForum() != null && this.jGP.getPbData().cCi() != null) {
            com.baidu.tbadk.distribute.a.bcK().b(getPageContext().getPageActivity(), "pb", this.jGP.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jGP.getPbData().cCi().getId(), 0L));
        }
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        MessageManager.getInstance().unRegisterListener(this.jKu);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("fid", this.jGP.getPbData().getForumId());
            anVar.dh("tid", this.jGP.cFt());
            anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.jKe && this.jKz != null) {
            this.jKe = true;
            this.jKz.cIa();
            a(false, (PostData) null);
        }
        if (this.jGP != null) {
            this.jGP.cancelLoadData();
            this.jGP.destory();
            if (this.jGP.cFX() != null) {
                this.jGP.cFX().onDestroy();
            }
        }
        if (this.jKM != null) {
            this.jKM.onDestroy();
        }
        if (this.gEV != null) {
            this.gEV.cancelLoadData();
        }
        if (this.dYI != null) {
            this.dYI.dcN();
        }
        if (this.jKz != null) {
            this.jKz.onDestroy();
            if (this.jKz.jRd != null) {
                this.jKz.jRd.releaseResources();
            }
        }
        if (this.jKf != null) {
            this.jKf.bfA();
        }
        if (this.jJY != null) {
            this.jJY.bld();
        }
        super.onDestroy();
        if (this.hnh != null) {
            this.hnh.onDestory(getPageContext());
        }
        if (this.jKz != null) {
            this.jKz.cHU();
        }
        MessageManager.getInstance().unRegisterListener(this.jLs);
        MessageManager.getInstance().unRegisterListener(this.jLt);
        MessageManager.getInstance().unRegisterListener(this.jLu);
        MessageManager.getInstance().unRegisterListener(this.jKU);
        MessageManager.getInstance().unRegisterListener(this.jLv);
        MessageManager.getInstance().unRegisterListener(this.hoG);
        MessageManager.getInstance().unRegisterListener(this.hEY);
        MessageManager.getInstance().unRegisterListener(this.jLy);
        this.jKS = null;
        this.jKT = null;
        com.baidu.tieba.recapp.d.a.cUZ().cVb();
        if (this.jKV != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jKV);
        }
        if (this.jKn != null) {
            this.jKn.cancelLoadData();
        }
        if (this.jKz != null && this.jKz.jRd != null) {
            this.jKz.jRd.cJe();
        }
        if (this.hDS != null) {
            this.hDS.cancelLoadData();
        }
        this.jKD.onDestroy();
        if (this.jGP != null && this.jGP.cFZ() != null) {
            this.jGP.cFZ().onDestroy();
        }
        if (this.iPP != null) {
            this.iPP.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g cHx;
        ArrayList<PostData> cDU;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aXJ() && this.jKz != null && (cHx = this.jKz.cHx()) != null && (cDU = cHx.cDU()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cDU.iterator();
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
                        bVar.gGQ = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.dGg == 1 && !TextUtils.isEmpty(id)) {
                    next.dGg = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.gGQ = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.jGP == null || this.jGP.getPbData() == null || this.jGP.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.jGP.getPbData().getForum().getFirst_class();
                    str2 = this.jGP.getPbData().getForum().getSecond_class();
                    str = this.jGP.getPbData().getForum().getId();
                    str4 = this.jGP.cFt();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aXM());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.jKz.onChangeSkinType(i);
            if (this.jKM != null && this.jKM.bcW() != null) {
                this.jKM.bcW().onChangeSkinType(i);
            }
            if (this.jKz.cHb() != null) {
                this.jKz.cHb().onChangeSkinType(getPageContext(), i);
            }
            this.jKD.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jKz = new av(this, this.hpu, this.efF);
        this.hrk = new com.baidu.tieba.f.b(getActivity());
        this.hrk.a(jLK);
        this.hrk.a(this.gLT);
        this.jKz.setOnScrollListener(this.mOnScrollListener);
        this.jKz.d(this.jLE);
        this.jKz.setListPullRefreshListener(this.eQw);
        this.jKz.re(com.baidu.tbadk.core.k.aNQ().isShowImages());
        this.jKz.setOnImageClickListener(this.eBC);
        this.jKz.b(this.mOnLongClickListener);
        this.jKz.g(this.hkE);
        this.jKz.a(this.jLC);
        this.jKz.rS(this.mIsLogin);
        if (this.jJW.getIntent() != null) {
            this.jKz.se(this.jJW.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.jKz.cHd().setFromForumId(this.jGP.getFromForumId());
        this.jKz.setEditorTools(this.jKM.bcW());
        this.jKM.yh(this.jKz.cHi());
        this.jKz.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.jGP.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jGP.getPbData().getForum().getId(), PbFragment.this.jGP.getPbData().getForum().getName(), PbFragment.this.jGP.getPbData().cCi().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.jKz.getView();
    }

    public void cEq() {
        if (this.jKz != null && this.jGP != null) {
            if ((this.jGP.getPbData() != null || this.jGP.getPbData().cCG() != null) && checkUpIsLogin() && this.jKz.cHx() != null && this.jKz.cHx().cDZ() != null) {
                this.jKz.cHx().cDZ().wU(this.jGP.cFt());
            }
        }
    }

    public void cEr() {
        TiebaStatic.log("c12181");
        if (this.jKz != null && this.jGP != null) {
            if ((this.jKz == null || this.jKz.cHh()) && this.jGP.getPbData() != null && this.jGP.getPbData().cCG() != null) {
                com.baidu.tieba.pb.data.m cCG = this.jGP.getPbData().cCG();
                if (checkUpIsLogin()) {
                    if ((!cCG.cCZ() || cCG.aRZ() != 2) && this.jKz.cHx() != null && this.jKz.cHx().cDZ() != null) {
                        this.jKz.cHx().cDZ().wU(this.jGP.cFt());
                    }
                    if (System.currentTimeMillis() - this.jKi > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).sL(false);
                        this.jKi = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cB(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.lkK && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.aNQ().isShowImages()) {
                    return Jn(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.jGP == null || this.jGP.getPbData() == null) {
                        return true;
                    }
                    if (cEo().cHe() != null) {
                        cEo().cHe().cEe();
                    }
                    com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                    nVar.a(this.jGP.getPbData().getForum());
                    nVar.setThreadData(this.jGP.getPbData().cCi());
                    nVar.g(postData);
                    cEo().cHd().d(nVar);
                    cEo().cHd().setPostId(postData.getId());
                    b(view, postData.aQx().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.jKM != null) {
                        this.jKz.rY(this.jKM.bdC());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cEs() {
        if (this.jKc == null) {
            this.jKc = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.jKc.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.jGL = PbFragment.this.jGL.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jGL);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.jGP.cFt(), PbFragment.this.jGL, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.jGL = PbFragment.this.jGL.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jGL);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.jGP.cFt(), PbFragment.this.jGL, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.jGL = PbFragment.this.jGL.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.jGL);
                        bVar.dismiss();
                    }
                }
            }).kI(R.style.dialog_ani_b2t).kJ(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.jLz.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).cLb(), "", 1);
    }

    private void az(Bundle bundle) {
        this.jGP = this.jJW.cDy();
        if (this.jGP.cFW() != null) {
            this.jGP.cFW().a(this.jJd);
        }
        if (this.jGP.cFX() != null) {
            this.jGP.cFX().b(this.jLf);
        }
        if (StringUtils.isNull(this.jGP.cFt())) {
            this.jJW.finish();
        } else if ("from_tieba_kuang".equals(this.jKk) && this.jKk != null) {
            this.jGP.As(6);
        }
    }

    private void initData(Bundle bundle) {
        this.jKx = com.baidu.tbadk.baseEditMark.a.a(this.jJW);
        if (this.jKx != null) {
            this.jKx.a(this.jLB);
        }
        this.gEV = new ForumManageModel(this.jJW);
        this.gEV.setLoadDataCallBack(this.gFa);
        this.dNL = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.jLp.setUniqueId(getUniqueId());
        this.jLp.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jKz.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.jKU;
        userMuteCheckCustomMessage.setTag(this.jKU);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cEt() {
        if (this.jGP == null || this.jGP.getPbData() == null) {
            return false;
        }
        bk cCi = this.jGP.getPbData().cCi();
        this.jGP.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cCi);
    }

    public void cEu() {
        if (checkUpIsLogin() && this.jGP != null && this.jGP.getPbData() != null && this.jGP.getPbData().getForum() != null && !cEt()) {
            if (this.jGP.getPbData().cCJ()) {
                this.jKz.cgO();
                return;
            }
            if (this.hqP == null) {
                this.hqP = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hqP.uZ(0);
                this.hqP.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void na(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void x(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nb(boolean z) {
                        if (z) {
                            PbFragment.this.jKz.cgO();
                        }
                    }
                });
            }
            this.hqP.D(this.jGP.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jGP.cFt(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cEv() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.jGP == null || (pbData = this.jGP.getPbData()) == null) {
            return null;
        }
        return pbData.cCw().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCi() != null) {
            if (eVar.cCi().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cCi().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cCi().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cEt() && cEw()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.jKp);
                this.jKq = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.jGP.getPbData() != null && this.jGP.getPbData().cCJ()) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.jJW.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cEo().getListView().smoothScrollBy((PbFragment.this.jKp[1] + PbFragment.this.jKq) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cEo().cHe() != null) {
                            PbFragment.this.jKM.bcW().setVisibility(8);
                            PbFragment.this.cEo().cHe().g(str, str2, PbFragment.this.cEo().cHi(), (PbFragment.this.jGP == null || PbFragment.this.jGP.getPbData() == null || PbFragment.this.jGP.getPbData().cCi() == null || !PbFragment.this.jGP.getPbData().cCi().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cEi = PbFragment.this.cEo().cHe().cEi();
                            if (cEi != null && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                cEi.a(PbFragment.this.jGP.getPbData().getAnti());
                                cEi.setThreadData(PbFragment.this.jGP.getPbData().cCi());
                            }
                            if (PbFragment.this.jKD.cIv() == null && PbFragment.this.cEo().cHe().cEi().bdZ() != null) {
                                PbFragment.this.cEo().cHe().cEi().bdZ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jKD != null && PbFragment.this.jKD.cIu() != null) {
                                            if (!PbFragment.this.jKD.cIu().dmj()) {
                                                PbFragment.this.jKD.sg(false);
                                            }
                                            PbFragment.this.jKD.cIu().vm(false);
                                        }
                                    }
                                });
                                PbFragment.this.jKD.e(PbFragment.this.cEo().cHe().cEi().bdZ().getInputView());
                                PbFragment.this.cEo().cHe().cEi().a(PbFragment.this.jKR);
                            }
                        }
                        PbFragment.this.cEo().cIe();
                    }
                }, 0L);
                return;
            }
            if (this.jKO == null) {
                this.jKO = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jKO.uZ(1);
                this.jKO.a(new AnonymousClass38(str, str2));
            }
            if (this.jGP != null && this.jGP.getPbData() != null && this.jGP.getPbData().getForum() != null) {
                this.jKO.D(this.jGP.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.jGP.cFt(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$38  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass38 implements c.a {
        final /* synthetic */ String jLW;
        final /* synthetic */ String jLX;

        AnonymousClass38(String str, String str2) {
            this.jLW = str;
            this.jLX = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void na(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void x(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nb(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.cEo().getListView().smoothScrollBy((PbFragment.this.jKp[1] + PbFragment.this.jKq) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cEo().cHe() != null) {
                            PbFragment.this.jKM.bcW().setVisibility(8);
                            PbFragment.this.cEo().cHe().g(AnonymousClass38.this.jLW, AnonymousClass38.this.jLX, PbFragment.this.cEo().cHi(), (PbFragment.this.jGP == null || PbFragment.this.jGP.getPbData() == null || PbFragment.this.jGP.getPbData().cCi() == null || !PbFragment.this.jGP.getPbData().cCi().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cEi = PbFragment.this.cEo().cHe().cEi();
                            if (cEi != null && PbFragment.this.jGP != null && PbFragment.this.jGP.getPbData() != null) {
                                cEi.a(PbFragment.this.jGP.getPbData().getAnti());
                                cEi.setThreadData(PbFragment.this.jGP.getPbData().cCi());
                            }
                            if (PbFragment.this.jKD.cIv() == null && PbFragment.this.cEo().cHe().cEi().bdZ() != null) {
                                PbFragment.this.cEo().cHe().cEi().bdZ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.jKD != null && PbFragment.this.jKD.cIu() != null) {
                                            if (!PbFragment.this.jKD.cIu().dmj()) {
                                                PbFragment.this.jKD.sg(false);
                                            }
                                            PbFragment.this.jKD.cIu().vm(false);
                                        }
                                    }
                                });
                                PbFragment.this.jKD.e(PbFragment.this.cEo().cHe().cEi().bdZ().getInputView());
                                PbFragment.this.cEo().cHe().cEi().a(PbFragment.this.jKR);
                            }
                        }
                        PbFragment.this.cEo().cIe();
                    }
                }, 0L);
            }
        }
    }

    public boolean cEw() {
        if ((this.jGP.getPbData() != null && this.jGP.getPbData().cCJ()) || this.iPP == null || this.jGP.getPbData() == null || this.jGP.getPbData().getAnti() == null) {
            return true;
        }
        return this.iPP.kZ(this.jGP.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Af(int i) {
        if (this.iPP == null || this.jGP.getPbData() == null || this.jGP.getPbData().getAnti() == null) {
            return true;
        }
        return this.iPP.aD(this.jGP.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.jGP != null && this.jGP.getPbData() != null && postData.ddu() != 1) {
            String cFt = this.jGP.cFt();
            String id = postData.getId();
            int cCx = this.jGP.getPbData() != null ? this.jGP.getPbData().cCx() : 0;
            PbActivity.a Jo = Jo(id);
            if (Jo != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cFt, id, "pb", true, null, false, null, cCx, postData.cJX(), this.jGP.getPbData().getAnti(), false, postData.aQx() != null ? postData.aQx().getIconInfo() : null).addBigImageData(Jo.jGX, Jo.jGY, Jo.jGZ, Jo.index);
                addBigImageData.setKeyPageStartFrom(this.jGP.cGd());
                addBigImageData.setFromFrsForumId(this.jGP.getFromForumId());
                addBigImageData.setKeyFromForumId(this.jGP.getForumId());
                addBigImageData.setBjhData(this.jGP.cFC());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cEx() {
        if (this.jGP.getPbData() == null || this.jGP.getPbData().cCi() == null) {
            return -1;
        }
        return this.jGP.getPbData().cCi().aRl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(boolean z) {
        if (this.jGP != null && this.jGP.jHO != null && this.jGP.jHO.cCi() != null) {
            bk cCi = this.jGP.jHO.cCi();
            cCi.mRecomAbTag = this.jGP.cGo();
            cCi.mRecomWeight = this.jGP.cGm();
            cCi.mRecomSource = this.jGP.cGn();
            cCi.mRecomExtra = this.jGP.cGp();
            if (cCi.getFid() == 0) {
                cCi.setFid(com.baidu.adp.lib.f.b.toLong(this.jGP.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cCi, "c13563");
            if (a2 != null) {
                a2.ag("reply_type", 1);
                if (z) {
                    a2.ag("obj_type", 2);
                } else {
                    a2.ag("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEy() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.LP(this.jGP.getForumId()) && this.jGP.getPbData() != null && this.jGP.getPbData().getForum() != null) {
            if (this.jGP.getPbData().getForum().isLike() == 1) {
                this.jGP.cFZ().fj(this.jGP.getForumId(), this.jGP.cFt());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ru(boolean z) {
        if (this.jGP == null || this.jGP.getPbData() == null) {
            return false;
        }
        return ((this.jGP.getPbData().cCx() != 0) || this.jGP.getPbData().cCi() == null || this.jGP.getPbData().cCi().aQx() == null || TextUtils.equals(this.jGP.getPbData().cCi().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean rv(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.v vVar;
        if (this.jGP == null || this.jGP.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.jGP.getPbData();
        bk cCi = pbData.cCi();
        if (cCi != null) {
            if (cCi.aPm() || cCi.aPn()) {
                return false;
            }
            if (cCi.aSv() || cCi.aSw()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cCx() != 0) {
                return pbData.cCx() != 3;
            }
            List<bg> cCE = pbData.cCE();
            if (com.baidu.tbadk.core.util.v.getCount(cCE) > 0) {
                for (bg bgVar : cCE) {
                    if (bgVar != null && (vVar = bgVar.dEk) != null && vVar.dCh && !vVar.dCi && (vVar.type == 1 || vVar.type == 2)) {
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

    private boolean rw(boolean z) {
        if (z || this.jGP == null || this.jGP.getPbData() == null) {
            return false;
        }
        return ((this.jGP.getPbData().getForum() != null && this.jGP.getPbData().getForum().isBlockBawuDelete) || this.jGP.getPbData().cCx() == 0 || this.jGP.getPbData().cCx() == 3) ? false : true;
    }

    public void cEz() {
        com.baidu.tieba.pb.data.e pbData;
        bk cCi;
        if (this.jGP != null && this.jGP.getPbData() != null && (cCi = (pbData = this.jGP.getPbData()).cCi()) != null && cCi.aQx() != null) {
            this.jKz.cHc();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cCi.aQx().getUserId());
            ag agVar = new ag();
            int cCx = this.jGP.getPbData().cCx();
            if (cCx == 1 || cCx == 3) {
                agVar.jPq = true;
                agVar.jPp = true;
                agVar.jPv = cCi.aQs() == 1;
                agVar.jPu = cCi.aQt() == 1;
            } else {
                agVar.jPq = false;
                agVar.jPp = false;
            }
            if (cCx == 1002 && !equals) {
                agVar.jPw = true;
            }
            agVar.jPn = rv(equals);
            agVar.jPr = cEA();
            agVar.jPo = rw(equals);
            agVar.DC = this.jGP.cFv();
            agVar.jPk = true;
            agVar.jPj = ru(equals);
            agVar.jPi = equals && this.jKz.cHJ();
            agVar.jPt = TbadkCoreApplication.getInst().getSkinType() == 1;
            agVar.jPs = true;
            agVar.isHostOnly = this.jGP.getHostMode();
            agVar.jPm = true;
            if (cCi.aQQ() == null) {
                agVar.jPl = true;
            } else {
                agVar.jPl = false;
            }
            if (pbData.cCJ()) {
                agVar.jPk = false;
                agVar.jPm = false;
                agVar.jPl = false;
                agVar.jPp = false;
                agVar.jPq = false;
            }
            this.jKz.jRd.a(agVar);
        }
    }

    private boolean cEA() {
        if (this.jGP != null && this.jGP.cFv()) {
            return this.jGP.getPageData() == null || this.jGP.getPageData().aPu() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
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
    public PbModel.a cEB() {
        return this.jLz;
    }

    public int cEC() {
        if (cEo() == null || cEo().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cEo().getListView();
        List<com.baidu.adp.widget.ListView.o> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.o oVar = data.get(i);
            if ((oVar instanceof com.baidu.tieba.pb.data.l) && ((com.baidu.tieba.pb.data.l) oVar).TK == com.baidu.tieba.pb.data.l.jFj) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cED() {
        if (cEo() == null || cEo().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cEo().getListView();
        List<com.baidu.adp.widget.ListView.o> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.o oVar = data.get(i);
            if ((oVar instanceof PostData) && oVar.getType() == PostData.lkJ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cEJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEE() {
        if (this.jGP != null && this.jGP.jHO != null && this.jGP.jHO.cCi() != null) {
            bk cCi = this.jGP.jHO.cCi();
            cCi.mRecomAbTag = this.jGP.cGo();
            cCi.mRecomWeight = this.jGP.cGm();
            cCi.mRecomSource = this.jGP.cGn();
            cCi.mRecomExtra = this.jGP.cGp();
            if (cCi.getFid() == 0) {
                cCi.setFid(com.baidu.adp.lib.f.b.toLong(this.jGP.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cCi, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.vN(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.vO(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.gW(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").dh("obj_id", metaData.getUserId()).ag("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").dh("obj_id", metaData.getUserId()).ag("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.dNL.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.jGP.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aST();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.jKz.cHD();
        this.jGP.rG(z);
        if (this.jKx != null) {
            this.jKx.gC(z);
            if (markData != null) {
                this.jKx.a(markData);
            }
        }
        if (this.jGP.aML()) {
            cEH();
        } else {
            this.jKz.r(this.jGP.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zX(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jl(String str) {
        if (this.jGP != null && this.jGP.getPbData() != null && this.jGP.getPbData().cCJ()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jGP.cFt(), str);
            bk cCi = this.jGP.getPbData().cCi();
            if (cCi.aPm()) {
                format = format + "&channelid=33833";
            } else if (cCi.aSu()) {
                format = format + "&channelid=33842";
            } else if (cCi.aPn()) {
                format = format + "&channelid=33840";
            }
            Jm(format);
            return;
        }
        this.jKw.JM(str);
    }

    private void Jm(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.jGP.cFA()) {
                    antiData.setBlock_forum_name(this.jGP.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.jGP.getPbData().getForum().getId());
                    antiData.setUser_name(this.jGP.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.jGP.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cEo() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bv(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            yo(str);
        } else {
            this.jKz.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.lnC) ? bVar.lnC : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.vO(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.gW(true);
                aVar.b(getPageContext());
                aVar.aST();
            } else {
                this.jKz.a(0, bVar.OU, bVar.lnC, z);
            }
            if (bVar.OU) {
                if (bVar.gUl == 1) {
                    ArrayList<PostData> cCk = this.jGP.getPbData().cCk();
                    int size = cCk.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cCk.get(i).getId())) {
                            i++;
                        } else {
                            cCk.remove(i);
                            break;
                        }
                    }
                    this.jGP.getPbData().cCi().kq(this.jGP.getPbData().cCi().aQo() - 1);
                    this.jKz.r(this.jGP.getPbData());
                } else if (bVar.gUl == 0) {
                    cEF();
                } else if (bVar.gUl == 2) {
                    ArrayList<PostData> cCk2 = this.jGP.getPbData().cCk();
                    int size2 = cCk2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cCk2.get(i2).ddr().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cCk2.get(i2).ddr().get(i3).getId())) {
                                i3++;
                            } else {
                                cCk2.get(i2).ddr().remove(i3);
                                cCk2.get(i2).ddt();
                                z2 = true;
                                break;
                            }
                        }
                        cCk2.get(i2).MB(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.jKz.r(this.jGP.getPbData());
                    }
                    a(bVar, this.jKz);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.jKz.a(this.gEV.getLoadDataMode(), gVar.OU, gVar.lnC, false);
            if (gVar.OU) {
                this.jKA = true;
                if (i == 2 || i == 3) {
                    this.jKB = true;
                    this.jKC = false;
                } else if (i == 4 || i == 5) {
                    this.jKB = false;
                    this.jKC = true;
                }
                if (i == 2) {
                    this.jGP.getPbData().cCi().kt(1);
                    this.jGP.setIsGood(1);
                } else if (i == 3) {
                    this.jGP.getPbData().cCi().kt(0);
                    this.jGP.setIsGood(0);
                } else if (i == 4) {
                    this.jGP.getPbData().cCi().ks(1);
                    this.jGP.Ak(1);
                } else if (i == 5) {
                    this.jGP.getPbData().cCi().ks(0);
                    this.jGP.Ak(0);
                }
                this.jKz.c(this.jGP.getPbData(), this.jGP.cFv());
            }
        }
    }

    private void cEF() {
        if (this.jGP.cFw() || this.jGP.cFy()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.jGP.cFt());
            PbActivity pbActivity = this.jJW;
            PbActivity pbActivity2 = this.jJW;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.jGP.cFt()));
        if (cEI()) {
            this.jJW.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDL() {
        this.jJW.cDL();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cCu;
        boolean z = false;
        if (this.jKz != null) {
            this.jKz.cHU();
        }
        if (this.jGP != null && this.jGP.getPbData() != null && !this.jGP.getPbData().cCJ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.jGP.getPbData().cCi().getId();
            if (this.jGP.isShareThread() && this.jGP.getPbData().cCi().dHm != null) {
                historyMessage.threadName = this.jGP.getPbData().cCi().dHm.showText;
            } else {
                historyMessage.threadName = this.jGP.getPbData().cCi().getTitle();
            }
            if (this.jGP.isShareThread() && !cDo()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.jGP.getPbData().getForum().getName();
            }
            ArrayList<PostData> cCk = this.jGP.getPbData().cCk();
            int cHF = this.jKz != null ? this.jKz.cHF() : 0;
            if (cCk != null && cHF >= 0 && cHF < cCk.size()) {
                historyMessage.postID = cCk.get(cHF).getId();
            }
            historyMessage.isHostOnly = this.jGP.getHostMode();
            historyMessage.isSquence = this.jGP.cFv();
            historyMessage.isShareThread = this.jGP.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.jKM != null) {
            this.jKM.onDestroy();
        }
        if (this.jKa && cEo() != null) {
            cEo().cIo();
        }
        if (this.jGP != null && (this.jGP.cFw() || this.jGP.cFy())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.jGP.cFt());
            if (this.jKA) {
                if (this.jKC) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.jGP.bOc());
                }
                if (this.jKB) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.jGP.getIsGood());
                }
            }
            if (this.jGP.getPbData() != null && System.currentTimeMillis() - this.jKd >= 40000 && (cCu = this.jGP.getPbData().cCu()) != null && !com.baidu.tbadk.core.util.v.isEmpty(cCu.getDataList())) {
                intent.putExtra("guess_like_data", cCu);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.jLa);
            }
            PbActivity pbActivity = this.jJW;
            PbActivity pbActivity2 = this.jJW;
            pbActivity.setResult(-1, intent);
        }
        if (cEI()) {
            if (this.jGP != null && this.jKz != null && this.jKz.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.jGP.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cCq() && !this.jKj && pbData.jDX == null) {
                        ao cGM = ao.cGM();
                        com.baidu.tieba.pb.data.e cFD = this.jGP.cFD();
                        Parcelable onSaveInstanceState = this.jKz.getListView().onSaveInstanceState();
                        boolean cFv = this.jGP.cFv();
                        boolean hostMode = this.jGP.getHostMode();
                        if (this.jKz.cHo() != null && this.jKz.cHo().getVisibility() == 0) {
                            z = true;
                        }
                        cGM.a(cFD, onSaveInstanceState, cFv, hostMode, z);
                        if (this.jKZ >= 0 || this.jGP.cGf() != null) {
                            ao.cGM().q(this.jGP.cGf());
                            ao.cGM().p(this.jGP.cGg());
                            ao.cGM().Au(this.jGP.cGh());
                        }
                    }
                }
            } else {
                ao.cGM().reset();
            }
            cDL();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.jKz == null || !this.jKz.AA(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ag(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.jJW;
        if (i == 0) {
            this.jKz.cHc();
            this.jKz.cHe().cEe();
            this.jKz.sa(false);
        }
        this.jKz.cHg();
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
                        this.jKM.resetData();
                        this.jKM.setVoiceModel(pbEditorData.getVoiceModel());
                        this.jKM.b(writeData);
                        com.baidu.tbadk.editortools.l nf = this.jKM.bcW().nf(6);
                        if (nf != null && nf.ekV != null) {
                            nf.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.jJW;
                        if (i == -1) {
                            this.jKM.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.jKz.cHe() != null && this.jKz.cHe().cEi() != null) {
                            com.baidu.tbadk.editortools.pb.h cEi = this.jKz.cHe().cEi();
                            cEi.setThreadData(this.jGP.getPbData().cCi());
                            cEi.b(writeData);
                            cEi.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nf2 = cEi.bcW().nf(6);
                            if (nf2 != null && nf2.ekV != null) {
                                nf2.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.jJW;
                            if (i == -1) {
                                cEi.bdR();
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
        this.jKM.onActivityResult(i, i2, intent);
        if (this.jKn != null) {
            this.jKn.onActivityResult(i, i2, intent);
        }
        if (cEo().cHe() != null) {
            cEo().cHe().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cEG();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ao.cGM().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.jGP != null) {
                                PbFragment.this.jGP.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cTS().D(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.jGP != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.cTS().D(getPageContext());
                        cEy();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.hDS != null && shareItem != null && shareItem.linkUrl != null) {
                            this.hDS.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bar() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57.1
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
                    this.jKz.rj(false);
                    if (this.jGP.getPbData() != null && this.jGP.getPbData().cCi() != null && this.jGP.getPbData().cCi().aQT() != null) {
                        this.jGP.getPbData().cCi().aQT().setStatus(2);
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
                        this.jKP = emotionImageData;
                        if (Af(com.baidu.tbadk.core.util.aj.dNI)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.jKo != null) {
                        this.jKz.cJ(this.jKo);
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
            if (this.jKn == null) {
                this.jKn = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.jJW);
                this.jKn.b(this.emO);
                this.jKn.c(this.emV);
            }
            this.jKn.a(emotionImageData, cDy(), cDy().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEG() {
        MarkData Ar;
        if (this.jKx != null) {
            if (this.jGP.getPbData() != null && this.jGP.getPbData().cCJ()) {
                Ar = this.jGP.Ar(0);
            } else {
                Ar = this.jGP.Ar(this.jKz.cHG());
            }
            if (Ar != null) {
                if (!Ar.isApp() || (Ar = this.jGP.Ar(this.jKz.cHG() + 1)) != null) {
                    this.jKz.cHB();
                    this.jKx.a(Ar);
                    if (!this.jKx.aML()) {
                        this.jKx.aMN();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.jKx.aMM();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEH() {
        com.baidu.tieba.pb.data.e pbData = this.jGP.getPbData();
        this.jGP.rG(true);
        if (this.jKx != null) {
            pbData.Jc(this.jKx.aMK());
        }
        this.jKz.r(pbData);
    }

    private boolean cEI() {
        if (this.jGP == null) {
            return true;
        }
        if (this.jGP.getPbData() == null || !this.jGP.getPbData().cCJ()) {
            if (this.jGP.aML()) {
                final MarkData cFN = this.jGP.cFN();
                if (cFN == null || !this.jGP.getIsFromMark()) {
                    return true;
                }
                final MarkData Ar = this.jGP.Ar(this.jKz.cHF());
                if (Ar == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cFN);
                    this.jJW.setResult(-1, intent);
                    return true;
                } else if (Ar.getPostId() == null || Ar.getPostId().equals(cFN.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cFN);
                    this.jJW.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.vO(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.jKx != null) {
                                if (PbFragment.this.jKx.aML()) {
                                    PbFragment.this.jKx.aMM();
                                    PbFragment.this.jKx.gC(false);
                                }
                                PbFragment.this.jKx.a(Ar);
                                PbFragment.this.jKx.gC(true);
                                PbFragment.this.jKx.aMN();
                            }
                            cFN.setPostId(Ar.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cFN);
                            PbFragment.this.jJW.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cDL();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cFN);
                            PbFragment.this.jJW.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cDL();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.jKz != null && PbFragment.this.jKz.getView() != null) {
                                PbFragment.this.jKz.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cFN);
                                PbFragment.this.jJW.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cDL();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aST();
                    return false;
                }
            } else if (this.jGP.getPbData() == null || this.jGP.getPbData().cCk() == null || this.jGP.getPbData().cCk().size() <= 0 || !this.jGP.getIsFromMark()) {
                return true;
            } else {
                this.jJW.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.jKz == null) {
            return null;
        }
        return this.jKz.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int biX() {
        if (this.jKz == null) {
            return 0;
        }
        return this.jKz.cHS();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> biY() {
        if (this.eBr == null) {
            this.eBr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bjk */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aNQ().isShowImages();
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
                        if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
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
        return this.eBr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> biZ() {
        if (this.eEf == null) {
            this.eEf = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.eEf;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bja() {
        if (this.eBs == null) {
            this.eBs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bPO */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aNQ().isShowImages();
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
                    if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
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
                    gifView.ber();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eBs;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bjb() {
        if (this.eEg == null) {
            this.eEg = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFf */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cE */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).deL();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eEg;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bjd() {
        this.eEi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFg */
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
        return this.eEi;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWO() {
        if (this.dXO == null) {
            this.dXO = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dXO;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (ba.JD(str) && this.jGP != null && this.jGP.cFt() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").ag("obj_param1", 1).dh("post_id", this.jGP.cFt()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.ejY = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            ba.cIx().d(getPageContext(), str);
        }
        this.jKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
        ba.cIx().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.jKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void an(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.jKz != null && this.jKz.cIj() != null && rect.top <= this.jKz.cIj().getHeight()) {
            rect.top += this.jKz.cIj().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.jGP.getPbData();
            TbRichText bu = bu(str, i);
            if (bu != null && (tbRichTextData = bu.biq().get(this.jLF)) != null) {
                aVar.postId = String.valueOf(bu.getPostId());
                aVar.jGX = new ArrayList<>();
                aVar.jGY = new ConcurrentHashMap<>();
                if (!tbRichTextData.biw().biH()) {
                    aVar.jHa = false;
                    String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                    aVar.jGX.add(b2);
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
                    imageUrlData.postId = bu.getPostId();
                    imageUrlData.mIsReserver = this.jGP.cFL();
                    imageUrlData.mIsSeeHost = this.jGP.getHostMode();
                    aVar.jGY.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cCi() != null) {
                            aVar.threadId = pbData.cCi().getId();
                        }
                        aVar.jGZ = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.jHa = true;
                int size = pbData.cCk().size();
                this.jLG = false;
                aVar.index = -1;
                int a2 = pbData.cCr() != null ? a(pbData.cCr().ddw(), bu, i, i, aVar.jGX, aVar.jGY) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cCk().get(i2);
                    if (postData.getId() == null || pbData.cCr() == null || pbData.cCr().getId() == null || !postData.getId().equals(pbData.cCr().getId())) {
                        a2 = a(postData.ddw(), bu, a2, i, aVar.jGX, aVar.jGY);
                    }
                }
                if (aVar.jGX.size() > 0) {
                    aVar.lastId = aVar.jGX.get(aVar.jGX.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cCi() != null) {
                        aVar.threadId = pbData.cCi().getId();
                    }
                    aVar.jGZ = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biw() == null) {
            return null;
        }
        return tbRichTextData.biw().biM();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biw() == null) {
            return 0L;
        }
        return tbRichTextData.biw().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biw() == null) {
            return false;
        }
        return tbRichTextData.biw().biN();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biw() == null) {
            return false;
        }
        return tbRichTextData.biw().biO();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo biw;
        String str;
        if (tbRichText == tbRichText2) {
            this.jLG = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.biq().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.biq().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.biw().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.biw().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.biw().biH()) {
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
                        String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (biw = tbRichTextData.biw()) != null) {
                                String biJ = biw.biJ();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = biw.biK();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = biJ;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.jGP.cFt(), -1L);
                                imageUrlData.mIsReserver = this.jGP.cFL();
                                imageUrlData.mIsSeeHost = this.jGP.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.jLG) {
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
        PostData cCr;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.jGP.aQG())) {
                z = true;
            }
            MarkData o = this.jGP.o(postData);
            if (this.jGP.getPbData() != null && this.jGP.getPbData().cCJ() && (cCr = cCr()) != null) {
                o = this.jGP.o(cCr);
            }
            if (o != null) {
                this.jKz.cHB();
                if (this.jKx != null) {
                    this.jKx.a(o);
                    if (!z) {
                        this.jKx.aMN();
                    } else {
                        this.jKx.aMM();
                    }
                }
            }
        }
    }

    public boolean cD(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bu(String str, int i) {
        TbRichText tbRichText = null;
        if (this.jGP == null || this.jGP.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.jGP.getPbData();
        if (pbData.cCr() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cCr());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cCk = pbData.cCk();
            c(pbData, cCk);
            return c(cCk, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cCw() != null && eVar.cCw().jFy != null && (list = eVar.cCw().jFy) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> biq;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText ddw = arrayList.get(i2).ddw();
            if (ddw != null && (biq = ddw.biq()) != null) {
                int size = biq.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (biq.get(i4) != null && biq.get(i4).getType() == 8) {
                        i3++;
                        if (biq.get(i4).biw().biJ().equals(str) || biq.get(i4).biw().biK().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = biq.get(i4).biw().getWidth() * equipmentDensity;
                            int height = biq.get(i4).biw().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.jLF = i4;
                            return ddw;
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
    public void s(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.jGL = str;
            if (this.jKc == null) {
                cEs();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.jKc.getItemView(1).setVisibility(8);
            } else {
                this.jKc.getItemView(1).setVisibility(0);
            }
            this.jKc.aSU();
            this.jKh = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hnh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEJ() {
        hideNetRefreshView(this.jKz.getView());
        cEK();
        if (this.jGP.cFG()) {
            this.jKz.cHB();
        }
        this.jKz.cHM();
    }

    private void cEK() {
        showLoadingView(this.jKz.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.jKz.cIj().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVn() {
        if (this.hnh != null) {
            this.hnh.stopPlay();
        }
        if (this.jJW != null) {
            this.jJW.bVn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cEx(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bjc() {
        if (this.eEh == null) {
            this.eEh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFh */
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
        return this.eEh;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.r onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bVo() {
        if (this.jJW != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.jJW.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jJW.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bUa() {
        if (this.jGP == null || this.jGP.getPbData() == null) {
            return null;
        }
        return this.jGP.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(av.jSr)).intValue();
            if (intValue == av.jSs) {
                if (!this.gEV.dek()) {
                    this.jKz.cHy();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gEV.MG(com.baidu.tbadk.core.util.aq.O(jSONArray));
                    }
                    this.gEV.a(this.jGP.getPbData().getForum().getId(), this.jGP.getPbData().getForum().getName(), this.jGP.getPbData().cCi().getId(), str, intValue3, intValue2, booleanValue, this.jGP.getPbData().cCi().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == av.jSt || intValue == av.jSv) {
                if (this.jGP.cFW() != null) {
                    this.jGP.cFW().Ab(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == av.jSt) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.jKU);
        userMuteAddAndDelCustomMessage.setTag(this.jKU);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Jn(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0697a
    public void rx(boolean z) {
        this.jKG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cEL() {
        ArrayList<PostData> cCk;
        int count;
        if (this.jGP == null || this.jGP.getPbData() == null || this.jGP.getPbData().cCk() == null || (count = com.baidu.tbadk.core.util.v.getCount((cCk = this.jGP.getPbData().cCk()))) == 0) {
            return "";
        }
        if (this.jGP.cFL()) {
            Iterator<PostData> it = cCk.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.ddu() == 1) {
                    return next.getId();
                }
            }
        }
        int cHF = this.jKz.cHF();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(cCk, cHF);
        if (postData == null || postData.aQx() == null) {
            return "";
        }
        if (this.jGP.Jr(postData.aQx().getUserId())) {
            return postData.getId();
        }
        for (int i = cHF - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(cCk, i);
            if (postData2 == null || postData2.aQx() == null || postData2.aQx().getUserId() == null) {
                break;
            } else if (this.jGP.Jr(postData2.aQx().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cHF + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(cCk, i2);
            if (postData3 == null || postData3.aQx() == null || postData3.aQx().getUserId() == null) {
                return "";
            }
            if (this.jGP.Jr(postData3.aQx().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ap(Context context, String str) {
        this.jKh = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Jo(String str) {
        String str2;
        if (this.jGP.getPbData() == null || this.jGP.getPbData().cCk() == null || this.jGP.getPbData().cCk().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.jGP.getPbData().cCk().size()) {
                i = 0;
                break;
            } else if (str.equals(this.jGP.getPbData().cCk().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.jGP.getPbData().cCk().get(i);
        if (postData.ddw() == null || postData.ddw().biq() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.ddw().biq().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.biw() != null) {
                    str2 = next.biw().biJ();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cEM() {
        return (!this.jJX && this.jLL == -1 && this.jLM == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.jLO = oVar;
            this.jJX = true;
            this.jKz.cHp();
            this.jKz.JB(this.jLN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEN() {
        if (this.jLO != null) {
            if (this.jLL == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.jLO.getCartoonId(), this.jLL, 0)));
                this.jJW.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEO() {
        if (this.jLO != null) {
            if (this.jLM == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.jLO.getCartoonId(), this.jLM, 0)));
                this.jJW.finish();
            }
        }
    }

    public int cEP() {
        return this.jLL;
    }

    public int cEQ() {
        return this.jLM;
    }

    private void chn() {
        if (this.jGP != null && this.jGP.getPbData() != null && this.jGP.getPbData().cCi() != null && this.jGP.getPbData().cCi().aPk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cER() {
        if (this.jGP != null && this.jGP.getPbData() != null && this.jGP.getPbData().cCi() != null && this.jGP.getPbData().cCi().aPk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cES() {
        if (this.beu) {
            this.jKm = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.jGP.getPbData() != null && this.jGP.getPbData().cCi() != null && this.jGP.getPbData().cCi().aQd() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.jGP.getPbData().cCi().aQd().getThreadId(), this.jGP.getPbData().cCi().aQd().getTaskId(), this.jGP.getPbData().cCi().aQd().getForumId(), this.jGP.getPbData().cCi().aQd().getForumName(), this.jGP.getPbData().cCi().aQs(), this.jGP.getPbData().cCi().aQt())));
            this.jJZ = true;
            this.jJW.finish();
        }
    }

    public String cET() {
        return this.jKk;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cEU() {
        return this.jKv;
    }

    public void ry(boolean z) {
        this.jKl = z;
    }

    public boolean aSr() {
        if (this.jGP != null) {
            return this.jGP.cFw();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.vO(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.jKS).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.jKS.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jKS).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(String str) {
        if (str == null) {
            str = "";
        }
        if (this.jKS != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jKS.getPageActivity());
            aVar.vO(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jKS).aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.jKz.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jKS.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.vO(this.jKS.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.vO(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.jKz.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jKS).aST();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ba.JD(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.hOp) {
            this.hOp = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.jKz != null) {
                this.jKz.onConfigurationChanged(configuration);
            }
            if (this.jKE != null) {
                this.jKE.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cEW() {
        if (this.jGP != null) {
            return this.jGP.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, av avVar) {
        boolean z;
        List<PostData> list = this.jGP.getPbData().cCw().jFy;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).ddr().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).ddr().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).ddr().remove(i2);
                    list.get(i).ddt();
                    z = true;
                    break;
                }
            }
            list.get(i).MB(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            avVar.r(this.jGP.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.cDc().getId();
        List<PostData> list = this.jGP.getPbData().cCw().jFy;
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
                ArrayList<PostData> cDg = nVar.cDg();
                postData.DR(nVar.getTotalCount());
                if (postData.ddr() != null) {
                    postData.ddr().clear();
                    postData.ddr().addAll(cDg);
                }
            }
        }
        if (!this.jGP.getIsFromMark()) {
            this.jKz.r(this.jGP.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cDn() {
        return this.jJW.cDn();
    }

    public boolean cDo() {
        if (this.jGP == null) {
            return false;
        }
        return this.jGP.cDo();
    }

    public void cEX() {
        if (this.jKz != null) {
            this.jKz.cHc();
            bVo();
        }
    }

    public PostData cCr() {
        return this.jKz.b(this.jGP.jHO, this.jGP.cFv());
    }

    public void onBackPressed() {
        if (this.jLb != null && !this.jLb.isEmpty()) {
            int size = this.jLb.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.jLb.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.jLb == null) {
                this.jLb = new ArrayList();
            }
            if (!this.jLb.contains(aVar)) {
                this.jLb.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.jLb == null) {
                this.jLb = new ArrayList();
            }
            if (!this.jLb.contains(aVar)) {
                this.jLb.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.jLb != null) {
            this.jLb.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.r rVar) {
        com.baidu.tbadk.core.util.ad.a(rVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(rVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEY() {
        if (this.jGP != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.jGP.cFt())) {
            com.baidu.tbadk.BdToken.c.aLi().o(com.baidu.tbadk.BdToken.b.dtS, com.baidu.adp.lib.f.b.toLong(this.jGP.cFt(), 0L));
        }
    }

    public com.baidu.tbadk.core.data.ay cEZ() {
        return this.jKt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp(String str) {
        if (this.jGP != null && this.jGP.getPbData() != null && this.jGP.getPbData().cCi() != null && this.jGP.getPbData().cCi().aSx()) {
            bk cCi = this.jGP.getPbData().cCi();
            int i = 0;
            if (cCi.aPm()) {
                i = 1;
            } else if (cCi.aPn()) {
                i = 2;
            } else if (cCi.aSv()) {
                i = 3;
            } else if (cCi.aSw()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.ag("obj_source", 4);
            anVar.ag("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cFa() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cFb() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cFc() {
        return this.jJW;
    }
}
