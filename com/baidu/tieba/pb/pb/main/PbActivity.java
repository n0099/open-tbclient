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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.s.az;
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
import com.baidu.tieba.frs.profession.permission.c;
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
/* loaded from: classes4.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<PbActivity> {
    private com.baidu.adp.lib.e.b<TbImageView> bTS;
    private com.baidu.adp.lib.e.b<ImageView> cAs;
    private com.baidu.adp.lib.e.b<GifView> cAt;
    private com.baidu.adp.lib.e.b<TextView> cDh;
    private com.baidu.adp.lib.e.b<View> cDi;
    private com.baidu.adp.lib.e.b<LinearLayout> cDj;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDk;
    private com.baidu.tieba.f.b dMr;
    private VoiceManager eYR;
    private com.baidu.tieba.frs.profession.permission.c fcv;
    private au fzR;
    public com.baidu.tbadk.core.util.aj gyK;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hmO;
    private View hmP;
    int hmR;
    private com.baidu.tieba.pb.pb.report.a hmU;
    private String hms;
    private com.baidu.tieba.pb.pb.main.b.b hmy;
    private List<a> hnA;
    public as hnb;
    private com.baidu.tbadk.core.dialog.g hnc;
    private com.baidu.tbadk.core.dialog.i hnd;
    private boolean hnf;
    private com.baidu.tieba.tbadkCore.data.f hnj;
    private com.baidu.tbadk.editortools.pb.f hnk;
    private com.baidu.tbadk.editortools.pb.d hnl;
    private com.baidu.tieba.frs.profession.permission.c hnn;
    private EmotionImageData hno;
    private com.baidu.adp.base.e hnr;
    private com.baidu.tbadk.core.view.e hns;
    private BdUniqueId hnt;
    private Runnable hnu;
    private com.baidu.adp.widget.ImageView.a hnv;
    private String hnw;
    private TbRichTextMemeInfo hnx;
    private boolean hoc;
    private String hon;
    private com.baidu.tbadk.core.data.o hoo;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLn));
        }
    };
    private static final b.a hoi = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // com.baidu.tieba.f.b.a
        public void it(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bIO();
            } else {
                com.baidu.tieba.pb.a.b.bIN();
            }
        }
    };
    private boolean hmx = false;
    private boolean hmz = false;
    private boolean hmA = false;
    private boolean gQe = false;
    private boolean hmB = true;
    private int hmC = 0;
    private com.baidu.tbadk.core.dialog.b hmD = null;
    private long eCL = -1;
    private long cqv = 0;
    private long hmE = 0;
    private long createTime = 0;
    private long cqn = 0;
    private boolean hmF = false;
    private com.baidu.tbadk.o.b hmG = null;
    private long hmH = 0;
    private boolean hmI = false;
    private long hmJ = 0;
    private String cki = null;
    private boolean hmK = false;
    private boolean isFullScreen = false;
    private String hmL = "";
    private boolean hmM = true;
    private boolean hmN = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hmQ = new int[2];
    private PbInterviewStatusView.a hmS = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.hmW.nN(!PbActivity.this.hmM);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hmT != null && PbActivity.this.hmT.Vb()) {
                        PbActivity.this.bJJ();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hmT = null;
    private com.baidu.tbadk.baseEditMark.a hmV = null;
    private ForumManageModel eiW = null;
    private com.baidu.tbadk.coreExtra.model.a bKy = null;
    private ShareSuccessReplyToServerModel foH = null;
    private aq hmW = null;
    public final com.baidu.tieba.pb.pb.main.b.a hmX = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hmY = false;
    private boolean hmZ = false;
    private boolean hna = false;
    private boolean hne = false;
    private boolean hng = false;
    private boolean hnh = false;
    private boolean hni = false;
    private boolean hnm = false;
    public boolean hnp = false;
    private com.baidu.tbadk.editortools.pb.c ckl = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void amr() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ckm = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amq() {
            if (PbActivity.this.hnb == null || PbActivity.this.hnb.bNz() == null || !PbActivity.this.hnb.bNz().coa()) {
                return !PbActivity.this.wd(com.baidu.tbadk.core.util.aj.bKt);
            }
            PbActivity.this.showToast(PbActivity.this.hnb.bNz().coc());
            if (PbActivity.this.hnl != null && (PbActivity.this.hnl.amF() || PbActivity.this.hnl.amG())) {
                PbActivity.this.hnl.a(false, PbActivity.this.hnb.bNC());
            }
            PbActivity.this.hnb.nZ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hnq = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amq() {
            if (PbActivity.this.hnb == null || PbActivity.this.hnb.bNA() == null || !PbActivity.this.hnb.bNA().coa()) {
                return !PbActivity.this.wd(com.baidu.tbadk.core.util.aj.bKu);
            }
            PbActivity.this.showToast(PbActivity.this.hnb.bNA().coc());
            if (PbActivity.this.hmW != null && PbActivity.this.hmW.bMo() != null && PbActivity.this.hmW.bMo().bKI() != null && PbActivity.this.hmW.bMo().bKI().amG()) {
                PbActivity.this.hmW.bMo().bKI().a(PbActivity.this.hnb.bNC());
            }
            PbActivity.this.hnb.oa(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean eZG = false;
    private int hny = 0;
    private int hnz = -1;
    private final a hnB = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hmW != null && PbActivity.this.hmW.bMo() != null) {
                s bMo = PbActivity.this.hmW.bMo();
                if (bMo.bKG()) {
                    bMo.bKF();
                    return true;
                }
            }
            if (PbActivity.this.hmW != null && PbActivity.this.hmW.bNh()) {
                PbActivity.this.hmW.bNi();
                return true;
            }
            return false;
        }
    };
    private r.a hnC = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
    };
    private AddExperiencedModel.a eZQ = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bJN();
        }
    };
    private final z.a hnD = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hmW.showToast(str);
            }
        }
    };
    private final CustomMessageListener hnE = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmT != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hnl != null) {
                    PbActivity.this.hmW.nS(PbActivity.this.hnl.amz());
                }
                PbActivity.this.hmW.bMp();
                PbActivity.this.hmW.bNa();
            }
        }
    };
    CustomMessageListener faj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hmT.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hmW != null && PbActivity.this.hmT != null) {
                    PbActivity.this.hmW.d(PbActivity.this.hmT.getPbData(), PbActivity.this.hmT.bKS(), PbActivity.this.hmT.getRequestType());
                }
                if (PbActivity.this.hmW != null && PbActivity.this.hmW.bMF() != null) {
                    PbActivity.this.hmW.bMF().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hnF = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hmW != null) {
                    if (booleanValue) {
                        PbActivity.this.hmW.buo();
                    } else {
                        PbActivity.this.hmW.bun();
                    }
                }
            }
        }
    };
    private CustomMessageListener hnG = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hnl != null) {
                    PbActivity.this.hmW.nS(PbActivity.this.hnl.amz());
                }
                PbActivity.this.hmW.nU(false);
            }
        }
    };
    private CustomMessageListener hnH = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener hnI = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmW != null && PbActivity.this.hmW.bMF() != null) {
                PbActivity.this.hmW.bMF().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gcF = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener brp = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hmA) {
                PbActivity.this.bKd();
            }
        }
    };
    private h.a hnJ = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void n(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.wf(2);
                aj.bMa().reset();
                PbActivity.this.hmT.bLn();
                boolean z2 = false;
                ArrayList<PostData> bIb = PbActivity.this.hmT.getPbData().bIb();
                if (bIb != null) {
                    Iterator<PostData> it = bIb.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.ceC().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hmW.o(PbActivity.this.hmT.getPbData());
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
    private View.OnClickListener ckW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.cki);
        }
    };
    private CustomMessageListener hnK = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmT.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hmT.bLe() != null && PbActivity.this.hmT.bLe().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hmW.a(aaVar.sendCount, PbActivity.this.hmT.getPbData(), PbActivity.this.hmT.bKS(), PbActivity.this.hmT.getRequestType());
                    }
                    if (pbData.bIb() != null && pbData.bIb().size() >= 1 && pbData.bIb().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bIb().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.hmT.bKR(), 0L);
                        if (d2 == aaVar.postId && d3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao ceB = pbData.bIb().get(0).ceB();
                            if (ceB == null) {
                                ceB = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> XM = ceB.XM();
                            if (XM == null) {
                                XM = new ArrayList<>();
                            }
                            XM.add(0, aVar);
                            ceB.setTotal(aaVar.sendCount + ceB.getTotal());
                            ceB.m(XM);
                            pbData.bIb().get(0).a(ceB);
                            PbActivity.this.hmW.bMF().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener frJ = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                PbActivity.this.zJ((String) customResponsedMessage.getData());
                PbActivity.this.hmT.bLk();
                if (PbActivity.this.hmW.bMF() != null) {
                    PbActivity.this.hmW.o(PbActivity.this.hmT.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hnL = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bNJ()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hnM = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ac(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.T(list) && PbActivity.this.hmW != null) {
                PbActivity.this.hmW.dD(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hnN = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cZ(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.jB().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18.1
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
    private boolean hnO = false;
    private PraiseModel hnP = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void rc(String str) {
            PbActivity.this.hnO = false;
            if (PbActivity.this.hnP != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmT.getPbData();
                if (pbData.bHZ().YD().getIsLike() == 1) {
                    PbActivity.this.qX(0);
                } else {
                    PbActivity.this.qX(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bHZ()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void af(int i, String str) {
            PbActivity.this.hnO = false;
            if (PbActivity.this.hnP != null && str != null) {
                if (AntiHelper.aB(i, str)) {
                    AntiHelper.aU(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hnQ = 0;
    private boolean hnR = true;
    private b.a hnS = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void no(boolean z) {
            PbActivity.this.nn(z);
            if (PbActivity.this.hmW.bNn() != null && z) {
                PbActivity.this.hmW.nN(false);
            }
            PbActivity.this.hmW.nP(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().bYz != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().bYz, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLn));
                        }
                    } else if (updateAttentionMessage.getData().Jy) {
                        if (PbActivity.this.bIg().YR() != null && PbActivity.this.bIg().YR().getGodUserData() != null) {
                            PbActivity.this.bIg().YR().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().YR() != null) {
                            PbActivity.this.hmT.getPbData().bHZ().YR().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a dLI = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hmW.aME();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.wg(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.bla();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c cbY = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            PbActivity.this.bJt();
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == d.g.richText) {
                    if (PbActivity.this.ck(view)) {
                        return true;
                    }
                } else if (view.getId() == d.g.pb_floor_item_layout) {
                    if (view.getTag(d.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(d.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != d.g.pb_post_header_layout) {
                    if (PbActivity.this.hmW != null && PbActivity.this.hmW.bJr() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").bJ(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.hmX != null && PbActivity.this.hmX.fAj != null) {
                            PbActivity.this.hmX.fAj.onClick(view);
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
            if (PbActivity.this.hnl != null) {
                PbActivity.this.hmW.nS(PbActivity.this.hnl.amz());
            }
            PbActivity.this.hmW.bMp();
            PbActivity.this.hmW.bNa();
            return true;
        }
    });
    private CustomMessageListener hnT = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnt) {
                PbActivity.this.hmW.aME();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmT.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bIm().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hns.i(PbActivity.this.hnr.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hnr.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.oW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bJZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hnr.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.hns.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hnU = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnt) {
                PbActivity.this.hmW.aME();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hns.i(PbActivity.this.hnr.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hnr.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.hns.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hnV = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnt) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hmW.aME();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.iUp;
                if (aVar.error == 0 && dataRes != null) {
                    int l = com.baidu.adp.lib.g.b.l(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = l == 1;
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
                    PbActivity.this.hmW.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hnW = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmW.bMq() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bJt();
            }
        }
    };
    private CustomMessageListener faq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.eZG = true;
                }
            }
        }
    };
    public a.b hbo = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bcN();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hmT.getPageData();
            int pageNum = PbActivity.this.hmW.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.XF()) {
                PbActivity.this.hmW.bNa();
                PbActivity.this.wf(2);
                PbActivity.this.bcM();
                PbActivity.this.hmW.bMJ();
                if (com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.hmT.wn(PbActivity.this.hmW.getPageNum());
                    if (PbActivity.this.hmy != null) {
                        PbActivity.this.hmy.showFloatingView();
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
    public final View.OnClickListener faY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Multi-variable search result rejected for r4v296, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v300, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v327, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v438, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:576:0x1b6e  */
        /* JADX WARN: Removed duplicated region for block: B:579:0x1bb4  */
        /* JADX WARN: Removed duplicated region for block: B:596:0x1d99  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.f fVar;
            boolean nj;
            com.baidu.tbadk.core.dialog.f fVar2;
            com.baidu.tbadk.core.dialog.f fVar3;
            long j;
            String str2;
            int i;
            int i2;
            int i3;
            bl blVar;
            String[] strArr;
            boolean u;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.hmW.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hmT.ny(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hmW.bMK();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLV()) {
                        if (view == PbActivity.this.hmW.hvN.csB) {
                            if (PbActivity.this.hmW.nR(PbActivity.this.hmT.bKX())) {
                                PbActivity.this.bcM();
                                return;
                            }
                            PbActivity.this.hmB = false;
                            PbActivity.this.hmz = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hmW.hvN.csB);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hmW.bMH() && (PbActivity.this.hmW.hvN.bNW() == null || (view != PbActivity.this.hmW.hvN.bNW().bLU() && view != PbActivity.this.hmW.hvN.bNW().bLS()))) {
                            if (view == PbActivity.this.hmW.bNd()) {
                                if (PbActivity.this.hmT != null) {
                                    com.baidu.tbadk.browser.a.ar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmT.getPbData().bHZ().YQ().getLink());
                                }
                            } else if (view != PbActivity.this.hmW.hvN.hAN) {
                                if (view == PbActivity.this.hmW.hvN.hAO) {
                                    if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                                        ArrayList<PostData> bIb = PbActivity.this.hmT.getPbData().bIb();
                                        if ((bIb == null || bIb.size() <= 0) && PbActivity.this.hmT.bKS()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").bJ("tid", PbActivity.this.hmT.bKR()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId()));
                                        if (!PbActivity.this.hmW.bNs()) {
                                            PbActivity.this.hmW.bMp();
                                        }
                                        PbActivity.this.bJB();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == d.g.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.kY()) {
                                        PbActivity.this.hmW.ns(true);
                                        PbActivity.this.hmW.bMp();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hmW.buo();
                                            PbActivity.this.bcM();
                                            PbActivity.this.hmW.bMJ();
                                            PbActivity.this.hmT.zQ(PbActivity.this.bJO());
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.wf(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_editor_tool_collection) {
                                    if ((PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLR()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                        if (PbActivity.this.hmW.hvN.bNW() != null && view == PbActivity.this.hmW.hvN.bNW().getCancelView()) {
                                            PbActivity.this.hmW.hvN.Qk();
                                        } else if (view.getId() != d.g.pb_editor_tool_share && view.getId() != d.g.share_num_container) {
                                            if (PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLP()) {
                                                if ((PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLX()) && view.getId() != d.g.pb_sort) {
                                                    if (PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLQ()) {
                                                        if (PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLY()) {
                                                            if (PbActivity.this.hmW.bNn() == view) {
                                                                if (PbActivity.this.hmW.bNn().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmT.getPbData();
                                                                    if (pbData != null && pbData.bHZ() != null && pbData.bHZ().Yx() != null) {
                                                                        String Yo = pbData.bHZ().Yx().Yo();
                                                                        if (StringUtils.isNull(Yo)) {
                                                                            Yo = pbData.bHZ().Yx().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").bJ(VideoPlayActivityConfig.OBJ_ID, Yo));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.dW("c10725", null);
                                                                }
                                                                PbActivity.this.bJV();
                                                            } else if (PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLW()) {
                                                                if (PbActivity.this.hmW.hvN.bNW() != null && view == PbActivity.this.hmW.hvN.bNW().bLT()) {
                                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hmW.c(PbActivity.this.hmT.getPbData(), PbActivity.this.hmT.bKS(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                PbActivity.this.hmW.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hmW.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hmW.hvN.Qk();
                                                                    } else {
                                                                        PbActivity.this.showToast(d.j.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.sub_pb_more || view.getId() == d.g.sub_pb_item || view.getId() == d.g.pb_floor_reply_more || view.getId() == d.g.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hmT != null && view.getId() == d.g.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar.bJ("tid", PbActivity.this.hmT.bKR());
                                                                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                                                                        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar.T("obj_locate", 4);
                                                                        TiebaStatic.log(amVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hmT.getPbData() != null) {
                                                                            PbActivity.this.hmW.bNa();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(d.g.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(d.g.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.ceF() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                }
                                                                                if (postData.iGW != null) {
                                                                                    com.baidu.tbadk.core.util.am adj = postData.iGW.adj();
                                                                                    adj.delete("obj_locate");
                                                                                    if (view.getId() == d.g.new_sub_pb_list_richText) {
                                                                                        adj.T("obj_locate", 6);
                                                                                    } else if (view.getId() == d.g.pb_floor_reply_more) {
                                                                                        adj.T("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(adj);
                                                                                }
                                                                                String bKR = PbActivity.this.hmT.bKR();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hmT.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hmT.getPbData().bIl();
                                                                                }
                                                                                PbActivity.this.bcM();
                                                                                if (view.getId() == d.g.replybtn) {
                                                                                    c zO = PbActivity.this.zO(id);
                                                                                    if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && zO != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKR, id, "pb", true, null, true, null, i4, postData.bOO(), PbActivity.this.hmT.getPbData().getAnti(), false, postData.YR().getIconInfo()).addBigImageData(zO.hoQ, zO.hoR, zO.hoS, zO.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hmT.bLz());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hmT.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c zO2 = PbActivity.this.zO(id);
                                                                                    if (postData != null && PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && zO2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKR, id, "pb", true, null, false, null, i4, postData.bOO(), PbActivity.this.hmT.getPbData().getAnti(), false, postData.YR().getIconInfo()).addBigImageData(zO2.hoQ, zO2.hoR, zO2.hoS, zO2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hmT.bLz());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hmT.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.pb_post_reply_count) {
                                                                    if (PbActivity.this.hmT != null) {
                                                                        com.baidu.tbadk.core.util.am amVar2 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar2.bJ("tid", PbActivity.this.hmT.bKR());
                                                                        amVar2.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                                                                        amVar2.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar2.T("obj_locate", 5);
                                                                        TiebaStatic.log(amVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                                                                                    String bKR2 = PbActivity.this.hmT.bKR();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hmT.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hmT.getPbData().bIl();
                                                                                    }
                                                                                    c zO3 = PbActivity.this.zO(id2);
                                                                                    if (zO3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKR2, id2, "pb", true, null, false, null, i5, postData2.bOO(), PbActivity.this.hmT.getPbData().getAnti(), false, postData2.YR().getIconInfo()).addBigImageData(zO3.hoQ, zO3.hoR, zO3.hoS, zO3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hmT.bLz());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hmT.getFromForumId());
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
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.pb_post_reply) {
                                                                    if (PbActivity.this.hmT != null) {
                                                                        com.baidu.tbadk.core.util.am amVar3 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar3.bJ("tid", PbActivity.this.hmT.bKR());
                                                                        amVar3.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                                                                        amVar3.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar3.T("obj_locate", 6);
                                                                        TiebaStatic.log(amVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.bJq().bMn() != null && postData3.YR() != null && postData3.cet() != 1) {
                                                                                    if (PbActivity.this.bJq().bMo() != null) {
                                                                                        PbActivity.this.bJq().bMo().bKE();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                                                                    jVar.a(PbActivity.this.hmT.getPbData().getForum());
                                                                                    jVar.aj(PbActivity.this.hmT.getPbData().bHZ());
                                                                                    jVar.e(postData3);
                                                                                    PbActivity.this.bJq().bMn().d(jVar);
                                                                                    PbActivity.this.bJq().bMn().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.YR().getUserId(), "");
                                                                                    if (PbActivity.this.hnl != null) {
                                                                                        PbActivity.this.hmW.nS(PbActivity.this.hnl.amz());
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
                                                                } else if (view != PbActivity.this.hmW.bJl()) {
                                                                    if (view == PbActivity.this.hmW.hvN.bNX()) {
                                                                        PbActivity.this.hmW.bMQ();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == d.g.pb_u9_text_view) {
                                                                            if (PbActivity.this.checkUpIsLogin() && (blVar = (bl) view.getTag()) != null && !StringUtils.isNull(blVar.aaP())) {
                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.adD().c(PbActivity.this.getPageContext(), new String[]{blVar.aaP()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.replybtn || id3 == d.g.cover_reply_content || id3 == d.g.replybtn_top_right || id3 == d.g.cover_reply_content_top_right || id3 == d.g.image_more_tip) {
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(d.g.tag_load_sub_data);
                                                                                    if (id3 == d.g.replybtn_top_right || id3 == d.g.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").bJ("tid", PbActivity.this.hmT.hrT));
                                                                                    }
                                                                                    if (PbActivity.this.hnd == null) {
                                                                                        PbActivity.this.hnd = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                                                                                        PbActivity.this.hnd.a(PbActivity.this.hoh);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cm(view);
                                                                                    if (!PbActivity.this.cm(view) || PbActivity.this.hnv == null || !PbActivity.this.hnv.isGif()) {
                                                                                    }
                                                                                    boolean z3 = false;
                                                                                    boolean z4 = false;
                                                                                    boolean z5 = false;
                                                                                    boolean z6 = false;
                                                                                    boolean z7 = false;
                                                                                    if (!(sparseArray4.get(d.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                        z = false;
                                                                                    } else {
                                                                                        z = ((Boolean) sparseArray4.get(d.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(d.g.tag_is_subpb) instanceof Boolean) {
                                                                                        ((Boolean) sparseArray4.get(d.g.tag_is_subpb)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(d.g.tag_del_post_is_self) instanceof Boolean) {
                                                                                        z3 = ((Boolean) sparseArray4.get(d.g.tag_del_post_is_self)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(d.g.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z4 = ((Boolean) sparseArray4.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(d.g.tag_should_manage_visible) instanceof Boolean) {
                                                                                        z5 = ((Boolean) sparseArray4.get(d.g.tag_should_manage_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(d.g.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z6 = ((Boolean) sparseArray4.get(d.g.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(d.g.tag_should_delete_visible) instanceof Boolean) {
                                                                                        z7 = ((Boolean) sparseArray4.get(d.g.tag_should_delete_visible)).booleanValue();
                                                                                    }
                                                                                    if (!(sparseArray4.get(d.g.tag_forbid_user_post_id) instanceof String)) {
                                                                                        str = null;
                                                                                    } else {
                                                                                        str = (String) sparseArray4.get(d.g.tag_forbid_user_post_id);
                                                                                    }
                                                                                    if (z) {
                                                                                        if (!(sparseArray4.get(d.g.tag_chudian_template_id) instanceof Long)) {
                                                                                            j = 0;
                                                                                        } else {
                                                                                            j = ((Long) sparseArray4.get(d.g.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (!(sparseArray4.get(d.g.tag_chudian_monitor_id) instanceof String)) {
                                                                                            str2 = "";
                                                                                        } else {
                                                                                            str2 = (String) sparseArray4.get(d.g.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (!(sparseArray4.get(d.g.tag_chudian_hide_day) instanceof Integer)) {
                                                                                            i = 0;
                                                                                        } else {
                                                                                            i = ((Integer) sparseArray4.get(d.g.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hnd);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(fVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cev() != null && postData4.cev().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hnd);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(d.g.tag_clip_board, postData4);
                                                                                            fVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(fVar5);
                                                                                        }
                                                                                        PbActivity.this.fPQ = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hmT.getPbData().Vb()) {
                                                                                        String Va = PbActivity.this.hmT.getPbData().Va();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(Va) && Va.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hnd);
                                                                                            } else {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hnd);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(d.g.tag_clip_board, PbActivity.this.fPQ);
                                                                                            sparseArray6.put(d.g.tag_is_subpb, false);
                                                                                            fVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(fVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hnd);
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(d.g.tag_user_mute_visible, true);
                                                                                                    sparseArray7.put(d.g.tag_is_mem, sparseArray4.get(d.g.tag_is_mem));
                                                                                                    sparseArray7.put(d.g.tag_user_mute_mute_userid, sparseArray4.get(d.g.tag_user_mute_mute_userid));
                                                                                                    sparseArray7.put(d.g.tag_user_mute_mute_username, sparseArray4.get(d.g.tag_user_mute_mute_username));
                                                                                                    sparseArray7.put(d.g.tag_user_mute_mute_nameshow, sparseArray4.get(d.g.tag_user_mute_mute_nameshow));
                                                                                                    sparseArray7.put(d.g.tag_user_mute_post_id, sparseArray4.get(d.g.tag_user_mute_post_id));
                                                                                                    sparseArray7.put(d.g.tag_user_mute_thread_id, sparseArray4.get(d.g.tag_user_mute_thread_id));
                                                                                                    sparseArray7.put(d.g.tag_del_post_is_self, sparseArray4.get(d.g.tag_del_post_is_self));
                                                                                                    sparseArray7.put(d.g.tag_del_post_type, sparseArray4.get(d.g.tag_del_post_type));
                                                                                                    sparseArray7.put(d.g.tag_del_post_id, sparseArray4.get(d.g.tag_del_post_id));
                                                                                                    sparseArray7.put(d.g.tag_manage_user_identity, sparseArray4.get(d.g.tag_manage_user_identity));
                                                                                                    fVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(fVar6);
                                                                                                } else {
                                                                                                    if (!ap.m(PbActivity.this.fPQ)) {
                                                                                                        nj = PbActivity.this.nj(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        nj = false;
                                                                                                    }
                                                                                                    if (nj) {
                                                                                                        com.baidu.tbadk.core.dialog.f fVar7 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnd);
                                                                                                        fVar7.mTextView.setTag(str);
                                                                                                        arrayList.add(fVar7);
                                                                                                    }
                                                                                                }
                                                                                                if (z5) {
                                                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                                                    sparseArray8.put(d.g.tag_should_manage_visible, true);
                                                                                                    sparseArray8.put(d.g.tag_manage_user_identity, sparseArray4.get(d.g.tag_manage_user_identity));
                                                                                                    sparseArray8.put(d.g.tag_forbid_user_name, sparseArray4.get(d.g.tag_forbid_user_name));
                                                                                                    sparseArray8.put(d.g.tag_forbid_user_name_show, sparseArray4.get(d.g.tag_forbid_user_name_show));
                                                                                                    sparseArray8.put(d.g.tag_forbid_user_portrait, sparseArray4.get(d.g.tag_forbid_user_portrait));
                                                                                                    sparseArray8.put(d.g.tag_forbid_user_post_id, str);
                                                                                                    if (z6) {
                                                                                                        sparseArray8.put(d.g.tag_user_mute_visible, true);
                                                                                                        sparseArray8.put(d.g.tag_is_mem, sparseArray4.get(d.g.tag_is_mem));
                                                                                                        sparseArray8.put(d.g.tag_user_mute_mute_userid, sparseArray4.get(d.g.tag_user_mute_mute_userid));
                                                                                                        sparseArray8.put(d.g.tag_user_mute_mute_username, sparseArray4.get(d.g.tag_user_mute_mute_username));
                                                                                                        sparseArray8.put(d.g.tag_user_mute_mute_nameshow, sparseArray4.get(d.g.tag_user_mute_mute_nameshow));
                                                                                                        sparseArray8.put(d.g.tag_user_mute_post_id, sparseArray4.get(d.g.tag_user_mute_post_id));
                                                                                                        sparseArray8.put(d.g.tag_user_mute_thread_id, sparseArray4.get(d.g.tag_user_mute_thread_id));
                                                                                                    } else {
                                                                                                        sparseArray8.put(d.g.tag_user_mute_visible, false);
                                                                                                    }
                                                                                                    if (z7) {
                                                                                                        sparseArray8.put(d.g.tag_should_delete_visible, true);
                                                                                                        sparseArray8.put(d.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                        sparseArray8.put(d.g.tag_del_post_id, sparseArray4.get(d.g.tag_del_post_id));
                                                                                                        sparseArray8.put(d.g.tag_del_post_type, sparseArray4.get(d.g.tag_del_post_type));
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnd);
                                                                                                        fVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(d.g.tag_should_delete_visible, false);
                                                                                                        fVar2 = null;
                                                                                                    }
                                                                                                    fVar3 = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hnd);
                                                                                                    fVar3.mTextView.setTag(sparseArray8);
                                                                                                } else if (!z7) {
                                                                                                    fVar2 = null;
                                                                                                    fVar3 = null;
                                                                                                } else {
                                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                                    sparseArray9.put(d.g.tag_should_manage_visible, false);
                                                                                                    sparseArray9.put(d.g.tag_user_mute_visible, false);
                                                                                                    sparseArray9.put(d.g.tag_should_delete_visible, true);
                                                                                                    sparseArray9.put(d.g.tag_manage_user_identity, sparseArray4.get(d.g.tag_manage_user_identity));
                                                                                                    sparseArray9.put(d.g.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                    sparseArray9.put(d.g.tag_del_post_id, sparseArray4.get(d.g.tag_del_post_id));
                                                                                                    sparseArray9.put(d.g.tag_del_post_type, sparseArray4.get(d.g.tag_del_post_type));
                                                                                                    if (PbActivity.this.hmT.getPbData().bIl() == 1002 && !z3) {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnd);
                                                                                                    } else {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnd);
                                                                                                    }
                                                                                                    fVar2.mTextView.setTag(sparseArray9);
                                                                                                    fVar3 = null;
                                                                                                }
                                                                                                if (fVar2 != null) {
                                                                                                    arrayList.add(fVar2);
                                                                                                }
                                                                                                if (fVar3 != null) {
                                                                                                    arrayList.add(fVar3);
                                                                                                }
                                                                                            }
                                                                                            PbActivity.this.hnd.P(arrayList);
                                                                                            PbActivity.this.hnc = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hnd.abk());
                                                                                            PbActivity.this.hnc.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(d.g.tag_clip_board, PbActivity.this.fPQ);
                                                                                    sparseArray62.put(d.g.tag_is_subpb, false);
                                                                                    fVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(fVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hnd.P(arrayList);
                                                                                    PbActivity.this.hnc = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hnd.abk());
                                                                                    PbActivity.this.hnc.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_act_btn) {
                                                                            if (PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), PbActivity.this.hmT.getPbData().bHZ().getActUrl());
                                                                                if (PbActivity.this.hmT.getPbData().bHZ().ZB() != 1) {
                                                                                    if (PbActivity.this.hmT.getPbData().bHZ().ZB() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.lottery_tail) {
                                                                            if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()).bJ("tid", PbActivity.this.hmT.getPbData().getThreadId()).bJ("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hmT.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hmW.setSelection(0);
                                                                                } else {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.pb_item_tail_content) {
                                                                            if (bc.cZ(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(d.j.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbActivity.this.hmW.bMp();
                                                                            }
                                                                        } else if (id3 == d.g.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bJy() == 1 && PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()).bJ("tid", PbActivity.this.hmT.getPbData().getThreadId()).bJ("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bJy() == 1 && PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()).bJ("tid", PbActivity.this.hmT.getPbData().getThreadId()).bJ("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.manga_prev_btn) {
                                                                            PbActivity.this.bJQ();
                                                                        } else if (id3 == d.g.manga_next_btn) {
                                                                            PbActivity.this.bJR();
                                                                        } else if (id3 == d.g.yule_head_img_img) {
                                                                            if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bIs() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hmT.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").bJ(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                ba.adD().c(PbActivity.this.getPageContext(), new String[]{pbData2.bIs().bIz()});
                                                                            }
                                                                        } else if (id3 == d.g.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bIs() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hmT.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                ba.adD().c(PbActivity.this.getPageContext(), new String[]{pbData3.bIs().bIz()});
                                                                            }
                                                                        } else if (PbActivity.this.hmW.hvN.bNW() != null && view == PbActivity.this.hmW.hvN.bNW().bLZ()) {
                                                                            if (PbActivity.this.hmT == null || PbActivity.this.hmT.getPbData() == null || PbActivity.this.hmT.getPbData().bHZ() == null) {
                                                                                PbActivity.this.hmW.hvN.Qk();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.lo()) {
                                                                                PbActivity.this.showToast(d.j.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hmT.getPbData().bHZ().Yy() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmT.bKR(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).abh();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").T("obj_locate", PbActivity.this.ax(PbActivity.this.hmT.getPbData().bHZ())).bJ("tid", PbActivity.this.hmT.getPbData().bHZ().getTid()).T("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == d.g.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hny >= 0) {
                                                                                if (PbActivity.this.hmT != null) {
                                                                                    PbActivity.this.hmT.bLA();
                                                                                }
                                                                                if (PbActivity.this.hmW.bMF() != null) {
                                                                                    PbActivity.this.hmW.bMF().a(PbActivity.this.hmT.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hmW.getListView().setSelection(PbActivity.this.hmT.bLD());
                                                                                PbActivity.this.hny = 0;
                                                                                if (PbActivity.this.hmT != null) {
                                                                                    PbActivity.this.hmT.bU(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == d.g.thread_info_commont_container) {
                                                                            PbActivity.this.bJv();
                                                                        } else if (id3 == d.g.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbActivity.this.d(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_editor_tool_comment_icon) {
                                                                            if (PbActivity.this.hmW.getListView() != null && PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hmW.getListView().getFirstVisiblePosition();
                                                                                int top = PbActivity.this.hmW.getListView().getChildAt(0).getTop();
                                                                                boolean bIx = PbActivity.this.hmT.getPbData().bIx();
                                                                                boolean z8 = PbActivity.this.hmW.hvH != null && PbActivity.this.hmW.hvH.bPe();
                                                                                boolean bMX = PbActivity.this.hmW.bMX();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bIx && PbActivity.this.hmW.hvH != null && PbActivity.this.hmW.hvH.aBC() != null) {
                                                                                    int aO = ((int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d)) - PbActivity.this.hmW.hvH.bPf();
                                                                                    z9 = firstVisiblePosition == 0 && (top == aO || top == PbActivity.this.hmW.hvH.aBC().getHeight() - PbActivity.this.hmW.hvH.bPf());
                                                                                    i7 = aO;
                                                                                }
                                                                                if ((PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().YI() <= 0) || (bMX && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bJv();
                                                                                        if (PbActivity.this.hmT.getPbData().bHZ().YR() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmT.hrT).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hmT.getPbData().bHZ().YR().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int aQ = (int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d);
                                                                                    if (bIx) {
                                                                                        if (PbActivity.this.hmW.hxw != null && PbActivity.this.hmW.hxw.hyF != null && PbActivity.this.hmW.hxw.hyF.getView() != null) {
                                                                                            if (PbActivity.this.hmW.hxw.hyF.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bJE();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hmW.hvH.aBC() != null) {
                                                                                                    i8 = PbActivity.this.hmW.hvH.aBC().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hmW.hxw.hyF.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hmW.bMx() != null) {
                                                                                        z10 = PbActivity.this.hmW.bMx().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hmW.hxw != null && PbActivity.this.hmW.hxw.hyF != null && PbActivity.this.hmW.hxw.hyF.getView() != null && PbActivity.this.hmW.hxw.hyF.getView().getParent() != null && PbActivity.this.hmW.hvN != null && PbActivity.this.hmW.hvN.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hmW.hxw.hyF.getView().getTop() - PbActivity.this.hmW.hvN.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bMX) {
                                                                                        int bJE = PbActivity.this.bJE();
                                                                                        if (PbActivity.this.bJD() != -1) {
                                                                                            bJE--;
                                                                                        }
                                                                                        int h = com.baidu.adp.lib.util.l.h(PbActivity.this, d.e.tbds116);
                                                                                        if (bJE < 0) {
                                                                                            i2 = PbActivity.this.hmW.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.S(PbActivity.this.hmW.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bJE;
                                                                                            i3 = h;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bIx || PbActivity.this.hmW.hvH.aBC() == null) {
                                                                                            if (PbActivity.this.hmW.hvN != null && PbActivity.this.hmW.hvN.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hmW.hvN.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hmW.hvH.aBC().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hmW.hxw == null || PbActivity.this.hmW.hxw.hyF == null || PbActivity.this.hmW.hxw.hyF.getView() == null || PbActivity.this.hmW.hxw.hyF.getView().getParent() == null) {
                                                                                            PbActivity.this.hmW.getListView().setSelectionFromTop(i2, i3 + aQ);
                                                                                            PbActivity.this.hmW.getListView().smoothScrollBy(aQ, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hmW.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hmW.getListView().smoothScrollBy(PbActivity.this.hmW.hxw.hyF.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-aQ))) {
                                                                                        PbActivity.this.hmW.getListView().setSelectionFromTop(0, i7 - aQ);
                                                                                        PbActivity.this.hmW.getListView().smoothScrollBy(-aQ, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hmW.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().YR() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmT.hrT).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hmT.getPbData().bHZ().YR().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_nav_title_forum_image || id3 == d.g.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(PbActivity.this.hmT.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hmT.bLz() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hmT.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar4 = new com.baidu.tbadk.core.util.am("c13401");
                                                                                amVar4.bJ("tid", PbActivity.this.hmT.bKR());
                                                                                amVar4.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                                                                                amVar4.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hmT.bLz() == 3 && PbActivity.this.bIQ() && PbActivity.this.hmT.getPbData() != null && com.baidu.tbadk.core.util.v.T(PbActivity.this.hmT.getPbData().bIu())) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(bgVar.YW(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar5 = new com.baidu.tbadk.core.util.am("c13399");
                                                                                amVar5.bJ("tid", bgVar.getId());
                                                                                amVar5.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
                                                                                amVar5.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbActivity.this.hmT != null) {
                                                                                com.baidu.tbadk.core.util.am amVar6 = new com.baidu.tbadk.core.util.am("c13398");
                                                                                amVar6.bJ("tid", PbActivity.this.hmT.bKR());
                                                                                amVar6.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                                                                                amVar6.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                amVar6.T("obj_locate", 2);
                                                                                TiebaStatic.log(amVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.hmT.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.hmT.bKR(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hmT.getPbData().bHZ().Zl())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.kY()) {
                                                                PbActivity.this.hmW.bNa();
                                                                SparseArray<Object> c3 = PbActivity.this.hmW.c(PbActivity.this.hmT.getPbData(), PbActivity.this.hmT.bKS(), 1);
                                                                if (c3 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmT.getPbData().getForum().getId(), PbActivity.this.hmT.getPbData().getForum().getName(), PbActivity.this.hmT.getPbData().bHZ().getId(), String.valueOf(PbActivity.this.hmT.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_name_show), (String) c3.get(d.g.tag_forbid_user_post_id), (String) c3.get(d.g.tag_forbid_user_portrait))));
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(d.j.network_not_available);
                                                                return;
                                                            }
                                                        } else {
                                                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                            UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                            if (skinType == 1) {
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                TbadkCoreApplication.getInst().setSkinType(0);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").T("obj_type", 0).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                            } else if (skinType == 0) {
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").T("obj_type", 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                            }
                                                            PbActivity.this.hmW.hvN.bNV();
                                                        }
                                                    } else if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bHZ() != null) {
                                                        PbActivity.this.hmW.hvN.Qk();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                        PbActivity.this.zL(PbActivity.this.hmT.getPbData().bHZ().Zh());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hmW.bNa();
                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hmT.bLi()));
                                                            return;
                                                        }
                                                        PbActivity.this.wf(2);
                                                        PbActivity.this.bcM();
                                                        PbActivity.this.hmW.bMJ();
                                                        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hmT.getPbData().hkv == null || PbActivity.this.hmT.getPbData().hkv.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(d.j.sort_type_new), PbActivity.this.getResources().getString(d.j.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hmT.getPbData().hkv.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hmT.getPbData().hkv.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hmT.getPbData().hkv.get(i10).sort_name + PbActivity.this.getResources().getString(d.j.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        gVar.a(null, strArr, new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                                            @Override // com.baidu.tbadk.core.dialog.i.c
                                                            public void a(com.baidu.tbadk.core.dialog.i iVar, int i11, View view3) {
                                                                int i12 = 2;
                                                                gVar.dismiss();
                                                                if (PbActivity.this.hmT.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hmT.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hmT.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hmT.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != d.g.pb_sort ? 1 : 0).T("obj_type", i12));
                                                                if (PbActivity.this.hmT.getPbData().hkv != null && PbActivity.this.hmT.getPbData().hkv.size() > i11) {
                                                                    i11 = PbActivity.this.hmT.getPbData().hkv.get(i11).sort_type.intValue();
                                                                }
                                                                boolean ws = PbActivity.this.hmT.ws(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hmT.bLi()));
                                                                if (ws) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hmW.nJ(true);
                                                                }
                                                            }
                                                        });
                                                        gVar.showDialog();
                                                    } else {
                                                        PbActivity.this.showToast(d.j.network_not_available);
                                                        return;
                                                    }
                                                }
                                            } else {
                                                PbActivity.this.hmW.bNa();
                                                if (PbActivity.this.bJa().getPbData().hkw != 2) {
                                                    if (PbActivity.this.hmT.getPageData() != null) {
                                                        PbActivity.this.hmW.a(PbActivity.this.hmT.getPageData(), PbActivity.this.hbo);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(d.j.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (az.jK() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().YR() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmT.hrT).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()).T("obj_locate", 4).bJ("uid", PbActivity.this.hmT.getPbData().bHZ().YR().getUserId()));
                                            }
                                            if (PbActivity.this.hmT != null) {
                                                com.baidu.tbadk.core.util.am amVar7 = new com.baidu.tbadk.core.util.am("c12386");
                                                amVar7.bJ("tid", PbActivity.this.hmT.bKR());
                                                amVar7.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                amVar7.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                                                amVar7.T("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    amVar7.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(amVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.lo()) {
                                                if (PbActivity.this.hmT.getPbData() != null) {
                                                    ArrayList<PostData> bIb2 = PbActivity.this.hmT.getPbData().bIb();
                                                    if ((bIb2 != null && bIb2.size() > 0) || !PbActivity.this.hmT.bKS()) {
                                                        PbActivity.this.hmW.bNa();
                                                        PbActivity.this.bcM();
                                                        PbActivity.this.wf(2);
                                                        if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bIs() != null && !StringUtils.isNull(PbActivity.this.hmT.getPbData().bIs().Xn(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                        if (az.jK()) {
                                                            PbActivity.this.wg(2);
                                                        } else {
                                                            PbActivity.this.hmW.showLoadingDialog();
                                                            PbActivity.this.hmT.bLu().m(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                    } else if (com.baidu.adp.lib.util.j.kY()) {
                                        PbActivity.this.hmW.bNa();
                                        if (PbActivity.this.hmW.hvN.bNW() != null && view == PbActivity.this.hmW.hvN.bNW().bLR() && !PbActivity.this.hmW.bNs()) {
                                            PbActivity.this.hmW.bMp();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bcM();
                                            PbActivity.this.hmW.bMJ();
                                            if (view.getId() == d.g.floor_owner_reply) {
                                                u = PbActivity.this.hmT.u(true, PbActivity.this.bJO());
                                            } else {
                                                u = view.getId() == d.g.reply_title ? PbActivity.this.hmT.u(false, PbActivity.this.bJO()) : PbActivity.this.hmT.zQ(PbActivity.this.bJO());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hmW.ns(true);
                                                PbActivity.this.hmW.buo();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hmW.nJ(true);
                                            }
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.wf(2);
                                        } else {
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        view.setTag(Boolean.FALSE);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.kY()) {
                                    PbActivity.this.hmW.bNa();
                                    if (PbActivity.this.we(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.hmT.wt(PbActivity.this.hmW.bMO()) != null) {
                                        PbActivity.this.bJI();
                                        if (PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().YR() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmT.hrT).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId()).T("obj_locate", 3).bJ("uid", PbActivity.this.hmT.getPbData().bHZ().YR().getUserId()));
                                        }
                                        if (PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().YR() != null && PbActivity.this.hmT.getPbData().bHZ().YR().getUserId() != null && PbActivity.this.hmV != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hmT.hrT).T("obj_locate", 1).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hmT.getPbData().bHZ().YR().getUserId()).T("obj_type", PbActivity.this.hmV.Vb() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hmT.getPbData())));
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(d.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().ZL() && PbActivity.this.hmT.getPbData().bHZ().Zi() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.hmT.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hmT.bIR()) && PbActivity.this.hmT.getAppealInfo() != null) {
                                        name = PbActivity.this.hmT.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hmT.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bIR = PbActivity.this.hmT.bIR();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hmT.bKT() && bIR != null && bIR.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.kY()) {
                            if (PbActivity.this.hmT.getPbData() != null) {
                                if ((PbActivity.this.hmT.getPbData().bIl() == 1 || PbActivity.this.hmT.getPbData().bIl() == 3) && !PbActivity.this.eiW.cff()) {
                                    PbActivity.this.hmW.bNa();
                                    int i11 = 0;
                                    if (PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLS()) {
                                        if (PbActivity.this.hmW.hvN.bNW() == null || view != PbActivity.this.hmW.hvN.bNW().bLU()) {
                                            if (view == PbActivity.this.hmW.bMH()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hmT.getPbData().bHZ().YN() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hmT.getPbData().bHZ().YM() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hmT.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hmT.getPbData().bHZ().getId();
                                    PbActivity.this.hmW.bMG();
                                    PbActivity.this.eiW.a(id4, name2, id5, i11, PbActivity.this.hmW.bMI());
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(d.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.kY()) {
                        PbActivity.this.hmW.bNa();
                        PbActivity.this.bcM();
                        PbActivity.this.hmW.bMJ();
                        PbActivity.this.hmW.showLoadingDialog();
                        if (PbActivity.this.hmW.bMx() != null) {
                            PbActivity.this.hmW.bMx().setVisibility(8);
                        }
                        PbActivity.this.hmT.wn(1);
                        if (PbActivity.this.hmy != null) {
                            PbActivity.this.hmy.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bJw = PbActivity.this.bJw();
                        if (!TextUtils.isEmpty(bJw)) {
                            ba.adD().c(PbActivity.this.getPageContext(), new String[]{bJw});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hmT != null) {
                    com.baidu.tbadk.core.util.am amVar8 = new com.baidu.tbadk.core.util.am("c13398");
                    amVar8.bJ("tid", PbActivity.this.hmT.bKR());
                    amVar8.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                    amVar8.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar8.T("obj_locate", 1);
                    TiebaStatic.log(amVar8);
                }
                if (PbActivity.this.hmI) {
                    PbActivity.this.hmI = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.bJq().bMn() != null && postData5.YR() != null && postData5.cet() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bJq().bMo() != null) {
                                PbActivity.this.bJq().bMo().bKE();
                            }
                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                            jVar2.a(PbActivity.this.hmT.getPbData().getForum());
                            jVar2.aj(PbActivity.this.hmT.getPbData().bHZ());
                            jVar2.e(postData5);
                            PbActivity.this.bJq().bMn().d(jVar2);
                            PbActivity.this.bJq().bMn().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.YR().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hmT.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hnl != null) {
                                PbActivity.this.hmW.nS(PbActivity.this.hnl.amz());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId());
                }
                if (PbActivity.this.hmT != null) {
                    amVar.bJ("tid", PbActivity.this.hmT.bKR());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.bcM();
            PbActivity.this.hmW.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.s.ap.apG() && PbActivity.this.bJa() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bJa().zT(postWriteCallBackData.getPostId());
                    PbActivity.this.hny = PbActivity.this.hmW.bMt();
                    if (PbActivity.this.hmT != null) {
                        PbActivity.this.hmT.bU(PbActivity.this.hny, PbActivity.this.hmW.bMu());
                    }
                }
                PbActivity.this.hmW.bNa();
                PbActivity.this.hnb.bNy();
                if (PbActivity.this.hnl != null) {
                    PbActivity.this.hmW.nS(PbActivity.this.hnl.amz());
                }
                PbActivity.this.hmW.bMm();
                PbActivity.this.hmW.nU(true);
                PbActivity.this.hmT.bLk();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hmT.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmT.getPbData();
                            if (pbData != null && pbData.bHZ() != null && pbData.bHZ().YR() != null && (userId = pbData.bHZ().YR().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.s.ap.apG() && PbActivity.this.hmT.bLb()) {
                                PbActivity.this.hmW.bMJ();
                            }
                        } else if (!com.baidu.tbadk.s.ap.apG() && PbActivity.this.hmT.bLb()) {
                            PbActivity.this.hmW.bMJ();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hmW.o(PbActivity.this.hmT.getPbData());
                    }
                    if (PbActivity.this.hmT.bKW()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").bJ("tid", PbActivity.this.hmT.bKR()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hnl.amF() || PbActivity.this.hnl.amG()) {
                    PbActivity.this.hnl.a(false, postWriteCallBackData);
                }
                PbActivity.this.hnb.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gyK != null) {
                    PbActivity.this.gyK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hnX = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getPbData().getForumId());
                }
                if (PbActivity.this.hmT != null) {
                    amVar.bJ("tid", PbActivity.this.hmT.bKR());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (PbActivity.this.hnb != null) {
                    PbActivity.this.hnb.bNx();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gyK != null) {
                    PbActivity.this.gyK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hnb != null) {
                if (PbActivity.this.hmW != null && PbActivity.this.hmW.bMo() != null && PbActivity.this.hmW.bMo().bKI() != null && PbActivity.this.hmW.bMo().bKI().amG()) {
                    PbActivity.this.hmW.bMo().bKI().a(postWriteCallBackData);
                }
                PbActivity.this.hnb.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a hnY = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g jt;
            if (!z || dVar == null || dVar.bIj() != null || com.baidu.tbadk.core.util.v.S(dVar.bIb()) >= 1) {
                PbActivity.this.gQe = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hmW.bML();
                if (dVar == null || !dVar.bIf()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hmW.getView());
                }
                PbActivity.this.hmW.bun();
                if (PbActivity.this.isFullScreen || PbActivity.this.hmW.bNs()) {
                    PbActivity.this.hmW.bNj();
                } else if (!PbActivity.this.hmW.bNg()) {
                    PbActivity.this.hmW.nU(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hne = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hmW.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hmW.aOA();
                    if (dVar.bHZ() != null && dVar.bHZ().ZU() != null) {
                        PbActivity.this.a(dVar.bHZ().ZU());
                    }
                    PbActivity.this.bJn();
                    if (PbActivity.this.hnl != null) {
                        PbActivity.this.hmW.nS(PbActivity.this.hnl.amz());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bIb() != null && dVar.bIb().size() >= 1 && dVar.bIb().get(0) != null) {
                        PbActivity.this.hmT.zS(dVar.bIb().get(0).getId());
                    } else if (dVar.bIj() != null) {
                        PbActivity.this.hmT.zS(dVar.bIj().getId());
                    }
                    if (PbActivity.this.hnl != null) {
                        PbActivity.this.hnl.a(dVar.getAnti());
                        PbActivity.this.hnl.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hnl.a(PbActivity.this.hmT.bLe(), PbActivity.this.hmT.bKR(), PbActivity.this.hmT.bLw());
                        if (dVar.bHZ() != null) {
                            PbActivity.this.hnl.eO(dVar.bHZ().aaj());
                        }
                    }
                    if (PbActivity.this.hmV != null) {
                        PbActivity.this.hmV.cZ(dVar.Vb());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hmW.nT(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hmW.a(dVar, i2, i3, PbActivity.this.hmT.bKS(), i4, PbActivity.this.hmT.getIsFromMark());
                    PbActivity.this.hmW.e(dVar, PbActivity.this.hmT.bKS());
                    PbActivity.this.hmW.nQ(PbActivity.this.hmT.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.cki = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.cki) && PbActivity.this.hnl != null && PbActivity.this.hnl.alS() != null && (jt = PbActivity.this.hnl.alS().jt(6)) != null && !TextUtils.isEmpty(PbActivity.this.cki)) {
                            ((View) jt).setOnClickListener(PbActivity.this.ckW);
                        }
                    }
                    if (PbActivity.this.hng) {
                        PbActivity.this.hng = false;
                        final int bJD = PbActivity.this.bJD();
                        if (!dVar.bIx()) {
                            PbActivity.this.hmW.wz(bJD);
                        } else {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bJD, aO);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hnh) {
                        PbActivity.this.hnh = false;
                        final int bJD2 = PbActivity.this.bJD();
                        final boolean z2 = bJD2 != -1;
                        if (!z2) {
                            bJD2 = PbActivity.this.bJE();
                        }
                        if (PbActivity.this.hmW != null) {
                            if (!dVar.bIx()) {
                                PbActivity.this.hmW.wz(bJD2);
                            } else {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bJD2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hmW.setSelectionFromTop(bJD2, aO2);
                                            } else {
                                                PbActivity.this.hmW.setSelectionFromTop(bJD2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hmW.nV(true);
                            }
                        }
                    } else if (PbActivity.this.hni) {
                        PbActivity.this.hni = false;
                        PbActivity.this.hmW.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hmW.bMP();
                    }
                    PbActivity.this.hmT.a(dVar.getForum(), PbActivity.this.hnL);
                    PbActivity.this.hmT.a(PbActivity.this.hnM);
                    if (PbActivity.this.gyK != null && dVar.bHZ() != null && dVar.bHZ().YR() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bHZ().YR());
                        PbActivity.this.gyK.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hne && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hmT != null && PbActivity.this.hmT.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hmT.getAppealInfo().hjP)) {
                                    PbActivity.this.hmW.a(PbActivity.this.hmT.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hmW.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hmW.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                            }
                            PbActivity.this.hmW.bNj();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hmT.bKR());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                        kVar.setOpType("2");
                        kVar.start();
                    }
                    if (i == -1) {
                        PbActivity.this.hmW.zW("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                            arrayList = PbActivity.this.hmT.getPbData().bIb();
                        }
                        if (com.baidu.tbadk.core.util.v.S(arrayList) != 0 && (com.baidu.tbadk.core.util.v.S(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cet() != 1)) {
                            PbActivity.this.hmW.zW(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                        } else if (PbActivity.this.bKb()) {
                            PbActivity.this.hmW.zX(PbActivity.this.getResources().getString(d.j.pb_no_host_reply));
                        } else {
                            PbActivity.this.hmW.zX(PbActivity.this.getResources().getString(d.j.pb_no_replay));
                        }
                    }
                    PbActivity.this.hmW.aeD();
                }
                PbActivity.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bJa().bKS() || PbActivity.this.bJa().getPbData().getPage().XL() != 0 || PbActivity.this.bJa().bLq()) {
                    PbActivity.this.hnm = true;
                    return;
                }
                return;
            }
            PbActivity.this.hmT.wn(1);
            if (PbActivity.this.hmy != null) {
                PbActivity.this.hmy.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hmW.o(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.o.m.apk().apl()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eCL : j;
                com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(i, z, responsedMessage, PbActivity.this.cqn, PbActivity.this.createTime, PbActivity.this.cqv, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cqn = 0L;
                if (iVar != null) {
                    iVar.apg();
                }
                if (z2) {
                    iVar.cqE = currentTimeMillis;
                    iVar.fe(true);
                }
                if (!z2 && PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bHZ() != null) {
                    int threadType = PbActivity.this.hmT.getPbData().bHZ().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmL, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmL, "from_frs")) {
                                com.baidu.tbadk.o.i iVar2 = new com.baidu.tbadk.o.i();
                                iVar2.jX(1000);
                                iVar2.cqG = currentTimeMillis;
                                iVar2.jY(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.o.d dVar = new com.baidu.tbadk.o.d();
                        dVar.pageType = 1;
                        dVar.jX(1005);
                        dVar.cqG = currentTimeMillis;
                        dVar.jY(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hnZ = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bJz();
            }
        }
    };
    private final a.InterfaceC0221a hoa = new a.InterfaceC0221a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hmW.bML();
            if (z) {
                if (PbActivity.this.hmV != null) {
                    PbActivity.this.hmV.cZ(z2);
                }
                PbActivity.this.hmT.nA(z2);
                if (PbActivity.this.hmT.Vb()) {
                    PbActivity.this.bJJ();
                } else {
                    PbActivity.this.hmW.o(PbActivity.this.hmT.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hmV != null && PbActivity.this.hmV.Ve() != null && PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().YR() != null) {
                        MarkData Ve = PbActivity.this.hmV.Ve();
                        MetaData YR = PbActivity.this.hmT.getPbData().bHZ().YR();
                        if (Ve != null && YR != null) {
                            if (!com.baidu.tbadk.core.util.ap.equals(TbadkCoreApplication.getCurrentAccount(), YR.getUserId()) && !YR.hadConcerned()) {
                                PbActivity.this.b(YR);
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
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.wb(PbActivity.this.mLastScrollState) && PbActivity.this.wb(i)) {
                if (PbActivity.this.hmW != null) {
                    PbActivity.this.hmW.bNa();
                    if (PbActivity.this.hnl != null && !PbActivity.this.hmW.bMq()) {
                        PbActivity.this.hmW.nS(PbActivity.this.hnl.amz());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hmW.bMp();
                    }
                }
                if (!PbActivity.this.hmF) {
                    PbActivity.this.hmF = true;
                    PbActivity.this.hmW.bNf();
                }
            }
            PbActivity.this.hmW.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hmy != null) {
                PbActivity.this.hmy.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hmG == null) {
                PbActivity.this.hmG = new com.baidu.tbadk.o.b();
                PbActivity.this.hmG.jX(1001);
            }
            if (i == 0) {
                PbActivity.this.hmG.apa();
            } else {
                PbActivity.this.hmG.aoZ();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.cdt().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bIb;
            if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmW != null && PbActivity.this.hmW.bMF() != null) {
                PbActivity.this.hmW.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hmy != null) {
                    PbActivity.this.hmy.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hmT.bLm() && (bIb = PbActivity.this.hmT.getPbData().bIb()) != null && !bIb.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hmW.bMF().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmT.getPbData();
                    if (pbData != null) {
                        if (pbData.bIc() != null && pbData.bIc().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bId() != null && pbData.bId().hasData()) {
                            headerCount--;
                        }
                        int size = bIb.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eja = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eiW.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hmT.bLk();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCH != 1002 || bVar.fDf) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hmW.a(1, dVar.Id, dVar.iIC, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eiW.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hmW.a(PbActivity.this.eiW.getLoadDataMode(), gVar.Id, gVar.iIC, false);
                        PbActivity.this.hmW.at(gVar.iIF);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hmW.a(PbActivity.this.eiW.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hob = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final h.c cPu = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (PbActivity.this.bJP()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hmT.nz(true)) {
                PbActivity.this.hmW.bMM();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fsR = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hoc && PbActivity.this.bJP()) {
                PbActivity.this.bJR();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hmT.ny(false)) {
                    PbActivity.this.hmW.bMK();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hmT.getPbData() != null) {
                    PbActivity.this.hmW.bNe();
                }
                PbActivity.this.hoc = true;
            }
        }
    };
    private int hod = 0;
    private final TbRichTextView.h cAB = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bMF;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hmT != null) {
                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                        amVar.bJ("tid", PbActivity.this.hmT.bKR());
                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId());
                        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        amVar.T("obj_locate", 3);
                        amVar.T("obj_type", z2 ? 1 : 2);
                        TiebaStatic.log(amVar);
                    }
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(d.g.tag_rich_text_meme_info) != null && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                        boolean isGif = ((TbImageView) view).isGif();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                        }
                        PbActivity.this.hmP = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hoT) {
                        TbRichText bh = PbActivity.this.bh(str, i);
                        if (bh != null && PbActivity.this.hod >= 0 && PbActivity.this.hod < bh.asw().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bh.asw().get(PbActivity.this.hod));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hoQ.size()) {
                                    break;
                                } else if (!cVar.hoQ.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bh.getPostId() != 0 && (bMF = PbActivity.this.hmW.bMF()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bMF.getDataList();
                                if (com.baidu.tbadk.core.util.v.S(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bh.getPostId() == com.baidu.adp.lib.g.b.d(((PostData) next).getId(), 0L)) {
                                            if (bh.getPostId() != com.baidu.adp.lib.g.b.d(PbActivity.this.hmT.bLw(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hmT.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.T(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hoR.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoS, cVar.lastId, PbActivity.this.hmT.bLh(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.m(rect);
                            createConfig.setIsHotSort(PbActivity.this.hmT.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hoQ, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.T(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hoR.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoS, cVar.hoQ.get(0), PbActivity.this.hmT.bLh(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hmT.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hmW.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hoe = false;
    PostData fPQ = null;
    private final b.InterfaceC0225b hof = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.fPQ != null) {
                if (i == 0) {
                    PbActivity.this.fPQ.eu(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fPQ = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fPQ);
                }
            }
        }
    };
    private final b.InterfaceC0225b hog = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hnv != null && !TextUtils.isEmpty(PbActivity.this.hnw)) {
                if (i == 0) {
                    if (PbActivity.this.hnx == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnw));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hnw;
                        aVar.pkgId = PbActivity.this.hnx.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnx.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.adQ();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.Y(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fzR == null) {
                            PbActivity.this.fzR = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fzR.h(PbActivity.this.hnw, PbActivity.this.hnv.oB());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hnv = null;
                PbActivity.this.hnw = null;
            }
        }
    };
    private final View.OnLongClickListener cdd = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        /* JADX WARN: Removed duplicated region for block: B:27:0x0096 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01e2  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            String str;
            boolean nj;
            com.baidu.tbadk.core.dialog.f fVar;
            com.baidu.tbadk.core.dialog.f fVar2;
            int i;
            SparseArray sparseArray;
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (PbActivity.this.cm(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.hnv = ((TbImageView) view).getBdImage();
                        PbActivity.this.hnw = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hnv == null || TextUtils.isEmpty(PbActivity.this.hnw)) {
                            return true;
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnx = null;
                        } else {
                            PbActivity.this.hnx = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hnv = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hnw = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hnx = null;
                            } else {
                                PbActivity.this.hnx = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hnv = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hnw = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnx = null;
                        } else {
                            PbActivity.this.hnx = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        PbActivity.this.hmW.a(PbActivity.this.hog, PbActivity.this.hnv.isGif());
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
            PbActivity.this.fPQ = (PostData) sparseArray2.get(d.g.tag_clip_board);
            if (PbActivity.this.fPQ == null) {
                return true;
            }
            if (PbActivity.this.fPQ.cet() != 1 || !PbActivity.this.cm(view)) {
                if (PbActivity.this.hmV != null) {
                    if (!PbActivity.this.hmV.Vb() || PbActivity.this.fPQ.getId() == null || !PbActivity.this.fPQ.getId().equals(PbActivity.this.hmT.Za())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.fPQ.cet() == 1) {
                        PbActivity.this.hmW.a(PbActivity.this.hof, z, false);
                        return true;
                    }
                    if (PbActivity.this.hnd == null) {
                        PbActivity.this.hnd = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                        PbActivity.this.hnd.a(PbActivity.this.hoh);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cm = PbActivity.this.cm(view);
                        boolean z3 = (!PbActivity.this.cm(view) || PbActivity.this.hnv == null || PbActivity.this.hnv.isGif()) ? false : true;
                        boolean z4 = false;
                        boolean z5 = false;
                        boolean z6 = false;
                        boolean z7 = false;
                        boolean z8 = false;
                        boolean z9 = false;
                        if (sparseArray2.get(d.g.tag_should_hide_chudian_visible) instanceof Boolean) {
                            z2 = ((Boolean) sparseArray2.get(d.g.tag_should_hide_chudian_visible)).booleanValue();
                        }
                        if (sparseArray2.get(d.g.tag_is_subpb) instanceof Boolean) {
                            z4 = ((Boolean) sparseArray2.get(d.g.tag_is_subpb)).booleanValue();
                        }
                        if (sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean) {
                            z5 = ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue();
                        }
                        if (sparseArray2.get(d.g.tag_user_mute_visible) instanceof Boolean) {
                            z6 = ((Boolean) sparseArray2.get(d.g.tag_user_mute_visible)).booleanValue();
                        }
                        if (sparseArray2.get(d.g.tag_should_manage_visible) instanceof Boolean) {
                            z7 = ((Boolean) sparseArray2.get(d.g.tag_should_manage_visible)).booleanValue();
                        }
                        if (sparseArray2.get(d.g.tag_user_mute_visible) instanceof Boolean) {
                            z8 = ((Boolean) sparseArray2.get(d.g.tag_user_mute_visible)).booleanValue();
                        }
                        if (sparseArray2.get(d.g.tag_should_delete_visible) instanceof Boolean) {
                            z9 = ((Boolean) sparseArray2.get(d.g.tag_should_delete_visible)).booleanValue();
                        }
                        if (!(sparseArray2.get(d.g.tag_forbid_user_post_id) instanceof String)) {
                            str = null;
                        } else {
                            str = (String) sparseArray2.get(d.g.tag_forbid_user_post_id);
                        }
                        if (z2) {
                            long j = 0;
                            String str2 = "";
                            if (sparseArray2.get(d.g.tag_chudian_template_id) instanceof Long) {
                                j = ((Long) sparseArray2.get(d.g.tag_chudian_template_id)).longValue();
                            }
                            if (sparseArray2.get(d.g.tag_chudian_monitor_id) instanceof String) {
                                str2 = (String) sparseArray2.get(d.g.tag_chudian_monitor_id);
                            }
                            if (!(sparseArray2.get(d.g.tag_chudian_hide_day) instanceof Integer)) {
                                i = 0;
                            } else {
                                i = ((Integer) sparseArray2.get(d.g.tag_chudian_hide_day)).intValue();
                            }
                            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hnd);
                            fVar3.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                            fVar3.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                            fVar3.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(fVar3);
                        }
                        if (cm) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, PbActivity.this.getString(d.j.save_to_emotion), PbActivity.this.hnd));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(2, PbActivity.this.getString(d.j.save_to_local), PbActivity.this.hnd));
                        }
                        if (!cm && !z3) {
                            com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hnd);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(d.g.tag_clip_board, PbActivity.this.fPQ);
                            fVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(fVar4);
                        }
                        if (!z4) {
                            if (z) {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hnd);
                            } else {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hnd);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(d.g.tag_clip_board, PbActivity.this.fPQ);
                            sparseArray4.put(d.g.tag_is_subpb, false);
                            fVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(fVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hnd);
                                SparseArray sparseArray5 = new SparseArray();
                                sparseArray5.put(d.g.tag_user_mute_visible, true);
                                sparseArray5.put(d.g.tag_is_mem, sparseArray2.get(d.g.tag_is_mem));
                                sparseArray5.put(d.g.tag_user_mute_mute_userid, sparseArray2.get(d.g.tag_user_mute_mute_userid));
                                sparseArray5.put(d.g.tag_user_mute_mute_username, sparseArray2.get(d.g.tag_user_mute_mute_username));
                                sparseArray5.put(d.g.tag_user_mute_mute_nameshow, sparseArray2.get(d.g.tag_user_mute_mute_nameshow));
                                sparseArray5.put(d.g.tag_user_mute_post_id, sparseArray2.get(d.g.tag_user_mute_post_id));
                                sparseArray5.put(d.g.tag_user_mute_thread_id, sparseArray2.get(d.g.tag_user_mute_thread_id));
                                sparseArray5.put(d.g.tag_del_post_is_self, sparseArray2.get(d.g.tag_del_post_is_self));
                                sparseArray5.put(d.g.tag_del_post_type, sparseArray2.get(d.g.tag_del_post_type));
                                sparseArray5.put(d.g.tag_del_post_id, sparseArray2.get(d.g.tag_del_post_id));
                                sparseArray5.put(d.g.tag_manage_user_identity, sparseArray2.get(d.g.tag_manage_user_identity));
                                fVar5.mTextView.setTag(sparseArray5);
                                arrayList.add(fVar5);
                            } else {
                                if (!ap.m(PbActivity.this.fPQ)) {
                                    nj = PbActivity.this.nj(z5) & PbActivity.this.isLogin();
                                } else {
                                    nj = false;
                                }
                                if (nj) {
                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnd);
                                    fVar6.mTextView.setTag(str);
                                    arrayList.add(fVar6);
                                }
                            }
                            com.baidu.tbadk.core.dialog.f fVar7 = null;
                            if (z7) {
                                SparseArray sparseArray6 = new SparseArray();
                                sparseArray6.put(d.g.tag_should_manage_visible, true);
                                sparseArray6.put(d.g.tag_manage_user_identity, sparseArray2.get(d.g.tag_manage_user_identity));
                                sparseArray6.put(d.g.tag_forbid_user_name, sparseArray2.get(d.g.tag_forbid_user_name));
                                sparseArray6.put(d.g.tag_forbid_user_name_show, sparseArray2.get(d.g.tag_forbid_user_name_show));
                                sparseArray6.put(d.g.tag_forbid_user_portrait, sparseArray2.get(d.g.tag_forbid_user_portrait));
                                sparseArray6.put(d.g.tag_forbid_user_post_id, str);
                                if (z8) {
                                    sparseArray6.put(d.g.tag_user_mute_visible, true);
                                    sparseArray6.put(d.g.tag_is_mem, sparseArray2.get(d.g.tag_is_mem));
                                    sparseArray6.put(d.g.tag_user_mute_mute_userid, sparseArray2.get(d.g.tag_user_mute_mute_userid));
                                    sparseArray6.put(d.g.tag_user_mute_mute_username, sparseArray2.get(d.g.tag_user_mute_mute_username));
                                    sparseArray6.put(d.g.tag_user_mute_mute_nameshow, sparseArray2.get(d.g.tag_user_mute_mute_nameshow));
                                    sparseArray6.put(d.g.tag_user_mute_post_id, sparseArray2.get(d.g.tag_user_mute_post_id));
                                    sparseArray6.put(d.g.tag_user_mute_thread_id, sparseArray2.get(d.g.tag_user_mute_thread_id));
                                } else {
                                    sparseArray6.put(d.g.tag_user_mute_visible, false);
                                }
                                if (z9) {
                                    sparseArray6.put(d.g.tag_should_delete_visible, true);
                                    sparseArray6.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray6.put(d.g.tag_del_post_id, sparseArray2.get(d.g.tag_del_post_id));
                                    sparseArray6.put(d.g.tag_del_post_type, sparseArray2.get(d.g.tag_del_post_type));
                                    fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnd);
                                    fVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(d.g.tag_should_delete_visible, false);
                                }
                                fVar = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hnd);
                                fVar.mTextView.setTag(sparseArray6);
                            } else {
                                if (z9) {
                                    SparseArray sparseArray7 = new SparseArray();
                                    sparseArray7.put(d.g.tag_should_manage_visible, false);
                                    sparseArray7.put(d.g.tag_user_mute_visible, false);
                                    sparseArray7.put(d.g.tag_should_delete_visible, true);
                                    sparseArray7.put(d.g.tag_manage_user_identity, sparseArray2.get(d.g.tag_manage_user_identity));
                                    sparseArray7.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray7.put(d.g.tag_del_post_id, sparseArray2.get(d.g.tag_del_post_id));
                                    sparseArray7.put(d.g.tag_del_post_type, sparseArray2.get(d.g.tag_del_post_type));
                                    if (PbActivity.this.hmT.getPbData().bIl() == 1002 && !z5) {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnd);
                                    } else {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnd);
                                    }
                                    fVar7.mTextView.setTag(sparseArray7);
                                }
                                fVar = null;
                            }
                            if (fVar7 != null) {
                                arrayList.add(fVar7);
                            }
                            if (fVar != null) {
                                arrayList.add(fVar);
                            }
                        }
                        PbActivity.this.hnd.P(arrayList);
                        PbActivity.this.hnc = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hnd.abk());
                        PbActivity.this.hnc.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").bJ("tid", PbActivity.this.hmT.hrT).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId()).bJ("uid", PbActivity.this.hmT.getPbData().bHZ().YR().getUserId()).bJ("post_id", PbActivity.this.hmT.amo()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hmW.a(PbActivity.this.hog, PbActivity.this.hnv.isGif());
            return true;
        }
    };
    private i.c hoh = new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.i.c
        public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
            if (PbActivity.this.hnc != null) {
                PbActivity.this.hnc.dismiss();
            }
            switch (i) {
                case 0:
                    long j = -1;
                    String str = "";
                    int i2 = 0;
                    if (view.getTag(d.g.tag_chudian_template_id) instanceof Long) {
                        j = ((Long) view.getTag(d.g.tag_chudian_template_id)).longValue();
                    }
                    if (view.getTag(d.g.tag_chudian_monitor_id) instanceof String) {
                        str = (String) view.getTag(d.g.tag_chudian_monitor_id);
                    }
                    if (view.getTag(d.g.tag_chudian_hide_day) instanceof Integer) {
                        i2 = ((Integer) view.getTag(d.g.tag_chudian_hide_day)).intValue();
                    }
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmT.getPbData();
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    if (pbData != null && pbData.getForum() != null) {
                        str2 = pbData.getForum().getId();
                        str3 = pbData.getForum().getName();
                        str4 = pbData.getThreadId();
                    }
                    com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                    PbActivity.this.a(j, str, str2, str3, str4, i2);
                    return;
                case 1:
                    if (PbActivity.this.hnv != null && !TextUtils.isEmpty(PbActivity.this.hnw)) {
                        if (PbActivity.this.hnx == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnw));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hnw;
                            aVar.pkgId = PbActivity.this.hnx.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnx.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hnv = null;
                        PbActivity.this.hnw = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hnv != null && !TextUtils.isEmpty(PbActivity.this.hnw)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.adQ();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.Y(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fzR == null) {
                                PbActivity.this.fzR = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fzR.h(PbActivity.this.hnw, PbActivity.this.hnv.oB());
                            PbActivity.this.hnv = null;
                            PbActivity.this.hnw = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.fPQ != null) {
                        PbActivity.this.fPQ.eu(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.fPQ = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").T("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.cl(view);
                        if (PbActivity.this.hmT.getPbData().bHZ() != null && PbActivity.this.hmT.getPbData().bHZ().YR() != null && PbActivity.this.hmT.getPbData().bHZ().YR().getUserId() != null && PbActivity.this.hmV != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hmT.hrT).T("obj_locate", 2).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hmT.getPbData().bHZ().YR().getUserId()).T("obj_type", PbActivity.this.hmV.Vb() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hmT.getPbData())));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!com.baidu.adp.lib.util.j.kY()) {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13079"));
                        PbActivity.this.zL((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").T("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(d.g.tag_from, 0);
                            sparseArray.put(d.g.tag_check_mute_from, 2);
                            PbActivity.this.c(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(d.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_id) instanceof String) && (sparseArray2.get(d.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(d.g.tag_del_post_is_self) instanceof Boolean)) {
                        PbActivity.this.hmW.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.kY()) {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(d.g.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray3.get(d.g.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray3.get(d.g.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray3.put(d.g.tag_from, 1);
                                sparseArray3.put(d.g.tag_check_mute_from, 2);
                                PbActivity.this.c(sparseArray3);
                                return;
                            }
                            sparseArray3.put(d.g.tag_check_mute_from, 2);
                            PbActivity.this.hmW.cs(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hmW.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a eWD = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (!PbActivity.this.hmA && z && !PbActivity.this.hmT.bKY()) {
                PbActivity.this.bJL();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
        }
    };
    public View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.dMr.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0284a dMs = new a.InterfaceC0284a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        final int dWk;

        {
            this.dWk = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            if (av(i2) && PbActivity.this.hmW != null && PbActivity.this.hmy != null) {
                PbActivity.this.hmW.bNk();
                PbActivity.this.hmy.jr(false);
                PbActivity.this.hmy.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aS(int i, int i2) {
            if (av(i2) && PbActivity.this.hmW != null && PbActivity.this.hmy != null) {
                PbActivity.this.hmy.jr(true);
                if (Math.abs(i2) > this.dWk) {
                    PbActivity.this.hmy.hideFloatingView();
                }
                if (PbActivity.this.bJP()) {
                    PbActivity.this.hmW.bMC();
                    PbActivity.this.hmW.bMD();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aT(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String hoj = null;
    private final m.a hok = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void k(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hoj = str2;
                PbActivity.this.hmW.zY(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hol = -1;
    private int hom = -1;
    private CustomMessageListener hop = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bvV == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0223a) {
                    if (aVar.bvW != null && !aVar.bvW.hasError() && aVar.bvW.getError() == 0) {
                        if (PbActivity.this.hmW != null) {
                            PbActivity.this.hmW.s(((a.C0223a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bKa();
                        }
                    } else if (z) {
                        if (aVar.bvW != null && aVar.bvW.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bvW.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bvW != null && !aVar.bvW.hasError() && aVar.bvW.getError() == 0) {
                        if (PbActivity.this.hmW != null && PbActivity.this.hmW != null) {
                            PbActivity.this.hmW.s(((a.C0223a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bvW != null && aVar.bvW.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bvW.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bvW == null || aVar.bvW.hasError() || aVar.bvW.getError() != 0) {
                        if (z) {
                            if (aVar.bvW != null && aVar.bvW.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bvW.getErrorString());
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

    /* loaded from: classes4.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void m(Object obj);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public ArrayList<String> hoQ;
        public ConcurrentHashMap<String, ImageUrlData> hoR;
        public boolean hoT;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hoS = false;
        public boolean hoU = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes4.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d bJm() {
        return this.hnl;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bID() != null) {
            String id = jVar.bID().getId();
            ArrayList<PostData> bIb = this.hmT.getPbData().bIb();
            int i = 0;
            while (true) {
                if (i >= bIb.size()) {
                    break;
                }
                PostData postData = bIb.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bIH = jVar.bIH();
                    postData.zt(jVar.getTotalCount());
                    if (postData.ceq() != null && bIH != null) {
                        Iterator<PostData> it = bIH.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.YR() != null && (metaData = postData.getUserMap().get(next.YR().getUserId())) != null) {
                                next.a(metaData);
                                next.pY(true);
                                next.a(getPageContext(), this.hmT.zR(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bIH.size() != postData.ceq().size();
                        postData.ceq().clear();
                        postData.ceq().addAll(bIH);
                        z = z2;
                    }
                    if (postData.cem() != null) {
                        postData.cen();
                    }
                }
            }
            if (!this.hmT.getIsFromMark() && z) {
                this.hmW.o(this.hmT.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bIo = this.hmT.getPbData().bIo();
            if (bIo != null && str.equals(bIo.getAdId())) {
                if (bIo.ceh() != null) {
                    bIo.ceh().legoCard = null;
                }
                this.hmT.getPbData().bIp();
            }
            com.baidu.tieba.tbadkCore.data.m bLc = this.hmT.bLc();
            if (bLc != null && str.equals(bLc.getAdId())) {
                this.hmT.bLd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer)) {
            if (this.hnc != null && this.hnc.isShowing()) {
                this.hnc.dismiss();
                this.hnc = null;
            }
            final String str = (String) sparseArray.get(d.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this);
                iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                    @Override // com.baidu.tbadk.core.dialog.i.c
                    public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                        if (PbActivity.this.hnc != null) {
                            PbActivity.this.hnc.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hmW.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.hnt);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hnt);
                            PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(d.g.tag_user_mute_mute_nameshow));
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int i = -1;
                if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.f(0, getResources().getString(d.j.delete), iVar));
                }
                if (z) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.f(1, getResources().getString(d.j.un_mute), iVar));
                } else {
                    arrayList.add(new com.baidu.tbadk.core.dialog.f(1, getResources().getString(d.j.mute), iVar));
                }
                iVar.P(arrayList);
                this.hnc = new com.baidu.tbadk.core.dialog.g(getPageContext(), iVar.abk());
                this.hnc.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        bg bHZ;
        if (this.hmT != null && this.hmT.getPbData() != null && (bHZ = this.hmT.getPbData().bHZ()) != null) {
            if (i == 1) {
                PraiseData YD = bHZ.YD();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (YD == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bHZ.a(praiseData);
                    } else {
                        bHZ.YD().getUser().add(0, metaData);
                        bHZ.YD().setNum(bHZ.YD().getNum() + 1);
                        bHZ.YD().setIsLike(i);
                    }
                }
                if (bHZ.YD() != null) {
                    if (bHZ.YD().getNum() < 1) {
                        getResources().getString(d.j.zan);
                    } else {
                        com.baidu.tbadk.core.util.ap.ax(bHZ.YD().getNum());
                    }
                }
            } else if (bHZ.YD() != null) {
                bHZ.YD().setIsLike(i);
                bHZ.YD().setNum(bHZ.YD().getNum() - 1);
                ArrayList<MetaData> user = bHZ.YD().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bHZ.YD().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bHZ.YD().getNum() < 1) {
                    getResources().getString(d.j.zan);
                } else {
                    String str = bHZ.YD().getNum() + "";
                }
            }
            if (this.hmT.bKS()) {
                this.hmW.bMF().notifyDataSetChanged();
            } else {
                this.hmW.p(this.hmT.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hmT.aa(bundle);
        if (this.eYR != null) {
            this.eYR.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hnl.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hmE = System.currentTimeMillis();
        this.hnr = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eCL = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hmL = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hmL) && intent.getData() != null) {
                this.hmL = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hmL)) {
                this.hmz = true;
            }
            this.hol = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hom = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hon = intent.getStringExtra("key_manga_title");
            this.hng = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hnh = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hni = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bJP()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.hnz = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eCL = System.currentTimeMillis();
        }
        this.cqn = this.hmE - this.eCL;
        super.onCreate(bundle);
        this.hmC = 0;
        Z(bundle);
        if (this.hmT != null && this.hmT.getPbData() != null) {
            this.hmT.getPbData().zH(this.source);
        }
        initUI();
        if (intent != null && this.hmW != null) {
            this.hmW.hvG = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hnu == null) {
                    this.hnu = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hmW.Aa("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hnu, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hmT != null && this.hmT.getPbData() != null) {
                this.hmT.zU(stringExtra);
            }
        }
        this.eYR = new VoiceManager();
        this.eYR.onCreate(getPageContext());
        initData(bundle);
        this.hnk = new com.baidu.tbadk.editortools.pb.f();
        bJn();
        this.hnl = (com.baidu.tbadk.editortools.pb.d) this.hnk.dd(getActivity());
        this.hnl.b(this);
        this.hnl.a(this.cks);
        this.hnl.a(this.ckl);
        this.hnl.a(this, bundle);
        this.hnl.alS().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hnl.alS().eH(true);
        ni(true);
        this.hmW.setEditorTools(this.hnl.alS());
        this.hnl.a(this.hmT.bLe(), this.hmT.bKR(), this.hmT.bLw());
        registerListener(this.hnG);
        if (!this.hmT.bKX()) {
            this.hnl.oR(this.hmT.bKR());
        }
        if (this.hmT.bLx()) {
            this.hnl.oP(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else if (this.hmW != null) {
            this.hnl.oP(this.hmW.bMr());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hnF);
        registerListener(this.hnH);
        registerListener(this.hnI);
        registerListener(this.faj);
        registerListener(this.hnW);
        registerListener(this.hnE);
        this.hnj = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.iFB);
        this.hnj.cdU();
        registerListener(this.hnK);
        registerListener(this.mAttentionListener);
        if (this.hmT != null) {
            this.hmT.bLo();
        }
        registerListener(this.hnZ);
        registerListener(this.hop);
        registerListener(this.faq);
        if (this.hmW != null && this.hmW.bNo() != null && this.hmW.bNp() != null) {
            this.hmy = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hmW.bNo(), this.hmW.bNp(), this.hmW.bMx());
            this.hmy.a(this.hnS);
        }
        if (this.hmx && this.hmW != null && this.hmW.bNp() != null) {
            this.hmW.bNp().setVisibility(8);
        }
        this.hns = new com.baidu.tbadk.core.view.e();
        this.hns.bPO = 1000L;
        registerListener(this.hnV);
        registerListener(this.hnT);
        registerListener(this.hnU);
        registerListener(this.frJ);
        registerListener(this.brp);
        this.hnt = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hnt;
        userMuteAddAndDelCustomMessage.setTag(this.hnt);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hnt;
        userMuteCheckCustomMessage.setTag(this.hnt);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hmT.bLu().a(this.dLI);
        this.hnb = new as();
        if (this.hnl.ams() != null) {
            this.hnb.k(this.hnl.ams().getInputView());
        }
        this.hnl.a(this.ckm);
        this.foH = new ShareSuccessReplyToServerModel();
        a(this.hnB);
        this.gyK = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gyK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bKt) {
                        PbActivity.this.hnl.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bKu && PbActivity.this.hmW != null && PbActivity.this.hmW.bMo() != null && PbActivity.this.hmW.bMo().bKI() != null) {
                        PbActivity.this.hmW.bMo().bKI().amL();
                    } else if (i == com.baidu.tbadk.core.util.aj.bKv) {
                        PbActivity.this.c(PbActivity.this.hno);
                    }
                }
            }
        });
        this.hmU = new com.baidu.tieba.pb.pb.report.a(this);
        this.hmU.p(getUniqueId());
        com.baidu.tieba.q.c.cdt().s(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.hmE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJn() {
        if (this.hnk != null && this.hmT != null) {
            this.hnk.setForumName(this.hmT.bIR());
            if (this.hmT.getPbData() != null && this.hmT.getPbData().getForum() != null) {
                this.hnk.a(this.hmT.getPbData().getForum());
            }
            this.hnk.setFrom("pb");
            this.hnk.a(this.hmT);
        }
    }

    public String bJo() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bJp() {
        return this.hmy;
    }

    private void ni(boolean z) {
        this.hnl.eL(z);
        this.hnl.eM(z);
        this.hnl.eN(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bIx() && !z && this.hmW != null && this.hmW.getView() != null && !UtilHelper.isOnePlus6()) {
            this.hmW.getView().setSystemUiVisibility(4);
        }
        this.hnp = z;
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
            Rect rect = new Rect();
            frameLayout.getWindowVisibleDisplayFrame(rect);
            ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
            childAt.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eYR != null) {
            this.eYR.onStart(getPageContext());
        }
    }

    public aq bJq() {
        return this.hmW;
    }

    public PbModel bJa() {
        return this.hmT;
    }

    public void zK(String str) {
        if (this.hmT != null && !StringUtils.isNull(str) && this.hmW != null) {
            this.hmW.nX(true);
            this.hmT.zK(str);
            this.hmK = true;
            this.hmW.bNa();
            this.hmW.bNj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hmA = false;
        } else {
            this.hmA = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hmC = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hmC == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.eYR != null) {
            this.eYR.onPause(getPageContext());
        }
        if (this.hmW != null) {
            this.hmW.onPause();
        }
        if (!this.hmT.bKX()) {
            this.hnl.oQ(this.hmT.bKR());
        }
        if (this.hmT != null) {
            this.hmT.bLp();
        }
        com.baidu.tbadk.BdToken.c.TZ().Ua();
        MessageManager.getInstance().unRegisterListener(this.gcF);
        bnY();
        MessageManager.getInstance().unRegisterListener(this.hnT);
        MessageManager.getInstance().unRegisterListener(this.hnU);
        MessageManager.getInstance().unRegisterListener(this.hnV);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bJr() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hmT.getPbData(), this.hmT.bKS(), this.hmT.getRequestType());
        return (a2 == null || a2.YR() == null || a2.YR().getGodUserData() == null || a2.YR().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hmA = false;
        super.onResume();
        if (this.hmN) {
            this.hmN = false;
            bJV();
        }
        if (bJr()) {
            this.hmH = System.currentTimeMillis();
        } else {
            this.hmH = -1L;
        }
        if (this.hmW != null && this.hmW.getView() != null) {
            if (!this.gQe) {
                bJM();
            } else {
                hideLoadingView(this.hmW.getView());
            }
            this.hmW.onResume();
        }
        if (this.hmC == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hmW != null) {
            noNetworkView = this.hmW.bMl();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kY()) {
            noNetworkView.dO(false);
        }
        if (this.eYR != null) {
            this.eYR.onResume(getPageContext());
        }
        registerListener(this.gcF);
        this.hnf = false;
        bJU();
        registerListener(this.hnT);
        registerListener(this.hnU);
        registerListener(this.hnV);
        if (this.eZG) {
            bJL();
            this.eZG = false;
        }
        bKd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hmW.nM(z);
        if (this.hnc != null) {
            this.hnc.dismiss();
        }
        if (z && this.hnf) {
            this.hmW.bMK();
            this.hmT.ny(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hmH > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").bJ("obj_duration", (System.currentTimeMillis() - this.hmH) + ""));
            this.hmH = 0L;
        }
        if (bJq().bMo() != null) {
            bJq().bMo().onStop();
        }
        if (this.hmW.hvN != null && !this.hmW.hvN.aRo()) {
            this.hmW.hvN.bzn();
        }
        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().getForum() != null && this.hmT.getPbData().bHZ() != null) {
            com.baidu.tbadk.distribute.a.alF().a(getPageContext().getPageActivity(), "pb", this.hmT.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmT.getPbData().bHZ().getId(), 0L));
        }
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.cdt().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.cdt().t(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hmT.getPbData().getForumId());
            amVar.bJ("tid", this.hmT.bKR());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hmF && this.hmW != null) {
            this.hmF = true;
            this.hmW.bNf();
            a(false, (PostData) null);
        }
        if (this.hmT != null) {
            this.hmT.cancelLoadData();
            this.hmT.destory();
            if (this.hmT.bLt() != null) {
                this.hmT.bLt().onDestroy();
            }
        }
        if (this.hnl != null) {
            this.hnl.onDestroy();
        }
        if (this.eiW != null) {
            this.eiW.cancelLoadData();
        }
        if (this.hmW != null) {
            this.hmW.onDestroy();
            if (this.hmW.hvN != null) {
                this.hmW.hvN.bzn();
            }
        }
        if (this.hmG != null) {
            this.hmG.apb();
        }
        if (this.hmy != null) {
            this.hmy.aqk();
        }
        super.onDestroy();
        if (this.eYR != null) {
            this.eYR.onDestory(getPageContext());
        }
        this.hmW.bNa();
        MessageManager.getInstance().unRegisterListener(this.hnT);
        MessageManager.getInstance().unRegisterListener(this.hnU);
        MessageManager.getInstance().unRegisterListener(this.hnV);
        MessageManager.getInstance().unRegisterListener(this.hnt);
        MessageManager.getInstance().unRegisterListener(this.hnW);
        MessageManager.getInstance().unRegisterListener(this.faq);
        MessageManager.getInstance().unRegisterListener(this.frJ);
        this.hnr = null;
        this.hns = null;
        com.baidu.tieba.recapp.d.a.bXz().bXB();
        if (this.hnu != null) {
            getSafeHandler().removeCallbacks(this.hnu);
        }
        if (this.hmO != null) {
            this.hmO.cancelLoadData();
        }
        if (this.hmW != null && this.hmW.hvN != null) {
            this.hmW.hvN.bOa();
        }
        if (this.foH != null) {
            this.foH.cancelLoadData();
        }
        this.hnb.onDestroy();
        if (this.hmT != null && this.hmT.bLv() != null) {
            this.hmT.bLv().onDestroy();
        }
        if (this.gyK != null) {
            this.gyK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bMF;
        ArrayList<PostData> bKt;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aga() && this.hmW != null && (bMF = this.hmW.bMF()) != null && (bKt = bMF.bKt()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bKt.iterator();
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
                        bVar.ekT = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bCg == 1 && !TextUtils.isEmpty(id)) {
                    next.bCg = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.ekT = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hmT == null || this.hmT.getPbData() == null || this.hmT.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hmT.getPbData().getForum().getFirst_class();
                    str2 = this.hmT.getPbData().getForum().getSecond_class();
                    str = this.hmT.getPbData().getForum().getId();
                    str4 = this.hmT.bKR();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.agd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.hmW.onChangeSkinType(i);
            if (this.hnl != null && this.hnl.alS() != null) {
                this.hnl.alS().onChangeSkinType(i);
            }
            if (this.hmW.bMl() != null) {
                this.hmW.bMl().onChangeSkinType(getPageContext(), i);
            }
            this.hnb.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hmW = new aq(this, this.faY, this.cbY);
        this.dMr = new com.baidu.tieba.f.b(getActivity());
        this.dMr.a(hoi);
        this.dMr.a(this.dMs);
        this.hmW.setOnScrollListener(this.mOnScrollListener);
        this.hmW.e(this.fsR);
        this.hmW.setListPullRefreshListener(this.cPu);
        this.hmW.nc(com.baidu.tbadk.core.i.Wy().WC());
        this.hmW.setOnImageClickListener(this.cAB);
        this.hmW.b(this.cdd);
        this.hmW.h(this.eWD);
        this.hmW.a(this.hob);
        this.hmW.nM(this.mIsLogin);
        if (getIntent() != null) {
            this.hmW.nY(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hmW.bMn().setFromForumId(this.hmT.getFromForumId());
    }

    public void bJs() {
        if (this.hmW != null && this.hmT != null) {
            if ((this.hmT.getPbData() != null || this.hmT.getPbData().bIw() != null) && checkUpIsLogin() && this.hmW.bMF() != null && this.hmW.bMF().bKy() != null) {
                this.hmW.bMF().bKy().nr(this.hmT.bKR());
            }
        }
    }

    public void bJt() {
        TiebaStatic.log("c12181");
        if (this.hmW != null && this.hmT != null) {
            if (this.hmW == null || this.hmW.bMq()) {
                if (this.hmT.getPbData() != null || this.hmT.getPbData().bIw() != null) {
                    com.baidu.tieba.pb.data.i bIw = this.hmT.getPbData().bIw();
                    if (checkUpIsLogin()) {
                        if ((!bIw.bIA() || bIw.aan() != 2) && this.hmW.bMF() != null && this.hmW.bMF().bKy() != null) {
                            this.hmW.bMF().bKy().nr(this.hmT.bKR());
                        }
                        if (System.currentTimeMillis() - this.hmJ > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).or(false);
                            this.hmJ = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ck(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(d.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.iGd && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.Wy().WC()) {
                    return zN(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hmT == null || this.hmT.getPbData() == null) {
                        return true;
                    }
                    if (bJq().bMo() != null) {
                        bJq().bMo().bKE();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.hmT.getPbData().getForum());
                    jVar.aj(this.hmT.getPbData().bHZ());
                    jVar.e(postData);
                    bJq().bMn().d(jVar);
                    bJq().bMn().setPostId(postData.getId());
                    a(view, postData.YR().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hnl != null) {
                        this.hmW.nS(this.hnl.amz());
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
        if (this.hmW != null) {
            if (z && !this.gQe) {
                bJM();
            } else {
                hideLoadingView(this.hmW.getView());
            }
            if (z && this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bIx() && this.hmW.getView() != null && !UtilHelper.isOnePlus6()) {
                this.hmW.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bJu() {
        if (this.hmD == null) {
            this.hmD = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hmD.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hms = PbActivity.this.hms.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hms);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hmT.bKR(), PbActivity.this.hms, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hms = PbActivity.this.hms.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hms);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hmT.bKR(), PbActivity.this.hms, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hms = PbActivity.this.hms.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hms);
                        bVar.dismiss();
                    }
                }
            }).gH(b.a.bFa).gI(17).d(getPageContext());
        }
    }

    private void Z(Bundle bundle) {
        this.hmT = new PbModel(this);
        this.hmT.a(this.hnY);
        if (this.hmT.bLs() != null) {
            this.hmT.bLs().a(this.hok);
        }
        if (this.hmT.bLr() != null) {
            this.hmT.bLr().a(this.hnJ);
        }
        if (this.hmT.bLt() != null) {
            this.hmT.bLt().b(this.hnD);
        }
        if (bundle != null) {
            this.hmT.initWithBundle(bundle);
        } else {
            this.hmT.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hmT.nB(true);
        }
        aj.bMa().ao(this.hmT.bKP(), this.hmT.getIsFromMark());
        if (StringUtils.isNull(this.hmT.bKR())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hmL) && this.hmL != null) {
            this.hmT.wu(6);
        }
        this.hmT.aou();
    }

    private void initData(Bundle bundle) {
        this.hmV = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hmV != null) {
            this.hmV.a(this.hoa);
        }
        this.eiW = new ForumManageModel(this);
        this.eiW.setLoadDataCallBack(this.eja);
        this.bKy = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hmW.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hmT.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmT.getPbData().getForum().getId(), PbActivity.this.hmT.getPbData().getForum().getName(), PbActivity.this.hmT.getPbData().bHZ().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hnP.setUniqueId(getUniqueId());
        this.hnP.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hmW.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hnt;
        userMuteCheckCustomMessage.setTag(this.hnt);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bJv() {
        if (checkUpIsLogin()) {
            if (this.fcv == null) {
                this.fcv = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fcv.re(0);
                this.fcv.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jl(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void n(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jm(boolean z) {
                        if (z) {
                            PbActivity.this.hmW.bnm();
                        }
                    }
                });
            }
            if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().getForum() != null) {
                this.fcv.q(this.hmT.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmT.bKR(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJw() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hmT != null && (pbData = this.hmT.getPbData()) != null) {
            return pbData.bIk().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHZ() != null) {
            if (dVar.bHZ().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bHZ().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bHZ().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bJx()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hmQ);
                this.hmR = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hnn == null) {
                this.hnn = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hnn.re(1);
                this.hnn.a(new AnonymousClass39(str, str2));
            }
            if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().getForum() != null) {
                this.hnn.q(this.hmT.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmT.bKR(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$39  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String hoA;
        final /* synthetic */ String hoz;

        AnonymousClass39(String str, String str2) {
            this.hoz = str;
            this.hoA = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jm(boolean z) {
            if (z) {
                PbActivity.this.getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int h;
                        int aQ = com.baidu.adp.lib.util.l.aQ(PbActivity.this.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            h = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), d.e.tbds256);
                        } else {
                            h = (aQ / 2) + com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), d.e.tbds256);
                        }
                        PbActivity.this.bJq().getListView().smoothScrollBy((PbActivity.this.hmQ[1] + PbActivity.this.hmR) - (aQ - h), 50);
                        if (PbActivity.this.bJq().bMo() != null) {
                            PbActivity.this.hnl.alS().setVisibility(8);
                            PbActivity.this.bJq().bMo().Y(AnonymousClass39.this.hoz, AnonymousClass39.this.hoA, PbActivity.this.bJq().bMr());
                            com.baidu.tbadk.editortools.pb.g bKI = PbActivity.this.bJq().bMo().bKI();
                            if (bKI != null && PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                                bKI.a(PbActivity.this.hmT.getPbData().getAnti());
                            }
                            if (PbActivity.this.hnb.bNB() == null && PbActivity.this.bJq().bMo().bKI().amT() != null) {
                                PbActivity.this.bJq().bMo().bKI().amT().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hnb != null && PbActivity.this.hnb.bNA() != null) {
                                            if (!PbActivity.this.hnb.bNA().cob()) {
                                                PbActivity.this.hnb.oa(false);
                                            }
                                            PbActivity.this.hnb.bNA().qV(false);
                                        }
                                    }
                                });
                                PbActivity.this.hnb.l(PbActivity.this.bJq().bMo().bKI().amT().getInputView());
                                PbActivity.this.bJq().bMo().bKI().a(PbActivity.this.hnq);
                            }
                        }
                        PbActivity.this.bJq().bNj();
                    }
                }, 0L);
            }
        }
    }

    public boolean bJx() {
        if (this.gyK == null || this.hmT.getPbData() == null || this.hmT.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyK.hm(this.hmT.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean wd(int i) {
        if (this.gyK == null || this.hmT.getPbData() == null || this.hmT.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyK.S(this.hmT.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.hmT != null && this.hmT.getPbData() != null && postData.cet() != 1) {
            String bKR = this.hmT.bKR();
            String id = postData.getId();
            int bIl = this.hmT.getPbData() != null ? this.hmT.getPbData().bIl() : 0;
            c zO = zO(id);
            if (zO != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bKR, id, "pb", true, null, false, null, bIl, postData.bOO(), this.hmT.getPbData().getAnti(), false, postData.YR() != null ? postData.YR().getIconInfo() : null).addBigImageData(zO.hoQ, zO.hoR, zO.hoS, zO.index);
                addBigImageData.setKeyPageStartFrom(this.hmT.bLz());
                addBigImageData.setFromFrsForumId(this.hmT.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJy() {
        if (this.hmT.getPbData() == null || this.hmT.getPbData().bHZ() == null) {
            return -1;
        }
        return this.hmT.getPbData().bHZ().ZB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJz() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.BV(this.hmT.getForumId()) && this.hmT.getPbData() != null && this.hmT.getPbData().getForum() != null) {
            if (this.hmT.getPbData().getForum().isLike() == 1) {
                this.hmT.bLv().dO(this.hmT.getForumId(), this.hmT.bKR());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hmT == null || this.hmT.getPbData() == null) {
            return false;
        }
        return ((this.hmT.getPbData().bIl() != 0) || this.hmT.getPbData().bHZ() == null || this.hmT.getPbData().bHZ().YR() == null || TextUtils.equals(this.hmT.getPbData().bHZ().YR().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bJA() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.s.v.apH()) {
            return "";
        }
        PostData bIg = bIg();
        if (this.hmT == null || (pbData = this.hmT.getPbData()) == null || pbData.getUserData() == null || pbData.bHZ() == null || bIg == null || bIg.YR() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bIg.YR().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bHZ().Yy() == 0) {
            return "";
        }
        if (pbData.bHZ().Yy() == 0) {
            return getPageContext().getString(d.j.fans_call);
        }
        return getPageContext().getString(d.j.haved_fans_call);
    }

    private boolean nk(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.v vVar;
        if (z) {
            return true;
        }
        if (this.hmT == null || this.hmT.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hmT.getPbData();
        if (pbData.bIl() != 0) {
            return pbData.bIl() != 3;
        }
        List<com.baidu.tbadk.core.data.bc> bIu = pbData.bIu();
        if (com.baidu.tbadk.core.util.v.S(bIu) > 0) {
            for (com.baidu.tbadk.core.data.bc bcVar : bIu) {
                if (bcVar != null && (vVar = bcVar.bAA) != null && vVar.byt && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    private boolean nl(boolean z) {
        return (z || this.hmT == null || this.hmT.getPbData() == null || this.hmT.getPbData().bIl() == 0 || this.hmT.getPbData().bIl() == 3) ? false : true;
    }

    public void bJB() {
        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null && this.hmT.getPbData().bHZ().YR() != null) {
            if (this.hmW != null) {
                this.hmW.bMm();
            }
            bg bHZ = this.hmT.getPbData().bHZ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bHZ.YR().getUserId());
            ab abVar = new ab();
            int bIl = this.hmT.getPbData().bIl();
            if (bIl == 1 || bIl == 3) {
                abVar.htW = true;
                abVar.htV = true;
                abVar.hud = bHZ.YM() == 1;
                abVar.huc = bHZ.YN() == 1;
            } else {
                abVar.htW = false;
                abVar.htV = false;
            }
            if (bIl == 1002 && !equals) {
                abVar.huh = true;
            }
            abVar.htX = nk(equals);
            abVar.htY = bJC();
            abVar.htZ = nl(equals);
            abVar.qV = this.hmT.bKS();
            abVar.htU = true;
            abVar.htT = nj(equals);
            abVar.huf = bJA();
            abVar.htS = equals && this.hmW.bMR();
            abVar.hua = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hub = true;
            abVar.isHostOnly = this.hmT.getHostMode();
            abVar.hue = true;
            if (bHZ.Zi() == null) {
                abVar.hug = true;
            } else {
                abVar.hug = false;
            }
            this.hmW.hvN.a(abVar);
        }
    }

    private boolean bJC() {
        if (this.hmT != null && this.hmT.bKS()) {
            return this.hmT.getPageData() == null || this.hmT.getPageData().XL() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(View view) {
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

    public int bJD() {
        if (bJq() == null || bJq().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bJq().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) mVar).mType == com.baidu.tieba.pb.data.h.hkH) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJE() {
        if (bJq() == null || bJq().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bJq().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.iGc) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bJL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.lx(getResources().getString(d.j.mark_done));
            aVar.dx(true);
            aVar.ly(getResources().getString(d.j.mark_like));
            aVar.dw(true);
            aVar.dq(false);
            aVar.b(getResources().getString(d.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").bJ(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).T("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(d.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").bJ(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).T("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.bKy.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hmT.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aaZ();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hmW.bML();
        this.hmT.nA(z);
        if (this.hmV != null) {
            this.hmV.cZ(z);
            if (markData != null) {
                this.hmV.a(markData);
            }
        }
        if (this.hmT.Vb()) {
            bJJ();
        } else {
            this.hmW.o(this.hmT.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wb(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(String str) {
        this.hmU.Aj(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hmT.bKX()) {
                    antiData.setBlock_forum_name(this.hmT.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hmT.getPbData().getForum().getId());
                    antiData.setUser_name(this.hmT.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hmT.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bJq() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aB(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLl));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLl));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLl));
            }
        } else if (i == 230277) {
            oW(str);
        } else {
            this.hmW.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.iIC) ? bVar.iIC : getString(d.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ly(string);
                aVar.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.dq(true);
                aVar.b(getPageContext());
                aVar.aaZ();
            } else {
                this.hmW.a(0, bVar.Id, bVar.iIC, z);
            }
            if (bVar.Id) {
                if (bVar.eFN == 1) {
                    ArrayList<PostData> bIb = this.hmT.getPbData().bIb();
                    int size = bIb.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bIb.get(i).getId())) {
                            i++;
                        } else {
                            bIb.remove(i);
                            break;
                        }
                    }
                    this.hmT.getPbData().bHZ().gr(this.hmT.getPbData().bHZ().YI() - 1);
                    this.hmW.o(this.hmT.getPbData());
                } else if (bVar.eFN == 0) {
                    bJF();
                } else if (bVar.eFN == 2) {
                    ArrayList<PostData> bIb2 = this.hmT.getPbData().bIb();
                    int size2 = bIb2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bIb2.get(i2).ceq().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bIb2.get(i2).ceq().get(i3).getId())) {
                                i3++;
                            } else {
                                bIb2.get(i2).ceq().remove(i3);
                                bIb2.get(i2).ces();
                                z2 = true;
                                break;
                            }
                        }
                        bIb2.get(i2).Cz(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hmW.o(this.hmT.getPbData());
                    }
                    a(bVar, this.hmW);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hmW.a(this.eiW.getLoadDataMode(), gVar.Id, gVar.iIC, false);
            if (gVar.Id) {
                this.hmY = true;
                if (i == 2 || i == 3) {
                    this.hmZ = true;
                    this.hna = false;
                } else if (i == 4 || i == 5) {
                    this.hmZ = false;
                    this.hna = true;
                }
                if (i == 2) {
                    this.hmT.getPbData().bHZ().gu(1);
                    this.hmT.setIsGood(1);
                } else if (i == 3) {
                    this.hmT.getPbData().bHZ().gu(0);
                    this.hmT.setIsGood(0);
                } else if (i == 4) {
                    this.hmT.getPbData().bHZ().gt(1);
                    this.hmT.oE(1);
                } else if (i == 5) {
                    this.hmT.getPbData().bHZ().gt(0);
                    this.hmT.oE(0);
                }
                this.hmW.d(this.hmT.getPbData(), this.hmT.bKS());
            }
        }
    }

    private void bJF() {
        if (this.hmT.bKT() || this.hmT.bKV()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hmT.bKR());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hmT.bKR()));
        if (bJK()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bIi;
        boolean z = false;
        if (this.hmW != null) {
            this.hmW.bNa();
        }
        if (this.hmT != null && this.hmT.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hmT.getPbData().bHZ().getId();
            if (this.hmT.isShareThread() && this.hmT.getPbData().bHZ().bDv != null) {
                historyMessage.threadName = this.hmT.getPbData().bHZ().bDv.showText;
            } else {
                historyMessage.threadName = this.hmT.getPbData().bHZ().getTitle();
            }
            if (this.hmT.isShareThread() && !bIQ()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hmT.getPbData().getForum().getName();
            }
            ArrayList<PostData> bIb = this.hmT.getPbData().bIb();
            int bMN = this.hmW != null ? this.hmW.bMN() : 0;
            if (bIb != null && bMN >= 0 && bMN < bIb.size()) {
                historyMessage.postID = bIb.get(bMN).getId();
            }
            historyMessage.isHostOnly = this.hmT.getHostMode();
            historyMessage.isSquence = this.hmT.bKS();
            historyMessage.isShareThread = this.hmT.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hnl != null) {
            this.hnl.onDestroy();
        }
        if (this.hmB && bJq() != null) {
            bJq().bNt();
        }
        if (this.hmT != null && (this.hmT.bKT() || this.hmT.bKV())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hmT.bKR());
            if (this.hmY) {
                if (this.hna) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hmT.aWk());
                }
                if (this.hmZ) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hmT.getIsGood());
                }
            }
            if (this.hmT.getPbData() != null && System.currentTimeMillis() - this.hmE >= 40000 && (bIi = this.hmT.getPbData().bIi()) != null && !com.baidu.tbadk.core.util.v.T(bIi.getDataList())) {
                intent.putExtra("guess_like_data", bIi);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hnz);
            }
            setResult(-1, intent);
        }
        if (bJK()) {
            if (this.hmT != null && this.hmW != null && this.hmW.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hmT.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bIf() && !this.hmK) {
                        aj bMa = aj.bMa();
                        com.baidu.tieba.pb.data.d bKZ = this.hmT.bKZ();
                        Parcelable onSaveInstanceState = this.hmW.getListView().onSaveInstanceState();
                        boolean bKS = this.hmT.bKS();
                        boolean hostMode = this.hmT.getHostMode();
                        if (this.hmW.bMx() != null && this.hmW.bMx().getVisibility() == 0) {
                            z = true;
                        }
                        bMa.a(bKZ, onSaveInstanceState, bKS, hostMode, z);
                        if (this.hny >= 0 || this.hmT.bLB() != null) {
                            aj.bMa().l(this.hmT.bLB());
                            aj.bMa().k(this.hmT.bLC());
                            aj.bMa().ww(this.hmT.bLD());
                        }
                    }
                }
            } else {
                aj.bMa().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hmW == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hmW.wB(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean we(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.hmW.bMm();
            this.hmW.bMo().bKE();
            this.hmW.nU(false);
        }
        this.hmW.bMp();
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
                        this.hnl.resetData();
                        this.hnl.b(writeData);
                        this.hnl.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k jw = this.hnl.alS().jw(6);
                        if (jw != null && jw.ciu != null) {
                            jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hnl.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hmW.bMo() != null && this.hmW.bMo().bKI() != null) {
                            com.baidu.tbadk.editortools.pb.g bKI = this.hmW.bMo().bKI();
                            bKI.b(writeData);
                            bKI.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k jw2 = bKI.alS().jw(6);
                            if (jw2 != null && jw2.ciu != null) {
                                jw2.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bKI.amL();
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
        this.hnl.onActivityResult(i, i2, intent);
        if (this.hmO != null) {
            this.hmO.onActivityResult(i, i2, intent);
        }
        if (bJq().bMo() != null) {
            bJq().bMo().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bJI();
                    return;
                case 13008:
                    aj.bMa().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hmT != null) {
                                PbActivity.this.hmT.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bWr().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hmT != null) {
                        a(bJH(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ad(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bWr().x(getPageContext());
                        bJz();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.foH != null && shareItem != null && shareItem.linkUrl != null) {
                            this.foH.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aiK() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57.1
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
                    this.hmW.nh(false);
                    if (this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null && this.hmT.getPbData().bHZ().Zl() != null) {
                        this.hmT.getPbData().bHZ().Zl().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hno = emotionImageData;
                        if (wd(com.baidu.tbadk.core.util.aj.bKv)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hmW != null && this.hmW.hvN != null) {
                        this.hmW.hvN.Qk();
                        this.hmW.hvN.bNU();
                        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null) {
                            this.hmT.getPbData().bHZ().gp(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hmP != null) {
                        this.hmW.ct(this.hmP);
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
            if (this.hmO == null) {
                this.hmO = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hmO.b(this.ckl);
                this.hmO.c(this.cks);
            }
            this.hmO.a(emotionImageData, bJa(), bJa().getPbData());
        }
    }

    private ShareFromPBMsgData bJH() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ek = this.hmT.getPbData().ek(getPageContext().getPageActivity());
        PostData bMs = this.hmW.bMs();
        String str = "";
        if (bMs != null) {
            str = bMs.getId();
            String ev = bMs.ev(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ev)) {
                ek[1] = ev;
            }
        }
        String Zh = this.hmT.getPbData().bHZ().Zh();
        if (Zh != null && Zh.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ek[1]);
        shareFromPBMsgData.setImageUrl(ek[0]);
        shareFromPBMsgData.setForumName(this.hmT.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hmT.getPbData().bHZ().getId());
        shareFromPBMsgData.setTitle(this.hmT.getPbData().bHZ().getTitle());
        return shareFromPBMsgData;
    }

    private void ad(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bJH(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.gF(1);
            aVar.az(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null) {
                        com.baidu.tbadk.core.util.am bJ = new com.baidu.tbadk.core.util.am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).T("obj_param1", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmT.getForumId()).bJ("tid", PbActivity.this.hmT.bKR());
                        if (PbActivity.this.e(PbActivity.this.hmT.getPbData()) != 0) {
                            bJ.T("obj_type", PbActivity.this.e(PbActivity.this.hmT.getPbData()));
                        }
                        TiebaStatic.log(bJ);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dr(true);
            aVar.b(getPageContext()).aaZ();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), this.hmT.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.gF(1);
            aVar.az(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dr(true);
            aVar.b(getPageContext()).aaZ();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), this.hmT.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJI() {
        MarkData wt;
        if (this.hmV != null && (wt = this.hmT.wt(this.hmW.bMO())) != null) {
            if (!wt.isApp() || (wt = this.hmT.wt(this.hmW.bMO() + 1)) != null) {
                this.hmW.bMJ();
                this.hmV.a(wt);
                if (!this.hmV.Vb()) {
                    this.hmV.Vd();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hmV.Vc();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        com.baidu.tieba.pb.data.d pbData = this.hmT.getPbData();
        this.hmT.nA(true);
        if (this.hmV != null) {
            pbData.zG(this.hmV.Va());
        }
        this.hmW.o(pbData);
    }

    private boolean bJK() {
        if (this.hmT == null) {
            return true;
        }
        if (this.hmT.Vb()) {
            final MarkData bLj = this.hmT.bLj();
            if (bLj == null || !this.hmT.getIsFromMark()) {
                return true;
            }
            final MarkData wt = this.hmT.wt(this.hmW.bMN());
            if (wt == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bLj);
                setResult(-1, intent);
                return true;
            } else if (wt.getPostId() == null || wt.getPostId().equals(bLj.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bLj);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ly(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hmV != null) {
                            if (PbActivity.this.hmV.Vb()) {
                                PbActivity.this.hmV.Vc();
                                PbActivity.this.hmV.cZ(false);
                            }
                            PbActivity.this.hmV.a(wt);
                            PbActivity.this.hmV.cZ(true);
                            PbActivity.this.hmV.Vd();
                        }
                        bLj.setPostId(wt.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bLj);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bJG();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bLj);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bJG();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hmW != null && PbActivity.this.hmW.getView() != null) {
                            PbActivity.this.hmW.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bLj);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bJG();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.aaZ();
                return false;
            }
        } else if (this.hmT.getPbData() == null || this.hmT.getPbData().bIb() == null || this.hmT.getPbData().bIb().size() <= 0 || !this.hmT.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hmW == null) {
            return null;
        }
        return this.hmW.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int atd() {
        if (this.hmW == null) {
            return 0;
        }
        return this.hmW.bMY();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ate() {
        if (this.cAs == null) {
            this.cAs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean WC = com.baidu.tbadk.core.i.Wy().WC();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(d.C0277d.common_color_10220));
                    if (WC) {
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
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0277d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.Wy().WC()) {
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
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(d.C0277d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.cAs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atf() {
        if (this.cDh == null) {
            this.cDh = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDh;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atg() {
        if (this.cAt == null) {
            this.cAt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKf */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbActivity.this.getPageContext().getPageActivity());
                    boolean WC = com.baidu.tbadk.core.i.Wy().WC();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(d.C0277d.common_color_10220));
                    if (WC) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(d.f.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.setBackgroundDrawable(null);
                    gifView.setImageDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(d.C0277d.common_color_10220);
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (com.baidu.tbadk.core.i.Wy().WC()) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(d.f.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.anm();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(d.C0277d.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cAt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ath() {
        if (this.cDi == null) {
            this.cDi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKg */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(d.e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cn */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: co */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cfD();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cp */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cDi;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atj() {
        this.cDk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bKh */
            public RelativeLayout makeObject() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.cDk;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afd() {
        if (this.bTS == null) {
            this.bTS = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTS;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ay(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hmI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (av.Ab(str) && this.hmT != null && this.hmT.bKR() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").T("obj_param1", 1).bJ("post_id", this.hmT.bKR()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.chu = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            av.bND().c(getPageContext(), str);
        }
        this.hmI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void az(Context context, String str) {
        av.bND().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hmI = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aB(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aA(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Rect rect) {
        if (rect != null && this.hmW != null && this.hmW.bNo() != null && rect.top <= this.hmW.bNo().getHeight()) {
            rect.top += this.hmW.bNo().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hmT.getPbData();
            TbRichText bh = bh(str, i);
            if (bh != null && (tbRichTextData = bh.asw().get(this.hod)) != null) {
                cVar.hoQ = new ArrayList<>();
                cVar.hoR = new ConcurrentHashMap<>();
                if (!tbRichTextData.asD().asP()) {
                    cVar.hoT = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hoQ.add(b2);
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
                    imageUrlData.postId = bh.getPostId();
                    imageUrlData.mIsReserver = this.hmT.bLh();
                    imageUrlData.mIsSeeHost = this.hmT.getHostMode();
                    cVar.hoR.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bHZ() != null) {
                            cVar.threadId = pbData.bHZ().getId();
                        }
                        cVar.hoS = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.hoT = true;
                int size = pbData.bIb().size();
                this.hoe = false;
                cVar.index = -1;
                if (pbData.bIg() != null) {
                    PostData bIg = pbData.bIg();
                    TbRichText cev = bIg.cev();
                    if (!ap.m(bIg)) {
                        i2 = a(cev, bh, i, i, cVar.hoQ, cVar.hoR);
                    } else {
                        i2 = a(bIg, i, cVar.hoQ, cVar.hoR);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bIb().get(i4);
                    if (postData.getId() == null || pbData.bIg() == null || pbData.bIg().getId() == null || !postData.getId().equals(pbData.bIg().getId())) {
                        TbRichText cev2 = postData.cev();
                        if (!ap.m(postData)) {
                            i3 = a(cev2, bh, i3, i, cVar.hoQ, cVar.hoR);
                        } else {
                            i3 = a(postData, i3, cVar.hoQ, cVar.hoR);
                        }
                    }
                }
                if (cVar.hoQ.size() > 0) {
                    cVar.lastId = cVar.hoQ.get(cVar.hoQ.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bHZ() != null) {
                        cVar.threadId = pbData.bHZ().getId();
                    }
                    cVar.hoS = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asD() == null) {
            return null;
        }
        return tbRichTextData.asD().asU();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asD() == null) {
            return 0L;
        }
        return tbRichTextData.asD().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asD() == null) {
            return false;
        }
        return tbRichTextData.asD().asV();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asD() == null) {
            return false;
        }
        return tbRichTextData.asD().asW();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo asD;
        String str;
        if (tbRichText == tbRichText2) {
            this.hoe = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.asw().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.asw().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.asD().getWidth() * aR;
                    int height = aR * tbRichTextData.asD().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.asD().asP()) {
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
                            if (tbRichTextData != null && (asD = tbRichTextData.asD()) != null) {
                                String asR = asD.asR();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = asD.asS();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = asR;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hmT.bKR(), -1L);
                                imageUrlData.mIsReserver = this.hmT.bLh();
                                imageUrlData.mIsSeeHost = this.hmT.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hoe) {
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
        com.baidu.tieba.tbadkCore.data.i ceC;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cdY;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cdY = (ceC = postData.ceC()).cdY()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cdY.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cdY.get(i3);
                if (kVar != null) {
                    String cec = kVar.cec();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(cec)) {
                        arrayList.add(cec);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cec;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.ceb();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hmT.bKR(), -1L);
                        imageUrlData.mIsReserver = this.hmT.bLh();
                        imageUrlData.mIsSeeHost = this.hmT.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = ceC.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cec, imageUrlData);
                        }
                        if (!this.hoe) {
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
            if (postData.getId() != null && postData.getId().equals(this.hmT.Za())) {
                z = true;
            }
            MarkData j = this.hmT.j(postData);
            if (j != null) {
                this.hmW.bMJ();
                if (this.hmV != null) {
                    this.hmV.a(j);
                    if (!z) {
                        this.hmV.Vd();
                    } else {
                        this.hmV.Vc();
                    }
                }
            }
        }
    }

    public boolean cm(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bh(String str, int i) {
        TbRichText tbRichText = null;
        if (this.hmT == null || this.hmT.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hmT.getPbData();
        if (pbData.bIg() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bIg());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bIb = pbData.bIb();
            a(pbData, bIb);
            return a(bIb, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bIk() != null && dVar.bIk().hkW != null && (list = dVar.bIk().hkW) != null && arrayList != null) {
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

    private long zM(String str) {
        ArrayList<PostData> bIb;
        com.baidu.tieba.pb.data.d pbData = this.hmT.getPbData();
        if (pbData != null && (bIb = pbData.bIb()) != null && !bIb.isEmpty()) {
            Iterator<PostData> it = bIb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i ceC = next.ceC();
                if (ceC != null && ceC.iFJ) {
                    Iterator<TbRichTextData> it2 = next.cev().asw().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.asM().getLink().equals(str)) {
                            return ceC.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> asw;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cev = arrayList.get(i2).cev();
            if (cev != null && (asw = cev.asw()) != null) {
                int size = asw.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (asw.get(i4) != null && asw.get(i4).getType() == 8) {
                        i3++;
                        if (asw.get(i4).asD().asR().equals(str) || asw.get(i4).asD().asS().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = asw.get(i4).asD().getWidth() * aR;
                            int height = asw.get(i4).asD().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hod = i4;
                            return cev;
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
            this.hms = str;
            if (this.hmD == null) {
                bJu();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hmD.gK(1).setVisibility(8);
            } else {
                this.hmD.gK(1).setVisibility(0);
            }
            this.hmD.abc();
            this.hmI = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        hideNetRefreshView(this.hmW.getView());
        bJM();
        if (this.hmT.aou()) {
            this.hmW.bMJ();
        }
    }

    private void bJM() {
        showLoadingView(this.hmW.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View anC = getLoadingView().anC();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anC.getLayoutParams();
        layoutParams.addRule(3, this.hmW.bNo().getId());
        anC.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcM() {
        if (this.eYR != null) {
            this.eYR.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf(int i) {
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
    public void wg(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.hmT.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hmT.getPbData();
            pbData.getForum().getName();
            String title = pbData.bHZ().getTitle();
            int i2 = this.hmT.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.BV(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hmT.bKR() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] ek = pbData.ek(getPageContext().getPageActivity());
                    str = ek[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = ek[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bJy() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").bJ(ImageViewerConfig.FORUM_ID, pbData.getForumId()).bJ("tid", pbData.getThreadId()).bJ("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.cbj = true;
                    dVar.cbq = z;
                    dVar.extData = this.hmT.bKR();
                    dVar.cbB = 3;
                    dVar.cbA = i;
                    dVar.fid = this.hmT.getForumId();
                    dVar.tid = this.hmT.bKR();
                    dVar.cbF = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hmT.getPbData().bHZ());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.cbB);
                    bundle.putInt("obj_type", dVar.cbF);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.D(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bIx() && !UtilHelper.isOnePlus6()) {
                                PbActivity.this.hmW.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.aSt().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hmT.bKR() + "?share=9105&fr=share&see_lz=" + i2;
            String[] ek2 = pbData.ek(getPageContext().getPageActivity());
            str = ek2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = ek2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bJy() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.cbj = true;
            dVar2.cbq = z;
            dVar2.extData = this.hmT.bKR();
            dVar2.cbB = 3;
            dVar2.cbA = i;
            dVar2.fid = this.hmT.getForumId();
            dVar2.tid = this.hmT.bKR();
            dVar2.cbF = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hmT.getPbData().bHZ());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.cbB);
            bundle2.putInt("obj_type", dVar2.cbF);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.D(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hmT != null && PbActivity.this.hmT.getPbData() != null && PbActivity.this.hmT.getPbData().bIx() && !UtilHelper.isOnePlus6()) {
                        PbActivity.this.hmW.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.aSt().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHZ() != null) {
            if (dVar.bHZ().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bHZ().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJN() {
        com.baidu.tbadk.util.aa.a(new com.baidu.tbadk.util.z<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.BW(PbActivity.this.hmT.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hmW.bNu();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ati() {
        if (this.cDj == null) {
            this.cDj = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKi */
                public LinearLayout makeObject() {
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
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.cDj;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bcN() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bbI() {
        if (this.hmT == null || this.hmT.getPbData() == null) {
            return null;
        }
        return this.hmT.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.abb() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.abb();
            int intValue = ((Integer) sparseArray.get(aq.hxA)).intValue();
            if (intValue == aq.hxB) {
                if (!this.eiW.cff()) {
                    this.hmW.bMG();
                    String str = (String) sparseArray.get(d.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eiW.CF(com.baidu.tbadk.core.util.ap.x(jSONArray));
                    }
                    this.eiW.a(this.hmT.getPbData().getForum().getId(), this.hmT.getPbData().getForum().getName(), this.hmT.getPbData().bHZ().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hxC || intValue == aq.hxE) {
                if (this.hmT.bLs() != null) {
                    this.hmT.bLs().wj(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hxC) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hnt);
        userMuteAddAndDelCustomMessage.setTag(this.hnt);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean zN(String str) {
        if (!StringUtils.isNull(str) && bc.cZ(getPageContext().getPageActivity())) {
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

    public void nm(boolean z) {
        this.hnf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJO() {
        ArrayList<PostData> bIb;
        int S;
        if (this.hmT == null || this.hmT.getPbData() == null || this.hmT.getPbData().bIb() == null || (S = com.baidu.tbadk.core.util.v.S((bIb = this.hmT.getPbData().bIb()))) == 0) {
            return "";
        }
        if (this.hmT.bLh()) {
            Iterator<PostData> it = bIb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cet() == 1) {
                    return next.getId();
                }
            }
        }
        int bMN = this.hmW.bMN();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bIb, bMN);
        if (postData == null || postData.YR() == null) {
            return "";
        }
        if (this.hmT.zR(postData.YR().getUserId())) {
            return postData.getId();
        }
        for (int i = bMN - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bIb, i);
            if (postData2 == null || postData2.YR() == null || postData2.YR().getUserId() == null) {
                break;
            } else if (this.hmT.zR(postData2.YR().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bMN + 1; i2 < S; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bIb, i2);
            if (postData3 == null || postData3.YR() == null || postData3.YR().getUserId() == null) {
                return "";
            }
            if (this.hmT.zR(postData3.YR().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.adD().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(zM(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hmT.getPbData().getForum().getId(), this.hmT.getPbData().getForum().getName(), this.hmT.getPbData().bHZ().getTid());
            }
            this.hmI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.ly(getResources().getString(d.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.ly(getResources().getString(d.j.make_sure_hide));
        }
        aVar.a(getResources().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hmT.bLr() != null) {
                    PbActivity.this.hmT.bLr().dD(j);
                }
            }
        });
        aVar.b(getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.dr(false);
        aVar.b(getPageContext());
        aVar.aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c zO(String str) {
        String str2;
        if (this.hmT.getPbData() == null || this.hmT.getPbData().bIb() == null || this.hmT.getPbData().bIb().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hmT.getPbData().bIb().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hmT.getPbData().bIb().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hmT.getPbData().bIb().get(i);
        if (postData.cev() == null || postData.cev().asw() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cev().asw().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.asD() != null) {
                    str2 = next.asD().asR();
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
        if (this.hmz) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hmz = false;
        } else if (bJP()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hmz) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hmz = false;
        } else if (bJP()) {
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
        if (pageStayDurationItem != null && this.hmT != null) {
            if (this.hmT.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hmT.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hmT.bKR(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bJP() {
        return (!this.hmx && this.hol == -1 && this.hom == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hoo = oVar;
            this.hmx = true;
            this.hmW.bMy();
            this.hmW.zZ(this.hon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJQ() {
        if (this.hoo != null) {
            if (this.hol == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hoo.getCartoonId(), this.hol, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJR() {
        if (this.hoo != null) {
            if (this.hom == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hoo.getCartoonId(), this.hom, 0)));
                finish();
            }
        }
    }

    public int bJS() {
        return this.hol;
    }

    public int bJT() {
        return this.hom;
    }

    private void bnY() {
        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null && this.hmT.getPbData().bHZ().ZL()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bJU() {
        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null && this.hmT.getPbData().bHZ().ZL()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bJV() {
        if (this.hmA) {
            this.hmN = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null && this.hmT.getPbData().bHZ().Yx() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hmT.getPbData().bHZ().Yx().getThreadId(), this.hmT.getPbData().bHZ().Yx().getTaskId(), this.hmT.getPbData().bHZ().Yx().getForumId(), this.hmT.getPbData().bHZ().Yx().getForumName(), this.hmT.getPbData().bHZ().YM(), this.hmT.getPbData().bHZ().YN())));
            this.hmz = true;
            finish();
        }
    }

    public String bJW() {
        return this.hmL;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bJX() {
        return this.hmS;
    }

    public void nn(boolean z) {
        this.hmM = z;
    }

    public boolean bJY() {
        if (this.hmT != null) {
            return this.hmT.bKT();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ly(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hnr).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hnr.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hnr).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hnr != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnr.getPageActivity());
            aVar.ly(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hnr).aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hmW.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnr.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.ly(this.hnr.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.ly(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hmW.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hnr).aaZ();
    }

    public void bKa() {
        if (this.hmT != null && this.hmT.getPbData() != null && this.hmT.getPbData().bHZ() != null && this.hmT.getPbData().bHZ().aab() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.gD(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hmT.getPbData().bHZ().aab().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(d.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.aaZ();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.Ab(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.hmW != null) {
            this.hmW.onConfigurationChanged(configuration);
        }
        if (this.hnc != null) {
            this.hnc.dismiss();
        }
    }

    public boolean bKb() {
        if (this.hmT != null) {
            return this.hmT.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hmT.getPbData().bIk().hkW;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).ceq().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).ceq().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).ceq().remove(i2);
                    list.get(i).ces();
                    z = true;
                    break;
                }
            }
            list.get(i).Cz(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.o(this.hmT.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bID().getId();
        List<PostData> list = this.hmT.getPbData().bIk().hkW;
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
                ArrayList<PostData> bIH = jVar.bIH();
                postData.zt(jVar.getTotalCount());
                if (postData.ceq() != null) {
                    postData.ceq().clear();
                    postData.ceq().addAll(bIH);
                }
            }
        }
        if (!this.hmT.getIsFromMark()) {
            this.hmW.o(this.hmT.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bIP() {
        return this.hmX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIQ() {
        if (this.hmT == null) {
            return false;
        }
        return this.hmT.bIQ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIR() {
        if (this.hmT != null) {
            return this.hmT.bIR();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIS() {
        if (this.hmT == null || this.hmT.getPbData() == null) {
            return 0;
        }
        return this.hmT.getPbData().bIl();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zI(String str) {
        return this.hmT != null && this.hmT.zR(str);
    }

    public void bKc() {
        if (this.hmW != null) {
            this.hmW.bMm();
            bcN();
        }
    }

    public PostData bIg() {
        return this.hmW.c(this.hmT.hsp, this.hmT.bKS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ax(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.isLinkThread()) {
                return 3;
            }
            if (bgVar.aad()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hnA != null && !this.hnA.isEmpty()) {
            int size = this.hnA.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hnA.get(i).onBackPressed()) {
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
            if (this.hnA == null) {
                this.hnA = new ArrayList();
            }
            if (!this.hnA.contains(aVar)) {
                this.hnA.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hnA == null) {
                this.hnA = new ArrayList();
            }
            if (!this.hnA.contains(aVar)) {
                this.hnA.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hnA != null) {
            this.hnA.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKd() {
        if (this.hmT != null && !com.baidu.tbadk.core.util.ap.isEmpty(this.hmT.bKR())) {
            com.baidu.tbadk.BdToken.c.TZ().f(com.baidu.tbadk.BdToken.b.bqD, com.baidu.adp.lib.g.b.d(this.hmT.bKR(), 0L));
        }
    }
}
