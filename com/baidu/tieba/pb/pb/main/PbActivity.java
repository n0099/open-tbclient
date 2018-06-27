package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.KuangFloatingViewController;
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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
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
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.a.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.r;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.PbMainFloorPraiseFloatingView;
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
/* loaded from: classes2.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e {
    private com.baidu.adp.lib.e.b<TbImageView> azg;
    private com.baidu.tieba.f.b bJn;
    private com.baidu.adp.lib.e.b<ImageView> bfI;
    private com.baidu.adp.lib.e.b<TextView> bfJ;
    private com.baidu.adp.lib.e.b<View> bfK;
    private com.baidu.adp.lib.e.b<LinearLayout> bfL;
    private com.baidu.adp.lib.e.b<RelativeLayout> bfM;
    private com.baidu.adp.lib.e.b<GifView> bfN;
    private com.baidu.tbadk.core.util.b.a bkp;
    private VoiceManager djz;
    private com.baidu.tbadk.core.dialog.h dkm;
    public com.baidu.tbadk.core.util.ak eEi;
    private String fuI;
    private com.baidu.tieba.pb.pb.main.a.b fuO;
    private com.baidu.adp.base.e fvB;
    private com.baidu.tbadk.core.view.d fvC;
    private BdUniqueId fvD;
    private Runnable fvE;
    private ax fvF;
    private com.baidu.adp.widget.ImageView.a fvG;
    private String fvH;
    private TbRichTextMemeInfo fvI;
    private List<a> fvL;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fve;
    private View fvf;
    private com.baidu.tieba.pb.pb.report.a fvi;
    public av fvo;
    private y fvp;
    private boolean fvr;
    private com.baidu.tieba.tbadkCore.data.e fvu;
    private com.baidu.tbadk.editortools.pb.f fvv;
    private com.baidu.tbadk.editortools.pb.d fvw;
    private EmotionImageData fvy;
    private com.baidu.tbadk.core.data.n fwA;
    private boolean fwn;
    private String fwz;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.arP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.arP));
        }
    };
    private static final b.a fwu = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.f.b.a
        public void fb(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bbS();
            } else {
                com.baidu.tieba.pb.a.b.bbR();
            }
        }
    };
    private boolean fuN = false;
    private boolean fuP = false;
    private boolean fuQ = false;
    private boolean eZH = false;
    private boolean fuR = true;
    private int fuS = 0;
    private com.baidu.tbadk.core.dialog.b fuT = null;
    private long cQb = -1;
    private long aTS = 0;
    private long fuU = 0;
    private long createTime = 0;
    private long aTK = 0;
    private boolean fuV = false;
    private com.baidu.tbadk.k.b fuW = null;
    private long fuX = 0;
    private boolean fuY = false;
    private long fuZ = 0;
    private String aNT = null;
    private boolean fva = false;
    private boolean isFullScreen = false;
    private String fvb = "";
    private boolean fvc = true;
    private boolean fvd = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fvg = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void t(boolean z) {
            PbActivity.this.fvj.kx(!PbActivity.this.fvc);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fvh != null && PbActivity.this.fvh.sc()) {
                        PbActivity.this.bcI();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fvh = null;
    private com.baidu.tbadk.baseEditMark.a eWM = null;
    private ForumManageModel cxj = null;
    private com.baidu.tbadk.coreExtra.model.a ard = null;
    private ShareSuccessReplyToServerModel dyM = null;
    private at fvj = null;
    public final com.baidu.tieba.pb.pb.main.a.a fvk = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean fvl = false;
    private boolean fvm = false;
    private boolean fvn = false;
    private boolean fvq = false;
    private boolean fvs = false;
    private boolean fvt = false;
    private boolean fvx = false;
    public boolean fvz = false;
    private com.baidu.tbadk.editortools.pb.c aNW = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HW() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aNX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HV() {
            if (PbActivity.this.fvo == null || PbActivity.this.fvo.bgx() == null || !PbActivity.this.fvo.bgx().bGA()) {
                return !PbActivity.this.qv(com.baidu.tbadk.core.util.ak.aqY);
            }
            PbActivity.this.showToast(PbActivity.this.fvo.bgx().bGC());
            if (PbActivity.this.fvw != null && (PbActivity.this.fvw.Ik() || PbActivity.this.fvw.Il())) {
                PbActivity.this.fvw.a(false, PbActivity.this.fvo.bgA());
            }
            PbActivity.this.fvo.kI(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fvA = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HV() {
            if (PbActivity.this.fvo == null || PbActivity.this.fvo.bgy() == null || !PbActivity.this.fvo.bgy().bGA()) {
                return !PbActivity.this.qv(com.baidu.tbadk.core.util.ak.aqZ);
            }
            PbActivity.this.showToast(PbActivity.this.fvo.bgy().bGC());
            if (PbActivity.this.fvj != null && PbActivity.this.fvj.bfn() != null && PbActivity.this.fvj.bfn().bdG() != null && PbActivity.this.fvj.bfn().bdG().Il()) {
                PbActivity.this.fvj.bfn().bdG().a(PbActivity.this.fvo.bgA());
            }
            PbActivity.this.fvo.kJ(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dki = false;
    private int fvJ = 0;
    private int fvK = -1;
    private final a fvM = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fvj != null && PbActivity.this.fvj.bfn() != null) {
                s bfn = PbActivity.this.fvj.bfn();
                if (bfn.bdD()) {
                    bfn.bdC();
                    return true;
                }
            }
            if (PbActivity.this.fvj != null && PbActivity.this.fvj.bge()) {
                PbActivity.this.fvj.bgf();
                return true;
            }
            return false;
        }
    };
    private r.b fvN = new r.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // com.baidu.tieba.pb.pb.main.r.b
        public void c(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private AddExperiencedModel.a dkq = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bcM();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fvO = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void H(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fvj.showToast(str);
            }
        }
    };
    private final CustomMessageListener fvP = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvh != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fvw != null) {
                    PbActivity.this.fvj.kC(PbActivity.this.fvw.Ie());
                }
                PbActivity.this.fvj.bfo();
                PbActivity.this.fvj.bfX();
            }
        }
    };
    CustomMessageListener dkI = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                PbActivity.this.fvh.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                if (PbActivity.this.fvj != null && PbActivity.this.fvh != null) {
                    PbActivity.this.fvj.d(PbActivity.this.fvh.getPbData(), PbActivity.this.fvh.bdQ(), PbActivity.this.fvh.getRequestType());
                }
                if (PbActivity.this.fvj != null && PbActivity.this.fvj.bfE() != null) {
                    PbActivity.this.fvj.bfE().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fvQ = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fvj != null) {
                    if (booleanValue) {
                        PbActivity.this.fvj.aKF();
                    } else {
                        PbActivity.this.fvj.aKE();
                    }
                }
            }
        }
    };
    private CustomMessageListener fvR = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fvw != null) {
                    PbActivity.this.fvj.kC(PbActivity.this.fvw.Ie());
                }
                PbActivity.this.fvj.kE(false);
            }
        }
    };
    private CustomMessageListener fvS = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customResponsedMessage.getData();
                switch (dVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.k) dVar.getData());
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
    private CustomMessageListener fvT = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvj != null && PbActivity.this.fvj.bfE() != null) {
                PbActivity.this.fvj.bfE().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener ehV = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fvU = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.qx(2);
                aj.beX().reset();
                PbActivity.this.fvh.bei();
                boolean z2 = false;
                ArrayList<PostData> baX = PbActivity.this.fvh.getPbData().baX();
                if (baX != null) {
                    Iterator<PostData> it = baX.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (as.j(next) && next.bxL().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fvj.n(PbActivity.this.fvh.getPbData());
                    }
                    PbActivity.this.showToast(d.k.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(d.k.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(d.k.operation_failed);
        }
    };
    private View.OnClickListener aOD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aNT);
        }
    };
    private CustomMessageListener fvV = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z)) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
                an.a aVar = new an.a();
                aVar.giftId = zVar.id;
                aVar.giftName = zVar.name;
                aVar.thumbnailUrl = zVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvh.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fvh.bdZ() != null && PbActivity.this.fvh.bdZ().getUserIdLong() == zVar.toUserId) {
                        PbActivity.this.fvj.a(zVar.sendCount, PbActivity.this.fvh.getPbData(), PbActivity.this.fvh.bdQ(), PbActivity.this.fvh.getRequestType());
                    }
                    if (pbData.baX() != null && pbData.baX().size() >= 1 && pbData.baX().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.baX().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fvh.bdP(), 0L);
                        if (c2 == zVar.postId && c3 == zVar.threadId) {
                            com.baidu.tbadk.core.data.an bxK = pbData.baX().get(0).bxK();
                            if (bxK == null) {
                                bxK = new com.baidu.tbadk.core.data.an();
                            }
                            ArrayList<an.a> uI = bxK.uI();
                            if (uI == null) {
                                uI = new ArrayList<>();
                            }
                            uI.add(0, aVar);
                            bxK.bN(zVar.sendCount + bxK.uH());
                            bxK.k(uI);
                            pbData.baX().get(0).a(bxK);
                            PbActivity.this.fvj.bfE().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a fvW = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.apa() != null && !aVar.apa().isEmpty()) {
                    PbActivity.this.fvj.a(aVar, PbActivity.this.fvY);
                }
                PbActivity.this.fvj.a(aVar, PbActivity.this.fvh.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bgD()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fvX = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void H(List<String> list) {
            if (!com.baidu.tbadk.core.util.w.A(list) && PbActivity.this.fvj != null) {
                PbActivity.this.fvj.da(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fvY = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bb.aU(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.ig().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17.1
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
    private boolean fvZ = false;
    private PraiseModel fwa = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void iV(String str) {
            PbActivity.this.fvZ = false;
            if (PbActivity.this.fwa != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvh.getPbData();
                if (pbData.baV().vj().getIsLike() == 1) {
                    PbActivity.this.kD(0);
                } else {
                    PbActivity.this.kD(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.baV()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void O(int i, String str) {
            PbActivity.this.fvZ = false;
            if (PbActivity.this.fwa != null && str != null) {
                if (AntiHelper.tQ(i)) {
                    AntiHelper.ao(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fwb = 0;
    private boolean fwc = true;
    private b.a fwd = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jT(boolean z) {
            PbActivity.this.jS(z);
            if (PbActivity.this.fvj.bgk() != null && z) {
                PbActivity.this.fvj.kx(false);
            }
            PbActivity.this.fvj.kz(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aDu != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aDu, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.arP));
                        }
                    } else if (updateAttentionMessage.getData().Gr) {
                        if (PbActivity.this.bbc().vw() != null && PbActivity.this.bbc().vw().getGodUserData() != null) {
                            PbActivity.this.bbc().vw().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().baV() != null && PbActivity.this.fvh.getPbData().baV().vw() != null) {
                            PbActivity.this.fvh.getPbData().baV().vw().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cby = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fvj.aeB();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.qy(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aCg();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.k.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bfS = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.fvj.bfp()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvh != null && (PbActivity.this.fvh.getPbData() != null || PbActivity.this.fvh.getPbData().bbs() != null)) {
                    if (PbActivity.this.fvh.getPbData().bbs().bbA()) {
                        if (PbActivity.this.fvh.getPbData().bbs().fta == 1 || PbActivity.this.fvh.getPbData().bbs().fta == 3 || PbActivity.this.fvh.getPbData().bbs().fta == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvh.getPbData().bbs().bbA() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvh.getPbData().bbs().bbA() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fuZ > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).le(false);
                        PbActivity.this.fuZ = System.currentTimeMillis();
                    }
                }
            }
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == d.g.richText) {
                    if (PbActivity.this.aZ(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.fvj != null && PbActivity.this.fvj.bcs() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").ah(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.fvk != null && PbActivity.this.fvk.fIG != null) {
                            PbActivity.this.fvk.fIG.onClick(view);
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
            if (PbActivity.this.fvw != null) {
                PbActivity.this.fvj.kC(PbActivity.this.fvw.Ie());
            }
            PbActivity.this.fvj.bfo();
            PbActivity.this.fvj.bfX();
            return true;
        }
    });
    private CustomMessageListener fwe = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvD) {
                PbActivity.this.fvj.aeB();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvh.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bbj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fvC.i(PbActivity.this.fvB.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fvB.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    PbActivity.this.gV(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bcY();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fvB.getResources().getString(d.k.mute_fail);
                    }
                    PbActivity.this.fvC.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fwf = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvD) {
                PbActivity.this.fvj.aeB();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fvC.i(PbActivity.this.fvB.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fvB.getResources().getString(d.k.un_mute_fail);
                }
                PbActivity.this.fvC.j(muteMessage);
            }
        }
    };
    private CustomMessageListener fwg = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvD) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fvj.aeB();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hai;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        sparseArray.put(d.g.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(d.g.tag_user_mute_msg, str);
                    }
                    sparseArray.put(d.g.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(d.g.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(d.g.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.fvj.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fwh = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvj.bfp() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.bca() != null && PbActivity.this.bca().getPbData() != null && PbActivity.this.bca().getPbData().bbs() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean bbA = PbActivity.this.bca().getPbData().bbs().bbA();
                if (intValue < 10) {
                    if (bbA) {
                        if (PbActivity.this.fvh.getPbData().bbs().fta == 1 || PbActivity.this.fvh.getPbData().bbs().fta == 3 || PbActivity.this.fvh.getPbData().bbs().fta == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvh.getPbData().bbs().bbA() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, bbA ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fuZ > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).le(false);
                        PbActivity.this.fuZ = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, bbA, 3);
                TiebaStatic.log(PbActivity.this.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, bbA ? 0 : 1));
            }
        }
    };
    private CustomMessageListener dkP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dki = true;
                }
            }
        }
    };
    public a.b fjC = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.atY();
            com.baidu.tbadk.core.data.am pageData = PbActivity.this.fvh.getPageData();
            int pageNum = PbActivity.this.fvj.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.k.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.uA()) {
                PbActivity.this.fvj.bfX();
                PbActivity.this.qx(2);
                PbActivity.this.atX();
                PbActivity.this.fvj.bfI();
                if (com.baidu.adp.lib.util.j.jD()) {
                    PbActivity.this.fvh.qG(PbActivity.this.fvj.getPageNum());
                    if (PbActivity.this.fuO != null) {
                        PbActivity.this.fuO.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(d.k.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.k.pb_page_error);
            }
        }
    };
    public final View.OnClickListener dlq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Multi-variable search result rejected for r2v182, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v186, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v213, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v317, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:670:0x1c59  */
        /* JADX WARN: Removed duplicated region for block: B:697:0x1e23  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.j bbs;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            String str;
            int i;
            bh bhVar;
            SparseArray sparseArray;
            PostData postData;
            boolean m;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fvj.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fvh.kd(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fvj.bfJ();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beQ()) {
                        if (view == PbActivity.this.fvj.fEx.aVN) {
                            if (PbActivity.this.fvj.kB(PbActivity.this.fvh.bdW())) {
                                PbActivity.this.atX();
                                return;
                            }
                            PbActivity.this.fuR = false;
                            PbActivity.this.fuP = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.fvj.fEx.aVN);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fvj.bfG() && (PbActivity.this.fvj.fEx.bgP() == null || (view != PbActivity.this.fvj.fEx.bgP().beP() && view != PbActivity.this.fvj.fEx.bgP().beN()))) {
                            if (view == PbActivity.this.fvj.bga()) {
                                if (PbActivity.this.fvh != null) {
                                    com.baidu.tbadk.browser.a.O(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvh.getPbData().baV().vv().getLink());
                                }
                            } else if (view != PbActivity.this.fvj.fEx.fJq && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.fvj.fEx.fJr) {
                                    if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null) {
                                        ArrayList<PostData> baX = PbActivity.this.fvh.getPbData().baX();
                                        if ((baX == null || baX.size() <= 0) && PbActivity.this.fvh.bdQ()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").ah("tid", PbActivity.this.fvh.bdP()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getForumId()));
                                        if (!PbActivity.this.fvj.bgp()) {
                                            PbActivity.this.fvj.bfo();
                                        }
                                        PbActivity.this.bcA();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beB()) {
                                        if ((PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beM()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.fvj.fEx.bgP() == null || (view != PbActivity.this.fvj.fEx.bgP().getCancelView() && view != PbActivity.this.fvj.fEx.bgP().beL())) {
                                                if (view != PbActivity.this.fvj.fEx.fJs && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beJ()) {
                                                        if ((PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beS()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beK()) {
                                                                if (PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beT()) {
                                                                    if (PbActivity.this.fvp == null || view != PbActivity.this.fvp.beD()) {
                                                                        if (PbActivity.this.fvp == null || view != PbActivity.this.fvp.beB()) {
                                                                            if (PbActivity.this.fvp == null || view != PbActivity.this.fvp.beG()) {
                                                                                if (PbActivity.this.fvp == null || view != PbActivity.this.fvp.beE()) {
                                                                                    if (PbActivity.this.fvp == null || view != PbActivity.this.fvp.beF()) {
                                                                                        if (PbActivity.this.fvj.bgk() == view) {
                                                                                            if (PbActivity.this.fvj.bgk().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvh.getPbData();
                                                                                                if (pbData != null && pbData.baV() != null && pbData.baV().vd() != null) {
                                                                                                    String tX = pbData.baV().vd().tX();
                                                                                                    if (StringUtils.isNull(tX)) {
                                                                                                        tX = pbData.baV().vd().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").ah(VideoPlayActivityConfig.OBJ_ID, tX));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.co("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.bcU();
                                                                                        } else if (PbActivity.this.fvj.bfD() != view) {
                                                                                            if (PbActivity.this.fvp == null || view != PbActivity.this.fvp.beC()) {
                                                                                                if (PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beR()) {
                                                                                                    if (PbActivity.this.fvj.fEx.bgP() != null && view == PbActivity.this.fvj.fEx.bgP().beO()) {
                                                                                                        if (com.baidu.adp.lib.util.j.jD()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.fvj.c(PbActivity.this.fvh.getPbData(), PbActivity.this.fvh.bdQ(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.fvj.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.fvj.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.fvj.fEx.sN();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.k.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.fvj.bcl()) {
                                                                                                            if (view == PbActivity.this.fvj.fEx.bgQ()) {
                                                                                                                PbActivity.this.fvj.bfP();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (bhVar = (bh) view.getTag()) != null && !StringUtils.isNull(bhVar.xc())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        az.zV().c(PbActivity.this.getPageContext(), new String[]{bhVar.xc()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData ba = PbActivity.this.ba(view);
                                                                                                                    if (ba != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, ba.bxO() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.bca() != null && PbActivity.this.bca().getPbData() != null && PbActivity.this.bca().getPbData().bbs() != null && PbActivity.this.bca().getPbData().bbs() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bcv().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.bca().getPbData().bbs().bbA() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && !StringUtils.isNull(PbActivity.this.fvh.getPbData().getThreadId()) && (bbs = PbActivity.this.fvh.getPbData().bbs()) != null && bbs.bby() > 0) {
                                                                                                                        az.zV().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fvh.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.fvp == null) {
                                                                                                                                PbActivity.this.fvp = new y(PbActivity.this.getPageContext(), PbActivity.this.dlq);
                                                                                                                                PbActivity.this.fvj.bk(PbActivity.this.fvp.getView());
                                                                                                                                PbActivity.this.fvp.kh(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.fvp.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").ah("tid", PbActivity.this.fvh.fAv));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.fvp.beB().setTag(sparseArray2);
                                                                                                                            PbActivity.this.fvp.beG().setTag(view.getTag());
                                                                                                                            PbActivity.this.fvp.kj(z6);
                                                                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                                                            boolean booleanValue = ((Boolean) sparseArray3.get(d.g.tag_should_manage_visible)).booleanValue();
                                                                                                                            boolean booleanValue2 = ((Boolean) sparseArray3.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                                                            boolean booleanValue3 = ((Boolean) sparseArray3.get(d.g.tag_should_delete_visible)).booleanValue();
                                                                                                                            if (!(sparseArray3.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                z2 = false;
                                                                                                                            } else {
                                                                                                                                z2 = ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                                                            }
                                                                                                                            String str2 = null;
                                                                                                                            if (sparseArray3.get(d.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                str2 = (String) sparseArray3.get(d.g.tag_forbid_user_post_id);
                                                                                                                            }
                                                                                                                            if (booleanValue) {
                                                                                                                                SparseArray sparseArray4 = new SparseArray();
                                                                                                                                sparseArray4.put(d.g.tag_should_manage_visible, true);
                                                                                                                                sparseArray4.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray4.put(d.g.tag_forbid_user_name, sparseArray3.get(d.g.tag_forbid_user_name));
                                                                                                                                sparseArray4.put(d.g.tag_forbid_user_name_show, sparseArray3.get(d.g.tag_forbid_user_name_show));
                                                                                                                                sparseArray4.put(d.g.tag_forbid_user_portrait, sparseArray3.get(d.g.tag_forbid_user_portrait));
                                                                                                                                sparseArray4.put(d.g.tag_forbid_user_post_id, str2);
                                                                                                                                if (booleanValue2) {
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_visible, true);
                                                                                                                                    sparseArray4.put(d.g.tag_is_mem, sparseArray3.get(d.g.tag_is_mem));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray3.get(d.g.tag_user_mute_mute_userid));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray3.get(d.g.tag_user_mute_mute_username));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_mute_nameshow, sparseArray3.get(d.g.tag_user_mute_mute_nameshow));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_post_id, sparseArray3.get(d.g.tag_user_mute_post_id));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_thread_id, sparseArray3.get(d.g.tag_user_mute_thread_id));
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_visible, false);
                                                                                                                                }
                                                                                                                                if (booleanValue3) {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, true);
                                                                                                                                    sparseArray4.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                    sparseArray4.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                    sparseArray4.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                    PbActivity.this.fvp.beE().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.fvp.beE().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvp.beC().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fvp.beE().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fvp.beC().setText(d.k.bar_manager);
                                                                                                                                PbActivity.this.fvp.beC().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.fvp.beC().setVisibility(8);
                                                                                                                                PbActivity.this.fvp.beE().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.fvp.beC().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fvp.beE().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fvp.beC().setText(d.k.delete);
                                                                                                                                PbActivity.this.fvp.beE().setVisibility(0);
                                                                                                                                if (PbActivity.this.fvh.getPbData().bbh() != 1002 || z2) {
                                                                                                                                    PbActivity.this.fvp.beE().setText(d.k.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvp.beE().setText(d.k.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvp.beC().setVisibility(8);
                                                                                                                            }
                                                                                                                            SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                                                                            if (!(sparseArray6.get(d.g.tag_user_mute_visible) instanceof Boolean)) {
                                                                                                                                z3 = false;
                                                                                                                            } else {
                                                                                                                                z3 = ((Boolean) sparseArray6.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                                                            }
                                                                                                                            if (!((Boolean) sparseArray6.get(d.g.tag_should_manage_visible)).booleanValue() && z3) {
                                                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_visible, true);
                                                                                                                                sparseArray7.put(d.g.tag_is_mem, sparseArray6.get(d.g.tag_is_mem));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_mute_userid, sparseArray6.get(d.g.tag_user_mute_mute_userid));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_mute_username, sparseArray6.get(d.g.tag_user_mute_mute_username));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_mute_nameshow, sparseArray6.get(d.g.tag_user_mute_mute_nameshow));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_post_id, sparseArray6.get(d.g.tag_user_mute_post_id));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_thread_id, sparseArray6.get(d.g.tag_user_mute_thread_id));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_is_self, sparseArray6.get(d.g.tag_del_post_is_self));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_type, sparseArray6.get(d.g.tag_del_post_type));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_id, sparseArray6.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray7.put(d.g.tag_manage_user_identity, sparseArray6.get(d.g.tag_manage_user_identity));
                                                                                                                                PbActivity.this.fvp.beD().setTag(sparseArray7);
                                                                                                                                PbActivity.this.fvp.beD().setVisibility(0);
                                                                                                                                PbActivity.this.fvp.beC().setVisibility(8);
                                                                                                                                PbActivity.this.fvp.beD().setText(d.k.mute_option);
                                                                                                                            } else {
                                                                                                                                if (!(sparseArray6.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                    z4 = false;
                                                                                                                                } else {
                                                                                                                                    z4 = ((Boolean) sparseArray6.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                }
                                                                                                                                String str3 = null;
                                                                                                                                if (sparseArray6.get(d.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                    str3 = (String) sparseArray6.get(d.g.tag_forbid_user_post_id);
                                                                                                                                }
                                                                                                                                boolean jO = PbActivity.this.jO(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fwr = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (as.j(PbActivity.this.fwr) ? false : jO) {
                                                                                                                                    PbActivity.this.fvp.beD().setVisibility(0);
                                                                                                                                    PbActivity.this.fvp.beD().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvp.beD().setVisibility(8);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                                                                            long j = 0;
                                                                                                                            if (!(sparseArray8.get(d.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                z5 = false;
                                                                                                                            } else {
                                                                                                                                z5 = ((Boolean) sparseArray8.get(d.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                            }
                                                                                                                            if (sparseArray8.get(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                j = ((Long) sparseArray8.get(d.g.tag_chudian_template_id)).longValue();
                                                                                                                            }
                                                                                                                            if (!(sparseArray8.get(d.g.tag_chudian_monitor_id) instanceof String)) {
                                                                                                                                str = "";
                                                                                                                            } else {
                                                                                                                                str = (String) sparseArray8.get(d.g.tag_chudian_monitor_id);
                                                                                                                            }
                                                                                                                            if (!(sparseArray8.get(d.g.tag_chudian_hide_day) instanceof Integer)) {
                                                                                                                                i = 0;
                                                                                                                            } else {
                                                                                                                                i = ((Integer) sparseArray8.get(d.g.tag_chudian_hide_day)).intValue();
                                                                                                                            }
                                                                                                                            if (z5) {
                                                                                                                                PbActivity.this.fvp.beF().setVisibility(0);
                                                                                                                                PbActivity.this.fvp.beF().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.fvp.beF().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.fvp.beF().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.fvp.beF().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fvh.getPbData().sc()) {
                                                                                                                            String sb = PbActivity.this.fvh.getPbData().sb();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(sb) && sb.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.fvp.beB().setText(d.k.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvp.beB().setText(d.k.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvp.ki(true);
                                                                                                                                PbActivity.this.fvp.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.fvp.ki(true);
                                                                                                                        PbActivity.this.fvp.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().baV() != null && PbActivity.this.fvh.getPbData().baV().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), PbActivity.this.fvh.getPbData().baV().getActUrl());
                                                                                                                        if (PbActivity.this.fvh.getPbData().baV().vY() != 1) {
                                                                                                                            if (PbActivity.this.fvh.getPbData().baV().vY() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getPbData().getForumId()).ah("tid", PbActivity.this.fvh.getPbData().getThreadId()).ah("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fvh.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.fvj.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (bb.aU(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.k.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.fvj.bfo();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.bcx() == 1 && PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getPbData().getForumId()).ah("tid", PbActivity.this.fvh.getPbData().getThreadId()).ah("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.bcx() == 1 && PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getPbData().getForumId()).ah("tid", PbActivity.this.fvh.getPbData().getThreadId()).ah("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.bcP();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.bcQ();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().bbo() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fvh.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").ah(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        az.zV().c(PbActivity.this.getPageContext(), new String[]{pbData2.bbo().bbx()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().bbo() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fvh.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").ah(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        az.zV().c(PbActivity.this.getPageContext(), new String[]{pbData3.bbo().bbx()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.fvj.fEx.bgP() != null && view == PbActivity.this.fvj.fEx.bgP().beU()) {
                                                                                                                    if (PbActivity.this.fvh == null || PbActivity.this.fvh.getPbData() == null || PbActivity.this.fvh.getPbData().baV() == null) {
                                                                                                                        PbActivity.this.fvj.fEx.sN();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.jU()) {
                                                                                                                        PbActivity.this.showToast(d.k.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fvh.getPbData().baV().ve() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvh.bdP(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.k.haved_fans_called)).xv();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").r("obj_locate", PbActivity.this.aj(PbActivity.this.fvh.getPbData().baV())).ah("tid", PbActivity.this.fvh.getPbData().baV().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fvJ >= 0) {
                                                                                                                        if (PbActivity.this.fvh != null) {
                                                                                                                            PbActivity.this.fvh.bew();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fvj.bfE() != null) {
                                                                                                                            PbActivity.this.fvj.bfE().a(PbActivity.this.fvh.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.fvj.getListView().setSelection(PbActivity.this.fvh.bez());
                                                                                                                        PbActivity.this.fvJ = 0;
                                                                                                                        if (PbActivity.this.fvh != null) {
                                                                                                                            PbActivity.this.fvh.bp(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.fvj.bgs();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fvh.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fvh.bdP(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fvh.getPbData().baV().vP())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fvh.getPbData() != null) {
                                                                                                            PbActivity.this.fvj.bfX();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bxQ() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                                                }
                                                                                                                String bdP = PbActivity.this.fvh.bdP();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fvh.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fvh.getPbData().bbh();
                                                                                                                }
                                                                                                                PbActivity.this.atX();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c rl = PbActivity.this.rl(id2);
                                                                                                                    if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && rl != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdP, id2, "pb", true, null, true, null, i3, postData3.bhG(), PbActivity.this.fvh.getPbData().uu(), false, postData3.vw().getIconInfo()).addBigImageData(rl.fxb, rl.fxc, rl.fxd, rl.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fvh.bev());
                                                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.fvh.getFromForumId());
                                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (view.getId() == d.g.sub_pb_item) {
                                                                                                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                                                                                    String str5 = (String) sparseArray10.get(d.g.tag_photo_username);
                                                                                                                    String str6 = (String) sparseArray9.get(d.g.tag_photo_userid);
                                                                                                                    PostData postData4 = (PostData) sparseArray10.get(d.g.tag_load_sub_data);
                                                                                                                    String str7 = null;
                                                                                                                    if (postData4 != null) {
                                                                                                                        str7 = postData4.getId();
                                                                                                                    }
                                                                                                                    TiebaStatic.log("c11741");
                                                                                                                    c rl2 = PbActivity.this.rl(id2);
                                                                                                                    if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && rl2 != null && PbActivity.this.bcr().bfm() != null) {
                                                                                                                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                                                        kVar.a(PbActivity.this.fvh.getPbData().baT());
                                                                                                                        kVar.X(PbActivity.this.fvh.getPbData().baV());
                                                                                                                        kVar.d(postData4);
                                                                                                                        PbActivity.this.bcr().bfm().d(kVar);
                                                                                                                        PbActivity.this.bcr().bfm().setPostId(str7);
                                                                                                                        PbActivity.this.b(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c rl3 = PbActivity.this.rl(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && rl3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdP, id2, "pb", true, null, false, null, i3, postData3.bhG(), PbActivity.this.fvh.getPbData().uu(), false, postData3.vw().getIconInfo()).addBigImageData(rl3.fxb, rl3.fxc, rl3.fxd, rl3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fvh.bev());
                                                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.fvh.getFromForumId());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 3).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.jD()) {
                                                                                                    PbActivity.this.fvj.bfX();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.fvj.c(PbActivity.this.fvh.getPbData(), PbActivity.this.fvh.bdQ(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvh.getPbData().baT().getId(), PbActivity.this.fvh.getPbData().baT().getName(), PbActivity.this.fvh.getPbData().baV().getId(), String.valueOf(PbActivity.this.fvh.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_name_show), (String) c3.get(d.g.tag_forbid_user_post_id), (String) c3.get(d.g.tag_forbid_user_portrait))));
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    PbActivity.this.showToast(d.k.network_not_available);
                                                                                                    return;
                                                                                                }
                                                                                            } else if (!com.baidu.adp.lib.util.j.jD()) {
                                                                                                PbActivity.this.showToast(d.k.network_not_available);
                                                                                                return;
                                                                                            } else {
                                                                                                SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                                if (sparseArray11 != null) {
                                                                                                    boolean booleanValue4 = ((Boolean) sparseArray11.get(d.g.tag_should_manage_visible)).booleanValue();
                                                                                                    boolean booleanValue5 = ((Boolean) sparseArray11.get(d.g.tag_should_delete_visible)).booleanValue();
                                                                                                    boolean booleanValue6 = ((Boolean) sparseArray11.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                                    if (booleanValue4) {
                                                                                                        if (booleanValue6) {
                                                                                                            sparseArray11.put(d.g.tag_from, 1);
                                                                                                            sparseArray11.put(d.g.tag_check_mute_from, 2);
                                                                                                            PbActivity.this.b(sparseArray11);
                                                                                                        } else {
                                                                                                            sparseArray11.put(d.g.tag_check_mute_from, 2);
                                                                                                            PbActivity.this.fvj.bi(view);
                                                                                                        }
                                                                                                    } else if (booleanValue5) {
                                                                                                        PbActivity.this.fvj.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.bcn();
                                                                                        }
                                                                                    } else {
                                                                                        long j2 = -1;
                                                                                        String str8 = "";
                                                                                        int i4 = 0;
                                                                                        if (view.getTag(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                            j2 = ((Long) view.getTag(d.g.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (view.getTag(d.g.tag_chudian_monitor_id) instanceof String) {
                                                                                            str8 = (String) view.getTag(d.g.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (view.getTag(d.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                            i4 = ((Integer) view.getTag(d.g.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fvh.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.baT() != null) {
                                                                                            str9 = pbData4.baT().getId();
                                                                                            str10 = pbData4.baT().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.a.a(j2, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j2, str8, str9, str10, str11, i4);
                                                                                    }
                                                                                } else {
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null) {
                                                                                        if ((sparseArray12.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_id) instanceof String) && (sparseArray12.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                            PbActivity.this.fvj.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), ((Integer) sparseArray12.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray12.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.fvp.beI()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12007").ah("tid", PbActivity.this.fvh.fAv));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvh.getPbData() != null) {
                                                                                    PbActivity.this.fvj.bfX();
                                                                                    if (!(view.getTag() instanceof SparseArray)) {
                                                                                        sparseArray = null;
                                                                                    } else {
                                                                                        sparseArray = (SparseArray) view.getTag();
                                                                                    }
                                                                                    if (sparseArray == null || !(sparseArray.get(d.g.tag_load_sub_data) instanceof PostData)) {
                                                                                        postData = null;
                                                                                    } else {
                                                                                        postData = (PostData) sparseArray.get(d.g.tag_load_sub_data);
                                                                                    }
                                                                                    if (postData != null) {
                                                                                        String bdP2 = PbActivity.this.fvh.bdP();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fvh.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fvh.getPbData().bbh();
                                                                                        }
                                                                                        PbActivity.this.atX();
                                                                                        c rl4 = PbActivity.this.rl(id3);
                                                                                        if (rl4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdP2, id3, "pb", true, null, true, null, i5, postData.bhG(), PbActivity.this.fvh.getPbData().uu(), false, postData.vw().getIconInfo()).addBigImageData(rl4.fxb, rl4.fxc, rl4.fxd, rl4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fvh.bev());
                                                                                            addBigImageData3.setFromFrsForumId(PbActivity.this.fvh.getFromForumId());
                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").r("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bb(view);
                                                                                if (PbActivity.this.fvh.getPbData().baV() != null && PbActivity.this.fvh.getPbData().baV().vw() != null && PbActivity.this.fvh.getPbData().baV().vw().getUserId() != null && PbActivity.this.eWM != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").ah("tid", PbActivity.this.fvh.fAv).r("obj_locate", 2).ah(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvh.getPbData().baV().vw().getUserId()).r("obj_type", PbActivity.this.eWM.sc() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fvh.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.jD()) {
                                                                        PbActivity.this.showToast(d.k.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13079"));
                                                                            PbActivity.this.ri((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").r("obj_locate", 4));
                                                                            SparseArray<Object> sparseArray13 = (SparseArray) tag;
                                                                            if ((sparseArray13.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray13.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray13.put(d.g.tag_from, 0);
                                                                                sparseArray13.put(d.g.tag_check_mute_from, 2);
                                                                                PbActivity.this.b(sparseArray13);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10647").r("obj_type", 0).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10647").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fvj.fEx.bgO();
                                                                }
                                                            } else if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().baV() != null) {
                                                                PbActivity.this.fvj.fEx.sN();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                                PbActivity.this.ri(PbActivity.this.fvh.getPbData().baV().vM());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fvj.bfX();
                                                            if (com.baidu.adp.lib.util.j.jD()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fvh.bed()));
                                                                    return;
                                                                }
                                                                PbActivity.this.qx(2);
                                                                PbActivity.this.atX();
                                                                PbActivity.this.fvj.bfI();
                                                                boolean bec = PbActivity.this.fvh.bec();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fvh.bed()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.fvj.fEx != null && PbActivity.this.fvj.fEx.bgP() != null && view == PbActivity.this.fvj.fEx.bgP().beS()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bec) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.fvj.ks(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.k.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fvj.bfX();
                                                        if (PbActivity.this.fvh.getPageData() != null) {
                                                            PbActivity.this.fvj.a(PbActivity.this.fvh.getPageData(), PbActivity.this.fjC);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.as.ip() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fvh != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12386").ah("tid", PbActivity.this.fvh.bdP()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.jU()) {
                                                        if (PbActivity.this.fvh.getPbData() != null) {
                                                            ArrayList<PostData> baX2 = PbActivity.this.fvh.getPbData().baX();
                                                            if ((baX2 != null && baX2.size() > 0) || !PbActivity.this.fvh.bdQ()) {
                                                                PbActivity.this.fvj.bfX();
                                                                PbActivity.this.atX();
                                                                PbActivity.this.qx(2);
                                                                if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().bbo() != null && !StringUtils.isNull(PbActivity.this.fvh.getPbData().bbo().uh(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                                if (com.baidu.tbadk.o.as.ip()) {
                                                                    PbActivity.this.qy(2);
                                                                } else {
                                                                    PbActivity.this.fvj.showLoadingDialog();
                                                                    PbActivity.this.fvh.beq().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(d.k.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.fvj.fEx.sN();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.jD()) {
                                            PbActivity.this.fvj.bfX();
                                            if (PbActivity.this.fvj.fEx.bgP() != null && view == PbActivity.this.fvj.fEx.bgP().beM() && !PbActivity.this.fvj.bgp()) {
                                                PbActivity.this.fvj.bfo();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.atX();
                                                PbActivity.this.fvj.bfI();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    m = PbActivity.this.fvh.m(true, PbActivity.this.bcN());
                                                } else {
                                                    m = view.getId() == d.g.reply_title ? PbActivity.this.fvh.m(false, PbActivity.this.bcN()) : PbActivity.this.fvh.rm(PbActivity.this.bcN());
                                                }
                                                view.setTag(Boolean.valueOf(m));
                                                if (m) {
                                                    PbActivity.this.fvj.jX(true);
                                                    PbActivity.this.fvj.aKF();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fvj.ks(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.qx(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.k.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.jD()) {
                                        PbActivity.this.fvj.bfX();
                                        if (PbActivity.this.qw(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fvh.qL(PbActivity.this.fvj.bfN()) != null) {
                                            PbActivity.this.bcH();
                                            if (PbActivity.this.fvh.getPbData().baV() != null && PbActivity.this.fvh.getPbData().baV().vw() != null && PbActivity.this.fvh.getPbData().baV().vw().getUserId() != null && PbActivity.this.eWM != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").ah("tid", PbActivity.this.fvh.fAv).r("obj_locate", 1).ah(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvh.getPbData().baV().vw().getUserId()).r("obj_type", PbActivity.this.eWM.sc() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fvh.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.k.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.jD()) {
                                    PbActivity.this.fvj.jX(true);
                                    PbActivity.this.fvj.bfo();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fvj.aKF();
                                        PbActivity.this.atX();
                                        PbActivity.this.fvj.bfI();
                                        PbActivity.this.fvh.rm(PbActivity.this.bcN());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.qx(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(d.k.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().baV() != null && PbActivity.this.fvh.getPbData().baV().wh() && PbActivity.this.fvh.getPbData().baV().vN() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbActivity.this.fvh.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fvh.bdO()) && PbActivity.this.fvh.getAppealInfo() != null) {
                                        name = PbActivity.this.fvh.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fvh.getPbData().baT().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bdO = PbActivity.this.fvh.bdO();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fvh.bdR() && bdO != null && bdO.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.jD()) {
                            if (PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().bbh() == 1 && !PbActivity.this.cxj.byq()) {
                                PbActivity.this.fvj.bfX();
                                int i6 = 0;
                                if (PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beN()) {
                                    if (PbActivity.this.fvj.fEx.bgP() == null || view != PbActivity.this.fvj.fEx.bgP().beP()) {
                                        if (view == PbActivity.this.fvj.bfG()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fvh.getPbData().baV().vs() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fvh.getPbData().baV().vr() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData baT = PbActivity.this.fvh.getPbData().baT();
                                String name2 = baT.getName();
                                String id4 = baT.getId();
                                String id5 = PbActivity.this.fvh.getPbData().baV().getId();
                                PbActivity.this.fvj.bfF();
                                PbActivity.this.cxj.a(id4, name2, id5, i6, PbActivity.this.fvj.bfH());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.k.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.jD()) {
                        PbActivity.this.fvj.bfX();
                        PbActivity.this.atX();
                        PbActivity.this.fvj.bfI();
                        PbActivity.this.fvj.showLoadingDialog();
                        if (PbActivity.this.fvj.bfv() != null) {
                            PbActivity.this.fvj.bfv().setVisibility(8);
                        }
                        PbActivity.this.fvh.qG(1);
                        if (PbActivity.this.fuO != null) {
                            PbActivity.this.fuO.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.k.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.k.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bcu = PbActivity.this.bcu();
                        if (!TextUtils.isEmpty(bcu)) {
                            az.zV().c(PbActivity.this.getPageContext(), new String[]{bcu});
                        }
                    }
                } else if (PbActivity.this.fuY) {
                    PbActivity.this.fuY = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.bcr().bfm() != null && postData5.vw() != null && postData5.bxC() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bcr().bfn() != null) {
                                    PbActivity.this.bcr().bfn().bdB();
                                }
                                com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                                kVar2.a(PbActivity.this.fvh.getPbData().baT());
                                kVar2.X(PbActivity.this.fvh.getPbData().baV());
                                kVar2.d(postData5);
                                PbActivity.this.bcr().bfm().d(kVar2);
                                PbActivity.this.bcr().bfm().setPostId(postData5.getId());
                                PbActivity.this.b(view, postData5.vw().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fvw != null) {
                                    PbActivity.this.fvj.kC(PbActivity.this.fvw.Ie());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aOd = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.atX();
            PbActivity.this.fvj.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.aj.Lb() && PbActivity.this.bca() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bca().rp(postWriteCallBackData.getPostId());
                    PbActivity.this.fvJ = PbActivity.this.fvj.bfr();
                    if (PbActivity.this.fvh != null) {
                        PbActivity.this.fvh.bp(PbActivity.this.fvJ, PbActivity.this.fvj.bfs());
                    }
                }
                PbActivity.this.fvj.bfX();
                PbActivity.this.fvo.bgw();
                if (PbActivity.this.fvw != null) {
                    PbActivity.this.fvj.kC(PbActivity.this.fvw.Ie());
                }
                PbActivity.this.fvj.bfl();
                PbActivity.this.fvj.kE(true);
                PbActivity.this.fvh.bef();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fvh.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvh.getPbData();
                            if (pbData != null && pbData.baV() != null && pbData.baV().vw() != null && (userId = pbData.baV().vw().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.aj.Lb() && PbActivity.this.fvh.bdY()) {
                                PbActivity.this.fvj.bfI();
                            }
                        } else if (!com.baidu.tbadk.o.aj.Lb() && PbActivity.this.fvh.bdY()) {
                            PbActivity.this.fvj.bfI();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fvj.n(PbActivity.this.fvh.getPbData());
                    }
                    if (PbActivity.this.fvh.bdU()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").ah("tid", PbActivity.this.fvh.bdP()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fvw.Ik() || PbActivity.this.fvw.Il()) {
                    PbActivity.this.fvw.a(false, postWriteCallBackData);
                }
                PbActivity.this.fvo.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.eEi != null) {
                    PbActivity.this.eEi.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fwi = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fvo != null) {
                    PbActivity.this.fvo.bgv();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.eEi != null) {
                    PbActivity.this.eEi.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fvo != null) {
                if (PbActivity.this.fvj != null && PbActivity.this.fvj.bfn() != null && PbActivity.this.fvj.bfn().bdG() != null && PbActivity.this.fvj.bfn().bdG().Il()) {
                    PbActivity.this.fvj.bfn().bdG().a(postWriteCallBackData);
                }
                PbActivity.this.fvo.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fwj = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g eK;
            if (!z || dVar == null || dVar.bbf() != null || com.baidu.tbadk.core.util.w.z(dVar.baX()) >= 1) {
                PbActivity.this.eZH = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fvj.bfK();
                if (dVar == null || !dVar.bbb()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fvj.getView());
                }
                PbActivity.this.fvj.aKE();
                if (PbActivity.this.isFullScreen || PbActivity.this.fvj.bgp()) {
                    PbActivity.this.fvj.bgg();
                } else if (!PbActivity.this.fvj.bgd()) {
                    PbActivity.this.fvj.kE(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fvq = true;
                }
                if (z && dVar != null) {
                    PbActivity.this.fvj.showListView();
                    if (dVar.baV() != null && dVar.baV().wo() != null) {
                        PbActivity.this.a(dVar.baV().wo());
                    }
                    PbActivity.this.bco();
                    if (PbActivity.this.fvw != null) {
                        PbActivity.this.fvj.kC(PbActivity.this.fvw.Ie());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.baX() != null && dVar.baX().size() >= 1 && dVar.baX().get(0) != null) {
                        PbActivity.this.fvh.ro(dVar.baX().get(0).getId());
                    } else if (dVar.bbf() != null) {
                        PbActivity.this.fvh.ro(dVar.bbf().getId());
                    }
                    if (PbActivity.this.fvw != null) {
                        PbActivity.this.fvw.a(dVar.uu());
                        PbActivity.this.fvw.a(dVar.baT(), dVar.getUserData());
                        PbActivity.this.fvw.a(PbActivity.this.fvh.bdZ(), PbActivity.this.fvh.bdP(), PbActivity.this.fvh.bes());
                        if (dVar.baV() != null) {
                            PbActivity.this.fvw.bL(dVar.baV().wE());
                        }
                    }
                    if (PbActivity.this.eWM != null) {
                        PbActivity.this.eWM.ah(dVar.sc());
                    }
                    if (dVar == null || dVar.bbi() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fvj.kD(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fvj.a(dVar, i2, i3, PbActivity.this.fvh.bdQ(), i4, PbActivity.this.fvh.getIsFromMark());
                    PbActivity.this.fvj.d(dVar, PbActivity.this.fvh.bdQ());
                    PbActivity.this.fvj.kA(PbActivity.this.fvh.getHostMode());
                    AntiData uu = dVar.uu();
                    if (uu != null) {
                        PbActivity.this.aNT = uu.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aNT) && PbActivity.this.fvw != null && PbActivity.this.fvw.Hy() != null && (eK = PbActivity.this.fvw.Hy().eK(6)) != null && !TextUtils.isEmpty(PbActivity.this.aNT)) {
                            ((View) eK).setOnClickListener(PbActivity.this.aOD);
                        }
                    }
                    if (PbActivity.this.fvs) {
                        PbActivity.this.fvs = false;
                        final int bcC = PbActivity.this.bcC();
                        if (dVar.bbt()) {
                            final int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bcC, ah);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bcr().qR(bcC);
                        }
                    }
                    if (PbActivity.this.fvt) {
                        PbActivity.this.fvt = false;
                        final int bcC2 = PbActivity.this.bcC();
                        final boolean z2 = bcC2 != -1;
                        if (!z2) {
                            bcC2 = PbActivity.this.bcD();
                        }
                        if (PbActivity.this.bcr() != null) {
                            if (dVar.bbt()) {
                                final int ah2 = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bcC2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bcC2, ah2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bcC2 - 1, ah2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.bcr().qR(bcC2);
                            }
                        }
                    } else {
                        PbActivity.this.fvj.bfO();
                    }
                    PbActivity.this.fvh.a(dVar.baT(), PbActivity.this.fvW);
                    PbActivity.this.fvh.a(PbActivity.this.fvX);
                    if (PbActivity.this.eEi != null && dVar.baV() != null && dVar.baV().vw() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.baV().vw());
                        PbActivity.this.eEi.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fvq && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fvh != null && PbActivity.this.fvh.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fvh.getAppealInfo().fsg)) {
                                    PbActivity.this.fvj.a(PbActivity.this.fvh.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fvj.getView(), PbActivity.this.getPageContext().getResources().getString(d.k.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fvj.getView(), PbActivity.this.getPageContext().getResources().getString(d.k.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.fvj.bgg();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fvh.bdP());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getForumId());
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
                        PbActivity.this.fvj.rs(PbActivity.this.getResources().getString(d.k.list_no_more_new));
                    } else {
                        PbActivity.this.fvj.rs("");
                    }
                    PbActivity.this.fvj.AI();
                }
                PbActivity.this.aTS = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bca().bdQ() || PbActivity.this.bca().getPbData().uJ().uG() != 0 || PbActivity.this.bca().bel()) {
                    PbActivity.this.fvx = true;
                    return;
                }
                return;
            }
            PbActivity.this.fvh.qG(1);
            if (PbActivity.this.fuO != null) {
                PbActivity.this.fuO.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fvj.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.m.KK().KL()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.cQb : j;
                com.baidu.tbadk.k.i iVar = new com.baidu.tbadk.k.i(i, z, responsedMessage, PbActivity.this.aTK, PbActivity.this.createTime, PbActivity.this.aTS, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aTK = 0L;
                if (iVar != null) {
                    iVar.KH();
                }
                if (z2) {
                    iVar.aUb = currentTimeMillis;
                    iVar.bZ(true);
                }
                if (!z2 && PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().baV() != null) {
                    int threadType = PbActivity.this.fvh.getPbData().baV().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.fvb, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.fvb, "from_frs")) {
                                com.baidu.tbadk.k.i iVar2 = new com.baidu.tbadk.k.i();
                                iVar2.fl(1000);
                                iVar2.aUd = currentTimeMillis;
                                iVar2.fm(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.k.d dVar = new com.baidu.tbadk.k.d();
                        dVar.pageType = 1;
                        dVar.fl(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
                        dVar.aUd = currentTimeMillis;
                        dVar.fm(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fwk = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bcy();
            }
        }
    };
    private final a.InterfaceC0100a fwl = new a.InterfaceC0100a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0100a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fvj.bfK();
            if (z) {
                if (PbActivity.this.eWM != null) {
                    PbActivity.this.eWM.ah(z2);
                }
                PbActivity.this.fvh.kf(z2);
                if (PbActivity.this.fvh.sc()) {
                    PbActivity.this.bcI();
                } else {
                    PbActivity.this.fvj.n(PbActivity.this.fvh.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.eWM != null && PbActivity.this.eWM.sf() != null && PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().baV() != null && PbActivity.this.fvh.getPbData().baV().vw() != null) {
                        MarkData sf = PbActivity.this.eWM.sf();
                        MetaData vw = PbActivity.this.fvh.getPbData().baV().vw();
                        if (sf != null && vw != null) {
                            if (!com.baidu.tbadk.core.util.ap.equals(TbadkCoreApplication.getCurrentAccount(), vw.getUserId()) && !vw.hadConcerned()) {
                                PbActivity.this.b(vw);
                                return;
                            } else {
                                PbActivity.this.showToast(d.k.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.k.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.k.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.k.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.qt(PbActivity.this.mLastScrollState) && PbActivity.this.qt(i)) {
                if (PbActivity.this.fvj != null) {
                    PbActivity.this.fvj.bfX();
                    if (PbActivity.this.fvw != null && !PbActivity.this.fvj.bfp()) {
                        PbActivity.this.fvj.kC(PbActivity.this.fvw.Ie());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fvj.bfo();
                    }
                }
                if (!PbActivity.this.fuV) {
                    PbActivity.this.fuV = true;
                    PbActivity.this.fvj.bgc();
                }
            }
            PbActivity.this.fvj.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fuO != null) {
                PbActivity.this.fuO.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fuW == null) {
                PbActivity.this.fuW = new com.baidu.tbadk.k.b();
                PbActivity.this.fuW.fl(1001);
            }
            if (i == 0) {
                PbActivity.this.fuW.KB();
            } else {
                PbActivity.this.fuW.KA();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> baX;
            if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvj != null && PbActivity.this.fvj.bfE() != null) {
                PbActivity.this.fvj.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fuO != null) {
                    PbActivity.this.fuO.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fvh.beh() && (baX = PbActivity.this.fvh.getPbData().baX()) != null && !baX.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fvj.bfE().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvh.getPbData();
                    if (pbData != null) {
                        if (pbData.baY() != null && pbData.baY().hasData()) {
                            headerCount--;
                        }
                        if (pbData.baZ() != null && pbData.baZ().hasData()) {
                            headerCount--;
                        }
                        int size = baX.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cxn = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cxj.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fvh.bef();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fLi != 1002 || bVar.dNa) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fvj.a(1, dVar.Fa, dVar.gPt, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cxj.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fvj.a(PbActivity.this.cxj.getLoadDataMode(), gVar.Fa, gVar.gPt, false);
                        PbActivity.this.fvj.as(gVar.gPw);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fvj.a(PbActivity.this.cxj.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fwm = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final g.b boQ = new g.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.g.b
        public void aU(boolean z) {
            if (PbActivity.this.bcO()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fvh.ke(true)) {
                PbActivity.this.fvj.bfL();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fwo = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fwn && PbActivity.this.bcO()) {
                PbActivity.this.bcQ();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fvh.kd(false)) {
                    PbActivity.this.fvj.bfJ();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fvh.getPbData() != null) {
                    PbActivity.this.fvj.bgb();
                }
                PbActivity.this.fwn = true;
            }
        }
    };
    private int fwp = 0;
    private final TbRichTextView.h bfR = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fvj.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(d.g.tag_rich_text_meme_info) != null && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    PbActivity.this.fvf = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fxe) {
                    TbRichText aF = PbActivity.this.aF(str, i);
                    if (aF != null && PbActivity.this.fwp >= 0 && PbActivity.this.fwp < aF.Nz().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aF.Nz().get(PbActivity.this.fwp));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fxb.size()) {
                                break;
                            } else if (!cVar.fxb.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.w.A(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fxc.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fxd, cVar.lastId, PbActivity.this.fvh.bed(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.w.d(cVar.fxb, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.w.A(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fxc.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fxd, cVar.fxb.get(0), PbActivity.this.fvh.bed(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fwq = false;
    PostData fwr = null;
    private final b.InterfaceC0104b fws = new b.InterfaceC0104b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fwr != null) {
                if (i == 0) {
                    PbActivity.this.fwr.ch(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fwr = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.e(PbActivity.this.fwr);
                }
            }
        }
    };
    private final b.InterfaceC0104b fwt = new b.InterfaceC0104b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fvG != null && !TextUtils.isEmpty(PbActivity.this.fvH)) {
                if (i == 0) {
                    if (PbActivity.this.fvI == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fvH));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fvH;
                        aVar.pkgId = PbActivity.this.fvI.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fvI.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bkp == null) {
                        PbActivity.this.bkp = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bkp.Aj();
                    PbActivity.this.bkp.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bkp.u(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fvF == null) {
                            PbActivity.this.fvF = new ax(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fvF.i(PbActivity.this.fvH, PbActivity.this.fvG.nc());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fvG = null;
                PbActivity.this.fvH = null;
            }
        }
    };
    private final View.OnLongClickListener aHk = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.fvG = ((TbImageView) view).getBdImage();
                PbActivity.this.fvH = ((TbImageView) view).getUrl();
                if (PbActivity.this.fvG != null && !TextUtils.isEmpty(PbActivity.this.fvH)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvI = null;
                    } else {
                        PbActivity.this.fvI = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvj.a(PbActivity.this.fwt, PbActivity.this.fvG.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.fvG = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.fvH = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvI = null;
                    } else {
                        PbActivity.this.fvI = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvj.a(PbActivity.this.fwt, PbActivity.this.fvG.isGif());
                }
            } else if (view instanceof TbMemeImageView) {
                if (((TbMemeImageView) view).getBdImage() != null) {
                    PbActivity.this.fvG = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        PbActivity.this.fvH = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvI = null;
                    } else {
                        PbActivity.this.fvI = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvj.a(PbActivity.this.fwt, PbActivity.this.fvG.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fwr = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fwr != null && PbActivity.this.eWM != null) {
                        PbActivity.this.fvj.a(PbActivity.this.fws, PbActivity.this.eWM.sc() && PbActivity.this.fwr.getId() != null && PbActivity.this.fwr.getId().equals(PbActivity.this.fvh.vF()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dhp = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            if (!PbActivity.this.fuQ && z && !PbActivity.this.fvh.bdX()) {
                PbActivity.this.bcK();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aWD = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag())) {
                    FrameLayout frameLayout2 = (FrameLayout) childAt;
                    if (frameLayout2.getChildCount() <= 0) {
                        break;
                    }
                    View childAt2 = frameLayout2.getChildAt(0);
                    if (frameLayout2 != null && (childAt2 instanceof PbMainFloorPraiseFloatingView) && ((PbMainFloorPraiseFloatingView) childAt2).arl()) {
                        break;
                    }
                }
            }
            PbActivity.this.bJn.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0147a bJo = new a.InterfaceC0147a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        final int clN;

        {
            this.clN = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void W(int i, int i2) {
            if (ad(i2) && PbActivity.this.fvj != null && PbActivity.this.fuO != null) {
                PbActivity.this.fvj.bgh();
                PbActivity.this.fuO.fL(false);
                PbActivity.this.fuO.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void X(int i, int i2) {
            if (ad(i2) && PbActivity.this.fvj != null && PbActivity.this.fuO != null) {
                PbActivity.this.fuO.fL(true);
                if (Math.abs(i2) > this.clN) {
                    PbActivity.this.fuO.hideFloatingView();
                }
                if (PbActivity.this.bcO()) {
                    PbActivity.this.fvj.bfA();
                    PbActivity.this.fvj.bfB();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void Y(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fwv = null;
    private final m.a fww = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void h(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.k.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.k.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fwv = str2;
                PbActivity.this.fvj.rt(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fwx = -1;
    private int fwy = -1;
    private CustomMessageListener fwB = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.adq == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0102a) {
                    if (aVar.adr != null && !aVar.adr.hasError() && aVar.adr.getError() == 0) {
                        if (PbActivity.this.fvj != null) {
                            PbActivity.this.fvj.y(((a.C0102a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bcZ();
                        }
                    } else if (z) {
                        if (aVar.adr != null && aVar.adr.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.adr.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.k.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.adr != null && !aVar.adr.hasError() && aVar.adr.getError() == 0) {
                        if (PbActivity.this.fvj != null && PbActivity.this.fvj != null) {
                            PbActivity.this.fvj.y(((a.C0102a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.adr != null && aVar.adr.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.adr.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.k.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.adr == null || aVar.adr.hasError() || aVar.adr.getError() != 0) {
                        if (z) {
                            if (aVar.adr != null && aVar.adr.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.adr.getErrorString());
                            } else {
                                PbActivity.this.showToast(d.k.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.k.channel_need_push), 1).show();
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void i(Object obj);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public ArrayList<String> fxb;
        public ConcurrentHashMap<String, ImageUrlData> fxc;
        public boolean fxe;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fxd = false;
        public boolean fxf = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes2.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d bcm() {
        return this.fvw;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        if (kVar.bbG() != null) {
            String id = kVar.bbG().getId();
            ArrayList<PostData> baX = this.fvh.getPbData().baX();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= baX.size()) {
                    break;
                }
                PostData postData = baX.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> bbK = kVar.bbK();
                    postData.tK(kVar.getTotalCount());
                    if (postData.bxz() != null && bbK != null) {
                        Iterator<PostData> it = bbK.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.vw() != null && (metaData = postData.getUserMap().get(next.vw().getUserId())) != null) {
                                next.a(metaData);
                                next.mI(true);
                                next.b(getPageContext(), this.fvh.rn(metaData.getUserId()));
                            }
                        }
                        postData.bxz().clear();
                        postData.bxz().addAll(bbK);
                    }
                    if (postData.bxv() != null) {
                        postData.bxw();
                    }
                }
            }
            if (!this.fvh.getIsFromMark()) {
                this.fvj.n(this.fvh.getPbData());
            }
            c(kVar);
        }
    }

    public void bcn() {
        com.baidu.tieba.pb.data.d pbData;
        bc baV;
        if (!this.fvZ) {
            if (!com.baidu.adp.lib.util.l.jU()) {
                showToast(d.k.no_network_guide);
            } else if (this.fwc) {
                this.fvZ = true;
                if (this.fvh != null && (pbData = this.fvh.getPbData()) != null && (baV = pbData.baV()) != null) {
                    int isLike = baV.vj() == null ? 0 : baV.vj().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10796").ah("tid", baV.getId()));
                    }
                    if (this.fwa != null) {
                        this.fwa.a(baV.vM(), baV.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(d.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
                bVar.cg(d.k.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.k.delete);
                    strArr[1] = z ? getResources().getString(d.k.un_mute) : getResources().getString(d.k.mute);
                    bVar.a(strArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fvj.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fvD);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fvD);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.k.un_mute) : getResources().getString(d.k.mute);
                    bVar.a(strArr2, new b.InterfaceC0104b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fvD);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fvD);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).xq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kD(int i) {
        bc baV;
        String str;
        String D;
        if (this.fvh != null && this.fvh.getPbData() != null && (baV = this.fvh.getPbData().baV()) != null) {
            if (i == 1) {
                PraiseData vj = baV.vj();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (vj == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        baV.a(praiseData);
                    } else {
                        baV.vj().getUser().add(0, metaData);
                        baV.vj().setNum(baV.vj().getNum() + 1);
                        baV.vj().setIsLike(i);
                    }
                }
                if (baV.vj() != null) {
                    if (baV.vj().getNum() < 1) {
                        D = getResources().getString(d.k.zan);
                    } else {
                        D = com.baidu.tbadk.core.util.ap.D(baV.vj().getNum());
                    }
                    this.fvj.N(D, true);
                }
            } else if (baV.vj() != null) {
                baV.vj().setIsLike(i);
                baV.vj().setNum(baV.vj().getNum() - 1);
                ArrayList<MetaData> user = baV.vj().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            baV.vj().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (baV.vj().getNum() < 1) {
                    str = getResources().getString(d.k.zan);
                } else {
                    str = baV.vj().getNum() + "";
                }
                this.fvj.N(str, false);
            }
            if (this.fvh.bdQ()) {
                this.fvj.bfE().notifyDataSetChanged();
            } else {
                this.fvj.o(this.fvh.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fvh.z(bundle);
        if (this.djz != null) {
            this.djz.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fvw.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fuU = System.currentTimeMillis();
        this.fvB = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cQb = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fvb = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fvb) && intent.getData() != null) {
                this.fvb = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fvb)) {
                this.fuP = true;
            }
            this.fwx = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fwy = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fwz = intent.getStringExtra("key_manga_title");
            this.fvs = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fvt = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bcO()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.fvK = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.cQb = System.currentTimeMillis();
        }
        this.aTK = this.fuU - this.cQb;
        super.onCreate(bundle);
        this.fuS = 0;
        y(bundle);
        if (this.fvh != null && this.fvh.getPbData() != null) {
            this.fvh.getPbData().rg(this.source);
        }
        initUI();
        if (intent != null && this.fvj != null) {
            this.fvj.fEq = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fvE == null) {
                    this.fvE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fvj.rv("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fvE, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fvh != null && this.fvh.getPbData() != null) {
                this.fvh.rq(stringExtra);
            }
        }
        this.djz = new VoiceManager();
        this.djz.onCreate(getPageContext());
        initData(bundle);
        this.fvv = new com.baidu.tbadk.editortools.pb.f();
        bco();
        this.fvw = (com.baidu.tbadk.editortools.pb.d) this.fvv.aY(getActivity());
        this.fvw.b(this);
        this.fvw.a(this.aOd);
        this.fvw.a(this.aNW);
        this.fvw.a(this, bundle);
        this.fvw.Hy().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fvw.Hy().bE(true);
        jN(true);
        this.fvj.setEditorTools(this.fvw.Hy());
        this.fvw.a(this.fvh.bdZ(), this.fvh.bdP(), this.fvh.bes());
        registerListener(this.fvR);
        if (!this.fvh.bdW()) {
            this.fvw.gP(this.fvh.bdP());
        }
        if (this.fvh.bet()) {
            this.fvw.gN(getPageContext().getString(d.k.pb_reply_hint_from_smart_frs));
        } else {
            this.fvw.gN(getPageContext().getString(d.k.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fvQ);
        registerListener(this.fvS);
        registerListener(this.fvT);
        registerListener(this.dkI);
        registerListener(this.fwh);
        registerListener(this.fvP);
        this.fvu = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gMv);
        this.fvu.bxd();
        registerListener(this.fvV);
        registerListener(this.mAttentionListener);
        if (this.fvh != null) {
            this.fvh.bej();
        }
        registerListener(this.fwk);
        registerListener(this.fwB);
        registerListener(this.dkP);
        if (this.fvj != null && this.fvj.bgl() != null && this.fvj.bgm() != null) {
            this.fuO = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.fvj.bgl(), this.fvj.bgm(), this.fvj.bfv());
            this.fuO.a(this.fwd);
        }
        if (this.fuN && this.fvj != null && this.fvj.bgm() != null) {
            this.fvj.bgm().setVisibility(8);
        }
        this.fvC = new com.baidu.tbadk.core.view.d();
        this.fvC.avm = 1000L;
        registerListener(this.fwg);
        registerListener(this.fwe);
        registerListener(this.fwf);
        this.fvD = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fvD;
        userMuteAddAndDelCustomMessage.setTag(this.fvD);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fvD;
        userMuteCheckCustomMessage.setTag(this.fvD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fvh.beq().a(this.cby);
        if ("from_tieba_kuang".equals(this.fvb) && this.fvb != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12264").r("obj_type", 2).ah("tid", this.fvh.bdP()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                    @Override // com.baidu.tbadk.core.e
                    public void an(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
            httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bg("shoubai://internal?type=pb&param=" + this.fvh.bdP()));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        this.fvo = new av();
        if (this.fvw.HX() != null) {
            this.fvo.g(this.fvw.HX().getInputView());
        }
        this.fvw.a(this.aNX);
        this.dyM = new ShareSuccessReplyToServerModel();
        a(this.fvM);
        this.eEi = new com.baidu.tbadk.core.util.ak(getPageContext());
        this.eEi.a(new ak.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.ak.aqY) {
                        PbActivity.this.fvw.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.ak.aqZ && PbActivity.this.fvj != null && PbActivity.this.fvj.bfn() != null && PbActivity.this.fvj.bfn().bdG() != null) {
                        PbActivity.this.fvj.bfn().bdG().Iq();
                    } else if (i == com.baidu.tbadk.core.util.ak.ara) {
                        PbActivity.this.c(PbActivity.this.fvy);
                    }
                }
            }
        });
        this.fvi = new com.baidu.tieba.pb.pb.report.a(this);
        this.fvi.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.fuU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bco() {
        if (this.fvv != null && this.fvh != null) {
            this.fvv.setForumName(this.fvh.bdO());
            if (this.fvh.getPbData() != null && this.fvh.getPbData().baT() != null) {
                this.fvv.a(this.fvh.getPbData().baT());
            }
            this.fvv.setFrom("pb");
            this.fvv.a(this.fvh);
        }
    }

    public String bcp() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b bcq() {
        return this.fuO;
    }

    private void jN(boolean z) {
        this.fvw.bI(z);
        this.fvw.bJ(z);
        this.fvw.bK(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().bbt() && !z && this.fvj != null && this.fvj.getView() != null) {
            this.fvj.getView().setSystemUiVisibility(4);
        }
        this.fvz = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.djz != null) {
            this.djz.onStart(getPageContext());
        }
    }

    public at bcr() {
        return this.fvj;
    }

    public PbModel bca() {
        return this.fvh;
    }

    public void rh(String str) {
        if (this.fvh != null && !StringUtils.isNull(str) && this.fvj != null) {
            this.fvj.kG(true);
            this.fvh.rh(str);
            this.fva = true;
            this.fvj.bfX();
            this.fvj.bgg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fuQ = false;
        } else {
            this.fuQ = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fuS = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fuS == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.djz != null) {
            this.djz.onPause(getPageContext());
        }
        if (this.fvj != null) {
            this.fvj.onPause();
        }
        if (!this.fvh.bdW()) {
            this.fvw.gO(this.fvh.bdP());
        }
        if (this.fvh != null) {
            this.fvh.bek();
        }
        MessageManager.getInstance().unRegisterListener(this.ehV);
        aEl();
        MessageManager.getInstance().unRegisterListener(this.fwe);
        MessageManager.getInstance().unRegisterListener(this.fwf);
        MessageManager.getInstance().unRegisterListener(this.fwg);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bcs() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fvh.getPbData(), this.fvh.bdQ(), this.fvh.getRequestType());
        return (a2 == null || a2.vw() == null || a2.vw().getGodUserData() == null || a2.vw().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fuQ = false;
        super.onResume();
        if (this.fvd) {
            this.fvd = false;
            bcU();
        }
        if (bcs()) {
            this.fuX = System.currentTimeMillis();
        } else {
            this.fuX = -1L;
        }
        if (this.fvj != null && this.fvj.getView() != null) {
            if (!this.eZH) {
                bcL();
            } else {
                hideLoadingView(this.fvj.getView());
            }
            this.fvj.onResume();
        }
        if (this.fuS == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fvj != null) {
            noNetworkView = this.fvj.bfk();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.jD()) {
            noNetworkView.aR(false);
        }
        if (this.djz != null) {
            this.djz.onResume(getPageContext());
        }
        registerListener(this.ehV);
        this.fvr = false;
        bcT();
        registerListener(this.fwe);
        registerListener(this.fwf);
        registerListener(this.fwg);
        if (this.dki) {
            bcK();
            this.dki = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.e
                public void an(boolean z) {
                    if (z) {
                        KuangFloatingViewController.getInstance().showFloatingView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fvj.kv(z);
        if (this.fvp != null) {
            this.fvp.kh(z);
        }
        if (z && this.fvr) {
            this.fvj.bfJ();
            this.fvh.kd(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fuX > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").ah("obj_duration", (System.currentTimeMillis() - this.fuX) + ""));
            this.fuX = 0L;
        }
        if (bcr().bfn() != null) {
            bcr().bfn().onStop();
        }
        if (this.fvj.fEx != null && !this.fvj.fEx.ajh()) {
            this.fvj.fEx.aPF();
        }
        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().baT() != null && this.fvh.getPbData().baV() != null) {
            com.baidu.tbadk.distribute.a.Hj().a(getPageContext().getPageActivity(), "pb", this.fvh.getPbData().baT().getId(), com.baidu.adp.lib.g.b.c(this.fvh.getPbData().baV().getId(), 0L));
        }
        if (this.djz != null) {
            this.djz.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.fuV && this.fvj != null) {
            this.fuV = true;
            this.fvj.bgc();
            a(false, (PostData) null);
        }
        if (this.fvh != null) {
            this.fvh.cancelLoadData();
            this.fvh.destory();
            if (this.fvh.bep() != null) {
                this.fvh.bep().onDestroy();
            }
        }
        if (this.fvw != null) {
            this.fvw.onDestroy();
        }
        if (this.cxj != null) {
            this.cxj.cancelLoadData();
        }
        if (this.fvj != null) {
            this.fvj.onDestroy();
            if (this.fvj.fEx != null) {
                this.fvj.fEx.aPF();
            }
        }
        if (this.fuW != null) {
            this.fuW.KC();
        }
        if (this.fuO != null) {
            this.fuO.Ly();
        }
        super.onDestroy();
        if (this.djz != null) {
            this.djz.onDestory(getPageContext());
        }
        this.fvj.bfX();
        MessageManager.getInstance().unRegisterListener(this.fwe);
        MessageManager.getInstance().unRegisterListener(this.fwf);
        MessageManager.getInstance().unRegisterListener(this.fwg);
        MessageManager.getInstance().unRegisterListener(this.fvD);
        MessageManager.getInstance().unRegisterListener(this.fwh);
        MessageManager.getInstance().unRegisterListener(this.dkP);
        this.fvB = null;
        this.fvC = null;
        com.baidu.tieba.recapp.d.a.bpy().bpA();
        if (this.fvE != null) {
            getSafeHandler().removeCallbacks(this.fvE);
        }
        if (this.fve != null) {
            this.fve.cancelLoadData();
        }
        if (this.fvj != null && this.fvj.fEx != null) {
            this.fvj.fEx.bgT();
        }
        if (this.dyM != null) {
            this.dyM.cancelLoadData();
        }
        this.fvo.onDestroy();
        if (this.dkm != null) {
            this.dkm.onDestroy();
        }
        if (this.fvh != null && this.fvh.ber() != null) {
            this.fvh.ber().onDestroy();
        }
        if (this.eEi != null) {
            this.eEi.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bfE;
        ArrayList<PostData> bds;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.BX() && this.fvj != null && (bfE = this.fvj.bfE()) != null && (bds = bfE.bds()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bds.iterator();
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
                        bVar.czg = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ajd == 1 && !TextUtils.isEmpty(id)) {
                    next.ajd = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.czg = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fvh == null || this.fvh.getPbData() == null || this.fvh.getPbData().baT() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fvh.getPbData().baT().getFirst_class();
                    str2 = this.fvh.getPbData().baT().getSecond_class();
                    str = this.fvh.getPbData().baT().getId();
                    str4 = this.fvh.bdP();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Ca());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fvj.onChangeSkinType(i);
            if (this.fvw != null && this.fvw.Hy() != null) {
                this.fvw.Hy().onChangeSkinType(i);
            }
            if (this.fvj.bfk() != null) {
                this.fvj.bfk().onChangeSkinType(getPageContext(), i);
            }
            this.fvo.onChangeSkinType();
            if (this.dkm != null) {
                this.dkm.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fvj = new at(this, this.dlq, this.bfS);
        this.bJn = new com.baidu.tieba.f.b(getActivity());
        this.bJn.a(fwu);
        this.bJn.a(this.bJo);
        this.fvj.setOnScrollListener(this.mOnScrollListener);
        this.fvj.e(this.fwo);
        this.fvj.a(this.boQ);
        this.fvj.jH(com.baidu.tbadk.core.i.tt().tz());
        this.fvj.setOnImageClickListener(this.bfR);
        this.fvj.b(this.aHk);
        this.fvj.h(this.dhp);
        this.fvj.a(this.fwm);
        this.fvj.kv(this.mIsLogin);
        if (getIntent() != null) {
            this.fvj.kH(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fvj.bfm().setFromForumId(this.fvh.getFromForumId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZ(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.gMX && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.tt().tz()) {
                    return rk(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fvh == null || this.fvh.getPbData() == null) {
                        return true;
                    }
                    if (bcr().bfn() != null) {
                        bcr().bfn().bdB();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.fvh.getPbData().baT());
                    kVar.X(this.fvh.getPbData().baV());
                    kVar.d(postData);
                    bcr().bfm().d(kVar);
                    bcr().bfm().setPostId(postData.getId());
                    b(view, postData.vw().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fvw != null) {
                        this.fvj.kC(this.fvw.Ie());
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
        if (this.fvj != null) {
            if (z && !this.eZH) {
                bcL();
            } else {
                hideLoadingView(this.fvj.getView());
            }
            if (z && this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().bbt() && this.fvj.getView() != null) {
                this.fvj.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void bct() {
        if (this.fuT == null) {
            this.fuT = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fuT.a(new String[]{getPageContext().getString(d.k.call_phone), getPageContext().getString(d.k.sms_phone), getPageContext().getString(d.k.search_in_baidu)}, new b.InterfaceC0104b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fuI = PbActivity.this.fuI.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuI);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fvh.bdP(), PbActivity.this.fuI, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fuI = PbActivity.this.fuI.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuI);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fvh.bdP(), PbActivity.this.fuI, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fuI = PbActivity.this.fuI.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuI);
                        bVar.dismiss();
                    }
                }
            }).ch(b.a.alC).ci(17).d(getPageContext());
        }
    }

    private void y(Bundle bundle) {
        this.fvh = new PbModel(this);
        this.fvh.a(this.fwj);
        if (this.fvh.ben() != null) {
            this.fvh.ben().a(this.fww);
        }
        if (this.fvh.bem() != null) {
            this.fvh.bem().a(this.fvU);
        }
        if (this.fvh.bep() != null) {
            this.fvh.bep().b(this.fvO);
        }
        if (bundle != null) {
            this.fvh.initWithBundle(bundle);
        } else {
            this.fvh.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fvh.kg(true);
        }
        aj.beX().M(this.fvh.bdN(), this.fvh.getIsFromMark());
        if (StringUtils.isNull(this.fvh.bdP())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fvb) && this.fvb != null) {
            this.fvh.qM(6);
        }
        if (this.fvh.beo() != null) {
            this.fvh.beo().a(this.fvN);
        }
        if (this.fvh.ber() != null) {
            this.fvh.ber().a(this.dkq);
        }
        this.fvh.JW();
    }

    private void initData(Bundle bundle) {
        this.eWM = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eWM != null) {
            this.eWM.a(this.fwl);
        }
        this.cxj = new ForumManageModel(this);
        this.cxj.setLoadDataCallBack(this.cxn);
        this.ard = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fvj.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void i(Object obj) {
                if (!com.baidu.adp.lib.util.j.jD()) {
                    PbActivity.this.showToast(d.k.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fvh.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvh.getPbData().baT().getId(), PbActivity.this.fvh.getPbData().baT().getName(), PbActivity.this.fvh.getPbData().baV().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fwa.setUniqueId(getUniqueId());
        this.fwa.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fvj.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fvD;
        userMuteCheckCustomMessage.setTag(this.fvD);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bcu() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fvh != null && (pbData = this.fvh.getPbData()) != null) {
            return pbData.bbg().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.baV() != null) {
            if (dVar.baV().getThreadType() == 0) {
                return 1;
            }
            if (dVar.baV().getThreadType() == 54) {
                return 2;
            }
            if (dVar.baV().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData ba(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bxO()) {
                postData.cV(postData.bxN() - 1);
            } else {
                postData.cV(postData.bxN() + 1);
                com.baidu.tieba.n.a.bor().y(getPageContext());
            }
            postData.mJ(!postData.bxO());
            ((PbFloorAgreeView) view).a(postData.bxO(), postData.bxN(), true);
            final int i = postData.bxO() ? 0 : 1;
            this.fvh.beo().a(postData.getId(), i, new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
                @Override // com.baidu.tieba.pb.pb.main.r.a
                public void qz(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).qX(i2);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.r.a
                public void c(CustomDialogData customDialogData) {
                    customDialogData.type = 0;
                    com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                }
            });
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.an bcv() {
        return new com.baidu.tbadk.core.util.an("c12003").ah("tid", this.fvh.fAv).r("obj_type", 0).ah(ImageViewerConfig.FORUM_ID, this.fvh.getForumId()).r("obj_param1", this.fvh.getPbData().baV().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && bcw()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
                @Override // java.lang.Runnable
                public void run() {
                    int e;
                    int aj = (com.baidu.adp.lib.util.l.aj(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        e = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.e(PbActivity.this.getPageContext().getPageActivity(), d.e.ds120);
                    } else {
                        e = com.baidu.adp.lib.util.l.e(PbActivity.this.getPageContext().getPageActivity(), d.e.ds640);
                    }
                    int i = e - aj;
                    if (i > 0) {
                        PbActivity.this.bcr().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bcr().bfn() != null) {
                        PbActivity.this.fvw.Hy().setVisibility(8);
                        PbActivity.this.bcr().bfn().bS(str, str2);
                        com.baidu.tbadk.editortools.pb.g bdG = PbActivity.this.bcr().bfn().bdG();
                        if (bdG != null && PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null) {
                            bdG.a(PbActivity.this.fvh.getPbData().uu());
                        }
                        if (PbActivity.this.fvo.bgz() == null && PbActivity.this.bcr().bfn().bdG().Iy() != null) {
                            PbActivity.this.bcr().bfn().bdG().Iy().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fvo != null && PbActivity.this.fvo.bgy() != null) {
                                        if (!PbActivity.this.fvo.bgy().bGB()) {
                                            PbActivity.this.fvo.kJ(false);
                                        }
                                        PbActivity.this.fvo.bgy().nA(false);
                                    }
                                }
                            });
                            PbActivity.this.fvo.h(PbActivity.this.bcr().bfn().bdG().Iy().getInputView());
                            PbActivity.this.bcr().bfn().bdG().a(PbActivity.this.fvA);
                        }
                    }
                    PbActivity.this.bcr().bgg();
                }
            }, 500L);
        }
    }

    public boolean bcw() {
        if (this.eEi == null || this.fvh.getPbData() == null || this.fvh.getPbData().uu() == null) {
            return true;
        }
        return this.eEi.cN(this.fvh.getPbData().uu().replyPrivateFlag);
    }

    public boolean qv(int i) {
        if (this.eEi == null || this.fvh.getPbData() == null || this.fvh.getPbData().uu() == null) {
            return true;
        }
        return this.eEi.u(this.fvh.getPbData().uu().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.fvh != null && this.fvh.getPbData() != null && postData.bxC() > 1) {
            String bdP = this.fvh.bdP();
            String id = postData.getId();
            int bbh = this.fvh.getPbData() != null ? this.fvh.getPbData().bbh() : 0;
            c rl = rl(id);
            if (rl != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bdP, id, "pb", true, null, false, null, bbh, postData.bhG(), this.fvh.getPbData().uu(), false, postData.vw() != null ? postData.vw().getIconInfo() : null).addBigImageData(rl.fxb, rl.fxc, rl.fxd, rl.index);
                addBigImageData.setKeyPageStartFrom(this.fvh.bev());
                addBigImageData.setFromFrsForumId(this.fvh.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        aq aqVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.jU()) {
                showToast(d.k.no_network_guide);
            } else if (bca() != null && bca().getPbData() != null && bca().getPbData().bbs() != null) {
                com.baidu.tieba.pb.data.j bbs = bca().getPbData().bbs();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof aq)) {
                    aqVar = null;
                } else {
                    aqVar = (aq) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (bbs != null) {
                    int i3 = -1;
                    if (z) {
                        bbs.qn(i);
                    } else if (bbs.bbA()) {
                        bbs.bbD();
                        i3 = 1;
                    } else {
                        bbs.qp(i);
                        i3 = 0;
                        com.baidu.tieba.n.a.bor().y(getPageContext());
                    }
                    bbs.qo(i2);
                    r.a aVar = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                        @Override // com.baidu.tieba.pb.pb.main.r.a
                        public void qz(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.r.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.fvh != null && this.fvh.beo() != null) {
                        String str = "";
                        if (this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null) {
                            str = this.fvh.getPbData().baV().vM();
                        }
                        if (this.fvh.getPbData() != null) {
                            this.fvh.getPbData().a(bbs);
                        }
                        if (z) {
                            this.fvh.beo().a(str, 3, i, this.fvh.getForumId(), aVar);
                        } else {
                            this.fvh.beo().a(str, i3, 3, i, this.fvh.getForumId(), aVar);
                            com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i();
                            iVar.fta = i3;
                            iVar.ftb = bbs;
                            iVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016551, iVar));
                        }
                    }
                    if (aqVar != null) {
                        aqVar.b(bbs);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bcx() {
        if (this.fvh.getPbData() == null || this.fvh.getPbData().baV() == null) {
            return -1;
        }
        return this.fvh.getPbData().baV().vY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.th(this.fvh.getForumId()) && this.fvh.getPbData() != null && this.fvh.getPbData().baT() != null) {
            if (this.fvh.getPbData().baT().isLike() == 1) {
                this.fvh.ber().ch(this.fvh.getForumId(), this.fvh.bdP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jO(boolean z) {
        if (this.fvh == null || this.fvh.getPbData() == null) {
            return false;
        }
        return ((this.fvh.getPbData().bbh() != 0) || this.fvh.getPbData().baV() == null || this.fvh.getPbData().baV().vw() == null || TextUtils.equals(this.fvh.getPbData().baV().vw().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bcz() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.o.s.Lc()) {
            return "";
        }
        PostData bbc = bbc();
        if (this.fvh == null || (pbData = this.fvh.getPbData()) == null || pbData.getUserData() == null || pbData.baV() == null || bbc == null || bbc.vw() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bbc.vw().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.baV().ve() == 0) {
            return "";
        }
        if (pbData.baV().ve() == 0) {
            return getPageContext().getString(d.k.fans_call);
        }
        return getPageContext().getString(d.k.haved_fans_call);
    }

    private boolean jP(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.u uVar;
        if (z) {
            return true;
        }
        if (this.fvh == null || this.fvh.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fvh.getPbData();
        if (pbData.bbh() == 0) {
            List<com.baidu.tbadk.core.data.az> bbq = pbData.bbq();
            if (com.baidu.tbadk.core.util.w.z(bbq) > 0) {
                for (com.baidu.tbadk.core.data.az azVar : bbq) {
                    if (azVar != null && (uVar = azVar.ahV) != null && uVar.afV && !uVar.isDeleted && (uVar.type == 1 || uVar.type == 2)) {
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

    private boolean jQ(boolean z) {
        return (z || this.fvh == null || this.fvh.getPbData() == null || this.fvh.getPbData().bbh() == 0) ? false : true;
    }

    public void bcA() {
        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null && this.fvh.getPbData().baV().vw() != null) {
            if (this.fvj != null) {
                this.fvj.bfl();
            }
            bc baV = this.fvh.getPbData().baV();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), baV.vw().getUserId());
            ab abVar = new ab();
            int bbh = this.fvh.getPbData().bbh();
            if (bbh == 1) {
                abVar.fCv = true;
                abVar.fCu = true;
                abVar.fCC = baV.vr() == 1;
                abVar.fCB = baV.vs() == 1;
            } else {
                abVar.fCv = false;
                abVar.fCu = false;
            }
            if (bbh == 1002 && !equals) {
                abVar.fCG = true;
            }
            abVar.fCs = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.fCw = jP(equals);
            abVar.fCx = bcB();
            abVar.fCy = jQ(equals);
            abVar.nT = this.fvh.bdQ();
            abVar.fCt = true;
            abVar.fto = this.eWM != null && this.eWM.sc();
            abVar.fCr = jO(equals);
            abVar.fCE = bcz();
            abVar.fCq = equals && this.fvj.bfQ();
            abVar.fCz = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fCA = true;
            abVar.isHostOnly = this.fvh.getHostMode();
            abVar.fCD = true;
            if (baV.vN() == null) {
                abVar.fCF = true;
            } else {
                abVar.fCF = false;
            }
            this.fvj.fEx.a(abVar);
        }
    }

    private boolean bcB() {
        if (this.fvh != null && this.fvh.bdQ()) {
            return this.fvh.getPageData() == null || this.fvh.getPageData().uG() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null) {
            e(postData);
        }
    }

    public int bcC() {
        if (bcr() == null || bcr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bcr().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fsW) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bcD() {
        if (bcr() == null || bcr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bcr().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.gMW) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bcK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.dD(getResources().getString(d.k.mark_done));
            aVar.aD(true);
            aVar.dE(getResources().getString(d.k.mark_like));
            aVar.aC(true);
            aVar.aw(false);
            aVar.b(getResources().getString(d.k.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").ah(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.k.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").ah(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.ard.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fvh.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).xn();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fvj.bfK();
        this.fvh.kf(z);
        if (this.eWM != null) {
            this.eWM.ah(z);
            if (markData != null) {
                this.eWM.a(markData);
            }
        }
        if (this.fvh.sc()) {
            bcI();
        } else {
            this.fvj.n(this.fvh.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qt(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri(String str) {
        this.fvi.rE(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fvh.bdW()) {
                    antiData.setBlock_forum_name(this.fvh.getPbData().baT().getName());
                    antiData.setBlock_forum_id(this.fvh.getPbData().baT().getId());
                    antiData.setUser_name(this.fvh.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fvh.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.tQ(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.arN));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.arN));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.arN));
            }
        } else if (i == 230277) {
            gV(str);
        } else {
            this.fvj.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.fvj.a(0, bVar.Fa, bVar.gPt, z);
            if (bVar.Fa) {
                if (bVar.gPr == 1) {
                    ArrayList<PostData> baX = this.fvh.getPbData().baX();
                    int size = baX.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(baX.get(i).getId())) {
                            i++;
                        } else {
                            baX.remove(i);
                            break;
                        }
                    }
                    this.fvj.n(this.fvh.getPbData());
                } else if (bVar.gPr == 0) {
                    bcE();
                } else if (bVar.gPr == 2) {
                    ArrayList<PostData> baX2 = this.fvh.getPbData().baX();
                    int size2 = baX2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= baX2.get(i2).bxz().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(baX2.get(i2).bxz().get(i3).getId())) {
                                i3++;
                            } else {
                                baX2.get(i2).bxz().remove(i3);
                                baX2.get(i2).bxB();
                                z2 = true;
                                break;
                            }
                        }
                        baX2.get(i2).tM(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fvj.n(this.fvh.getPbData());
                    }
                    a(bVar, this.fvj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fvj.a(this.cxj.getLoadDataMode(), gVar.Fa, gVar.gPt, false);
            if (gVar.Fa) {
                this.fvl = true;
                if (i == 2 || i == 3) {
                    this.fvm = true;
                    this.fvn = false;
                } else if (i == 4 || i == 5) {
                    this.fvm = false;
                    this.fvn = true;
                }
                if (i == 2) {
                    this.fvh.getPbData().baV().bU(1);
                    this.fvh.setIsGood(1);
                } else if (i == 3) {
                    this.fvh.getPbData().baV().bU(0);
                    this.fvh.setIsGood(0);
                } else if (i == 4) {
                    this.fvh.getPbData().baV().bT(1);
                    this.fvh.iX(1);
                } else if (i == 5) {
                    this.fvh.getPbData().baV().bT(0);
                    this.fvh.iX(0);
                }
                this.fvj.c(this.fvh.getPbData(), this.fvh.bdQ());
            }
        }
    }

    private void bcE() {
        if (this.fvh.bdR() || this.fvh.bdT()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fvh.bdP());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fvh.bdP()));
        if (bcJ()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcF() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bbe;
        boolean z = false;
        if (this.fvj != null) {
            this.fvj.bfX();
        }
        if (this.fvh != null && this.fvh.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fvh.getPbData().baV().getId();
            if (this.fvh.isShareThread() && this.fvh.getPbData().baV().akk != null) {
                historyMessage.threadName = this.fvh.getPbData().baV().akk.showText;
            } else {
                historyMessage.threadName = this.fvh.getPbData().baV().getTitle();
            }
            if (this.fvh.isShareThread() && !bdb()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fvh.getPbData().baT().getName();
            }
            ArrayList<PostData> baX = this.fvh.getPbData().baX();
            int bfM = this.fvj != null ? this.fvj.bfM() : 0;
            if (baX != null && bfM >= 0 && bfM < baX.size()) {
                historyMessage.postID = baX.get(bfM).getId();
            }
            historyMessage.isHostOnly = this.fvh.getHostMode();
            historyMessage.isSquence = this.fvh.bdQ();
            historyMessage.isShareThread = this.fvh.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fvw != null) {
            this.fvw.onDestroy();
        }
        if (this.fuR && bcr() != null) {
            bcr().bgq();
        }
        if (this.fvh != null && (this.fvh.bdR() || this.fvh.bdT())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fvh.bdP());
            if (this.fvl) {
                if (this.fvn) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fvh.bdV());
                }
                if (this.fvm) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fvh.getIsGood());
                }
            }
            if (this.fvh.getPbData() != null && System.currentTimeMillis() - this.fuU >= 40000 && (bbe = this.fvh.getPbData().bbe()) != null && !com.baidu.tbadk.core.util.w.A(bbe.getDataList())) {
                intent.putExtra("guess_like_data", bbe);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fvK);
            }
            setResult(-1, intent);
        }
        if (bcJ()) {
            if (this.fvh != null && this.fvj != null && this.fvj.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fvh.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bbb() && !this.fva) {
                        aj beX = aj.beX();
                        com.baidu.tieba.pb.data.d pbData2 = this.fvh.getPbData();
                        Parcelable onSaveInstanceState = this.fvj.getListView().onSaveInstanceState();
                        boolean bdQ = this.fvh.bdQ();
                        boolean hostMode = this.fvh.getHostMode();
                        if (this.fvj.bfv() != null && this.fvj.bfv().getVisibility() == 0) {
                            z = true;
                        }
                        beX.a(pbData2, onSaveInstanceState, bdQ, hostMode, z);
                        if (this.fvJ >= 0 || this.fvh.bex() != null) {
                            aj.beX().i(this.fvh.bex());
                            aj.beX().h(this.fvh.bey());
                            aj.beX().qO(this.fvh.bez());
                        }
                    }
                }
            } else {
                aj.beX().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fvj == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fvj.qS(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qw(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fvj.bfl();
            this.fvj.bfn().bdB();
            this.fvj.kE(false);
        }
        this.fvj.bfo();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fvw.resetData();
                        this.fvw.b(writeData);
                        this.fvw.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k eN = this.fvw.Hy().eN(6);
                        if (eN != null && eN.aMf != null) {
                            eN.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fvw.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fvj.bfn() != null && this.fvj.bfn().bdG() != null) {
                            com.baidu.tbadk.editortools.pb.g bdG = this.fvj.bfn().bdG();
                            bdG.b(writeData);
                            bdG.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k eN2 = bdG.Hy().eN(6);
                            if (eN2 != null && eN2.aMf != null) {
                                eN2.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bdG.Iq();
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
        this.fvw.onActivityResult(i, i2, intent);
        if (this.fve != null) {
            this.fve.onActivityResult(i, i2, intent);
        }
        if (bcr().bfn() != null) {
            bcr().bfn().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bcH();
                    return;
                case 13008:
                    aj.beX().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fvh != null) {
                                PbActivity.this.fvh.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bor().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fvh != null) {
                        a(bcG(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    J(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bor().x(getPageContext());
                        bcy();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dyM != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dyM.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void Ew() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59.1
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
                    this.fvj.jM(false);
                    if (this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null && this.fvh.getPbData().baV().vP() != null) {
                        this.fvh.getPbData().baV().vP().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fvy = emotionImageData;
                        if (qv(com.baidu.tbadk.core.util.ak.ara)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fvj != null && this.fvj.fEx != null) {
                        this.fvj.fEx.sN();
                        this.fvj.fEx.bgN();
                        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null) {
                            this.fvh.getPbData().baV().bP(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fvf != null) {
                        this.fvj.bj(this.fvf);
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
            if (this.fve == null) {
                this.fve = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fve.b(this.aNW);
                this.fve.c(this.aOd);
            }
            this.fve.a(emotionImageData, bca(), bca().getPbData());
        }
    }

    private ShareFromPBMsgData bcG() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bW = this.fvh.getPbData().bW(getPageContext().getPageActivity());
        PostData bfq = this.fvj.bfq();
        String str = "";
        if (bfq != null) {
            str = bfq.getId();
            String ci = bfq.ci(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ci)) {
                bW[1] = ci;
            }
        }
        String vM = this.fvh.getPbData().baV().vM();
        if (vM != null && vM.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bW[1]);
        shareFromPBMsgData.setImageUrl(bW[0]);
        shareFromPBMsgData.setForumName(this.fvh.getPbData().baT().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fvh.getPbData().baV().getId());
        shareFromPBMsgData.setTitle(this.fvh.getPbData().baV().getTitle());
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bcG(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null) {
                        com.baidu.tbadk.core.util.an ah = new com.baidu.tbadk.core.util.an("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fvh.getForumId()).ah("tid", PbActivity.this.fvh.bdP());
                        if (PbActivity.this.e(PbActivity.this.fvh.getPbData()) != 0) {
                            ah.r("obj_type", PbActivity.this.e(PbActivity.this.fvh.getPbData()));
                        }
                        TiebaStatic.log(ah);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ax(true);
            aVar.b(getPageContext()).xn();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.E(shareFromPBMsgData.getImageUrl(), this.fvh.getPbData().bbi() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ax(true);
            aVar.b(getPageContext()).xn();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.E(shareFromPBMsgData.getImageUrl(), this.fvh.getPbData().bbi() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcH() {
        MarkData qL;
        if (this.eWM != null && (qL = this.fvh.qL(this.fvj.bfN())) != null) {
            if (!qL.isApp() || (qL = this.fvh.qL(this.fvj.bfN() + 1)) != null) {
                this.fvj.bfI();
                this.eWM.a(qL);
                if (!this.eWM.sc()) {
                    this.eWM.se();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.eWM.sd();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcI() {
        com.baidu.tieba.pb.data.d pbData = this.fvh.getPbData();
        this.fvh.kf(true);
        if (this.eWM != null) {
            pbData.rf(this.eWM.sb());
        }
        this.fvj.n(pbData);
    }

    private boolean bcJ() {
        if (this.fvh == null) {
            return true;
        }
        if (this.fvh.sc()) {
            final MarkData bee = this.fvh.bee();
            if (bee == null || !this.fvh.getIsFromMark()) {
                return true;
            }
            final MarkData qL = this.fvh.qL(this.fvj.bfM());
            if (qL == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bee);
                setResult(-1, intent);
                return true;
            } else if (qL.getPostId() == null || qL.getPostId().equals(bee.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bee);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dE(getPageContext().getString(d.k.alert_update_mark));
                aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.eWM != null) {
                            if (PbActivity.this.eWM.sc()) {
                                PbActivity.this.eWM.sd();
                                PbActivity.this.eWM.ah(false);
                            }
                            PbActivity.this.eWM.a(qL);
                            PbActivity.this.eWM.ah(true);
                            PbActivity.this.eWM.se();
                        }
                        bee.setPostId(qL.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bee);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bcF();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bee);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bcF();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fvj != null && PbActivity.this.fvj.getView() != null) {
                            PbActivity.this.fvj.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bee);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bcF();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.xn();
                return false;
            }
        } else if (this.fvh.getPbData() == null || this.fvh.getPbData().baX() == null || this.fvh.getPbData().baX().size() <= 0 || !this.fvh.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fvj == null) {
            return null;
        }
        return this.fvj.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Oe() {
        if (this.fvj == null) {
            return 0;
        }
        return this.fvj.bfV();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Of() {
        if (this.bfI == null) {
            this.bfI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: afE */
                public ImageView mo9if() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean tz = com.baidu.tbadk.core.i.tt().tz();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(d.C0142d.common_color_10220));
                    if (tz) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(d.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public void q(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0142d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView r(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.tt().tz()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(d.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public ImageView s(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0142d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bfI;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Og() {
        if (this.bfJ == null) {
            this.bfJ = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.bfJ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Oh() {
        if (this.bfN == null) {
            this.bfN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bde */
                public GifView mo9if() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void q(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView r(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView s(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.IS();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bfN;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Oi() {
        if (this.bfK == null) {
            this.bfK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdf */
                public View mo9if() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bd */
                public void q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: be */
                public View r(View view) {
                    ((PlayVoiceBntNew) view).byM();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bf */
                public View s(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bfK;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ok() {
        this.bfM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bdg */
            public RelativeLayout mo9if() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout r(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout s(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bfM;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Bc() {
        if (this.azg == null) {
            this.azg = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.azg;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fuY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void f(Context context, String str, boolean z) {
        if (ay.rw(str) && this.fvh != null && this.fvh.bdP() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").r("obj_param1", 1).ah("post_id", this.fvh.bdP()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                hVar.mLink = str;
                hVar.type = 3;
                hVar.aLc = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
            }
        } else {
            ay.bgB().c(getPageContext(), str);
        }
        this.fuY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        ay.bgB().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fuY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fvh.getPbData();
            TbRichText aF = aF(str, i);
            if (aF != null && (tbRichTextData = aF.Nz().get(this.fwp)) != null) {
                cVar.fxb = new ArrayList<>();
                cVar.fxc = new ConcurrentHashMap<>();
                if (!tbRichTextData.NF().NR()) {
                    cVar.fxe = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fxb.add(b2);
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
                    imageUrlData.postId = aF.getPostId();
                    imageUrlData.mIsReserver = this.fvh.bed();
                    imageUrlData.mIsSeeHost = this.fvh.getHostMode();
                    cVar.fxc.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.baT() != null) {
                            cVar.forumName = pbData.baT().getName();
                            cVar.forumId = pbData.baT().getId();
                        }
                        if (pbData.baV() != null) {
                            cVar.threadId = pbData.baV().getId();
                        }
                        cVar.fxd = pbData.bbi() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fxe = true;
                int size = pbData.baX().size();
                this.fwq = false;
                cVar.index = -1;
                if (pbData.bbc() != null) {
                    PostData bbc = pbData.bbc();
                    TbRichText bxE = bbc.bxE();
                    if (!as.j(bbc)) {
                        i2 = a(bxE, aF, i, i, cVar.fxb, cVar.fxc);
                    } else {
                        i2 = a(bbc, i, cVar.fxb, cVar.fxc);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.baX().get(i4);
                    if (postData.getId() == null || pbData.bbc() == null || pbData.bbc().getId() == null || !postData.getId().equals(pbData.bbc().getId())) {
                        TbRichText bxE2 = postData.bxE();
                        if (!as.j(postData)) {
                            i3 = a(bxE2, aF, i3, i, cVar.fxb, cVar.fxc);
                        } else {
                            i3 = a(postData, i3, cVar.fxb, cVar.fxc);
                        }
                    }
                }
                if (cVar.fxb.size() > 0) {
                    cVar.lastId = cVar.fxb.get(cVar.fxb.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.baT() != null) {
                        cVar.forumName = pbData.baT().getName();
                        cVar.forumId = pbData.baT().getId();
                    }
                    if (pbData.baV() != null) {
                        cVar.threadId = pbData.baV().getId();
                    }
                    cVar.fxd = pbData.bbi() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.NF() == null) {
            return null;
        }
        return tbRichTextData.NF().NV();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.NF() == null) {
            return 0L;
        }
        return tbRichTextData.NF().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.NF() == null) {
            return false;
        }
        return tbRichTextData.NF().NW();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.NF() == null) {
            return false;
        }
        return tbRichTextData.NF().NX();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo NF;
        String str;
        if (tbRichText == tbRichText2) {
            this.fwq = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Nz().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Nz().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ak = (int) com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.NF().getWidth() * ak;
                    int height = ak * tbRichTextData.NF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.NF().NR()) {
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
                            if (tbRichTextData != null && (NF = tbRichTextData.NF()) != null) {
                                String NS = NF.NS();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = NF.NT();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = NS;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fvh.bdP(), -1L);
                                imageUrlData.mIsReserver = this.fvh.bed();
                                imageUrlData.mIsSeeHost = this.fvh.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fwq) {
                            i4 = i7 + 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i = i4;
                i5 = i3;
            }
        }
        return i;
    }

    private int a(PostData postData, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        com.baidu.tieba.tbadkCore.data.h bxL;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bxh;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bxh = (bxL = postData.bxL()).bxh()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bxh.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bxh.get(i3);
                if (jVar != null) {
                    String bxl = jVar.bxl();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(bxl)) {
                        arrayList.add(bxl);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bxl;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bxk();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fvh.bdP(), -1L);
                        imageUrlData.mIsReserver = this.fvh.bed();
                        imageUrlData.mIsSeeHost = this.fvh.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bxL.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bxl, imageUrlData);
                        }
                        if (!this.fwq) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    protected void e(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.fvh.vF())) {
                z = true;
            }
            MarkData g = this.fvh.g(postData);
            if (g != null) {
                this.fvj.bfI();
                if (this.eWM != null) {
                    this.eWM.a(g);
                    if (!z) {
                        this.eWM.se();
                    } else {
                        this.eWM.sd();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aF(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fvh == null || this.fvh.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fvh.getPbData();
        if (pbData.bbc() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bbc());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> baX = pbData.baX();
            a(pbData, baX);
            return a(baX, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bbg() != null && dVar.bbg().ftq != null && (list = dVar.bbg().ftq) != null && arrayList != null) {
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

    private long rj(String str) {
        ArrayList<PostData> baX;
        com.baidu.tieba.pb.data.d pbData = this.fvh.getPbData();
        if (pbData != null && (baX = pbData.baX()) != null && !baX.isEmpty()) {
            Iterator<PostData> it = baX.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bxL = next.bxL();
                if (bxL != null && bxL.gMD) {
                    Iterator<TbRichTextData> it2 = next.bxE().Nz().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.NO().getLink().equals(str)) {
                            return bxL.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Nz;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bxE = arrayList.get(i2).bxE();
            if (bxE != null && (Nz = bxE.Nz()) != null) {
                int size = Nz.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Nz.get(i4) != null && Nz.get(i4).getType() == 8) {
                        i3++;
                        if (Nz.get(i4).NF().NS().equals(str) || Nz.get(i4).NF().NT().equals(str)) {
                            int ak = (int) com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
                            int width = Nz.get(i4).NF().getWidth() * ak;
                            int height = Nz.get(i4).NF().getHeight() * ak;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fwp = i4;
                            return bxE;
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
    public void h(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.fuI = str;
            if (this.fuT == null) {
                bct();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fuT.cl(1).setVisibility(8);
            } else {
                this.fuT.cl(1).setVisibility(0);
            }
            this.fuT.xq();
            this.fuY = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.djz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcK() {
        hideNetRefreshView(this.fvj.getView());
        bcL();
        if (this.fvh.JW()) {
            this.fvj.bfI();
        }
    }

    private void bcL() {
        showLoadingView(this.fvj.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View Jn = getLoadingView().Jn();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Jn.getLayoutParams();
        layoutParams.addRule(3, this.fvj.bgl().getId());
        Jn.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atX() {
        if (this.djz != null) {
            this.djz.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qx(int i) {
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
    public void qy(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fvh.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fvh.getPbData();
            pbData.baT().getName();
            String title = pbData.baV().getTitle();
            int i2 = this.fvh.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.baT() != null) {
                if ((pbData.baT().isLike() == 1) && AddExperiencedModel.th(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fvh.bdP() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bW = pbData.bW(getPageContext().getPageActivity());
                    str = bW[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bW[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bcx() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").ah(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ah("tid", pbData.getThreadId()).ah("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aFU = true;
                    dVar.aFZ = z;
                    dVar.extData = this.fvh.bdP();
                    dVar.aGi = 3;
                    dVar.aGh = i;
                    dVar.fid = this.fvh.getForumId();
                    dVar.tid = this.fvh.bdP();
                    dVar.aGj = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fvh.getPbData().baV());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aGi);
                    bundle.putInt("obj_type", dVar.aGj);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.f(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().bbt()) {
                                PbActivity.this.fvj.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.akp().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fvh.bdP() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bW2 = pbData.bW(getPageContext().getPageActivity());
            str = bW2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bW2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bcx() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aFU = true;
            dVar2.aFZ = z;
            dVar2.extData = this.fvh.bdP();
            dVar2.aGi = 3;
            dVar2.aGh = i;
            dVar2.fid = this.fvh.getForumId();
            dVar2.tid = this.fvh.bdP();
            dVar2.aGj = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fvh.getPbData().baV());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aGi);
            bundle2.putInt("obj_type", dVar2.aGj);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.f(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fvh != null && PbActivity.this.fvh.getPbData() != null && PbActivity.this.fvh.getPbData().bbt()) {
                        PbActivity.this.fvj.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.akp().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.baV() != null) {
            if (dVar.baV().getThreadType() == 0) {
                return 1;
            }
            if (dVar.baV().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcM() {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.v
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.ti(PbActivity.this.fvh.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fvj.bgr();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Oj() {
        if (this.bfL == null) {
            this.bfL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bdh */
                public LinearLayout mo9if() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(d.g.pb_text_voice_layout);
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
                /* renamed from: c */
                public void q(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout r(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout s(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bfL;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fvj.bfD() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).ah(ImageViewerConfig.FORUM_ID, this.fvh.getPbData().getForumId()));
            } else {
                bc baV = this.fvh.getPbData().baV();
                if (view != null) {
                    boolean z = baV.vj() == null || baV.vj().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fwb > 1000) {
                            this.fwc = true;
                            bc(view);
                        } else {
                            this.fwc = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view, this.fwc);
                        } else {
                            l(view, this.fwc);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view, this.fwc);
                    } else if (motionEvent.getAction() == 3) {
                        l(view, this.fwc);
                    }
                }
            }
        }
        return false;
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fwb = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void m(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fwb = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bc(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void atY() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData Cm() {
        if (this.fvh == null || this.fvh.getPbData() == null) {
            return null;
        }
        return this.fvh.getPbData().uu();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.xp() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.xp();
            int intValue = ((Integer) sparseArray.get(at.fGk)).intValue();
            if (intValue == at.fGl) {
                if (!this.cxj.byq()) {
                    this.fvj.bfF();
                    String str = (String) sparseArray.get(d.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.cxj.tS(com.baidu.tbadk.core.util.ap.d(jSONArray));
                    }
                    this.cxj.a(this.fvh.getPbData().baT().getId(), this.fvh.getPbData().baT().getName(), this.fvh.getPbData().baV().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == at.fGm || intValue == at.fGo) {
                if (this.fvh.ben() != null) {
                    this.fvh.ben().qC(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == at.fGm) {
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
        if (sparseArray.get(d.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(d.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(d.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(d.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(d.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(d.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(d.g.tag_user_mute_msg);
        }
        if (sparseArray.get(d.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fvD);
        userMuteAddAndDelCustomMessage.setTag(this.fvD);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean rk(String str) {
        if (!StringUtils.isNull(str) && bb.aU(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(d.k.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void jR(boolean z) {
        this.fvr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bcN() {
        ArrayList<PostData> baX;
        int z;
        if (this.fvh == null || this.fvh.getPbData() == null || this.fvh.getPbData().baX() == null || (z = com.baidu.tbadk.core.util.w.z((baX = this.fvh.getPbData().baX()))) == 0) {
            return "";
        }
        if (this.fvh.bed()) {
            Iterator<PostData> it = baX.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bxC() == 1) {
                    return next.getId();
                }
            }
        }
        int bfM = this.fvj.bfM();
        PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(baX, bfM);
        if (postData == null || postData.vw() == null) {
            return "";
        }
        if (this.fvh.rn(postData.vw().getUserId())) {
            return postData.getId();
        }
        for (int i = bfM - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.d(baX, i);
            if (postData2 == null || postData2.vw() == null || postData2.vw().getUserId() == null) {
                break;
            } else if (this.fvh.rn(postData2.vw().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bfM + 1; i2 < z; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.d(baX, i2);
            if (postData3 == null || postData3.vw() == null || postData3.vw().getUserId() == null) {
                return "";
            }
            if (this.fvh.rn(postData3.vw().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (az.zV().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(rj(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fvh.getPbData().baT().getId(), this.fvh.getPbData().baT().getName(), this.fvh.getPbData().baV().getTid());
            }
            this.fuY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.dE(getResources().getString(d.k.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.dE(getResources().getString(d.k.make_sure_hide));
        }
        aVar.a(getResources().getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvh.bem() != null) {
                    PbActivity.this.fvh.bem().cK(j);
                }
            }
        });
        aVar.b(getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.ax(false);
        aVar.b(getPageContext());
        aVar.xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c rl(String str) {
        String str2;
        if (this.fvh.getPbData() == null || this.fvh.getPbData().baX() == null || this.fvh.getPbData().baX().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fvh.getPbData().baX().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fvh.getPbData().baX().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fvh.getPbData().baX().get(i);
        if (postData.bxE() == null || postData.bxE().Nz() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bxE().Nz().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.NF() != null) {
                    str2 = next.NF().NS();
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
        if (this.fuP) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fuP = false;
        } else if (bcO()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fuP) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fuP = false;
        } else if (bcO()) {
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
        if (pageStayDurationItem != null && this.fvh != null) {
            if (this.fvh.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fvh.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fvh.bdP(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean bcO() {
        return (!this.fuN && this.fwx == -1 && this.fwy == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.fwA = nVar;
            this.fuN = true;
            this.fvj.bfw();
            this.fvj.ru(this.fwz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcP() {
        if (this.fwA != null) {
            if (this.fwx == -1) {
                showToast(d.k.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bb.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fwA.getCartoonId(), this.fwx, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcQ() {
        if (this.fwA != null) {
            if (this.fwy == -1) {
                showToast(d.k.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bb.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fwA.getCartoonId(), this.fwy, 0)));
                finish();
            }
        }
    }

    public int bcR() {
        return this.fwx;
    }

    public int bcS() {
        return this.fwy;
    }

    private void aEl() {
        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null && this.fvh.getPbData().baV().wh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bcT() {
        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null && this.fvh.getPbData().baV().wh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bcU() {
        if (this.fuQ) {
            this.fvd = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null && this.fvh.getPbData().baV().vd() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fvh.getPbData().baV().vd().getThreadId(), this.fvh.getPbData().baV().vd().getTaskId(), this.fvh.getPbData().baV().vd().getForumId(), this.fvh.getPbData().baV().vd().getForumName(), this.fvh.getPbData().baV().vr(), this.fvh.getPbData().baV().vs())));
            this.fuP = true;
            finish();
        }
    }

    public String bcV() {
        return this.fvb;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bcW() {
        return this.fvg;
    }

    public void jS(boolean z) {
        this.fvc = z;
    }

    public boolean bcX() {
        if (this.fvh != null) {
            return this.fvh.bdR();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dE(getResources().getString(d.k.mute_is_super_member_function));
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fvB).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fvB.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvB).xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fvB != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvB.getPageActivity());
            aVar.dE(str);
            aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fvB).xn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fvj.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvB.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.dE(this.fvB.getResources().getString(d.k.block_mute_message_alert, str3));
        } else {
            aVar.dE(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fvj.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvB).xn();
    }

    public void bcZ() {
        if (this.fvh != null && this.fvh.getPbData() != null && this.fvh.getPbData().baV() != null && this.fvh.getPbData().baV().ww() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cd(d.k.channel_open_push_message);
            aVar.a(d.k.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fvh.getPbData().baV().ww().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.98
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.k.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.xn();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ay.rw(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.fvj != null) {
            this.fvj.onConfigurationChanged(configuration);
        }
        if (this.fvp != null) {
            this.fvp.dismiss();
        }
    }

    public boolean bda() {
        if (this.fvh != null) {
            return this.fvh.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, at atVar) {
        boolean z;
        List<PostData> list = this.fvh.getPbData().bbg().ftq;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bxz().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bxz().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bxz().remove(i2);
                    list.get(i).bxB();
                    z = true;
                    break;
                }
            }
            list.get(i).tM(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            atVar.n(this.fvh.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bbG().getId();
        List<PostData> list = this.fvh.getPbData().bbg().ftq;
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
                ArrayList<PostData> bbK = kVar.bbK();
                postData.tK(kVar.getTotalCount());
                if (postData.bxz() != null) {
                    postData.bxz().clear();
                    postData.bxz().addAll(bbK);
                }
            }
        }
        if (!this.fvh.getIsFromMark()) {
            this.fvj.n(this.fvh.getPbData());
        }
    }

    public boolean bdb() {
        if (this.fvh == null) {
            return false;
        }
        return this.fvh.bdb();
    }

    public void bdc() {
        if (this.fvj != null) {
            this.fvj.bfl();
            atY();
        }
    }

    public PostData bbc() {
        return this.fvj.b(this.fvh.fAN, this.fvh.bdQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aj(bc bcVar) {
        if (bcVar != null) {
            if (bcVar.isLinkThread()) {
                return 3;
            }
            if (bcVar.wy()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fvL != null && !this.fvL.isEmpty()) {
            int size = this.fvL.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fvL.get(i).onBackPressed()) {
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
            if (this.fvL == null) {
                this.fvL = new ArrayList();
            }
            if (!this.fvL.contains(aVar)) {
                this.fvL.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fvL == null) {
                this.fvL = new ArrayList();
            }
            if (!this.fvL.contains(aVar)) {
                this.fvL.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fvL != null) {
            this.fvL.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dkm == null) {
            this.dkm = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dkm.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aE(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13061"));
                    }
                }
            });
        }
        this.dkm.a(contriInfo, -1L);
    }
}
