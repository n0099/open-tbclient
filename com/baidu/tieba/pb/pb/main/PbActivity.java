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
import com.baidu.tbadk.core.data.am;
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
import com.baidu.tieba.f;
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
    private com.baidu.adp.lib.e.b<TbImageView> ayP;
    private com.baidu.tieba.f.b bKa;
    private com.baidu.adp.lib.e.b<ImageView> bfV;
    private com.baidu.adp.lib.e.b<TextView> bfW;
    private com.baidu.adp.lib.e.b<View> bfX;
    private com.baidu.adp.lib.e.b<LinearLayout> bfY;
    private com.baidu.adp.lib.e.b<RelativeLayout> bfZ;
    private com.baidu.adp.lib.e.b<GifView> bga;
    private com.baidu.tbadk.core.util.b.a bkZ;
    private VoiceManager dmn;
    private com.baidu.tbadk.core.dialog.h dna;
    public com.baidu.tbadk.core.util.ak eHX;
    private String fuM;
    private com.baidu.tieba.pb.pb.main.a.b fuS;
    private com.baidu.tbadk.editortools.pb.f fvA;
    private com.baidu.tbadk.editortools.pb.d fvB;
    private EmotionImageData fvD;
    private com.baidu.adp.base.e fvG;
    private com.baidu.tbadk.core.view.d fvH;
    private BdUniqueId fvI;
    private Runnable fvJ;
    private ax fvK;
    private com.baidu.adp.widget.ImageView.a fvL;
    private String fvM;
    private TbRichTextMemeInfo fvN;
    private List<a> fvQ;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fvi;
    private View fvj;
    private com.baidu.tieba.pb.pb.report.a fvm;
    public av fvt;
    private y fvu;
    private boolean fvw;
    private com.baidu.tieba.tbadkCore.data.e fvz;
    private String fwE;
    private com.baidu.tbadk.core.data.m fwF;
    private boolean fws;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.arr));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.arr));
        }
    };
    private static final b.a fwz = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
        @Override // com.baidu.tieba.f.b.a
        public void fc(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bag();
            } else {
                com.baidu.tieba.pb.a.b.baf();
            }
        }
    };
    private boolean fuR = false;
    private boolean fuT = false;
    private boolean fuU = false;
    private boolean eYS = false;
    private boolean fuV = true;
    private int fuW = 0;
    private com.baidu.tbadk.core.dialog.b fuX = null;
    private long cSK = -1;
    private long aTT = 0;
    private long fuY = 0;
    private long createTime = 0;
    private long aTL = 0;
    private boolean fuZ = false;
    private com.baidu.tbadk.l.b fva = null;
    private long fvb = 0;
    private boolean fvc = false;
    private long fvd = 0;
    private String aNP = null;
    private boolean fve = false;
    private boolean isFullScreen = false;
    private String fvf = "";
    private boolean fvg = true;
    private boolean fvh = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fvk = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void q(boolean z) {
            PbActivity.this.fvo.kj(!PbActivity.this.fvg);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fvl != null && PbActivity.this.fvl.rL()) {
                        PbActivity.this.baW();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fvl = null;
    private com.baidu.tbadk.baseEditMark.a fvn = null;
    private ForumManageModel czJ = null;
    private com.baidu.tbadk.coreExtra.model.a aqF = null;
    private ShareSuccessReplyToServerModel dBv = null;
    private at fvo = null;
    public final com.baidu.tieba.pb.pb.main.a.a fvp = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean fvq = false;
    private boolean fvr = false;
    private boolean fvs = false;
    private boolean fvv = false;
    private boolean fvx = false;
    private boolean fvy = false;
    private boolean fvC = false;
    public boolean fvE = false;
    private com.baidu.tbadk.editortools.pb.c aNS = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HR() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aNT = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HQ() {
            if (PbActivity.this.fvt == null || PbActivity.this.fvt.beL() == null || !PbActivity.this.fvt.beL().bFp()) {
                return !PbActivity.this.qs(com.baidu.tbadk.core.util.ak.aqA);
            }
            PbActivity.this.showToast(PbActivity.this.fvt.beL().bFr());
            if (PbActivity.this.fvB != null && (PbActivity.this.fvB.If() || PbActivity.this.fvB.Ig())) {
                PbActivity.this.fvB.a(false, PbActivity.this.fvt.beO());
            }
            PbActivity.this.fvt.ku(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fvF = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HQ() {
            if (PbActivity.this.fvt == null || PbActivity.this.fvt.beM() == null || !PbActivity.this.fvt.beM().bFp()) {
                return !PbActivity.this.qs(com.baidu.tbadk.core.util.ak.aqB);
            }
            PbActivity.this.showToast(PbActivity.this.fvt.beM().bFr());
            if (PbActivity.this.fvo != null && PbActivity.this.fvo.bdB() != null && PbActivity.this.fvo.bdB().bbU() != null && PbActivity.this.fvo.bdB().bbU().Ig()) {
                PbActivity.this.fvo.bdB().bbU().a(PbActivity.this.fvt.beO());
            }
            PbActivity.this.fvt.kv(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dmW = false;
    private int fvO = 0;
    private int fvP = -1;
    private final a fvR = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fvo != null && PbActivity.this.fvo.bdB() != null) {
                s bdB = PbActivity.this.fvo.bdB();
                if (bdB.bbR()) {
                    bdB.bbQ();
                    return true;
                }
            }
            if (PbActivity.this.fvo != null && PbActivity.this.fvo.bes()) {
                PbActivity.this.fvo.bet();
                return true;
            }
            return false;
        }
    };
    private r.b fvS = new r.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // com.baidu.tieba.pb.pb.main.r.b
        public void c(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private AddExperiencedModel.a dne = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bba();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fvT = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void G(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fvo.showToast(str);
            }
        }
    };
    private final CustomMessageListener fvU = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvl != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fvB != null) {
                    PbActivity.this.fvo.ko(PbActivity.this.fvB.HZ());
                }
                PbActivity.this.fvo.bdC();
                PbActivity.this.fvo.bel();
            }
        }
    };
    CustomMessageListener dnw = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                PbActivity.this.fvl.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                if (PbActivity.this.fvo != null && PbActivity.this.fvl != null) {
                    PbActivity.this.fvo.d(PbActivity.this.fvl.getPbData(), PbActivity.this.fvl.bce(), PbActivity.this.fvl.getRequestType());
                }
                if (PbActivity.this.fvo != null && PbActivity.this.fvo.bdS() != null) {
                    PbActivity.this.fvo.bdS().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fvV = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fvo != null) {
                    if (booleanValue) {
                        PbActivity.this.fvo.aLD();
                    } else {
                        PbActivity.this.fvo.aLC();
                    }
                }
            }
        }
    };
    private CustomMessageListener fvW = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fvB != null) {
                    PbActivity.this.fvo.ko(PbActivity.this.fvB.HZ());
                }
                PbActivity.this.fvo.kq(false);
            }
        }
    };
    private CustomMessageListener fvX = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
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
    private CustomMessageListener fvY = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvo != null && PbActivity.this.fvo.bdS() != null) {
                PbActivity.this.fvo.bdS().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener elH = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fvZ = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.qu(2);
                aj.bdl().reset();
                PbActivity.this.fvl.bcw();
                boolean z2 = false;
                ArrayList<PostData> aZk = PbActivity.this.fvl.getPbData().aZk();
                if (aZk != null) {
                    Iterator<PostData> it = aZk.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (as.j(next) && next.bwp().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fvo.n(PbActivity.this.fvl.getPbData());
                    }
                    PbActivity.this.showToast(f.j.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(f.j.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(f.j.operation_failed);
        }
    };
    private View.OnClickListener aOz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aNP);
        }
    };
    private CustomMessageListener fwa = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvl.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fvl.bcn() != null && PbActivity.this.fvl.bcn().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fvo.a(yVar.sendCount, PbActivity.this.fvl.getPbData(), PbActivity.this.fvl.bce(), PbActivity.this.fvl.getRequestType());
                    }
                    if (pbData.aZk() != null && pbData.aZk().size() >= 1 && pbData.aZk().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aZk().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fvl.bcd(), 0L);
                        if (c2 == yVar.postId && c3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bwo = pbData.aZk().get(0).bwo();
                            if (bwo == null) {
                                bwo = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> uu = bwo.uu();
                            if (uu == null) {
                                uu = new ArrayList<>();
                            }
                            uu.add(0, aVar);
                            bwo.bP(yVar.sendCount + bwo.ut());
                            bwo.k(uu);
                            pbData.aZk().get(0).a(bwo);
                            PbActivity.this.fvo.bdS().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener dEi = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null) {
                PbActivity.this.rd((String) customResponsedMessage.getData());
                PbActivity.this.fvl.bct();
                if (PbActivity.this.fvo.bdS() != null) {
                    PbActivity.this.fvo.n(PbActivity.this.fvl.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a fwb = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.apB() != null && !aVar.apB().isEmpty()) {
                    PbActivity.this.fvo.a(aVar, PbActivity.this.fwd);
                }
                PbActivity.this.fvo.a(aVar, PbActivity.this.fvl.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.beR()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fwc = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void G(List<String> list) {
            if (!com.baidu.tbadk.core.util.w.z(list) && PbActivity.this.fvo != null) {
                PbActivity.this.fvo.cW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fwd = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bb.aU(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.ih().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20.1
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
    private boolean fwe = false;
    private PraiseModel fwf = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void iT(String str) {
            PbActivity.this.fwe = false;
            if (PbActivity.this.fwf != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvl.getPbData();
                if (pbData.aZi().uW().getIsLike() == 1) {
                    PbActivity.this.kN(0);
                } else {
                    PbActivity.this.kN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.aZi()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Q(int i, String str) {
            PbActivity.this.fwe = false;
            if (PbActivity.this.fwf != null && str != null) {
                if (AntiHelper.al(i, str)) {
                    AntiHelper.aq(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fwg = 0;
    private boolean fwh = true;
    private b.a fwi = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jF(boolean z) {
            PbActivity.this.jE(z);
            if (PbActivity.this.fvo.bey() != null && z) {
                PbActivity.this.fvo.kj(false);
            }
            PbActivity.this.fvo.kl(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aDt != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aDt, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.arr));
                        }
                    } else if (updateAttentionMessage.getData().Gp) {
                        if (PbActivity.this.aZp().vj() != null && PbActivity.this.aZp().vj().getGodUserData() != null) {
                            PbActivity.this.aZp().vj().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZi() != null && PbActivity.this.fvl.getPbData().aZi().vj() != null) {
                            PbActivity.this.fvl.getPbData().aZi().vj().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a ccJ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fvo.aeR();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.qv(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aCM();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(f.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bgf = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.fvo.bdD()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvl != null && (PbActivity.this.fvl.getPbData() != null || PbActivity.this.fvl.getPbData().aZG() != null)) {
                    if (PbActivity.this.fvl.getPbData().aZG().aZO()) {
                        if (PbActivity.this.fvl.getPbData().aZG().ftf == 1 || PbActivity.this.fvl.getPbData().aZG().ftf == 3 || PbActivity.this.fvl.getPbData().aZG().ftf == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(f.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvl.getPbData().aZG().aZO() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(f.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvl.getPbData().aZG().aZO() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fvd > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kQ(false);
                        PbActivity.this.fvd = System.currentTimeMillis();
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
                if (view.getId() == f.g.richText) {
                    if (PbActivity.this.bc(view)) {
                        return true;
                    }
                } else if (view.getId() == f.g.pb_floor_item_layout) {
                    if (view.getTag(f.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(f.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != f.g.pb_post_header_layout) {
                    if (PbActivity.this.fvo != null && PbActivity.this.fvo.baG() && view.getId() == f.g.pb_head_user_info_root) {
                        if (view.getTag(f.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").ae(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(f.g.tag_user_id)));
                        }
                        if (PbActivity.this.fvp != null && PbActivity.this.fvp.fIO != null) {
                            PbActivity.this.fvp.fIO.onClick(view);
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
            if (PbActivity.this.fvB != null) {
                PbActivity.this.fvo.ko(PbActivity.this.fvB.HZ());
            }
            PbActivity.this.fvo.bdC();
            PbActivity.this.fvo.bel();
            return true;
        }
    });
    private CustomMessageListener fwj = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvI) {
                PbActivity.this.fvo.aeR();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvl.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aZw().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fvH.e(PbActivity.this.fvG.getResources().getString(f.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fvG.getResources().getString(f.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gR(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bbm();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fvG.getResources().getString(f.j.mute_fail);
                    }
                    PbActivity.this.fvH.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fwk = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvI) {
                PbActivity.this.fvo.aeR();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fvH.e(PbActivity.this.fvG.getResources().getString(f.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fvG.getResources().getString(f.j.un_mute_fail);
                }
                PbActivity.this.fvH.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fwl = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvI) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fvo.aeR();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hbs;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        sparseArray.put(f.g.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(f.g.tag_user_mute_msg, str);
                    }
                    sparseArray.put(f.g.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(f.g.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(f.g.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.fvo.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fwm = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvo.bdD() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.bao() != null && PbActivity.this.bao().getPbData() != null && PbActivity.this.bao().getPbData().aZG() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aZO = PbActivity.this.bao().getPbData().aZG().aZO();
                if (intValue < 10) {
                    if (aZO) {
                        if (PbActivity.this.fvl.getPbData().aZG().ftf == 1 || PbActivity.this.fvl.getPbData().aZG().ftf == 3 || PbActivity.this.fvl.getPbData().aZG().ftf == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(f.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvl.getPbData().aZG().aZO() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(f.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aZO ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fvd > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kQ(false);
                        PbActivity.this.fvd = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(f.g.view_main_thread_praise_state), intValue / 11, aZO, 3);
                TiebaStatic.log(PbActivity.this.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aZO ? 0 : 1));
            }
        }
    };
    private CustomMessageListener dnD = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dmW = true;
                }
            }
        }
    };
    public a.b fjI = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.auB();
            com.baidu.tbadk.core.data.al pageData = PbActivity.this.fvl.getPageData();
            int pageNum = PbActivity.this.fvo.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(f.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.um()) {
                PbActivity.this.fvo.bel();
                PbActivity.this.qu(2);
                PbActivity.this.auA();
                PbActivity.this.fvo.bdW();
                if (com.baidu.adp.lib.util.j.jE()) {
                    PbActivity.this.fvl.qD(PbActivity.this.fvo.getPageNum());
                    if (PbActivity.this.fuS != null) {
                        PbActivity.this.fuS.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(f.j.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(f.j.pb_page_error);
            }
        }
    };
    public final View.OnClickListener dog = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        /* JADX DEBUG: Multi-variable search result rejected for r2v184, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v188, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v215, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v319, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v46, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:677:0x1c9a  */
        /* JADX WARN: Removed duplicated region for block: B:704:0x1e64  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.j aZG;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            String str;
            int i;
            bg bgVar;
            SparseArray sparseArray;
            PostData postData;
            boolean l;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fvo.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fvl.jP(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fvo.bdX();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bde()) {
                        if (view == PbActivity.this.fvo.fED.aVP) {
                            if (PbActivity.this.fvo.kn(PbActivity.this.fvl.bck())) {
                                PbActivity.this.auA();
                                return;
                            }
                            PbActivity.this.fuV = false;
                            PbActivity.this.fuT = false;
                            com.baidu.adp.lib.util.l.a(PbActivity.this, PbActivity.this.fvo.fED.aVP);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fvo.bdU() && (PbActivity.this.fvo.fED.bfd() == null || (view != PbActivity.this.fvo.fED.bfd().bdd() && view != PbActivity.this.fvo.fED.bfd().bdb()))) {
                            if (view == PbActivity.this.fvo.beo()) {
                                if (PbActivity.this.fvl != null) {
                                    com.baidu.tbadk.browser.a.Q(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvl.getPbData().aZi().vi().getLink());
                                }
                            } else if (view != PbActivity.this.fvo.fED.fJy && view.getId() != f.g.view_forum_name) {
                                if (view == PbActivity.this.fvo.fED.fJz) {
                                    if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null) {
                                        ArrayList<PostData> aZk = PbActivity.this.fvl.getPbData().aZk();
                                        if ((aZk == null || aZk.size() <= 0) && PbActivity.this.fvl.bce()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(f.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").ae("tid", PbActivity.this.fvl.bcd()).ae("uid", TbadkCoreApplication.getCurrentAccount()).ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getForumId()));
                                        if (!PbActivity.this.fvo.beD()) {
                                            PbActivity.this.fvo.bdC();
                                        }
                                        PbActivity.this.baO();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(f.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != f.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bcP()) {
                                        if ((PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bda()) && view.getId() != f.g.floor_owner_reply && view.getId() != f.g.reply_title) {
                                            if (PbActivity.this.fvo.fED.bfd() == null || (view != PbActivity.this.fvo.fED.bfd().getCancelView() && view != PbActivity.this.fvo.fED.bfd().bcZ())) {
                                                if (view != PbActivity.this.fvo.fED.fJA && view.getId() != f.g.tv_share && view.getId() != f.g.share_container) {
                                                    if (PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bcX()) {
                                                        if ((PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bdg()) && view.getId() != f.g.pb_sort) {
                                                            if (PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bcY()) {
                                                                if (PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bdh()) {
                                                                    if (PbActivity.this.fvu == null || view != PbActivity.this.fvu.bcR()) {
                                                                        if (PbActivity.this.fvu == null || view != PbActivity.this.fvu.bcP()) {
                                                                            if (PbActivity.this.fvu == null || view != PbActivity.this.fvu.bcU()) {
                                                                                if (PbActivity.this.fvu == null || view != PbActivity.this.fvu.bcS()) {
                                                                                    if (PbActivity.this.fvu == null || view != PbActivity.this.fvu.bcT()) {
                                                                                        if (PbActivity.this.fvo.bey() == view) {
                                                                                            if (PbActivity.this.fvo.bey().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvl.getPbData();
                                                                                                if (pbData != null && pbData.aZi() != null && pbData.aZi().uQ() != null) {
                                                                                                    String tI = pbData.aZi().uQ().tI();
                                                                                                    if (StringUtils.isNull(tI)) {
                                                                                                        tI = pbData.aZi().uQ().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").ae(VideoPlayActivityConfig.OBJ_ID, tI));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cl("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.bbi();
                                                                                        } else if (PbActivity.this.fvo.bdR() != view) {
                                                                                            if (PbActivity.this.fvu == null || view != PbActivity.this.fvu.bcQ()) {
                                                                                                if (PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bdf()) {
                                                                                                    if (PbActivity.this.fvo.fED.bfd() != null && view == PbActivity.this.fvo.fED.bfd().bdc()) {
                                                                                                        if (com.baidu.adp.lib.util.j.jE()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.fvo.c(PbActivity.this.fvl.getPbData(), PbActivity.this.fvl.bce(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(f.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.fvo.a(((Integer) c2.get(f.g.tag_del_post_type)).intValue(), (String) c2.get(f.g.tag_del_post_id), ((Integer) c2.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(f.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.fvo.a(((Integer) c2.get(f.g.tag_del_post_type)).intValue(), (String) c2.get(f.g.tag_del_post_id), ((Integer) c2.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(f.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(f.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.fvo.fED.sy();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(f.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != f.g.sub_pb_more && view.getId() != f.g.sub_pb_item && view.getId() != f.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.fvo.baz()) {
                                                                                                            if (view == PbActivity.this.fvo.fED.bfe()) {
                                                                                                                PbActivity.this.fvo.bed();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == f.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (bgVar = (bg) view.getTag()) != null && !StringUtils.isNull(bgVar.wT())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        az.zI().c(PbActivity.this.getPageContext(), new String[]{bgVar.wT()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == f.g.pb_floor_agree || id == f.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData bd = PbActivity.this.bd(view);
                                                                                                                    if (bd != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, bd.bws() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == f.g.view_main_thread_praise_state || id == f.g.praise_container || id == f.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.bao() != null && PbActivity.this.bao().getPbData() != null && PbActivity.this.bao().getPbData().aZG() != null && PbActivity.this.bao().getPbData().aZG() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.baJ().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.bao().getPbData().aZG().aZO() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == f.g.view_main_thread_praise_num || id == f.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && !StringUtils.isNull(PbActivity.this.fvl.getPbData().getThreadId()) && (aZG = PbActivity.this.fvl.getPbData().aZG()) != null && aZG.aZM() > 0) {
                                                                                                                        az.zI().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fvl.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == f.g.replybtn || id == f.g.cover_reply_content || id == f.g.replybtn_top_right || id == f.g.cover_reply_content_top_right || id == f.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(f.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.fvu == null) {
                                                                                                                                PbActivity.this.fvu = new y(PbActivity.this.getPageContext(), PbActivity.this.dog);
                                                                                                                                PbActivity.this.fvo.bn(PbActivity.this.fvu.getView());
                                                                                                                                PbActivity.this.fvu.jT(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.fvu.showDialog();
                                                                                                                            boolean z6 = id == f.g.replybtn_top_right || id == f.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").ae("tid", PbActivity.this.fvl.fAA));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(f.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(f.g.tag_clip_board));
                                                                                                                            sparseArray2.put(f.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.fvu.bcP().setTag(sparseArray2);
                                                                                                                            PbActivity.this.fvu.bcU().setTag(view.getTag());
                                                                                                                            PbActivity.this.fvu.jV(z6);
                                                                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                                                            boolean booleanValue = ((Boolean) sparseArray3.get(f.g.tag_should_manage_visible)).booleanValue();
                                                                                                                            boolean booleanValue2 = ((Boolean) sparseArray3.get(f.g.tag_user_mute_visible)).booleanValue();
                                                                                                                            boolean booleanValue3 = ((Boolean) sparseArray3.get(f.g.tag_should_delete_visible)).booleanValue();
                                                                                                                            if (!(sparseArray3.get(f.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                z2 = false;
                                                                                                                            } else {
                                                                                                                                z2 = ((Boolean) sparseArray3.get(f.g.tag_del_post_is_self)).booleanValue();
                                                                                                                            }
                                                                                                                            String str2 = null;
                                                                                                                            if (sparseArray3.get(f.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                str2 = (String) sparseArray3.get(f.g.tag_forbid_user_post_id);
                                                                                                                            }
                                                                                                                            if (booleanValue) {
                                                                                                                                SparseArray sparseArray4 = new SparseArray();
                                                                                                                                sparseArray4.put(f.g.tag_should_manage_visible, true);
                                                                                                                                sparseArray4.put(f.g.tag_manage_user_identity, sparseArray3.get(f.g.tag_manage_user_identity));
                                                                                                                                sparseArray4.put(f.g.tag_forbid_user_name, sparseArray3.get(f.g.tag_forbid_user_name));
                                                                                                                                sparseArray4.put(f.g.tag_forbid_user_name_show, sparseArray3.get(f.g.tag_forbid_user_name_show));
                                                                                                                                sparseArray4.put(f.g.tag_forbid_user_portrait, sparseArray3.get(f.g.tag_forbid_user_portrait));
                                                                                                                                sparseArray4.put(f.g.tag_forbid_user_post_id, str2);
                                                                                                                                if (booleanValue2) {
                                                                                                                                    sparseArray4.put(f.g.tag_user_mute_visible, true);
                                                                                                                                    sparseArray4.put(f.g.tag_is_mem, sparseArray3.get(f.g.tag_is_mem));
                                                                                                                                    sparseArray4.put(f.g.tag_user_mute_mute_userid, sparseArray3.get(f.g.tag_user_mute_mute_userid));
                                                                                                                                    sparseArray4.put(f.g.tag_user_mute_mute_username, sparseArray3.get(f.g.tag_user_mute_mute_username));
                                                                                                                                    sparseArray4.put(f.g.tag_user_mute_mute_nameshow, sparseArray3.get(f.g.tag_user_mute_mute_nameshow));
                                                                                                                                    sparseArray4.put(f.g.tag_user_mute_post_id, sparseArray3.get(f.g.tag_user_mute_post_id));
                                                                                                                                    sparseArray4.put(f.g.tag_user_mute_thread_id, sparseArray3.get(f.g.tag_user_mute_thread_id));
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(f.g.tag_user_mute_visible, false);
                                                                                                                                }
                                                                                                                                if (booleanValue3) {
                                                                                                                                    sparseArray4.put(f.g.tag_should_delete_visible, true);
                                                                                                                                    sparseArray4.put(f.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                    sparseArray4.put(f.g.tag_del_post_id, sparseArray3.get(f.g.tag_del_post_id));
                                                                                                                                    sparseArray4.put(f.g.tag_del_post_type, sparseArray3.get(f.g.tag_del_post_type));
                                                                                                                                    PbActivity.this.fvu.bcS().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(f.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.fvu.bcS().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvu.bcQ().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fvu.bcS().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fvu.bcQ().setText(f.j.bar_manager);
                                                                                                                                PbActivity.this.fvu.bcQ().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.fvu.bcQ().setVisibility(8);
                                                                                                                                PbActivity.this.fvu.bcS().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(f.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(f.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(f.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(f.g.tag_manage_user_identity, sparseArray3.get(f.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(f.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(f.g.tag_del_post_id, sparseArray3.get(f.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(f.g.tag_del_post_type, sparseArray3.get(f.g.tag_del_post_type));
                                                                                                                                PbActivity.this.fvu.bcQ().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fvu.bcS().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fvu.bcQ().setText(f.j.delete);
                                                                                                                                PbActivity.this.fvu.bcS().setVisibility(0);
                                                                                                                                if (PbActivity.this.fvl.getPbData().aZu() != 1002 || z2) {
                                                                                                                                    PbActivity.this.fvu.bcS().setText(f.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvu.bcS().setText(f.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvu.bcQ().setVisibility(8);
                                                                                                                            }
                                                                                                                            SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                                                                            if (!(sparseArray6.get(f.g.tag_user_mute_visible) instanceof Boolean)) {
                                                                                                                                z3 = false;
                                                                                                                            } else {
                                                                                                                                z3 = ((Boolean) sparseArray6.get(f.g.tag_user_mute_visible)).booleanValue();
                                                                                                                            }
                                                                                                                            if (!((Boolean) sparseArray6.get(f.g.tag_should_manage_visible)).booleanValue() && z3) {
                                                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                                                sparseArray7.put(f.g.tag_user_mute_visible, true);
                                                                                                                                sparseArray7.put(f.g.tag_is_mem, sparseArray6.get(f.g.tag_is_mem));
                                                                                                                                sparseArray7.put(f.g.tag_user_mute_mute_userid, sparseArray6.get(f.g.tag_user_mute_mute_userid));
                                                                                                                                sparseArray7.put(f.g.tag_user_mute_mute_username, sparseArray6.get(f.g.tag_user_mute_mute_username));
                                                                                                                                sparseArray7.put(f.g.tag_user_mute_mute_nameshow, sparseArray6.get(f.g.tag_user_mute_mute_nameshow));
                                                                                                                                sparseArray7.put(f.g.tag_user_mute_post_id, sparseArray6.get(f.g.tag_user_mute_post_id));
                                                                                                                                sparseArray7.put(f.g.tag_user_mute_thread_id, sparseArray6.get(f.g.tag_user_mute_thread_id));
                                                                                                                                sparseArray7.put(f.g.tag_del_post_is_self, sparseArray6.get(f.g.tag_del_post_is_self));
                                                                                                                                sparseArray7.put(f.g.tag_del_post_type, sparseArray6.get(f.g.tag_del_post_type));
                                                                                                                                sparseArray7.put(f.g.tag_del_post_id, sparseArray6.get(f.g.tag_del_post_id));
                                                                                                                                sparseArray7.put(f.g.tag_manage_user_identity, sparseArray6.get(f.g.tag_manage_user_identity));
                                                                                                                                PbActivity.this.fvu.bcR().setTag(sparseArray7);
                                                                                                                                PbActivity.this.fvu.bcR().setVisibility(0);
                                                                                                                                PbActivity.this.fvu.bcQ().setVisibility(8);
                                                                                                                                PbActivity.this.fvu.bcR().setText(f.j.mute_option);
                                                                                                                            } else {
                                                                                                                                if (!(sparseArray6.get(f.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                    z4 = false;
                                                                                                                                } else {
                                                                                                                                    z4 = ((Boolean) sparseArray6.get(f.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                }
                                                                                                                                String str3 = null;
                                                                                                                                if (sparseArray6.get(f.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                    str3 = (String) sparseArray6.get(f.g.tag_forbid_user_post_id);
                                                                                                                                }
                                                                                                                                boolean jA = PbActivity.this.jA(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fww = (PostData) sparseArray6.get(f.g.tag_clip_board);
                                                                                                                                if (as.j(PbActivity.this.fww) ? false : jA) {
                                                                                                                                    PbActivity.this.fvu.bcR().setVisibility(0);
                                                                                                                                    PbActivity.this.fvu.bcR().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvu.bcR().setVisibility(8);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                                                                            long j = 0;
                                                                                                                            if (!(sparseArray8.get(f.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                z5 = false;
                                                                                                                            } else {
                                                                                                                                z5 = ((Boolean) sparseArray8.get(f.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                            }
                                                                                                                            if (sparseArray8.get(f.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                j = ((Long) sparseArray8.get(f.g.tag_chudian_template_id)).longValue();
                                                                                                                            }
                                                                                                                            if (!(sparseArray8.get(f.g.tag_chudian_monitor_id) instanceof String)) {
                                                                                                                                str = "";
                                                                                                                            } else {
                                                                                                                                str = (String) sparseArray8.get(f.g.tag_chudian_monitor_id);
                                                                                                                            }
                                                                                                                            if (!(sparseArray8.get(f.g.tag_chudian_hide_day) instanceof Integer)) {
                                                                                                                                i = 0;
                                                                                                                            } else {
                                                                                                                                i = ((Integer) sparseArray8.get(f.g.tag_chudian_hide_day)).intValue();
                                                                                                                            }
                                                                                                                            if (z5) {
                                                                                                                                PbActivity.this.fvu.bcT().setVisibility(0);
                                                                                                                                PbActivity.this.fvu.bcT().setTag(f.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.fvu.bcT().setTag(f.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.fvu.bcT().setTag(f.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.fvu.bcT().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fvl.getPbData().rL()) {
                                                                                                                            String rK = PbActivity.this.fvl.getPbData().rK();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(rK) && rK.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.fvu.bcP().setText(f.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvu.bcP().setText(f.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvu.jU(true);
                                                                                                                                PbActivity.this.fvu.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.fvu.jU(true);
                                                                                                                        PbActivity.this.fvu.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == f.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZi() != null && PbActivity.this.fvl.getPbData().aZi().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), PbActivity.this.fvl.getPbData().aZi().getActUrl());
                                                                                                                        if (PbActivity.this.fvl.getPbData().aZi().vM() != 1) {
                                                                                                                            if (PbActivity.this.fvl.getPbData().aZi().vM() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == f.g.lottery_tail) {
                                                                                                                    if (view.getTag(f.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(f.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getPbData().getForumId()).ae("tid", PbActivity.this.fvl.getPbData().getThreadId()).ae("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fvl.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.fvo.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == f.g.pb_item_tail_content) {
                                                                                                                    if (bb.aU(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(f.j.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.fvo.bdC();
                                                                                                                    }
                                                                                                                } else if (id == f.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.baL() == 1 && PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getPbData().getForumId()).ae("tid", PbActivity.this.fvl.getPbData().getThreadId()).ae("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == f.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.baL() == 1 && PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getPbData().getForumId()).ae("tid", PbActivity.this.fvl.getPbData().getThreadId()).ae("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == f.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.bbd();
                                                                                                                } else if (id == f.g.manga_next_btn) {
                                                                                                                    PbActivity.this.bbe();
                                                                                                                } else if (id == f.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZC() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fvl.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").ae(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        az.zI().c(PbActivity.this.getPageContext(), new String[]{pbData2.aZC().aZL()});
                                                                                                                    }
                                                                                                                } else if (id == f.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZC() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fvl.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").ae(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        az.zI().c(PbActivity.this.getPageContext(), new String[]{pbData3.aZC().aZL()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.fvo.fED.bfd() != null && view == PbActivity.this.fvo.fED.bfd().bdi()) {
                                                                                                                    if (PbActivity.this.fvl == null || PbActivity.this.fvl.getPbData() == null || PbActivity.this.fvl.getPbData().aZi() == null) {
                                                                                                                        PbActivity.this.fvo.fED.sy();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.jV()) {
                                                                                                                        PbActivity.this.showToast(f.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fvl.getPbData().aZi().uR() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvl.bcd(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(f.j.haved_fans_called)).xm();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").r("obj_locate", PbActivity.this.ak(PbActivity.this.fvl.getPbData().aZi())).ae("tid", PbActivity.this.fvl.getPbData().aZi().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == f.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fvO >= 0) {
                                                                                                                        if (PbActivity.this.fvl != null) {
                                                                                                                            PbActivity.this.fvl.bcK();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fvo.bdS() != null) {
                                                                                                                            PbActivity.this.fvo.bdS().a(PbActivity.this.fvl.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.fvo.getListView().setSelection(PbActivity.this.fvl.bcN());
                                                                                                                        PbActivity.this.fvO = 0;
                                                                                                                        if (PbActivity.this.fvl != null) {
                                                                                                                            PbActivity.this.fvl.bq(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == f.g.single_bar_tips) {
                                                                                                                    PbActivity.this.fvo.beG();
                                                                                                                } else if (id == f.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fvl.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fvl.bcd(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fvl.getPbData().aZi().vD())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fvl.getPbData() != null) {
                                                                                                            PbActivity.this.fvo.bel();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(f.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(f.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bwu() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                                                }
                                                                                                                String bcd = PbActivity.this.fvl.bcd();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fvl.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fvl.getPbData().aZu();
                                                                                                                }
                                                                                                                PbActivity.this.auA();
                                                                                                                if (view.getId() == f.g.replybtn) {
                                                                                                                    c ri = PbActivity.this.ri(id2);
                                                                                                                    if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && ri != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bcd, id2, "pb", true, null, true, null, i3, postData3.bfU(), PbActivity.this.fvl.getPbData().ug(), false, postData3.vj().getIconInfo()).addBigImageData(ri.fxg, ri.fxh, ri.fxi, ri.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fvl.bcJ());
                                                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.fvl.getFromForumId());
                                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (view.getId() == f.g.sub_pb_item) {
                                                                                                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                                                                                                    String str5 = (String) sparseArray10.get(f.g.tag_photo_username);
                                                                                                                    String str6 = (String) sparseArray9.get(f.g.tag_photo_userid);
                                                                                                                    PostData postData4 = (PostData) sparseArray10.get(f.g.tag_load_sub_data);
                                                                                                                    String str7 = null;
                                                                                                                    if (postData4 != null) {
                                                                                                                        str7 = postData4.getId();
                                                                                                                    }
                                                                                                                    if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11741").ae("task_id", TbadkCoreApplication.getInst().getTaskId()));
                                                                                                                    } else {
                                                                                                                        TiebaStatic.log("c11741");
                                                                                                                    }
                                                                                                                    c ri2 = PbActivity.this.ri(id2);
                                                                                                                    if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && ri2 != null && PbActivity.this.baF().bdA() != null) {
                                                                                                                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                                                        kVar.a(PbActivity.this.fvl.getPbData().aZg());
                                                                                                                        kVar.Z(PbActivity.this.fvl.getPbData().aZi());
                                                                                                                        kVar.d(postData4);
                                                                                                                        PbActivity.this.baF().bdA().d(kVar);
                                                                                                                        PbActivity.this.baF().bdA().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c ri3 = PbActivity.this.ri(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && ri3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bcd, id2, "pb", true, null, false, null, i3, postData3.bfU(), PbActivity.this.fvl.getPbData().ug(), false, postData3.vj().getIconInfo()).addBigImageData(ri3.fxg, ri3.fxh, ri3.fxi, ri3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fvl.bcJ());
                                                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.fvl.getFromForumId());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 3).ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.jE()) {
                                                                                                    PbActivity.this.fvo.bel();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.fvo.c(PbActivity.this.fvl.getPbData(), PbActivity.this.fvl.bce(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvl.getPbData().aZg().getId(), PbActivity.this.fvl.getPbData().aZg().getName(), PbActivity.this.fvl.getPbData().aZi().getId(), String.valueOf(PbActivity.this.fvl.getPbData().getUserData().getUserId()), (String) c3.get(f.g.tag_forbid_user_name), (String) c3.get(f.g.tag_forbid_user_name_show), (String) c3.get(f.g.tag_forbid_user_post_id), (String) c3.get(f.g.tag_forbid_user_portrait))));
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    PbActivity.this.showToast(f.j.network_not_available);
                                                                                                    return;
                                                                                                }
                                                                                            } else if (!com.baidu.adp.lib.util.j.jE()) {
                                                                                                PbActivity.this.showToast(f.j.network_not_available);
                                                                                                return;
                                                                                            } else {
                                                                                                SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                                if (sparseArray11 != null) {
                                                                                                    boolean booleanValue4 = ((Boolean) sparseArray11.get(f.g.tag_should_manage_visible)).booleanValue();
                                                                                                    boolean booleanValue5 = ((Boolean) sparseArray11.get(f.g.tag_should_delete_visible)).booleanValue();
                                                                                                    boolean booleanValue6 = ((Boolean) sparseArray11.get(f.g.tag_user_mute_visible)).booleanValue();
                                                                                                    if (booleanValue4) {
                                                                                                        if (booleanValue6) {
                                                                                                            sparseArray11.put(f.g.tag_from, 1);
                                                                                                            sparseArray11.put(f.g.tag_check_mute_from, 2);
                                                                                                            PbActivity.this.b(sparseArray11);
                                                                                                        } else {
                                                                                                            sparseArray11.put(f.g.tag_check_mute_from, 2);
                                                                                                            PbActivity.this.fvo.bl(view);
                                                                                                        }
                                                                                                    } else if (booleanValue5) {
                                                                                                        PbActivity.this.fvo.a(((Integer) sparseArray11.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(f.g.tag_del_post_id), ((Integer) sparseArray11.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(f.g.tag_del_post_is_self)).booleanValue());
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.baB();
                                                                                        }
                                                                                    } else {
                                                                                        long j2 = -1;
                                                                                        String str8 = "";
                                                                                        int i4 = 0;
                                                                                        if (view.getTag(f.g.tag_chudian_template_id) instanceof Long) {
                                                                                            j2 = ((Long) view.getTag(f.g.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (view.getTag(f.g.tag_chudian_monitor_id) instanceof String) {
                                                                                            str8 = (String) view.getTag(f.g.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (view.getTag(f.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                            i4 = ((Integer) view.getTag(f.g.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fvl.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aZg() != null) {
                                                                                            str9 = pbData4.aZg().getId();
                                                                                            str10 = pbData4.aZg().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.a.a(j2, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j2, str8, str9, str10, str11, i4);
                                                                                    }
                                                                                } else {
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null) {
                                                                                        if ((sparseArray12.get(f.g.tag_del_post_type) instanceof Integer) && (sparseArray12.get(f.g.tag_del_post_id) instanceof String) && (sparseArray12.get(f.g.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(f.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                            PbActivity.this.fvo.a(((Integer) sparseArray12.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(f.g.tag_del_post_id), ((Integer) sparseArray12.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray12.get(f.g.tag_del_post_is_self)).booleanValue());
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.fvu.bcW()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12007").ae("tid", PbActivity.this.fvl.fAA));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvl.getPbData() != null) {
                                                                                    PbActivity.this.fvo.bel();
                                                                                    if (!(view.getTag() instanceof SparseArray)) {
                                                                                        sparseArray = null;
                                                                                    } else {
                                                                                        sparseArray = (SparseArray) view.getTag();
                                                                                    }
                                                                                    if (sparseArray == null || !(sparseArray.get(f.g.tag_load_sub_data) instanceof PostData)) {
                                                                                        postData = null;
                                                                                    } else {
                                                                                        postData = (PostData) sparseArray.get(f.g.tag_load_sub_data);
                                                                                    }
                                                                                    if (postData != null) {
                                                                                        String bcd2 = PbActivity.this.fvl.bcd();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fvl.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fvl.getPbData().aZu();
                                                                                        }
                                                                                        PbActivity.this.auA();
                                                                                        c ri4 = PbActivity.this.ri(id3);
                                                                                        if (ri4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bcd2, id3, "pb", true, null, true, null, i5, postData.bfU(), PbActivity.this.fvl.getPbData().ug(), false, postData.vj().getIconInfo()).addBigImageData(ri4.fxg, ri4.fxh, ri4.fxi, ri4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fvl.bcJ());
                                                                                            addBigImageData3.setFromFrsForumId(PbActivity.this.fvl.getFromForumId());
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
                                                                                PbActivity.this.be(view);
                                                                                if (PbActivity.this.fvl.getPbData().aZi() != null && PbActivity.this.fvl.getPbData().aZi().vj() != null && PbActivity.this.fvl.getPbData().aZi().vj().getUserId() != null && PbActivity.this.fvn != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").ae("tid", PbActivity.this.fvl.fAA).r("obj_locate", 2).ae(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvl.getPbData().aZi().vj().getUserId()).r("obj_type", PbActivity.this.fvn.rL() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fvl.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.jE()) {
                                                                        PbActivity.this.showToast(f.j.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13079"));
                                                                            PbActivity.this.rf((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").r("obj_locate", 4));
                                                                            SparseArray<Object> sparseArray13 = (SparseArray) tag;
                                                                            if ((sparseArray13.get(f.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray13.get(f.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray13.put(f.g.tag_from, 0);
                                                                                sparseArray13.put(f.g.tag_check_mute_from, 2);
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
                                                                    PbActivity.this.fvo.fED.bfc();
                                                                }
                                                            } else if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZi() != null) {
                                                                PbActivity.this.fvo.fED.sy();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                                PbActivity.this.rf(PbActivity.this.fvl.getPbData().aZi().vA());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fvo.bel();
                                                            if (com.baidu.adp.lib.util.j.jE()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fvl.bcr()));
                                                                    return;
                                                                }
                                                                PbActivity.this.qu(2);
                                                                PbActivity.this.auA();
                                                                PbActivity.this.fvo.bdW();
                                                                boolean bcq = PbActivity.this.fvl.bcq();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fvl.bcr()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.fvo.fED != null && PbActivity.this.fvo.fED.bfd() != null && view == PbActivity.this.fvo.fED.bfd().bdg()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == f.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bcq) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.fvo.ke(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(f.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fvo.bel();
                                                        if (PbActivity.this.fvl.getPageData() != null) {
                                                            PbActivity.this.fvo.a(PbActivity.this.fvl.getPageData(), PbActivity.this.fjI);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.p.at.iq() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fvl != null) {
                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12386");
                                                        anVar.ae("tid", PbActivity.this.fvl.bcd());
                                                        anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
                                                        anVar.ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getForumId());
                                                        anVar.r("obj_locate", 6);
                                                        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        TiebaStatic.log(anVar);
                                                    }
                                                    if (com.baidu.adp.lib.util.l.jV()) {
                                                        if (PbActivity.this.fvl.getPbData() != null) {
                                                            ArrayList<PostData> aZk2 = PbActivity.this.fvl.getPbData().aZk();
                                                            if ((aZk2 != null && aZk2.size() > 0) || !PbActivity.this.fvl.bce()) {
                                                                PbActivity.this.fvo.bel();
                                                                PbActivity.this.auA();
                                                                PbActivity.this.qu(2);
                                                                if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZC() != null && !StringUtils.isNull(PbActivity.this.fvl.getPbData().aZC().tT(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                                if (com.baidu.tbadk.p.at.iq()) {
                                                                    PbActivity.this.qv(2);
                                                                } else {
                                                                    PbActivity.this.fvo.showLoadingDialog();
                                                                    PbActivity.this.fvl.bcE().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(f.j.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(f.j.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(f.j.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.fvo.fED.sy();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.jE()) {
                                            PbActivity.this.fvo.bel();
                                            if (PbActivity.this.fvo.fED.bfd() != null && view == PbActivity.this.fvo.fED.bfd().bda() && !PbActivity.this.fvo.beD()) {
                                                PbActivity.this.fvo.bdC();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.auA();
                                                PbActivity.this.fvo.bdW();
                                                if (view.getId() == f.g.floor_owner_reply) {
                                                    l = PbActivity.this.fvl.l(true, PbActivity.this.bbb());
                                                } else {
                                                    l = view.getId() == f.g.reply_title ? PbActivity.this.fvl.l(false, PbActivity.this.bbb()) : PbActivity.this.fvl.rj(PbActivity.this.bbb());
                                                }
                                                view.setTag(Boolean.valueOf(l));
                                                if (l) {
                                                    PbActivity.this.fvo.jJ(true);
                                                    PbActivity.this.fvo.aLD();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fvo.ke(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.qu(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(f.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.jE()) {
                                        PbActivity.this.fvo.bel();
                                        if (PbActivity.this.qt(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fvl.qI(PbActivity.this.fvo.beb()) != null) {
                                            PbActivity.this.baV();
                                            if (PbActivity.this.fvl.getPbData().aZi() != null && PbActivity.this.fvl.getPbData().aZi().vj() != null && PbActivity.this.fvl.getPbData().aZi().vj().getUserId() != null && PbActivity.this.fvn != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").ae("tid", PbActivity.this.fvl.fAA).r("obj_locate", 1).ae(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvl.getPbData().aZi().vj().getUserId()).r("obj_type", PbActivity.this.fvn.rL() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fvl.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(f.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.jE()) {
                                    PbActivity.this.fvo.jJ(true);
                                    PbActivity.this.fvo.bdC();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fvo.aLD();
                                        PbActivity.this.auA();
                                        PbActivity.this.fvo.bdW();
                                        PbActivity.this.fvl.rj(PbActivity.this.bbb());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.qu(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(f.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZi() != null && PbActivity.this.fvl.getPbData().aZi().vV() && PbActivity.this.fvl.getPbData().aZi().vB() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbActivity.this.fvl.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fvl.bcc()) && PbActivity.this.fvl.getAppealInfo() != null) {
                                        name = PbActivity.this.fvl.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fvl.getPbData().aZg().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bcc = PbActivity.this.fvl.bcc();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fvl.bcf() && bcc != null && bcc.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.jE()) {
                            if (PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZu() == 1 && !PbActivity.this.czJ.bwU()) {
                                PbActivity.this.fvo.bel();
                                int i6 = 0;
                                if (PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bdb()) {
                                    if (PbActivity.this.fvo.fED.bfd() == null || view != PbActivity.this.fvo.fED.bfd().bdd()) {
                                        if (view == PbActivity.this.fvo.bdU()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fvl.getPbData().aZi().vf() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fvl.getPbData().aZi().ve() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aZg = PbActivity.this.fvl.getPbData().aZg();
                                String name2 = aZg.getName();
                                String id4 = aZg.getId();
                                String id5 = PbActivity.this.fvl.getPbData().aZi().getId();
                                PbActivity.this.fvo.bdT();
                                PbActivity.this.czJ.a(id4, name2, id5, i6, PbActivity.this.fvo.bdV());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(f.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.jE()) {
                        PbActivity.this.fvo.bel();
                        PbActivity.this.auA();
                        PbActivity.this.fvo.bdW();
                        PbActivity.this.fvo.showLoadingDialog();
                        if (PbActivity.this.fvo.bdJ() != null) {
                            PbActivity.this.fvo.bdJ().setVisibility(8);
                        }
                        PbActivity.this.fvl.qD(1);
                        if (PbActivity.this.fuS != null) {
                            PbActivity.this.fuS.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(f.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(f.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == f.g.reply_god_title_group) {
                        String baI = PbActivity.this.baI();
                        if (!TextUtils.isEmpty(baI)) {
                            az.zI().c(PbActivity.this.getPageContext(), new String[]{baI});
                        }
                    }
                } else if (PbActivity.this.fvc) {
                    PbActivity.this.fvc = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(f.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.baF().bdA() != null && postData5.vj() != null && postData5.bwg() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.baF().bdB() != null) {
                                    PbActivity.this.baF().bdB().bbP();
                                }
                                com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                                kVar2.a(PbActivity.this.fvl.getPbData().aZg());
                                kVar2.Z(PbActivity.this.fvl.getPbData().aZi());
                                kVar2.d(postData5);
                                PbActivity.this.baF().bdA().d(kVar2);
                                PbActivity.this.baF().bdA().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.vj().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fvB != null) {
                                    PbActivity.this.fvo.ko(PbActivity.this.fvB.HZ());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aNZ = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.u uVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null) {
                    anVar.ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getPbData().getForumId());
                }
                if (PbActivity.this.fvl != null) {
                    anVar.ae("tid", PbActivity.this.fvl.bcd());
                }
                anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbActivity.this.auA();
            PbActivity.this.fvo.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.ak.La() && PbActivity.this.bao() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bao().rm(postWriteCallBackData.getPostId());
                    PbActivity.this.fvO = PbActivity.this.fvo.bdF();
                    if (PbActivity.this.fvl != null) {
                        PbActivity.this.fvl.bq(PbActivity.this.fvO, PbActivity.this.fvo.bdG());
                    }
                }
                PbActivity.this.fvo.bel();
                PbActivity.this.fvt.beK();
                if (PbActivity.this.fvB != null) {
                    PbActivity.this.fvo.ko(PbActivity.this.fvB.HZ());
                }
                PbActivity.this.fvo.bdz();
                PbActivity.this.fvo.kq(true);
                PbActivity.this.fvl.bct();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fvl.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvl.getPbData();
                            if (pbData != null && pbData.aZi() != null && pbData.aZi().vj() != null && (userId = pbData.aZi().vj().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.ak.La() && PbActivity.this.fvl.bcm()) {
                                PbActivity.this.fvo.bdW();
                            }
                        } else if (!com.baidu.tbadk.p.ak.La() && PbActivity.this.fvl.bcm()) {
                            PbActivity.this.fvo.bdW();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fvo.n(PbActivity.this.fvl.getPbData());
                    }
                    if (PbActivity.this.fvl.bci()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").ae("tid", PbActivity.this.fvl.bcd()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fvB.If() || PbActivity.this.fvB.Ig()) {
                    PbActivity.this.fvB.a(false, postWriteCallBackData);
                }
                PbActivity.this.fvt.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.eHX != null) {
                    PbActivity.this.eHX.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (uVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fwn = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.u uVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null) {
                    anVar.ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getPbData().getForumId());
                }
                if (PbActivity.this.fvl != null) {
                    anVar.ae("tid", PbActivity.this.fvl.bcd());
                }
                anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fvt != null) {
                    PbActivity.this.fvt.beJ();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.eHX != null) {
                    PbActivity.this.eHX.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fvt != null) {
                if (PbActivity.this.fvo != null && PbActivity.this.fvo.bdB() != null && PbActivity.this.fvo.bdB().bbU() != null && PbActivity.this.fvo.bdB().bbU().Ig()) {
                    PbActivity.this.fvo.bdB().bbU().a(postWriteCallBackData);
                }
                PbActivity.this.fvt.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fwo = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g eK;
            if (!z || dVar == null || dVar.aZs() != null || com.baidu.tbadk.core.util.w.y(dVar.aZk()) >= 1) {
                PbActivity.this.eYS = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fvo.bdY();
                if (dVar == null || !dVar.aZo()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fvo.getView());
                }
                PbActivity.this.fvo.aLC();
                if (PbActivity.this.isFullScreen || PbActivity.this.fvo.beD()) {
                    PbActivity.this.fvo.beu();
                } else if (!PbActivity.this.fvo.ber()) {
                    PbActivity.this.fvo.kq(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fvv = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.fvo.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.fvo.agP();
                    if (dVar.aZi() != null && dVar.aZi().wc() != null) {
                        PbActivity.this.a(dVar.aZi().wc());
                    }
                    PbActivity.this.baC();
                    if (PbActivity.this.fvB != null) {
                        PbActivity.this.fvo.ko(PbActivity.this.fvB.HZ());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.aZk() != null && dVar.aZk().size() >= 1 && dVar.aZk().get(0) != null) {
                        PbActivity.this.fvl.rl(dVar.aZk().get(0).getId());
                    } else if (dVar.aZs() != null) {
                        PbActivity.this.fvl.rl(dVar.aZs().getId());
                    }
                    if (PbActivity.this.fvB != null) {
                        PbActivity.this.fvB.a(dVar.ug());
                        PbActivity.this.fvB.a(dVar.aZg(), dVar.getUserData());
                        PbActivity.this.fvB.a(PbActivity.this.fvl.bcn(), PbActivity.this.fvl.bcd(), PbActivity.this.fvl.bcG());
                        if (dVar.aZi() != null) {
                            PbActivity.this.fvB.bK(dVar.aZi().ws());
                        }
                    }
                    if (PbActivity.this.fvn != null) {
                        PbActivity.this.fvn.ae(dVar.rL());
                    }
                    if (dVar == null || dVar.aZv() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fvo.kp(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fvo.a(dVar, i2, i3, PbActivity.this.fvl.bce(), i4, PbActivity.this.fvl.getIsFromMark());
                    PbActivity.this.fvo.d(dVar, PbActivity.this.fvl.bce());
                    PbActivity.this.fvo.km(PbActivity.this.fvl.getHostMode());
                    AntiData ug = dVar.ug();
                    if (ug != null) {
                        PbActivity.this.aNP = ug.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aNP) && PbActivity.this.fvB != null && PbActivity.this.fvB.Ht() != null && (eK = PbActivity.this.fvB.Ht().eK(6)) != null && !TextUtils.isEmpty(PbActivity.this.aNP)) {
                            ((View) eK).setOnClickListener(PbActivity.this.aOz);
                        }
                    }
                    if (PbActivity.this.fvx) {
                        PbActivity.this.fvx = false;
                        final int baQ = PbActivity.this.baQ();
                        if (dVar.aZH()) {
                            final int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(baQ, ah);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.baF().qO(baQ);
                        }
                    }
                    if (PbActivity.this.fvy) {
                        PbActivity.this.fvy = false;
                        final int baQ2 = PbActivity.this.baQ();
                        final boolean z2 = baQ2 != -1;
                        if (!z2) {
                            baQ2 = PbActivity.this.baR();
                        }
                        if (PbActivity.this.baF() != null) {
                            if (dVar.aZH()) {
                                final int ah2 = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (baQ2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(baQ2, ah2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(baQ2 - 1, ah2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.baF().qO(baQ2);
                            }
                        }
                    } else {
                        PbActivity.this.fvo.bec();
                    }
                    PbActivity.this.fvl.a(dVar.aZg(), PbActivity.this.fwb);
                    PbActivity.this.fvl.a(PbActivity.this.fwc);
                    if (PbActivity.this.eHX != null && dVar.aZi() != null && dVar.aZi().vj() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.aZi().vj());
                        PbActivity.this.eHX.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fvv && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fvl != null && PbActivity.this.fvl.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fvl.getAppealInfo().fsl)) {
                                    PbActivity.this.fvo.a(PbActivity.this.fvl.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fvo.getView(), PbActivity.this.getPageContext().getResources().getString(f.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), f.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fvo.getView(), PbActivity.this.getPageContext().getResources().getString(f.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), f.e.ds200));
                            }
                            PbActivity.this.fvo.beu();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fvl.bcd());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getForumId());
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
                        PbActivity.this.fvo.rp(PbActivity.this.getResources().getString(f.j.list_no_more_new));
                    } else {
                        PbActivity.this.fvo.rp("");
                    }
                    PbActivity.this.fvo.Aw();
                }
                PbActivity.this.aTT = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bao().bce() || PbActivity.this.bao().getPbData().uv().us() != 0 || PbActivity.this.bao().bcz()) {
                    PbActivity.this.fvC = true;
                    return;
                }
                return;
            }
            PbActivity.this.fvl.qD(1);
            if (PbActivity.this.fuS != null) {
                PbActivity.this.fuS.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fvo.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.m.KJ().KK()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.cSK : j;
                com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, PbActivity.this.aTL, PbActivity.this.createTime, PbActivity.this.aTT, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aTL = 0L;
                if (iVar != null) {
                    iVar.KG();
                }
                if (z2) {
                    iVar.aUc = currentTimeMillis;
                    iVar.bY(true);
                }
                if (!z2 && PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZi() != null) {
                    int threadType = PbActivity.this.fvl.getPbData().aZi().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.fvf, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.fvf, "from_frs")) {
                                com.baidu.tbadk.l.i iVar2 = new com.baidu.tbadk.l.i();
                                iVar2.fl(1000);
                                iVar2.aUe = currentTimeMillis;
                                iVar2.fm(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.l.d dVar = new com.baidu.tbadk.l.d();
                        dVar.pageType = 1;
                        dVar.fl(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
                        dVar.aUe = currentTimeMillis;
                        dVar.fm(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fwp = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.baM();
            }
        }
    };
    private final a.InterfaceC0097a fwq = new a.InterfaceC0097a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0097a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fvo.bdY();
            if (z) {
                if (PbActivity.this.fvn != null) {
                    PbActivity.this.fvn.ae(z2);
                }
                PbActivity.this.fvl.jR(z2);
                if (PbActivity.this.fvl.rL()) {
                    PbActivity.this.baW();
                } else {
                    PbActivity.this.fvo.n(PbActivity.this.fvl.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fvn != null && PbActivity.this.fvn.rO() != null && PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZi() != null && PbActivity.this.fvl.getPbData().aZi().vj() != null) {
                        MarkData rO = PbActivity.this.fvn.rO();
                        MetaData vj = PbActivity.this.fvl.getPbData().aZi().vj();
                        if (rO != null && vj != null) {
                            if (!com.baidu.tbadk.core.util.ap.equals(TbadkCoreApplication.getCurrentAccount(), vj.getUserId()) && !vj.hadConcerned()) {
                                PbActivity.this.b(vj);
                                return;
                            } else {
                                PbActivity.this.showToast(f.j.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(f.j.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(f.j.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(f.j.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.qq(PbActivity.this.mLastScrollState) && PbActivity.this.qq(i)) {
                if (PbActivity.this.fvo != null) {
                    PbActivity.this.fvo.bel();
                    if (PbActivity.this.fvB != null && !PbActivity.this.fvo.bdD()) {
                        PbActivity.this.fvo.ko(PbActivity.this.fvB.HZ());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fvo.bdC();
                    }
                }
                if (!PbActivity.this.fuZ) {
                    PbActivity.this.fuZ = true;
                    PbActivity.this.fvo.beq();
                }
            }
            PbActivity.this.fvo.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fuS != null) {
                PbActivity.this.fuS.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fva == null) {
                PbActivity.this.fva = new com.baidu.tbadk.l.b();
                PbActivity.this.fva.fl(1001);
            }
            if (i == 0) {
                PbActivity.this.fva.KA();
            } else {
                PbActivity.this.fva.Kz();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aZk;
            if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvo != null && PbActivity.this.fvo.bdS() != null) {
                PbActivity.this.fvo.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fuS != null) {
                    PbActivity.this.fuS.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fvl.bcv() && (aZk = PbActivity.this.fvl.getPbData().aZk()) != null && !aZk.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fvo.bdS().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvl.getPbData();
                    if (pbData != null) {
                        if (pbData.aZl() != null && pbData.aZl().hasData()) {
                            headerCount--;
                        }
                        if (pbData.aZm() != null && pbData.aZm().hasData()) {
                            headerCount--;
                        }
                        int size = aZk.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d czN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.czJ.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fvl.bct();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fLp != 1002 || bVar.dPJ) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fvo.a(1, dVar.EX, dVar.gQs, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.czJ.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fvo.a(PbActivity.this.czJ.getLoadDataMode(), gVar.EX, gVar.gQs, false);
                        PbActivity.this.fvo.aq(gVar.gQv);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fvo.a(PbActivity.this.czJ.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fwr = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
    };
    private final g.b bpz = new g.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            if (PbActivity.this.bbc()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fvl.jQ(true)) {
                PbActivity.this.fvo.bdZ();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fwt = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fws && PbActivity.this.bbc()) {
                PbActivity.this.bbe();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fvl.jP(false)) {
                    PbActivity.this.fvo.bdX();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fvl.getPbData() != null) {
                    PbActivity.this.fvo.bep();
                }
                PbActivity.this.fws = true;
            }
        }
    };
    private int fwu = 0;
    private final TbRichTextView.h bge = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fvo.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(f.g.tag_rich_text_meme_info) != null && (view.getTag(f.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(f.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    PbActivity.this.fvj = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fxj) {
                    TbRichText aB = PbActivity.this.aB(str, i);
                    if (aB != null && PbActivity.this.fwu >= 0 && PbActivity.this.fwu < aB.Nw().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aB.Nw().get(PbActivity.this.fwu));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fxg.size()) {
                                break;
                            } else if (!cVar.fxg.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.w.z(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fxh.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fxi, cVar.lastId, PbActivity.this.fvl.bcr(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.w.d(cVar.fxg, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.w.z(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fxh.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fxi, cVar.fxg.get(0), PbActivity.this.fvl.bcr(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fwv = false;
    PostData fww = null;
    private final b.InterfaceC0101b fwx = new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fww != null) {
                if (i == 0) {
                    PbActivity.this.fww.ch(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fww = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.e(PbActivity.this.fww);
                }
            }
        }
    };
    private final b.InterfaceC0101b fwy = new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fvL != null && !TextUtils.isEmpty(PbActivity.this.fvM)) {
                if (i == 0) {
                    if (PbActivity.this.fvN == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fvM));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fvM;
                        aVar.pkgId = PbActivity.this.fvN.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fvN.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bkZ == null) {
                        PbActivity.this.bkZ = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bkZ.zW();
                    PbActivity.this.bkZ.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bkZ.u(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fvK == null) {
                            PbActivity.this.fvK = new ax(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fvK.i(PbActivity.this.fvM, PbActivity.this.fvL.ne());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fvL = null;
                PbActivity.this.fvM = null;
            }
        }
    };
    private final View.OnLongClickListener aHj = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.fvL = ((TbImageView) view).getBdImage();
                PbActivity.this.fvM = ((TbImageView) view).getUrl();
                if (PbActivity.this.fvL != null && !TextUtils.isEmpty(PbActivity.this.fvM)) {
                    if (view.getTag(f.g.tag_rich_text_meme_info) == null || !(view.getTag(f.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvN = null;
                    } else {
                        PbActivity.this.fvN = (TbRichTextMemeInfo) view.getTag(f.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvo.a(PbActivity.this.fwy, PbActivity.this.fvL.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.fvL = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.fvM = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(f.g.tag_rich_text_meme_info) == null || !(view.getTag(f.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvN = null;
                    } else {
                        PbActivity.this.fvN = (TbRichTextMemeInfo) view.getTag(f.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvo.a(PbActivity.this.fwy, PbActivity.this.fvL.isGif());
                }
            } else if (view instanceof TbMemeImageView) {
                if (((TbMemeImageView) view).getBdImage() != null) {
                    PbActivity.this.fvL = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        PbActivity.this.fvM = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(f.g.tag_rich_text_meme_info) == null || !(view.getTag(f.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvN = null;
                    } else {
                        PbActivity.this.fvN = (TbRichTextMemeInfo) view.getTag(f.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvo.a(PbActivity.this.fwy, PbActivity.this.fvL.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fww = (PostData) sparseArray.get(f.g.tag_clip_board);
                    if (PbActivity.this.fww != null && PbActivity.this.fvn != null) {
                        PbActivity.this.fvo.a(PbActivity.this.fwx, PbActivity.this.fvn.rL() && PbActivity.this.fww.getId() != null && PbActivity.this.fww.getId().equals(PbActivity.this.fvl.vt()), ((Boolean) sparseArray.get(f.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dkd = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
            if (!PbActivity.this.fuU && z && !PbActivity.this.fvl.bcl()) {
                PbActivity.this.baY();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), f.e.ds200));
        }
    };
    public View.OnTouchListener aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
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
                    if (frameLayout2 != null && (childAt2 instanceof PbMainFloorPraiseFloatingView) && ((PbMainFloorPraiseFloatingView) childAt2).arL()) {
                        break;
                    }
                }
            }
            PbActivity.this.bKa.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0144a bKb = new a.InterfaceC0144a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        final int cnz;

        {
            this.cnz = (int) PbActivity.this.getResources().getDimension(f.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Y(int i, int i2) {
            if (ad(i2) && PbActivity.this.fvo != null && PbActivity.this.fuS != null) {
                PbActivity.this.fvo.bev();
                PbActivity.this.fuS.fN(false);
                PbActivity.this.fuS.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Z(int i, int i2) {
            if (ad(i2) && PbActivity.this.fvo != null && PbActivity.this.fuS != null) {
                PbActivity.this.fuS.fN(true);
                if (Math.abs(i2) > this.cnz) {
                    PbActivity.this.fuS.hideFloatingView();
                }
                if (PbActivity.this.bbc()) {
                    PbActivity.this.fvo.bdO();
                    PbActivity.this.fvo.bdP();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void aa(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fwA = null;
    private final m.a fwB = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void h(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(f.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(f.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fwA = str2;
                PbActivity.this.fvo.rq(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fwC = -1;
    private int fwD = -1;
    private CustomMessageListener fwG = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.100
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.acU == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0099a) {
                    if (aVar.acV != null && !aVar.acV.hasError() && aVar.acV.getError() == 0) {
                        if (PbActivity.this.fvo != null) {
                            PbActivity.this.fvo.k(((a.C0099a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bbn();
                        }
                    } else if (z) {
                        if (aVar.acV != null && aVar.acV.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.acV.getErrorString());
                        } else {
                            PbActivity.this.showToast(f.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.acV != null && !aVar.acV.hasError() && aVar.acV.getError() == 0) {
                        if (PbActivity.this.fvo != null && PbActivity.this.fvo != null) {
                            PbActivity.this.fvo.k(((a.C0099a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.acV != null && aVar.acV.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.acV.getErrorString());
                        } else {
                            PbActivity.this.showToast(f.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.acV == null || aVar.acV.hasError() || aVar.acV.getError() != 0) {
                        if (z) {
                            if (aVar.acV != null && aVar.acV.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.acV.getErrorString());
                            } else {
                                PbActivity.this.showToast(f.j.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(f.j.channel_need_push), 1).show();
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
        public ArrayList<String> fxg;
        public ConcurrentHashMap<String, ImageUrlData> fxh;
        public boolean fxj;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fxi = false;
        public boolean fxk = false;
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

    public com.baidu.tbadk.editortools.pb.d baA() {
        return this.fvB;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        if (kVar.aZU() != null) {
            String id = kVar.aZU().getId();
            ArrayList<PostData> aZk = this.fvl.getPbData().aZk();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aZk.size()) {
                    break;
                }
                PostData postData = aZk.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> aZY = kVar.aZY();
                    postData.tI(kVar.getTotalCount());
                    if (postData.bwd() != null && aZY != null) {
                        Iterator<PostData> it = aZY.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.vj() != null && (metaData = postData.getUserMap().get(next.vj().getUserId())) != null) {
                                next.a(metaData);
                                next.mt(true);
                                next.b(getPageContext(), this.fvl.rk(metaData.getUserId()));
                            }
                        }
                        postData.bwd().clear();
                        postData.bwd().addAll(aZY);
                    }
                    if (postData.bvZ() != null) {
                        postData.bwa();
                    }
                }
            }
            if (!this.fvl.getIsFromMark()) {
                this.fvo.n(this.fvl.getPbData());
            }
            c(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd(String str) {
        com.baidu.tieba.tbadkCore.data.l aZy;
        if (!TextUtils.isEmpty(str) && (aZy = this.fvl.getPbData().aZy()) != null && str.equals(aZy.getAdId())) {
            if (aZy.bvU() != null) {
                aZy.bvU().legoCard = null;
            }
            this.fvl.getPbData().aZz();
        }
    }

    public void baB() {
        com.baidu.tieba.pb.data.d pbData;
        com.baidu.tbadk.core.data.bb aZi;
        if (!this.fwe) {
            if (!com.baidu.adp.lib.util.l.jV()) {
                showToast(f.j.no_network_guide);
            } else if (this.fwh) {
                this.fwe = true;
                if (this.fvl != null && (pbData = this.fvl.getPbData()) != null && (aZi = pbData.aZi()) != null) {
                    int isLike = aZi.uW() == null ? 0 : aZi.uW().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10796").ae("tid", aZi.getId()));
                    }
                    if (this.fwf != null) {
                        this.fwf.a(aZi.vA(), aZi.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(f.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(f.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(f.g.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(f.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(f.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(f.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
                bVar.ci(f.j.operation);
                int i = -1;
                if (sparseArray.get(f.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(f.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(f.j.delete);
                    strArr[1] = z ? getResources().getString(f.j.un_mute) : getResources().getString(f.j.mute);
                    bVar.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fvo.a(((Integer) sparseArray.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray.get(f.g.tag_del_post_id), ((Integer) sparseArray.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(f.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(f.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(f.g.tag_user_mute_thread_id), (String) sparseArray.get(f.g.tag_user_mute_post_id), 1, str, PbActivity.this.fvI);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fvI);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(f.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(f.j.un_mute) : getResources().getString(f.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(f.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(f.g.tag_user_mute_thread_id), (String) sparseArray.get(f.g.tag_user_mute_post_id), 1, str, PbActivity.this.fvI);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fvI);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(f.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).xh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN(int i) {
        com.baidu.tbadk.core.data.bb aZi;
        String str;
        String F;
        if (this.fvl != null && this.fvl.getPbData() != null && (aZi = this.fvl.getPbData().aZi()) != null) {
            if (i == 1) {
                PraiseData uW = aZi.uW();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (uW == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aZi.a(praiseData);
                    } else {
                        aZi.uW().getUser().add(0, metaData);
                        aZi.uW().setNum(aZi.uW().getNum() + 1);
                        aZi.uW().setIsLike(i);
                    }
                }
                if (aZi.uW() != null) {
                    if (aZi.uW().getNum() < 1) {
                        F = getResources().getString(f.j.zan);
                    } else {
                        F = com.baidu.tbadk.core.util.ap.F(aZi.uW().getNum());
                    }
                    this.fvo.M(F, true);
                }
            } else if (aZi.uW() != null) {
                aZi.uW().setIsLike(i);
                aZi.uW().setNum(aZi.uW().getNum() - 1);
                ArrayList<MetaData> user = aZi.uW().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aZi.uW().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aZi.uW().getNum() < 1) {
                    str = getResources().getString(f.j.zan);
                } else {
                    str = aZi.uW().getNum() + "";
                }
                this.fvo.M(str, false);
            }
            if (this.fvl.bce()) {
                this.fvo.bdS().notifyDataSetChanged();
            } else {
                this.fvo.o(this.fvl.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fvl.z(bundle);
        if (this.dmn != null) {
            this.dmn.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fvB.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fuY = System.currentTimeMillis();
        this.fvG = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cSK = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fvf = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fvf) && intent.getData() != null) {
                this.fvf = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fvf)) {
                this.fuT = true;
            }
            this.fwC = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fwD = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fwE = intent.getStringExtra("key_manga_title");
            this.fvx = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fvy = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bbc()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.fvP = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.cSK = System.currentTimeMillis();
        }
        this.aTL = this.fuY - this.cSK;
        super.onCreate(bundle);
        this.fuW = 0;
        y(bundle);
        if (this.fvl != null && this.fvl.getPbData() != null) {
            this.fvl.getPbData().rc(this.source);
        }
        initUI();
        if (intent != null && this.fvo != null) {
            this.fvo.fEw = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fvJ == null) {
                    this.fvJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fvo.rs("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fvJ, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fvl != null && this.fvl.getPbData() != null) {
                this.fvl.rn(stringExtra);
            }
        }
        this.dmn = new VoiceManager();
        this.dmn.onCreate(getPageContext());
        initData(bundle);
        this.fvA = new com.baidu.tbadk.editortools.pb.f();
        baC();
        this.fvB = (com.baidu.tbadk.editortools.pb.d) this.fvA.aY(getActivity());
        this.fvB.b(this);
        this.fvB.a(this.aNZ);
        this.fvB.a(this.aNS);
        this.fvB.a(this, bundle);
        this.fvB.Ht().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fvB.Ht().bD(true);
        jz(true);
        this.fvo.setEditorTools(this.fvB.Ht());
        this.fvB.a(this.fvl.bcn(), this.fvl.bcd(), this.fvl.bcG());
        registerListener(this.fvW);
        if (!this.fvl.bck()) {
            this.fvB.gL(this.fvl.bcd());
        }
        if (this.fvl.bcH()) {
            this.fvB.gJ(getPageContext().getString(f.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fvB.gJ(getPageContext().getString(f.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fvV);
        registerListener(this.fvX);
        registerListener(this.fvY);
        registerListener(this.dnw);
        registerListener(this.fwm);
        registerListener(this.fvU);
        this.fvz = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gNv);
        this.fvz.bvH();
        registerListener(this.fwa);
        registerListener(this.mAttentionListener);
        if (this.fvl != null) {
            this.fvl.bcx();
        }
        registerListener(this.fwp);
        registerListener(this.fwG);
        registerListener(this.dnD);
        if (this.fvo != null && this.fvo.bez() != null && this.fvo.beA() != null) {
            this.fuS = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.fvo.bez(), this.fvo.beA(), this.fvo.bdJ());
            this.fuS.a(this.fwi);
        }
        if (this.fuR && this.fvo != null && this.fvo.beA() != null) {
            this.fvo.beA().setVisibility(8);
        }
        this.fvH = new com.baidu.tbadk.core.view.d();
        this.fvH.auR = 1000L;
        registerListener(this.fwl);
        registerListener(this.fwj);
        registerListener(this.fwk);
        registerListener(this.dEi);
        this.fvI = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fvI;
        userMuteAddAndDelCustomMessage.setTag(this.fvI);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fvI;
        userMuteCheckCustomMessage.setTag(this.fvI);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fvl.bcE().a(this.ccJ);
        if ("from_tieba_kuang".equals(this.fvf) && this.fvf != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12264").r("obj_type", 2).ae("tid", this.fvl.bcd()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                    @Override // com.baidu.tbadk.core.e
                    public void ak(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
            httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bh("shoubai://internal?type=pb&param=" + this.fvl.bcd()));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        this.fvt = new av();
        if (this.fvB.HS() != null) {
            this.fvt.g(this.fvB.HS().getInputView());
        }
        this.fvB.a(this.aNT);
        this.dBv = new ShareSuccessReplyToServerModel();
        a(this.fvR);
        this.eHX = new com.baidu.tbadk.core.util.ak(getPageContext());
        this.eHX.a(new ak.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.ak.aqA) {
                        PbActivity.this.fvB.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.ak.aqB && PbActivity.this.fvo != null && PbActivity.this.fvo.bdB() != null && PbActivity.this.fvo.bdB().bbU() != null) {
                        PbActivity.this.fvo.bdB().bbU().Il();
                    } else if (i == com.baidu.tbadk.core.util.ak.aqC) {
                        PbActivity.this.c(PbActivity.this.fvD);
                    }
                }
            }
        });
        this.fvm = new com.baidu.tieba.pb.pb.report.a(this);
        this.fvm.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.fuY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baC() {
        if (this.fvA != null && this.fvl != null) {
            this.fvA.setForumName(this.fvl.bcc());
            if (this.fvl.getPbData() != null && this.fvl.getPbData().aZg() != null) {
                this.fvA.a(this.fvl.getPbData().aZg());
            }
            this.fvA.setFrom("pb");
            this.fvA.a(this.fvl);
        }
    }

    public String baD() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b baE() {
        return this.fuS;
    }

    private void jz(boolean z) {
        this.fvB.bH(z);
        this.fvB.bI(z);
        this.fvB.bJ(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZH() && !z && this.fvo != null && this.fvo.getView() != null) {
            this.fvo.getView().setSystemUiVisibility(4);
        }
        this.fvE = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    public at baF() {
        return this.fvo;
    }

    public PbModel bao() {
        return this.fvl;
    }

    public void re(String str) {
        if (this.fvl != null && !StringUtils.isNull(str) && this.fvo != null) {
            this.fvo.ks(true);
            this.fvl.re(str);
            this.fve = true;
            this.fvo.bel();
            this.fvo.beu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fuU = false;
        } else {
            this.fuU = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fuW = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fuW == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
        if (this.fvo != null) {
            this.fvo.onPause();
        }
        if (!this.fvl.bck()) {
            this.fvB.gK(this.fvl.bcd());
        }
        if (this.fvl != null) {
            this.fvl.bcy();
        }
        MessageManager.getInstance().unRegisterListener(this.elH);
        aFi();
        MessageManager.getInstance().unRegisterListener(this.fwj);
        MessageManager.getInstance().unRegisterListener(this.fwk);
        MessageManager.getInstance().unRegisterListener(this.fwl);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean baG() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fvl.getPbData(), this.fvl.bce(), this.fvl.getRequestType());
        return (a2 == null || a2.vj() == null || a2.vj().getGodUserData() == null || a2.vj().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fuU = false;
        super.onResume();
        if (this.fvh) {
            this.fvh = false;
            bbi();
        }
        if (baG()) {
            this.fvb = System.currentTimeMillis();
        } else {
            this.fvb = -1L;
        }
        if (this.fvo != null && this.fvo.getView() != null) {
            if (!this.eYS) {
                baZ();
            } else {
                hideLoadingView(this.fvo.getView());
            }
            this.fvo.onResume();
        }
        if (this.fuW == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fvo != null) {
            noNetworkView = this.fvo.bdy();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.jE()) {
            noNetworkView.aQ(false);
        }
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
        }
        registerListener(this.elH);
        this.fvw = false;
        bbh();
        registerListener(this.fwj);
        registerListener(this.fwk);
        registerListener(this.fwl);
        if (this.dmW) {
            baY();
            this.dmW = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
                @Override // com.baidu.tbadk.core.e
                public void ak(boolean z) {
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
        this.fvo.kh(z);
        if (this.fvu != null) {
            this.fvu.jT(z);
        }
        if (z && this.fvw) {
            this.fvo.bdX();
            this.fvl.jP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fvb > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").ae("obj_duration", (System.currentTimeMillis() - this.fvb) + ""));
            this.fvb = 0L;
        }
        if (baF().bdB() != null) {
            baF().bdB().onStop();
        }
        if (this.fvo.fED != null && !this.fvo.fED.ajI()) {
            this.fvo.fED.aQD();
        }
        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZg() != null && this.fvl.getPbData().aZi() != null) {
            com.baidu.tbadk.distribute.a.Hf().a(getPageContext().getPageActivity(), "pb", this.fvl.getPbData().aZg().getId(), com.baidu.adp.lib.g.b.c(this.fvl.getPbData().aZi().getId(), 0L));
        }
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.ae(ImageViewerConfig.FORUM_ID, this.fvl.getPbData().getForumId());
            anVar.ae("tid", this.fvl.bcd());
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.fuZ && this.fvo != null) {
            this.fuZ = true;
            this.fvo.beq();
            a(false, (PostData) null);
        }
        if (this.fvl != null) {
            this.fvl.cancelLoadData();
            this.fvl.destory();
            if (this.fvl.bcD() != null) {
                this.fvl.bcD().onDestroy();
            }
        }
        if (this.fvB != null) {
            this.fvB.onDestroy();
        }
        if (this.czJ != null) {
            this.czJ.cancelLoadData();
        }
        if (this.fvo != null) {
            this.fvo.onDestroy();
            if (this.fvo.fED != null) {
                this.fvo.fED.aQD();
            }
        }
        if (this.fva != null) {
            this.fva.KB();
        }
        if (this.fuS != null) {
            this.fuS.Lx();
        }
        super.onDestroy();
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
        this.fvo.bel();
        MessageManager.getInstance().unRegisterListener(this.fwj);
        MessageManager.getInstance().unRegisterListener(this.fwk);
        MessageManager.getInstance().unRegisterListener(this.fwl);
        MessageManager.getInstance().unRegisterListener(this.fvI);
        MessageManager.getInstance().unRegisterListener(this.fwm);
        MessageManager.getInstance().unRegisterListener(this.dnD);
        MessageManager.getInstance().unRegisterListener(this.dEi);
        this.fvG = null;
        this.fvH = null;
        com.baidu.tieba.recapp.d.a.boe().bog();
        if (this.fvJ != null) {
            getSafeHandler().removeCallbacks(this.fvJ);
        }
        if (this.fvi != null) {
            this.fvi.cancelLoadData();
        }
        if (this.fvo != null && this.fvo.fED != null) {
            this.fvo.fED.bfh();
        }
        if (this.dBv != null) {
            this.dBv.cancelLoadData();
        }
        this.fvt.onDestroy();
        if (this.dna != null) {
            this.dna.onDestroy();
        }
        if (this.fvl != null && this.fvl.bcF() != null) {
            this.fvl.bcF().onDestroy();
        }
        if (this.eHX != null) {
            this.eHX.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bdS;
        ArrayList<PostData> bbG;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.BM() && this.fvo != null && (bdS = this.fvo.bdS()) != null && (bbG = bdS.bbG()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bbG.iterator();
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
                        bVar.cBI = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aiA == 1 && !TextUtils.isEmpty(id)) {
                    next.aiA = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.cBI = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fvl == null || this.fvl.getPbData() == null || this.fvl.getPbData().aZg() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fvl.getPbData().aZg().getFirst_class();
                    str2 = this.fvl.getPbData().aZg().getSecond_class();
                    str = this.fvl.getPbData().aZg().getId();
                    str4 = this.fvl.bcd();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.BP());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fvo.onChangeSkinType(i);
            if (this.fvB != null && this.fvB.Ht() != null) {
                this.fvB.Ht().onChangeSkinType(i);
            }
            if (this.fvo.bdy() != null) {
                this.fvo.bdy().onChangeSkinType(getPageContext(), i);
            }
            this.fvt.onChangeSkinType();
            if (this.dna != null) {
                this.dna.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fvo = new at(this, this.dog, this.bgf);
        this.bKa = new com.baidu.tieba.f.b(getActivity());
        this.bKa.a(fwz);
        this.bKa.a(this.bKb);
        this.fvo.setOnScrollListener(this.mOnScrollListener);
        this.fvo.e(this.fwt);
        this.fvo.a(this.bpz);
        this.fvo.jt(com.baidu.tbadk.core.i.td().tj());
        this.fvo.setOnImageClickListener(this.bge);
        this.fvo.b(this.aHj);
        this.fvo.h(this.dkd);
        this.fvo.a(this.fwr);
        this.fvo.kh(this.mIsLogin);
        if (getIntent() != null) {
            this.fvo.kt(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fvo.bdA().setFromForumId(this.fvl.getFromForumId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bc(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(f.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.gNX && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.td().tj()) {
                    return rh(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fvl == null || this.fvl.getPbData() == null) {
                        return true;
                    }
                    if (baF().bdB() != null) {
                        baF().bdB().bbP();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.fvl.getPbData().aZg());
                    kVar.Z(this.fvl.getPbData().aZi());
                    kVar.d(postData);
                    baF().bdA().d(kVar);
                    baF().bdA().setPostId(postData.getId());
                    a(view, postData.vj().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fvB != null) {
                        this.fvo.ko(this.fvB.HZ());
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
        if (this.fvo != null) {
            if (z && !this.eYS) {
                baZ();
            } else {
                hideLoadingView(this.fvo.getView());
            }
            if (z && this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZH() && this.fvo.getView() != null) {
                this.fvo.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void baH() {
        if (this.fuX == null) {
            this.fuX = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fuX.a(new String[]{getPageContext().getString(f.j.call_phone), getPageContext().getString(f.j.sms_phone), getPageContext().getString(f.j.search_in_baidu)}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fuM = PbActivity.this.fuM.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuM);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fvl.bcd(), PbActivity.this.fuM, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fuM = PbActivity.this.fuM.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuM);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fvl.bcd(), PbActivity.this.fuM, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fuM = PbActivity.this.fuM.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuM);
                        bVar.dismiss();
                    }
                }
            }).cj(b.a.alb).ck(17).d(getPageContext());
        }
    }

    private void y(Bundle bundle) {
        this.fvl = new PbModel(this);
        this.fvl.a(this.fwo);
        if (this.fvl.bcB() != null) {
            this.fvl.bcB().a(this.fwB);
        }
        if (this.fvl.bcA() != null) {
            this.fvl.bcA().a(this.fvZ);
        }
        if (this.fvl.bcD() != null) {
            this.fvl.bcD().b(this.fvT);
        }
        if (bundle != null) {
            this.fvl.initWithBundle(bundle);
        } else {
            this.fvl.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fvl.jS(true);
        }
        aj.bdl().L(this.fvl.bcb(), this.fvl.getIsFromMark());
        if (StringUtils.isNull(this.fvl.bcd())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fvf) && this.fvf != null) {
            this.fvl.qJ(6);
        }
        if (this.fvl.bcC() != null) {
            this.fvl.bcC().a(this.fvS);
        }
        if (this.fvl.bcF() != null) {
            this.fvl.bcF().a(this.dne);
        }
        this.fvl.JV();
    }

    private void initData(Bundle bundle) {
        this.fvn = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fvn != null) {
            this.fvn.a(this.fwq);
        }
        this.czJ = new ForumManageModel(this);
        this.czJ.setLoadDataCallBack(this.czN);
        this.aqF = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fvo.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void i(Object obj) {
                if (!com.baidu.adp.lib.util.j.jE()) {
                    PbActivity.this.showToast(f.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fvl.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvl.getPbData().aZg().getId(), PbActivity.this.fvl.getPbData().aZg().getName(), PbActivity.this.fvl.getPbData().aZi().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fwf.setUniqueId(getUniqueId());
        this.fwf.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fvo.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(f.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fvI;
        userMuteCheckCustomMessage.setTag(this.fvI);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String baI() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fvl != null && (pbData = this.fvl.getPbData()) != null) {
            return pbData.aZt().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aZi() != null) {
            if (dVar.aZi().getThreadType() == 0) {
                return 1;
            }
            if (dVar.aZi().getThreadType() == 54) {
                return 2;
            }
            if (dVar.aZi().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData bd(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(f.g.tag_clip_board)) != null) {
            if (postData.bws()) {
                postData.cS(postData.bwr() - 1);
            } else {
                postData.cS(postData.bwr() + 1);
                com.baidu.tieba.n.a.bmW().y(getPageContext());
            }
            postData.mu(!postData.bws());
            ((PbFloorAgreeView) view).a(postData.bws(), postData.bwr(), true);
            final int i = postData.bws() ? 0 : 1;
            this.fvl.bcC().a(postData.getId(), i, new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
                @Override // com.baidu.tieba.pb.pb.main.r.a
                public void qw(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).qU(i2);
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

    public com.baidu.tbadk.core.util.an baJ() {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12003");
        anVar.ae("tid", this.fvl.fAA);
        anVar.r("obj_type", 0);
        anVar.ae(ImageViewerConfig.FORUM_ID, this.fvl.getForumId());
        anVar.r("obj_param1", this.fvl.getPbData().aZi().getThreadType() == 40 ? 2 : 1);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.ae("obj_param2", TbadkCoreApplication.getInst().getTaskId());
        }
        return anVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && baK()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // java.lang.Runnable
                public void run() {
                    int f;
                    int aj = (com.baidu.adp.lib.util.l.aj(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        f = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.f(PbActivity.this.getPageContext().getPageActivity(), f.e.ds120);
                    } else {
                        f = com.baidu.adp.lib.util.l.f(PbActivity.this.getPageContext().getPageActivity(), f.e.ds640);
                    }
                    int i = f - aj;
                    if (i > 0) {
                        PbActivity.this.baF().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.baF().bdB() != null) {
                        PbActivity.this.fvB.Ht().setVisibility(8);
                        PbActivity.this.baF().bdB().bO(str, str2);
                        com.baidu.tbadk.editortools.pb.g bbU = PbActivity.this.baF().bdB().bbU();
                        if (bbU != null && PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null) {
                            bbU.a(PbActivity.this.fvl.getPbData().ug());
                        }
                        if (PbActivity.this.fvt.beN() == null && PbActivity.this.baF().bdB().bbU().It() != null) {
                            PbActivity.this.baF().bdB().bbU().It().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fvt != null && PbActivity.this.fvt.beM() != null) {
                                        if (!PbActivity.this.fvt.beM().bFq()) {
                                            PbActivity.this.fvt.kv(false);
                                        }
                                        PbActivity.this.fvt.beM().no(false);
                                    }
                                }
                            });
                            PbActivity.this.fvt.h(PbActivity.this.baF().bdB().bbU().It().getInputView());
                            PbActivity.this.baF().bdB().bbU().a(PbActivity.this.fvF);
                        }
                    }
                    PbActivity.this.baF().beu();
                }
            }, 500L);
        }
    }

    public boolean baK() {
        if (this.eHX == null || this.fvl.getPbData() == null || this.fvl.getPbData().ug() == null) {
            return true;
        }
        return this.eHX.cP(this.fvl.getPbData().ug().replyPrivateFlag);
    }

    public boolean qs(int i) {
        if (this.eHX == null || this.fvl.getPbData() == null || this.fvl.getPbData().ug() == null) {
            return true;
        }
        return this.eHX.u(this.fvl.getPbData().ug().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(f.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(f.g.tag_clip_board)) != null && this.fvl != null && this.fvl.getPbData() != null && postData.bwg() > 1) {
            String bcd = this.fvl.bcd();
            String id = postData.getId();
            int aZu = this.fvl.getPbData() != null ? this.fvl.getPbData().aZu() : 0;
            c ri = ri(id);
            if (ri != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bcd, id, "pb", true, null, false, null, aZu, postData.bfU(), this.fvl.getPbData().ug(), false, postData.vj() != null ? postData.vj().getIconInfo() : null).addBigImageData(ri.fxg, ri.fxh, ri.fxi, ri.index);
                addBigImageData.setKeyPageStartFrom(this.fvl.bcJ());
                addBigImageData.setFromFrsForumId(this.fvl.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        aq aqVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.jV()) {
                showToast(f.j.no_network_guide);
            } else if (bao() != null && bao().getPbData() != null && bao().getPbData().aZG() != null) {
                com.baidu.tieba.pb.data.j aZG = bao().getPbData().aZG();
                if (view == null || !(view.getTag(f.g.pb_main_thread_praise_view) instanceof aq)) {
                    aqVar = null;
                } else {
                    aqVar = (aq) view.getTag(f.g.pb_main_thread_praise_view);
                }
                if (aZG != null) {
                    int i3 = -1;
                    if (z) {
                        aZG.qk(i);
                    } else if (aZG.aZO()) {
                        aZG.aZR();
                        i3 = 1;
                    } else {
                        aZG.qm(i);
                        i3 = 0;
                        com.baidu.tieba.n.a.bmW().y(getPageContext());
                    }
                    aZG.ql(i2);
                    r.a aVar = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
                        @Override // com.baidu.tieba.pb.pb.main.r.a
                        public void qw(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.r.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.fvl != null && this.fvl.bcC() != null) {
                        String str = "";
                        if (this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null) {
                            str = this.fvl.getPbData().aZi().vA();
                        }
                        if (this.fvl.getPbData() != null) {
                            this.fvl.getPbData().a(aZG);
                        }
                        if (z) {
                            this.fvl.bcC().a(str, 3, i, this.fvl.getForumId(), aVar);
                        } else {
                            this.fvl.bcC().a(str, i3, 3, i, this.fvl.getForumId(), aVar);
                            com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i();
                            iVar.ftf = i3;
                            iVar.ftg = aZG;
                            iVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016551, iVar));
                        }
                    }
                    if (aqVar != null) {
                        aqVar.b(aZG);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int baL() {
        if (this.fvl.getPbData() == null || this.fvl.getPbData().aZi() == null) {
            return -1;
        }
        return this.fvl.getPbData().aZi().vM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baM() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.tj(this.fvl.getForumId()) && this.fvl.getPbData() != null && this.fvl.getPbData().aZg() != null) {
            if (this.fvl.getPbData().aZg().isLike() == 1) {
                this.fvl.bcF().ce(this.fvl.getForumId(), this.fvl.bcd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jA(boolean z) {
        if (this.fvl == null || this.fvl.getPbData() == null) {
            return false;
        }
        return ((this.fvl.getPbData().aZu() != 0) || this.fvl.getPbData().aZi() == null || this.fvl.getPbData().aZi().vj() == null || TextUtils.equals(this.fvl.getPbData().aZi().vj().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String baN() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.p.s.Lb()) {
            return "";
        }
        PostData aZp = aZp();
        if (this.fvl == null || (pbData = this.fvl.getPbData()) == null || pbData.getUserData() == null || pbData.aZi() == null || aZp == null || aZp.vj() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aZp.vj().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aZi().uR() == 0) {
            return "";
        }
        if (pbData.aZi().uR() == 0) {
            return getPageContext().getString(f.j.fans_call);
        }
        return getPageContext().getString(f.j.haved_fans_call);
    }

    private boolean jB(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fvl == null || this.fvl.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fvl.getPbData();
        if (pbData.aZu() == 0) {
            List<com.baidu.tbadk.core.data.ay> aZE = pbData.aZE();
            if (com.baidu.tbadk.core.util.w.y(aZE) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : aZE) {
                    if (ayVar != null && (tVar = ayVar.ahr) != null && tVar.afp && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean jC(boolean z) {
        return (z || this.fvl == null || this.fvl.getPbData() == null || this.fvl.getPbData().aZu() == 0) ? false : true;
    }

    public void baO() {
        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null && this.fvl.getPbData().aZi().vj() != null) {
            if (this.fvo != null) {
                this.fvo.bdz();
            }
            com.baidu.tbadk.core.data.bb aZi = this.fvl.getPbData().aZi();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aZi.vj().getUserId());
            ab abVar = new ab();
            int aZu = this.fvl.getPbData().aZu();
            if (aZu == 1) {
                abVar.fCB = true;
                abVar.fCA = true;
                abVar.fCI = aZi.ve() == 1;
                abVar.fCH = aZi.vf() == 1;
            } else {
                abVar.fCB = false;
                abVar.fCA = false;
            }
            if (aZu == 1002 && !equals) {
                abVar.fCM = true;
            }
            abVar.fCy = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.fCC = jB(equals);
            abVar.fCD = baP();
            abVar.fCE = jC(equals);
            abVar.nK = this.fvl.bce();
            abVar.fCz = true;
            abVar.fts = this.fvn != null && this.fvn.rL();
            abVar.fCx = jA(equals);
            abVar.fCK = baN();
            abVar.fCw = equals && this.fvo.bee();
            abVar.fCF = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fCG = true;
            abVar.isHostOnly = this.fvl.getHostMode();
            abVar.fCJ = true;
            if (aZi.vB() == null) {
                abVar.fCL = true;
            } else {
                abVar.fCL = false;
            }
            this.fvo.fED.a(abVar);
        }
    }

    private boolean baP() {
        if (this.fvl != null && this.fvl.bce()) {
            return this.fvl.getPageData() == null || this.fvl.getPageData().us() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(f.g.tag_clip_board)) != null) {
            e(postData);
        }
    }

    public int baQ() {
        if (baF() == null || baF().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = baF().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.ftb) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int baR() {
        if (baF() == null || baF().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = baF().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.gNW) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        baY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.dA(getResources().getString(f.j.mark_done));
            aVar.aC(true);
            aVar.dB(getResources().getString(f.j.mark_like));
            aVar.aB(true);
            aVar.av(false);
            aVar.b(getResources().getString(f.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").ae(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(f.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").ae(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aqF.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fvl.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).xe();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fvo.bdY();
        this.fvl.jR(z);
        if (this.fvn != null) {
            this.fvn.ae(z);
            if (markData != null) {
                this.fvn.a(markData);
            }
        }
        if (this.fvl.rL()) {
            baW();
        } else {
            this.fvo.n(this.fvl.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qq(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rf(String str) {
        this.fvm.rB(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fvl.bck()) {
                    antiData.setBlock_forum_name(this.fvl.getPbData().aZg().getName());
                    antiData.setBlock_forum_id(this.fvl.getPbData().aZg().getId());
                    antiData.setUser_name(this.fvl.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fvl.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else if (baF() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.al(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.arp));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.arp));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.arp));
            }
        } else if (i == 230277) {
            gR(str);
        } else {
            this.fvo.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.gQs) ? bVar.gQs : getString(f.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dB(string);
                aVar.a(f.j.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.av(true);
                aVar.b(getPageContext());
                aVar.xe();
            } else {
                this.fvo.a(0, bVar.EX, bVar.gQs, z);
            }
            if (bVar.EX) {
                if (bVar.gQq == 1) {
                    ArrayList<PostData> aZk = this.fvl.getPbData().aZk();
                    int size = aZk.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aZk.get(i).getId())) {
                            i++;
                        } else {
                            aZk.remove(i);
                            break;
                        }
                    }
                    this.fvo.n(this.fvl.getPbData());
                } else if (bVar.gQq == 0) {
                    baS();
                } else if (bVar.gQq == 2) {
                    ArrayList<PostData> aZk2 = this.fvl.getPbData().aZk();
                    int size2 = aZk2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aZk2.get(i2).bwd().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aZk2.get(i2).bwd().get(i3).getId())) {
                                i3++;
                            } else {
                                aZk2.get(i2).bwd().remove(i3);
                                aZk2.get(i2).bwf();
                                z2 = true;
                                break;
                            }
                        }
                        aZk2.get(i2).tO(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fvo.n(this.fvl.getPbData());
                    }
                    a(bVar, this.fvo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fvo.a(this.czJ.getLoadDataMode(), gVar.EX, gVar.gQs, false);
            if (gVar.EX) {
                this.fvq = true;
                if (i == 2 || i == 3) {
                    this.fvr = true;
                    this.fvs = false;
                } else if (i == 4 || i == 5) {
                    this.fvr = false;
                    this.fvs = true;
                }
                if (i == 2) {
                    this.fvl.getPbData().aZi().bW(1);
                    this.fvl.setIsGood(1);
                } else if (i == 3) {
                    this.fvl.getPbData().aZi().bW(0);
                    this.fvl.setIsGood(0);
                } else if (i == 4) {
                    this.fvl.getPbData().aZi().bV(1);
                    this.fvl.ji(1);
                } else if (i == 5) {
                    this.fvl.getPbData().aZi().bV(0);
                    this.fvl.ji(0);
                }
                this.fvo.c(this.fvl.getPbData(), this.fvl.bce());
            }
        }
    }

    private void baS() {
        if (this.fvl.bcf() || this.fvl.bch()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fvl.bcd());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fvl.bcd()));
        if (baX()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baT() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aZr;
        boolean z = false;
        if (this.fvo != null) {
            this.fvo.bel();
        }
        if (this.fvl != null && this.fvl.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fvl.getPbData().aZi().getId();
            if (this.fvl.isShareThread() && this.fvl.getPbData().aZi().ajH != null) {
                historyMessage.threadName = this.fvl.getPbData().aZi().ajH.showText;
            } else {
                historyMessage.threadName = this.fvl.getPbData().aZi().getTitle();
            }
            if (this.fvl.isShareThread() && !bbp()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fvl.getPbData().aZg().getName();
            }
            ArrayList<PostData> aZk = this.fvl.getPbData().aZk();
            int bea = this.fvo != null ? this.fvo.bea() : 0;
            if (aZk != null && bea >= 0 && bea < aZk.size()) {
                historyMessage.postID = aZk.get(bea).getId();
            }
            historyMessage.isHostOnly = this.fvl.getHostMode();
            historyMessage.isSquence = this.fvl.bce();
            historyMessage.isShareThread = this.fvl.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fvB != null) {
            this.fvB.onDestroy();
        }
        if (this.fuV && baF() != null) {
            baF().beE();
        }
        if (this.fvl != null && (this.fvl.bcf() || this.fvl.bch())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fvl.bcd());
            if (this.fvq) {
                if (this.fvs) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fvl.bcj());
                }
                if (this.fvr) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fvl.getIsGood());
                }
            }
            if (this.fvl.getPbData() != null && System.currentTimeMillis() - this.fuY >= 40000 && (aZr = this.fvl.getPbData().aZr()) != null && !com.baidu.tbadk.core.util.w.z(aZr.getDataList())) {
                intent.putExtra("guess_like_data", aZr);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fvP);
            }
            setResult(-1, intent);
        }
        if (baX()) {
            if (this.fvl != null && this.fvo != null && this.fvo.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fvl.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aZo() && !this.fve) {
                        aj bdl = aj.bdl();
                        com.baidu.tieba.pb.data.d pbData2 = this.fvl.getPbData();
                        Parcelable onSaveInstanceState = this.fvo.getListView().onSaveInstanceState();
                        boolean bce = this.fvl.bce();
                        boolean hostMode = this.fvl.getHostMode();
                        if (this.fvo.bdJ() != null && this.fvo.bdJ().getVisibility() == 0) {
                            z = true;
                        }
                        bdl.a(pbData2, onSaveInstanceState, bce, hostMode, z);
                        if (this.fvO >= 0 || this.fvl.bcL() != null) {
                            aj.bdl().i(this.fvl.bcL());
                            aj.bdl().h(this.fvl.bcM());
                            aj.bdl().qL(this.fvl.bcN());
                        }
                    }
                }
            } else {
                aj.bdl().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fvo == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fvo.qP(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qt(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fvo.bdz();
            this.fvo.bdB().bbP();
            this.fvo.kq(false);
        }
        this.fvo.bdC();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fvB.resetData();
                        this.fvB.b(writeData);
                        this.fvB.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k eN = this.fvB.Ht().eN(6);
                        if (eN != null && eN.aMc != null) {
                            eN.aMc.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fvB.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fvo.bdB() != null && this.fvo.bdB().bbU() != null) {
                            com.baidu.tbadk.editortools.pb.g bbU = this.fvo.bdB().bbU();
                            bbU.b(writeData);
                            bbU.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k eN2 = bbU.Ht().eN(6);
                            if (eN2 != null && eN2.aMc != null) {
                                eN2.aMc.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bbU.Il();
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
        this.fvB.onActivityResult(i, i2, intent);
        if (this.fvi != null) {
            this.fvi.onActivityResult(i, i2, intent);
        }
        if (baF().bdB() != null) {
            baF().bdB().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    baV();
                    return;
                case 13008:
                    aj.bdl().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fvl != null) {
                                PbActivity.this.fvl.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bmW().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fvl != null) {
                        a(baU(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    J(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bmW().x(getPageContext());
                        baM();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dBv != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dBv.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void Es() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63.1
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
                    this.fvo.jy(false);
                    if (this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null && this.fvl.getPbData().aZi().vD() != null) {
                        this.fvl.getPbData().aZi().vD().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fvD = emotionImageData;
                        if (qs(com.baidu.tbadk.core.util.ak.aqC)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fvo != null && this.fvo.fED != null) {
                        this.fvo.fED.sy();
                        this.fvo.fED.bfb();
                        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null) {
                            this.fvl.getPbData().aZi().bR(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fvj != null) {
                        this.fvo.bm(this.fvj);
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
            if (this.fvi == null) {
                this.fvi = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fvi.b(this.aNS);
                this.fvi.c(this.aNZ);
            }
            this.fvi.a(emotionImageData, bao(), bao().getPbData());
        }
    }

    private ShareFromPBMsgData baU() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bW = this.fvl.getPbData().bW(getPageContext().getPageActivity());
        PostData bdE = this.fvo.bdE();
        String str = "";
        if (bdE != null) {
            str = bdE.getId();
            String ci = bdE.ci(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ci)) {
                bW[1] = ci;
            }
        }
        String vA = this.fvl.getPbData().aZi().vA();
        if (vA != null && vA.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bW[1]);
        shareFromPBMsgData.setImageUrl(bW[0]);
        shareFromPBMsgData.setForumName(this.fvl.getPbData().aZg().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fvl.getPbData().aZi().getId());
        shareFromPBMsgData.setTitle(this.fvl.getPbData().aZi().getTitle());
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(baU(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ch(1);
            aVar.w(thread2GroupShareView);
            aVar.a(f.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null) {
                        com.baidu.tbadk.core.util.an ae = new com.baidu.tbadk.core.util.an("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ae(ImageViewerConfig.FORUM_ID, PbActivity.this.fvl.getForumId()).ae("tid", PbActivity.this.fvl.bcd());
                        if (PbActivity.this.e(PbActivity.this.fvl.getPbData()) != 0) {
                            ae.r("obj_type", PbActivity.this.e(PbActivity.this.fvl.getPbData()));
                        }
                        TiebaStatic.log(ae);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aw(true);
            aVar.b(getPageContext()).xe();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.fvl.getPbData().aZv() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ch(1);
            aVar.w(thread2GroupShareView);
            aVar.a(f.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aw(true);
            aVar.b(getPageContext()).xe();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.fvl.getPbData().aZv() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baV() {
        MarkData qI;
        if (this.fvn != null && (qI = this.fvl.qI(this.fvo.beb())) != null) {
            if (!qI.isApp() || (qI = this.fvl.qI(this.fvo.beb() + 1)) != null) {
                this.fvo.bdW();
                this.fvn.a(qI);
                if (!this.fvn.rL()) {
                    this.fvn.rN();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fvn.rM();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baW() {
        com.baidu.tieba.pb.data.d pbData = this.fvl.getPbData();
        this.fvl.jR(true);
        if (this.fvn != null) {
            pbData.rb(this.fvn.rK());
        }
        this.fvo.n(pbData);
    }

    private boolean baX() {
        if (this.fvl == null) {
            return true;
        }
        if (this.fvl.rL()) {
            final MarkData bcs = this.fvl.bcs();
            if (bcs == null || !this.fvl.getIsFromMark()) {
                return true;
            }
            final MarkData qI = this.fvl.qI(this.fvo.bea());
            if (qI == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bcs);
                setResult(-1, intent);
                return true;
            } else if (qI.getPostId() == null || qI.getPostId().equals(bcs.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bcs);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dB(getPageContext().getString(f.j.alert_update_mark));
                aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fvn != null) {
                            if (PbActivity.this.fvn.rL()) {
                                PbActivity.this.fvn.rM();
                                PbActivity.this.fvn.ae(false);
                            }
                            PbActivity.this.fvn.a(qI);
                            PbActivity.this.fvn.ae(true);
                            PbActivity.this.fvn.rN();
                        }
                        bcs.setPostId(qI.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bcs);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.baT();
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bcs);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.baT();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fvo != null && PbActivity.this.fvo.getView() != null) {
                            PbActivity.this.fvo.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bcs);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.baT();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.xe();
                return false;
            }
        } else if (this.fvl.getPbData() == null || this.fvl.getPbData().aZk() == null || this.fvl.getPbData().aZk().size() <= 0 || !this.fvl.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fvo == null) {
            return null;
        }
        return this.fvo.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Od() {
        if (this.fvo == null) {
            return 0;
        }
        return this.fvo.bej();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Oe() {
        if (this.bfV == null) {
            this.bfV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aga */
                public ImageView ig() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean tj = com.baidu.tbadk.core.i.td().tj();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(f.d.common_color_10220));
                    if (tj) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(f.C0146f.icon_click);
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
                        foreDrawableImageView.setDefaultBgResource(f.d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView r(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.td().tj()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(f.C0146f.icon_click);
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
                        foreDrawableImageView.setDefaultBgResource(f.d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bfV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Of() {
        if (this.bfW == null) {
            this.bfW = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.bfW;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Og() {
        if (this.bga == null) {
            this.bga = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbs */
                public GifView ig() {
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
                    gifView.IN();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bga;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Oh() {
        if (this.bfX == null) {
            this.bfX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbt */
                public View ig() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(f.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bg */
                public void q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bh */
                public View r(View view) {
                    ((PlayVoiceBntNew) view).bxq();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bi */
                public View s(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bfX;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Oj() {
        this.bfZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bbu */
            public RelativeLayout ig() {
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
        return this.bfZ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AQ() {
        if (this.ayP == null) {
            this.ayP = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.ayP;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fvc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (ay.rt(str) && this.fvl != null && this.fvl.bcd() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").r("obj_param1", 1).ae("post_id", this.fvl.bcd()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                hVar.mLink = str;
                hVar.type = 3;
                hVar.aLf = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
            }
        } else {
            ay.beP().c(getPageContext(), str);
        }
        this.fvc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        ay.beP().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fvc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fvl.getPbData();
            TbRichText aB = aB(str, i);
            if (aB != null && (tbRichTextData = aB.Nw().get(this.fwu)) != null) {
                cVar.fxg = new ArrayList<>();
                cVar.fxh = new ConcurrentHashMap<>();
                if (!tbRichTextData.NC().NO()) {
                    cVar.fxj = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fxg.add(b2);
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
                    imageUrlData.postId = aB.getPostId();
                    imageUrlData.mIsReserver = this.fvl.bcr();
                    imageUrlData.mIsSeeHost = this.fvl.getHostMode();
                    cVar.fxh.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aZg() != null) {
                            cVar.forumName = pbData.aZg().getName();
                            cVar.forumId = pbData.aZg().getId();
                        }
                        if (pbData.aZi() != null) {
                            cVar.threadId = pbData.aZi().getId();
                        }
                        cVar.fxi = pbData.aZv() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fxj = true;
                int size = pbData.aZk().size();
                this.fwv = false;
                cVar.index = -1;
                if (pbData.aZp() != null) {
                    PostData aZp = pbData.aZp();
                    TbRichText bwi = aZp.bwi();
                    if (!as.j(aZp)) {
                        i2 = a(bwi, aB, i, i, cVar.fxg, cVar.fxh);
                    } else {
                        i2 = a(aZp, i, cVar.fxg, cVar.fxh);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aZk().get(i4);
                    if (postData.getId() == null || pbData.aZp() == null || pbData.aZp().getId() == null || !postData.getId().equals(pbData.aZp().getId())) {
                        TbRichText bwi2 = postData.bwi();
                        if (!as.j(postData)) {
                            i3 = a(bwi2, aB, i3, i, cVar.fxg, cVar.fxh);
                        } else {
                            i3 = a(postData, i3, cVar.fxg, cVar.fxh);
                        }
                    }
                }
                if (cVar.fxg.size() > 0) {
                    cVar.lastId = cVar.fxg.get(cVar.fxg.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aZg() != null) {
                        cVar.forumName = pbData.aZg().getName();
                        cVar.forumId = pbData.aZg().getId();
                    }
                    if (pbData.aZi() != null) {
                        cVar.threadId = pbData.aZi().getId();
                    }
                    cVar.fxi = pbData.aZv() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.NC() == null) {
            return null;
        }
        return tbRichTextData.NC().NU();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.NC() == null) {
            return 0L;
        }
        return tbRichTextData.NC().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.NC() == null) {
            return false;
        }
        return tbRichTextData.NC().NV();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.NC() == null) {
            return false;
        }
        return tbRichTextData.NC().NW();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo NC;
        String str;
        if (tbRichText == tbRichText2) {
            this.fwv = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Nw().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Nw().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ak = (int) com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.NC().getWidth() * ak;
                    int height = ak * tbRichTextData.NC().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.NC().NO()) {
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
                            if (tbRichTextData != null && (NC = tbRichTextData.NC()) != null) {
                                String NR = NC.NR();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = NC.NS();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = NR;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fvl.bcd(), -1L);
                                imageUrlData.mIsReserver = this.fvl.bcr();
                                imageUrlData.mIsSeeHost = this.fvl.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fwv) {
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
        com.baidu.tieba.tbadkCore.data.h bwp;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bvL;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bvL = (bwp = postData.bwp()).bvL()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bvL.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bvL.get(i3);
                if (jVar != null) {
                    String bvP = jVar.bvP();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(bvP)) {
                        arrayList.add(bvP);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bvP;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bvO();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fvl.bcd(), -1L);
                        imageUrlData.mIsReserver = this.fvl.bcr();
                        imageUrlData.mIsSeeHost = this.fvl.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bwp.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bvP, imageUrlData);
                        }
                        if (!this.fwv) {
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
            if (postData.getId() != null && postData.getId().equals(this.fvl.vt())) {
                z = true;
            }
            MarkData g = this.fvl.g(postData);
            if (g != null) {
                this.fvo.bdW();
                if (this.fvn != null) {
                    this.fvn.a(g);
                    if (!z) {
                        this.fvn.rN();
                    } else {
                        this.fvn.rM();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aB(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fvl == null || this.fvl.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fvl.getPbData();
        if (pbData.aZp() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aZp());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aZk = pbData.aZk();
            a(pbData, aZk);
            return a(aZk, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.aZt() != null && dVar.aZt().ftu != null && (list = dVar.aZt().ftu) != null && arrayList != null) {
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

    private long rg(String str) {
        ArrayList<PostData> aZk;
        com.baidu.tieba.pb.data.d pbData = this.fvl.getPbData();
        if (pbData != null && (aZk = pbData.aZk()) != null && !aZk.isEmpty()) {
            Iterator<PostData> it = aZk.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bwp = next.bwp();
                if (bwp != null && bwp.gND) {
                    Iterator<TbRichTextData> it2 = next.bwi().Nw().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.NL().getLink().equals(str)) {
                            return bwp.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Nw;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bwi = arrayList.get(i2).bwi();
            if (bwi != null && (Nw = bwi.Nw()) != null) {
                int size = Nw.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Nw.get(i4) != null && Nw.get(i4).getType() == 8) {
                        i3++;
                        if (Nw.get(i4).NC().NR().equals(str) || Nw.get(i4).NC().NS().equals(str)) {
                            int ak = (int) com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
                            int width = Nw.get(i4).NC().getWidth() * ak;
                            int height = Nw.get(i4).NC().getHeight() * ak;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fwu = i4;
                            return bwi;
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
            this.fuM = str;
            if (this.fuX == null) {
                baH();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fuX.cn(1).setVisibility(8);
            } else {
                this.fuX.cn(1).setVisibility(0);
            }
            this.fuX.xh();
            this.fvc = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dmn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baY() {
        hideNetRefreshView(this.fvo.getView());
        baZ();
        if (this.fvl.JV()) {
            this.fvo.bdW();
        }
    }

    private void baZ() {
        showLoadingView(this.fvo.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds400));
        View Ji = getLoadingView().Ji();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Ji.getLayoutParams();
        layoutParams.addRule(3, this.fvo.bez().getId());
        Ji.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auA() {
        if (this.dmn != null) {
            this.dmn.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu(int i) {
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
    public void qv(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fvl.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fvl.getPbData();
            pbData.aZg().getName();
            String title = pbData.aZi().getTitle();
            int i2 = this.fvl.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aZg() != null) {
                if ((pbData.aZg().isLike() == 1) && AddExperiencedModel.tj(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fvl.bcd() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bW = pbData.bW(getPageContext().getPageActivity());
                    str = bW[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bW[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (baL() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").ae(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ae("tid", pbData.getThreadId()).ae("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aFT = true;
                    dVar.aFY = z;
                    dVar.extData = this.fvl.bcd();
                    dVar.aGh = 3;
                    dVar.aGg = i;
                    dVar.fid = this.fvl.getForumId();
                    dVar.tid = this.fvl.bcd();
                    dVar.aGi = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fvl.getPbData().aZi());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aGh);
                    bundle.putInt("obj_type", dVar.aGi);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.f(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZH()) {
                                PbActivity.this.fvo.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.akQ().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fvl.bcd() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bW2 = pbData.bW(getPageContext().getPageActivity());
            str = bW2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bW2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (baL() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aFT = true;
            dVar2.aFY = z;
            dVar2.extData = this.fvl.bcd();
            dVar2.aGh = 3;
            dVar2.aGg = i;
            dVar2.fid = this.fvl.getForumId();
            dVar2.tid = this.fvl.bcd();
            dVar2.aGi = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fvl.getPbData().aZi());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aGh);
            bundle2.putInt("obj_type", dVar2.aGi);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.f(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fvl != null && PbActivity.this.fvl.getPbData() != null && PbActivity.this.fvl.getPbData().aZH()) {
                        PbActivity.this.fvo.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.akQ().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aZi() != null) {
            if (dVar.aZi().getThreadType() == 0) {
                return 1;
            }
            if (dVar.aZi().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bba() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.tk(PbActivity.this.fvl.getForumId()));
            }
        }, new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fvo.beF();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Oi() {
        if (this.bfY == null) {
            this.bfY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbv */
                public LinearLayout ig() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(f.g.pb_text_voice_layout);
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
        return this.bfY;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fvo.bdR() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).ae(ImageViewerConfig.FORUM_ID, this.fvl.getPbData().getForumId()));
            } else {
                com.baidu.tbadk.core.data.bb aZi = this.fvl.getPbData().aZi();
                if (view != null) {
                    boolean z = aZi.uW() == null || aZi.uW().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fwg > 1000) {
                            this.fwh = true;
                            bf(view);
                        } else {
                            this.fwh = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            l(view, this.fwh);
                        } else {
                            k(view, this.fwh);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        k(view, this.fwh);
                    } else if (motionEvent.getAction() == 3) {
                        k(view, this.fwh);
                    }
                }
            }
        }
        return false;
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), f.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fwg = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), f.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fwg = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bf(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), f.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void auB() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData Cb() {
        if (this.fvl == null || this.fvl.getPbData() == null) {
            return null;
        }
        return this.fvl.getPbData().ug();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.xg() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.xg();
            int intValue = ((Integer) sparseArray.get(at.fGq)).intValue();
            if (intValue == at.fGr) {
                if (!this.czJ.bwU()) {
                    this.fvo.bdT();
                    String str = (String) sparseArray.get(f.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(f.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(f.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(f.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.czJ.tU(com.baidu.tbadk.core.util.ap.d(jSONArray));
                    }
                    this.czJ.a(this.fvl.getPbData().aZg().getId(), this.fvl.getPbData().aZg().getName(), this.fvl.getPbData().aZi().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == at.fGs || intValue == at.fGu) {
                if (this.fvl.bcB() != null) {
                    this.fvl.bcB().qz(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == at.fGs) {
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
        if (sparseArray.get(f.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(f.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(f.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(f.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(f.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(f.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(f.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(f.g.tag_user_mute_msg);
        }
        if (sparseArray.get(f.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(f.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fvI);
        userMuteAddAndDelCustomMessage.setTag(this.fvI);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean rh(String str) {
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
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(f.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void jD(boolean z) {
        this.fvw = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bbb() {
        ArrayList<PostData> aZk;
        int y;
        if (this.fvl == null || this.fvl.getPbData() == null || this.fvl.getPbData().aZk() == null || (y = com.baidu.tbadk.core.util.w.y((aZk = this.fvl.getPbData().aZk()))) == 0) {
            return "";
        }
        if (this.fvl.bcr()) {
            Iterator<PostData> it = aZk.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bwg() == 1) {
                    return next.getId();
                }
            }
        }
        int bea = this.fvo.bea();
        PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(aZk, bea);
        if (postData == null || postData.vj() == null) {
            return "";
        }
        if (this.fvl.rk(postData.vj().getUserId())) {
            return postData.getId();
        }
        for (int i = bea - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.d(aZk, i);
            if (postData2 == null || postData2.vj() == null || postData2.vj().getUserId() == null) {
                break;
            } else if (this.fvl.rk(postData2.vj().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bea + 1; i2 < y; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.d(aZk, i2);
            if (postData3 == null || postData3.vj() == null || postData3.vj().getUserId() == null) {
                return "";
            }
            if (this.fvl.rk(postData3.vj().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (az.zI().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(rg(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fvl.getPbData().aZg().getId(), this.fvl.getPbData().aZg().getName(), this.fvl.getPbData().aZi().getTid());
            }
            this.fvc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.dB(getResources().getString(f.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.dB(getResources().getString(f.j.make_sure_hide));
        }
        aVar.a(getResources().getString(f.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvl.bcA() != null) {
                    PbActivity.this.fvl.bcA().cG(j);
                }
            }
        });
        aVar.b(getResources().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.aw(false);
        aVar.b(getPageContext());
        aVar.xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ri(String str) {
        String str2;
        if (this.fvl.getPbData() == null || this.fvl.getPbData().aZk() == null || this.fvl.getPbData().aZk().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fvl.getPbData().aZk().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fvl.getPbData().aZk().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fvl.getPbData().aZk().get(i);
        if (postData.bwi() == null || postData.bwi().Nw() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bwi().Nw().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.NC() != null) {
                    str2 = next.NC().NR();
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
        if (this.fuT) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fuT = false;
        } else if (bbc()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fuT) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fuT = false;
        } else if (bbc()) {
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
        if (pageStayDurationItem != null && this.fvl != null) {
            if (this.fvl.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fvl.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fvl.bcd(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bbc() {
        return (!this.fuR && this.fwC == -1 && this.fwD == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fwF = mVar;
            this.fuR = true;
            this.fvo.bdK();
            this.fvo.rr(this.fwE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbd() {
        if (this.fwF != null) {
            if (this.fwC == -1) {
                showToast(f.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bb.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fwF.getCartoonId(), this.fwC, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbe() {
        if (this.fwF != null) {
            if (this.fwD == -1) {
                showToast(f.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bb.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fwF.getCartoonId(), this.fwD, 0)));
                finish();
            }
        }
    }

    public int bbf() {
        return this.fwC;
    }

    public int bbg() {
        return this.fwD;
    }

    private void aFi() {
        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null && this.fvl.getPbData().aZi().vV()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bbh() {
        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null && this.fvl.getPbData().aZi().vV()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bbi() {
        if (this.fuU) {
            this.fvh = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null && this.fvl.getPbData().aZi().uQ() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fvl.getPbData().aZi().uQ().getThreadId(), this.fvl.getPbData().aZi().uQ().getTaskId(), this.fvl.getPbData().aZi().uQ().getForumId(), this.fvl.getPbData().aZi().uQ().getForumName(), this.fvl.getPbData().aZi().ve(), this.fvl.getPbData().aZi().vf())));
            this.fuT = true;
            finish();
        }
    }

    public String bbj() {
        return this.fvf;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bbk() {
        return this.fvk;
    }

    public void jE(boolean z) {
        this.fvg = z;
    }

    public boolean bbl() {
        if (this.fvl != null) {
            return this.fvl.bcf();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dB(getResources().getString(f.j.mute_is_super_member_function));
        aVar.a(f.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fvG).showToast(f.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fvG.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvG).xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fvG != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvG.getPageActivity());
            aVar.dB(str);
            aVar.b(f.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fvG).xe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fvo.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvG.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.dB(this.fvG.getResources().getString(f.j.block_mute_message_alert, str3));
        } else {
            aVar.dB(str);
        }
        aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.98
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fvo.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.99
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvG).xe();
    }

    public void bbn() {
        if (this.fvl != null && this.fvl.getPbData() != null && this.fvl.getPbData().aZi() != null && this.fvl.getPbData().aZi().wk() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cf(f.j.channel_open_push_message);
            aVar.a(f.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fvl.getPbData().aZi().wk().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(f.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(f.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.xe();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ay.rt(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(f.C0146f.icon_pb_wenxue)) != null) {
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
        if (this.fvo != null) {
            this.fvo.onConfigurationChanged(configuration);
        }
        if (this.fvu != null) {
            this.fvu.dismiss();
        }
    }

    public boolean bbo() {
        if (this.fvl != null) {
            return this.fvl.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, at atVar) {
        boolean z;
        List<PostData> list = this.fvl.getPbData().aZt().ftu;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bwd().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bwd().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bwd().remove(i2);
                    list.get(i).bwf();
                    z = true;
                    break;
                }
            }
            list.get(i).tO(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            atVar.n(this.fvl.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.aZU().getId();
        List<PostData> list = this.fvl.getPbData().aZt().ftu;
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
                ArrayList<PostData> aZY = kVar.aZY();
                postData.tI(kVar.getTotalCount());
                if (postData.bwd() != null) {
                    postData.bwd().clear();
                    postData.bwd().addAll(aZY);
                }
            }
        }
        if (!this.fvl.getIsFromMark()) {
            this.fvo.n(this.fvl.getPbData());
        }
    }

    public boolean bbp() {
        if (this.fvl == null) {
            return false;
        }
        return this.fvl.bbp();
    }

    public void bbq() {
        if (this.fvo != null) {
            this.fvo.bdz();
            auB();
        }
    }

    public PostData aZp() {
        return this.fvo.b(this.fvl.fAT, this.fvl.bce());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ak(com.baidu.tbadk.core.data.bb bbVar) {
        if (bbVar != null) {
            if (bbVar.isLinkThread()) {
                return 3;
            }
            if (bbVar.wm()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fvQ != null && !this.fvQ.isEmpty()) {
            int size = this.fvQ.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fvQ.get(i).onBackPressed()) {
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
            if (this.fvQ == null) {
                this.fvQ = new ArrayList();
            }
            if (!this.fvQ.contains(aVar)) {
                this.fvQ.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fvQ == null) {
                this.fvQ = new ArrayList();
            }
            if (!this.fvQ.contains(aVar)) {
                this.fvQ.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fvQ != null) {
            this.fvQ.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dna == null) {
            this.dna = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dna.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aD(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13061"));
                    }
                }
            });
        }
        this.dna.a(contriInfo, -1L);
    }
}
