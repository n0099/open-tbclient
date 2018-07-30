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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
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
    private com.baidu.adp.lib.e.b<TbImageView> ayS;
    private com.baidu.tieba.f.b bKb;
    private com.baidu.adp.lib.e.b<ImageView> bfU;
    private com.baidu.adp.lib.e.b<TextView> bfV;
    private com.baidu.adp.lib.e.b<View> bfW;
    private com.baidu.adp.lib.e.b<LinearLayout> bfX;
    private com.baidu.adp.lib.e.b<RelativeLayout> bfY;
    private com.baidu.adp.lib.e.b<GifView> bfZ;
    private com.baidu.tbadk.core.util.b.a bkU;
    private VoiceManager dmp;
    private com.baidu.tbadk.core.dialog.h dnc;
    public com.baidu.tbadk.core.util.ak eIc;
    private String fuT;
    private com.baidu.tieba.pb.pb.main.a.b fuZ;
    public av fvA;
    private y fvB;
    private boolean fvD;
    private com.baidu.tieba.tbadkCore.data.e fvG;
    private com.baidu.tbadk.editortools.pb.f fvH;
    private com.baidu.tbadk.editortools.pb.d fvI;
    private EmotionImageData fvK;
    private com.baidu.adp.base.e fvN;
    private com.baidu.tbadk.core.view.d fvO;
    private BdUniqueId fvP;
    private Runnable fvQ;
    private ax fvR;
    private com.baidu.adp.widget.ImageView.a fvS;
    private String fvT;
    private TbRichTextMemeInfo fvU;
    private List<a> fvX;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fvp;
    private View fvq;
    private com.baidu.tieba.pb.pb.report.a fvt;
    private String fwL;
    private com.baidu.tbadk.core.data.m fwM;
    private boolean fwz;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.arq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.arq));
        }
    };
    private static final b.a fwG = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
        @Override // com.baidu.tieba.f.b.a
        public void fc(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bal();
            } else {
                com.baidu.tieba.pb.a.b.bak();
            }
        }
    };
    private boolean fuY = false;
    private boolean fva = false;
    private boolean fvb = false;
    private boolean eYY = false;
    private boolean fvc = true;
    private int fvd = 0;
    private com.baidu.tbadk.core.dialog.b fve = null;
    private long cSN = -1;
    private long aTT = 0;
    private long fvf = 0;
    private long createTime = 0;
    private long aTL = 0;
    private boolean fvg = false;
    private com.baidu.tbadk.l.b fvh = null;
    private long fvi = 0;
    private boolean fvj = false;
    private long fvk = 0;
    private String aNS = null;
    private boolean fvl = false;
    private boolean isFullScreen = false;
    private String fvm = "";
    private boolean fvn = true;
    private boolean fvo = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fvr = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void q(boolean z) {
            PbActivity.this.fvv.kj(!PbActivity.this.fvn);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fvs != null && PbActivity.this.fvs.rN()) {
                        PbActivity.this.bbb();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fvs = null;
    private com.baidu.tbadk.baseEditMark.a fvu = null;
    private ForumManageModel czM = null;
    private com.baidu.tbadk.coreExtra.model.a aqE = null;
    private ShareSuccessReplyToServerModel dBy = null;
    private at fvv = null;
    public final com.baidu.tieba.pb.pb.main.a.a fvw = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean fvx = false;
    private boolean fvy = false;
    private boolean fvz = false;
    private boolean fvC = false;
    private boolean fvE = false;
    private boolean fvF = false;
    private boolean fvJ = false;
    public boolean fvL = false;
    private com.baidu.tbadk.editortools.pb.c aNV = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HR() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aNW = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HQ() {
            if (PbActivity.this.fvA == null || PbActivity.this.fvA.beQ() == null || !PbActivity.this.fvA.beQ().bFl()) {
                return !PbActivity.this.qs(com.baidu.tbadk.core.util.ak.aqz);
            }
            PbActivity.this.showToast(PbActivity.this.fvA.beQ().bFn());
            if (PbActivity.this.fvI != null && (PbActivity.this.fvI.If() || PbActivity.this.fvI.Ig())) {
                PbActivity.this.fvI.a(false, PbActivity.this.fvA.beT());
            }
            PbActivity.this.fvA.ku(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fvM = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HQ() {
            if (PbActivity.this.fvA == null || PbActivity.this.fvA.beR() == null || !PbActivity.this.fvA.beR().bFl()) {
                return !PbActivity.this.qs(com.baidu.tbadk.core.util.ak.aqA);
            }
            PbActivity.this.showToast(PbActivity.this.fvA.beR().bFn());
            if (PbActivity.this.fvv != null && PbActivity.this.fvv.bdG() != null && PbActivity.this.fvv.bdG().bbZ() != null && PbActivity.this.fvv.bdG().bbZ().Ig()) {
                PbActivity.this.fvv.bdG().bbZ().a(PbActivity.this.fvA.beT());
            }
            PbActivity.this.fvA.kv(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dmY = false;
    private int fvV = 0;
    private int fvW = -1;
    private final a fvY = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fvv != null && PbActivity.this.fvv.bdG() != null) {
                s bdG = PbActivity.this.fvv.bdG();
                if (bdG.bbW()) {
                    bdG.bbV();
                    return true;
                }
            }
            if (PbActivity.this.fvv != null && PbActivity.this.fvv.bex()) {
                PbActivity.this.fvv.bey();
                return true;
            }
            return false;
        }
    };
    private r.b fvZ = new r.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // com.baidu.tieba.pb.pb.main.r.b
        public void c(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private AddExperiencedModel.a dng = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bbf();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fwa = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void G(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fvv.showToast(str);
            }
        }
    };
    private final CustomMessageListener fwb = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvs != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fvI != null) {
                    PbActivity.this.fvv.ko(PbActivity.this.fvI.HZ());
                }
                PbActivity.this.fvv.bdH();
                PbActivity.this.fvv.beq();
            }
        }
    };
    CustomMessageListener dny = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                PbActivity.this.fvs.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                if (PbActivity.this.fvv != null && PbActivity.this.fvs != null) {
                    PbActivity.this.fvv.d(PbActivity.this.fvs.getPbData(), PbActivity.this.fvs.bcj(), PbActivity.this.fvs.getRequestType());
                }
                if (PbActivity.this.fvv != null && PbActivity.this.fvv.bdX() != null) {
                    PbActivity.this.fvv.bdX().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fwc = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fvv != null) {
                    if (booleanValue) {
                        PbActivity.this.fvv.aLG();
                    } else {
                        PbActivity.this.fvv.aLF();
                    }
                }
            }
        }
    };
    private CustomMessageListener fwd = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fvI != null) {
                    PbActivity.this.fvv.ko(PbActivity.this.fvI.HZ());
                }
                PbActivity.this.fvv.kq(false);
            }
        }
    };
    private CustomMessageListener fwe = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
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
    private CustomMessageListener fwf = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvv != null && PbActivity.this.fvv.bdX() != null) {
                PbActivity.this.fvv.bdX().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener elL = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fwg = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.qu(2);
                aj.bdq().reset();
                PbActivity.this.fvs.bcB();
                boolean z2 = false;
                ArrayList<PostData> aZp = PbActivity.this.fvs.getPbData().aZp();
                if (aZp != null) {
                    Iterator<PostData> it = aZp.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (as.j(next) && next.bwo().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fvv.n(PbActivity.this.fvs.getPbData());
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
    private View.OnClickListener aOC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aNS);
        }
    };
    private CustomMessageListener fwh = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvs.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fvs.bcs() != null && PbActivity.this.fvs.bcs().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fvv.a(yVar.sendCount, PbActivity.this.fvs.getPbData(), PbActivity.this.fvs.bcj(), PbActivity.this.fvs.getRequestType());
                    }
                    if (pbData.aZp() != null && pbData.aZp().size() >= 1 && pbData.aZp().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.aZp().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fvs.bci(), 0L);
                        if (c2 == yVar.postId && c3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bwn = pbData.aZp().get(0).bwn();
                            if (bwn == null) {
                                bwn = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> uv = bwn.uv();
                            if (uv == null) {
                                uv = new ArrayList<>();
                            }
                            uv.add(0, aVar);
                            bwn.bP(yVar.sendCount + bwn.uu());
                            bwn.k(uv);
                            pbData.aZp().get(0).a(bwn);
                            PbActivity.this.fvv.bdX().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener dEl = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null) {
                PbActivity.this.ra((String) customResponsedMessage.getData());
                PbActivity.this.fvs.bcy();
                if (PbActivity.this.fvv.bdX() != null) {
                    PbActivity.this.fvv.n(PbActivity.this.fvs.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a fwi = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.apB() != null && !aVar.apB().isEmpty()) {
                    PbActivity.this.fvv.a(aVar, PbActivity.this.fwk);
                }
                PbActivity.this.fvv.a(aVar, PbActivity.this.fvs.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.beW()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fwj = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void G(List<String> list) {
            if (!com.baidu.tbadk.core.util.w.z(list) && PbActivity.this.fvv != null) {
                PbActivity.this.fvv.cW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fwk = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.aV(PbActivity.this.getPageContext().getPageActivity());
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
    private boolean fwl = false;
    private PraiseModel fwm = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void iS(String str) {
            PbActivity.this.fwl = false;
            if (PbActivity.this.fwm != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvs.getPbData();
                if (pbData.aZn().uX().getIsLike() == 1) {
                    PbActivity.this.kO(0);
                } else {
                    PbActivity.this.kO(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.aZn()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Q(int i, String str) {
            PbActivity.this.fwl = false;
            if (PbActivity.this.fwm != null && str != null) {
                if (AntiHelper.al(i, str)) {
                    AntiHelper.aq(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fwn = 0;
    private boolean fwo = true;
    private b.a fwp = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jF(boolean z) {
            PbActivity.this.jE(z);
            if (PbActivity.this.fvv.beD() != null && z) {
                PbActivity.this.fvv.kj(false);
            }
            PbActivity.this.fvv.kl(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aDu != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aDu, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.arq));
                        }
                    } else if (updateAttentionMessage.getData().Gp) {
                        if (PbActivity.this.aZu().vk() != null && PbActivity.this.aZu().vk().getGodUserData() != null) {
                            PbActivity.this.aZu().vk().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZn() != null && PbActivity.this.fvs.getPbData().aZn().vk() != null) {
                            PbActivity.this.fvs.getPbData().aZn().vk().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a ccL = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fvv.aeP();
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
                    com.baidu.tieba.i.a.aCP();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bge = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.fvv.bdI()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvs != null && (PbActivity.this.fvs.getPbData() != null || PbActivity.this.fvs.getPbData().aZL() != null)) {
                    if (PbActivity.this.fvs.getPbData().aZL().aZT()) {
                        if (PbActivity.this.fvs.getPbData().aZL().ftm == 1 || PbActivity.this.fvs.getPbData().aZL().ftm == 3 || PbActivity.this.fvs.getPbData().aZL().ftm == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvs.getPbData().aZL().aZT() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvs.getPbData().aZL().aZT() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fvk > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kQ(false);
                        PbActivity.this.fvk = System.currentTimeMillis();
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
                    if (PbActivity.this.bc(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.fvv != null && PbActivity.this.fvv.baL() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").af(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.fvw != null && PbActivity.this.fvw.fIV != null) {
                            PbActivity.this.fvw.fIV.onClick(view);
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
            if (PbActivity.this.fvI != null) {
                PbActivity.this.fvv.ko(PbActivity.this.fvI.HZ());
            }
            PbActivity.this.fvv.bdH();
            PbActivity.this.fvv.beq();
            return true;
        }
    });
    private CustomMessageListener fwq = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvP) {
                PbActivity.this.fvv.aeP();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvs.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aZB().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fvO.e(PbActivity.this.fvN.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fvN.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.gR(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bbr();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fvN.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.fvO.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fwr = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvP) {
                PbActivity.this.fvv.aeP();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fvO.e(PbActivity.this.fvN.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fvN.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.fvO.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fws = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fvP) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fvv.aeP();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hbr;
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
                    PbActivity.this.fvv.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fwt = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fvv.bdI() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.bat() != null && PbActivity.this.bat().getPbData() != null && PbActivity.this.bat().getPbData().aZL() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean aZT = PbActivity.this.bat().getPbData().aZL().aZT();
                if (intValue < 10) {
                    if (aZT) {
                        if (PbActivity.this.fvs.getPbData().aZL().ftm == 1 || PbActivity.this.fvs.getPbData().aZL().ftm == 3 || PbActivity.this.fvs.getPbData().aZL().ftm == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvs.getPbData().aZL().aZT() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aZT ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.fvk > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kQ(false);
                        PbActivity.this.fvk = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, aZT, 3);
                TiebaStatic.log(PbActivity.this.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, aZT ? 0 : 1));
            }
        }
    };
    private CustomMessageListener dnF = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dmY = true;
                }
            }
        }
    };
    public a.b fjO = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.auC();
            com.baidu.tbadk.core.data.al pageData = PbActivity.this.fvs.getPageData();
            int pageNum = PbActivity.this.fvv.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.un()) {
                PbActivity.this.fvv.beq();
                PbActivity.this.qu(2);
                PbActivity.this.auB();
                PbActivity.this.fvv.beb();
                if (com.baidu.adp.lib.util.j.jE()) {
                    PbActivity.this.fvs.qD(PbActivity.this.fvv.getPageNum());
                    if (PbActivity.this.fuZ != null) {
                        PbActivity.this.fuZ.showFloatingView();
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
    public final View.OnClickListener doi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
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
            com.baidu.tieba.pb.data.j aZL;
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
            boolean m;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fvv.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fvs.jP(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fvv.bec();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdj()) {
                        if (view == PbActivity.this.fvv.fEK.aVP) {
                            if (PbActivity.this.fvv.kn(PbActivity.this.fvs.bcp())) {
                                PbActivity.this.auB();
                                return;
                            }
                            PbActivity.this.fvc = false;
                            PbActivity.this.fva = false;
                            com.baidu.adp.lib.util.l.a(PbActivity.this, PbActivity.this.fvv.fEK.aVP);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fvv.bdZ() && (PbActivity.this.fvv.fEK.bfi() == null || (view != PbActivity.this.fvv.fEK.bfi().bdi() && view != PbActivity.this.fvv.fEK.bfi().bdg()))) {
                            if (view == PbActivity.this.fvv.bet()) {
                                if (PbActivity.this.fvs != null) {
                                    com.baidu.tbadk.browser.a.Q(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvs.getPbData().aZn().vj().getLink());
                                }
                            } else if (view != PbActivity.this.fvv.fEK.fJF && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.fvv.fEK.fJG) {
                                    if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null) {
                                        ArrayList<PostData> aZp = PbActivity.this.fvs.getPbData().aZp();
                                        if ((aZp == null || aZp.size() <= 0) && PbActivity.this.fvs.bcj()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").af("tid", PbActivity.this.fvs.bci()).af("uid", TbadkCoreApplication.getCurrentAccount()).af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getForumId()));
                                        if (!PbActivity.this.fvv.beI()) {
                                            PbActivity.this.fvv.bdH();
                                        }
                                        PbActivity.this.baT();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bcU()) {
                                        if ((PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdf()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.fvv.fEK.bfi() == null || (view != PbActivity.this.fvv.fEK.bfi().getCancelView() && view != PbActivity.this.fvv.fEK.bfi().bde())) {
                                                if (view != PbActivity.this.fvv.fEK.fJH && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdc()) {
                                                        if ((PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdl()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdd()) {
                                                                if (PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdm()) {
                                                                    if (PbActivity.this.fvB == null || view != PbActivity.this.fvB.bcW()) {
                                                                        if (PbActivity.this.fvB == null || view != PbActivity.this.fvB.bcU()) {
                                                                            if (PbActivity.this.fvB == null || view != PbActivity.this.fvB.bcZ()) {
                                                                                if (PbActivity.this.fvB == null || view != PbActivity.this.fvB.bcX()) {
                                                                                    if (PbActivity.this.fvB == null || view != PbActivity.this.fvB.bcY()) {
                                                                                        if (PbActivity.this.fvv.beD() == view) {
                                                                                            if (PbActivity.this.fvv.beD().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvs.getPbData();
                                                                                                if (pbData != null && pbData.aZn() != null && pbData.aZn().uR() != null) {
                                                                                                    String tJ = pbData.aZn().uR().tJ();
                                                                                                    if (StringUtils.isNull(tJ)) {
                                                                                                        tJ = pbData.aZn().uR().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").af(VideoPlayActivityConfig.OBJ_ID, tJ));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.cl("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.bbn();
                                                                                        } else if (PbActivity.this.fvv.bdW() != view) {
                                                                                            if (PbActivity.this.fvB == null || view != PbActivity.this.fvB.bcV()) {
                                                                                                if (PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdk()) {
                                                                                                    if (PbActivity.this.fvv.fEK.bfi() != null && view == PbActivity.this.fvv.fEK.bfi().bdh()) {
                                                                                                        if (com.baidu.adp.lib.util.j.jE()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.fvv.c(PbActivity.this.fvs.getPbData(), PbActivity.this.fvs.bcj(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.fvv.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.fvv.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.fvv.fEK.sz();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.fvv.baE()) {
                                                                                                            if (view == PbActivity.this.fvv.fEK.bfj()) {
                                                                                                                PbActivity.this.fvv.bei();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (bgVar = (bg) view.getTag()) != null && !StringUtils.isNull(bgVar.wU())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                                        com.baidu.tbadk.core.util.ay.zK().c(PbActivity.this.getPageContext(), new String[]{bgVar.wU()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData bd = PbActivity.this.bd(view);
                                                                                                                    if (bd != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, bd.bwr() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.bat() != null && PbActivity.this.bat().getPbData() != null && PbActivity.this.bat().getPbData().aZL() != null && PbActivity.this.bat().getPbData().aZL() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.baO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.bat().getPbData().aZL().aZT() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && !StringUtils.isNull(PbActivity.this.fvs.getPbData().getThreadId()) && (aZL = PbActivity.this.fvs.getPbData().aZL()) != null && aZL.aZR() > 0) {
                                                                                                                        com.baidu.tbadk.core.util.ay.zK().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fvs.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.fvB == null) {
                                                                                                                                PbActivity.this.fvB = new y(PbActivity.this.getPageContext(), PbActivity.this.doi);
                                                                                                                                PbActivity.this.fvv.bn(PbActivity.this.fvB.getView());
                                                                                                                                PbActivity.this.fvB.jT(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.fvB.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").af("tid", PbActivity.this.fvs.fAH));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.fvB.bcU().setTag(sparseArray2);
                                                                                                                            PbActivity.this.fvB.bcZ().setTag(view.getTag());
                                                                                                                            PbActivity.this.fvB.jV(z6);
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
                                                                                                                                    PbActivity.this.fvB.bcX().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.fvB.bcX().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvB.bcV().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fvB.bcX().setTag(sparseArray4);
                                                                                                                                PbActivity.this.fvB.bcV().setText(d.j.bar_manager);
                                                                                                                                PbActivity.this.fvB.bcV().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.fvB.bcV().setVisibility(8);
                                                                                                                                PbActivity.this.fvB.bcX().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.fvB.bcV().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fvB.bcX().setTag(sparseArray5);
                                                                                                                                PbActivity.this.fvB.bcV().setText(d.j.delete);
                                                                                                                                PbActivity.this.fvB.bcX().setVisibility(0);
                                                                                                                                if (PbActivity.this.fvs.getPbData().aZz() != 1002 || z2) {
                                                                                                                                    PbActivity.this.fvB.bcX().setText(d.j.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvB.bcX().setText(d.j.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvB.bcV().setVisibility(8);
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
                                                                                                                                PbActivity.this.fvB.bcW().setTag(sparseArray7);
                                                                                                                                PbActivity.this.fvB.bcW().setVisibility(0);
                                                                                                                                PbActivity.this.fvB.bcV().setVisibility(8);
                                                                                                                                PbActivity.this.fvB.bcW().setText(d.j.mute_option);
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
                                                                                                                                boolean jA = PbActivity.this.jA(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fwD = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (as.j(PbActivity.this.fwD) ? false : jA) {
                                                                                                                                    PbActivity.this.fvB.bcW().setVisibility(0);
                                                                                                                                    PbActivity.this.fvB.bcW().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvB.bcW().setVisibility(8);
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
                                                                                                                                PbActivity.this.fvB.bcY().setVisibility(0);
                                                                                                                                PbActivity.this.fvB.bcY().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.fvB.bcY().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.fvB.bcY().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.fvB.bcY().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fvs.getPbData().rN()) {
                                                                                                                            String rM = PbActivity.this.fvs.getPbData().rM();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(rM) && rM.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.fvB.bcU().setText(d.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fvB.bcU().setText(d.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fvB.jU(true);
                                                                                                                                PbActivity.this.fvB.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.fvB.jU(true);
                                                                                                                        PbActivity.this.fvB.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZn() != null && PbActivity.this.fvs.getPbData().aZn().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), PbActivity.this.fvs.getPbData().aZn().getActUrl());
                                                                                                                        if (PbActivity.this.fvs.getPbData().aZn().vN() != 1) {
                                                                                                                            if (PbActivity.this.fvs.getPbData().aZn().vN() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getPbData().getForumId()).af("tid", PbActivity.this.fvs.getPbData().getThreadId()).af("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fvs.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.fvv.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (ba.aV(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.fvv.bdH();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.baQ() == 1 && PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getPbData().getForumId()).af("tid", PbActivity.this.fvs.getPbData().getThreadId()).af("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.Q(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.baQ() == 1 && PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getPbData().getForumId()).af("tid", PbActivity.this.fvs.getPbData().getThreadId()).af("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.bbi();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.bbj();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZH() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fvs.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").af(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.ay.zK().c(PbActivity.this.getPageContext(), new String[]{pbData2.aZH().aZQ()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZH() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fvs.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").af(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        com.baidu.tbadk.core.util.ay.zK().c(PbActivity.this.getPageContext(), new String[]{pbData3.aZH().aZQ()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.fvv.fEK.bfi() != null && view == PbActivity.this.fvv.fEK.bfi().bdn()) {
                                                                                                                    if (PbActivity.this.fvs == null || PbActivity.this.fvs.getPbData() == null || PbActivity.this.fvs.getPbData().aZn() == null) {
                                                                                                                        PbActivity.this.fvv.fEK.sz();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.jV()) {
                                                                                                                        PbActivity.this.showToast(d.j.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fvs.getPbData().aZn().uS() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvs.bci(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).xn();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").r("obj_locate", PbActivity.this.ak(PbActivity.this.fvs.getPbData().aZn())).af("tid", PbActivity.this.fvs.getPbData().aZn().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.fvV >= 0) {
                                                                                                                        if (PbActivity.this.fvs != null) {
                                                                                                                            PbActivity.this.fvs.bcP();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fvv.bdX() != null) {
                                                                                                                            PbActivity.this.fvv.bdX().a(PbActivity.this.fvs.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.fvv.getListView().setSelection(PbActivity.this.fvs.bcS());
                                                                                                                        PbActivity.this.fvV = 0;
                                                                                                                        if (PbActivity.this.fvs != null) {
                                                                                                                            PbActivity.this.fvs.bq(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.fvv.beL();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fvs.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fvs.bci(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fvs.getPbData().aZn().vE())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fvs.getPbData() != null) {
                                                                                                            PbActivity.this.fvv.beq();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bwt() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                                                }
                                                                                                                String bci = PbActivity.this.fvs.bci();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fvs.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fvs.getPbData().aZz();
                                                                                                                }
                                                                                                                PbActivity.this.auB();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c rf = PbActivity.this.rf(id2);
                                                                                                                    if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && rf != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bci, id2, "pb", true, null, true, null, i3, postData3.bfZ(), PbActivity.this.fvs.getPbData().uh(), false, postData3.vk().getIconInfo()).addBigImageData(rf.fxn, rf.fxo, rf.fxp, rf.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fvs.bcO());
                                                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.fvs.getFromForumId());
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
                                                                                                                    c rf2 = PbActivity.this.rf(id2);
                                                                                                                    if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && rf2 != null && PbActivity.this.baK().bdF() != null) {
                                                                                                                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                                                        kVar.a(PbActivity.this.fvs.getPbData().aZl());
                                                                                                                        kVar.Z(PbActivity.this.fvs.getPbData().aZn());
                                                                                                                        kVar.d(postData4);
                                                                                                                        PbActivity.this.baK().bdF().d(kVar);
                                                                                                                        PbActivity.this.baK().bdF().setPostId(str7);
                                                                                                                        PbActivity.this.a(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c rf3 = PbActivity.this.rf(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && rf3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bci, id2, "pb", true, null, false, null, i3, postData3.bfZ(), PbActivity.this.fvs.getPbData().uh(), false, postData3.vk().getIconInfo()).addBigImageData(rf3.fxn, rf3.fxo, rf3.fxp, rf3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fvs.bcO());
                                                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.fvs.getFromForumId());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 3).af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.jE()) {
                                                                                                    PbActivity.this.fvv.beq();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.fvv.c(PbActivity.this.fvs.getPbData(), PbActivity.this.fvs.bcj(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvs.getPbData().aZl().getId(), PbActivity.this.fvs.getPbData().aZl().getName(), PbActivity.this.fvs.getPbData().aZn().getId(), String.valueOf(PbActivity.this.fvs.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_name_show), (String) c3.get(d.g.tag_forbid_user_post_id), (String) c3.get(d.g.tag_forbid_user_portrait))));
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    PbActivity.this.showToast(d.j.network_not_available);
                                                                                                    return;
                                                                                                }
                                                                                            } else if (!com.baidu.adp.lib.util.j.jE()) {
                                                                                                PbActivity.this.showToast(d.j.network_not_available);
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
                                                                                                            PbActivity.this.fvv.bl(view);
                                                                                                        }
                                                                                                    } else if (booleanValue5) {
                                                                                                        PbActivity.this.fvv.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.baG();
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
                                                                                        com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fvs.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.aZl() != null) {
                                                                                            str9 = pbData4.aZl().getId();
                                                                                            str10 = pbData4.aZl().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.a.a(j2, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j2, str8, str9, str10, str11, i4);
                                                                                    }
                                                                                } else {
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null) {
                                                                                        if ((sparseArray12.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_id) instanceof String) && (sparseArray12.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                            PbActivity.this.fvv.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), ((Integer) sparseArray12.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray12.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.fvB.bdb()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12007").af("tid", PbActivity.this.fvs.fAH));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvs.getPbData() != null) {
                                                                                    PbActivity.this.fvv.beq();
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
                                                                                        String bci2 = PbActivity.this.fvs.bci();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fvs.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fvs.getPbData().aZz();
                                                                                        }
                                                                                        PbActivity.this.auB();
                                                                                        c rf4 = PbActivity.this.rf(id3);
                                                                                        if (rf4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bci2, id3, "pb", true, null, true, null, i5, postData.bfZ(), PbActivity.this.fvs.getPbData().uh(), false, postData.vk().getIconInfo()).addBigImageData(rf4.fxn, rf4.fxo, rf4.fxp, rf4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fvs.bcO());
                                                                                            addBigImageData3.setFromFrsForumId(PbActivity.this.fvs.getFromForumId());
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
                                                                                if (PbActivity.this.fvs.getPbData().aZn() != null && PbActivity.this.fvs.getPbData().aZn().vk() != null && PbActivity.this.fvs.getPbData().aZn().vk().getUserId() != null && PbActivity.this.fvu != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").af("tid", PbActivity.this.fvs.fAH).r("obj_locate", 2).af(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvs.getPbData().aZn().vk().getUserId()).r("obj_type", PbActivity.this.fvu.rN() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fvs.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.jE()) {
                                                                        PbActivity.this.showToast(d.j.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13079"));
                                                                            PbActivity.this.rc((String) tag);
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
                                                                    PbActivity.this.fvv.fEK.bfh();
                                                                }
                                                            } else if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZn() != null) {
                                                                PbActivity.this.fvv.fEK.sz();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                                PbActivity.this.rc(PbActivity.this.fvs.getPbData().aZn().vB());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fvv.beq();
                                                            if (com.baidu.adp.lib.util.j.jE()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fvs.bcw()));
                                                                    return;
                                                                }
                                                                PbActivity.this.qu(2);
                                                                PbActivity.this.auB();
                                                                PbActivity.this.fvv.beb();
                                                                boolean bcv = PbActivity.this.fvs.bcv();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fvs.bcw()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.fvv.fEK != null && PbActivity.this.fvv.fEK.bfi() != null && view == PbActivity.this.fvv.fEK.bfi().bdl()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bcv) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.fvv.ke(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fvv.beq();
                                                        if (PbActivity.this.fvs.getPageData() != null) {
                                                            PbActivity.this.fvv.a(PbActivity.this.fvs.getPageData(), PbActivity.this.fjO);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.p.at.iq() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fvs != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12386").af("tid", PbActivity.this.fvs.bci()).af("uid", TbadkCoreApplication.getCurrentAccount()).af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.jV()) {
                                                        if (PbActivity.this.fvs.getPbData() != null) {
                                                            ArrayList<PostData> aZp2 = PbActivity.this.fvs.getPbData().aZp();
                                                            if ((aZp2 != null && aZp2.size() > 0) || !PbActivity.this.fvs.bcj()) {
                                                                PbActivity.this.fvv.beq();
                                                                PbActivity.this.auB();
                                                                PbActivity.this.qu(2);
                                                                if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZH() != null && !StringUtils.isNull(PbActivity.this.fvs.getPbData().aZH().tU(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                                if (com.baidu.tbadk.p.at.iq()) {
                                                                    PbActivity.this.qv(2);
                                                                } else {
                                                                    PbActivity.this.fvv.showLoadingDialog();
                                                                    PbActivity.this.fvs.bcJ().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.fvv.fEK.sz();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.jE()) {
                                            PbActivity.this.fvv.beq();
                                            if (PbActivity.this.fvv.fEK.bfi() != null && view == PbActivity.this.fvv.fEK.bfi().bdf() && !PbActivity.this.fvv.beI()) {
                                                PbActivity.this.fvv.bdH();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.auB();
                                                PbActivity.this.fvv.beb();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    m = PbActivity.this.fvs.m(true, PbActivity.this.bbg());
                                                } else {
                                                    m = view.getId() == d.g.reply_title ? PbActivity.this.fvs.m(false, PbActivity.this.bbg()) : PbActivity.this.fvs.rg(PbActivity.this.bbg());
                                                }
                                                view.setTag(Boolean.valueOf(m));
                                                if (m) {
                                                    PbActivity.this.fvv.jJ(true);
                                                    PbActivity.this.fvv.aLG();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fvv.ke(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.qu(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(d.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.jE()) {
                                        PbActivity.this.fvv.beq();
                                        if (PbActivity.this.qt(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fvs.qI(PbActivity.this.fvv.beg()) != null) {
                                            PbActivity.this.bba();
                                            if (PbActivity.this.fvs.getPbData().aZn() != null && PbActivity.this.fvs.getPbData().aZn().vk() != null && PbActivity.this.fvs.getPbData().aZn().vk().getUserId() != null && PbActivity.this.fvu != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").af("tid", PbActivity.this.fvs.fAH).r("obj_locate", 1).af(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fvs.getPbData().aZn().vk().getUserId()).r("obj_type", PbActivity.this.fvu.rN() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fvs.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.jE()) {
                                    PbActivity.this.fvv.jJ(true);
                                    PbActivity.this.fvv.bdH();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fvv.aLG();
                                        PbActivity.this.auB();
                                        PbActivity.this.fvv.beb();
                                        PbActivity.this.fvs.rg(PbActivity.this.bbg());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.qu(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(d.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZn() != null && PbActivity.this.fvs.getPbData().aZn().vW() && PbActivity.this.fvs.getPbData().aZn().vC() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbActivity.this.fvs.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fvs.bch()) && PbActivity.this.fvs.getAppealInfo() != null) {
                                        name = PbActivity.this.fvs.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fvs.getPbData().aZl().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bch = PbActivity.this.fvs.bch();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fvs.bck() && bch != null && bch.equals(name)) {
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
                            if (PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZz() == 1 && !PbActivity.this.czM.bwT()) {
                                PbActivity.this.fvv.beq();
                                int i6 = 0;
                                if (PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdg()) {
                                    if (PbActivity.this.fvv.fEK.bfi() == null || view != PbActivity.this.fvv.fEK.bfi().bdi()) {
                                        if (view == PbActivity.this.fvv.bdZ()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fvs.getPbData().aZn().vg() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fvs.getPbData().aZn().vf() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData aZl = PbActivity.this.fvs.getPbData().aZl();
                                String name2 = aZl.getName();
                                String id4 = aZl.getId();
                                String id5 = PbActivity.this.fvs.getPbData().aZn().getId();
                                PbActivity.this.fvv.bdY();
                                PbActivity.this.czM.a(id4, name2, id5, i6, PbActivity.this.fvv.bea());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.jE()) {
                        PbActivity.this.fvv.beq();
                        PbActivity.this.auB();
                        PbActivity.this.fvv.beb();
                        PbActivity.this.fvv.showLoadingDialog();
                        if (PbActivity.this.fvv.bdO() != null) {
                            PbActivity.this.fvv.bdO().setVisibility(8);
                        }
                        PbActivity.this.fvs.qD(1);
                        if (PbActivity.this.fuZ != null) {
                            PbActivity.this.fuZ.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String baN = PbActivity.this.baN();
                        if (!TextUtils.isEmpty(baN)) {
                            com.baidu.tbadk.core.util.ay.zK().c(PbActivity.this.getPageContext(), new String[]{baN});
                        }
                    }
                } else if (PbActivity.this.fvj) {
                    PbActivity.this.fvj = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.baK().bdF() != null && postData5.vk() != null && postData5.bwf() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.baK().bdG() != null) {
                                    PbActivity.this.baK().bdG().bbU();
                                }
                                com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                                kVar2.a(PbActivity.this.fvs.getPbData().aZl());
                                kVar2.Z(PbActivity.this.fvs.getPbData().aZn());
                                kVar2.d(postData5);
                                PbActivity.this.baK().bdF().d(kVar2);
                                PbActivity.this.baK().bdF().setPostId(postData5.getId());
                                PbActivity.this.a(view, postData5.vk().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fvI != null) {
                                    PbActivity.this.fvv.ko(PbActivity.this.fvI.HZ());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aOc = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.auB();
            PbActivity.this.fvv.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.ak.KW() && PbActivity.this.bat() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bat().rj(postWriteCallBackData.getPostId());
                    PbActivity.this.fvV = PbActivity.this.fvv.bdK();
                    if (PbActivity.this.fvs != null) {
                        PbActivity.this.fvs.bq(PbActivity.this.fvV, PbActivity.this.fvv.bdL());
                    }
                }
                PbActivity.this.fvv.beq();
                PbActivity.this.fvA.beP();
                if (PbActivity.this.fvI != null) {
                    PbActivity.this.fvv.ko(PbActivity.this.fvI.HZ());
                }
                PbActivity.this.fvv.bdE();
                PbActivity.this.fvv.kq(true);
                PbActivity.this.fvs.bcy();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fvs.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvs.getPbData();
                            if (pbData != null && pbData.aZn() != null && pbData.aZn().vk() != null && (userId = pbData.aZn().vk().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.ak.KW() && PbActivity.this.fvs.bcr()) {
                                PbActivity.this.fvv.beb();
                            }
                        } else if (!com.baidu.tbadk.p.ak.KW() && PbActivity.this.fvs.bcr()) {
                            PbActivity.this.fvv.beb();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fvv.n(PbActivity.this.fvs.getPbData());
                    }
                    if (PbActivity.this.fvs.bcn()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").af("tid", PbActivity.this.fvs.bci()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fvI.If() || PbActivity.this.fvI.Ig()) {
                    PbActivity.this.fvI.a(false, postWriteCallBackData);
                }
                PbActivity.this.fvA.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.eIc != null) {
                    PbActivity.this.eIc.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fwu = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fvA != null) {
                    PbActivity.this.fvA.beO();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.eIc != null) {
                    PbActivity.this.eIc.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fvA != null) {
                if (PbActivity.this.fvv != null && PbActivity.this.fvv.bdG() != null && PbActivity.this.fvv.bdG().bbZ() != null && PbActivity.this.fvv.bdG().bbZ().Ig()) {
                    PbActivity.this.fvv.bdG().bbZ().a(postWriteCallBackData);
                }
                PbActivity.this.fvA.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fwv = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g eL;
            if (!z || dVar == null || dVar.aZx() != null || com.baidu.tbadk.core.util.w.y(dVar.aZp()) >= 1) {
                PbActivity.this.eYY = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fvv.bed();
                if (dVar == null || !dVar.aZt()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fvv.getView());
                }
                PbActivity.this.fvv.aLF();
                if (PbActivity.this.isFullScreen || PbActivity.this.fvv.beI()) {
                    PbActivity.this.fvv.bez();
                } else if (!PbActivity.this.fvv.bew()) {
                    PbActivity.this.fvv.kq(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fvC = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.fvv.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.fvv.agN();
                    if (dVar.aZn() != null && dVar.aZn().wd() != null) {
                        PbActivity.this.a(dVar.aZn().wd());
                    }
                    PbActivity.this.baH();
                    if (PbActivity.this.fvI != null) {
                        PbActivity.this.fvv.ko(PbActivity.this.fvI.HZ());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.aZp() != null && dVar.aZp().size() >= 1 && dVar.aZp().get(0) != null) {
                        PbActivity.this.fvs.ri(dVar.aZp().get(0).getId());
                    } else if (dVar.aZx() != null) {
                        PbActivity.this.fvs.ri(dVar.aZx().getId());
                    }
                    if (PbActivity.this.fvI != null) {
                        PbActivity.this.fvI.a(dVar.uh());
                        PbActivity.this.fvI.a(dVar.aZl(), dVar.getUserData());
                        PbActivity.this.fvI.a(PbActivity.this.fvs.bcs(), PbActivity.this.fvs.bci(), PbActivity.this.fvs.bcL());
                        if (dVar.aZn() != null) {
                            PbActivity.this.fvI.bJ(dVar.aZn().wt());
                        }
                    }
                    if (PbActivity.this.fvu != null) {
                        PbActivity.this.fvu.ad(dVar.rN());
                    }
                    if (dVar == null || dVar.aZA() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fvv.kp(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fvv.a(dVar, i2, i3, PbActivity.this.fvs.bcj(), i4, PbActivity.this.fvs.getIsFromMark());
                    PbActivity.this.fvv.d(dVar, PbActivity.this.fvs.bcj());
                    PbActivity.this.fvv.km(PbActivity.this.fvs.getHostMode());
                    AntiData uh = dVar.uh();
                    if (uh != null) {
                        PbActivity.this.aNS = uh.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aNS) && PbActivity.this.fvI != null && PbActivity.this.fvI.Ht() != null && (eL = PbActivity.this.fvI.Ht().eL(6)) != null && !TextUtils.isEmpty(PbActivity.this.aNS)) {
                            ((View) eL).setOnClickListener(PbActivity.this.aOC);
                        }
                    }
                    if (PbActivity.this.fvE) {
                        PbActivity.this.fvE = false;
                        final int baV = PbActivity.this.baV();
                        if (dVar.aZM()) {
                            final int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(baV, ah);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.baK().qO(baV);
                        }
                    }
                    if (PbActivity.this.fvF) {
                        PbActivity.this.fvF = false;
                        final int baV2 = PbActivity.this.baV();
                        final boolean z2 = baV2 != -1;
                        if (!z2) {
                            baV2 = PbActivity.this.baW();
                        }
                        if (PbActivity.this.baK() != null) {
                            if (dVar.aZM()) {
                                final int ah2 = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (baV2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(baV2, ah2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(baV2 - 1, ah2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.baK().qO(baV2);
                            }
                        }
                    } else {
                        PbActivity.this.fvv.beh();
                    }
                    PbActivity.this.fvs.a(dVar.aZl(), PbActivity.this.fwi);
                    PbActivity.this.fvs.a(PbActivity.this.fwj);
                    if (PbActivity.this.eIc != null && dVar.aZn() != null && dVar.aZn().vk() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.aZn().vk());
                        PbActivity.this.eIc.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fvC && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fvs != null && PbActivity.this.fvs.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fvs.getAppealInfo().fss)) {
                                    PbActivity.this.fvv.a(PbActivity.this.fvs.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fvv.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fvv.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.fvv.bez();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fvs.bci());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getForumId());
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
                        PbActivity.this.fvv.rm(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                    } else {
                        PbActivity.this.fvv.rm("");
                    }
                    PbActivity.this.fvv.Ay();
                }
                PbActivity.this.aTT = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bat().bcj() || PbActivity.this.bat().getPbData().uw().ut() != 0 || PbActivity.this.bat().bcE()) {
                    PbActivity.this.fvJ = true;
                    return;
                }
                return;
            }
            PbActivity.this.fvs.qD(1);
            if (PbActivity.this.fuZ != null) {
                PbActivity.this.fuZ.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fvv.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.m.KF().KG()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.cSN : j;
                com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, PbActivity.this.aTL, PbActivity.this.createTime, PbActivity.this.aTT, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aTL = 0L;
                if (iVar != null) {
                    iVar.KC();
                }
                if (z2) {
                    iVar.aUc = currentTimeMillis;
                    iVar.bX(true);
                }
                if (!z2 && PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZn() != null) {
                    int threadType = PbActivity.this.fvs.getPbData().aZn().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.fvm, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.fvm, "from_frs")) {
                                com.baidu.tbadk.l.i iVar2 = new com.baidu.tbadk.l.i();
                                iVar2.fm(1000);
                                iVar2.aUe = currentTimeMillis;
                                iVar2.fn(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.l.d dVar = new com.baidu.tbadk.l.d();
                        dVar.pageType = 1;
                        dVar.fm(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
                        dVar.aUe = currentTimeMillis;
                        dVar.fn(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fww = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.baR();
            }
        }
    };
    private final a.InterfaceC0097a fwx = new a.InterfaceC0097a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0097a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fvv.bed();
            if (z) {
                if (PbActivity.this.fvu != null) {
                    PbActivity.this.fvu.ad(z2);
                }
                PbActivity.this.fvs.jR(z2);
                if (PbActivity.this.fvs.rN()) {
                    PbActivity.this.bbb();
                } else {
                    PbActivity.this.fvv.n(PbActivity.this.fvs.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fvu != null && PbActivity.this.fvu.rQ() != null && PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZn() != null && PbActivity.this.fvs.getPbData().aZn().vk() != null) {
                        MarkData rQ = PbActivity.this.fvu.rQ();
                        MetaData vk = PbActivity.this.fvs.getPbData().aZn().vk();
                        if (rQ != null && vk != null) {
                            if (!com.baidu.tbadk.core.util.ap.equals(TbadkCoreApplication.getCurrentAccount(), vk.getUserId()) && !vk.hadConcerned()) {
                                PbActivity.this.b(vk);
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
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.qq(PbActivity.this.mLastScrollState) && PbActivity.this.qq(i)) {
                if (PbActivity.this.fvv != null) {
                    PbActivity.this.fvv.beq();
                    if (PbActivity.this.fvI != null && !PbActivity.this.fvv.bdI()) {
                        PbActivity.this.fvv.ko(PbActivity.this.fvI.HZ());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fvv.bdH();
                    }
                }
                if (!PbActivity.this.fvg) {
                    PbActivity.this.fvg = true;
                    PbActivity.this.fvv.bev();
                }
            }
            PbActivity.this.fvv.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fuZ != null) {
                PbActivity.this.fuZ.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fvh == null) {
                PbActivity.this.fvh = new com.baidu.tbadk.l.b();
                PbActivity.this.fvh.fm(1001);
            }
            if (i == 0) {
                PbActivity.this.fvh.Kw();
            } else {
                PbActivity.this.fvh.Kv();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> aZp;
            if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvv != null && PbActivity.this.fvv.bdX() != null) {
                PbActivity.this.fvv.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fuZ != null) {
                    PbActivity.this.fuZ.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fvs.bcA() && (aZp = PbActivity.this.fvs.getPbData().aZp()) != null && !aZp.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fvv.bdX().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fvs.getPbData();
                    if (pbData != null) {
                        if (pbData.aZq() != null && pbData.aZq().hasData()) {
                            headerCount--;
                        }
                        if (pbData.aZr() != null && pbData.aZr().hasData()) {
                            headerCount--;
                        }
                        int size = aZp.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d czQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.czM.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fvs.bcy();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fLw != 1002 || bVar.dPN) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fvv.a(1, dVar.EX, dVar.gQr, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.czM.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fvv.a(PbActivity.this.czM.getLoadDataMode(), gVar.EX, gVar.gQr, false);
                        PbActivity.this.fvv.aq(gVar.gQu);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fvv.a(PbActivity.this.czM.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fwy = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
    };
    private final g.b bpx = new g.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
        @Override // com.baidu.tbadk.core.view.g.b
        public void aS(boolean z) {
            if (PbActivity.this.bbh()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fvs.jQ(true)) {
                PbActivity.this.fvv.bee();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fwA = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fwz && PbActivity.this.bbh()) {
                PbActivity.this.bbj();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fvs.jP(false)) {
                    PbActivity.this.fvv.bec();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fvs.getPbData() != null) {
                    PbActivity.this.fvv.beu();
                }
                PbActivity.this.fwz = true;
            }
        }
    };
    private int fwB = 0;
    private final TbRichTextView.h bgd = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fvv.b((TbRichText) view.getTag());
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
                    PbActivity.this.fvq = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fxq) {
                    TbRichText aB = PbActivity.this.aB(str, i);
                    if (aB != null && PbActivity.this.fwB >= 0 && PbActivity.this.fwB < aB.Nx().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aB.Nx().get(PbActivity.this.fwB));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fxn.size()) {
                                break;
                            } else if (!cVar.fxn.get(i3).equals(b2)) {
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
                            concurrentHashMap.put(str2, cVar.fxo.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fxp, cVar.lastId, PbActivity.this.fvs.bcw(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.w.d(cVar.fxn, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.w.z(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fxo.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fxp, cVar.fxn.get(0), PbActivity.this.fvs.bcw(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fwC = false;
    PostData fwD = null;
    private final b.InterfaceC0101b fwE = new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fwD != null) {
                if (i == 0) {
                    PbActivity.this.fwD.ci(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fwD = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.e(PbActivity.this.fwD);
                }
            }
        }
    };
    private final b.InterfaceC0101b fwF = new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fvS != null && !TextUtils.isEmpty(PbActivity.this.fvT)) {
                if (i == 0) {
                    if (PbActivity.this.fvU == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fvT));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fvT;
                        aVar.pkgId = PbActivity.this.fvU.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fvU.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bkU == null) {
                        PbActivity.this.bkU = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bkU.zY();
                    PbActivity.this.bkU.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bkU.u(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fvR == null) {
                            PbActivity.this.fvR = new ax(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fvR.i(PbActivity.this.fvT, PbActivity.this.fvS.ne());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fvS = null;
                PbActivity.this.fvT = null;
            }
        }
    };
    private final View.OnLongClickListener aHk = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.fvS = ((TbImageView) view).getBdImage();
                PbActivity.this.fvT = ((TbImageView) view).getUrl();
                if (PbActivity.this.fvS != null && !TextUtils.isEmpty(PbActivity.this.fvT)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvU = null;
                    } else {
                        PbActivity.this.fvU = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvv.a(PbActivity.this.fwF, PbActivity.this.fvS.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.fvS = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.fvT = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvU = null;
                    } else {
                        PbActivity.this.fvU = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvv.a(PbActivity.this.fwF, PbActivity.this.fvS.isGif());
                }
            } else if (view instanceof TbMemeImageView) {
                if (((TbMemeImageView) view).getBdImage() != null) {
                    PbActivity.this.fvS = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        PbActivity.this.fvT = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.fvU = null;
                    } else {
                        PbActivity.this.fvU = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.fvv.a(PbActivity.this.fwF, PbActivity.this.fvS.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fwD = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fwD != null && PbActivity.this.fvu != null) {
                        PbActivity.this.fvv.a(PbActivity.this.fwE, PbActivity.this.fvu.rN() && PbActivity.this.fwD.getId() != null && PbActivity.this.fwD.getId().equals(PbActivity.this.fvs.vu()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dkf = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (!PbActivity.this.fvb && z && !PbActivity.this.fvs.bcq()) {
                PbActivity.this.bbd();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(PbActivity.this.getApplicationContext(), d.e.ds200));
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
            PbActivity.this.bKb.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0145a bKc = new a.InterfaceC0145a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        final int cnC;

        {
            this.cnC = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Y(int i, int i2) {
            if (ae(i2) && PbActivity.this.fvv != null && PbActivity.this.fuZ != null) {
                PbActivity.this.fvv.beA();
                PbActivity.this.fuZ.fN(false);
                PbActivity.this.fuZ.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Z(int i, int i2) {
            if (ae(i2) && PbActivity.this.fvv != null && PbActivity.this.fuZ != null) {
                PbActivity.this.fuZ.fN(true);
                if (Math.abs(i2) > this.cnC) {
                    PbActivity.this.fuZ.hideFloatingView();
                }
                if (PbActivity.this.bbh()) {
                    PbActivity.this.fvv.bdT();
                    PbActivity.this.fvv.bdU();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void aa(int i, int i2) {
        }

        private boolean ae(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fwH = null;
    private final m.a fwI = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void h(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fwH = str2;
                PbActivity.this.fvv.rn(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fwJ = -1;
    private int fwK = -1;
    private CustomMessageListener fwN = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.100
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.acT == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0099a) {
                    if (aVar.acU != null && !aVar.acU.hasError() && aVar.acU.getError() == 0) {
                        if (PbActivity.this.fvv != null) {
                            PbActivity.this.fvv.k(((a.C0099a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bbs();
                        }
                    } else if (z) {
                        if (aVar.acU != null && aVar.acU.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.acU.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.acU != null && !aVar.acU.hasError() && aVar.acU.getError() == 0) {
                        if (PbActivity.this.fvv != null && PbActivity.this.fvv != null) {
                            PbActivity.this.fvv.k(((a.C0099a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.acU != null && aVar.acU.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.acU.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.acU == null || aVar.acU.hasError() || aVar.acU.getError() != 0) {
                        if (z) {
                            if (aVar.acU != null && aVar.acU.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.acU.getErrorString());
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
        public ArrayList<String> fxn;
        public ConcurrentHashMap<String, ImageUrlData> fxo;
        public boolean fxq;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fxp = false;
        public boolean fxr = false;
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

    public com.baidu.tbadk.editortools.pb.d baF() {
        return this.fvI;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        if (kVar.aZZ() != null) {
            String id = kVar.aZZ().getId();
            ArrayList<PostData> aZp = this.fvs.getPbData().aZp();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aZp.size()) {
                    break;
                }
                PostData postData = aZp.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> bad = kVar.bad();
                    postData.tI(kVar.getTotalCount());
                    if (postData.bwc() != null && bad != null) {
                        Iterator<PostData> it = bad.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.vk() != null && (metaData = postData.getUserMap().get(next.vk().getUserId())) != null) {
                                next.a(metaData);
                                next.mt(true);
                                next.b(getPageContext(), this.fvs.rh(metaData.getUserId()));
                            }
                        }
                        postData.bwc().clear();
                        postData.bwc().addAll(bad);
                    }
                    if (postData.bvY() != null) {
                        postData.bvZ();
                    }
                }
            }
            if (!this.fvs.getIsFromMark()) {
                this.fvv.n(this.fvs.getPbData());
            }
            c(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(String str) {
        com.baidu.tieba.tbadkCore.data.l aZD;
        if (!TextUtils.isEmpty(str) && (aZD = this.fvs.getPbData().aZD()) != null && str.equals(aZD.getAdId())) {
            if (aZD.bvT() != null) {
                aZD.bvT().legoCard = null;
            }
            this.fvs.getPbData().aZE();
        }
    }

    public void baG() {
        com.baidu.tieba.pb.data.d pbData;
        bb aZn;
        if (!this.fwl) {
            if (!com.baidu.adp.lib.util.l.jV()) {
                showToast(d.j.no_network_guide);
            } else if (this.fwo) {
                this.fwl = true;
                if (this.fvs != null && (pbData = this.fvs.getPbData()) != null && (aZn = pbData.aZn()) != null) {
                    int isLike = aZn.uX() == null ? 0 : aZn.uX().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10796").af("tid", aZn.getId()));
                    }
                    if (this.fwm != null) {
                        this.fwm.a(aZn.vB(), aZn.getId(), isLike, "pb");
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
                bVar.ci(d.j.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.j.delete);
                    strArr[1] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fvv.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fvP);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fvP);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.j.un_mute) : getResources().getString(d.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.fvP);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fvP);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).xi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(int i) {
        bb aZn;
        String str;
        String F;
        if (this.fvs != null && this.fvs.getPbData() != null && (aZn = this.fvs.getPbData().aZn()) != null) {
            if (i == 1) {
                PraiseData uX = aZn.uX();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (uX == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        aZn.a(praiseData);
                    } else {
                        aZn.uX().getUser().add(0, metaData);
                        aZn.uX().setNum(aZn.uX().getNum() + 1);
                        aZn.uX().setIsLike(i);
                    }
                }
                if (aZn.uX() != null) {
                    if (aZn.uX().getNum() < 1) {
                        F = getResources().getString(d.j.zan);
                    } else {
                        F = com.baidu.tbadk.core.util.ap.F(aZn.uX().getNum());
                    }
                    this.fvv.M(F, true);
                }
            } else if (aZn.uX() != null) {
                aZn.uX().setIsLike(i);
                aZn.uX().setNum(aZn.uX().getNum() - 1);
                ArrayList<MetaData> user = aZn.uX().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            aZn.uX().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (aZn.uX().getNum() < 1) {
                    str = getResources().getString(d.j.zan);
                } else {
                    str = aZn.uX().getNum() + "";
                }
                this.fvv.M(str, false);
            }
            if (this.fvs.bcj()) {
                this.fvv.bdX().notifyDataSetChanged();
            } else {
                this.fvv.o(this.fvs.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fvs.z(bundle);
        if (this.dmp != null) {
            this.dmp.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fvI.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fvf = System.currentTimeMillis();
        this.fvN = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cSN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fvm = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fvm) && intent.getData() != null) {
                this.fvm = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fvm)) {
                this.fva = true;
            }
            this.fwJ = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fwK = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fwL = intent.getStringExtra("key_manga_title");
            this.fvE = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fvF = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bbh()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.fvW = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.cSN = System.currentTimeMillis();
        }
        this.aTL = this.fvf - this.cSN;
        super.onCreate(bundle);
        this.fvd = 0;
        y(bundle);
        if (this.fvs != null && this.fvs.getPbData() != null) {
            this.fvs.getPbData().qZ(this.source);
        }
        initUI();
        if (intent != null && this.fvv != null) {
            this.fvv.fED = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fvQ == null) {
                    this.fvQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fvv.rp("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fvQ, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fvs != null && this.fvs.getPbData() != null) {
                this.fvs.rk(stringExtra);
            }
        }
        this.dmp = new VoiceManager();
        this.dmp.onCreate(getPageContext());
        initData(bundle);
        this.fvH = new com.baidu.tbadk.editortools.pb.f();
        baH();
        this.fvI = (com.baidu.tbadk.editortools.pb.d) this.fvH.aZ(getActivity());
        this.fvI.b(this);
        this.fvI.a(this.aOc);
        this.fvI.a(this.aNV);
        this.fvI.a(this, bundle);
        this.fvI.Ht().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fvI.Ht().bC(true);
        jz(true);
        this.fvv.setEditorTools(this.fvI.Ht());
        this.fvI.a(this.fvs.bcs(), this.fvs.bci(), this.fvs.bcL());
        registerListener(this.fwd);
        if (!this.fvs.bcp()) {
            this.fvI.gL(this.fvs.bci());
        }
        if (this.fvs.bcM()) {
            this.fvI.gJ(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fvI.gJ(getPageContext().getString(d.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fwc);
        registerListener(this.fwe);
        registerListener(this.fwf);
        registerListener(this.dny);
        registerListener(this.fwt);
        registerListener(this.fwb);
        this.fvG = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gNt);
        this.fvG.bvG();
        registerListener(this.fwh);
        registerListener(this.mAttentionListener);
        if (this.fvs != null) {
            this.fvs.bcC();
        }
        registerListener(this.fww);
        registerListener(this.fwN);
        registerListener(this.dnF);
        if (this.fvv != null && this.fvv.beE() != null && this.fvv.beF() != null) {
            this.fuZ = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.fvv.beE(), this.fvv.beF(), this.fvv.bdO());
            this.fuZ.a(this.fwp);
        }
        if (this.fuY && this.fvv != null && this.fvv.beF() != null) {
            this.fvv.beF().setVisibility(8);
        }
        this.fvO = new com.baidu.tbadk.core.view.d();
        this.fvO.auS = 1000L;
        registerListener(this.fws);
        registerListener(this.fwq);
        registerListener(this.fwr);
        registerListener(this.dEl);
        this.fvP = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fvP;
        userMuteAddAndDelCustomMessage.setTag(this.fvP);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fvP;
        userMuteCheckCustomMessage.setTag(this.fvP);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fvs.bcJ().a(this.ccL);
        if ("from_tieba_kuang".equals(this.fvm) && this.fvm != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12264").r("obj_type", 2).af("tid", this.fvs.bci()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                    @Override // com.baidu.tbadk.core.e
                    public void aj(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
            httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bh("shoubai://internal?type=pb&param=" + this.fvs.bci()));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        this.fvA = new av();
        if (this.fvI.HS() != null) {
            this.fvA.g(this.fvI.HS().getInputView());
        }
        this.fvI.a(this.aNW);
        this.dBy = new ShareSuccessReplyToServerModel();
        a(this.fvY);
        this.eIc = new com.baidu.tbadk.core.util.ak(getPageContext());
        this.eIc.a(new ak.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.ak.aqz) {
                        PbActivity.this.fvI.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.ak.aqA && PbActivity.this.fvv != null && PbActivity.this.fvv.bdG() != null && PbActivity.this.fvv.bdG().bbZ() != null) {
                        PbActivity.this.fvv.bdG().bbZ().Il();
                    } else if (i == com.baidu.tbadk.core.util.ak.aqB) {
                        PbActivity.this.c(PbActivity.this.fvK);
                    }
                }
            }
        });
        this.fvt = new com.baidu.tieba.pb.pb.report.a(this);
        this.fvt.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.fvf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baH() {
        if (this.fvH != null && this.fvs != null) {
            this.fvH.setForumName(this.fvs.bch());
            if (this.fvs.getPbData() != null && this.fvs.getPbData().aZl() != null) {
                this.fvH.a(this.fvs.getPbData().aZl());
            }
            this.fvH.setFrom("pb");
            this.fvH.a(this.fvs);
        }
    }

    public String baI() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b baJ() {
        return this.fuZ;
    }

    private void jz(boolean z) {
        this.fvI.bG(z);
        this.fvI.bH(z);
        this.fvI.bI(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZM() && !z && this.fvv != null && this.fvv.getView() != null) {
            this.fvv.getView().setSystemUiVisibility(4);
        }
        this.fvL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dmp != null) {
            this.dmp.onStart(getPageContext());
        }
    }

    public at baK() {
        return this.fvv;
    }

    public PbModel bat() {
        return this.fvs;
    }

    public void rb(String str) {
        if (this.fvs != null && !StringUtils.isNull(str) && this.fvv != null) {
            this.fvv.ks(true);
            this.fvs.rb(str);
            this.fvl = true;
            this.fvv.beq();
            this.fvv.bez();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fvb = false;
        } else {
            this.fvb = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fvd = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fvd == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dmp != null) {
            this.dmp.onPause(getPageContext());
        }
        if (this.fvv != null) {
            this.fvv.onPause();
        }
        if (!this.fvs.bcp()) {
            this.fvI.gK(this.fvs.bci());
        }
        if (this.fvs != null) {
            this.fvs.bcD();
        }
        MessageManager.getInstance().unRegisterListener(this.elL);
        aFl();
        MessageManager.getInstance().unRegisterListener(this.fwq);
        MessageManager.getInstance().unRegisterListener(this.fwr);
        MessageManager.getInstance().unRegisterListener(this.fws);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean baL() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fvs.getPbData(), this.fvs.bcj(), this.fvs.getRequestType());
        return (a2 == null || a2.vk() == null || a2.vk().getGodUserData() == null || a2.vk().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fvb = false;
        super.onResume();
        if (this.fvo) {
            this.fvo = false;
            bbn();
        }
        if (baL()) {
            this.fvi = System.currentTimeMillis();
        } else {
            this.fvi = -1L;
        }
        if (this.fvv != null && this.fvv.getView() != null) {
            if (!this.eYY) {
                bbe();
            } else {
                hideLoadingView(this.fvv.getView());
            }
            this.fvv.onResume();
        }
        if (this.fvd == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fvv != null) {
            noNetworkView = this.fvv.bdD();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.jE()) {
            noNetworkView.aP(false);
        }
        if (this.dmp != null) {
            this.dmp.onResume(getPageContext());
        }
        registerListener(this.elL);
        this.fvD = false;
        bbm();
        registerListener(this.fwq);
        registerListener(this.fwr);
        registerListener(this.fws);
        if (this.dmY) {
            bbd();
            this.dmY = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
                @Override // com.baidu.tbadk.core.e
                public void aj(boolean z) {
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
        this.fvv.kh(z);
        if (this.fvB != null) {
            this.fvB.jT(z);
        }
        if (z && this.fvD) {
            this.fvv.bec();
            this.fvs.jP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fvi > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").af("obj_duration", (System.currentTimeMillis() - this.fvi) + ""));
            this.fvi = 0L;
        }
        if (baK().bdG() != null) {
            baK().bdG().onStop();
        }
        if (this.fvv.fEK != null && !this.fvv.fEK.ajF()) {
            this.fvv.fEK.aQG();
        }
        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZl() != null && this.fvs.getPbData().aZn() != null) {
            com.baidu.tbadk.distribute.a.Hf().a(getPageContext().getPageActivity(), "pb", this.fvs.getPbData().aZl().getId(), com.baidu.adp.lib.g.b.c(this.fvs.getPbData().aZn().getId(), 0L));
        }
        if (this.dmp != null) {
            this.dmp.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.fvg && this.fvv != null) {
            this.fvg = true;
            this.fvv.bev();
            a(false, (PostData) null);
        }
        if (this.fvs != null) {
            this.fvs.cancelLoadData();
            this.fvs.destory();
            if (this.fvs.bcI() != null) {
                this.fvs.bcI().onDestroy();
            }
        }
        if (this.fvI != null) {
            this.fvI.onDestroy();
        }
        if (this.czM != null) {
            this.czM.cancelLoadData();
        }
        if (this.fvv != null) {
            this.fvv.onDestroy();
            if (this.fvv.fEK != null) {
                this.fvv.fEK.aQG();
            }
        }
        if (this.fvh != null) {
            this.fvh.Kx();
        }
        if (this.fuZ != null) {
            this.fuZ.Lt();
        }
        super.onDestroy();
        if (this.dmp != null) {
            this.dmp.onDestory(getPageContext());
        }
        this.fvv.beq();
        MessageManager.getInstance().unRegisterListener(this.fwq);
        MessageManager.getInstance().unRegisterListener(this.fwr);
        MessageManager.getInstance().unRegisterListener(this.fws);
        MessageManager.getInstance().unRegisterListener(this.fvP);
        MessageManager.getInstance().unRegisterListener(this.fwt);
        MessageManager.getInstance().unRegisterListener(this.dnF);
        MessageManager.getInstance().unRegisterListener(this.dEl);
        this.fvN = null;
        this.fvO = null;
        com.baidu.tieba.recapp.d.a.bod().bof();
        if (this.fvQ != null) {
            getSafeHandler().removeCallbacks(this.fvQ);
        }
        if (this.fvp != null) {
            this.fvp.cancelLoadData();
        }
        if (this.fvv != null && this.fvv.fEK != null) {
            this.fvv.fEK.bfm();
        }
        if (this.dBy != null) {
            this.dBy.cancelLoadData();
        }
        this.fvA.onDestroy();
        if (this.dnc != null) {
            this.dnc.onDestroy();
        }
        if (this.fvs != null && this.fvs.bcK() != null) {
            this.fvs.bcK().onDestroy();
        }
        if (this.eIc != null) {
            this.eIc.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bdX;
        ArrayList<PostData> bbL;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.BP() && this.fvv != null && (bdX = this.fvv.bdX()) != null && (bbL = bdX.bbL()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bbL.iterator();
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
                        bVar.cBL = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aiA == 1 && !TextUtils.isEmpty(id)) {
                    next.aiA = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.cBL = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fvs == null || this.fvs.getPbData() == null || this.fvs.getPbData().aZl() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fvs.getPbData().aZl().getFirst_class();
                    str2 = this.fvs.getPbData().aZl().getSecond_class();
                    str = this.fvs.getPbData().aZl().getId();
                    str4 = this.fvs.bci();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.BS());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fvv.onChangeSkinType(i);
            if (this.fvI != null && this.fvI.Ht() != null) {
                this.fvI.Ht().onChangeSkinType(i);
            }
            if (this.fvv.bdD() != null) {
                this.fvv.bdD().onChangeSkinType(getPageContext(), i);
            }
            this.fvA.onChangeSkinType();
            if (this.dnc != null) {
                this.dnc.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fvv = new at(this, this.doi, this.bge);
        this.bKb = new com.baidu.tieba.f.b(getActivity());
        this.bKb.a(fwG);
        this.bKb.a(this.bKc);
        this.fvv.setOnScrollListener(this.mOnScrollListener);
        this.fvv.e(this.fwA);
        this.fvv.a(this.bpx);
        this.fvv.jt(com.baidu.tbadk.core.i.te().tk());
        this.fvv.setOnImageClickListener(this.bgd);
        this.fvv.b(this.aHk);
        this.fvv.h(this.dkf);
        this.fvv.a(this.fwy);
        this.fvv.kh(this.mIsLogin);
        if (getIntent() != null) {
            this.fvv.kt(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fvv.bdF().setFromForumId(this.fvs.getFromForumId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bc(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.gNV && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.te().tk()) {
                    return re(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fvs == null || this.fvs.getPbData() == null) {
                        return true;
                    }
                    if (baK().bdG() != null) {
                        baK().bdG().bbU();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.fvs.getPbData().aZl());
                    kVar.Z(this.fvs.getPbData().aZn());
                    kVar.d(postData);
                    baK().bdF().d(kVar);
                    baK().bdF().setPostId(postData.getId());
                    a(view, postData.vk().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fvI != null) {
                        this.fvv.ko(this.fvI.HZ());
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
        if (this.fvv != null) {
            if (z && !this.eYY) {
                bbe();
            } else {
                hideLoadingView(this.fvv.getView());
            }
            if (z && this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZM() && this.fvv.getView() != null) {
                this.fvv.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void baM() {
        if (this.fve == null) {
            this.fve = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fve.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fuT = PbActivity.this.fuT.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuT);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fvs.bci(), PbActivity.this.fuT, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fuT = PbActivity.this.fuT.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuT);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fvs.bci(), PbActivity.this.fuT, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fuT = PbActivity.this.fuT.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fuT);
                        bVar.dismiss();
                    }
                }
            }).cj(b.a.alb).ck(17).d(getPageContext());
        }
    }

    private void y(Bundle bundle) {
        this.fvs = new PbModel(this);
        this.fvs.a(this.fwv);
        if (this.fvs.bcG() != null) {
            this.fvs.bcG().a(this.fwI);
        }
        if (this.fvs.bcF() != null) {
            this.fvs.bcF().a(this.fwg);
        }
        if (this.fvs.bcI() != null) {
            this.fvs.bcI().b(this.fwa);
        }
        if (bundle != null) {
            this.fvs.initWithBundle(bundle);
        } else {
            this.fvs.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fvs.jS(true);
        }
        aj.bdq().L(this.fvs.bcg(), this.fvs.getIsFromMark());
        if (StringUtils.isNull(this.fvs.bci())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fvm) && this.fvm != null) {
            this.fvs.qJ(6);
        }
        if (this.fvs.bcH() != null) {
            this.fvs.bcH().a(this.fvZ);
        }
        if (this.fvs.bcK() != null) {
            this.fvs.bcK().a(this.dng);
        }
        this.fvs.JR();
    }

    private void initData(Bundle bundle) {
        this.fvu = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fvu != null) {
            this.fvu.a(this.fwx);
        }
        this.czM = new ForumManageModel(this);
        this.czM.setLoadDataCallBack(this.czQ);
        this.aqE = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fvv.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void i(Object obj) {
                if (!com.baidu.adp.lib.util.j.jE()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fvs.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fvs.getPbData().aZl().getId(), PbActivity.this.fvs.getPbData().aZl().getName(), PbActivity.this.fvs.getPbData().aZn().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fwm.setUniqueId(getUniqueId());
        this.fwm.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fvv.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fvP;
        userMuteCheckCustomMessage.setTag(this.fvP);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String baN() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fvs != null && (pbData = this.fvs.getPbData()) != null) {
            return pbData.aZy().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aZn() != null) {
            if (dVar.aZn().getThreadType() == 0) {
                return 1;
            }
            if (dVar.aZn().getThreadType() == 54) {
                return 2;
            }
            if (dVar.aZn().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData bd(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bwr()) {
                postData.cS(postData.bwq() - 1);
            } else {
                postData.cS(postData.bwq() + 1);
                com.baidu.tieba.n.a.bmV().y(getPageContext());
            }
            postData.mu(!postData.bwr());
            ((PbFloorAgreeView) view).a(postData.bwr(), postData.bwq(), true);
            final int i = postData.bwr() ? 0 : 1;
            this.fvs.bcH().a(postData.getId(), i, new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
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

    public com.baidu.tbadk.core.util.an baO() {
        return new com.baidu.tbadk.core.util.an("c12003").af("tid", this.fvs.fAH).r("obj_type", 0).af(ImageViewerConfig.FORUM_ID, this.fvs.getForumId()).r("obj_param1", this.fvs.getPbData().aZn().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && baP()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
                @Override // java.lang.Runnable
                public void run() {
                    int f;
                    int aj = (com.baidu.adp.lib.util.l.aj(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        f = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.f(PbActivity.this.getPageContext().getPageActivity(), d.e.ds120);
                    } else {
                        f = com.baidu.adp.lib.util.l.f(PbActivity.this.getPageContext().getPageActivity(), d.e.ds640);
                    }
                    int i = f - aj;
                    if (i > 0) {
                        PbActivity.this.baK().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.baK().bdG() != null) {
                        PbActivity.this.fvI.Ht().setVisibility(8);
                        PbActivity.this.baK().bdG().bO(str, str2);
                        com.baidu.tbadk.editortools.pb.g bbZ = PbActivity.this.baK().bdG().bbZ();
                        if (bbZ != null && PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null) {
                            bbZ.a(PbActivity.this.fvs.getPbData().uh());
                        }
                        if (PbActivity.this.fvA.beS() == null && PbActivity.this.baK().bdG().bbZ().It() != null) {
                            PbActivity.this.baK().bdG().bbZ().It().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fvA != null && PbActivity.this.fvA.beR() != null) {
                                        if (!PbActivity.this.fvA.beR().bFm()) {
                                            PbActivity.this.fvA.kv(false);
                                        }
                                        PbActivity.this.fvA.beR().no(false);
                                    }
                                }
                            });
                            PbActivity.this.fvA.h(PbActivity.this.baK().bdG().bbZ().It().getInputView());
                            PbActivity.this.baK().bdG().bbZ().a(PbActivity.this.fvM);
                        }
                    }
                    PbActivity.this.baK().bez();
                }
            }, 500L);
        }
    }

    public boolean baP() {
        if (this.eIc == null || this.fvs.getPbData() == null || this.fvs.getPbData().uh() == null) {
            return true;
        }
        return this.eIc.cP(this.fvs.getPbData().uh().replyPrivateFlag);
    }

    public boolean qs(int i) {
        if (this.eIc == null || this.fvs.getPbData() == null || this.fvs.getPbData().uh() == null) {
            return true;
        }
        return this.eIc.u(this.fvs.getPbData().uh().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.fvs != null && this.fvs.getPbData() != null && postData.bwf() > 1) {
            String bci = this.fvs.bci();
            String id = postData.getId();
            int aZz = this.fvs.getPbData() != null ? this.fvs.getPbData().aZz() : 0;
            c rf = rf(id);
            if (rf != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bci, id, "pb", true, null, false, null, aZz, postData.bfZ(), this.fvs.getPbData().uh(), false, postData.vk() != null ? postData.vk().getIconInfo() : null).addBigImageData(rf.fxn, rf.fxo, rf.fxp, rf.index);
                addBigImageData.setKeyPageStartFrom(this.fvs.bcO());
                addBigImageData.setFromFrsForumId(this.fvs.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        aq aqVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.jV()) {
                showToast(d.j.no_network_guide);
            } else if (bat() != null && bat().getPbData() != null && bat().getPbData().aZL() != null) {
                com.baidu.tieba.pb.data.j aZL = bat().getPbData().aZL();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof aq)) {
                    aqVar = null;
                } else {
                    aqVar = (aq) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (aZL != null) {
                    int i3 = -1;
                    if (z) {
                        aZL.qk(i);
                    } else if (aZL.aZT()) {
                        aZL.aZW();
                        i3 = 1;
                    } else {
                        aZL.qm(i);
                        i3 = 0;
                        com.baidu.tieba.n.a.bmV().y(getPageContext());
                    }
                    aZL.ql(i2);
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
                    if (this.fvs != null && this.fvs.bcH() != null) {
                        String str = "";
                        if (this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null) {
                            str = this.fvs.getPbData().aZn().vB();
                        }
                        if (this.fvs.getPbData() != null) {
                            this.fvs.getPbData().a(aZL);
                        }
                        if (z) {
                            this.fvs.bcH().a(str, 3, i, this.fvs.getForumId(), aVar);
                        } else {
                            this.fvs.bcH().a(str, i3, 3, i, this.fvs.getForumId(), aVar);
                            com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i();
                            iVar.ftm = i3;
                            iVar.ftn = aZL;
                            iVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016551, iVar));
                        }
                    }
                    if (aqVar != null) {
                        aqVar.b(aZL);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int baQ() {
        if (this.fvs.getPbData() == null || this.fvs.getPbData().aZn() == null) {
            return -1;
        }
        return this.fvs.getPbData().aZn().vN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baR() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.tf(this.fvs.getForumId()) && this.fvs.getPbData() != null && this.fvs.getPbData().aZl() != null) {
            if (this.fvs.getPbData().aZl().isLike() == 1) {
                this.fvs.bcK().ce(this.fvs.getForumId(), this.fvs.bci());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jA(boolean z) {
        if (this.fvs == null || this.fvs.getPbData() == null) {
            return false;
        }
        return ((this.fvs.getPbData().aZz() != 0) || this.fvs.getPbData().aZn() == null || this.fvs.getPbData().aZn().vk() == null || TextUtils.equals(this.fvs.getPbData().aZn().vk().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String baS() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.p.s.KX()) {
            return "";
        }
        PostData aZu = aZu();
        if (this.fvs == null || (pbData = this.fvs.getPbData()) == null || pbData.getUserData() == null || pbData.aZn() == null || aZu == null || aZu.vk() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !aZu.vk().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.aZn().uS() == 0) {
            return "";
        }
        if (pbData.aZn().uS() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean jB(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fvs == null || this.fvs.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fvs.getPbData();
        if (pbData.aZz() == 0) {
            List<com.baidu.tbadk.core.data.ay> aZJ = pbData.aZJ();
            if (com.baidu.tbadk.core.util.w.y(aZJ) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : aZJ) {
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
        return (z || this.fvs == null || this.fvs.getPbData() == null || this.fvs.getPbData().aZz() == 0) ? false : true;
    }

    public void baT() {
        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null && this.fvs.getPbData().aZn().vk() != null) {
            if (this.fvv != null) {
                this.fvv.bdE();
            }
            bb aZn = this.fvs.getPbData().aZn();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), aZn.vk().getUserId());
            ab abVar = new ab();
            int aZz = this.fvs.getPbData().aZz();
            if (aZz == 1) {
                abVar.fCI = true;
                abVar.fCH = true;
                abVar.fCP = aZn.vf() == 1;
                abVar.fCO = aZn.vg() == 1;
            } else {
                abVar.fCI = false;
                abVar.fCH = false;
            }
            if (aZz == 1002 && !equals) {
                abVar.fCT = true;
            }
            abVar.fCF = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.fCJ = jB(equals);
            abVar.fCK = baU();
            abVar.fCL = jC(equals);
            abVar.nJ = this.fvs.bcj();
            abVar.fCG = true;
            abVar.ftz = this.fvu != null && this.fvu.rN();
            abVar.fCE = jA(equals);
            abVar.fCR = baS();
            abVar.fCD = equals && this.fvv.bej();
            abVar.fCM = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.fCN = true;
            abVar.isHostOnly = this.fvs.getHostMode();
            abVar.fCQ = true;
            if (aZn.vC() == null) {
                abVar.fCS = true;
            } else {
                abVar.fCS = false;
            }
            this.fvv.fEK.a(abVar);
        }
    }

    private boolean baU() {
        if (this.fvs != null && this.fvs.bcj()) {
            return this.fvs.getPageData() == null || this.fvs.getPageData().ut() != 0;
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
        if (sparseArray != null && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null) {
            e(postData);
        }
    }

    public int baV() {
        if (baK() == null || baK().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = baK().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fti) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int baW() {
        if (baK() == null || baK().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = baK().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.gNU) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bbd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.dA(getResources().getString(d.j.mark_done));
            aVar.aB(true);
            aVar.dB(getResources().getString(d.j.mark_like));
            aVar.aA(true);
            aVar.au(false);
            aVar.b(getResources().getString(d.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").af(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").af(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aqE.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fvs.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).xf();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fvv.bed();
        this.fvs.jR(z);
        if (this.fvu != null) {
            this.fvu.ad(z);
            if (markData != null) {
                this.fvu.a(markData);
            }
        }
        if (this.fvs.rN()) {
            bbb();
        } else {
            this.fvv.n(this.fvs.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qq(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(String str) {
        this.fvt.ry(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fvs.bcp()) {
                    antiData.setBlock_forum_name(this.fvs.getPbData().aZl().getName());
                    antiData.setBlock_forum_id(this.fvs.getPbData().aZl().getId());
                    antiData.setUser_name(this.fvs.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fvs.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else if (baK() != null) {
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.aro));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.aro));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.aro));
            }
        } else if (i == 230277) {
            gR(str);
        } else {
            this.fvv.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.gQr) ? bVar.gQr : getString(d.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dB(string);
                aVar.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.au(true);
                aVar.b(getPageContext());
                aVar.xf();
            } else {
                this.fvv.a(0, bVar.EX, bVar.gQr, z);
            }
            if (bVar.EX) {
                if (bVar.gQp == 1) {
                    ArrayList<PostData> aZp = this.fvs.getPbData().aZp();
                    int size = aZp.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(aZp.get(i).getId())) {
                            i++;
                        } else {
                            aZp.remove(i);
                            break;
                        }
                    }
                    this.fvv.n(this.fvs.getPbData());
                } else if (bVar.gQp == 0) {
                    baX();
                } else if (bVar.gQp == 2) {
                    ArrayList<PostData> aZp2 = this.fvs.getPbData().aZp();
                    int size2 = aZp2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= aZp2.get(i2).bwc().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(aZp2.get(i2).bwc().get(i3).getId())) {
                                i3++;
                            } else {
                                aZp2.get(i2).bwc().remove(i3);
                                aZp2.get(i2).bwe();
                                z2 = true;
                                break;
                            }
                        }
                        aZp2.get(i2).tK(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fvv.n(this.fvs.getPbData());
                    }
                    a(bVar, this.fvv);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fvv.a(this.czM.getLoadDataMode(), gVar.EX, gVar.gQr, false);
            if (gVar.EX) {
                this.fvx = true;
                if (i == 2 || i == 3) {
                    this.fvy = true;
                    this.fvz = false;
                } else if (i == 4 || i == 5) {
                    this.fvy = false;
                    this.fvz = true;
                }
                if (i == 2) {
                    this.fvs.getPbData().aZn().bW(1);
                    this.fvs.setIsGood(1);
                } else if (i == 3) {
                    this.fvs.getPbData().aZn().bW(0);
                    this.fvs.setIsGood(0);
                } else if (i == 4) {
                    this.fvs.getPbData().aZn().bV(1);
                    this.fvs.jj(1);
                } else if (i == 5) {
                    this.fvs.getPbData().aZn().bV(0);
                    this.fvs.jj(0);
                }
                this.fvv.c(this.fvs.getPbData(), this.fvs.bcj());
            }
        }
    }

    private void baX() {
        if (this.fvs.bck() || this.fvs.bcm()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fvs.bci());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fvs.bci()));
        if (bbc()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baY() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData aZw;
        boolean z = false;
        if (this.fvv != null) {
            this.fvv.beq();
        }
        if (this.fvs != null && this.fvs.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fvs.getPbData().aZn().getId();
            if (this.fvs.isShareThread() && this.fvs.getPbData().aZn().ajH != null) {
                historyMessage.threadName = this.fvs.getPbData().aZn().ajH.showText;
            } else {
                historyMessage.threadName = this.fvs.getPbData().aZn().getTitle();
            }
            if (this.fvs.isShareThread() && !bbu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fvs.getPbData().aZl().getName();
            }
            ArrayList<PostData> aZp = this.fvs.getPbData().aZp();
            int bef = this.fvv != null ? this.fvv.bef() : 0;
            if (aZp != null && bef >= 0 && bef < aZp.size()) {
                historyMessage.postID = aZp.get(bef).getId();
            }
            historyMessage.isHostOnly = this.fvs.getHostMode();
            historyMessage.isSquence = this.fvs.bcj();
            historyMessage.isShareThread = this.fvs.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fvI != null) {
            this.fvI.onDestroy();
        }
        if (this.fvc && baK() != null) {
            baK().beJ();
        }
        if (this.fvs != null && (this.fvs.bck() || this.fvs.bcm())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fvs.bci());
            if (this.fvx) {
                if (this.fvz) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fvs.bco());
                }
                if (this.fvy) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fvs.getIsGood());
                }
            }
            if (this.fvs.getPbData() != null && System.currentTimeMillis() - this.fvf >= 40000 && (aZw = this.fvs.getPbData().aZw()) != null && !com.baidu.tbadk.core.util.w.z(aZw.getDataList())) {
                intent.putExtra("guess_like_data", aZw);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fvW);
            }
            setResult(-1, intent);
        }
        if (bbc()) {
            if (this.fvs != null && this.fvv != null && this.fvv.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fvs.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.aZt() && !this.fvl) {
                        aj bdq = aj.bdq();
                        com.baidu.tieba.pb.data.d pbData2 = this.fvs.getPbData();
                        Parcelable onSaveInstanceState = this.fvv.getListView().onSaveInstanceState();
                        boolean bcj = this.fvs.bcj();
                        boolean hostMode = this.fvs.getHostMode();
                        if (this.fvv.bdO() != null && this.fvv.bdO().getVisibility() == 0) {
                            z = true;
                        }
                        bdq.a(pbData2, onSaveInstanceState, bcj, hostMode, z);
                        if (this.fvV >= 0 || this.fvs.bcQ() != null) {
                            aj.bdq().i(this.fvs.bcQ());
                            aj.bdq().h(this.fvs.bcR());
                            aj.bdq().qL(this.fvs.bcS());
                        }
                    }
                }
            } else {
                aj.bdq().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fvv == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fvv.qP(i)) {
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
            this.fvv.bdE();
            this.fvv.bdG().bbU();
            this.fvv.kq(false);
        }
        this.fvv.bdH();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fvI.resetData();
                        this.fvI.b(writeData);
                        this.fvI.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k eO = this.fvI.Ht().eO(6);
                        if (eO != null && eO.aMf != null) {
                            eO.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fvI.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fvv.bdG() != null && this.fvv.bdG().bbZ() != null) {
                            com.baidu.tbadk.editortools.pb.g bbZ = this.fvv.bdG().bbZ();
                            bbZ.b(writeData);
                            bbZ.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k eO2 = bbZ.Ht().eO(6);
                            if (eO2 != null && eO2.aMf != null) {
                                eO2.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bbZ.Il();
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
        this.fvI.onActivityResult(i, i2, intent);
        if (this.fvp != null) {
            this.fvp.onActivityResult(i, i2, intent);
        }
        if (baK().bdG() != null) {
            baK().bdG().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bba();
                    return;
                case 13008:
                    aj.bdq().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fvs != null) {
                                PbActivity.this.fvs.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bmV().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fvs != null) {
                        a(baZ(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    J(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bmV().x(getPageContext());
                        baR();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dBy != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dBy.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
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
                    this.fvv.jy(false);
                    if (this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null && this.fvs.getPbData().aZn().vE() != null) {
                        this.fvs.getPbData().aZn().vE().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fvK = emotionImageData;
                        if (qs(com.baidu.tbadk.core.util.ak.aqB)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fvv != null && this.fvv.fEK != null) {
                        this.fvv.fEK.sz();
                        this.fvv.fEK.bfg();
                        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null) {
                            this.fvs.getPbData().aZn().bR(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fvq != null) {
                        this.fvv.bm(this.fvq);
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
            if (this.fvp == null) {
                this.fvp = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fvp.b(this.aNV);
                this.fvp.c(this.aOc);
            }
            this.fvp.a(emotionImageData, bat(), bat().getPbData());
        }
    }

    private ShareFromPBMsgData baZ() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bX = this.fvs.getPbData().bX(getPageContext().getPageActivity());
        PostData bdJ = this.fvv.bdJ();
        String str = "";
        if (bdJ != null) {
            str = bdJ.getId();
            String cj = bdJ.cj(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(cj)) {
                bX[1] = cj;
            }
        }
        String vB = this.fvs.getPbData().aZn().vB();
        if (vB != null && vB.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bX[1]);
        shareFromPBMsgData.setImageUrl(bX[0]);
        shareFromPBMsgData.setForumName(this.fvs.getPbData().aZl().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fvs.getPbData().aZn().getId());
        shareFromPBMsgData.setTitle(this.fvs.getPbData().aZn().getTitle());
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(baZ(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ch(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null) {
                        com.baidu.tbadk.core.util.an af = new com.baidu.tbadk.core.util.an("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).af(ImageViewerConfig.FORUM_ID, PbActivity.this.fvs.getForumId()).af("tid", PbActivity.this.fvs.bci());
                        if (PbActivity.this.e(PbActivity.this.fvs.getPbData()) != 0) {
                            af.r("obj_type", PbActivity.this.e(PbActivity.this.fvs.getPbData()));
                        }
                        TiebaStatic.log(af);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.av(true);
            aVar.b(getPageContext()).xf();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.fvs.getPbData().aZA() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ch(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.av(true);
            aVar.b(getPageContext()).xf();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.fvs.getPbData().aZA() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bba() {
        MarkData qI;
        if (this.fvu != null && (qI = this.fvs.qI(this.fvv.beg())) != null) {
            if (!qI.isApp() || (qI = this.fvs.qI(this.fvv.beg() + 1)) != null) {
                this.fvv.beb();
                this.fvu.a(qI);
                if (!this.fvu.rN()) {
                    this.fvu.rP();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fvu.rO();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbb() {
        com.baidu.tieba.pb.data.d pbData = this.fvs.getPbData();
        this.fvs.jR(true);
        if (this.fvu != null) {
            pbData.qY(this.fvu.rM());
        }
        this.fvv.n(pbData);
    }

    private boolean bbc() {
        if (this.fvs == null) {
            return true;
        }
        if (this.fvs.rN()) {
            final MarkData bcx = this.fvs.bcx();
            if (bcx == null || !this.fvs.getIsFromMark()) {
                return true;
            }
            final MarkData qI = this.fvs.qI(this.fvv.bef());
            if (qI == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bcx);
                setResult(-1, intent);
                return true;
            } else if (qI.getPostId() == null || qI.getPostId().equals(bcx.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bcx);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dB(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fvu != null) {
                            if (PbActivity.this.fvu.rN()) {
                                PbActivity.this.fvu.rO();
                                PbActivity.this.fvu.ad(false);
                            }
                            PbActivity.this.fvu.a(qI);
                            PbActivity.this.fvu.ad(true);
                            PbActivity.this.fvu.rP();
                        }
                        bcx.setPostId(qI.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bcx);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.baY();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bcx);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.baY();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fvv != null && PbActivity.this.fvv.getView() != null) {
                            PbActivity.this.fvv.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bcx);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.baY();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.xf();
                return false;
            }
        } else if (this.fvs.getPbData() == null || this.fvs.getPbData().aZp() == null || this.fvs.getPbData().aZp().size() <= 0 || !this.fvs.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fvv == null) {
            return null;
        }
        return this.fvv.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Oe() {
        if (this.fvv == null) {
            return 0;
        }
        return this.fvv.beo();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Of() {
        if (this.bfU == null) {
            this.bfU = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: afY */
                public ImageView ig() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean tk = com.baidu.tbadk.core.i.te().tk();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(d.C0140d.common_color_10220));
                    if (tk) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0140d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView r(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.te().tk()) {
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
                        foreDrawableImageView.setDefaultBgResource(d.C0140d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.bfU;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Og() {
        if (this.bfV == null) {
            this.bfV = TbRichTextView.k(getPageContext().getPageActivity(), 8);
        }
        return this.bfV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Oh() {
        if (this.bfZ == null) {
            this.bfZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbx */
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
        return this.bfZ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Oi() {
        if (this.bfW == null) {
            this.bfW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bby */
                public View ig() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
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
                    ((PlayVoiceBntNew) view).bxp();
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
        return this.bfW;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ok() {
        this.bfY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bbz */
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
        return this.bfY;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AT() {
        if (this.ayS == null) {
            this.ayS = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.ayS;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fvj = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void f(Context context, String str, boolean z) {
        if (ay.rq(str) && this.fvs != null && this.fvs.bci() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").r("obj_param1", 1).af("post_id", this.fvs.bci()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                hVar.mLink = str;
                hVar.type = 3;
                hVar.aLi = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
            }
        } else {
            ay.beU().c(getPageContext(), str);
        }
        this.fvj = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
        ay.beU().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fvj = true;
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
            com.baidu.tieba.pb.data.d pbData = this.fvs.getPbData();
            TbRichText aB = aB(str, i);
            if (aB != null && (tbRichTextData = aB.Nx().get(this.fwB)) != null) {
                cVar.fxn = new ArrayList<>();
                cVar.fxo = new ConcurrentHashMap<>();
                if (!tbRichTextData.ND().NP()) {
                    cVar.fxq = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fxn.add(b2);
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
                    imageUrlData.mIsReserver = this.fvs.bcw();
                    imageUrlData.mIsSeeHost = this.fvs.getHostMode();
                    cVar.fxo.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.aZl() != null) {
                            cVar.forumName = pbData.aZl().getName();
                            cVar.forumId = pbData.aZl().getId();
                        }
                        if (pbData.aZn() != null) {
                            cVar.threadId = pbData.aZn().getId();
                        }
                        cVar.fxp = pbData.aZA() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.fxq = true;
                int size = pbData.aZp().size();
                this.fwC = false;
                cVar.index = -1;
                if (pbData.aZu() != null) {
                    PostData aZu = pbData.aZu();
                    TbRichText bwh = aZu.bwh();
                    if (!as.j(aZu)) {
                        i2 = a(bwh, aB, i, i, cVar.fxn, cVar.fxo);
                    } else {
                        i2 = a(aZu, i, cVar.fxn, cVar.fxo);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.aZp().get(i4);
                    if (postData.getId() == null || pbData.aZu() == null || pbData.aZu().getId() == null || !postData.getId().equals(pbData.aZu().getId())) {
                        TbRichText bwh2 = postData.bwh();
                        if (!as.j(postData)) {
                            i3 = a(bwh2, aB, i3, i, cVar.fxn, cVar.fxo);
                        } else {
                            i3 = a(postData, i3, cVar.fxn, cVar.fxo);
                        }
                    }
                }
                if (cVar.fxn.size() > 0) {
                    cVar.lastId = cVar.fxn.get(cVar.fxn.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.aZl() != null) {
                        cVar.forumName = pbData.aZl().getName();
                        cVar.forumId = pbData.aZl().getId();
                    }
                    if (pbData.aZn() != null) {
                        cVar.threadId = pbData.aZn().getId();
                    }
                    cVar.fxp = pbData.aZA() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ND() == null) {
            return null;
        }
        return tbRichTextData.ND().NV();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ND() == null) {
            return 0L;
        }
        return tbRichTextData.ND().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ND() == null) {
            return false;
        }
        return tbRichTextData.ND().NW();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.ND() == null) {
            return false;
        }
        return tbRichTextData.ND().NX();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo ND;
        String str;
        if (tbRichText == tbRichText2) {
            this.fwC = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Nx().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Nx().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ak = (int) com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.ND().getWidth() * ak;
                    int height = ak * tbRichTextData.ND().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.ND().NP()) {
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
                            if (tbRichTextData != null && (ND = tbRichTextData.ND()) != null) {
                                String NS = ND.NS();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = ND.NT();
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fvs.bci(), -1L);
                                imageUrlData.mIsReserver = this.fvs.bcw();
                                imageUrlData.mIsSeeHost = this.fvs.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fwC) {
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
        com.baidu.tieba.tbadkCore.data.h bwo;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bvK;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bvK = (bwo = postData.bwo()).bvK()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bvK.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bvK.get(i3);
                if (jVar != null) {
                    String bvO = jVar.bvO();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(bvO)) {
                        arrayList.add(bvO);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bvO;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bvN();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fvs.bci(), -1L);
                        imageUrlData.mIsReserver = this.fvs.bcw();
                        imageUrlData.mIsSeeHost = this.fvs.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bwo.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bvO, imageUrlData);
                        }
                        if (!this.fwC) {
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
            if (postData.getId() != null && postData.getId().equals(this.fvs.vu())) {
                z = true;
            }
            MarkData g = this.fvs.g(postData);
            if (g != null) {
                this.fvv.beb();
                if (this.fvu != null) {
                    this.fvu.a(g);
                    if (!z) {
                        this.fvu.rP();
                    } else {
                        this.fvu.rO();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aB(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fvs == null || this.fvs.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fvs.getPbData();
        if (pbData.aZu() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.aZu());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> aZp = pbData.aZp();
            a(pbData, aZp);
            return a(aZp, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.aZy() != null && dVar.aZy().ftB != null && (list = dVar.aZy().ftB) != null && arrayList != null) {
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

    private long rd(String str) {
        ArrayList<PostData> aZp;
        com.baidu.tieba.pb.data.d pbData = this.fvs.getPbData();
        if (pbData != null && (aZp = pbData.aZp()) != null && !aZp.isEmpty()) {
            Iterator<PostData> it = aZp.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bwo = next.bwo();
                if (bwo != null && bwo.gNB) {
                    Iterator<TbRichTextData> it2 = next.bwh().Nx().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.NM().getLink().equals(str)) {
                            return bwo.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> Nx;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bwh = arrayList.get(i2).bwh();
            if (bwh != null && (Nx = bwh.Nx()) != null) {
                int size = Nx.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Nx.get(i4) != null && Nx.get(i4).getType() == 8) {
                        i3++;
                        if (Nx.get(i4).ND().NS().equals(str) || Nx.get(i4).ND().NT().equals(str)) {
                            int ak = (int) com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
                            int width = Nx.get(i4).ND().getWidth() * ak;
                            int height = Nx.get(i4).ND().getHeight() * ak;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fwB = i4;
                            return bwh;
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
            this.fuT = str;
            if (this.fve == null) {
                baM();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fve.cn(1).setVisibility(8);
            } else {
                this.fve.cn(1).setVisibility(0);
            }
            this.fve.xi();
            this.fvj = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dmp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbd() {
        hideNetRefreshView(this.fvv.getView());
        bbe();
        if (this.fvs.JR()) {
            this.fvv.beb();
        }
    }

    private void bbe() {
        showLoadingView(this.fvv.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View Ji = getLoadingView().Ji();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Ji.getLayoutParams();
        layoutParams.addRule(3, this.fvv.beE().getId());
        Ji.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auB() {
        if (this.dmp != null) {
            this.dmp.stopPlay();
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
        if (this.fvs.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fvs.getPbData();
            pbData.aZl().getName();
            String title = pbData.aZn().getTitle();
            int i2 = this.fvs.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.aZl() != null) {
                if ((pbData.aZl().isLike() == 1) && AddExperiencedModel.tf(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fvs.bci() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bX = pbData.bX(getPageContext().getPageActivity());
                    str = bX[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bX[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (baQ() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").af(ImageViewerConfig.FORUM_ID, pbData.getForumId()).af("tid", pbData.getThreadId()).af("uid", currentAccount));
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
                    dVar.extData = this.fvs.bci();
                    dVar.aGi = 3;
                    dVar.aGh = i;
                    dVar.fid = this.fvs.getForumId();
                    dVar.tid = this.fvs.bci();
                    dVar.aGj = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fvs.getPbData().aZn());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aGi);
                    bundle.putInt("obj_type", dVar.aGj);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.f(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZM()) {
                                PbActivity.this.fvv.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.akO().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fvs.bci() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bX2 = pbData.bX(getPageContext().getPageActivity());
            str = bX2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bX2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (baQ() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aFU = true;
            dVar2.aFZ = z;
            dVar2.extData = this.fvs.bci();
            dVar2.aGi = 3;
            dVar2.aGh = i;
            dVar2.fid = this.fvs.getForumId();
            dVar2.tid = this.fvs.bci();
            dVar2.aGj = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fvs.getPbData().aZn());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aGi);
            bundle2.putInt("obj_type", dVar2.aGj);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.f(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fvs != null && PbActivity.this.fvs.getPbData() != null && PbActivity.this.fvs.getPbData().aZM()) {
                        PbActivity.this.fvv.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.akO().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aZn() != null) {
            if (dVar.aZn().getThreadType() == 0) {
                return 1;
            }
            if (dVar.aZn().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbf() {
        com.baidu.tbadk.util.v.a(new com.baidu.tbadk.util.u<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.tg(PbActivity.this.fvs.getForumId()));
            }
        }, new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fvv.beK();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Oj() {
        if (this.bfX == null) {
            this.bfX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bbA */
                public LinearLayout ig() {
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
        return this.bfX;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fvv.bdW() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).af(ImageViewerConfig.FORUM_ID, this.fvs.getPbData().getForumId()));
            } else {
                bb aZn = this.fvs.getPbData().aZn();
                if (view != null) {
                    boolean z = aZn.uX() == null || aZn.uX().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fwn > 1000) {
                            this.fwo = true;
                            bf(view);
                        } else {
                            this.fwo = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            l(view, this.fwo);
                        } else {
                            k(view, this.fwo);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        k(view, this.fwo);
                    } else if (motionEvent.getAction() == 3) {
                        k(view, this.fwo);
                    }
                }
            }
        }
        return false;
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fwn = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void l(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fwn = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bf(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void auC() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData Ce() {
        if (this.fvs == null || this.fvs.getPbData() == null) {
            return null;
        }
        return this.fvs.getPbData().uh();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.xh() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.xh();
            int intValue = ((Integer) sparseArray.get(at.fGx)).intValue();
            if (intValue == at.fGy) {
                if (!this.czM.bwT()) {
                    this.fvv.bdY();
                    String str = (String) sparseArray.get(d.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.czM.tQ(com.baidu.tbadk.core.util.ap.d(jSONArray));
                    }
                    this.czM.a(this.fvs.getPbData().aZl().getId(), this.fvs.getPbData().aZl().getName(), this.fvs.getPbData().aZn().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == at.fGz || intValue == at.fGB) {
                if (this.fvs.bcG() != null) {
                    this.fvs.bcG().qz(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == at.fGz) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fvP);
        userMuteAddAndDelCustomMessage.setTag(this.fvP);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean re(String str) {
        if (!StringUtils.isNull(str) && ba.aV(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(d.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void jD(boolean z) {
        this.fvD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bbg() {
        ArrayList<PostData> aZp;
        int y;
        if (this.fvs == null || this.fvs.getPbData() == null || this.fvs.getPbData().aZp() == null || (y = com.baidu.tbadk.core.util.w.y((aZp = this.fvs.getPbData().aZp()))) == 0) {
            return "";
        }
        if (this.fvs.bcw()) {
            Iterator<PostData> it = aZp.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bwf() == 1) {
                    return next.getId();
                }
            }
        }
        int bef = this.fvv.bef();
        PostData postData = (PostData) com.baidu.tbadk.core.util.w.d(aZp, bef);
        if (postData == null || postData.vk() == null) {
            return "";
        }
        if (this.fvs.rh(postData.vk().getUserId())) {
            return postData.getId();
        }
        for (int i = bef - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.d(aZp, i);
            if (postData2 == null || postData2.vk() == null || postData2.vk().getUserId() == null) {
                break;
            } else if (this.fvs.rh(postData2.vk().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bef + 1; i2 < y; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.d(aZp, i2);
            if (postData3 == null || postData3.vk() == null || postData3.vk().getUserId() == null) {
                return "";
            }
            if (this.fvs.rh(postData3.vk().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ab(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.baidu.tbadk.core.util.ay.zK().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(rd(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fvs.getPbData().aZl().getId(), this.fvs.getPbData().aZl().getName(), this.fvs.getPbData().aZn().getTid());
            }
            this.fvj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.dB(getResources().getString(d.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.dB(getResources().getString(d.j.make_sure_hide));
        }
        aVar.a(getResources().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fvs.bcF() != null) {
                    PbActivity.this.fvs.bcF().cG(j);
                }
            }
        });
        aVar.b(getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.av(false);
        aVar.b(getPageContext());
        aVar.xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c rf(String str) {
        String str2;
        if (this.fvs.getPbData() == null || this.fvs.getPbData().aZp() == null || this.fvs.getPbData().aZp().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fvs.getPbData().aZp().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fvs.getPbData().aZp().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fvs.getPbData().aZp().get(i);
        if (postData.bwh() == null || postData.bwh().Nx() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bwh().Nx().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.ND() != null) {
                    str2 = next.ND().NS();
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
        if (this.fva) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fva = false;
        } else if (bbh()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fva) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fva = false;
        } else if (bbh()) {
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
        if (pageStayDurationItem != null && this.fvs != null) {
            if (this.fvs.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fvs.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fvs.bci(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean bbh() {
        return (!this.fuY && this.fwJ == -1 && this.fwK == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fwM = mVar;
            this.fuY = true;
            this.fvv.bdP();
            this.fvv.ro(this.fwL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbi() {
        if (this.fwM != null) {
            if (this.fwJ == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.aU(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fwM.getCartoonId(), this.fwJ, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbj() {
        if (this.fwM != null) {
            if (this.fwK == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.aU(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fwM.getCartoonId(), this.fwK, 0)));
                finish();
            }
        }
    }

    public int bbk() {
        return this.fwJ;
    }

    public int bbl() {
        return this.fwK;
    }

    private void aFl() {
        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null && this.fvs.getPbData().aZn().vW()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bbm() {
        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null && this.fvs.getPbData().aZn().vW()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bbn() {
        if (this.fvb) {
            this.fvo = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null && this.fvs.getPbData().aZn().uR() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fvs.getPbData().aZn().uR().getThreadId(), this.fvs.getPbData().aZn().uR().getTaskId(), this.fvs.getPbData().aZn().uR().getForumId(), this.fvs.getPbData().aZn().uR().getForumName(), this.fvs.getPbData().aZn().vf(), this.fvs.getPbData().aZn().vg())));
            this.fva = true;
            finish();
        }
    }

    public String bbo() {
        return this.fvm;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bbp() {
        return this.fvr;
    }

    public void jE(boolean z) {
        this.fvn = z;
    }

    public boolean bbq() {
        if (this.fvs != null) {
            return this.fvs.bck();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dB(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fvN).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fvN.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvN).xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fvN != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvN.getPageActivity());
            aVar.dB(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fvN).xf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fvv.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fvN.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.dB(this.fvN.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.dB(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.98
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fvv.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.99
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fvN).xf();
    }

    public void bbs() {
        if (this.fvs != null && this.fvs.getPbData() != null && this.fvs.getPbData().aZn() != null && this.fvs.getPbData().aZn().wl() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cf(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fvs.getPbData().aZn().wl().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.xf();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ay.rq(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.fvv != null) {
            this.fvv.onConfigurationChanged(configuration);
        }
        if (this.fvB != null) {
            this.fvB.dismiss();
        }
    }

    public boolean bbt() {
        if (this.fvs != null) {
            return this.fvs.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, at atVar) {
        boolean z;
        List<PostData> list = this.fvs.getPbData().aZy().ftB;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bwc().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bwc().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bwc().remove(i2);
                    list.get(i).bwe();
                    z = true;
                    break;
                }
            }
            list.get(i).tK(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            atVar.n(this.fvs.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.aZZ().getId();
        List<PostData> list = this.fvs.getPbData().aZy().ftB;
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
                ArrayList<PostData> bad = kVar.bad();
                postData.tI(kVar.getTotalCount());
                if (postData.bwc() != null) {
                    postData.bwc().clear();
                    postData.bwc().addAll(bad);
                }
            }
        }
        if (!this.fvs.getIsFromMark()) {
            this.fvv.n(this.fvs.getPbData());
        }
    }

    public boolean bbu() {
        if (this.fvs == null) {
            return false;
        }
        return this.fvs.bbu();
    }

    public void bbv() {
        if (this.fvv != null) {
            this.fvv.bdE();
            auC();
        }
    }

    public PostData aZu() {
        return this.fvv.b(this.fvs.fBa, this.fvs.bcj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ak(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.isLinkThread()) {
                return 3;
            }
            if (bbVar.wn()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fvX != null && !this.fvX.isEmpty()) {
            int size = this.fvX.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fvX.get(i).onBackPressed()) {
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
            if (this.fvX == null) {
                this.fvX = new ArrayList();
            }
            if (!this.fvX.contains(aVar)) {
                this.fvX.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fvX == null) {
                this.fvX = new ArrayList();
            }
            if (!this.fvX.contains(aVar)) {
                this.fvX.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fvX != null) {
            this.fvX.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dnc == null) {
            this.dnc = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dnc.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aC(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13061"));
                    }
                }
            });
        }
        this.dnc.a(contriInfo, -1L);
    }
}
