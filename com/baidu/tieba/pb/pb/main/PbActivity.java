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
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
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
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
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
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.r;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.share.AddExperiencedModel;
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
import com.baidu.tieba.view.Thread2GroupShareView;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<PbActivity> {
    private com.baidu.adp.lib.e.b<TbImageView> aGx;
    private com.baidu.tieba.f.b bYq;
    private com.baidu.adp.lib.e.b<ImageView> bnu;
    private com.baidu.adp.lib.e.b<TextView> bnv;
    private com.baidu.adp.lib.e.b<View> bnw;
    private com.baidu.adp.lib.e.b<LinearLayout> bnx;
    private com.baidu.adp.lib.e.b<RelativeLayout> bny;
    private com.baidu.adp.lib.e.b<GifView> bnz;
    private com.baidu.tbadk.core.util.b.a buX;
    private com.baidu.tbadk.core.dialog.h dAY;
    private VoiceManager dAm;
    public com.baidu.tbadk.core.util.aj eWW;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fKC;
    private View fKD;
    private com.baidu.tieba.pb.pb.report.a fKG;
    public at fKN;
    private y fKO;
    private boolean fKQ;
    private com.baidu.tieba.tbadkCore.data.e fKT;
    private com.baidu.tbadk.editortools.pb.f fKU;
    private com.baidu.tbadk.editortools.pb.d fKV;
    private EmotionImageData fKX;
    private String fKg;
    private com.baidu.tieba.pb.pb.main.b.b fKm;
    private boolean fLM;
    private String fLX;
    private com.baidu.tbadk.core.data.m fLY;
    private com.baidu.adp.base.e fLa;
    private com.baidu.tbadk.core.view.g fLb;
    private BdUniqueId fLc;
    private Runnable fLd;
    private av fLe;
    private com.baidu.adp.widget.ImageView.a fLf;
    private String fLg;
    private TbRichTextMemeInfo fLh;
    private List<a> fLk;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.ayA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.ayA));
        }
    };
    private static final b.a fLS = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // com.baidu.tieba.f.b.a
        public void fL(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bfO();
            } else {
                com.baidu.tieba.pb.a.b.bfN();
            }
        }
    };
    private boolean fKl = false;
    private boolean fKn = false;
    private boolean fKo = false;
    private boolean fnX = false;
    private boolean fKp = true;
    private int fKq = 0;
    private com.baidu.tbadk.core.dialog.b fKr = null;
    private long dgR = -1;
    private long bbI = 0;
    private long fKs = 0;
    private long createTime = 0;
    private long bbA = 0;
    private boolean fKt = false;
    private com.baidu.tbadk.l.b fKu = null;
    private long fKv = 0;
    private boolean fKw = false;
    private long fKx = 0;
    private String aVI = null;
    private boolean fKy = false;
    private boolean isFullScreen = false;
    private String fKz = "";
    private boolean fKA = true;
    private boolean fKB = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fKE = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void A(boolean z) {
            PbActivity.this.fKI.kX(!PbActivity.this.fKA);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fKF != null && PbActivity.this.fKF.vc()) {
                        PbActivity.this.bgK();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fKF = null;
    private com.baidu.tbadk.baseEditMark.a fKH = null;
    private ForumManageModel cNV = null;
    private com.baidu.tbadk.coreExtra.model.a axO = null;
    private ShareSuccessReplyToServerModel dQb = null;
    private ar fKI = null;
    public final com.baidu.tieba.pb.pb.main.b.a fKJ = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean fKK = false;
    private boolean fKL = false;
    private boolean fKM = false;
    private boolean fKP = false;
    private boolean fKR = false;
    private boolean fKS = false;
    private boolean fKW = false;
    public boolean fKY = false;
    private com.baidu.tbadk.editortools.pb.c aVL = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lf() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aVM = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Le() {
            if (PbActivity.this.fKN == null || PbActivity.this.fKN.bkx() == null || !PbActivity.this.fKN.bkx().bLs()) {
                return !PbActivity.this.rq(com.baidu.tbadk.core.util.aj.axJ);
            }
            PbActivity.this.showToast(PbActivity.this.fKN.bkx().bLu());
            if (PbActivity.this.fKV != null && (PbActivity.this.fKV.Lt() || PbActivity.this.fKV.Lu())) {
                PbActivity.this.fKV.a(false, PbActivity.this.fKN.bkA());
            }
            PbActivity.this.fKN.lj(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fKZ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Le() {
            if (PbActivity.this.fKN == null || PbActivity.this.fKN.bky() == null || !PbActivity.this.fKN.bky().bLs()) {
                return !PbActivity.this.rq(com.baidu.tbadk.core.util.aj.axK);
            }
            PbActivity.this.showToast(PbActivity.this.fKN.bky().bLu());
            if (PbActivity.this.fKI != null && PbActivity.this.fKI.bjl() != null && PbActivity.this.fKI.bjl().bhH() != null && PbActivity.this.fKI.bjl().bhH().Lu()) {
                PbActivity.this.fKI.bjl().bhH().a(PbActivity.this.fKN.bkA());
            }
            PbActivity.this.fKN.lk(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dAU = false;
    private int fLi = 0;
    private int fLj = -1;
    private final a fLl = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fKI != null && PbActivity.this.fKI.bjl() != null) {
                s bjl = PbActivity.this.fKI.bjl();
                if (bjl.bhE()) {
                    bjl.bhD();
                    return true;
                }
            }
            if (PbActivity.this.fKI != null && PbActivity.this.fKI.bkd()) {
                PbActivity.this.fKI.bke();
                return true;
            }
            return false;
        }
    };
    private r.a fLm = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
    };
    private AddExperiencedModel.a dBd = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bgO();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fLn = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void Q(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void i(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fKI.showToast(str);
            }
        }
    };
    private final CustomMessageListener fLo = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fKF != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fKV != null) {
                    PbActivity.this.fKI.lc(PbActivity.this.fKV.Ln());
                }
                PbActivity.this.fKI.bjm();
                PbActivity.this.fKI.bjW();
            }
        }
    };
    CustomMessageListener dBv = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.fKF.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.fKI != null && PbActivity.this.fKF != null) {
                    PbActivity.this.fKI.d(PbActivity.this.fKF.getPbData(), PbActivity.this.fKF.bhQ(), PbActivity.this.fKF.getRequestType());
                }
                if (PbActivity.this.fKI != null && PbActivity.this.fKI.bjD() != null) {
                    PbActivity.this.fKI.bjD().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fLp = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fKI != null) {
                    if (booleanValue) {
                        PbActivity.this.fKI.aRh();
                    } else {
                        PbActivity.this.fKI.aRg();
                    }
                }
            }
        }
    };
    private CustomMessageListener fLq = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fKV != null) {
                    PbActivity.this.fKI.lc(PbActivity.this.fKV.Ln());
                }
                PbActivity.this.fKI.le(false);
            }
        }
    };
    private CustomMessageListener fLr = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customResponsedMessage.getData();
                switch (dVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.j) dVar.getData());
                        return;
                    case 1:
                        PbActivity.this.a((ForumManageModel.b) dVar.getData(), false);
                        return;
                    case 2:
                        if (dVar.getData() == null) {
                            PbActivity.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbActivity.this.a(true, (MarkData) dVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener fLs = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fKI != null && PbActivity.this.fKI.bjD() != null) {
                PbActivity.this.fKI.bjD().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener eAS = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fLt = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.rs(2);
                aj.biX().reset();
                PbActivity.this.fKF.bii();
                boolean z2 = false;
                ArrayList<PostData> beX = PbActivity.this.fKF.getPbData().beX();
                if (beX != null) {
                    Iterator<PostData> it = beX.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bCk().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fKI.n(PbActivity.this.fKF.getPbData());
                    }
                    PbActivity.this.showToast(e.j.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(e.j.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(e.j.operation_failed);
        }
    };
    private View.OnClickListener aWs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aVI);
        }
    };
    private CustomMessageListener fLu = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKF.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fKF.bhZ() != null && PbActivity.this.fKF.bhZ().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fKI.a(yVar.sendCount, PbActivity.this.fKF.getPbData(), PbActivity.this.fKF.bhQ(), PbActivity.this.fKF.getRequestType());
                    }
                    if (pbData.beX() != null && pbData.beX().size() >= 1 && pbData.beX().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.beX().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.fKF.bhP(), 0L);
                        if (d2 == yVar.postId && d3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bCj = pbData.beX().get(0).bCj();
                            if (bCj == null) {
                                bCj = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> xG = bCj.xG();
                            if (xG == null) {
                                xG = new ArrayList<>();
                            }
                            xG.add(0, aVar);
                            bCj.cj(yVar.sendCount + bCj.xF());
                            bCj.k(xG);
                            pbData.beX().get(0).a(bCj);
                            PbActivity.this.fKI.bjD().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener dSV = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null) {
                PbActivity.this.sk((String) customResponsedMessage.getData());
                PbActivity.this.fKF.bif();
                if (PbActivity.this.fKI.bjD() != null) {
                    PbActivity.this.fKI.n(PbActivity.this.fKF.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a fLv = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.auM() != null && !aVar.auM().isEmpty()) {
                    PbActivity.this.fKI.a(aVar, PbActivity.this.fLx);
                }
                PbActivity.this.fKI.a(aVar, PbActivity.this.fKF.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bkH()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fLw = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void Q(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.J(list) && PbActivity.this.fKI != null) {
                PbActivity.this.fKI.dl(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fLx = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bI(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.jC().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbActivity.this.getUniqueId());
            } else {
                PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_BOTTOM)));
            }
        }
    };
    private boolean fLy = false;
    private PraiseModel fLz = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void jI(String str) {
            PbActivity.this.fLy = false;
            if (PbActivity.this.fLz != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKF.getPbData();
                if (pbData.beV().yi().getIsLike() == 1) {
                    PbActivity.this.lO(0);
                } else {
                    PbActivity.this.lO(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.beV()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Q(int i, String str) {
            PbActivity.this.fLy = false;
            if (PbActivity.this.fLz != null && str != null) {
                if (AntiHelper.am(i, str)) {
                    AntiHelper.aI(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fLA = 0;
    private boolean fLB = true;
    private b.a fLC = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void kx(boolean z) {
            PbActivity.this.kw(z);
            if (PbActivity.this.fKI.bkj() != null && z) {
                PbActivity.this.fKI.kX(false);
            }
            PbActivity.this.fKI.kZ(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aLc != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aLc, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.ayA));
                        }
                    } else if (updateAttentionMessage.getData().Jo) {
                        if (PbActivity.this.bfc().yv() != null && PbActivity.this.bfc().yv().getGodUserData() != null) {
                            PbActivity.this.bfc().yv().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().beV() != null && PbActivity.this.fKF.getPbData().beV().yv() != null) {
                            PbActivity.this.fKF.getPbData().beV().yv().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a crf = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fKI.akk();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.rt(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aIr();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(e.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bnE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            PbActivity.this.bgu();
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == e.g.richText) {
                    if (PbActivity.this.bq(view)) {
                        return true;
                    }
                } else if (view.getId() == e.g.pb_floor_item_layout) {
                    if (view.getTag(e.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(e.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != e.g.pb_post_header_layout) {
                    if (PbActivity.this.fKI != null && PbActivity.this.fKI.bgs() && view.getId() == e.g.pb_head_user_info_root) {
                        if (view.getTag(e.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").ax(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(e.g.tag_user_id)));
                        }
                        if (PbActivity.this.fKJ != null && PbActivity.this.fKJ.eak != null) {
                            PbActivity.this.fKJ.eak.onClick(view);
                        }
                    }
                } else {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        PbActivity.this.c(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (PbActivity.this.fKV != null) {
                PbActivity.this.fKI.lc(PbActivity.this.fKV.Ln());
            }
            PbActivity.this.fKI.bjm();
            PbActivity.this.fKI.bjW();
            return true;
        }
    });
    private CustomMessageListener fLD = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLc) {
                PbActivity.this.fKI.akk();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKF.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bfj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fLb.e(PbActivity.this.fLa.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fLa.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.hB(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bha();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ao.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fLa.getResources().getString(e.j.mute_fail);
                    }
                    PbActivity.this.fLb.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fLE = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLc) {
                PbActivity.this.fKI.akk();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fLb.e(PbActivity.this.fLa.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ao.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fLa.getResources().getString(e.j.un_mute_fail);
                }
                PbActivity.this.fLb.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fLF = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLc) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fKI.akk();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hqB;
                if (aVar.error == 0 && dataRes != null) {
                    int l = com.baidu.adp.lib.g.b.l(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = l == 1;
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        sparseArray.put(e.g.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(e.g.tag_user_mute_msg, str);
                    }
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(e.g.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(e.g.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.fKI.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fLG = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fKI.bjn() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bgu();
            }
        }
    };
    private CustomMessageListener dBC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dAU = true;
                }
            }
        }
    };
    public a.b fyK = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.azR();
            com.baidu.tbadk.core.data.al pageData = PbActivity.this.fKF.getPageData();
            int pageNum = PbActivity.this.fKI.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(e.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.xy()) {
                PbActivity.this.fKI.bjW();
                PbActivity.this.rs(2);
                PbActivity.this.azQ();
                PbActivity.this.fKI.bjH();
                if (com.baidu.adp.lib.util.j.kX()) {
                    PbActivity.this.fKF.rA(PbActivity.this.fKI.getPageNum());
                    if (PbActivity.this.fKm != null) {
                        PbActivity.this.fKm.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(e.j.pb_page_error);
            }
        }
    };
    public final View.OnClickListener dCe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Multi-variable search result rejected for r2v175, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v179, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v206, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v315, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            String name;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String str;
            int i;
            bg bgVar;
            String[] strArr;
            boolean q;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fKI.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fKF.kG(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fKI.bjI();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biQ()) {
                        if (view == PbActivity.this.fKI.fTE.bdE) {
                            if (PbActivity.this.fKI.lb(PbActivity.this.fKF.bhW())) {
                                PbActivity.this.azQ();
                                return;
                            }
                            PbActivity.this.fKp = false;
                            PbActivity.this.fKn = false;
                            com.baidu.adp.lib.util.l.a(PbActivity.this, PbActivity.this.fKI.fTE.bdE);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fKI.bjF() && (PbActivity.this.fKI.fTE.bkT() == null || (view != PbActivity.this.fKI.fTE.bkT().biP() && view != PbActivity.this.fKI.fTE.bkT().biN()))) {
                            if (view == PbActivity.this.fKI.bjZ()) {
                                if (PbActivity.this.fKF != null) {
                                    com.baidu.tbadk.browser.a.ae(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKF.getPbData().beV().yu().getLink());
                                }
                            } else if (view != PbActivity.this.fKI.fTE.fYE && view.getId() != e.g.view_forum_name) {
                                if (view == PbActivity.this.fKI.fTE.fYF) {
                                    if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null) {
                                        ArrayList<PostData> beX = PbActivity.this.fKF.getPbData().beX();
                                        if ((beX == null || beX.size() <= 0) && PbActivity.this.fKF.bhQ()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").ax("tid", PbActivity.this.fKF.bhP()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getForumId()));
                                        if (!PbActivity.this.fKI.bko()) {
                                            PbActivity.this.fKI.bjm();
                                        }
                                        PbActivity.this.bgC();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != e.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biB()) {
                                        if ((PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biM()) && view.getId() != e.g.floor_owner_reply && view.getId() != e.g.reply_title) {
                                            if (PbActivity.this.fKI.fTE.bkT() == null || (view != PbActivity.this.fKI.fTE.bkT().getCancelView() && view != PbActivity.this.fKI.fTE.bkT().biL())) {
                                                if (view != PbActivity.this.fKI.fTE.fYG && view.getId() != e.g.share_num_container) {
                                                    if (PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biJ()) {
                                                        if ((PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biS()) && view.getId() != e.g.pb_sort) {
                                                            if (PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biK()) {
                                                                if (PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biT()) {
                                                                    if (PbActivity.this.fKO == null || view != PbActivity.this.fKO.biD()) {
                                                                        if (PbActivity.this.fKO == null || view != PbActivity.this.fKO.biB()) {
                                                                            if (PbActivity.this.fKO == null || view != PbActivity.this.fKO.biE()) {
                                                                                if (PbActivity.this.fKO == null || view != PbActivity.this.fKO.biF()) {
                                                                                    if (PbActivity.this.fKO == null || view != PbActivity.this.fKO.biH()) {
                                                                                        if (PbActivity.this.fKO == null || view != PbActivity.this.fKO.biI()) {
                                                                                            if (PbActivity.this.fKO == null || view != PbActivity.this.fKO.biG()) {
                                                                                                if (PbActivity.this.fKI.bkj() == view) {
                                                                                                    if (PbActivity.this.fKI.bkj().getIndicateStatus()) {
                                                                                                        com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKF.getPbData();
                                                                                                        if (pbData != null && pbData.beV() != null && pbData.beV().yc() != null) {
                                                                                                            String wU = pbData.beV().yc().wU();
                                                                                                            if (StringUtils.isNull(wU)) {
                                                                                                                wU = pbData.beV().yc().getTaskId();
                                                                                                            }
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").ax(VideoPlayActivityConfig.OBJ_ID, wU));
                                                                                                        }
                                                                                                    } else {
                                                                                                        com.baidu.tieba.tbadkCore.d.a.cG("c10725", null);
                                                                                                    }
                                                                                                    PbActivity.this.bgW();
                                                                                                } else if (PbActivity.this.fKI.bjC() != view) {
                                                                                                    if (PbActivity.this.fKO == null || view != PbActivity.this.fKO.biC()) {
                                                                                                        if (PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biR()) {
                                                                                                            if (PbActivity.this.fKI.fTE.bkT() != null && view == PbActivity.this.fKI.fTE.bkT().biO()) {
                                                                                                                if (com.baidu.adp.lib.util.j.kX()) {
                                                                                                                    SparseArray<Object> c2 = PbActivity.this.fKI.c(PbActivity.this.fKF.getPbData(), PbActivity.this.fKF.bhQ(), 1);
                                                                                                                    if (c2 != null) {
                                                                                                                        if (StringUtils.isNull((String) c2.get(e.g.tag_del_multi_forum))) {
                                                                                                                            PbActivity.this.fKI.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                                        } else {
                                                                                                                            PbActivity.this.fKI.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(e.g.tag_del_multi_forum));
                                                                                                                        }
                                                                                                                    }
                                                                                                                    PbActivity.this.fKI.fTE.vO();
                                                                                                                } else {
                                                                                                                    PbActivity.this.showToast(e.j.network_not_available);
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (view.getId() != e.g.sub_pb_more && view.getId() != e.g.sub_pb_item && view.getId() != e.g.pb_floor_reply_more && view.getId() != e.g.new_sub_pb_list_richText) {
                                                                                                                if (view != PbActivity.this.fKI.bgl()) {
                                                                                                                    if (view == PbActivity.this.fKI.fTE.bkU()) {
                                                                                                                        PbActivity.this.fKI.bjO();
                                                                                                                    } else {
                                                                                                                        int id = view.getId();
                                                                                                                        if (id == e.g.pb_u9_text_view) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin() && (bgVar = (bg) view.getTag()) != null && !StringUtils.isNull(bgVar.Aj())) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                ay.CU().c(PbActivity.this.getPageContext(), new String[]{bgVar.Aj()});
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.replybtn || id == e.g.cover_reply_content || id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right || id == e.g.image_more_tip) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                                                                PostData postData = null;
                                                                                                                                if (view != null && view.getTag() != null) {
                                                                                                                                    postData = (PostData) ((SparseArray) view.getTag()).get(e.g.tag_load_sub_data);
                                                                                                                                    if (PbActivity.this.fKO == null) {
                                                                                                                                        PbActivity.this.fKO = new y(PbActivity.this.getPageContext(), PbActivity.this.dCe);
                                                                                                                                        PbActivity.this.fKI.bC(PbActivity.this.fKO.getView());
                                                                                                                                        PbActivity.this.fKO.kK(PbActivity.this.mIsLogin);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fKO.showDialog();
                                                                                                                                    if (id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right) {
                                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").ax("tid", PbActivity.this.fKF.fPL));
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray = new SparseArray();
                                                                                                                                    sparseArray.put(e.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(e.g.tag_clip_board));
                                                                                                                                    sparseArray.put(e.g.tag_is_subpb, false);
                                                                                                                                    PbActivity.this.fKO.biB().setTag(sparseArray);
                                                                                                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                                                                    boolean booleanValue = ((Boolean) sparseArray2.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                                                                    boolean booleanValue2 = ((Boolean) sparseArray2.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                                                    boolean booleanValue3 = ((Boolean) sparseArray2.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                                                                    if (!(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                        z = false;
                                                                                                                                    } else {
                                                                                                                                        z = ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                    }
                                                                                                                                    String str2 = null;
                                                                                                                                    if (sparseArray2.get(e.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                        str2 = (String) sparseArray2.get(e.g.tag_forbid_user_post_id);
                                                                                                                                    }
                                                                                                                                    if (booleanValue) {
                                                                                                                                        SparseArray sparseArray3 = new SparseArray();
                                                                                                                                        sparseArray3.put(e.g.tag_should_manage_visible, true);
                                                                                                                                        sparseArray3.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_name, sparseArray2.get(e.g.tag_forbid_user_name));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_name_show, sparseArray2.get(e.g.tag_forbid_user_name_show));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_portrait, sparseArray2.get(e.g.tag_forbid_user_portrait));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_post_id, str2);
                                                                                                                                        if (booleanValue2) {
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_visible, true);
                                                                                                                                            sparseArray3.put(e.g.tag_is_mem, sparseArray2.get(e.g.tag_is_mem));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_userid, sparseArray2.get(e.g.tag_user_mute_mute_userid));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_username, sparseArray2.get(e.g.tag_user_mute_mute_username));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_nameshow, sparseArray2.get(e.g.tag_user_mute_mute_nameshow));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_post_id, sparseArray2.get(e.g.tag_user_mute_post_id));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_thread_id, sparseArray2.get(e.g.tag_user_mute_thread_id));
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        }
                                                                                                                                        if (booleanValue3) {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, true);
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                            PbActivity.this.fKO.biE().setVisibility(0);
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, false);
                                                                                                                                            PbActivity.this.fKO.biE().setVisibility(8);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fKO.biC().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fKO.biE().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fKO.biC().setText(e.j.bar_manager);
                                                                                                                                        PbActivity.this.fKO.biC().setVisibility(0);
                                                                                                                                    } else if (!booleanValue3) {
                                                                                                                                        PbActivity.this.fKO.biC().setVisibility(8);
                                                                                                                                        PbActivity.this.fKO.biE().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        SparseArray sparseArray4 = new SparseArray();
                                                                                                                                        sparseArray4.put(e.g.tag_should_manage_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_should_delete_visible, true);
                                                                                                                                        sparseArray4.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                        PbActivity.this.fKO.biC().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fKO.biE().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fKO.biC().setText(e.j.delete);
                                                                                                                                        PbActivity.this.fKO.biE().setVisibility(0);
                                                                                                                                        if (PbActivity.this.fKF.getPbData().bfh() != 1002 || z) {
                                                                                                                                            PbActivity.this.fKO.biE().setText(e.j.delete);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fKO.biE().setText(e.j.report_text);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fKO.biC().setVisibility(8);
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                                                    if (!(sparseArray5.get(e.g.tag_user_mute_visible) instanceof Boolean)) {
                                                                                                                                        z2 = false;
                                                                                                                                    } else {
                                                                                                                                        z2 = ((Boolean) sparseArray5.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                                                    }
                                                                                                                                    if (!((Boolean) sparseArray5.get(e.g.tag_should_manage_visible)).booleanValue() && z2) {
                                                                                                                                        SparseArray sparseArray6 = new SparseArray();
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_visible, true);
                                                                                                                                        sparseArray6.put(e.g.tag_is_mem, sparseArray5.get(e.g.tag_is_mem));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_userid, sparseArray5.get(e.g.tag_user_mute_mute_userid));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_username, sparseArray5.get(e.g.tag_user_mute_mute_username));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_nameshow, sparseArray5.get(e.g.tag_user_mute_mute_nameshow));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_post_id, sparseArray5.get(e.g.tag_user_mute_post_id));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_thread_id, sparseArray5.get(e.g.tag_user_mute_thread_id));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_is_self, sparseArray5.get(e.g.tag_del_post_is_self));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_type, sparseArray5.get(e.g.tag_del_post_type));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_id, sparseArray5.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray6.put(e.g.tag_manage_user_identity, sparseArray5.get(e.g.tag_manage_user_identity));
                                                                                                                                        PbActivity.this.fKO.biD().setTag(sparseArray6);
                                                                                                                                        PbActivity.this.fKO.biD().setVisibility(0);
                                                                                                                                        PbActivity.this.fKO.biC().setVisibility(8);
                                                                                                                                        PbActivity.this.fKO.biD().setText(e.j.mute_option);
                                                                                                                                    } else {
                                                                                                                                        if (!(sparseArray5.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                            z3 = false;
                                                                                                                                        } else {
                                                                                                                                            z3 = ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                        }
                                                                                                                                        String str3 = null;
                                                                                                                                        if (sparseArray5.get(e.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                            str3 = (String) sparseArray5.get(e.g.tag_forbid_user_post_id);
                                                                                                                                        }
                                                                                                                                        boolean ks = PbActivity.this.ks(z3) & PbActivity.this.isLogin();
                                                                                                                                        PbActivity.this.fLP = (PostData) sparseArray5.get(e.g.tag_clip_board);
                                                                                                                                        if (aq.k(PbActivity.this.fLP) ? false : ks) {
                                                                                                                                            PbActivity.this.fKO.biD().setVisibility(0);
                                                                                                                                            PbActivity.this.fKO.biD().setTag(str3);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fKO.biD().setVisibility(8);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                                                                                                                    long j = 0;
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                        z4 = false;
                                                                                                                                    } else {
                                                                                                                                        z4 = ((Boolean) sparseArray7.get(e.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                                    }
                                                                                                                                    if (sparseArray7.get(e.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                        j = ((Long) sparseArray7.get(e.g.tag_chudian_template_id)).longValue();
                                                                                                                                    }
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_chudian_monitor_id) instanceof String)) {
                                                                                                                                        str = "";
                                                                                                                                    } else {
                                                                                                                                        str = (String) sparseArray7.get(e.g.tag_chudian_monitor_id);
                                                                                                                                    }
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_chudian_hide_day) instanceof Integer)) {
                                                                                                                                        i = 0;
                                                                                                                                    } else {
                                                                                                                                        i = ((Integer) sparseArray7.get(e.g.tag_chudian_hide_day)).intValue();
                                                                                                                                    }
                                                                                                                                    if (z4) {
                                                                                                                                        PbActivity.this.fKO.biG().setVisibility(0);
                                                                                                                                        PbActivity.this.fKO.biG().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                        PbActivity.this.fKO.biG().setTag(e.g.tag_chudian_monitor_id, str);
                                                                                                                                        PbActivity.this.fKO.biG().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fKO.biG().setVisibility(8);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                boolean z5 = false;
                                                                                                                                if (PbActivity.this.fKF.getPbData().vc()) {
                                                                                                                                    String vb = PbActivity.this.fKF.getPbData().vb();
                                                                                                                                    if (postData != null && !com.baidu.adp.lib.util.k.isEmpty(vb) && vb.equals(postData.getId())) {
                                                                                                                                        z5 = true;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (z5) {
                                                                                                                                    PbActivity.this.fKO.biB().setText(e.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fKO.biB().setText(e.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fKO.biI().setVisibility(8);
                                                                                                                                PbActivity.this.fKO.biH().setVisibility(8);
                                                                                                                                if (postData != null) {
                                                                                                                                    if (postData.bCd() == null || postData.bCd().toString().length() <= 0) {
                                                                                                                                        PbActivity.this.fKO.biF().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fKO.biF().setVisibility(0);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fLP = postData;
                                                                                                                                }
                                                                                                                                PbActivity.this.fKO.refreshUI();
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_act_btn) {
                                                                                                                            if (PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().beV() != null && PbActivity.this.fKF.getPbData().beV().getActUrl() != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), PbActivity.this.fKF.getPbData().beV().getActUrl());
                                                                                                                                if (PbActivity.this.fKF.getPbData().beV().yZ() != 1) {
                                                                                                                                    if (PbActivity.this.fKF.getPbData().beV().yZ() == 2) {
                                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.lottery_tail) {
                                                                                                                            if (view.getTag(e.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                                String str4 = (String) view.getTag(e.g.tag_pb_lottery_tail_link);
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getPbData().getForumId()).ax("tid", PbActivity.this.fKF.getPbData().getThreadId()).ax("lotterytail", StringUtils.string(str4, BaseRequestAction.SPLITE, TbadkCoreApplication.getCurrentAccount())));
                                                                                                                                if (PbActivity.this.fKF.getPbData().getThreadId().equals(str4)) {
                                                                                                                                    PbActivity.this.fKI.setSelection(0);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_item_tail_content) {
                                                                                                                            if (ba.bI(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                                String string = TbadkCoreApplication.getInst().getString(e.j.tail_web_view_title);
                                                                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                                if (!StringUtils.isNull(string2)) {
                                                                                                                                    TiebaStatic.log("c10056");
                                                                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                                }
                                                                                                                                PbActivity.this.fKI.bjm();
                                                                                                                            }
                                                                                                                        } else if (id == e.g.join_vote_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                if (PbActivity.this.bgz() == 1 && PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getPbData().getForumId()).ax("tid", PbActivity.this.fKF.getPbData().getThreadId()).ax("uid", currentAccount));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.look_all_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                com.baidu.tbadk.browser.a.ae(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                if (PbActivity.this.bgz() == 1 && PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getPbData().getForumId()).ax("tid", PbActivity.this.fKF.getPbData().getThreadId()).ax("uid", currentAccount2));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.manga_prev_btn) {
                                                                                                                            PbActivity.this.bgR();
                                                                                                                        } else if (id == e.g.manga_next_btn) {
                                                                                                                            PbActivity.this.bgS();
                                                                                                                        } else if (id == e.g.yule_head_img_img) {
                                                                                                                            if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().bfp() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fKF.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").ax(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                                ay.CU().c(PbActivity.this.getPageContext(), new String[]{pbData2.bfp().bfy()});
                                                                                                                            }
                                                                                                                        } else if (id == e.g.yule_head_img_all_rank) {
                                                                                                                            if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().bfp() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fKF.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").ax(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                                ay.CU().c(PbActivity.this.getPageContext(), new String[]{pbData3.bfp().bfy()});
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.fKI.fTE.bkT() != null && view == PbActivity.this.fKI.fTE.bkT().biU()) {
                                                                                                                            if (PbActivity.this.fKF == null || PbActivity.this.fKF.getPbData() == null || PbActivity.this.fKF.getPbData().beV() == null) {
                                                                                                                                PbActivity.this.fKI.fTE.vO();
                                                                                                                                return;
                                                                                                                            } else if (!com.baidu.adp.lib.util.l.lo()) {
                                                                                                                                PbActivity.this.showToast(e.j.neterror);
                                                                                                                                return;
                                                                                                                            } else {
                                                                                                                                int i2 = 1;
                                                                                                                                if (PbActivity.this.fKF.getPbData().beV().yd() == 0) {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKF.bhP(), 25028)));
                                                                                                                                } else {
                                                                                                                                    BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(e.j.haved_fans_called)).AC();
                                                                                                                                    i2 = 2;
                                                                                                                                }
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").x("obj_locate", PbActivity.this.al(PbActivity.this.fKF.getPbData().beV())).ax("tid", PbActivity.this.fKF.getPbData().beV().getTid()).x("obj_type", i2));
                                                                                                                            }
                                                                                                                        } else if (id == e.g.tv_pb_reply_more) {
                                                                                                                            if (PbActivity.this.fLi >= 0) {
                                                                                                                                if (PbActivity.this.fKF != null) {
                                                                                                                                    PbActivity.this.fKF.biv();
                                                                                                                                }
                                                                                                                                if (PbActivity.this.fKI.bjD() != null) {
                                                                                                                                    PbActivity.this.fKI.bjD().a(PbActivity.this.fKF.getPbData(), false);
                                                                                                                                }
                                                                                                                                PbActivity.this.fKI.getListView().setSelection(PbActivity.this.fKF.biy());
                                                                                                                                PbActivity.this.fLi = 0;
                                                                                                                                if (PbActivity.this.fKF != null) {
                                                                                                                                    PbActivity.this.fKF.bx(0, 0);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.single_bar_tips) {
                                                                                                                            PbActivity.this.fKI.bks();
                                                                                                                        } else if (id == e.g.pb_post_recommend_live_layout) {
                                                                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                                TiebaStatic.log("c12640");
                                                                                                                            }
                                                                                                                        } else if (id == e.g.thread_info_commont_container) {
                                                                                                                            PbActivity.this.fKI.bjr();
                                                                                                                        } else if (id == e.g.new_sub_pb_list_richText) {
                                                                                                                            SparseArray sparseArray8 = null;
                                                                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                                                                sparseArray8 = (SparseArray) view.getTag();
                                                                                                                            }
                                                                                                                            if (sparseArray8 != null) {
                                                                                                                                PbActivity.this.c(sparseArray8);
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.fKF.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.fKF.bhP(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fKF.getPbData().beV().yQ())));
                                                                                                                }
                                                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                if (PbActivity.this.fKF.getPbData() != null) {
                                                                                                                    PbActivity.this.fKI.bjW();
                                                                                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                    PostData postData2 = (PostData) sparseArray9.get(e.g.tag_load_sub_data);
                                                                                                                    View view2 = (View) sparseArray9.get(e.g.tag_load_sub_view);
                                                                                                                    if (postData2 != null && view2 != null) {
                                                                                                                        if (postData2.bCn() == 1) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                                                        }
                                                                                                                        String bhP = PbActivity.this.fKF.bhP();
                                                                                                                        String id2 = postData2.getId();
                                                                                                                        int i3 = 0;
                                                                                                                        if (PbActivity.this.fKF.getPbData() != null) {
                                                                                                                            i3 = PbActivity.this.fKF.getPbData().bfh();
                                                                                                                        }
                                                                                                                        PbActivity.this.azQ();
                                                                                                                        if (view.getId() == e.g.replybtn) {
                                                                                                                            c sp = PbActivity.this.sp(id2);
                                                                                                                            if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && sp != null) {
                                                                                                                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bhP, id2, "pb", true, null, true, null, i3, postData2.blJ(), PbActivity.this.fKF.getPbData().xs(), false, postData2.yv().getIconInfo()).addBigImageData(sp.fMz, sp.fMA, sp.fMB, sp.index);
                                                                                                                                addBigImageData.setKeyPageStartFrom(PbActivity.this.fKF.biu());
                                                                                                                                addBigImageData.setFromFrsForumId(PbActivity.this.fKF.getFromForumId());
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            c sp2 = PbActivity.this.sp(id2);
                                                                                                                            if (postData2 != null && PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && sp2 != null) {
                                                                                                                                SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bhP, id2, "pb", true, null, false, null, i3, postData2.blJ(), PbActivity.this.fKF.getPbData().xs(), false, postData2.yv().getIconInfo()).addBigImageData(sp2.fMz, sp2.fMA, sp2.fMB, sp2.index);
                                                                                                                                addBigImageData2.setKeyPageStartFrom(PbActivity.this.fKF.biu());
                                                                                                                                addBigImageData2.setFromFrsForumId(PbActivity.this.fKF.getFromForumId());
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData2));
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
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 3).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getPbData().getForumId()));
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (com.baidu.adp.lib.util.j.kX()) {
                                                                                                            PbActivity.this.fKI.bjW();
                                                                                                            SparseArray<Object> c3 = PbActivity.this.fKI.c(PbActivity.this.fKF.getPbData(), PbActivity.this.fKF.bhQ(), 1);
                                                                                                            if (c3 != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKF.getPbData().beT().getId(), PbActivity.this.fKF.getPbData().beT().getName(), PbActivity.this.fKF.getPbData().beV().getId(), String.valueOf(PbActivity.this.fKF.getPbData().getUserData().getUserId()), (String) c3.get(e.g.tag_forbid_user_name), (String) c3.get(e.g.tag_forbid_user_name_show), (String) c3.get(e.g.tag_forbid_user_post_id), (String) c3.get(e.g.tag_forbid_user_portrait))));
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(e.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (!com.baidu.adp.lib.util.j.kX()) {
                                                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        SparseArray<Object> sparseArray10 = (SparseArray) view.getTag();
                                                                                                        if (sparseArray10 != null) {
                                                                                                            boolean booleanValue4 = ((Boolean) sparseArray10.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                                            boolean booleanValue5 = ((Boolean) sparseArray10.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                                            boolean booleanValue6 = ((Boolean) sparseArray10.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                            if (booleanValue4) {
                                                                                                                if (booleanValue6) {
                                                                                                                    sparseArray10.put(e.g.tag_from, 1);
                                                                                                                    sparseArray10.put(e.g.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.b(sparseArray10);
                                                                                                                } else {
                                                                                                                    sparseArray10.put(e.g.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.fKI.bA(view);
                                                                                                                }
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.fKI.a(((Integer) sparseArray10.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray10.get(e.g.tag_del_post_id), ((Integer) sparseArray10.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getPbData().getForumId()));
                                                                                                    return;
                                                                                                } else {
                                                                                                    PbActivity.this.bgn();
                                                                                                }
                                                                                            } else {
                                                                                                long j2 = -1;
                                                                                                String str5 = "";
                                                                                                int i4 = 0;
                                                                                                if (view.getTag(e.g.tag_chudian_template_id) instanceof Long) {
                                                                                                    j2 = ((Long) view.getTag(e.g.tag_chudian_template_id)).longValue();
                                                                                                }
                                                                                                if (view.getTag(e.g.tag_chudian_monitor_id) instanceof String) {
                                                                                                    str5 = (String) view.getTag(e.g.tag_chudian_monitor_id);
                                                                                                }
                                                                                                if (view.getTag(e.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                                    i4 = ((Integer) view.getTag(e.g.tag_chudian_hide_day)).intValue();
                                                                                                }
                                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fKF.getPbData();
                                                                                                String str6 = null;
                                                                                                String str7 = null;
                                                                                                String str8 = null;
                                                                                                if (pbData4 != null && pbData4.beT() != null) {
                                                                                                    str6 = pbData4.beT().getId();
                                                                                                    str7 = pbData4.beT().getName();
                                                                                                    str8 = pbData4.getThreadId();
                                                                                                }
                                                                                                com.baidu.tieba.pb.a.a(j2, str5, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str6, str7, str8);
                                                                                                PbActivity.this.a(j2, str5, str6, str7, str8, i4);
                                                                                            }
                                                                                        } else if (PbActivity.this.fLf != null && !TextUtils.isEmpty(PbActivity.this.fLg)) {
                                                                                            if (PbActivity.this.buX == null) {
                                                                                                PbActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                                                                                            }
                                                                                            PbActivity.this.buX.Di();
                                                                                            PbActivity.this.buX.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                            if (!PbActivity.this.buX.z(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                if (PbActivity.this.fLe == null) {
                                                                                                    PbActivity.this.fLe = new av(PbActivity.this.getPageContext());
                                                                                                }
                                                                                                PbActivity.this.fLe.i(PbActivity.this.fLg, PbActivity.this.fLf.ov());
                                                                                                PbActivity.this.fLf = null;
                                                                                                PbActivity.this.fLg = null;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.fLf != null && !TextUtils.isEmpty(PbActivity.this.fLg)) {
                                                                                        if (PbActivity.this.fLh == null) {
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fLg));
                                                                                        } else {
                                                                                            d.a aVar = new d.a();
                                                                                            aVar.url = PbActivity.this.fLg;
                                                                                            aVar.pkgId = PbActivity.this.fLh.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fLh.memeInfo.pck_id;
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                                        }
                                                                                        PbActivity.this.fLf = null;
                                                                                        PbActivity.this.fLg = null;
                                                                                    }
                                                                                } else if (PbActivity.this.fLP != null) {
                                                                                    PbActivity.this.fLP.da(PbActivity.this.getPageContext().getPageActivity());
                                                                                    PbActivity.this.fLP = null;
                                                                                }
                                                                            } else {
                                                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                                                if (sparseArray11 != null) {
                                                                                    if ((sparseArray11.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_id) instanceof String) && (sparseArray11.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                        PbActivity.this.fKI.a(((Integer) sparseArray11.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(e.g.tag_del_post_id), ((Integer) sparseArray11.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").x("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bs(view);
                                                                                if (PbActivity.this.fKF.getPbData().beV() != null && PbActivity.this.fKF.getPbData().beV().yv() != null && PbActivity.this.fKF.getPbData().beV().yv().getUserId() != null && PbActivity.this.fKH != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").ax("tid", PbActivity.this.fKF.fPL).x("obj_locate", 2).ax(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fKF.getPbData().beV().yv().getUserId()).x("obj_type", PbActivity.this.fKH.vc() ? 0 : 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fKF.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.kX()) {
                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13079"));
                                                                            PbActivity.this.sm((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").x("obj_locate", 4));
                                                                            SparseArray<Object> sparseArray12 = (SparseArray) tag;
                                                                            if ((sparseArray12.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray12.get(e.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray12.put(e.g.tag_from, 0);
                                                                                sparseArray12.put(e.g.tag_check_mute_from, 2);
                                                                                PbActivity.this.b(sparseArray12);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").x("obj_type", 0).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").x("obj_type", 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fKI.fTE.bkS();
                                                                }
                                                            } else if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().beV() != null) {
                                                                PbActivity.this.fKI.fTE.vO();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                                PbActivity.this.sm(PbActivity.this.fKF.getPbData().beV().yM());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fKI.bjW();
                                                            if (com.baidu.adp.lib.util.j.kX()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Integer.valueOf(PbActivity.this.fKF.bid()));
                                                                    return;
                                                                }
                                                                PbActivity.this.rs(2);
                                                                PbActivity.this.azQ();
                                                                PbActivity.this.fKI.bjH();
                                                                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(PbActivity.this.getPageContext().getPageActivity());
                                                                if (PbActivity.this.fKF.getPbData().fIg == null || PbActivity.this.fKF.getPbData().fIg.size() <= 0) {
                                                                    strArr = new String[]{PbActivity.this.getResources().getString(e.j.sort_type_new), PbActivity.this.getResources().getString(e.j.sort_type_old)};
                                                                } else {
                                                                    String[] strArr2 = new String[PbActivity.this.fKF.getPbData().fIg.size()];
                                                                    int i5 = 0;
                                                                    while (true) {
                                                                        int i6 = i5;
                                                                        if (i6 >= PbActivity.this.fKF.getPbData().fIg.size()) {
                                                                            break;
                                                                        }
                                                                        strArr2[i6] = PbActivity.this.fKF.getPbData().fIg.get(i6).sort_name + PbActivity.this.getResources().getString(e.j.sort_static);
                                                                        i5 = i6 + 1;
                                                                    }
                                                                    strArr = strArr2;
                                                                }
                                                                bVar.a(strArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                                                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                                                                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i7, View view3) {
                                                                        int i8 = 2;
                                                                        if (PbActivity.this.fKF.aaJ() == 1 && i7 == 1) {
                                                                            i8 = 0;
                                                                        } else if (PbActivity.this.fKF.aaJ() == 2 && i7 == 0) {
                                                                            i8 = 1;
                                                                        } else if (PbActivity.this.fKF.aaJ() != 3 || i7 == 2) {
                                                                            i8 = (i7 != 2 || PbActivity.this.fKF.aaJ() == 3) ? 0 : 3;
                                                                        }
                                                                        TiebaStatic.log("c12097");
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != e.g.pb_sort ? 1 : 0).x("obj_type", i8));
                                                                        if (PbActivity.this.fKF.getPbData().fIg != null && PbActivity.this.fKF.getPbData().fIg.size() > i7) {
                                                                            i7 = PbActivity.this.fKF.getPbData().fIg.get(i7).sort_type.intValue();
                                                                        }
                                                                        boolean rF = PbActivity.this.fKF.rF(i7);
                                                                        view.setTag(Integer.valueOf(PbActivity.this.fKF.bid()));
                                                                        if (rF) {
                                                                            PbActivity.this.mIsLoading = true;
                                                                            PbActivity.this.fKI.kS(true);
                                                                        }
                                                                        bVar2.dismiss();
                                                                    }
                                                                });
                                                                bVar.d(PbActivity.this.getPageContext()).Ax();
                                                            } else {
                                                                PbActivity.this.showToast(e.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fKI.bjW();
                                                        if (PbActivity.this.bga().getPbData().fIh != 2) {
                                                            if (PbActivity.this.fKF.getPageData() != null) {
                                                                PbActivity.this.fKI.a(PbActivity.this.fKF.getPageData(), PbActivity.this.fyK);
                                                            }
                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            PbActivity.this.showToast(e.j.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (com.baidu.tbadk.p.aw.jL() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fKF != null) {
                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12386");
                                                        amVar.ax("tid", PbActivity.this.fKF.bhP());
                                                        amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                                                        amVar.ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getForumId());
                                                        amVar.x("obj_locate", 6);
                                                        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        TiebaStatic.log(amVar);
                                                    }
                                                    if (com.baidu.adp.lib.util.l.lo()) {
                                                        if (PbActivity.this.fKF.getPbData() != null) {
                                                            ArrayList<PostData> beX2 = PbActivity.this.fKF.getPbData().beX();
                                                            if ((beX2 != null && beX2.size() > 0) || !PbActivity.this.fKF.bhQ()) {
                                                                PbActivity.this.fKI.bjW();
                                                                PbActivity.this.azQ();
                                                                PbActivity.this.rs(2);
                                                                if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().bfp() != null && !StringUtils.isNull(PbActivity.this.fKF.getPbData().bfp().xf(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                                if (com.baidu.tbadk.p.aw.jL()) {
                                                                    PbActivity.this.rt(2);
                                                                } else {
                                                                    PbActivity.this.fKI.showLoadingDialog();
                                                                    PbActivity.this.fKF.bip().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(e.j.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.fKI.fTE.vO();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kX()) {
                                            PbActivity.this.fKI.bjW();
                                            if (PbActivity.this.fKI.fTE.bkT() != null && view == PbActivity.this.fKI.fTE.bkT().biM() && !PbActivity.this.fKI.bko()) {
                                                PbActivity.this.fKI.bjm();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.azQ();
                                                PbActivity.this.fKI.bjH();
                                                if (view.getId() == e.g.floor_owner_reply) {
                                                    q = PbActivity.this.fKF.q(true, PbActivity.this.bgP());
                                                } else {
                                                    q = view.getId() == e.g.reply_title ? PbActivity.this.fKF.q(false, PbActivity.this.bgP()) : PbActivity.this.fKF.sq(PbActivity.this.bgP());
                                                }
                                                view.setTag(Boolean.valueOf(q));
                                                if (q) {
                                                    PbActivity.this.fKI.kB(true);
                                                    PbActivity.this.fKI.aRh();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fKI.kS(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.rs(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(e.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.kX()) {
                                        PbActivity.this.fKI.bjW();
                                        if (PbActivity.this.rr(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fKF.rG(PbActivity.this.fKI.bjM()) != null) {
                                            PbActivity.this.bgJ();
                                            if (PbActivity.this.fKF.getPbData().beV() != null && PbActivity.this.fKF.getPbData().beV().yv() != null && PbActivity.this.fKF.getPbData().beV().yv().getUserId() != null && PbActivity.this.fKH != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").ax("tid", PbActivity.this.fKF.fPL).x("obj_locate", 1).ax(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fKF.getPbData().beV().yv().getUserId()).x("obj_type", PbActivity.this.fKH.vc() ? 0 : 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fKF.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(e.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.kX()) {
                                    PbActivity.this.fKI.kB(true);
                                    PbActivity.this.fKI.bjm();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fKI.aRh();
                                        PbActivity.this.azQ();
                                        PbActivity.this.fKI.bjH();
                                        PbActivity.this.fKF.sq(PbActivity.this.bgP());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.rs(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(e.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().beV() != null && PbActivity.this.fKF.getPbData().beV().zj() && PbActivity.this.fKF.getPbData().beV().yN() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.fKF.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fKF.bfR()) && PbActivity.this.fKF.getAppealInfo() != null) {
                                        name = PbActivity.this.fKF.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fKF.getPbData().beT().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bfR = PbActivity.this.fKF.bfR();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fKF.bhR() && bfR != null && bfR.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.kX()) {
                            if (PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().bfh() == 1 && !PbActivity.this.cNV.bCN()) {
                                PbActivity.this.fKI.bjW();
                                int i7 = 0;
                                if (PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biN()) {
                                    if (PbActivity.this.fKI.fTE.bkT() == null || view != PbActivity.this.fKI.fTE.bkT().biP()) {
                                        if (view == PbActivity.this.fKI.bjF()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.fKF.getPbData().beV().yr() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.fKF.getPbData().beV().yq() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData beT = PbActivity.this.fKF.getPbData().beT();
                                String name2 = beT.getName();
                                String id3 = beT.getId();
                                String id4 = PbActivity.this.fKF.getPbData().beV().getId();
                                PbActivity.this.fKI.bjE();
                                PbActivity.this.cNV.a(id3, name2, id4, i7, PbActivity.this.fKI.bjG());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(e.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.kX()) {
                        PbActivity.this.fKI.bjW();
                        PbActivity.this.azQ();
                        PbActivity.this.fKI.bjH();
                        PbActivity.this.fKI.showLoadingDialog();
                        if (PbActivity.this.fKI.bju() != null) {
                            PbActivity.this.fKI.bju().setVisibility(8);
                        }
                        PbActivity.this.fKF.rA(1);
                        if (PbActivity.this.fKm != null) {
                            PbActivity.this.fKm.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(e.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(e.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == e.g.reply_god_title_group) {
                        String bgw = PbActivity.this.bgw();
                        if (!TextUtils.isEmpty(bgw)) {
                            ay.CU().c(PbActivity.this.getPageContext(), new String[]{bgw});
                        }
                    }
                } else if (PbActivity.this.fKw) {
                    PbActivity.this.fKw = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(e.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData3 = (PostData) obj;
                            if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.bgr().bjk() != null && postData3.yv() != null && postData3.bCb() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bgr().bjl() != null) {
                                    PbActivity.this.bgr().bjl().bhC();
                                }
                                com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                jVar.a(PbActivity.this.fKF.getPbData().beT());
                                jVar.aa(PbActivity.this.fKF.getPbData().beV());
                                jVar.e(postData3);
                                PbActivity.this.bgr().bjk().d(jVar);
                                PbActivity.this.bgr().bjk().setPostId(postData3.getId());
                                PbActivity.this.a(view, postData3.yv().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fKV != null) {
                                    PbActivity.this.fKI.lc(PbActivity.this.fKV.Ln());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.v vVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null) {
                    amVar.ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getPbData().getForumId());
                }
                if (PbActivity.this.fKF != null) {
                    amVar.ax("tid", PbActivity.this.fKF.bhP());
                }
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.azQ();
            PbActivity.this.fKI.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.an.Oo() && PbActivity.this.bga() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bga().su(postWriteCallBackData.getPostId());
                    PbActivity.this.fLi = PbActivity.this.fKI.bjp();
                    if (PbActivity.this.fKF != null) {
                        PbActivity.this.fKF.bx(PbActivity.this.fLi, PbActivity.this.fKI.bjq());
                    }
                }
                PbActivity.this.fKI.bjW();
                PbActivity.this.fKN.bkw();
                if (PbActivity.this.fKV != null) {
                    PbActivity.this.fKI.lc(PbActivity.this.fKV.Ln());
                }
                PbActivity.this.fKI.bjj();
                PbActivity.this.fKI.le(true);
                PbActivity.this.fKF.bif();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fKF.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKF.getPbData();
                            if (pbData != null && pbData.beV() != null && pbData.beV().yv() != null && (userId = pbData.beV().yv().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.an.Oo() && PbActivity.this.fKF.bhY()) {
                                PbActivity.this.fKI.bjH();
                            }
                        } else if (!com.baidu.tbadk.p.an.Oo() && PbActivity.this.fKF.bhY()) {
                            PbActivity.this.fKI.bjH();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fKI.n(PbActivity.this.fKF.getPbData());
                    }
                    if (PbActivity.this.fKF.bhU()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").ax("tid", PbActivity.this.fKF.bhP()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fKV.Lt() || PbActivity.this.fKV.Lu()) {
                    PbActivity.this.fKV.a(false, postWriteCallBackData);
                }
                PbActivity.this.fKN.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.eWW != null) {
                    PbActivity.this.eWW.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (vVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fLH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.v vVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null) {
                    amVar.ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getPbData().getForumId());
                }
                if (PbActivity.this.fKF != null) {
                    amVar.ax("tid", PbActivity.this.fKF.bhP());
                }
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fKN != null) {
                    PbActivity.this.fKN.bkv();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.eWW != null) {
                    PbActivity.this.eWW.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fKN != null) {
                if (PbActivity.this.fKI != null && PbActivity.this.fKI.bjl() != null && PbActivity.this.fKI.bjl().bhH() != null && PbActivity.this.fKI.bjl().bhH().Lu()) {
                    PbActivity.this.fKI.bjl().bhH().a(postWriteCallBackData);
                }
                PbActivity.this.fKN.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fLI = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g ff;
            if (!z || dVar == null || dVar.bff() != null || com.baidu.tbadk.core.util.v.I(dVar.beX()) >= 1) {
                PbActivity.this.fnX = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fKI.bjJ();
                if (dVar == null || !dVar.bfb()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fKI.getView());
                }
                PbActivity.this.fKI.aRg();
                if (PbActivity.this.isFullScreen || PbActivity.this.fKI.bko()) {
                    PbActivity.this.fKI.bkf();
                } else if (!PbActivity.this.fKI.bkc()) {
                    PbActivity.this.fKI.le(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fKP = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.fKI.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.fKI.amh();
                    if (dVar.beV() != null && dVar.beV().zq() != null) {
                        PbActivity.this.a(dVar.beV().zq());
                    }
                    PbActivity.this.bgo();
                    if (PbActivity.this.fKV != null) {
                        PbActivity.this.fKI.lc(PbActivity.this.fKV.Ln());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.beX() != null && dVar.beX().size() >= 1 && dVar.beX().get(0) != null) {
                        PbActivity.this.fKF.st(dVar.beX().get(0).getId());
                    } else if (dVar.bff() != null) {
                        PbActivity.this.fKF.st(dVar.bff().getId());
                    }
                    if (PbActivity.this.fKV != null) {
                        PbActivity.this.fKV.a(dVar.xs());
                        PbActivity.this.fKV.a(dVar.beT(), dVar.getUserData());
                        PbActivity.this.fKV.a(PbActivity.this.fKF.bhZ(), PbActivity.this.fKF.bhP(), PbActivity.this.fKF.bir());
                        if (dVar.beV() != null) {
                            PbActivity.this.fKV.cf(dVar.beV().zG());
                        }
                    }
                    if (PbActivity.this.fKH != null) {
                        PbActivity.this.fKH.ay(dVar.vc());
                    }
                    if (dVar == null || dVar.bfi() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fKI.ld(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fKI.a(dVar, i2, i3, PbActivity.this.fKF.bhQ(), i4, PbActivity.this.fKF.getIsFromMark());
                    PbActivity.this.fKI.d(dVar, PbActivity.this.fKF.bhQ());
                    PbActivity.this.fKI.la(PbActivity.this.fKF.getHostMode());
                    AntiData xs = dVar.xs();
                    if (xs != null) {
                        PbActivity.this.aVI = xs.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aVI) && PbActivity.this.fKV != null && PbActivity.this.fKV.KH() != null && (ff = PbActivity.this.fKV.KH().ff(6)) != null && !TextUtils.isEmpty(PbActivity.this.aVI)) {
                            ((View) ff).setOnClickListener(PbActivity.this.aWs);
                        }
                    }
                    if (PbActivity.this.fKR) {
                        PbActivity.this.fKR = false;
                        final int bgE = PbActivity.this.bgE();
                        if (dVar.bfu()) {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bgE, aO);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bgr().rM(bgE);
                        }
                    }
                    if (PbActivity.this.fKS) {
                        PbActivity.this.fKS = false;
                        final int bgE2 = PbActivity.this.bgE();
                        final boolean z2 = bgE2 != -1;
                        if (!z2) {
                            bgE2 = PbActivity.this.bgF();
                        }
                        if (PbActivity.this.bgr() != null) {
                            if (dVar.bfu()) {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bgE2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bgE2, aO2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bgE2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.bgr().lf(true);
                            } else {
                                PbActivity.this.bgr().rM(bgE2);
                            }
                        }
                    } else {
                        PbActivity.this.fKI.bjN();
                    }
                    PbActivity.this.fKF.a(dVar.beT(), PbActivity.this.fLv);
                    PbActivity.this.fKF.a(PbActivity.this.fLw);
                    if (PbActivity.this.eWW != null && dVar.beV() != null && dVar.beV().yv() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.beV().yv());
                        PbActivity.this.eWW.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fKP && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fKF != null && PbActivity.this.fKF.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fKF.getAppealInfo().fHy)) {
                                    PbActivity.this.fKI.a(PbActivity.this.fKF.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fKI.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0175e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fKI.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0175e.ds200));
                            }
                            PbActivity.this.fKI.bkf();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fKF.bhP());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.j jVar = new com.baidu.tbadk.core.util.j();
                        jVar.setOpType("2");
                        jVar.start();
                    }
                    if (i != -1) {
                        PbActivity.this.fKI.sx(PbActivity.this.getResources().getString(e.j.list_no_more_new));
                    } else {
                        PbActivity.this.fKI.sx("");
                    }
                    PbActivity.this.fKI.DP();
                }
                PbActivity.this.bbI = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bga().bhQ() || PbActivity.this.bga().getPbData().xH().xE() != 0 || PbActivity.this.bga().bil()) {
                    PbActivity.this.fKW = true;
                    return;
                }
                return;
            }
            PbActivity.this.fKF.rA(1);
            if (PbActivity.this.fKm != null) {
                PbActivity.this.fKm.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fKI.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.m.NX().NY()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.dgR : j;
                com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, PbActivity.this.bbA, PbActivity.this.createTime, PbActivity.this.bbI, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.bbA = 0L;
                if (iVar != null) {
                    iVar.NU();
                }
                if (z2) {
                    iVar.bbR = currentTimeMillis;
                    iVar.ct(true);
                }
                if (!z2 && PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().beV() != null) {
                    int threadType = PbActivity.this.fKF.getPbData().beV().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fKz, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fKz, "from_frs")) {
                                com.baidu.tbadk.l.i iVar2 = new com.baidu.tbadk.l.i();
                                iVar2.fG(1000);
                                iVar2.bbT = currentTimeMillis;
                                iVar2.fH(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.l.d dVar = new com.baidu.tbadk.l.d();
                        dVar.pageType = 1;
                        dVar.fG(1005);
                        dVar.bbT = currentTimeMillis;
                        dVar.fH(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fLJ = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bgA();
            }
        }
    };
    private final a.InterfaceC0120a fLK = new a.InterfaceC0120a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0120a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fKI.bjJ();
            if (z) {
                if (PbActivity.this.fKH != null) {
                    PbActivity.this.fKH.ay(z2);
                }
                PbActivity.this.fKF.kI(z2);
                if (PbActivity.this.fKF.vc()) {
                    PbActivity.this.bgK();
                } else {
                    PbActivity.this.fKI.n(PbActivity.this.fKF.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fKH != null && PbActivity.this.fKH.vf() != null && PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().beV() != null && PbActivity.this.fKF.getPbData().beV().yv() != null) {
                        MarkData vf = PbActivity.this.fKH.vf();
                        MetaData yv = PbActivity.this.fKF.getPbData().beV().yv();
                        if (vf != null && yv != null) {
                            if (!com.baidu.tbadk.core.util.ao.equals(TbadkCoreApplication.getCurrentAccount(), yv.getUserId()) && !yv.hadConcerned()) {
                                PbActivity.this.b(yv);
                                return;
                            } else {
                                PbActivity.this.showToast(e.j.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.ro(PbActivity.this.mLastScrollState) && PbActivity.this.ro(i)) {
                if (PbActivity.this.fKI != null) {
                    PbActivity.this.fKI.bjW();
                    if (PbActivity.this.fKV != null && !PbActivity.this.fKI.bjn()) {
                        PbActivity.this.fKI.lc(PbActivity.this.fKV.Ln());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fKI.bjm();
                    }
                }
                if (!PbActivity.this.fKt) {
                    PbActivity.this.fKt = true;
                    PbActivity.this.fKI.bkb();
                }
            }
            PbActivity.this.fKI.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fKm != null) {
                PbActivity.this.fKm.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fKu == null) {
                PbActivity.this.fKu = new com.baidu.tbadk.l.b();
                PbActivity.this.fKu.fG(1001);
            }
            if (i == 0) {
                PbActivity.this.fKu.NO();
            } else {
                PbActivity.this.fKu.NN();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> beX;
            if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKI != null && PbActivity.this.fKI.bjD() != null) {
                PbActivity.this.fKI.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fKm != null) {
                    PbActivity.this.fKm.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fKF.bih() && (beX = PbActivity.this.fKF.getPbData().beX()) != null && !beX.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fKI.bjD().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKF.getPbData();
                    if (pbData != null) {
                        if (pbData.beY() != null && pbData.beY().hasData()) {
                            headerCount--;
                        }
                        if (pbData.beZ() != null && pbData.beZ().hasData()) {
                            headerCount--;
                        }
                        int size = beX.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cNZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cNV.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fKF.bif();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gaw != 1002 || bVar.eeV) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fKI.a(1, dVar.HV, dVar.hfr, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cNV.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fKI.a(PbActivity.this.cNV.getLoadDataMode(), gVar.HV, gVar.hfr, false);
                        PbActivity.this.fKI.aq(gVar.hfu);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fKI.a(PbActivity.this.cNV.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fLL = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
    };
    private final j.b bzr = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.tbadk.core.view.j.b
        public void bp(boolean z) {
            if (PbActivity.this.bgQ()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fKF.kH(true)) {
                PbActivity.this.fKI.bjK();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e dTv = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fLM && PbActivity.this.bgQ()) {
                PbActivity.this.bgS();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fKF.kG(false)) {
                    PbActivity.this.fKI.bjI();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fKF.getPbData() != null) {
                    PbActivity.this.fKI.bka();
                }
                PbActivity.this.fLM = true;
            }
        }
    };
    private int fLN = 0;
    private final TbRichTextView.h bnD = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fKI.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(e.g.tag_rich_text_meme_info) != null && (view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    PbActivity.this.fKD = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fMC) {
                    TbRichText aK = PbActivity.this.aK(str, i);
                    if (aK != null && PbActivity.this.fLN >= 0 && PbActivity.this.fLN < aK.QK().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aK.QK().get(PbActivity.this.fLN));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fMz.size()) {
                                break;
                            } else if (!cVar.fMz.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.J(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fMA.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fMB, cVar.lastId, PbActivity.this.fKF.bic(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbActivity.this.l(rect);
                        createConfig.setIsHotSort(PbActivity.this.fKF.aaJ() == 2);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.d(cVar.fMz, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.J(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fMA.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fMB, cVar.fMz.get(0), PbActivity.this.fKF.bic(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                createConfig2.setIsHotSort(PbActivity.this.fKF.aaJ() == 2);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fLO = false;
    PostData fLP = null;
    private final b.InterfaceC0124b fLQ = new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fLP != null) {
                if (i == 0) {
                    PbActivity.this.fLP.da(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fLP = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fLP);
                }
            }
        }
    };
    private final b.InterfaceC0124b fLR = new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fLf != null && !TextUtils.isEmpty(PbActivity.this.fLg)) {
                if (i == 0) {
                    if (PbActivity.this.fLh == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fLg));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fLg;
                        aVar.pkgId = PbActivity.this.fLh.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fLh.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.buX == null) {
                        PbActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.buX.Di();
                    PbActivity.this.buX.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.buX.z(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fLe == null) {
                            PbActivity.this.fLe = new av(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fLe.i(PbActivity.this.fLg, PbActivity.this.fLf.ov());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fLf = null;
                PbActivity.this.fLg = null;
            }
        }
    };
    private final View.OnLongClickListener aOZ = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX WARN: Removed duplicated region for block: B:122:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0190  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            SparseArray<Object> sparseArray;
            boolean z;
            SparseArray<Object> sparseArray2;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (PbActivity.this.bt(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.fLf = ((TbImageView) view).getBdImage();
                        PbActivity.this.fLg = ((TbImageView) view).getUrl();
                        if (PbActivity.this.fLf != null && !TextUtils.isEmpty(PbActivity.this.fLg)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fLh = null;
                            } else {
                                PbActivity.this.fLh = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                PbActivity.this.fKI.a(PbActivity.this.fLR, PbActivity.this.fLf.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                sparseArray = sparseArray2;
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.fLf = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.fLg = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fLh = null;
                            } else {
                                PbActivity.this.fLh = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.fLf = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.fLg = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.fLh = null;
                        } else {
                            PbActivity.this.fLh = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                        }
                    }
                    if (!(view.getParent() instanceof TbRichTextView)) {
                    }
                    if (sparseArray2 != null) {
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 != null) {
                }
                return true;
            }
            PbActivity.this.fLP = (PostData) sparseArray.get(e.g.tag_clip_board);
            if (PbActivity.this.fLP != null) {
                if (PbActivity.this.fLP.bCb() != 1 || !PbActivity.this.bt(view)) {
                    if (PbActivity.this.fKH != null) {
                        boolean z2 = PbActivity.this.fKH.vc() && PbActivity.this.fLP.getId() != null && PbActivity.this.fLP.getId().equals(PbActivity.this.fKF.yF());
                        if (view == null || sparseArray == null) {
                            z = false;
                        } else {
                            if (PbActivity.this.fKO == null) {
                                PbActivity.this.fKO = new y(PbActivity.this.getPageContext(), PbActivity.this.dCe);
                                PbActivity.this.fKI.bC(PbActivity.this.fKO.getView());
                                PbActivity.this.fKO.kK(PbActivity.this.mIsLogin);
                            }
                            if (PbActivity.this.fLP.bCb() == 1) {
                                PbActivity.this.fKI.a(PbActivity.this.fLQ, z2, false);
                            } else {
                                PbActivity.this.fKO.showDialog();
                                z = PbActivity.this.ks(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & PbActivity.this.isLogin();
                            }
                        }
                        boolean booleanValue = sparseArray.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            PbActivity.this.fKO.biB().setText(e.j.remove_mark);
                        } else {
                            PbActivity.this.fKO.biB().setText(e.j.mark);
                        }
                        if (booleanValue) {
                            PbActivity.this.fKO.biB().setVisibility(8);
                        } else {
                            PbActivity.this.fKO.biB().setVisibility(0);
                        }
                        if (PbActivity.this.bt(view)) {
                            if (PbActivity.this.fLf != null && !PbActivity.this.fLf.isGif()) {
                                sparseArray.put(e.g.tag_richtext_image, true);
                            } else {
                                sparseArray.put(e.g.tag_richtext_image, false);
                            }
                            sparseArray.put(e.g.tag_richtext_emotion, true);
                        } else {
                            sparseArray.put(e.g.tag_richtext_image, false);
                            sparseArray.put(e.g.tag_richtext_emotion, false);
                        }
                        PbActivity.this.fKO.a(sparseArray, PbActivity.this.fKF.getPbData().bfh(), z);
                        PbActivity.this.fKO.refreshUI();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").ax("tid", PbActivity.this.fKF.fPL).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getForumId()).ax("uid", PbActivity.this.fKF.getPbData().beV().yv().getUserId()).ax("post_id", PbActivity.this.fKF.Lc()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, booleanValue ? 2 : 1));
                    }
                } else {
                    PbActivity.this.fKI.a(PbActivity.this.fLR, PbActivity.this.fLf.isGif());
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dxY = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (!PbActivity.this.fKo && z && !PbActivity.this.fKF.bhX()) {
                PbActivity.this.bgM();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0175e.ds200));
        }
    };
    public View.OnTouchListener bez = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.bYq.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0179a bYr = new a.InterfaceC0179a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        final int cBT;

        {
            this.cBT = (int) PbActivity.this.getResources().getDimension(e.C0175e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void af(int i, int i2) {
            if (ag(i2) && PbActivity.this.fKI != null && PbActivity.this.fKm != null) {
                PbActivity.this.fKI.bkg();
                PbActivity.this.fKm.gC(false);
                PbActivity.this.fKm.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void ag(int i, int i2) {
            if (ag(i2) && PbActivity.this.fKI != null && PbActivity.this.fKm != null) {
                PbActivity.this.fKm.gC(true);
                if (Math.abs(i2) > this.cBT) {
                    PbActivity.this.fKm.hideFloatingView();
                }
                if (PbActivity.this.bgQ()) {
                    PbActivity.this.fKI.bjz();
                    PbActivity.this.fKI.bjA();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void ah(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fLT = null;
    private final m.a fLU = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void j(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(e.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fLT = str2;
                PbActivity.this.fKI.sy(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fLV = -1;
    private int fLW = -1;
    private CustomMessageListener fLZ = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.aks == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0122a) {
                    if (aVar.akt != null && !aVar.akt.hasError() && aVar.akt.getError() == 0) {
                        if (PbActivity.this.fKI != null) {
                            PbActivity.this.fKI.n(((a.C0122a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bhb();
                        }
                    } else if (z) {
                        if (aVar.akt != null && aVar.akt.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.akt.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.akt != null && !aVar.akt.hasError() && aVar.akt.getError() == 0) {
                        if (PbActivity.this.fKI != null && PbActivity.this.fKI != null) {
                            PbActivity.this.fKI.n(((a.C0122a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.akt != null && aVar.akt.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.akt.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.akt == null || aVar.akt.hasError() || aVar.akt.getError() != 0) {
                        if (z) {
                            if (aVar.akt != null && aVar.akt.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.akt.getErrorString());
                            } else {
                                PbActivity.this.showToast(e.j.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    }
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void m(Object obj);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public ConcurrentHashMap<String, ImageUrlData> fMA;
        public boolean fMC;
        public ArrayList<String> fMz;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fMB = false;
        public boolean fMD = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes6.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d bgm() {
        return this.fKV;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bfC() != null) {
            String id = jVar.bfC().getId();
            ArrayList<PostData> beX = this.fKF.getPbData().beX();
            int i = 0;
            while (true) {
                if (i >= beX.size()) {
                    break;
                }
                PostData postData = beX.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bfG = jVar.bfG();
                    postData.uF(jVar.getTotalCount());
                    if (postData.bBY() != null && bfG != null) {
                        Iterator<PostData> it = bfG.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.yv() != null && (metaData = postData.getUserMap().get(next.yv().getUserId())) != null) {
                                next.a(metaData);
                                next.nh(true);
                                next.a(getPageContext(), this.fKF.ss(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bfG.size() != postData.bBY().size();
                        postData.bBY().clear();
                        postData.bBY().addAll(bfG);
                        z = z2;
                    }
                    if (postData.bBU() != null) {
                        postData.bBV();
                    }
                }
            }
            if (!this.fKF.getIsFromMark() && z) {
                this.fKI.n(this.fKF.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(String str) {
        com.baidu.tieba.tbadkCore.data.l bfl;
        if (!TextUtils.isEmpty(str) && (bfl = this.fKF.getPbData().bfl()) != null && str.equals(bfl.getAdId())) {
            if (bfl.bBP() != null) {
                bfl.bBP().legoCard = null;
            }
            this.fKF.getPbData().bfm();
        }
    }

    public void bgn() {
        com.baidu.tieba.pb.data.d pbData;
        bb beV;
        if (!this.fLy) {
            if (!com.baidu.adp.lib.util.l.lo()) {
                showToast(e.j.no_network_guide);
            } else if (this.fLB) {
                this.fLy = true;
                if (this.fKF != null && (pbData = this.fKF.getPbData()) != null && (beV = pbData.beV()) != null) {
                    int isLike = beV.yi() == null ? 0 : beV.yi().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10796").ax("tid", beV.getId()));
                    }
                    if (this.fLz != null) {
                        this.fLz.a(beV.yM(), beV.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(e.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
                bVar.cC(e.j.operation);
                int i = -1;
                if (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(e.j.delete);
                    strArr[1] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fKI.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fLc);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fLc);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fLc);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fLc);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).Ax();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(int i) {
        bb beV;
        String str;
        String L;
        if (this.fKF != null && this.fKF.getPbData() != null && (beV = this.fKF.getPbData().beV()) != null) {
            if (i == 1) {
                PraiseData yi = beV.yi();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yi == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        beV.a(praiseData);
                    } else {
                        beV.yi().getUser().add(0, metaData);
                        beV.yi().setNum(beV.yi().getNum() + 1);
                        beV.yi().setIsLike(i);
                    }
                }
                if (beV.yi() != null) {
                    if (beV.yi().getNum() < 1) {
                        L = getResources().getString(e.j.zan);
                    } else {
                        L = com.baidu.tbadk.core.util.ao.L(beV.yi().getNum());
                    }
                    this.fKI.U(L, true);
                }
            } else if (beV.yi() != null) {
                beV.yi().setIsLike(i);
                beV.yi().setNum(beV.yi().getNum() - 1);
                ArrayList<MetaData> user = beV.yi().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            beV.yi().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (beV.yi().getNum() < 1) {
                    str = getResources().getString(e.j.zan);
                } else {
                    str = beV.yi().getNum() + "";
                }
                this.fKI.U(str, false);
            }
            if (this.fKF.bhQ()) {
                this.fKI.bjD().notifyDataSetChanged();
            } else {
                this.fKI.o(this.fKF.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fKF.A(bundle);
        if (this.dAm != null) {
            this.dAm.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fKV.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fKs = System.currentTimeMillis();
        this.fLa = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dgR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fKz = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fKz) && intent.getData() != null) {
                this.fKz = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fKz)) {
                this.fKn = true;
            }
            this.fLV = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fLW = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fLX = intent.getStringExtra("key_manga_title");
            this.fKR = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fKS = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bgQ()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ao.isEmpty(this.source) ? "" : this.source;
            this.fLj = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dgR = System.currentTimeMillis();
        }
        this.bbA = this.fKs - this.dgR;
        super.onCreate(bundle);
        this.fKq = 0;
        z(bundle);
        if (this.fKF != null && this.fKF.getPbData() != null) {
            this.fKF.getPbData().si(this.source);
        }
        initUI();
        if (intent != null && this.fKI != null) {
            this.fKI.fTx = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fLd == null) {
                    this.fLd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fKI.sA("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fLd, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fKF != null && this.fKF.getPbData() != null) {
                this.fKF.sv(stringExtra);
            }
        }
        this.dAm = new VoiceManager();
        this.dAm.onCreate(getPageContext());
        initData(bundle);
        this.fKU = new com.baidu.tbadk.editortools.pb.f();
        bgo();
        this.fKV = (com.baidu.tbadk.editortools.pb.d) this.fKU.bM(getActivity());
        this.fKV.b(this);
        this.fKV.a(this.aVS);
        this.fKV.a(this.aVL);
        this.fKV.a(this, bundle);
        this.fKV.KH().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fKV.KH().bY(true);
        kr(true);
        this.fKI.setEditorTools(this.fKV.KH());
        this.fKV.a(this.fKF.bhZ(), this.fKF.bhP(), this.fKF.bir());
        registerListener(this.fLq);
        if (!this.fKF.bhW()) {
            this.fKV.hv(this.fKF.bhP());
        }
        if (this.fKF.bis()) {
            this.fKV.ht(getPageContext().getString(e.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fKV.ht(getPageContext().getString(e.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fLp);
        registerListener(this.fLr);
        registerListener(this.fLs);
        registerListener(this.dBv);
        registerListener(this.fLG);
        registerListener(this.fLo);
        this.fKT = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.hcv);
        this.fKT.bBC();
        registerListener(this.fLu);
        registerListener(this.mAttentionListener);
        if (this.fKF != null) {
            this.fKF.bij();
        }
        registerListener(this.fLJ);
        registerListener(this.fLZ);
        registerListener(this.dBC);
        if (this.fKI != null && this.fKI.bkk() != null && this.fKI.bkl() != null) {
            this.fKm = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.fKI.bkk(), this.fKI.bkl(), this.fKI.bju());
            this.fKm.a(this.fLC);
        }
        if (this.fKl && this.fKI != null && this.fKI.bkl() != null) {
            this.fKI.bkl().setVisibility(8);
        }
        this.fLb = new com.baidu.tbadk.core.view.g();
        this.fLb.aCM = 1000L;
        registerListener(this.fLF);
        registerListener(this.fLD);
        registerListener(this.fLE);
        registerListener(this.dSV);
        this.fLc = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fLc;
        userMuteAddAndDelCustomMessage.setTag(this.fLc);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fLc;
        userMuteCheckCustomMessage.setTag(this.fLc);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fKF.bip().a(this.crf);
        this.fKN = new at();
        if (this.fKV.Lg() != null) {
            this.fKN.g(this.fKV.Lg().getInputView());
        }
        this.fKV.a(this.aVM);
        this.dQb = new ShareSuccessReplyToServerModel();
        a(this.fLl);
        this.eWW = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.eWW.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.axJ) {
                        PbActivity.this.fKV.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.axK && PbActivity.this.fKI != null && PbActivity.this.fKI.bjl() != null && PbActivity.this.fKI.bjl().bhH() != null) {
                        PbActivity.this.fKI.bjl().bhH().Lz();
                    } else if (i == com.baidu.tbadk.core.util.aj.axL) {
                        PbActivity.this.c(PbActivity.this.fKX);
                    }
                }
            }
        });
        this.fKG = new com.baidu.tieba.pb.pb.report.a(this);
        this.fKG.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.fKs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgo() {
        if (this.fKU != null && this.fKF != null) {
            this.fKU.setForumName(this.fKF.bfR());
            if (this.fKF.getPbData() != null && this.fKF.getPbData().beT() != null) {
                this.fKU.a(this.fKF.getPbData().beT());
            }
            this.fKU.setFrom("pb");
            this.fKU.a(this.fKF);
        }
    }

    public String bgp() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bgq() {
        return this.fKm;
    }

    private void kr(boolean z) {
        this.fKV.cc(z);
        this.fKV.cd(z);
        this.fKV.ce(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().bfu() && !z && this.fKI != null && this.fKI.getView() != null) {
            this.fKI.getView().setSystemUiVisibility(4);
        }
        this.fKY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dAm != null) {
            this.dAm.onStart(getPageContext());
        }
    }

    public ar bgr() {
        return this.fKI;
    }

    public PbModel bga() {
        return this.fKF;
    }

    public void sl(String str) {
        if (this.fKF != null && !StringUtils.isNull(str) && this.fKI != null) {
            this.fKI.lh(true);
            this.fKF.sl(str);
            this.fKy = true;
            this.fKI.bjW();
            this.fKI.bkf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fKo = false;
        } else {
            this.fKo = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fKq = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fKq == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dAm != null) {
            this.dAm.onPause(getPageContext());
        }
        if (this.fKI != null) {
            this.fKI.onPause();
        }
        if (!this.fKF.bhW()) {
            this.fKV.hu(this.fKF.bhP());
        }
        if (this.fKF != null) {
            this.fKF.bik();
        }
        MessageManager.getInstance().unRegisterListener(this.eAS);
        aKP();
        MessageManager.getInstance().unRegisterListener(this.fLD);
        MessageManager.getInstance().unRegisterListener(this.fLE);
        MessageManager.getInstance().unRegisterListener(this.fLF);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bgs() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fKF.getPbData(), this.fKF.bhQ(), this.fKF.getRequestType());
        return (a2 == null || a2.yv() == null || a2.yv().getGodUserData() == null || a2.yv().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fKo = false;
        super.onResume();
        if (this.fKB) {
            this.fKB = false;
            bgW();
        }
        if (bgs()) {
            this.fKv = System.currentTimeMillis();
        } else {
            this.fKv = -1L;
        }
        if (this.fKI != null && this.fKI.getView() != null) {
            if (!this.fnX) {
                bgN();
            } else {
                hideLoadingView(this.fKI.getView());
            }
            this.fKI.onResume();
        }
        if (this.fKq == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fKI != null) {
            noNetworkView = this.fKI.bji();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kX()) {
            noNetworkView.bm(false);
        }
        if (this.dAm != null) {
            this.dAm.onResume(getPageContext());
        }
        registerListener(this.eAS);
        this.fKQ = false;
        bgV();
        registerListener(this.fLD);
        registerListener(this.fLE);
        registerListener(this.fLF);
        if (this.dAU) {
            bgM();
            this.dAU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fKI.kV(z);
        if (this.fKO != null) {
            this.fKO.kK(z);
        }
        if (z && this.fKQ) {
            this.fKI.bjI();
            this.fKF.kG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fKv > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").ax("obj_duration", (System.currentTimeMillis() - this.fKv) + ""));
            this.fKv = 0L;
        }
        if (bgr().bjl() != null) {
            bgr().bjl().onStop();
        }
        if (this.fKI.fTE != null && !this.fKI.fTE.aoW()) {
            this.fKI.fTE.aWf();
        }
        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().beT() != null && this.fKF.getPbData().beV() != null) {
            com.baidu.tbadk.distribute.a.Ku().a(getPageContext().getPageActivity(), "pb", this.fKF.getPbData().beT().getId(), com.baidu.adp.lib.g.b.d(this.fKF.getPbData().beV().getId(), 0L));
        }
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.ax(ImageViewerConfig.FORUM_ID, this.fKF.getPbData().getForumId());
            amVar.ax("tid", this.fKF.bhP());
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.fKt && this.fKI != null) {
            this.fKt = true;
            this.fKI.bkb();
            a(false, (PostData) null);
        }
        if (this.fKF != null) {
            this.fKF.cancelLoadData();
            this.fKF.destory();
            if (this.fKF.bio() != null) {
                this.fKF.bio().onDestroy();
            }
        }
        if (this.fKV != null) {
            this.fKV.onDestroy();
        }
        if (this.cNV != null) {
            this.cNV.cancelLoadData();
        }
        if (this.fKI != null) {
            this.fKI.onDestroy();
            if (this.fKI.fTE != null) {
                this.fKI.fTE.aWf();
            }
        }
        if (this.fKu != null) {
            this.fKu.NP();
        }
        if (this.fKm != null) {
            this.fKm.ON();
        }
        super.onDestroy();
        if (this.dAm != null) {
            this.dAm.onDestory(getPageContext());
        }
        this.fKI.bjW();
        MessageManager.getInstance().unRegisterListener(this.fLD);
        MessageManager.getInstance().unRegisterListener(this.fLE);
        MessageManager.getInstance().unRegisterListener(this.fLF);
        MessageManager.getInstance().unRegisterListener(this.fLc);
        MessageManager.getInstance().unRegisterListener(this.fLG);
        MessageManager.getInstance().unRegisterListener(this.dBC);
        MessageManager.getInstance().unRegisterListener(this.dSV);
        this.fLa = null;
        this.fLb = null;
        com.baidu.tieba.recapp.d.a.bua().buc();
        if (this.fLd != null) {
            getSafeHandler().removeCallbacks(this.fLd);
        }
        if (this.fKC != null) {
            this.fKC.cancelLoadData();
        }
        if (this.fKI != null && this.fKI.fTE != null) {
            this.fKI.fTE.bkX();
        }
        if (this.dQb != null) {
            this.dQb.cancelLoadData();
        }
        this.fKN.onDestroy();
        if (this.dAY != null) {
            this.dAY.onDestroy();
        }
        if (this.fKF != null && this.fKF.biq() != null) {
            this.fKF.biq().onDestroy();
        }
        if (this.eWW != null) {
            this.eWW.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bjD;
        ArrayList<PostData> bht;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.Fe() && this.fKI != null && (bjD = this.fKI.bjD()) != null && (bht = bjD.bht()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bht.iterator();
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
                        bVar.cPU = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.apX == 1 && !TextUtils.isEmpty(id)) {
                    next.apX = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.cPU = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fKF == null || this.fKF.getPbData() == null || this.fKF.getPbData().beT() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fKF.getPbData().beT().getFirst_class();
                    str2 = this.fKF.getPbData().beT().getSecond_class();
                    str = this.fKF.getPbData().beT().getId();
                    str4 = this.fKF.bhP();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Fh());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fKI.onChangeSkinType(i);
            if (this.fKV != null && this.fKV.KH() != null) {
                this.fKV.KH().onChangeSkinType(i);
            }
            if (this.fKI.bji() != null) {
                this.fKI.bji().onChangeSkinType(getPageContext(), i);
            }
            this.fKN.onChangeSkinType();
            if (this.dAY != null) {
                this.dAY.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fKI = new ar(this, this.dCe, this.bnE);
        this.bYq = new com.baidu.tieba.f.b(getActivity());
        this.bYq.a(fLS);
        this.bYq.a(this.bYr);
        this.fKI.setOnScrollListener(this.mOnScrollListener);
        this.fKI.e(this.dTv);
        this.fKI.a(this.bzr);
        this.fKI.kl(com.baidu.tbadk.core.i.ws().ww());
        this.fKI.setOnImageClickListener(this.bnD);
        this.fKI.b(this.aOZ);
        this.fKI.h(this.dxY);
        this.fKI.a(this.fLL);
        this.fKI.kV(this.mIsLogin);
        if (getIntent() != null) {
            this.fKI.li(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fKI.bjk().setFromForumId(this.fKF.getFromForumId());
    }

    public void bgt() {
        if (this.fKI != null && this.fKF != null) {
            if (this.fKF.getPbData() != null || this.fKF.getPbData().bft() != null) {
                TiebaStatic.log(bgx().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_locate", 4).x(VideoPlayActivityConfig.OBJ_ID, bga().getPbData().bft().bfz() ? 0 : 1));
                if (checkUpIsLogin() && this.fKI.bjD() != null && this.fKI.bjD().bhy() != null) {
                    this.fKI.bjD().bhy().fX(this.fKF.bhP());
                }
            }
        }
    }

    public void bgu() {
        TiebaStatic.log("c12181");
        if (this.fKI != null && this.fKF != null) {
            if (this.fKI == null || this.fKI.bjn()) {
                if (this.fKF.getPbData() != null || this.fKF.getPbData().bft() != null) {
                    com.baidu.tieba.pb.data.i bft = this.fKF.getPbData().bft();
                    TiebaStatic.log(bgx().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_locate", 4).x(VideoPlayActivityConfig.OBJ_ID, bft.bfz() ? 0 : 1));
                    if (checkUpIsLogin()) {
                        if ((!bft.bfz() || bft.zK() != 2) && this.fKI.bjD() != null && this.fKI.bjD().bhy() != null) {
                            this.fKI.bjD().bhy().fX(this.fKF.bhP());
                        }
                        if (System.currentTimeMillis() - this.fKx > SystemScreenshotManager.DELAY_TIME) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).lD(false);
                            this.fKx = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bq(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(e.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.hcX && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.ws().ww()) {
                    return so(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fKF == null || this.fKF.getPbData() == null) {
                        return true;
                    }
                    if (bgr().bjl() != null) {
                        bgr().bjl().bhC();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.fKF.getPbData().beT());
                    jVar.aa(this.fKF.getPbData().beV());
                    jVar.e(postData);
                    bgr().bjk().d(jVar);
                    bgr().bjk().setPostId(postData.getId());
                    a(view, postData.yv().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fKV != null) {
                        this.fKI.lc(this.fKV.Ln());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.fKI != null) {
            if (z && !this.fnX) {
                bgN();
            } else {
                hideLoadingView(this.fKI.getView());
            }
            if (z && this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().bfu() && this.fKI.getView() != null) {
                this.fKI.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bgv() {
        if (this.fKr == null) {
            this.fKr = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fKr.a(new String[]{getPageContext().getString(e.j.call_phone), getPageContext().getString(e.j.sms_phone), getPageContext().getString(e.j.search_in_baidu)}, new b.InterfaceC0124b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fKg = PbActivity.this.fKg.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKg);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fKF.bhP(), PbActivity.this.fKg, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fKg = PbActivity.this.fKg.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKg);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fKF.bhP(), PbActivity.this.fKg, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fKg = PbActivity.this.fKg.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKg);
                        bVar.dismiss();
                    }
                }
            }).cD(b.a.asB).cE(17).d(getPageContext());
        }
    }

    private void z(Bundle bundle) {
        this.fKF = new PbModel(this);
        this.fKF.a(this.fLI);
        if (this.fKF.bin() != null) {
            this.fKF.bin().a(this.fLU);
        }
        if (this.fKF.bim() != null) {
            this.fKF.bim().a(this.fLt);
        }
        if (this.fKF.bio() != null) {
            this.fKF.bio().b(this.fLn);
        }
        if (bundle != null) {
            this.fKF.initWithBundle(bundle);
        } else {
            this.fKF.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fKF.kJ(true);
        }
        aj.biX().T(this.fKF.bhO(), this.fKF.getIsFromMark());
        if (StringUtils.isNull(this.fKF.bhP())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fKz) && this.fKz != null) {
            this.fKF.rH(6);
        }
        this.fKF.Nj();
    }

    private void initData(Bundle bundle) {
        this.fKH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fKH != null) {
            this.fKH.a(this.fLK);
        }
        this.cNV = new ForumManageModel(this);
        this.cNV.setLoadDataCallBack(this.cNZ);
        this.axO = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fKI.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kX()) {
                    PbActivity.this.showToast(e.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fKF.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKF.getPbData().beT().getId(), PbActivity.this.fKF.getPbData().beT().getName(), PbActivity.this.fKF.getPbData().beV().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fLz.setUniqueId(getUniqueId());
        this.fLz.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fKI.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(e.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fLc;
        userMuteCheckCustomMessage.setTag(this.fLc);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bgw() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fKF != null && (pbData = this.fKF.getPbData()) != null) {
            return pbData.bfg().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.beV() != null) {
            if (dVar.beV().getThreadType() == 0) {
                return 1;
            }
            if (dVar.beV().getThreadType() == 54) {
                return 2;
            }
            if (dVar.beV().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData br(View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(e.g.tag_clip_board)) != null) {
            if (view instanceof PostPraiseView) {
                ((PostPraiseView) view).L(view);
                return postData;
            }
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.am bgx() {
        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12003");
        amVar.ax("tid", this.fKF.fPL);
        amVar.x("obj_type", 0);
        amVar.ax(ImageViewerConfig.FORUM_ID, this.fKF.getForumId());
        amVar.x("obj_param1", this.fKF.getPbData().beV().getThreadType() == 40 ? 2 : 1);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.ax("obj_param2", TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && bgy()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                @Override // java.lang.Runnable
                public void run() {
                    int h;
                    int aQ = (com.baidu.adp.lib.util.l.aQ(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        h = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0175e.ds120);
                    } else {
                        h = com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0175e.ds640);
                    }
                    int i = h - aQ;
                    if (i > 0) {
                        PbActivity.this.bgr().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bgr().bjl() != null) {
                        PbActivity.this.fKV.KH().setVisibility(8);
                        PbActivity.this.bgr().bjl().ci(str, str2);
                        com.baidu.tbadk.editortools.pb.g bhH = PbActivity.this.bgr().bjl().bhH();
                        if (bhH != null && PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null) {
                            bhH.a(PbActivity.this.fKF.getPbData().xs());
                        }
                        if (PbActivity.this.fKN.bkz() == null && PbActivity.this.bgr().bjl().bhH().LH() != null) {
                            PbActivity.this.bgr().bjl().bhH().LH().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fKN != null && PbActivity.this.fKN.bky() != null) {
                                        if (!PbActivity.this.fKN.bky().bLt()) {
                                            PbActivity.this.fKN.lk(false);
                                        }
                                        PbActivity.this.fKN.bky().ob(false);
                                    }
                                }
                            });
                            PbActivity.this.fKN.h(PbActivity.this.bgr().bjl().bhH().LH().getInputView());
                            PbActivity.this.bgr().bjl().bhH().a(PbActivity.this.fKZ);
                        }
                    }
                    PbActivity.this.bgr().bkf();
                }
            }, 500L);
        }
    }

    public boolean bgy() {
        if (this.eWW == null || this.fKF.getPbData() == null || this.fKF.getPbData().xs() == null) {
            return true;
        }
        return this.eWW.di(this.fKF.getPbData().xs().replyPrivateFlag);
    }

    public boolean rq(int i) {
        if (this.eWW == null || this.fKF.getPbData() == null || this.fKF.getPbData().xs() == null) {
            return true;
        }
        return this.eWW.w(this.fKF.getPbData().xs().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(e.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null && this.fKF != null && this.fKF.getPbData() != null && postData.bCb() != 1) {
            String bhP = this.fKF.bhP();
            String id = postData.getId();
            int bfh = this.fKF.getPbData() != null ? this.fKF.getPbData().bfh() : 0;
            c sp = sp(id);
            if (sp != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bhP, id, "pb", true, null, false, null, bfh, postData.blJ(), this.fKF.getPbData().xs(), false, postData.yv() != null ? postData.yv().getIconInfo() : null).addBigImageData(sp.fMz, sp.fMA, sp.fMB, sp.index);
                addBigImageData.setKeyPageStartFrom(this.fKF.biu());
                addBigImageData.setFromFrsForumId(this.fKF.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bgz() {
        if (this.fKF.getPbData() == null || this.fKF.getPbData().beV() == null) {
            return -1;
        }
        return this.fKF.getPbData().beV().yZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgA() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.us(this.fKF.getForumId()) && this.fKF.getPbData() != null && this.fKF.getPbData().beT() != null) {
            if (this.fKF.getPbData().beT().isLike() == 1) {
                this.fKF.biq().cz(this.fKF.getForumId(), this.fKF.bhP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ks(boolean z) {
        if (this.fKF == null || this.fKF.getPbData() == null) {
            return false;
        }
        return ((this.fKF.getPbData().bfh() != 0) || this.fKF.getPbData().beV() == null || this.fKF.getPbData().beV().yv() == null || TextUtils.equals(this.fKF.getPbData().beV().yv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bgB() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.p.t.Op()) {
            return "";
        }
        PostData bfc = bfc();
        if (this.fKF == null || (pbData = this.fKF.getPbData()) == null || pbData.getUserData() == null || pbData.beV() == null || bfc == null || bfc.yv() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bfc.yv().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.beV().yd() == 0) {
            return "";
        }
        if (pbData.beV().yd() == 0) {
            return getPageContext().getString(e.j.fans_call);
        }
        return getPageContext().getString(e.j.haved_fans_call);
    }

    private boolean kt(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fKF == null || this.fKF.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fKF.getPbData();
        if (pbData.bfh() == 0) {
            List<com.baidu.tbadk.core.data.ay> bfr = pbData.bfr();
            if (com.baidu.tbadk.core.util.v.I(bfr) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : bfr) {
                    if (ayVar != null && (tVar = ayVar.aoM) != null && tVar.amM && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            return z2;
        }
        return true;
    }

    private boolean ku(boolean z) {
        return (z || this.fKF == null || this.fKF.getPbData() == null || this.fKF.getPbData().bfh() == 0) ? false : true;
    }

    public void bgC() {
        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null && this.fKF.getPbData().beV().yv() != null) {
            if (this.fKI != null) {
                this.fKI.bjj();
            }
            bb beV = this.fKF.getPbData().beV();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), beV.yv().getUserId());
            ab abVar = new ab();
            int bfh = this.fKF.getPbData().bfh();
            if (bfh == 1) {
                abVar.fRN = true;
                abVar.fRM = true;
                abVar.fRU = beV.yq() == 1;
                abVar.fRT = beV.yr() == 1;
            } else {
                abVar.fRN = false;
                abVar.fRM = false;
            }
            if (bfh == 1002 && !equals) {
                abVar.fRY = true;
            }
            abVar.fRK = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.fRO = kt(equals);
            abVar.fRP = bgD();
            abVar.fRQ = ku(equals);
            abVar.qY = this.fKF.bhQ();
            abVar.fRL = true;
            abVar.fIE = this.fKH != null && this.fKH.vc();
            abVar.fRJ = ks(equals);
            abVar.fRW = bgB();
            abVar.fRI = equals && this.fKI.bjP();
            abVar.fRR = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fRS = true;
            abVar.isHostOnly = this.fKF.getHostMode();
            abVar.fRV = true;
            if (beV.yN() == null) {
                abVar.fRX = true;
            } else {
                abVar.fRX = false;
            }
            this.fKI.fTE.a(abVar);
        }
    }

    private boolean bgD() {
        if (this.fKF != null && this.fKF.bhQ()) {
            return this.fKF.getPageData() == null || this.fKF.getPageData().xE() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    public int bgE() {
        if (bgr() == null || bgr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bgr().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fIr) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bgF() {
        if (bgr() == null || bgr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bgr().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.hcW) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bgM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.ei(getResources().getString(e.j.mark_done));
            aVar.aV(true);
            aVar.ej(getResources().getString(e.j.mark_like));
            aVar.aU(true);
            aVar.aO(false);
            aVar.b(getResources().getString(e.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").ax(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).x("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(e.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").ax(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).x("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.axO.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fKF.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).Au();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fKI.bjJ();
        this.fKF.kI(z);
        if (this.fKH != null) {
            this.fKH.ay(z);
            if (markData != null) {
                this.fKH.a(markData);
            }
        }
        if (this.fKF.vc()) {
            bgK();
        } else {
            this.fKI.n(this.fKF.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ro(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sm(String str) {
        this.fKG.sJ(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fKF.bhW()) {
                    antiData.setBlock_forum_name(this.fKF.getPbData().beT().getName());
                    antiData.setBlock_forum_id(this.fKF.getPbData().beT().getId());
                    antiData.setUser_name(this.fKF.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fKF.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else if (bgr() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.am(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.ayy));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.ayy));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.ayy));
            }
        } else if (i == 230277) {
            hB(str);
        } else {
            this.fKI.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.hfr) ? bVar.hfr : getString(e.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ej(string);
                aVar.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.aO(true);
                aVar.b(getPageContext());
                aVar.Au();
            } else {
                this.fKI.a(0, bVar.HV, bVar.hfr, z);
            }
            if (bVar.HV) {
                if (bVar.hfp == 1) {
                    ArrayList<PostData> beX = this.fKF.getPbData().beX();
                    int size = beX.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(beX.get(i).getId())) {
                            i++;
                        } else {
                            beX.remove(i);
                            break;
                        }
                    }
                    this.fKI.n(this.fKF.getPbData());
                } else if (bVar.hfp == 0) {
                    bgG();
                } else if (bVar.hfp == 2) {
                    ArrayList<PostData> beX2 = this.fKF.getPbData().beX();
                    int size2 = beX2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= beX2.get(i2).bBY().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(beX2.get(i2).bBY().get(i3).getId())) {
                                i3++;
                            } else {
                                beX2.get(i2).bBY().remove(i3);
                                beX2.get(i2).bCa();
                                z2 = true;
                                break;
                            }
                        }
                        beX2.get(i2).uX(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fKI.n(this.fKF.getPbData());
                    }
                    a(bVar, this.fKI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fKI.a(this.cNV.getLoadDataMode(), gVar.HV, gVar.hfr, false);
            if (gVar.HV) {
                this.fKK = true;
                if (i == 2 || i == 3) {
                    this.fKL = true;
                    this.fKM = false;
                } else if (i == 4 || i == 5) {
                    this.fKL = false;
                    this.fKM = true;
                }
                if (i == 2) {
                    this.fKF.getPbData().beV().cq(1);
                    this.fKF.setIsGood(1);
                } else if (i == 3) {
                    this.fKF.getPbData().beV().cq(0);
                    this.fKF.setIsGood(0);
                } else if (i == 4) {
                    this.fKF.getPbData().beV().cp(1);
                    this.fKF.kf(1);
                } else if (i == 5) {
                    this.fKF.getPbData().beV().cp(0);
                    this.fKF.kf(0);
                }
                this.fKI.c(this.fKF.getPbData(), this.fKF.bhQ());
            }
        }
    }

    private void bgG() {
        if (this.fKF.bhR() || this.fKF.bhT()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fKF.bhP());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fKF.bhP()));
        if (bgL()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgH() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bfe;
        boolean z = false;
        if (this.fKI != null) {
            this.fKI.bjW();
        }
        if (this.fKF != null && this.fKF.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fKF.getPbData().beV().getId();
            if (this.fKF.isShareThread() && this.fKF.getPbData().beV().arg != null) {
                historyMessage.threadName = this.fKF.getPbData().beV().arg.showText;
            } else {
                historyMessage.threadName = this.fKF.getPbData().beV().getTitle();
            }
            if (this.fKF.isShareThread() && !bfQ()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fKF.getPbData().beT().getName();
            }
            ArrayList<PostData> beX = this.fKF.getPbData().beX();
            int bjL = this.fKI != null ? this.fKI.bjL() : 0;
            if (beX != null && bjL >= 0 && bjL < beX.size()) {
                historyMessage.postID = beX.get(bjL).getId();
            }
            historyMessage.isHostOnly = this.fKF.getHostMode();
            historyMessage.isSquence = this.fKF.bhQ();
            historyMessage.isShareThread = this.fKF.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fKV != null) {
            this.fKV.onDestroy();
        }
        if (this.fKp && bgr() != null) {
            bgr().bkp();
        }
        if (this.fKF != null && (this.fKF.bhR() || this.fKF.bhT())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fKF.bhP());
            if (this.fKK) {
                if (this.fKM) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fKF.bhV());
                }
                if (this.fKL) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fKF.getIsGood());
                }
            }
            if (this.fKF.getPbData() != null && System.currentTimeMillis() - this.fKs >= 40000 && (bfe = this.fKF.getPbData().bfe()) != null && !com.baidu.tbadk.core.util.v.J(bfe.getDataList())) {
                intent.putExtra("guess_like_data", bfe);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fLj);
            }
            setResult(-1, intent);
        }
        if (bgL()) {
            if (this.fKF != null && this.fKI != null && this.fKI.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fKF.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bfb() && !this.fKy) {
                        aj biX = aj.biX();
                        com.baidu.tieba.pb.data.d pbData2 = this.fKF.getPbData();
                        Parcelable onSaveInstanceState = this.fKI.getListView().onSaveInstanceState();
                        boolean bhQ = this.fKF.bhQ();
                        boolean hostMode = this.fKF.getHostMode();
                        if (this.fKI.bju() != null && this.fKI.bju().getVisibility() == 0) {
                            z = true;
                        }
                        biX.a(pbData2, onSaveInstanceState, bhQ, hostMode, z);
                        if (this.fLi >= 0 || this.fKF.biw() != null) {
                            aj.biX().j(this.fKF.biw());
                            aj.biX().i(this.fKF.bix());
                            aj.biX().rJ(this.fKF.biy());
                        }
                    }
                }
            } else {
                aj.biX().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fKI == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fKI.rN(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rr(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fKI.bjj();
            this.fKI.bjl().bhC();
            this.fKI.le(false);
        }
        this.fKI.bjm();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fKV.resetData();
                        this.fKV.b(writeData);
                        this.fKV.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k fi = this.fKV.KH().fi(6);
                        if (fi != null && fi.aTV != null) {
                            fi.aTV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fKV.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fKI.bjl() != null && this.fKI.bjl().bhH() != null) {
                            com.baidu.tbadk.editortools.pb.g bhH = this.fKI.bjl().bhH();
                            bhH.b(writeData);
                            bhH.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k fi2 = bhH.KH().fi(6);
                            if (fi2 != null && fi2.aTV != null) {
                                fi2.aTV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bhH.Lz();
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.fKV.onActivityResult(i, i2, intent);
        if (this.fKC != null) {
            this.fKC.onActivityResult(i, i2, intent);
        }
        if (bgr().bjl() != null) {
            bgr().bjl().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bgJ();
                    return;
                case 13008:
                    aj.biX().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fKF != null) {
                                PbActivity.this.fKF.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bsS().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fKF != null) {
                        a(bgI(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bsS().x(getPageContext());
                        bgA();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dQb != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dQb.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void HI() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                                        }
                                    }, 1000L);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                case 24008:
                    this.fKI.kq(false);
                    if (this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null && this.fKF.getPbData().beV().yQ() != null) {
                        this.fKF.getPbData().beV().yQ().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fKX = emotionImageData;
                        if (rq(com.baidu.tbadk.core.util.aj.axL)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fKI != null && this.fKI.fTE != null) {
                        this.fKI.fTE.vO();
                        this.fKI.fTE.bkR();
                        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null) {
                            this.fKF.getPbData().beV().cl(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fKD != null) {
                        this.fKI.bB(this.fKD);
                        return;
                    }
                    return;
                default:
                    return;
            }
            intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
            intent.getStringExtra("KEY_FORUM_NAME");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.fKC == null) {
                this.fKC = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fKC.b(this.aVL);
                this.fKC.c(this.aVS);
            }
            this.fKC.a(emotionImageData, bga(), bga().getPbData());
        }
    }

    private ShareFromPBMsgData bgI() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] cQ = this.fKF.getPbData().cQ(getPageContext().getPageActivity());
        PostData bjo = this.fKI.bjo();
        String str = "";
        if (bjo != null) {
            str = bjo.getId();
            String db = bjo.db(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(db)) {
                cQ[1] = db;
            }
        }
        String yM = this.fKF.getPbData().beV().yM();
        if (yM != null && yM.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(cQ[1]);
        shareFromPBMsgData.setImageUrl(cQ[0]);
        shareFromPBMsgData.setForumName(this.fKF.getPbData().beT().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fKF.getPbData().beV().getId());
        shareFromPBMsgData.setTitle(this.fKF.getPbData().beV().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bgI(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cB(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null) {
                        com.baidu.tbadk.core.util.am ax = new com.baidu.tbadk.core.util.am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_param1", 3).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fKF.getForumId()).ax("tid", PbActivity.this.fKF.bhP());
                        if (PbActivity.this.e(PbActivity.this.fKF.getPbData()) != 0) {
                            ax.x("obj_type", PbActivity.this.e(PbActivity.this.fKF.getPbData()));
                        }
                        TiebaStatic.log(ax);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aP(true);
            aVar.b(getPageContext()).Au();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.L(shareFromPBMsgData.getImageUrl(), this.fKF.getPbData().bfi() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cB(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aP(true);
            aVar.b(getPageContext()).Au();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.L(shareFromPBMsgData.getImageUrl(), this.fKF.getPbData().bfi() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgJ() {
        MarkData rG;
        if (this.fKH != null && (rG = this.fKF.rG(this.fKI.bjM())) != null) {
            if (!rG.isApp() || (rG = this.fKF.rG(this.fKI.bjM() + 1)) != null) {
                this.fKI.bjH();
                this.fKH.a(rG);
                if (!this.fKH.vc()) {
                    this.fKH.ve();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fKH.vd();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgK() {
        com.baidu.tieba.pb.data.d pbData = this.fKF.getPbData();
        this.fKF.kI(true);
        if (this.fKH != null) {
            pbData.sh(this.fKH.vb());
        }
        this.fKI.n(pbData);
    }

    private boolean bgL() {
        if (this.fKF == null) {
            return true;
        }
        if (this.fKF.vc()) {
            final MarkData bie = this.fKF.bie();
            if (bie == null || !this.fKF.getIsFromMark()) {
                return true;
            }
            final MarkData rG = this.fKF.rG(this.fKI.bjL());
            if (rG == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bie);
                setResult(-1, intent);
                return true;
            } else if (rG.getPostId() == null || rG.getPostId().equals(bie.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bie);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ej(getPageContext().getString(e.j.alert_update_mark));
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fKH != null) {
                            if (PbActivity.this.fKH.vc()) {
                                PbActivity.this.fKH.vd();
                                PbActivity.this.fKH.ay(false);
                            }
                            PbActivity.this.fKH.a(rG);
                            PbActivity.this.fKH.ay(true);
                            PbActivity.this.fKH.ve();
                        }
                        bie.setPostId(rG.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bie);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bgH();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bie);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bgH();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fKI != null && PbActivity.this.fKI.getView() != null) {
                            PbActivity.this.fKI.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bie);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bgH();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.Au();
                return false;
            }
        } else if (this.fKF.getPbData() == null || this.fKF.getPbData().beX() == null || this.fKF.getPbData().beX().size() <= 0 || !this.fKF.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fKI == null) {
            return null;
        }
        return this.fKI.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rr() {
        if (this.fKI == null) {
            return 0;
        }
        return this.fKI.bjU();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Rs() {
        if (this.bnu == null) {
            this.bnu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: als */
                public ImageView jB() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean ww = com.baidu.tbadk.core.i.ws().ww();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(e.d.common_color_10220));
                    if (ww) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(e.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public void u(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public ImageView v(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.ws().ww()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(e.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public ImageView w(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bnu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rt() {
        if (this.bnv == null) {
            this.bnv = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.bnv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Ru() {
        if (this.bnz == null) {
            this.bnz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bhf */
                public GifView jB() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void u(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView v(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView w(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.Mb();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bnz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rv() {
        if (this.bnw == null) {
            this.bnw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bhg */
                public View jB() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0175e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bv */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bw */
                public View v(View view) {
                    ((PlayVoiceBntNew) view).bDm();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bnw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rx() {
        this.bny = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bhh */
            public RelativeLayout jB() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout v(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout w(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bny;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Eh() {
        if (this.aGx == null) {
            this.aGx = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aGx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fKw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (aw.sB(str) && this.fKF != null && this.fKF.bhP() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").x("obj_param1", 1).ax("post_id", this.fKF.bhP()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                iVar.mLink = str;
                iVar.type = 3;
                iVar.aSZ = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
            }
        } else {
            aw.bkB().c(getPageContext(), str);
        }
        this.fKw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        aw.bkB().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fKw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Rect rect) {
        if (rect != null && this.fKI != null && this.fKI.bkk() != null && rect.top <= this.fKI.bkk().getHeight()) {
            rect.top += this.fKI.bkk().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fKF.getPbData();
            TbRichText aK = aK(str, i);
            if (aK != null && (tbRichTextData = aK.QK().get(this.fLN)) != null) {
                cVar.fMz = new ArrayList<>();
                cVar.fMA = new ConcurrentHashMap<>();
                if (!tbRichTextData.QQ().Rc()) {
                    cVar.fMC = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fMz.add(b2);
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
                    imageUrlData.postId = aK.getPostId();
                    imageUrlData.mIsReserver = this.fKF.bic();
                    imageUrlData.mIsSeeHost = this.fKF.getHostMode();
                    cVar.fMA.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.beT() != null) {
                            cVar.forumName = pbData.beT().getName();
                            cVar.forumId = pbData.beT().getId();
                        }
                        if (pbData.beV() != null) {
                            cVar.threadId = pbData.beV().getId();
                        }
                        cVar.fMB = pbData.bfi() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.fMC = true;
                int size = pbData.beX().size();
                this.fLO = false;
                cVar.index = -1;
                if (pbData.bfc() != null) {
                    PostData bfc = pbData.bfc();
                    TbRichText bCd = bfc.bCd();
                    if (!aq.k(bfc)) {
                        i2 = a(bCd, aK, i, i, cVar.fMz, cVar.fMA);
                    } else {
                        i2 = a(bfc, i, cVar.fMz, cVar.fMA);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.beX().get(i4);
                    if (postData.getId() == null || pbData.bfc() == null || pbData.bfc().getId() == null || !postData.getId().equals(pbData.bfc().getId())) {
                        TbRichText bCd2 = postData.bCd();
                        if (!aq.k(postData)) {
                            i3 = a(bCd2, aK, i3, i, cVar.fMz, cVar.fMA);
                        } else {
                            i3 = a(postData, i3, cVar.fMz, cVar.fMA);
                        }
                    }
                }
                if (cVar.fMz.size() > 0) {
                    cVar.lastId = cVar.fMz.get(cVar.fMz.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.beT() != null) {
                        cVar.forumName = pbData.beT().getName();
                        cVar.forumId = pbData.beT().getId();
                    }
                    if (pbData.beV() != null) {
                        cVar.threadId = pbData.beV().getId();
                    }
                    cVar.fMB = pbData.bfi() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QQ() == null) {
            return null;
        }
        return tbRichTextData.QQ().Ri();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QQ() == null) {
            return 0L;
        }
        return tbRichTextData.QQ().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QQ() == null) {
            return false;
        }
        return tbRichTextData.QQ().Rj();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QQ() == null) {
            return false;
        }
        return tbRichTextData.QQ().Rk();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo QQ;
        String str;
        if (tbRichText == tbRichText2) {
            this.fLO = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.QK().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.QK().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.QQ().getWidth() * aR;
                    int height = aR * tbRichTextData.QQ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.QQ().Rc()) {
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
                        String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (QQ = tbRichTextData.QQ()) != null) {
                                String Rf = QQ.Rf();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = QQ.Rg();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Rf;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fKF.bhP(), -1L);
                                imageUrlData.mIsReserver = this.fKF.bic();
                                imageUrlData.mIsSeeHost = this.fKF.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fLO) {
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
        com.baidu.tieba.tbadkCore.data.h bCk;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bBG;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bBG = (bCk = postData.bCk()).bBG()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bBG.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bBG.get(i3);
                if (jVar != null) {
                    String bBK = jVar.bBK();
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(bBK)) {
                        arrayList.add(bBK);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bBK;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bBJ();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fKF.bhP(), -1L);
                        imageUrlData.mIsReserver = this.fKF.bic();
                        imageUrlData.mIsSeeHost = this.fKF.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bCk.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bBK, imageUrlData);
                        }
                        if (!this.fLO) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    protected void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.fKF.yF())) {
                z = true;
            }
            MarkData h = this.fKF.h(postData);
            if (h != null) {
                this.fKI.bjH();
                if (this.fKH != null) {
                    this.fKH.a(h);
                    if (!z) {
                        this.fKH.ve();
                    } else {
                        this.fKH.vd();
                    }
                }
            }
        }
    }

    public boolean bt(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aK(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fKF == null || this.fKF.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fKF.getPbData();
        if (pbData.bfc() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bfc());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> beX = pbData.beX();
            a(pbData, beX);
            return a(beX, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bfg() != null && dVar.bfg().fIG != null && (list = dVar.bfg().fIG) != null && arrayList != null) {
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

    private long sn(String str) {
        ArrayList<PostData> beX;
        com.baidu.tieba.pb.data.d pbData = this.fKF.getPbData();
        if (pbData != null && (beX = pbData.beX()) != null && !beX.isEmpty()) {
            Iterator<PostData> it = beX.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bCk = next.bCk();
                if (bCk != null && bCk.hcD) {
                    Iterator<TbRichTextData> it2 = next.bCd().QK().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.QZ().getLink().equals(str)) {
                            return bCk.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> QK;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bCd = arrayList.get(i2).bCd();
            if (bCd != null && (QK = bCd.QK()) != null) {
                int size = QK.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (QK.get(i4) != null && QK.get(i4).getType() == 8) {
                        i3++;
                        if (QK.get(i4).QQ().Rf().equals(str) || QK.get(i4).QQ().Rg().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = QK.get(i4).QQ().getWidth() * aR;
                            int height = QK.get(i4).QQ().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fLN = i4;
                            return bCd;
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

    @Override // com.baidu.tbadk.widget.richText.e
    public void i(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.fKg = str;
            if (this.fKr == null) {
                bgv();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fKr.cH(1).setVisibility(8);
            } else {
                this.fKr.cH(1).setVisibility(0);
            }
            this.fKr.Ax();
            this.fKw = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dAm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgM() {
        hideNetRefreshView(this.fKI.getView());
        bgN();
        if (this.fKF.Nj()) {
            this.fKI.bjH();
        }
    }

    private void bgN() {
        showLoadingView(this.fKI.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds400));
        View Mw = getLoadingView().Mw();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Mw.getLayoutParams();
        layoutParams.addRule(3, this.fKI.bkk().getId());
        Mw.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azQ() {
        if (this.dAm != null) {
            this.dAm.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004020, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void rt(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fKF.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fKF.getPbData();
            pbData.beT().getName();
            String title = pbData.beV().getTitle();
            int i2 = this.fKF.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.beT() != null) {
                if ((pbData.beT().isLike() == 1) && AddExperiencedModel.us(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fKF.bhP() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] cQ = pbData.cQ(getPageContext().getPageActivity());
                    str = cQ[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = cQ[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bgz() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").ax(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ax("tid", pbData.getThreadId()).ax("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aNJ = true;
                    dVar.aNO = z;
                    dVar.extData = this.fKF.bhP();
                    dVar.aNX = 3;
                    dVar.aNW = i;
                    dVar.fid = this.fKF.getForumId();
                    dVar.tid = this.fKF.bhP();
                    dVar.aNY = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fKF.getPbData().beV());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aNX);
                    bundle.putInt("obj_type", dVar.aNY);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.f(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().bfu()) {
                                PbActivity.this.fKI.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.aqb().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fKF.bhP() + "?share=9105&fr=share&see_lz=" + i2;
            String[] cQ2 = pbData.cQ(getPageContext().getPageActivity());
            str = cQ2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = cQ2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bgz() == 1) {
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aNJ = true;
            dVar2.aNO = z;
            dVar2.extData = this.fKF.bhP();
            dVar2.aNX = 3;
            dVar2.aNW = i;
            dVar2.fid = this.fKF.getForumId();
            dVar2.tid = this.fKF.bhP();
            dVar2.aNY = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fKF.getPbData().beV());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aNX);
            bundle2.putInt("obj_type", dVar2.aNY);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.f(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fKF != null && PbActivity.this.fKF.getPbData() != null && PbActivity.this.fKF.getPbData().bfu()) {
                        PbActivity.this.fKI.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.aqb().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.beV() != null) {
            if (dVar.beV().getThreadType() == 0) {
                return 1;
            }
            if (dVar.beV().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgO() {
        com.baidu.tbadk.util.x.a(new com.baidu.tbadk.util.w<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.ut(PbActivity.this.fKF.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fKI.bkq();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Rw() {
        if (this.bnx == null) {
            this.bnx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bhi */
                public LinearLayout jB() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(e.g.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public void u(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout v(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout w(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bnx;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fKI.bjC() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).ax(ImageViewerConfig.FORUM_ID, this.fKF.getPbData().getForumId()));
            } else {
                bb beV = this.fKF.getPbData().beV();
                if (view != null) {
                    boolean z = beV.yi() == null || beV.yi().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fLA > 1000) {
                            this.fLB = true;
                            bu(view);
                        } else {
                            this.fLB = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            l(view, this.fLB);
                        } else {
                            k(view, this.fLB);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        k(view, this.fLB);
                    } else if (motionEvent.getAction() == 3) {
                        k(view, this.fLB);
                    }
                }
            }
        }
        return false;
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fLA = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fLA = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bu(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void azR() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData ayQ() {
        if (this.fKF == null || this.fKF.getPbData() == null) {
            return null;
        }
        return this.fKF.getPbData().xs();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.Aw() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.Aw();
            int intValue = ((Integer) sparseArray.get(ar.fVr)).intValue();
            if (intValue == ar.fVs) {
                if (!this.cNV.bCN()) {
                    this.fKI.bjE();
                    String str = (String) sparseArray.get(e.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.cNV.vd(com.baidu.tbadk.core.util.ao.i(jSONArray));
                    }
                    this.cNV.a(this.fKF.getPbData().beT().getId(), this.fKF.getPbData().beT().getName(), this.fKF.getPbData().beV().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == ar.fVt || intValue == ar.fVv) {
                if (this.fKF.bin() != null) {
                    this.fKF.bin().rw(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.fVt) {
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
        if (sparseArray.get(e.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(e.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(e.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(e.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(e.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(e.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(e.g.tag_user_mute_msg);
        }
        if (sparseArray.get(e.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fLc);
        userMuteAddAndDelCustomMessage.setTag(this.fLc);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean so(String str) {
        if (!StringUtils.isNull(str) && ba.bI(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(e.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void kv(boolean z) {
        this.fKQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bgP() {
        ArrayList<PostData> beX;
        int I;
        if (this.fKF == null || this.fKF.getPbData() == null || this.fKF.getPbData().beX() == null || (I = com.baidu.tbadk.core.util.v.I((beX = this.fKF.getPbData().beX()))) == 0) {
            return "";
        }
        if (this.fKF.bic()) {
            Iterator<PostData> it = beX.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bCb() == 1) {
                    return next.getId();
                }
            }
        }
        int bjL = this.fKI.bjL();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(beX, bjL);
        if (postData == null || postData.yv() == null) {
            return "";
        }
        if (this.fKF.ss(postData.yv().getUserId())) {
            return postData.getId();
        }
        for (int i = bjL - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(beX, i);
            if (postData2 == null || postData2.yv() == null || postData2.yv().getUserId() == null) {
                break;
            } else if (this.fKF.ss(postData2.yv().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bjL + 1; i2 < I; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(beX, i2);
            if (postData3 == null || postData3.yv() == null || postData3.yv().getUserId() == null) {
                return "";
            }
            if (this.fKF.ss(postData3.yv().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ay.CU().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(sn(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fKF.getPbData().beT().getId(), this.fKF.getPbData().beT().getName(), this.fKF.getPbData().beV().getTid());
            }
            this.fKw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.ej(getResources().getString(e.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.ej(getResources().getString(e.j.make_sure_hide));
        }
        aVar.a(getResources().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fKF.bim() != null) {
                    PbActivity.this.fKF.bim().cR(j);
                }
            }
        });
        aVar.b(getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.aP(false);
        aVar.b(getPageContext());
        aVar.Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c sp(String str) {
        String str2;
        if (this.fKF.getPbData() == null || this.fKF.getPbData().beX() == null || this.fKF.getPbData().beX().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fKF.getPbData().beX().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fKF.getPbData().beX().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fKF.getPbData().beX().get(i);
        if (postData.bCd() == null || postData.bCd().QK() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bCd().QK().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.QQ() != null) {
                    str2 = next.QQ().Rf();
                }
            }
        }
        str2 = null;
        a(str2, 0, cVar);
        com.baidu.tieba.pb.data.e.a(postData, cVar);
        return cVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fKn) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fKn = false;
        } else if (bgQ()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fKn) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fKn = false;
        } else if (bgQ()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.fKF != null) {
            if (this.fKF.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.fKF.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.fKF.bhP(), 0L));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bgQ() {
        return (!this.fKl && this.fLV == -1 && this.fLW == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fLY = mVar;
            this.fKl = true;
            this.fKI.bjv();
            this.fKI.sz(this.fLX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgR() {
        if (this.fLY != null) {
            if (this.fLV == -1) {
                showToast(e.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bH(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fLY.getCartoonId(), this.fLV, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgS() {
        if (this.fLY != null) {
            if (this.fLW == -1) {
                showToast(e.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bH(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fLY.getCartoonId(), this.fLW, 0)));
                finish();
            }
        }
    }

    public int bgT() {
        return this.fLV;
    }

    public int bgU() {
        return this.fLW;
    }

    private void aKP() {
        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null && this.fKF.getPbData().beV().zj()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bgV() {
        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null && this.fKF.getPbData().beV().zj()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bgW() {
        if (this.fKo) {
            this.fKB = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null && this.fKF.getPbData().beV().yc() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fKF.getPbData().beV().yc().getThreadId(), this.fKF.getPbData().beV().yc().getTaskId(), this.fKF.getPbData().beV().yc().getForumId(), this.fKF.getPbData().beV().yc().getForumName(), this.fKF.getPbData().beV().yq(), this.fKF.getPbData().beV().yr())));
            this.fKn = true;
            finish();
        }
    }

    public String bgX() {
        return this.fKz;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bgY() {
        return this.fKE;
    }

    public void kw(boolean z) {
        this.fKA = z;
    }

    public boolean bgZ() {
        if (this.fKF != null) {
            return this.fKF.bhR();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bha() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ej(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fLa).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fLa.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLa).Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hB(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fLa != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLa.getPageActivity());
            aVar.ej(str);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fLa).Au();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fKI.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLa.getPageActivity());
        if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            aVar.ej(this.fLa.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.ej(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fKI.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLa).Au();
    }

    public void bhb() {
        if (this.fKF != null && this.fKF.getPbData() != null && this.fKF.getPbData().beV() != null && this.fKF.getPbData().beV().zy() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cz(e.j.channel_open_push_message);
            aVar.a(e.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fKF.getPbData().beV().zy().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.Au();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (aw.sB(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_wenxue)) != null) {
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

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.isFullScreen = true;
        } else {
            this.isFullScreen = false;
        }
        if (this.fKI != null) {
            this.fKI.onConfigurationChanged(configuration);
        }
        if (this.fKO != null) {
            this.fKO.dismiss();
        }
    }

    public boolean bhc() {
        if (this.fKF != null) {
            return this.fKF.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.fKF.getPbData().bfg().fIG;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bBY().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bBY().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bBY().remove(i2);
                    list.get(i).bCa();
                    z = true;
                    break;
                }
            }
            list.get(i).uX(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.n(this.fKF.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bfC().getId();
        List<PostData> list = this.fKF.getPbData().bfg().fIG;
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
                ArrayList<PostData> bfG = jVar.bfG();
                postData.uF(jVar.getTotalCount());
                if (postData.bBY() != null) {
                    postData.bBY().clear();
                    postData.bBY().addAll(bfG);
                }
            }
        }
        if (!this.fKF.getIsFromMark()) {
            this.fKI.n(this.fKF.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bfP() {
        return this.fKJ;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bfQ() {
        if (this.fKF == null) {
            return false;
        }
        return this.fKF.bfQ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bfR() {
        if (this.fKF != null) {
            return this.fKF.bfR();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bfS() {
        if (this.fKF == null || this.fKF.getPbData() == null) {
            return 0;
        }
        return this.fKF.getPbData().bfh();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean sj(String str) {
        return this.fKF != null && this.fKF.ss(str);
    }

    public void bhd() {
        if (this.fKI != null) {
            this.fKI.bjj();
            azR();
        }
    }

    public PostData bfc() {
        return this.fKI.b(this.fKF.fQf, this.fKF.bhQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.isLinkThread()) {
                return 3;
            }
            if (bbVar.zA()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fLk != null && !this.fLk.isEmpty()) {
            int size = this.fLk.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fLk.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
        super.onBackPressed();
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.fLk == null) {
                this.fLk = new ArrayList();
            }
            if (!this.fLk.contains(aVar)) {
                this.fLk.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fLk == null) {
                this.fLk = new ArrayList();
            }
            if (!this.fLk.contains(aVar)) {
                this.fLk.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fLk != null) {
            this.fLk.remove(aVar);
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dAY == null) {
            this.dAY = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dAY.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aW(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dAY.a(contriInfo, -1L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        com.baidu.tbadk.core.util.ad.a(kVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }
}
