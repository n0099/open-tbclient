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
    private com.baidu.adp.lib.e.b<TbImageView> aHn;
    private com.baidu.adp.lib.e.b<ImageView> bog;
    private com.baidu.adp.lib.e.b<TextView> boh;
    private com.baidu.adp.lib.e.b<View> boi;
    private com.baidu.adp.lib.e.b<LinearLayout> boj;
    private com.baidu.adp.lib.e.b<RelativeLayout> bok;
    private com.baidu.adp.lib.e.b<GifView> bol;
    private com.baidu.tbadk.core.util.b.a bvI;
    private com.baidu.tieba.f.b crR;
    private VoiceManager dBD;
    private com.baidu.tbadk.core.dialog.h dCp;
    public com.baidu.tbadk.core.util.aj eYo;
    private String fLF;
    private com.baidu.tieba.pb.pb.main.b.b fLL;
    private com.baidu.tbadk.core.view.g fMA;
    private BdUniqueId fMB;
    private Runnable fMC;
    private av fMD;
    private com.baidu.adp.widget.ImageView.a fME;
    private String fMF;
    private TbRichTextMemeInfo fMG;
    private List<a> fMJ;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fMb;
    private View fMc;
    private com.baidu.tieba.pb.pb.report.a fMf;
    public at fMm;
    private y fMn;
    private boolean fMp;
    private com.baidu.tieba.tbadkCore.data.e fMs;
    private com.baidu.tbadk.editortools.pb.f fMt;
    private com.baidu.tbadk.editortools.pb.d fMu;
    private EmotionImageData fMw;
    private com.baidu.adp.base.e fMz;
    private boolean fNl;
    private String fNw;
    private com.baidu.tbadk.core.data.m fNx;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.azn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.azn));
        }
    };
    private static final b.a fNr = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // com.baidu.tieba.f.b.a
        public void fV(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bfl();
            } else {
                com.baidu.tieba.pb.a.b.bfk();
            }
        }
    };
    private boolean fLK = false;
    private boolean fLM = false;
    private boolean fLN = false;
    private boolean fpn = false;
    private boolean fLO = true;
    private int fLP = 0;
    private com.baidu.tbadk.core.dialog.b fLQ = null;
    private long dhW = -1;
    private long bcv = 0;
    private long fLR = 0;
    private long createTime = 0;
    private long bcn = 0;
    private boolean fLS = false;
    private com.baidu.tbadk.l.b fLT = null;
    private long fLU = 0;
    private boolean fLV = false;
    private long fLW = 0;
    private String aWy = null;
    private boolean fLX = false;
    private boolean isFullScreen = false;
    private String fLY = "";
    private boolean fLZ = true;
    private boolean fMa = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fMd = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.fMh.li(!PbActivity.this.fLZ);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fMe != null && PbActivity.this.fMe.vm()) {
                        PbActivity.this.bgh();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fMe = null;
    private com.baidu.tbadk.baseEditMark.a fMg = null;
    private ForumManageModel cPb = null;
    private com.baidu.tbadk.coreExtra.model.a ayB = null;
    private ShareSuccessReplyToServerModel dRe = null;
    private ar fMh = null;
    public final com.baidu.tieba.pb.pb.main.b.a fMi = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean fMj = false;
    private boolean fMk = false;
    private boolean fMl = false;
    private boolean fMo = false;
    private boolean fMq = false;
    private boolean fMr = false;
    private boolean fMv = false;
    public boolean fMx = false;
    private com.baidu.tbadk.editortools.pb.c aWB = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lr() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aWC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lq() {
            if (PbActivity.this.fMm == null || PbActivity.this.fMm.bjU() == null || !PbActivity.this.fMm.bjU().bKR()) {
                return !PbActivity.this.rJ(com.baidu.tbadk.core.util.aj.ayw);
            }
            PbActivity.this.showToast(PbActivity.this.fMm.bjU().bKT());
            if (PbActivity.this.fMu != null && (PbActivity.this.fMu.LF() || PbActivity.this.fMu.LG())) {
                PbActivity.this.fMu.a(false, PbActivity.this.fMm.bjX());
            }
            PbActivity.this.fMm.lu(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fMy = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lq() {
            if (PbActivity.this.fMm == null || PbActivity.this.fMm.bjV() == null || !PbActivity.this.fMm.bjV().bKR()) {
                return !PbActivity.this.rJ(com.baidu.tbadk.core.util.aj.ayx);
            }
            PbActivity.this.showToast(PbActivity.this.fMm.bjV().bKT());
            if (PbActivity.this.fMh != null && PbActivity.this.fMh.biI() != null && PbActivity.this.fMh.biI().bhe() != null && PbActivity.this.fMh.biI().bhe().LG()) {
                PbActivity.this.fMh.biI().bhe().a(PbActivity.this.fMm.bjX());
            }
            PbActivity.this.fMm.lv(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dCl = false;
    private int fMH = 0;
    private int fMI = -1;
    private final a fMK = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fMh != null && PbActivity.this.fMh.biI() != null) {
                s biI = PbActivity.this.fMh.biI();
                if (biI.bhb()) {
                    biI.bha();
                    return true;
                }
            }
            if (PbActivity.this.fMh != null && PbActivity.this.fMh.bjA()) {
                PbActivity.this.fMh.bjB();
                return true;
            }
            return false;
        }
    };
    private r.a fML = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
    };
    private AddExperiencedModel.a dCu = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bgl();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fMM = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void P(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void i(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fMh.showToast(str);
            }
        }
    };
    private final CustomMessageListener fMN = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fMe != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fMu != null) {
                    PbActivity.this.fMh.ln(PbActivity.this.fMu.Lz());
                }
                PbActivity.this.fMh.biJ();
                PbActivity.this.fMh.bjt();
            }
        }
    };
    CustomMessageListener dCM = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.fMe.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.fMh != null && PbActivity.this.fMe != null) {
                    PbActivity.this.fMh.d(PbActivity.this.fMe.getPbData(), PbActivity.this.fMe.bhn(), PbActivity.this.fMe.getRequestType());
                }
                if (PbActivity.this.fMh != null && PbActivity.this.fMh.bja() != null) {
                    PbActivity.this.fMh.bja().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fMO = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fMh != null) {
                    if (booleanValue) {
                        PbActivity.this.fMh.aQE();
                    } else {
                        PbActivity.this.fMh.aQD();
                    }
                }
            }
        }
    };
    private CustomMessageListener fMP = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fMu != null) {
                    PbActivity.this.fMh.ln(PbActivity.this.fMu.Lz());
                }
                PbActivity.this.fMh.lp(false);
            }
        }
    };
    private CustomMessageListener fMQ = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener fMR = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fMh != null && PbActivity.this.fMh.bja() != null) {
                PbActivity.this.fMh.bja().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener eCl = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fMS = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.rL(2);
                aj.biu().reset();
                PbActivity.this.fMe.bhF();
                boolean z2 = false;
                ArrayList<PostData> bev = PbActivity.this.fMe.getPbData().bev();
                if (bev != null) {
                    Iterator<PostData> it = bev.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bBG().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fMh.n(PbActivity.this.fMe.getPbData());
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
    private View.OnClickListener aXi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aWy);
        }
    };
    private CustomMessageListener fMT = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fMe.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fMe.bhw() != null && PbActivity.this.fMe.bhw().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fMh.a(yVar.sendCount, PbActivity.this.fMe.getPbData(), PbActivity.this.fMe.bhn(), PbActivity.this.fMe.getRequestType());
                    }
                    if (pbData.bev() != null && pbData.bev().size() >= 1 && pbData.bev().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bev().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.fMe.bhm(), 0L);
                        if (d2 == yVar.postId && d3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bBF = pbData.bev().get(0).bBF();
                            if (bBF == null) {
                                bBF = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> xN = bBF.xN();
                            if (xN == null) {
                                xN = new ArrayList<>();
                            }
                            xN.add(0, aVar);
                            bBF.setTotal(yVar.sendCount + bBF.getTotal());
                            bBF.k(xN);
                            pbData.bev().get(0).a(bBF);
                            PbActivity.this.fMh.bja().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener dUb = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null) {
                PbActivity.this.sl((String) customResponsedMessage.getData());
                PbActivity.this.fMe.bhC();
                if (PbActivity.this.fMh.bja() != null) {
                    PbActivity.this.fMh.n(PbActivity.this.fMe.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a fMU = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.auk() != null && !aVar.auk().isEmpty()) {
                    PbActivity.this.fMh.a(aVar, PbActivity.this.fMW);
                }
                PbActivity.this.fMh.a(aVar, PbActivity.this.fMe.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bke()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fMV = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void P(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.I(list) && PbActivity.this.fMh != null) {
                PbActivity.this.fMh.dj(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fMW = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bG(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.jA().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17.1
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
    private boolean fMX = false;
    private PraiseModel fMY = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void jK(String str) {
            PbActivity.this.fMX = false;
            if (PbActivity.this.fMY != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fMe.getPbData();
                if (pbData.bet().yp().getIsLike() == 1) {
                    PbActivity.this.mF(0);
                } else {
                    PbActivity.this.mF(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bet()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void M(int i, String str) {
            PbActivity.this.fMX = false;
            if (PbActivity.this.fMY != null && str != null) {
                if (AntiHelper.ai(i, str)) {
                    AntiHelper.aG(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fMZ = 0;
    private boolean fNa = true;
    private b.a fNb = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void kI(boolean z) {
            PbActivity.this.kH(z);
            if (PbActivity.this.fMh.bjG() != null && z) {
                PbActivity.this.fMh.li(false);
            }
            PbActivity.this.fMh.lk(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aLS != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aLS, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.azn));
                        }
                    } else if (updateAttentionMessage.getData().Jr) {
                        if (PbActivity.this.beA().yC() != null && PbActivity.this.beA().yC().getGodUserData() != null) {
                            PbActivity.this.beA().yC().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().bet() != null && PbActivity.this.fMe.getPbData().bet().yC() != null) {
                            PbActivity.this.fMe.getPbData().bet().yC().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cri = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fMh.ajH();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.rM(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aHP();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(e.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c boq = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            PbActivity.this.bfR();
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
                    if (PbActivity.this.bs(view)) {
                        return true;
                    }
                } else if (view.getId() == e.g.pb_floor_item_layout) {
                    if (view.getTag(e.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(e.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != e.g.pb_post_header_layout) {
                    if (PbActivity.this.fMh != null && PbActivity.this.fMh.bfP() && view.getId() == e.g.pb_head_user_info_root) {
                        if (view.getTag(e.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").ax(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(e.g.tag_user_id)));
                        }
                        if (PbActivity.this.fMi != null && PbActivity.this.fMi.ebD != null) {
                            PbActivity.this.fMi.ebD.onClick(view);
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
            if (PbActivity.this.fMu != null) {
                PbActivity.this.fMh.ln(PbActivity.this.fMu.Lz());
            }
            PbActivity.this.fMh.biJ();
            PbActivity.this.fMh.bjt();
            return true;
        }
    });
    private CustomMessageListener fNc = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fMB) {
                PbActivity.this.fMh.ajH();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fMe.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.beH().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fMA.e(PbActivity.this.fMz.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fMz.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.hC(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bgx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ao.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fMz.getResources().getString(e.j.mute_fail);
                    }
                    PbActivity.this.fMA.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fNd = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fMB) {
                PbActivity.this.fMh.ajH();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fMA.e(PbActivity.this.fMz.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ao.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fMz.getResources().getString(e.j.un_mute_fail);
                }
                PbActivity.this.fMA.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fNe = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fMB) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fMh.ajH();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hsk;
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
                    PbActivity.this.fMh.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fNf = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fMh.biK() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bfR();
            }
        }
    };
    private CustomMessageListener dCT = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dCl = true;
                }
            }
        }
    };
    public a.b fAh = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.azo();
            com.baidu.tbadk.core.data.al pageData = PbActivity.this.fMe.getPageData();
            int pageNum = PbActivity.this.fMh.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(e.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.xG()) {
                PbActivity.this.fMh.bjt();
                PbActivity.this.rL(2);
                PbActivity.this.azn();
                PbActivity.this.fMh.bje();
                if (com.baidu.adp.lib.util.j.kV()) {
                    PbActivity.this.fMe.rT(PbActivity.this.fMh.getPageNum());
                    if (PbActivity.this.fLL != null) {
                        PbActivity.this.fLL.showFloatingView();
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
    public final View.OnClickListener dDv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
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
            boolean p;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fMh.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fMe.kR(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fMh.bjf();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().bin()) {
                        if (view == PbActivity.this.fMh.fVd.bes) {
                            if (PbActivity.this.fMh.lm(PbActivity.this.fMe.bht())) {
                                PbActivity.this.azn();
                                return;
                            }
                            PbActivity.this.fLO = false;
                            PbActivity.this.fLM = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.fMh.fVd.bes);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fMh.bjc() && (PbActivity.this.fMh.fVd.bkq() == null || (view != PbActivity.this.fMh.fVd.bkq().bim() && view != PbActivity.this.fMh.fVd.bkq().bik()))) {
                            if (view == PbActivity.this.fMh.bjw()) {
                                if (PbActivity.this.fMe != null) {
                                    com.baidu.tbadk.browser.a.ac(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fMe.getPbData().bet().yB().getLink());
                                }
                            } else if (view != PbActivity.this.fMh.fVd.gad && view.getId() != e.g.view_forum_name) {
                                if (view == PbActivity.this.fMh.fVd.gae) {
                                    if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null) {
                                        ArrayList<PostData> bev = PbActivity.this.fMe.getPbData().bev();
                                        if ((bev == null || bev.size() <= 0) && PbActivity.this.fMe.bhn()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").ax("tid", PbActivity.this.fMe.bhm()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getForumId()));
                                        if (!PbActivity.this.fMh.bjL()) {
                                            PbActivity.this.fMh.biJ();
                                        }
                                        PbActivity.this.bfZ();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != e.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().bhY()) {
                                        if ((PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().bij()) && view.getId() != e.g.floor_owner_reply && view.getId() != e.g.reply_title) {
                                            if (PbActivity.this.fMh.fVd.bkq() == null || (view != PbActivity.this.fMh.fVd.bkq().getCancelView() && view != PbActivity.this.fMh.fVd.bkq().bii())) {
                                                if (view != PbActivity.this.fMh.fVd.gaf && view.getId() != e.g.share_num_container) {
                                                    if (PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().big()) {
                                                        if ((PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().bip()) && view.getId() != e.g.pb_sort) {
                                                            if (PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().bih()) {
                                                                if (PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().biq()) {
                                                                    if (PbActivity.this.fMn == null || view != PbActivity.this.fMn.bia()) {
                                                                        if (PbActivity.this.fMn == null || view != PbActivity.this.fMn.bhY()) {
                                                                            if (PbActivity.this.fMn == null || view != PbActivity.this.fMn.bib()) {
                                                                                if (PbActivity.this.fMn == null || view != PbActivity.this.fMn.bic()) {
                                                                                    if (PbActivity.this.fMn == null || view != PbActivity.this.fMn.bie()) {
                                                                                        if (PbActivity.this.fMn == null || view != PbActivity.this.fMn.bif()) {
                                                                                            if (PbActivity.this.fMn == null || view != PbActivity.this.fMn.bid()) {
                                                                                                if (PbActivity.this.fMh.bjG() == view) {
                                                                                                    if (PbActivity.this.fMh.bjG().getIndicateStatus()) {
                                                                                                        com.baidu.tieba.pb.data.d pbData = PbActivity.this.fMe.getPbData();
                                                                                                        if (pbData != null && pbData.bet() != null && pbData.bet().yj() != null) {
                                                                                                            String xc = pbData.bet().yj().xc();
                                                                                                            if (StringUtils.isNull(xc)) {
                                                                                                                xc = pbData.bet().yj().getTaskId();
                                                                                                            }
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").ax(VideoPlayActivityConfig.OBJ_ID, xc));
                                                                                                        }
                                                                                                    } else {
                                                                                                        com.baidu.tieba.tbadkCore.d.a.cG("c10725", null);
                                                                                                    }
                                                                                                    PbActivity.this.bgt();
                                                                                                } else if (PbActivity.this.fMh.biZ() != view) {
                                                                                                    if (PbActivity.this.fMn == null || view != PbActivity.this.fMn.bhZ()) {
                                                                                                        if (PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().bio()) {
                                                                                                            if (PbActivity.this.fMh.fVd.bkq() != null && view == PbActivity.this.fMh.fVd.bkq().bil()) {
                                                                                                                if (com.baidu.adp.lib.util.j.kV()) {
                                                                                                                    SparseArray<Object> c2 = PbActivity.this.fMh.c(PbActivity.this.fMe.getPbData(), PbActivity.this.fMe.bhn(), 1);
                                                                                                                    if (c2 != null) {
                                                                                                                        if (StringUtils.isNull((String) c2.get(e.g.tag_del_multi_forum))) {
                                                                                                                            PbActivity.this.fMh.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                                        } else {
                                                                                                                            PbActivity.this.fMh.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(e.g.tag_del_multi_forum));
                                                                                                                        }
                                                                                                                    }
                                                                                                                    PbActivity.this.fMh.fVd.dismissPopMenu();
                                                                                                                } else {
                                                                                                                    PbActivity.this.showToast(e.j.network_not_available);
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (view.getId() != e.g.sub_pb_more && view.getId() != e.g.sub_pb_item && view.getId() != e.g.pb_floor_reply_more && view.getId() != e.g.new_sub_pb_list_richText) {
                                                                                                                if (view != PbActivity.this.fMh.bfI()) {
                                                                                                                    if (view == PbActivity.this.fMh.fVd.bkr()) {
                                                                                                                        PbActivity.this.fMh.bjl();
                                                                                                                    } else {
                                                                                                                        int id = view.getId();
                                                                                                                        if (id == e.g.pb_u9_text_view) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin() && (bgVar = (bg) view.getTag()) != null && !StringUtils.isNull(bgVar.Aq())) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                ay.Db().c(PbActivity.this.getPageContext(), new String[]{bgVar.Aq()});
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.replybtn || id == e.g.cover_reply_content || id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right || id == e.g.image_more_tip) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                                                                PostData postData = null;
                                                                                                                                if (view != null && view.getTag() != null) {
                                                                                                                                    postData = (PostData) ((SparseArray) view.getTag()).get(e.g.tag_load_sub_data);
                                                                                                                                    if (PbActivity.this.fMn == null) {
                                                                                                                                        PbActivity.this.fMn = new y(PbActivity.this.getPageContext(), PbActivity.this.dDv);
                                                                                                                                        PbActivity.this.fMh.bE(PbActivity.this.fMn.getView());
                                                                                                                                        PbActivity.this.fMn.kV(PbActivity.this.mIsLogin);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fMn.showDialog();
                                                                                                                                    if (id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right) {
                                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").ax("tid", PbActivity.this.fMe.fRk));
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray = new SparseArray();
                                                                                                                                    sparseArray.put(e.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(e.g.tag_clip_board));
                                                                                                                                    sparseArray.put(e.g.tag_is_subpb, false);
                                                                                                                                    PbActivity.this.fMn.bhY().setTag(sparseArray);
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
                                                                                                                                            PbActivity.this.fMn.bib().setVisibility(0);
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, false);
                                                                                                                                            PbActivity.this.fMn.bib().setVisibility(8);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fMn.bhZ().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fMn.bib().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fMn.bhZ().setText(e.j.bar_manager);
                                                                                                                                        PbActivity.this.fMn.bhZ().setVisibility(0);
                                                                                                                                    } else if (!booleanValue3) {
                                                                                                                                        PbActivity.this.fMn.bhZ().setVisibility(8);
                                                                                                                                        PbActivity.this.fMn.bib().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        SparseArray sparseArray4 = new SparseArray();
                                                                                                                                        sparseArray4.put(e.g.tag_should_manage_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_should_delete_visible, true);
                                                                                                                                        sparseArray4.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                        PbActivity.this.fMn.bhZ().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fMn.bib().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fMn.bhZ().setText(e.j.delete);
                                                                                                                                        PbActivity.this.fMn.bib().setVisibility(0);
                                                                                                                                        if (PbActivity.this.fMe.getPbData().beF() != 1002 || z) {
                                                                                                                                            PbActivity.this.fMn.bib().setText(e.j.delete);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fMn.bib().setText(e.j.report_text);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fMn.bhZ().setVisibility(8);
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
                                                                                                                                        PbActivity.this.fMn.bia().setTag(sparseArray6);
                                                                                                                                        PbActivity.this.fMn.bia().setVisibility(0);
                                                                                                                                        PbActivity.this.fMn.bhZ().setVisibility(8);
                                                                                                                                        PbActivity.this.fMn.bia().setText(e.j.mute_option);
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
                                                                                                                                        boolean kD = PbActivity.this.kD(z3) & PbActivity.this.isLogin();
                                                                                                                                        PbActivity.this.fNo = (PostData) sparseArray5.get(e.g.tag_clip_board);
                                                                                                                                        if (aq.k(PbActivity.this.fNo) ? false : kD) {
                                                                                                                                            PbActivity.this.fMn.bia().setVisibility(0);
                                                                                                                                            PbActivity.this.fMn.bia().setTag(str3);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fMn.bia().setVisibility(8);
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
                                                                                                                                        PbActivity.this.fMn.bid().setVisibility(0);
                                                                                                                                        PbActivity.this.fMn.bid().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                        PbActivity.this.fMn.bid().setTag(e.g.tag_chudian_monitor_id, str);
                                                                                                                                        PbActivity.this.fMn.bid().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fMn.bid().setVisibility(8);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                boolean z5 = false;
                                                                                                                                if (PbActivity.this.fMe.getPbData().vm()) {
                                                                                                                                    String vl = PbActivity.this.fMe.getPbData().vl();
                                                                                                                                    if (postData != null && !com.baidu.adp.lib.util.k.isEmpty(vl) && vl.equals(postData.getId())) {
                                                                                                                                        z5 = true;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (z5) {
                                                                                                                                    PbActivity.this.fMn.bhY().setText(e.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fMn.bhY().setText(e.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fMn.bif().setVisibility(8);
                                                                                                                                PbActivity.this.fMn.bie().setVisibility(8);
                                                                                                                                if (postData != null) {
                                                                                                                                    if (postData.bBz() == null || postData.bBz().toString().length() <= 0) {
                                                                                                                                        PbActivity.this.fMn.bic().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fMn.bic().setVisibility(0);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fNo = postData;
                                                                                                                                }
                                                                                                                                PbActivity.this.fMn.refreshUI();
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_act_btn) {
                                                                                                                            if (PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().bet() != null && PbActivity.this.fMe.getPbData().bet().getActUrl() != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ac(PbActivity.this.getActivity(), PbActivity.this.fMe.getPbData().bet().getActUrl());
                                                                                                                                if (PbActivity.this.fMe.getPbData().bet().zg() != 1) {
                                                                                                                                    if (PbActivity.this.fMe.getPbData().bet().zg() == 2) {
                                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.lottery_tail) {
                                                                                                                            if (view.getTag(e.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                                String str4 = (String) view.getTag(e.g.tag_pb_lottery_tail_link);
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getPbData().getForumId()).ax("tid", PbActivity.this.fMe.getPbData().getThreadId()).ax("lotterytail", StringUtils.string(str4, BaseRequestAction.SPLITE, TbadkCoreApplication.getCurrentAccount())));
                                                                                                                                if (PbActivity.this.fMe.getPbData().getThreadId().equals(str4)) {
                                                                                                                                    PbActivity.this.fMh.setSelection(0);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_item_tail_content) {
                                                                                                                            if (ba.bG(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                                String string = TbadkCoreApplication.getInst().getString(e.j.tail_web_view_title);
                                                                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                                if (!StringUtils.isNull(string2)) {
                                                                                                                                    TiebaStatic.log("c10056");
                                                                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                                }
                                                                                                                                PbActivity.this.fMh.biJ();
                                                                                                                            }
                                                                                                                        } else if (id == e.g.join_vote_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ac(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                if (PbActivity.this.bfW() == 1 && PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getPbData().getForumId()).ax("tid", PbActivity.this.fMe.getPbData().getThreadId()).ax("uid", currentAccount));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.look_all_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                com.baidu.tbadk.browser.a.ac(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                if (PbActivity.this.bfW() == 1 && PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getPbData().getForumId()).ax("tid", PbActivity.this.fMe.getPbData().getThreadId()).ax("uid", currentAccount2));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.manga_prev_btn) {
                                                                                                                            PbActivity.this.bgo();
                                                                                                                        } else if (id == e.g.manga_next_btn) {
                                                                                                                            PbActivity.this.bgp();
                                                                                                                        } else if (id == e.g.yule_head_img_img) {
                                                                                                                            if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().beN() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fMe.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").ax(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                                ay.Db().c(PbActivity.this.getPageContext(), new String[]{pbData2.beN().beW()});
                                                                                                                            }
                                                                                                                        } else if (id == e.g.yule_head_img_all_rank) {
                                                                                                                            if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().beN() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fMe.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").ax(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                                ay.Db().c(PbActivity.this.getPageContext(), new String[]{pbData3.beN().beW()});
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.fMh.fVd.bkq() != null && view == PbActivity.this.fMh.fVd.bkq().bir()) {
                                                                                                                            if (PbActivity.this.fMe == null || PbActivity.this.fMe.getPbData() == null || PbActivity.this.fMe.getPbData().bet() == null) {
                                                                                                                                PbActivity.this.fMh.fVd.dismissPopMenu();
                                                                                                                                return;
                                                                                                                            } else if (!com.baidu.adp.lib.util.l.lm()) {
                                                                                                                                PbActivity.this.showToast(e.j.neterror);
                                                                                                                                return;
                                                                                                                            } else {
                                                                                                                                int i2 = 1;
                                                                                                                                if (PbActivity.this.fMe.getPbData().bet().yk() == 0) {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fMe.bhm(), 25028)));
                                                                                                                                } else {
                                                                                                                                    BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(e.j.haved_fans_called)).AJ();
                                                                                                                                    i2 = 2;
                                                                                                                                }
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").x("obj_locate", PbActivity.this.al(PbActivity.this.fMe.getPbData().bet())).ax("tid", PbActivity.this.fMe.getPbData().bet().getTid()).x("obj_type", i2));
                                                                                                                            }
                                                                                                                        } else if (id == e.g.tv_pb_reply_more) {
                                                                                                                            if (PbActivity.this.fMH >= 0) {
                                                                                                                                if (PbActivity.this.fMe != null) {
                                                                                                                                    PbActivity.this.fMe.bhS();
                                                                                                                                }
                                                                                                                                if (PbActivity.this.fMh.bja() != null) {
                                                                                                                                    PbActivity.this.fMh.bja().a(PbActivity.this.fMe.getPbData(), false);
                                                                                                                                }
                                                                                                                                PbActivity.this.fMh.getListView().setSelection(PbActivity.this.fMe.bhV());
                                                                                                                                PbActivity.this.fMH = 0;
                                                                                                                                if (PbActivity.this.fMe != null) {
                                                                                                                                    PbActivity.this.fMe.bz(0, 0);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.single_bar_tips) {
                                                                                                                            PbActivity.this.fMh.bjP();
                                                                                                                        } else if (id == e.g.pb_post_recommend_live_layout) {
                                                                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                                TiebaStatic.log("c12640");
                                                                                                                            }
                                                                                                                        } else if (id == e.g.thread_info_commont_container) {
                                                                                                                            PbActivity.this.fMh.biO();
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
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.fMe.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.fMe.bhm(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fMe.getPbData().bet().yX())));
                                                                                                                }
                                                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                if (PbActivity.this.fMe.getPbData() != null) {
                                                                                                                    PbActivity.this.fMh.bjt();
                                                                                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                    PostData postData2 = (PostData) sparseArray9.get(e.g.tag_load_sub_data);
                                                                                                                    View view2 = (View) sparseArray9.get(e.g.tag_load_sub_view);
                                                                                                                    if (postData2 != null && view2 != null) {
                                                                                                                        if (postData2.bBJ() == 1) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                                                        }
                                                                                                                        String bhm = PbActivity.this.fMe.bhm();
                                                                                                                        String id2 = postData2.getId();
                                                                                                                        int i3 = 0;
                                                                                                                        if (PbActivity.this.fMe.getPbData() != null) {
                                                                                                                            i3 = PbActivity.this.fMe.getPbData().beF();
                                                                                                                        }
                                                                                                                        PbActivity.this.azn();
                                                                                                                        if (view.getId() == e.g.replybtn) {
                                                                                                                            c sq = PbActivity.this.sq(id2);
                                                                                                                            if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && sq != null) {
                                                                                                                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bhm, id2, "pb", true, null, true, null, i3, postData2.blf(), PbActivity.this.fMe.getPbData().xA(), false, postData2.yC().getIconInfo()).addBigImageData(sq.fNY, sq.fNZ, sq.fOa, sq.index);
                                                                                                                                addBigImageData.setKeyPageStartFrom(PbActivity.this.fMe.bhR());
                                                                                                                                addBigImageData.setFromFrsForumId(PbActivity.this.fMe.getFromForumId());
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            c sq2 = PbActivity.this.sq(id2);
                                                                                                                            if (postData2 != null && PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && sq2 != null) {
                                                                                                                                SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bhm, id2, "pb", true, null, false, null, i3, postData2.blf(), PbActivity.this.fMe.getPbData().xA(), false, postData2.yC().getIconInfo()).addBigImageData(sq2.fNY, sq2.fNZ, sq2.fOa, sq2.index);
                                                                                                                                addBigImageData2.setKeyPageStartFrom(PbActivity.this.fMe.bhR());
                                                                                                                                addBigImageData2.setFromFrsForumId(PbActivity.this.fMe.getFromForumId());
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
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 3).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getPbData().getForumId()));
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                                                                                            PbActivity.this.fMh.bjt();
                                                                                                            SparseArray<Object> c3 = PbActivity.this.fMh.c(PbActivity.this.fMe.getPbData(), PbActivity.this.fMe.bhn(), 1);
                                                                                                            if (c3 != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fMe.getPbData().ber().getId(), PbActivity.this.fMe.getPbData().ber().getName(), PbActivity.this.fMe.getPbData().bet().getId(), String.valueOf(PbActivity.this.fMe.getPbData().getUserData().getUserId()), (String) c3.get(e.g.tag_forbid_user_name), (String) c3.get(e.g.tag_forbid_user_name_show), (String) c3.get(e.g.tag_forbid_user_post_id), (String) c3.get(e.g.tag_forbid_user_portrait))));
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
                                                                                                                    PbActivity.this.fMh.bC(view);
                                                                                                                }
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.fMh.a(((Integer) sparseArray10.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray10.get(e.g.tag_del_post_id), ((Integer) sparseArray10.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getPbData().getForumId()));
                                                                                                    return;
                                                                                                } else {
                                                                                                    PbActivity.this.bfK();
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
                                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fMe.getPbData();
                                                                                                String str6 = null;
                                                                                                String str7 = null;
                                                                                                String str8 = null;
                                                                                                if (pbData4 != null && pbData4.ber() != null) {
                                                                                                    str6 = pbData4.ber().getId();
                                                                                                    str7 = pbData4.ber().getName();
                                                                                                    str8 = pbData4.getThreadId();
                                                                                                }
                                                                                                com.baidu.tieba.pb.a.a(j2, str5, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str6, str7, str8);
                                                                                                PbActivity.this.a(j2, str5, str6, str7, str8, i4);
                                                                                            }
                                                                                        } else if (PbActivity.this.fME != null && !TextUtils.isEmpty(PbActivity.this.fMF)) {
                                                                                            if (PbActivity.this.bvI == null) {
                                                                                                PbActivity.this.bvI = new com.baidu.tbadk.core.util.b.a();
                                                                                            }
                                                                                            PbActivity.this.bvI.Dp();
                                                                                            PbActivity.this.bvI.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                            if (!PbActivity.this.bvI.A(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                if (PbActivity.this.fMD == null) {
                                                                                                    PbActivity.this.fMD = new av(PbActivity.this.getPageContext());
                                                                                                }
                                                                                                PbActivity.this.fMD.i(PbActivity.this.fMF, PbActivity.this.fME.ot());
                                                                                                PbActivity.this.fME = null;
                                                                                                PbActivity.this.fMF = null;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.fME != null && !TextUtils.isEmpty(PbActivity.this.fMF)) {
                                                                                        if (PbActivity.this.fMG == null) {
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fMF));
                                                                                        } else {
                                                                                            d.a aVar = new d.a();
                                                                                            aVar.url = PbActivity.this.fMF;
                                                                                            aVar.pkgId = PbActivity.this.fMG.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fMG.memeInfo.pck_id;
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                                        }
                                                                                        PbActivity.this.fME = null;
                                                                                        PbActivity.this.fMF = null;
                                                                                    }
                                                                                } else if (PbActivity.this.fNo != null) {
                                                                                    PbActivity.this.fNo.cV(PbActivity.this.getPageContext().getPageActivity());
                                                                                    PbActivity.this.fNo = null;
                                                                                }
                                                                            } else {
                                                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                                                if (sparseArray11 != null) {
                                                                                    if ((sparseArray11.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_id) instanceof String) && (sparseArray11.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                        PbActivity.this.fMh.a(((Integer) sparseArray11.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(e.g.tag_del_post_id), ((Integer) sparseArray11.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").x("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bu(view);
                                                                                if (PbActivity.this.fMe.getPbData().bet() != null && PbActivity.this.fMe.getPbData().bet().yC() != null && PbActivity.this.fMe.getPbData().bet().yC().getUserId() != null && PbActivity.this.fMg != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").ax("tid", PbActivity.this.fMe.fRk).x("obj_locate", 2).ax(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fMe.getPbData().bet().yC().getUserId()).x("obj_type", PbActivity.this.fMg.vm() ? 0 : 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fMe.getPbData())));
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
                                                                            PbActivity.this.sn((String) tag);
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
                                                                    UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").x("obj_type", 0).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").x("obj_type", 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fMh.fVd.bkp();
                                                                }
                                                            } else if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().bet() != null) {
                                                                PbActivity.this.fMh.fVd.dismissPopMenu();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                                PbActivity.this.sn(PbActivity.this.fMe.getPbData().bet().yT());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fMh.bjt();
                                                            if (com.baidu.adp.lib.util.j.kV()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Integer.valueOf(PbActivity.this.fMe.bhA()));
                                                                    return;
                                                                }
                                                                PbActivity.this.rL(2);
                                                                PbActivity.this.azn();
                                                                PbActivity.this.fMh.bje();
                                                                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(PbActivity.this.getPageContext().getPageActivity());
                                                                if (PbActivity.this.fMe.getPbData().fJE == null || PbActivity.this.fMe.getPbData().fJE.size() <= 0) {
                                                                    strArr = new String[]{PbActivity.this.getResources().getString(e.j.sort_type_new), PbActivity.this.getResources().getString(e.j.sort_type_old)};
                                                                } else {
                                                                    String[] strArr2 = new String[PbActivity.this.fMe.getPbData().fJE.size()];
                                                                    int i5 = 0;
                                                                    while (true) {
                                                                        int i6 = i5;
                                                                        if (i6 >= PbActivity.this.fMe.getPbData().fJE.size()) {
                                                                            break;
                                                                        }
                                                                        strArr2[i6] = PbActivity.this.fMe.getPbData().fJE.get(i6).sort_name + PbActivity.this.getResources().getString(e.j.sort_static);
                                                                        i5 = i6 + 1;
                                                                    }
                                                                    strArr = strArr2;
                                                                }
                                                                bVar.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                                                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                                                                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i7, View view3) {
                                                                        int i8 = 2;
                                                                        if (PbActivity.this.fMe.aaT() == 1 && i7 == 1) {
                                                                            i8 = 0;
                                                                        } else if (PbActivity.this.fMe.aaT() == 2 && i7 == 0) {
                                                                            i8 = 1;
                                                                        } else if (PbActivity.this.fMe.aaT() != 3 || i7 == 2) {
                                                                            i8 = (i7 != 2 || PbActivity.this.fMe.aaT() == 3) ? 0 : 3;
                                                                        }
                                                                        TiebaStatic.log("c12097");
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != e.g.pb_sort ? 1 : 0).x("obj_type", i8));
                                                                        if (PbActivity.this.fMe.getPbData().fJE != null && PbActivity.this.fMe.getPbData().fJE.size() > i7) {
                                                                            i7 = PbActivity.this.fMe.getPbData().fJE.get(i7).sort_type.intValue();
                                                                        }
                                                                        boolean rY = PbActivity.this.fMe.rY(i7);
                                                                        view.setTag(Integer.valueOf(PbActivity.this.fMe.bhA()));
                                                                        if (rY) {
                                                                            PbActivity.this.mIsLoading = true;
                                                                            PbActivity.this.fMh.ld(true);
                                                                        }
                                                                        bVar2.dismiss();
                                                                    }
                                                                });
                                                                bVar.d(PbActivity.this.getPageContext()).AE();
                                                            } else {
                                                                PbActivity.this.showToast(e.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fMh.bjt();
                                                        if (PbActivity.this.bfx().getPbData().fJF != 2) {
                                                            if (PbActivity.this.fMe.getPageData() != null) {
                                                                PbActivity.this.fMh.a(PbActivity.this.fMe.getPageData(), PbActivity.this.fAh);
                                                            }
                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            PbActivity.this.showToast(e.j.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (ax.jJ() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fMe != null) {
                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12386");
                                                        amVar.ax("tid", PbActivity.this.fMe.bhm());
                                                        amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                                                        amVar.ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getForumId());
                                                        amVar.x("obj_locate", 6);
                                                        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        TiebaStatic.log(amVar);
                                                    }
                                                    if (com.baidu.adp.lib.util.l.lm()) {
                                                        if (PbActivity.this.fMe.getPbData() != null) {
                                                            ArrayList<PostData> bev2 = PbActivity.this.fMe.getPbData().bev();
                                                            if ((bev2 != null && bev2.size() > 0) || !PbActivity.this.fMe.bhn()) {
                                                                PbActivity.this.fMh.bjt();
                                                                PbActivity.this.azn();
                                                                PbActivity.this.rL(2);
                                                                if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().beN() != null && !StringUtils.isNull(PbActivity.this.fMe.getPbData().beN().xn(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                                if (ax.jJ()) {
                                                                    PbActivity.this.rM(2);
                                                                } else {
                                                                    PbActivity.this.fMh.showLoadingDialog();
                                                                    PbActivity.this.fMe.bhM().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.fMh.fVd.dismissPopMenu();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                            PbActivity.this.fMh.bjt();
                                            if (PbActivity.this.fMh.fVd.bkq() != null && view == PbActivity.this.fMh.fVd.bkq().bij() && !PbActivity.this.fMh.bjL()) {
                                                PbActivity.this.fMh.biJ();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.azn();
                                                PbActivity.this.fMh.bje();
                                                if (view.getId() == e.g.floor_owner_reply) {
                                                    p = PbActivity.this.fMe.p(true, PbActivity.this.bgm());
                                                } else {
                                                    p = view.getId() == e.g.reply_title ? PbActivity.this.fMe.p(false, PbActivity.this.bgm()) : PbActivity.this.fMe.ss(PbActivity.this.bgm());
                                                }
                                                view.setTag(Boolean.valueOf(p));
                                                if (p) {
                                                    PbActivity.this.fMh.kM(true);
                                                    PbActivity.this.fMh.aQE();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fMh.ld(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.rL(2);
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
                                        PbActivity.this.fMh.bjt();
                                        if (PbActivity.this.rK(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fMe.rZ(PbActivity.this.fMh.bjj()) != null) {
                                            PbActivity.this.bgg();
                                            if (PbActivity.this.fMe.getPbData().bet() != null && PbActivity.this.fMe.getPbData().bet().yC() != null && PbActivity.this.fMe.getPbData().bet().yC().getUserId() != null && PbActivity.this.fMg != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").ax("tid", PbActivity.this.fMe.fRk).x("obj_locate", 1).ax(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fMe.getPbData().bet().yC().getUserId()).x("obj_type", PbActivity.this.fMg.vm() ? 0 : 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fMe.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(e.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.kV()) {
                                    PbActivity.this.fMh.kM(true);
                                    PbActivity.this.fMh.biJ();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fMh.aQE();
                                        PbActivity.this.azn();
                                        PbActivity.this.fMh.bje();
                                        PbActivity.this.fMe.ss(PbActivity.this.bgm());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.rL(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(e.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().bet() != null && PbActivity.this.fMe.getPbData().bet().zq() && PbActivity.this.fMe.getPbData().bet().yU() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.fMe.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fMe.bfo()) && PbActivity.this.fMe.getAppealInfo() != null) {
                                        name = PbActivity.this.fMe.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fMe.getPbData().ber().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bfo = PbActivity.this.fMe.bfo();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fMe.bho() && bfo != null && bfo.equals(name)) {
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
                            if (PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().beF() == 1 && !PbActivity.this.cPb.bCi()) {
                                PbActivity.this.fMh.bjt();
                                int i7 = 0;
                                if (PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().bik()) {
                                    if (PbActivity.this.fMh.fVd.bkq() == null || view != PbActivity.this.fMh.fVd.bkq().bim()) {
                                        if (view == PbActivity.this.fMh.bjc()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.fMe.getPbData().bet().yy() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.fMe.getPbData().bet().yx() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData ber = PbActivity.this.fMe.getPbData().ber();
                                String name2 = ber.getName();
                                String id3 = ber.getId();
                                String id4 = PbActivity.this.fMe.getPbData().bet().getId();
                                PbActivity.this.fMh.bjb();
                                PbActivity.this.cPb.a(id3, name2, id4, i7, PbActivity.this.fMh.bjd());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(e.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.kV()) {
                        PbActivity.this.fMh.bjt();
                        PbActivity.this.azn();
                        PbActivity.this.fMh.bje();
                        PbActivity.this.fMh.showLoadingDialog();
                        if (PbActivity.this.fMh.biR() != null) {
                            PbActivity.this.fMh.biR().setVisibility(8);
                        }
                        PbActivity.this.fMe.rT(1);
                        if (PbActivity.this.fLL != null) {
                            PbActivity.this.fLL.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(e.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(e.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == e.g.reply_god_title_group) {
                        String bfT = PbActivity.this.bfT();
                        if (!TextUtils.isEmpty(bfT)) {
                            ay.Db().c(PbActivity.this.getPageContext(), new String[]{bfT});
                        }
                    }
                } else if (PbActivity.this.fLV) {
                    PbActivity.this.fLV = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(e.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData3 = (PostData) obj;
                            if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.bfO().biH() != null && postData3.yC() != null && postData3.bBx() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bfO().biI() != null) {
                                    PbActivity.this.bfO().biI().bgZ();
                                }
                                com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                jVar.a(PbActivity.this.fMe.getPbData().ber());
                                jVar.aa(PbActivity.this.fMe.getPbData().bet());
                                jVar.e(postData3);
                                PbActivity.this.bfO().biH().d(jVar);
                                PbActivity.this.bfO().biH().setPostId(postData3.getId());
                                PbActivity.this.a(view, postData3.yC().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fMu != null) {
                                    PbActivity.this.fMh.ln(PbActivity.this.fMu.Lz());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.w wVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null) {
                    amVar.ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getPbData().getForumId());
                }
                if (PbActivity.this.fMe != null) {
                    amVar.ax("tid", PbActivity.this.fMe.bhm());
                }
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.azn();
            PbActivity.this.fMh.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.ao.Ox() && PbActivity.this.bfx() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bfx().sv(postWriteCallBackData.getPostId());
                    PbActivity.this.fMH = PbActivity.this.fMh.biM();
                    if (PbActivity.this.fMe != null) {
                        PbActivity.this.fMe.bz(PbActivity.this.fMH, PbActivity.this.fMh.biN());
                    }
                }
                PbActivity.this.fMh.bjt();
                PbActivity.this.fMm.bjT();
                if (PbActivity.this.fMu != null) {
                    PbActivity.this.fMh.ln(PbActivity.this.fMu.Lz());
                }
                PbActivity.this.fMh.biG();
                PbActivity.this.fMh.lp(true);
                PbActivity.this.fMe.bhC();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fMe.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fMe.getPbData();
                            if (pbData != null && pbData.bet() != null && pbData.bet().yC() != null && (userId = pbData.bet().yC().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.ao.Ox() && PbActivity.this.fMe.bhv()) {
                                PbActivity.this.fMh.bje();
                            }
                        } else if (!com.baidu.tbadk.p.ao.Ox() && PbActivity.this.fMe.bhv()) {
                            PbActivity.this.fMh.bje();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fMh.n(PbActivity.this.fMe.getPbData());
                    }
                    if (PbActivity.this.fMe.bhr()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").ax("tid", PbActivity.this.fMe.bhm()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fMu.LF() || PbActivity.this.fMu.LG()) {
                    PbActivity.this.fMu.a(false, postWriteCallBackData);
                }
                PbActivity.this.fMm.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.eYo != null) {
                    PbActivity.this.eYo.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (wVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fNg = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.w wVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null) {
                    amVar.ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getPbData().getForumId());
                }
                if (PbActivity.this.fMe != null) {
                    amVar.ax("tid", PbActivity.this.fMe.bhm());
                }
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fMm != null) {
                    PbActivity.this.fMm.bjS();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.eYo != null) {
                    PbActivity.this.eYo.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fMm != null) {
                if (PbActivity.this.fMh != null && PbActivity.this.fMh.biI() != null && PbActivity.this.fMh.biI().bhe() != null && PbActivity.this.fMh.biI().bhe().LG()) {
                    PbActivity.this.fMh.biI().bhe().a(postWriteCallBackData);
                }
                PbActivity.this.fMm.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fNh = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g ft;
            if (!z || dVar == null || dVar.beD() != null || com.baidu.tbadk.core.util.v.H(dVar.bev()) >= 1) {
                PbActivity.this.fpn = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fMh.bjg();
                if (dVar == null || !dVar.bez()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fMh.getView());
                }
                PbActivity.this.fMh.aQD();
                if (PbActivity.this.isFullScreen || PbActivity.this.fMh.bjL()) {
                    PbActivity.this.fMh.bjC();
                } else if (!PbActivity.this.fMh.bjz()) {
                    PbActivity.this.fMh.lp(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fMo = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.fMh.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.fMh.alG();
                    if (dVar.bet() != null && dVar.bet().zx() != null) {
                        PbActivity.this.a(dVar.bet().zx());
                    }
                    PbActivity.this.bfL();
                    if (PbActivity.this.fMu != null) {
                        PbActivity.this.fMh.ln(PbActivity.this.fMu.Lz());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bev() != null && dVar.bev().size() >= 1 && dVar.bev().get(0) != null) {
                        PbActivity.this.fMe.su(dVar.bev().get(0).getId());
                    } else if (dVar.beD() != null) {
                        PbActivity.this.fMe.su(dVar.beD().getId());
                    }
                    if (PbActivity.this.fMu != null) {
                        PbActivity.this.fMu.a(dVar.xA());
                        PbActivity.this.fMu.a(dVar.ber(), dVar.getUserData());
                        PbActivity.this.fMu.a(PbActivity.this.fMe.bhw(), PbActivity.this.fMe.bhm(), PbActivity.this.fMe.bhO());
                        if (dVar.bet() != null) {
                            PbActivity.this.fMu.cw(dVar.bet().zN());
                        }
                    }
                    if (PbActivity.this.fMg != null) {
                        PbActivity.this.fMg.aO(dVar.vm());
                    }
                    if (dVar == null || dVar.beG() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fMh.lo(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fMh.a(dVar, i2, i3, PbActivity.this.fMe.bhn(), i4, PbActivity.this.fMe.getIsFromMark());
                    PbActivity.this.fMh.d(dVar, PbActivity.this.fMe.bhn());
                    PbActivity.this.fMh.ll(PbActivity.this.fMe.getHostMode());
                    AntiData xA = dVar.xA();
                    if (xA != null) {
                        PbActivity.this.aWy = xA.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aWy) && PbActivity.this.fMu != null && PbActivity.this.fMu.KT() != null && (ft = PbActivity.this.fMu.KT().ft(6)) != null && !TextUtils.isEmpty(PbActivity.this.aWy)) {
                            ((View) ft).setOnClickListener(PbActivity.this.aXi);
                        }
                    }
                    if (PbActivity.this.fMq) {
                        PbActivity.this.fMq = false;
                        final int bgb = PbActivity.this.bgb();
                        if (dVar.beS()) {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bgb, aO);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bfO().sf(bgb);
                        }
                    }
                    if (PbActivity.this.fMr) {
                        PbActivity.this.fMr = false;
                        final int bgb2 = PbActivity.this.bgb();
                        final boolean z2 = bgb2 != -1;
                        if (!z2) {
                            bgb2 = PbActivity.this.bgc();
                        }
                        if (PbActivity.this.bfO() != null) {
                            if (dVar.beS()) {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bgb2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bgb2, aO2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bgb2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.bfO().lq(true);
                            } else {
                                PbActivity.this.bfO().sf(bgb2);
                            }
                        }
                    } else {
                        PbActivity.this.fMh.bjk();
                    }
                    PbActivity.this.fMe.a(dVar.ber(), PbActivity.this.fMU);
                    PbActivity.this.fMe.a(PbActivity.this.fMV);
                    if (PbActivity.this.eYo != null && dVar.bet() != null && dVar.bet().yC() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bet().yC());
                        PbActivity.this.eYo.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fMo && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fMe != null && PbActivity.this.fMe.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fMe.getAppealInfo().fIW)) {
                                    PbActivity.this.fMh.a(PbActivity.this.fMe.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fMh.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0200e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fMh.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0200e.ds200));
                            }
                            PbActivity.this.fMh.bjC();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fMe.bhm());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getForumId());
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
                        PbActivity.this.fMh.sy(PbActivity.this.getResources().getString(e.j.list_no_more_new));
                    } else {
                        PbActivity.this.fMh.sy("");
                    }
                    PbActivity.this.fMh.DZ();
                }
                PbActivity.this.bcv = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bfx().bhn() || PbActivity.this.bfx().getPbData().xO().xM() != 0 || PbActivity.this.bfx().bhI()) {
                    PbActivity.this.fMv = true;
                    return;
                }
                return;
            }
            PbActivity.this.fMe.rT(1);
            if (PbActivity.this.fLL != null) {
                PbActivity.this.fLL.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fMh.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.m.Og().Oh()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.dhW : j;
                com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, PbActivity.this.bcn, PbActivity.this.createTime, PbActivity.this.bcv, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.bcn = 0L;
                if (iVar != null) {
                    iVar.Od();
                }
                if (z2) {
                    iVar.bcE = currentTimeMillis;
                    iVar.cK(true);
                }
                if (!z2 && PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().bet() != null) {
                    int threadType = PbActivity.this.fMe.getPbData().bet().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fLY, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fLY, "from_frs")) {
                                com.baidu.tbadk.l.i iVar2 = new com.baidu.tbadk.l.i();
                                iVar2.fU(1000);
                                iVar2.bcG = currentTimeMillis;
                                iVar2.fV(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.l.d dVar = new com.baidu.tbadk.l.d();
                        dVar.pageType = 1;
                        dVar.fU(1005);
                        dVar.bcG = currentTimeMillis;
                        dVar.fV(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fNi = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bfX();
            }
        }
    };
    private final a.InterfaceC0144a fNj = new a.InterfaceC0144a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0144a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fMh.bjg();
            if (z) {
                if (PbActivity.this.fMg != null) {
                    PbActivity.this.fMg.aO(z2);
                }
                PbActivity.this.fMe.kT(z2);
                if (PbActivity.this.fMe.vm()) {
                    PbActivity.this.bgh();
                } else {
                    PbActivity.this.fMh.n(PbActivity.this.fMe.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fMg != null && PbActivity.this.fMg.vp() != null && PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().bet() != null && PbActivity.this.fMe.getPbData().bet().yC() != null) {
                        MarkData vp = PbActivity.this.fMg.vp();
                        MetaData yC = PbActivity.this.fMe.getPbData().bet().yC();
                        if (vp != null && yC != null) {
                            if (!com.baidu.tbadk.core.util.ao.equals(TbadkCoreApplication.getCurrentAccount(), yC.getUserId()) && !yC.hadConcerned()) {
                                PbActivity.this.b(yC);
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
            if (!PbActivity.this.rH(PbActivity.this.mLastScrollState) && PbActivity.this.rH(i)) {
                if (PbActivity.this.fMh != null) {
                    PbActivity.this.fMh.bjt();
                    if (PbActivity.this.fMu != null && !PbActivity.this.fMh.biK()) {
                        PbActivity.this.fMh.ln(PbActivity.this.fMu.Lz());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fMh.biJ();
                    }
                }
                if (!PbActivity.this.fLS) {
                    PbActivity.this.fLS = true;
                    PbActivity.this.fMh.bjy();
                }
            }
            PbActivity.this.fMh.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fLL != null) {
                PbActivity.this.fLL.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fLT == null) {
                PbActivity.this.fLT = new com.baidu.tbadk.l.b();
                PbActivity.this.fLT.fU(1001);
            }
            if (i == 0) {
                PbActivity.this.fLT.NX();
            } else {
                PbActivity.this.fLT.NW();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bev;
            if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMh != null && PbActivity.this.fMh.bja() != null) {
                PbActivity.this.fMh.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fLL != null) {
                    PbActivity.this.fLL.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fMe.bhE() && (bev = PbActivity.this.fMe.getPbData().bev()) != null && !bev.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fMh.bja().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fMe.getPbData();
                    if (pbData != null) {
                        if (pbData.bew() != null && pbData.bew().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bex() != null && pbData.bex().hasData()) {
                            headerCount--;
                        }
                        int size = bev.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cPf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cPb.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fMe.bhC();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gbS != 1002 || bVar.egp) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fMh.a(1, dVar.HZ, dVar.hgO, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cPb.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fMh.a(PbActivity.this.cPb.getLoadDataMode(), gVar.HZ, gVar.hgO, false);
                        PbActivity.this.fMh.ap(gVar.hgR);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fMh.a(PbActivity.this.cPb.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fNk = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
    };
    private final j.b bAc = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.tbadk.core.view.j.b
        public void bG(boolean z) {
            if (PbActivity.this.bgn()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fMe.kS(true)) {
                PbActivity.this.fMh.bjh();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e dUB = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fNl && PbActivity.this.bgn()) {
                PbActivity.this.bgp();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fMe.kR(false)) {
                    PbActivity.this.fMh.bjf();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fMe.getPbData() != null) {
                    PbActivity.this.fMh.bjx();
                }
                PbActivity.this.fNl = true;
            }
        }
    };
    private int fNm = 0;
    private final TbRichTextView.h bop = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
        /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fMh.b((TbRichText) view.getTag());
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
                    PbActivity.this.fMc = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fOb) {
                    TbRichText aK = PbActivity.this.aK(str, i);
                    if (aK != null && PbActivity.this.fNm >= 0 && PbActivity.this.fNm < aK.QT().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aK.QT().get(PbActivity.this.fNm));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fNY.size()) {
                                break;
                            } else if (!cVar.fNY.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.I(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fNZ.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fOa, cVar.lastId, PbActivity.this.fMe.bhz(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbActivity.this.l(rect);
                        createConfig.setIsHotSort(PbActivity.this.fMe.aaT() == 2);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.d(cVar.fNY, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.I(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fNZ.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fOa, cVar.fNY.get(0), PbActivity.this.fMe.bhz(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                createConfig2.setIsHotSort(PbActivity.this.fMe.aaT() == 2);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fNn = false;
    PostData fNo = null;
    private final b.InterfaceC0148b fNp = new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fNo != null) {
                if (i == 0) {
                    PbActivity.this.fNo.cV(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fNo = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fNo);
                }
            }
        }
    };
    private final b.InterfaceC0148b fNq = new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fME != null && !TextUtils.isEmpty(PbActivity.this.fMF)) {
                if (i == 0) {
                    if (PbActivity.this.fMG == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fMF));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fMF;
                        aVar.pkgId = PbActivity.this.fMG.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fMG.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bvI == null) {
                        PbActivity.this.bvI = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bvI.Dp();
                    PbActivity.this.bvI.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bvI.A(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fMD == null) {
                            PbActivity.this.fMD = new av(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fMD.i(PbActivity.this.fMF, PbActivity.this.fME.ot());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fME = null;
                PbActivity.this.fMF = null;
            }
        }
    };
    private final View.OnLongClickListener aPP = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
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
                if (PbActivity.this.bv(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.fME = ((TbImageView) view).getBdImage();
                        PbActivity.this.fMF = ((TbImageView) view).getUrl();
                        if (PbActivity.this.fME != null && !TextUtils.isEmpty(PbActivity.this.fMF)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fMG = null;
                            } else {
                                PbActivity.this.fMG = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                PbActivity.this.fMh.a(PbActivity.this.fNq, PbActivity.this.fME.isGif());
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
                            PbActivity.this.fME = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.fMF = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fMG = null;
                            } else {
                                PbActivity.this.fMG = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.fME = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.fMF = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.fMG = null;
                        } else {
                            PbActivity.this.fMG = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
            PbActivity.this.fNo = (PostData) sparseArray.get(e.g.tag_clip_board);
            if (PbActivity.this.fNo != null) {
                if (PbActivity.this.fNo.bBx() != 1 || !PbActivity.this.bv(view)) {
                    if (PbActivity.this.fMg != null) {
                        boolean z2 = PbActivity.this.fMg.vm() && PbActivity.this.fNo.getId() != null && PbActivity.this.fNo.getId().equals(PbActivity.this.fMe.yM());
                        if (view == null || sparseArray == null) {
                            z = false;
                        } else {
                            if (PbActivity.this.fMn == null) {
                                PbActivity.this.fMn = new y(PbActivity.this.getPageContext(), PbActivity.this.dDv);
                                PbActivity.this.fMh.bE(PbActivity.this.fMn.getView());
                                PbActivity.this.fMn.kV(PbActivity.this.mIsLogin);
                            }
                            if (PbActivity.this.fNo.bBx() == 1) {
                                PbActivity.this.fMh.a(PbActivity.this.fNp, z2, false);
                            } else {
                                PbActivity.this.fMn.showDialog();
                                z = PbActivity.this.kD(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & PbActivity.this.isLogin();
                            }
                        }
                        boolean booleanValue = sparseArray.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            PbActivity.this.fMn.bhY().setText(e.j.remove_mark);
                        } else {
                            PbActivity.this.fMn.bhY().setText(e.j.mark);
                        }
                        if (booleanValue) {
                            PbActivity.this.fMn.bhY().setVisibility(8);
                        } else {
                            PbActivity.this.fMn.bhY().setVisibility(0);
                        }
                        if (PbActivity.this.bv(view)) {
                            if (PbActivity.this.fME != null && !PbActivity.this.fME.isGif()) {
                                sparseArray.put(e.g.tag_richtext_image, true);
                            } else {
                                sparseArray.put(e.g.tag_richtext_image, false);
                            }
                            sparseArray.put(e.g.tag_richtext_emotion, true);
                        } else {
                            sparseArray.put(e.g.tag_richtext_image, false);
                            sparseArray.put(e.g.tag_richtext_emotion, false);
                        }
                        PbActivity.this.fMn.a(sparseArray, PbActivity.this.fMe.getPbData().beF(), z);
                        PbActivity.this.fMn.refreshUI();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").ax("tid", PbActivity.this.fMe.fRk).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getForumId()).ax("uid", PbActivity.this.fMe.getPbData().bet().yC().getUserId()).ax("post_id", PbActivity.this.fMe.Lo()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, booleanValue ? 2 : 1));
                    }
                } else {
                    PbActivity.this.fMh.a(PbActivity.this.fNq, PbActivity.this.fME.isGif());
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dzq = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            if (!PbActivity.this.fLN && z && !PbActivity.this.fMe.bhu()) {
                PbActivity.this.bgj();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0200e.ds200));
        }
    };
    public View.OnTouchListener bfm = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.crR.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0204a crS = new a.InterfaceC0204a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        final int cDb;

        {
            this.cDb = (int) PbActivity.this.getResources().getDimension(e.C0200e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void ap(int i, int i2) {
            if (ag(i2) && PbActivity.this.fMh != null && PbActivity.this.fLL != null) {
                PbActivity.this.fMh.bjD();
                PbActivity.this.fLL.gM(false);
                PbActivity.this.fLL.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void aq(int i, int i2) {
            if (ag(i2) && PbActivity.this.fMh != null && PbActivity.this.fLL != null) {
                PbActivity.this.fLL.gM(true);
                if (Math.abs(i2) > this.cDb) {
                    PbActivity.this.fLL.hideFloatingView();
                }
                if (PbActivity.this.bgn()) {
                    PbActivity.this.fMh.biW();
                    PbActivity.this.fMh.biX();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void ar(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fNs = null;
    private final m.a fNt = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void j(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(e.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fNs = str2;
                PbActivity.this.fMh.sz(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fNu = -1;
    private int fNv = -1;
    private CustomMessageListener fNy = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.alf == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0146a) {
                    if (aVar.alg != null && !aVar.alg.hasError() && aVar.alg.getError() == 0) {
                        if (PbActivity.this.fMh != null) {
                            PbActivity.this.fMh.n(((a.C0146a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bgy();
                        }
                    } else if (z) {
                        if (aVar.alg != null && aVar.alg.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.alg.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.alg != null && !aVar.alg.hasError() && aVar.alg.getError() == 0) {
                        if (PbActivity.this.fMh != null && PbActivity.this.fMh != null) {
                            PbActivity.this.fMh.n(((a.C0146a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.alg != null && aVar.alg.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.alg.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.alg == null || aVar.alg.hasError() || aVar.alg.getError() != 0) {
                        if (z) {
                            if (aVar.alg != null && aVar.alg.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.alg.getErrorString());
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
        public ArrayList<String> fNY;
        public ConcurrentHashMap<String, ImageUrlData> fNZ;
        public boolean fOb;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fOa = false;
        public boolean fOc = false;
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

    public com.baidu.tbadk.editortools.pb.d bfJ() {
        return this.fMu;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bfa() != null) {
            String id = jVar.bfa().getId();
            ArrayList<PostData> bev = this.fMe.getPbData().bev();
            int i = 0;
            while (true) {
                if (i >= bev.size()) {
                    break;
                }
                PostData postData = bev.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bfe = jVar.bfe();
                    postData.uY(jVar.getTotalCount());
                    if (postData.bBu() != null && bfe != null) {
                        Iterator<PostData> it = bfe.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.yC() != null && (metaData = postData.getUserMap().get(next.yC().getUserId())) != null) {
                                next.a(metaData);
                                next.ns(true);
                                next.a(getPageContext(), this.fMe.st(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bfe.size() != postData.bBu().size();
                        postData.bBu().clear();
                        postData.bBu().addAll(bfe);
                        z = z2;
                    }
                    if (postData.bBq() != null) {
                        postData.bBr();
                    }
                }
            }
            if (!this.fMe.getIsFromMark() && z) {
                this.fMh.n(this.fMe.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(String str) {
        com.baidu.tieba.tbadkCore.data.l beJ;
        if (!TextUtils.isEmpty(str) && (beJ = this.fMe.getPbData().beJ()) != null && str.equals(beJ.getAdId())) {
            if (beJ.bBl() != null) {
                beJ.bBl().legoCard = null;
            }
            this.fMe.getPbData().beK();
        }
    }

    public void bfK() {
        com.baidu.tieba.pb.data.d pbData;
        bb bet;
        if (!this.fMX) {
            if (!com.baidu.adp.lib.util.l.lm()) {
                showToast(e.j.no_network_guide);
            } else if (this.fNa) {
                this.fMX = true;
                if (this.fMe != null && (pbData = this.fMe.getPbData()) != null && (bet = pbData.bet()) != null) {
                    int isLike = bet.yp() == null ? 0 : bet.yp().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10796").ax("tid", bet.getId()));
                    }
                    if (this.fMY != null) {
                        this.fMY.a(bet.yT(), bet.getId(), isLike, "pb");
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
                bVar.cQ(e.j.operation);
                int i = -1;
                if (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(e.j.delete);
                    strArr[1] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fMh.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fMB);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fMB);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fMB);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fMB);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).AE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(int i) {
        bb bet;
        String str;
        String N;
        if (this.fMe != null && this.fMe.getPbData() != null && (bet = this.fMe.getPbData().bet()) != null) {
            if (i == 1) {
                PraiseData yp = bet.yp();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (yp == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bet.a(praiseData);
                    } else {
                        bet.yp().getUser().add(0, metaData);
                        bet.yp().setNum(bet.yp().getNum() + 1);
                        bet.yp().setIsLike(i);
                    }
                }
                if (bet.yp() != null) {
                    if (bet.yp().getNum() < 1) {
                        N = getResources().getString(e.j.zan);
                    } else {
                        N = com.baidu.tbadk.core.util.ao.N(bet.yp().getNum());
                    }
                    this.fMh.U(N, true);
                }
            } else if (bet.yp() != null) {
                bet.yp().setIsLike(i);
                bet.yp().setNum(bet.yp().getNum() - 1);
                ArrayList<MetaData> user = bet.yp().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bet.yp().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bet.yp().getNum() < 1) {
                    str = getResources().getString(e.j.zan);
                } else {
                    str = bet.yp().getNum() + "";
                }
                this.fMh.U(str, false);
            }
            if (this.fMe.bhn()) {
                this.fMh.bja().notifyDataSetChanged();
            } else {
                this.fMh.o(this.fMe.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fMe.D(bundle);
        if (this.dBD != null) {
            this.dBD.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fMu.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fLR = System.currentTimeMillis();
        this.fMz = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dhW = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fLY = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fLY) && intent.getData() != null) {
                this.fLY = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fLY)) {
                this.fLM = true;
            }
            this.fNu = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fNv = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fNw = intent.getStringExtra("key_manga_title");
            this.fMq = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fMr = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bgn()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ao.isEmpty(this.source) ? "" : this.source;
            this.fMI = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dhW = System.currentTimeMillis();
        }
        this.bcn = this.fLR - this.dhW;
        super.onCreate(bundle);
        this.fLP = 0;
        C(bundle);
        if (this.fMe != null && this.fMe.getPbData() != null) {
            this.fMe.getPbData().sj(this.source);
        }
        initUI();
        if (intent != null && this.fMh != null) {
            this.fMh.fUW = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fMC == null) {
                    this.fMC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fMh.sB("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fMC, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fMe != null && this.fMe.getPbData() != null) {
                this.fMe.sw(stringExtra);
            }
        }
        this.dBD = new VoiceManager();
        this.dBD.onCreate(getPageContext());
        initData(bundle);
        this.fMt = new com.baidu.tbadk.editortools.pb.f();
        bfL();
        this.fMu = (com.baidu.tbadk.editortools.pb.d) this.fMt.bJ(getActivity());
        this.fMu.b(this);
        this.fMu.a(this.aWI);
        this.fMu.a(this.aWB);
        this.fMu.a(this, bundle);
        this.fMu.KT().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fMu.KT().cp(true);
        kC(true);
        this.fMh.setEditorTools(this.fMu.KT());
        this.fMu.a(this.fMe.bhw(), this.fMe.bhm(), this.fMe.bhO());
        registerListener(this.fMP);
        if (!this.fMe.bht()) {
            this.fMu.hw(this.fMe.bhm());
        }
        if (this.fMe.bhP()) {
            this.fMu.hu(getPageContext().getString(e.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fMu.hu(getPageContext().getString(e.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fMO);
        registerListener(this.fMQ);
        registerListener(this.fMR);
        registerListener(this.dCM);
        registerListener(this.fNf);
        registerListener(this.fMN);
        this.fMs = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.hdS);
        this.fMs.bAY();
        registerListener(this.fMT);
        registerListener(this.mAttentionListener);
        if (this.fMe != null) {
            this.fMe.bhG();
        }
        registerListener(this.fNi);
        registerListener(this.fNy);
        registerListener(this.dCT);
        if (this.fMh != null && this.fMh.bjH() != null && this.fMh.bjI() != null) {
            this.fLL = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.fMh.bjH(), this.fMh.bjI(), this.fMh.biR());
            this.fLL.a(this.fNb);
        }
        if (this.fLK && this.fMh != null && this.fMh.bjI() != null) {
            this.fMh.bjI().setVisibility(8);
        }
        this.fMA = new com.baidu.tbadk.core.view.g();
        this.fMA.aDC = 1000L;
        registerListener(this.fNe);
        registerListener(this.fNc);
        registerListener(this.fNd);
        registerListener(this.dUb);
        this.fMB = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fMB;
        userMuteAddAndDelCustomMessage.setTag(this.fMB);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fMB;
        userMuteCheckCustomMessage.setTag(this.fMB);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fMe.bhM().a(this.cri);
        this.fMm = new at();
        if (this.fMu.Ls() != null) {
            this.fMm.g(this.fMu.Ls().getInputView());
        }
        this.fMu.a(this.aWC);
        this.dRe = new ShareSuccessReplyToServerModel();
        a(this.fMK);
        this.eYo = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.eYo.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.ayw) {
                        PbActivity.this.fMu.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.ayx && PbActivity.this.fMh != null && PbActivity.this.fMh.biI() != null && PbActivity.this.fMh.biI().bhe() != null) {
                        PbActivity.this.fMh.biI().bhe().LL();
                    } else if (i == com.baidu.tbadk.core.util.aj.ayy) {
                        PbActivity.this.c(PbActivity.this.fMw);
                    }
                }
            }
        });
        this.fMf = new com.baidu.tieba.pb.pb.report.a(this);
        this.fMf.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.fLR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfL() {
        if (this.fMt != null && this.fMe != null) {
            this.fMt.setForumName(this.fMe.bfo());
            if (this.fMe.getPbData() != null && this.fMe.getPbData().ber() != null) {
                this.fMt.a(this.fMe.getPbData().ber());
            }
            this.fMt.setFrom("pb");
            this.fMt.a(this.fMe);
        }
    }

    public String bfM() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bfN() {
        return this.fLL;
    }

    private void kC(boolean z) {
        this.fMu.ct(z);
        this.fMu.cu(z);
        this.fMu.cv(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().beS() && !z && this.fMh != null && this.fMh.getView() != null) {
            this.fMh.getView().setSystemUiVisibility(4);
        }
        this.fMx = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    public ar bfO() {
        return this.fMh;
    }

    public PbModel bfx() {
        return this.fMe;
    }

    public void sm(String str) {
        if (this.fMe != null && !StringUtils.isNull(str) && this.fMh != null) {
            this.fMh.ls(true);
            this.fMe.sm(str);
            this.fLX = true;
            this.fMh.bjt();
            this.fMh.bjC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fLN = false;
        } else {
            this.fLN = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fLP = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fLP == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
        if (this.fMh != null) {
            this.fMh.onPause();
        }
        if (!this.fMe.bht()) {
            this.fMu.hv(this.fMe.bhm());
        }
        if (this.fMe != null) {
            this.fMe.bhH();
        }
        MessageManager.getInstance().unRegisterListener(this.eCl);
        aKn();
        MessageManager.getInstance().unRegisterListener(this.fNc);
        MessageManager.getInstance().unRegisterListener(this.fNd);
        MessageManager.getInstance().unRegisterListener(this.fNe);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bfP() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fMe.getPbData(), this.fMe.bhn(), this.fMe.getRequestType());
        return (a2 == null || a2.yC() == null || a2.yC().getGodUserData() == null || a2.yC().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fLN = false;
        super.onResume();
        if (this.fMa) {
            this.fMa = false;
            bgt();
        }
        if (bfP()) {
            this.fLU = System.currentTimeMillis();
        } else {
            this.fLU = -1L;
        }
        if (this.fMh != null && this.fMh.getView() != null) {
            if (!this.fpn) {
                bgk();
            } else {
                hideLoadingView(this.fMh.getView());
            }
            this.fMh.onResume();
        }
        if (this.fLP == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fMh != null) {
            noNetworkView = this.fMh.biF();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kV()) {
            noNetworkView.bD(false);
        }
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
        registerListener(this.eCl);
        this.fMp = false;
        bgs();
        registerListener(this.fNc);
        registerListener(this.fNd);
        registerListener(this.fNe);
        if (this.dCl) {
            bgj();
            this.dCl = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fMh.lg(z);
        if (this.fMn != null) {
            this.fMn.kV(z);
        }
        if (z && this.fMp) {
            this.fMh.bjf();
            this.fMe.kR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fLU > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").ax("obj_duration", (System.currentTimeMillis() - this.fLU) + ""));
            this.fLU = 0L;
        }
        if (bfO().biI() != null) {
            bfO().biI().onStop();
        }
        if (this.fMh.fVd != null && !this.fMh.fVd.aox()) {
            this.fMh.fVd.aVC();
        }
        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().ber() != null && this.fMe.getPbData().bet() != null) {
            com.baidu.tbadk.distribute.a.KG().a(getPageContext().getPageActivity(), "pb", this.fMe.getPbData().ber().getId(), com.baidu.adp.lib.g.b.d(this.fMe.getPbData().bet().getId(), 0L));
        }
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
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
            amVar.ax(ImageViewerConfig.FORUM_ID, this.fMe.getPbData().getForumId());
            amVar.ax("tid", this.fMe.bhm());
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.fLS && this.fMh != null) {
            this.fLS = true;
            this.fMh.bjy();
            a(false, (PostData) null);
        }
        if (this.fMe != null) {
            this.fMe.cancelLoadData();
            this.fMe.destory();
            if (this.fMe.bhL() != null) {
                this.fMe.bhL().onDestroy();
            }
        }
        if (this.fMu != null) {
            this.fMu.onDestroy();
        }
        if (this.cPb != null) {
            this.cPb.cancelLoadData();
        }
        if (this.fMh != null) {
            this.fMh.onDestroy();
            if (this.fMh.fVd != null) {
                this.fMh.fVd.aVC();
            }
        }
        if (this.fLT != null) {
            this.fLT.NY();
        }
        if (this.fLL != null) {
            this.fLL.OW();
        }
        super.onDestroy();
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
        this.fMh.bjt();
        MessageManager.getInstance().unRegisterListener(this.fNc);
        MessageManager.getInstance().unRegisterListener(this.fNd);
        MessageManager.getInstance().unRegisterListener(this.fNe);
        MessageManager.getInstance().unRegisterListener(this.fMB);
        MessageManager.getInstance().unRegisterListener(this.fNf);
        MessageManager.getInstance().unRegisterListener(this.dCT);
        MessageManager.getInstance().unRegisterListener(this.dUb);
        this.fMz = null;
        this.fMA = null;
        com.baidu.tieba.recapp.d.a.btw().bty();
        if (this.fMC != null) {
            getSafeHandler().removeCallbacks(this.fMC);
        }
        if (this.fMb != null) {
            this.fMb.cancelLoadData();
        }
        if (this.fMh != null && this.fMh.fVd != null) {
            this.fMh.fVd.bku();
        }
        if (this.dRe != null) {
            this.dRe.cancelLoadData();
        }
        this.fMm.onDestroy();
        if (this.dCp != null) {
            this.dCp.onDestroy();
        }
        if (this.fMe != null && this.fMe.bhN() != null) {
            this.fMe.bhN().onDestroy();
        }
        if (this.eYo != null) {
            this.eYo.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bja;
        ArrayList<PostData> bgQ;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.Fp() && this.fMh != null && (bja = this.fMh.bja()) != null && (bgQ = bja.bgQ()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bgQ.iterator();
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
                        bVar.cRa = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aqK == 1 && !TextUtils.isEmpty(id)) {
                    next.aqK = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.cRa = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fMe == null || this.fMe.getPbData() == null || this.fMe.getPbData().ber() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fMe.getPbData().ber().getFirst_class();
                    str2 = this.fMe.getPbData().ber().getSecond_class();
                    str = this.fMe.getPbData().ber().getId();
                    str4 = this.fMe.bhm();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Fs());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fMh.onChangeSkinType(i);
            if (this.fMu != null && this.fMu.KT() != null) {
                this.fMu.KT().onChangeSkinType(i);
            }
            if (this.fMh.biF() != null) {
                this.fMh.biF().onChangeSkinType(getPageContext(), i);
            }
            this.fMm.onChangeSkinType();
            if (this.dCp != null) {
                this.dCp.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fMh = new ar(this, this.dDv, this.boq);
        this.crR = new com.baidu.tieba.f.b(getActivity());
        this.crR.a(fNr);
        this.crR.a(this.crS);
        this.fMh.setOnScrollListener(this.mOnScrollListener);
        this.fMh.e(this.dUB);
        this.fMh.a(this.bAc);
        this.fMh.kw(com.baidu.tbadk.core.i.wA().wE());
        this.fMh.setOnImageClickListener(this.bop);
        this.fMh.b(this.aPP);
        this.fMh.h(this.dzq);
        this.fMh.a(this.fNk);
        this.fMh.lg(this.mIsLogin);
        if (getIntent() != null) {
            this.fMh.lt(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fMh.biH().setFromForumId(this.fMe.getFromForumId());
    }

    public void bfQ() {
        if (this.fMh != null && this.fMe != null) {
            if (this.fMe.getPbData() != null || this.fMe.getPbData().beR() != null) {
                TiebaStatic.log(bfU().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_locate", 4).x(VideoPlayActivityConfig.OBJ_ID, bfx().getPbData().beR().beX() ? 0 : 1));
                if (checkUpIsLogin() && this.fMh.bja() != null && this.fMh.bja().bgV() != null) {
                    this.fMh.bja().bgV().fY(this.fMe.bhm());
                }
            }
        }
    }

    public void bfR() {
        TiebaStatic.log("c12181");
        if (this.fMh != null && this.fMe != null) {
            if (this.fMh == null || this.fMh.biK()) {
                if (this.fMe.getPbData() != null || this.fMe.getPbData().beR() != null) {
                    com.baidu.tieba.pb.data.i beR = this.fMe.getPbData().beR();
                    TiebaStatic.log(bfU().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_locate", 4).x(VideoPlayActivityConfig.OBJ_ID, beR.beX() ? 0 : 1));
                    if (checkUpIsLogin()) {
                        if ((!beR.beX() || beR.zR() != 2) && this.fMh.bja() != null && this.fMh.bja().bgV() != null) {
                            this.fMh.bja().bgV().fY(this.fMe.bhm());
                        }
                        if (System.currentTimeMillis() - this.fLW > SystemScreenshotManager.DELAY_TIME) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).lO(false);
                            this.fLW = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(e.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.heu && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.wA().wE()) {
                    return sp(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fMe == null || this.fMe.getPbData() == null) {
                        return true;
                    }
                    if (bfO().biI() != null) {
                        bfO().biI().bgZ();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.fMe.getPbData().ber());
                    jVar.aa(this.fMe.getPbData().bet());
                    jVar.e(postData);
                    bfO().biH().d(jVar);
                    bfO().biH().setPostId(postData.getId());
                    a(view, postData.yC().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fMu != null) {
                        this.fMh.ln(this.fMu.Lz());
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
        if (this.fMh != null) {
            if (z && !this.fpn) {
                bgk();
            } else {
                hideLoadingView(this.fMh.getView());
            }
            if (z && this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().beS() && this.fMh.getView() != null) {
                this.fMh.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bfS() {
        if (this.fLQ == null) {
            this.fLQ = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fLQ.a(new String[]{getPageContext().getString(e.j.call_phone), getPageContext().getString(e.j.sms_phone), getPageContext().getString(e.j.search_in_baidu)}, new b.InterfaceC0148b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fLF = PbActivity.this.fLF.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fLF);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fMe.bhm(), PbActivity.this.fLF, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fLF = PbActivity.this.fLF.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fLF);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fMe.bhm(), PbActivity.this.fLF, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fLF = PbActivity.this.fLF.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fLF);
                        bVar.dismiss();
                    }
                }
            }).cR(b.a.ato).cS(17).d(getPageContext());
        }
    }

    private void C(Bundle bundle) {
        this.fMe = new PbModel(this);
        this.fMe.a(this.fNh);
        if (this.fMe.bhK() != null) {
            this.fMe.bhK().a(this.fNt);
        }
        if (this.fMe.bhJ() != null) {
            this.fMe.bhJ().a(this.fMS);
        }
        if (this.fMe.bhL() != null) {
            this.fMe.bhL().b(this.fMM);
        }
        if (bundle != null) {
            this.fMe.initWithBundle(bundle);
        } else {
            this.fMe.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fMe.kU(true);
        }
        aj.biu().T(this.fMe.bhl(), this.fMe.getIsFromMark());
        if (StringUtils.isNull(this.fMe.bhm())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fLY) && this.fLY != null) {
            this.fMe.sa(6);
        }
        this.fMe.Ns();
    }

    private void initData(Bundle bundle) {
        this.fMg = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fMg != null) {
            this.fMg.a(this.fNj);
        }
        this.cPb = new ForumManageModel(this);
        this.cPb.setLoadDataCallBack(this.cPf);
        this.ayB = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fMh.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    PbActivity.this.showToast(e.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fMe.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fMe.getPbData().ber().getId(), PbActivity.this.fMe.getPbData().ber().getName(), PbActivity.this.fMe.getPbData().bet().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fMY.setUniqueId(getUniqueId());
        this.fMY.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fMh.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(e.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fMB;
        userMuteCheckCustomMessage.setTag(this.fMB);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bfT() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fMe != null && (pbData = this.fMe.getPbData()) != null) {
            return pbData.beE().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bet() != null) {
            if (dVar.bet().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bet().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bet().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData bt(View view) {
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

    public com.baidu.tbadk.core.util.am bfU() {
        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12003");
        amVar.ax("tid", this.fMe.fRk);
        amVar.x("obj_type", 0);
        amVar.ax(ImageViewerConfig.FORUM_ID, this.fMe.getForumId());
        amVar.x("obj_param1", this.fMe.getPbData().bet().getThreadType() == 40 ? 2 : 1);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.ax("obj_param2", TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && bfV()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                @Override // java.lang.Runnable
                public void run() {
                    int h;
                    int aQ = (com.baidu.adp.lib.util.l.aQ(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        h = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0200e.ds120);
                    } else {
                        h = com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0200e.ds640);
                    }
                    int i = h - aQ;
                    if (i > 0) {
                        PbActivity.this.bfO().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bfO().biI() != null) {
                        PbActivity.this.fMu.KT().setVisibility(8);
                        PbActivity.this.bfO().biI().ci(str, str2);
                        com.baidu.tbadk.editortools.pb.g bhe = PbActivity.this.bfO().biI().bhe();
                        if (bhe != null && PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null) {
                            bhe.a(PbActivity.this.fMe.getPbData().xA());
                        }
                        if (PbActivity.this.fMm.bjW() == null && PbActivity.this.bfO().biI().bhe().LT() != null) {
                            PbActivity.this.bfO().biI().bhe().LT().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fMm != null && PbActivity.this.fMm.bjV() != null) {
                                        if (!PbActivity.this.fMm.bjV().bKS()) {
                                            PbActivity.this.fMm.lv(false);
                                        }
                                        PbActivity.this.fMm.bjV().op(false);
                                    }
                                }
                            });
                            PbActivity.this.fMm.h(PbActivity.this.bfO().biI().bhe().LT().getInputView());
                            PbActivity.this.bfO().biI().bhe().a(PbActivity.this.fMy);
                        }
                    }
                    PbActivity.this.bfO().bjC();
                }
            }, 500L);
        }
    }

    public boolean bfV() {
        if (this.eYo == null || this.fMe.getPbData() == null || this.fMe.getPbData().xA() == null) {
            return true;
        }
        return this.eYo.dw(this.fMe.getPbData().xA().replyPrivateFlag);
    }

    public boolean rJ(int i) {
        if (this.eYo == null || this.fMe.getPbData() == null || this.fMe.getPbData().xA() == null) {
            return true;
        }
        return this.eYo.w(this.fMe.getPbData().xA().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(e.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null && this.fMe != null && this.fMe.getPbData() != null && postData.bBx() != 1) {
            String bhm = this.fMe.bhm();
            String id = postData.getId();
            int beF = this.fMe.getPbData() != null ? this.fMe.getPbData().beF() : 0;
            c sq = sq(id);
            if (sq != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bhm, id, "pb", true, null, false, null, beF, postData.blf(), this.fMe.getPbData().xA(), false, postData.yC() != null ? postData.yC().getIconInfo() : null).addBigImageData(sq.fNY, sq.fNZ, sq.fOa, sq.index);
                addBigImageData.setKeyPageStartFrom(this.fMe.bhR());
                addBigImageData.setFromFrsForumId(this.fMe.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bfW() {
        if (this.fMe.getPbData() == null || this.fMe.getPbData().bet() == null) {
            return -1;
        }
        return this.fMe.getPbData().bet().zg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfX() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.uw(this.fMe.getForumId()) && this.fMe.getPbData() != null && this.fMe.getPbData().ber() != null) {
            if (this.fMe.getPbData().ber().isLike() == 1) {
                this.fMe.bhN().cz(this.fMe.getForumId(), this.fMe.bhm());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kD(boolean z) {
        if (this.fMe == null || this.fMe.getPbData() == null) {
            return false;
        }
        return ((this.fMe.getPbData().beF() != 0) || this.fMe.getPbData().bet() == null || this.fMe.getPbData().bet().yC() == null || TextUtils.equals(this.fMe.getPbData().bet().yC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bfY() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.p.u.Oy()) {
            return "";
        }
        PostData beA = beA();
        if (this.fMe == null || (pbData = this.fMe.getPbData()) == null || pbData.getUserData() == null || pbData.bet() == null || beA == null || beA.yC() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !beA.yC().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bet().yk() == 0) {
            return "";
        }
        if (pbData.bet().yk() == 0) {
            return getPageContext().getString(e.j.fans_call);
        }
        return getPageContext().getString(e.j.haved_fans_call);
    }

    private boolean kE(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fMe == null || this.fMe.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fMe.getPbData();
        if (pbData.beF() == 0) {
            List<com.baidu.tbadk.core.data.ay> beP = pbData.beP();
            if (com.baidu.tbadk.core.util.v.H(beP) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : beP) {
                    if (ayVar != null && (tVar = ayVar.apA) != null && tVar.anz && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean kF(boolean z) {
        return (z || this.fMe == null || this.fMe.getPbData() == null || this.fMe.getPbData().beF() == 0) ? false : true;
    }

    public void bfZ() {
        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null && this.fMe.getPbData().bet().yC() != null) {
            if (this.fMh != null) {
                this.fMh.biG();
            }
            bb bet = this.fMe.getPbData().bet();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bet.yC().getUserId());
            ab abVar = new ab();
            int beF = this.fMe.getPbData().beF();
            if (beF == 1) {
                abVar.fTm = true;
                abVar.fTl = true;
                abVar.fTt = bet.yx() == 1;
                abVar.fTs = bet.yy() == 1;
            } else {
                abVar.fTm = false;
                abVar.fTl = false;
            }
            if (beF == 1002 && !equals) {
                abVar.fTx = true;
            }
            abVar.fTj = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.fTn = kE(equals);
            abVar.fTo = bga();
            abVar.fTp = kF(equals);
            abVar.qZ = this.fMe.bhn();
            abVar.fTk = true;
            abVar.fKc = this.fMg != null && this.fMg.vm();
            abVar.fTi = kD(equals);
            abVar.fTv = bfY();
            abVar.fTh = equals && this.fMh.bjm();
            abVar.fTq = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fTr = true;
            abVar.isHostOnly = this.fMe.getHostMode();
            abVar.fTu = true;
            if (bet.yU() == null) {
                abVar.fTw = true;
            } else {
                abVar.fTw = false;
            }
            this.fMh.fVd.a(abVar);
        }
    }

    private boolean bga() {
        if (this.fMe != null && this.fMe.bhn()) {
            return this.fMe.getPageData() == null || this.fMe.getPageData().xM() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(View view) {
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

    public int bgb() {
        if (bfO() == null || bfO().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bfO().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fJP) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bgc() {
        if (bfO() == null || bfO().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bfO().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.het) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bgj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.ei(getResources().getString(e.j.mark_done));
            aVar.bl(true);
            aVar.ej(getResources().getString(e.j.mark_like));
            aVar.bk(true);
            aVar.be(false);
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
                    PbActivity.this.ayB.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fMe.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).AB();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fMh.bjg();
        this.fMe.kT(z);
        if (this.fMg != null) {
            this.fMg.aO(z);
            if (markData != null) {
                this.fMg.a(markData);
            }
        }
        if (this.fMe.vm()) {
            bgh();
        } else {
            this.fMh.n(this.fMe.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rH(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(String str) {
        this.fMf.sK(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fMe.bht()) {
                    antiData.setBlock_forum_name(this.fMe.getPbData().ber().getName());
                    antiData.setBlock_forum_id(this.fMe.getPbData().ber().getId());
                    antiData.setUser_name(this.fMe.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fMe.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else if (bfO() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.ai(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.azl));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.azl));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.azl));
            }
        } else if (i == 230277) {
            hC(str);
        } else {
            this.fMh.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.hgO) ? bVar.hgO : getString(e.j.delete_fail);
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
                aVar.be(true);
                aVar.b(getPageContext());
                aVar.AB();
            } else {
                this.fMh.a(0, bVar.HZ, bVar.hgO, z);
            }
            if (bVar.HZ) {
                if (bVar.hgM == 1) {
                    ArrayList<PostData> bev = this.fMe.getPbData().bev();
                    int size = bev.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bev.get(i).getId())) {
                            i++;
                        } else {
                            bev.remove(i);
                            break;
                        }
                    }
                    this.fMh.n(this.fMe.getPbData());
                } else if (bVar.hgM == 0) {
                    bgd();
                } else if (bVar.hgM == 2) {
                    ArrayList<PostData> bev2 = this.fMe.getPbData().bev();
                    int size2 = bev2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bev2.get(i2).bBu().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bev2.get(i2).bBu().get(i3).getId())) {
                                i3++;
                            } else {
                                bev2.get(i2).bBu().remove(i3);
                                bev2.get(i2).bBw();
                                z2 = true;
                                break;
                            }
                        }
                        bev2.get(i2).vc(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fMh.n(this.fMe.getPbData());
                    }
                    a(bVar, this.fMh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fMh.a(this.cPb.getLoadDataMode(), gVar.HZ, gVar.hgO, false);
            if (gVar.HZ) {
                this.fMj = true;
                if (i == 2 || i == 3) {
                    this.fMk = true;
                    this.fMl = false;
                } else if (i == 4 || i == 5) {
                    this.fMk = false;
                    this.fMl = true;
                }
                if (i == 2) {
                    this.fMe.getPbData().bet().cE(1);
                    this.fMe.setIsGood(1);
                } else if (i == 3) {
                    this.fMe.getPbData().bet().cE(0);
                    this.fMe.setIsGood(0);
                } else if (i == 4) {
                    this.fMe.getPbData().bet().cD(1);
                    this.fMe.ky(1);
                } else if (i == 5) {
                    this.fMe.getPbData().bet().cD(0);
                    this.fMe.ky(0);
                }
                this.fMh.c(this.fMe.getPbData(), this.fMe.bhn());
            }
        }
    }

    private void bgd() {
        if (this.fMe.bho() || this.fMe.bhq()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fMe.bhm());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fMe.bhm()));
        if (bgi()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bge() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData beC;
        boolean z = false;
        if (this.fMh != null) {
            this.fMh.bjt();
        }
        if (this.fMe != null && this.fMe.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.fMe.getPbData().bet().getId();
            if (this.fMe.isShareThread() && this.fMe.getPbData().bet().arT != null) {
                historyMessage.threadName = this.fMe.getPbData().bet().arT.showText;
            } else {
                historyMessage.threadName = this.fMe.getPbData().bet().getTitle();
            }
            if (this.fMe.isShareThread() && !bfn()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fMe.getPbData().ber().getName();
            }
            ArrayList<PostData> bev = this.fMe.getPbData().bev();
            int bji = this.fMh != null ? this.fMh.bji() : 0;
            if (bev != null && bji >= 0 && bji < bev.size()) {
                historyMessage.postID = bev.get(bji).getId();
            }
            historyMessage.isHostOnly = this.fMe.getHostMode();
            historyMessage.isSquence = this.fMe.bhn();
            historyMessage.isShareThread = this.fMe.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fMu != null) {
            this.fMu.onDestroy();
        }
        if (this.fLO && bfO() != null) {
            bfO().bjM();
        }
        if (this.fMe != null && (this.fMe.bho() || this.fMe.bhq())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fMe.bhm());
            if (this.fMj) {
                if (this.fMl) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fMe.bhs());
                }
                if (this.fMk) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fMe.getIsGood());
                }
            }
            if (this.fMe.getPbData() != null && System.currentTimeMillis() - this.fLR >= 40000 && (beC = this.fMe.getPbData().beC()) != null && !com.baidu.tbadk.core.util.v.I(beC.getDataList())) {
                intent.putExtra("guess_like_data", beC);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fMI);
            }
            setResult(-1, intent);
        }
        if (bgi()) {
            if (this.fMe != null && this.fMh != null && this.fMh.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fMe.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bez() && !this.fLX) {
                        aj biu = aj.biu();
                        com.baidu.tieba.pb.data.d pbData2 = this.fMe.getPbData();
                        Parcelable onSaveInstanceState = this.fMh.getListView().onSaveInstanceState();
                        boolean bhn = this.fMe.bhn();
                        boolean hostMode = this.fMe.getHostMode();
                        if (this.fMh.biR() != null && this.fMh.biR().getVisibility() == 0) {
                            z = true;
                        }
                        biu.a(pbData2, onSaveInstanceState, bhn, hostMode, z);
                        if (this.fMH >= 0 || this.fMe.bhT() != null) {
                            aj.biu().j(this.fMe.bhT());
                            aj.biu().i(this.fMe.bhU());
                            aj.biu().sc(this.fMe.bhV());
                        }
                    }
                }
            } else {
                aj.biu().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fMh == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fMh.sg(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fMh.biG();
            this.fMh.biI().bgZ();
            this.fMh.lp(false);
        }
        this.fMh.biJ();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fMu.resetData();
                        this.fMu.b(writeData);
                        this.fMu.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k fw = this.fMu.KT().fw(6);
                        if (fw != null && fw.aUL != null) {
                            fw.aUL.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fMu.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fMh.biI() != null && this.fMh.biI().bhe() != null) {
                            com.baidu.tbadk.editortools.pb.g bhe = this.fMh.biI().bhe();
                            bhe.b(writeData);
                            bhe.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k fw2 = bhe.KT().fw(6);
                            if (fw2 != null && fw2.aUL != null) {
                                fw2.aUL.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bhe.LL();
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
        this.fMu.onActivityResult(i, i2, intent);
        if (this.fMb != null) {
            this.fMb.onActivityResult(i, i2, intent);
        }
        if (bfO().biI() != null) {
            bfO().biI().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bgg();
                    return;
                case 13008:
                    aj.biu().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fMe != null) {
                                PbActivity.this.fMe.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bso().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fMe != null) {
                        a(bgf(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bso().x(getPageContext());
                        bfX();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dRe != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dRe.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void HU() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55.1
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
                    this.fMh.kB(false);
                    if (this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null && this.fMe.getPbData().bet().yX() != null) {
                        this.fMe.getPbData().bet().yX().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fMw = emotionImageData;
                        if (rJ(com.baidu.tbadk.core.util.aj.ayy)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fMh != null && this.fMh.fVd != null) {
                        this.fMh.fVd.dismissPopMenu();
                        this.fMh.fVd.bko();
                        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null) {
                            this.fMe.getPbData().bet().cz(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fMc != null) {
                        this.fMh.bD(this.fMc);
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
            if (this.fMb == null) {
                this.fMb = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fMb.b(this.aWB);
                this.fMb.c(this.aWI);
            }
            this.fMb.a(emotionImageData, bfx(), bfx().getPbData());
        }
    }

    private ShareFromPBMsgData bgf() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] cL = this.fMe.getPbData().cL(getPageContext().getPageActivity());
        PostData biL = this.fMh.biL();
        String str = "";
        if (biL != null) {
            str = biL.getId();
            String cW = biL.cW(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(cW)) {
                cL[1] = cW;
            }
        }
        String yT = this.fMe.getPbData().bet().yT();
        if (yT != null && yT.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(cL[1]);
        shareFromPBMsgData.setImageUrl(cL[0]);
        shareFromPBMsgData.setForumName(this.fMe.getPbData().ber().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fMe.getPbData().bet().getId());
        shareFromPBMsgData.setTitle(this.fMe.getPbData().bet().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bgf(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cP(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null) {
                        com.baidu.tbadk.core.util.am ax = new com.baidu.tbadk.core.util.am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_param1", 3).ax(ImageViewerConfig.FORUM_ID, PbActivity.this.fMe.getForumId()).ax("tid", PbActivity.this.fMe.bhm());
                        if (PbActivity.this.e(PbActivity.this.fMe.getPbData()) != 0) {
                            ax.x("obj_type", PbActivity.this.e(PbActivity.this.fMe.getPbData()));
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
            aVar.bf(true);
            aVar.b(getPageContext()).AB();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.L(shareFromPBMsgData.getImageUrl(), this.fMe.getPbData().beG() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cP(1);
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
            aVar.bf(true);
            aVar.b(getPageContext()).AB();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.L(shareFromPBMsgData.getImageUrl(), this.fMe.getPbData().beG() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgg() {
        MarkData rZ;
        if (this.fMg != null && (rZ = this.fMe.rZ(this.fMh.bjj())) != null) {
            if (!rZ.isApp() || (rZ = this.fMe.rZ(this.fMh.bjj() + 1)) != null) {
                this.fMh.bje();
                this.fMg.a(rZ);
                if (!this.fMg.vm()) {
                    this.fMg.vo();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fMg.vn();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgh() {
        com.baidu.tieba.pb.data.d pbData = this.fMe.getPbData();
        this.fMe.kT(true);
        if (this.fMg != null) {
            pbData.si(this.fMg.vl());
        }
        this.fMh.n(pbData);
    }

    private boolean bgi() {
        if (this.fMe == null) {
            return true;
        }
        if (this.fMe.vm()) {
            final MarkData bhB = this.fMe.bhB();
            if (bhB == null || !this.fMe.getIsFromMark()) {
                return true;
            }
            final MarkData rZ = this.fMe.rZ(this.fMh.bji());
            if (rZ == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bhB);
                setResult(-1, intent);
                return true;
            } else if (rZ.getPostId() == null || rZ.getPostId().equals(bhB.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bhB);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ej(getPageContext().getString(e.j.alert_update_mark));
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fMg != null) {
                            if (PbActivity.this.fMg.vm()) {
                                PbActivity.this.fMg.vn();
                                PbActivity.this.fMg.aO(false);
                            }
                            PbActivity.this.fMg.a(rZ);
                            PbActivity.this.fMg.aO(true);
                            PbActivity.this.fMg.vo();
                        }
                        bhB.setPostId(rZ.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bhB);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bge();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bhB);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bge();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fMh != null && PbActivity.this.fMh.getView() != null) {
                            PbActivity.this.fMh.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bhB);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bge();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.AB();
                return false;
            }
        } else if (this.fMe.getPbData() == null || this.fMe.getPbData().bev() == null || this.fMe.getPbData().bev().size() <= 0 || !this.fMe.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fMh == null) {
            return null;
        }
        return this.fMh.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RA() {
        if (this.fMh == null) {
            return 0;
        }
        return this.fMh.bjr();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RB() {
        if (this.bog == null) {
            this.bog = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: akN */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean wE = com.baidu.tbadk.core.i.wA().wE();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(e.d.common_color_10220));
                    if (wE) {
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
                        if (com.baidu.tbadk.core.i.wA().wE()) {
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
        return this.bog;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RC() {
        if (this.boh == null) {
            this.boh = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.boh;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RD() {
        if (this.bol == null) {
            this.bol = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgC */
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
                    gifView.Mn();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bol;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RE() {
        if (this.boi == null) {
            this.boi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgD */
                public View jz() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0200e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: by */
                public View v(View view) {
                    ((PlayVoiceBntNew) view).bCH();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bz */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.boi;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RG() {
        this.bok = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bgE */
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
        return this.bok;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Er() {
        if (this.aHn == null) {
            this.aHn = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aHn;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ak(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fLV = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (aw.sC(str) && this.fMe != null && this.fMe.bhm() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").x("obj_param1", 1).ax("post_id", this.fMe.bhm()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                iVar.mLink = str;
                iVar.type = 3;
                iVar.aTP = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
            }
        } else {
            aw.bjY().c(getPageContext(), str);
        }
        this.fLV = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
        aw.bjY().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fLV = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Rect rect) {
        if (rect != null && this.fMh != null && this.fMh.bjH() != null && rect.top <= this.fMh.bjH().getHeight()) {
            rect.top += this.fMh.bjH().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fMe.getPbData();
            TbRichText aK = aK(str, i);
            if (aK != null && (tbRichTextData = aK.QT().get(this.fNm)) != null) {
                cVar.fNY = new ArrayList<>();
                cVar.fNZ = new ConcurrentHashMap<>();
                if (!tbRichTextData.QZ().Rl()) {
                    cVar.fOb = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fNY.add(b2);
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
                    imageUrlData.mIsReserver = this.fMe.bhz();
                    imageUrlData.mIsSeeHost = this.fMe.getHostMode();
                    cVar.fNZ.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.ber() != null) {
                            cVar.forumName = pbData.ber().getName();
                            cVar.forumId = pbData.ber().getId();
                        }
                        if (pbData.bet() != null) {
                            cVar.threadId = pbData.bet().getId();
                        }
                        cVar.fOa = pbData.beG() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.fOb = true;
                int size = pbData.bev().size();
                this.fNn = false;
                cVar.index = -1;
                if (pbData.beA() != null) {
                    PostData beA = pbData.beA();
                    TbRichText bBz = beA.bBz();
                    if (!aq.k(beA)) {
                        i2 = a(bBz, aK, i, i, cVar.fNY, cVar.fNZ);
                    } else {
                        i2 = a(beA, i, cVar.fNY, cVar.fNZ);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bev().get(i4);
                    if (postData.getId() == null || pbData.beA() == null || pbData.beA().getId() == null || !postData.getId().equals(pbData.beA().getId())) {
                        TbRichText bBz2 = postData.bBz();
                        if (!aq.k(postData)) {
                            i3 = a(bBz2, aK, i3, i, cVar.fNY, cVar.fNZ);
                        } else {
                            i3 = a(postData, i3, cVar.fNY, cVar.fNZ);
                        }
                    }
                }
                if (cVar.fNY.size() > 0) {
                    cVar.lastId = cVar.fNY.get(cVar.fNY.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.ber() != null) {
                        cVar.forumName = pbData.ber().getName();
                        cVar.forumId = pbData.ber().getId();
                    }
                    if (pbData.bet() != null) {
                        cVar.threadId = pbData.bet().getId();
                    }
                    cVar.fOa = pbData.beG() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QZ() == null) {
            return null;
        }
        return tbRichTextData.QZ().Rr();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QZ() == null) {
            return 0L;
        }
        return tbRichTextData.QZ().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QZ() == null) {
            return false;
        }
        return tbRichTextData.QZ().Rs();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.QZ() == null) {
            return false;
        }
        return tbRichTextData.QZ().Rt();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo QZ;
        String str;
        if (tbRichText == tbRichText2) {
            this.fNn = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.QT().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.QT().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.QZ().getWidth() * aR;
                    int height = aR * tbRichTextData.QZ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.QZ().Rl()) {
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
                            if (tbRichTextData != null && (QZ = tbRichTextData.QZ()) != null) {
                                String Ro = QZ.Ro();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = QZ.Rp();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Ro;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fMe.bhm(), -1L);
                                imageUrlData.mIsReserver = this.fMe.bhz();
                                imageUrlData.mIsSeeHost = this.fMe.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fNn) {
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
        com.baidu.tieba.tbadkCore.data.h bBG;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bBc;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bBc = (bBG = postData.bBG()).bBc()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bBc.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bBc.get(i3);
                if (jVar != null) {
                    String bBg = jVar.bBg();
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(bBg)) {
                        arrayList.add(bBg);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bBg;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bBf();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fMe.bhm(), -1L);
                        imageUrlData.mIsReserver = this.fMe.bhz();
                        imageUrlData.mIsSeeHost = this.fMe.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bBG.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bBg, imageUrlData);
                        }
                        if (!this.fNn) {
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
            if (postData.getId() != null && postData.getId().equals(this.fMe.yM())) {
                z = true;
            }
            MarkData h = this.fMe.h(postData);
            if (h != null) {
                this.fMh.bje();
                if (this.fMg != null) {
                    this.fMg.a(h);
                    if (!z) {
                        this.fMg.vo();
                    } else {
                        this.fMg.vn();
                    }
                }
            }
        }
    }

    public boolean bv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aK(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fMe == null || this.fMe.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fMe.getPbData();
        if (pbData.beA() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.beA());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bev = pbData.bev();
            a(pbData, bev);
            return a(bev, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.beE() != null && dVar.beE().fKe != null && (list = dVar.beE().fKe) != null && arrayList != null) {
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

    private long so(String str) {
        ArrayList<PostData> bev;
        com.baidu.tieba.pb.data.d pbData = this.fMe.getPbData();
        if (pbData != null && (bev = pbData.bev()) != null && !bev.isEmpty()) {
            Iterator<PostData> it = bev.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bBG = next.bBG();
                if (bBG != null && bBG.hea) {
                    Iterator<TbRichTextData> it2 = next.bBz().QT().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Ri().getLink().equals(str)) {
                            return bBG.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> QT;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bBz = arrayList.get(i2).bBz();
            if (bBz != null && (QT = bBz.QT()) != null) {
                int size = QT.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (QT.get(i4) != null && QT.get(i4).getType() == 8) {
                        i3++;
                        if (QT.get(i4).QZ().Ro().equals(str) || QT.get(i4).QZ().Rp().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = QT.get(i4).QZ().getWidth() * aR;
                            int height = QT.get(i4).QZ().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fNm = i4;
                            return bBz;
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
            this.fLF = str;
            if (this.fLQ == null) {
                bfS();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fLQ.cV(1).setVisibility(8);
            } else {
                this.fLQ.cV(1).setVisibility(0);
            }
            this.fLQ.AE();
            this.fLV = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgj() {
        hideNetRefreshView(this.fMh.getView());
        bgk();
        if (this.fMe.Ns()) {
            this.fMh.bje();
        }
    }

    private void bgk() {
        showLoadingView(this.fMh.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds400));
        View MF = getLoadingView().MF();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MF.getLayoutParams();
        layoutParams.addRule(3, this.fMh.bjH().getId());
        MF.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azn() {
        if (this.dBD != null) {
            this.dBD.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL(int i) {
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
    public void rM(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fMe.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fMe.getPbData();
            pbData.ber().getName();
            String title = pbData.bet().getTitle();
            int i2 = this.fMe.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.ber() != null) {
                if ((pbData.ber().isLike() == 1) && AddExperiencedModel.uw(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fMe.bhm() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] cL = pbData.cL(getPageContext().getPageActivity());
                    str = cL[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = cL[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bfW() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").ax(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ax("tid", pbData.getThreadId()).ax("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aOz = true;
                    dVar.aOE = z;
                    dVar.extData = this.fMe.bhm();
                    dVar.aON = 3;
                    dVar.aOM = i;
                    dVar.fid = this.fMe.getForumId();
                    dVar.tid = this.fMe.bhm();
                    dVar.aOO = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fMe.getPbData().bet());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aON);
                    bundle.putInt("obj_type", dVar.aOO);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.i(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().beS()) {
                                PbActivity.this.fMh.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.apC().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fMe.bhm() + "?share=9105&fr=share&see_lz=" + i2;
            String[] cL2 = pbData.cL(getPageContext().getPageActivity());
            str = cL2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = cL2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bfW() == 1) {
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aOz = true;
            dVar2.aOE = z;
            dVar2.extData = this.fMe.bhm();
            dVar2.aON = 3;
            dVar2.aOM = i;
            dVar2.fid = this.fMe.getForumId();
            dVar2.tid = this.fMe.bhm();
            dVar2.aOO = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fMe.getPbData().bet());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aON);
            bundle2.putInt("obj_type", dVar2.aOO);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.i(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fMe != null && PbActivity.this.fMe.getPbData() != null && PbActivity.this.fMe.getPbData().beS()) {
                        PbActivity.this.fMh.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.apC().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bet() != null) {
            if (dVar.bet().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bet().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgl() {
        com.baidu.tbadk.util.x.a(new com.baidu.tbadk.util.w<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.ux(PbActivity.this.fMe.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fMh.bjN();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RF() {
        if (this.boj == null) {
            this.boj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bgF */
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
        return this.boj;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fMh.biZ() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).ax(ImageViewerConfig.FORUM_ID, this.fMe.getPbData().getForumId()));
            } else {
                bb bet = this.fMe.getPbData().bet();
                if (view != null) {
                    boolean z = bet.yp() == null || bet.yp().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fMZ > 1000) {
                            this.fNa = true;
                            bw(view);
                        } else {
                            this.fNa = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.fNa);
                        } else {
                            j(view, this.fNa);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.fNa);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.fNa);
                    }
                }
            }
        }
        return false;
    }

    private void j(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fMZ = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fMZ = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bw(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void azo() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData ayn() {
        if (this.fMe == null || this.fMe.getPbData() == null) {
            return null;
        }
        return this.fMe.getPbData().xA();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.AD() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.AD();
            int intValue = ((Integer) sparseArray.get(ar.fWQ)).intValue();
            if (intValue == ar.fWR) {
                if (!this.cPb.bCi()) {
                    this.fMh.bjb();
                    String str = (String) sparseArray.get(e.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.cPb.vi(com.baidu.tbadk.core.util.ao.i(jSONArray));
                    }
                    this.cPb.a(this.fMe.getPbData().ber().getId(), this.fMe.getPbData().ber().getName(), this.fMe.getPbData().bet().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == ar.fWS || intValue == ar.fWU) {
                if (this.fMe.bhK() != null) {
                    this.fMe.bhK().rP(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.fWS) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fMB);
        userMuteAddAndDelCustomMessage.setTag(this.fMB);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean sp(String str) {
        if (!StringUtils.isNull(str) && ba.bG(getPageContext().getPageActivity())) {
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

    public void kG(boolean z) {
        this.fMp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bgm() {
        ArrayList<PostData> bev;
        int H;
        if (this.fMe == null || this.fMe.getPbData() == null || this.fMe.getPbData().bev() == null || (H = com.baidu.tbadk.core.util.v.H((bev = this.fMe.getPbData().bev()))) == 0) {
            return "";
        }
        if (this.fMe.bhz()) {
            Iterator<PostData> it = bev.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bBx() == 1) {
                    return next.getId();
                }
            }
        }
        int bji = this.fMh.bji();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bev, bji);
        if (postData == null || postData.yC() == null) {
            return "";
        }
        if (this.fMe.st(postData.yC().getUserId())) {
            return postData.getId();
        }
        for (int i = bji - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(bev, i);
            if (postData2 == null || postData2.yC() == null || postData2.yC().getUserId() == null) {
                break;
            } else if (this.fMe.st(postData2.yC().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bji + 1; i2 < H; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(bev, i2);
            if (postData3 == null || postData3.yC() == null || postData3.yC().getUserId() == null) {
                return "";
            }
            if (this.fMe.st(postData3.yC().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ay.Db().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(so(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fMe.getPbData().ber().getId(), this.fMe.getPbData().ber().getName(), this.fMe.getPbData().bet().getTid());
            }
            this.fLV = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fMe.bhJ() != null) {
                    PbActivity.this.fMe.bhJ().cM(j);
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
        aVar.bf(false);
        aVar.b(getPageContext());
        aVar.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c sq(String str) {
        String str2;
        if (this.fMe.getPbData() == null || this.fMe.getPbData().bev() == null || this.fMe.getPbData().bev().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fMe.getPbData().bev().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fMe.getPbData().bev().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fMe.getPbData().bev().get(i);
        if (postData.bBz() == null || postData.bBz().QT() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bBz().QT().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.QZ() != null) {
                    str2 = next.QZ().Ro();
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
        if (this.fLM) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fLM = false;
        } else if (bgn()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fLM) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fLM = false;
        } else if (bgn()) {
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
        if (pageStayDurationItem != null && this.fMe != null) {
            if (this.fMe.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.fMe.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.fMe.bhm(), 0L));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bgn() {
        return (!this.fLK && this.fNu == -1 && this.fNv == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fNx = mVar;
            this.fLK = true;
            this.fMh.biS();
            this.fMh.sA(this.fNw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgo() {
        if (this.fNx != null) {
            if (this.fNu == -1) {
                showToast(e.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bF(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fNx.getCartoonId(), this.fNu, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        if (this.fNx != null) {
            if (this.fNv == -1) {
                showToast(e.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bF(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fNx.getCartoonId(), this.fNv, 0)));
                finish();
            }
        }
    }

    public int bgq() {
        return this.fNu;
    }

    public int bgr() {
        return this.fNv;
    }

    private void aKn() {
        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null && this.fMe.getPbData().bet().zq()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bgs() {
        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null && this.fMe.getPbData().bet().zq()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bgt() {
        if (this.fLN) {
            this.fMa = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null && this.fMe.getPbData().bet().yj() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fMe.getPbData().bet().yj().getThreadId(), this.fMe.getPbData().bet().yj().getTaskId(), this.fMe.getPbData().bet().yj().getForumId(), this.fMe.getPbData().bet().yj().getForumName(), this.fMe.getPbData().bet().yx(), this.fMe.getPbData().bet().yy())));
            this.fLM = true;
            finish();
        }
    }

    public String bgu() {
        return this.fLY;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bgv() {
        return this.fMd;
    }

    public void kH(boolean z) {
        this.fLZ = z;
    }

    public boolean bgw() {
        if (this.fMe != null) {
            return this.fMe.bho();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ej(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fMz).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fMz.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fMz).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fMz != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMz.getPageActivity());
            aVar.ej(str);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fMz).AB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fMh.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMz.getPageActivity());
        if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            aVar.ej(this.fMz.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.ej(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fMh.showLoadingDialog();
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
        aVar.b(this.fMz).AB();
    }

    public void bgy() {
        if (this.fMe != null && this.fMe.getPbData() != null && this.fMe.getPbData().bet() != null && this.fMe.getPbData().bet().zF() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cN(e.j.channel_open_push_message);
            aVar.a(e.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fMe.getPbData().bet().zF().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.AB();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (aw.sC(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_wenxue)) != null) {
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
        if (this.fMh != null) {
            this.fMh.onConfigurationChanged(configuration);
        }
        if (this.fMn != null) {
            this.fMn.dismiss();
        }
    }

    public boolean bgz() {
        if (this.fMe != null) {
            return this.fMe.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.fMe.getPbData().beE().fKe;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bBu().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bBu().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bBu().remove(i2);
                    list.get(i).bBw();
                    z = true;
                    break;
                }
            }
            list.get(i).vc(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.n(this.fMe.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bfa().getId();
        List<PostData> list = this.fMe.getPbData().beE().fKe;
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
                ArrayList<PostData> bfe = jVar.bfe();
                postData.uY(jVar.getTotalCount());
                if (postData.bBu() != null) {
                    postData.bBu().clear();
                    postData.bBu().addAll(bfe);
                }
            }
        }
        if (!this.fMe.getIsFromMark()) {
            this.fMh.n(this.fMe.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bfm() {
        return this.fMi;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bfn() {
        if (this.fMe == null) {
            return false;
        }
        return this.fMe.bfn();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bfo() {
        if (this.fMe != null) {
            return this.fMe.bfo();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bfp() {
        if (this.fMe == null || this.fMe.getPbData() == null) {
            return 0;
        }
        return this.fMe.getPbData().beF();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean sk(String str) {
        return this.fMe != null && this.fMe.st(str);
    }

    public void bgA() {
        if (this.fMh != null) {
            this.fMh.biG();
            azo();
        }
    }

    public PostData beA() {
        return this.fMh.b(this.fMe.fRE, this.fMe.bhn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.isLinkThread()) {
                return 3;
            }
            if (bbVar.zH()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fMJ != null && !this.fMJ.isEmpty()) {
            int size = this.fMJ.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fMJ.get(i).onBackPressed()) {
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
            if (this.fMJ == null) {
                this.fMJ = new ArrayList();
            }
            if (!this.fMJ.contains(aVar)) {
                this.fMJ.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fMJ == null) {
                this.fMJ = new ArrayList();
            }
            if (!this.fMJ.contains(aVar)) {
                this.fMJ.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fMJ != null) {
            this.fMJ.remove(aVar);
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dCp == null) {
            this.dCp = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dCp.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bm(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dCp.a(contriInfo, -1L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        com.baidu.tbadk.core.util.ad.a(kVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }
}
