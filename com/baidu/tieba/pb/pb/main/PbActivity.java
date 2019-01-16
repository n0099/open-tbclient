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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.p.ax;
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
    private com.baidu.adp.lib.e.b<TbImageView> aLr;
    private com.baidu.adp.lib.e.b<ImageView> bsu;
    private com.baidu.adp.lib.e.b<TextView> bsv;
    private com.baidu.adp.lib.e.b<View> bsw;
    private com.baidu.adp.lib.e.b<LinearLayout> bsx;
    private com.baidu.adp.lib.e.b<RelativeLayout> bsy;
    private com.baidu.adp.lib.e.b<GifView> bsz;
    private com.baidu.tieba.f.b cxA;
    private VoiceManager dLz;
    private com.baidu.tbadk.core.dialog.h dMl;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fWG;
    private View fWH;
    private com.baidu.tieba.pb.pb.report.a fWK;
    public at fWR;
    private y fWS;
    private boolean fWU;
    private com.baidu.tieba.tbadkCore.data.e fWX;
    private com.baidu.tbadk.editortools.pb.f fWY;
    private com.baidu.tbadk.editortools.pb.d fWZ;
    private String fWk;
    private com.baidu.tieba.pb.pb.main.b.b fWq;
    private boolean fXQ;
    private EmotionImageData fXb;
    private com.baidu.adp.base.e fXe;
    private com.baidu.tbadk.core.view.g fXf;
    private BdUniqueId fXg;
    private Runnable fXh;
    private av fXi;
    private com.baidu.adp.widget.ImageView.a fXj;
    private String fXk;
    private TbRichTextMemeInfo fXl;
    private List<a> fXo;
    private String fYb;
    private com.baidu.tbadk.core.data.m fYc;
    public com.baidu.tbadk.core.util.aj fiK;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").y("obj_locate", as.a.aDq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").y("obj_locate", as.a.aDq));
        }
    };
    private static final b.a fXW = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.f.b.a
        public void gb(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bir();
            } else {
                com.baidu.tieba.pb.a.b.biq();
            }
        }
    };
    private boolean fWp = false;
    private boolean fWr = false;
    private boolean fWs = false;
    private boolean fzR = false;
    private boolean fWt = true;
    private int fWu = 0;
    private com.baidu.tbadk.core.dialog.b fWv = null;
    private long dsd = -1;
    private long bgJ = 0;
    private long fWw = 0;
    private long createTime = 0;
    private long bgB = 0;
    private boolean fWx = false;
    private com.baidu.tbadk.l.b fWy = null;
    private long fWz = 0;
    private boolean fWA = false;
    private long fWB = 0;
    private String baJ = null;
    private boolean fWC = false;
    private boolean isFullScreen = false;
    private String fWD = "";
    private boolean fWE = true;
    private boolean fWF = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fWI = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.fWM.lo(!PbActivity.this.fWE);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.wx()) {
                        PbActivity.this.bjn();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fWJ = null;
    private com.baidu.tbadk.baseEditMark.a fWL = null;
    private ForumManageModel cZj = null;
    private com.baidu.tbadk.coreExtra.model.a aCD = null;
    private ShareSuccessReplyToServerModel ebd = null;
    private ar fWM = null;
    public final com.baidu.tieba.pb.pb.main.b.a fWN = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean fWO = false;
    private boolean fWP = false;
    private boolean fWQ = false;
    private boolean fWT = false;
    private boolean fWV = false;
    private boolean fWW = false;
    private boolean fXa = false;
    public boolean fXc = false;
    private com.baidu.tbadk.editortools.pb.c baM = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void MN() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b baN = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean MM() {
            if (PbActivity.this.fWR == null || PbActivity.this.fWR.bng() == null || !PbActivity.this.fWR.bng().bOv()) {
                return !PbActivity.this.su(com.baidu.tbadk.core.util.aj.aCy);
            }
            PbActivity.this.showToast(PbActivity.this.fWR.bng().bOx());
            if (PbActivity.this.fWZ != null && (PbActivity.this.fWZ.Nb() || PbActivity.this.fWZ.Nc())) {
                PbActivity.this.fWZ.a(false, PbActivity.this.fWR.bnj());
            }
            PbActivity.this.fWR.lA(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fXd = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean MM() {
            if (PbActivity.this.fWR == null || PbActivity.this.fWR.bnh() == null || !PbActivity.this.fWR.bnh().bOv()) {
                return !PbActivity.this.su(com.baidu.tbadk.core.util.aj.aCz);
            }
            PbActivity.this.showToast(PbActivity.this.fWR.bnh().bOx());
            if (PbActivity.this.fWM != null && PbActivity.this.fWM.blT() != null && PbActivity.this.fWM.blT().bkl() != null && PbActivity.this.fWM.blT().bkl().Nc()) {
                PbActivity.this.fWM.blT().bkl().a(PbActivity.this.fWR.bnj());
            }
            PbActivity.this.fWR.lB(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dMh = false;
    private int fXm = 0;
    private int fXn = -1;
    private final a fXp = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fWM != null && PbActivity.this.fWM.blT() != null) {
                s blT = PbActivity.this.fWM.blT();
                if (blT.bki()) {
                    blT.bkh();
                    return true;
                }
            }
            if (PbActivity.this.fWM != null && PbActivity.this.fWM.bmM()) {
                PbActivity.this.fWM.bmN();
                return true;
            }
            return false;
        }
    };
    private r.a fXq = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
    };
    private AddExperiencedModel.a dMq = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bjr();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fXr = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void Q(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fWM.showToast(str);
            }
        }
    };
    private final CustomMessageListener fXs = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fWJ != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fWZ != null) {
                    PbActivity.this.fWM.lt(PbActivity.this.fWZ.MV());
                }
                PbActivity.this.fWM.blU();
                PbActivity.this.fWM.bmF();
            }
        }
    };
    CustomMessageListener dMI = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.fWJ.a((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.fWM != null && PbActivity.this.fWJ != null) {
                    PbActivity.this.fWM.d(PbActivity.this.fWJ.getPbData(), PbActivity.this.fWJ.bku(), PbActivity.this.fWJ.getRequestType());
                }
                if (PbActivity.this.fWM != null && PbActivity.this.fWM.bml() != null) {
                    PbActivity.this.fWM.bml().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fXt = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fWM != null) {
                    if (booleanValue) {
                        PbActivity.this.fWM.aTJ();
                    } else {
                        PbActivity.this.fWM.aTI();
                    }
                }
            }
        }
    };
    private CustomMessageListener fXu = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fWZ != null) {
                    PbActivity.this.fWM.lt(PbActivity.this.fWZ.MV());
                }
                PbActivity.this.fWM.lv(false);
            }
        }
    };
    private CustomMessageListener fXv = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener fXw = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fWM != null && PbActivity.this.fWM.bml() != null) {
                PbActivity.this.fWM.bml().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener eMD = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener akJ = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.fWs) {
                PbActivity.this.bjH();
            }
        }
    };
    private h.a fXx = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void n(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.sw(2);
                aj.blF().reset();
                PbActivity.this.fWJ.bkQ();
                boolean z2 = false;
                ArrayList<PostData> bhB = PbActivity.this.fWJ.getPbData().bhB();
                if (bhB != null) {
                    Iterator<PostData> it = bhB.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.m(next) && next.bFb().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fWM.o(PbActivity.this.fWJ.getPbData());
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
    private View.OnClickListener bbt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.baJ);
        }
    };
    private CustomMessageListener fXy = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fWJ.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fWJ.bkH() != null && PbActivity.this.fWJ.bkH().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fWM.a(yVar.sendCount, PbActivity.this.fWJ.getPbData(), PbActivity.this.fWJ.bku(), PbActivity.this.fWJ.getRequestType());
                    }
                    if (pbData.bhB() != null && pbData.bhB().size() >= 1 && pbData.bhB().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bhB().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.fWJ.bkt(), 0L);
                        if (d2 == yVar.postId && d3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bFa = pbData.bhB().get(0).bFa();
                            if (bFa == null) {
                                bFa = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> ze = bFa.ze();
                            if (ze == null) {
                                ze = new ArrayList<>();
                            }
                            ze.add(0, aVar);
                            bFa.setTotal(yVar.sendCount + bFa.getTotal());
                            bFa.k(ze);
                            pbData.bhB().get(0).a(bFa);
                            PbActivity.this.fWM.bml().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eeb = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null) {
                PbActivity.this.th((String) customResponsedMessage.getData());
                PbActivity.this.fWJ.bkN();
                if (PbActivity.this.fWM.bml() != null) {
                    PbActivity.this.fWM.o(PbActivity.this.fWJ.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a fXz = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.axh() != null && !aVar.axh().isEmpty()) {
                    PbActivity.this.fWM.a(aVar, PbActivity.this.fXB);
                }
                PbActivity.this.fWM.a(aVar, PbActivity.this.fWJ.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bnq()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fXA = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void Q(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.I(list) && PbActivity.this.fWM != null) {
                PbActivity.this.fWM.dp(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fXB = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bJ(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.jA().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18.1
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
    private boolean fXC = false;
    private PraiseModel fXD = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void kt(String str) {
            PbActivity.this.fXC = false;
            if (PbActivity.this.fXD != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fWJ.getPbData();
                if (pbData.bhz().zG().getIsLike() == 1) {
                    PbActivity.this.nj(0);
                } else {
                    PbActivity.this.nj(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bhz()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void P(int i, String str) {
            PbActivity.this.fXC = false;
            if (PbActivity.this.fXD != null && str != null) {
                if (AntiHelper.al(i, str)) {
                    AntiHelper.aH(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fXE = 0;
    private boolean fXF = true;
    private b.a fXG = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void kO(boolean z) {
            PbActivity.this.kN(z);
            if (PbActivity.this.fWM.bmS() != null && z) {
                PbActivity.this.fWM.lo(false);
            }
            PbActivity.this.fWM.lq(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aPX != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aPX, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").y("obj_locate", as.a.aDq));
                        }
                    } else if (updateAttentionMessage.getData().Jr) {
                        if (PbActivity.this.bhG().zT() != null && PbActivity.this.bhG().zT().getGodUserData() != null) {
                            PbActivity.this.bhG().zT().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhz() != null && PbActivity.this.fWJ.getPbData().bhz().zT() != null) {
                            PbActivity.this.fWJ.getPbData().bhz().zT().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cwR = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fWM.alK();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.sx(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aKT();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(e.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bsE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            PbActivity.this.biX();
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
                    if (PbActivity.this.bv(view)) {
                        return true;
                    }
                } else if (view.getId() == e.g.pb_floor_item_layout) {
                    if (view.getTag(e.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(e.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != e.g.pb_post_header_layout) {
                    if (PbActivity.this.fWM != null && PbActivity.this.fWM.biV() && view.getId() == e.g.pb_head_user_info_root) {
                        if (view.getTag(e.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").aB(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(e.g.tag_user_id)));
                        }
                        if (PbActivity.this.fWN != null && PbActivity.this.fWN.elC != null) {
                            PbActivity.this.fWN.elC.onClick(view);
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
            if (PbActivity.this.fWZ != null) {
                PbActivity.this.fWM.lt(PbActivity.this.fWZ.MV());
            }
            PbActivity.this.fWM.blU();
            PbActivity.this.fWM.bmF();
            return true;
        }
    });
    private CustomMessageListener fXH = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fXg) {
                PbActivity.this.fWM.alK();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fWJ.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bhN().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fXf.e(PbActivity.this.fXe.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fXe.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.ij(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bjD();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ao.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fXe.getResources().getString(e.j.mute_fail);
                    }
                    PbActivity.this.fXf.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fXI = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fXg) {
                PbActivity.this.fWM.alK();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fXf.e(PbActivity.this.fXe.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ao.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fXe.getResources().getString(e.j.un_mute_fail);
                }
                PbActivity.this.fXf.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fXJ = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fXg) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fWM.alK();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hDO;
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
                    PbActivity.this.fWM.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fXK = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fWM.blV() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.biX();
            }
        }
    };
    private CustomMessageListener dMP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dMh = true;
                }
            }
        }
    };
    public a.b fKJ = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.aCk();
            com.baidu.tbadk.core.data.al pageData = PbActivity.this.fWJ.getPageData();
            int pageNum = PbActivity.this.fWM.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(e.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.yX()) {
                PbActivity.this.fWM.bmF();
                PbActivity.this.sw(2);
                PbActivity.this.aCj();
                PbActivity.this.fWM.bmp();
                if (com.baidu.adp.lib.util.j.kV()) {
                    PbActivity.this.fWJ.sE(PbActivity.this.fWM.getPageNum());
                    if (PbActivity.this.fWq != null) {
                        PbActivity.this.fWq.showFloatingView();
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
    public final View.OnClickListener dNr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Multi-variable search result rejected for r2v179, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v183, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v210, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v319, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
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
            boolean p;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fWM.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fWJ.kX(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fWM.bmq();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().bly()) {
                        if (view == PbActivity.this.fWM.gfP.biG) {
                            if (PbActivity.this.fWM.ls(PbActivity.this.fWJ.bkA())) {
                                PbActivity.this.aCj();
                                return;
                            }
                            PbActivity.this.fWt = false;
                            PbActivity.this.fWr = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.fWM.gfP.biG);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fWM.bmn() && (PbActivity.this.fWM.gfP.bnC() == null || (view != PbActivity.this.fWM.gfP.bnC().blx() && view != PbActivity.this.fWM.gfP.bnC().blv()))) {
                            if (view == PbActivity.this.fWM.bmI()) {
                                if (PbActivity.this.fWJ != null) {
                                    com.baidu.tbadk.browser.a.ad(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fWJ.getPbData().bhz().zS().getLink());
                                }
                            } else if (view != PbActivity.this.fWM.gfP.gkQ && view.getId() != e.g.view_forum_name) {
                                if (view == PbActivity.this.fWM.gfP.gkR) {
                                    if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null) {
                                        ArrayList<PostData> bhB = PbActivity.this.fWJ.getPbData().bhB();
                                        if ((bhB == null || bhB.size() <= 0) && PbActivity.this.fWJ.bku()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").aB("tid", PbActivity.this.fWJ.bkt()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getForumId()));
                                        if (!PbActivity.this.fWM.bmX()) {
                                            PbActivity.this.fWM.blU();
                                        }
                                        PbActivity.this.bjf();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != e.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().blj()) {
                                        if ((PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().blu()) && view.getId() != e.g.floor_owner_reply && view.getId() != e.g.reply_title) {
                                            if (PbActivity.this.fWM.gfP.bnC() == null || (view != PbActivity.this.fWM.gfP.bnC().getCancelView() && view != PbActivity.this.fWM.gfP.bnC().blt())) {
                                                if (view != PbActivity.this.fWM.gfP.gkS && view.getId() != e.g.share_num_container) {
                                                    if (PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().blr()) {
                                                        if ((PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().blA()) && view.getId() != e.g.pb_sort) {
                                                            if (PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().bls()) {
                                                                if (PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().blB()) {
                                                                    if (PbActivity.this.fWS == null || view != PbActivity.this.fWS.bll()) {
                                                                        if (PbActivity.this.fWS == null || view != PbActivity.this.fWS.blj()) {
                                                                            if (PbActivity.this.fWS == null || view != PbActivity.this.fWS.blm()) {
                                                                                if (PbActivity.this.fWS == null || view != PbActivity.this.fWS.bln()) {
                                                                                    if (PbActivity.this.fWS == null || view != PbActivity.this.fWS.blp()) {
                                                                                        if (PbActivity.this.fWS == null || view != PbActivity.this.fWS.blq()) {
                                                                                            if (PbActivity.this.fWS == null || view != PbActivity.this.fWS.blo()) {
                                                                                                if (PbActivity.this.fWM.bmS() == view) {
                                                                                                    if (PbActivity.this.fWM.bmS().getIndicateStatus()) {
                                                                                                        com.baidu.tieba.pb.data.d pbData = PbActivity.this.fWJ.getPbData();
                                                                                                        if (pbData != null && pbData.bhz() != null && pbData.bhz().zA() != null) {
                                                                                                            String yt = pbData.bhz().zA().yt();
                                                                                                            if (StringUtils.isNull(yt)) {
                                                                                                                yt = pbData.bhz().zA().getTaskId();
                                                                                                            }
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").aB(VideoPlayActivityConfig.OBJ_ID, yt));
                                                                                                        }
                                                                                                    } else {
                                                                                                        com.baidu.tieba.tbadkCore.d.a.cN("c10725", null);
                                                                                                    }
                                                                                                    PbActivity.this.bjz();
                                                                                                } else if (PbActivity.this.fWM.bmk() != view) {
                                                                                                    if (PbActivity.this.fWS == null || view != PbActivity.this.fWS.blk()) {
                                                                                                        if (PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().blz()) {
                                                                                                            if (PbActivity.this.fWM.gfP.bnC() != null && view == PbActivity.this.fWM.gfP.bnC().blw()) {
                                                                                                                if (com.baidu.adp.lib.util.j.kV()) {
                                                                                                                    SparseArray<Object> c2 = PbActivity.this.fWM.c(PbActivity.this.fWJ.getPbData(), PbActivity.this.fWJ.bku(), 1);
                                                                                                                    if (c2 != null) {
                                                                                                                        if (StringUtils.isNull((String) c2.get(e.g.tag_del_multi_forum))) {
                                                                                                                            PbActivity.this.fWM.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                                        } else {
                                                                                                                            PbActivity.this.fWM.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(e.g.tag_del_multi_forum));
                                                                                                                        }
                                                                                                                    }
                                                                                                                    PbActivity.this.fWM.gfP.dismissPopMenu();
                                                                                                                } else {
                                                                                                                    PbActivity.this.showToast(e.j.network_not_available);
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (view.getId() != e.g.sub_pb_more && view.getId() != e.g.sub_pb_item && view.getId() != e.g.pb_floor_reply_more && view.getId() != e.g.new_sub_pb_list_richText) {
                                                                                                                if (view != PbActivity.this.fWM.biO()) {
                                                                                                                    if (view == PbActivity.this.fWM.gfP.bnD()) {
                                                                                                                        PbActivity.this.fWM.bmx();
                                                                                                                    } else {
                                                                                                                        int id = view.getId();
                                                                                                                        if (id == e.g.pb_u9_text_view) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin() && (bgVar = (bg) view.getTag()) != null && !StringUtils.isNull(bgVar.BH())) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                ay.Es().c(PbActivity.this.getPageContext(), new String[]{bgVar.BH()});
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.replybtn || id == e.g.cover_reply_content || id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right || id == e.g.image_more_tip) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                                                                PostData postData = null;
                                                                                                                                if (view != null && view.getTag() != null) {
                                                                                                                                    postData = (PostData) ((SparseArray) view.getTag()).get(e.g.tag_load_sub_data);
                                                                                                                                    if (PbActivity.this.fWS == null) {
                                                                                                                                        PbActivity.this.fWS = new y(PbActivity.this.getPageContext(), PbActivity.this.dNr);
                                                                                                                                        PbActivity.this.fWM.bH(PbActivity.this.fWS.getView());
                                                                                                                                        PbActivity.this.fWS.lb(PbActivity.this.mIsLogin);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fWS.showDialog();
                                                                                                                                    if (id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right) {
                                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").aB("tid", PbActivity.this.fWJ.gbP));
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray = new SparseArray();
                                                                                                                                    sparseArray.put(e.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(e.g.tag_clip_board));
                                                                                                                                    sparseArray.put(e.g.tag_is_subpb, false);
                                                                                                                                    PbActivity.this.fWS.blj().setTag(sparseArray);
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
                                                                                                                                            PbActivity.this.fWS.blm().setVisibility(0);
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, false);
                                                                                                                                            PbActivity.this.fWS.blm().setVisibility(8);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fWS.blk().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fWS.blm().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fWS.blk().setText(e.j.bar_manager);
                                                                                                                                        PbActivity.this.fWS.blk().setVisibility(0);
                                                                                                                                    } else if (!booleanValue3) {
                                                                                                                                        PbActivity.this.fWS.blk().setVisibility(8);
                                                                                                                                        PbActivity.this.fWS.blm().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        SparseArray sparseArray4 = new SparseArray();
                                                                                                                                        sparseArray4.put(e.g.tag_should_manage_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_should_delete_visible, true);
                                                                                                                                        sparseArray4.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                        PbActivity.this.fWS.blk().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fWS.blm().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fWS.blk().setText(e.j.delete);
                                                                                                                                        PbActivity.this.fWS.blm().setVisibility(0);
                                                                                                                                        if (PbActivity.this.fWJ.getPbData().bhL() != 1002 || z) {
                                                                                                                                            PbActivity.this.fWS.blm().setText(e.j.delete);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fWS.blm().setText(e.j.report_text);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fWS.blk().setVisibility(8);
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
                                                                                                                                        PbActivity.this.fWS.bll().setTag(sparseArray6);
                                                                                                                                        PbActivity.this.fWS.bll().setVisibility(0);
                                                                                                                                        PbActivity.this.fWS.blk().setVisibility(8);
                                                                                                                                        PbActivity.this.fWS.bll().setText(e.j.mute_option);
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
                                                                                                                                        boolean kJ = PbActivity.this.kJ(z3) & PbActivity.this.isLogin();
                                                                                                                                        PbActivity.this.fXT = (PostData) sparseArray5.get(e.g.tag_clip_board);
                                                                                                                                        if (aq.m(PbActivity.this.fXT) ? false : kJ) {
                                                                                                                                            PbActivity.this.fWS.bll().setVisibility(0);
                                                                                                                                            PbActivity.this.fWS.bll().setTag(str3);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fWS.bll().setVisibility(8);
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
                                                                                                                                        PbActivity.this.fWS.blo().setVisibility(0);
                                                                                                                                        PbActivity.this.fWS.blo().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                        PbActivity.this.fWS.blo().setTag(e.g.tag_chudian_monitor_id, str);
                                                                                                                                        PbActivity.this.fWS.blo().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fWS.blo().setVisibility(8);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                boolean z5 = false;
                                                                                                                                if (PbActivity.this.fWJ.getPbData().wx()) {
                                                                                                                                    String ww = PbActivity.this.fWJ.getPbData().ww();
                                                                                                                                    if (postData != null && !com.baidu.adp.lib.util.k.isEmpty(ww) && ww.equals(postData.getId())) {
                                                                                                                                        z5 = true;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (z5) {
                                                                                                                                    PbActivity.this.fWS.blj().setText(e.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fWS.blj().setText(e.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fWS.blq().setVisibility(8);
                                                                                                                                PbActivity.this.fWS.blp().setVisibility(8);
                                                                                                                                if (postData != null) {
                                                                                                                                    if (postData.bEU() == null || postData.bEU().toString().length() <= 0) {
                                                                                                                                        PbActivity.this.fWS.bln().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fWS.bln().setVisibility(0);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fXT = postData;
                                                                                                                                }
                                                                                                                                PbActivity.this.fWS.refreshUI();
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_act_btn) {
                                                                                                                            if (PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhz() != null && PbActivity.this.fWJ.getPbData().bhz().getActUrl() != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), PbActivity.this.fWJ.getPbData().bhz().getActUrl());
                                                                                                                                if (PbActivity.this.fWJ.getPbData().bhz().Ax() != 1) {
                                                                                                                                    if (PbActivity.this.fWJ.getPbData().bhz().Ax() == 2) {
                                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.lottery_tail) {
                                                                                                                            if (view.getTag(e.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                                String str4 = (String) view.getTag(e.g.tag_pb_lottery_tail_link);
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getPbData().getForumId()).aB("tid", PbActivity.this.fWJ.getPbData().getThreadId()).aB("lotterytail", StringUtils.string(str4, BaseRequestAction.SPLITE, TbadkCoreApplication.getCurrentAccount())));
                                                                                                                                if (PbActivity.this.fWJ.getPbData().getThreadId().equals(str4)) {
                                                                                                                                    PbActivity.this.fWM.setSelection(0);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_item_tail_content) {
                                                                                                                            if (ba.bJ(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                                String string = TbadkCoreApplication.getInst().getString(e.j.tail_web_view_title);
                                                                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                                if (!StringUtils.isNull(string2)) {
                                                                                                                                    TiebaStatic.log("c10056");
                                                                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                                }
                                                                                                                                PbActivity.this.fWM.blU();
                                                                                                                            }
                                                                                                                        } else if (id == e.g.join_vote_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                if (PbActivity.this.bjc() == 1 && PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getPbData().getForumId()).aB("tid", PbActivity.this.fWJ.getPbData().getThreadId()).aB("uid", currentAccount));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.look_all_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                if (PbActivity.this.bjc() == 1 && PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getPbData().getForumId()).aB("tid", PbActivity.this.fWJ.getPbData().getThreadId()).aB("uid", currentAccount2));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.manga_prev_btn) {
                                                                                                                            PbActivity.this.bju();
                                                                                                                        } else if (id == e.g.manga_next_btn) {
                                                                                                                            PbActivity.this.bjv();
                                                                                                                        } else if (id == e.g.yule_head_img_img) {
                                                                                                                            if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhT() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fWJ.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").aB(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                                ay.Es().c(PbActivity.this.getPageContext(), new String[]{pbData2.bhT().bic()});
                                                                                                                            }
                                                                                                                        } else if (id == e.g.yule_head_img_all_rank) {
                                                                                                                            if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhT() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fWJ.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").aB(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                                ay.Es().c(PbActivity.this.getPageContext(), new String[]{pbData3.bhT().bic()});
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.fWM.gfP.bnC() != null && view == PbActivity.this.fWM.gfP.bnC().blC()) {
                                                                                                                            if (PbActivity.this.fWJ == null || PbActivity.this.fWJ.getPbData() == null || PbActivity.this.fWJ.getPbData().bhz() == null) {
                                                                                                                                PbActivity.this.fWM.gfP.dismissPopMenu();
                                                                                                                                return;
                                                                                                                            } else if (!com.baidu.adp.lib.util.l.ll()) {
                                                                                                                                PbActivity.this.showToast(e.j.neterror);
                                                                                                                                return;
                                                                                                                            } else {
                                                                                                                                int i2 = 1;
                                                                                                                                if (PbActivity.this.fWJ.getPbData().bhz().zB() == 0) {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fWJ.bkt(), 25028)));
                                                                                                                                } else {
                                                                                                                                    BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(e.j.haved_fans_called)).Ca();
                                                                                                                                    i2 = 2;
                                                                                                                                }
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").y("obj_locate", PbActivity.this.al(PbActivity.this.fWJ.getPbData().bhz())).aB("tid", PbActivity.this.fWJ.getPbData().bhz().getTid()).y("obj_type", i2));
                                                                                                                            }
                                                                                                                        } else if (id == e.g.tv_pb_reply_more) {
                                                                                                                            if (PbActivity.this.fXm >= 0) {
                                                                                                                                if (PbActivity.this.fWJ != null) {
                                                                                                                                    PbActivity.this.fWJ.bld();
                                                                                                                                }
                                                                                                                                if (PbActivity.this.fWM.bml() != null) {
                                                                                                                                    PbActivity.this.fWM.bml().a(PbActivity.this.fWJ.getPbData(), false);
                                                                                                                                }
                                                                                                                                PbActivity.this.fWM.getListView().setSelection(PbActivity.this.fWJ.blg());
                                                                                                                                PbActivity.this.fXm = 0;
                                                                                                                                if (PbActivity.this.fWJ != null) {
                                                                                                                                    PbActivity.this.fWJ.by(0, 0);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.single_bar_tips) {
                                                                                                                            PbActivity.this.fWM.bnb();
                                                                                                                        } else if (id == e.g.pb_post_recommend_live_layout) {
                                                                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                                TiebaStatic.log("c12640");
                                                                                                                            }
                                                                                                                        } else if (id == e.g.thread_info_commont_container) {
                                                                                                                            PbActivity.this.fWM.blZ();
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
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.fWJ.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.fWJ.bkt(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fWJ.getPbData().bhz().Ao())));
                                                                                                                }
                                                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                if (PbActivity.this.fWJ.getPbData() != null) {
                                                                                                                    PbActivity.this.fWM.bmF();
                                                                                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                    PostData postData2 = (PostData) sparseArray9.get(e.g.tag_load_sub_data);
                                                                                                                    View view2 = (View) sparseArray9.get(e.g.tag_load_sub_view);
                                                                                                                    if (postData2 != null && view2 != null) {
                                                                                                                        if (postData2.bFe() == 1) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                                                        }
                                                                                                                        if (postData2.hqu != null) {
                                                                                                                            com.baidu.tbadk.core.util.am DY = postData2.hqu.DY();
                                                                                                                            DY.delete("obj_locate");
                                                                                                                            if (view.getId() == e.g.new_sub_pb_list_richText) {
                                                                                                                                DY.y("obj_locate", 6);
                                                                                                                            } else if (view.getId() == e.g.pb_floor_reply_more) {
                                                                                                                                DY.y("obj_locate", 8);
                                                                                                                            }
                                                                                                                            TiebaStatic.log(DY);
                                                                                                                        }
                                                                                                                        String bkt = PbActivity.this.fWJ.bkt();
                                                                                                                        String id2 = postData2.getId();
                                                                                                                        int i3 = 0;
                                                                                                                        if (PbActivity.this.fWJ.getPbData() != null) {
                                                                                                                            i3 = PbActivity.this.fWJ.getPbData().bhL();
                                                                                                                        }
                                                                                                                        PbActivity.this.aCj();
                                                                                                                        if (view.getId() == e.g.replybtn) {
                                                                                                                            c tm = PbActivity.this.tm(id2);
                                                                                                                            if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && tm != null) {
                                                                                                                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bkt, id2, "pb", true, null, true, null, i3, postData2.bor(), PbActivity.this.fWJ.getPbData().yR(), false, postData2.zT().getIconInfo()).addBigImageData(tm.fYD, tm.fYE, tm.fYF, tm.index);
                                                                                                                                addBigImageData.setKeyPageStartFrom(PbActivity.this.fWJ.blc());
                                                                                                                                addBigImageData.setFromFrsForumId(PbActivity.this.fWJ.getFromForumId());
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            c tm2 = PbActivity.this.tm(id2);
                                                                                                                            if (postData2 != null && PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && tm2 != null) {
                                                                                                                                SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bkt, id2, "pb", true, null, false, null, i3, postData2.bor(), PbActivity.this.fWJ.getPbData().yR(), false, postData2.zT().getIconInfo()).addBigImageData(tm2.fYD, tm2.fYE, tm2.fYF, tm2.index);
                                                                                                                                addBigImageData2.setKeyPageStartFrom(PbActivity.this.fWJ.blc());
                                                                                                                                addBigImageData2.setFromFrsForumId(PbActivity.this.fWJ.getFromForumId());
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
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").y("obj_locate", 3).aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getPbData().getForumId()));
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                                                                                            PbActivity.this.fWM.bmF();
                                                                                                            SparseArray<Object> c3 = PbActivity.this.fWM.c(PbActivity.this.fWJ.getPbData(), PbActivity.this.fWJ.bku(), 1);
                                                                                                            if (c3 != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fWJ.getPbData().bhx().getId(), PbActivity.this.fWJ.getPbData().bhx().getName(), PbActivity.this.fWJ.getPbData().bhz().getId(), String.valueOf(PbActivity.this.fWJ.getPbData().getUserData().getUserId()), (String) c3.get(e.g.tag_forbid_user_name), (String) c3.get(e.g.tag_forbid_user_name_show), (String) c3.get(e.g.tag_forbid_user_post_id), (String) c3.get(e.g.tag_forbid_user_portrait))));
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(e.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (!com.baidu.adp.lib.util.j.kV()) {
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
                                                                                                                    PbActivity.this.fWM.bF(view);
                                                                                                                }
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.fWM.a(((Integer) sparseArray10.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray10.get(e.g.tag_del_post_id), ((Integer) sparseArray10.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").y("obj_locate", 2).aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getPbData().getForumId()));
                                                                                                    return;
                                                                                                } else {
                                                                                                    PbActivity.this.biQ();
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
                                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fWJ.getPbData();
                                                                                                String str6 = null;
                                                                                                String str7 = null;
                                                                                                String str8 = null;
                                                                                                if (pbData4 != null && pbData4.bhx() != null) {
                                                                                                    str6 = pbData4.bhx().getId();
                                                                                                    str7 = pbData4.bhx().getName();
                                                                                                    str8 = pbData4.getThreadId();
                                                                                                }
                                                                                                com.baidu.tieba.pb.a.a(j2, str5, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str6, str7, str8);
                                                                                                PbActivity.this.a(j2, str5, str6, str7, str8, i4);
                                                                                            }
                                                                                        } else if (PbActivity.this.fXj != null && !TextUtils.isEmpty(PbActivity.this.fXk)) {
                                                                                            if (PbActivity.this.mPermissionJudgement == null) {
                                                                                                PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                                                                                            }
                                                                                            PbActivity.this.mPermissionJudgement.EG();
                                                                                            PbActivity.this.mPermissionJudgement.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                            if (!PbActivity.this.mPermissionJudgement.B(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                if (PbActivity.this.fXi == null) {
                                                                                                    PbActivity.this.fXi = new av(PbActivity.this.getPageContext());
                                                                                                }
                                                                                                PbActivity.this.fXi.i(PbActivity.this.fXk, PbActivity.this.fXj.ow());
                                                                                                PbActivity.this.fXj = null;
                                                                                                PbActivity.this.fXk = null;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.fXj != null && !TextUtils.isEmpty(PbActivity.this.fXk)) {
                                                                                        if (PbActivity.this.fXl == null) {
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fXk));
                                                                                        } else {
                                                                                            d.a aVar = new d.a();
                                                                                            aVar.url = PbActivity.this.fXk;
                                                                                            aVar.pkgId = PbActivity.this.fXl.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fXl.memeInfo.pck_id;
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                                        }
                                                                                        PbActivity.this.fXj = null;
                                                                                        PbActivity.this.fXk = null;
                                                                                    }
                                                                                } else if (PbActivity.this.fXT != null) {
                                                                                    PbActivity.this.fXT.cZ(PbActivity.this.getPageContext().getPageActivity());
                                                                                    PbActivity.this.fXT = null;
                                                                                }
                                                                            } else {
                                                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                                                if (sparseArray11 != null) {
                                                                                    if ((sparseArray11.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_id) instanceof String) && (sparseArray11.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                        PbActivity.this.fWM.a(((Integer) sparseArray11.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(e.g.tag_del_post_id), ((Integer) sparseArray11.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").y("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bx(view);
                                                                                if (PbActivity.this.fWJ.getPbData().bhz() != null && PbActivity.this.fWJ.getPbData().bhz().zT() != null && PbActivity.this.fWJ.getPbData().bhz().zT().getUserId() != null && PbActivity.this.fWL != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").aB("tid", PbActivity.this.fWJ.gbP).y("obj_locate", 2).aB(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fWJ.getPbData().bhz().zT().getUserId()).y("obj_type", PbActivity.this.fWL.wx() ? 0 : 1).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fWJ.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.kV()) {
                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13079"));
                                                                            PbActivity.this.tj((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").y("obj_locate", 4));
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
                                                                    UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").y("obj_type", 0).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").y("obj_type", 1).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fWM.gfP.bnB();
                                                                }
                                                            } else if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhz() != null) {
                                                                PbActivity.this.fWM.gfP.dismissPopMenu();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                                PbActivity.this.tj(PbActivity.this.fWJ.getPbData().bhz().Ak());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fWM.bmF();
                                                            if (com.baidu.adp.lib.util.j.kV()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Integer.valueOf(PbActivity.this.fWJ.bkL()));
                                                                    return;
                                                                }
                                                                PbActivity.this.sw(2);
                                                                PbActivity.this.aCj();
                                                                PbActivity.this.fWM.bmp();
                                                                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(PbActivity.this.getPageContext().getPageActivity());
                                                                if (PbActivity.this.fWJ.getPbData().fUj == null || PbActivity.this.fWJ.getPbData().fUj.size() <= 0) {
                                                                    strArr = new String[]{PbActivity.this.getResources().getString(e.j.sort_type_new), PbActivity.this.getResources().getString(e.j.sort_type_old)};
                                                                } else {
                                                                    String[] strArr2 = new String[PbActivity.this.fWJ.getPbData().fUj.size()];
                                                                    int i5 = 0;
                                                                    while (true) {
                                                                        int i6 = i5;
                                                                        if (i6 >= PbActivity.this.fWJ.getPbData().fUj.size()) {
                                                                            break;
                                                                        }
                                                                        strArr2[i6] = PbActivity.this.fWJ.getPbData().fUj.get(i6).sort_name + PbActivity.this.getResources().getString(e.j.sort_static);
                                                                        i5 = i6 + 1;
                                                                    }
                                                                    strArr = strArr2;
                                                                }
                                                                bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                                                                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i7, View view3) {
                                                                        int i8 = 2;
                                                                        if (PbActivity.this.fWJ.acy() == 1 && i7 == 1) {
                                                                            i8 = 0;
                                                                        } else if (PbActivity.this.fWJ.acy() == 2 && i7 == 0) {
                                                                            i8 = 1;
                                                                        } else if (PbActivity.this.fWJ.acy() != 3 || i7 == 2) {
                                                                            i8 = (i7 != 2 || PbActivity.this.fWJ.acy() == 3) ? 0 : 3;
                                                                        }
                                                                        TiebaStatic.log("c12097");
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != e.g.pb_sort ? 1 : 0).y("obj_type", i8));
                                                                        if (PbActivity.this.fWJ.getPbData().fUj != null && PbActivity.this.fWJ.getPbData().fUj.size() > i7) {
                                                                            i7 = PbActivity.this.fWJ.getPbData().fUj.get(i7).sort_type.intValue();
                                                                        }
                                                                        boolean sJ = PbActivity.this.fWJ.sJ(i7);
                                                                        view.setTag(Integer.valueOf(PbActivity.this.fWJ.bkL()));
                                                                        if (sJ) {
                                                                            PbActivity.this.mIsLoading = true;
                                                                            PbActivity.this.fWM.lj(true);
                                                                        }
                                                                        bVar2.dismiss();
                                                                    }
                                                                });
                                                                bVar.d(PbActivity.this.getPageContext()).BV();
                                                            } else {
                                                                PbActivity.this.showToast(e.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fWM.bmF();
                                                        if (PbActivity.this.biD().getPbData().fUk != 2) {
                                                            if (PbActivity.this.fWJ.getPageData() != null) {
                                                                PbActivity.this.fWM.a(PbActivity.this.fWJ.getPageData(), PbActivity.this.fKJ);
                                                            }
                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            PbActivity.this.showToast(e.j.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (ax.jJ() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fWJ != null) {
                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12386");
                                                        amVar.aB("tid", PbActivity.this.fWJ.bkt());
                                                        amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
                                                        amVar.aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getForumId());
                                                        amVar.y("obj_locate", 6);
                                                        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        TiebaStatic.log(amVar);
                                                    }
                                                    if (com.baidu.adp.lib.util.l.ll()) {
                                                        if (PbActivity.this.fWJ.getPbData() != null) {
                                                            ArrayList<PostData> bhB2 = PbActivity.this.fWJ.getPbData().bhB();
                                                            if ((bhB2 != null && bhB2.size() > 0) || !PbActivity.this.fWJ.bku()) {
                                                                PbActivity.this.fWM.bmF();
                                                                PbActivity.this.aCj();
                                                                PbActivity.this.sw(2);
                                                                if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhT() != null && !StringUtils.isNull(PbActivity.this.fWJ.getPbData().bhT().yF(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                                if (ax.jJ()) {
                                                                    PbActivity.this.sx(2);
                                                                } else {
                                                                    PbActivity.this.fWM.showLoadingDialog();
                                                                    PbActivity.this.fWJ.bkX().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.fWM.gfP.dismissPopMenu();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                            PbActivity.this.fWM.bmF();
                                            if (PbActivity.this.fWM.gfP.bnC() != null && view == PbActivity.this.fWM.gfP.bnC().blu() && !PbActivity.this.fWM.bmX()) {
                                                PbActivity.this.fWM.blU();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.aCj();
                                                PbActivity.this.fWM.bmp();
                                                if (view.getId() == e.g.floor_owner_reply) {
                                                    p = PbActivity.this.fWJ.p(true, PbActivity.this.bjs());
                                                } else {
                                                    p = view.getId() == e.g.reply_title ? PbActivity.this.fWJ.p(false, PbActivity.this.bjs()) : PbActivity.this.fWJ.tn(PbActivity.this.bjs());
                                                }
                                                view.setTag(Boolean.valueOf(p));
                                                if (p) {
                                                    PbActivity.this.fWM.kS(true);
                                                    PbActivity.this.fWM.aTJ();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fWM.lj(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.sw(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(e.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.kV()) {
                                        PbActivity.this.fWM.bmF();
                                        if (PbActivity.this.sv(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fWJ.sK(PbActivity.this.fWM.bmu()) != null) {
                                            PbActivity.this.bjm();
                                            if (PbActivity.this.fWJ.getPbData().bhz() != null && PbActivity.this.fWJ.getPbData().bhz().zT() != null && PbActivity.this.fWJ.getPbData().bhz().zT().getUserId() != null && PbActivity.this.fWL != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").aB("tid", PbActivity.this.fWJ.gbP).y("obj_locate", 1).aB(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fWJ.getPbData().bhz().zT().getUserId()).y("obj_type", PbActivity.this.fWL.wx() ? 0 : 1).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fWJ.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(e.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.kV()) {
                                    PbActivity.this.fWM.kS(true);
                                    PbActivity.this.fWM.blU();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fWM.aTJ();
                                        PbActivity.this.aCj();
                                        PbActivity.this.fWM.bmp();
                                        PbActivity.this.fWJ.tn(PbActivity.this.bjs());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.sw(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(e.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhz() != null && PbActivity.this.fWJ.getPbData().bhz().AH() && PbActivity.this.fWJ.getPbData().bhz().Al() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.fWJ.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fWJ.biu()) && PbActivity.this.fWJ.getAppealInfo() != null) {
                                        name = PbActivity.this.fWJ.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fWJ.getPbData().bhx().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String biu = PbActivity.this.fWJ.biu();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fWJ.bkv() && biu != null && biu.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.kV()) {
                            if (PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhL() == 1 && !PbActivity.this.cZj.bFD()) {
                                PbActivity.this.fWM.bmF();
                                int i7 = 0;
                                if (PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().blv()) {
                                    if (PbActivity.this.fWM.gfP.bnC() == null || view != PbActivity.this.fWM.gfP.bnC().blx()) {
                                        if (view == PbActivity.this.fWM.bmn()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.fWJ.getPbData().bhz().zP() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.fWJ.getPbData().bhz().zO() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData bhx = PbActivity.this.fWJ.getPbData().bhx();
                                String name2 = bhx.getName();
                                String id3 = bhx.getId();
                                String id4 = PbActivity.this.fWJ.getPbData().bhz().getId();
                                PbActivity.this.fWM.bmm();
                                PbActivity.this.cZj.a(id3, name2, id4, i7, PbActivity.this.fWM.bmo());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(e.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.kV()) {
                        PbActivity.this.fWM.bmF();
                        PbActivity.this.aCj();
                        PbActivity.this.fWM.bmp();
                        PbActivity.this.fWM.showLoadingDialog();
                        if (PbActivity.this.fWM.bmc() != null) {
                            PbActivity.this.fWM.bmc().setVisibility(8);
                        }
                        PbActivity.this.fWJ.sE(1);
                        if (PbActivity.this.fWq != null) {
                            PbActivity.this.fWq.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(e.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(e.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == e.g.reply_god_title_group) {
                        String biZ = PbActivity.this.biZ();
                        if (!TextUtils.isEmpty(biZ)) {
                            ay.Es().c(PbActivity.this.getPageContext(), new String[]{biZ});
                        }
                    }
                } else if (PbActivity.this.fWA) {
                    PbActivity.this.fWA = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(e.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData3 = (PostData) obj;
                            if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.biU().blS() != null && postData3.zT() != null && postData3.bES() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.biU().blT() != null) {
                                    PbActivity.this.biU().blT().bkg();
                                }
                                com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                jVar.a(PbActivity.this.fWJ.getPbData().bhx());
                                jVar.aa(PbActivity.this.fWJ.getPbData().bhz());
                                jVar.e(postData3);
                                PbActivity.this.biU().blS().d(jVar);
                                PbActivity.this.biU().blS().setPostId(postData3.getId());
                                PbActivity.this.a(view, postData3.zT().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(PbActivity.this.fWJ.getPbData(), postData3, postData3.locate, 8, 1);
                                if (PbActivity.this.fWZ != null) {
                                    PbActivity.this.fWM.lt(PbActivity.this.fWZ.MV());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d baT = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null) {
                    amVar.aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getPbData().getForumId());
                }
                if (PbActivity.this.fWJ != null) {
                    amVar.aB("tid", PbActivity.this.fWJ.bkt());
                }
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.aCj();
            PbActivity.this.fWM.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.ao.PV() && PbActivity.this.biD() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.biD().tq(postWriteCallBackData.getPostId());
                    PbActivity.this.fXm = PbActivity.this.fWM.blX();
                    if (PbActivity.this.fWJ != null) {
                        PbActivity.this.fWJ.by(PbActivity.this.fXm, PbActivity.this.fWM.blY());
                    }
                }
                PbActivity.this.fWM.bmF();
                PbActivity.this.fWR.bnf();
                if (PbActivity.this.fWZ != null) {
                    PbActivity.this.fWM.lt(PbActivity.this.fWZ.MV());
                }
                PbActivity.this.fWM.blR();
                PbActivity.this.fWM.lv(true);
                PbActivity.this.fWJ.bkN();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fWJ.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fWJ.getPbData();
                            if (pbData != null && pbData.bhz() != null && pbData.bhz().zT() != null && (userId = pbData.bhz().zT().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.ao.PV() && PbActivity.this.fWJ.bkE()) {
                                PbActivity.this.fWM.bmp();
                            }
                        } else if (!com.baidu.tbadk.p.ao.PV() && PbActivity.this.fWJ.bkE()) {
                            PbActivity.this.fWM.bmp();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fWM.o(PbActivity.this.fWJ.getPbData());
                    }
                    if (PbActivity.this.fWJ.bky()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").aB("tid", PbActivity.this.fWJ.bkt()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fWZ.Nb() || PbActivity.this.fWZ.Nc()) {
                    PbActivity.this.fWZ.a(false, postWriteCallBackData);
                }
                PbActivity.this.fWR.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.fiK != null) {
                    PbActivity.this.fiK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fXL = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null) {
                    amVar.aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getPbData().getForumId());
                }
                if (PbActivity.this.fWJ != null) {
                    amVar.aB("tid", PbActivity.this.fWJ.bkt());
                }
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fWR != null) {
                    PbActivity.this.fWR.bne();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.fiK != null) {
                    PbActivity.this.fiK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fWR != null) {
                if (PbActivity.this.fWM != null && PbActivity.this.fWM.blT() != null && PbActivity.this.fWM.blT().bkl() != null && PbActivity.this.fWM.blT().bkl().Nc()) {
                    PbActivity.this.fWM.blT().bkl().a(postWriteCallBackData);
                }
                PbActivity.this.fWR.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fXM = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g fI;
            if (!z || dVar == null || dVar.bhJ() != null || com.baidu.tbadk.core.util.v.H(dVar.bhB()) >= 1) {
                PbActivity.this.fzR = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fWM.bmr();
                if (dVar == null || !dVar.bhF()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fWM.getView());
                }
                PbActivity.this.fWM.aTI();
                if (PbActivity.this.isFullScreen || PbActivity.this.fWM.bmX()) {
                    PbActivity.this.fWM.bmO();
                } else if (!PbActivity.this.fWM.bmL()) {
                    PbActivity.this.fWM.lv(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fWT = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.fWM.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.fWM.anM();
                    if (dVar.bhz() != null && dVar.bhz().AO() != null) {
                        PbActivity.this.a(dVar.bhz().AO());
                    }
                    PbActivity.this.biR();
                    if (PbActivity.this.fWZ != null) {
                        PbActivity.this.fWM.lt(PbActivity.this.fWZ.MV());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bhB() != null && dVar.bhB().size() >= 1 && dVar.bhB().get(0) != null) {
                        PbActivity.this.fWJ.tp(dVar.bhB().get(0).getId());
                    } else if (dVar.bhJ() != null) {
                        PbActivity.this.fWJ.tp(dVar.bhJ().getId());
                    }
                    if (PbActivity.this.fWZ != null) {
                        PbActivity.this.fWZ.a(dVar.yR());
                        PbActivity.this.fWZ.a(dVar.bhx(), dVar.getUserData());
                        PbActivity.this.fWZ.a(PbActivity.this.fWJ.bkH(), PbActivity.this.fWJ.bkt(), PbActivity.this.fWJ.bkZ());
                        if (dVar.bhz() != null) {
                            PbActivity.this.fWZ.cA(dVar.bhz().Be());
                        }
                    }
                    if (PbActivity.this.fWL != null) {
                        PbActivity.this.fWL.aQ(dVar.wx());
                    }
                    if (dVar == null || dVar.bhM() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fWM.lu(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fWM.a(dVar, i2, i3, PbActivity.this.fWJ.bku(), i4, PbActivity.this.fWJ.getIsFromMark());
                    PbActivity.this.fWM.d(dVar, PbActivity.this.fWJ.bku());
                    PbActivity.this.fWM.lr(PbActivity.this.fWJ.getHostMode());
                    AntiData yR = dVar.yR();
                    if (yR != null) {
                        PbActivity.this.baJ = yR.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.baJ) && PbActivity.this.fWZ != null && PbActivity.this.fWZ.Mp() != null && (fI = PbActivity.this.fWZ.Mp().fI(6)) != null && !TextUtils.isEmpty(PbActivity.this.baJ)) {
                            ((View) fI).setOnClickListener(PbActivity.this.bbt);
                        }
                    }
                    if (PbActivity.this.fWV) {
                        PbActivity.this.fWV = false;
                        final int bjh = PbActivity.this.bjh();
                        if (dVar.bhY()) {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bjh, aO);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.biU().sQ(bjh);
                        }
                    }
                    if (PbActivity.this.fWW) {
                        PbActivity.this.fWW = false;
                        final int bjh2 = PbActivity.this.bjh();
                        final boolean z2 = bjh2 != -1;
                        if (!z2) {
                            bjh2 = PbActivity.this.bji();
                        }
                        if (PbActivity.this.biU() != null) {
                            if (dVar.bhY()) {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bjh2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bjh2, aO2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bjh2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.biU().lw(true);
                            } else {
                                PbActivity.this.biU().sQ(bjh2);
                            }
                        }
                    } else {
                        PbActivity.this.fWM.bmv();
                    }
                    PbActivity.this.fWJ.a(dVar.bhx(), PbActivity.this.fXz);
                    PbActivity.this.fWJ.a(PbActivity.this.fXA);
                    if (PbActivity.this.fiK != null && dVar.bhz() != null && dVar.bhz().zT() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bhz().zT());
                        PbActivity.this.fiK.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fWT && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fWJ.getAppealInfo().fTB)) {
                                    PbActivity.this.fWM.a(PbActivity.this.fWJ.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fWM.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fWM.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
                            }
                            PbActivity.this.fWM.bmO();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fWJ.bkt());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getForumId());
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
                        PbActivity.this.fWM.tt(PbActivity.this.getResources().getString(e.j.list_no_more_new));
                    } else {
                        PbActivity.this.fWM.tt("");
                    }
                    PbActivity.this.fWM.Fq();
                }
                PbActivity.this.bgJ = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.biD().bku() || PbActivity.this.biD().getPbData().zf().zd() != 0 || PbActivity.this.biD().bkT()) {
                    PbActivity.this.fXa = true;
                    return;
                }
                return;
            }
            PbActivity.this.fWJ.sE(1);
            if (PbActivity.this.fWq != null) {
                PbActivity.this.fWq.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fWM.o(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.m.PD().PE()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.dsd : j;
                com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, PbActivity.this.bgB, PbActivity.this.createTime, PbActivity.this.bgJ, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.bgB = 0L;
                if (iVar != null) {
                    iVar.PA();
                }
                if (z2) {
                    iVar.bgS = currentTimeMillis;
                    iVar.cO(true);
                }
                if (!z2 && PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhz() != null) {
                    int threadType = PbActivity.this.fWJ.getPbData().bhz().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fWD, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fWD, "from_frs")) {
                                com.baidu.tbadk.l.i iVar2 = new com.baidu.tbadk.l.i();
                                iVar2.gj(1000);
                                iVar2.bgU = currentTimeMillis;
                                iVar2.gk(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.l.d dVar = new com.baidu.tbadk.l.d();
                        dVar.pageType = 1;
                        dVar.gj(1005);
                        dVar.bgU = currentTimeMillis;
                        dVar.gk(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fXN = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bjd();
            }
        }
    };
    private final a.InterfaceC0154a fXO = new a.InterfaceC0154a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fWM.bmr();
            if (z) {
                if (PbActivity.this.fWL != null) {
                    PbActivity.this.fWL.aQ(z2);
                }
                PbActivity.this.fWJ.kZ(z2);
                if (PbActivity.this.fWJ.wx()) {
                    PbActivity.this.bjn();
                } else {
                    PbActivity.this.fWM.o(PbActivity.this.fWJ.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fWL != null && PbActivity.this.fWL.wA() != null && PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhz() != null && PbActivity.this.fWJ.getPbData().bhz().zT() != null) {
                        MarkData wA = PbActivity.this.fWL.wA();
                        MetaData zT = PbActivity.this.fWJ.getPbData().bhz().zT();
                        if (wA != null && zT != null) {
                            if (!com.baidu.tbadk.core.util.ao.equals(TbadkCoreApplication.getCurrentAccount(), zT.getUserId()) && !zT.hadConcerned()) {
                                PbActivity.this.b(zT);
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
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.ss(PbActivity.this.mLastScrollState) && PbActivity.this.ss(i)) {
                if (PbActivity.this.fWM != null) {
                    PbActivity.this.fWM.bmF();
                    if (PbActivity.this.fWZ != null && !PbActivity.this.fWM.blV()) {
                        PbActivity.this.fWM.lt(PbActivity.this.fWZ.MV());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fWM.blU();
                    }
                }
                if (!PbActivity.this.fWx) {
                    PbActivity.this.fWx = true;
                    PbActivity.this.fWM.bmK();
                }
            }
            PbActivity.this.fWM.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fWq != null) {
                PbActivity.this.fWq.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fWy == null) {
                PbActivity.this.fWy = new com.baidu.tbadk.l.b();
                PbActivity.this.fWy.gj(1001);
            }
            if (i == 0) {
                PbActivity.this.fWy.Pu();
            } else {
                PbActivity.this.fWy.Pt();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.bCC().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bhB;
            if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWM != null && PbActivity.this.fWM.bml() != null) {
                PbActivity.this.fWM.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fWq != null) {
                    PbActivity.this.fWq.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fWJ.bkP() && (bhB = PbActivity.this.fWJ.getPbData().bhB()) != null && !bhB.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fWM.bml().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fWJ.getPbData();
                    if (pbData != null) {
                        if (pbData.bhC() != null && pbData.bhC().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bhD() != null && pbData.bhD().hasData()) {
                            headerCount--;
                        }
                        int size = bhB.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cZn = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cZj.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fWJ.bkN();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gmE != 1002 || bVar.eqF) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fWM.a(1, dVar.HZ, dVar.hsc, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cZj.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fWM.a(PbActivity.this.cZj.getLoadDataMode(), gVar.HZ, gVar.hsc, false);
                        PbActivity.this.fWM.ap(gVar.hsf);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fWM.a(PbActivity.this.cZj.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fXP = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final j.b bEp = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.j.b
        public void bI(boolean z) {
            if (PbActivity.this.bjt()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fWJ.kY(true)) {
                PbActivity.this.fWM.bms();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e eeB = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fXQ && PbActivity.this.bjt()) {
                PbActivity.this.bjv();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fWJ.kX(false)) {
                    PbActivity.this.fWM.bmq();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fWJ.getPbData() != null) {
                    PbActivity.this.fWM.bmJ();
                }
                PbActivity.this.fXQ = true;
            }
        }
    };
    private int fXR = 0;
    private final TbRichTextView.h bsD = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            f bml;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fWM.b((TbRichText) view.getTag());
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
                    PbActivity.this.fWH = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fYG) {
                    TbRichText aM = PbActivity.this.aM(str, i);
                    if (aM != null && PbActivity.this.fXR >= 0 && PbActivity.this.fXR < aM.Sx().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aM.Sx().get(PbActivity.this.fXR));
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= cVar.fYD.size()) {
                                break;
                            } else if (!cVar.fYD.get(i4).equals(b2)) {
                                i3 = i4 + 1;
                            } else {
                                cVar.index = i4;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        if (aM.getPostId() != 0 && (bml = PbActivity.this.fWM.bml()) != null) {
                            ArrayList<com.baidu.adp.widget.ListView.h> dataList = bml.getDataList();
                            if (com.baidu.tbadk.core.util.v.H(dataList) > 0) {
                                Iterator<com.baidu.adp.widget.ListView.h> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    com.baidu.adp.widget.ListView.h next = it.next();
                                    if ((next instanceof PostData) && aM.getPostId() == com.baidu.adp.lib.g.b.d(((PostData) next).getId(), 0L)) {
                                        if (aM.getPostId() != com.baidu.adp.lib.g.b.d(PbActivity.this.fWJ.bkZ(), 0L)) {
                                            i2 = 8;
                                        } else {
                                            i2 = 1;
                                        }
                                        com.baidu.tieba.pb.c.a.a(PbActivity.this.fWJ.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.I(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fYE.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fYF, cVar.lastId, PbActivity.this.fWJ.bkK(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbActivity.this.l(rect);
                        createConfig.setIsHotSort(PbActivity.this.fWJ.acy() == 2);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.d(cVar.fYD, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.I(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fYE.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fYF, cVar.fYD.get(0), PbActivity.this.fWJ.bkK(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                createConfig2.setIsHotSort(PbActivity.this.fWJ.acy() == 2);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fXS = false;
    PostData fXT = null;
    private final b.InterfaceC0158b fXU = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fXT != null) {
                if (i == 0) {
                    PbActivity.this.fXT.cZ(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fXT = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fXT);
                }
            }
        }
    };
    private final b.InterfaceC0158b fXV = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fXj != null && !TextUtils.isEmpty(PbActivity.this.fXk)) {
                if (i == 0) {
                    if (PbActivity.this.fXl == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fXk));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fXk;
                        aVar.pkgId = PbActivity.this.fXl.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fXl.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.EG();
                    PbActivity.this.mPermissionJudgement.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.B(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fXi == null) {
                            PbActivity.this.fXi = new av(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fXi.i(PbActivity.this.fXk, PbActivity.this.fXj.ow());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fXj = null;
                PbActivity.this.fXk = null;
            }
        }
    };
    private final View.OnLongClickListener aTZ = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
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
                if (PbActivity.this.by(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.fXj = ((TbImageView) view).getBdImage();
                        PbActivity.this.fXk = ((TbImageView) view).getUrl();
                        if (PbActivity.this.fXj != null && !TextUtils.isEmpty(PbActivity.this.fXk)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fXl = null;
                            } else {
                                PbActivity.this.fXl = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                PbActivity.this.fWM.a(PbActivity.this.fXV, PbActivity.this.fXj.isGif());
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
                            PbActivity.this.fXj = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.fXk = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fXl = null;
                            } else {
                                PbActivity.this.fXl = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.fXj = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.fXk = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.fXl = null;
                        } else {
                            PbActivity.this.fXl = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
            PbActivity.this.fXT = (PostData) sparseArray.get(e.g.tag_clip_board);
            if (PbActivity.this.fXT != null) {
                if (PbActivity.this.fXT.bES() != 1 || !PbActivity.this.by(view)) {
                    if (PbActivity.this.fWL != null) {
                        boolean z2 = PbActivity.this.fWL.wx() && PbActivity.this.fXT.getId() != null && PbActivity.this.fXT.getId().equals(PbActivity.this.fWJ.Ad());
                        if (view == null || sparseArray == null) {
                            z = false;
                        } else {
                            if (PbActivity.this.fWS == null) {
                                PbActivity.this.fWS = new y(PbActivity.this.getPageContext(), PbActivity.this.dNr);
                                PbActivity.this.fWM.bH(PbActivity.this.fWS.getView());
                                PbActivity.this.fWS.lb(PbActivity.this.mIsLogin);
                            }
                            if (PbActivity.this.fXT.bES() == 1) {
                                PbActivity.this.fWM.a(PbActivity.this.fXU, z2, false);
                            } else {
                                PbActivity.this.fWS.showDialog();
                                z = PbActivity.this.kJ(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & PbActivity.this.isLogin();
                            }
                        }
                        boolean booleanValue = sparseArray.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            PbActivity.this.fWS.blj().setText(e.j.remove_mark);
                        } else {
                            PbActivity.this.fWS.blj().setText(e.j.mark);
                        }
                        if (booleanValue) {
                            PbActivity.this.fWS.blj().setVisibility(8);
                        } else {
                            PbActivity.this.fWS.blj().setVisibility(0);
                        }
                        if (PbActivity.this.by(view)) {
                            if (PbActivity.this.fXj != null && !PbActivity.this.fXj.isGif()) {
                                sparseArray.put(e.g.tag_richtext_image, true);
                            } else {
                                sparseArray.put(e.g.tag_richtext_image, false);
                            }
                            sparseArray.put(e.g.tag_richtext_emotion, true);
                        } else {
                            sparseArray.put(e.g.tag_richtext_image, false);
                            sparseArray.put(e.g.tag_richtext_emotion, false);
                        }
                        PbActivity.this.fWS.a(sparseArray, PbActivity.this.fWJ.getPbData().bhL(), z);
                        PbActivity.this.fWS.refreshUI();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").aB("tid", PbActivity.this.fWJ.gbP).aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getForumId()).aB("uid", PbActivity.this.fWJ.getPbData().bhz().zT().getUserId()).aB("post_id", PbActivity.this.fWJ.MK()).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, booleanValue ? 2 : 1));
                    }
                } else {
                    PbActivity.this.fWM.a(PbActivity.this.fXV, PbActivity.this.fXj.isGif());
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dJm = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (!PbActivity.this.fWs && z && !PbActivity.this.fWJ.bkB()) {
                PbActivity.this.bjp();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
        }
    };
    public View.OnTouchListener bjC = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.cxA.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0214a cxB = new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        final int cIL;

        {
            this.cIL = (int) PbActivity.this.getResources().getDimension(e.C0210e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (ag(i2) && PbActivity.this.fWM != null && PbActivity.this.fWq != null) {
                PbActivity.this.fWM.bmP();
                PbActivity.this.fWq.gT(false);
                PbActivity.this.fWq.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            if (ag(i2) && PbActivity.this.fWM != null && PbActivity.this.fWq != null) {
                PbActivity.this.fWq.gT(true);
                if (Math.abs(i2) > this.cIL) {
                    PbActivity.this.fWq.hideFloatingView();
                }
                if (PbActivity.this.bjt()) {
                    PbActivity.this.fWM.bmh();
                    PbActivity.this.fWM.bmi();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fXX = null;
    private final m.a fXY = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void k(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(e.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fXX = str2;
                PbActivity.this.fWM.tu(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fXZ = -1;
    private int fYa = -1;
    private CustomMessageListener fYd = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.apj == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0156a) {
                    if (aVar.apk != null && !aVar.apk.hasError() && aVar.apk.getError() == 0) {
                        if (PbActivity.this.fWM != null) {
                            PbActivity.this.fWM.n(((a.C0156a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bjE();
                        }
                    } else if (z) {
                        if (aVar.apk != null && aVar.apk.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.apk.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.apk != null && !aVar.apk.hasError() && aVar.apk.getError() == 0) {
                        if (PbActivity.this.fWM != null && PbActivity.this.fWM != null) {
                            PbActivity.this.fWM.n(((a.C0156a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.apk != null && aVar.apk.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.apk.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.apk == null || aVar.apk.hasError() || aVar.apk.getError() != 0) {
                        if (z) {
                            if (aVar.apk != null && aVar.apk.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.apk.getErrorString());
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
        public ArrayList<String> fYD;
        public ConcurrentHashMap<String, ImageUrlData> fYE;
        public boolean fYG;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fYF = false;
        public boolean fYH = false;
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

    public com.baidu.tbadk.editortools.pb.d biP() {
        return this.fWZ;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.big() != null) {
            String id = jVar.big().getId();
            ArrayList<PostData> bhB = this.fWJ.getPbData().bhB();
            int i = 0;
            while (true) {
                if (i >= bhB.size()) {
                    break;
                }
                PostData postData = bhB.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bik = jVar.bik();
                    postData.vK(jVar.getTotalCount());
                    if (postData.bEP() != null && bik != null) {
                        Iterator<PostData> it = bik.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.zT() != null && (metaData = postData.getUserMap().get(next.zT().getUserId())) != null) {
                                next.a(metaData);
                                next.ny(true);
                                next.a(getPageContext(), this.fWJ.to(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bik.size() != postData.bEP().size();
                        postData.bEP().clear();
                        postData.bEP().addAll(bik);
                        z = z2;
                    }
                    if (postData.bEL() != null) {
                        postData.bEM();
                    }
                }
            }
            if (!this.fWJ.getIsFromMark() && z) {
                this.fWM.o(this.fWJ.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.l bhP = this.fWJ.getPbData().bhP();
            if (bhP != null && str.equals(bhP.getAdId())) {
                if (bhP.bEG() != null) {
                    bhP.bEG().legoCard = null;
                }
                this.fWJ.getPbData().bhQ();
            }
            com.baidu.tieba.tbadkCore.data.l bkF = this.fWJ.bkF();
            if (bkF != null && str.equals(bkF.getAdId())) {
                this.fWJ.bkG();
            }
        }
    }

    public void biQ() {
        com.baidu.tieba.pb.data.d pbData;
        bb bhz;
        if (!this.fXC) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                showToast(e.j.no_network_guide);
            } else if (this.fXF) {
                this.fXC = true;
                if (this.fWJ != null && (pbData = this.fWJ.getPbData()) != null && (bhz = pbData.bhz()) != null) {
                    int isLike = bhz.zG() == null ? 0 : bhz.zG().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10796").aB("tid", bhz.getId()));
                    }
                    if (this.fXD != null) {
                        this.fXD.a(bhz.Ak(), bhz.getId(), isLike, "pb");
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
                bVar.de(e.j.operation);
                int i = -1;
                if (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(e.j.delete);
                    strArr[1] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fWM.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fXg);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fXg);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fXg);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fXg);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).BV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj(int i) {
        bb bhz;
        String str;
        String V;
        if (this.fWJ != null && this.fWJ.getPbData() != null && (bhz = this.fWJ.getPbData().bhz()) != null) {
            if (i == 1) {
                PraiseData zG = bhz.zG();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zG == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bhz.a(praiseData);
                    } else {
                        bhz.zG().getUser().add(0, metaData);
                        bhz.zG().setNum(bhz.zG().getNum() + 1);
                        bhz.zG().setIsLike(i);
                    }
                }
                if (bhz.zG() != null) {
                    if (bhz.zG().getNum() < 1) {
                        V = getResources().getString(e.j.zan);
                    } else {
                        V = com.baidu.tbadk.core.util.ao.V(bhz.zG().getNum());
                    }
                    this.fWM.V(V, true);
                }
            } else if (bhz.zG() != null) {
                bhz.zG().setIsLike(i);
                bhz.zG().setNum(bhz.zG().getNum() - 1);
                ArrayList<MetaData> user = bhz.zG().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bhz.zG().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bhz.zG().getNum() < 1) {
                    str = getResources().getString(e.j.zan);
                } else {
                    str = bhz.zG().getNum() + "";
                }
                this.fWM.V(str, false);
            }
            if (this.fWJ.bku()) {
                this.fWM.bml().notifyDataSetChanged();
            } else {
                this.fWM.p(this.fWJ.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fWJ.G(bundle);
        if (this.dLz != null) {
            this.dLz.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fWZ.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fWw = System.currentTimeMillis();
        this.fXe = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dsd = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fWD = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fWD) && intent.getData() != null) {
                this.fWD = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fWD)) {
                this.fWr = true;
            }
            this.fXZ = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fYa = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fYb = intent.getStringExtra("key_manga_title");
            this.fWV = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fWW = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bjt()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ao.isEmpty(this.source) ? "" : this.source;
            this.fXn = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dsd = System.currentTimeMillis();
        }
        this.bgB = this.fWw - this.dsd;
        super.onCreate(bundle);
        this.fWu = 0;
        F(bundle);
        if (this.fWJ != null && this.fWJ.getPbData() != null) {
            this.fWJ.getPbData().tf(this.source);
        }
        initUI();
        if (intent != null && this.fWM != null) {
            this.fWM.gfI = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fXh == null) {
                    this.fXh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fWM.tw("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fXh, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fWJ != null && this.fWJ.getPbData() != null) {
                this.fWJ.tr(stringExtra);
            }
        }
        this.dLz = new VoiceManager();
        this.dLz.onCreate(getPageContext());
        initData(bundle);
        this.fWY = new com.baidu.tbadk.editortools.pb.f();
        biR();
        this.fWZ = (com.baidu.tbadk.editortools.pb.d) this.fWY.bM(getActivity());
        this.fWZ.b(this);
        this.fWZ.a(this.baT);
        this.fWZ.a(this.baM);
        this.fWZ.a(this, bundle);
        this.fWZ.Mp().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fWZ.Mp().ct(true);
        kI(true);
        this.fWM.setEditorTools(this.fWZ.Mp());
        this.fWZ.a(this.fWJ.bkH(), this.fWJ.bkt(), this.fWJ.bkZ());
        registerListener(this.fXu);
        if (!this.fWJ.bkA()) {
            this.fWZ.ie(this.fWJ.bkt());
        }
        if (this.fWJ.bla()) {
            this.fWZ.ib(getPageContext().getString(e.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fWZ.ib(getPageContext().getString(e.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fXt);
        registerListener(this.fXv);
        registerListener(this.fXw);
        registerListener(this.dMI);
        registerListener(this.fXK);
        registerListener(this.fXs);
        this.fWX = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.hpc);
        this.fWX.bEt();
        registerListener(this.fXy);
        registerListener(this.mAttentionListener);
        if (this.fWJ != null) {
            this.fWJ.bkR();
        }
        registerListener(this.fXN);
        registerListener(this.fYd);
        registerListener(this.dMP);
        if (this.fWM != null && this.fWM.bmT() != null && this.fWM.bmU() != null) {
            this.fWq = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.fWM.bmT(), this.fWM.bmU(), this.fWM.bmc());
            this.fWq.a(this.fXG);
        }
        if (this.fWp && this.fWM != null && this.fWM.bmU() != null) {
            this.fWM.bmU().setVisibility(8);
        }
        this.fXf = new com.baidu.tbadk.core.view.g();
        this.fXf.aHF = 1000L;
        registerListener(this.fXJ);
        registerListener(this.fXH);
        registerListener(this.fXI);
        registerListener(this.eeb);
        registerListener(this.akJ);
        this.fXg = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fXg;
        userMuteAddAndDelCustomMessage.setTag(this.fXg);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fXg;
        userMuteCheckCustomMessage.setTag(this.fXg);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fWJ.bkX().a(this.cwR);
        this.fWR = new at();
        if (this.fWZ.MO() != null) {
            this.fWR.g(this.fWZ.MO().getInputView());
        }
        this.fWZ.a(this.baN);
        this.ebd = new ShareSuccessReplyToServerModel();
        a(this.fXp);
        this.fiK = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.fiK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.aCy) {
                        PbActivity.this.fWZ.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.aCz && PbActivity.this.fWM != null && PbActivity.this.fWM.blT() != null && PbActivity.this.fWM.blT().bkl() != null) {
                        PbActivity.this.fWM.blT().bkl().Nh();
                    } else if (i == com.baidu.tbadk.core.util.aj.aCA) {
                        PbActivity.this.c(PbActivity.this.fXb);
                    }
                }
            }
        });
        this.fWK = new com.baidu.tieba.pb.pb.report.a(this);
        this.fWK.o(getUniqueId());
        com.baidu.tieba.q.c.bCC().r(getUniqueId());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.kW() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.createTime = System.currentTimeMillis() - this.fWw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biR() {
        if (this.fWY != null && this.fWJ != null) {
            this.fWY.setForumName(this.fWJ.biu());
            if (this.fWJ.getPbData() != null && this.fWJ.getPbData().bhx() != null) {
                this.fWY.a(this.fWJ.getPbData().bhx());
            }
            this.fWY.setFrom("pb");
            this.fWY.a(this.fWJ);
        }
    }

    public String biS() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b biT() {
        return this.fWq;
    }

    private void kI(boolean z) {
        this.fWZ.cx(z);
        this.fWZ.cy(z);
        this.fWZ.cz(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhY() && !z && this.fWM != null && this.fWM.getView() != null) {
            this.fWM.getView().setSystemUiVisibility(4);
        }
        this.fXc = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dLz != null) {
            this.dLz.onStart(getPageContext());
        }
    }

    public ar biU() {
        return this.fWM;
    }

    public PbModel biD() {
        return this.fWJ;
    }

    public void ti(String str) {
        if (this.fWJ != null && !StringUtils.isNull(str) && this.fWM != null) {
            this.fWM.ly(true);
            this.fWJ.ti(str);
            this.fWC = true;
            this.fWM.bmF();
            this.fWM.bmO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fWs = false;
        } else {
            this.fWs = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fWu = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fWu == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dLz != null) {
            this.dLz.onPause(getPageContext());
        }
        if (this.fWM != null) {
            this.fWM.onPause();
        }
        if (!this.fWJ.bkA()) {
            this.fWZ.ic(this.fWJ.bkt());
        }
        if (this.fWJ != null) {
            this.fWJ.bkS();
        }
        com.baidu.tbadk.BdToken.c.vy().vz();
        MessageManager.getInstance().unRegisterListener(this.eMD);
        aNs();
        MessageManager.getInstance().unRegisterListener(this.fXH);
        MessageManager.getInstance().unRegisterListener(this.fXI);
        MessageManager.getInstance().unRegisterListener(this.fXJ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean biV() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fWJ.getPbData(), this.fWJ.bku(), this.fWJ.getRequestType());
        return (a2 == null || a2.zT() == null || a2.zT().getGodUserData() == null || a2.zT().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fWs = false;
        super.onResume();
        if (this.fWF) {
            this.fWF = false;
            bjz();
        }
        if (biV()) {
            this.fWz = System.currentTimeMillis();
        } else {
            this.fWz = -1L;
        }
        if (this.fWM != null && this.fWM.getView() != null) {
            if (!this.fzR) {
                bjq();
            } else {
                hideLoadingView(this.fWM.getView());
            }
            this.fWM.onResume();
        }
        if (this.fWu == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fWM != null) {
            noNetworkView = this.fWM.blQ();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kV()) {
            noNetworkView.bF(false);
        }
        if (this.dLz != null) {
            this.dLz.onResume(getPageContext());
        }
        registerListener(this.eMD);
        this.fWU = false;
        bjy();
        registerListener(this.fXH);
        registerListener(this.fXI);
        registerListener(this.fXJ);
        if (this.dMh) {
            bjp();
            this.dMh = false;
        }
        bjH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fWM.lm(z);
        if (this.fWS != null) {
            this.fWS.lb(z);
        }
        if (z && this.fWU) {
            this.fWM.bmq();
            this.fWJ.kX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fWz > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").aB("obj_duration", (System.currentTimeMillis() - this.fWz) + ""));
            this.fWz = 0L;
        }
        if (biU().blT() != null) {
            biU().blT().onStop();
        }
        if (this.fWM.gfP != null && !this.fWM.gfP.arx()) {
            this.fWM.gfP.aYH();
        }
        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhx() != null && this.fWJ.getPbData().bhz() != null) {
            com.baidu.tbadk.distribute.a.Mc().a(getPageContext().getPageActivity(), "pb", this.fWJ.getPbData().bhx().getId(), com.baidu.adp.lib.g.b.d(this.fWJ.getPbData().bhz().getId(), 0L));
        }
        if (this.dLz != null) {
            this.dLz.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.bCC().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.bCC().s(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aB(ImageViewerConfig.FORUM_ID, this.fWJ.getPbData().getForumId());
            amVar.aB("tid", this.fWJ.bkt());
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.fWx && this.fWM != null) {
            this.fWx = true;
            this.fWM.bmK();
            a(false, (PostData) null);
        }
        if (this.fWJ != null) {
            this.fWJ.cancelLoadData();
            this.fWJ.destory();
            if (this.fWJ.bkW() != null) {
                this.fWJ.bkW().onDestroy();
            }
        }
        if (this.fWZ != null) {
            this.fWZ.onDestroy();
        }
        if (this.cZj != null) {
            this.cZj.cancelLoadData();
        }
        if (this.fWM != null) {
            this.fWM.onDestroy();
            if (this.fWM.gfP != null) {
                this.fWM.gfP.aYH();
            }
        }
        if (this.fWy != null) {
            this.fWy.Pv();
        }
        if (this.fWq != null) {
            this.fWq.Qz();
        }
        super.onDestroy();
        if (this.dLz != null) {
            this.dLz.onDestory(getPageContext());
        }
        this.fWM.bmF();
        MessageManager.getInstance().unRegisterListener(this.fXH);
        MessageManager.getInstance().unRegisterListener(this.fXI);
        MessageManager.getInstance().unRegisterListener(this.fXJ);
        MessageManager.getInstance().unRegisterListener(this.fXg);
        MessageManager.getInstance().unRegisterListener(this.fXK);
        MessageManager.getInstance().unRegisterListener(this.dMP);
        MessageManager.getInstance().unRegisterListener(this.eeb);
        this.fXe = null;
        this.fXf = null;
        com.baidu.tieba.recapp.d.a.bwJ().bwL();
        if (this.fXh != null) {
            getSafeHandler().removeCallbacks(this.fXh);
        }
        if (this.fWG != null) {
            this.fWG.cancelLoadData();
        }
        if (this.fWM != null && this.fWM.gfP != null) {
            this.fWM.gfP.bnG();
        }
        if (this.ebd != null) {
            this.ebd.cancelLoadData();
        }
        this.fWR.onDestroy();
        if (this.dMl != null) {
            this.dMl.onDestroy();
        }
        if (this.fWJ != null && this.fWJ.bkY() != null) {
            this.fWJ.bkY().onDestroy();
        }
        if (this.fiK != null) {
            this.fiK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bml;
        ArrayList<PostData> bjX;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.GH() && this.fWM != null && (bml = this.fWM.bml()) != null && (bjX = bml.bjX()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bjX.iterator();
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
                        bVar.dbk = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.auM == 1 && !TextUtils.isEmpty(id)) {
                    next.auM = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.dbk = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fWJ == null || this.fWJ.getPbData() == null || this.fWJ.getPbData().bhx() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fWJ.getPbData().bhx().getFirst_class();
                    str2 = this.fWJ.getPbData().bhx().getSecond_class();
                    str = this.fWJ.getPbData().bhx().getId();
                    str4 = this.fWJ.bkt();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.GK());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fWM.onChangeSkinType(i);
            if (this.fWZ != null && this.fWZ.Mp() != null) {
                this.fWZ.Mp().onChangeSkinType(i);
            }
            if (this.fWM.blQ() != null) {
                this.fWM.blQ().onChangeSkinType(getPageContext(), i);
            }
            this.fWR.onChangeSkinType();
            if (this.dMl != null) {
                this.dMl.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fWM = new ar(this, this.dNr, this.bsE);
        this.cxA = new com.baidu.tieba.f.b(getActivity());
        this.cxA.a(fXW);
        this.cxA.a(this.cxB);
        this.fWM.setOnScrollListener(this.mOnScrollListener);
        this.fWM.e(this.eeB);
        this.fWM.a(this.bEp);
        this.fWM.kC(com.baidu.tbadk.core.i.xR().xV());
        this.fWM.setOnImageClickListener(this.bsD);
        this.fWM.b(this.aTZ);
        this.fWM.h(this.dJm);
        this.fWM.a(this.fXP);
        this.fWM.lm(this.mIsLogin);
        if (getIntent() != null) {
            this.fWM.lz(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fWM.blS().setFromForumId(this.fWJ.getFromForumId());
    }

    public void biW() {
        if (this.fWM != null && this.fWJ != null) {
            if (this.fWJ.getPbData() != null || this.fWJ.getPbData().bhX() != null) {
                TiebaStatic.log(bja().y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).y("obj_locate", 4).y(VideoPlayActivityConfig.OBJ_ID, biD().getPbData().bhX().bid() ? 0 : 1));
                if (checkUpIsLogin() && this.fWM.bml() != null && this.fWM.bml().bkc() != null) {
                    this.fWM.bml().bkc().gF(this.fWJ.bkt());
                }
            }
        }
    }

    public void biX() {
        TiebaStatic.log("c12181");
        if (this.fWM != null && this.fWJ != null) {
            if (this.fWM == null || this.fWM.blV()) {
                if (this.fWJ.getPbData() != null || this.fWJ.getPbData().bhX() != null) {
                    com.baidu.tieba.pb.data.i bhX = this.fWJ.getPbData().bhX();
                    TiebaStatic.log(bja().y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).y("obj_locate", 4).y(VideoPlayActivityConfig.OBJ_ID, bhX.bid() ? 0 : 1));
                    if (checkUpIsLogin()) {
                        if ((!bhX.bid() || bhX.Bi() != 2) && this.fWM.bml() != null && this.fWM.bml().bkc() != null) {
                            this.fWM.bml().bkc().gF(this.fWJ.bkt());
                        }
                        if (System.currentTimeMillis() - this.fWB > SystemScreenshotManager.DELAY_TIME) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).lU(false);
                            this.fWB = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bv(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(e.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.hpE && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.xR().xV()) {
                    return tl(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fWJ == null || this.fWJ.getPbData() == null) {
                        return true;
                    }
                    if (biU().blT() != null) {
                        biU().blT().bkg();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.fWJ.getPbData().bhx());
                    jVar.aa(this.fWJ.getPbData().bhz());
                    jVar.e(postData);
                    biU().blS().d(jVar);
                    biU().blS().setPostId(postData.getId());
                    a(view, postData.zT().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fWZ != null) {
                        this.fWM.lt(this.fWZ.MV());
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
        if (this.fWM != null) {
            if (z && !this.fzR) {
                bjq();
            } else {
                hideLoadingView(this.fWM.getView());
            }
            if (z && this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhY() && this.fWM.getView() != null) {
                this.fWM.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void biY() {
        if (this.fWv == null) {
            this.fWv = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fWv.a(new String[]{getPageContext().getString(e.j.call_phone), getPageContext().getString(e.j.sms_phone), getPageContext().getString(e.j.search_in_baidu)}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fWk = PbActivity.this.fWk.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fWk);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fWJ.bkt(), PbActivity.this.fWk, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fWk = PbActivity.this.fWk.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fWk);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fWJ.bkt(), PbActivity.this.fWk, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fWk = PbActivity.this.fWk.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fWk);
                        bVar.dismiss();
                    }
                }
            }).df(b.a.axr).dg(17).d(getPageContext());
        }
    }

    private void F(Bundle bundle) {
        this.fWJ = new PbModel(this);
        this.fWJ.a(this.fXM);
        if (this.fWJ.bkV() != null) {
            this.fWJ.bkV().a(this.fXY);
        }
        if (this.fWJ.bkU() != null) {
            this.fWJ.bkU().a(this.fXx);
        }
        if (this.fWJ.bkW() != null) {
            this.fWJ.bkW().b(this.fXr);
        }
        if (bundle != null) {
            this.fWJ.initWithBundle(bundle);
        } else {
            this.fWJ.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fWJ.la(true);
        }
        aj.blF().U(this.fWJ.bks(), this.fWJ.getIsFromMark());
        if (StringUtils.isNull(this.fWJ.bkt())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fWD) && this.fWD != null) {
            this.fWJ.sL(6);
        }
        this.fWJ.OP();
    }

    private void initData(Bundle bundle) {
        this.fWL = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fWL != null) {
            this.fWL.a(this.fXO);
        }
        this.cZj = new ForumManageModel(this);
        this.cZj.setLoadDataCallBack(this.cZn);
        this.aCD = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fWM.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    PbActivity.this.showToast(e.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fWJ.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fWJ.getPbData().bhx().getId(), PbActivity.this.fWJ.getPbData().bhx().getName(), PbActivity.this.fWJ.getPbData().bhz().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fXD.setUniqueId(getUniqueId());
        this.fXD.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fWM.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(e.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fXg;
        userMuteCheckCustomMessage.setTag(this.fXg);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String biZ() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fWJ != null && (pbData = this.fWJ.getPbData()) != null) {
            return pbData.bhK().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bhz() != null) {
            if (dVar.bhz().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bhz().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bhz().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData bw(View view) {
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

    public com.baidu.tbadk.core.util.am bja() {
        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12003");
        amVar.aB("tid", this.fWJ.gbP);
        amVar.y("obj_type", 0);
        amVar.aB(ImageViewerConfig.FORUM_ID, this.fWJ.getForumId());
        amVar.y("obj_param1", this.fWJ.getPbData().bhz().getThreadType() == 40 ? 2 : 1);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aB("obj_param2", TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && bjb()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                @Override // java.lang.Runnable
                public void run() {
                    int h;
                    int aQ = (com.baidu.adp.lib.util.l.aQ(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        h = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0210e.ds120);
                    } else {
                        h = com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0210e.ds640);
                    }
                    int i = h - aQ;
                    if (i > 0) {
                        PbActivity.this.biU().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.biU().blT() != null) {
                        PbActivity.this.fWZ.Mp().setVisibility(8);
                        PbActivity.this.biU().blT().co(str, str2);
                        com.baidu.tbadk.editortools.pb.g bkl = PbActivity.this.biU().blT().bkl();
                        if (bkl != null && PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null) {
                            bkl.a(PbActivity.this.fWJ.getPbData().yR());
                        }
                        if (PbActivity.this.fWR.bni() == null && PbActivity.this.biU().blT().bkl().Np() != null) {
                            PbActivity.this.biU().blT().bkl().Np().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fWR != null && PbActivity.this.fWR.bnh() != null) {
                                        if (!PbActivity.this.fWR.bnh().bOw()) {
                                            PbActivity.this.fWR.lB(false);
                                        }
                                        PbActivity.this.fWR.bnh().ov(false);
                                    }
                                }
                            });
                            PbActivity.this.fWR.h(PbActivity.this.biU().blT().bkl().Np().getInputView());
                            PbActivity.this.biU().blT().bkl().a(PbActivity.this.fXd);
                        }
                    }
                    PbActivity.this.biU().bmO();
                }
            }, 500L);
        }
    }

    public boolean bjb() {
        if (this.fiK == null || this.fWJ.getPbData() == null || this.fWJ.getPbData().yR() == null) {
            return true;
        }
        return this.fiK.dK(this.fWJ.getPbData().yR().replyPrivateFlag);
    }

    public boolean su(int i) {
        if (this.fiK == null || this.fWJ.getPbData() == null || this.fWJ.getPbData().yR() == null) {
            return true;
        }
        return this.fiK.x(this.fWJ.getPbData().yR().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(e.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null && this.fWJ != null && this.fWJ.getPbData() != null && postData.bES() != 1) {
            String bkt = this.fWJ.bkt();
            String id = postData.getId();
            int bhL = this.fWJ.getPbData() != null ? this.fWJ.getPbData().bhL() : 0;
            c tm = tm(id);
            if (tm != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bkt, id, "pb", true, null, false, null, bhL, postData.bor(), this.fWJ.getPbData().yR(), false, postData.zT() != null ? postData.zT().getIconInfo() : null).addBigImageData(tm.fYD, tm.fYE, tm.fYF, tm.index);
                addBigImageData.setKeyPageStartFrom(this.fWJ.blc());
                addBigImageData.setFromFrsForumId(this.fWJ.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bjc() {
        if (this.fWJ.getPbData() == null || this.fWJ.getPbData().bhz() == null) {
            return -1;
        }
        return this.fWJ.getPbData().bhz().Ax();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjd() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.vq(this.fWJ.getForumId()) && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhx() != null) {
            if (this.fWJ.getPbData().bhx().isLike() == 1) {
                this.fWJ.bkY().cF(this.fWJ.getForumId(), this.fWJ.bkt());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kJ(boolean z) {
        if (this.fWJ == null || this.fWJ.getPbData() == null) {
            return false;
        }
        return ((this.fWJ.getPbData().bhL() != 0) || this.fWJ.getPbData().bhz() == null || this.fWJ.getPbData().bhz().zT() == null || TextUtils.equals(this.fWJ.getPbData().bhz().zT().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bje() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.p.u.PW()) {
            return "";
        }
        PostData bhG = bhG();
        if (this.fWJ == null || (pbData = this.fWJ.getPbData()) == null || pbData.getUserData() == null || pbData.bhz() == null || bhG == null || bhG.zT() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bhG.zT().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bhz().zB() == 0) {
            return "";
        }
        if (pbData.bhz().zB() == 0) {
            return getPageContext().getString(e.j.fans_call);
        }
        return getPageContext().getString(e.j.haved_fans_call);
    }

    private boolean kK(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fWJ == null || this.fWJ.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fWJ.getPbData();
        if (pbData.bhL() == 0) {
            List<com.baidu.tbadk.core.data.ay> bhV = pbData.bhV();
            if (com.baidu.tbadk.core.util.v.H(bhV) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : bhV) {
                    if (ayVar != null && (tVar = ayVar.atC) != null && tVar.arC && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean kL(boolean z) {
        return (z || this.fWJ == null || this.fWJ.getPbData() == null || this.fWJ.getPbData().bhL() == 0) ? false : true;
    }

    public void bjf() {
        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null && this.fWJ.getPbData().bhz().zT() != null) {
            if (this.fWM != null) {
                this.fWM.blR();
            }
            bb bhz = this.fWJ.getPbData().bhz();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhz.zT().getUserId());
            ab abVar = new ab();
            int bhL = this.fWJ.getPbData().bhL();
            if (bhL == 1) {
                abVar.gdS = true;
                abVar.gdR = true;
                abVar.gdZ = bhz.zO() == 1;
                abVar.gdY = bhz.zP() == 1;
            } else {
                abVar.gdS = false;
                abVar.gdR = false;
            }
            if (bhL == 1002 && !equals) {
                abVar.ged = true;
            }
            abVar.gdP = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.gdT = kK(equals);
            abVar.gdU = bjg();
            abVar.gdV = kL(equals);
            abVar.qZ = this.fWJ.bku();
            abVar.gdQ = true;
            abVar.fUH = this.fWL != null && this.fWL.wx();
            abVar.gdO = kJ(equals);
            abVar.geb = bje();
            abVar.gdN = equals && this.fWM.bmy();
            abVar.gdW = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.gdX = true;
            abVar.isHostOnly = this.fWJ.getHostMode();
            abVar.gea = true;
            if (bhz.Al() == null) {
                abVar.gec = true;
            } else {
                abVar.gec = false;
            }
            this.fWM.gfP.a(abVar);
        }
    }

    private boolean bjg() {
        if (this.fWJ != null && this.fWJ.bku()) {
            return this.fWJ.getPageData() == null || this.fWJ.getPageData().zd() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(View view) {
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

    public int bjh() {
        if (biU() == null || biU().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = biU().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fUu) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bji() {
        if (biU() == null || biU().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = biU().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.hpD) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bjp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.eJ(getResources().getString(e.j.mark_done));
            aVar.bn(true);
            aVar.eK(getResources().getString(e.j.mark_like));
            aVar.bm(true);
            aVar.bg(false);
            aVar.b(getResources().getString(e.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").aB(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).y("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(e.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").aB(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).y("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aCD.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fWJ.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).BS();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fWM.bmr();
        this.fWJ.kZ(z);
        if (this.fWL != null) {
            this.fWL.aQ(z);
            if (markData != null) {
                this.fWL.a(markData);
            }
        }
        if (this.fWJ.wx()) {
            bjn();
        } else {
            this.fWM.o(this.fWJ.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ss(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(String str) {
        this.fWK.tF(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fWJ.bkA()) {
                    antiData.setBlock_forum_name(this.fWJ.getPbData().bhx().getName());
                    antiData.setBlock_forum_id(this.fWJ.getPbData().bhx().getId());
                    antiData.setUser_name(this.fWJ.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fWJ.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else if (biU() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.al(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").y("obj_locate", as.a.aDo));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").y("obj_locate", as.a.aDo));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").y("obj_locate", as.a.aDo));
            }
        } else if (i == 230277) {
            ij(str);
        } else {
            this.fWM.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.hsc) ? bVar.hsc : getString(e.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.eK(string);
                aVar.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.bg(true);
                aVar.b(getPageContext());
                aVar.BS();
            } else {
                this.fWM.a(0, bVar.HZ, bVar.hsc, z);
            }
            if (bVar.HZ) {
                if (bVar.hsa == 1) {
                    ArrayList<PostData> bhB = this.fWJ.getPbData().bhB();
                    int size = bhB.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bhB.get(i).getId())) {
                            i++;
                        } else {
                            bhB.remove(i);
                            break;
                        }
                    }
                    this.fWM.o(this.fWJ.getPbData());
                } else if (bVar.hsa == 0) {
                    bjj();
                } else if (bVar.hsa == 2) {
                    ArrayList<PostData> bhB2 = this.fWJ.getPbData().bhB();
                    int size2 = bhB2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bhB2.get(i2).bEP().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bhB2.get(i2).bEP().get(i3).getId())) {
                                i3++;
                            } else {
                                bhB2.get(i2).bEP().remove(i3);
                                bhB2.get(i2).bER();
                                z2 = true;
                                break;
                            }
                        }
                        bhB2.get(i2).vW(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fWM.o(this.fWJ.getPbData());
                    }
                    a(bVar, this.fWM);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fWM.a(this.cZj.getLoadDataMode(), gVar.HZ, gVar.hsc, false);
            if (gVar.HZ) {
                this.fWO = true;
                if (i == 2 || i == 3) {
                    this.fWP = true;
                    this.fWQ = false;
                } else if (i == 4 || i == 5) {
                    this.fWP = false;
                    this.fWQ = true;
                }
                if (i == 2) {
                    this.fWJ.getPbData().bhz().cS(1);
                    this.fWJ.setIsGood(1);
                } else if (i == 3) {
                    this.fWJ.getPbData().bhz().cS(0);
                    this.fWJ.setIsGood(0);
                } else if (i == 4) {
                    this.fWJ.getPbData().bhz().cR(1);
                    this.fWJ.lc(1);
                } else if (i == 5) {
                    this.fWJ.getPbData().bhz().cR(0);
                    this.fWJ.lc(0);
                }
                this.fWM.c(this.fWJ.getPbData(), this.fWJ.bku());
            }
        }
    }

    private void bjj() {
        if (this.fWJ.bkv() || this.fWJ.bkx()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fWJ.bkt());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fWJ.bkt()));
        if (bjo()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjk() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bhI;
        boolean z = false;
        if (this.fWM != null) {
            this.fWM.bmF();
        }
        if (this.fWJ != null && this.fWJ.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.fWJ.getPbData().bhz().getId();
            if (this.fWJ.isShareThread() && this.fWJ.getPbData().bhz().avV != null) {
                historyMessage.threadName = this.fWJ.getPbData().bhz().avV.showText;
            } else {
                historyMessage.threadName = this.fWJ.getPbData().bhz().getTitle();
            }
            if (this.fWJ.isShareThread() && !bit()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fWJ.getPbData().bhx().getName();
            }
            ArrayList<PostData> bhB = this.fWJ.getPbData().bhB();
            int bmt = this.fWM != null ? this.fWM.bmt() : 0;
            if (bhB != null && bmt >= 0 && bmt < bhB.size()) {
                historyMessage.postID = bhB.get(bmt).getId();
            }
            historyMessage.isHostOnly = this.fWJ.getHostMode();
            historyMessage.isSquence = this.fWJ.bku();
            historyMessage.isShareThread = this.fWJ.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fWZ != null) {
            this.fWZ.onDestroy();
        }
        if (this.fWt && biU() != null) {
            biU().bmY();
        }
        if (this.fWJ != null && (this.fWJ.bkv() || this.fWJ.bkx())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fWJ.bkt());
            if (this.fWO) {
                if (this.fWQ) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fWJ.bkz());
                }
                if (this.fWP) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fWJ.getIsGood());
                }
            }
            if (this.fWJ.getPbData() != null && System.currentTimeMillis() - this.fWw >= 40000 && (bhI = this.fWJ.getPbData().bhI()) != null && !com.baidu.tbadk.core.util.v.I(bhI.getDataList())) {
                intent.putExtra("guess_like_data", bhI);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fXn);
            }
            setResult(-1, intent);
        }
        if (bjo()) {
            if (this.fWJ != null && this.fWM != null && this.fWM.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fWJ.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bhF() && !this.fWC) {
                        aj blF = aj.blF();
                        com.baidu.tieba.pb.data.d bkC = this.fWJ.bkC();
                        Parcelable onSaveInstanceState = this.fWM.getListView().onSaveInstanceState();
                        boolean bku = this.fWJ.bku();
                        boolean hostMode = this.fWJ.getHostMode();
                        if (this.fWM.bmc() != null && this.fWM.bmc().getVisibility() == 0) {
                            z = true;
                        }
                        blF.a(bkC, onSaveInstanceState, bku, hostMode, z);
                        if (this.fXm >= 0 || this.fWJ.ble() != null) {
                            aj.blF().l(this.fWJ.ble());
                            aj.blF().k(this.fWJ.blf());
                            aj.blF().sN(this.fWJ.blg());
                        }
                    }
                }
            } else {
                aj.blF().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fWM == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fWM.sR(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sv(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fWM.blR();
            this.fWM.blT().bkg();
            this.fWM.lv(false);
        }
        this.fWM.blU();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fWZ.resetData();
                        this.fWZ.b(writeData);
                        this.fWZ.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k fL = this.fWZ.Mp().fL(6);
                        if (fL != null && fL.aYV != null) {
                            fL.aYV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fWZ.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fWM.blT() != null && this.fWM.blT().bkl() != null) {
                            com.baidu.tbadk.editortools.pb.g bkl = this.fWM.blT().bkl();
                            bkl.b(writeData);
                            bkl.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k fL2 = bkl.Mp().fL(6);
                            if (fL2 != null && fL2.aYV != null) {
                                fL2.aYV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bkl.Nh();
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
        this.fWZ.onActivityResult(i, i2, intent);
        if (this.fWG != null) {
            this.fWG.onActivityResult(i, i2, intent);
        }
        if (biU().blT() != null) {
            biU().blT().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bjm();
                    return;
                case 13008:
                    aj.blF().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fWJ != null) {
                                PbActivity.this.fWJ.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bvB().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fWJ != null) {
                        a(bjl(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bvB().x(getPageContext());
                        bjd();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.ebd != null && shareItem != null && shareItem.linkUrl != null) {
                            this.ebd.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void Jo() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57.1
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
                    this.fWM.kH(false);
                    if (this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null && this.fWJ.getPbData().bhz().Ao() != null) {
                        this.fWJ.getPbData().bhz().Ao().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fXb = emotionImageData;
                        if (su(com.baidu.tbadk.core.util.aj.aCA)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fWM != null && this.fWM.gfP != null) {
                        this.fWM.gfP.dismissPopMenu();
                        this.fWM.gfP.bnA();
                        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null) {
                            this.fWJ.getPbData().bhz().cN(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fWH != null) {
                        this.fWM.bG(this.fWH);
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
            if (this.fWG == null) {
                this.fWG = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fWG.b(this.baM);
                this.fWG.c(this.baT);
            }
            this.fWG.a(emotionImageData, biD(), biD().getPbData());
        }
    }

    private ShareFromPBMsgData bjl() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] cP = this.fWJ.getPbData().cP(getPageContext().getPageActivity());
        PostData blW = this.fWM.blW();
        String str = "";
        if (blW != null) {
            str = blW.getId();
            String da = blW.da(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(da)) {
                cP[1] = da;
            }
        }
        String Ak = this.fWJ.getPbData().bhz().Ak();
        if (Ak != null && Ak.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(cP[1]);
        shareFromPBMsgData.setImageUrl(cP[0]);
        shareFromPBMsgData.setForumName(this.fWJ.getPbData().bhx().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fWJ.getPbData().bhz().getId());
        shareFromPBMsgData.setTitle(this.fWJ.getPbData().bhz().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bjl(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null) {
                        com.baidu.tbadk.core.util.am aB = new com.baidu.tbadk.core.util.am("share_success").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).y("obj_param1", 3).aB(ImageViewerConfig.FORUM_ID, PbActivity.this.fWJ.getForumId()).aB("tid", PbActivity.this.fWJ.bkt());
                        if (PbActivity.this.e(PbActivity.this.fWJ.getPbData()) != 0) {
                            aB.y("obj_type", PbActivity.this.e(PbActivity.this.fWJ.getPbData()));
                        }
                        TiebaStatic.log(aB);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bh(true);
            aVar.b(getPageContext()).BS();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.M(shareFromPBMsgData.getImageUrl(), this.fWJ.getPbData().bhM() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bh(true);
            aVar.b(getPageContext()).BS();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.M(shareFromPBMsgData.getImageUrl(), this.fWJ.getPbData().bhM() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjm() {
        MarkData sK;
        if (this.fWL != null && (sK = this.fWJ.sK(this.fWM.bmu())) != null) {
            if (!sK.isApp() || (sK = this.fWJ.sK(this.fWM.bmu() + 1)) != null) {
                this.fWM.bmp();
                this.fWL.a(sK);
                if (!this.fWL.wx()) {
                    this.fWL.wz();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fWL.wy();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjn() {
        com.baidu.tieba.pb.data.d pbData = this.fWJ.getPbData();
        this.fWJ.kZ(true);
        if (this.fWL != null) {
            pbData.te(this.fWL.ww());
        }
        this.fWM.o(pbData);
    }

    private boolean bjo() {
        if (this.fWJ == null) {
            return true;
        }
        if (this.fWJ.wx()) {
            final MarkData bkM = this.fWJ.bkM();
            if (bkM == null || !this.fWJ.getIsFromMark()) {
                return true;
            }
            final MarkData sK = this.fWJ.sK(this.fWM.bmt());
            if (sK == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bkM);
                setResult(-1, intent);
                return true;
            } else if (sK.getPostId() == null || sK.getPostId().equals(bkM.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bkM);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.eK(getPageContext().getString(e.j.alert_update_mark));
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fWL != null) {
                            if (PbActivity.this.fWL.wx()) {
                                PbActivity.this.fWL.wy();
                                PbActivity.this.fWL.aQ(false);
                            }
                            PbActivity.this.fWL.a(sK);
                            PbActivity.this.fWL.aQ(true);
                            PbActivity.this.fWL.wz();
                        }
                        bkM.setPostId(sK.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bkM);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bjk();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bkM);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bjk();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fWM != null && PbActivity.this.fWM.getView() != null) {
                            PbActivity.this.fWM.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bkM);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bjk();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.BS();
                return false;
            }
        } else if (this.fWJ.getPbData() == null || this.fWJ.getPbData().bhB() == null || this.fWJ.getPbData().bhB().size() <= 0 || !this.fWJ.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fWM == null) {
            return null;
        }
        return this.fWM.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Te() {
        if (this.fWM == null) {
            return 0;
        }
        return this.fWM.bmD();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Tf() {
        if (this.bsu == null) {
            this.bsu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: amT */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean xV = com.baidu.tbadk.core.i.xR().xV();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(e.d.common_color_10220));
                    if (xV) {
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
                        if (com.baidu.tbadk.core.i.xR().xV()) {
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
        return this.bsu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Tg() {
        if (this.bsv == null) {
            this.bsv = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.bsv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Th() {
        if (this.bsz == null) {
            this.bsz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjJ */
                public GifView jz() {
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
                    gifView.NJ();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bsz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Ti() {
        if (this.bsw == null) {
            this.bsw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjK */
                public View jz() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0210e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bA */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bB */
                public View v(View view) {
                    ((PlayVoiceBntNew) view).bGc();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bC */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bsw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Tk() {
        this.bsy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bjL */
            public RelativeLayout jz() {
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
        return this.bsy;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> FJ() {
        if (this.aLr == null) {
            this.aLr = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aLr;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fWA = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (aw.tx(str) && this.fWJ != null && this.fWJ.bkt() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").y("obj_param1", 1).aB("post_id", this.fWJ.bkt()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.aXZ = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            aw.bnk().c(getPageContext(), str);
        }
        this.fWA = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        aw.bnk().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fWA = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Rect rect) {
        if (rect != null && this.fWM != null && this.fWM.bmT() != null && rect.top <= this.fWM.bmT().getHeight()) {
            rect.top += this.fWM.bmT().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fWJ.getPbData();
            TbRichText aM = aM(str, i);
            if (aM != null && (tbRichTextData = aM.Sx().get(this.fXR)) != null) {
                cVar.fYD = new ArrayList<>();
                cVar.fYE = new ConcurrentHashMap<>();
                if (!tbRichTextData.SD().SP()) {
                    cVar.fYG = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fYD.add(b2);
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
                    imageUrlData.postId = aM.getPostId();
                    imageUrlData.mIsReserver = this.fWJ.bkK();
                    imageUrlData.mIsSeeHost = this.fWJ.getHostMode();
                    cVar.fYE.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.bhx() != null) {
                            cVar.forumName = pbData.bhx().getName();
                            cVar.forumId = pbData.bhx().getId();
                        }
                        if (pbData.bhz() != null) {
                            cVar.threadId = pbData.bhz().getId();
                        }
                        cVar.fYF = pbData.bhM() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.fYG = true;
                int size = pbData.bhB().size();
                this.fXS = false;
                cVar.index = -1;
                if (pbData.bhG() != null) {
                    PostData bhG = pbData.bhG();
                    TbRichText bEU = bhG.bEU();
                    if (!aq.m(bhG)) {
                        i2 = a(bEU, aM, i, i, cVar.fYD, cVar.fYE);
                    } else {
                        i2 = a(bhG, i, cVar.fYD, cVar.fYE);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bhB().get(i4);
                    if (postData.getId() == null || pbData.bhG() == null || pbData.bhG().getId() == null || !postData.getId().equals(pbData.bhG().getId())) {
                        TbRichText bEU2 = postData.bEU();
                        if (!aq.m(postData)) {
                            i3 = a(bEU2, aM, i3, i, cVar.fYD, cVar.fYE);
                        } else {
                            i3 = a(postData, i3, cVar.fYD, cVar.fYE);
                        }
                    }
                }
                if (cVar.fYD.size() > 0) {
                    cVar.lastId = cVar.fYD.get(cVar.fYD.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.bhx() != null) {
                        cVar.forumName = pbData.bhx().getName();
                        cVar.forumId = pbData.bhx().getId();
                    }
                    if (pbData.bhz() != null) {
                        cVar.threadId = pbData.bhz().getId();
                    }
                    cVar.fYF = pbData.bhM() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.SD() == null) {
            return null;
        }
        return tbRichTextData.SD().SV();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.SD() == null) {
            return 0L;
        }
        return tbRichTextData.SD().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.SD() == null) {
            return false;
        }
        return tbRichTextData.SD().SW();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.SD() == null) {
            return false;
        }
        return tbRichTextData.SD().SX();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo SD;
        String str;
        if (tbRichText == tbRichText2) {
            this.fXS = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Sx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Sx().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.SD().getWidth() * aR;
                    int height = aR * tbRichTextData.SD().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.SD().SP()) {
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
                            if (tbRichTextData != null && (SD = tbRichTextData.SD()) != null) {
                                String SS = SD.SS();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = SD.ST();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = SS;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fWJ.bkt(), -1L);
                                imageUrlData.mIsReserver = this.fWJ.bkK();
                                imageUrlData.mIsSeeHost = this.fWJ.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fXS) {
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
        com.baidu.tieba.tbadkCore.data.h bFb;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bEx;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bEx = (bFb = postData.bFb()).bEx()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bEx.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bEx.get(i3);
                if (jVar != null) {
                    String bEB = jVar.bEB();
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(bEB)) {
                        arrayList.add(bEB);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bEB;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bEA();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fWJ.bkt(), -1L);
                        imageUrlData.mIsReserver = this.fWJ.bkK();
                        imageUrlData.mIsSeeHost = this.fWJ.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bFb.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bEB, imageUrlData);
                        }
                        if (!this.fXS) {
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
            if (postData.getId() != null && postData.getId().equals(this.fWJ.Ad())) {
                z = true;
            }
            MarkData j = this.fWJ.j(postData);
            if (j != null) {
                this.fWM.bmp();
                if (this.fWL != null) {
                    this.fWL.a(j);
                    if (!z) {
                        this.fWL.wz();
                    } else {
                        this.fWL.wy();
                    }
                }
            }
        }
    }

    public boolean by(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aM(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fWJ == null || this.fWJ.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fWJ.getPbData();
        if (pbData.bhG() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bhG());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bhB = pbData.bhB();
            a(pbData, bhB);
            return a(bhB, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bhK() != null && dVar.bhK().fUJ != null && (list = dVar.bhK().fUJ) != null && arrayList != null) {
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

    private long tk(String str) {
        ArrayList<PostData> bhB;
        com.baidu.tieba.pb.data.d pbData = this.fWJ.getPbData();
        if (pbData != null && (bhB = pbData.bhB()) != null && !bhB.isEmpty()) {
            Iterator<PostData> it = bhB.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bFb = next.bFb();
                if (bFb != null && bFb.hpk) {
                    Iterator<TbRichTextData> it2 = next.bEU().Sx().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.SM().getLink().equals(str)) {
                            return bFb.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Sx;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bEU = arrayList.get(i2).bEU();
            if (bEU != null && (Sx = bEU.Sx()) != null) {
                int size = Sx.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Sx.get(i4) != null && Sx.get(i4).getType() == 8) {
                        i3++;
                        if (Sx.get(i4).SD().SS().equals(str) || Sx.get(i4).SD().ST().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = Sx.get(i4).SD().getWidth() * aR;
                            int height = Sx.get(i4).SD().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fXR = i4;
                            return bEU;
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
    public void k(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.fWk = str;
            if (this.fWv == null) {
                biY();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fWv.dj(1).setVisibility(8);
            } else {
                this.fWv.dj(1).setVisibility(0);
            }
            this.fWv.BV();
            this.fWA = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dLz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjp() {
        hideNetRefreshView(this.fWM.getView());
        bjq();
        if (this.fWJ.OP()) {
            this.fWM.bmp();
        }
    }

    private void bjq() {
        showLoadingView(this.fWM.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds400));
        View Ob = getLoadingView().Ob();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Ob.getLayoutParams();
        layoutParams.addRule(3, this.fWM.bmT().getId());
        Ob.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCj() {
        if (this.dLz != null) {
            this.dLz.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw(int i) {
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
    public void sx(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fWJ.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fWJ.getPbData();
            pbData.bhx().getName();
            String title = pbData.bhz().getTitle();
            int i2 = this.fWJ.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.bhx() != null) {
                if ((pbData.bhx().isLike() == 1) && AddExperiencedModel.vq(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fWJ.bkt() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] cP = pbData.cP(getPageContext().getPageActivity());
                    str = cP[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = cP[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bjc() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").aB(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aB("tid", pbData.getThreadId()).aB("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aSE = true;
                    dVar.aSJ = z;
                    dVar.extData = this.fWJ.bkt();
                    dVar.aST = 3;
                    dVar.aSS = i;
                    dVar.fid = this.fWJ.getForumId();
                    dVar.tid = this.fWJ.bkt();
                    dVar.aSU = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fWJ.getPbData().bhz());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aST);
                    bundle.putInt("obj_type", dVar.aSU);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.k(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhY()) {
                                PbActivity.this.fWM.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.asB().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fWJ.bkt() + "?share=9105&fr=share&see_lz=" + i2;
            String[] cP2 = pbData.cP(getPageContext().getPageActivity());
            str = cP2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = cP2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bjc() == 1) {
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aSE = true;
            dVar2.aSJ = z;
            dVar2.extData = this.fWJ.bkt();
            dVar2.aST = 3;
            dVar2.aSS = i;
            dVar2.fid = this.fWJ.getForumId();
            dVar2.tid = this.fWJ.bkt();
            dVar2.aSU = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fWJ.getPbData().bhz());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aST);
            bundle2.putInt("obj_type", dVar2.aSU);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.k(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fWJ != null && PbActivity.this.fWJ.getPbData() != null && PbActivity.this.fWJ.getPbData().bhY()) {
                        PbActivity.this.fWM.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.asB().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bhz() != null) {
            if (dVar.bhz().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bhz().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjr() {
        com.baidu.tbadk.util.y.a(new com.baidu.tbadk.util.x<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.x
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.vr(PbActivity.this.fWJ.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fWM.bmZ();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Tj() {
        if (this.bsx == null) {
            this.bsx = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bjM */
                public LinearLayout jz() {
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
        return this.bsx;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fWM.bmk() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").y("obj_locate", 2).aB(ImageViewerConfig.FORUM_ID, this.fWJ.getPbData().getForumId()));
            } else {
                bb bhz = this.fWJ.getPbData().bhz();
                if (view != null) {
                    boolean z = bhz.zG() == null || bhz.zG().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fXE > 1000) {
                            this.fXF = true;
                            bz(view);
                        } else {
                            this.fXF = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.fXF);
                        } else {
                            j(view, this.fXF);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.fXF);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.fXF);
                    }
                }
            }
        }
        return false;
    }

    private void j(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fXE = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fXE = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bz(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void aCk() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData aBj() {
        if (this.fWJ == null || this.fWJ.getPbData() == null) {
            return null;
        }
        return this.fWJ.getPbData().yR();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.BU() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.BU();
            int intValue = ((Integer) sparseArray.get(ar.ghC)).intValue();
            if (intValue == ar.ghD) {
                if (!this.cZj.bFD()) {
                    this.fWM.bmm();
                    String str = (String) sparseArray.get(e.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.cZj.wc(com.baidu.tbadk.core.util.ao.i(jSONArray));
                    }
                    this.cZj.a(this.fWJ.getPbData().bhx().getId(), this.fWJ.getPbData().bhx().getName(), this.fWJ.getPbData().bhz().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == ar.ghE || intValue == ar.ghG) {
                if (this.fWJ.bkV() != null) {
                    this.fWJ.bkV().sA(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.ghE) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fXg);
        userMuteAddAndDelCustomMessage.setTag(this.fXg);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean tl(String str) {
        if (!StringUtils.isNull(str) && ba.bJ(getPageContext().getPageActivity())) {
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

    public void kM(boolean z) {
        this.fWU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bjs() {
        ArrayList<PostData> bhB;
        int H;
        if (this.fWJ == null || this.fWJ.getPbData() == null || this.fWJ.getPbData().bhB() == null || (H = com.baidu.tbadk.core.util.v.H((bhB = this.fWJ.getPbData().bhB()))) == 0) {
            return "";
        }
        if (this.fWJ.bkK()) {
            Iterator<PostData> it = bhB.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bES() == 1) {
                    return next.getId();
                }
            }
        }
        int bmt = this.fWM.bmt();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bhB, bmt);
        if (postData == null || postData.zT() == null) {
            return "";
        }
        if (this.fWJ.to(postData.zT().getUserId())) {
            return postData.getId();
        }
        for (int i = bmt - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(bhB, i);
            if (postData2 == null || postData2.zT() == null || postData2.zT().getUserId() == null) {
                break;
            } else if (this.fWJ.to(postData2.zT().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bmt + 1; i2 < H; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(bhB, i2);
            if (postData3 == null || postData3.zT() == null || postData3.zT().getUserId() == null) {
                return "";
            }
            if (this.fWJ.to(postData3.zT().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ay.Es().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(tk(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fWJ.getPbData().bhx().getId(), this.fWJ.getPbData().bhx().getName(), this.fWJ.getPbData().bhz().getTid());
            }
            this.fWA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.eK(getResources().getString(e.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.eK(getResources().getString(e.j.make_sure_hide));
        }
        aVar.a(getResources().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fWJ.bkU() != null) {
                    PbActivity.this.fWJ.bkU().cY(j);
                }
            }
        });
        aVar.b(getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.bh(false);
        aVar.b(getPageContext());
        aVar.BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c tm(String str) {
        String str2;
        if (this.fWJ.getPbData() == null || this.fWJ.getPbData().bhB() == null || this.fWJ.getPbData().bhB().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fWJ.getPbData().bhB().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fWJ.getPbData().bhB().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fWJ.getPbData().bhB().get(i);
        if (postData.bEU() == null || postData.bEU().Sx() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bEU().Sx().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.SD() != null) {
                    str2 = next.SD().SS();
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
        if (this.fWr) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fWr = false;
        } else if (bjt()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fWr) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fWr = false;
        } else if (bjt()) {
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
        if (pageStayDurationItem != null && this.fWJ != null) {
            if (this.fWJ.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.fWJ.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.fWJ.bkt(), 0L));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bjt() {
        return (!this.fWp && this.fXZ == -1 && this.fYa == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fYc = mVar;
            this.fWp = true;
            this.fWM.bmd();
            this.fWM.tv(this.fYb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bju() {
        if (this.fYc != null) {
            if (this.fXZ == -1) {
                showToast(e.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fYc.getCartoonId(), this.fXZ, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjv() {
        if (this.fYc != null) {
            if (this.fYa == -1) {
                showToast(e.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fYc.getCartoonId(), this.fYa, 0)));
                finish();
            }
        }
    }

    public int bjw() {
        return this.fXZ;
    }

    public int bjx() {
        return this.fYa;
    }

    private void aNs() {
        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null && this.fWJ.getPbData().bhz().AH()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bjy() {
        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null && this.fWJ.getPbData().bhz().AH()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bjz() {
        if (this.fWs) {
            this.fWF = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null && this.fWJ.getPbData().bhz().zA() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fWJ.getPbData().bhz().zA().getThreadId(), this.fWJ.getPbData().bhz().zA().getTaskId(), this.fWJ.getPbData().bhz().zA().getForumId(), this.fWJ.getPbData().bhz().zA().getForumName(), this.fWJ.getPbData().bhz().zO(), this.fWJ.getPbData().bhz().zP())));
            this.fWr = true;
            finish();
        }
    }

    public String bjA() {
        return this.fWD;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bjB() {
        return this.fWI;
    }

    public void kN(boolean z) {
        this.fWE = z;
    }

    public boolean bjC() {
        if (this.fWJ != null) {
            return this.fWJ.bkv();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.eK(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fXe).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fXe.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fXe).BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fXe != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fXe.getPageActivity());
            aVar.eK(str);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fXe).BS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fWM.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fXe.getPageActivity());
        if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            aVar.eK(this.fXe.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.eK(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fWM.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fXe).BS();
    }

    public void bjE() {
        if (this.fWJ != null && this.fWJ.getPbData() != null && this.fWJ.getPbData().bhz() != null && this.fWJ.getPbData().bhz().AW() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.db(e.j.channel_open_push_message);
            aVar.a(e.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fWJ.getPbData().bhz().AW().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.BS();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (aw.tx(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_wenxue)) != null) {
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
        if (this.fWM != null) {
            this.fWM.onConfigurationChanged(configuration);
        }
        if (this.fWS != null) {
            this.fWS.dismiss();
        }
    }

    public boolean bjF() {
        if (this.fWJ != null) {
            return this.fWJ.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.fWJ.getPbData().bhK().fUJ;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bEP().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bEP().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bEP().remove(i2);
                    list.get(i).bER();
                    z = true;
                    break;
                }
            }
            list.get(i).vW(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.o(this.fWJ.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.big().getId();
        List<PostData> list = this.fWJ.getPbData().bhK().fUJ;
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
                ArrayList<PostData> bik = jVar.bik();
                postData.vK(jVar.getTotalCount());
                if (postData.bEP() != null) {
                    postData.bEP().clear();
                    postData.bEP().addAll(bik);
                }
            }
        }
        if (!this.fWJ.getIsFromMark()) {
            this.fWM.o(this.fWJ.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bis() {
        return this.fWN;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bit() {
        if (this.fWJ == null) {
            return false;
        }
        return this.fWJ.bit();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String biu() {
        if (this.fWJ != null) {
            return this.fWJ.biu();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int biv() {
        if (this.fWJ == null || this.fWJ.getPbData() == null) {
            return 0;
        }
        return this.fWJ.getPbData().bhL();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean tg(String str) {
        return this.fWJ != null && this.fWJ.to(str);
    }

    public void bjG() {
        if (this.fWM != null) {
            this.fWM.blR();
            aCk();
        }
    }

    public PostData bhG() {
        return this.fWM.b(this.fWJ.gcj, this.fWJ.bku());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.isLinkThread()) {
                return 3;
            }
            if (bbVar.AY()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fXo != null && !this.fXo.isEmpty()) {
            int size = this.fXo.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fXo.get(i).onBackPressed()) {
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
            if (this.fXo == null) {
                this.fXo = new ArrayList();
            }
            if (!this.fXo.contains(aVar)) {
                this.fXo.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fXo == null) {
                this.fXo = new ArrayList();
            }
            if (!this.fXo.contains(aVar)) {
                this.fXo.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fXo != null) {
            this.fXo.remove(aVar);
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dMl == null) {
            this.dMl = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dMl.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bo(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dMl.a(contriInfo, -1L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        com.baidu.tbadk.core.util.ad.a(kVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjH() {
        if (this.fWJ != null && !com.baidu.tbadk.core.util.ao.isEmpty(this.fWJ.bkt())) {
            com.baidu.tbadk.BdToken.c.vy().f(com.baidu.tbadk.BdToken.b.ajX, com.baidu.adp.lib.g.b.d(this.fWJ.bkt(), 0L));
        }
    }
}
