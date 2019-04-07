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
    private com.baidu.adp.lib.e.b<TbImageView> bTU;
    private com.baidu.adp.lib.e.b<ImageView> cAu;
    private com.baidu.adp.lib.e.b<GifView> cAv;
    private com.baidu.adp.lib.e.b<TextView> cDj;
    private com.baidu.adp.lib.e.b<View> cDk;
    private com.baidu.adp.lib.e.b<LinearLayout> cDl;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDm;
    private com.baidu.tieba.f.b dLI;
    private VoiceManager eYD;
    private com.baidu.tieba.frs.profession.permission.c fci;
    private au fzF;
    public com.baidu.tbadk.core.util.aj gyx;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hmB;
    private View hmC;
    int hmE;
    private com.baidu.tieba.pb.pb.report.a hmH;
    public as hmO;
    private com.baidu.tbadk.core.dialog.g hmP;
    private com.baidu.tbadk.core.dialog.i hmQ;
    private boolean hmS;
    private com.baidu.tieba.tbadkCore.data.f hmW;
    private com.baidu.tbadk.editortools.pb.f hmX;
    private com.baidu.tbadk.editortools.pb.d hmY;
    private String hmf;
    private com.baidu.tieba.pb.pb.main.b.b hml;
    private boolean hnP;
    private com.baidu.tieba.frs.profession.permission.c hna;
    private EmotionImageData hnb;
    private com.baidu.adp.base.e hne;
    private com.baidu.tbadk.core.view.e hnf;
    private BdUniqueId hng;
    private Runnable hnh;
    private com.baidu.adp.widget.ImageView.a hni;
    private String hnj;
    private TbRichTextMemeInfo hnk;
    private List<a> hnn;
    private String hoa;
    private com.baidu.tbadk.core.data.o hob;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLp));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLp));
        }
    };
    private static final b.a hnV = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // com.baidu.tieba.f.b.a
        public void it(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bIL();
            } else {
                com.baidu.tieba.pb.a.b.bIK();
            }
        }
    };
    private boolean hmk = false;
    private boolean hmm = false;
    private boolean hmn = false;
    private boolean gPR = false;
    private boolean hmo = true;
    private int hmp = 0;
    private com.baidu.tbadk.core.dialog.b hmq = null;
    private long eCw = -1;
    private long cqx = 0;
    private long hmr = 0;
    private long createTime = 0;
    private long cqp = 0;
    private boolean hms = false;
    private com.baidu.tbadk.o.b hmt = null;
    private long hmu = 0;
    private boolean hmv = false;
    private long hmw = 0;
    private String ckk = null;
    private boolean hmx = false;
    private boolean isFullScreen = false;
    private String hmy = "";
    private boolean hmz = true;
    private boolean hmA = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hmD = new int[2];
    private PbInterviewStatusView.a hmF = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.hmJ.nN(!PbActivity.this.hmz);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hmG != null && PbActivity.this.hmG.UY()) {
                        PbActivity.this.bJG();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hmG = null;
    private com.baidu.tbadk.baseEditMark.a hmI = null;
    private ForumManageModel eiI = null;
    private com.baidu.tbadk.coreExtra.model.a bKA = null;
    private ShareSuccessReplyToServerModel fot = null;
    private aq hmJ = null;
    public final com.baidu.tieba.pb.pb.main.b.a hmK = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hmL = false;
    private boolean hmM = false;
    private boolean hmN = false;
    private boolean hmR = false;
    private boolean hmT = false;
    private boolean hmU = false;
    private boolean hmV = false;
    private boolean hmZ = false;
    public boolean hnc = false;
    private com.baidu.tbadk.editortools.pb.c ckn = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void amo() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b cko = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amn() {
            if (PbActivity.this.hmO == null || PbActivity.this.hmO.bNw() == null || !PbActivity.this.hmO.bNw().cnY()) {
                return !PbActivity.this.vZ(com.baidu.tbadk.core.util.aj.bKv);
            }
            PbActivity.this.showToast(PbActivity.this.hmO.bNw().coa());
            if (PbActivity.this.hmY != null && (PbActivity.this.hmY.amC() || PbActivity.this.hmY.amD())) {
                PbActivity.this.hmY.a(false, PbActivity.this.hmO.bNz());
            }
            PbActivity.this.hmO.nZ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hnd = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amn() {
            if (PbActivity.this.hmO == null || PbActivity.this.hmO.bNx() == null || !PbActivity.this.hmO.bNx().cnY()) {
                return !PbActivity.this.vZ(com.baidu.tbadk.core.util.aj.bKw);
            }
            PbActivity.this.showToast(PbActivity.this.hmO.bNx().coa());
            if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.bMl() != null && PbActivity.this.hmJ.bMl().bKF() != null && PbActivity.this.hmJ.bMl().bKF().amD()) {
                PbActivity.this.hmJ.bMl().bKF().a(PbActivity.this.hmO.bNz());
            }
            PbActivity.this.hmO.oa(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean eZs = false;
    private int hnl = 0;
    private int hnm = -1;
    private final a hno = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.bMl() != null) {
                s bMl = PbActivity.this.hmJ.bMl();
                if (bMl.bKD()) {
                    bMl.bKC();
                    return true;
                }
            }
            if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.bNe()) {
                PbActivity.this.hmJ.bNf();
                return true;
            }
            return false;
        }
    };
    private r.a hnp = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
    };
    private AddExperiencedModel.a eZC = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bJK();
        }
    };
    private final z.a hnq = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hmJ.showToast(str);
            }
        }
    };
    private final CustomMessageListener hnr = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmG != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hmY != null) {
                    PbActivity.this.hmJ.nS(PbActivity.this.hmY.amw());
                }
                PbActivity.this.hmJ.bMm();
                PbActivity.this.hmJ.bMX();
            }
        }
    };
    CustomMessageListener eZV = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hmG.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hmJ != null && PbActivity.this.hmG != null) {
                    PbActivity.this.hmJ.d(PbActivity.this.hmG.getPbData(), PbActivity.this.hmG.bKP(), PbActivity.this.hmG.getRequestType());
                }
                if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.bMC() != null) {
                    PbActivity.this.hmJ.bMC().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hns = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hmJ != null) {
                    if (booleanValue) {
                        PbActivity.this.hmJ.bul();
                    } else {
                        PbActivity.this.hmJ.buk();
                    }
                }
            }
        }
    };
    private CustomMessageListener hnt = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hmY != null) {
                    PbActivity.this.hmJ.nS(PbActivity.this.hmY.amw());
                }
                PbActivity.this.hmJ.nU(false);
            }
        }
    };
    private CustomMessageListener hnu = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener hnv = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.bMC() != null) {
                PbActivity.this.hmJ.bMC().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gct = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener brs = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hmn) {
                PbActivity.this.bKa();
            }
        }
    };
    private h.a hnw = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void n(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.wb(2);
                aj.bLX().reset();
                PbActivity.this.hmG.bLk();
                boolean z2 = false;
                ArrayList<PostData> bHY = PbActivity.this.hmG.getPbData().bHY();
                if (bHY != null) {
                    Iterator<PostData> it = bHY.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cey().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hmJ.n(PbActivity.this.hmG.getPbData());
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
    private View.OnClickListener ckY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.ckk);
        }
    };
    private CustomMessageListener hnx = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmG.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hmG.bLb() != null && PbActivity.this.hmG.bLb().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hmJ.a(aaVar.sendCount, PbActivity.this.hmG.getPbData(), PbActivity.this.hmG.bKP(), PbActivity.this.hmG.getRequestType());
                    }
                    if (pbData.bHY() != null && pbData.bHY().size() >= 1 && pbData.bHY().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bHY().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.hmG.bKO(), 0L);
                        if (d2 == aaVar.postId && d3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cex = pbData.bHY().get(0).cex();
                            if (cex == null) {
                                cex = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> XJ = cex.XJ();
                            if (XJ == null) {
                                XJ = new ArrayList<>();
                            }
                            XJ.add(0, aVar);
                            cex.setTotal(aaVar.sendCount + cex.getTotal());
                            cex.m(XJ);
                            pbData.bHY().get(0).a(cex);
                            PbActivity.this.hmJ.bMC().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener frv = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                PbActivity.this.zI((String) customResponsedMessage.getData());
                PbActivity.this.hmG.bLh();
                if (PbActivity.this.hmJ.bMC() != null) {
                    PbActivity.this.hmJ.n(PbActivity.this.hmG.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hny = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bNG()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hnz = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ac(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.T(list) && PbActivity.this.hmJ != null) {
                PbActivity.this.hmJ.dA(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hnA = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
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
    private boolean hnB = false;
    private PraiseModel hnC = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void rd(String str) {
            PbActivity.this.hnB = false;
            if (PbActivity.this.hnC != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmG.getPbData();
                if (pbData.bHW().YA().getIsLike() == 1) {
                    PbActivity.this.qT(0);
                } else {
                    PbActivity.this.qT(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bHW()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void ah(int i, String str) {
            PbActivity.this.hnB = false;
            if (PbActivity.this.hnC != null && str != null) {
                if (AntiHelper.aD(i, str)) {
                    AntiHelper.aU(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hnD = 0;
    private boolean hnE = true;
    private b.a hnF = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void no(boolean z) {
            PbActivity.this.nn(z);
            if (PbActivity.this.hmJ.bNk() != null && z) {
                PbActivity.this.hmJ.nN(false);
            }
            PbActivity.this.hmJ.nP(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().bYB != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().bYB, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLp));
                        }
                    } else if (updateAttentionMessage.getData().Jy) {
                        if (PbActivity.this.bId().YO() != null && PbActivity.this.bId().YO().getGodUserData() != null) {
                            PbActivity.this.bId().YO().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().YO() != null) {
                            PbActivity.this.hmG.getPbData().bHW().YO().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a dKZ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hmJ.aMt();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.wc(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.bkX();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(d.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c cca = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            PbActivity.this.bJq();
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
                    if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.bJo() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").bJ(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.hmK != null && PbActivity.this.hmK.fzX != null) {
                            PbActivity.this.hmK.fzX.onClick(view);
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
            if (PbActivity.this.hmY != null) {
                PbActivity.this.hmJ.nS(PbActivity.this.hmY.amw());
            }
            PbActivity.this.hmJ.bMm();
            PbActivity.this.hmJ.bMX();
            return true;
        }
    });
    private CustomMessageListener hnG = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hng) {
                PbActivity.this.hmJ.aMt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmG.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bIj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hnf.i(PbActivity.this.hne.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hne.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.oX(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bJW();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hne.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.hnf.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hnH = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hng) {
                PbActivity.this.hmJ.aMt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hnf.i(PbActivity.this.hne.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hne.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.hnf.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hnI = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hng) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hmJ.aMt();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.iUd;
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
                    PbActivity.this.hmJ.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hnJ = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmJ.bMn() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bJq();
            }
        }
    };
    private CustomMessageListener fac = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.eZs = true;
                }
            }
        }
    };
    public a.b hbb = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bcL();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hmG.getPageData();
            int pageNum = PbActivity.this.hmJ.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.XC()) {
                PbActivity.this.hmJ.bMX();
                PbActivity.this.wb(2);
                PbActivity.this.bcK();
                PbActivity.this.hmJ.bMG();
                if (com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.hmG.wj(PbActivity.this.hmJ.getPageNum());
                    if (PbActivity.this.hml != null) {
                        PbActivity.this.hml.showFloatingView();
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
    public final View.OnClickListener faL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
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
                    if (view == PbActivity.this.hmJ.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hmG.ny(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hmJ.bMH();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLS()) {
                        if (view == PbActivity.this.hmJ.hvA.csD) {
                            if (PbActivity.this.hmJ.nR(PbActivity.this.hmG.bKU())) {
                                PbActivity.this.bcK();
                                return;
                            }
                            PbActivity.this.hmo = false;
                            PbActivity.this.hmm = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hmJ.hvA.csD);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hmJ.bME() && (PbActivity.this.hmJ.hvA.bNT() == null || (view != PbActivity.this.hmJ.hvA.bNT().bLR() && view != PbActivity.this.hmJ.hvA.bNT().bLP()))) {
                            if (view == PbActivity.this.hmJ.bNa()) {
                                if (PbActivity.this.hmG != null) {
                                    com.baidu.tbadk.browser.a.ar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmG.getPbData().bHW().YN().getLink());
                                }
                            } else if (view != PbActivity.this.hmJ.hvA.hAz) {
                                if (view == PbActivity.this.hmJ.hvA.hAA) {
                                    if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                                        ArrayList<PostData> bHY = PbActivity.this.hmG.getPbData().bHY();
                                        if ((bHY == null || bHY.size() <= 0) && PbActivity.this.hmG.bKP()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").bJ("tid", PbActivity.this.hmG.bKO()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId()));
                                        if (!PbActivity.this.hmJ.bNp()) {
                                            PbActivity.this.hmJ.bMm();
                                        }
                                        PbActivity.this.bJy();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == d.g.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.kY()) {
                                        PbActivity.this.hmJ.ns(true);
                                        PbActivity.this.hmJ.bMm();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hmJ.bul();
                                            PbActivity.this.bcK();
                                            PbActivity.this.hmJ.bMG();
                                            PbActivity.this.hmG.zP(PbActivity.this.bJL());
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.wb(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(d.j.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != d.g.pb_editor_tool_collection) {
                                    if ((PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLO()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                        if (PbActivity.this.hmJ.hvA.bNT() != null && view == PbActivity.this.hmJ.hvA.bNT().getCancelView()) {
                                            PbActivity.this.hmJ.hvA.Qi();
                                        } else if (view.getId() != d.g.pb_editor_tool_share && view.getId() != d.g.share_num_container) {
                                            if (PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLM()) {
                                                if ((PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLU()) && view.getId() != d.g.pb_sort) {
                                                    if (PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLN()) {
                                                        if (PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLV()) {
                                                            if (PbActivity.this.hmJ.bNk() == view) {
                                                                if (PbActivity.this.hmJ.bNk().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmG.getPbData();
                                                                    if (pbData != null && pbData.bHW() != null && pbData.bHW().Yu() != null) {
                                                                        String Yl = pbData.bHW().Yu().Yl();
                                                                        if (StringUtils.isNull(Yl)) {
                                                                            Yl = pbData.bHW().Yu().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").bJ(VideoPlayActivityConfig.OBJ_ID, Yl));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.dX("c10725", null);
                                                                }
                                                                PbActivity.this.bJS();
                                                            } else if (PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLT()) {
                                                                if (PbActivity.this.hmJ.hvA.bNT() != null && view == PbActivity.this.hmJ.hvA.bNT().bLQ()) {
                                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hmJ.c(PbActivity.this.hmG.getPbData(), PbActivity.this.hmG.bKP(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                PbActivity.this.hmJ.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hmJ.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hmJ.hvA.Qi();
                                                                    } else {
                                                                        PbActivity.this.showToast(d.j.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.sub_pb_more || view.getId() == d.g.sub_pb_item || view.getId() == d.g.pb_floor_reply_more || view.getId() == d.g.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hmG != null && view.getId() == d.g.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar.bJ("tid", PbActivity.this.hmG.bKO());
                                                                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
                                                                        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar.T("obj_locate", 4);
                                                                        TiebaStatic.log(amVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hmG.getPbData() != null) {
                                                                            PbActivity.this.hmJ.bMX();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(d.g.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(d.g.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.ceB() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                }
                                                                                if (postData.iGG != null) {
                                                                                    com.baidu.tbadk.core.util.am adg = postData.iGG.adg();
                                                                                    adg.delete("obj_locate");
                                                                                    if (view.getId() == d.g.new_sub_pb_list_richText) {
                                                                                        adg.T("obj_locate", 6);
                                                                                    } else if (view.getId() == d.g.pb_floor_reply_more) {
                                                                                        adg.T("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(adg);
                                                                                }
                                                                                String bKO = PbActivity.this.hmG.bKO();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hmG.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hmG.getPbData().bIi();
                                                                                }
                                                                                PbActivity.this.bcK();
                                                                                if (view.getId() == d.g.replybtn) {
                                                                                    c zN = PbActivity.this.zN(id);
                                                                                    if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && zN != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKO, id, "pb", true, null, true, null, i4, postData.bOL(), PbActivity.this.hmG.getPbData().getAnti(), false, postData.YO().getIconInfo()).addBigImageData(zN.hoD, zN.hoE, zN.hoF, zN.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hmG.bLw());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hmG.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c zN2 = PbActivity.this.zN(id);
                                                                                    if (postData != null && PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && zN2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKO, id, "pb", true, null, false, null, i4, postData.bOL(), PbActivity.this.hmG.getPbData().getAnti(), false, postData.YO().getIconInfo()).addBigImageData(zN2.hoD, zN2.hoE, zN2.hoF, zN2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hmG.bLw());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hmG.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.pb_post_reply_count) {
                                                                    if (PbActivity.this.hmG != null) {
                                                                        com.baidu.tbadk.core.util.am amVar2 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar2.bJ("tid", PbActivity.this.hmG.bKO());
                                                                        amVar2.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
                                                                        amVar2.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar2.T("obj_locate", 5);
                                                                        TiebaStatic.log(amVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                                                                                    String bKO2 = PbActivity.this.hmG.bKO();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hmG.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hmG.getPbData().bIi();
                                                                                    }
                                                                                    c zN3 = PbActivity.this.zN(id2);
                                                                                    if (zN3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKO2, id2, "pb", true, null, false, null, i5, postData2.bOL(), PbActivity.this.hmG.getPbData().getAnti(), false, postData2.YO().getIconInfo()).addBigImageData(zN3.hoD, zN3.hoE, zN3.hoF, zN3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hmG.bLw());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hmG.getFromForumId());
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
                                                                    if (PbActivity.this.hmG != null) {
                                                                        com.baidu.tbadk.core.util.am amVar3 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar3.bJ("tid", PbActivity.this.hmG.bKO());
                                                                        amVar3.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
                                                                        amVar3.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar3.T("obj_locate", 6);
                                                                        TiebaStatic.log(amVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.bJn().bMk() != null && postData3.YO() != null && postData3.cep() != 1) {
                                                                                    if (PbActivity.this.bJn().bMl() != null) {
                                                                                        PbActivity.this.bJn().bMl().bKB();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                                                                    jVar.a(PbActivity.this.hmG.getPbData().getForum());
                                                                                    jVar.ai(PbActivity.this.hmG.getPbData().bHW());
                                                                                    jVar.e(postData3);
                                                                                    PbActivity.this.bJn().bMk().d(jVar);
                                                                                    PbActivity.this.bJn().bMk().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.YO().getUserId(), "");
                                                                                    if (PbActivity.this.hmY != null) {
                                                                                        PbActivity.this.hmJ.nS(PbActivity.this.hmY.amw());
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
                                                                } else if (view != PbActivity.this.hmJ.bJi()) {
                                                                    if (view == PbActivity.this.hmJ.hvA.bNU()) {
                                                                        PbActivity.this.hmJ.bMN();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == d.g.pb_u9_text_view) {
                                                                            if (PbActivity.this.checkUpIsLogin() && (blVar = (bl) view.getTag()) != null && !StringUtils.isNull(blVar.aaM())) {
                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.adA().c(PbActivity.this.getPageContext(), new String[]{blVar.aaM()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").bJ("tid", PbActivity.this.hmG.hrG));
                                                                                    }
                                                                                    if (PbActivity.this.hmQ == null) {
                                                                                        PbActivity.this.hmQ = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                                                                                        PbActivity.this.hmQ.a(PbActivity.this.hnU);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cm(view);
                                                                                    if (!PbActivity.this.cm(view) || PbActivity.this.hni == null || !PbActivity.this.hni.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hmQ);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(fVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cer() != null && postData4.cer().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hmQ);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(d.g.tag_clip_board, postData4);
                                                                                            fVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(fVar5);
                                                                                        }
                                                                                        PbActivity.this.fPE = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hmG.getPbData().UY()) {
                                                                                        String UX = PbActivity.this.hmG.getPbData().UX();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(UX) && UX.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hmQ);
                                                                                            } else {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hmQ);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(d.g.tag_clip_board, PbActivity.this.fPE);
                                                                                            sparseArray6.put(d.g.tag_is_subpb, false);
                                                                                            fVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(fVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hmQ);
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
                                                                                                    if (!ap.m(PbActivity.this.fPE)) {
                                                                                                        nj = PbActivity.this.nj(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        nj = false;
                                                                                                    }
                                                                                                    if (nj) {
                                                                                                        com.baidu.tbadk.core.dialog.f fVar7 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hmQ);
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
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hmQ);
                                                                                                        fVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(d.g.tag_should_delete_visible, false);
                                                                                                        fVar2 = null;
                                                                                                    }
                                                                                                    fVar3 = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hmQ);
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
                                                                                                    if (PbActivity.this.hmG.getPbData().bIi() == 1002 && !z3) {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hmQ);
                                                                                                    } else {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hmQ);
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
                                                                                            PbActivity.this.hmQ.P(arrayList);
                                                                                            PbActivity.this.hmP = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hmQ.abh());
                                                                                            PbActivity.this.hmP.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(d.g.tag_clip_board, PbActivity.this.fPE);
                                                                                    sparseArray62.put(d.g.tag_is_subpb, false);
                                                                                    fVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(fVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hmQ.P(arrayList);
                                                                                    PbActivity.this.hmP = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hmQ.abh());
                                                                                    PbActivity.this.hmP.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_act_btn) {
                                                                            if (PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), PbActivity.this.hmG.getPbData().bHW().getActUrl());
                                                                                if (PbActivity.this.hmG.getPbData().bHW().Zy() != 1) {
                                                                                    if (PbActivity.this.hmG.getPbData().bHW().Zy() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.lottery_tail) {
                                                                            if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()).bJ("tid", PbActivity.this.hmG.getPbData().getThreadId()).bJ("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hmG.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hmJ.setSelection(0);
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
                                                                                PbActivity.this.hmJ.bMm();
                                                                            }
                                                                        } else if (id3 == d.g.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bJv() == 1 && PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()).bJ("tid", PbActivity.this.hmG.getPbData().getThreadId()).bJ("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bJv() == 1 && PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()).bJ("tid", PbActivity.this.hmG.getPbData().getThreadId()).bJ("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.manga_prev_btn) {
                                                                            PbActivity.this.bJN();
                                                                        } else if (id3 == d.g.manga_next_btn) {
                                                                            PbActivity.this.bJO();
                                                                        } else if (id3 == d.g.yule_head_img_img) {
                                                                            if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bIp() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hmG.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").bJ(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                ba.adA().c(PbActivity.this.getPageContext(), new String[]{pbData2.bIp().bIw()});
                                                                            }
                                                                        } else if (id3 == d.g.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bIp() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hmG.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                ba.adA().c(PbActivity.this.getPageContext(), new String[]{pbData3.bIp().bIw()});
                                                                            }
                                                                        } else if (PbActivity.this.hmJ.hvA.bNT() != null && view == PbActivity.this.hmJ.hvA.bNT().bLW()) {
                                                                            if (PbActivity.this.hmG == null || PbActivity.this.hmG.getPbData() == null || PbActivity.this.hmG.getPbData().bHW() == null) {
                                                                                PbActivity.this.hmJ.hvA.Qi();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.lo()) {
                                                                                PbActivity.this.showToast(d.j.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hmG.getPbData().bHW().Yv() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmG.bKO(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).abe();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").T("obj_locate", PbActivity.this.aw(PbActivity.this.hmG.getPbData().bHW())).bJ("tid", PbActivity.this.hmG.getPbData().bHW().getTid()).T("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == d.g.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hnl >= 0) {
                                                                                if (PbActivity.this.hmG != null) {
                                                                                    PbActivity.this.hmG.bLx();
                                                                                }
                                                                                if (PbActivity.this.hmJ.bMC() != null) {
                                                                                    PbActivity.this.hmJ.bMC().a(PbActivity.this.hmG.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hmJ.getListView().setSelection(PbActivity.this.hmG.bLA());
                                                                                PbActivity.this.hnl = 0;
                                                                                if (PbActivity.this.hmG != null) {
                                                                                    PbActivity.this.hmG.bU(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == d.g.thread_info_commont_container) {
                                                                            PbActivity.this.bJs();
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
                                                                            if (PbActivity.this.hmJ.getListView() != null && PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hmJ.getListView().getFirstVisiblePosition();
                                                                                int top = PbActivity.this.hmJ.getListView().getChildAt(0).getTop();
                                                                                boolean bIu = PbActivity.this.hmG.getPbData().bIu();
                                                                                boolean z8 = PbActivity.this.hmJ.hvu != null && PbActivity.this.hmJ.hvu.bPb();
                                                                                boolean bMU = PbActivity.this.hmJ.bMU();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bIu && PbActivity.this.hmJ.hvu != null && PbActivity.this.hmJ.hvu.aBz() != null) {
                                                                                    int aO = ((int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d)) - PbActivity.this.hmJ.hvu.bPc();
                                                                                    z9 = firstVisiblePosition == 0 && (top == aO || top == PbActivity.this.hmJ.hvu.aBz().getHeight() - PbActivity.this.hmJ.hvu.bPc());
                                                                                    i7 = aO;
                                                                                }
                                                                                if ((PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().YF() <= 0) || (bMU && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bJs();
                                                                                        if (PbActivity.this.hmG.getPbData().bHW().YO() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmG.hrG).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hmG.getPbData().bHW().YO().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int aQ = (int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d);
                                                                                    if (bIu) {
                                                                                        if (PbActivity.this.hmJ.hxj != null && PbActivity.this.hmJ.hxj.hyr != null && PbActivity.this.hmJ.hxj.hyr.getView() != null) {
                                                                                            if (PbActivity.this.hmJ.hxj.hyr.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bJB();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hmJ.hvu.aBz() != null) {
                                                                                                    i8 = PbActivity.this.hmJ.hvu.aBz().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hmJ.hxj.hyr.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hmJ.bMu() != null) {
                                                                                        z10 = PbActivity.this.hmJ.bMu().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hmJ.hxj != null && PbActivity.this.hmJ.hxj.hyr != null && PbActivity.this.hmJ.hxj.hyr.getView() != null && PbActivity.this.hmJ.hxj.hyr.getView().getParent() != null && PbActivity.this.hmJ.hvA != null && PbActivity.this.hmJ.hvA.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hmJ.hxj.hyr.getView().getTop() - PbActivity.this.hmJ.hvA.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bMU) {
                                                                                        int bJB = PbActivity.this.bJB();
                                                                                        if (PbActivity.this.bJA() != -1) {
                                                                                            bJB--;
                                                                                        }
                                                                                        int h = com.baidu.adp.lib.util.l.h(PbActivity.this, d.e.tbds116);
                                                                                        if (bJB < 0) {
                                                                                            i2 = PbActivity.this.hmJ.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.S(PbActivity.this.hmJ.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bJB;
                                                                                            i3 = h;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bIu || PbActivity.this.hmJ.hvu.aBz() == null) {
                                                                                            if (PbActivity.this.hmJ.hvA != null && PbActivity.this.hmJ.hvA.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hmJ.hvA.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hmJ.hvu.aBz().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hmJ.hxj == null || PbActivity.this.hmJ.hxj.hyr == null || PbActivity.this.hmJ.hxj.hyr.getView() == null || PbActivity.this.hmJ.hxj.hyr.getView().getParent() == null) {
                                                                                            PbActivity.this.hmJ.getListView().setSelectionFromTop(i2, i3 + aQ);
                                                                                            PbActivity.this.hmJ.getListView().smoothScrollBy(aQ, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hmJ.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hmJ.getListView().smoothScrollBy(PbActivity.this.hmJ.hxj.hyr.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-aQ))) {
                                                                                        PbActivity.this.hmJ.getListView().setSelectionFromTop(0, i7 - aQ);
                                                                                        PbActivity.this.hmJ.getListView().smoothScrollBy(-aQ, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hmJ.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().YO() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmG.hrG).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hmG.getPbData().bHW().YO().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_nav_title_forum_image || id3 == d.g.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(PbActivity.this.hmG.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hmG.bLw() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hmG.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar4 = new com.baidu.tbadk.core.util.am("c13401");
                                                                                amVar4.bJ("tid", PbActivity.this.hmG.bKO());
                                                                                amVar4.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
                                                                                amVar4.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hmG.bLw() == 3 && PbActivity.this.bIN() && PbActivity.this.hmG.getPbData() != null && com.baidu.tbadk.core.util.v.T(PbActivity.this.hmG.getPbData().bIr())) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(bgVar.YT(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
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
                                                                            if (PbActivity.this.hmG != null) {
                                                                                com.baidu.tbadk.core.util.am amVar6 = new com.baidu.tbadk.core.util.am("c13398");
                                                                                amVar6.bJ("tid", PbActivity.this.hmG.bKO());
                                                                                amVar6.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
                                                                                amVar6.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                amVar6.T("obj_locate", 2);
                                                                                TiebaStatic.log(amVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.hmG.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.hmG.bKO(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hmG.getPbData().bHW().Zi())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.kY()) {
                                                                PbActivity.this.hmJ.bMX();
                                                                SparseArray<Object> c3 = PbActivity.this.hmJ.c(PbActivity.this.hmG.getPbData(), PbActivity.this.hmG.bKP(), 1);
                                                                if (c3 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmG.getPbData().getForum().getId(), PbActivity.this.hmG.getPbData().getForum().getName(), PbActivity.this.hmG.getPbData().bHW().getId(), String.valueOf(PbActivity.this.hmG.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_name_show), (String) c3.get(d.g.tag_forbid_user_post_id), (String) c3.get(d.g.tag_forbid_user_portrait))));
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
                                                            PbActivity.this.hmJ.hvA.bNS();
                                                        }
                                                    } else if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bHW() != null) {
                                                        PbActivity.this.hmJ.hvA.Qi();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                        PbActivity.this.zK(PbActivity.this.hmG.getPbData().bHW().Ze());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hmJ.bMX();
                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hmG.bLf()));
                                                            return;
                                                        }
                                                        PbActivity.this.wb(2);
                                                        PbActivity.this.bcK();
                                                        PbActivity.this.hmJ.bMG();
                                                        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hmG.getPbData().hki == null || PbActivity.this.hmG.getPbData().hki.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(d.j.sort_type_new), PbActivity.this.getResources().getString(d.j.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hmG.getPbData().hki.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hmG.getPbData().hki.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hmG.getPbData().hki.get(i10).sort_name + PbActivity.this.getResources().getString(d.j.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        gVar.a(null, strArr, new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                                            @Override // com.baidu.tbadk.core.dialog.i.c
                                                            public void a(com.baidu.tbadk.core.dialog.i iVar, int i11, View view3) {
                                                                int i12 = 2;
                                                                gVar.dismiss();
                                                                if (PbActivity.this.hmG.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hmG.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hmG.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hmG.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != d.g.pb_sort ? 1 : 0).T("obj_type", i12));
                                                                if (PbActivity.this.hmG.getPbData().hki != null && PbActivity.this.hmG.getPbData().hki.size() > i11) {
                                                                    i11 = PbActivity.this.hmG.getPbData().hki.get(i11).sort_type.intValue();
                                                                }
                                                                boolean wo = PbActivity.this.hmG.wo(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hmG.bLf()));
                                                                if (wo) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hmJ.nJ(true);
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
                                                PbActivity.this.hmJ.bMX();
                                                if (PbActivity.this.bIX().getPbData().hkj != 2) {
                                                    if (PbActivity.this.hmG.getPageData() != null) {
                                                        PbActivity.this.hmJ.a(PbActivity.this.hmG.getPageData(), PbActivity.this.hbb);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(d.j.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (az.jK() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().YO() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmG.hrG).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()).T("obj_locate", 4).bJ("uid", PbActivity.this.hmG.getPbData().bHW().YO().getUserId()));
                                            }
                                            if (PbActivity.this.hmG != null) {
                                                com.baidu.tbadk.core.util.am amVar7 = new com.baidu.tbadk.core.util.am("c12386");
                                                amVar7.bJ("tid", PbActivity.this.hmG.bKO());
                                                amVar7.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                amVar7.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
                                                amVar7.T("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    amVar7.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(amVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.lo()) {
                                                if (PbActivity.this.hmG.getPbData() != null) {
                                                    ArrayList<PostData> bHY2 = PbActivity.this.hmG.getPbData().bHY();
                                                    if ((bHY2 != null && bHY2.size() > 0) || !PbActivity.this.hmG.bKP()) {
                                                        PbActivity.this.hmJ.bMX();
                                                        PbActivity.this.bcK();
                                                        PbActivity.this.wb(2);
                                                        if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bIp() != null && !StringUtils.isNull(PbActivity.this.hmG.getPbData().bIp().Xk(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                        if (az.jK()) {
                                                            PbActivity.this.wc(2);
                                                        } else {
                                                            PbActivity.this.hmJ.showLoadingDialog();
                                                            PbActivity.this.hmG.bLr().m(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hmJ.bMX();
                                        if (PbActivity.this.hmJ.hvA.bNT() != null && view == PbActivity.this.hmJ.hvA.bNT().bLO() && !PbActivity.this.hmJ.bNp()) {
                                            PbActivity.this.hmJ.bMm();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bcK();
                                            PbActivity.this.hmJ.bMG();
                                            if (view.getId() == d.g.floor_owner_reply) {
                                                u = PbActivity.this.hmG.u(true, PbActivity.this.bJL());
                                            } else {
                                                u = view.getId() == d.g.reply_title ? PbActivity.this.hmG.u(false, PbActivity.this.bJL()) : PbActivity.this.hmG.zP(PbActivity.this.bJL());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hmJ.ns(true);
                                                PbActivity.this.hmJ.bul();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hmJ.nJ(true);
                                            }
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.wb(2);
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
                                    PbActivity.this.hmJ.bMX();
                                    if (PbActivity.this.wa(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.hmG.wp(PbActivity.this.hmJ.bML()) != null) {
                                        PbActivity.this.bJF();
                                        if (PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().YO() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmG.hrG).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId()).T("obj_locate", 3).bJ("uid", PbActivity.this.hmG.getPbData().bHW().YO().getUserId()));
                                        }
                                        if (PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().YO() != null && PbActivity.this.hmG.getPbData().bHW().YO().getUserId() != null && PbActivity.this.hmI != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hmG.hrG).T("obj_locate", 1).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hmG.getPbData().bHW().YO().getUserId()).T("obj_type", PbActivity.this.hmI.UY() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hmG.getPbData())));
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
                                if (PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().ZI() && PbActivity.this.hmG.getPbData().bHW().Zf() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.hmG.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hmG.bIO()) && PbActivity.this.hmG.getAppealInfo() != null) {
                                        name = PbActivity.this.hmG.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hmG.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bIO = PbActivity.this.hmG.bIO();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hmG.bKQ() && bIO != null && bIO.equals(name)) {
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
                            if (PbActivity.this.hmG.getPbData() != null) {
                                if ((PbActivity.this.hmG.getPbData().bIi() == 1 || PbActivity.this.hmG.getPbData().bIi() == 3) && !PbActivity.this.eiI.cfb()) {
                                    PbActivity.this.hmJ.bMX();
                                    int i11 = 0;
                                    if (PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLP()) {
                                        if (PbActivity.this.hmJ.hvA.bNT() == null || view != PbActivity.this.hmJ.hvA.bNT().bLR()) {
                                            if (view == PbActivity.this.hmJ.bME()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hmG.getPbData().bHW().YK() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hmG.getPbData().bHW().YJ() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hmG.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hmG.getPbData().bHW().getId();
                                    PbActivity.this.hmJ.bMD();
                                    PbActivity.this.eiI.a(id4, name2, id5, i11, PbActivity.this.hmJ.bMF());
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
                        PbActivity.this.hmJ.bMX();
                        PbActivity.this.bcK();
                        PbActivity.this.hmJ.bMG();
                        PbActivity.this.hmJ.showLoadingDialog();
                        if (PbActivity.this.hmJ.bMu() != null) {
                            PbActivity.this.hmJ.bMu().setVisibility(8);
                        }
                        PbActivity.this.hmG.wj(1);
                        if (PbActivity.this.hml != null) {
                            PbActivity.this.hml.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bJt = PbActivity.this.bJt();
                        if (!TextUtils.isEmpty(bJt)) {
                            ba.adA().c(PbActivity.this.getPageContext(), new String[]{bJt});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hmG != null) {
                    com.baidu.tbadk.core.util.am amVar8 = new com.baidu.tbadk.core.util.am("c13398");
                    amVar8.bJ("tid", PbActivity.this.hmG.bKO());
                    amVar8.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
                    amVar8.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar8.T("obj_locate", 1);
                    TiebaStatic.log(amVar8);
                }
                if (PbActivity.this.hmv) {
                    PbActivity.this.hmv = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.bJn().bMk() != null && postData5.YO() != null && postData5.cep() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bJn().bMl() != null) {
                                PbActivity.this.bJn().bMl().bKB();
                            }
                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                            jVar2.a(PbActivity.this.hmG.getPbData().getForum());
                            jVar2.ai(PbActivity.this.hmG.getPbData().bHW());
                            jVar2.e(postData5);
                            PbActivity.this.bJn().bMk().d(jVar2);
                            PbActivity.this.bJn().bMk().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.YO().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hmG.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hmY != null) {
                                PbActivity.this.hmJ.nS(PbActivity.this.hmY.amw());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d cku = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId());
                }
                if (PbActivity.this.hmG != null) {
                    amVar.bJ("tid", PbActivity.this.hmG.bKO());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.bcK();
            PbActivity.this.hmJ.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.s.ap.apD() && PbActivity.this.bIX() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bIX().zS(postWriteCallBackData.getPostId());
                    PbActivity.this.hnl = PbActivity.this.hmJ.bMq();
                    if (PbActivity.this.hmG != null) {
                        PbActivity.this.hmG.bU(PbActivity.this.hnl, PbActivity.this.hmJ.bMr());
                    }
                }
                PbActivity.this.hmJ.bMX();
                PbActivity.this.hmO.bNv();
                if (PbActivity.this.hmY != null) {
                    PbActivity.this.hmJ.nS(PbActivity.this.hmY.amw());
                }
                PbActivity.this.hmJ.bMj();
                PbActivity.this.hmJ.nU(true);
                PbActivity.this.hmG.bLh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hmG.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmG.getPbData();
                            if (pbData != null && pbData.bHW() != null && pbData.bHW().YO() != null && (userId = pbData.bHW().YO().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.s.ap.apD() && PbActivity.this.hmG.bKY()) {
                                PbActivity.this.hmJ.bMG();
                            }
                        } else if (!com.baidu.tbadk.s.ap.apD() && PbActivity.this.hmG.bKY()) {
                            PbActivity.this.hmJ.bMG();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hmJ.n(PbActivity.this.hmG.getPbData());
                    }
                    if (PbActivity.this.hmG.bKT()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").bJ("tid", PbActivity.this.hmG.bKO()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hmY.amC() || PbActivity.this.hmY.amD()) {
                    PbActivity.this.hmY.a(false, postWriteCallBackData);
                }
                PbActivity.this.hmO.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gyx != null) {
                    PbActivity.this.gyx.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hnK = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getPbData().getForumId());
                }
                if (PbActivity.this.hmG != null) {
                    amVar.bJ("tid", PbActivity.this.hmG.bKO());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (PbActivity.this.hmO != null) {
                    PbActivity.this.hmO.bNu();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gyx != null) {
                    PbActivity.this.gyx.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hmO != null) {
                if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.bMl() != null && PbActivity.this.hmJ.bMl().bKF() != null && PbActivity.this.hmJ.bMl().bKF().amD()) {
                    PbActivity.this.hmJ.bMl().bKF().a(postWriteCallBackData);
                }
                PbActivity.this.hmO.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a hnL = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g js;
            if (!z || dVar == null || dVar.bIg() != null || com.baidu.tbadk.core.util.v.S(dVar.bHY()) >= 1) {
                PbActivity.this.gPR = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hmJ.bMI();
                if (dVar == null || !dVar.bIc()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hmJ.getView());
                }
                PbActivity.this.hmJ.buk();
                if (PbActivity.this.isFullScreen || PbActivity.this.hmJ.bNp()) {
                    PbActivity.this.hmJ.bNg();
                } else if (!PbActivity.this.hmJ.bNd()) {
                    PbActivity.this.hmJ.nU(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hmR = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hmJ.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hmJ.aOs();
                    if (dVar.bHW() != null && dVar.bHW().ZR() != null) {
                        PbActivity.this.a(dVar.bHW().ZR());
                    }
                    PbActivity.this.bJk();
                    if (PbActivity.this.hmY != null) {
                        PbActivity.this.hmJ.nS(PbActivity.this.hmY.amw());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bHY() != null && dVar.bHY().size() >= 1 && dVar.bHY().get(0) != null) {
                        PbActivity.this.hmG.zR(dVar.bHY().get(0).getId());
                    } else if (dVar.bIg() != null) {
                        PbActivity.this.hmG.zR(dVar.bIg().getId());
                    }
                    if (PbActivity.this.hmY != null) {
                        PbActivity.this.hmY.a(dVar.getAnti());
                        PbActivity.this.hmY.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hmY.a(PbActivity.this.hmG.bLb(), PbActivity.this.hmG.bKO(), PbActivity.this.hmG.bLt());
                        if (dVar.bHW() != null) {
                            PbActivity.this.hmY.eO(dVar.bHW().aag());
                        }
                    }
                    if (PbActivity.this.hmI != null) {
                        PbActivity.this.hmI.cZ(dVar.UY());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hmJ.nT(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hmJ.a(dVar, i2, i3, PbActivity.this.hmG.bKP(), i4, PbActivity.this.hmG.getIsFromMark());
                    PbActivity.this.hmJ.e(dVar, PbActivity.this.hmG.bKP());
                    PbActivity.this.hmJ.nQ(PbActivity.this.hmG.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.ckk = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.ckk) && PbActivity.this.hmY != null && PbActivity.this.hmY.alP() != null && (js = PbActivity.this.hmY.alP().js(6)) != null && !TextUtils.isEmpty(PbActivity.this.ckk)) {
                            ((View) js).setOnClickListener(PbActivity.this.ckY);
                        }
                    }
                    if (PbActivity.this.hmT) {
                        PbActivity.this.hmT = false;
                        final int bJA = PbActivity.this.bJA();
                        if (!dVar.bIu()) {
                            PbActivity.this.hmJ.wv(bJA);
                        } else {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bJA, aO);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hmU) {
                        PbActivity.this.hmU = false;
                        final int bJA2 = PbActivity.this.bJA();
                        final boolean z2 = bJA2 != -1;
                        if (!z2) {
                            bJA2 = PbActivity.this.bJB();
                        }
                        if (PbActivity.this.hmJ != null) {
                            if (!dVar.bIu()) {
                                PbActivity.this.hmJ.wv(bJA2);
                            } else {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bJA2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hmJ.setSelectionFromTop(bJA2, aO2);
                                            } else {
                                                PbActivity.this.hmJ.setSelectionFromTop(bJA2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hmJ.nV(true);
                            }
                        }
                    } else if (PbActivity.this.hmV) {
                        PbActivity.this.hmV = false;
                        PbActivity.this.hmJ.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hmJ.bMM();
                    }
                    PbActivity.this.hmG.a(dVar.getForum(), PbActivity.this.hny);
                    PbActivity.this.hmG.a(PbActivity.this.hnz);
                    if (PbActivity.this.gyx != null && dVar.bHW() != null && dVar.bHW().YO() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bHW().YO());
                        PbActivity.this.gyx.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hmR && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hmG != null && PbActivity.this.hmG.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hmG.getAppealInfo().hjC)) {
                                    PbActivity.this.hmJ.a(PbActivity.this.hmG.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hmJ.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hmJ.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                            }
                            PbActivity.this.hmJ.bNg();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hmG.bKO());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
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
                        PbActivity.this.hmJ.zV("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                            arrayList = PbActivity.this.hmG.getPbData().bHY();
                        }
                        if (com.baidu.tbadk.core.util.v.S(arrayList) != 0 && (com.baidu.tbadk.core.util.v.S(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cep() != 1)) {
                            PbActivity.this.hmJ.zV(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                        } else if (PbActivity.this.bJY()) {
                            PbActivity.this.hmJ.zW(PbActivity.this.getResources().getString(d.j.pb_no_host_reply));
                        } else {
                            PbActivity.this.hmJ.zW(PbActivity.this.getResources().getString(d.j.pb_no_replay));
                        }
                    }
                    PbActivity.this.hmJ.aeA();
                }
                PbActivity.this.cqx = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bIX().bKP() || PbActivity.this.bIX().getPbData().getPage().XI() != 0 || PbActivity.this.bIX().bLn()) {
                    PbActivity.this.hmZ = true;
                    return;
                }
                return;
            }
            PbActivity.this.hmG.wj(1);
            if (PbActivity.this.hml != null) {
                PbActivity.this.hml.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hmJ.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.o.m.apg().aph()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eCw : j;
                com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(i, z, responsedMessage, PbActivity.this.cqp, PbActivity.this.createTime, PbActivity.this.cqx, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cqp = 0L;
                if (iVar != null) {
                    iVar.apd();
                }
                if (z2) {
                    iVar.cqG = currentTimeMillis;
                    iVar.fe(true);
                }
                if (!z2 && PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bHW() != null) {
                    int threadType = PbActivity.this.hmG.getPbData().bHW().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmy, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmy, "from_frs")) {
                                com.baidu.tbadk.o.i iVar2 = new com.baidu.tbadk.o.i();
                                iVar2.jW(1000);
                                iVar2.cqI = currentTimeMillis;
                                iVar2.jX(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.o.d dVar = new com.baidu.tbadk.o.d();
                        dVar.pageType = 1;
                        dVar.jW(1005);
                        dVar.cqI = currentTimeMillis;
                        dVar.jX(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hnM = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bJw();
            }
        }
    };
    private final a.InterfaceC0221a hnN = new a.InterfaceC0221a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hmJ.bMI();
            if (z) {
                if (PbActivity.this.hmI != null) {
                    PbActivity.this.hmI.cZ(z2);
                }
                PbActivity.this.hmG.nA(z2);
                if (PbActivity.this.hmG.UY()) {
                    PbActivity.this.bJG();
                } else {
                    PbActivity.this.hmJ.n(PbActivity.this.hmG.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hmI != null && PbActivity.this.hmI.Vb() != null && PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().YO() != null) {
                        MarkData Vb = PbActivity.this.hmI.Vb();
                        MetaData YO = PbActivity.this.hmG.getPbData().bHW().YO();
                        if (Vb != null && YO != null) {
                            if (!com.baidu.tbadk.core.util.ap.equals(TbadkCoreApplication.getCurrentAccount(), YO.getUserId()) && !YO.hadConcerned()) {
                                PbActivity.this.b(YO);
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
            if (!PbActivity.this.vX(PbActivity.this.mLastScrollState) && PbActivity.this.vX(i)) {
                if (PbActivity.this.hmJ != null) {
                    PbActivity.this.hmJ.bMX();
                    if (PbActivity.this.hmY != null && !PbActivity.this.hmJ.bMn()) {
                        PbActivity.this.hmJ.nS(PbActivity.this.hmY.amw());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hmJ.bMm();
                    }
                }
                if (!PbActivity.this.hms) {
                    PbActivity.this.hms = true;
                    PbActivity.this.hmJ.bNc();
                }
            }
            PbActivity.this.hmJ.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hml != null) {
                PbActivity.this.hml.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hmt == null) {
                PbActivity.this.hmt = new com.baidu.tbadk.o.b();
                PbActivity.this.hmt.jW(1001);
            }
            if (i == 0) {
                PbActivity.this.hmt.aoX();
            } else {
                PbActivity.this.hmt.aoW();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.cdp().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bHY;
            if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmJ != null && PbActivity.this.hmJ.bMC() != null) {
                PbActivity.this.hmJ.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hml != null) {
                    PbActivity.this.hml.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hmG.bLj() && (bHY = PbActivity.this.hmG.getPbData().bHY()) != null && !bHY.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hmJ.bMC().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmG.getPbData();
                    if (pbData != null) {
                        if (pbData.bHZ() != null && pbData.bHZ().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bIa() != null && pbData.bIa().hasData()) {
                            headerCount--;
                        }
                        int size = bHY.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eiM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eiI.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hmG.bLh();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCt != 1002 || bVar.fCT) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hmJ.a(1, dVar.Id, dVar.iIn, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eiI.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hmJ.a(PbActivity.this.eiI.getLoadDataMode(), gVar.Id, gVar.iIn, false);
                        PbActivity.this.hmJ.at(gVar.iIq);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hmJ.a(PbActivity.this.eiI.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hnO = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final h.c cPw = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (PbActivity.this.bJM()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hmG.nz(true)) {
                PbActivity.this.hmJ.bMJ();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fsD = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hnP && PbActivity.this.bJM()) {
                PbActivity.this.bJO();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hmG.ny(false)) {
                    PbActivity.this.hmJ.bMH();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hmG.getPbData() != null) {
                    PbActivity.this.hmJ.bNb();
                }
                PbActivity.this.hnP = true;
            }
        }
    };
    private int hnQ = 0;
    private final TbRichTextView.h cAD = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bMC;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hmG != null) {
                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                        amVar.bJ("tid", PbActivity.this.hmG.bKO());
                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId());
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
                        PbActivity.this.hmC = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hoG) {
                        TbRichText bh = PbActivity.this.bh(str, i);
                        if (bh != null && PbActivity.this.hnQ >= 0 && PbActivity.this.hnQ < bh.ast().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bh.ast().get(PbActivity.this.hnQ));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hoD.size()) {
                                    break;
                                } else if (!cVar.hoD.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bh.getPostId() != 0 && (bMC = PbActivity.this.hmJ.bMC()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bMC.getDataList();
                                if (com.baidu.tbadk.core.util.v.S(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bh.getPostId() == com.baidu.adp.lib.g.b.d(((PostData) next).getId(), 0L)) {
                                            if (bh.getPostId() != com.baidu.adp.lib.g.b.d(PbActivity.this.hmG.bLt(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hmG.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.T(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hoE.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoF, cVar.lastId, PbActivity.this.hmG.bLe(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.m(rect);
                            createConfig.setIsHotSort(PbActivity.this.hmG.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hoD, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.T(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hoE.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoF, cVar.hoD.get(0), PbActivity.this.hmG.bLe(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hmG.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hmJ.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hnR = false;
    PostData fPE = null;
    private final b.InterfaceC0225b hnS = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.fPE != null) {
                if (i == 0) {
                    PbActivity.this.fPE.eu(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fPE = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fPE);
                }
            }
        }
    };
    private final b.InterfaceC0225b hnT = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hni != null && !TextUtils.isEmpty(PbActivity.this.hnj)) {
                if (i == 0) {
                    if (PbActivity.this.hnk == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnj));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hnj;
                        aVar.pkgId = PbActivity.this.hnk.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnk.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.adN();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.Y(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fzF == null) {
                            PbActivity.this.fzF = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fzF.h(PbActivity.this.hnj, PbActivity.this.hni.oB());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hni = null;
                PbActivity.this.hnj = null;
            }
        }
    };
    private final View.OnLongClickListener cdf = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
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
                        PbActivity.this.hni = ((TbImageView) view).getBdImage();
                        PbActivity.this.hnj = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hni == null || TextUtils.isEmpty(PbActivity.this.hnj)) {
                            return true;
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnk = null;
                        } else {
                            PbActivity.this.hnk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hni = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hnj = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hnk = null;
                            } else {
                                PbActivity.this.hnk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hni = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hnj = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnk = null;
                        } else {
                            PbActivity.this.hnk = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        PbActivity.this.hmJ.a(PbActivity.this.hnT, PbActivity.this.hni.isGif());
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
            PbActivity.this.fPE = (PostData) sparseArray2.get(d.g.tag_clip_board);
            if (PbActivity.this.fPE == null) {
                return true;
            }
            if (PbActivity.this.fPE.cep() != 1 || !PbActivity.this.cm(view)) {
                if (PbActivity.this.hmI != null) {
                    if (!PbActivity.this.hmI.UY() || PbActivity.this.fPE.getId() == null || !PbActivity.this.fPE.getId().equals(PbActivity.this.hmG.YX())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.fPE.cep() == 1) {
                        PbActivity.this.hmJ.a(PbActivity.this.hnS, z, false);
                        return true;
                    }
                    if (PbActivity.this.hmQ == null) {
                        PbActivity.this.hmQ = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                        PbActivity.this.hmQ.a(PbActivity.this.hnU);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cm = PbActivity.this.cm(view);
                        boolean z3 = (!PbActivity.this.cm(view) || PbActivity.this.hni == null || PbActivity.this.hni.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hmQ);
                            fVar3.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                            fVar3.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                            fVar3.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(fVar3);
                        }
                        if (cm) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, PbActivity.this.getString(d.j.save_to_emotion), PbActivity.this.hmQ));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(2, PbActivity.this.getString(d.j.save_to_local), PbActivity.this.hmQ));
                        }
                        if (!cm && !z3) {
                            com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hmQ);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(d.g.tag_clip_board, PbActivity.this.fPE);
                            fVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(fVar4);
                        }
                        if (!z4) {
                            if (z) {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hmQ);
                            } else {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hmQ);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(d.g.tag_clip_board, PbActivity.this.fPE);
                            sparseArray4.put(d.g.tag_is_subpb, false);
                            fVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(fVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hmQ);
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
                                if (!ap.m(PbActivity.this.fPE)) {
                                    nj = PbActivity.this.nj(z5) & PbActivity.this.isLogin();
                                } else {
                                    nj = false;
                                }
                                if (nj) {
                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hmQ);
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
                                    fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hmQ);
                                    fVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(d.g.tag_should_delete_visible, false);
                                }
                                fVar = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hmQ);
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
                                    if (PbActivity.this.hmG.getPbData().bIi() == 1002 && !z5) {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hmQ);
                                    } else {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hmQ);
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
                        PbActivity.this.hmQ.P(arrayList);
                        PbActivity.this.hmP = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hmQ.abh());
                        PbActivity.this.hmP.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").bJ("tid", PbActivity.this.hmG.hrG).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId()).bJ("uid", PbActivity.this.hmG.getPbData().bHW().YO().getUserId()).bJ("post_id", PbActivity.this.hmG.aml()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hmJ.a(PbActivity.this.hnT, PbActivity.this.hni.isGif());
            return true;
        }
    };
    private i.c hnU = new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.i.c
        public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
            if (PbActivity.this.hmP != null) {
                PbActivity.this.hmP.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmG.getPbData();
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
                    if (PbActivity.this.hni != null && !TextUtils.isEmpty(PbActivity.this.hnj)) {
                        if (PbActivity.this.hnk == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnj));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hnj;
                            aVar.pkgId = PbActivity.this.hnk.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnk.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hni = null;
                        PbActivity.this.hnj = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hni != null && !TextUtils.isEmpty(PbActivity.this.hnj)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.adN();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.Y(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fzF == null) {
                                PbActivity.this.fzF = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fzF.h(PbActivity.this.hnj, PbActivity.this.hni.oB());
                            PbActivity.this.hni = null;
                            PbActivity.this.hnj = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.fPE != null) {
                        PbActivity.this.fPE.eu(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.fPE = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").T("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.cl(view);
                        if (PbActivity.this.hmG.getPbData().bHW() != null && PbActivity.this.hmG.getPbData().bHW().YO() != null && PbActivity.this.hmG.getPbData().bHW().YO().getUserId() != null && PbActivity.this.hmI != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hmG.hrG).T("obj_locate", 2).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hmG.getPbData().bHW().YO().getUserId()).T("obj_type", PbActivity.this.hmI.UY() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hmG.getPbData())));
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
                        PbActivity.this.zK((String) tag);
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
                        PbActivity.this.hmJ.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hmJ.cs(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hmJ.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a eWp = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (!PbActivity.this.hmn && z && !PbActivity.this.hmG.bKV()) {
                PbActivity.this.bJI();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
        }
    };
    public View.OnTouchListener ccW = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.dLI.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0284a dLJ = new a.InterfaceC0284a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        final int dVI;

        {
            this.dVI = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            if (av(i2) && PbActivity.this.hmJ != null && PbActivity.this.hml != null) {
                PbActivity.this.hmJ.bNh();
                PbActivity.this.hml.jr(false);
                PbActivity.this.hml.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aS(int i, int i2) {
            if (av(i2) && PbActivity.this.hmJ != null && PbActivity.this.hml != null) {
                PbActivity.this.hml.jr(true);
                if (Math.abs(i2) > this.dVI) {
                    PbActivity.this.hml.hideFloatingView();
                }
                if (PbActivity.this.bJM()) {
                    PbActivity.this.hmJ.bMz();
                    PbActivity.this.hmJ.bMA();
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
    private String hnW = null;
    private final m.a hnX = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void k(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hnW = str2;
                PbActivity.this.hmJ.zX(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hnY = -1;
    private int hnZ = -1;
    private CustomMessageListener hoc = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bvY == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0223a) {
                    if (aVar.bvZ != null && !aVar.bvZ.hasError() && aVar.bvZ.getError() == 0) {
                        if (PbActivity.this.hmJ != null) {
                            PbActivity.this.hmJ.s(((a.C0223a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bJX();
                        }
                    } else if (z) {
                        if (aVar.bvZ != null && aVar.bvZ.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bvZ.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bvZ != null && !aVar.bvZ.hasError() && aVar.bvZ.getError() == 0) {
                        if (PbActivity.this.hmJ != null && PbActivity.this.hmJ != null) {
                            PbActivity.this.hmJ.s(((a.C0223a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bvZ != null && aVar.bvZ.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bvZ.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bvZ == null || aVar.bvZ.hasError() || aVar.bvZ.getError() != 0) {
                        if (z) {
                            if (aVar.bvZ != null && aVar.bvZ.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bvZ.getErrorString());
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
        public ArrayList<String> hoD;
        public ConcurrentHashMap<String, ImageUrlData> hoE;
        public boolean hoG;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hoF = false;
        public boolean hoH = false;
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

    public com.baidu.tbadk.editortools.pb.d bJj() {
        return this.hmY;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bIA() != null) {
            String id = jVar.bIA().getId();
            ArrayList<PostData> bHY = this.hmG.getPbData().bHY();
            int i = 0;
            while (true) {
                if (i >= bHY.size()) {
                    break;
                }
                PostData postData = bHY.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bIE = jVar.bIE();
                    postData.zp(jVar.getTotalCount());
                    if (postData.cem() != null && bIE != null) {
                        Iterator<PostData> it = bIE.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.YO() != null && (metaData = postData.getUserMap().get(next.YO().getUserId())) != null) {
                                next.a(metaData);
                                next.pY(true);
                                next.a(getPageContext(), this.hmG.zQ(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bIE.size() != postData.cem().size();
                        postData.cem().clear();
                        postData.cem().addAll(bIE);
                        z = z2;
                    }
                    if (postData.cei() != null) {
                        postData.cej();
                    }
                }
            }
            if (!this.hmG.getIsFromMark() && z) {
                this.hmJ.n(this.hmG.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zI(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bIl = this.hmG.getPbData().bIl();
            if (bIl != null && str.equals(bIl.getAdId())) {
                if (bIl.ced() != null) {
                    bIl.ced().legoCard = null;
                }
                this.hmG.getPbData().bIm();
            }
            com.baidu.tieba.tbadkCore.data.m bKZ = this.hmG.bKZ();
            if (bKZ != null && str.equals(bKZ.getAdId())) {
                this.hmG.bLa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer)) {
            if (this.hmP != null && this.hmP.isShowing()) {
                this.hmP.dismiss();
                this.hmP = null;
            }
            final String str = (String) sparseArray.get(d.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this);
                iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                    @Override // com.baidu.tbadk.core.dialog.i.c
                    public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                        if (PbActivity.this.hmP != null) {
                            PbActivity.this.hmP.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hmJ.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.hng);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hng);
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
                this.hmP = new com.baidu.tbadk.core.dialog.g(getPageContext(), iVar.abh());
                this.hmP.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(int i) {
        bg bHW;
        if (this.hmG != null && this.hmG.getPbData() != null && (bHW = this.hmG.getPbData().bHW()) != null) {
            if (i == 1) {
                PraiseData YA = bHW.YA();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (YA == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bHW.a(praiseData);
                    } else {
                        bHW.YA().getUser().add(0, metaData);
                        bHW.YA().setNum(bHW.YA().getNum() + 1);
                        bHW.YA().setIsLike(i);
                    }
                }
                if (bHW.YA() != null) {
                    if (bHW.YA().getNum() < 1) {
                        getResources().getString(d.j.zan);
                    } else {
                        com.baidu.tbadk.core.util.ap.ax(bHW.YA().getNum());
                    }
                }
            } else if (bHW.YA() != null) {
                bHW.YA().setIsLike(i);
                bHW.YA().setNum(bHW.YA().getNum() - 1);
                ArrayList<MetaData> user = bHW.YA().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bHW.YA().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bHW.YA().getNum() < 1) {
                    getResources().getString(d.j.zan);
                } else {
                    String str = bHW.YA().getNum() + "";
                }
            }
            if (this.hmG.bKP()) {
                this.hmJ.bMC().notifyDataSetChanged();
            } else {
                this.hmJ.o(this.hmG.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hmG.aa(bundle);
        if (this.eYD != null) {
            this.eYD.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hmY.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hmr = System.currentTimeMillis();
        this.hne = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eCw = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hmy = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hmy) && intent.getData() != null) {
                this.hmy = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hmy)) {
                this.hmm = true;
            }
            this.hnY = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hnZ = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hoa = intent.getStringExtra("key_manga_title");
            this.hmT = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hmU = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hmV = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bJM()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.hnm = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eCw = System.currentTimeMillis();
        }
        this.cqp = this.hmr - this.eCw;
        super.onCreate(bundle);
        this.hmp = 0;
        Z(bundle);
        if (this.hmG != null && this.hmG.getPbData() != null) {
            this.hmG.getPbData().zG(this.source);
        }
        initUI();
        if (intent != null && this.hmJ != null) {
            this.hmJ.hvt = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hnh == null) {
                    this.hnh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hmJ.zZ("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hnh, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hmG != null && this.hmG.getPbData() != null) {
                this.hmG.zT(stringExtra);
            }
        }
        this.eYD = new VoiceManager();
        this.eYD.onCreate(getPageContext());
        initData(bundle);
        this.hmX = new com.baidu.tbadk.editortools.pb.f();
        bJk();
        this.hmY = (com.baidu.tbadk.editortools.pb.d) this.hmX.dd(getActivity());
        this.hmY.b(this);
        this.hmY.a(this.cku);
        this.hmY.a(this.ckn);
        this.hmY.a(this, bundle);
        this.hmY.alP().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hmY.alP().eH(true);
        ni(true);
        this.hmJ.setEditorTools(this.hmY.alP());
        this.hmY.a(this.hmG.bLb(), this.hmG.bKO(), this.hmG.bLt());
        registerListener(this.hnt);
        if (!this.hmG.bKU()) {
            this.hmY.oS(this.hmG.bKO());
        }
        if (this.hmG.bLu()) {
            this.hmY.oQ(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else if (this.hmJ != null) {
            this.hmY.oQ(this.hmJ.bMo());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hns);
        registerListener(this.hnu);
        registerListener(this.hnv);
        registerListener(this.eZV);
        registerListener(this.hnJ);
        registerListener(this.hnr);
        this.hmW = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.iFl);
        this.hmW.cdQ();
        registerListener(this.hnx);
        registerListener(this.mAttentionListener);
        if (this.hmG != null) {
            this.hmG.bLl();
        }
        registerListener(this.hnM);
        registerListener(this.hoc);
        registerListener(this.fac);
        if (this.hmJ != null && this.hmJ.bNl() != null && this.hmJ.bNm() != null) {
            this.hml = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hmJ.bNl(), this.hmJ.bNm(), this.hmJ.bMu());
            this.hml.a(this.hnF);
        }
        if (this.hmk && this.hmJ != null && this.hmJ.bNm() != null) {
            this.hmJ.bNm().setVisibility(8);
        }
        this.hnf = new com.baidu.tbadk.core.view.e();
        this.hnf.bPQ = 1000L;
        registerListener(this.hnI);
        registerListener(this.hnG);
        registerListener(this.hnH);
        registerListener(this.frv);
        registerListener(this.brs);
        this.hng = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hng;
        userMuteAddAndDelCustomMessage.setTag(this.hng);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hng;
        userMuteCheckCustomMessage.setTag(this.hng);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hmG.bLr().a(this.dKZ);
        this.hmO = new as();
        if (this.hmY.amp() != null) {
            this.hmO.k(this.hmY.amp().getInputView());
        }
        this.hmY.a(this.cko);
        this.fot = new ShareSuccessReplyToServerModel();
        a(this.hno);
        this.gyx = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gyx.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bKv) {
                        PbActivity.this.hmY.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bKw && PbActivity.this.hmJ != null && PbActivity.this.hmJ.bMl() != null && PbActivity.this.hmJ.bMl().bKF() != null) {
                        PbActivity.this.hmJ.bMl().bKF().amI();
                    } else if (i == com.baidu.tbadk.core.util.aj.bKx) {
                        PbActivity.this.c(PbActivity.this.hnb);
                    }
                }
            }
        });
        this.hmH = new com.baidu.tieba.pb.pb.report.a(this);
        this.hmH.p(getUniqueId());
        com.baidu.tieba.q.c.cdp().s(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.hmr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJk() {
        if (this.hmX != null && this.hmG != null) {
            this.hmX.setForumName(this.hmG.bIO());
            if (this.hmG.getPbData() != null && this.hmG.getPbData().getForum() != null) {
                this.hmX.a(this.hmG.getPbData().getForum());
            }
            this.hmX.setFrom("pb");
            this.hmX.a(this.hmG);
        }
    }

    public String bJl() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bJm() {
        return this.hml;
    }

    private void ni(boolean z) {
        this.hmY.eL(z);
        this.hmY.eM(z);
        this.hmY.eN(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bIu() && !z && this.hmJ != null && this.hmJ.getView() != null && !UtilHelper.isOnePlus6()) {
            this.hmJ.getView().setSystemUiVisibility(4);
        }
        this.hnc = z;
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
        if (this.eYD != null) {
            this.eYD.onStart(getPageContext());
        }
    }

    public aq bJn() {
        return this.hmJ;
    }

    public PbModel bIX() {
        return this.hmG;
    }

    public void zJ(String str) {
        if (this.hmG != null && !StringUtils.isNull(str) && this.hmJ != null) {
            this.hmJ.nX(true);
            this.hmG.zJ(str);
            this.hmx = true;
            this.hmJ.bMX();
            this.hmJ.bNg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hmn = false;
        } else {
            this.hmn = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hmp = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hmp == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.eYD != null) {
            this.eYD.onPause(getPageContext());
        }
        if (this.hmJ != null) {
            this.hmJ.onPause();
        }
        if (!this.hmG.bKU()) {
            this.hmY.oR(this.hmG.bKO());
        }
        if (this.hmG != null) {
            this.hmG.bLm();
        }
        com.baidu.tbadk.BdToken.c.TX().TY();
        MessageManager.getInstance().unRegisterListener(this.gct);
        bnV();
        MessageManager.getInstance().unRegisterListener(this.hnG);
        MessageManager.getInstance().unRegisterListener(this.hnH);
        MessageManager.getInstance().unRegisterListener(this.hnI);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bJo() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hmG.getPbData(), this.hmG.bKP(), this.hmG.getRequestType());
        return (a2 == null || a2.YO() == null || a2.YO().getGodUserData() == null || a2.YO().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hmn = false;
        super.onResume();
        if (this.hmA) {
            this.hmA = false;
            bJS();
        }
        if (bJo()) {
            this.hmu = System.currentTimeMillis();
        } else {
            this.hmu = -1L;
        }
        if (this.hmJ != null && this.hmJ.getView() != null) {
            if (!this.gPR) {
                bJJ();
            } else {
                hideLoadingView(this.hmJ.getView());
            }
            this.hmJ.onResume();
        }
        if (this.hmp == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hmJ != null) {
            noNetworkView = this.hmJ.bMi();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kY()) {
            noNetworkView.dO(false);
        }
        if (this.eYD != null) {
            this.eYD.onResume(getPageContext());
        }
        registerListener(this.gct);
        this.hmS = false;
        bJR();
        registerListener(this.hnG);
        registerListener(this.hnH);
        registerListener(this.hnI);
        if (this.eZs) {
            bJI();
            this.eZs = false;
        }
        bKa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hmJ.nM(z);
        if (this.hmP != null) {
            this.hmP.dismiss();
        }
        if (z && this.hmS) {
            this.hmJ.bMH();
            this.hmG.ny(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hmu > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").bJ("obj_duration", (System.currentTimeMillis() - this.hmu) + ""));
            this.hmu = 0L;
        }
        if (bJn().bMl() != null) {
            bJn().bMl().onStop();
        }
        if (this.hmJ.hvA != null && !this.hmJ.hvA.aRm()) {
            this.hmJ.hvA.bzk();
        }
        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().getForum() != null && this.hmG.getPbData().bHW() != null) {
            com.baidu.tbadk.distribute.a.alC().a(getPageContext().getPageActivity(), "pb", this.hmG.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmG.getPbData().bHW().getId(), 0L));
        }
        if (this.eYD != null) {
            this.eYD.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.cdp().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.cdp().t(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hmG.getPbData().getForumId());
            amVar.bJ("tid", this.hmG.bKO());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hms && this.hmJ != null) {
            this.hms = true;
            this.hmJ.bNc();
            a(false, (PostData) null);
        }
        if (this.hmG != null) {
            this.hmG.cancelLoadData();
            this.hmG.destory();
            if (this.hmG.bLq() != null) {
                this.hmG.bLq().onDestroy();
            }
        }
        if (this.hmY != null) {
            this.hmY.onDestroy();
        }
        if (this.eiI != null) {
            this.eiI.cancelLoadData();
        }
        if (this.hmJ != null) {
            this.hmJ.onDestroy();
            if (this.hmJ.hvA != null) {
                this.hmJ.hvA.bzk();
            }
        }
        if (this.hmt != null) {
            this.hmt.aoY();
        }
        if (this.hml != null) {
            this.hml.aqh();
        }
        super.onDestroy();
        if (this.eYD != null) {
            this.eYD.onDestory(getPageContext());
        }
        this.hmJ.bMX();
        MessageManager.getInstance().unRegisterListener(this.hnG);
        MessageManager.getInstance().unRegisterListener(this.hnH);
        MessageManager.getInstance().unRegisterListener(this.hnI);
        MessageManager.getInstance().unRegisterListener(this.hng);
        MessageManager.getInstance().unRegisterListener(this.hnJ);
        MessageManager.getInstance().unRegisterListener(this.fac);
        MessageManager.getInstance().unRegisterListener(this.frv);
        this.hne = null;
        this.hnf = null;
        com.baidu.tieba.recapp.d.a.bXv().bXx();
        if (this.hnh != null) {
            getSafeHandler().removeCallbacks(this.hnh);
        }
        if (this.hmB != null) {
            this.hmB.cancelLoadData();
        }
        if (this.hmJ != null && this.hmJ.hvA != null) {
            this.hmJ.hvA.bNX();
        }
        if (this.fot != null) {
            this.fot.cancelLoadData();
        }
        this.hmO.onDestroy();
        if (this.hmG != null && this.hmG.bLs() != null) {
            this.hmG.bLs().onDestroy();
        }
        if (this.gyx != null) {
            this.gyx.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bMC;
        ArrayList<PostData> bKq;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.afX() && this.hmJ != null && (bMC = this.hmJ.bMC()) != null && (bKq = bMC.bKq()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bKq.iterator();
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
                        bVar.ekF = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bCj == 1 && !TextUtils.isEmpty(id)) {
                    next.bCj = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.ekF = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hmG == null || this.hmG.getPbData() == null || this.hmG.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hmG.getPbData().getForum().getFirst_class();
                    str2 = this.hmG.getPbData().getForum().getSecond_class();
                    str = this.hmG.getPbData().getForum().getId();
                    str4 = this.hmG.bKO();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aga());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.hmJ.onChangeSkinType(i);
            if (this.hmY != null && this.hmY.alP() != null) {
                this.hmY.alP().onChangeSkinType(i);
            }
            if (this.hmJ.bMi() != null) {
                this.hmJ.bMi().onChangeSkinType(getPageContext(), i);
            }
            this.hmO.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hmJ = new aq(this, this.faL, this.cca);
        this.dLI = new com.baidu.tieba.f.b(getActivity());
        this.dLI.a(hnV);
        this.dLI.a(this.dLJ);
        this.hmJ.setOnScrollListener(this.mOnScrollListener);
        this.hmJ.e(this.fsD);
        this.hmJ.setListPullRefreshListener(this.cPw);
        this.hmJ.nc(com.baidu.tbadk.core.i.Wv().Wz());
        this.hmJ.setOnImageClickListener(this.cAD);
        this.hmJ.b(this.cdf);
        this.hmJ.h(this.eWp);
        this.hmJ.a(this.hnO);
        this.hmJ.nM(this.mIsLogin);
        if (getIntent() != null) {
            this.hmJ.nY(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hmJ.bMk().setFromForumId(this.hmG.getFromForumId());
    }

    public void bJp() {
        if (this.hmJ != null && this.hmG != null) {
            if ((this.hmG.getPbData() != null || this.hmG.getPbData().bIt() != null) && checkUpIsLogin() && this.hmJ.bMC() != null && this.hmJ.bMC().bKv() != null) {
                this.hmJ.bMC().bKv().ns(this.hmG.bKO());
            }
        }
    }

    public void bJq() {
        TiebaStatic.log("c12181");
        if (this.hmJ != null && this.hmG != null) {
            if (this.hmJ == null || this.hmJ.bMn()) {
                if (this.hmG.getPbData() != null || this.hmG.getPbData().bIt() != null) {
                    com.baidu.tieba.pb.data.i bIt = this.hmG.getPbData().bIt();
                    if (checkUpIsLogin()) {
                        if ((!bIt.bIx() || bIt.aak() != 2) && this.hmJ.bMC() != null && this.hmJ.bMC().bKv() != null) {
                            this.hmJ.bMC().bKv().ns(this.hmG.bKO());
                        }
                        if (System.currentTimeMillis() - this.hmw > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).or(false);
                            this.hmw = System.currentTimeMillis();
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
                if (postData.getType() != PostData.iFN && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.Wv().Wz()) {
                    return zM(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hmG == null || this.hmG.getPbData() == null) {
                        return true;
                    }
                    if (bJn().bMl() != null) {
                        bJn().bMl().bKB();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.hmG.getPbData().getForum());
                    jVar.ai(this.hmG.getPbData().bHW());
                    jVar.e(postData);
                    bJn().bMk().d(jVar);
                    bJn().bMk().setPostId(postData.getId());
                    a(view, postData.YO().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hmY != null) {
                        this.hmJ.nS(this.hmY.amw());
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
        if (this.hmJ != null) {
            if (z && !this.gPR) {
                bJJ();
            } else {
                hideLoadingView(this.hmJ.getView());
            }
            if (z && this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bIu() && this.hmJ.getView() != null && !UtilHelper.isOnePlus6()) {
                this.hmJ.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bJr() {
        if (this.hmq == null) {
            this.hmq = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hmq.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hmf = PbActivity.this.hmf.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmf);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hmG.bKO(), PbActivity.this.hmf, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hmf = PbActivity.this.hmf.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmf);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hmG.bKO(), PbActivity.this.hmf, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hmf = PbActivity.this.hmf.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmf);
                        bVar.dismiss();
                    }
                }
            }).gG(b.a.bFc).gH(17).d(getPageContext());
        }
    }

    private void Z(Bundle bundle) {
        this.hmG = new PbModel(this);
        this.hmG.a(this.hnL);
        if (this.hmG.bLp() != null) {
            this.hmG.bLp().a(this.hnX);
        }
        if (this.hmG.bLo() != null) {
            this.hmG.bLo().a(this.hnw);
        }
        if (this.hmG.bLq() != null) {
            this.hmG.bLq().b(this.hnq);
        }
        if (bundle != null) {
            this.hmG.initWithBundle(bundle);
        } else {
            this.hmG.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hmG.nB(true);
        }
        aj.bLX().ao(this.hmG.bKM(), this.hmG.getIsFromMark());
        if (StringUtils.isNull(this.hmG.bKO())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hmy) && this.hmy != null) {
            this.hmG.wq(6);
        }
        this.hmG.aor();
    }

    private void initData(Bundle bundle) {
        this.hmI = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hmI != null) {
            this.hmI.a(this.hnN);
        }
        this.eiI = new ForumManageModel(this);
        this.eiI.setLoadDataCallBack(this.eiM);
        this.bKA = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hmJ.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hmG.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmG.getPbData().getForum().getId(), PbActivity.this.hmG.getPbData().getForum().getName(), PbActivity.this.hmG.getPbData().bHW().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hnC.setUniqueId(getUniqueId());
        this.hnC.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hmJ.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hng;
        userMuteCheckCustomMessage.setTag(this.hng);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bJs() {
        if (checkUpIsLogin()) {
            if (this.fci == null) {
                this.fci = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fci.ra(0);
                this.fci.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jl(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void n(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jm(boolean z) {
                        if (z) {
                            PbActivity.this.hmJ.bnj();
                        }
                    }
                });
            }
            if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().getForum() != null) {
                this.fci.q(this.hmG.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmG.bKO(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJt() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hmG != null && (pbData = this.hmG.getPbData()) != null) {
            return pbData.bIh().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHW() != null) {
            if (dVar.bHW().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bHW().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bHW().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bJu()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hmD);
                this.hmE = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hna == null) {
                this.hna = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hna.ra(1);
                this.hna.a(new AnonymousClass39(str, str2));
            }
            if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().getForum() != null) {
                this.hna.q(this.hmG.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmG.bKO(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$39  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String hom;
        final /* synthetic */ String hon;

        AnonymousClass39(String str, String str2) {
            this.hom = str;
            this.hon = str2;
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
                        PbActivity.this.bJn().getListView().smoothScrollBy((PbActivity.this.hmD[1] + PbActivity.this.hmE) - (aQ - h), 50);
                        if (PbActivity.this.bJn().bMl() != null) {
                            PbActivity.this.hmY.alP().setVisibility(8);
                            PbActivity.this.bJn().bMl().Y(AnonymousClass39.this.hom, AnonymousClass39.this.hon, PbActivity.this.bJn().bMo());
                            com.baidu.tbadk.editortools.pb.g bKF = PbActivity.this.bJn().bMl().bKF();
                            if (bKF != null && PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                                bKF.a(PbActivity.this.hmG.getPbData().getAnti());
                            }
                            if (PbActivity.this.hmO.bNy() == null && PbActivity.this.bJn().bMl().bKF().amQ() != null) {
                                PbActivity.this.bJn().bMl().bKF().amQ().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hmO != null && PbActivity.this.hmO.bNx() != null) {
                                            if (!PbActivity.this.hmO.bNx().cnZ()) {
                                                PbActivity.this.hmO.oa(false);
                                            }
                                            PbActivity.this.hmO.bNx().qV(false);
                                        }
                                    }
                                });
                                PbActivity.this.hmO.l(PbActivity.this.bJn().bMl().bKF().amQ().getInputView());
                                PbActivity.this.bJn().bMl().bKF().a(PbActivity.this.hnd);
                            }
                        }
                        PbActivity.this.bJn().bNg();
                    }
                }, 0L);
            }
        }
    }

    public boolean bJu() {
        if (this.gyx == null || this.hmG.getPbData() == null || this.hmG.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyx.hl(this.hmG.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean vZ(int i) {
        if (this.gyx == null || this.hmG.getPbData() == null || this.hmG.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyx.S(this.hmG.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.hmG != null && this.hmG.getPbData() != null && postData.cep() != 1) {
            String bKO = this.hmG.bKO();
            String id = postData.getId();
            int bIi = this.hmG.getPbData() != null ? this.hmG.getPbData().bIi() : 0;
            c zN = zN(id);
            if (zN != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bKO, id, "pb", true, null, false, null, bIi, postData.bOL(), this.hmG.getPbData().getAnti(), false, postData.YO() != null ? postData.YO().getIconInfo() : null).addBigImageData(zN.hoD, zN.hoE, zN.hoF, zN.index);
                addBigImageData.setKeyPageStartFrom(this.hmG.bLw());
                addBigImageData.setFromFrsForumId(this.hmG.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJv() {
        if (this.hmG.getPbData() == null || this.hmG.getPbData().bHW() == null) {
            return -1;
        }
        return this.hmG.getPbData().bHW().Zy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJw() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.BU(this.hmG.getForumId()) && this.hmG.getPbData() != null && this.hmG.getPbData().getForum() != null) {
            if (this.hmG.getPbData().getForum().isLike() == 1) {
                this.hmG.bLs().dP(this.hmG.getForumId(), this.hmG.bKO());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hmG == null || this.hmG.getPbData() == null) {
            return false;
        }
        return ((this.hmG.getPbData().bIi() != 0) || this.hmG.getPbData().bHW() == null || this.hmG.getPbData().bHW().YO() == null || TextUtils.equals(this.hmG.getPbData().bHW().YO().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bJx() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.s.v.apE()) {
            return "";
        }
        PostData bId = bId();
        if (this.hmG == null || (pbData = this.hmG.getPbData()) == null || pbData.getUserData() == null || pbData.bHW() == null || bId == null || bId.YO() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bId.YO().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bHW().Yv() == 0) {
            return "";
        }
        if (pbData.bHW().Yv() == 0) {
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
        if (this.hmG == null || this.hmG.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hmG.getPbData();
        if (pbData.bIi() != 0) {
            return pbData.bIi() != 3;
        }
        List<com.baidu.tbadk.core.data.bc> bIr = pbData.bIr();
        if (com.baidu.tbadk.core.util.v.S(bIr) > 0) {
            for (com.baidu.tbadk.core.data.bc bcVar : bIr) {
                if (bcVar != null && (vVar = bcVar.bAD) != null && vVar.byw && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    private boolean nl(boolean z) {
        return (z || this.hmG == null || this.hmG.getPbData() == null || this.hmG.getPbData().bIi() == 0 || this.hmG.getPbData().bIi() == 3) ? false : true;
    }

    public void bJy() {
        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null && this.hmG.getPbData().bHW().YO() != null) {
            if (this.hmJ != null) {
                this.hmJ.bMj();
            }
            bg bHW = this.hmG.getPbData().bHW();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bHW.YO().getUserId());
            ab abVar = new ab();
            int bIi = this.hmG.getPbData().bIi();
            if (bIi == 1 || bIi == 3) {
                abVar.htJ = true;
                abVar.htI = true;
                abVar.htQ = bHW.YJ() == 1;
                abVar.htP = bHW.YK() == 1;
            } else {
                abVar.htJ = false;
                abVar.htI = false;
            }
            if (bIi == 1002 && !equals) {
                abVar.htU = true;
            }
            abVar.htK = nk(equals);
            abVar.htL = bJz();
            abVar.htM = nl(equals);
            abVar.qV = this.hmG.bKP();
            abVar.htH = true;
            abVar.htG = nj(equals);
            abVar.htS = bJx();
            abVar.htF = equals && this.hmJ.bMO();
            abVar.htN = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.htO = true;
            abVar.isHostOnly = this.hmG.getHostMode();
            abVar.htR = true;
            if (bHW.Zf() == null) {
                abVar.htT = true;
            } else {
                abVar.htT = false;
            }
            this.hmJ.hvA.a(abVar);
        }
    }

    private boolean bJz() {
        if (this.hmG != null && this.hmG.bKP()) {
            return this.hmG.getPageData() == null || this.hmG.getPageData().XI() != 0;
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

    public int bJA() {
        if (bJn() == null || bJn().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bJn().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) mVar).mType == com.baidu.tieba.pb.data.h.hku) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJB() {
        if (bJn() == null || bJn().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bJn().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.iFM) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bJI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.ly(getResources().getString(d.j.mark_done));
            aVar.dx(true);
            aVar.lz(getResources().getString(d.j.mark_like));
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
                    PbActivity.this.bKA.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hmG.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aaW();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hmJ.bMI();
        this.hmG.nA(z);
        if (this.hmI != null) {
            this.hmI.cZ(z);
            if (markData != null) {
                this.hmI.a(markData);
            }
        }
        if (this.hmG.UY()) {
            bJG();
        } else {
            this.hmJ.n(this.hmG.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vX(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zK(String str) {
        this.hmH.Ai(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hmG.bKU()) {
                    antiData.setBlock_forum_name(this.hmG.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hmG.getPbData().getForum().getId());
                    antiData.setUser_name(this.hmG.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hmG.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bJn() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aD(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLn));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLn));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLn));
            }
        } else if (i == 230277) {
            oX(str);
        } else {
            this.hmJ.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.iIn) ? bVar.iIn : getString(d.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.lz(string);
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
                aVar.aaW();
            } else {
                this.hmJ.a(0, bVar.Id, bVar.iIn, z);
            }
            if (bVar.Id) {
                if (bVar.eFy == 1) {
                    ArrayList<PostData> bHY = this.hmG.getPbData().bHY();
                    int size = bHY.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bHY.get(i).getId())) {
                            i++;
                        } else {
                            bHY.remove(i);
                            break;
                        }
                    }
                    this.hmG.getPbData().bHW().gq(this.hmG.getPbData().bHW().YF() - 1);
                    this.hmJ.n(this.hmG.getPbData());
                } else if (bVar.eFy == 0) {
                    bJC();
                } else if (bVar.eFy == 2) {
                    ArrayList<PostData> bHY2 = this.hmG.getPbData().bHY();
                    int size2 = bHY2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bHY2.get(i2).cem().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bHY2.get(i2).cem().get(i3).getId())) {
                                i3++;
                            } else {
                                bHY2.get(i2).cem().remove(i3);
                                bHY2.get(i2).ceo();
                                z2 = true;
                                break;
                            }
                        }
                        bHY2.get(i2).Cy(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hmJ.n(this.hmG.getPbData());
                    }
                    a(bVar, this.hmJ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hmJ.a(this.eiI.getLoadDataMode(), gVar.Id, gVar.iIn, false);
            if (gVar.Id) {
                this.hmL = true;
                if (i == 2 || i == 3) {
                    this.hmM = true;
                    this.hmN = false;
                } else if (i == 4 || i == 5) {
                    this.hmM = false;
                    this.hmN = true;
                }
                if (i == 2) {
                    this.hmG.getPbData().bHW().gt(1);
                    this.hmG.setIsGood(1);
                } else if (i == 3) {
                    this.hmG.getPbData().bHW().gt(0);
                    this.hmG.setIsGood(0);
                } else if (i == 4) {
                    this.hmG.getPbData().bHW().gs(1);
                    this.hmG.oA(1);
                } else if (i == 5) {
                    this.hmG.getPbData().bHW().gs(0);
                    this.hmG.oA(0);
                }
                this.hmJ.d(this.hmG.getPbData(), this.hmG.bKP());
            }
        }
    }

    private void bJC() {
        if (this.hmG.bKQ() || this.hmG.bKS()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hmG.bKO());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hmG.bKO()));
        if (bJH()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJD() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bIf;
        boolean z = false;
        if (this.hmJ != null) {
            this.hmJ.bMX();
        }
        if (this.hmG != null && this.hmG.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hmG.getPbData().bHW().getId();
            if (this.hmG.isShareThread() && this.hmG.getPbData().bHW().bDy != null) {
                historyMessage.threadName = this.hmG.getPbData().bHW().bDy.showText;
            } else {
                historyMessage.threadName = this.hmG.getPbData().bHW().getTitle();
            }
            if (this.hmG.isShareThread() && !bIN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hmG.getPbData().getForum().getName();
            }
            ArrayList<PostData> bHY = this.hmG.getPbData().bHY();
            int bMK = this.hmJ != null ? this.hmJ.bMK() : 0;
            if (bHY != null && bMK >= 0 && bMK < bHY.size()) {
                historyMessage.postID = bHY.get(bMK).getId();
            }
            historyMessage.isHostOnly = this.hmG.getHostMode();
            historyMessage.isSquence = this.hmG.bKP();
            historyMessage.isShareThread = this.hmG.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hmY != null) {
            this.hmY.onDestroy();
        }
        if (this.hmo && bJn() != null) {
            bJn().bNq();
        }
        if (this.hmG != null && (this.hmG.bKQ() || this.hmG.bKS())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hmG.bKO());
            if (this.hmL) {
                if (this.hmN) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hmG.aWi());
                }
                if (this.hmM) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hmG.getIsGood());
                }
            }
            if (this.hmG.getPbData() != null && System.currentTimeMillis() - this.hmr >= 40000 && (bIf = this.hmG.getPbData().bIf()) != null && !com.baidu.tbadk.core.util.v.T(bIf.getDataList())) {
                intent.putExtra("guess_like_data", bIf);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hnm);
            }
            setResult(-1, intent);
        }
        if (bJH()) {
            if (this.hmG != null && this.hmJ != null && this.hmJ.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hmG.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bIc() && !this.hmx) {
                        aj bLX = aj.bLX();
                        com.baidu.tieba.pb.data.d bKW = this.hmG.bKW();
                        Parcelable onSaveInstanceState = this.hmJ.getListView().onSaveInstanceState();
                        boolean bKP = this.hmG.bKP();
                        boolean hostMode = this.hmG.getHostMode();
                        if (this.hmJ.bMu() != null && this.hmJ.bMu().getVisibility() == 0) {
                            z = true;
                        }
                        bLX.a(bKW, onSaveInstanceState, bKP, hostMode, z);
                        if (this.hnl >= 0 || this.hmG.bLy() != null) {
                            aj.bLX().l(this.hmG.bLy());
                            aj.bLX().k(this.hmG.bLz());
                            aj.bLX().ws(this.hmG.bLA());
                        }
                    }
                }
            } else {
                aj.bLX().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hmJ == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hmJ.wx(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wa(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.hmJ.bMj();
            this.hmJ.bMl().bKB();
            this.hmJ.nU(false);
        }
        this.hmJ.bMm();
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
                        this.hmY.resetData();
                        this.hmY.b(writeData);
                        this.hmY.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k jv = this.hmY.alP().jv(6);
                        if (jv != null && jv.ciw != null) {
                            jv.ciw.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hmY.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hmJ.bMl() != null && this.hmJ.bMl().bKF() != null) {
                            com.baidu.tbadk.editortools.pb.g bKF = this.hmJ.bMl().bKF();
                            bKF.b(writeData);
                            bKF.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k jv2 = bKF.alP().jv(6);
                            if (jv2 != null && jv2.ciw != null) {
                                jv2.ciw.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bKF.amI();
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
        this.hmY.onActivityResult(i, i2, intent);
        if (this.hmB != null) {
            this.hmB.onActivityResult(i, i2, intent);
        }
        if (bJn().bMl() != null) {
            bJn().bMl().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bJF();
                    return;
                case 13008:
                    aj.bLX().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hmG != null) {
                                PbActivity.this.hmG.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bWn().w(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hmG != null) {
                        a(bJE(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ad(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bWn().w(getPageContext());
                        bJw();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.fot != null && shareItem != null && shareItem.linkUrl != null) {
                            this.fot.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aiH() {
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
                    this.hmJ.nh(false);
                    if (this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null && this.hmG.getPbData().bHW().Zi() != null) {
                        this.hmG.getPbData().bHW().Zi().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hnb = emotionImageData;
                        if (vZ(com.baidu.tbadk.core.util.aj.bKx)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hmJ != null && this.hmJ.hvA != null) {
                        this.hmJ.hvA.Qi();
                        this.hmJ.hvA.bNR();
                        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null) {
                            this.hmG.getPbData().bHW().go(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hmC != null) {
                        this.hmJ.ct(this.hmC);
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
            if (this.hmB == null) {
                this.hmB = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hmB.b(this.ckn);
                this.hmB.c(this.cku);
            }
            this.hmB.a(emotionImageData, bIX(), bIX().getPbData());
        }
    }

    private ShareFromPBMsgData bJE() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ek = this.hmG.getPbData().ek(getPageContext().getPageActivity());
        PostData bMp = this.hmJ.bMp();
        String str = "";
        if (bMp != null) {
            str = bMp.getId();
            String ev = bMp.ev(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ev)) {
                ek[1] = ev;
            }
        }
        String Ze = this.hmG.getPbData().bHW().Ze();
        if (Ze != null && Ze.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ek[1]);
        shareFromPBMsgData.setImageUrl(ek[0]);
        shareFromPBMsgData.setForumName(this.hmG.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hmG.getPbData().bHW().getId());
        shareFromPBMsgData.setTitle(this.hmG.getPbData().bHW().getTitle());
        return shareFromPBMsgData;
    }

    private void ad(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bJE(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.gE(1);
            aVar.az(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null) {
                        com.baidu.tbadk.core.util.am bJ = new com.baidu.tbadk.core.util.am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).T("obj_param1", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmG.getForumId()).bJ("tid", PbActivity.this.hmG.bKO());
                        if (PbActivity.this.e(PbActivity.this.hmG.getPbData()) != 0) {
                            bJ.T("obj_type", PbActivity.this.e(PbActivity.this.hmG.getPbData()));
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
            aVar.b(getPageContext()).aaW();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), this.hmG.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.gE(1);
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
            aVar.b(getPageContext()).aaW();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), this.hmG.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJF() {
        MarkData wp;
        if (this.hmI != null && (wp = this.hmG.wp(this.hmJ.bML())) != null) {
            if (!wp.isApp() || (wp = this.hmG.wp(this.hmJ.bML() + 1)) != null) {
                this.hmJ.bMG();
                this.hmI.a(wp);
                if (!this.hmI.UY()) {
                    this.hmI.Va();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hmI.UZ();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        com.baidu.tieba.pb.data.d pbData = this.hmG.getPbData();
        this.hmG.nA(true);
        if (this.hmI != null) {
            pbData.zF(this.hmI.UX());
        }
        this.hmJ.n(pbData);
    }

    private boolean bJH() {
        if (this.hmG == null) {
            return true;
        }
        if (this.hmG.UY()) {
            final MarkData bLg = this.hmG.bLg();
            if (bLg == null || !this.hmG.getIsFromMark()) {
                return true;
            }
            final MarkData wp = this.hmG.wp(this.hmJ.bMK());
            if (wp == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bLg);
                setResult(-1, intent);
                return true;
            } else if (wp.getPostId() == null || wp.getPostId().equals(bLg.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bLg);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.lz(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hmI != null) {
                            if (PbActivity.this.hmI.UY()) {
                                PbActivity.this.hmI.UZ();
                                PbActivity.this.hmI.cZ(false);
                            }
                            PbActivity.this.hmI.a(wp);
                            PbActivity.this.hmI.cZ(true);
                            PbActivity.this.hmI.Va();
                        }
                        bLg.setPostId(wp.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bLg);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bJD();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bLg);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bJD();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.getView() != null) {
                            PbActivity.this.hmJ.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bLg);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bJD();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.aaW();
                return false;
            }
        } else if (this.hmG.getPbData() == null || this.hmG.getPbData().bHY() == null || this.hmG.getPbData().bHY().size() <= 0 || !this.hmG.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hmJ == null) {
            return null;
        }
        return this.hmJ.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ata() {
        if (this.hmJ == null) {
            return 0;
        }
        return this.hmJ.bMV();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> atb() {
        if (this.cAu == null) {
            this.cAu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean Wz = com.baidu.tbadk.core.i.Wv().Wz();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(d.C0277d.common_color_10220));
                    if (Wz) {
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
                        if (com.baidu.tbadk.core.i.Wv().Wz()) {
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
        return this.cAu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atc() {
        if (this.cDj == null) {
            this.cDj = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDj;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atd() {
        if (this.cAv == null) {
            this.cAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKc */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbActivity.this.getPageContext().getPageActivity());
                    boolean Wz = com.baidu.tbadk.core.i.Wv().Wz();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(d.C0277d.common_color_10220));
                    if (Wz) {
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
                    if (com.baidu.tbadk.core.i.Wv().Wz()) {
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
                    gifView.anj();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(d.C0277d.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cAv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ate() {
        if (this.cDk == null) {
            this.cDk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKd */
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
                    ((PlayVoiceBntNew) view).cfz();
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
        return this.cDk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atg() {
        this.cDm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bKe */
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
        return this.cDm;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afa() {
        if (this.bTU == null) {
            this.bTU = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTU;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ay(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hmv = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (av.Aa(str) && this.hmG != null && this.hmG.bKO() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").T("obj_param1", 1).bJ("post_id", this.hmG.bKO()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.chw = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            av.bNA().c(getPageContext(), str);
        }
        this.hmv = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void az(Context context, String str) {
        av.bNA().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hmv = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aB(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aA(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Rect rect) {
        if (rect != null && this.hmJ != null && this.hmJ.bNl() != null && rect.top <= this.hmJ.bNl().getHeight()) {
            rect.top += this.hmJ.bNl().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hmG.getPbData();
            TbRichText bh = bh(str, i);
            if (bh != null && (tbRichTextData = bh.ast().get(this.hnQ)) != null) {
                cVar.hoD = new ArrayList<>();
                cVar.hoE = new ConcurrentHashMap<>();
                if (!tbRichTextData.asA().asM()) {
                    cVar.hoG = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hoD.add(b2);
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
                    imageUrlData.mIsReserver = this.hmG.bLe();
                    imageUrlData.mIsSeeHost = this.hmG.getHostMode();
                    cVar.hoE.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bHW() != null) {
                            cVar.threadId = pbData.bHW().getId();
                        }
                        cVar.hoF = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.hoG = true;
                int size = pbData.bHY().size();
                this.hnR = false;
                cVar.index = -1;
                if (pbData.bId() != null) {
                    PostData bId = pbData.bId();
                    TbRichText cer = bId.cer();
                    if (!ap.m(bId)) {
                        i2 = a(cer, bh, i, i, cVar.hoD, cVar.hoE);
                    } else {
                        i2 = a(bId, i, cVar.hoD, cVar.hoE);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bHY().get(i4);
                    if (postData.getId() == null || pbData.bId() == null || pbData.bId().getId() == null || !postData.getId().equals(pbData.bId().getId())) {
                        TbRichText cer2 = postData.cer();
                        if (!ap.m(postData)) {
                            i3 = a(cer2, bh, i3, i, cVar.hoD, cVar.hoE);
                        } else {
                            i3 = a(postData, i3, cVar.hoD, cVar.hoE);
                        }
                    }
                }
                if (cVar.hoD.size() > 0) {
                    cVar.lastId = cVar.hoD.get(cVar.hoD.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bHW() != null) {
                        cVar.threadId = pbData.bHW().getId();
                    }
                    cVar.hoF = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asA() == null) {
            return null;
        }
        return tbRichTextData.asA().asR();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asA() == null) {
            return 0L;
        }
        return tbRichTextData.asA().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asA() == null) {
            return false;
        }
        return tbRichTextData.asA().asS();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asA() == null) {
            return false;
        }
        return tbRichTextData.asA().asT();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo asA;
        String str;
        if (tbRichText == tbRichText2) {
            this.hnR = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.ast().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.ast().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.asA().getWidth() * aR;
                    int height = aR * tbRichTextData.asA().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.asA().asM()) {
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
                            if (tbRichTextData != null && (asA = tbRichTextData.asA()) != null) {
                                String asO = asA.asO();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = asA.asP();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = asO;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hmG.bKO(), -1L);
                                imageUrlData.mIsReserver = this.hmG.bLe();
                                imageUrlData.mIsSeeHost = this.hmG.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hnR) {
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
        com.baidu.tieba.tbadkCore.data.i cey;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cdU;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cdU = (cey = postData.cey()).cdU()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cdU.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cdU.get(i3);
                if (kVar != null) {
                    String cdY = kVar.cdY();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(cdY)) {
                        arrayList.add(cdY);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cdY;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cdX();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hmG.bKO(), -1L);
                        imageUrlData.mIsReserver = this.hmG.bLe();
                        imageUrlData.mIsSeeHost = this.hmG.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cey.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cdY, imageUrlData);
                        }
                        if (!this.hnR) {
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
            if (postData.getId() != null && postData.getId().equals(this.hmG.YX())) {
                z = true;
            }
            MarkData j = this.hmG.j(postData);
            if (j != null) {
                this.hmJ.bMG();
                if (this.hmI != null) {
                    this.hmI.a(j);
                    if (!z) {
                        this.hmI.Va();
                    } else {
                        this.hmI.UZ();
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
        if (this.hmG == null || this.hmG.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hmG.getPbData();
        if (pbData.bId() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bId());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bHY = pbData.bHY();
            a(pbData, bHY);
            return a(bHY, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bIh() != null && dVar.bIh().hkJ != null && (list = dVar.bIh().hkJ) != null && arrayList != null) {
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

    private long zL(String str) {
        ArrayList<PostData> bHY;
        com.baidu.tieba.pb.data.d pbData = this.hmG.getPbData();
        if (pbData != null && (bHY = pbData.bHY()) != null && !bHY.isEmpty()) {
            Iterator<PostData> it = bHY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cey = next.cey();
                if (cey != null && cey.iFt) {
                    Iterator<TbRichTextData> it2 = next.cer().ast().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.asJ().getLink().equals(str)) {
                            return cey.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> ast;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cer = arrayList.get(i2).cer();
            if (cer != null && (ast = cer.ast()) != null) {
                int size = ast.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (ast.get(i4) != null && ast.get(i4).getType() == 8) {
                        i3++;
                        if (ast.get(i4).asA().asO().equals(str) || ast.get(i4).asA().asP().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = ast.get(i4).asA().getWidth() * aR;
                            int height = ast.get(i4).asA().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hnQ = i4;
                            return cer;
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
            this.hmf = str;
            if (this.hmq == null) {
                bJr();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hmq.gJ(1).setVisibility(8);
            } else {
                this.hmq.gJ(1).setVisibility(0);
            }
            this.hmq.aaZ();
            this.hmv = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJI() {
        hideNetRefreshView(this.hmJ.getView());
        bJJ();
        if (this.hmG.aor()) {
            this.hmJ.bMG();
        }
    }

    private void bJJ() {
        showLoadingView(this.hmJ.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View anz = getLoadingView().anz();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anz.getLayoutParams();
        layoutParams.addRule(3, this.hmJ.bNl().getId());
        anz.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcK() {
        if (this.eYD != null) {
            this.eYD.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb(int i) {
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
    public void wc(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.hmG.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hmG.getPbData();
            pbData.getForum().getName();
            String title = pbData.bHW().getTitle();
            int i2 = this.hmG.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.BU(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hmG.bKO() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] ek = pbData.ek(getPageContext().getPageActivity());
                    str = ek[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = ek[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bJv() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").bJ(ImageViewerConfig.FORUM_ID, pbData.getForumId()).bJ("tid", pbData.getThreadId()).bJ("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.cbl = true;
                    dVar.cbs = z;
                    dVar.extData = this.hmG.bKO();
                    dVar.cbD = 3;
                    dVar.cbC = i;
                    dVar.fid = this.hmG.getForumId();
                    dVar.tid = this.hmG.bKO();
                    dVar.cbH = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hmG.getPbData().bHW());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.cbD);
                    bundle.putInt("obj_type", dVar.cbH);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.D(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bIu() && !UtilHelper.isOnePlus6()) {
                                PbActivity.this.hmJ.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.aSr().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hmG.bKO() + "?share=9105&fr=share&see_lz=" + i2;
            String[] ek2 = pbData.ek(getPageContext().getPageActivity());
            str = ek2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = ek2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bJv() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.cbl = true;
            dVar2.cbs = z;
            dVar2.extData = this.hmG.bKO();
            dVar2.cbD = 3;
            dVar2.cbC = i;
            dVar2.fid = this.hmG.getForumId();
            dVar2.tid = this.hmG.bKO();
            dVar2.cbH = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hmG.getPbData().bHW());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.cbD);
            bundle2.putInt("obj_type", dVar2.cbH);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.D(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hmG != null && PbActivity.this.hmG.getPbData() != null && PbActivity.this.hmG.getPbData().bIu() && !UtilHelper.isOnePlus6()) {
                        PbActivity.this.hmJ.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.aSr().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bHW() != null) {
            if (dVar.bHW().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bHW().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJK() {
        com.baidu.tbadk.util.aa.a(new com.baidu.tbadk.util.z<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.BV(PbActivity.this.hmG.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hmJ.bNr();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> atf() {
        if (this.cDl == null) {
            this.cDl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKf */
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
        return this.cDl;
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

    public void bcL() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bbG() {
        if (this.hmG == null || this.hmG.getPbData() == null) {
            return null;
        }
        return this.hmG.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.aaY() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.aaY();
            int intValue = ((Integer) sparseArray.get(aq.hxn)).intValue();
            if (intValue == aq.hxo) {
                if (!this.eiI.cfb()) {
                    this.hmJ.bMD();
                    String str = (String) sparseArray.get(d.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eiI.CE(com.baidu.tbadk.core.util.ap.x(jSONArray));
                    }
                    this.eiI.a(this.hmG.getPbData().getForum().getId(), this.hmG.getPbData().getForum().getName(), this.hmG.getPbData().bHW().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hxp || intValue == aq.hxr) {
                if (this.hmG.bLp() != null) {
                    this.hmG.bLp().wf(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hxp) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hng);
        userMuteAddAndDelCustomMessage.setTag(this.hng);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean zM(String str) {
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
        this.hmS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJL() {
        ArrayList<PostData> bHY;
        int S;
        if (this.hmG == null || this.hmG.getPbData() == null || this.hmG.getPbData().bHY() == null || (S = com.baidu.tbadk.core.util.v.S((bHY = this.hmG.getPbData().bHY()))) == 0) {
            return "";
        }
        if (this.hmG.bLe()) {
            Iterator<PostData> it = bHY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cep() == 1) {
                    return next.getId();
                }
            }
        }
        int bMK = this.hmJ.bMK();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bHY, bMK);
        if (postData == null || postData.YO() == null) {
            return "";
        }
        if (this.hmG.zQ(postData.YO().getUserId())) {
            return postData.getId();
        }
        for (int i = bMK - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bHY, i);
            if (postData2 == null || postData2.YO() == null || postData2.YO().getUserId() == null) {
                break;
            } else if (this.hmG.zQ(postData2.YO().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bMK + 1; i2 < S; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bHY, i2);
            if (postData3 == null || postData3.YO() == null || postData3.YO().getUserId() == null) {
                return "";
            }
            if (this.hmG.zQ(postData3.YO().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.adA().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(zL(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hmG.getPbData().getForum().getId(), this.hmG.getPbData().getForum().getName(), this.hmG.getPbData().bHW().getTid());
            }
            this.hmv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.lz(getResources().getString(d.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.lz(getResources().getString(d.j.make_sure_hide));
        }
        aVar.a(getResources().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hmG.bLo() != null) {
                    PbActivity.this.hmG.bLo().dD(j);
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
        aVar.aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c zN(String str) {
        String str2;
        if (this.hmG.getPbData() == null || this.hmG.getPbData().bHY() == null || this.hmG.getPbData().bHY().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hmG.getPbData().bHY().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hmG.getPbData().bHY().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hmG.getPbData().bHY().get(i);
        if (postData.cer() == null || postData.cer().ast() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cer().ast().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.asA() != null) {
                    str2 = next.asA().asO();
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
        if (this.hmm) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hmm = false;
        } else if (bJM()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hmm) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hmm = false;
        } else if (bJM()) {
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
        if (pageStayDurationItem != null && this.hmG != null) {
            if (this.hmG.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hmG.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hmG.bKO(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bJM() {
        return (!this.hmk && this.hnY == -1 && this.hnZ == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hob = oVar;
            this.hmk = true;
            this.hmJ.bMv();
            this.hmJ.zY(this.hoa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJN() {
        if (this.hob != null) {
            if (this.hnY == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hob.getCartoonId(), this.hnY, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        if (this.hob != null) {
            if (this.hnZ == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hob.getCartoonId(), this.hnZ, 0)));
                finish();
            }
        }
    }

    public int bJP() {
        return this.hnY;
    }

    public int bJQ() {
        return this.hnZ;
    }

    private void bnV() {
        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null && this.hmG.getPbData().bHW().ZI()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bJR() {
        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null && this.hmG.getPbData().bHW().ZI()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bJS() {
        if (this.hmn) {
            this.hmA = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null && this.hmG.getPbData().bHW().Yu() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hmG.getPbData().bHW().Yu().getThreadId(), this.hmG.getPbData().bHW().Yu().getTaskId(), this.hmG.getPbData().bHW().Yu().getForumId(), this.hmG.getPbData().bHW().Yu().getForumName(), this.hmG.getPbData().bHW().YJ(), this.hmG.getPbData().bHW().YK())));
            this.hmm = true;
            finish();
        }
    }

    public String bJT() {
        return this.hmy;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bJU() {
        return this.hmF;
    }

    public void nn(boolean z) {
        this.hmz = z;
    }

    public boolean bJV() {
        if (this.hmG != null) {
            return this.hmG.bKQ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.lz(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hne).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hne.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hne).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oX(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hne != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hne.getPageActivity());
            aVar.lz(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hne).aaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hmJ.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hne.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.lz(this.hne.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.lz(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hmJ.showLoadingDialog();
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
        aVar.b(this.hne).aaW();
    }

    public void bJX() {
        if (this.hmG != null && this.hmG.getPbData() != null && this.hmG.getPbData().bHW() != null && this.hmG.getPbData().bHW().ZY() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.gC(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hmG.getPbData().bHW().ZY().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.aaW();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.Aa(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.hmJ != null) {
            this.hmJ.onConfigurationChanged(configuration);
        }
        if (this.hmP != null) {
            this.hmP.dismiss();
        }
    }

    public boolean bJY() {
        if (this.hmG != null) {
            return this.hmG.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hmG.getPbData().bIh().hkJ;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cem().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cem().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cem().remove(i2);
                    list.get(i).ceo();
                    z = true;
                    break;
                }
            }
            list.get(i).Cy(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.n(this.hmG.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bIA().getId();
        List<PostData> list = this.hmG.getPbData().bIh().hkJ;
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
                ArrayList<PostData> bIE = jVar.bIE();
                postData.zp(jVar.getTotalCount());
                if (postData.cem() != null) {
                    postData.cem().clear();
                    postData.cem().addAll(bIE);
                }
            }
        }
        if (!this.hmG.getIsFromMark()) {
            this.hmJ.n(this.hmG.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bIM() {
        return this.hmK;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIN() {
        if (this.hmG == null) {
            return false;
        }
        return this.hmG.bIN();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIO() {
        if (this.hmG != null) {
            return this.hmG.bIO();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIP() {
        if (this.hmG == null || this.hmG.getPbData() == null) {
            return 0;
        }
        return this.hmG.getPbData().bIi();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zH(String str) {
        return this.hmG != null && this.hmG.zQ(str);
    }

    public void bJZ() {
        if (this.hmJ != null) {
            this.hmJ.bMj();
            bcL();
        }
    }

    public PostData bId() {
        return this.hmJ.c(this.hmG.hsc, this.hmG.bKP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aw(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.isLinkThread()) {
                return 3;
            }
            if (bgVar.aaa()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hnn != null && !this.hnn.isEmpty()) {
            int size = this.hnn.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hnn.get(i).onBackPressed()) {
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
            if (this.hnn == null) {
                this.hnn = new ArrayList();
            }
            if (!this.hnn.contains(aVar)) {
                this.hnn.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hnn == null) {
                this.hnn = new ArrayList();
            }
            if (!this.hnn.contains(aVar)) {
                this.hnn.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hnn != null) {
            this.hnn.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKa() {
        if (this.hmG != null && !com.baidu.tbadk.core.util.ap.isEmpty(this.hmG.bKO())) {
            com.baidu.tbadk.BdToken.c.TX().f(com.baidu.tbadk.BdToken.b.bqG, com.baidu.adp.lib.g.b.d(this.hmG.bKO(), 0L));
        }
    }
}
