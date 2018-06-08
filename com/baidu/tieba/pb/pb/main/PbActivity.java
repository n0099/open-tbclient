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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bi;
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
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.f;
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
import com.baidu.tieba.pb.pb.main.q;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.main.y;
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
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.tencent.connect.common.Constants;
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
    private com.baidu.adp.lib.e.b<TbImageView> ayn;
    private com.baidu.tieba.f.b bHu;
    private com.baidu.adp.lib.e.b<ImageView> beu;
    private com.baidu.adp.lib.e.b<TextView> bev;
    private com.baidu.adp.lib.e.b<View> bew;
    private com.baidu.adp.lib.e.b<LinearLayout> bex;
    private com.baidu.adp.lib.e.b<RelativeLayout> bey;
    private com.baidu.adp.lib.e.b<GifView> bez;
    private com.baidu.tbadk.core.util.b.a biP;
    private VoiceManager dhB;
    private com.baidu.tbadk.core.dialog.h dio;
    public com.baidu.tbadk.core.util.aj eAs;
    private String fqP;
    private com.baidu.tieba.pb.pb.main.a.b fqV;
    private com.baidu.tieba.tbadkCore.data.e frC;
    private com.baidu.tbadk.editortools.pb.f frD;
    private com.baidu.tbadk.editortools.pb.d frE;
    private EmotionImageData frG;
    private com.baidu.adp.base.e frJ;
    private com.baidu.tbadk.core.view.c frK;
    private BdUniqueId frL;
    private Runnable frM;
    private aw frN;
    private com.baidu.adp.widget.ImageView.a frO;
    private String frP;
    private TbRichTextMemeInfo frQ;
    private List<a> frT;
    private com.baidu.tieba.pb.pb.main.emotion.model.a frl;
    private View frm;
    private com.baidu.tieba.pb.pb.report.a frp;
    public au frw;
    private x frx;
    private boolean frz;
    private String fsH;
    private com.baidu.tbadk.core.data.n fsI;
    private boolean fsv;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").r("obj_locate", as.a.arm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").r("obj_locate", as.a.arm));
        }
    };
    private static final b.a fsC = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.f.b.a
        public void fb(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bbl();
            } else {
                com.baidu.tieba.pb.a.b.bbk();
            }
        }
    };
    private boolean fqU = false;
    private boolean fqW = false;
    private boolean fqX = false;
    private boolean eVQ = false;
    private boolean fqY = true;
    private int fqZ = 0;
    private com.baidu.tbadk.core.dialog.b fra = null;
    private long cSd = -1;
    private long aSW = 0;
    private long frb = 0;
    private long createTime = 0;
    private long aSO = 0;
    private boolean frc = false;
    private com.baidu.tbadk.k.b frd = null;
    private long fre = 0;
    private boolean frf = false;
    private long frg = 0;
    private String aMX = null;
    private boolean frh = false;
    private boolean isFullScreen = false;
    private String fri = "";
    private boolean frj = true;
    private boolean frk = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a frn = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void t(boolean z) {
            PbActivity.this.frq.kn(!PbActivity.this.frj);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fro != null && PbActivity.this.fro.sc()) {
                        PbActivity.this.bcb();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fro = null;
    private com.baidu.tbadk.baseEditMark.a eSU = null;
    private ForumManageModel czq = null;
    private com.baidu.tbadk.coreExtra.model.a aqA = null;
    private ShareSuccessReplyToServerModel dvD = null;
    private as frq = null;
    public final com.baidu.tieba.pb.pb.main.a.a frr = new com.baidu.tieba.pb.pb.main.a.a(this);
    private boolean frt = false;
    private boolean fru = false;
    private boolean frv = false;
    private boolean fry = false;
    private boolean frA = false;
    private boolean frB = false;
    private boolean frF = false;
    public boolean frH = false;
    private com.baidu.tbadk.editortools.pb.c aNa = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HE() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aNb = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HD() {
            if (PbActivity.this.frw == null || PbActivity.this.frw.bfP() == null || !PbActivity.this.frw.bfP().bGa()) {
                return !PbActivity.this.qo(com.baidu.tbadk.core.util.aj.aqv);
            }
            PbActivity.this.showToast(PbActivity.this.frw.bfP().bGc());
            if (PbActivity.this.frE != null && (PbActivity.this.frE.HS() || PbActivity.this.frE.HT())) {
                PbActivity.this.frE.a(false, PbActivity.this.frw.bfS());
            }
            PbActivity.this.frw.ky(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b frI = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean HD() {
            if (PbActivity.this.frw == null || PbActivity.this.frw.bfQ() == null || !PbActivity.this.frw.bfQ().bGa()) {
                return !PbActivity.this.qo(com.baidu.tbadk.core.util.aj.aqw);
            }
            PbActivity.this.showToast(PbActivity.this.frw.bfQ().bGc());
            if (PbActivity.this.frq != null && PbActivity.this.frq.beF() != null && PbActivity.this.frq.beF().bcY() != null && PbActivity.this.frq.beF().bcY().HT()) {
                PbActivity.this.frq.beF().bcY().a(PbActivity.this.frw.bfS());
            }
            PbActivity.this.frw.kz(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dik = false;
    private int frR = 0;
    private int frS = -1;
    private final a frU = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.frq != null && PbActivity.this.frq.beF() != null) {
                r beF = PbActivity.this.frq.beF();
                if (beF.bcV()) {
                    beF.bcU();
                    return true;
                }
            }
            if (PbActivity.this.frq != null && PbActivity.this.frq.bfw()) {
                PbActivity.this.frq.bfx();
                return true;
            }
            return false;
        }
    };
    private q.b frV = new q.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
        @Override // com.baidu.tieba.pb.pb.main.q.b
        public void c(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private AddExperiencedModel.a diq = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bcf();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final y.a frW = new y.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void G(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.y.a
        public void g(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.frq.showToast(str);
            }
        }
    };
    private final CustomMessageListener frX = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fro != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.frE != null) {
                    PbActivity.this.frq.ks(PbActivity.this.frE.HM());
                }
                PbActivity.this.frq.beG();
                PbActivity.this.frq.bfp();
            }
        }
    };
    CustomMessageListener diH = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                PbActivity.this.fro.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                if (PbActivity.this.frq != null && PbActivity.this.fro != null) {
                    PbActivity.this.frq.d(PbActivity.this.fro.getPbData(), PbActivity.this.fro.bdi(), PbActivity.this.fro.getRequestType());
                }
                if (PbActivity.this.frq != null && PbActivity.this.frq.beW() != null) {
                    PbActivity.this.frq.beW().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener frY = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.frq != null) {
                    if (booleanValue) {
                        PbActivity.this.frq.aJY();
                    } else {
                        PbActivity.this.frq.aJX();
                    }
                }
            }
        }
    };
    private CustomMessageListener frZ = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.frE != null) {
                    PbActivity.this.frq.ks(PbActivity.this.frE.HM());
                }
                PbActivity.this.frq.ku(false);
            }
        }
    };
    private CustomMessageListener fsa = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
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
    private CustomMessageListener fsb = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.frq != null && PbActivity.this.frq.beW() != null) {
                PbActivity.this.frq.beW().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener eeb = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private h.a fsc = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void k(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.qq(2);
                ai.bep().reset();
                PbActivity.this.fro.bdA();
                boolean z2 = false;
                ArrayList<PostData> baq = PbActivity.this.fro.getPbData().baq();
                if (baq != null) {
                    Iterator<PostData> it = baq.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ar.j(next) && next.bxi().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.frq.n(PbActivity.this.fro.getPbData());
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
    private View.OnClickListener aNH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aMX);
        }
    };
    private CustomMessageListener fsd = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z)) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
                an.a aVar = new an.a();
                aVar.giftId = zVar.id;
                aVar.giftName = zVar.name;
                aVar.thumbnailUrl = zVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fro.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fro.bdr() != null && PbActivity.this.fro.bdr().getUserIdLong() == zVar.toUserId) {
                        PbActivity.this.frq.a(zVar.sendCount, PbActivity.this.fro.getPbData(), PbActivity.this.fro.bdi(), PbActivity.this.fro.getRequestType());
                    }
                    if (pbData.baq() != null && pbData.baq().size() >= 1 && pbData.baq().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.baq().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.fro.bdh(), 0L);
                        if (c2 == zVar.postId && c3 == zVar.threadId) {
                            com.baidu.tbadk.core.data.an bxh = pbData.baq().get(0).bxh();
                            if (bxh == null) {
                                bxh = new com.baidu.tbadk.core.data.an();
                            }
                            ArrayList<an.a> uA = bxh.uA();
                            if (uA == null) {
                                uA = new ArrayList<>();
                            }
                            uA.add(0, aVar);
                            bxh.bM(zVar.sendCount + bxh.uz());
                            bxh.g(uA);
                            pbData.baq().get(0).a(bxh);
                            PbActivity.this.frq.beW().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private SuggestEmotionModel.a fse = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.apG() != null && !aVar.apG().isEmpty()) {
                    PbActivity.this.frq.a(aVar, PbActivity.this.fsg);
                }
                PbActivity.this.frq.a(aVar, PbActivity.this.fro.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bfV()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fsf = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void G(List<String> list) {
            if (!com.baidu.tbadk.core.util.w.z(list) && PbActivity.this.frq != null) {
                PbActivity.this.frq.cW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fsg = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.aU(PbActivity.this.getPageContext().getPageActivity());
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
    private boolean fsh = false;
    private PraiseModel fsi = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void iQ(String str) {
            PbActivity.this.fsh = false;
            if (PbActivity.this.fsi != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fro.getPbData();
                if (pbData.bao().va().getIsLike() == 1) {
                    PbActivity.this.kw(0);
                } else {
                    PbActivity.this.kw(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bao()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void R(int i, String str) {
            PbActivity.this.fsh = false;
            if (PbActivity.this.fsi != null && str != null) {
                if (AntiHelper.tE(i)) {
                    AntiHelper.ao(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fsj = 0;
    private boolean fsk = true;
    private b.a fsl = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.a.b.a
        public void jJ(boolean z) {
            PbActivity.this.jI(z);
            if (PbActivity.this.frq.bfC() != null && z) {
                PbActivity.this.frq.kn(false);
            }
            PbActivity.this.frq.kp(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aCA != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aCA, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").r("obj_locate", as.a.arm));
                        }
                    } else if (updateAttentionMessage.getData().Gp) {
                        if (PbActivity.this.bav().vm() != null && PbActivity.this.bav().vm().getGodUserData() != null) {
                            PbActivity.this.bav().vm().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().bao() != null && PbActivity.this.fro.getPbData().bao().vm() != null) {
                            PbActivity.this.fro.getPbData().bao().vm().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a bZo = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.frq.adT();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.qr(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aBA();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.k.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c beE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (PbActivity.this.frq.beH()) {
                TiebaStatic.log("c12181");
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fro != null && (PbActivity.this.fro.getPbData() != null || PbActivity.this.fro.getPbData().baK() != null)) {
                    if (PbActivity.this.fro.getPbData().baK().baS()) {
                        if (PbActivity.this.fro.getPbData().baK().fpg == 1 || PbActivity.this.fro.getPbData().baK().fpg == 3 || PbActivity.this.fro.getPbData().baK().fpg == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, true, 2);
                            TiebaStatic.log(PbActivity.this.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fro.getPbData().baK().baS() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), 2, false, 2);
                        TiebaStatic.log(PbActivity.this.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fro.getPbData().baK().baS() ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.frg > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kU(false);
                        PbActivity.this.frg = System.currentTimeMillis();
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
                    if (PbActivity.this.aY(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.frq != null && PbActivity.this.frq.bbL() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").ah(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.frr != null && PbActivity.this.frr.fEF != null) {
                            PbActivity.this.frr.fEF.onClick(view);
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
            if (PbActivity.this.frE != null) {
                PbActivity.this.frq.ks(PbActivity.this.frE.HM());
            }
            PbActivity.this.frq.beG();
            PbActivity.this.frq.bfp();
            return true;
        }
    });
    private CustomMessageListener fsm = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.frL) {
                PbActivity.this.frq.adT();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fro.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.baC().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.frK.i(PbActivity.this.frJ.getResources().getString(d.k.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.frJ.getResources().getString(d.k.mute_error_beyond_limit);
                    }
                    PbActivity.this.gR(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bcr();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ao.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.frJ.getResources().getString(d.k.mute_fail);
                    }
                    PbActivity.this.frK.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fsn = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.frL) {
                PbActivity.this.frq.adT();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.frK.i(PbActivity.this.frJ.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ao.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.frJ.getResources().getString(d.k.un_mute_fail);
                }
                PbActivity.this.frK.j(muteMessage);
            }
        }
    };
    private CustomMessageListener fso = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.frL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.frq.adT();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.gWd;
                if (aVar.error == 0 && dataRes != null) {
                    int g = com.baidu.adp.lib.g.b.g(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = g == 1;
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
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
                    PbActivity.this.frq.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fsp = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.frq.beH() && (customResponsedMessage.getData() instanceof Integer) && PbActivity.this.bbt() != null && PbActivity.this.bbt().getPbData() != null && PbActivity.this.bbt().getPbData().baK() != null && PbActivity.this.checkUpIsLogin()) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                boolean baS = PbActivity.this.bbt().getPbData().baK().baS();
                if (intValue < 10) {
                    if (baS) {
                        if (PbActivity.this.fro.getPbData().baK().fpg == 1 || PbActivity.this.fro.getPbData().baK().fpg == 3 || PbActivity.this.fro.getPbData().baK().fpg == 4) {
                            PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, true, 2);
                            TiebaStatic.log(PbActivity.this.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fro.getPbData().baK().baS() ? 0 : 1));
                        }
                    } else {
                        PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue, false, 2);
                        TiebaStatic.log(PbActivity.this.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, baS ? 0 : 1));
                    }
                    if (System.currentTimeMillis() - PbActivity.this.frg > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(PbActivity.this.getActivity()).kU(false);
                        PbActivity.this.frg = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                PbActivity.this.a(PbActivity.this.findViewById(d.g.view_main_thread_praise_state), intValue / 11, baS, 3);
                TiebaStatic.log(PbActivity.this.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, baS ? 0 : 1));
            }
        }
    };
    private CustomMessageListener diO = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dik = true;
                }
            }
        }
    };
    public a.b ffE = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.atH();
            com.baidu.tbadk.core.data.am aEh = PbActivity.this.fro.aEh();
            int pageNum = PbActivity.this.frq.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.k.pb_page_error);
            } else if (aEh == null || pageNum <= aEh.us()) {
                PbActivity.this.frq.bfp();
                PbActivity.this.qq(2);
                PbActivity.this.atG();
                PbActivity.this.frq.bfa();
                if (com.baidu.adp.lib.util.j.jD()) {
                    PbActivity.this.fro.qy(PbActivity.this.frq.getPageNum());
                    if (PbActivity.this.fqV != null) {
                        PbActivity.this.fqV.showFloatingView();
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
    public final View.OnClickListener djp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
        /* JADX DEBUG: Multi-variable search result rejected for r2v182, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v186, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v213, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v317, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:670:0x1c10  */
        /* JADX WARN: Removed duplicated region for block: B:697:0x1dda  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String name;
            com.baidu.tieba.pb.data.j baK;
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
            boolean m;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.frq.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fro.jT(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.frq.bfb();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().bei()) {
                        if (view == PbActivity.this.frq.fAw.aUR) {
                            if (PbActivity.this.frq.kr(PbActivity.this.fro.bdo())) {
                                PbActivity.this.atG();
                                return;
                            }
                            PbActivity.this.fqY = false;
                            PbActivity.this.fqW = false;
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.frq.beY() && (PbActivity.this.frq.fAw.bgh() == null || (view != PbActivity.this.frq.fAw.bgh().beh() && view != PbActivity.this.frq.fAw.bgh().bef()))) {
                            if (view == PbActivity.this.frq.bfs()) {
                                if (PbActivity.this.fro != null) {
                                    com.baidu.tbadk.browser.a.O(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fro.getPbData().bao().vl().getLink());
                                }
                            } else if (view != PbActivity.this.frq.fAw.fFp && view.getId() != d.g.view_forum_name) {
                                if (view == PbActivity.this.frq.fAw.fFq) {
                                    if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null) {
                                        ArrayList<PostData> baq = PbActivity.this.fro.getPbData().baq();
                                        if ((baq == null || baq.size() <= 0) && PbActivity.this.fro.bdi()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").ah("tid", PbActivity.this.fro.bdh()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getForumId()));
                                        if (!PbActivity.this.frq.bfH()) {
                                            PbActivity.this.frq.beG();
                                        }
                                        PbActivity.this.bbT();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.k.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().bdT()) {
                                        if ((PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().bee()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                            if (PbActivity.this.frq.fAw.bgh() == null || (view != PbActivity.this.frq.fAw.bgh().getCancelView() && view != PbActivity.this.frq.fAw.bgh().bed())) {
                                                if (view != PbActivity.this.frq.fAw.fFr && view.getId() != d.g.tv_share && view.getId() != d.g.share_container) {
                                                    if (PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().beb()) {
                                                        if ((PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().bek()) && view.getId() != d.g.pb_sort) {
                                                            if (PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().bec()) {
                                                                if (PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().bel()) {
                                                                    if (PbActivity.this.frx == null || view != PbActivity.this.frx.bdV()) {
                                                                        if (PbActivity.this.frx == null || view != PbActivity.this.frx.bdT()) {
                                                                            if (PbActivity.this.frx == null || view != PbActivity.this.frx.bdY()) {
                                                                                if (PbActivity.this.frx == null || view != PbActivity.this.frx.bdW()) {
                                                                                    if (PbActivity.this.frx == null || view != PbActivity.this.frx.bdX()) {
                                                                                        if (PbActivity.this.frq.bfC() == view) {
                                                                                            if (PbActivity.this.frq.bfC().getIndicateStatus()) {
                                                                                                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fro.getPbData();
                                                                                                if (pbData != null && pbData.bao() != null && pbData.bao().uV() != null) {
                                                                                                    String tR = pbData.bao().uV().tR();
                                                                                                    if (StringUtils.isNull(tR)) {
                                                                                                        tR = pbData.bao().uV().getTaskId();
                                                                                                    }
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").ah(VideoPlayActivityConfig.OBJ_ID, tR));
                                                                                                }
                                                                                            } else {
                                                                                                com.baidu.tieba.tbadkCore.d.a.ck("c10725", null);
                                                                                            }
                                                                                            PbActivity.this.bcn();
                                                                                        } else if (PbActivity.this.frq.beV() != view) {
                                                                                            if (PbActivity.this.frx == null || view != PbActivity.this.frx.bdU()) {
                                                                                                if (PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().bej()) {
                                                                                                    if (PbActivity.this.frq.fAw.bgh() != null && view == PbActivity.this.frq.fAw.bgh().beg()) {
                                                                                                        if (com.baidu.adp.lib.util.j.jD()) {
                                                                                                            SparseArray<Object> c2 = PbActivity.this.frq.c(PbActivity.this.fro.getPbData(), PbActivity.this.fro.bdi(), 1);
                                                                                                            if (c2 != null) {
                                                                                                                if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                                                    PbActivity.this.frq.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                                } else {
                                                                                                                    PbActivity.this.frq.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                                                                }
                                                                                                            }
                                                                                                            PbActivity.this.frq.fAw.sL();
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(d.k.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (view.getId() != d.g.sub_pb_more && view.getId() != d.g.sub_pb_item && view.getId() != d.g.pb_floor_reply_more) {
                                                                                                        if (view != PbActivity.this.frq.bbE()) {
                                                                                                            if (view == PbActivity.this.frq.fAw.bgi()) {
                                                                                                                PbActivity.this.frq.bfh();
                                                                                                            } else {
                                                                                                                int id = view.getId();
                                                                                                                if (id == d.g.pb_u9_text_view) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin() && (biVar = (bi) view.getTag()) != null && !StringUtils.isNull(biVar.wP())) {
                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        ay.zG().c(PbActivity.this.getPageContext(), new String[]{biVar.wP()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if ((id == d.g.pb_floor_agree || id == d.g.view_floor_praise) && (view instanceof PbFloorAgreeView)) {
                                                                                                                    PostData aZ = PbActivity.this.aZ(view);
                                                                                                                    if (aZ != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 5).r(VideoPlayActivityConfig.OBJ_ID, aZ.bxl() ? 0 : 1));
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_state || id == d.g.praise_container || id == d.g.tv_praise) {
                                                                                                                    PbActivity.this.a(view, 2, false, 1);
                                                                                                                    if (PbActivity.this.bbt() != null && PbActivity.this.bbt().getPbData() != null && PbActivity.this.bbt().getPbData().baK() != null && PbActivity.this.bbt().getPbData().baK() != null) {
                                                                                                                        TiebaStatic.log(PbActivity.this.bbO().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_locate", 4).r(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.bbt().getPbData().baK().baS() ? 0 : 1));
                                                                                                                    }
                                                                                                                } else if (id == d.g.view_main_thread_praise_num || id == d.g.view_main_thread_praise_name_list) {
                                                                                                                    if (view != null && (view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue() && PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && !StringUtils.isNull(PbActivity.this.fro.getPbData().getThreadId()) && (baK = PbActivity.this.fro.getPbData().baK()) != null && baK.baQ() > 0) {
                                                                                                                        ay.zG().c(PbActivity.this.getPageContext(), new String[]{"https://tieba.baidu.com/n/apage-runtime/page/agree_list?thread_id=" + PbActivity.this.fro.getPbData().getThreadId()});
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.replybtn || id == d.g.cover_reply_content || id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right || id == d.g.image_more_tip) {
                                                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                                                        PostData postData2 = null;
                                                                                                                        if (view != null && view.getTag() != null) {
                                                                                                                            postData2 = (PostData) ((SparseArray) view.getTag()).get(d.g.tag_load_sub_data);
                                                                                                                            if (PbActivity.this.frx == null) {
                                                                                                                                PbActivity.this.frx = new x(PbActivity.this.getPageContext(), PbActivity.this.djp);
                                                                                                                                PbActivity.this.frq.bj(PbActivity.this.frx.getView());
                                                                                                                                PbActivity.this.frx.jX(PbActivity.this.mIsLogin);
                                                                                                                            }
                                                                                                                            PbActivity.this.frx.showDialog();
                                                                                                                            boolean z6 = id == d.g.replybtn_top_right || id == d.g.cover_reply_content_top_right;
                                                                                                                            if (z6) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").ah("tid", PbActivity.this.fro.fwu));
                                                                                                                            }
                                                                                                                            SparseArray sparseArray2 = new SparseArray();
                                                                                                                            sparseArray2.put(d.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(d.g.tag_clip_board));
                                                                                                                            sparseArray2.put(d.g.tag_is_subpb, false);
                                                                                                                            PbActivity.this.frx.bdT().setTag(sparseArray2);
                                                                                                                            PbActivity.this.frx.bdY().setTag(view.getTag());
                                                                                                                            PbActivity.this.frx.jZ(z6);
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
                                                                                                                                    PbActivity.this.frx.bdW().setVisibility(0);
                                                                                                                                } else {
                                                                                                                                    sparseArray4.put(d.g.tag_should_delete_visible, false);
                                                                                                                                    PbActivity.this.frx.bdW().setVisibility(8);
                                                                                                                                }
                                                                                                                                PbActivity.this.frx.bdU().setTag(sparseArray4);
                                                                                                                                PbActivity.this.frx.bdW().setTag(sparseArray4);
                                                                                                                                PbActivity.this.frx.bdU().setText(d.k.bar_manager);
                                                                                                                                PbActivity.this.frx.bdU().setVisibility(0);
                                                                                                                            } else if (!booleanValue3) {
                                                                                                                                PbActivity.this.frx.bdU().setVisibility(8);
                                                                                                                                PbActivity.this.frx.bdW().setVisibility(8);
                                                                                                                            } else {
                                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                                sparseArray5.put(d.g.tag_should_manage_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_user_mute_visible, false);
                                                                                                                                sparseArray5.put(d.g.tag_should_delete_visible, true);
                                                                                                                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray3.get(d.g.tag_manage_user_identity));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_id, sparseArray3.get(d.g.tag_del_post_id));
                                                                                                                                sparseArray5.put(d.g.tag_del_post_type, sparseArray3.get(d.g.tag_del_post_type));
                                                                                                                                PbActivity.this.frx.bdU().setTag(sparseArray5);
                                                                                                                                PbActivity.this.frx.bdW().setTag(sparseArray5);
                                                                                                                                PbActivity.this.frx.bdU().setText(d.k.delete);
                                                                                                                                PbActivity.this.frx.bdW().setVisibility(0);
                                                                                                                                if (PbActivity.this.fro.getPbData().baA() != 1002 || z2) {
                                                                                                                                    PbActivity.this.frx.bdW().setText(d.k.delete);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.frx.bdW().setText(d.k.report_text);
                                                                                                                                }
                                                                                                                                PbActivity.this.frx.bdU().setVisibility(8);
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
                                                                                                                                PbActivity.this.frx.bdV().setTag(sparseArray7);
                                                                                                                                PbActivity.this.frx.bdV().setVisibility(0);
                                                                                                                                PbActivity.this.frx.bdU().setVisibility(8);
                                                                                                                                PbActivity.this.frx.bdV().setText(d.k.mute_option);
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
                                                                                                                                boolean jE = PbActivity.this.jE(z4) & PbActivity.this.isLogin();
                                                                                                                                PbActivity.this.fsz = (PostData) sparseArray6.get(d.g.tag_clip_board);
                                                                                                                                if (ar.j(PbActivity.this.fsz) ? false : jE) {
                                                                                                                                    PbActivity.this.frx.bdV().setVisibility(0);
                                                                                                                                    PbActivity.this.frx.bdV().setTag(str3);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.frx.bdV().setVisibility(8);
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
                                                                                                                                PbActivity.this.frx.bdX().setVisibility(0);
                                                                                                                                PbActivity.this.frx.bdX().setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                PbActivity.this.frx.bdX().setTag(d.g.tag_chudian_monitor_id, str);
                                                                                                                                PbActivity.this.frx.bdX().setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                            } else {
                                                                                                                                PbActivity.this.frx.bdX().setVisibility(8);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (PbActivity.this.fro.getPbData().sc()) {
                                                                                                                            String sb = PbActivity.this.fro.getPbData().sb();
                                                                                                                            if (postData2 != null && !com.baidu.adp.lib.util.k.isEmpty(sb) && sb.equals(postData2.getId())) {
                                                                                                                                z = true;
                                                                                                                                if (!z) {
                                                                                                                                    PbActivity.this.frx.bdT().setText(d.k.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.frx.bdT().setText(d.k.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.frx.jY(true);
                                                                                                                                PbActivity.this.frx.refreshUI();
                                                                                                                            }
                                                                                                                        }
                                                                                                                        z = false;
                                                                                                                        if (!z) {
                                                                                                                        }
                                                                                                                        PbActivity.this.frx.jY(true);
                                                                                                                        PbActivity.this.frx.refreshUI();
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_act_btn) {
                                                                                                                    if (PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().bao() != null && PbActivity.this.fro.getPbData().bao().getActUrl() != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), PbActivity.this.fro.getPbData().bao().getActUrl());
                                                                                                                        if (PbActivity.this.fro.getPbData().bao().vO() != 1) {
                                                                                                                            if (PbActivity.this.fro.getPbData().bao().vO() == 2) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, WBPageConstants.ParamKey.PAGE, "pb");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.lottery_tail) {
                                                                                                                    if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                        String str4 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getPbData().getForumId()).ah("tid", PbActivity.this.fro.getPbData().getThreadId()).ah("lotterytail", StringUtils.string(str4, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                                        if (PbActivity.this.fro.getPbData().getThreadId().equals(str4)) {
                                                                                                                            PbActivity.this.frq.setSelection(0);
                                                                                                                        } else {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.pb_item_tail_content) {
                                                                                                                    if (ba.aU(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                        String string = TbadkCoreApplication.getInst().getString(d.k.tail_web_view_title);
                                                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                                                            TiebaStatic.log("c10056");
                                                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                        }
                                                                                                                        PbActivity.this.frq.beG();
                                                                                                                    }
                                                                                                                } else if (id == d.g.join_vote_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        if (PbActivity.this.bbQ() == 1 && PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getPbData().getForumId()).ah("tid", PbActivity.this.fro.getPbData().getThreadId()).ah("uid", currentAccount));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.look_all_tv) {
                                                                                                                    if (view != null) {
                                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                        com.baidu.tbadk.browser.a.O(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                        if (PbActivity.this.bbQ() == 1 && PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getPbData().getForumId()).ah("tid", PbActivity.this.fro.getPbData().getThreadId()).ah("uid", currentAccount2));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.manga_prev_btn) {
                                                                                                                    PbActivity.this.bci();
                                                                                                                } else if (id == d.g.manga_next_btn) {
                                                                                                                    PbActivity.this.bcj();
                                                                                                                } else if (id == d.g.yule_head_img_img) {
                                                                                                                    if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().baG() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fro.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").ah(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                        ay.zG().c(PbActivity.this.getPageContext(), new String[]{pbData2.baG().baP()});
                                                                                                                    }
                                                                                                                } else if (id == d.g.yule_head_img_all_rank) {
                                                                                                                    if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().baG() != null) {
                                                                                                                        com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fro.getPbData();
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").ah(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                        ay.zG().c(PbActivity.this.getPageContext(), new String[]{pbData3.baG().baP()});
                                                                                                                    }
                                                                                                                } else if (PbActivity.this.frq.fAw.bgh() != null && view == PbActivity.this.frq.fAw.bgh().bem()) {
                                                                                                                    if (PbActivity.this.fro == null || PbActivity.this.fro.getPbData() == null || PbActivity.this.fro.getPbData().bao() == null) {
                                                                                                                        PbActivity.this.frq.fAw.sL();
                                                                                                                        return;
                                                                                                                    } else if (!com.baidu.adp.lib.util.l.jU()) {
                                                                                                                        PbActivity.this.showToast(d.k.neterror);
                                                                                                                        return;
                                                                                                                    } else {
                                                                                                                        int i2 = 1;
                                                                                                                        if (PbActivity.this.fro.getPbData().bao().uW() == 0) {
                                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fro.bdh(), 25028)));
                                                                                                                        } else {
                                                                                                                            BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.k.haved_fans_called)).xi();
                                                                                                                            i2 = 2;
                                                                                                                        }
                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").r("obj_locate", PbActivity.this.ae(PbActivity.this.fro.getPbData().bao())).ah("tid", PbActivity.this.fro.getPbData().bao().getTid()).r("obj_type", i2));
                                                                                                                    }
                                                                                                                } else if (id == d.g.tv_pb_reply_more) {
                                                                                                                    if (PbActivity.this.frR >= 0) {
                                                                                                                        if (PbActivity.this.fro != null) {
                                                                                                                            PbActivity.this.fro.bdO();
                                                                                                                        }
                                                                                                                        if (PbActivity.this.frq.beW() != null) {
                                                                                                                            PbActivity.this.frq.beW().a(PbActivity.this.fro.getPbData(), false);
                                                                                                                        }
                                                                                                                        PbActivity.this.frq.getListView().setSelection(PbActivity.this.fro.bdR());
                                                                                                                        PbActivity.this.frR = 0;
                                                                                                                        if (PbActivity.this.fro != null) {
                                                                                                                            PbActivity.this.fro.bq(0, 0);
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (id == d.g.single_bar_tips) {
                                                                                                                    PbActivity.this.frq.bfK();
                                                                                                                } else if (id == d.g.pb_post_recommend_live_layout && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                                                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                    TiebaStatic.log("c12640");
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                            PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.fro.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.fro.bdh(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fro.getPbData().bao().vF())));
                                                                                                        }
                                                                                                    } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                        if (PbActivity.this.fro.getPbData() != null) {
                                                                                                            PbActivity.this.frq.bfp();
                                                                                                            SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                            PostData postData3 = (PostData) sparseArray9.get(d.g.tag_load_sub_data);
                                                                                                            View view2 = (View) sparseArray9.get(d.g.tag_load_sub_view);
                                                                                                            if (postData3 != null && view2 != null) {
                                                                                                                if (postData3.bxn() == 1) {
                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                                                }
                                                                                                                String bdh = PbActivity.this.fro.bdh();
                                                                                                                String id2 = postData3.getId();
                                                                                                                int i3 = 0;
                                                                                                                if (PbActivity.this.fro.getPbData() != null) {
                                                                                                                    i3 = PbActivity.this.fro.getPbData().baA();
                                                                                                                }
                                                                                                                PbActivity.this.atG();
                                                                                                                if (view.getId() == d.g.replybtn) {
                                                                                                                    c rm = PbActivity.this.rm(id2);
                                                                                                                    if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && rm != null) {
                                                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdh, id2, "pb", true, null, true, null, i3, postData3.bgZ(), PbActivity.this.fro.getPbData().uo(), false, postData3.vm().getIconInfo()).addBigImageData(rm.ftj, rm.ftk, rm.ftl, rm.index);
                                                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.fro.bdN());
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
                                                                                                                    c rm2 = PbActivity.this.rm(id2);
                                                                                                                    if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && rm2 != null && PbActivity.this.bbK().beE() != null) {
                                                                                                                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                                                        kVar.a(PbActivity.this.fro.getPbData().bam());
                                                                                                                        kVar.T(PbActivity.this.fro.getPbData().bao());
                                                                                                                        kVar.d(postData4);
                                                                                                                        PbActivity.this.bbK().beE().d(kVar);
                                                                                                                        PbActivity.this.bbK().beE().setPostId(str7);
                                                                                                                        PbActivity.this.b(view, str6, str5);
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    TiebaStatic.log("c11742");
                                                                                                                    c rm3 = PbActivity.this.rm(id2);
                                                                                                                    if (postData3 != null && PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && rm3 != null) {
                                                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdh, id2, "pb", true, null, false, null, i3, postData3.bgZ(), PbActivity.this.fro.getPbData().uo(), false, postData3.vm().getIconInfo()).addBigImageData(rm3.ftj, rm3.ftk, rm3.ftl, rm3.index);
                                                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.fro.bdN());
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
                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").r("obj_locate", 3).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getPbData().getForumId()));
                                                                                                        return;
                                                                                                    }
                                                                                                } else if (com.baidu.adp.lib.util.j.jD()) {
                                                                                                    PbActivity.this.frq.bfp();
                                                                                                    SparseArray<Object> c3 = PbActivity.this.frq.c(PbActivity.this.fro.getPbData(), PbActivity.this.fro.bdi(), 1);
                                                                                                    if (c3 != null) {
                                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fro.getPbData().bam().getId(), PbActivity.this.fro.getPbData().bam().getName(), PbActivity.this.fro.getPbData().bao().getId(), String.valueOf(PbActivity.this.fro.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_name_show), (String) c3.get(d.g.tag_forbid_user_post_id))));
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
                                                                                                            PbActivity.this.frq.bh(view);
                                                                                                        }
                                                                                                    } else if (booleanValue5) {
                                                                                                        PbActivity.this.frq.a(((Integer) sparseArray11.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(d.g.tag_del_post_id), ((Integer) sparseArray11.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").r("obj_locate", 2).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getPbData().getForumId()));
                                                                                            return;
                                                                                        } else {
                                                                                            PbActivity.this.bbG();
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
                                                                                        com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fro.getPbData();
                                                                                        String str9 = null;
                                                                                        String str10 = null;
                                                                                        String str11 = null;
                                                                                        if (pbData4 != null && pbData4.bam() != null) {
                                                                                            str9 = pbData4.bam().getId();
                                                                                            str10 = pbData4.bam().getName();
                                                                                            str11 = pbData4.getThreadId();
                                                                                        }
                                                                                        com.baidu.tieba.pb.a.a(j2, str8, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str9, str10, str11);
                                                                                        PbActivity.this.a(j2, str8, str9, str10, str11, i4);
                                                                                    }
                                                                                } else {
                                                                                    SparseArray sparseArray12 = (SparseArray) view.getTag();
                                                                                    if (sparseArray12 != null) {
                                                                                        if ((sparseArray12.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_id) instanceof String) && (sparseArray12.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray12.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                            PbActivity.this.frq.a(((Integer) sparseArray12.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray12.get(d.g.tag_del_post_id), ((Integer) sparseArray12.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray12.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (PbActivity.this.frx.bea()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12007").ah("tid", PbActivity.this.fro.fwu));
                                                                                } else {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").r("obj_locate", 1));
                                                                                }
                                                                                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fro.getPbData() != null) {
                                                                                    PbActivity.this.frq.bfp();
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
                                                                                        String bdh2 = PbActivity.this.fro.bdh();
                                                                                        String id3 = postData.getId();
                                                                                        int i5 = 0;
                                                                                        if (PbActivity.this.fro.getPbData() != null) {
                                                                                            i5 = PbActivity.this.fro.getPbData().baA();
                                                                                        }
                                                                                        PbActivity.this.atG();
                                                                                        c rm4 = PbActivity.this.rm(id3);
                                                                                        if (rm4 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bdh2, id3, "pb", true, null, true, null, i5, postData.bgZ(), PbActivity.this.fro.getPbData().uo(), false, postData.vm().getIconInfo()).addBigImageData(rm4.ftj, rm4.ftk, rm4.ftl, rm4.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbActivity.this.fro.bdN());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").r("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.ba(view);
                                                                                if (PbActivity.this.fro.getPbData().bao() != null && PbActivity.this.fro.getPbData().bao().vm() != null && PbActivity.this.fro.getPbData().bao().vm().getUserId() != null && PbActivity.this.eSU != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").ah("tid", PbActivity.this.fro.fwu).r("obj_locate", 2).ah(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fro.getPbData().bao().vm().getUserId()).r("obj_type", PbActivity.this.eSU.sc() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fro.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.jD()) {
                                                                        PbActivity.this.showToast(d.k.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13079"));
                                                                            PbActivity.this.rj((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").r("obj_locate", 4));
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").r("obj_type", 0).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.frq.fAw.bgg();
                                                                }
                                                            } else if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().bao() != null) {
                                                                PbActivity.this.frq.fAw.sL();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                                PbActivity.this.rj(PbActivity.this.fro.getPbData().bao().vC());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.frq.bfp();
                                                            if (com.baidu.adp.lib.util.j.jD()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Boolean.valueOf(PbActivity.this.fro.bdv()));
                                                                    return;
                                                                }
                                                                PbActivity.this.qq(2);
                                                                PbActivity.this.atG();
                                                                PbActivity.this.frq.bfa();
                                                                boolean bdu = PbActivity.this.fro.bdu();
                                                                view.setTag(Boolean.valueOf(PbActivity.this.fro.bdv()));
                                                                TiebaStatic.log("c12097");
                                                                if (PbActivity.this.frq.fAw != null && PbActivity.this.frq.fAw.bgh() != null && view == PbActivity.this.frq.fAw.bgh().bek()) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                } else if (view.getId() == d.g.pb_sort) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
                                                                }
                                                                if (bdu) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.frq.ki(true);
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.k.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.frq.bfp();
                                                        if (PbActivity.this.fro.aEh() != null) {
                                                            PbActivity.this.frq.a(PbActivity.this.fro.aEh(), PbActivity.this.ffE);
                                                        }
                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    }
                                                } else if (com.baidu.tbadk.o.ar.ip() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fro != null) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12386").ah("tid", PbActivity.this.fro.bdh()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getForumId()).r("obj_locate", 6));
                                                    }
                                                    if (com.baidu.adp.lib.util.l.jU()) {
                                                        if (PbActivity.this.fro.getPbData() != null) {
                                                            ArrayList<PostData> baq2 = PbActivity.this.fro.getPbData().baq();
                                                            if ((baq2 != null && baq2.size() > 0) || !PbActivity.this.fro.bdi()) {
                                                                PbActivity.this.frq.bfp();
                                                                PbActivity.this.atG();
                                                                PbActivity.this.qq(2);
                                                                if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().baG() != null && !StringUtils.isNull(PbActivity.this.fro.getPbData().baG().ub(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                                if (com.baidu.tbadk.o.ar.ip()) {
                                                                    PbActivity.this.qr(2);
                                                                } else {
                                                                    PbActivity.this.frq.showLoadingDialog();
                                                                    PbActivity.this.fro.bdI().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                                PbActivity.this.frq.fAw.sL();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.jD()) {
                                            PbActivity.this.frq.bfp();
                                            if (PbActivity.this.frq.fAw.bgh() != null && view == PbActivity.this.frq.fAw.bgh().bee() && !PbActivity.this.frq.bfH()) {
                                                PbActivity.this.frq.beG();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.atG();
                                                PbActivity.this.frq.bfa();
                                                if (view.getId() == d.g.floor_owner_reply) {
                                                    m = PbActivity.this.fro.m(true, PbActivity.this.bcg());
                                                } else {
                                                    m = view.getId() == d.g.reply_title ? PbActivity.this.fro.m(false, PbActivity.this.bcg()) : PbActivity.this.fro.rn(PbActivity.this.bcg());
                                                }
                                                view.setTag(Boolean.valueOf(m));
                                                if (m) {
                                                    PbActivity.this.frq.jN(true);
                                                    PbActivity.this.frq.aJY();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.frq.ki(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.qq(2);
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
                                        PbActivity.this.frq.bfp();
                                        if (PbActivity.this.qp(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fro.qD(PbActivity.this.frq.bff()) != null) {
                                            PbActivity.this.bca();
                                            if (PbActivity.this.fro.getPbData().bao() != null && PbActivity.this.fro.getPbData().bao().vm() != null && PbActivity.this.fro.getPbData().bao().vm().getUserId() != null && PbActivity.this.eSU != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").ah("tid", PbActivity.this.fro.fwu).r("obj_locate", 1).ah(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fro.getPbData().bao().vm().getUserId()).r("obj_type", PbActivity.this.eSU.sc() ? 0 : 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fro.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.k.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.jD()) {
                                    PbActivity.this.frq.jN(true);
                                    PbActivity.this.frq.beG();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.frq.aJY();
                                        PbActivity.this.atG();
                                        PbActivity.this.frq.bfa();
                                        PbActivity.this.fro.rn(PbActivity.this.bcg());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.qq(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(d.k.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().bao() != null && PbActivity.this.fro.getPbData().bao().vX() && PbActivity.this.fro.getPbData().bao().vD() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.fro.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fro.bdg()) && PbActivity.this.fro.getAppealInfo() != null) {
                                        name = PbActivity.this.fro.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fro.getPbData().bam().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bdg = PbActivity.this.fro.bdg();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fro.bdj() && bdg != null && bdg.equals(name)) {
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
                            if (PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().baA() == 1 && !PbActivity.this.czq.bxN()) {
                                PbActivity.this.frq.bfp();
                                int i6 = 0;
                                if (PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().bef()) {
                                    if (PbActivity.this.frq.fAw.bgh() == null || view != PbActivity.this.frq.fAw.bgh().beh()) {
                                        if (view == PbActivity.this.frq.beY()) {
                                            i6 = 2;
                                        }
                                    } else if (PbActivity.this.fro.getPbData().bao().vi() == 1) {
                                        i6 = 3;
                                    } else {
                                        i6 = 6;
                                    }
                                } else if (PbActivity.this.fro.getPbData().bao().vh() == 1) {
                                    i6 = 5;
                                } else {
                                    i6 = 4;
                                }
                                ForumData bam = PbActivity.this.fro.getPbData().bam();
                                String name2 = bam.getName();
                                String id4 = bam.getId();
                                String id5 = PbActivity.this.fro.getPbData().bao().getId();
                                PbActivity.this.frq.beX();
                                PbActivity.this.czq.a(id4, name2, id5, i6, PbActivity.this.frq.beZ());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.k.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.jD()) {
                        PbActivity.this.frq.bfp();
                        PbActivity.this.atG();
                        PbActivity.this.frq.bfa();
                        PbActivity.this.frq.showLoadingDialog();
                        if (PbActivity.this.frq.beN() != null) {
                            PbActivity.this.frq.beN().setVisibility(8);
                        }
                        PbActivity.this.fro.qy(1);
                        if (PbActivity.this.fqV != null) {
                            PbActivity.this.fqV.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.k.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.k.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bbN = PbActivity.this.bbN();
                        if (!TextUtils.isEmpty(bbN)) {
                            ay.zG().c(PbActivity.this.getPageContext(), new String[]{bbN});
                        }
                    }
                } else if (PbActivity.this.frf) {
                    PbActivity.this.frf = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData5 = (PostData) obj;
                            if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.bbK().beE() != null && postData5.vm() != null && postData5.bwZ() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bbK().beF() != null) {
                                    PbActivity.this.bbK().beF().bcT();
                                }
                                com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                                kVar2.a(PbActivity.this.fro.getPbData().bam());
                                kVar2.T(PbActivity.this.fro.getPbData().bao());
                                kVar2.d(postData5);
                                PbActivity.this.bbK().beE().d(kVar2);
                                PbActivity.this.bbK().beE().setPostId(postData5.getId());
                                PbActivity.this.b(view, postData5.vm().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.frE != null) {
                                    PbActivity.this.frq.ks(PbActivity.this.frE.HM());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            String userId;
            PbActivity.this.atG();
            PbActivity.this.frq.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.o.ai.KJ() && PbActivity.this.bbt() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bbt().rq(postWriteCallBackData.getPostId());
                    PbActivity.this.frR = PbActivity.this.frq.beJ();
                    if (PbActivity.this.fro != null) {
                        PbActivity.this.fro.bq(PbActivity.this.frR, PbActivity.this.frq.beK());
                    }
                }
                PbActivity.this.frq.bfp();
                PbActivity.this.frw.bfO();
                if (PbActivity.this.frE != null) {
                    PbActivity.this.frq.ks(PbActivity.this.frE.HM());
                }
                PbActivity.this.frq.beD();
                PbActivity.this.frq.ku(true);
                PbActivity.this.fro.bdx();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fro.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fro.getPbData();
                            if (pbData != null && pbData.bao() != null && pbData.bao().vm() != null && (userId = pbData.bao().vm().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.o.ai.KJ() && PbActivity.this.fro.bdq()) {
                                PbActivity.this.frq.bfa();
                            }
                        } else if (!com.baidu.tbadk.o.ai.KJ() && PbActivity.this.fro.bdq()) {
                            PbActivity.this.frq.bfa();
                        }
                    } else if (floor != null) {
                        PbActivity.this.frq.n(PbActivity.this.fro.getPbData());
                    }
                    if (PbActivity.this.fro.bdm()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").ah("tid", PbActivity.this.fro.bdh()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.frE.HS() || PbActivity.this.frE.HT()) {
                    PbActivity.this.frE.a(false, postWriteCallBackData);
                }
                PbActivity.this.frw.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.eAs != null) {
                    PbActivity.this.eAs.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (tVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fsq = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.frw != null) {
                    PbActivity.this.frw.bfN();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.eAs != null) {
                    PbActivity.this.eAs.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.frw != null) {
                if (PbActivity.this.frq != null && PbActivity.this.frq.beF() != null && PbActivity.this.frq.beF().bcY() != null && PbActivity.this.frq.beF().bcY().HT()) {
                    PbActivity.this.frq.beF().bcY().a(postWriteCallBackData);
                }
                PbActivity.this.frw.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fsr = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g eJ;
            if (!z || dVar == null || dVar.bay() != null || com.baidu.tbadk.core.util.w.y(dVar.baq()) >= 1) {
                PbActivity.this.eVQ = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.frq.bfc();
                if (dVar == null || !dVar.bau()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.frq.getView());
                }
                PbActivity.this.frq.aJX();
                if (PbActivity.this.isFullScreen || PbActivity.this.frq.bfH()) {
                    PbActivity.this.frq.bfy();
                } else if (!PbActivity.this.frq.bfv()) {
                    PbActivity.this.frq.ku(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fry = true;
                }
                if (z && dVar != null) {
                    PbActivity.this.frq.showListView();
                    if (dVar.bao() != null && dVar.bao().we() != null) {
                        PbActivity.this.a(dVar.bao().we());
                    }
                    PbActivity.this.bbH();
                    if (PbActivity.this.frE != null) {
                        PbActivity.this.frq.ks(PbActivity.this.frE.HM());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.baq() != null && dVar.baq().size() >= 1 && dVar.baq().get(0) != null) {
                        PbActivity.this.fro.rp(dVar.baq().get(0).getId());
                    } else if (dVar.bay() != null) {
                        PbActivity.this.fro.rp(dVar.bay().getId());
                    }
                    if (PbActivity.this.frE != null) {
                        PbActivity.this.frE.a(dVar.uo());
                        PbActivity.this.frE.a(dVar.bam(), dVar.getUserData());
                        PbActivity.this.frE.a(PbActivity.this.fro.bdr(), PbActivity.this.fro.bdh(), PbActivity.this.fro.bdK());
                        if (dVar.bao() != null) {
                            PbActivity.this.frE.bI(dVar.bao().wu());
                        }
                    }
                    if (PbActivity.this.eSU != null) {
                        PbActivity.this.eSU.ah(dVar.sc());
                    }
                    if (dVar == null || dVar.baB() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.frq.kt(PbActivity.this.mIsFromCDN);
                    PbActivity.this.frq.a(dVar, i2, i3, PbActivity.this.fro.bdi(), i4, PbActivity.this.fro.getIsFromMark());
                    PbActivity.this.frq.d(dVar, PbActivity.this.fro.bdi());
                    PbActivity.this.frq.kq(PbActivity.this.fro.getHostMode());
                    AntiData uo = dVar.uo();
                    if (uo != null) {
                        PbActivity.this.aMX = uo.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aMX) && PbActivity.this.frE != null && PbActivity.this.frE.Hg() != null && (eJ = PbActivity.this.frE.Hg().eJ(6)) != null && !TextUtils.isEmpty(PbActivity.this.aMX)) {
                            ((View) eJ).setOnClickListener(PbActivity.this.aNH);
                        }
                    }
                    if (PbActivity.this.frA) {
                        PbActivity.this.frA = false;
                        final int bbV = PbActivity.this.bbV();
                        if (dVar.baL()) {
                            final int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bbV, ah);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bbK().qJ(bbV);
                        }
                    }
                    if (PbActivity.this.frB) {
                        PbActivity.this.frB = false;
                        final int bbV2 = PbActivity.this.bbV();
                        final boolean z2 = bbV2 != -1;
                        if (!z2) {
                            bbV2 = PbActivity.this.bbW();
                        }
                        if (PbActivity.this.bbK() != null) {
                            if (dVar.baL()) {
                                final int ah2 = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bbV2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bbV2, ah2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bbV2 - 1, ah2);
                                            }
                                        }
                                    }
                                });
                            } else {
                                PbActivity.this.bbK().qJ(bbV2);
                            }
                        }
                    } else {
                        PbActivity.this.frq.bfg();
                    }
                    PbActivity.this.fro.a(dVar.bam(), PbActivity.this.fse);
                    PbActivity.this.fro.a(PbActivity.this.fsf);
                    if (PbActivity.this.eAs != null && dVar.bao() != null && dVar.bao().vm() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bao().vm());
                        PbActivity.this.eAs.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fry && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fro != null && PbActivity.this.fro.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fro.getAppealInfo().fom)) {
                                    PbActivity.this.frq.a(PbActivity.this.fro.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.frq.getView(), PbActivity.this.getPageContext().getResources().getString(d.k.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.frq.getView(), PbActivity.this.getPageContext().getResources().getString(d.k.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
                            }
                            PbActivity.this.frq.bfy();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fro.bdh());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getForumId());
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
                        PbActivity.this.frq.rt(PbActivity.this.getResources().getString(d.k.list_no_more_new));
                    } else {
                        PbActivity.this.frq.rt("");
                    }
                    PbActivity.this.frq.As();
                }
                PbActivity.this.aSW = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bbt().bdi() || PbActivity.this.bbt().getPbData().uB().uy() != 0 || PbActivity.this.bbt().bdD()) {
                    PbActivity.this.frF = true;
                    return;
                }
                return;
            }
            PbActivity.this.fro.qy(1);
            if (PbActivity.this.fqV != null) {
                PbActivity.this.fqV.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.frq.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.k.m.Ks().Kt()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.cSd : j;
                com.baidu.tbadk.k.i iVar = new com.baidu.tbadk.k.i(i, z, responsedMessage, PbActivity.this.aSO, PbActivity.this.createTime, PbActivity.this.aSW, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.aSO = 0L;
                if (iVar != null) {
                    iVar.Kp();
                }
                if (z2) {
                    iVar.aTf = currentTimeMillis;
                    iVar.bW(true);
                }
                if (!z2 && PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().bao() != null) {
                    int threadType = PbActivity.this.fro.getPbData().bao().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fri, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fri, "from_frs")) {
                                com.baidu.tbadk.k.i iVar2 = new com.baidu.tbadk.k.i();
                                iVar2.fk(1000);
                                iVar2.aTh = currentTimeMillis;
                                iVar2.fl(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.k.d dVar = new com.baidu.tbadk.k.d();
                        dVar.pageType = 1;
                        dVar.fk(1005);
                        dVar.aTh = currentTimeMillis;
                        dVar.fl(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fss = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bbR();
            }
        }
    };
    private final a.InterfaceC0099a fst = new a.InterfaceC0099a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0099a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.frq.bfc();
            if (z) {
                if (PbActivity.this.eSU != null) {
                    PbActivity.this.eSU.ah(z2);
                }
                PbActivity.this.fro.jV(z2);
                if (PbActivity.this.fro.sc()) {
                    PbActivity.this.bcb();
                } else {
                    PbActivity.this.frq.n(PbActivity.this.fro.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.eSU != null && PbActivity.this.eSU.sf() != null && PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().bao() != null && PbActivity.this.fro.getPbData().bao().vm() != null) {
                        MarkData sf = PbActivity.this.eSU.sf();
                        MetaData vm = PbActivity.this.fro.getPbData().bao().vm();
                        if (sf != null && vm != null) {
                            if (!com.baidu.tbadk.core.util.ao.equals(TbadkCoreApplication.getCurrentAccount(), vm.getUserId()) && !vm.hadConcerned()) {
                                PbActivity.this.b(vm);
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
            if (!PbActivity.this.qm(PbActivity.this.mLastScrollState) && PbActivity.this.qm(i)) {
                if (PbActivity.this.frq != null) {
                    PbActivity.this.frq.bfp();
                    if (PbActivity.this.frE != null && !PbActivity.this.frq.beH()) {
                        PbActivity.this.frq.ks(PbActivity.this.frE.HM());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.frq.beG();
                    }
                }
                if (!PbActivity.this.frc) {
                    PbActivity.this.frc = true;
                    PbActivity.this.frq.bfu();
                }
            }
            PbActivity.this.frq.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fqV != null) {
                PbActivity.this.fqV.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.frd == null) {
                PbActivity.this.frd = new com.baidu.tbadk.k.b();
                PbActivity.this.frd.fk(1001);
            }
            if (i == 0) {
                PbActivity.this.frd.Kj();
            } else {
                PbActivity.this.frd.Ki();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> baq;
            if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.frq != null && PbActivity.this.frq.beW() != null) {
                PbActivity.this.frq.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fqV != null) {
                    PbActivity.this.fqV.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fro.bdz() && (baq = PbActivity.this.fro.getPbData().baq()) != null && !baq.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.frq.beW().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fro.getPbData();
                    if (pbData != null) {
                        if (pbData.bar() != null && pbData.bar().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bas() != null && pbData.bas().hasData()) {
                            headerCount--;
                        }
                        int size = baq.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d czu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.czq.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fro.bdx();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.fHh != 1002 || bVar.dJI) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.frq.a(1, dVar.EY, dVar.gLr, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.czq.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.frq.a(PbActivity.this.czq.getLoadDataMode(), gVar.EY, gVar.gLr, false);
                        PbActivity.this.frq.ao(gVar.gLu);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.frq.a(PbActivity.this.czq.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fsu = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final f.b bnr = new f.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.f.b
        public void aS(boolean z) {
            if (PbActivity.this.bch()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fro.jU(true)) {
                PbActivity.this.frq.bfd();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fsw = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fsv && PbActivity.this.bch()) {
                PbActivity.this.bcj();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fro.jT(false)) {
                    PbActivity.this.frq.bfb();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fro.getPbData() != null) {
                    PbActivity.this.frq.bft();
                }
                PbActivity.this.fsv = true;
            }
        }
    };
    private int fsx = 0;
    private final TbRichTextView.h beD = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v35, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.frq.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
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
                    PbActivity.this.frm = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.ftm) {
                    TbRichText aE = PbActivity.this.aE(str, i);
                    if (aE != null && PbActivity.this.fsx >= 0 && PbActivity.this.fsx < aE.Ng().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aE.Ng().get(PbActivity.this.fsx));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.ftj.size()) {
                                break;
                            } else if (!cVar.ftj.get(i3).equals(b2)) {
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
                            concurrentHashMap.put(str2, cVar.ftk.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.ftl, cVar.lastId, PbActivity.this.fro.bdv(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        createConfig.setIsCanDrag(false);
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.w.c(cVar.ftj, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.w.z(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.ftk.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.ftl, cVar.ftj.get(0), PbActivity.this.fro.bdv(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fsy = false;
    PostData fsz = null;
    private final b.InterfaceC0103b fsA = new b.InterfaceC0103b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fsz != null) {
                if (i == 0) {
                    PbActivity.this.fsz.cj(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fsz = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.e(PbActivity.this.fsz);
                }
            }
        }
    };
    private final b.InterfaceC0103b fsB = new b.InterfaceC0103b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.frO != null && !TextUtils.isEmpty(PbActivity.this.frP)) {
                if (i == 0) {
                    if (PbActivity.this.frQ == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.frP));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.frP;
                        aVar.pkgId = PbActivity.this.frQ.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.frQ.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.biP == null) {
                        PbActivity.this.biP = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.biP.zU();
                    PbActivity.this.biP.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.biP.u(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.frN == null) {
                            PbActivity.this.frN = new aw(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.frN.i(PbActivity.this.frP, PbActivity.this.frO.nc());
                    } else {
                        return;
                    }
                }
                PbActivity.this.frO = null;
                PbActivity.this.frP = null;
            }
        }
    };
    private final View.OnLongClickListener aGs = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            SparseArray sparseArray;
            if (view instanceof TbImageView) {
                PbActivity.this.frO = ((TbImageView) view).getBdImage();
                PbActivity.this.frP = ((TbImageView) view).getUrl();
                if (PbActivity.this.frO != null && !TextUtils.isEmpty(PbActivity.this.frP)) {
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.frQ = null;
                    } else {
                        PbActivity.this.frQ = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.frq.a(PbActivity.this.fsB, PbActivity.this.frO.isGif());
                }
            } else if (view instanceof GifView) {
                if (((GifView) view).getBdImage() != null) {
                    PbActivity.this.frO = ((GifView) view).getBdImage();
                    if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                        PbActivity.this.frP = ((GifView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.frQ = null;
                    } else {
                        PbActivity.this.frQ = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.frq.a(PbActivity.this.fsB, PbActivity.this.frO.isGif());
                }
            } else if (view instanceof TbMemeImageView) {
                if (((TbMemeImageView) view).getBdImage() != null) {
                    PbActivity.this.frO = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        PbActivity.this.frP = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        PbActivity.this.frQ = null;
                    } else {
                        PbActivity.this.frQ = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                    }
                    PbActivity.this.frq.a(PbActivity.this.fsB, PbActivity.this.frO.isGif());
                }
            } else {
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray != null) {
                    PbActivity.this.fsz = (PostData) sparseArray.get(d.g.tag_clip_board);
                    if (PbActivity.this.fsz != null && PbActivity.this.eSU != null) {
                        PbActivity.this.frq.a(PbActivity.this.fsA, PbActivity.this.eSU.sc() && PbActivity.this.fsz.getId() != null && PbActivity.this.fsz.getId().equals(PbActivity.this.fro.vv()), ((Boolean) sparseArray.get(d.g.tag_is_subpb)).booleanValue());
                    }
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dfy = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (!PbActivity.this.fqX && z && !PbActivity.this.fro.bdp()) {
                PbActivity.this.bcd();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(PbActivity.this.getApplicationContext(), d.e.ds200));
        }
    };
    public View.OnTouchListener aVI = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
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
                    if (frameLayout2 != null && (childAt2 instanceof PbMainFloorPraiseFloatingView) && ((PbMainFloorPraiseFloatingView) childAt2).arQ()) {
                        break;
                    }
                }
            }
            PbActivity.this.bHu.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0146a bHv = new a.InterfaceC0146a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        final int cjj;

        {
            this.cjj = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void X(int i, int i2) {
            if (ad(i2) && PbActivity.this.frq != null && PbActivity.this.fqV != null) {
                PbActivity.this.frq.bfz();
                PbActivity.this.fqV.fH(false);
                PbActivity.this.fqV.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Y(int i, int i2) {
            if (ad(i2) && PbActivity.this.frq != null && PbActivity.this.fqV != null) {
                PbActivity.this.fqV.fH(true);
                if (Math.abs(i2) > this.cjj) {
                    PbActivity.this.fqV.hideFloatingView();
                }
                if (PbActivity.this.bch()) {
                    PbActivity.this.frq.beS();
                    PbActivity.this.frq.beT();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Z(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fsD = null;
    private final m.a fsE = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void h(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.k.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.k.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fsD = str2;
                PbActivity.this.frq.ru(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fsF = -1;
    private int fsG = -1;
    private CustomMessageListener fsJ = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.ada == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0101a) {
                    if (aVar.adb != null && !aVar.adb.hasError() && aVar.adb.getError() == 0) {
                        if (PbActivity.this.frq != null) {
                            PbActivity.this.frq.y(((a.C0101a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bcs();
                        }
                    } else if (z) {
                        if (aVar.adb != null && aVar.adb.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.adb.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.k.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.adb != null && !aVar.adb.hasError() && aVar.adb.getError() == 0) {
                        if (PbActivity.this.frq != null && PbActivity.this.frq != null) {
                            PbActivity.this.frq.y(((a.C0101a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.adb != null && aVar.adb.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.adb.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.k.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.adb == null || aVar.adb.hasError() || aVar.adb.getError() != 0) {
                        if (z) {
                            if (aVar.adb != null && aVar.adb.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.adb.getErrorString());
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
        public ArrayList<String> ftj;
        public ConcurrentHashMap<String, ImageUrlData> ftk;
        public boolean ftm;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean ftl = false;
        public boolean ftn = false;
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

    public com.baidu.tbadk.editortools.pb.d bbF() {
        return this.frE;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        if (kVar.baY() != null) {
            String id = kVar.baY().getId();
            ArrayList<PostData> baq = this.fro.getPbData().baq();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= baq.size()) {
                    break;
                }
                PostData postData = baq.get(i2);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i = i2 + 1;
                } else {
                    ArrayList<PostData> bbc = kVar.bbc();
                    postData.ty(kVar.getTotalCount());
                    if (postData.bwW() != null && bbc != null) {
                        Iterator<PostData> it = bbc.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.vm() != null && (metaData = postData.getUserMap().get(next.vm().getUserId())) != null) {
                                next.a(metaData);
                                next.mx(true);
                                next.b(getPageContext(), this.fro.ro(metaData.getUserId()));
                            }
                        }
                        postData.bwW().clear();
                        postData.bwW().addAll(bbc);
                    }
                    if (postData.bwS() != null) {
                        postData.bwT();
                    }
                }
            }
            if (!this.fro.getIsFromMark()) {
                this.frq.n(this.fro.getPbData());
            }
            c(kVar);
        }
    }

    public void bbG() {
        com.baidu.tieba.pb.data.d pbData;
        bd bao;
        if (!this.fsh) {
            if (!com.baidu.adp.lib.util.l.jU()) {
                showToast(d.k.no_network_guide);
            } else if (this.fsk) {
                this.fsh = true;
                if (this.fro != null && (pbData = this.fro.getPbData()) != null && (bao = pbData.bao()) != null) {
                    int isLike = bao.va() == null ? 0 : bao.va().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10796").ah("tid", bao.getId()));
                    }
                    if (this.fsi != null) {
                        this.fsi.a(bao.vC(), bao.getId(), isLike, "pb");
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
                bVar.cf(d.k.operation);
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(d.k.delete);
                    strArr[1] = z ? getResources().getString(d.k.un_mute) : getResources().getString(d.k.mute);
                    bVar.a(strArr, new b.InterfaceC0103b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.frq.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.frL);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.frL);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(d.k.un_mute) : getResources().getString(d.k.mute);
                    bVar.a(strArr2, new b.InterfaceC0103b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.frL);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.frL);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).xd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw(int i) {
        bd bao;
        String str;
        String C;
        if (this.fro != null && this.fro.getPbData() != null && (bao = this.fro.getPbData().bao()) != null) {
            if (i == 1) {
                PraiseData va = bao.va();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (va == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bao.a(praiseData);
                    } else {
                        bao.va().getUser().add(0, metaData);
                        bao.va().setNum(bao.va().getNum() + 1);
                        bao.va().setIsLike(i);
                    }
                }
                if (bao.va() != null) {
                    if (bao.va().getNum() < 1) {
                        C = getResources().getString(d.k.zan);
                    } else {
                        C = com.baidu.tbadk.core.util.ao.C(bao.va().getNum());
                    }
                    this.frq.M(C, true);
                }
            } else if (bao.va() != null) {
                bao.va().setIsLike(i);
                bao.va().setNum(bao.va().getNum() - 1);
                ArrayList<MetaData> user = bao.va().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bao.va().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bao.va().getNum() < 1) {
                    str = getResources().getString(d.k.zan);
                } else {
                    str = bao.va().getNum() + "";
                }
                this.frq.M(str, false);
            }
            if (this.fro.bdi()) {
                this.frq.beW().notifyDataSetChanged();
            } else {
                this.frq.o(this.fro.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fro.z(bundle);
        if (this.dhB != null) {
            this.dhB.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.frE.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.frb = System.currentTimeMillis();
        this.frJ = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.cSd = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fri = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fri) && intent.getData() != null) {
                this.fri = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fri)) {
                this.fqW = true;
            }
            this.fsF = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fsG = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fsH = intent.getStringExtra("key_manga_title");
            this.frA = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.frB = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bch()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ao.isEmpty(this.source) ? "" : this.source;
            this.frS = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.cSd = System.currentTimeMillis();
        }
        this.aSO = this.frb - this.cSd;
        super.onCreate(bundle);
        this.fqZ = 0;
        y(bundle);
        if (this.fro != null && this.fro.getPbData() != null) {
            this.fro.getPbData().rh(this.source);
        }
        initUI();
        if (intent != null && this.frq != null) {
            this.frq.fAp = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.frM == null) {
                    this.frM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.frq.rw("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.frM, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fro != null && this.fro.getPbData() != null) {
                this.fro.rr(stringExtra);
            }
        }
        this.dhB = new VoiceManager();
        this.dhB.onCreate(getPageContext());
        initData(bundle);
        this.frD = new com.baidu.tbadk.editortools.pb.f();
        bbH();
        this.frE = (com.baidu.tbadk.editortools.pb.d) this.frD.aY(getActivity());
        this.frE.b(this);
        this.frE.a(this.aNh);
        this.frE.a(this.aNa);
        this.frE.a(this, bundle);
        this.frE.Hg().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.frE.Hg().bB(true);
        jD(true);
        this.frq.setEditorTools(this.frE.Hg());
        this.frE.a(this.fro.bdr(), this.fro.bdh(), this.fro.bdK());
        registerListener(this.frZ);
        if (!this.fro.bdo()) {
            this.frE.gL(this.fro.bdh());
        }
        if (this.fro.bdL()) {
            this.frE.gJ(getPageContext().getString(d.k.pb_reply_hint_from_smart_frs));
        } else {
            this.frE.gJ(getPageContext().getString(d.k.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.frY);
        registerListener(this.fsa);
        registerListener(this.fsb);
        registerListener(this.diH);
        registerListener(this.fsp);
        registerListener(this.frX);
        this.frC = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.gIv);
        this.frC.bwC();
        registerListener(this.fsd);
        registerListener(this.mAttentionListener);
        if (this.fro != null) {
            this.fro.bdB();
        }
        registerListener(this.fss);
        registerListener(this.fsJ);
        registerListener(this.diO);
        if (this.frq != null && this.frq.bfD() != null && this.frq.bfE() != null) {
            this.fqV = new com.baidu.tieba.pb.pb.main.a.b(getActivity(), this.frq.bfD(), this.frq.bfE(), this.frq.beN());
            this.fqV.a(this.fsl);
        }
        if (this.fqU && this.frq != null && this.frq.bfE() != null) {
            this.frq.bfE().setVisibility(8);
        }
        this.frK = new com.baidu.tbadk.core.view.c();
        this.frK.auA = 1000L;
        registerListener(this.fso);
        registerListener(this.fsm);
        registerListener(this.fsn);
        this.frL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.frL;
        userMuteAddAndDelCustomMessage.setTag(this.frL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.frL;
        userMuteCheckCustomMessage.setTag(this.frL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fro.bdI().a(this.bZo);
        if ("from_tieba_kuang".equals(this.fri) && this.fri != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12264").r("obj_type", 2).ah("tid", this.fro.bdh()));
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
            httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.be("shoubai://internal?type=pb&param=" + this.fro.bdh()));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
        this.frw = new au();
        if (this.frE.HF() != null) {
            this.frw.g(this.frE.HF().getInputView());
        }
        this.frE.a(this.aNb);
        this.dvD = new ShareSuccessReplyToServerModel();
        a(this.frU);
        this.eAs = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.eAs.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.aqv) {
                        PbActivity.this.frE.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.aqw && PbActivity.this.frq != null && PbActivity.this.frq.beF() != null && PbActivity.this.frq.beF().bcY() != null) {
                        PbActivity.this.frq.beF().bcY().HY();
                    } else if (i == com.baidu.tbadk.core.util.aj.aqx) {
                        PbActivity.this.c(PbActivity.this.frG);
                    }
                }
            }
        });
        this.frp = new com.baidu.tieba.pb.pb.report.a(this);
        this.frp.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.frb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbH() {
        if (this.frD != null && this.fro != null) {
            this.frD.setForumName(this.fro.bdg());
            if (this.fro.getPbData() != null && this.fro.getPbData().bam() != null) {
                this.frD.a(this.fro.getPbData().bam());
            }
            this.frD.setFrom("pb");
            this.frD.a(this.fro);
        }
    }

    public String bbI() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.a.b bbJ() {
        return this.fqV;
    }

    private void jD(boolean z) {
        this.frE.bF(z);
        this.frE.bG(z);
        this.frE.bH(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().baL() && !z && this.frq != null && this.frq.getView() != null) {
            this.frq.getView().setSystemUiVisibility(4);
        }
        this.frH = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    public as bbK() {
        return this.frq;
    }

    public PbModel bbt() {
        return this.fro;
    }

    public void ri(String str) {
        if (this.fro != null && !StringUtils.isNull(str) && this.frq != null) {
            this.frq.kw(true);
            this.fro.ri(str);
            this.frh = true;
            this.frq.bfp();
            this.frq.bfy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fqX = false;
        } else {
            this.fqX = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fqZ = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fqZ == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
        if (this.frq != null) {
            this.frq.onPause();
        }
        if (!this.fro.bdo()) {
            this.frE.gK(this.fro.bdh());
        }
        if (this.fro != null) {
            this.fro.bdC();
        }
        MessageManager.getInstance().unRegisterListener(this.eeb);
        aDB();
        MessageManager.getInstance().unRegisterListener(this.fsm);
        MessageManager.getInstance().unRegisterListener(this.fsn);
        MessageManager.getInstance().unRegisterListener(this.fso);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bbL() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fro.getPbData(), this.fro.bdi(), this.fro.getRequestType());
        return (a2 == null || a2.vm() == null || a2.vm().getGodUserData() == null || a2.vm().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fqX = false;
        super.onResume();
        if (this.frk) {
            this.frk = false;
            bcn();
        }
        if (bbL()) {
            this.fre = System.currentTimeMillis();
        } else {
            this.fre = -1L;
        }
        if (this.frq != null && this.frq.getView() != null) {
            if (!this.eVQ) {
                bce();
            } else {
                hideLoadingView(this.frq.getView());
            }
            this.frq.onResume();
        }
        if (this.fqZ == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.frq != null) {
            noNetworkView = this.frq.beC();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.jD()) {
            noNetworkView.aP(false);
        }
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
        registerListener(this.eeb);
        this.frz = false;
        bcm();
        registerListener(this.fsm);
        registerListener(this.fsn);
        registerListener(this.fso);
        if (this.dik) {
            bcd();
            this.dik = false;
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
        this.frq.kl(z);
        if (this.frx != null) {
            this.frx.jX(z);
        }
        if (z && this.frz) {
            this.frq.bfb();
            this.fro.jT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fre > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").ah("obj_duration", (System.currentTimeMillis() - this.fre) + ""));
            this.fre = 0L;
        }
        if (bbK().beF() != null) {
            bbK().beF().onStop();
        }
        if (this.frq.fAw != null && !this.frq.fAw.ajN()) {
            this.frq.fAw.aOZ();
        }
        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().bam() != null && this.fro.getPbData().bao() != null) {
            com.baidu.tbadk.distribute.a.GR().a(getPageContext().getPageActivity(), "pb", this.fro.getPbData().bam().getId(), com.baidu.adp.lib.g.b.c(this.fro.getPbData().bao().getId(), 0L));
        }
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!this.frc && this.frq != null) {
            this.frc = true;
            this.frq.bfu();
            a(false, (PostData) null);
        }
        if (this.fro != null) {
            this.fro.cancelLoadData();
            this.fro.destory();
            if (this.fro.bdH() != null) {
                this.fro.bdH().onDestroy();
            }
        }
        if (this.frE != null) {
            this.frE.onDestroy();
        }
        if (this.czq != null) {
            this.czq.cancelLoadData();
        }
        if (this.frq != null) {
            this.frq.onDestroy();
            if (this.frq.fAw != null) {
                this.frq.fAw.aOZ();
            }
        }
        if (this.frd != null) {
            this.frd.Kk();
        }
        if (this.fqV != null) {
            this.fqV.Lg();
        }
        super.onDestroy();
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
        this.frq.bfp();
        MessageManager.getInstance().unRegisterListener(this.fsm);
        MessageManager.getInstance().unRegisterListener(this.fsn);
        MessageManager.getInstance().unRegisterListener(this.fso);
        MessageManager.getInstance().unRegisterListener(this.frL);
        MessageManager.getInstance().unRegisterListener(this.fsp);
        MessageManager.getInstance().unRegisterListener(this.diO);
        this.frJ = null;
        this.frK = null;
        com.baidu.tieba.recapp.d.a.boX().boZ();
        if (this.frM != null) {
            getSafeHandler().removeCallbacks(this.frM);
        }
        if (this.frl != null) {
            this.frl.cancelLoadData();
        }
        if (this.frq != null && this.frq.fAw != null) {
            this.frq.fAw.bgl();
        }
        if (this.dvD != null) {
            this.dvD.cancelLoadData();
        }
        this.frw.onDestroy();
        if (this.dio != null) {
            this.dio.onDestroy();
        }
        if (this.fro != null && this.fro.bdJ() != null) {
            this.fro.bdJ().onDestroy();
        }
        if (this.eAs != null) {
            this.eAs.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f beW;
        ArrayList<PostData> bcK;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.BG() && this.frq != null && (beW = this.frq.beW()) != null && (bcK = beW.bcK()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bcK.iterator();
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
                        bVar.cBm = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.aiI == 1 && !TextUtils.isEmpty(id)) {
                    next.aiI = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.cBm = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fro == null || this.fro.getPbData() == null || this.fro.getPbData().bam() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fro.getPbData().bam().getFirst_class();
                    str2 = this.fro.getPbData().bam().getSecond_class();
                    str = this.fro.getPbData().bam().getId();
                    str4 = this.fro.bdh();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.BJ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.frq.onChangeSkinType(i);
            if (this.frE != null && this.frE.Hg() != null) {
                this.frE.Hg().onChangeSkinType(i);
            }
            if (this.frq.beC() != null) {
                this.frq.beC().onChangeSkinType(getPageContext(), i);
            }
            this.frw.onChangeSkinType();
            if (this.dio != null) {
                this.dio.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.frq = new as(this, this.djp, this.beE);
        this.bHu = new com.baidu.tieba.f.b(getActivity());
        this.bHu.a(fsC);
        this.bHu.a(this.bHv);
        this.frq.setOnScrollListener(this.mOnScrollListener);
        this.frq.e(this.fsw);
        this.frq.a(this.bnr);
        this.frq.jx(com.baidu.tbadk.core.i.tt().tz());
        this.frq.setOnImageClickListener(this.beD);
        this.frq.b(this.aGs);
        this.frq.h(this.dfy);
        this.frq.a(this.fsu);
        this.frq.kl(this.mIsLogin);
        if (getIntent() != null) {
            this.frq.kx(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aY(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.gIW && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.tt().tz()) {
                    return rl(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fro == null || this.fro.getPbData() == null) {
                        return true;
                    }
                    if (bbK().beF() != null) {
                        bbK().beF().bcT();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.fro.getPbData().bam());
                    kVar.T(this.fro.getPbData().bao());
                    kVar.d(postData);
                    bbK().beE().d(kVar);
                    bbK().beE().setPostId(postData.getId());
                    b(view, postData.vm().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.frE != null) {
                        this.frq.ks(this.frE.HM());
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
        if (this.frq != null) {
            if (z && !this.eVQ) {
                bce();
            } else {
                hideLoadingView(this.frq.getView());
            }
            if (z && this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().baL() && this.frq.getView() != null) {
                this.frq.getView().setSystemUiVisibility(4);
            }
        }
    }

    private void bbM() {
        if (this.fra == null) {
            this.fra = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fra.a(new String[]{getPageContext().getString(d.k.call_phone), getPageContext().getString(d.k.sms_phone), getPageContext().getString(d.k.search_in_baidu)}, new b.InterfaceC0103b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fqP = PbActivity.this.fqP.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fqP);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fro.bdh(), PbActivity.this.fqP, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fqP = PbActivity.this.fqP.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fqP);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fro.bdh(), PbActivity.this.fqP, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fqP = PbActivity.this.fqP.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fqP);
                        bVar.dismiss();
                    }
                }
            }).cg(b.a.alc).ch(17).d(getPageContext());
        }
    }

    private void y(Bundle bundle) {
        this.fro = new PbModel(this);
        this.fro.a(this.fsr);
        if (this.fro.bdF() != null) {
            this.fro.bdF().a(this.fsE);
        }
        if (this.fro.bdE() != null) {
            this.fro.bdE().a(this.fsc);
        }
        if (this.fro.bdH() != null) {
            this.fro.bdH().b(this.frW);
        }
        if (bundle != null) {
            this.fro.initWithBundle(bundle);
        } else {
            this.fro.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fro.jW(true);
        }
        ai.bep().L(this.fro.bdf(), this.fro.getIsFromMark());
        if (StringUtils.isNull(this.fro.bdh())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fri) && this.fri != null) {
            this.fro.qE(6);
        }
        if (this.fro.bdG() != null) {
            this.fro.bdG().a(this.frV);
        }
        if (this.fro.bdJ() != null) {
            this.fro.bdJ().a(this.diq);
        }
        this.fro.JE();
    }

    private void initData(Bundle bundle) {
        this.eSU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.eSU != null) {
            this.eSU.a(this.fst);
        }
        this.czq = new ForumManageModel(this);
        this.czq.setLoadDataCallBack(this.czu);
        this.aqA = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.frq.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void i(Object obj) {
                if (!com.baidu.adp.lib.util.j.jD()) {
                    PbActivity.this.showToast(d.k.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fro.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fro.getPbData().bam().getId(), PbActivity.this.fro.getPbData().bam().getName(), PbActivity.this.fro.getPbData().bao().getId(), valueOf, str, str3, str2)));
            }
        });
        this.fsi.setUniqueId(getUniqueId());
        this.fsi.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.frq.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.frL;
        userMuteCheckCustomMessage.setTag(this.frL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bbN() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fro != null && (pbData = this.fro.getPbData()) != null) {
            return pbData.baz().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bao() != null) {
            if (dVar.bao().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bao().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bao().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData aZ(final View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(d.g.tag_clip_board)) != null) {
            if (postData.bxl()) {
                postData.da(postData.bxk() - 1);
            } else {
                postData.da(postData.bxk() + 1);
                com.baidu.tieba.n.a.bnR().y(getPageContext());
            }
            postData.my(!postData.bxl());
            ((PbFloorAgreeView) view).a(postData.bxl(), postData.bxk(), true);
            final int i = postData.bxl() ? 0 : 1;
            this.fro.bdG().a(postData.getId(), i, new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
                @Override // com.baidu.tieba.pb.pb.main.q.a
                public void qs(int i2) {
                    if (i2 > 0 && i == 0) {
                        ((PbFloorAgreeView) view).qP(i2);
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

    public com.baidu.tbadk.core.util.am bbO() {
        return new com.baidu.tbadk.core.util.am("c12003").ah("tid", this.fro.fwu).r("obj_type", 0).ah(ImageViewerConfig.FORUM_ID, this.fro.getForumId()).r("obj_param1", this.fro.getPbData().bao().getThreadType() == 40 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && bbP()) {
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
                        PbActivity.this.bbK().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bbK().beF() != null) {
                        PbActivity.this.frE.Hg().setVisibility(8);
                        PbActivity.this.bbK().beF().bO(str, str2);
                        com.baidu.tbadk.editortools.pb.g bcY = PbActivity.this.bbK().beF().bcY();
                        if (bcY != null && PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null) {
                            bcY.a(PbActivity.this.fro.getPbData().uo());
                        }
                        if (PbActivity.this.frw.bfR() == null && PbActivity.this.bbK().beF().bcY().Ig() != null) {
                            PbActivity.this.bbK().beF().bcY().Ig().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.frw != null && PbActivity.this.frw.bfQ() != null) {
                                        if (!PbActivity.this.frw.bfQ().bGb()) {
                                            PbActivity.this.frw.kz(false);
                                        }
                                        PbActivity.this.frw.bfQ().ns(false);
                                    }
                                }
                            });
                            PbActivity.this.frw.h(PbActivity.this.bbK().beF().bcY().Ig().getInputView());
                            PbActivity.this.bbK().beF().bcY().a(PbActivity.this.frI);
                        }
                    }
                    PbActivity.this.bbK().bfy();
                }
            }, 500L);
        }
    }

    public boolean bbP() {
        if (this.eAs == null || this.fro.getPbData() == null || this.fro.getPbData().uo() == null) {
            return true;
        }
        return this.eAs.cM(this.fro.getPbData().uo().replyPrivateFlag);
    }

    public boolean qo(int i) {
        if (this.eAs == null || this.fro.getPbData() == null || this.fro.getPbData().uo() == null) {
            return true;
        }
        return this.eAs.u(this.fro.getPbData().uo().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.fro != null && this.fro.getPbData() != null && postData.bwZ() > 1) {
            String bdh = this.fro.bdh();
            String id = postData.getId();
            int baA = this.fro.getPbData() != null ? this.fro.getPbData().baA() : 0;
            c rm = rm(id);
            if (rm != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bdh, id, "pb", true, null, false, null, baA, postData.bgZ(), this.fro.getPbData().uo(), false, postData.vm() != null ? postData.vm().getIconInfo() : null).addBigImageData(rm.ftj, rm.ftk, rm.ftl, rm.index);
                addBigImageData.setKeyPageStartFrom(this.fro.bdN());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public void a(View view, int i, boolean z, int i2) {
        ap apVar;
        if ((i >= 1 || i <= 4) && checkUpIsLogin()) {
            if (!com.baidu.adp.lib.util.l.jU()) {
                showToast(d.k.no_network_guide);
            } else if (bbt() != null && bbt().getPbData() != null && bbt().getPbData().baK() != null) {
                com.baidu.tieba.pb.data.j baK = bbt().getPbData().baK();
                if (view == null || !(view.getTag(d.g.pb_main_thread_praise_view) instanceof ap)) {
                    apVar = null;
                } else {
                    apVar = (ap) view.getTag(d.g.pb_main_thread_praise_view);
                }
                if (baK != null) {
                    int i3 = -1;
                    if (z) {
                        baK.qg(i);
                    } else if (baK.baS()) {
                        baK.baV();
                        i3 = 1;
                    } else {
                        baK.qi(i);
                        i3 = 0;
                        com.baidu.tieba.n.a.bnR().y(getPageContext());
                    }
                    baK.qh(i2);
                    q.a aVar = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
                        @Override // com.baidu.tieba.pb.pb.main.q.a
                        public void qs(int i4) {
                        }

                        @Override // com.baidu.tieba.pb.pb.main.q.a
                        public void c(CustomDialogData customDialogData) {
                            customDialogData.type = 0;
                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
                        }
                    };
                    if (this.fro != null && this.fro.bdG() != null) {
                        String str = "";
                        if (this.fro.getPbData() != null && this.fro.getPbData().bao() != null) {
                            str = this.fro.getPbData().bao().vC();
                        }
                        if (this.fro.getPbData() != null) {
                            this.fro.getPbData().a(baK);
                        }
                        if (z) {
                            this.fro.bdG().a(str, 3, i, this.fro.getForumId(), aVar);
                        } else {
                            this.fro.bdG().a(str, i3, 3, i, this.fro.getForumId(), aVar);
                            com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i();
                            iVar.fpg = i3;
                            iVar.fph = baK;
                            iVar.pid = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016551, iVar));
                        }
                    }
                    if (apVar != null) {
                        apVar.b(baK);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bbQ() {
        if (this.fro.getPbData() == null || this.fro.getPbData().bao() == null) {
            return -1;
        }
        return this.fro.getPbData().bao().vO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbR() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.ti(this.fro.getForumId()) && this.fro.getPbData() != null && this.fro.getPbData().bam() != null) {
            if (this.fro.getPbData().bam().isLike() == 1) {
                this.fro.bdJ().cd(this.fro.getForumId(), this.fro.bdh());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jE(boolean z) {
        if (this.fro == null || this.fro.getPbData() == null) {
            return false;
        }
        return ((this.fro.getPbData().baA() != 0) || this.fro.getPbData().bao() == null || this.fro.getPbData().bao().vm() == null || TextUtils.equals(this.fro.getPbData().bao().vm().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bbS() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.o.r.KK()) {
            return "";
        }
        PostData bav = bav();
        if (this.fro == null || (pbData = this.fro.getPbData()) == null || pbData.getUserData() == null || pbData.bao() == null || bav == null || bav.vm() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bav.vm().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bao().uW() == 0) {
            return "";
        }
        if (pbData.bao().uW() == 0) {
            return getPageContext().getString(d.k.fans_call);
        }
        return getPageContext().getString(d.k.haved_fans_call);
    }

    private boolean jF(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.u uVar;
        if (z) {
            return true;
        }
        if (this.fro == null || this.fro.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fro.getPbData();
        if (pbData.baA() == 0) {
            List<az> baI = pbData.baI();
            if (com.baidu.tbadk.core.util.w.y(baI) > 0) {
                for (az azVar : baI) {
                    if (azVar != null && (uVar = azVar.ahC) != null && uVar.afG && !uVar.isDeleted && (uVar.type == 1 || uVar.type == 2)) {
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

    private boolean jG(boolean z) {
        return (z || this.fro == null || this.fro.getPbData() == null || this.fro.getPbData().baA() == 0) ? false : true;
    }

    public void bbT() {
        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().bao() != null && this.fro.getPbData().bao().vm() != null) {
            if (this.frq != null) {
                this.frq.beD();
            }
            bd bao = this.fro.getPbData().bao();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bao.vm().getUserId());
            aa aaVar = new aa();
            int baA = this.fro.getPbData().baA();
            if (baA == 1) {
                aaVar.fyu = true;
                aaVar.fyt = true;
                aaVar.fyB = bao.vh() == 1;
                aaVar.fyA = bao.vi() == 1;
            } else {
                aaVar.fyu = false;
                aaVar.fyt = false;
            }
            if (baA == 1002 && !equals) {
                aaVar.fyF = true;
            }
            aaVar.fyr = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            aaVar.fyv = jF(equals);
            aaVar.fyw = bbU();
            aaVar.fyx = jG(equals);
            aaVar.nU = this.fro.bdi();
            aaVar.fys = true;
            aaVar.fpw = this.eSU != null && this.eSU.sc();
            aaVar.fyq = jE(equals);
            aaVar.fyD = bbS();
            aaVar.fyp = equals && this.frq.bfi();
            aaVar.fyy = TbadkCoreApplication.getInst().getSkinType() == 1;
            aaVar.fyz = true;
            aaVar.isHostOnly = this.fro.getHostMode();
            aaVar.fyC = true;
            if (bao.vD() == null) {
                aaVar.fyE = true;
            } else {
                aaVar.fyE = false;
            }
            this.frq.fAw.a(aaVar);
        }
    }

    private boolean bbU() {
        if (this.fro != null && this.fro.bdi()) {
            return this.fro.aEh() == null || this.fro.aEh().uy() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(View view) {
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

    public int bbV() {
        if (bbK() == null || bbK().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bbK().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fpc) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bbW() {
        if (bbK() == null || bbK().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bbK().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.gIV) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bcd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.dA(getResources().getString(d.k.mark_done));
            aVar.aB(true);
            aVar.dB(getResources().getString(d.k.mark_like));
            aVar.aA(true);
            aVar.au(false);
            aVar.b(getResources().getString(d.k.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").ah(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.k.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").ah(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).r("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aqA.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fro.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).xa();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.frq.bfc();
        this.fro.jV(z);
        if (this.eSU != null) {
            this.eSU.ah(z);
            if (markData != null) {
                this.eSU.a(markData);
            }
        }
        if (this.fro.sc()) {
            bcb();
        } else {
            this.frq.n(this.fro.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qm(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rj(String str) {
        this.frp.rF(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fro.bdo()) {
                    antiData.setBlock_forum_name(this.fro.getPbData().bam().getName());
                    antiData.setBlock_forum_id(this.fro.getPbData().bam().getId());
                    antiData.setUser_name(this.fro.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fro.getPbData().getUserData().getUserId());
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
        if (AntiHelper.tE(i)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").r("obj_locate", as.a.ark));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").r("obj_locate", as.a.ark));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").r("obj_locate", as.a.ark));
            }
        } else if (i == 230277) {
            gR(str);
        } else {
            this.frq.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            this.frq.a(0, bVar.EY, bVar.gLr, z);
            if (bVar.EY) {
                if (bVar.gLp == 1) {
                    ArrayList<PostData> baq = this.fro.getPbData().baq();
                    int size = baq.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(baq.get(i).getId())) {
                            i++;
                        } else {
                            baq.remove(i);
                            break;
                        }
                    }
                    this.frq.n(this.fro.getPbData());
                } else if (bVar.gLp == 0) {
                    bbX();
                } else if (bVar.gLp == 2) {
                    ArrayList<PostData> baq2 = this.fro.getPbData().baq();
                    int size2 = baq2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= baq2.get(i2).bwW().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(baq2.get(i2).bwW().get(i3).getId())) {
                                i3++;
                            } else {
                                baq2.get(i2).bwW().remove(i3);
                                baq2.get(i2).bwY();
                                z2 = true;
                                break;
                            }
                        }
                        baq2.get(i2).tN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.frq.n(this.fro.getPbData());
                    }
                    a(bVar, this.frq);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.frq.a(this.czq.getLoadDataMode(), gVar.EY, gVar.gLr, false);
            if (gVar.EY) {
                this.frt = true;
                if (i == 2 || i == 3) {
                    this.fru = true;
                    this.frv = false;
                } else if (i == 4 || i == 5) {
                    this.fru = false;
                    this.frv = true;
                }
                if (i == 2) {
                    this.fro.getPbData().bao().bT(1);
                    this.fro.setIsGood(1);
                } else if (i == 3) {
                    this.fro.getPbData().bao().bT(0);
                    this.fro.setIsGood(0);
                } else if (i == 4) {
                    this.fro.getPbData().bao().bS(1);
                    this.fro.iZ(1);
                } else if (i == 5) {
                    this.fro.getPbData().bao().bS(0);
                    this.fro.iZ(0);
                }
                this.frq.c(this.fro.getPbData(), this.fro.bdi());
            }
        }
    }

    private void bbX() {
        if (this.fro.bdj() || this.fro.bdl()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fro.bdh());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fro.bdh()));
        if (bcc()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbY() {
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bax;
        boolean z = false;
        if (this.frq != null) {
            this.frq.bfp();
        }
        if (this.fro != null && this.fro.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this;
            historyMessage.threadId = this.fro.getPbData().bao().getId();
            if (this.fro.isShareThread() && this.fro.getPbData().bao().ajP != null) {
                historyMessage.threadName = this.fro.getPbData().bao().ajP.showText;
            } else {
                historyMessage.threadName = this.fro.getPbData().bao().getTitle();
            }
            if (this.fro.isShareThread() && !bcu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fro.getPbData().bam().getName();
            }
            ArrayList<PostData> baq = this.fro.getPbData().baq();
            int bfe = this.frq != null ? this.frq.bfe() : 0;
            if (baq != null && bfe >= 0 && bfe < baq.size()) {
                historyMessage.postID = baq.get(bfe).getId();
            }
            historyMessage.isHostOnly = this.fro.getHostMode();
            historyMessage.isSquence = this.fro.bdi();
            historyMessage.isShareThread = this.fro.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.frE != null) {
            this.frE.onDestroy();
        }
        if (this.fqY && bbK() != null) {
            bbK().bfI();
        }
        if (this.fro != null && (this.fro.bdj() || this.fro.bdl())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fro.bdh());
            if (this.frt) {
                if (this.frv) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fro.bdn());
                }
                if (this.fru) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fro.getIsGood());
                }
            }
            if (this.fro.getPbData() != null && System.currentTimeMillis() - this.frb >= 40000 && (bax = this.fro.getPbData().bax()) != null && !com.baidu.tbadk.core.util.w.z(bax.getDataList())) {
                intent.putExtra("guess_like_data", bax);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.frS);
            }
            setResult(-1, intent);
        }
        if (bcc()) {
            if (this.fro != null && this.frq != null && this.frq.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fro.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bau() && !this.frh) {
                        ai bep = ai.bep();
                        com.baidu.tieba.pb.data.d pbData2 = this.fro.getPbData();
                        Parcelable onSaveInstanceState = this.frq.getListView().onSaveInstanceState();
                        boolean bdi = this.fro.bdi();
                        boolean hostMode = this.fro.getHostMode();
                        if (this.frq.beN() != null && this.frq.beN().getVisibility() == 0) {
                            z = true;
                        }
                        bep.a(pbData2, onSaveInstanceState, bdi, hostMode, z);
                        if (this.frR >= 0 || this.fro.bdP() != null) {
                            ai.bep().i(this.fro.bdP());
                            ai.bep().h(this.fro.bdQ());
                            ai.bep().qG(this.fro.bdR());
                        }
                    }
                }
            } else {
                ai.bep().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.frq == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.frq.qK(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qp(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.frq.beD();
            this.frq.beF().bcT();
            this.frq.ku(false);
        }
        this.frq.beG();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.frE.resetData();
                        this.frE.b(writeData);
                        this.frE.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k eM = this.frE.Hg().eM(6);
                        if (eM != null && eM.aLj != null) {
                            eM.aLj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.frE.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.frq.beF() != null && this.frq.beF().bcY() != null) {
                            com.baidu.tbadk.editortools.pb.g bcY = this.frq.beF().bcY();
                            bcY.b(writeData);
                            bcY.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k eM2 = bcY.Hg().eM(6);
                            if (eM2 != null && eM2.aLj != null) {
                                eM2.aLj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bcY.HY();
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
        this.frE.onActivityResult(i, i2, intent);
        if (this.frl != null) {
            this.frl.onActivityResult(i, i2, intent);
        }
        if (bbK().beF() != null) {
            bbK().beF().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bca();
                    return;
                case 13008:
                    ai.bep().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fro != null) {
                                PbActivity.this.fro.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bnR().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fro != null) {
                        a(bbZ(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    J(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bnR().x(getPageContext());
                        bbR();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dvD != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dvD.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void Ee() {
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
                    this.frq.jC(false);
                    if (this.fro.getPbData() != null && this.fro.getPbData().bao() != null && this.fro.getPbData().bao().vF() != null) {
                        this.fro.getPbData().bao().vF().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.frG = emotionImageData;
                        if (qo(com.baidu.tbadk.core.util.aj.aqx)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.frq != null && this.frq.fAw != null) {
                        this.frq.fAw.sL();
                        this.frq.fAw.bgf();
                        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().bao() != null) {
                            this.fro.getPbData().bao().bO(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.frm != null) {
                        this.frq.bi(this.frm);
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
            if (this.frl == null) {
                this.frl = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.frl.b(this.aNa);
                this.frl.c(this.aNh);
            }
            this.frl.a(emotionImageData, bbt(), bbt().getPbData());
        }
    }

    private ShareFromPBMsgData bbZ() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] bX = this.fro.getPbData().bX(getPageContext().getPageActivity());
        PostData beI = this.frq.beI();
        String str = "";
        if (beI != null) {
            str = beI.getId();
            String ck = beI.ck(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ck)) {
                bX[1] = ck;
            }
        }
        String vC = this.fro.getPbData().bao().vC();
        if (vC != null && vC.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(bX[1]);
        shareFromPBMsgData.setImageUrl(bX[0]);
        shareFromPBMsgData.setForumName(this.fro.getPbData().bam().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fro.getPbData().bao().getId());
        shareFromPBMsgData.setTitle(this.fro.getPbData().bao().getTitle());
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bbZ(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().bao() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null) {
                        com.baidu.tbadk.core.util.am ah = new com.baidu.tbadk.core.util.am("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_param1", 3).ah(ImageViewerConfig.FORUM_ID, PbActivity.this.fro.getForumId()).ah("tid", PbActivity.this.fro.bdh());
                        if (PbActivity.this.e(PbActivity.this.fro.getPbData()) != 0) {
                            ah.r("obj_type", PbActivity.this.e(PbActivity.this.fro.getPbData()));
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
            aVar.av(true);
            aVar.b(getPageContext()).xa();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.fro.getPbData().baB() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().bao() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ce(1);
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
            aVar.av(true);
            aVar.b(getPageContext()).xa();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), this.fro.getPbData().baB() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bca() {
        MarkData qD;
        if (this.eSU != null && (qD = this.fro.qD(this.frq.bff())) != null) {
            if (!qD.isApp() || (qD = this.fro.qD(this.frq.bff() + 1)) != null) {
                this.frq.bfa();
                this.eSU.a(qD);
                if (!this.eSU.sc()) {
                    this.eSU.se();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.eSU.sd();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcb() {
        com.baidu.tieba.pb.data.d pbData = this.fro.getPbData();
        this.fro.jV(true);
        if (this.eSU != null) {
            pbData.rg(this.eSU.sb());
        }
        this.frq.n(pbData);
    }

    private boolean bcc() {
        if (this.fro == null) {
            return true;
        }
        if (this.fro.sc()) {
            final MarkData bdw = this.fro.bdw();
            if (bdw == null || !this.fro.getIsFromMark()) {
                return true;
            }
            final MarkData qD = this.fro.qD(this.frq.bfe());
            if (qD == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bdw);
                setResult(-1, intent);
                return true;
            } else if (qD.getPostId() == null || qD.getPostId().equals(bdw.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bdw);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dB(getPageContext().getString(d.k.alert_update_mark));
                aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.eSU != null) {
                            if (PbActivity.this.eSU.sc()) {
                                PbActivity.this.eSU.sd();
                                PbActivity.this.eSU.ah(false);
                            }
                            PbActivity.this.eSU.a(qD);
                            PbActivity.this.eSU.ah(true);
                            PbActivity.this.eSU.se();
                        }
                        bdw.setPostId(qD.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bdw);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bbY();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bdw);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bbY();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.frq != null && PbActivity.this.frq.getView() != null) {
                            PbActivity.this.frq.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bdw);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bbY();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.xa();
                return false;
            }
        } else if (this.fro.getPbData() == null || this.fro.getPbData().baq() == null || this.fro.getPbData().baq().size() <= 0 || !this.fro.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.frq == null) {
            return null;
        }
        return this.frq.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int NL() {
        if (this.frq == null) {
            return 0;
        }
        return this.frq.bfn();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> NM() {
        if (this.beu == null) {
            this.beu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: aeW */
                public ImageView mo9if() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean tz = com.baidu.tbadk.core.i.tt().tz();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(d.C0141d.common_color_10220));
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
                        foreDrawableImageView.setDefaultBgResource(d.C0141d.common_color_10220);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0141d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.beu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> NN() {
        if (this.bev == null) {
            this.bev = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.bev;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> NO() {
        if (this.bez == null) {
            this.bez = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcx */
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
                    gifView.IA();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.bez;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> NP() {
        if (this.bew == null) {
            this.bew = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcy */
                public View mo9if() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bc */
                public void q(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bd */
                public View r(View view) {
                    ((PlayVoiceBntNew) view).byi();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: be */
                public View s(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.bew;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> NR() {
        this.bey = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bcz */
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
        return this.bey;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AK() {
        if (this.ayn == null) {
            this.ayn = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.ayn;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.frf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void f(Context context, String str, boolean z) {
        if (ax.rx(str) && this.fro != null && this.fro.bdh() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").r("obj_param1", 1).ah("post_id", this.fro.bdh()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                hVar.mLink = str;
                hVar.type = 3;
                hVar.aKf = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
            }
        } else {
            ax.bfT().c(getPageContext(), str);
        }
        this.frf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        ax.bfT().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.frf = true;
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
            com.baidu.tieba.pb.data.d pbData = this.fro.getPbData();
            TbRichText aE = aE(str, i);
            if (aE != null && (tbRichTextData = aE.Ng().get(this.fsx)) != null) {
                cVar.ftj = new ArrayList<>();
                cVar.ftk = new ConcurrentHashMap<>();
                if (!tbRichTextData.Nm().Ny()) {
                    cVar.ftm = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.ftj.add(b2);
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
                    imageUrlData.postId = aE.getPostId();
                    imageUrlData.mIsReserver = this.fro.bdv();
                    imageUrlData.mIsSeeHost = this.fro.getHostMode();
                    cVar.ftk.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.bam() != null) {
                            cVar.forumName = pbData.bam().getName();
                            cVar.forumId = pbData.bam().getId();
                        }
                        if (pbData.bao() != null) {
                            cVar.threadId = pbData.bao().getId();
                        }
                        cVar.ftl = pbData.baB() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.ftm = true;
                int size = pbData.baq().size();
                this.fsy = false;
                cVar.index = -1;
                if (pbData.bav() != null) {
                    PostData bav = pbData.bav();
                    TbRichText bxb = bav.bxb();
                    if (!ar.j(bav)) {
                        i2 = a(bxb, aE, i, i, cVar.ftj, cVar.ftk);
                    } else {
                        i2 = a(bav, i, cVar.ftj, cVar.ftk);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.baq().get(i4);
                    if (postData.getId() == null || pbData.bav() == null || pbData.bav().getId() == null || !postData.getId().equals(pbData.bav().getId())) {
                        TbRichText bxb2 = postData.bxb();
                        if (!ar.j(postData)) {
                            i3 = a(bxb2, aE, i3, i, cVar.ftj, cVar.ftk);
                        } else {
                            i3 = a(postData, i3, cVar.ftj, cVar.ftk);
                        }
                    }
                }
                if (cVar.ftj.size() > 0) {
                    cVar.lastId = cVar.ftj.get(cVar.ftj.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.bam() != null) {
                        cVar.forumName = pbData.bam().getName();
                        cVar.forumId = pbData.bam().getId();
                    }
                    if (pbData.bao() != null) {
                        cVar.threadId = pbData.bao().getId();
                    }
                    cVar.ftl = pbData.baB() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Nm() == null) {
            return null;
        }
        return tbRichTextData.Nm().NC();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Nm() == null) {
            return 0L;
        }
        return tbRichTextData.Nm().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Nm() == null) {
            return false;
        }
        return tbRichTextData.Nm().ND();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Nm() == null) {
            return false;
        }
        return tbRichTextData.Nm().NE();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Nm;
        String str;
        if (tbRichText == tbRichText2) {
            this.fsy = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.Ng().size();
            int i5 = -1;
            int i6 = 0;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.Ng().get(i6);
                int i7 = tbRichTextData.getType() == 20 ? i - 1 : i;
                if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ak = (int) com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.Nm().getWidth() * ak;
                    int height = ak * tbRichTextData.Nm().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Nm().Ny()) {
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
                            if (tbRichTextData != null && (Nm = tbRichTextData.Nm()) != null) {
                                String Nz = Nm.Nz();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = Nm.NA();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Nz;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fro.bdh(), -1L);
                                imageUrlData.mIsReserver = this.fro.bdv();
                                imageUrlData.mIsSeeHost = this.fro.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fsy) {
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
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bwG;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bwG = (bxi = postData.bxi()).bwG()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bwG.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bwG.get(i3);
                if (jVar != null) {
                    String bwK = jVar.bwK();
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(bwK)) {
                        arrayList.add(bwK);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bwK;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bwJ();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.fro.bdh(), -1L);
                        imageUrlData.mIsReserver = this.fro.bdv();
                        imageUrlData.mIsSeeHost = this.fro.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bxi.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bwK, imageUrlData);
                        }
                        if (!this.fsy) {
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
            if (postData.getId() != null && postData.getId().equals(this.fro.vv())) {
                z = true;
            }
            MarkData g = this.fro.g(postData);
            if (g != null) {
                this.frq.bfa();
                if (this.eSU != null) {
                    this.eSU.a(g);
                    if (!z) {
                        this.eSU.se();
                    } else {
                        this.eSU.sd();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aE(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fro == null || this.fro.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fro.getPbData();
        if (pbData.bav() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bav());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> baq = pbData.baq();
            a(pbData, baq);
            return a(baq, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.baz() != null && dVar.baz().fpy != null && (list = dVar.baz().fpy) != null && arrayList != null) {
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

    private long rk(String str) {
        ArrayList<PostData> baq;
        com.baidu.tieba.pb.data.d pbData = this.fro.getPbData();
        if (pbData != null && (baq = pbData.baq()) != null && !baq.isEmpty()) {
            Iterator<PostData> it = baq.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bxi = next.bxi();
                if (bxi != null && bxi.gID) {
                    Iterator<TbRichTextData> it2 = next.bxb().Ng().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.Nv().getLink().equals(str)) {
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
        ArrayList<TbRichTextData> Ng;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bxb = arrayList.get(i2).bxb();
            if (bxb != null && (Ng = bxb.Ng()) != null) {
                int size = Ng.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (Ng.get(i4) != null && Ng.get(i4).getType() == 8) {
                        i3++;
                        if (Ng.get(i4).Nm().Nz().equals(str) || Ng.get(i4).Nm().NA().equals(str)) {
                            int ak = (int) com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
                            int width = Ng.get(i4).Nm().getWidth() * ak;
                            int height = Ng.get(i4).Nm().getHeight() * ak;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fsx = i4;
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
            this.fqP = str;
            if (this.fra == null) {
                bbM();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fra.ck(1).setVisibility(8);
            } else {
                this.fra.ck(1).setVisibility(0);
            }
            this.fra.xd();
            this.frf = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dhB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcd() {
        hideNetRefreshView(this.frq.getView());
        bce();
        if (this.fro.JE()) {
            this.frq.bfa();
        }
    }

    private void bce() {
        showLoadingView(this.frq.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View IV = getLoadingView().IV();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) IV.getLayoutParams();
        layoutParams.addRule(3, this.frq.bfD().getId());
        IV.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atG() {
        if (this.dhB != null) {
            this.dhB.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq(int i) {
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
    public void qr(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fro.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fro.getPbData();
            pbData.bam().getName();
            String title = pbData.bao().getTitle();
            int i2 = this.fro.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.bam() != null) {
                if ((pbData.bam().isLike() == 1) && AddExperiencedModel.ti(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fro.bdh() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] bX = pbData.bX(getPageContext().getPageActivity());
                    str = bX[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = bX[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bbQ() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").ah(ImageViewerConfig.FORUM_ID, pbData.getForumId()).ah("tid", pbData.getThreadId()).ah("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aFa = true;
                    dVar.aFf = z;
                    dVar.extData = this.fro.bdh();
                    dVar.aFp = 3;
                    dVar.aFo = i;
                    dVar.fid = this.fro.getForumId();
                    dVar.tid = this.fro.bdh();
                    dVar.aFq = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.aFj = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fro.getPbData().bao());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aFp);
                    bundle.putInt("obj_type", dVar.aFq);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.f(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().baL()) {
                                PbActivity.this.frq.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.akV().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fro.bdh() + "?share=9105&fr=share&see_lz=" + i2;
            String[] bX2 = pbData.bX(getPageContext().getPageActivity());
            str = bX2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = bX2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bbQ() == 1) {
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aFa = true;
            dVar2.aFf = z;
            dVar2.extData = this.fro.bdh();
            dVar2.aFp = 3;
            dVar2.aFo = i;
            dVar2.fid = this.fro.getForumId();
            dVar2.tid = this.fro.bdh();
            dVar2.aFq = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fro.getPbData().bao());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aFp);
            bundle2.putInt("obj_type", dVar2.aFq);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.f(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fro != null && PbActivity.this.fro.getPbData() != null && PbActivity.this.fro.getPbData().baL()) {
                        PbActivity.this.frq.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.akV().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bao() != null) {
            if (dVar.bao().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bao().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcf() {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.v
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.tj(PbActivity.this.fro.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.frq.bfJ();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> NQ() {
        if (this.bex == null) {
            this.bex = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bcA */
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
        return this.bex;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.frq.beV() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").r("obj_locate", 2).ah(ImageViewerConfig.FORUM_ID, this.fro.getPbData().getForumId()));
            } else {
                bd bao = this.fro.getPbData().bao();
                if (view != null) {
                    boolean z = bao.va() == null || bao.va().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fsj > 1000) {
                            this.fsk = true;
                            bb(view);
                        } else {
                            this.fsk = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            m(view, this.fsk);
                        } else {
                            l(view, this.fsk);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        l(view, this.fsk);
                    } else if (motionEvent.getAction() == 3) {
                        l(view, this.fsk);
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
                    PbActivity.this.fsj = System.currentTimeMillis();
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
                    PbActivity.this.fsj = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bb(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), d.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void atH() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.k.login_to_use), true, 11017)));
        } else if (aVar.xc() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.xc();
            int intValue = ((Integer) sparseArray.get(as.fCj)).intValue();
            if (intValue == as.fCk) {
                if (!this.czq.bxN()) {
                    this.frq.beX();
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    this.czq.a(this.fro.getPbData().bam().getId(), this.fro.getPbData().bam().getName(), this.fro.getPbData().bao().getId(), (String) sparseArray.get(d.g.tag_del_post_id), intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == as.fCl || intValue == as.fCn) {
                if (this.fro.bdF() != null) {
                    this.fro.bdF().qv(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == as.fCl) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.frL);
        userMuteAddAndDelCustomMessage.setTag(this.frL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean rl(String str) {
        if (!StringUtils.isNull(str) && ba.aU(getPageContext().getPageActivity())) {
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

    public void jH(boolean z) {
        this.frz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bcg() {
        ArrayList<PostData> baq;
        int y;
        if (this.fro == null || this.fro.getPbData() == null || this.fro.getPbData().baq() == null || (y = com.baidu.tbadk.core.util.w.y((baq = this.fro.getPbData().baq()))) == 0) {
            return "";
        }
        if (this.fro.bdv()) {
            Iterator<PostData> it = baq.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bwZ() == 1) {
                    return next.getId();
                }
            }
        }
        int bfe = this.frq.bfe();
        PostData postData = (PostData) com.baidu.tbadk.core.util.w.c(baq, bfe);
        if (postData == null || postData.vm() == null) {
            return "";
        }
        if (this.fro.ro(postData.vm().getUserId())) {
            return postData.getId();
        }
        for (int i = bfe - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.c(baq, i);
            if (postData2 == null || postData2.vm() == null || postData2.vm().getUserId() == null) {
                break;
            } else if (this.fro.ro(postData2.vm().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bfe + 1; i2 < y; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.c(baq, i2);
            if (postData3 == null || postData3.vm() == null || postData3.vm().getUserId() == null) {
                return "";
            }
            if (this.fro.ro(postData3.vm().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ay.zG().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(rk(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fro.getPbData().bam().getId(), this.fro.getPbData().bam().getName(), this.fro.getPbData().bao().getTid());
            }
            this.frf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.dB(getResources().getString(d.k.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.dB(getResources().getString(d.k.make_sure_hide));
        }
        aVar.a(getResources().getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fro.bdE() != null) {
                    PbActivity.this.fro.bdE().cO(j);
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
        aVar.av(false);
        aVar.b(getPageContext());
        aVar.xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c rm(String str) {
        String str2;
        if (this.fro.getPbData() == null || this.fro.getPbData().baq() == null || this.fro.getPbData().baq().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fro.getPbData().baq().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fro.getPbData().baq().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fro.getPbData().baq().get(i);
        if (postData.bxb() == null || postData.bxb().Ng() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bxb().Ng().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Nm() != null) {
                    str2 = next.Nm().Nz();
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
        if (this.fqW) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fqW = false;
        } else if (bch()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fqW) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fqW = false;
        } else if (bch()) {
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
        if (pageStayDurationItem != null && this.fro != null) {
            if (this.fro.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.fro.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.fro.bdh(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean bch() {
        return (!this.fqU && this.fsF == -1 && this.fsG == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null) {
            this.fsI = nVar;
            this.fqU = true;
            this.frq.beO();
            this.frq.rv(this.fsH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bci() {
        if (this.fsI != null) {
            if (this.fsF == -1) {
                showToast(d.k.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fsI.getCartoonId(), this.fsF, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcj() {
        if (this.fsI != null) {
            if (this.fsG == -1) {
                showToast(d.k.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.aT(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fsI.getCartoonId(), this.fsG, 0)));
                finish();
            }
        }
    }

    public int bck() {
        return this.fsF;
    }

    public int bcl() {
        return this.fsG;
    }

    private void aDB() {
        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().bao() != null && this.fro.getPbData().bao().vX()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bcm() {
        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().bao() != null && this.fro.getPbData().bao().vX()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bcn() {
        if (this.fqX) {
            this.frk = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fro.getPbData() != null && this.fro.getPbData().bao() != null && this.fro.getPbData().bao().uV() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fro.getPbData().bao().uV().getThreadId(), this.fro.getPbData().bao().uV().getTaskId(), this.fro.getPbData().bao().uV().getForumId(), this.fro.getPbData().bao().uV().getForumName(), this.fro.getPbData().bao().vh(), this.fro.getPbData().bao().vi())));
            this.fqW = true;
            finish();
        }
    }

    public String bco() {
        return this.fri;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bcp() {
        return this.frn;
    }

    public void jI(boolean z) {
        this.frj = z;
    }

    public boolean bcq() {
        if (this.fro != null) {
            return this.fro.bdj();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.dB(getResources().getString(d.k.mute_is_super_member_function));
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.frJ).showToast(d.k.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.frJ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.frJ).xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (str == null) {
            str = "";
        }
        if (this.frJ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.frJ.getPageActivity());
            aVar.dB(str);
            aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.frJ).xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.frq.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.frJ.getPageActivity());
        if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            aVar.dB(this.frJ.getResources().getString(d.k.block_mute_message_alert, str3));
        } else {
            aVar.dB(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.frq.showLoadingDialog();
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
        aVar.b(this.frJ).xa();
    }

    public void bcs() {
        if (this.fro != null && this.fro.getPbData() != null && this.fro.getPbData().bao() != null && this.fro.getPbData().bao().wm() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cc(d.k.channel_open_push_message);
            aVar.a(d.k.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fro.getPbData().bao().wm().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.xa();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ax.rx(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.frq != null) {
            this.frq.onConfigurationChanged(configuration);
        }
        if (this.frx != null) {
            this.frx.dismiss();
        }
    }

    public boolean bct() {
        if (this.fro != null) {
            return this.fro.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, as asVar) {
        boolean z;
        List<PostData> list = this.fro.getPbData().baz().fpy;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bwW().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bwW().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bwW().remove(i2);
                    list.get(i).bwY();
                    z = true;
                    break;
                }
            }
            list.get(i).tN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            asVar.n(this.fro.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.baY().getId();
        List<PostData> list = this.fro.getPbData().baz().fpy;
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
                ArrayList<PostData> bbc = kVar.bbc();
                postData.ty(kVar.getTotalCount());
                if (postData.bwW() != null) {
                    postData.bwW().clear();
                    postData.bwW().addAll(bbc);
                }
            }
        }
        if (!this.fro.getIsFromMark()) {
            this.frq.n(this.fro.getPbData());
        }
    }

    public boolean bcu() {
        if (this.fro == null) {
            return false;
        }
        return this.fro.bcu();
    }

    public void bcv() {
        if (this.frq != null) {
            this.frq.beD();
            atH();
        }
    }

    public PostData bav() {
        return this.frq.b(this.fro.fwM, this.fro.bdi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ae(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.isLinkThread()) {
                return 3;
            }
            if (bdVar.wo()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.frT != null && !this.frT.isEmpty()) {
            int size = this.frT.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.frT.get(i).onBackPressed()) {
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
            if (this.frT == null) {
                this.frT = new ArrayList();
            }
            if (!this.frT.contains(aVar)) {
                this.frT.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.frT == null) {
                this.frT = new ArrayList();
            }
            if (!this.frT.contains(aVar)) {
                this.frT.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.frT != null) {
            this.frT.remove(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dio == null) {
            this.dio = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dio.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aC(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dio.a(contriInfo, -1L);
    }
}
