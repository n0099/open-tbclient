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
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoNetworkView;
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
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.e.b;
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
import com.baidu.tieba.pb.pb.main.q;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.main.y;
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
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e {
    private com.baidu.adp.lib.e.b<TextView> bLA;
    private com.baidu.adp.lib.e.b<View> bLB;
    private com.baidu.adp.lib.e.b<LinearLayout> bLC;
    private com.baidu.adp.lib.e.b<RelativeLayout> bLD;
    private com.baidu.adp.lib.e.b<GifView> bLE;
    private com.baidu.adp.lib.e.b<ImageView> bLz;
    private com.baidu.tbadk.core.util.b.a bQG;
    private com.baidu.adp.lib.e.b<TbImageView> beQ;
    private com.baidu.tieba.e.b cof;
    private com.baidu.tbadk.core.dialog.i dEX;
    private VoiceManager dEn;
    private String fKJ;
    private com.baidu.tieba.pb.pb.main.a.b fKP;
    private com.baidu.adp.base.e fLA;
    private com.baidu.tbadk.core.view.e fLB;
    private BdUniqueId fLC;
    private Runnable fLD;
    private av fLE;
    private com.baidu.adp.widget.a.a fLF;
    private String fLG;
    private TbRichTextMemeInfo fLH;
    private List<a> fLK;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fLf;
    private View fLg;
    public at fLo;
    private x fLp;
    private boolean fLr;
    private com.baidu.tieba.tbadkCore.data.e fLu;
    private com.baidu.tbadk.editortools.pb.g fLv;
    private com.baidu.tbadk.editortools.pb.d fLw;
    private boolean fMm;
    private String fMy;
    private com.baidu.tbadk.core.data.m fMz;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private boolean fKO = false;
    private boolean fKQ = false;
    private boolean fKR = false;
    private boolean foD = false;
    private boolean fKS = true;
    private int fKT = 0;
    private com.baidu.tbadk.core.dialog.b fKU = null;
    private long dpA = -1;
    private long bAz = 0;
    private long fKV = 0;
    private long createTime = 0;
    private long bAr = 0;
    private boolean fKW = false;
    private com.baidu.tbadk.k.d fKX = null;
    private long fKY = 0;
    private boolean fKZ = false;
    private long fLa = 0;
    private String bub = null;
    private boolean fLb = false;
    private boolean isFullScreen = false;
    private String fLc = "";
    private boolean fLd = true;
    private boolean fLe = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fLh = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void Y(boolean z) {
            PbActivity.this.fLj.kK(!PbActivity.this.fLd);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fLi != null && PbActivity.this.fLi.vX()) {
                        PbActivity.this.bch();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", aq.a.aXA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", aq.a.aXA));
        }
    };
    private PbModel fLi = null;
    private com.baidu.tbadk.baseEditMark.a flT = null;
    private ForumManageModel cXP = null;
    private com.baidu.tbadk.coreExtra.model.a bft = null;
    private ShareSuccessReplyToServerModel dQX = null;
    private ar fLj = null;
    public final com.baidu.tieba.pb.pb.main.a.a fLk = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean fLl = false;
    private boolean fLm = false;
    private boolean fLn = false;
    private boolean fLq = false;
    private boolean fLs = false;
    private boolean fLt = false;
    private boolean fLx = false;
    public boolean fLy = false;
    private com.baidu.tbadk.editortools.pb.c bue = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void LA() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b bug = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lz() {
            if (PbActivity.this.fLo == null || PbActivity.this.fLo.bfT() == null || !PbActivity.this.fLo.bfT().bFI()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fLo.bfT().bFK());
            if (PbActivity.this.fLw != null && (PbActivity.this.fLw.LN() || PbActivity.this.fLw.LO())) {
                PbActivity.this.fLw.a(false, PbActivity.this.fLo.bfW());
            }
            PbActivity.this.fLo.kU(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fLz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Lz() {
            if (PbActivity.this.fLo == null || PbActivity.this.fLo.bfU() == null || !PbActivity.this.fLo.bfU().bFI()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fLo.bfU().bFK());
            if (PbActivity.this.fLj != null && PbActivity.this.fLj.beK() != null && PbActivity.this.fLj.beK().bdd() != null && PbActivity.this.fLj.beK().bdd().LO()) {
                PbActivity.this.fLj.beK().bdd().a(PbActivity.this.fLo.bfW());
            }
            PbActivity.this.fLo.kV(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dET = false;
    private int fLI = 0;
    private int fLJ = -1;
    private final a fLL = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fLj != null && PbActivity.this.fLj.beK() != null) {
                r beK = PbActivity.this.fLj.beK();
                if (beK.bcZ()) {
                    beK.bcY();
                    return true;
                }
            }
            if (PbActivity.this.fLj != null && PbActivity.this.fLj.bfC()) {
                PbActivity.this.fLj.bfD();
                return true;
            }
            return false;
        }
    };
    private q.b fLM = new q.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.q.b
        public void c(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private AddExperiencedModel.a dEZ = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bcl();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final y.a fLN = new y.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void L(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fLj.showToast(str);
            }
        }
    };
    private final CustomMessageListener fLO = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fLi != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fLw != null) {
                    PbActivity.this.fLj.kP(PbActivity.this.fLw.LH());
                }
                PbActivity.this.fLj.beL();
                PbActivity.this.fLj.bfv();
            }
        }
    };
    CustomMessageListener dFq = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                PbActivity.this.fLi.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                if (PbActivity.this.fLj != null && PbActivity.this.fLi != null) {
                    PbActivity.this.fLj.d(PbActivity.this.fLi.getPbData(), PbActivity.this.fLi.bdn(), PbActivity.this.fLi.getRequestType());
                }
                if (PbActivity.this.fLj != null && PbActivity.this.fLj.bfb() != null) {
                    PbActivity.this.fLj.bfb().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fLP = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fLj != null) {
                    if (booleanValue) {
                        PbActivity.this.fLj.aKi();
                    } else {
                        PbActivity.this.fLj.aKh();
                    }
                }
            }
        }
    };
    private CustomMessageListener fLQ = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fLw != null) {
                    PbActivity.this.fLj.kP(PbActivity.this.fLw.LH());
                }
                PbActivity.this.fLj.kR(false);
            }
        }
    };
    private CustomMessageListener fLR = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.k) eVar.getData());
                        return;
                    case 1:
                        PbActivity.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            PbActivity.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbActivity.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener fLS = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fLj != null && PbActivity.this.fLj.bfb() != null) {
                PbActivity.this.fLj.bfb().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener exe = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fLT = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void h(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.sJ(2);
                ai.beu().reset();
                PbActivity.this.fLi.bdF();
                boolean z2 = false;
                ArrayList<PostData> baw = PbActivity.this.fLi.getPbData().baw();
                if (baw != null) {
                    Iterator<PostData> it = baw.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bxi().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fLj.n(PbActivity.this.fLi.getPbData());
                    }
                    PbActivity.this.showToast(d.j.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(d.j.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(d.j.operation_failed);
        }
    };
    private View.OnClickListener buL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.bub);
        }
    };
    private CustomMessageListener fLU = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fLi.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fLi.bdw() != null && PbActivity.this.fLi.bdw().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fLj.a(yVar.sendCount, PbActivity.this.fLi.getPbData(), PbActivity.this.fLi.bdn(), PbActivity.this.fLi.getRequestType());
                    }
                    if (pbData.baw() != null && pbData.baw().size() >= 1 && pbData.baw().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.baw().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fLi.bdm(), 0L);
                        if (c2 == yVar.postId && c3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bxh = pbData.baw().get(0).bxh();
                            if (bxh == null) {
                                bxh = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> yz = bxh.yz();
                            if (yz == null) {
                                yz = new ArrayList<>();
                            }
                            yz.add(0, aVar);
                            bxh.eL(yVar.sendCount + bxh.yy());
                            bxh.h(yz);
                            pbData.baw().get(0).a(bxh);
                            PbActivity.this.fLj.bfb().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a fLV = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.ark() != null && !aVar.ark().isEmpty()) {
                    PbActivity.this.fLj.a(aVar, PbActivity.this.fLX);
                }
                PbActivity.this.fLj.a(aVar, PbActivity.this.fLi.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bfZ()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fLW = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void L(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.E(list) && PbActivity.this.fLj != null) {
                PbActivity.this.fLj.cW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fLX = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ay.ba(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.nm().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
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
    private boolean fLY = false;
    private PraiseModel fLZ = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void ir(String str) {
            PbActivity.this.fLY = false;
            if (PbActivity.this.fLZ != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fLi.getPbData();
                if (pbData.bau().zc().getIsLike() == 1) {
                    PbActivity.this.nB(0);
                } else {
                    PbActivity.this.nB(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bau()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void I(int i, String str) {
            PbActivity.this.fLY = false;
            if (PbActivity.this.fLZ != null && str != null) {
                if (AntiHelper.vR(i)) {
                    AntiHelper.ar(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fMa = 0;
    private boolean fMb = true;
    private b.a fMc = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void kg(boolean z) {
            PbActivity.this.kf(z);
            if (PbActivity.this.fLj.bfI() != null && z) {
                PbActivity.this.fLj.kK(false);
            }
            PbActivity.this.fLj.kM(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().biK != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().biK, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", aq.a.aXA));
                        }
                    } else if (updateAttentionMessage.getData().apH) {
                        if (PbActivity.this.baB().zn() != null && PbActivity.this.baB().zn().getGodUserData() != null) {
                            PbActivity.this.baB().zn().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().bau() != null && PbActivity.this.fLi.getPbData().bau().zn() != null) {
                            PbActivity.this.fLi.getPbData().bau().zn().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cAt = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fLj.agg();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.sK(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.h.a.aBN();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bLJ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (PbActivity.this.fLj.beM()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fLi != null && (PbActivity.this.fLi.getPbData() != null || PbActivity.this.fLi.getPbData().baQ() != null)) {
                    if (PbActivity.this.fLi.getPbData().baQ().baX()) {
                        if (PbActivity.this.fLi.getPbData().baQ().fIc == 1 || PbActivity.this.fLi.getPbData().baQ().fIc == 3 || PbActivity.this.fLi.getPbData().baQ().fIc == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fLi.getPbData().baQ().baX() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fLi.getPbData().baQ().baX() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fLa > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).lq(false);
                        PbActivity.this.fLa = System.currentTimeMillis();
                    }
                }
            }
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean e(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == d.g.richText) {
                    if (PbActivity.this.cp(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.fLj != null && PbActivity.this.fLj.bbS() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ab("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.fLk != null && PbActivity.this.fLk.fYe != null) {
                            PbActivity.this.fLk.fYe.onClick(view);
                        }
                    }
                } else {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        PbActivity.this.d(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (PbActivity.this.fLw != null) {
                PbActivity.this.fLj.kP(PbActivity.this.fLw.LH());
            }
            PbActivity.this.fLj.beL();
            PbActivity.this.fLj.bfv();
            return true;
        }
    });
    private CustomMessageListener fMd = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLC) {
                PbActivity.this.fLj.agg();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fLi.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.baI().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fLB.q(PbActivity.this.fLA.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fLA.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gC(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bcx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fLA.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.fLB.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fMe = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLC) {
                PbActivity.this.fLj.agg();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fLB.q(PbActivity.this.fLA.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fLA.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.fLB.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fMf = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLC) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fLj.agg();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hnT;
                if (aVar.error == 0 && dataRes != null) {
                    int h = com.baidu.adp.lib.g.b.h(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = h == 1;
                    if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
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
                    PbActivity.this.fLj.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fMg = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fLj.beM() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.bbA() != null && PbActivity.this.bbA().getPbData() != null && PbActivity.this.bbA().getPbData().baQ() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean baX = PbActivity.this.bbA().getPbData().baQ().baX();
                if (intValue < 10) {
                    if (baX) {
                        if (PbActivity.this.fLi.getPbData().baQ().fIc == 1 || PbActivity.this.fLi.getPbData().baQ().fIc == 3 || PbActivity.this.fLi.getPbData().baQ().fIc == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fLi.getPbData().baQ().baX() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", baX ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fLa > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).lq(false);
                        PbActivity.this.fLa = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, baX, 3);
                TiebaStatic.log(PbActivity.this.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).s("obj_locate", 4).s("obj_id", baX ? 0 : 1));
            }
        }
    };
    private CustomMessageListener dFy = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dET = true;
                }
            }
        }
    };
    public a.b fyx = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.avj();
            com.baidu.tbadk.core.data.al aEp = PbActivity.this.fLi.aEp();
            int pageNum = PbActivity.this.fLj.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (aEp == null || pageNum <= aEp.yr()) {
                PbActivity.this.fLj.bfv();
                PbActivity.this.sJ(2);
                PbActivity.this.avi();
                PbActivity.this.fLj.bff();
                if (com.baidu.adp.lib.util.j.oJ()) {
                    PbActivity.this.fLi.sR(PbActivity.this.fLj.getPageNum());
                    if (PbActivity.this.fKP != null) {
                        PbActivity.this.fKP.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(d.j.pb_page_error);
            }
        }
    };
    public final View.OnClickListener dFV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Multi-variable search result rejected for r2v184, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v188, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v215, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v318, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v47, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:692:0x1c66  */
        /* JADX WARN: Removed duplicated region for block: B:719:0x1e30  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.j baQ;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            String str;
            int i;
            bi biVar;
            SparseArray sparseArray;
            PostData postData;
            boolean j;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fLj.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fLi.kq(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fLj.bfg();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().ben()) {
                        if (view == PbActivity.this.fLj.fTU.bCs) {
                            if (PbActivity.this.fLj.kO(PbActivity.this.fLi.bdt())) {
                                PbActivity.this.avi();
                                return;
                            }
                            PbActivity.this.fKS = false;
                            PbActivity.this.fKQ = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fLj.bfd() && (PbActivity.this.fLj.fTU.bgk() == null || (view != PbActivity.this.fLj.fTU.bgk().bem() && view != PbActivity.this.fLj.fTU.bgk().bek()))) {
                            if (view == PbActivity.this.fLj.bfy()) {
                                if (PbActivity.this.fLi != null) {
                                    com.baidu.tbadk.browser.b.R(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fLi.getPbData().bau().zm().getLink());
                                }
                            } else if (view != PbActivity.this.fLj.fTU.fYO && view.getId() != d.g.view_forum_name_first_floor && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.fLj.fTU.fYP) {
                                    if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null) {
                                        ArrayList<PostData> baw = PbActivity.this.fLi.getPbData().baw();
                                        if ((baw == null || baw.size() <= 0) && PbActivity.this.fLi.bdn()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ab("tid", PbActivity.this.fLi.bdm()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getForumId()));
                                        if (!PbActivity.this.fLj.bfN()) {
                                            PbActivity.this.fLj.beL();
                                        }
                                        PbActivity.this.bbZ();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().bdY()) {
                                        if ((PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().bej()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.fLj.fTU.bgk() == null || (view != PbActivity.this.fLj.fTU.bgk().getCancelView() && view != PbActivity.this.fLj.fTU.bgk().bei())) {
                                                if (view != PbActivity.this.fLj.fTU.fYQ && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().beg()) {
                                                        if ((PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().bep()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().beh()) {
                                                                if (PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().beq()) {
                                                                    if (PbActivity.this.fLp == null || view != PbActivity.this.fLp.bea()) {
                                                                        if (PbActivity.this.fLp == null || view != PbActivity.this.fLp.bdY()) {
                                                                            if (PbActivity.this.fLp == null || view != PbActivity.this.fLp.bed()) {
                                                                                if (PbActivity.this.fLp == null || view != PbActivity.this.fLp.beb()) {
                                                                                    if (PbActivity.this.fLp == null || view != PbActivity.this.fLp.bec()) {
                                                                                        if (PbActivity.this.fLj.bfI() == view) {
                                                                                            if (PbActivity.this.fLj.bfI().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fLi.getPbData();
                                                                                                if (pbData != null && pbData.bau() != null && pbData.bau().yV() != null) {
                                                                                                    String xP = pbData.bau().yV().xP();
                                                                                                    if (StringUtils.isNull(xP)) {
                                                                                                        xP = pbData.bau().yV().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ab("obj_id", xP));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cd("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.bct();
                                                                                        } else if (PbActivity.this.fLj.bfa() != view) {
                                                                                            if (PbActivity.this.fLp == null || view != PbActivity.this.fLp.bdZ()) {
                                                                                                if (PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().beo()) {
                                                                                                    if (PbActivity.this.fLj.fTU.bgk() != null && view == PbActivity.this.fLj.fTU.bgk().bel()) {
                                                                                                        if (com.baidu.adp.lib.util.j.oJ()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.fLj.c(PbActivity.this.fLi.getPbData(), PbActivity.this.fLi.bdn(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.fLj.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.fLj.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.fLj.fTU.wH();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.fLj.bbL()) {
                                                                                                            if (view == PbActivity.this.fLj.fTU.bgl()) {
                                                                                                                PbActivity.this.fLj.bfn();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view.getTag()) != null && !StringUtils.isNull(biVar.AK())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        com.baidu.tbadk.core.util.aw.Du().c(PbActivity.this.getPageContext(), new String[]{biVar.AK()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData cq = PbActivity.this.cq(view);
                                                                                                                    if (cq != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 5).s("obj_id", cq.bxl() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.bbA() != null && PbActivity.this.bbA().getPbData() != null && PbActivity.this.bbA().getPbData().baQ() != null && PbActivity.this.bbA().getPbData().baQ() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bbV().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 4).s("obj_id", PbActivity.this.bbA().getPbData().baQ().baX() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && !StringUtils.isNull(PbActivity.this.fLi.getPbData().getThreadId()) && (baQ = PbActivity.this.fLi.getPbData().baQ()) != null && baQ.baV() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.aw.Du().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fLi.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.fLp == null) {
                                                                                                                                PbActivity.this.fLp = new x(PbActivity.this.getPageContext(), PbActivity.this.dFV);
                                                                                                                                PbActivity.this.fLj.cA(PbActivity.this.fLp.getView());
                                                                                                                                PbActivity.this.fLp.ku(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.fLp.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ab("tid", PbActivity.this.fLi.fPW));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.fLp.bdY().setTag(sparseArray2);
                                                                                                                            PbActivity.this.fLp.bed().setTag(view.getTag());
                                                                                                                            PbActivity.this.fLp.kw(z6);
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
                                                                                                                                sparseArray4.put(d.g.tag_forbid_user_post_id, str2);
                                                                                                                                if (booleanValue2) {
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_visible, true);
                                                                                                                                    sparseArray4.put(d.g.tag_is_mem, sparseArray3.get(d.g.tag_is_mem));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray3.get(d.g.tag_user_mute_mute_userid));
                                                                                                                                    sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray3.get(d.g.tag_user_mute_mute_username));
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
                                                                                                                                    PbActivity.this.fLp.beb().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.fLp.beb().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.fLp.bdZ().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fLp.beb().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fLp.bdZ().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.fLp.bdZ().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.fLp.bdZ().setVisibility(8);
                                                                                                                                PbActivity.this.fLp.beb().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.fLp.bdZ().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fLp.beb().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fLp.bdZ().setText(d.j.delete);
                                                                                                                                PbActivity.this.fLp.beb().setVisibility(0);
                                                                                                                                if (PbActivity.this.fLi.getPbData().baG() != 1002 || z2) {
                                                                                                                                    PbActivity.this.fLp.beb().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fLp.beb().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.fLp.bdZ().setVisibility(8);
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
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_post_id, sparseArray6.get(d.g.tag_user_mute_post_id));
                                                                                                                                sparseArray7.put(d.g.tag_user_mute_thread_id, sparseArray6.get(d.g.tag_user_mute_thread_id));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_is_self, sparseArray6.get(d.g.tag_del_post_is_self));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_type, sparseArray6.get(d.g.tag_del_post_type));
                                                                                                                                sparseArray7.put(d.g.tag_del_post_id, sparseArray6.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray7.put(d.g.tag_manage_user_identity, sparseArray6.get(d.g.tag_manage_user_identity));
                                                                                                                                PbActivity.this.fLp.bea().setTag(sparseArray7);
                                                                                                                                PbActivity.this.fLp.bea().setVisibility(0);
                                                                                                                                PbActivity.this.fLp.bdZ().setVisibility(8);
                                                                                                                                PbActivity.this.fLp.bea().setText(d.j.mute_option);
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
                                                                                                                                boolean kb = PbActivity.this.kb(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fMq = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (aq.k(PbActivity.this.fMq) ? false : kb) {
                                                                                                                                    PbActivity.this.fLp.bea().setVisibility(0);
                                                                                                                                    PbActivity.this.fLp.bea().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fLp.bea().setVisibility(8);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                                                                                            long j2 = 0;
                                                                                                                            if (!(sparseArray8.get(d.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                z5 = false;
                                                                                                                            } else {
                                                                                                                                z5 = ((Boolean) sparseArray8.get(d.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                            }
                                                                                                                            if (sparseArray8.get(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                j2 = ((Long) sparseArray8.get(d.g.tag_chudian_template_id)).longValue();
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
                                                                                                                                PbActivity.this.fLp.bec().setVisibility(0);
                                                                                                                                PbActivity.this.fLp.bec().setTag(d.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                                PbActivity.this.fLp.bec().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.fLp.bec().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.fLp.bec().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fLi.getPbData().vX()) {
                                                                                                                            String vW = PbActivity.this.fLi.getPbData().vW();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(vW) && vW.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.fLp.bdY().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fLp.bdY().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fLp.kv(true);
                                                                                                                                PbActivity.this.fLp.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.fLp.kv(true);
                                                                                                                        PbActivity.this.fLp.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().bau() != null && PbActivity.this.fLi.getPbData().bau().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.b.R(PbActivity.this.getActivity(), PbActivity.this.fLi.getPbData().bau().getActUrl());
                                                                                                                        if (PbActivity.this.fLi.getPbData().bau().zR() != 1) {
                                                                                                                            if (PbActivity.this.fLi.getPbData().bau().zR() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getPbData().getForumId()).ab("tid", PbActivity.this.fLi.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fLi.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.fLj.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (ay.ba(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.b.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.fLj.beL();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.b.R(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.bbW() == 1 && PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getPbData().getForumId()).ab("tid", PbActivity.this.fLi.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.b.R(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.bbW() == 1 && PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getPbData().getForumId()).ab("tid", PbActivity.this.fLi.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.bco();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.bcp();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().baM() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fLi.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ab(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.aw.Du().c(PbActivity.this.getPageContext(), new String[]{pbData2.baM().baU()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().baM() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fLi.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ab(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.aw.Du().c(PbActivity.this.getPageContext(), new String[]{pbData3.baM().baU()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.fLj.fTU.bgk() != null && view == PbActivity.this.fLj.fTU.bgk().ber()) {
                                                                                                                    if (PbActivity.this.fLi == null || PbActivity.this.fLi.getPbData() == null || PbActivity.this.fLi.getPbData().bau() == null) {
                                                                                                                        PbActivity.this.fLj.fTU.wH();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.pa()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fLi.getPbData().bau().yX() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fLi.bdm(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).Bd();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").s("obj_locate", PbActivity.this.aa(PbActivity.this.fLi.getPbData().bau())).ab("tid", PbActivity.this.fLi.getPbData().bau().getTid()).s("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fLI >= 0) {
                                                                                                                        if (PbActivity.this.fLi != null) {
                                                                                                                            PbActivity.this.fLi.bdT();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fLj.bfb() != null) {
                                                                                                                            PbActivity.this.fLj.bfb().a(PbActivity.this.fLi.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.fLj.getListView().setSelection(PbActivity.this.fLi.bdW());
                                                                                                                        PbActivity.this.fLI = 0;
                                                                                                                        if (PbActivity.this.fLi != null) {
                                                                                                                            PbActivity.this.fLi.co(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.fLj.bfQ();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fLi.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fLi.bdm(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fLi.getPbData().bau().zI())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fLi.getPbData() != null) {
                                                                                                            PbActivity.this.fLj.bfv();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bxn() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12630"));
                                                                                                                }
                                                                                                                String bdm = PbActivity.this.fLi.bdm();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fLi.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fLi.getPbData().baG();
                                                                                                                }
                                                                                                                PbActivity.this.avi();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c qp = PbActivity.this.qp(id2);
                                                                                                                    if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && qp != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdm, id2, "pb", true, null, true, null, i3, postData3.bha(), PbActivity.this.fLi.getPbData().yn(), false, postData3.zn().getIconInfo()).addBigImageData(qp.fNa, qp.fNb, qp.fNc, qp.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fLi.bdS());
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
                                                                                                                    c qp2 = PbActivity.this.qp(id2);
                                                                                                                    if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && qp2 != null && PbActivity.this.bbR().beJ() != null) {
                                                                                                                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                                                        kVar.b(PbActivity.this.fLi.getPbData().bas());
                                                                                                                        kVar.T(PbActivity.this.fLi.getPbData().bau());
                                                                                                                        kVar.d(postData4);
                                                                                                                        PbActivity.this.bbR().beJ().d(kVar);
                                                                                                                        PbActivity.this.bbR().beJ().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c qp3 = PbActivity.this.qp(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && qp3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdm, id2, "pb", true, null, false, null, i3, postData3.bha(), PbActivity.this.fLi.getPbData().yn(), false, postData3.zn().getIconInfo()).addBigImageData(qp3.fNa, qp3.fNb, qp3.fNc, qp3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fLi.bdS());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 3).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.oJ()) {
                                                                                                    PbActivity.this.fLj.bfv();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.fLj.c(PbActivity.this.fLi.getPbData(), PbActivity.this.fLi.bdn(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fLi.getPbData().bas().getId(), PbActivity.this.fLi.getPbData().bas().getName(), PbActivity.this.fLi.getPbData().bau().getId(), String.valueOf(PbActivity.this.fLi.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    PbActivity.this.showToast(d.j.network_not_available);
                                                                                                    return;
                                                                                                }
                                                                                            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                                                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                                                return;
                                                                                            } else {
                                                                                                SparseArray<Object> sparseArray11 = (SparseArray) view.getTag();
                                                                                                if (sparseArray11 != null) {
                                                                                                    if (!com.baidu.tieba.c.a.akM() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fLi.bdm(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
                                                                                                        boolean booleanValue4 = ((Boolean) sparseArray11.get(d.g.tag_should_manage_visible)).booleanValue();
                                                                                                        boolean booleanValue5 = ((Boolean) sparseArray11.get(d.g.tag_should_delete_visible)).booleanValue();
                                                                                                        boolean booleanValue6 = ((Boolean) sparseArray11.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                                        if (booleanValue4) {
                                                                                                            if (booleanValue6) {
                                                                                                                sparseArray11.put(d.g.tag_from, 1);
                                                                                                                sparseArray11.put(d.g.tag_check_mute_from, 2);
                                                                                                                PbActivity.this.c(sparseArray11);
                                                                                                            } else {
                                                                                                                sparseArray11.put(d.g.tag_check_mute_from, 2);
                                                                                                                PbActivity.this.fLj.cy(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.fLj.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.bbN();
                                                                                        }
                                                                                    } else {
                                                                                        long j3 = -1;
                                                                                        String str8 = "";
                                                                                        int i4 = 0;
                                                                                        if (view.getTag(d.g.tag_chudian_template_id) instanceof Long) {
                                                                                            j3 = ((Long) view.getTag(d.g.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (view.getTag(d.g.tag_chudian_monitor_id) instanceof String) {
                                                                                            str8 = (String) view.getTag(d.g.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (view.getTag(d.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                            i4 = ((Integer) view.getTag(d.g.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fLi.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.bas() != null) {
                                                                                            str9 = pbData4.bas().getId();
                                                                                            str10 = pbData4.bas().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.a.a(j3, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j3, str8, str9, str10, str11, i4);
                                                                                    }
                                                                                } else {
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null) {
                                                                                        if ((sparseArray12.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_id) instanceof String) && (sparseArray12.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                            boolean booleanValue7 = ((Boolean) sparseArray12.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                            int intValue = ((Integer) sparseArray12.get(d.g.tag_manage_user_identity)).intValue();
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.akM() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fLi.bdm(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.fLj.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.fLp.bef()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ab("tid", PbActivity.this.fLi.fPW));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fLi.getPbData() != null) {
                                                                                    PbActivity.this.fLj.bfv();
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
                                                                                        String bdm2 = PbActivity.this.fLi.bdm();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fLi.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fLi.getPbData().baG();
                                                                                        }
                                                                                        PbActivity.this.avi();
                                                                                        c qp4 = PbActivity.this.qp(id3);
                                                                                        if (qp4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdm2, id3, "pb", true, null, true, null, i5, postData.bha(), PbActivity.this.fLi.getPbData().yn(), false, postData.zn().getIconInfo()).addBigImageData(qp4.fNa, qp4.fNb, qp4.fNc, qp4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fLi.bdS());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.cr(view);
                                                                                if (PbActivity.this.fLi.getPbData().bau() != null && PbActivity.this.fLi.getPbData().bau().zn() != null && PbActivity.this.fLi.getPbData().bau().zn().getUserId() != null && PbActivity.this.flT != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ab("tid", PbActivity.this.fLi.fPW).s("obj_locate", 2).ab("obj_id", PbActivity.this.fLi.getPbData().bau().zn().getUserId()).s("obj_type", PbActivity.this.flT.vX() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fLi.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 4));
                                                                        if (!com.baidu.adp.lib.util.j.oJ()) {
                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                            return;
                                                                        }
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            PbActivity.this.qm((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            SparseArray<Object> sparseArray13 = (SparseArray) tag;
                                                                            if ((sparseArray13.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray13.get(d.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray13.put(d.g.tag_from, 0);
                                                                                sparseArray13.put(d.g.tag_check_mute_from, 2);
                                                                                PbActivity.this.c(sparseArray13);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").s("obj_type", 0).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10647").s("obj_type", 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fLj.fTU.bgj();
                                                                }
                                                            } else if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().bau() != null) {
                                                                PbActivity.this.fLj.fTU.wH();
                                                                PbActivity.this.qm(PbActivity.this.fLi.getPbData().bau().zE());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fLj.bfv();
                                                            if (com.baidu.adp.lib.util.j.oJ()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fLi.bdA()));
                                                                    return;
                                                                }
                                                                PbActivity.this.sJ(2);
                                                                PbActivity.this.avi();
                                                                PbActivity.this.fLj.bff();
                                                                boolean bdz = PbActivity.this.fLi.bdz();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fLi.bdA()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.fLj.fTU != null && PbActivity.this.fLj.fTU.bgk() != null && view == PbActivity.this.fLj.fTU.bgk().bep()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bdz) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.fLj.kF(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fLj.bfv();
                                                        if (PbActivity.this.fLi.aEp() != null) {
                                                            PbActivity.this.fLj.a(PbActivity.this.fLi.aEp(), PbActivity.this.fyx);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.ap.nv() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fLi != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ab("tid", PbActivity.this.fLi.bdm()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getForumId()).s("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.pa()) {
                                                        if (PbActivity.this.fLi.getPbData() != null) {
                                                            ArrayList<PostData> baw2 = PbActivity.this.fLi.getPbData().baw();
                                                            if ((baw2 != null && baw2.size() > 0) || !PbActivity.this.fLi.bdn()) {
                                                                PbActivity.this.fLj.bfv();
                                                                PbActivity.this.avi();
                                                                PbActivity.this.sJ(2);
                                                                if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().baM() != null && !StringUtils.isNull(PbActivity.this.fLi.getPbData().baM().ya(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.ap.nv()) {
                                                                    PbActivity.this.sK(2);
                                                                } else {
                                                                    PbActivity.this.fLj.showLoadingDialog();
                                                                    PbActivity.this.fLi.bdN().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(d.j.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.fLj.fTU.wH();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.oJ()) {
                                            PbActivity.this.fLj.bfv();
                                            if (PbActivity.this.fLj.fTU.bgk() != null && view == PbActivity.this.fLj.fTU.bgk().bej() && !PbActivity.this.fLj.bfN()) {
                                                PbActivity.this.fLj.beL();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.avi();
                                                PbActivity.this.fLj.bff();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    j = PbActivity.this.fLi.j(true, PbActivity.this.bcm());
                                                } else {
                                                    j = view.getId() == d.g.reply_title ? PbActivity.this.fLi.j(false, PbActivity.this.bcm()) : PbActivity.this.fLi.qq(PbActivity.this.bcm());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.fLj.kk(true);
                                                    PbActivity.this.fLj.aKi();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fLj.kF(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.sJ(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.oJ()) {
                                        PbActivity.this.fLj.bfv();
                                        if (PbActivity.this.sI(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fLi.sX(PbActivity.this.fLj.bfk()) != null) {
                                            PbActivity.this.bcg();
                                            if (PbActivity.this.fLi.getPbData().bau() != null && PbActivity.this.fLi.getPbData().bau().zn() != null && PbActivity.this.fLi.getPbData().bau().zn().getUserId() != null && PbActivity.this.flT != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ab("tid", PbActivity.this.fLi.fPW).s("obj_locate", 1).ab("obj_id", PbActivity.this.fLi.getPbData().bau().zn().getUserId()).s("obj_type", PbActivity.this.flT.vX() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fLi.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.oJ()) {
                                    PbActivity.this.fLj.kk(true);
                                    PbActivity.this.fLj.beL();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fLj.aKi();
                                        PbActivity.this.avi();
                                        PbActivity.this.fLj.bff();
                                        PbActivity.this.fLi.qq(PbActivity.this.bcm());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.sJ(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(d.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (view.getId() == d.g.view_forum_name_first_floor) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12505").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, com.baidu.tieba.pb.d.u(PbActivity.this.getPageContext())));
                                }
                                if (PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().bau() != null && PbActivity.this.fLi.getPbData().bau().Aa() && PbActivity.this.fLi.getPbData().bau().zF() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.fLi.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fLi.bdl()) && PbActivity.this.fLi.getAppealInfo() != null) {
                                        name = PbActivity.this.fLi.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fLi.getPbData().bas().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bdl = PbActivity.this.fLi.bdl();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fLi.bdo() && bdl != null && bdl.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.oJ()) {
                            if (PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().baG() == 1 && !PbActivity.this.cXP.bxK()) {
                                PbActivity.this.fLj.bfv();
                                int i6 = 0;
                                if (PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().bek()) {
                                    if (PbActivity.this.fLj.fTU.bgk() == null || view != PbActivity.this.fLj.fTU.bgk().bem()) {
                                        if (view == PbActivity.this.fLj.bfd()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fLi.getPbData().bau().zj() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fLi.getPbData().bau().zi() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData bas = PbActivity.this.fLi.getPbData().bas();
                                String name2 = bas.getName();
                                String id4 = bas.getId();
                                String id5 = PbActivity.this.fLi.getPbData().bau().getId();
                                if (!com.baidu.tieba.c.a.akM() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.fLj.bfc();
                                    PbActivity.this.cXP.a(id4, name2, id5, i6, PbActivity.this.fLj.bfe());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.oJ()) {
                        PbActivity.this.fLj.bfv();
                        PbActivity.this.avi();
                        PbActivity.this.fLj.bff();
                        PbActivity.this.fLj.showLoadingDialog();
                        if (PbActivity.this.fLj.beS() != null) {
                            PbActivity.this.fLj.beS().setVisibility(8);
                        }
                        PbActivity.this.fLi.sR(1);
                        if (PbActivity.this.fKP != null) {
                            PbActivity.this.fKP.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bbU = PbActivity.this.bbU();
                        if (!TextUtils.isEmpty(bbU)) {
                            com.baidu.tbadk.core.util.aw.Du().c(PbActivity.this.getPageContext(), new String[]{bbU});
                        }
                    }
                } else if (PbActivity.this.fKZ) {
                    PbActivity.this.fKZ = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.bbR().beJ() != null && postData5.zn() != null && postData5.bwY() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bbR().beK() != null) {
                                    PbActivity.this.bbR().beK().bcX();
                                }
                                com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                                kVar2.b(PbActivity.this.fLi.getPbData().bas());
                                kVar2.T(PbActivity.this.fLi.getPbData().bau());
                                kVar2.d(postData5);
                                PbActivity.this.bbR().beJ().d(kVar2);
                                PbActivity.this.bbR().beJ().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.zn().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fLw != null) {
                                    PbActivity.this.fLj.kP(PbActivity.this.fLw.LH());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d bum = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.avi();
            PbActivity.this.fLj.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ag.OO() && PbActivity.this.bbA() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bbA().qt(postWriteCallBackData.getPostId());
                    PbActivity.this.fLI = PbActivity.this.fLj.beO();
                    if (PbActivity.this.fLi != null) {
                        PbActivity.this.fLi.co(PbActivity.this.fLI, PbActivity.this.fLj.beP());
                    }
                }
                PbActivity.this.fLj.bfv();
                PbActivity.this.fLo.bfS();
                if (PbActivity.this.fLw != null) {
                    PbActivity.this.fLj.kP(PbActivity.this.fLw.LH());
                }
                PbActivity.this.fLj.beI();
                PbActivity.this.fLj.kR(true);
                PbActivity.this.fLi.bdC();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fLi.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fLi.getPbData();
                            if (pbData != null && pbData.bau() != null && pbData.bau().zn() != null && (userId = pbData.bau().zn().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ag.OO() && PbActivity.this.fLi.bdv()) {
                                PbActivity.this.fLj.bff();
                            }
                        } else if (!com.baidu.tbadk.o.ag.OO() && PbActivity.this.fLi.bdv()) {
                            PbActivity.this.fLj.bff();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fLj.n(PbActivity.this.fLi.getPbData());
                    }
                    if (PbActivity.this.fLi.bdr()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ab("tid", PbActivity.this.fLi.bdm()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fLw.LN() || PbActivity.this.fLw.LO()) {
                    PbActivity.this.fLw.a(false, postWriteCallBackData);
                }
                PbActivity.this.fLo.e(postWriteCallBackData);
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fMh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.fLo != null) {
                if (z) {
                    if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                        PbActivity.this.a(postWriteCallBackData.getContriInfo());
                    }
                    PbActivity.this.fLo.bfR();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    if (PbActivity.this.fLj != null && PbActivity.this.fLj.beK() != null && PbActivity.this.fLj.beK().bdd() != null && PbActivity.this.fLj.beK().bdd().LO()) {
                        PbActivity.this.fLj.beK().bdd().a(postWriteCallBackData);
                    }
                    PbActivity.this.fLo.f(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a fMi = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.l hG;
            if (!z || dVar == null || dVar.baE() != null || com.baidu.tbadk.core.util.v.D(dVar.baw()) >= 1) {
                PbActivity.this.foD = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fLj.bfh();
                if (dVar == null || !dVar.baA()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fLj.getView());
                }
                PbActivity.this.fLj.aKh();
                if (PbActivity.this.isFullScreen || PbActivity.this.fLj.bfN()) {
                    PbActivity.this.fLj.bfE();
                } else if (!PbActivity.this.fLj.bfB()) {
                    PbActivity.this.fLj.kR(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fLq = true;
                }
                if (z && dVar != null) {
                    PbActivity.this.fLj.aik();
                    if (dVar.bau() != null && dVar.bau().Ag() != null) {
                        PbActivity.this.a(dVar.bau().Ag());
                    }
                    PbActivity.this.bbO();
                    if (PbActivity.this.fLw != null) {
                        PbActivity.this.fLj.kP(PbActivity.this.fLw.LH());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.baw() != null && dVar.baw().size() >= 1 && dVar.baw().get(0) != null) {
                        PbActivity.this.fLi.qs(dVar.baw().get(0).getId());
                    } else if (dVar.baE() != null) {
                        PbActivity.this.fLi.qs(dVar.baE().getId());
                    }
                    if (PbActivity.this.fLw != null) {
                        PbActivity.this.fLw.a(dVar.yn());
                        PbActivity.this.fLw.a(dVar.bas(), dVar.getUserData());
                        PbActivity.this.fLw.a(PbActivity.this.fLi.bdw(), PbActivity.this.fLi.bdm(), PbActivity.this.fLi.bdP());
                        if (dVar.bau() != null) {
                            PbActivity.this.fLw.cm(dVar.bau().Aw());
                        }
                    }
                    if (PbActivity.this.flT != null) {
                        PbActivity.this.flT.aL(dVar.vX());
                    }
                    if (dVar == null || dVar.baH() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fLj.kQ(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fLj.a(dVar, i2, i3, PbActivity.this.fLi.bdn(), i4, PbActivity.this.fLi.getIsFromMark());
                    PbActivity.this.fLj.d(dVar, PbActivity.this.fLi.bdn());
                    PbActivity.this.fLj.kN(PbActivity.this.fLi.getHostMode());
                    AntiData yn = dVar.yn();
                    if (yn != null) {
                        PbActivity.this.bub = yn.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.bub) && PbActivity.this.fLw != null && PbActivity.this.fLw.Lc() != null && (hG = PbActivity.this.fLw.Lc().hG(6)) != null && !TextUtils.isEmpty(PbActivity.this.bub)) {
                            ((View) hG).setOnClickListener(PbActivity.this.buL);
                        }
                    }
                    if (PbActivity.this.fLs) {
                        PbActivity.this.fLs = false;
                        final int bcb = PbActivity.this.bcb();
                        if (dVar.baR()) {
                            final int ao = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bcb, ao);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bbR().td(bcb);
                        }
                    }
                    if (PbActivity.this.fLt) {
                        PbActivity.this.fLt = false;
                        final int bcb2 = PbActivity.this.bcb();
                        final boolean z2 = bcb2 != -1;
                        if (!z2) {
                            bcb2 = PbActivity.this.bcc();
                        }
                        if (PbActivity.this.bbR() != null) {
                            if (dVar.baR()) {
                                final int ao2 = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bcb2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bcb2, ao2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bcb2 - 1, ao2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.bbR().td(bcb2);
                            }
                        }
                    } else {
                        PbActivity.this.fLj.bfl();
                    }
                    PbActivity.this.fLi.a(dVar.bas(), PbActivity.this.fLV);
                    PbActivity.this.fLi.a(PbActivity.this.fLW);
                } else if (str != null) {
                    if (!PbActivity.this.fLq && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fLi != null && PbActivity.this.fLi.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fLi.getAppealInfo().fHi)) {
                                    PbActivity.this.fLj.a(PbActivity.this.fLi.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fLj.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fLj.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.fLj.bfE();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fLi.bdm());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.i iVar = new com.baidu.tbadk.core.util.i();
                        iVar.setOpType("2");
                        iVar.start();
                    }
                    if (i != -1) {
                        PbActivity.this.fLj.qw(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.fLj.qw("");
                    }
                    PbActivity.this.fLj.Eh();
                }
                PbActivity.this.bAz = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bbA().bdn() || PbActivity.this.bbA().getPbData().yA().yx() != 0 || PbActivity.this.bbA().bdI()) {
                    PbActivity.this.fLx = true;
                    return;
                }
                return;
            }
            PbActivity.this.fLi.sR(1);
            if (PbActivity.this.fKP != null) {
                PbActivity.this.fKP.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fLj.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.p.Ow().Ox()) {
                com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, PbActivity.this.bAr, PbActivity.this.createTime, PbActivity.this.bAz, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.dpA : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.bAr = 0L;
                if (lVar != null) {
                    lVar.Or();
                }
            }
        }
    };
    private CustomMessageListener fMj = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bbX();
            }
        }
    };
    private final a.InterfaceC0093a fMk = new a.InterfaceC0093a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0093a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fLj.bfh();
            if (z) {
                if (PbActivity.this.flT != null) {
                    PbActivity.this.flT.aL(z2);
                }
                PbActivity.this.fLi.ks(z2);
                if (PbActivity.this.fLi.vX()) {
                    PbActivity.this.bch();
                } else {
                    PbActivity.this.fLj.n(PbActivity.this.fLi.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.flT != null && PbActivity.this.flT.wa() != null && PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().bau() != null && PbActivity.this.fLi.getPbData().bau().zn() != null) {
                        MarkData wa = PbActivity.this.flT.wa();
                        MetaData zn = PbActivity.this.fLi.getPbData().bau().zn();
                        if (wa != null && zn != null) {
                            if (!com.baidu.tbadk.core.util.am.equals(TbadkCoreApplication.getCurrentAccount(), zn.getUserId()) && !zn.hadConcerned()) {
                                PbActivity.this.b(zn);
                                return;
                            } else {
                                PbActivity.this.showToast(d.j.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.j.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.j.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(d.j.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.sG(PbActivity.this.mLastScrollState) && PbActivity.this.sG(i)) {
                if (PbActivity.this.fLj != null) {
                    PbActivity.this.fLj.bfv();
                    if (PbActivity.this.fLw != null && !PbActivity.this.fLj.beM()) {
                        PbActivity.this.fLj.kP(PbActivity.this.fLw.LH());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fLj.beL();
                    }
                }
                if (!PbActivity.this.fKW) {
                    PbActivity.this.fKW = true;
                    PbActivity.this.fLj.bfA();
                }
            }
            PbActivity.this.fLj.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fKP != null) {
                PbActivity.this.fKP.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fKX == null) {
                PbActivity.this.fKX = new com.baidu.tbadk.k.d();
                PbActivity.this.fKX.ij(1001);
            }
            if (i == 0) {
                PbActivity.this.fKX.Od();
            } else if (i == 1) {
                PbActivity.this.fKX.Od();
            } else {
                PbActivity.this.fKX.Od();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> baw;
            if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLj != null && PbActivity.this.fLj.bfb() != null) {
                PbActivity.this.fLj.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fKP != null) {
                    PbActivity.this.fKP.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fLi.bdE() && (baw = PbActivity.this.fLi.getPbData().baw()) != null && !baw.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fLj.bfb().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fLi.getPbData();
                    if (pbData != null) {
                        if (pbData.bax() != null && pbData.bax().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bay() != null && pbData.bay().hasData()) {
                            headerCount--;
                        }
                        int size = baw.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cXT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cXP.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fLi.bdC();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gaB != 1002 || bVar.ecO) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fLj.a(1, dVar.aoo, dVar.hdt, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cXP.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fLj.a(PbActivity.this.cXP.getLoadDataMode(), gVar.aoo, gVar.hdt, false);
                        PbActivity.this.fLj.an(gVar.hdw);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fLj.a(PbActivity.this.cXP.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fMl = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final j.b bVd = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            if (PbActivity.this.bcn()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fLi.kr(true)) {
                PbActivity.this.fLj.bfi();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fMn = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fMm && PbActivity.this.bcn()) {
                PbActivity.this.bcp();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fLi.kq(false)) {
                    PbActivity.this.fLj.bfg();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fLi.getPbData() != null) {
                    PbActivity.this.fLj.bfz();
                }
                PbActivity.this.fMm = true;
            }
        }
    };
    private int fMo = 0;
    private final TbRichTextView.h bLI = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fLj.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12490"));
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
                    PbActivity.this.fLg = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fNd) {
                    TbRichText az = PbActivity.this.az(str, i);
                    if (az != null && PbActivity.this.fMo >= 0 && PbActivity.this.fMo < az.Ri().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(az.Ri().get(PbActivity.this.fMo));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fNa.size()) {
                                break;
                            } else if (!cVar.fNa.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.E(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fNb.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fNc, cVar.lastId, PbActivity.this.fLi.bdA(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.f(cVar.fNa, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.E(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fNb.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fNc, cVar.fNa.get(0), PbActivity.this.fLi.bdA(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fMp = false;
    PostData fMq = null;
    private final b.InterfaceC0097b fMr = new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fMq != null) {
                if (i == 0) {
                    PbActivity.this.fMq.ck(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fMq = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fMq);
                }
            }
        }
    };
    private final b.InterfaceC0097b fMs = new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fLF != null && !TextUtils.isEmpty(PbActivity.this.fLG)) {
                if (i == 0) {
                    if (PbActivity.this.fLH == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fLG));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fLG;
                        aVar.pkgId = PbActivity.this.fLH.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fLH.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bQG == null) {
                        PbActivity.this.bQG = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bQG.DI();
                    PbActivity.this.bQG.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bQG.v(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fLE == null) {
                            PbActivity.this.fLE = new av(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fLE.j(PbActivity.this.fLG, PbActivity.this.fLF.sk());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fLF = null;
                PbActivity.this.fLG = null;
            }
        }
    };
    private final View.OnLongClickListener bmk = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.fLF = ((TbImageView) view).getBdImage();
                PbActivity.this.fLG = ((TbImageView) view).getUrl();
                if (PbActivity.this.fLF != null && !TextUtils.isEmpty(PbActivity.this.fLG)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fLH = null;
                    } else {
                        PbActivity.this.fLH = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fLj.a(PbActivity.this.fMs, PbActivity.this.fLF.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.fLF = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.fLG = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fLH = null;
                    } else {
                        PbActivity.this.fLH = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fLj.a(PbActivity.this.fMs, PbActivity.this.fLF.isGif());
                }
            } else if (view instanceof com.baidu.tbadk.widget.d) {
                if (((com.baidu.tbadk.widget.d) view).getBdImage() != null) {
                    PbActivity.this.fLF = ((com.baidu.tbadk.widget.d) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.d) view).getBdImage().getUrl())) {
                        PbActivity.this.fLG = ((com.baidu.tbadk.widget.d) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fLH = null;
                    } else {
                        PbActivity.this.fLH = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fLj.a(PbActivity.this.fMs, PbActivity.this.fLF.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fMq = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fMq != null && PbActivity.this.flT != null) {
                        PbActivity.this.fLj.a(PbActivity.this.fMr, PbActivity.this.flT.vX() && PbActivity.this.fMq.getId() != null && PbActivity.this.fMq.getId().equals(PbActivity.this.fLi.zx()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dCv = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (!PbActivity.this.fKR && z && !PbActivity.this.fLi.bdu()) {
                PbActivity.this.bcj();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener bDn = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).atx()) {
                        break;
                    }
                }
            }
            PbActivity.this.cof.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0143a cog = new a.InterfaceC0143a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        final int cKd;

        {
            this.cKd = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aY(int i, int i2) {
            if (af(i2) && PbActivity.this.fLj != null && PbActivity.this.fKP != null) {
                PbActivity.this.fLj.bfF();
                PbActivity.this.fKP.fW(false);
                PbActivity.this.fKP.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aZ(int i, int i2) {
            if (af(i2) && PbActivity.this.fLj != null && PbActivity.this.fKP != null) {
                PbActivity.this.fKP.fW(true);
                if (Math.abs(i2) > this.cKd) {
                    PbActivity.this.fKP.hideFloatingView();
                }
                if (PbActivity.this.bcn()) {
                    PbActivity.this.fLj.beX();
                    PbActivity.this.fLj.beY();
                }
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void ba(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final b.a fMt = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.e.b.a
        public void fr(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bbq();
            } else {
                com.baidu.tieba.pb.a.b.bbp();
            }
        }
    };
    private String fMu = null;
    private final m.a fMv = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fMu = str2;
                PbActivity.this.fLj.qx(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fMw = -1;
    private int fMx = -1;
    private CustomMessageListener fMA = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.aJK == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0095a) {
                    if (aVar.aJL != null && !aVar.aJL.hasError() && aVar.aJL.getError() == 0) {
                        if (PbActivity.this.fLj != null) {
                            PbActivity.this.fLj.y(((a.C0095a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bcy();
                        }
                    } else if (z) {
                        if (aVar.aJL != null && aVar.aJL.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aJL.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.aJL != null && !aVar.aJL.hasError() && aVar.aJL.getError() == 0) {
                        if (PbActivity.this.fLj != null && PbActivity.this.fLj != null) {
                            PbActivity.this.fLj.y(((a.C0095a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.aJL != null && aVar.aJL.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aJL.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.aJL == null || aVar.aJL.hasError() || aVar.aJL.getError() != 0) {
                        if (z) {
                            if (aVar.aJL != null && aVar.aJL.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.aJL.getErrorString());
                            } else {
                                PbActivity.this.showToast(d.j.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.j.channel_need_push), 1).show();
                    }
                }
            }
        }
    };
    private final CustomMessageListener dFt = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.aw.Du().c(PbActivity.this.getPageContext(), new String[]{str});
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
        void ak(Object obj);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public ArrayList<String> fNa;
        public ConcurrentHashMap<String, ImageUrlData> fNb;
        public boolean fNd;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fNc = false;
        public boolean fNe = false;
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

    public com.baidu.tbadk.editortools.pb.d bbM() {
        return this.fLw;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        if (kVar.bbd() != null) {
            String id = kVar.bbd().getId();
            ArrayList<PostData> baw = this.fLi.getPbData().baw();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= baw.size()) {
                    break;
                }
                PostData postData = baw.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> bbh = kVar.bbh();
                    postData.vL(kVar.getTotalCount());
                    if (postData.bwV() != null && bbh != null) {
                        Iterator<PostData> it = bbh.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.zn() != null && (metaData = postData.getUserMap().get(next.zn().getUserId())) != null) {
                                next.a(metaData);
                                next.mO(true);
                                next.b(getPageContext(), this.fLi.qr(metaData.getUserId()));
                            }
                        }
                        postData.bwV().clear();
                        postData.bwV().addAll(bbh);
                    }
                    if (postData.bwR() != null) {
                        postData.bwS();
                    }
                }
            }
            if (!this.fLi.getIsFromMark()) {
                this.fLj.n(this.fLi.getPbData());
            }
            c(kVar);
        }
    }

    public void bbN() {
        com.baidu.tieba.pb.data.d pbData;
        bd bau;
        if (!this.fLY) {
            if (!com.baidu.adp.lib.util.l.pa()) {
                showToast(d.j.no_network_guide);
            } else if (this.fMb) {
                this.fLY = true;
                if (this.fLi != null && (pbData = this.fLi.getPbData()) != null && (bau = pbData.bau()) != null) {
                    int isLike = bau.zc() == null ? 0 : bau.zc().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ab("tid", bau.getId()));
                    }
                    if (this.fLZ != null) {
                        this.fLZ.a(bau.zE(), bau.getId(), isLike, "pb");
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
                bVar.fe(d.j.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.j.delete);
                    strArr[1] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fLj.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fLC);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fLC);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fLC);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fLC);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).AY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(int i) {
        bd bau;
        String str;
        String H;
        if (this.fLi != null && this.fLi.getPbData() != null && (bau = this.fLi.getPbData().bau()) != null) {
            if (i == 1) {
                PraiseData zc = bau.zc();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zc == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bau.a(praiseData);
                    } else {
                        bau.zc().getUser().add(0, metaData);
                        bau.zc().setNum(bau.zc().getNum() + 1);
                        bau.zc().setIsLike(i);
                    }
                }
                if (bau.zc() != null) {
                    if (bau.zc().getNum() < 1) {
                        H = getResources().getString(d.j.zan);
                    } else {
                        H = com.baidu.tbadk.core.util.am.H(bau.zc().getNum());
                    }
                    this.fLj.Q(H, true);
                }
            } else if (bau.zc() != null) {
                bau.zc().setIsLike(i);
                bau.zc().setNum(bau.zc().getNum() - 1);
                ArrayList<MetaData> user = bau.zc().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bau.zc().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bau.zc().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = bau.zc().getNum() + "";
                }
                this.fLj.Q(str, false);
            }
            if (this.fLi.bdn()) {
                this.fLj.bfb().notifyDataSetChanged();
            } else {
                this.fLj.o(this.fLi.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fLi.D(bundle);
        if (this.dEn != null) {
            this.dEn.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fLw.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fLA = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dpA = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fLc = intent.getStringExtra("from");
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fLc)) {
                this.fKQ = true;
            }
            this.fMw = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fMx = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fMy = intent.getStringExtra("key_manga_title");
            this.fLs = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fLt = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bcn()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.fLJ = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dpA = System.currentTimeMillis();
        }
        this.fKV = System.currentTimeMillis();
        this.bAr = this.fKV - this.dpA;
        super.onCreate(bundle);
        this.fKT = 0;
        C(bundle);
        if (this.fLi != null && this.fLi.getPbData() != null) {
            this.fLi.getPbData().qk(this.source);
        }
        initUI();
        if (intent != null && this.fLj != null) {
            this.fLj.fTN = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fLD == null) {
                    this.fLD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fLj.qz("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fLD, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fLi != null && this.fLi.getPbData() != null) {
                this.fLi.qu(stringExtra);
            }
        }
        this.dEn = new VoiceManager();
        this.dEn.onCreate(getPageContext());
        initData(bundle);
        this.fLv = new com.baidu.tbadk.editortools.pb.g();
        bbO();
        this.fLw = (com.baidu.tbadk.editortools.pb.d) this.fLv.bd(getActivity());
        this.fLw.b(this);
        this.fLw.a(this.bum);
        this.fLw.a(this.bue);
        this.fLw.a(this, bundle);
        this.fLw.Lc().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.fLw.Lc().cf(true);
        ka(true);
        this.fLj.setEditorTools(this.fLw.Lc());
        this.fLw.a(this.fLi.bdw(), this.fLi.bdm(), this.fLi.bdP());
        registerListener(this.fLQ);
        if (!this.fLi.bdt()) {
            this.fLw.gw(this.fLi.bdm());
        }
        if (this.fLi.bdQ()) {
            this.fLw.gu(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fLw.gu(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.fKV;
        registerListener(this.fLP);
        registerListener(this.fLR);
        registerListener(this.fLS);
        registerListener(this.dFq);
        registerListener(this.fMg);
        registerListener(this.fLO);
        this.fLu = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.hay);
        this.fLu.bwA();
        registerListener(this.fLU);
        registerListener(this.mAttentionListener);
        if (this.fLi != null) {
            this.fLi.bdG();
        }
        registerListener(this.fMj);
        registerListener(this.fMA);
        registerListener(this.dFy);
        if (this.fLj != null && this.fLj.bfJ() != null && this.fLj.bfK() != null) {
            this.fKP = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.fLj.bfJ(), this.fLj.bfK(), this.fLj.beS());
            this.fKP.a(this.fMc);
        }
        if (this.fKO && this.fLj != null && this.fLj.bfK() != null) {
            this.fLj.bfK().setVisibility(8);
        }
        this.fLB = new com.baidu.tbadk.core.view.e();
        this.fLB.baX = 1000L;
        registerListener(this.fMf);
        registerListener(this.fMd);
        registerListener(this.fMe);
        this.fLC = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fLC;
        userMuteAddAndDelCustomMessage.setTag(this.fLC);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fLC;
        userMuteCheckCustomMessage.setTag(this.fLC);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fLi.bdN().a(this.cAt);
        if ("from_tieba_kuang".equals(this.fLc)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 2).ab("tid", this.fLi.bdm()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                    @Override // com.baidu.tbadk.core.e
                    public void aS(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
        this.fLo = new at();
        if (this.fLw.LB() != null) {
            this.fLo.g(this.fLw.LB().getInputView());
        }
        this.fLw.a(this.bug);
        this.dQX = new ShareSuccessReplyToServerModel();
        a(this.fLL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbO() {
        if (this.fLv != null && this.fLi != null) {
            this.fLv.setForumName(this.fLi.bdl());
            if (this.fLi.getPbData() != null && this.fLi.getPbData().bas() != null) {
                this.fLv.setForumId(this.fLi.getPbData().bas().getId());
            }
            this.fLv.setFrom("pb");
            this.fLv.a(this.fLi);
        }
    }

    public String bbP() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b bbQ() {
        return this.fKP;
    }

    private void ka(boolean z) {
        this.fLw.cj(z);
        this.fLw.ck(z);
        this.fLw.cl(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().baR() && !z && this.fLj != null && this.fLj.getView() != null) {
            this.fLj.getView().setSystemUiVisibility(4);
        }
        this.fLy = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dEn != null) {
            this.dEn.onStart(getPageContext());
        }
    }

    public ar bbR() {
        return this.fLj;
    }

    public PbModel bbA() {
        return this.fLi;
    }

    public void ql(String str) {
        if (this.fLi != null && !StringUtils.isNull(str) && this.fLj != null) {
            this.fLj.kT(true);
            this.fLi.ql(str);
            this.fLb = true;
            this.fLj.bfv();
            this.fLj.bfE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fKR = false;
        } else {
            this.fKR = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fKT = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fKT == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dEn != null) {
            this.dEn.onPause(getPageContext());
        }
        if (this.fLj != null) {
            this.fLj.onPause();
        }
        if (!this.fLi.bdt()) {
            this.fLw.gv(this.fLi.bdm());
        }
        if (this.fLi != null) {
            this.fLi.bdH();
        }
        MessageManager.getInstance().unRegisterListener(this.exe);
        aDK();
        MessageManager.getInstance().unRegisterListener(this.fMd);
        MessageManager.getInstance().unRegisterListener(this.fMe);
        MessageManager.getInstance().unRegisterListener(this.fMf);
        MessageManager.getInstance().unRegisterListener(this.dFt);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bbS() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fLi.getPbData(), this.fLi.bdn(), this.fLi.getRequestType());
        return (a2 == null || a2.zn() == null || a2.zn().getGodUserData() == null || a2.zn().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fKR = false;
        super.onResume();
        if (this.fLe) {
            this.fLe = false;
            bct();
        }
        if (bbS()) {
            this.fKY = System.currentTimeMillis();
        } else {
            this.fKY = -1L;
        }
        if (this.fLj != null && this.fLj.getView() != null) {
            if (!this.foD) {
                bck();
            } else {
                hideLoadingView(this.fLj.getView());
            }
            this.fLj.onResume();
        }
        if (this.fKT == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fLj != null) {
            noNetworkView = this.fLj.beH();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.oJ()) {
            noNetworkView.bt(false);
        }
        if (this.dEn != null) {
            this.dEn.onResume(getPageContext());
        }
        registerListener(this.exe);
        this.fLr = false;
        bcs();
        registerListener(this.fMd);
        registerListener(this.fMe);
        registerListener(this.fMf);
        registerListener(this.dFt);
        if (this.dET) {
            bcj();
            this.dET = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
                @Override // com.baidu.tbadk.core.e
                public void aS(boolean z) {
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
        this.fLj.kI(z);
        if (this.fLp != null) {
            this.fLp.ku(z);
        }
        if (z && this.fLr) {
            this.fLj.bfg();
            this.fLi.kq(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fKY > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ab("obj_duration", (System.currentTimeMillis() - this.fKY) + ""));
            this.fKY = 0L;
        }
        if (bbR().beK() != null) {
            bbR().beK().onStop();
        }
        if (this.fLj.fTU != null && !this.fLj.fTU.amf()) {
            this.fLj.fTU.aPc();
        }
        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().bas() != null && this.fLi.getPbData().bau() != null) {
            com.baidu.tbadk.distribute.a.KM().a(getPageContext().getPageActivity(), "pb", this.fLi.getPbData().bas().getId(), com.baidu.adp.lib.g.b.c(this.fLi.getPbData().bau().getId(), 0L));
        }
        if (this.dEn != null) {
            this.dEn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.fKW && this.fLj != null) {
            this.fKW = true;
            this.fLj.bfA();
            a(false, (PostData) null);
        }
        if (this.fLi != null) {
            this.fLi.cancelLoadData();
            this.fLi.destory();
            if (this.fLi.bdM() != null) {
                this.fLi.bdM().onDestroy();
            }
        }
        if (this.fLw != null) {
            this.fLw.onDestroy();
        }
        if (this.cXP != null) {
            this.cXP.cancelLoadData();
        }
        if (this.fLj != null) {
            this.fLj.onDestroy();
            if (this.fLj.fTU != null) {
                this.fLj.fTU.aPc();
            }
        }
        if (this.fKX != null) {
            this.fKX.onDestroy();
        }
        if (this.fKP != null) {
            this.fKP.Pk();
        }
        super.onDestroy();
        if (this.dEn != null) {
            this.dEn.onDestory(getPageContext());
        }
        this.fLj.bfv();
        MessageManager.getInstance().unRegisterListener(this.fMd);
        MessageManager.getInstance().unRegisterListener(this.fMe);
        MessageManager.getInstance().unRegisterListener(this.fMf);
        MessageManager.getInstance().unRegisterListener(this.fLC);
        MessageManager.getInstance().unRegisterListener(this.fMg);
        MessageManager.getInstance().unRegisterListener(this.dFy);
        this.fLA = null;
        this.fLB = null;
        com.baidu.tieba.recapp.d.a.boS().boU();
        if (this.fLD != null) {
            getSafeHandler().removeCallbacks(this.fLD);
        }
        if (this.fLf != null) {
            this.fLf.cancelLoadData();
        }
        if (this.fLj != null && this.fLj.fTU != null) {
            this.fLj.fTU.bgo();
        }
        if (this.dQX != null) {
            this.dQX.cancelLoadData();
        }
        this.fLo.onDestroy();
        if (this.dEX != null) {
            this.dEX.onDestroy();
        }
        if (this.fLi != null && this.fLi.bdO() != null) {
            this.fLi.bdO().onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bfb;
        ArrayList<PostData> bcO;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.Fu() && this.fLj != null && (bfb = this.fLj.bfb()) != null && (bcO = bfb.bcO()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bcO.iterator();
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
                        bVar.bCW = id;
                        bVar.cZF = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aPe == 1 && !TextUtils.isEmpty(id)) {
                    next.aPe = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bCW = id;
                    bVar2.cZF = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fLi == null || this.fLi.getPbData() == null || this.fLi.getPbData().bas() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fLi.getPbData().bas().getFirst_class();
                    str2 = this.fLi.getPbData().bas().getSecond_class();
                    str = this.fLi.getPbData().bas().getId();
                    str4 = this.fLi.bdm();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Fx());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fLj.onChangeSkinType(i);
            if (this.fLw != null && this.fLw.Lc() != null) {
                this.fLw.Lc().onChangeSkinType(i);
            }
            if (this.fLj.beH() != null) {
                this.fLj.beH().onChangeSkinType(getPageContext(), i);
            }
            this.fLo.onChangeSkinType();
            if (this.dEX != null) {
                this.dEX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fLj = new ar(this, this.dFV, this.bLJ);
        this.cof = new com.baidu.tieba.e.b(getActivity());
        this.cof.a(this.fMt);
        this.cof.a(this.cog);
        this.fLj.setOnScrollListener(this.mOnScrollListener);
        this.fLj.d(this.fMn);
        this.fLj.a(this.bVd);
        this.fLj.jU(com.baidu.tbadk.core.i.xo().xu());
        this.fLj.setOnImageClickListener(this.bLI);
        this.fLj.a(this.bmk);
        this.fLj.h(this.dCv);
        this.fLj.a(this.fMl);
        this.fLj.kI(this.mIsLogin);
        if (getIntent() != null) {
            this.fLj.setIsInterviewLive(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cp(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.hba && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.xo().xu()) {
                    return qo(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fLi == null || this.fLi.getPbData() == null) {
                        return true;
                    }
                    if (bbR().beK() != null) {
                        bbR().beK().bcX();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.b(this.fLi.getPbData().bas());
                    kVar.T(this.fLi.getPbData().bau());
                    kVar.d(postData);
                    bbR().beJ().d(kVar);
                    bbR().beJ().setPostId(postData.getId());
                    a(view, postData.zn().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fLw != null) {
                        this.fLj.kP(this.fLw.LH());
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
        if (this.fLj != null) {
            if (z && !this.foD) {
                bck();
            } else {
                hideLoadingView(this.fLj.getView());
            }
            if (z && this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().baR() && this.fLj.getView() != null) {
                this.fLj.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void bbT() {
        if (this.fKU == null) {
            this.fKU = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fKU.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fKJ = PbActivity.this.fKJ.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKJ);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fLi.bdm(), PbActivity.this.fKJ, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fKJ = PbActivity.this.fKJ.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKJ);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fLi.bdm(), PbActivity.this.fKJ, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fKJ = PbActivity.this.fKJ.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKJ);
                        bVar.dismiss();
                    }
                }
            }).ff(b.a.aRB).fg(17).d(getPageContext());
        }
    }

    private void C(Bundle bundle) {
        this.fLi = new PbModel(this);
        this.fLi.a(this.fMi);
        if (this.fLi.bdK() != null) {
            this.fLi.bdK().a(this.fMv);
        }
        if (this.fLi.bdJ() != null) {
            this.fLi.bdJ().a(this.fLT);
        }
        if (this.fLi.bdM() != null) {
            this.fLi.bdM().b(this.fLN);
        }
        if (bundle != null) {
            this.fLi.initWithBundle(bundle);
        } else {
            this.fLi.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fLi.kt(true);
        }
        ai.beu().P(this.fLi.bdk(), this.fLi.getIsFromMark());
        if (StringUtils.isNull(this.fLi.bdm())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fLc)) {
            this.fLi.sY(6);
        }
        if (this.fLi.bdL() != null) {
            this.fLi.bdL().a(this.fLM);
        }
        if (this.fLi.bdO() != null) {
            this.fLi.bdO().a(this.dEZ);
        }
        this.fLi.Nw();
    }

    private void initData(Bundle bundle) {
        this.flT = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.flT != null) {
            this.flT.a(this.fMk);
        }
        this.cXP = new ForumManageModel(this);
        this.cXP.setLoadDataCallBack(this.cXT);
        this.bft = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fLj.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void ak(Object obj) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fLi.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fLi.getPbData().bas().getId(), PbActivity.this.fLi.getPbData().bas().getName(), PbActivity.this.fLi.getPbData().bau().getId(), valueOf, str, str2)));
            }
        });
        this.fLZ.setUniqueId(getUniqueId());
        this.fLZ.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fLj.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fLC;
        userMuteCheckCustomMessage.setTag(this.fLC);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bbU() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fLi != null && (pbData = this.fLi.getPbData()) != null) {
            return pbData.baF().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bau() != null) {
            if (dVar.bau().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bau().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bau().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData cq(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bxl()) {
                postData.cQ(postData.bxk() - 1);
            } else {
                postData.cQ(postData.bxk() + 1);
            }
            postData.mP(!postData.bxl());
            ((PbFloorAgreeView) view).a(postData.bxl(), postData.bxk(), true);
            final int i = postData.bxl() ? 0 : 1;
            this.fLi.bdL().a(postData.getId(), i, new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                @Override // com.baidu.tieba.pb.pb.main.q.a
                public void sL(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).tj(i2);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.q.a
                public void c(CustomDialogData customDialogData) {
                    customDialogData.type = 0;
                    com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                }
            });
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.ak bbV() {
        return new com.baidu.tbadk.core.util.ak("c12003").ab("tid", this.fLi.fPW).s("obj_type", 0).ab(ImageViewerConfig.FORUM_ID, this.fLi.getForumId()).s("obj_param1", this.fLi.getPbData().bau().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                @Override // java.lang.Runnable
                public void run() {
                    int t;
                    int aq = (com.baidu.adp.lib.util.l.aq(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        t = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.t(PbActivity.this.getPageContext().getPageActivity(), d.e.ds120);
                    } else {
                        t = com.baidu.adp.lib.util.l.t(PbActivity.this.getPageContext().getPageActivity(), d.e.ds640);
                    }
                    int i = t - aq;
                    if (i > 0) {
                        PbActivity.this.bbR().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bbR().beK() != null) {
                        PbActivity.this.fLw.Lc().setVisibility(8);
                        PbActivity.this.bbR().beK().bG(str, str2);
                        com.baidu.tbadk.editortools.pb.h bdd = PbActivity.this.bbR().beK().bdd();
                        if (bdd != null && PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null) {
                            bdd.a(PbActivity.this.fLi.getPbData().yn());
                        }
                        if (PbActivity.this.fLo.bfV() == null && PbActivity.this.bbR().beK().bdd().Mb() != null) {
                            PbActivity.this.bbR().beK().bdd().Mb().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fLo != null && PbActivity.this.fLo.bfU() != null) {
                                        if (!PbActivity.this.fLo.bfU().bFJ()) {
                                            PbActivity.this.fLo.kV(false);
                                        }
                                        PbActivity.this.fLo.bfU().nG(false);
                                    }
                                }
                            });
                            PbActivity.this.fLo.h(PbActivity.this.bbR().beK().bdd().Mb().getInputView());
                            PbActivity.this.bbR().beK().bdd().a(PbActivity.this.fLz);
                        }
                    }
                    PbActivity.this.bbR().bfE();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.fLi != null && this.fLi.getPbData() != null && postData.bwY() > 1) {
            String bdm = this.fLi.bdm();
            String id = postData.getId();
            int baG = this.fLi.getPbData() != null ? this.fLi.getPbData().baG() : 0;
            c qp = qp(id);
            if (qp != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bdm, id, "pb", true, null, false, null, baG, postData.bha(), this.fLi.getPbData().yn(), false, postData.zn() != null ? postData.zn().getIconInfo() : null).addBigImageData(qp.fNa, qp.fNb, qp.fNc, qp.index);
                addBigImageData.setKeyPageStartFrom(this.fLi.bdS());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ao aoVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.pa()) {
                showToast(d.j.no_network_guide);
            } else if (bbA() != null && bbA().getPbData() != null && bbA().getPbData().baQ() != null) {
                com.baidu.tieba.pb.data.j baQ = bbA().getPbData().baQ();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ao)) {
                    aoVar = null;
                } else {
                    aoVar = (ao) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (baQ != null) {
                    int i3 = -1;
                    if (z) {
                        baQ.sB(i);
                    } else if (baQ.baX()) {
                        baQ.bba();
                        i3 = 1;
                    } else {
                        baQ.sD(i);
                        i3 = 0;
                    }
                    baQ.sC(i2);
                    q.a aVar = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
                        @Override // com.baidu.tieba.pb.pb.main.q.a
                        public void sL(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.q.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.fLi != null && this.fLi.bdL() != null) {
                        String str = "";
                        if (this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null) {
                            str = this.fLi.getPbData().bau().zE();
                        }
                        if (this.fLi.getPbData() != null) {
                            this.fLi.getPbData().a(baQ);
                        }
                        if (z) {
                            this.fLi.bdL().a(str, 3, i, this.fLi.getForumId(), aVar);
                        } else {
                            this.fLi.bdL().a(str, i3, 3, i, this.fLi.getForumId(), aVar);
                            com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i();
                            iVar.fIc = i3;
                            iVar.fId = baQ;
                            iVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016551, iVar));
                        }
                    }
                    if (aoVar != null) {
                        aoVar.b(baQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bbW() {
        if (this.fLi.getPbData() == null || this.fLi.getPbData().bau() == null) {
            return -1;
        }
        return this.fLi.getPbData().bau().zR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbX() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.sg(this.fLi.getForumId()) && this.fLi.getPbData() != null && this.fLi.getPbData().bas() != null) {
            if (this.fLi.getPbData().bas().isLike() == 1) {
                this.fLi.bdO().bW(this.fLi.getForumId(), this.fLi.bdm());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kb(boolean z) {
        if (this.fLi == null || this.fLi.getPbData() == null) {
            return false;
        }
        return ((this.fLi.getPbData().baG() != 0) || this.fLi.getPbData().bau() == null || this.fLi.getPbData().bau().zn() == null || TextUtils.equals(this.fLi.getPbData().bau().zn().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bbY() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.o.q.OP()) {
            return "";
        }
        PostData baB = baB();
        if (this.fLi == null || (pbData = this.fLi.getPbData()) == null || pbData.getUserData() == null || pbData.bau() == null || baB == null || baB.zn() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !baB.zn().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bau().yX() == 0) {
            return "";
        }
        if (pbData.bau().yX() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean kc(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fLi == null || this.fLi.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fLi.getPbData();
        if (pbData.baG() == 0) {
            List<com.baidu.tbadk.core.data.ay> baO = pbData.baO();
            if (com.baidu.tbadk.core.util.v.D(baO) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : baO) {
                    if (ayVar != null && (tVar = ayVar.aOb) != null && tVar.aMj && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean kd(boolean z) {
        return (z || this.fLi == null || this.fLi.getPbData() == null || this.fLi.getPbData().baG() == 0) ? false : true;
    }

    public void bbZ() {
        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null && this.fLi.getPbData().bau().zn() != null) {
            if (this.fLj != null) {
                this.fLj.beI();
            }
            bd bau = this.fLi.getPbData().bau();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bau.zn().getUserId());
            aa aaVar = new aa();
            int baG = this.fLi.getPbData().baG();
            if (baG == 1) {
                aaVar.fRX = true;
                aaVar.fRW = true;
                aaVar.fSe = bau.zi() == 1;
                aaVar.fSd = bau.zj() == 1;
            } else {
                aaVar.fRX = false;
                aaVar.fRW = false;
            }
            if (baG == 1002 && !equals) {
                aaVar.fSi = true;
            }
            aaVar.fRT = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            aaVar.fRY = kc(equals);
            aaVar.fRZ = bca();
            aaVar.fSa = kd(equals);
            aaVar.fRU = this.fLi.bdn();
            aaVar.fRV = true;
            aaVar.fIs = this.flT != null && this.flT.vX();
            aaVar.fRS = kb(equals);
            aaVar.fSg = bbY();
            aaVar.fRR = equals && this.fLj.bfo();
            aaVar.fSb = TbadkCoreApplication.getInst().getSkinType() == 1;
            aaVar.fSc = true;
            aaVar.isHostOnly = this.fLi.getHostMode();
            aaVar.fSf = true;
            if (bau.zF() == null) {
                aaVar.fSh = true;
            } else {
                aaVar.fSh = false;
            }
            this.fLj.fTU.a(aaVar);
        }
    }

    private boolean bca() {
        if (this.fLi != null && this.fLi.bdn()) {
            return this.fLi.aEp() == null || this.fLi.aEp().yx() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    public int bcb() {
        if (bbR() == null || bbR().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bbR().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) iVar).mType == com.baidu.tieba.pb.data.h.fHY) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bcc() {
        if (bbR() == null || bbR().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bbR().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof PostData) && iVar.getType() == PostData.haZ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bcj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.dj(getResources().getString(d.j.mark_done));
            aVar.bg(true);
            aVar.dk(getResources().getString(d.j.mark_like));
            aVar.bf(true);
            aVar.aZ(false);
            aVar.b(getResources().getString(d.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ab("obj_id", metaData.getUserId()).s("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12528").ab("obj_id", metaData.getUserId()).s("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.bft.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fLi.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).AV();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fLj.bfh();
        this.fLi.ks(z);
        if (this.flT != null) {
            this.flT.aL(z);
            if (markData != null) {
                this.flT.a(markData);
            }
        }
        if (this.fLi.vX()) {
            bch();
        } else {
            this.fLj.n(this.fLi.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sG(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(String str) {
        if (!StringUtils.isNull(str) && this.fLi != null) {
            String bdm = this.fLi.bdm();
            String id = this.fLi.getPbData().bas().getId();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + bdm + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fLi.bdt()) {
                    antiData.setBlock_forum_name(this.fLi.getPbData().bas().getName());
                    antiData.setBlock_forum_id(this.fLi.getPbData().bas().getId());
                    antiData.setUser_name(this.fLi.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fLi.getPbData().getUserData().getUserId());
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
        if (AntiHelper.vR(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", aq.a.aXy));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", aq.a.aXy));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", aq.a.aXy));
            }
        } else if (i == 230277) {
            gC(str);
        } else {
            this.fLj.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.fLj.a(0, bVar.aoo, bVar.hdt, z);
            if (bVar.aoo) {
                if (bVar.hdr == 1) {
                    ArrayList<PostData> baw = this.fLi.getPbData().baw();
                    int size = baw.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(baw.get(i).getId())) {
                            i++;
                        } else {
                            baw.remove(i);
                            break;
                        }
                    }
                    this.fLj.n(this.fLi.getPbData());
                } else if (bVar.hdr == 0) {
                    bcd();
                } else if (bVar.hdr == 2) {
                    ArrayList<PostData> baw2 = this.fLi.getPbData().baw();
                    int size2 = baw2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= baw2.get(i2).bwV().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(baw2.get(i2).bwV().get(i3).getId())) {
                                i3++;
                            } else {
                                baw2.get(i2).bwV().remove(i3);
                                baw2.get(i2).bwX();
                                z2 = true;
                                break;
                            }
                        }
                        baw2.get(i2).sM(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fLj.n(this.fLi.getPbData());
                    }
                    a(bVar, this.fLj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fLj.a(this.cXP.getLoadDataMode(), gVar.aoo, gVar.hdt, false);
            if (gVar.aoo) {
                this.fLl = true;
                if (i == 2 || i == 3) {
                    this.fLm = true;
                    this.fLn = false;
                } else if (i == 4 || i == 5) {
                    this.fLm = false;
                    this.fLn = true;
                }
                if (i == 2) {
                    this.fLi.getPbData().bau().eS(1);
                    this.fLi.setIsGood(1);
                } else if (i == 3) {
                    this.fLi.getPbData().bau().eS(0);
                    this.fLi.setIsGood(0);
                } else if (i == 4) {
                    this.fLi.getPbData().bau().eR(1);
                    this.fLi.lO(1);
                } else if (i == 5) {
                    this.fLi.getPbData().bau().eR(0);
                    this.fLi.lO(0);
                }
                this.fLj.c(this.fLi.getPbData(), this.fLi.bdn());
            }
        }
    }

    private void bcd() {
        if (this.fLi.bdo() || this.fLi.bdq()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fLi.bdm());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fLi.bdm()));
        if (bci()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bce() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData baD;
        boolean z = false;
        if (this.fLj != null) {
            this.fLj.bfv();
        }
        if (this.fLi != null && this.fLi.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fLi.getPbData().bau().getId();
            if (this.fLi.isShareThread() && this.fLi.getPbData().bau().aQm != null) {
                historyMessage.threadName = this.fLi.getPbData().bau().aQm.showText;
            } else {
                historyMessage.threadName = this.fLi.getPbData().bau().getTitle();
            }
            if (this.fLi.isShareThread() && !bcA()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fLi.getPbData().bas().getName();
            }
            ArrayList<PostData> baw = this.fLi.getPbData().baw();
            int bfj = this.fLj != null ? this.fLj.bfj() : 0;
            if (baw != null && bfj >= 0 && bfj < baw.size()) {
                historyMessage.postID = baw.get(bfj).getId();
            }
            historyMessage.isHostOnly = this.fLi.getHostMode();
            historyMessage.isSquence = this.fLi.bdn();
            historyMessage.isShareThread = this.fLi.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fLw != null) {
            this.fLw.onDestroy();
        }
        if (this.fKS && bbR() != null) {
            bbR().bfO();
        }
        if (this.fLi != null && (this.fLi.bdo() || this.fLi.bdq())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fLi.bdm());
            if (this.fLl) {
                if (this.fLn) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fLi.bds());
                }
                if (this.fLm) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fLi.getIsGood());
                }
            }
            if (this.fLi.getPbData() != null && System.currentTimeMillis() - this.fKV >= 40000 && (baD = this.fLi.getPbData().baD()) != null && !com.baidu.tbadk.core.util.v.E(baD.getDataList())) {
                intent.putExtra("guess_like_data", baD);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fLJ);
            }
            setResult(-1, intent);
        }
        if (bci()) {
            if (this.fLi != null && this.fLj != null && this.fLj.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fLi.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.baA() && !this.fLb) {
                        ai beu = ai.beu();
                        com.baidu.tieba.pb.data.d pbData2 = this.fLi.getPbData();
                        Parcelable onSaveInstanceState = this.fLj.getListView().onSaveInstanceState();
                        boolean bdn = this.fLi.bdn();
                        boolean hostMode = this.fLi.getHostMode();
                        if (this.fLj.beS() != null && this.fLj.beS().getVisibility() == 0) {
                            z = true;
                        }
                        beu.a(pbData2, onSaveInstanceState, bdn, hostMode, z);
                        if (this.fLI >= 0 || this.fLi.bdU() != null) {
                            ai.beu().j(this.fLi.bdU());
                            ai.beu().i(this.fLi.bdV());
                            ai.beu().ta(this.fLi.bdW());
                        }
                    }
                }
            } else {
                ai.beu().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fLj == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fLj.te(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sI(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fLj.beI();
            this.fLj.beK().bcX();
            this.fLj.kR(false);
        }
        this.fLj.beL();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fLw.resetData();
                        this.fLw.b(writeData);
                        this.fLw.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.r hI = this.fLw.Lc().hI(6);
                        if (hI != null && hI.bsm != null) {
                            hI.bsm.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fLw.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fLj.beK() != null && this.fLj.beK().bdb() != null) {
                            com.baidu.tbadk.editortools.pb.h bdb = this.fLj.beK().bdb();
                            bdb.b(writeData);
                            bdb.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.r hI2 = bdb.Lc().hI(6);
                            if (hI2 != null && hI2.bsm != null) {
                                hI2.bsm.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bdb.LT();
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
        this.fLw.onActivityResult(i, i2, intent);
        if (this.fLf != null) {
            this.fLf.onActivityResult(i, i2, intent);
        }
        if (bbR().beK() != null) {
            bbR().beK().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bcg();
                    return;
                case 13008:
                    ai.beu().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fLi != null) {
                                PbActivity.this.fLi.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.fLi != null) {
                        a(bcf(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    L(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        bbX();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dQX != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dQX.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void HR() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57.1
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
                    this.fLj.jZ(false);
                    if (this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null && this.fLi.getPbData().bau().zI() != null) {
                        this.fLi.getPbData().bau().zI().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        c(emotionImageData);
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fLj != null && this.fLj.fTU != null) {
                        this.fLj.fTU.wH();
                        this.fLj.fTU.bgi();
                        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null) {
                            this.fLi.getPbData().bau().eN(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fLg != null) {
                        this.fLj.cz(this.fLg);
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

    private void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.fLf == null) {
                this.fLf = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fLf.b(this.bue);
                this.fLf.c(this.bum);
            }
            this.fLf.a(emotionImageData, bbA(), bbA().getPbData());
        }
    }

    private ShareFromPBMsgData bcf() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bY = this.fLi.getPbData().bY(getPageContext().getPageActivity());
        PostData beN = this.fLj.beN();
        String str = "";
        if (beN != null) {
            str = beN.getId();
            String cl = beN.cl(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(cl)) {
                bY[1] = cl;
            }
        }
        String zE = this.fLi.getPbData().bau().zE();
        if (zE != null && zE.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bY[1]);
        shareFromPBMsgData.setImageUrl(bY[0]);
        shareFromPBMsgData.setForumName(this.fLi.getPbData().bas().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fLi.getPbData().bau().getId());
        shareFromPBMsgData.setTitle(this.fLi.getPbData().bau().getTitle());
        return shareFromPBMsgData;
    }

    private void L(Intent intent) {
        a(bcf(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ab = new com.baidu.tbadk.core.util.ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_param1", 3).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fLi.getForumId()).ab("tid", PbActivity.this.fLi.bdm());
                        if (PbActivity.this.e(PbActivity.this.fLi.getPbData()) != 0) {
                            ab.s("obj_type", PbActivity.this.e(PbActivity.this.fLi.getPbData()));
                        }
                        TiebaStatic.log(ab);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ba(true);
            aVar.b(getPageContext()).AV();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.G(shareFromPBMsgData.getImageUrl(), this.fLi.getPbData().baH() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), i, str, j, "from_share", lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ba(true);
            aVar.b(getPageContext()).AV();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.G(shareFromPBMsgData.getImageUrl(), this.fLi.getPbData().baH() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcg() {
        MarkData sX;
        if (this.flT != null && (sX = this.fLi.sX(this.fLj.bfk())) != null) {
            if (!sX.isApp() || (sX = this.fLi.sX(this.fLj.bfk() + 1)) != null) {
                this.fLj.bff();
                this.flT.a(sX);
                if (!this.flT.vX()) {
                    this.flT.vZ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.flT.vY();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bch() {
        com.baidu.tieba.pb.data.d pbData = this.fLi.getPbData();
        this.fLi.ks(true);
        if (this.flT != null) {
            pbData.qj(this.flT.vW());
        }
        this.fLj.n(pbData);
    }

    private boolean bci() {
        if (this.fLi == null) {
            return true;
        }
        if (this.fLi.vX()) {
            final MarkData bdB = this.fLi.bdB();
            if (bdB == null || !this.fLi.getIsFromMark()) {
                return true;
            }
            final MarkData sX = this.fLi.sX(this.fLj.bfj());
            if (sX == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bdB);
                setResult(-1, intent);
                return true;
            } else if (sX.getPostId() == null || sX.getPostId().equals(bdB.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bdB);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dk(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.flT != null) {
                            if (PbActivity.this.flT.vX()) {
                                PbActivity.this.flT.vY();
                                PbActivity.this.flT.aL(false);
                            }
                            PbActivity.this.flT.a(sX);
                            PbActivity.this.flT.aL(true);
                            PbActivity.this.flT.vZ();
                        }
                        bdB.setPostId(sX.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bdB);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bce();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bdB);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bce();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fLj != null && PbActivity.this.fLj.getView() != null) {
                            PbActivity.this.fLj.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bdB);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bce();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.AV();
                return false;
            }
        } else if (this.fLi.getPbData() == null || this.fLi.getPbData().baw() == null || this.fLi.getPbData().baw().size() <= 0 || !this.fLi.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fLj == null) {
            return null;
        }
        return this.fLj.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RO() {
        if (this.fLj == null) {
            return 0;
        }
        return this.fLj.bft();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RP() {
        if (this.bLz == null) {
            this.bLz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ahq */
                public ImageView nl() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean xu = com.baidu.tbadk.core.i.xo().xu();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aj.getDrawable(d.C0141d.common_color_10220));
                    if (xu) {
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
                public void as(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0141d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView at(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.xo().xu()) {
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
                public ImageView au(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0141d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bLz;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RQ() {
        if (this.bLA == null) {
            this.bLA = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.bLA;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RR() {
        if (this.bLE == null) {
            this.bLE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcC */
                public GifView nl() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void as(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView at(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView au(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.Mt();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bLE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RS() {
        if (this.bLB == null) {
            this.bLB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcD */
                public View nl() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ct */
                public void as(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cu */
                public View at(View view) {
                    ((PlayVoiceBntNew) view).byf();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cv */
                public View au(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bLB;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RU() {
        this.bLD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bcE */
            public RelativeLayout nl() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout at(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout au(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.bLD;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> EA() {
        if (this.beQ == null) {
            this.beQ = UserIconBox.w(getPageContext().getPageActivity(), 8);
        }
        return this.beQ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fKZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        if (aw.qA(str) && this.fLi != null && this.fLi.bdm() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").s("obj_param1", 1).ab("post_id", this.fLi.bdm()));
        }
        aw.bfX().d(getPageContext(), str);
        this.fKZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        aw.bfX().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fKZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fLi.getPbData();
            TbRichText az = az(str, i);
            if (az != null && (tbRichTextData = az.Ri().get(this.fMo)) != null) {
                cVar.fNa = new ArrayList<>();
                cVar.fNb = new ConcurrentHashMap<>();
                if (!tbRichTextData.Ro().RA()) {
                    cVar.fNd = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fNa.add(b2);
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
                    imageUrlData.postId = az.getPostId();
                    imageUrlData.mIsReserver = this.fLi.bdA();
                    imageUrlData.mIsSeeHost = this.fLi.getHostMode();
                    cVar.fNb.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.bas() != null) {
                            cVar.forumName = pbData.bas().getName();
                            cVar.forumId = pbData.bas().getId();
                        }
                        if (pbData.bau() != null) {
                            cVar.threadId = pbData.bau().getId();
                        }
                        cVar.fNc = pbData.baH() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fNd = true;
                int size = pbData.baw().size();
                this.fMp = false;
                cVar.index = -1;
                if (pbData.baB() != null) {
                    PostData baB = pbData.baB();
                    TbRichText bxb = baB.bxb();
                    if (!aq.k(baB)) {
                        i2 = a(bxb, az, i, i, cVar.fNa, cVar.fNb);
                    } else {
                        i2 = a(baB, i, cVar.fNa, cVar.fNb);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.baw().get(i4);
                    if (postData.getId() == null || pbData.baB() == null || pbData.baB().getId() == null || !postData.getId().equals(pbData.baB().getId())) {
                        TbRichText bxb2 = postData.bxb();
                        if (!aq.k(postData)) {
                            i3 = a(bxb2, az, i3, i, cVar.fNa, cVar.fNb);
                        } else {
                            i3 = a(postData, i3, cVar.fNa, cVar.fNb);
                        }
                    }
                }
                if (cVar.fNa.size() > 0) {
                    cVar.lastId = cVar.fNa.get(cVar.fNa.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.bas() != null) {
                        cVar.forumName = pbData.bas().getName();
                        cVar.forumId = pbData.bas().getId();
                    }
                    if (pbData.bau() != null) {
                        cVar.threadId = pbData.bau().getId();
                    }
                    cVar.fNc = pbData.baH() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Ro() == null) {
            return null;
        }
        return tbRichTextData.Ro().RF();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Ro() == null) {
            return 0L;
        }
        return tbRichTextData.Ro().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Ro() == null) {
            return false;
        }
        return tbRichTextData.Ro().RG();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Ro() == null) {
            return false;
        }
        return tbRichTextData.Ro().RH();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Ro;
        String str;
        if (tbRichText == tbRichText2) {
            this.fMp = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Ri().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Ri().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.Ro().getWidth() * ar;
                    int height = ar * tbRichTextData.Ro().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Ro().RA()) {
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
                            if (tbRichTextData != null && (Ro = tbRichTextData.Ro()) != null) {
                                String RC = Ro.RC();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = Ro.RD();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = RC;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fLi.bdm(), -1L);
                                imageUrlData.mIsReserver = this.fLi.bdA();
                                imageUrlData.mIsSeeHost = this.fLi.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fMp) {
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
        com.baidu.tieba.tbadkCore.data.h bxi;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bwE;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bwE = (bxi = postData.bxi()).bwE()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bwE.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bwE.get(i3);
                if (jVar != null) {
                    String bwI = jVar.bwI();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bwI)) {
                        arrayList.add(bwI);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bwI;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bwH();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fLi.bdm(), -1L);
                        imageUrlData.mIsReserver = this.fLi.bdA();
                        imageUrlData.mIsSeeHost = this.fLi.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bxi.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bwI, imageUrlData);
                        }
                        if (!this.fMp) {
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
            if (postData.getId() != null && postData.getId().equals(this.fLi.zx())) {
                z = true;
            }
            MarkData h = this.fLi.h(postData);
            if (h != null) {
                this.fLj.bff();
                if (this.flT != null) {
                    this.flT.a(h);
                    if (!z) {
                        this.flT.vZ();
                    } else {
                        this.flT.vY();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText az(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fLi == null || this.fLi.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fLi.getPbData();
        if (pbData.baB() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.baB());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> baw = pbData.baw();
            a(pbData, baw);
            return a(baw, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.baF() != null && dVar.baF().fIu != null && (list = dVar.baF().fIu) != null && arrayList != null) {
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

    private long qn(String str) {
        ArrayList<PostData> baw;
        com.baidu.tieba.pb.data.d pbData = this.fLi.getPbData();
        if (pbData != null && (baw = pbData.baw()) != null && !baw.isEmpty()) {
            Iterator<PostData> it = baw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bxi = next.bxi();
                if (bxi != null && bxi.haG) {
                    Iterator<TbRichTextData> it2 = next.bxb().Ri().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Rx().getLink().equals(str)) {
                            return bxi.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Ri;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bxb = arrayList.get(i2).bxb();
            if (bxb != null && (Ri = bxb.Ri()) != null) {
                int size = Ri.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Ri.get(i4) != null && Ri.get(i4).getType() == 8) {
                        i3++;
                        if (Ri.get(i4).Ro().RC().equals(str) || Ri.get(i4).Ro().RD().equals(str)) {
                            int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                            int width = Ri.get(i4).Ro().getWidth() * ar;
                            int height = Ri.get(i4).Ro().getHeight() * ar;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fMo = i4;
                            return bxb;
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
            this.fKJ = str;
            if (this.fKU == null) {
                bbT();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fKU.fj(1).setVisibility(8);
            } else {
                this.fKU.fj(1).setVisibility(0);
            }
            this.fKU.AY();
            this.fKZ = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dEn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcj() {
        hideNetRefreshView(this.fLj.getView());
        bck();
        if (this.fLi.Nw()) {
            this.fLj.bff();
        }
    }

    private void bck() {
        showLoadingView(this.fLj.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View MP = getLoadingView().MP();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MP.getLayoutParams();
        layoutParams.addRule(3, this.fLj.bfJ().getId());
        MP.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avi() {
        if (this.dEn != null) {
            this.dEn.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ(int i) {
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
    public void sK(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fLi.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fLi.getPbData();
            pbData.bas().getName();
            String title = pbData.bau().getTitle();
            int i2 = this.fLi.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.bas() != null) {
                if ((pbData.bas().isLike() == 1) && AddExperiencedModel.sg(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fLi.bdm() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bY = pbData.bY(getPageContext().getPageActivity());
                    str = bY[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bY[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bbW() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ab(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.blj = true;
                    dVar.bln = z;
                    dVar.extData = this.fLi.bdm();
                    dVar.blx = 3;
                    dVar.blw = i;
                    dVar.fid = this.fLi.getForumId();
                    dVar.tid = this.fLi.bdm();
                    dVar.bly = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.blr = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fLi.getPbData().bau());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.blx);
                    bundle.putInt("obj_type", dVar.bly);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.i(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().baR()) {
                                PbActivity.this.fLj.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.d.d.anj().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fLi.bdm() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bY2 = pbData.bY(getPageContext().getPageActivity());
            str = bY2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bY2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bbW() == 1) {
            }
            if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.blj = true;
            dVar2.bln = z;
            dVar2.extData = this.fLi.bdm();
            dVar2.blx = 3;
            dVar2.blw = i;
            dVar2.fid = this.fLi.getForumId();
            dVar2.tid = this.fLi.bdm();
            dVar2.bly = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fLi.getPbData().bau());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.blx);
            bundle2.putInt("obj_type", dVar2.bly);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.i(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fLi != null && PbActivity.this.fLi.getPbData() != null && PbActivity.this.fLi.getPbData().baR()) {
                        PbActivity.this.fLj.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.d.d.anj().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bau() != null) {
            if (dVar.bau().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bau().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcl() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.sh(PbActivity.this.fLi.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fLj.bfP();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RT() {
        if (this.bLC == null) {
            this.bLC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcF */
                public LinearLayout nl() {
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
                /* renamed from: b */
                public void as(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public LinearLayout at(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public LinearLayout au(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.bLC;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fLj.bfa() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, this.fLi.getPbData().getForumId()));
            } else {
                bd bau = this.fLi.getPbData().bau();
                if (view != null) {
                    boolean z = bau.zc() == null || bau.zc().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fMa > 1000) {
                            this.fMb = true;
                            cs(view);
                        } else {
                            this.fMb = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            s(view, this.fMb);
                        } else {
                            r(view, this.fMb);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        r(view, this.fMb);
                    } else if (motionEvent.getAction() == 3) {
                        r(view, this.fMb);
                    }
                }
            }
        }
        return false;
    }

    private void r(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fMa = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void s(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fMa = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void cs(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void avj() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11017)));
        } else if (aVar.AX() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.AX();
            int intValue = ((Integer) sparseArray.get(ar.fVH)).intValue();
            if (intValue == ar.fVI) {
                if (!this.cXP.bxK()) {
                    this.fLj.bfc();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cXP.a(this.fLi.getPbData().bas().getId(), this.fLi.getPbData().bas().getName(), this.fLi.getPbData().bau().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == ar.fVJ || intValue == ar.fVL) {
                if (this.fLi.bdK() != null) {
                    this.fLi.bdK().sO(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.fVJ) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ar.fVK) {
                sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.fMu).xD()));
            }
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
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
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fLC);
        userMuteAddAndDelCustomMessage.setTag(this.fLC);
        a(z, userMuteAddAndDelCustomMessage, str5, str2);
    }

    private boolean qo(String str) {
        if (!StringUtils.isNull(str) && ay.ba(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.b.a(getPageContext().getPageActivity(), getResources().getString(d.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void ke(boolean z) {
        this.fLr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bcm() {
        ArrayList<PostData> baw;
        int D;
        if (this.fLi == null || this.fLi.getPbData() == null || this.fLi.getPbData().baw() == null || (D = com.baidu.tbadk.core.util.v.D((baw = this.fLi.getPbData().baw()))) == 0) {
            return "";
        }
        if (this.fLi.bdA()) {
            Iterator<PostData> it = baw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bwY() == 1) {
                    return next.getId();
                }
            }
        }
        int bfj = this.fLj.bfj();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(baw, bfj);
        if (postData == null || postData.zn() == null) {
            return "";
        }
        if (this.fLi.qr(postData.zn().getUserId())) {
            return postData.getId();
        }
        for (int i = bfj - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(baw, i);
            if (postData2 == null || postData2.zn() == null || postData2.zn().getUserId() == null) {
                break;
            } else if (this.fLi.qr(postData2.zn().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bfj + 1; i2 < D; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(baw, i2);
            if (postData3 == null || postData3.zn() == null || postData3.zn().getUserId() == null) {
                return "";
            }
            if (this.fLi.qr(postData3.zn().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ac(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.aw.Du().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(qn(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fLi.getPbData().bas().getId(), this.fLi.getPbData().bas().getName(), this.fLi.getPbData().bau().getTid());
            }
            this.fKZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.dk(getResources().getString(d.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.dk(getResources().getString(d.j.make_sure_hide));
        }
        aVar.a(getResources().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fLi.bdJ() != null) {
                    PbActivity.this.fLi.bdJ().cF(j);
                }
            }
        });
        aVar.b(getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.ba(false);
        aVar.b(getPageContext());
        aVar.AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c qp(String str) {
        String str2;
        if (this.fLi.getPbData() == null || this.fLi.getPbData().baw() == null || this.fLi.getPbData().baw().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fLi.getPbData().baw().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fLi.getPbData().baw().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fLi.getPbData().baw().get(i);
        if (postData.bxb() == null || postData.bxb().Ri() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bxb().Ri().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Ro() != null) {
                    str2 = next.Ro().RC();
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
        if (this.fKQ) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fKQ = false;
        } else if (bcn()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fKQ) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fKQ = false;
        } else if (bcn()) {
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
        if (pageStayDurationItem != null && this.fLi != null) {
            if (this.fLi.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fLi.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fLi.bdm(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean bcn() {
        return (!this.fKO && this.fMw == -1 && this.fMx == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fMz = mVar;
            this.fKO = true;
            this.fLj.beT();
            this.fLj.qy(this.fMy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bco() {
        if (this.fMz != null) {
            if (this.fMw == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ay.aZ(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fMz.getCartoonId(), this.fMw, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcp() {
        if (this.fMz != null) {
            if (this.fMx == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ay.aZ(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fMz.getCartoonId(), this.fMx, 0)));
                finish();
            }
        }
    }

    public int bcq() {
        return this.fMw;
    }

    public int bcr() {
        return this.fMx;
    }

    private void aDK() {
        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null && this.fLi.getPbData().bau().Aa()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bcs() {
        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null && this.fLi.getPbData().bau().Aa()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bct() {
        if (this.fKR) {
            this.fLe = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null && this.fLi.getPbData().bau().yV() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fLi.getPbData().bau().yV().getThreadId(), this.fLi.getPbData().bau().yV().getTaskId(), this.fLi.getPbData().bau().yV().getForumId(), this.fLi.getPbData().bau().yV().getForumName(), this.fLi.getPbData().bau().zi(), this.fLi.getPbData().bau().zj())));
            this.fKQ = true;
            finish();
        }
    }

    public String bcu() {
        return this.fLc;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bcv() {
        return this.fLh;
    }

    public void kf(boolean z) {
        this.fLd = z;
    }

    public boolean bcw() {
        if (this.fLi != null) {
            return this.fLi.bdo();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dk(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fLA).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fLA.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLA).AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fLA != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLA.getPageActivity());
            aVar.dk(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fLA).AV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fLj.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLA.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.dk(this.fLA.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.dk(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fLj.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLA).AV();
    }

    public void bcy() {
        if (this.fLi != null && this.fLi.getPbData() != null && this.fLi.getPbData().bau() != null && this.fLi.getPbData().bau().Ao() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.fb(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fLi.getPbData().bau().Ao().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.AV();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (aw.qA(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.f(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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
        if (this.fLj != null) {
            this.fLj.onConfigurationChanged(configuration);
        }
        if (this.fLp != null) {
            this.fLp.dismiss();
        }
    }

    public boolean bcz() {
        if (this.fLi != null) {
            return this.fLi.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.fLi.getPbData().baF().fIu;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bwV().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bwV().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bwV().remove(i2);
                    list.get(i).bwX();
                    z = true;
                    break;
                }
            }
            list.get(i).sM(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.n(this.fLi.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bbd().getId();
        List<PostData> list = this.fLi.getPbData().baF().fIu;
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
                ArrayList<PostData> bbh = kVar.bbh();
                postData.vL(kVar.getTotalCount());
                if (postData.bwV() != null) {
                    postData.bwV().clear();
                    postData.bwV().addAll(bbh);
                }
            }
        }
        if (!this.fLi.getIsFromMark()) {
            this.fLj.n(this.fLi.getPbData());
        }
    }

    public boolean bcA() {
        if (this.fLi == null) {
            return false;
        }
        return this.fLi.bcA();
    }

    public void bcB() {
        if (this.fLj != null) {
            this.fLj.beI();
            avj();
        }
    }

    public PostData baB() {
        return this.fLj.b(this.fLi.fQo, this.fLi.bdn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aa(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.isLinkThread()) {
                return 3;
            }
            if (bdVar.Aq()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fLK != null && !this.fLK.isEmpty()) {
            int size = this.fLK.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fLK.get(i).onBackPressed()) {
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
            if (this.fLK == null) {
                this.fLK = new ArrayList();
            }
            if (!this.fLK.contains(aVar)) {
                this.fLK.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fLK == null) {
                this.fLK = new ArrayList();
            }
            if (!this.fLK.contains(aVar)) {
                this.fLK.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fLK != null) {
            this.fLK.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dEX == null) {
            this.dEX = new com.baidu.tbadk.core.dialog.i(getPageContext());
        }
        this.dEX.a(contriInfo, -1L);
    }
}
