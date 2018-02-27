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
    private com.baidu.adp.lib.e.b<RelativeLayout> bLA;
    private com.baidu.adp.lib.e.b<GifView> bLB;
    private com.baidu.adp.lib.e.b<ImageView> bLw;
    private com.baidu.adp.lib.e.b<TextView> bLx;
    private com.baidu.adp.lib.e.b<View> bLy;
    private com.baidu.adp.lib.e.b<LinearLayout> bLz;
    private com.baidu.tbadk.core.util.b.a bQD;
    private com.baidu.adp.lib.e.b<TbImageView> beN;
    private com.baidu.tieba.e.b coc;
    private com.baidu.tbadk.core.dialog.i dEU;
    private VoiceManager dEk;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fKP;
    private View fKQ;
    public at fKY;
    private x fKZ;
    private String fKt;
    private com.baidu.tieba.pb.pb.main.a.b fKz;
    private boolean fLW;
    private boolean fLb;
    private com.baidu.tieba.tbadkCore.data.e fLe;
    private com.baidu.tbadk.editortools.pb.g fLf;
    private com.baidu.tbadk.editortools.pb.d fLg;
    private com.baidu.adp.base.e fLk;
    private com.baidu.tbadk.core.view.e fLl;
    private BdUniqueId fLm;
    private Runnable fLn;
    private av fLo;
    private com.baidu.adp.widget.a.a fLp;
    private String fLq;
    private TbRichTextMemeInfo fLr;
    private List<a> fLu;
    private String fMi;
    private com.baidu.tbadk.core.data.m fMj;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private boolean fKy = false;
    private boolean fKA = false;
    private boolean fKB = false;
    private boolean fom = false;
    private boolean fKC = true;
    private int fKD = 0;
    private com.baidu.tbadk.core.dialog.b fKE = null;
    private long dpx = -1;
    private long bAw = 0;
    private long fKF = 0;
    private long createTime = 0;
    private long bAo = 0;
    private boolean fKG = false;
    private com.baidu.tbadk.k.d fKH = null;
    private long fKI = 0;
    private boolean fKJ = false;
    private long fKK = 0;
    private String btY = null;
    private boolean fKL = false;
    private boolean isFullScreen = false;
    private String fKM = "";
    private boolean fKN = true;
    private boolean fKO = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fKR = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void Y(boolean z) {
            PbActivity.this.fKT.kF(!PbActivity.this.fKN);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fKS != null && PbActivity.this.fKS.vX()) {
                        PbActivity.this.bcg();
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
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", aq.a.aXy));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", aq.a.aXy));
        }
    };
    private PbModel fKS = null;
    private com.baidu.tbadk.baseEditMark.a flD = null;
    private ForumManageModel cXM = null;
    private com.baidu.tbadk.coreExtra.model.a bfq = null;
    private ShareSuccessReplyToServerModel dQS = null;
    private ar fKT = null;
    public final com.baidu.tieba.pb.pb.main.a.a fKU = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean fKV = false;
    private boolean fKW = false;
    private boolean fKX = false;
    private boolean fLa = false;
    private boolean fLc = false;
    private boolean fLd = false;
    private boolean fLh = false;
    public boolean fLi = false;
    private com.baidu.tbadk.editortools.pb.c bub = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lz() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b buc = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ly() {
            if (PbActivity.this.fKY == null || PbActivity.this.fKY.bfS() == null || !PbActivity.this.fKY.bfS().bFD()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fKY.bfS().bFF());
            if (PbActivity.this.fLg != null && (PbActivity.this.fLg.LM() || PbActivity.this.fLg.LN())) {
                PbActivity.this.fLg.a(false, PbActivity.this.fKY.bfV());
            }
            PbActivity.this.fKY.kP(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fLj = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Ly() {
            if (PbActivity.this.fKY == null || PbActivity.this.fKY.bfT() == null || !PbActivity.this.fKY.bfT().bFD()) {
                return false;
            }
            PbActivity.this.showToast(PbActivity.this.fKY.bfT().bFF());
            if (PbActivity.this.fKT != null && PbActivity.this.fKT.beJ() != null && PbActivity.this.fKT.beJ().bdc() != null && PbActivity.this.fKT.beJ().bdc().LN()) {
                PbActivity.this.fKT.beJ().bdc().a(PbActivity.this.fKY.bfV());
            }
            PbActivity.this.fKY.kQ(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dEQ = false;
    private int fLs = 0;
    private int fLt = -1;
    private final a fLv = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fKT != null && PbActivity.this.fKT.beJ() != null) {
                r beJ = PbActivity.this.fKT.beJ();
                if (beJ.bcY()) {
                    beJ.bcX();
                    return true;
                }
            }
            if (PbActivity.this.fKT != null && PbActivity.this.fKT.bfB()) {
                PbActivity.this.fKT.bfC();
                return true;
            }
            return false;
        }
    };
    private q.b fLw = new q.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tieba.pb.pb.main.q.b
        public void c(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private AddExperiencedModel.a dEW = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bck();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final y.a fLx = new y.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void L(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void h(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fKT.showToast(str);
            }
        }
    };
    private final CustomMessageListener fLy = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fKS != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fLg != null) {
                    PbActivity.this.fKT.kK(PbActivity.this.fLg.LG());
                }
                PbActivity.this.fKT.beK();
                PbActivity.this.fKT.bfu();
            }
        }
    };
    CustomMessageListener dFm = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                PbActivity.this.fKS.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                if (PbActivity.this.fKT != null && PbActivity.this.fKS != null) {
                    PbActivity.this.fKT.d(PbActivity.this.fKS.getPbData(), PbActivity.this.fKS.bdm(), PbActivity.this.fKS.getRequestType());
                }
                if (PbActivity.this.fKT != null && PbActivity.this.fKT.bfa() != null) {
                    PbActivity.this.fKT.bfa().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fLz = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fKT != null) {
                    if (booleanValue) {
                        PbActivity.this.fKT.aKh();
                    } else {
                        PbActivity.this.fKT.aKg();
                    }
                }
            }
        }
    };
    private CustomMessageListener fLA = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fLg != null) {
                    PbActivity.this.fKT.kK(PbActivity.this.fLg.LG());
                }
                PbActivity.this.fKT.kM(false);
            }
        }
    };
    private CustomMessageListener fLB = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener fLC = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fKT != null && PbActivity.this.fKT.bfa() != null) {
                PbActivity.this.fKT.bfa().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener ewO = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fLD = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void h(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.sJ(2);
                ai.bet().reset();
                PbActivity.this.fKS.bdE();
                boolean z2 = false;
                ArrayList<PostData> bav = PbActivity.this.fKS.getPbData().bav();
                if (bav != null) {
                    Iterator<PostData> it = bav.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bxd().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fKT.n(PbActivity.this.fKS.getPbData());
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
    private View.OnClickListener buI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.btY);
        }
    };
    private CustomMessageListener fLE = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKS.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fKS.bdv() != null && PbActivity.this.fKS.bdv().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fKT.a(yVar.sendCount, PbActivity.this.fKS.getPbData(), PbActivity.this.fKS.bdm(), PbActivity.this.fKS.getRequestType());
                    }
                    if (pbData.bav() != null && pbData.bav().size() >= 1 && pbData.bav().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.bav().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fKS.bdl(), 0L);
                        if (c2 == yVar.postId && c3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bxc = pbData.bav().get(0).bxc();
                            if (bxc == null) {
                                bxc = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> yz = bxc.yz();
                            if (yz == null) {
                                yz = new ArrayList<>();
                            }
                            yz.add(0, aVar);
                            bxc.eL(yVar.sendCount + bxc.yy());
                            bxc.h(yz);
                            pbData.bav().get(0).a(bxc);
                            PbActivity.this.fKT.bfa().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a fLF = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.arj() != null && !aVar.arj().isEmpty()) {
                    PbActivity.this.fKT.a(aVar, PbActivity.this.fLH);
                }
                PbActivity.this.fKT.a(aVar, PbActivity.this.fKS.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bfY()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fLG = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void L(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.E(list) && PbActivity.this.fKT != null) {
                PbActivity.this.fKT.cW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fLH = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
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
    private boolean fLI = false;
    private PraiseModel fLJ = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void ir(String str) {
            PbActivity.this.fLI = false;
            if (PbActivity.this.fLJ != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKS.getPbData();
                if (pbData.bat().zc().getIsLike() == 1) {
                    PbActivity.this.nB(0);
                } else {
                    PbActivity.this.nB(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bat()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void I(int i, String str) {
            PbActivity.this.fLI = false;
            if (PbActivity.this.fLJ != null && str != null) {
                if (AntiHelper.vR(i)) {
                    AntiHelper.ar(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fLK = 0;
    private boolean fLL = true;
    private b.a fLM = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void kb(boolean z) {
            PbActivity.this.ka(z);
            if (PbActivity.this.fKT.bfH() != null && z) {
                PbActivity.this.fKT.kF(false);
            }
            PbActivity.this.fKT.kH(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().biH != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().biH, PbActivity.this.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", aq.a.aXy));
                        }
                    } else if (updateAttentionMessage.getData().apG) {
                        if (PbActivity.this.baA().zn() != null && PbActivity.this.baA().zn().getGodUserData() != null) {
                            PbActivity.this.baA().zn().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().bat() != null && PbActivity.this.fKS.getPbData().bat().zn() != null) {
                            PbActivity.this.fKS.getPbData().bat().zn().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cAq = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fKT.agf();
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
                    com.baidu.tieba.h.a.aBM();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bLG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (PbActivity.this.fKT.beL()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fKS != null && (PbActivity.this.fKS.getPbData() != null || PbActivity.this.fKS.getPbData().baP() != null)) {
                    if (PbActivity.this.fKS.getPbData().baP().baW()) {
                        if (PbActivity.this.fKS.getPbData().baP().fHM == 1 || PbActivity.this.fKS.getPbData().baP().fHM == 3 || PbActivity.this.fKS.getPbData().baP().fHM == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fKS.getPbData().baP().baW() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fKS.getPbData().baP().baW() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fKK > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).ll(false);
                        PbActivity.this.fKK = System.currentTimeMillis();
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
                    if (PbActivity.this.fKT != null && PbActivity.this.fKT.bbR() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10630").ab("obj_id", (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.fKU != null && PbActivity.this.fKU.fXO != null) {
                            PbActivity.this.fKU.fXO.onClick(view);
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
            if (PbActivity.this.fLg != null) {
                PbActivity.this.fKT.kK(PbActivity.this.fLg.LG());
            }
            PbActivity.this.fKT.beK();
            PbActivity.this.fKT.bfu();
            return true;
        }
    });
    private CustomMessageListener fLN = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLm) {
                PbActivity.this.fKT.agf();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKS.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.baH().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fLl.q(PbActivity.this.fLk.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fLk.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gC(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bcw();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.am.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fLk.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.fLl.r(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fLO = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLm) {
                PbActivity.this.fKT.agf();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fLl.q(PbActivity.this.fLk.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.am.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fLk.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.fLl.r(muteMessage);
            }
        }
    };
    private CustomMessageListener fLP = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fLm) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fKT.agf();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hnv;
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
                    PbActivity.this.fKT.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fLQ = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fKT.beL() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.bbz() != null && PbActivity.this.bbz().getPbData() != null && PbActivity.this.bbz().getPbData().baP() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean baW = PbActivity.this.bbz().getPbData().baP().baW();
                if (intValue < 10) {
                    if (baW) {
                        if (PbActivity.this.fKS.getPbData().baP().fHM == 1 || PbActivity.this.fKS.getPbData().baP().fHM == 3 || PbActivity.this.fKS.getPbData().baP().fHM == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", PbActivity.this.fKS.getPbData().baP().baW() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 4).s("obj_id", baW ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fKK > 2000) {
                        new com.baidu.tieba.pb.view.c(PbActivity.this.getActivity()).ll(false);
                        PbActivity.this.fKK = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, baW, 3);
                TiebaStatic.log(PbActivity.this.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).s("obj_locate", 4).s("obj_id", baW ? 0 : 1));
            }
        }
    };
    private CustomMessageListener dFu = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dEQ = true;
                }
            }
        }
    };
    public a.b fyh = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.avi();
            com.baidu.tbadk.core.data.al aEo = PbActivity.this.fKS.aEo();
            int pageNum = PbActivity.this.fKT.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (aEo == null || pageNum <= aEo.yr()) {
                PbActivity.this.fKT.bfu();
                PbActivity.this.sJ(2);
                PbActivity.this.avh();
                PbActivity.this.fKT.bfe();
                if (com.baidu.adp.lib.util.j.oJ()) {
                    PbActivity.this.fKS.sR(PbActivity.this.fKT.getPageNum());
                    if (PbActivity.this.fKz != null) {
                        PbActivity.this.fKz.showFloatingView();
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
    public final View.OnClickListener dFR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
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
            com.baidu.tieba.pb.data.j baP;
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
                    if (view == PbActivity.this.fKT.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fKS.kl(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fKT.bff();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().bem()) {
                        if (view == PbActivity.this.fKT.fTE.bCp) {
                            if (PbActivity.this.fKT.kJ(PbActivity.this.fKS.bds())) {
                                PbActivity.this.avh();
                                return;
                            }
                            PbActivity.this.fKC = false;
                            PbActivity.this.fKA = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fKT.bfc() && (PbActivity.this.fKT.fTE.bgj() == null || (view != PbActivity.this.fKT.fTE.bgj().bel() && view != PbActivity.this.fKT.fTE.bgj().bej()))) {
                            if (view == PbActivity.this.fKT.bfx()) {
                                if (PbActivity.this.fKS != null) {
                                    com.baidu.tbadk.browser.b.R(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKS.getPbData().bat().zm().getLink());
                                }
                            } else if (view != PbActivity.this.fKT.fTE.fYy && view.getId() != d.g.view_forum_name_first_floor && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.fKT.fTE.fYz) {
                                    if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null) {
                                        ArrayList<PostData> bav = PbActivity.this.fKS.getPbData().bav();
                                        if ((bav == null || bav.size() <= 0) && PbActivity.this.fKS.bdm()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12378").ab("tid", PbActivity.this.fKS.bdl()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getForumId()));
                                        if (!PbActivity.this.fKT.bfM()) {
                                            PbActivity.this.fKT.beK();
                                        }
                                        PbActivity.this.bbY();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().bdX()) {
                                        if ((PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().bei()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.fKT.fTE.bgj() == null || (view != PbActivity.this.fKT.fTE.bgj().getCancelView() && view != PbActivity.this.fKT.fTE.bgj().beh())) {
                                                if (view != PbActivity.this.fKT.fTE.fYA && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().bef()) {
                                                        if ((PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().beo()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().beg()) {
                                                                if (PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().bep()) {
                                                                    if (PbActivity.this.fKZ == null || view != PbActivity.this.fKZ.bdZ()) {
                                                                        if (PbActivity.this.fKZ == null || view != PbActivity.this.fKZ.bdX()) {
                                                                            if (PbActivity.this.fKZ == null || view != PbActivity.this.fKZ.bec()) {
                                                                                if (PbActivity.this.fKZ == null || view != PbActivity.this.fKZ.bea()) {
                                                                                    if (PbActivity.this.fKZ == null || view != PbActivity.this.fKZ.beb()) {
                                                                                        if (PbActivity.this.fKT.bfH() == view) {
                                                                                            if (PbActivity.this.fKT.bfH().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKS.getPbData();
                                                                                                if (pbData != null && pbData.bat() != null && pbData.bat().yV() != null) {
                                                                                                    String xP = pbData.bat().yV().xP();
                                                                                                    if (StringUtils.isNull(xP)) {
                                                                                                        xP = pbData.bat().yV().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11107").ab("obj_id", xP));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cd("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.bcs();
                                                                                        } else if (PbActivity.this.fKT.beZ() != view) {
                                                                                            if (PbActivity.this.fKZ == null || view != PbActivity.this.fKZ.bdY()) {
                                                                                                if (PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().ben()) {
                                                                                                    if (PbActivity.this.fKT.fTE.bgj() != null && view == PbActivity.this.fKT.fTE.bgj().bek()) {
                                                                                                        if (com.baidu.adp.lib.util.j.oJ()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.fKT.c(PbActivity.this.fKS.getPbData(), PbActivity.this.fKS.bdm(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.fKT.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.fKT.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.fKT.fTE.wH();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.fKT.bbK()) {
                                                                                                            if (view == PbActivity.this.fKT.fTE.bgk()) {
                                                                                                                PbActivity.this.fKT.bfm();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view.getTag()) != null && !StringUtils.isNull(biVar.AJ())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        com.baidu.tbadk.core.util.aw.Dt().c(PbActivity.this.getPageContext(), new String[]{biVar.AJ()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData cq = PbActivity.this.cq(view);
                                                                                                                    if (cq != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 5).s("obj_id", cq.bxg() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.bbz() != null && PbActivity.this.bbz().getPbData() != null && PbActivity.this.bbz().getPbData().baP() != null && PbActivity.this.bbz().getPbData().baP() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bbU().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_locate", 4).s("obj_id", PbActivity.this.bbz().getPbData().baP().baW() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && !StringUtils.isNull(PbActivity.this.fKS.getPbData().getThreadId()) && (baP = PbActivity.this.fKS.getPbData().baP()) != null && baP.baU() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.aw.Dt().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fKS.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.fKZ == null) {
                                                                                                                                PbActivity.this.fKZ = new x(PbActivity.this.getPageContext(), PbActivity.this.dFR);
                                                                                                                                PbActivity.this.fKT.cA(PbActivity.this.fKZ.getView());
                                                                                                                                PbActivity.this.fKZ.kp(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.fKZ.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12006").ab("tid", PbActivity.this.fKS.fPG));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.fKZ.bdX().setTag(sparseArray2);
                                                                                                                            PbActivity.this.fKZ.bec().setTag(view.getTag());
                                                                                                                            PbActivity.this.fKZ.kr(z6);
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
                                                                                                                                    PbActivity.this.fKZ.bea().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.fKZ.bea().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.fKZ.bdY().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fKZ.bea().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fKZ.bdY().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.fKZ.bdY().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.fKZ.bdY().setVisibility(8);
                                                                                                                                PbActivity.this.fKZ.bea().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.fKZ.bdY().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fKZ.bea().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fKZ.bdY().setText(d.j.delete);
                                                                                                                                PbActivity.this.fKZ.bea().setVisibility(0);
                                                                                                                                if (PbActivity.this.fKS.getPbData().baF() != 1002 || z2) {
                                                                                                                                    PbActivity.this.fKZ.bea().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fKZ.bea().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.fKZ.bdY().setVisibility(8);
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
                                                                                                                                PbActivity.this.fKZ.bdZ().setTag(sparseArray7);
                                                                                                                                PbActivity.this.fKZ.bdZ().setVisibility(0);
                                                                                                                                PbActivity.this.fKZ.bdY().setVisibility(8);
                                                                                                                                PbActivity.this.fKZ.bdZ().setText(d.j.mute_option);
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
                                                                                                                                boolean jW = PbActivity.this.jW(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fMa = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (aq.k(PbActivity.this.fMa) ? false : jW) {
                                                                                                                                    PbActivity.this.fKZ.bdZ().setVisibility(0);
                                                                                                                                    PbActivity.this.fKZ.bdZ().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fKZ.bdZ().setVisibility(8);
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
                                                                                                                                PbActivity.this.fKZ.beb().setVisibility(0);
                                                                                                                                PbActivity.this.fKZ.beb().setTag(d.g.tag_chudian_template_id, Long.valueOf(j2));
                                                                                                                                PbActivity.this.fKZ.beb().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.fKZ.beb().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.fKZ.beb().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fKS.getPbData().vX()) {
                                                                                                                            String vW = PbActivity.this.fKS.getPbData().vW();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(vW) && vW.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.fKZ.bdX().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fKZ.bdX().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fKZ.kq(true);
                                                                                                                                PbActivity.this.fKZ.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.fKZ.kq(true);
                                                                                                                        PbActivity.this.fKZ.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().bat() != null && PbActivity.this.fKS.getPbData().bat().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.b.R(PbActivity.this.getActivity(), PbActivity.this.fKS.getPbData().bat().getActUrl());
                                                                                                                        if (PbActivity.this.fKS.getPbData().bat().zR() != 1) {
                                                                                                                            if (PbActivity.this.fKS.getPbData().bat().zR() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10912").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getPbData().getForumId()).ab("tid", PbActivity.this.fKS.getPbData().getThreadId()).ab("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fKS.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.fKT.setSelection(0);
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
                                                                                                                        PbActivity.this.fKT.beK();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.b.R(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.bbV() == 1 && PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10397").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getPbData().getForumId()).ab("tid", PbActivity.this.fKS.getPbData().getThreadId()).ab("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.b.R(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.bbV() == 1 && PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10507").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getPbData().getForumId()).ab("tid", PbActivity.this.fKS.getPbData().getThreadId()).ab("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.bcn();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.bco();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().baL() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fKS.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11679").ab(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.aw.Dt().c(PbActivity.this.getPageContext(), new String[]{pbData2.baL().baT()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().baL() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fKS.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ab(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.aw.Dt().c(PbActivity.this.getPageContext(), new String[]{pbData3.baL().baT()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.fKT.fTE.bgj() != null && view == PbActivity.this.fKT.fTE.bgj().beq()) {
                                                                                                                    if (PbActivity.this.fKS == null || PbActivity.this.fKS.getPbData() == null || PbActivity.this.fKS.getPbData().bat() == null) {
                                                                                                                        PbActivity.this.fKT.fTE.wH();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.pa()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fKS.getPbData().bat().yX() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKS.bdl(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).Bc();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12399").s("obj_locate", PbActivity.this.aa(PbActivity.this.fKS.getPbData().bat())).ab("tid", PbActivity.this.fKS.getPbData().bat().getTid()).s("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fLs >= 0) {
                                                                                                                        if (PbActivity.this.fKS != null) {
                                                                                                                            PbActivity.this.fKS.bdS();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fKT.bfa() != null) {
                                                                                                                            PbActivity.this.fKT.bfa().a(PbActivity.this.fKS.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.fKT.getListView().setSelection(PbActivity.this.fKS.bdV());
                                                                                                                        PbActivity.this.fLs = 0;
                                                                                                                        if (PbActivity.this.fKS != null) {
                                                                                                                            PbActivity.this.fKS.co(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.fKT.bfP();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fKS.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fKS.bdl(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fKS.getPbData().bat().zI())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fKS.getPbData() != null) {
                                                                                                            PbActivity.this.fKT.bfu();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bxi() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12630"));
                                                                                                                }
                                                                                                                String bdl = PbActivity.this.fKS.bdl();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fKS.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fKS.getPbData().baF();
                                                                                                                }
                                                                                                                PbActivity.this.avh();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c qp = PbActivity.this.qp(id2);
                                                                                                                    if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && qp != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdl, id2, "pb", true, null, true, null, i3, postData3.bgZ(), PbActivity.this.fKS.getPbData().yn(), false, postData3.zn().getIconInfo()).addBigImageData(qp.fMK, qp.fML, qp.fMM, qp.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fKS.bdR());
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
                                                                                                                    if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && qp2 != null && PbActivity.this.bbQ().beI() != null) {
                                                                                                                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                                                        kVar.b(PbActivity.this.fKS.getPbData().bar());
                                                                                                                        kVar.T(PbActivity.this.fKS.getPbData().bat());
                                                                                                                        kVar.d(postData4);
                                                                                                                        PbActivity.this.bbQ().beI().d(kVar);
                                                                                                                        PbActivity.this.bbQ().beI().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c qp3 = PbActivity.this.qp(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && qp3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdl, id2, "pb", true, null, false, null, i3, postData3.bgZ(), PbActivity.this.fKS.getPbData().yn(), false, postData3.zn().getIconInfo()).addBigImageData(qp3.fMK, qp3.fML, qp3.fMM, qp3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fKS.bdR());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 3).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.oJ()) {
                                                                                                    PbActivity.this.fKT.bfu();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.fKT.c(PbActivity.this.fKS.getPbData(), PbActivity.this.fKS.bdm(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKS.getPbData().bar().getId(), PbActivity.this.fKS.getPbData().bar().getName(), PbActivity.this.fKS.getPbData().bat().getId(), String.valueOf(PbActivity.this.fKS.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_post_id))));
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
                                                                                                    if (!com.baidu.tieba.c.a.akL() || sparseArray11.get(d.g.tag_del_post_id) == null || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fKS.bdl(), (String) sparseArray11.get(d.g.tag_del_post_id))) {
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
                                                                                                                PbActivity.this.fKT.cy(view);
                                                                                                            }
                                                                                                        } else if (booleanValue5) {
                                                                                                            PbActivity.this.fKT.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.bbM();
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
                                                                                        com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fKS.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.bar() != null) {
                                                                                            str9 = pbData4.bar().getId();
                                                                                            str10 = pbData4.bar().getName();
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
                                                                                            if (booleanValue7 || intValue == 0 || !com.baidu.tieba.c.a.akL() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), PbActivity.this.fKS.bdl(), (String) sparseArray12.get(d.g.tag_del_post_id))) {
                                                                                                PbActivity.this.fKT.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), intValue, booleanValue7);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.fKZ.bee()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12007").ab("tid", PbActivity.this.fKS.fPG));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11739").s("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fKS.getPbData() != null) {
                                                                                    PbActivity.this.fKT.bfu();
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
                                                                                        String bdl2 = PbActivity.this.fKS.bdl();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fKS.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fKS.getPbData().baF();
                                                                                        }
                                                                                        PbActivity.this.avh();
                                                                                        c qp4 = PbActivity.this.qp(id3);
                                                                                        if (qp4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdl2, id3, "pb", true, null, true, null, i5, postData.bgZ(), PbActivity.this.fKS.getPbData().yn(), false, postData.zn().getIconInfo()).addBigImageData(qp4.fMK, qp4.fML, qp4.fMM, qp4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fKS.bdR());
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
                                                                                if (PbActivity.this.fKS.getPbData().bat() != null && PbActivity.this.fKS.getPbData().bat().zn() != null && PbActivity.this.fKS.getPbData().bat().zn().getUserId() != null && PbActivity.this.flD != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ab("tid", PbActivity.this.fKS.fPG).s("obj_locate", 2).ab("obj_id", PbActivity.this.fKS.getPbData().bat().zn().getUserId()).s("obj_type", PbActivity.this.flD.vX() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fKS.getPbData())));
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
                                                                    PbActivity.this.fKT.fTE.bgi();
                                                                }
                                                            } else if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().bat() != null) {
                                                                PbActivity.this.fKT.fTE.wH();
                                                                PbActivity.this.qm(PbActivity.this.fKS.getPbData().bat().zE());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fKT.bfu();
                                                            if (com.baidu.adp.lib.util.j.oJ()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fKS.bdz()));
                                                                    return;
                                                                }
                                                                PbActivity.this.sJ(2);
                                                                PbActivity.this.avh();
                                                                PbActivity.this.fKT.bfe();
                                                                boolean bdy = PbActivity.this.fKS.bdy();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fKS.bdz()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.fKT.fTE != null && PbActivity.this.fKT.fTE.bgj() != null && view == PbActivity.this.fKT.fTE.bgj().beo()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12097").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bdy) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.fKT.kA(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fKT.bfu();
                                                        if (PbActivity.this.fKS.aEo() != null) {
                                                            PbActivity.this.fKT.a(PbActivity.this.fKS.aEo(), PbActivity.this.fyh);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.ap.nv() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fKS != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12386").ab("tid", PbActivity.this.fKS.bdl()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getForumId()).s("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.pa()) {
                                                        if (PbActivity.this.fKS.getPbData() != null) {
                                                            ArrayList<PostData> bav2 = PbActivity.this.fKS.getPbData().bav();
                                                            if ((bav2 != null && bav2.size() > 0) || !PbActivity.this.fKS.bdm()) {
                                                                PbActivity.this.fKT.bfu();
                                                                PbActivity.this.avh();
                                                                PbActivity.this.sJ(2);
                                                                if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().baL() != null && !StringUtils.isNull(PbActivity.this.fKS.getPbData().baL().ya(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11678").ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11939"));
                                                                if (com.baidu.tbadk.o.ap.nv()) {
                                                                    PbActivity.this.sK(2);
                                                                } else {
                                                                    PbActivity.this.fKT.showLoadingDialog();
                                                                    PbActivity.this.fKS.bdM().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.fKT.fTE.wH();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.oJ()) {
                                            PbActivity.this.fKT.bfu();
                                            if (PbActivity.this.fKT.fTE.bgj() != null && view == PbActivity.this.fKT.fTE.bgj().bei() && !PbActivity.this.fKT.bfM()) {
                                                PbActivity.this.fKT.beK();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.avh();
                                                PbActivity.this.fKT.bfe();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    j = PbActivity.this.fKS.j(true, PbActivity.this.bcl());
                                                } else {
                                                    j = view.getId() == d.g.reply_title ? PbActivity.this.fKS.j(false, PbActivity.this.bcl()) : PbActivity.this.fKS.qq(PbActivity.this.bcl());
                                                }
                                                view.setTag(Boolean.valueOf(j));
                                                if (j) {
                                                    PbActivity.this.fKT.kf(true);
                                                    PbActivity.this.fKT.aKh();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fKT.kA(true);
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
                                        PbActivity.this.fKT.bfu();
                                        if (PbActivity.this.sI(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fKS.sX(PbActivity.this.fKT.bfj()) != null) {
                                            PbActivity.this.bcf();
                                            if (PbActivity.this.fKS.getPbData().bat() != null && PbActivity.this.fKS.getPbData().bat().zn() != null && PbActivity.this.fKS.getPbData().bat().zn().getUserId() != null && PbActivity.this.flD != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12526").ab("tid", PbActivity.this.fKS.fPG).s("obj_locate", 1).ab("obj_id", PbActivity.this.fKS.getPbData().bat().zn().getUserId()).s("obj_type", PbActivity.this.flD.vX() ? 0 : 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fKS.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.oJ()) {
                                    PbActivity.this.fKT.kf(true);
                                    PbActivity.this.fKT.beK();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fKT.aKh();
                                        PbActivity.this.avh();
                                        PbActivity.this.fKT.bfe();
                                        PbActivity.this.fKS.qq(PbActivity.this.bcl());
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
                                if (PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().bat() != null && PbActivity.this.fKS.getPbData().bat().Aa() && PbActivity.this.fKS.getPbData().bat().zF() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11922"));
                                }
                                if (PbActivity.this.fKS.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fKS.bdk()) && PbActivity.this.fKS.getAppealInfo() != null) {
                                        name = PbActivity.this.fKS.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fKS.getPbData().bar().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bdk = PbActivity.this.fKS.bdk();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fKS.bdn() && bdk != null && bdk.equals(name)) {
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
                            if (PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().baF() == 1 && !PbActivity.this.cXM.bxF()) {
                                PbActivity.this.fKT.bfu();
                                int i6 = 0;
                                if (PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().bej()) {
                                    if (PbActivity.this.fKT.fTE.bgj() == null || view != PbActivity.this.fKT.fTE.bgj().bel()) {
                                        if (view == PbActivity.this.fKT.bfc()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fKS.getPbData().bat().zj() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fKS.getPbData().bat().zi() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData bar = PbActivity.this.fKS.getPbData().bar();
                                String name2 = bar.getName();
                                String id4 = bar.getId();
                                String id5 = PbActivity.this.fKS.getPbData().bat().getId();
                                if (!com.baidu.tieba.c.a.akL() || !com.baidu.tieba.c.a.j(PbActivity.this.getBaseContext(), id5, null)) {
                                    PbActivity.this.fKT.bfb();
                                    PbActivity.this.cXM.a(id4, name2, id5, i6, PbActivity.this.fKT.bfd());
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.oJ()) {
                        PbActivity.this.fKT.bfu();
                        PbActivity.this.avh();
                        PbActivity.this.fKT.bfe();
                        PbActivity.this.fKT.showLoadingDialog();
                        if (PbActivity.this.fKT.beR() != null) {
                            PbActivity.this.fKT.beR().setVisibility(8);
                        }
                        PbActivity.this.fKS.sR(1);
                        if (PbActivity.this.fKz != null) {
                            PbActivity.this.fKz.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bbT = PbActivity.this.bbT();
                        if (!TextUtils.isEmpty(bbT)) {
                            com.baidu.tbadk.core.util.aw.Dt().c(PbActivity.this.getPageContext(), new String[]{bbT});
                        }
                    }
                } else if (PbActivity.this.fKJ) {
                    PbActivity.this.fKJ = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.bbQ().beI() != null && postData5.zn() != null && postData5.bwT() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bbQ().beJ() != null) {
                                    PbActivity.this.bbQ().beJ().bcW();
                                }
                                com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                                kVar2.b(PbActivity.this.fKS.getPbData().bar());
                                kVar2.T(PbActivity.this.fKS.getPbData().bat());
                                kVar2.d(postData5);
                                PbActivity.this.bbQ().beI().d(kVar2);
                                PbActivity.this.bbQ().beI().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.zn().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fLg != null) {
                                    PbActivity.this.fKT.kK(PbActivity.this.fLg.LG());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d buj = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.avh();
            PbActivity.this.fKT.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ag.ON() && PbActivity.this.bbz() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bbz().qt(postWriteCallBackData.getPostId());
                    PbActivity.this.fLs = PbActivity.this.fKT.beN();
                    if (PbActivity.this.fKS != null) {
                        PbActivity.this.fKS.co(PbActivity.this.fLs, PbActivity.this.fKT.beO());
                    }
                }
                PbActivity.this.fKT.bfu();
                PbActivity.this.fKY.bfR();
                if (PbActivity.this.fLg != null) {
                    PbActivity.this.fKT.kK(PbActivity.this.fLg.LG());
                }
                PbActivity.this.fKT.beH();
                PbActivity.this.fKT.kM(true);
                PbActivity.this.fKS.bdB();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fKS.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKS.getPbData();
                            if (pbData != null && pbData.bat() != null && pbData.bat().zn() != null && (userId = pbData.bat().zn().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ag.ON() && PbActivity.this.fKS.bdu()) {
                                PbActivity.this.fKT.bfe();
                            }
                        } else if (!com.baidu.tbadk.o.ag.ON() && PbActivity.this.fKS.bdu()) {
                            PbActivity.this.fKT.bfe();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fKT.n(PbActivity.this.fKS.getPbData());
                    }
                    if (PbActivity.this.fKS.bdq()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10369").ab("tid", PbActivity.this.fKS.bdl()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fLg.LM() || PbActivity.this.fLg.LN()) {
                    PbActivity.this.fLg.a(false, postWriteCallBackData);
                }
                PbActivity.this.fKY.e(postWriteCallBackData);
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fLR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (PbActivity.this.fKY != null) {
                if (z) {
                    if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                        PbActivity.this.a(postWriteCallBackData.getContriInfo());
                    }
                    PbActivity.this.fKY.bfQ();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    if (PbActivity.this.fKT != null && PbActivity.this.fKT.beJ() != null && PbActivity.this.fKT.beJ().bdc() != null && PbActivity.this.fKT.beJ().bdc().LN()) {
                        PbActivity.this.fKT.beJ().bdc().a(postWriteCallBackData);
                    }
                    PbActivity.this.fKY.f(postWriteCallBackData);
                }
            }
        }
    };
    private final PbModel.a fLS = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.l hG;
            if (!z || dVar == null || dVar.baD() != null || com.baidu.tbadk.core.util.v.D(dVar.bav()) >= 1) {
                PbActivity.this.fom = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fKT.bfg();
                if (dVar == null || !dVar.baz()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fKT.getView());
                }
                PbActivity.this.fKT.aKg();
                if (PbActivity.this.isFullScreen || PbActivity.this.fKT.bfM()) {
                    PbActivity.this.fKT.bfD();
                } else if (!PbActivity.this.fKT.bfA()) {
                    PbActivity.this.fKT.kM(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fLa = true;
                }
                if (z && dVar != null) {
                    PbActivity.this.fKT.aij();
                    if (dVar.bat() != null && dVar.bat().Ag() != null) {
                        PbActivity.this.a(dVar.bat().Ag());
                    }
                    PbActivity.this.bbN();
                    if (PbActivity.this.fLg != null) {
                        PbActivity.this.fKT.kK(PbActivity.this.fLg.LG());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bav() != null && dVar.bav().size() >= 1 && dVar.bav().get(0) != null) {
                        PbActivity.this.fKS.qs(dVar.bav().get(0).getId());
                    } else if (dVar.baD() != null) {
                        PbActivity.this.fKS.qs(dVar.baD().getId());
                    }
                    if (PbActivity.this.fLg != null) {
                        PbActivity.this.fLg.a(dVar.yn());
                        PbActivity.this.fLg.a(dVar.bar(), dVar.getUserData());
                        PbActivity.this.fLg.a(PbActivity.this.fKS.bdv(), PbActivity.this.fKS.bdl(), PbActivity.this.fKS.bdO());
                        if (dVar.bat() != null) {
                            PbActivity.this.fLg.cm(dVar.bat().Aw());
                        }
                    }
                    if (PbActivity.this.flD != null) {
                        PbActivity.this.flD.aL(dVar.vX());
                    }
                    if (dVar == null || dVar.baG() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fKT.kL(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fKT.a(dVar, i2, i3, PbActivity.this.fKS.bdm(), i4, PbActivity.this.fKS.getIsFromMark());
                    PbActivity.this.fKT.d(dVar, PbActivity.this.fKS.bdm());
                    PbActivity.this.fKT.kI(PbActivity.this.fKS.getHostMode());
                    AntiData yn = dVar.yn();
                    if (yn != null) {
                        PbActivity.this.btY = yn.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.btY) && PbActivity.this.fLg != null && PbActivity.this.fLg.Lb() != null && (hG = PbActivity.this.fLg.Lb().hG(6)) != null && !TextUtils.isEmpty(PbActivity.this.btY)) {
                            ((View) hG).setOnClickListener(PbActivity.this.buI);
                        }
                    }
                    if (PbActivity.this.fLc) {
                        PbActivity.this.fLc = false;
                        final int bca = PbActivity.this.bca();
                        if (dVar.baQ()) {
                            final int ao = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bca, ao);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bbQ().td(bca);
                        }
                    }
                    if (PbActivity.this.fLd) {
                        PbActivity.this.fLd = false;
                        final int bca2 = PbActivity.this.bca();
                        final boolean z2 = bca2 != -1;
                        if (!z2) {
                            bca2 = PbActivity.this.bcb();
                        }
                        if (PbActivity.this.bbQ() != null) {
                            if (dVar.baQ()) {
                                final int ao2 = (int) (com.baidu.adp.lib.util.l.ao(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bca2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bca2, ao2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bca2 - 1, ao2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.bbQ().td(bca2);
                            }
                        }
                    } else {
                        PbActivity.this.fKT.bfk();
                    }
                    PbActivity.this.fKS.a(dVar.bar(), PbActivity.this.fLF);
                    PbActivity.this.fKS.a(PbActivity.this.fLG);
                } else if (str != null) {
                    if (!PbActivity.this.fLa && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fKS != null && PbActivity.this.fKS.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fKS.getAppealInfo().fGS)) {
                                    PbActivity.this.fKT.a(PbActivity.this.fKS.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fKT.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fKT.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.fKT.bfD();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fKS.bdl());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getForumId());
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
                        PbActivity.this.fKT.qw(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.fKT.qw("");
                    }
                    PbActivity.this.fKT.Eg();
                }
                PbActivity.this.bAw = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bbz().bdm() || PbActivity.this.bbz().getPbData().yA().yx() != 0 || PbActivity.this.bbz().bdH()) {
                    PbActivity.this.fLh = true;
                    return;
                }
                return;
            }
            PbActivity.this.fKS.sR(1);
            if (PbActivity.this.fKz != null) {
                PbActivity.this.fKz.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fKT.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.p.Ov().Ow()) {
                com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, PbActivity.this.bAo, PbActivity.this.createTime, PbActivity.this.bAw, z2, !z2 ? System.currentTimeMillis() - PbActivity.this.dpx : j);
                PbActivity.this.createTime = 0L;
                PbActivity.this.bAo = 0L;
                if (lVar != null) {
                    lVar.Oq();
                }
            }
        }
    };
    private CustomMessageListener fLT = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bbW();
            }
        }
    };
    private final a.InterfaceC0093a fLU = new a.InterfaceC0093a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0093a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fKT.bfg();
            if (z) {
                if (PbActivity.this.flD != null) {
                    PbActivity.this.flD.aL(z2);
                }
                PbActivity.this.fKS.kn(z2);
                if (PbActivity.this.fKS.vX()) {
                    PbActivity.this.bcg();
                } else {
                    PbActivity.this.fKT.n(PbActivity.this.fKS.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.flD != null && PbActivity.this.flD.wa() != null && PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().bat() != null && PbActivity.this.fKS.getPbData().bat().zn() != null) {
                        MarkData wa = PbActivity.this.flD.wa();
                        MetaData zn = PbActivity.this.fKS.getPbData().bat().zn();
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
                if (PbActivity.this.fKT != null) {
                    PbActivity.this.fKT.bfu();
                    if (PbActivity.this.fLg != null && !PbActivity.this.fKT.beL()) {
                        PbActivity.this.fKT.kK(PbActivity.this.fLg.LG());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fKT.beK();
                    }
                }
                if (!PbActivity.this.fKG) {
                    PbActivity.this.fKG = true;
                    PbActivity.this.fKT.bfz();
                }
            }
            PbActivity.this.fKT.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fKz != null) {
                PbActivity.this.fKz.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fKH == null) {
                PbActivity.this.fKH = new com.baidu.tbadk.k.d();
                PbActivity.this.fKH.ij(1001);
            }
            if (i == 0) {
                PbActivity.this.fKH.Oc();
            } else if (i == 1) {
                PbActivity.this.fKH.Oc();
            } else {
                PbActivity.this.fKH.Oc();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bav;
            if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKT != null && PbActivity.this.fKT.bfa() != null) {
                PbActivity.this.fKT.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fKz != null) {
                    PbActivity.this.fKz.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fKS.bdD() && (bav = PbActivity.this.fKS.getPbData().bav()) != null && !bav.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fKT.bfa().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fKS.getPbData();
                    if (pbData != null) {
                        if (pbData.baw() != null && pbData.baw().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bax() != null && pbData.bax().hasData()) {
                            headerCount--;
                        }
                        int size = bav.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cXQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cXM.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fKS.bdB();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.gal != 1002 || bVar.ecy) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fKT.a(1, dVar.aoo, dVar.hcV, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cXM.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fKT.a(PbActivity.this.cXM.getLoadDataMode(), gVar.aoo, gVar.hcV, false);
                        PbActivity.this.fKT.an(gVar.hcY);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fKT.a(PbActivity.this.cXM.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fLV = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final j.b bVa = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.j.b
        public void bw(boolean z) {
            if (PbActivity.this.bcm()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fKS.km(true)) {
                PbActivity.this.fKT.bfh();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fLX = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fLW && PbActivity.this.bcm()) {
                PbActivity.this.bco();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fKS.kl(false)) {
                    PbActivity.this.fKT.bff();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fKS.getPbData() != null) {
                    PbActivity.this.fKT.bfy();
                }
                PbActivity.this.fLW = true;
            }
        }
    };
    private int fLY = 0;
    private final TbRichTextView.h bLF = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fKT.b((TbRichText) view.getTag());
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
                    PbActivity.this.fKQ = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fMN) {
                    TbRichText az = PbActivity.this.az(str, i);
                    if (az != null && PbActivity.this.fLY >= 0 && PbActivity.this.fLY < az.Rh().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(az.Rh().get(PbActivity.this.fLY));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fMK.size()) {
                                break;
                            } else if (!cVar.fMK.get(i3).equals(b2)) {
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
                            concurrentHashMap.put(str2, cVar.fML.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fMM, cVar.lastId, PbActivity.this.fKS.bdz(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.f(cVar.fMK, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.E(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fML.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fMM, cVar.fMK.get(0), PbActivity.this.fKS.bdz(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fLZ = false;
    PostData fMa = null;
    private final b.InterfaceC0097b fMb = new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fMa != null) {
                if (i == 0) {
                    PbActivity.this.fMa.ck(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fMa = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fMa);
                }
            }
        }
    };
    private final b.InterfaceC0097b fMc = new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fLp != null && !TextUtils.isEmpty(PbActivity.this.fLq)) {
                if (i == 0) {
                    if (PbActivity.this.fLr == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fLq));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fLq;
                        aVar.pkgId = PbActivity.this.fLr.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fLr.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bQD == null) {
                        PbActivity.this.bQD = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bQD.DH();
                    PbActivity.this.bQD.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bQD.v(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fLo == null) {
                            PbActivity.this.fLo = new av(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fLo.j(PbActivity.this.fLq, PbActivity.this.fLp.sk());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fLp = null;
                PbActivity.this.fLq = null;
            }
        }
    };
    private final View.OnLongClickListener bmh = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.fLp = ((TbImageView) view).getBdImage();
                PbActivity.this.fLq = ((TbImageView) view).getUrl();
                if (PbActivity.this.fLp != null && !TextUtils.isEmpty(PbActivity.this.fLq)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fLr = null;
                    } else {
                        PbActivity.this.fLr = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fKT.a(PbActivity.this.fMc, PbActivity.this.fLp.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.fLp = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.fLq = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fLr = null;
                    } else {
                        PbActivity.this.fLr = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fKT.a(PbActivity.this.fMc, PbActivity.this.fLp.isGif());
                }
            } else if (view instanceof com.baidu.tbadk.widget.d) {
                if (((com.baidu.tbadk.widget.d) view).getBdImage() != null) {
                    PbActivity.this.fLp = ((com.baidu.tbadk.widget.d) view).getBdImage();
                    if (!TextUtils.isEmpty(((com.baidu.tbadk.widget.d) view).getBdImage().getUrl())) {
                        PbActivity.this.fLq = ((com.baidu.tbadk.widget.d) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fLr = null;
                    } else {
                        PbActivity.this.fLr = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fKT.a(PbActivity.this.fMc, PbActivity.this.fLp.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fMa = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fMa != null && PbActivity.this.flD != null) {
                        PbActivity.this.fKT.a(PbActivity.this.fMb, PbActivity.this.flD.vX() && PbActivity.this.fMa.getId() != null && PbActivity.this.fMa.getId().equals(PbActivity.this.fKS.zx()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dCs = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (!PbActivity.this.fKB && z && !PbActivity.this.fKS.bdt()) {
                PbActivity.this.bci();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener bDk = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
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
                    if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.e) && ((com.baidu.tieba.pb.view.e) childAt2).atw()) {
                        break;
                    }
                }
            }
            PbActivity.this.coc.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0143a cod = new a.InterfaceC0143a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        final int cKa;

        {
            this.cKa = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aY(int i, int i2) {
            if (af(i2) && PbActivity.this.fKT != null && PbActivity.this.fKz != null) {
                PbActivity.this.fKT.bfE();
                PbActivity.this.fKz.fW(false);
                PbActivity.this.fKz.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aZ(int i, int i2) {
            if (af(i2) && PbActivity.this.fKT != null && PbActivity.this.fKz != null) {
                PbActivity.this.fKz.fW(true);
                if (Math.abs(i2) > this.cKa) {
                    PbActivity.this.fKz.hideFloatingView();
                }
                if (PbActivity.this.bcm()) {
                    PbActivity.this.fKT.beW();
                    PbActivity.this.fKT.beX();
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
    private final b.a fMd = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.e.b.a
        public void fr(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bbp();
            } else {
                com.baidu.tieba.pb.a.b.bbo();
            }
        }
    };
    private String fMe = null;
    private final m.a fMf = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void i(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fMe = str2;
                PbActivity.this.fKT.qx(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fMg = -1;
    private int fMh = -1;
    private CustomMessageListener fMk = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.aJJ == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0095a) {
                    if (aVar.aJK != null && !aVar.aJK.hasError() && aVar.aJK.getError() == 0) {
                        if (PbActivity.this.fKT != null) {
                            PbActivity.this.fKT.y(((a.C0095a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bcx();
                        }
                    } else if (z) {
                        if (aVar.aJK != null && aVar.aJK.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aJK.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.aJK != null && !aVar.aJK.hasError() && aVar.aJK.getError() == 0) {
                        if (PbActivity.this.fKT != null && PbActivity.this.fKT != null) {
                            PbActivity.this.fKT.y(((a.C0095a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.aJK != null && aVar.aJK.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aJK.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.aJK == null || aVar.aJK.hasError() || aVar.aJK.getError() != 0) {
                        if (z) {
                            if (aVar.aJK != null && aVar.aJK.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.aJK.getErrorString());
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
    private final CustomMessageListener dFp = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "pb"));
                    com.baidu.tbadk.core.util.aw.Dt().c(PbActivity.this.getPageContext(), new String[]{str});
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
        public ArrayList<String> fMK;
        public ConcurrentHashMap<String, ImageUrlData> fML;
        public boolean fMN;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fMM = false;
        public boolean fMO = false;
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

    public com.baidu.tbadk.editortools.pb.d bbL() {
        return this.fLg;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        if (kVar.bbc() != null) {
            String id = kVar.bbc().getId();
            ArrayList<PostData> bav = this.fKS.getPbData().bav();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bav.size()) {
                    break;
                }
                PostData postData = bav.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> bbg = kVar.bbg();
                    postData.vL(kVar.getTotalCount());
                    if (postData.bwQ() != null && bbg != null) {
                        Iterator<PostData> it = bbg.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.zn() != null && (metaData = postData.getUserMap().get(next.zn().getUserId())) != null) {
                                next.a(metaData);
                                next.mJ(true);
                                next.b(getPageContext(), this.fKS.qr(metaData.getUserId()));
                            }
                        }
                        postData.bwQ().clear();
                        postData.bwQ().addAll(bbg);
                    }
                    if (postData.bwM() != null) {
                        postData.bwN();
                    }
                }
            }
            if (!this.fKS.getIsFromMark()) {
                this.fKT.n(this.fKS.getPbData());
            }
            c(kVar);
        }
    }

    public void bbM() {
        com.baidu.tieba.pb.data.d pbData;
        bd bat;
        if (!this.fLI) {
            if (!com.baidu.adp.lib.util.l.pa()) {
                showToast(d.j.no_network_guide);
            } else if (this.fLL) {
                this.fLI = true;
                if (this.fKS != null && (pbData = this.fKS.getPbData()) != null && (bat = pbData.bat()) != null) {
                    int isLike = bat.zc() == null ? 0 : bat.zc().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10796").ab("tid", bat.getId()));
                    }
                    if (this.fLJ != null) {
                        this.fLJ.a(bat.zE(), bat.getId(), isLike, "pb");
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
                                    PbActivity.this.fKT.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fLm);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fLm);
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
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fLm);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fLm);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3);
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).AX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(int i) {
        bd bat;
        String str;
        String H;
        if (this.fKS != null && this.fKS.getPbData() != null && (bat = this.fKS.getPbData().bat()) != null) {
            if (i == 1) {
                PraiseData zc = bat.zc();
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
                        bat.a(praiseData);
                    } else {
                        bat.zc().getUser().add(0, metaData);
                        bat.zc().setNum(bat.zc().getNum() + 1);
                        bat.zc().setIsLike(i);
                    }
                }
                if (bat.zc() != null) {
                    if (bat.zc().getNum() < 1) {
                        H = getResources().getString(d.j.zan);
                    } else {
                        H = com.baidu.tbadk.core.util.am.H(bat.zc().getNum());
                    }
                    this.fKT.Q(H, true);
                }
            } else if (bat.zc() != null) {
                bat.zc().setIsLike(i);
                bat.zc().setNum(bat.zc().getNum() - 1);
                ArrayList<MetaData> user = bat.zc().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bat.zc().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bat.zc().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = bat.zc().getNum() + "";
                }
                this.fKT.Q(str, false);
            }
            if (this.fKS.bdm()) {
                this.fKT.bfa().notifyDataSetChanged();
            } else {
                this.fKT.o(this.fKS.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fKS.D(bundle);
        if (this.dEk != null) {
            this.dEk.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fLg.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fLk = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.dpx = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fKM = intent.getStringExtra("from");
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fKM)) {
                this.fKA = true;
            }
            this.fMg = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fMh = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fMi = intent.getStringExtra("key_manga_title");
            this.fLc = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fLd = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bcm()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.am.isEmpty(this.source) ? "" : this.source;
            this.fLt = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.dpx = System.currentTimeMillis();
        }
        this.fKF = System.currentTimeMillis();
        this.bAo = this.fKF - this.dpx;
        super.onCreate(bundle);
        this.fKD = 0;
        C(bundle);
        if (this.fKS != null && this.fKS.getPbData() != null) {
            this.fKS.getPbData().qk(this.source);
        }
        initUI();
        if (intent != null && this.fKT != null) {
            this.fKT.fTx = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fLn == null) {
                    this.fLn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fKT.qz("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fLn, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fKS != null && this.fKS.getPbData() != null) {
                this.fKS.qu(stringExtra);
            }
        }
        this.dEk = new VoiceManager();
        this.dEk.onCreate(getPageContext());
        initData(bundle);
        this.fLf = new com.baidu.tbadk.editortools.pb.g();
        bbN();
        this.fLg = (com.baidu.tbadk.editortools.pb.d) this.fLf.bd(getActivity());
        this.fLg.b(this);
        this.fLg.a(this.buj);
        this.fLg.a(this.bub);
        this.fLg.a(this, bundle);
        this.fLg.Lb().c(new com.baidu.tbadk.editortools.q(getActivity()));
        this.fLg.Lb().cf(true);
        jV(true);
        this.fKT.setEditorTools(this.fLg.Lb());
        this.fLg.a(this.fKS.bdv(), this.fKS.bdl(), this.fKS.bdO());
        registerListener(this.fLA);
        if (!this.fKS.bds()) {
            this.fLg.gw(this.fKS.bdl());
        }
        if (this.fKS.bdP()) {
            this.fLg.gu(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fLg.gu(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.createTime = System.currentTimeMillis() - this.fKF;
        registerListener(this.fLz);
        registerListener(this.fLB);
        registerListener(this.fLC);
        registerListener(this.dFm);
        registerListener(this.fLQ);
        registerListener(this.fLy);
        this.fLe = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.hab);
        this.fLe.bwv();
        registerListener(this.fLE);
        registerListener(this.mAttentionListener);
        if (this.fKS != null) {
            this.fKS.bdF();
        }
        registerListener(this.fLT);
        registerListener(this.fMk);
        registerListener(this.dFu);
        if (this.fKT != null && this.fKT.bfI() != null && this.fKT.bfJ() != null) {
            this.fKz = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.fKT.bfI(), this.fKT.bfJ(), this.fKT.beR());
            this.fKz.a(this.fLM);
        }
        if (this.fKy && this.fKT != null && this.fKT.bfJ() != null) {
            this.fKT.bfJ().setVisibility(8);
        }
        this.fLl = new com.baidu.tbadk.core.view.e();
        this.fLl.baV = 1000L;
        registerListener(this.fLP);
        registerListener(this.fLN);
        registerListener(this.fLO);
        this.fLm = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fLm;
        userMuteAddAndDelCustomMessage.setTag(this.fLm);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fLm;
        userMuteCheckCustomMessage.setTag(this.fLm);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fKS.bdM().a(this.cAq);
        if ("from_tieba_kuang".equals(this.fKM)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 2).ab("tid", this.fKS.bdl()));
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
        this.fKY = new at();
        if (this.fLg.LA() != null) {
            this.fKY.g(this.fLg.LA().getInputView());
        }
        this.fLg.a(this.buc);
        this.dQS = new ShareSuccessReplyToServerModel();
        a(this.fLv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbN() {
        if (this.fLf != null && this.fKS != null) {
            this.fLf.setForumName(this.fKS.bdk());
            if (this.fKS.getPbData() != null && this.fKS.getPbData().bar() != null) {
                this.fLf.setForumId(this.fKS.getPbData().bar().getId());
            }
            this.fLf.setFrom("pb");
            this.fLf.a(this.fKS);
        }
    }

    public String bbO() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b bbP() {
        return this.fKz;
    }

    private void jV(boolean z) {
        this.fLg.cj(z);
        this.fLg.ck(z);
        this.fLg.cl(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().baQ() && !z && this.fKT != null && this.fKT.getView() != null) {
            this.fKT.getView().setSystemUiVisibility(4);
        }
        this.fLi = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dEk != null) {
            this.dEk.onStart(getPageContext());
        }
    }

    public ar bbQ() {
        return this.fKT;
    }

    public PbModel bbz() {
        return this.fKS;
    }

    public void ql(String str) {
        if (this.fKS != null && !StringUtils.isNull(str) && this.fKT != null) {
            this.fKT.kO(true);
            this.fKS.ql(str);
            this.fKL = true;
            this.fKT.bfu();
            this.fKT.bfD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fKB = false;
        } else {
            this.fKB = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fKD = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fKD == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dEk != null) {
            this.dEk.onPause(getPageContext());
        }
        if (this.fKT != null) {
            this.fKT.onPause();
        }
        if (!this.fKS.bds()) {
            this.fLg.gv(this.fKS.bdl());
        }
        if (this.fKS != null) {
            this.fKS.bdG();
        }
        MessageManager.getInstance().unRegisterListener(this.ewO);
        aDJ();
        MessageManager.getInstance().unRegisterListener(this.fLN);
        MessageManager.getInstance().unRegisterListener(this.fLO);
        MessageManager.getInstance().unRegisterListener(this.fLP);
        MessageManager.getInstance().unRegisterListener(this.dFp);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bbR() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fKS.getPbData(), this.fKS.bdm(), this.fKS.getRequestType());
        return (a2 == null || a2.zn() == null || a2.zn().getGodUserData() == null || a2.zn().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fKB = false;
        super.onResume();
        if (this.fKO) {
            this.fKO = false;
            bcs();
        }
        if (bbR()) {
            this.fKI = System.currentTimeMillis();
        } else {
            this.fKI = -1L;
        }
        if (this.fKT != null && this.fKT.getView() != null) {
            if (!this.fom) {
                bcj();
            } else {
                hideLoadingView(this.fKT.getView());
            }
            this.fKT.onResume();
        }
        if (this.fKD == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fKT != null) {
            noNetworkView = this.fKT.beG();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.oJ()) {
            noNetworkView.bt(false);
        }
        if (this.dEk != null) {
            this.dEk.onResume(getPageContext());
        }
        registerListener(this.ewO);
        this.fLb = false;
        bcr();
        registerListener(this.fLN);
        registerListener(this.fLO);
        registerListener(this.fLP);
        registerListener(this.dFp);
        if (this.dEQ) {
            bci();
            this.dEQ = false;
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
        this.fKT.kD(z);
        if (this.fKZ != null) {
            this.fKZ.kp(z);
        }
        if (z && this.fLb) {
            this.fKT.bff();
            this.fKS.kl(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fKI > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10804").ab("obj_duration", (System.currentTimeMillis() - this.fKI) + ""));
            this.fKI = 0L;
        }
        if (bbQ().beJ() != null) {
            bbQ().beJ().onStop();
        }
        if (this.fKT.fTE != null && !this.fKT.fTE.ame()) {
            this.fKT.fTE.aPb();
        }
        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().bar() != null && this.fKS.getPbData().bat() != null) {
            com.baidu.tbadk.distribute.a.KL().a(getPageContext().getPageActivity(), "pb", this.fKS.getPbData().bar().getId(), com.baidu.adp.lib.g.b.c(this.fKS.getPbData().bat().getId(), 0L));
        }
        if (this.dEk != null) {
            this.dEk.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.fKG && this.fKT != null) {
            this.fKG = true;
            this.fKT.bfz();
            a(false, (PostData) null);
        }
        if (this.fKS != null) {
            this.fKS.cancelLoadData();
            this.fKS.destory();
            if (this.fKS.bdL() != null) {
                this.fKS.bdL().onDestroy();
            }
        }
        if (this.fLg != null) {
            this.fLg.onDestroy();
        }
        if (this.cXM != null) {
            this.cXM.cancelLoadData();
        }
        if (this.fKT != null) {
            this.fKT.onDestroy();
            if (this.fKT.fTE != null) {
                this.fKT.fTE.aPb();
            }
        }
        if (this.fKH != null) {
            this.fKH.onDestroy();
        }
        if (this.fKz != null) {
            this.fKz.Pj();
        }
        super.onDestroy();
        if (this.dEk != null) {
            this.dEk.onDestory(getPageContext());
        }
        this.fKT.bfu();
        MessageManager.getInstance().unRegisterListener(this.fLN);
        MessageManager.getInstance().unRegisterListener(this.fLO);
        MessageManager.getInstance().unRegisterListener(this.fLP);
        MessageManager.getInstance().unRegisterListener(this.fLm);
        MessageManager.getInstance().unRegisterListener(this.fLQ);
        MessageManager.getInstance().unRegisterListener(this.dFu);
        this.fLk = null;
        this.fLl = null;
        com.baidu.tieba.recapp.d.a.boR().boT();
        if (this.fLn != null) {
            getSafeHandler().removeCallbacks(this.fLn);
        }
        if (this.fKP != null) {
            this.fKP.cancelLoadData();
        }
        if (this.fKT != null && this.fKT.fTE != null) {
            this.fKT.fTE.bgn();
        }
        if (this.dQS != null) {
            this.dQS.cancelLoadData();
        }
        this.fKY.onDestroy();
        if (this.dEU != null) {
            this.dEU.onDestroy();
        }
        if (this.fKS != null && this.fKS.bdN() != null) {
            this.fKS.bdN().onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bfa;
        ArrayList<PostData> bcN;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.Ft() && this.fKT != null && (bfa = this.fKT.bfa()) != null && (bcN = bfa.bcN()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bcN.iterator();
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
                        bVar.bCT = id;
                        bVar.cZC = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aPd == 1 && !TextUtils.isEmpty(id)) {
                    next.aPd = 2;
                    a.b bVar2 = new a.b();
                    bVar2.bCT = id;
                    bVar2.cZC = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fKS == null || this.fKS.getPbData() == null || this.fKS.getPbData().bar() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fKS.getPbData().bar().getFirst_class();
                    str2 = this.fKS.getPbData().bar().getSecond_class();
                    str = this.fKS.getPbData().bar().getId();
                    str4 = this.fKS.bdl();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Fw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fKT.onChangeSkinType(i);
            if (this.fLg != null && this.fLg.Lb() != null) {
                this.fLg.Lb().onChangeSkinType(i);
            }
            if (this.fKT.beG() != null) {
                this.fKT.beG().onChangeSkinType(getPageContext(), i);
            }
            this.fKY.onChangeSkinType();
            if (this.dEU != null) {
                this.dEU.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fKT = new ar(this, this.dFR, this.bLG);
        this.coc = new com.baidu.tieba.e.b(getActivity());
        this.coc.a(this.fMd);
        this.coc.a(this.cod);
        this.fKT.setOnScrollListener(this.mOnScrollListener);
        this.fKT.d(this.fLX);
        this.fKT.a(this.bVa);
        this.fKT.jP(com.baidu.tbadk.core.i.xo().xu());
        this.fKT.setOnImageClickListener(this.bLF);
        this.fKT.a(this.bmh);
        this.fKT.h(this.dCs);
        this.fKT.a(this.fLV);
        this.fKT.kD(this.mIsLogin);
        if (getIntent() != null) {
            this.fKT.setIsInterviewLive(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cp(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.haC && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.xo().xu()) {
                    return qo(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fKS == null || this.fKS.getPbData() == null) {
                        return true;
                    }
                    if (bbQ().beJ() != null) {
                        bbQ().beJ().bcW();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.b(this.fKS.getPbData().bar());
                    kVar.T(this.fKS.getPbData().bat());
                    kVar.d(postData);
                    bbQ().beI().d(kVar);
                    bbQ().beI().setPostId(postData.getId());
                    a(view, postData.zn().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fLg != null) {
                        this.fKT.kK(this.fLg.LG());
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
        if (this.fKT != null) {
            if (z && !this.fom) {
                bcj();
            } else {
                hideLoadingView(this.fKT.getView());
            }
            if (z && this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().baQ() && this.fKT.getView() != null) {
                this.fKT.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void bbS() {
        if (this.fKE == null) {
            this.fKE = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fKE.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fKt = PbActivity.this.fKt.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKt);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fKS.bdl(), PbActivity.this.fKt, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fKt = PbActivity.this.fKt.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKt);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fKS.bdl(), PbActivity.this.fKt, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fKt = PbActivity.this.fKt.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKt);
                        bVar.dismiss();
                    }
                }
            }).ff(b.a.aRz).fg(17).d(getPageContext());
        }
    }

    private void C(Bundle bundle) {
        this.fKS = new PbModel(this);
        this.fKS.a(this.fLS);
        if (this.fKS.bdJ() != null) {
            this.fKS.bdJ().a(this.fMf);
        }
        if (this.fKS.bdI() != null) {
            this.fKS.bdI().a(this.fLD);
        }
        if (this.fKS.bdL() != null) {
            this.fKS.bdL().b(this.fLx);
        }
        if (bundle != null) {
            this.fKS.initWithBundle(bundle);
        } else {
            this.fKS.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fKS.ko(true);
        }
        ai.bet().P(this.fKS.bdj(), this.fKS.getIsFromMark());
        if (StringUtils.isNull(this.fKS.bdl())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fKM)) {
            this.fKS.sY(6);
        }
        if (this.fKS.bdK() != null) {
            this.fKS.bdK().a(this.fLw);
        }
        if (this.fKS.bdN() != null) {
            this.fKS.bdN().a(this.dEW);
        }
        this.fKS.Nv();
    }

    private void initData(Bundle bundle) {
        this.flD = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.flD != null) {
            this.flD.a(this.fLU);
        }
        this.cXM = new ForumManageModel(this);
        this.cXM.setLoadDataCallBack(this.cXQ);
        this.bfq = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fKT.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void ak(Object obj) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fKS.getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fKS.getPbData().bar().getId(), PbActivity.this.fKS.getPbData().bar().getName(), PbActivity.this.fKS.getPbData().bat().getId(), valueOf, str, str2)));
            }
        });
        this.fLJ.setUniqueId(getUniqueId());
        this.fLJ.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fKT.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fLm;
        userMuteCheckCustomMessage.setTag(this.fLm);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bbT() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fKS != null && (pbData = this.fKS.getPbData()) != null) {
            return pbData.baE().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bat() != null) {
            if (dVar.bat().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bat().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bat().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData cq(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bxg()) {
                postData.cQ(postData.bxf() - 1);
            } else {
                postData.cQ(postData.bxf() + 1);
            }
            postData.mK(!postData.bxg());
            ((PbFloorAgreeView) view).a(postData.bxg(), postData.bxf(), true);
            final int i = postData.bxg() ? 0 : 1;
            this.fKS.bdK().a(postData.getId(), i, new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
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

    public com.baidu.tbadk.core.util.ak bbU() {
        return new com.baidu.tbadk.core.util.ak("c12003").ab("tid", this.fKS.fPG).s("obj_type", 0).ab(ImageViewerConfig.FORUM_ID, this.fKS.getForumId()).s("obj_param1", this.fKS.getPbData().bat().getThreadType() == 40 ? 2 : 1);
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
                        PbActivity.this.bbQ().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bbQ().beJ() != null) {
                        PbActivity.this.fLg.Lb().setVisibility(8);
                        PbActivity.this.bbQ().beJ().bG(str, str2);
                        com.baidu.tbadk.editortools.pb.h bdc = PbActivity.this.bbQ().beJ().bdc();
                        if (bdc != null && PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null) {
                            bdc.a(PbActivity.this.fKS.getPbData().yn());
                        }
                        if (PbActivity.this.fKY.bfU() == null && PbActivity.this.bbQ().beJ().bdc().Ma() != null) {
                            PbActivity.this.bbQ().beJ().bdc().Ma().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fKY != null && PbActivity.this.fKY.bfT() != null) {
                                        if (!PbActivity.this.fKY.bfT().bFE()) {
                                            PbActivity.this.fKY.kQ(false);
                                        }
                                        PbActivity.this.fKY.bfT().nB(false);
                                    }
                                }
                            });
                            PbActivity.this.fKY.h(PbActivity.this.bbQ().beJ().bdc().Ma().getInputView());
                            PbActivity.this.bbQ().beJ().bdc().a(PbActivity.this.fLj);
                        }
                    }
                    PbActivity.this.bbQ().bfD();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.fKS != null && this.fKS.getPbData() != null && postData.bwT() > 1) {
            String bdl = this.fKS.bdl();
            String id = postData.getId();
            int baF = this.fKS.getPbData() != null ? this.fKS.getPbData().baF() : 0;
            c qp = qp(id);
            if (qp != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bdl, id, "pb", true, null, false, null, baF, postData.bgZ(), this.fKS.getPbData().yn(), false, postData.zn() != null ? postData.zn().getIconInfo() : null).addBigImageData(qp.fMK, qp.fML, qp.fMM, qp.index);
                addBigImageData.setKeyPageStartFrom(this.fKS.bdR());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ao aoVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.pa()) {
                showToast(d.j.no_network_guide);
            } else if (bbz() != null && bbz().getPbData() != null && bbz().getPbData().baP() != null) {
                com.baidu.tieba.pb.data.j baP = bbz().getPbData().baP();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ao)) {
                    aoVar = null;
                } else {
                    aoVar = (ao) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (baP != null) {
                    int i3 = -1;
                    if (z) {
                        baP.sB(i);
                    } else if (baP.baW()) {
                        baP.baZ();
                        i3 = 1;
                    } else {
                        baP.sD(i);
                        i3 = 0;
                    }
                    baP.sC(i2);
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
                    if (this.fKS != null && this.fKS.bdK() != null) {
                        String str = "";
                        if (this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null) {
                            str = this.fKS.getPbData().bat().zE();
                        }
                        if (this.fKS.getPbData() != null) {
                            this.fKS.getPbData().a(baP);
                        }
                        if (z) {
                            this.fKS.bdK().a(str, 3, i, this.fKS.getForumId(), aVar);
                        } else {
                            this.fKS.bdK().a(str, i3, 3, i, this.fKS.getForumId(), aVar);
                            com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i();
                            iVar.fHM = i3;
                            iVar.fHN = baP;
                            iVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016551, iVar));
                        }
                    }
                    if (aoVar != null) {
                        aoVar.b(baP);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bbV() {
        if (this.fKS.getPbData() == null || this.fKS.getPbData().bat() == null) {
            return -1;
        }
        return this.fKS.getPbData().bat().zR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbW() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.sg(this.fKS.getForumId()) && this.fKS.getPbData() != null && this.fKS.getPbData().bar() != null) {
            if (this.fKS.getPbData().bar().isLike() == 1) {
                this.fKS.bdN().bW(this.fKS.getForumId(), this.fKS.bdl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jW(boolean z) {
        if (this.fKS == null || this.fKS.getPbData() == null) {
            return false;
        }
        return ((this.fKS.getPbData().baF() != 0) || this.fKS.getPbData().bat() == null || this.fKS.getPbData().bat().zn() == null || TextUtils.equals(this.fKS.getPbData().bat().zn().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bbX() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.o.q.OO()) {
            return "";
        }
        PostData baA = baA();
        if (this.fKS == null || (pbData = this.fKS.getPbData()) == null || pbData.getUserData() == null || pbData.bat() == null || baA == null || baA.zn() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !baA.zn().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bat().yX() == 0) {
            return "";
        }
        if (pbData.bat().yX() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean jX(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fKS == null || this.fKS.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fKS.getPbData();
        if (pbData.baF() == 0) {
            List<com.baidu.tbadk.core.data.ay> baN = pbData.baN();
            if (com.baidu.tbadk.core.util.v.D(baN) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : baN) {
                    if (ayVar != null && (tVar = ayVar.aOa) != null && tVar.aMi && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean jY(boolean z) {
        return (z || this.fKS == null || this.fKS.getPbData() == null || this.fKS.getPbData().baF() == 0) ? false : true;
    }

    public void bbY() {
        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null && this.fKS.getPbData().bat().zn() != null) {
            if (this.fKT != null) {
                this.fKT.beH();
            }
            bd bat = this.fKS.getPbData().bat();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bat.zn().getUserId());
            aa aaVar = new aa();
            int baF = this.fKS.getPbData().baF();
            if (baF == 1) {
                aaVar.fRH = true;
                aaVar.fRG = true;
                aaVar.fRO = bat.zi() == 1;
                aaVar.fRN = bat.zj() == 1;
            } else {
                aaVar.fRH = false;
                aaVar.fRG = false;
            }
            if (baF == 1002 && !equals) {
                aaVar.fRS = true;
            }
            aaVar.fRD = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            aaVar.fRI = jX(equals);
            aaVar.fRJ = bbZ();
            aaVar.fRK = jY(equals);
            aaVar.fRE = this.fKS.bdm();
            aaVar.fRF = true;
            aaVar.fIc = this.flD != null && this.flD.vX();
            aaVar.fRC = jW(equals);
            aaVar.fRQ = bbX();
            aaVar.fRB = equals && this.fKT.bfn();
            aaVar.fRL = TbadkCoreApplication.getInst().getSkinType() == 1;
            aaVar.fRM = true;
            aaVar.isHostOnly = this.fKS.getHostMode();
            aaVar.fRP = true;
            if (bat.zF() == null) {
                aaVar.fRR = true;
            } else {
                aaVar.fRR = false;
            }
            this.fKT.fTE.a(aaVar);
        }
    }

    private boolean bbZ() {
        if (this.fKS != null && this.fKS.bdm()) {
            return this.fKS.aEo() == null || this.fKS.aEo().yx() != 0;
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

    public int bca() {
        if (bbQ() == null || bbQ().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bbQ().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) iVar).mType == com.baidu.tieba.pb.data.h.fHI) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bcb() {
        if (bbQ() == null || bbQ().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bbQ().getListView();
        List<com.baidu.adp.widget.ListView.i> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = data.get(i);
            if ((iVar instanceof PostData) && iVar.getType() == PostData.haB) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bci();
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
                    PbActivity.this.bfq.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fKS.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).AU();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fKT.bfg();
        this.fKS.kn(z);
        if (this.flD != null) {
            this.flD.aL(z);
            if (markData != null) {
                this.flD.a(markData);
            }
        }
        if (this.fKS.vX()) {
            bcg();
        } else {
            this.fKT.n(this.fKS.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sG(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(String str) {
        if (!StringUtils.isNull(str) && this.fKS != null) {
            String bdl = this.fKS.bdl();
            String id = this.fKS.getPbData().bar().getId();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(d.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + id + "&tid=" + bdl + "&pid=" + str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fKS.bds()) {
                    antiData.setBlock_forum_name(this.fKS.getPbData().bar().getName());
                    antiData.setBlock_forum_id(this.fKS.getPbData().bar().getId());
                    antiData.setUser_name(this.fKS.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fKS.getPbData().getUserData().getUserId());
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", aq.a.aXw));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", aq.a.aXw));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", aq.a.aXw));
            }
        } else if (i == 230277) {
            gC(str);
        } else {
            this.fKT.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.fKT.a(0, bVar.aoo, bVar.hcV, z);
            if (bVar.aoo) {
                if (bVar.hcT == 1) {
                    ArrayList<PostData> bav = this.fKS.getPbData().bav();
                    int size = bav.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bav.get(i).getId())) {
                            i++;
                        } else {
                            bav.remove(i);
                            break;
                        }
                    }
                    this.fKT.n(this.fKS.getPbData());
                } else if (bVar.hcT == 0) {
                    bcc();
                } else if (bVar.hcT == 2) {
                    ArrayList<PostData> bav2 = this.fKS.getPbData().bav();
                    int size2 = bav2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bav2.get(i2).bwQ().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bav2.get(i2).bwQ().get(i3).getId())) {
                                i3++;
                            } else {
                                bav2.get(i2).bwQ().remove(i3);
                                bav2.get(i2).bwS();
                                z2 = true;
                                break;
                            }
                        }
                        bav2.get(i2).sM(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fKT.n(this.fKS.getPbData());
                    }
                    a(bVar, this.fKT);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fKT.a(this.cXM.getLoadDataMode(), gVar.aoo, gVar.hcV, false);
            if (gVar.aoo) {
                this.fKV = true;
                if (i == 2 || i == 3) {
                    this.fKW = true;
                    this.fKX = false;
                } else if (i == 4 || i == 5) {
                    this.fKW = false;
                    this.fKX = true;
                }
                if (i == 2) {
                    this.fKS.getPbData().bat().eS(1);
                    this.fKS.setIsGood(1);
                } else if (i == 3) {
                    this.fKS.getPbData().bat().eS(0);
                    this.fKS.setIsGood(0);
                } else if (i == 4) {
                    this.fKS.getPbData().bat().eR(1);
                    this.fKS.lO(1);
                } else if (i == 5) {
                    this.fKS.getPbData().bat().eR(0);
                    this.fKS.lO(0);
                }
                this.fKT.c(this.fKS.getPbData(), this.fKS.bdm());
            }
        }
    }

    private void bcc() {
        if (this.fKS.bdn() || this.fKS.bdp()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fKS.bdl());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fKS.bdl()));
        if (bch()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcd() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData baC;
        boolean z = false;
        if (this.fKT != null) {
            this.fKT.bfu();
        }
        if (this.fKS != null && this.fKS.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fKS.getPbData().bat().getId();
            if (this.fKS.isShareThread() && this.fKS.getPbData().bat().aQl != null) {
                historyMessage.threadName = this.fKS.getPbData().bat().aQl.showText;
            } else {
                historyMessage.threadName = this.fKS.getPbData().bat().getTitle();
            }
            if (this.fKS.isShareThread() && !bcz()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fKS.getPbData().bar().getName();
            }
            ArrayList<PostData> bav = this.fKS.getPbData().bav();
            int bfi = this.fKT != null ? this.fKT.bfi() : 0;
            if (bav != null && bfi >= 0 && bfi < bav.size()) {
                historyMessage.postID = bav.get(bfi).getId();
            }
            historyMessage.isHostOnly = this.fKS.getHostMode();
            historyMessage.isSquence = this.fKS.bdm();
            historyMessage.isShareThread = this.fKS.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fLg != null) {
            this.fLg.onDestroy();
        }
        if (this.fKC && bbQ() != null) {
            bbQ().bfN();
        }
        if (this.fKS != null && (this.fKS.bdn() || this.fKS.bdp())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fKS.bdl());
            if (this.fKV) {
                if (this.fKX) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fKS.bdr());
                }
                if (this.fKW) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fKS.getIsGood());
                }
            }
            if (this.fKS.getPbData() != null && System.currentTimeMillis() - this.fKF >= 40000 && (baC = this.fKS.getPbData().baC()) != null && !com.baidu.tbadk.core.util.v.E(baC.getDataList())) {
                intent.putExtra("guess_like_data", baC);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fLt);
            }
            setResult(-1, intent);
        }
        if (bch()) {
            if (this.fKS != null && this.fKT != null && this.fKT.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fKS.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.baz() && !this.fKL) {
                        ai bet = ai.bet();
                        com.baidu.tieba.pb.data.d pbData2 = this.fKS.getPbData();
                        Parcelable onSaveInstanceState = this.fKT.getListView().onSaveInstanceState();
                        boolean bdm = this.fKS.bdm();
                        boolean hostMode = this.fKS.getHostMode();
                        if (this.fKT.beR() != null && this.fKT.beR().getVisibility() == 0) {
                            z = true;
                        }
                        bet.a(pbData2, onSaveInstanceState, bdm, hostMode, z);
                        if (this.fLs >= 0 || this.fKS.bdT() != null) {
                            ai.bet().j(this.fKS.bdT());
                            ai.bet().i(this.fKS.bdU());
                            ai.bet().ta(this.fKS.bdV());
                        }
                    }
                }
            } else {
                ai.bet().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fKT == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fKT.te(i)) {
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
            this.fKT.beH();
            this.fKT.beJ().bcW();
            this.fKT.kM(false);
        }
        this.fKT.beK();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fLg.resetData();
                        this.fLg.b(writeData);
                        this.fLg.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.r hI = this.fLg.Lb().hI(6);
                        if (hI != null && hI.bsj != null) {
                            hI.bsj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fLg.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fKT.beJ() != null && this.fKT.beJ().bda() != null) {
                            com.baidu.tbadk.editortools.pb.h bda = this.fKT.beJ().bda();
                            bda.b(writeData);
                            bda.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.r hI2 = bda.Lb().hI(6);
                            if (hI2 != null && hI2.bsj != null) {
                                hI2.bsj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bda.LS();
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
        this.fLg.onActivityResult(i, i2, intent);
        if (this.fKP != null) {
            this.fKP.onActivityResult(i, i2, intent);
        }
        if (bbQ().beJ() != null) {
            bbQ().beJ().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bcf();
                    return;
                case 13008:
                    ai.bet().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fKS != null) {
                                PbActivity.this.fKS.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 23003:
                    if (intent != null && this.fKS != null) {
                        a(bce(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    L(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        bbW();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dQS != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dQS.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void HQ() {
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
                    this.fKT.jU(false);
                    if (this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null && this.fKS.getPbData().bat().zI() != null) {
                        this.fKS.getPbData().bat().zI().setStatus(2);
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
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fKT != null && this.fKT.fTE != null) {
                        this.fKT.fTE.wH();
                        this.fKT.fTE.bgh();
                        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null) {
                            this.fKS.getPbData().bat().eN(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fKQ != null) {
                        this.fKT.cz(this.fKQ);
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
            if (this.fKP == null) {
                this.fKP = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fKP.b(this.bub);
                this.fKP.c(this.buj);
            }
            this.fKP.a(emotionImageData, bbz(), bbz().getPbData());
        }
    }

    private ShareFromPBMsgData bce() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bY = this.fKS.getPbData().bY(getPageContext().getPageActivity());
        PostData beM = this.fKT.beM();
        String str = "";
        if (beM != null) {
            str = beM.getId();
            String cl = beM.cl(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(cl)) {
                bY[1] = cl;
            }
        }
        String zE = this.fKS.getPbData().bat().zE();
        if (zE != null && zE.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bY[1]);
        shareFromPBMsgData.setImageUrl(bY[0]);
        shareFromPBMsgData.setForumName(this.fKS.getPbData().bar().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fKS.getPbData().bat().getId());
        shareFromPBMsgData.setTitle(this.fKS.getPbData().bat().getTitle());
        return shareFromPBMsgData;
    }

    private void L(Intent intent) {
        a(bce(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null) {
                        com.baidu.tbadk.core.util.ak ab = new com.baidu.tbadk.core.util.ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_param1", 3).ab(ImageViewerConfig.FORUM_ID, PbActivity.this.fKS.getForumId()).ab("tid", PbActivity.this.fKS.bdl());
                        if (PbActivity.this.e(PbActivity.this.fKS.getPbData()) != 0) {
                            ab.s("obj_type", PbActivity.this.e(PbActivity.this.fKS.getPbData()));
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
            aVar.b(getPageContext()).AU();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.G(shareFromPBMsgData.getImageUrl(), this.fKS.getPbData().baG() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final int i, final String str, final long j) {
        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null) {
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
            aVar.b(getPageContext()).AU();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.G(shareFromPBMsgData.getImageUrl(), this.fKS.getPbData().baG() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcf() {
        MarkData sX;
        if (this.flD != null && (sX = this.fKS.sX(this.fKT.bfj())) != null) {
            if (!sX.isApp() || (sX = this.fKS.sX(this.fKT.bfj() + 1)) != null) {
                this.fKT.bfe();
                this.flD.a(sX);
                if (!this.flD.vX()) {
                    this.flD.vZ();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.flD.vY();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcg() {
        com.baidu.tieba.pb.data.d pbData = this.fKS.getPbData();
        this.fKS.kn(true);
        if (this.flD != null) {
            pbData.qj(this.flD.vW());
        }
        this.fKT.n(pbData);
    }

    private boolean bch() {
        if (this.fKS == null) {
            return true;
        }
        if (this.fKS.vX()) {
            final MarkData bdA = this.fKS.bdA();
            if (bdA == null || !this.fKS.getIsFromMark()) {
                return true;
            }
            final MarkData sX = this.fKS.sX(this.fKT.bfi());
            if (sX == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bdA);
                setResult(-1, intent);
                return true;
            } else if (sX.getPostId() == null || sX.getPostId().equals(bdA.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bdA);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dk(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.flD != null) {
                            if (PbActivity.this.flD.vX()) {
                                PbActivity.this.flD.vY();
                                PbActivity.this.flD.aL(false);
                            }
                            PbActivity.this.flD.a(sX);
                            PbActivity.this.flD.aL(true);
                            PbActivity.this.flD.vZ();
                        }
                        bdA.setPostId(sX.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bdA);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bcd();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bdA);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bcd();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fKT != null && PbActivity.this.fKT.getView() != null) {
                            PbActivity.this.fKT.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bdA);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bcd();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.AU();
                return false;
            }
        } else if (this.fKS.getPbData() == null || this.fKS.getPbData().bav() == null || this.fKS.getPbData().bav().size() <= 0 || !this.fKS.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fKT == null) {
            return null;
        }
        return this.fKT.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int RN() {
        if (this.fKT == null) {
            return 0;
        }
        return this.fKT.bfs();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> RO() {
        if (this.bLw == null) {
            this.bLw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: ahp */
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
        return this.bLw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> RP() {
        if (this.bLx == null) {
            this.bLx = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.bLx;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> RQ() {
        if (this.bLB == null) {
            this.bLB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcB */
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
                    gifView.Ms();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bLB;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> RR() {
        if (this.bLy == null) {
            this.bLy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcC */
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
                    ((PlayVoiceBntNew) view).bya();
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
        return this.bLy;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> RT() {
        this.bLA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bcD */
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
        return this.bLA;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ez() {
        if (this.beN == null) {
            this.beN = UserIconBox.w(getPageContext().getPageActivity(), 8);
        }
        return this.beN;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fKJ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        if (aw.qA(str) && this.fKS != null && this.fKS.bdl() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11664").s("obj_param1", 1).ab("post_id", this.fKS.bdl()));
        }
        aw.bfW().d(getPageContext(), str);
        this.fKJ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        aw.bfW().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fKJ = true;
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
            com.baidu.tieba.pb.data.d pbData = this.fKS.getPbData();
            TbRichText az = az(str, i);
            if (az != null && (tbRichTextData = az.Rh().get(this.fLY)) != null) {
                cVar.fMK = new ArrayList<>();
                cVar.fML = new ConcurrentHashMap<>();
                if (!tbRichTextData.Rn().Rz()) {
                    cVar.fMN = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fMK.add(b2);
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
                    imageUrlData.mIsReserver = this.fKS.bdz();
                    imageUrlData.mIsSeeHost = this.fKS.getHostMode();
                    cVar.fML.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.bar() != null) {
                            cVar.forumName = pbData.bar().getName();
                            cVar.forumId = pbData.bar().getId();
                        }
                        if (pbData.bat() != null) {
                            cVar.threadId = pbData.bat().getId();
                        }
                        cVar.fMM = pbData.baG() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fMN = true;
                int size = pbData.bav().size();
                this.fLZ = false;
                cVar.index = -1;
                if (pbData.baA() != null) {
                    PostData baA = pbData.baA();
                    TbRichText bwW = baA.bwW();
                    if (!aq.k(baA)) {
                        i2 = a(bwW, az, i, i, cVar.fMK, cVar.fML);
                    } else {
                        i2 = a(baA, i, cVar.fMK, cVar.fML);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bav().get(i4);
                    if (postData.getId() == null || pbData.baA() == null || pbData.baA().getId() == null || !postData.getId().equals(pbData.baA().getId())) {
                        TbRichText bwW2 = postData.bwW();
                        if (!aq.k(postData)) {
                            i3 = a(bwW2, az, i3, i, cVar.fMK, cVar.fML);
                        } else {
                            i3 = a(postData, i3, cVar.fMK, cVar.fML);
                        }
                    }
                }
                if (cVar.fMK.size() > 0) {
                    cVar.lastId = cVar.fMK.get(cVar.fMK.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.bar() != null) {
                        cVar.forumName = pbData.bar().getName();
                        cVar.forumId = pbData.bar().getId();
                    }
                    if (pbData.bat() != null) {
                        cVar.threadId = pbData.bat().getId();
                    }
                    cVar.fMM = pbData.baG() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Rn() == null) {
            return null;
        }
        return tbRichTextData.Rn().RE();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Rn() == null) {
            return 0L;
        }
        return tbRichTextData.Rn().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Rn() == null) {
            return false;
        }
        return tbRichTextData.Rn().RF();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Rn() == null) {
            return false;
        }
        return tbRichTextData.Rn().RG();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Rn;
        String str;
        if (tbRichText == tbRichText2) {
            this.fLZ = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Rh().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Rh().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.Rn().getWidth() * ar;
                    int height = ar * tbRichTextData.Rn().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Rn().Rz()) {
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
                            if (tbRichTextData != null && (Rn = tbRichTextData.Rn()) != null) {
                                String RB = Rn.RB();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = Rn.RC();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = RB;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fKS.bdl(), -1L);
                                imageUrlData.mIsReserver = this.fKS.bdz();
                                imageUrlData.mIsSeeHost = this.fKS.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fLZ) {
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
        com.baidu.tieba.tbadkCore.data.h bxd;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bwz;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bwz = (bxd = postData.bxd()).bwz()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bwz.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bwz.get(i3);
                if (jVar != null) {
                    String bwD = jVar.bwD();
                    if (!com.baidu.tbadk.core.util.am.isEmpty(bwD)) {
                        arrayList.add(bwD);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bwD;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bwC();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fKS.bdl(), -1L);
                        imageUrlData.mIsReserver = this.fKS.bdz();
                        imageUrlData.mIsSeeHost = this.fKS.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bxd.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bwD, imageUrlData);
                        }
                        if (!this.fLZ) {
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
            if (postData.getId() != null && postData.getId().equals(this.fKS.zx())) {
                z = true;
            }
            MarkData h = this.fKS.h(postData);
            if (h != null) {
                this.fKT.bfe();
                if (this.flD != null) {
                    this.flD.a(h);
                    if (!z) {
                        this.flD.vZ();
                    } else {
                        this.flD.vY();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText az(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fKS == null || this.fKS.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fKS.getPbData();
        if (pbData.baA() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.baA());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bav = pbData.bav();
            a(pbData, bav);
            return a(bav, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.baE() != null && dVar.baE().fIe != null && (list = dVar.baE().fIe) != null && arrayList != null) {
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
        ArrayList<PostData> bav;
        com.baidu.tieba.pb.data.d pbData = this.fKS.getPbData();
        if (pbData != null && (bav = pbData.bav()) != null && !bav.isEmpty()) {
            Iterator<PostData> it = bav.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bxd = next.bxd();
                if (bxd != null && bxd.haj) {
                    Iterator<TbRichTextData> it2 = next.bwW().Rh().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Rw().getLink().equals(str)) {
                            return bxd.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Rh;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bwW = arrayList.get(i2).bwW();
            if (bwW != null && (Rh = bwW.Rh()) != null) {
                int size = Rh.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Rh.get(i4) != null && Rh.get(i4).getType() == 8) {
                        i3++;
                        if (Rh.get(i4).Rn().RB().equals(str) || Rh.get(i4).Rn().RC().equals(str)) {
                            int ar = (int) com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
                            int width = Rh.get(i4).Rn().getWidth() * ar;
                            int height = Rh.get(i4).Rn().getHeight() * ar;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fLY = i4;
                            return bwW;
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
            this.fKt = str;
            if (this.fKE == null) {
                bbS();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fKE.fj(1).setVisibility(8);
            } else {
                this.fKE.fj(1).setVisibility(0);
            }
            this.fKE.AX();
            this.fKJ = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dEk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bci() {
        hideNetRefreshView(this.fKT.getView());
        bcj();
        if (this.fKS.Nv()) {
            this.fKT.bfe();
        }
    }

    private void bcj() {
        showLoadingView(this.fKT.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View MO = getLoadingView().MO();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MO.getLayoutParams();
        layoutParams.addRule(3, this.fKT.bfI().getId());
        MO.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avh() {
        if (this.dEk != null) {
            this.dEk.stopPlay();
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
        if (this.fKS.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fKS.getPbData();
            pbData.bar().getName();
            String title = pbData.bat().getTitle();
            int i2 = this.fKS.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.bar() != null) {
                if ((pbData.bar().isLike() == 1) && AddExperiencedModel.sg(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fKS.bdl() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bY = pbData.bY(getPageContext().getPageActivity());
                    str = bY[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bY[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bbV() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10399").ab(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ab("tid", pbData.getThreadId()).ab("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.blg = true;
                    dVar.blk = z;
                    dVar.extData = this.fKS.bdl();
                    dVar.blu = 3;
                    dVar.blt = i;
                    dVar.fid = this.fKS.getForumId();
                    dVar.tid = this.fKS.bdl();
                    dVar.blv = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.blo = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fKS.getPbData().bat());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.blu);
                    bundle.putInt("obj_type", dVar.blv);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.i(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().baQ()) {
                                PbActivity.this.fKT.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.d.d.ani().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fKS.bdl() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bY2 = pbData.bY(getPageContext().getPageActivity());
            str = bY2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bY2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bbV() == 1) {
            }
            if (com.baidu.tbadk.core.util.am.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.blg = true;
            dVar2.blk = z;
            dVar2.extData = this.fKS.bdl();
            dVar2.blu = 3;
            dVar2.blt = i;
            dVar2.fid = this.fKS.getForumId();
            dVar2.tid = this.fKS.bdl();
            dVar2.blv = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fKS.getPbData().bat());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.blu);
            bundle2.putInt("obj_type", dVar2.blv);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.i(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fKS != null && PbActivity.this.fKS.getPbData() != null && PbActivity.this.fKS.getPbData().baQ()) {
                        PbActivity.this.fKT.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.d.d.ani().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bat() != null) {
            if (dVar.bat().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bat().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bck() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.sh(PbActivity.this.fKS.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fKT.bfO();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> RS() {
        if (this.bLz == null) {
            this.bLz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcE */
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
        return this.bLz;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fKT.beZ() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, this.fKS.getPbData().getForumId()));
            } else {
                bd bat = this.fKS.getPbData().bat();
                if (view != null) {
                    boolean z = bat.zc() == null || bat.zc().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fLK > 1000) {
                            this.fLL = true;
                            cs(view);
                        } else {
                            this.fLL = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            s(view, this.fLL);
                        } else {
                            r(view, this.fLL);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        r(view, this.fLL);
                    } else if (motionEvent.getAction() == 3) {
                        r(view, this.fLL);
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
                    PbActivity.this.fLK = System.currentTimeMillis();
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
                    PbActivity.this.fLK = System.currentTimeMillis();
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

    public void avi() {
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
        } else if (aVar.AW() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.AW();
            int intValue = ((Integer) sparseArray.get(ar.fVr)).intValue();
            if (intValue == ar.fVs) {
                if (!this.cXM.bxF()) {
                    this.fKT.bfb();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.cXM.a(this.fKS.getPbData().bar().getId(), this.fKS.getPbData().bar().getName(), this.fKS.getPbData().bat().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == ar.fVt || intValue == ar.fVv) {
                if (this.fKS.bdJ() != null) {
                    this.fKS.bdJ().sO(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.fVt) {
                    TiebaStatic.log("c10499");
                }
            } else if (intValue == ar.fVu) {
                sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), this.fMe).xD()));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fLm);
        userMuteAddAndDelCustomMessage.setTag(this.fLm);
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

    public void jZ(boolean z) {
        this.fLb = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bcl() {
        ArrayList<PostData> bav;
        int D;
        if (this.fKS == null || this.fKS.getPbData() == null || this.fKS.getPbData().bav() == null || (D = com.baidu.tbadk.core.util.v.D((bav = this.fKS.getPbData().bav()))) == 0) {
            return "";
        }
        if (this.fKS.bdz()) {
            Iterator<PostData> it = bav.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bwT() == 1) {
                    return next.getId();
                }
            }
        }
        int bfi = this.fKT.bfi();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.f(bav, bfi);
        if (postData == null || postData.zn() == null) {
            return "";
        }
        if (this.fKS.qr(postData.zn().getUserId())) {
            return postData.getId();
        }
        for (int i = bfi - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.f(bav, i);
            if (postData2 == null || postData2.zn() == null || postData2.zn().getUserId() == null) {
                break;
            } else if (this.fKS.qr(postData2.zn().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bfi + 1; i2 < D; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.f(bav, i2);
            if (postData3 == null || postData3.zn() == null || postData3.zn().getUserId() == null) {
                return "";
            }
            if (this.fKS.qr(postData3.zn().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ac(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.aw.Dt().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(qn(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fKS.getPbData().bar().getId(), this.fKS.getPbData().bar().getName(), this.fKS.getPbData().bat().getTid());
            }
            this.fKJ = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fKS.bdI() != null) {
                    PbActivity.this.fKS.bdI().cF(j);
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
        aVar.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c qp(String str) {
        String str2;
        if (this.fKS.getPbData() == null || this.fKS.getPbData().bav() == null || this.fKS.getPbData().bav().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fKS.getPbData().bav().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fKS.getPbData().bav().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fKS.getPbData().bav().get(i);
        if (postData.bwW() == null || postData.bwW().Rh() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bwW().Rh().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Rn() != null) {
                    str2 = next.Rn().RB();
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
        if (this.fKA) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fKA = false;
        } else if (bcm()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fKA) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fKA = false;
        } else if (bcm()) {
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
        if (pageStayDurationItem != null && this.fKS != null) {
            if (this.fKS.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fKS.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fKS.bdl(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean bcm() {
        return (!this.fKy && this.fMg == -1 && this.fMh == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fMj = mVar;
            this.fKy = true;
            this.fKT.beS();
            this.fKT.qy(this.fMi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcn() {
        if (this.fMj != null) {
            if (this.fMg == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ay.aZ(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fMj.getCartoonId(), this.fMg, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bco() {
        if (this.fMj != null) {
            if (this.fMh == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ay.aZ(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fMj.getCartoonId(), this.fMh, 0)));
                finish();
            }
        }
    }

    public int bcp() {
        return this.fMg;
    }

    public int bcq() {
        return this.fMh;
    }

    private void aDJ() {
        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null && this.fKS.getPbData().bat().Aa()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bcr() {
        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null && this.fKS.getPbData().bat().Aa()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bcs() {
        if (this.fKB) {
            this.fKO = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null && this.fKS.getPbData().bat().yV() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fKS.getPbData().bat().yV().getThreadId(), this.fKS.getPbData().bat().yV().getTaskId(), this.fKS.getPbData().bat().yV().getForumId(), this.fKS.getPbData().bat().yV().getForumName(), this.fKS.getPbData().bat().zi(), this.fKS.getPbData().bat().zj())));
            this.fKA = true;
            finish();
        }
    }

    public String bct() {
        return this.fKM;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bcu() {
        return this.fKR;
    }

    public void ka(boolean z) {
        this.fKN = z;
    }

    public boolean bcv() {
        if (this.fKS != null) {
            return this.fKS.bdn();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dk(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fLk).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fLk.getPageActivity(), 2, true, 4);
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
        aVar.b(this.fLk).AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fLk != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLk.getPageActivity());
            aVar.dk(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fLk).AU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.fKT.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLk.getPageActivity());
        if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
            aVar.dk(this.fLk.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.dk(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fKT.showLoadingDialog();
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
        aVar.b(this.fLk).AU();
    }

    public void bcx() {
        if (this.fKS != null && this.fKS.getPbData() != null && this.fKS.getPbData().bat() != null && this.fKS.getPbData().bat().Ao() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.fb(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fKS.getPbData().bat().Ao().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.AU();
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
        if (this.fKT != null) {
            this.fKT.onConfigurationChanged(configuration);
        }
        if (this.fKZ != null) {
            this.fKZ.dismiss();
        }
    }

    public boolean bcy() {
        if (this.fKS != null) {
            return this.fKS.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.fKS.getPbData().baE().fIe;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bwQ().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bwQ().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bwQ().remove(i2);
                    list.get(i).bwS();
                    z = true;
                    break;
                }
            }
            list.get(i).sM(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.n(this.fKS.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bbc().getId();
        List<PostData> list = this.fKS.getPbData().baE().fIe;
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
                ArrayList<PostData> bbg = kVar.bbg();
                postData.vL(kVar.getTotalCount());
                if (postData.bwQ() != null) {
                    postData.bwQ().clear();
                    postData.bwQ().addAll(bbg);
                }
            }
        }
        if (!this.fKS.getIsFromMark()) {
            this.fKT.n(this.fKS.getPbData());
        }
    }

    public boolean bcz() {
        if (this.fKS == null) {
            return false;
        }
        return this.fKS.bcz();
    }

    public void bcA() {
        if (this.fKT != null) {
            this.fKT.beH();
            avi();
        }
    }

    public PostData baA() {
        return this.fKT.b(this.fKS.fPY, this.fKS.bdm());
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
        if (this.fLu != null && !this.fLu.isEmpty()) {
            int size = this.fLu.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fLu.get(i).onBackPressed()) {
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
            if (this.fLu == null) {
                this.fLu = new ArrayList();
            }
            if (!this.fLu.contains(aVar)) {
                this.fLu.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fLu == null) {
                this.fLu = new ArrayList();
            }
            if (!this.fLu.contains(aVar)) {
                this.fLu.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fLu != null) {
            this.fLu.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dEU == null) {
            this.dEU = new com.baidu.tbadk.core.dialog.i(getPageContext());
        }
        this.dEU.a(contriInfo, -1L);
    }
}
