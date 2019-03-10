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
    private com.baidu.adp.lib.e.b<TbImageView> bTR;
    private com.baidu.adp.lib.e.b<ImageView> cAv;
    private com.baidu.adp.lib.e.b<GifView> cAw;
    private com.baidu.adp.lib.e.b<TextView> cDk;
    private com.baidu.adp.lib.e.b<View> cDl;
    private com.baidu.adp.lib.e.b<LinearLayout> cDm;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDn;
    private com.baidu.tieba.f.b dMv;
    private VoiceManager eYS;
    private com.baidu.tieba.frs.profession.permission.c fcw;
    private au fzS;
    public com.baidu.tbadk.core.util.aj gyL;
    private com.baidu.tieba.pb.pb.main.b.b hmD;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hmT;
    private View hmU;
    private int hmV;
    private int hmW;
    int hmY;
    private String hmx;
    private BdUniqueId hnA;
    private Runnable hnB;
    private com.baidu.adp.widget.ImageView.a hnC;
    private String hnD;
    private TbRichTextMemeInfo hnE;
    private List<a> hnH;
    private com.baidu.tieba.pb.pb.report.a hnb;
    public as hni;
    private com.baidu.tbadk.core.dialog.g hnj;
    private com.baidu.tbadk.core.dialog.i hnk;
    private boolean hnm;
    private com.baidu.tieba.tbadkCore.data.f hnq;
    private com.baidu.tbadk.editortools.pb.f hnr;
    private com.baidu.tbadk.editortools.pb.d hns;
    private com.baidu.tieba.frs.profession.permission.c hnu;
    private EmotionImageData hnv;
    private com.baidu.adp.base.e hny;
    private com.baidu.tbadk.core.view.e hnz;
    private boolean hoj;
    private String hou;
    private com.baidu.tbadk.core.data.o hov;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLm));
        }
    };
    private static final b.a hop = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // com.baidu.tieba.f.b.a
        public void it(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bIP();
            } else {
                com.baidu.tieba.pb.a.b.bIO();
            }
        }
    };
    private boolean hmC = false;
    private boolean hmE = false;
    private boolean hmF = false;
    private boolean gQf = false;
    private boolean hmG = true;
    private int hmH = 0;
    private com.baidu.tbadk.core.dialog.b hmI = null;
    private long eCP = -1;
    private long cqv = 0;
    private long hmJ = 0;
    private long createTime = 0;
    private long cqn = 0;
    private boolean hmK = false;
    private com.baidu.tbadk.o.b hmL = null;
    private long hmM = 0;
    private boolean hmN = false;
    private long hmO = 0;
    private String cki = null;
    private boolean hmP = false;
    private boolean isFullScreen = false;
    private String hmQ = "";
    private boolean hmR = true;
    private boolean hmS = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hmX = new int[2];
    private PbInterviewStatusView.a hmZ = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.hnd.nN(!PbActivity.this.hmR);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hna != null && PbActivity.this.hna.Vb()) {
                        PbActivity.this.bJK();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hna = null;
    private com.baidu.tbadk.baseEditMark.a hnc = null;
    private ForumManageModel eja = null;
    private com.baidu.tbadk.coreExtra.model.a bKx = null;
    private ShareSuccessReplyToServerModel foI = null;
    private aq hnd = null;
    public final com.baidu.tieba.pb.pb.main.b.a hne = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hnf = false;
    private boolean hng = false;
    private boolean hnh = false;
    private boolean hnl = false;
    private boolean hnn = false;
    private boolean hno = false;
    private boolean hnp = false;
    private boolean hnt = false;
    public boolean hnw = false;
    private com.baidu.tbadk.editortools.pb.c ckl = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void ams() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ckm = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amr() {
            if (PbActivity.this.hni == null || PbActivity.this.hni.bNz() == null || !PbActivity.this.hni.bNz().cnX()) {
                return !PbActivity.this.wd(com.baidu.tbadk.core.util.aj.bKs);
            }
            PbActivity.this.showToast(PbActivity.this.hni.bNz().cnZ());
            if (PbActivity.this.hns != null && (PbActivity.this.hns.amG() || PbActivity.this.hns.amH())) {
                PbActivity.this.hns.a(false, PbActivity.this.hni.bNC());
            }
            PbActivity.this.hni.nZ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hnx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amr() {
            if (PbActivity.this.hni == null || PbActivity.this.hni.bNA() == null || !PbActivity.this.hni.bNA().cnX()) {
                return !PbActivity.this.wd(com.baidu.tbadk.core.util.aj.bKt);
            }
            PbActivity.this.showToast(PbActivity.this.hni.bNA().cnZ());
            if (PbActivity.this.hnd != null && PbActivity.this.hnd.bMp() != null && PbActivity.this.hnd.bMp().bKJ() != null && PbActivity.this.hnd.bMp().bKJ().amH()) {
                PbActivity.this.hnd.bMp().bKJ().a(PbActivity.this.hni.bNC());
            }
            PbActivity.this.hni.oa(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean eZH = false;
    private int hnF = 0;
    private int hnG = -1;
    private final a hnI = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hnd != null && PbActivity.this.hnd.bMp() != null) {
                s bMp = PbActivity.this.hnd.bMp();
                if (bMp.bKH()) {
                    bMp.bKG();
                    return true;
                }
            }
            if (PbActivity.this.hnd != null && PbActivity.this.hnd.bNh()) {
                PbActivity.this.hnd.bNi();
                return true;
            }
            return false;
        }
    };
    private r.a hnJ = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
    };
    private AddExperiencedModel.a eZR = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bJO();
        }
    };
    private final z.a hnK = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hnd.showToast(str);
            }
        }
    };
    private final CustomMessageListener hnL = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hna != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hns != null) {
                    PbActivity.this.hnd.nS(PbActivity.this.hns.amA());
                }
                PbActivity.this.hnd.bMq();
                PbActivity.this.hnd.bNa();
            }
        }
    };
    CustomMessageListener fak = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hna.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hnd != null && PbActivity.this.hna != null) {
                    PbActivity.this.hnd.d(PbActivity.this.hna.getPbData(), PbActivity.this.hna.bKT(), PbActivity.this.hna.getRequestType());
                }
                if (PbActivity.this.hnd != null && PbActivity.this.hnd.bMG() != null) {
                    PbActivity.this.hnd.bMG().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hnM = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hnd != null) {
                    if (booleanValue) {
                        PbActivity.this.hnd.bup();
                    } else {
                        PbActivity.this.hnd.buo();
                    }
                }
            }
        }
    };
    private CustomMessageListener hnN = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hns != null) {
                    PbActivity.this.hnd.nS(PbActivity.this.hns.amA());
                }
                PbActivity.this.hnd.nU(false);
            }
        }
    };
    private CustomMessageListener hnO = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener hnP = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hnd != null && PbActivity.this.hnd.bMG() != null) {
                PbActivity.this.hnd.bMG().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gcG = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener bro = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hmF) {
                PbActivity.this.bKe();
            }
        }
    };
    private h.a hnQ = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void n(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.wf(2);
                aj.bMb().reset();
                PbActivity.this.hna.bLo();
                boolean z2 = false;
                ArrayList<PostData> bIc = PbActivity.this.hna.getPbData().bIc();
                if (bIc != null) {
                    Iterator<PostData> it = bIc.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.ceA().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hnd.o(PbActivity.this.hna.getPbData());
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
    private CustomMessageListener hnR = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hna.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hna.bLf() != null && PbActivity.this.hna.bLf().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hnd.a(aaVar.sendCount, PbActivity.this.hna.getPbData(), PbActivity.this.hna.bKT(), PbActivity.this.hna.getRequestType());
                    }
                    if (pbData.bIc() != null && pbData.bIc().size() >= 1 && pbData.bIc().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bIc().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.hna.bKS(), 0L);
                        if (d2 == aaVar.postId && d3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cez = pbData.bIc().get(0).cez();
                            if (cez == null) {
                                cez = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> XM = cez.XM();
                            if (XM == null) {
                                XM = new ArrayList<>();
                            }
                            XM.add(0, aVar);
                            cez.setTotal(aaVar.sendCount + cez.getTotal());
                            cez.m(XM);
                            pbData.bIc().get(0).a(cez);
                            PbActivity.this.hnd.bMG().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener frK = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                PbActivity.this.zL((String) customResponsedMessage.getData());
                PbActivity.this.hna.bLl();
                if (PbActivity.this.hnd.bMG() != null) {
                    PbActivity.this.hnd.o(PbActivity.this.hna.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hnS = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
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
    private GetSugMatchWordsModel.a hnT = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ac(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.T(list) && PbActivity.this.hnd != null) {
                PbActivity.this.hnd.dD(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hnU = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
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
    private boolean hnV = false;
    private PraiseModel hnW = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void re(String str) {
            PbActivity.this.hnV = false;
            if (PbActivity.this.hnW != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hna.getPbData();
                if (pbData.bIa().YD().getIsLike() == 1) {
                    PbActivity.this.qX(0);
                } else {
                    PbActivity.this.qX(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bIa()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void af(int i, String str) {
            PbActivity.this.hnV = false;
            if (PbActivity.this.hnW != null && str != null) {
                if (AntiHelper.aB(i, str)) {
                    AntiHelper.aV(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hnX = 0;
    private boolean hnY = true;
    private b.a hnZ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void no(boolean z) {
            PbActivity.this.nn(z);
            if (PbActivity.this.hnd.bNn() != null && z) {
                PbActivity.this.hnd.nN(false);
            }
            PbActivity.this.hnd.nP(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().bYy != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().bYy, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLm));
                        }
                    } else if (updateAttentionMessage.getData().Jy) {
                        if (PbActivity.this.bIh().YR() != null && PbActivity.this.bIh().YR().getGodUserData() != null) {
                            PbActivity.this.bIh().YR().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().YR() != null) {
                            PbActivity.this.hna.getPbData().bIa().YR().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a dLM = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hnd.aMF();
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
                    com.baidu.tieba.i.a.blb();
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
            PbActivity.this.bJu();
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
                    if (PbActivity.this.hnd != null && PbActivity.this.hnd.bJs() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").bJ(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.hne != null && PbActivity.this.hne.fAk != null) {
                            PbActivity.this.hne.fAk.onClick(view);
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
            if (PbActivity.this.hns != null) {
                PbActivity.this.hnd.nS(PbActivity.this.hns.amA());
            }
            PbActivity.this.hnd.bMq();
            PbActivity.this.hnd.bNa();
            return true;
        }
    });
    private CustomMessageListener hoa = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnA) {
                PbActivity.this.hnd.aMF();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hna.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bIn().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hnz.i(PbActivity.this.hny.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hny.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.oW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bKa();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hny.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.hnz.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hob = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnA) {
                PbActivity.this.hnd.aMF();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hnz.i(PbActivity.this.hny.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hny.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.hnz.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hoc = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnA) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hnd.aMF();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.iUx;
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
                    PbActivity.this.hnd.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hod = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hnd.bMr() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bJu();
            }
        }
    };
    private CustomMessageListener far = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.eZH = true;
                }
            }
        }
    };
    public a.b hbp = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bcO();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hna.getPageData();
            int pageNum = PbActivity.this.hnd.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.XF()) {
                PbActivity.this.hnd.bNa();
                PbActivity.this.wf(2);
                PbActivity.this.bcN();
                PbActivity.this.hnd.bMK();
                if (com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.hna.wn(PbActivity.this.hnd.getPageNum());
                    if (PbActivity.this.hmD != null) {
                        PbActivity.this.hmD.showFloatingView();
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
    public final View.OnClickListener faZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        /* JADX DEBUG: Multi-variable search result rejected for r4v263, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v267, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v294, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v405, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:578:0x1b7f  */
        /* JADX WARN: Removed duplicated region for block: B:581:0x1bc5  */
        /* JADX WARN: Removed duplicated region for block: B:598:0x1d84  */
        /* JADX WARN: Removed duplicated region for block: B:601:0x1db4  */
        /* JADX WARN: Removed duplicated region for block: B:617:0x1eca  */
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
            bl blVar;
            String[] strArr;
            boolean u;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.hnd.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hna.ny(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hnd.bML();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLW()) {
                        if (view == PbActivity.this.hnd.hvU.csE) {
                            if (PbActivity.this.hnd.nR(PbActivity.this.hna.bKY())) {
                                PbActivity.this.bcN();
                                return;
                            }
                            PbActivity.this.hmG = false;
                            PbActivity.this.hmE = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hnd.hvU.csE);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hnd.bMI() && (PbActivity.this.hnd.hvU.bNW() == null || (view != PbActivity.this.hnd.hvU.bNW().bLV() && view != PbActivity.this.hnd.hvU.bNW().bLT()))) {
                            if (view == PbActivity.this.hnd.bNd()) {
                                if (PbActivity.this.hna != null) {
                                    com.baidu.tbadk.browser.a.ar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hna.getPbData().bIa().YQ().getLink());
                                }
                            } else if (view != PbActivity.this.hnd.hvU.hAT) {
                                if (view == PbActivity.this.hnd.hvU.hAU) {
                                    if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                                        ArrayList<PostData> bIc = PbActivity.this.hna.getPbData().bIc();
                                        if ((bIc == null || bIc.size() <= 0) && PbActivity.this.hna.bKT()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").bJ("tid", PbActivity.this.hna.bKS()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId()));
                                        if (!PbActivity.this.hnd.bNs()) {
                                            PbActivity.this.hnd.bMq();
                                        }
                                        PbActivity.this.bJC();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == d.g.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.kY()) {
                                        PbActivity.this.hnd.ns(true);
                                        PbActivity.this.hnd.bMq();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hnd.bup();
                                            PbActivity.this.bcN();
                                            PbActivity.this.hnd.bMK();
                                            PbActivity.this.hna.zS(PbActivity.this.bJP());
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
                                    if ((PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLS()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                        if (PbActivity.this.hnd.hvU.bNW() != null && view == PbActivity.this.hnd.hvU.bNW().getCancelView()) {
                                            PbActivity.this.hnd.hvU.Qk();
                                        } else if (view.getId() != d.g.pb_editor_tool_share && view.getId() != d.g.share_num_container) {
                                            if (PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLQ()) {
                                                if ((PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLY()) && view.getId() != d.g.pb_sort) {
                                                    if (PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLR()) {
                                                        if (PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLZ()) {
                                                            if (PbActivity.this.hnd.bNn() == view) {
                                                                if (PbActivity.this.hnd.bNn().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hna.getPbData();
                                                                    if (pbData != null && pbData.bIa() != null && pbData.bIa().Yx() != null) {
                                                                        String Yo = pbData.bIa().Yx().Yo();
                                                                        if (StringUtils.isNull(Yo)) {
                                                                            Yo = pbData.bIa().Yx().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").bJ(VideoPlayActivityConfig.OBJ_ID, Yo));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.dX("c10725", null);
                                                                }
                                                                PbActivity.this.bJW();
                                                            } else if (PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLX()) {
                                                                if (PbActivity.this.hnd.hvU.bNW() != null && view == PbActivity.this.hnd.hvU.bNW().bLU()) {
                                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hnd.c(PbActivity.this.hna.getPbData(), PbActivity.this.hna.bKT(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                PbActivity.this.hnd.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hnd.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hnd.hvU.Qk();
                                                                    } else {
                                                                        PbActivity.this.showToast(d.j.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.sub_pb_more || view.getId() == d.g.sub_pb_item || view.getId() == d.g.pb_floor_reply_more || view.getId() == d.g.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hna != null && view.getId() == d.g.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar.bJ("tid", PbActivity.this.hna.bKS());
                                                                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
                                                                        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar.T("obj_locate", 4);
                                                                        TiebaStatic.log(amVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hna.getPbData() != null) {
                                                                            PbActivity.this.hnd.bNa();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(d.g.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(d.g.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.ceD() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                }
                                                                                if (postData.iHe != null) {
                                                                                    com.baidu.tbadk.core.util.am adj = postData.iHe.adj();
                                                                                    adj.delete("obj_locate");
                                                                                    if (view.getId() == d.g.new_sub_pb_list_richText) {
                                                                                        adj.T("obj_locate", 6);
                                                                                    } else if (view.getId() == d.g.pb_floor_reply_more) {
                                                                                        adj.T("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(adj);
                                                                                }
                                                                                String bKS = PbActivity.this.hna.bKS();
                                                                                String id = postData.getId();
                                                                                int i2 = 0;
                                                                                if (PbActivity.this.hna.getPbData() != null) {
                                                                                    i2 = PbActivity.this.hna.getPbData().bIm();
                                                                                }
                                                                                PbActivity.this.bcN();
                                                                                if (view.getId() == d.g.replybtn) {
                                                                                    c zQ = PbActivity.this.zQ(id);
                                                                                    if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && zQ != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKS, id, "pb", true, null, true, null, i2, postData.bOO(), PbActivity.this.hna.getPbData().getAnti(), false, postData.YR().getIconInfo()).addBigImageData(zQ.hoX, zQ.hoY, zQ.hoZ, zQ.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hna.bLA());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hna.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c zQ2 = PbActivity.this.zQ(id);
                                                                                    if (postData != null && PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && zQ2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKS, id, "pb", true, null, false, null, i2, postData.bOO(), PbActivity.this.hna.getPbData().getAnti(), false, postData.YR().getIconInfo()).addBigImageData(zQ2.hoX, zQ2.hoY, zQ2.hoZ, zQ2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hna.bLA());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hna.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.pb_post_reply_count) {
                                                                    if (PbActivity.this.hna != null) {
                                                                        com.baidu.tbadk.core.util.am amVar2 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar2.bJ("tid", PbActivity.this.hna.bKS());
                                                                        amVar2.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
                                                                        amVar2.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar2.T("obj_locate", 5);
                                                                        TiebaStatic.log(amVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                                                                                    String bKS2 = PbActivity.this.hna.bKS();
                                                                                    String id2 = postData2.getId();
                                                                                    int i3 = 0;
                                                                                    if (PbActivity.this.hna.getPbData() != null) {
                                                                                        i3 = PbActivity.this.hna.getPbData().bIm();
                                                                                    }
                                                                                    c zQ3 = PbActivity.this.zQ(id2);
                                                                                    if (zQ3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKS2, id2, "pb", true, null, false, null, i3, postData2.bOO(), PbActivity.this.hna.getPbData().getAnti(), false, postData2.YR().getIconInfo()).addBigImageData(zQ3.hoX, zQ3.hoY, zQ3.hoZ, zQ3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hna.bLA());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hna.getFromForumId());
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
                                                                    if (PbActivity.this.hna != null) {
                                                                        com.baidu.tbadk.core.util.am amVar3 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar3.bJ("tid", PbActivity.this.hna.bKS());
                                                                        amVar3.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
                                                                        amVar3.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar3.T("obj_locate", 6);
                                                                        TiebaStatic.log(amVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.bJr().bMo() != null && postData3.YR() != null && postData3.cer() != 1) {
                                                                                    if (PbActivity.this.bJr().bMp() != null) {
                                                                                        PbActivity.this.bJr().bMp().bKF();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                                                                    jVar.a(PbActivity.this.hna.getPbData().getForum());
                                                                                    jVar.aj(PbActivity.this.hna.getPbData().bIa());
                                                                                    jVar.e(postData3);
                                                                                    PbActivity.this.bJr().bMo().d(jVar);
                                                                                    PbActivity.this.bJr().bMo().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.YR().getUserId(), "");
                                                                                    if (PbActivity.this.hns != null) {
                                                                                        PbActivity.this.hnd.nS(PbActivity.this.hns.amA());
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
                                                                } else if (view != PbActivity.this.hnd.bJm()) {
                                                                    if (view == PbActivity.this.hnd.hvU.bNX()) {
                                                                        PbActivity.this.hnd.bMR();
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").bJ("tid", PbActivity.this.hna.hsa));
                                                                                    }
                                                                                    if (PbActivity.this.hnk == null) {
                                                                                        PbActivity.this.hnk = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                                                                                        PbActivity.this.hnk.a(PbActivity.this.hoo);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cm(view);
                                                                                    if (!PbActivity.this.cm(view) || PbActivity.this.hnC == null || !PbActivity.this.hnC.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hnk);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(fVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cet() != null && postData4.cet().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hnk);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(d.g.tag_clip_board, postData4);
                                                                                            fVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(fVar5);
                                                                                        }
                                                                                        PbActivity.this.fPR = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hna.getPbData().Vb()) {
                                                                                        String Va = PbActivity.this.hna.getPbData().Va();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(Va) && Va.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hnk);
                                                                                            } else {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hnk);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(d.g.tag_clip_board, PbActivity.this.fPR);
                                                                                            sparseArray6.put(d.g.tag_is_subpb, false);
                                                                                            fVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(fVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hnk);
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
                                                                                                    if (!ap.m(PbActivity.this.fPR)) {
                                                                                                        nj = PbActivity.this.nj(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        nj = false;
                                                                                                    }
                                                                                                    if (nj) {
                                                                                                        com.baidu.tbadk.core.dialog.f fVar7 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnk);
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
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnk);
                                                                                                        fVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(d.g.tag_should_delete_visible, false);
                                                                                                        fVar2 = null;
                                                                                                    }
                                                                                                    fVar3 = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hnk);
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
                                                                                                    if (PbActivity.this.hna.getPbData().bIm() == 1002 && !z3) {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnk);
                                                                                                    } else {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnk);
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
                                                                                            PbActivity.this.hnk.P(arrayList);
                                                                                            if (PbActivity.this.hnj != null) {
                                                                                                PbActivity.this.hnj = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hnk.abk());
                                                                                            } else {
                                                                                                PbActivity.this.hnj.setContentView(PbActivity.this.hnk.abk());
                                                                                            }
                                                                                            PbActivity.this.hnj.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(d.g.tag_clip_board, PbActivity.this.fPR);
                                                                                    sparseArray62.put(d.g.tag_is_subpb, false);
                                                                                    fVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(fVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hnk.P(arrayList);
                                                                                    if (PbActivity.this.hnj != null) {
                                                                                    }
                                                                                    PbActivity.this.hnj.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_act_btn) {
                                                                            if (PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), PbActivity.this.hna.getPbData().bIa().getActUrl());
                                                                                if (PbActivity.this.hna.getPbData().bIa().ZB() != 1) {
                                                                                    if (PbActivity.this.hna.getPbData().bIa().ZB() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.lottery_tail) {
                                                                            if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()).bJ("tid", PbActivity.this.hna.getPbData().getThreadId()).bJ("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hna.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hnd.setSelection(0);
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
                                                                                PbActivity.this.hnd.bMq();
                                                                            }
                                                                        } else if (id3 == d.g.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bJz() == 1 && PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()).bJ("tid", PbActivity.this.hna.getPbData().getThreadId()).bJ("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bJz() == 1 && PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()).bJ("tid", PbActivity.this.hna.getPbData().getThreadId()).bJ("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.manga_prev_btn) {
                                                                            PbActivity.this.bJR();
                                                                        } else if (id3 == d.g.manga_next_btn) {
                                                                            PbActivity.this.bJS();
                                                                        } else if (id3 == d.g.yule_head_img_img) {
                                                                            if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIt() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hna.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").bJ(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                ba.adD().c(PbActivity.this.getPageContext(), new String[]{pbData2.bIt().bIA()});
                                                                            }
                                                                        } else if (id3 == d.g.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIt() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hna.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                ba.adD().c(PbActivity.this.getPageContext(), new String[]{pbData3.bIt().bIA()});
                                                                            }
                                                                        } else if (PbActivity.this.hnd.hvU.bNW() != null && view == PbActivity.this.hnd.hvU.bNW().bMa()) {
                                                                            if (PbActivity.this.hna == null || PbActivity.this.hna.getPbData() == null || PbActivity.this.hna.getPbData().bIa() == null) {
                                                                                PbActivity.this.hnd.hvU.Qk();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.lo()) {
                                                                                PbActivity.this.showToast(d.j.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i4 = 1;
                                                                                if (PbActivity.this.hna.getPbData().bIa().Yy() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hna.bKS(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).abh();
                                                                                    i4 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").T("obj_locate", PbActivity.this.ax(PbActivity.this.hna.getPbData().bIa())).bJ("tid", PbActivity.this.hna.getPbData().bIa().getTid()).T("obj_type", i4));
                                                                            }
                                                                        } else if (id3 == d.g.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hnF >= 0) {
                                                                                if (PbActivity.this.hna != null) {
                                                                                    PbActivity.this.hna.bLB();
                                                                                }
                                                                                if (PbActivity.this.hnd.bMG() != null) {
                                                                                    PbActivity.this.hnd.bMG().a(PbActivity.this.hna.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hnd.getListView().setSelection(PbActivity.this.hna.bLE());
                                                                                PbActivity.this.hnF = 0;
                                                                                if (PbActivity.this.hna != null) {
                                                                                    PbActivity.this.hna.bU(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == d.g.thread_info_commont_container) {
                                                                            PbActivity.this.bJw();
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
                                                                            if (PbActivity.this.hna.getPbData().bIa().YI() > 0) {
                                                                                if (PbActivity.this.mLastScrollState == 0) {
                                                                                    int firstVisiblePosition = PbActivity.this.hnd.getListView().getFirstVisiblePosition();
                                                                                    int top = PbActivity.this.hnd.getListView().getChildAt(0).getTop();
                                                                                    if (firstVisiblePosition != 0 || top != 0 || PbActivity.this.hmW != 0 || PbActivity.this.hmV != 0) {
                                                                                        if (firstVisiblePosition == 0 && top <= 0 && top >= (-PbActivity.this.getResources().getDimension(d.e.tbds66))) {
                                                                                            if (PbActivity.this.hnd.getListView().getChildAt(PbActivity.this.hmW) != null) {
                                                                                                PbActivity.this.hnd.getListView().smoothScrollToPosition(PbActivity.this.hmW, PbActivity.this.hmV, 200);
                                                                                            } else {
                                                                                                PbActivity.this.hnd.getListView().setSelectionFromTop(PbActivity.this.hmW, PbActivity.this.hmV + ((int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d)));
                                                                                                PbActivity.this.hnd.getListView().smoothScrollBy((int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d), 500);
                                                                                            }
                                                                                        } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-com.baidu.adp.lib.util.l.aQ(PbActivity.this)) * 0.6d)) {
                                                                                            PbActivity.this.hnd.getListView().setSelectionFromTop(0, -((int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d)));
                                                                                            PbActivity.this.hnd.getListView().smoothScrollBy(-((int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d)), 500);
                                                                                        } else {
                                                                                            PbActivity.this.hnd.getListView().smoothScrollToPosition(0, 0, 500);
                                                                                        }
                                                                                        PbActivity.this.hmW = firstVisiblePosition;
                                                                                        PbActivity.this.hmV = top;
                                                                                        if (PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().YR() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hna.hsa).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hna.getPbData().bIa().YR().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bJw();
                                                                                if (PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().YR() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hna.hsa).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hna.getPbData().bIa().YR().getUserId()));
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_nav_title_forum_image || id3 == d.g.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(PbActivity.this.hna.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hna.bLA() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hna.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar4 = new com.baidu.tbadk.core.util.am("c13401");
                                                                                amVar4.bJ("tid", PbActivity.this.hna.bKS());
                                                                                amVar4.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
                                                                                amVar4.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hna.bLA() == 3 && PbActivity.this.bIR() && PbActivity.this.hna.getPbData() != null && com.baidu.tbadk.core.util.v.T(PbActivity.this.hna.getPbData().bIv())) {
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
                                                                            if (PbActivity.this.hna != null) {
                                                                                com.baidu.tbadk.core.util.am amVar6 = new com.baidu.tbadk.core.util.am("c13398");
                                                                                amVar6.bJ("tid", PbActivity.this.hna.bKS());
                                                                                amVar6.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
                                                                                amVar6.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                amVar6.T("obj_locate", 2);
                                                                                TiebaStatic.log(amVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.hna.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.hna.bKS(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hna.getPbData().bIa().Zl())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.kY()) {
                                                                PbActivity.this.hnd.bNa();
                                                                SparseArray<Object> c3 = PbActivity.this.hnd.c(PbActivity.this.hna.getPbData(), PbActivity.this.hna.bKT(), 1);
                                                                if (c3 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hna.getPbData().getForum().getId(), PbActivity.this.hna.getPbData().getForum().getName(), PbActivity.this.hna.getPbData().bIa().getId(), String.valueOf(PbActivity.this.hna.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_name_show), (String) c3.get(d.g.tag_forbid_user_post_id), (String) c3.get(d.g.tag_forbid_user_portrait))));
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
                                                            PbActivity.this.hnd.hvU.bNV();
                                                        }
                                                    } else if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null) {
                                                        PbActivity.this.hnd.hvU.Qk();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                        PbActivity.this.zN(PbActivity.this.hna.getPbData().bIa().Zh());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hnd.bNa();
                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hna.bLj()));
                                                            return;
                                                        }
                                                        PbActivity.this.wf(2);
                                                        PbActivity.this.bcN();
                                                        PbActivity.this.hnd.bMK();
                                                        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hna.getPbData().hkw == null || PbActivity.this.hna.getPbData().hkw.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(d.j.sort_type_new), PbActivity.this.getResources().getString(d.j.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hna.getPbData().hkw.size()];
                                                            int i5 = 0;
                                                            while (true) {
                                                                int i6 = i5;
                                                                if (i6 >= PbActivity.this.hna.getPbData().hkw.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i6] = PbActivity.this.hna.getPbData().hkw.get(i6).sort_name + PbActivity.this.getResources().getString(d.j.sort_static);
                                                                i5 = i6 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        gVar.a(null, strArr, new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                                            @Override // com.baidu.tbadk.core.dialog.i.c
                                                            public void a(com.baidu.tbadk.core.dialog.i iVar, int i7, View view3) {
                                                                int i8 = 2;
                                                                gVar.dismiss();
                                                                if (PbActivity.this.hna.getSortType() == 1 && i7 == 1) {
                                                                    i8 = 0;
                                                                } else if (PbActivity.this.hna.getSortType() == 2 && i7 == 0) {
                                                                    i8 = 1;
                                                                } else if (PbActivity.this.hna.getSortType() != 3 || i7 == 2) {
                                                                    i8 = (i7 != 2 || PbActivity.this.hna.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != d.g.pb_sort ? 1 : 0).T("obj_type", i8));
                                                                if (PbActivity.this.hna.getPbData().hkw != null && PbActivity.this.hna.getPbData().hkw.size() > i7) {
                                                                    i7 = PbActivity.this.hna.getPbData().hkw.get(i7).sort_type.intValue();
                                                                }
                                                                boolean ws = PbActivity.this.hna.ws(i7);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hna.bLj()));
                                                                if (ws) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hnd.nJ(true);
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
                                                PbActivity.this.hnd.bNa();
                                                if (PbActivity.this.bJb().getPbData().hkx != 2) {
                                                    if (PbActivity.this.hna.getPageData() != null) {
                                                        PbActivity.this.hnd.a(PbActivity.this.hna.getPageData(), PbActivity.this.hbp);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(d.j.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (az.jK() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().YR() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hna.hsa).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()).T("obj_locate", 4).bJ("uid", PbActivity.this.hna.getPbData().bIa().YR().getUserId()));
                                            }
                                            if (PbActivity.this.hna != null) {
                                                com.baidu.tbadk.core.util.am amVar7 = new com.baidu.tbadk.core.util.am("c12386");
                                                amVar7.bJ("tid", PbActivity.this.hna.bKS());
                                                amVar7.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                amVar7.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
                                                amVar7.T("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    amVar7.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(amVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.lo()) {
                                                if (PbActivity.this.hna.getPbData() != null) {
                                                    ArrayList<PostData> bIc2 = PbActivity.this.hna.getPbData().bIc();
                                                    if ((bIc2 != null && bIc2.size() > 0) || !PbActivity.this.hna.bKT()) {
                                                        PbActivity.this.hnd.bNa();
                                                        PbActivity.this.bcN();
                                                        PbActivity.this.wf(2);
                                                        if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIt() != null && !StringUtils.isNull(PbActivity.this.hna.getPbData().bIt().Xn(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                        if (az.jK()) {
                                                            PbActivity.this.wg(2);
                                                        } else {
                                                            PbActivity.this.hnd.showLoadingDialog();
                                                            PbActivity.this.hna.bLv().m(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hnd.bNa();
                                        if (PbActivity.this.hnd.hvU.bNW() != null && view == PbActivity.this.hnd.hvU.bNW().bLS() && !PbActivity.this.hnd.bNs()) {
                                            PbActivity.this.hnd.bMq();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bcN();
                                            PbActivity.this.hnd.bMK();
                                            if (view.getId() == d.g.floor_owner_reply) {
                                                u = PbActivity.this.hna.u(true, PbActivity.this.bJP());
                                            } else {
                                                u = view.getId() == d.g.reply_title ? PbActivity.this.hna.u(false, PbActivity.this.bJP()) : PbActivity.this.hna.zS(PbActivity.this.bJP());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hnd.ns(true);
                                                PbActivity.this.hnd.bup();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hnd.nJ(true);
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
                                    PbActivity.this.hnd.bNa();
                                    if (PbActivity.this.we(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && com.baidu.tbadk.plugins.c.b(PbActivity.this.getPageContext(), "com.baidu.tieba.pluginCore") && PbActivity.this.hna.wt(PbActivity.this.hnd.bMP()) != null) {
                                        PbActivity.this.bJJ();
                                        if (PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().YR() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hna.hsa).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId()).T("obj_locate", 3).bJ("uid", PbActivity.this.hna.getPbData().bIa().YR().getUserId()));
                                        }
                                        if (PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().YR() != null && PbActivity.this.hna.getPbData().bIa().YR().getUserId() != null && PbActivity.this.hnc != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hna.hsa).T("obj_locate", 1).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hna.getPbData().bIa().YR().getUserId()).T("obj_type", PbActivity.this.hnc.Vb() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hna.getPbData())));
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
                                if (PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().ZL() && PbActivity.this.hna.getPbData().bIa().Zi() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.hna.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hna.bIS()) && PbActivity.this.hna.getAppealInfo() != null) {
                                        name = PbActivity.this.hna.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hna.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bIS = PbActivity.this.hna.bIS();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hna.bKU() && bIS != null && bIS.equals(name)) {
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
                            if (PbActivity.this.hna.getPbData() != null) {
                                if ((PbActivity.this.hna.getPbData().bIm() == 1 || PbActivity.this.hna.getPbData().bIm() == 3) && !PbActivity.this.eja.cfd()) {
                                    PbActivity.this.hnd.bNa();
                                    int i7 = 0;
                                    if (PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLT()) {
                                        if (PbActivity.this.hnd.hvU.bNW() == null || view != PbActivity.this.hnd.hvU.bNW().bLV()) {
                                            if (view == PbActivity.this.hnd.bMI()) {
                                                i7 = 2;
                                            }
                                        } else if (PbActivity.this.hna.getPbData().bIa().YN() == 1) {
                                            i7 = 3;
                                        } else {
                                            i7 = 6;
                                        }
                                    } else if (PbActivity.this.hna.getPbData().bIa().YM() == 1) {
                                        i7 = 5;
                                    } else {
                                        i7 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hna.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hna.getPbData().bIa().getId();
                                    PbActivity.this.hnd.bMH();
                                    PbActivity.this.eja.a(id4, name2, id5, i7, PbActivity.this.hnd.bMJ());
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
                        PbActivity.this.hnd.bNa();
                        PbActivity.this.bcN();
                        PbActivity.this.hnd.bMK();
                        PbActivity.this.hnd.showLoadingDialog();
                        if (PbActivity.this.hnd.bMy() != null) {
                            PbActivity.this.hnd.bMy().setVisibility(8);
                        }
                        PbActivity.this.hna.wn(1);
                        if (PbActivity.this.hmD != null) {
                            PbActivity.this.hmD.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(d.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(d.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == d.g.reply_god_title_group) {
                        String bJx = PbActivity.this.bJx();
                        if (!TextUtils.isEmpty(bJx)) {
                            ba.adD().c(PbActivity.this.getPageContext(), new String[]{bJx});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hna != null) {
                    com.baidu.tbadk.core.util.am amVar8 = new com.baidu.tbadk.core.util.am("c13398");
                    amVar8.bJ("tid", PbActivity.this.hna.bKS());
                    amVar8.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
                    amVar8.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar8.T("obj_locate", 1);
                    TiebaStatic.log(amVar8);
                }
                if (PbActivity.this.hmN) {
                    PbActivity.this.hmN = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.bJr().bMo() != null && postData5.YR() != null && postData5.cer() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bJr().bMp() != null) {
                                PbActivity.this.bJr().bMp().bKF();
                            }
                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                            jVar2.a(PbActivity.this.hna.getPbData().getForum());
                            jVar2.aj(PbActivity.this.hna.getPbData().bIa());
                            jVar2.e(postData5);
                            PbActivity.this.bJr().bMo().d(jVar2);
                            PbActivity.this.bJr().bMo().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.YR().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hna.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hns != null) {
                                PbActivity.this.hnd.nS(PbActivity.this.hns.amA());
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
                if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId());
                }
                if (PbActivity.this.hna != null) {
                    amVar.bJ("tid", PbActivity.this.hna.bKS());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.bcN();
            PbActivity.this.hnd.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.s.ap.apH() && PbActivity.this.bJb() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bJb().zV(postWriteCallBackData.getPostId());
                    PbActivity.this.hnF = PbActivity.this.hnd.bMu();
                    if (PbActivity.this.hna != null) {
                        PbActivity.this.hna.bU(PbActivity.this.hnF, PbActivity.this.hnd.bMv());
                    }
                }
                PbActivity.this.hnd.bNa();
                PbActivity.this.hni.bNy();
                if (PbActivity.this.hns != null) {
                    PbActivity.this.hnd.nS(PbActivity.this.hns.amA());
                }
                PbActivity.this.hnd.bMn();
                PbActivity.this.hnd.nU(true);
                PbActivity.this.hna.bLl();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hna.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hna.getPbData();
                            if (pbData != null && pbData.bIa() != null && pbData.bIa().YR() != null && (userId = pbData.bIa().YR().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.s.ap.apH() && PbActivity.this.hna.bLc()) {
                                PbActivity.this.hnd.bMK();
                            }
                        } else if (!com.baidu.tbadk.s.ap.apH() && PbActivity.this.hna.bLc()) {
                            PbActivity.this.hnd.bMK();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hnd.o(PbActivity.this.hna.getPbData());
                    }
                    if (PbActivity.this.hna.bKX()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").bJ("tid", PbActivity.this.hna.bKS()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hns.amG() || PbActivity.this.hns.amH()) {
                    PbActivity.this.hns.a(false, postWriteCallBackData);
                }
                PbActivity.this.hni.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gyL != null) {
                    PbActivity.this.gyL.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hoe = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getPbData().getForumId());
                }
                if (PbActivity.this.hna != null) {
                    amVar.bJ("tid", PbActivity.this.hna.bKS());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (PbActivity.this.hni != null) {
                    PbActivity.this.hni.bNx();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gyL != null) {
                    PbActivity.this.gyL.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hni != null) {
                if (PbActivity.this.hnd != null && PbActivity.this.hnd.bMp() != null && PbActivity.this.hnd.bMp().bKJ() != null && PbActivity.this.hnd.bMp().bKJ().amH()) {
                    PbActivity.this.hnd.bMp().bKJ().a(postWriteCallBackData);
                }
                PbActivity.this.hni.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a hof = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g jt;
            if (!z || dVar == null || dVar.bIk() != null || com.baidu.tbadk.core.util.v.S(dVar.bIc()) >= 1) {
                PbActivity.this.gQf = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hnd.bMM();
                if (dVar == null || !dVar.bIg()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hnd.getView());
                }
                PbActivity.this.hnd.buo();
                if (PbActivity.this.isFullScreen || PbActivity.this.hnd.bNs()) {
                    PbActivity.this.hnd.bNj();
                } else if (!PbActivity.this.hnd.bNg()) {
                    PbActivity.this.hnd.nU(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hnl = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hnd.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hnd.aOB();
                    if (dVar.bIa() != null && dVar.bIa().ZU() != null) {
                        PbActivity.this.a(dVar.bIa().ZU());
                    }
                    PbActivity.this.bJo();
                    if (PbActivity.this.hns != null) {
                        PbActivity.this.hnd.nS(PbActivity.this.hns.amA());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bIc() != null && dVar.bIc().size() >= 1 && dVar.bIc().get(0) != null) {
                        PbActivity.this.hna.zU(dVar.bIc().get(0).getId());
                    } else if (dVar.bIk() != null) {
                        PbActivity.this.hna.zU(dVar.bIk().getId());
                    }
                    if (PbActivity.this.hns != null) {
                        PbActivity.this.hns.a(dVar.getAnti());
                        PbActivity.this.hns.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hns.a(PbActivity.this.hna.bLf(), PbActivity.this.hna.bKS(), PbActivity.this.hna.bLx());
                        if (dVar.bIa() != null) {
                            PbActivity.this.hns.eO(dVar.bIa().aaj());
                        }
                    }
                    if (PbActivity.this.hnc != null) {
                        PbActivity.this.hnc.cZ(dVar.Vb());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hnd.nT(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hnd.a(dVar, i2, i3, PbActivity.this.hna.bKT(), i4, PbActivity.this.hna.getIsFromMark());
                    PbActivity.this.hnd.e(dVar, PbActivity.this.hna.bKT());
                    PbActivity.this.hnd.nQ(PbActivity.this.hna.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.cki = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.cki) && PbActivity.this.hns != null && PbActivity.this.hns.alT() != null && (jt = PbActivity.this.hns.alT().jt(6)) != null && !TextUtils.isEmpty(PbActivity.this.cki)) {
                            ((View) jt).setOnClickListener(PbActivity.this.ckW);
                        }
                    }
                    if (PbActivity.this.hnn) {
                        PbActivity.this.hnn = false;
                        final int bJE = PbActivity.this.bJE();
                        if (!dVar.bIy()) {
                            PbActivity.this.hnd.wz(bJE);
                        } else {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bJE, aO);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hno) {
                        PbActivity.this.hno = false;
                        final int bJE2 = PbActivity.this.bJE();
                        final boolean z2 = bJE2 != -1;
                        if (!z2) {
                            bJE2 = PbActivity.this.bJF();
                        }
                        if (PbActivity.this.hnd != null) {
                            if (!dVar.bIy()) {
                                PbActivity.this.hnd.wz(bJE2);
                            } else {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bJE2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hnd.setSelectionFromTop(bJE2, aO2);
                                            } else {
                                                PbActivity.this.hnd.setSelectionFromTop(bJE2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hnd.nV(true);
                            }
                        }
                    } else if (PbActivity.this.hnp) {
                        PbActivity.this.hnp = false;
                        PbActivity.this.hnd.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hnd.bMQ();
                    }
                    PbActivity.this.hna.a(dVar.getForum(), PbActivity.this.hnS);
                    PbActivity.this.hna.a(PbActivity.this.hnT);
                    if (PbActivity.this.gyL != null && dVar.bIa() != null && dVar.bIa().YR() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bIa().YR());
                        PbActivity.this.gyL.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hnl && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hna != null && PbActivity.this.hna.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hna.getAppealInfo().hjQ)) {
                                    PbActivity.this.hnd.a(PbActivity.this.hna.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hnd.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hnd.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                            }
                            PbActivity.this.hnd.bNj();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hna.bKS());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
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
                        PbActivity.this.hnd.zY("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                            arrayList = PbActivity.this.hna.getPbData().bIc();
                        }
                        if (com.baidu.tbadk.core.util.v.S(arrayList) != 0 && (com.baidu.tbadk.core.util.v.S(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cer() != 1)) {
                            PbActivity.this.hnd.zY(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                        } else if (PbActivity.this.bKc()) {
                            PbActivity.this.hnd.zZ(PbActivity.this.getResources().getString(d.j.pb_no_host_reply));
                        } else {
                            PbActivity.this.hnd.zZ(PbActivity.this.getResources().getString(d.j.pb_no_replay));
                        }
                    }
                    PbActivity.this.hnd.aeD();
                }
                PbActivity.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bJb().bKT() || PbActivity.this.bJb().getPbData().getPage().XL() != 0 || PbActivity.this.bJb().bLr()) {
                    PbActivity.this.hnt = true;
                    return;
                }
                return;
            }
            PbActivity.this.hna.wn(1);
            if (PbActivity.this.hmD != null) {
                PbActivity.this.hmD.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hnd.o(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.o.m.apl().apm()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eCP : j;
                com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(i, z, responsedMessage, PbActivity.this.cqn, PbActivity.this.createTime, PbActivity.this.cqv, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cqn = 0L;
                if (iVar != null) {
                    iVar.aph();
                }
                if (z2) {
                    iVar.cqE = currentTimeMillis;
                    iVar.fe(true);
                }
                if (!z2 && PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null) {
                    int threadType = PbActivity.this.hna.getPbData().bIa().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmQ, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmQ, "from_frs")) {
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
    private CustomMessageListener hog = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bJA();
            }
        }
    };
    private final a.InterfaceC0187a hoh = new a.InterfaceC0187a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0187a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hnd.bMM();
            if (z) {
                if (PbActivity.this.hnc != null) {
                    PbActivity.this.hnc.cZ(z2);
                }
                PbActivity.this.hna.nA(z2);
                if (PbActivity.this.hna.Vb()) {
                    PbActivity.this.bJK();
                } else {
                    PbActivity.this.hnd.o(PbActivity.this.hna.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hnc != null && PbActivity.this.hnc.Ve() != null && PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().YR() != null) {
                        MarkData Ve = PbActivity.this.hnc.Ve();
                        MetaData YR = PbActivity.this.hna.getPbData().bIa().YR();
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
                if (PbActivity.this.hnd != null) {
                    PbActivity.this.hnd.bNa();
                    if (PbActivity.this.hns != null && !PbActivity.this.hnd.bMr()) {
                        PbActivity.this.hnd.nS(PbActivity.this.hns.amA());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hnd.bMq();
                    }
                }
                if (!PbActivity.this.hmK) {
                    PbActivity.this.hmK = true;
                    PbActivity.this.hnd.bNf();
                }
            }
            PbActivity.this.hnd.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hmD != null) {
                PbActivity.this.hmD.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hmL == null) {
                PbActivity.this.hmL = new com.baidu.tbadk.o.b();
                PbActivity.this.hmL.jX(1001);
            }
            if (i == 0) {
                PbActivity.this.hmL.apb();
            } else {
                PbActivity.this.hmL.apa();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.cdr().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bIc;
            if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hnd != null && PbActivity.this.hnd.bMG() != null) {
                PbActivity.this.hnd.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hmD != null) {
                    PbActivity.this.hmD.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hna.bLn() && (bIc = PbActivity.this.hna.getPbData().bIc()) != null && !bIc.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hnd.bMG().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hna.getPbData();
                    if (pbData != null) {
                        if (pbData.bId() != null && pbData.bId().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bIe() != null && pbData.bIe().hasData()) {
                            headerCount--;
                        }
                        int size = bIc.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eje = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eja.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hna.bLl();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCN != 1002 || bVar.fDg) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hnd.a(1, dVar.Id, dVar.iIK, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eja.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hnd.a(PbActivity.this.eja.getLoadDataMode(), gVar.Id, gVar.iIK, false);
                        PbActivity.this.hnd.at(gVar.iIN);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hnd.a(PbActivity.this.eja.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hoi = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final h.c cPx = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (PbActivity.this.bJQ()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hna.nz(true)) {
                PbActivity.this.hnd.bMN();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fsS = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hoj && PbActivity.this.bJQ()) {
                PbActivity.this.bJS();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hna.ny(false)) {
                    PbActivity.this.hnd.bML();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hna.getPbData() != null) {
                    PbActivity.this.hnd.bNe();
                }
                PbActivity.this.hoj = true;
            }
        }
    };
    private int hok = 0;
    private final TbRichTextView.h cAE = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bMG;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hna != null) {
                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                        amVar.bJ("tid", PbActivity.this.hna.bKS());
                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId());
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
                        PbActivity.this.hmU = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hpa) {
                        TbRichText bh = PbActivity.this.bh(str, i);
                        if (bh != null && PbActivity.this.hok >= 0 && PbActivity.this.hok < bh.asx().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bh.asx().get(PbActivity.this.hok));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hoX.size()) {
                                    break;
                                } else if (!cVar.hoX.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bh.getPostId() != 0 && (bMG = PbActivity.this.hnd.bMG()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bMG.getDataList();
                                if (com.baidu.tbadk.core.util.v.S(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bh.getPostId() == com.baidu.adp.lib.g.b.d(((PostData) next).getId(), 0L)) {
                                            if (bh.getPostId() != com.baidu.adp.lib.g.b.d(PbActivity.this.hna.bLx(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hna.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.T(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hoY.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoZ, cVar.lastId, PbActivity.this.hna.bLi(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.m(rect);
                            createConfig.setIsHotSort(PbActivity.this.hna.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hoX, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.T(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hoY.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoZ, cVar.hoX.get(0), PbActivity.this.hna.bLi(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hna.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hnd.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hol = false;
    PostData fPR = null;
    private final b.InterfaceC0191b hom = new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.fPR != null) {
                if (i == 0) {
                    PbActivity.this.fPR.ev(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fPR = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fPR);
                }
            }
        }
    };
    private final b.InterfaceC0191b hon = new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hnC != null && !TextUtils.isEmpty(PbActivity.this.hnD)) {
                if (i == 0) {
                    if (com.baidu.tbadk.plugins.c.b(PbActivity.this.getPageContext(), "com.baidu.tieba.pluginResource")) {
                        if (PbActivity.this.hnE == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnD));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hnD;
                            aVar.pkgId = PbActivity.this.hnE.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnE.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.adQ();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.Y(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fzS == null) {
                            PbActivity.this.fzS = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fzS.h(PbActivity.this.hnD, PbActivity.this.hnC.oB());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hnC = null;
                PbActivity.this.hnD = null;
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
                        PbActivity.this.hnC = ((TbImageView) view).getBdImage();
                        PbActivity.this.hnD = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hnC == null || TextUtils.isEmpty(PbActivity.this.hnD)) {
                            return true;
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnE = null;
                        } else {
                            PbActivity.this.hnE = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hnC = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hnD = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hnE = null;
                            } else {
                                PbActivity.this.hnE = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hnC = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hnD = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnE = null;
                        } else {
                            PbActivity.this.hnE = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        PbActivity.this.hnd.a(PbActivity.this.hon, PbActivity.this.hnC.isGif());
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
            PbActivity.this.fPR = (PostData) sparseArray2.get(d.g.tag_clip_board);
            if (PbActivity.this.fPR == null) {
                return true;
            }
            if (PbActivity.this.fPR.cer() != 1 || !PbActivity.this.cm(view)) {
                if (PbActivity.this.hnc != null) {
                    if (!PbActivity.this.hnc.Vb() || PbActivity.this.fPR.getId() == null || !PbActivity.this.fPR.getId().equals(PbActivity.this.hna.Za())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.fPR.cer() == 1) {
                        PbActivity.this.hnd.a(PbActivity.this.hom, z, false);
                        return true;
                    }
                    if (PbActivity.this.hnk == null) {
                        PbActivity.this.hnk = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                        PbActivity.this.hnk.a(PbActivity.this.hoo);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cm = PbActivity.this.cm(view);
                        boolean z3 = (!PbActivity.this.cm(view) || PbActivity.this.hnC == null || PbActivity.this.hnC.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hnk);
                            fVar3.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                            fVar3.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                            fVar3.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(fVar3);
                        }
                        if (cm) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, PbActivity.this.getString(d.j.save_to_emotion), PbActivity.this.hnk));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(2, PbActivity.this.getString(d.j.save_to_local), PbActivity.this.hnk));
                        }
                        if (!cm && !z3) {
                            com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hnk);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(d.g.tag_clip_board, PbActivity.this.fPR);
                            fVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(fVar4);
                        }
                        if (!z4) {
                            if (z) {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hnk);
                            } else {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hnk);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(d.g.tag_clip_board, PbActivity.this.fPR);
                            sparseArray4.put(d.g.tag_is_subpb, false);
                            fVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(fVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hnk);
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
                                if (!ap.m(PbActivity.this.fPR)) {
                                    nj = PbActivity.this.nj(z5) & PbActivity.this.isLogin();
                                } else {
                                    nj = false;
                                }
                                if (nj) {
                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnk);
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
                                    fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnk);
                                    fVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(d.g.tag_should_delete_visible, false);
                                }
                                fVar = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hnk);
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
                                    if (PbActivity.this.hna.getPbData().bIm() == 1002 && !z5) {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnk);
                                    } else {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnk);
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
                        PbActivity.this.hnk.P(arrayList);
                        if (PbActivity.this.hnj == null) {
                            PbActivity.this.hnj = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hnk.abk());
                        } else {
                            PbActivity.this.hnj.setContentView(PbActivity.this.hnk.abk());
                        }
                        PbActivity.this.hnj.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").bJ("tid", PbActivity.this.hna.hsa).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId()).bJ("uid", PbActivity.this.hna.getPbData().bIa().YR().getUserId()).bJ("post_id", PbActivity.this.hna.amp()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hnd.a(PbActivity.this.hon, PbActivity.this.hnC.isGif());
            return true;
        }
    };
    private i.c hoo = new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.i.c
        public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
            if (PbActivity.this.hnj != null) {
                PbActivity.this.hnj.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hna.getPbData();
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
                    if (PbActivity.this.hnC != null && !TextUtils.isEmpty(PbActivity.this.hnD)) {
                        if (PbActivity.this.hnE == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnD));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hnD;
                            aVar.pkgId = PbActivity.this.hnE.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnE.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hnC = null;
                        PbActivity.this.hnD = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hnC != null && !TextUtils.isEmpty(PbActivity.this.hnD)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.adQ();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.Y(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fzS == null) {
                                PbActivity.this.fzS = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fzS.h(PbActivity.this.hnD, PbActivity.this.hnC.oB());
                            PbActivity.this.hnC = null;
                            PbActivity.this.hnD = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.fPR != null) {
                        PbActivity.this.fPR.ev(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.fPR = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").T("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.cl(view);
                        if (PbActivity.this.hna.getPbData().bIa() != null && PbActivity.this.hna.getPbData().bIa().YR() != null && PbActivity.this.hna.getPbData().bIa().YR().getUserId() != null && PbActivity.this.hnc != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hna.hsa).T("obj_locate", 2).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hna.getPbData().bIa().YR().getUserId()).T("obj_type", PbActivity.this.hnc.Vb() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hna.getPbData())));
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
                        PbActivity.this.zN((String) tag);
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
                        PbActivity.this.hnd.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hnd.cs(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hnd.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a eWE = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (!PbActivity.this.hmF && z && !PbActivity.this.hna.bKZ()) {
                PbActivity.this.bJM();
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
            PbActivity.this.dMv.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0243a dMw = new a.InterfaceC0243a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        final int dWo;

        {
            this.dWo = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aR(int i, int i2) {
            if (av(i2) && PbActivity.this.hnd != null && PbActivity.this.hmD != null) {
                PbActivity.this.hnd.bNk();
                PbActivity.this.hmD.jr(false);
                PbActivity.this.hmD.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aS(int i, int i2) {
            if (av(i2) && PbActivity.this.hnd != null && PbActivity.this.hmD != null) {
                PbActivity.this.hmD.jr(true);
                if (Math.abs(i2) > this.dWo) {
                    PbActivity.this.hmD.hideFloatingView();
                }
                if (PbActivity.this.bJQ()) {
                    PbActivity.this.hnd.bMD();
                    PbActivity.this.hnd.bME();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aT(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String hoq = null;
    private final m.a hor = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void k(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hoq = str2;
                PbActivity.this.hnd.Aa(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hos = -1;
    private int hot = -1;
    private CustomMessageListener how = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bvT == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0189a) {
                    if (aVar.bvU != null && !aVar.bvU.hasError() && aVar.bvU.getError() == 0) {
                        if (PbActivity.this.hnd != null) {
                            PbActivity.this.hnd.s(((a.C0189a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bKb();
                        }
                    } else if (z) {
                        if (aVar.bvU != null && aVar.bvU.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bvU.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bvU != null && !aVar.bvU.hasError() && aVar.bvU.getError() == 0) {
                        if (PbActivity.this.hnd != null && PbActivity.this.hnd != null) {
                            PbActivity.this.hnd.s(((a.C0189a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bvU != null && aVar.bvU.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bvU.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bvU == null || aVar.bvU.hasError() || aVar.bvU.getError() != 0) {
                        if (z) {
                            if (aVar.bvU != null && aVar.bvU.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bvU.getErrorString());
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
        public ArrayList<String> hoX;
        public ConcurrentHashMap<String, ImageUrlData> hoY;
        public boolean hpa;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hoZ = false;
        public boolean hpb = false;
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

    public com.baidu.tbadk.editortools.pb.d bJn() {
        return this.hns;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bIE() != null) {
            String id = jVar.bIE().getId();
            ArrayList<PostData> bIc = this.hna.getPbData().bIc();
            int i = 0;
            while (true) {
                if (i >= bIc.size()) {
                    break;
                }
                PostData postData = bIc.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bII = jVar.bII();
                    postData.zt(jVar.getTotalCount());
                    if (postData.ceo() != null && bII != null) {
                        Iterator<PostData> it = bII.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.YR() != null && (metaData = postData.getUserMap().get(next.YR().getUserId())) != null) {
                                next.a(metaData);
                                next.pY(true);
                                next.a(getPageContext(), this.hna.zT(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bII.size() != postData.ceo().size();
                        postData.ceo().clear();
                        postData.ceo().addAll(bII);
                        z = z2;
                    }
                    if (postData.cek() != null) {
                        postData.cel();
                    }
                }
            }
            if (!this.hna.getIsFromMark() && z) {
                this.hnd.o(this.hna.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bIp = this.hna.getPbData().bIp();
            if (bIp != null && str.equals(bIp.getAdId())) {
                if (bIp.cef() != null) {
                    bIp.cef().legoCard = null;
                }
                this.hna.getPbData().bIq();
            }
            com.baidu.tieba.tbadkCore.data.m bLd = this.hna.bLd();
            if (bLd != null && str.equals(bLd.getAdId())) {
                this.hna.bLe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(d.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this);
                iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                    @Override // com.baidu.tbadk.core.dialog.i.c
                    public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                        if (PbActivity.this.hnj != null) {
                            PbActivity.this.hnj.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hnd.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.hnA);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hnA);
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
                if (this.hnj == null) {
                    this.hnj = new com.baidu.tbadk.core.dialog.g(getPageContext(), iVar.abk());
                } else {
                    this.hnj.setContentView(iVar.abk());
                }
                this.hnj.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        bg bIa;
        if (this.hna != null && this.hna.getPbData() != null && (bIa = this.hna.getPbData().bIa()) != null) {
            if (i == 1) {
                PraiseData YD = bIa.YD();
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
                        bIa.a(praiseData);
                    } else {
                        bIa.YD().getUser().add(0, metaData);
                        bIa.YD().setNum(bIa.YD().getNum() + 1);
                        bIa.YD().setIsLike(i);
                    }
                }
                if (bIa.YD() != null) {
                    if (bIa.YD().getNum() < 1) {
                        getResources().getString(d.j.zan);
                    } else {
                        com.baidu.tbadk.core.util.ap.ax(bIa.YD().getNum());
                    }
                }
            } else if (bIa.YD() != null) {
                bIa.YD().setIsLike(i);
                bIa.YD().setNum(bIa.YD().getNum() - 1);
                ArrayList<MetaData> user = bIa.YD().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bIa.YD().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bIa.YD().getNum() < 1) {
                    getResources().getString(d.j.zan);
                } else {
                    String str = bIa.YD().getNum() + "";
                }
            }
            if (this.hna.bKT()) {
                this.hnd.bMG().notifyDataSetChanged();
            } else {
                this.hnd.p(this.hna.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hna.aa(bundle);
        if (this.eYS != null) {
            this.eYS.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hns.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hmJ = System.currentTimeMillis();
        this.hny = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eCP = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hmQ = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hmQ) && intent.getData() != null) {
                this.hmQ = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hmQ)) {
                this.hmE = true;
            }
            this.hos = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hot = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hou = intent.getStringExtra("key_manga_title");
            this.hnn = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hno = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hnp = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bJQ()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.hnG = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eCP = System.currentTimeMillis();
        }
        this.cqn = this.hmJ - this.eCP;
        super.onCreate(bundle);
        this.hmH = 0;
        Z(bundle);
        if (this.hna != null && this.hna.getPbData() != null) {
            this.hna.getPbData().zJ(this.source);
        }
        initUI();
        if (intent != null && this.hnd != null) {
            this.hnd.hvN = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hnB == null) {
                    this.hnB = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hnd.Ac("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hnB, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hna != null && this.hna.getPbData() != null) {
                this.hna.zW(stringExtra);
            }
        }
        this.eYS = new VoiceManager();
        this.eYS.onCreate(getPageContext());
        initData(bundle);
        this.hnr = new com.baidu.tbadk.editortools.pb.f();
        bJo();
        this.hns = (com.baidu.tbadk.editortools.pb.d) this.hnr.dd(getActivity());
        this.hns.b(this);
        this.hns.a(this.cks);
        this.hns.a(this.ckl);
        this.hns.a(this, bundle);
        this.hns.alT().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hns.alT().eH(true);
        ni(true);
        this.hnd.setEditorTools(this.hns.alT());
        this.hns.a(this.hna.bLf(), this.hna.bKS(), this.hna.bLx());
        registerListener(this.hnN);
        if (!this.hna.bKY()) {
            this.hns.oR(this.hna.bKS());
        }
        if (this.hna.bLy()) {
            this.hns.oP(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else if (this.hnd != null) {
            this.hns.oP(this.hnd.bMs());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hnM);
        registerListener(this.hnO);
        registerListener(this.hnP);
        registerListener(this.fak);
        registerListener(this.hod);
        registerListener(this.hnL);
        this.hnq = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.iFJ);
        this.hnq.cdS();
        registerListener(this.hnR);
        registerListener(this.mAttentionListener);
        if (this.hna != null) {
            this.hna.bLp();
        }
        registerListener(this.hog);
        registerListener(this.how);
        registerListener(this.far);
        if (this.hnd != null && this.hnd.bNo() != null && this.hnd.bNp() != null) {
            this.hmD = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hnd.bNo(), this.hnd.bNp(), this.hnd.bMy());
            this.hmD.a(this.hnZ);
        }
        if (this.hmC && this.hnd != null && this.hnd.bNp() != null) {
            this.hnd.bNp().setVisibility(8);
        }
        this.hnz = new com.baidu.tbadk.core.view.e();
        this.hnz.bPN = 1000L;
        registerListener(this.hoc);
        registerListener(this.hoa);
        registerListener(this.hob);
        registerListener(this.frK);
        registerListener(this.bro);
        this.hnA = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hnA;
        userMuteAddAndDelCustomMessage.setTag(this.hnA);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hnA;
        userMuteCheckCustomMessage.setTag(this.hnA);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hna.bLv().a(this.dLM);
        this.hni = new as();
        if (this.hns.amt() != null) {
            this.hni.k(this.hns.amt().getInputView());
        }
        this.hns.a(this.ckm);
        this.foI = new ShareSuccessReplyToServerModel();
        a(this.hnI);
        this.gyL = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gyL.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bKs) {
                        PbActivity.this.hns.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bKt && PbActivity.this.hnd != null && PbActivity.this.hnd.bMp() != null && PbActivity.this.hnd.bMp().bKJ() != null) {
                        PbActivity.this.hnd.bMp().bKJ().amM();
                    } else if (i == com.baidu.tbadk.core.util.aj.bKu) {
                        PbActivity.this.c(PbActivity.this.hnv);
                    }
                }
            }
        });
        this.hnb = new com.baidu.tieba.pb.pb.report.a(this);
        this.hnb.p(getUniqueId());
        com.baidu.tieba.q.c.cdr().s(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.hmJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJo() {
        if (this.hnr != null && this.hna != null) {
            this.hnr.setForumName(this.hna.bIS());
            if (this.hna.getPbData() != null && this.hna.getPbData().getForum() != null) {
                this.hnr.a(this.hna.getPbData().getForum());
            }
            this.hnr.setFrom("pb");
            this.hnr.a(this.hna);
        }
    }

    public String bJp() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bJq() {
        return this.hmD;
    }

    private void ni(boolean z) {
        this.hns.eL(z);
        this.hns.eM(z);
        this.hns.eN(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIy() && !z && this.hnd != null && this.hnd.getView() != null && !UtilHelper.isOnePlus6()) {
            this.hnd.getView().setSystemUiVisibility(4);
        }
        this.hnw = z;
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
        if (this.eYS != null) {
            this.eYS.onStart(getPageContext());
        }
    }

    public aq bJr() {
        return this.hnd;
    }

    public PbModel bJb() {
        return this.hna;
    }

    public void zM(String str) {
        if (this.hna != null && !StringUtils.isNull(str) && this.hnd != null) {
            this.hnd.nX(true);
            this.hna.zM(str);
            this.hmP = true;
            this.hnd.bNa();
            this.hnd.bNj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hmF = false;
        } else {
            this.hmF = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hmH = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hmH == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.eYS != null) {
            this.eYS.onPause(getPageContext());
        }
        if (this.hnd != null) {
            this.hnd.onPause();
        }
        if (!this.hna.bKY()) {
            this.hns.oQ(this.hna.bKS());
        }
        if (this.hna != null) {
            this.hna.bLq();
        }
        com.baidu.tbadk.BdToken.c.TZ().Ua();
        MessageManager.getInstance().unRegisterListener(this.gcG);
        bnZ();
        MessageManager.getInstance().unRegisterListener(this.hoa);
        MessageManager.getInstance().unRegisterListener(this.hob);
        MessageManager.getInstance().unRegisterListener(this.hoc);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bJs() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hna.getPbData(), this.hna.bKT(), this.hna.getRequestType());
        return (a2 == null || a2.YR() == null || a2.YR().getGodUserData() == null || a2.YR().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hmF = false;
        super.onResume();
        if (this.hmS) {
            this.hmS = false;
            bJW();
        }
        if (bJs()) {
            this.hmM = System.currentTimeMillis();
        } else {
            this.hmM = -1L;
        }
        if (this.hnd != null && this.hnd.getView() != null) {
            if (!this.gQf) {
                bJN();
            } else {
                hideLoadingView(this.hnd.getView());
            }
            this.hnd.onResume();
        }
        if (this.hmH == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hnd != null) {
            noNetworkView = this.hnd.bMm();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kY()) {
            noNetworkView.dO(false);
        }
        if (this.eYS != null) {
            this.eYS.onResume(getPageContext());
        }
        registerListener(this.gcG);
        this.hnm = false;
        bJV();
        registerListener(this.hoa);
        registerListener(this.hob);
        registerListener(this.hoc);
        if (this.eZH) {
            bJM();
            this.eZH = false;
        }
        bKe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hnd.nM(z);
        if (this.hnj != null) {
            this.hnj.dismiss();
        }
        if (z && this.hnm) {
            this.hnd.bML();
            this.hna.ny(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hmM > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").bJ("obj_duration", (System.currentTimeMillis() - this.hmM) + ""));
            this.hmM = 0L;
        }
        if (bJr().bMp() != null) {
            bJr().bMp().onStop();
        }
        if (this.hnd.hvU != null && !this.hnd.hvU.aRp()) {
            this.hnd.hvU.bzo();
        }
        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().getForum() != null && this.hna.getPbData().bIa() != null) {
            com.baidu.tbadk.distribute.a.alG().a(getPageContext().getPageActivity(), "pb", this.hna.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hna.getPbData().bIa().getId(), 0L));
        }
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.cdr().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.cdr().t(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hna.getPbData().getForumId());
            amVar.bJ("tid", this.hna.bKS());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hmK && this.hnd != null) {
            this.hmK = true;
            this.hnd.bNf();
            a(false, (PostData) null);
        }
        if (this.hna != null) {
            this.hna.cancelLoadData();
            this.hna.destory();
            if (this.hna.bLu() != null) {
                this.hna.bLu().onDestroy();
            }
        }
        if (this.hns != null) {
            this.hns.onDestroy();
        }
        if (this.eja != null) {
            this.eja.cancelLoadData();
        }
        if (this.hnd != null) {
            this.hnd.onDestroy();
            if (this.hnd.hvU != null) {
                this.hnd.hvU.bzo();
            }
        }
        if (this.hmL != null) {
            this.hmL.apc();
        }
        if (this.hmD != null) {
            this.hmD.aql();
        }
        super.onDestroy();
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
        this.hnd.bNa();
        MessageManager.getInstance().unRegisterListener(this.hoa);
        MessageManager.getInstance().unRegisterListener(this.hob);
        MessageManager.getInstance().unRegisterListener(this.hoc);
        MessageManager.getInstance().unRegisterListener(this.hnA);
        MessageManager.getInstance().unRegisterListener(this.hod);
        MessageManager.getInstance().unRegisterListener(this.far);
        MessageManager.getInstance().unRegisterListener(this.frK);
        this.hny = null;
        this.hnz = null;
        com.baidu.tieba.recapp.d.a.bXx().bXz();
        if (this.hnB != null) {
            getSafeHandler().removeCallbacks(this.hnB);
        }
        if (this.hmT != null) {
            this.hmT.cancelLoadData();
        }
        if (this.hnd != null && this.hnd.hvU != null) {
            this.hnd.hvU.bOa();
        }
        if (this.foI != null) {
            this.foI.cancelLoadData();
        }
        this.hni.onDestroy();
        if (this.hna != null && this.hna.bLw() != null) {
            this.hna.bLw().onDestroy();
        }
        if (this.gyL != null) {
            this.gyL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bMG;
        ArrayList<PostData> bKu;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aga() && this.hnd != null && (bMG = this.hnd.bMG()) != null && (bKu = bMG.bKu()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bKu.iterator();
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
                        bVar.ekX = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bCe == 1 && !TextUtils.isEmpty(id)) {
                    next.bCe = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.ekX = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hna == null || this.hna.getPbData() == null || this.hna.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hna.getPbData().getForum().getFirst_class();
                    str2 = this.hna.getPbData().getForum().getSecond_class();
                    str = this.hna.getPbData().getForum().getId();
                    str4 = this.hna.bKS();
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
            this.hnd.onChangeSkinType(i);
            if (this.hns != null && this.hns.alT() != null) {
                this.hns.alT().onChangeSkinType(i);
            }
            if (this.hnd.bMm() != null) {
                this.hnd.bMm().onChangeSkinType(getPageContext(), i);
            }
            this.hni.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hnd = new aq(this, this.faZ, this.cbY);
        this.dMv = new com.baidu.tieba.f.b(getActivity());
        this.dMv.a(hop);
        this.dMv.a(this.dMw);
        this.hnd.setOnScrollListener(this.mOnScrollListener);
        this.hnd.e(this.fsS);
        this.hnd.setListPullRefreshListener(this.cPx);
        this.hnd.nc(com.baidu.tbadk.core.i.Wy().WC());
        this.hnd.setOnImageClickListener(this.cAE);
        this.hnd.b(this.cdd);
        this.hnd.h(this.eWE);
        this.hnd.a(this.hoi);
        this.hnd.nM(this.mIsLogin);
        if (getIntent() != null) {
            this.hnd.nY(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hnd.bMo().setFromForumId(this.hna.getFromForumId());
    }

    public void bJt() {
        if (this.hnd != null && this.hna != null) {
            if ((this.hna.getPbData() != null || this.hna.getPbData().bIx() != null) && checkUpIsLogin() && this.hnd.bMG() != null && this.hnd.bMG().bKz() != null) {
                this.hnd.bMG().bKz().nr(this.hna.bKS());
            }
        }
    }

    public void bJu() {
        TiebaStatic.log("c12181");
        if (this.hnd != null && this.hna != null) {
            if (this.hnd == null || this.hnd.bMr()) {
                if (this.hna.getPbData() != null || this.hna.getPbData().bIx() != null) {
                    com.baidu.tieba.pb.data.i bIx = this.hna.getPbData().bIx();
                    if (checkUpIsLogin()) {
                        if ((!bIx.bIB() || bIx.aan() != 2) && this.hnd.bMG() != null && this.hnd.bMG().bKz() != null) {
                            this.hnd.bMG().bKz().nr(this.hna.bKS());
                        }
                        if (System.currentTimeMillis() - this.hmO > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).or(false);
                            this.hmO = System.currentTimeMillis();
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
                if (postData.getType() != PostData.iGl && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.Wy().WC()) {
                    return zP(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hna == null || this.hna.getPbData() == null) {
                        return true;
                    }
                    if (bJr().bMp() != null) {
                        bJr().bMp().bKF();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.hna.getPbData().getForum());
                    jVar.aj(this.hna.getPbData().bIa());
                    jVar.e(postData);
                    bJr().bMo().d(jVar);
                    bJr().bMo().setPostId(postData.getId());
                    a(view, postData.YR().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hns != null) {
                        this.hnd.nS(this.hns.amA());
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
        if (this.hnd != null) {
            if (z && !this.gQf) {
                bJN();
            } else {
                hideLoadingView(this.hnd.getView());
            }
            if (z && this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIy() && this.hnd.getView() != null && !UtilHelper.isOnePlus6()) {
                this.hnd.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bJv() {
        if (this.hmI == null) {
            this.hmI = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hmI.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hmx = PbActivity.this.hmx.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmx);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hna.bKS(), PbActivity.this.hmx, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hmx = PbActivity.this.hmx.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmx);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hna.bKS(), PbActivity.this.hmx, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hmx = PbActivity.this.hmx.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmx);
                        bVar.dismiss();
                    }
                }
            }).gH(b.a.bEY).gI(17).d(getPageContext());
        }
    }

    private void Z(Bundle bundle) {
        this.hna = new PbModel(this);
        this.hna.a(this.hof);
        if (this.hna.bLt() != null) {
            this.hna.bLt().a(this.hor);
        }
        if (this.hna.bLs() != null) {
            this.hna.bLs().a(this.hnQ);
        }
        if (this.hna.bLu() != null) {
            this.hna.bLu().b(this.hnK);
        }
        if (bundle != null) {
            this.hna.initWithBundle(bundle);
        } else {
            this.hna.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hna.nB(true);
        }
        aj.bMb().ao(this.hna.bKQ(), this.hna.getIsFromMark());
        if (StringUtils.isNull(this.hna.bKS())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hmQ) && this.hmQ != null) {
            this.hna.wu(6);
        }
        this.hna.aov();
    }

    private void initData(Bundle bundle) {
        this.hnc = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hnc != null) {
            this.hnc.a(this.hoh);
        }
        this.eja = new ForumManageModel(this);
        this.eja.setLoadDataCallBack(this.eje);
        this.bKx = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hnd.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hna.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hna.getPbData().getForum().getId(), PbActivity.this.hna.getPbData().getForum().getName(), PbActivity.this.hna.getPbData().bIa().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hnW.setUniqueId(getUniqueId());
        this.hnW.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hnd.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hnA;
        userMuteCheckCustomMessage.setTag(this.hnA);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bJw() {
        if (checkUpIsLogin()) {
            if (this.fcw == null) {
                this.fcw = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fcw.re(0);
                this.fcw.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jl(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void n(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jm(boolean z) {
                        if (z) {
                            PbActivity.this.hnd.bnn();
                        }
                    }
                });
            }
            if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().getForum() != null) {
                this.fcw.q(this.hna.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hna.bKS(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJx() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hna != null && (pbData = this.hna.getPbData()) != null) {
            return pbData.bIl().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bIa() != null) {
            if (dVar.bIa().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bIa().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bIa().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bJy()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hmX);
                this.hmY = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hnu == null) {
                this.hnu = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hnu.re(1);
                this.hnu.a(new AnonymousClass39(str, str2));
            }
            if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().getForum() != null) {
                this.hnu.q(this.hna.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hna.bKS(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$39  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String hoG;
        final /* synthetic */ String hoH;

        AnonymousClass39(String str, String str2) {
            this.hoG = str;
            this.hoH = str2;
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
                        PbActivity.this.bJr().getListView().smoothScrollBy((PbActivity.this.hmX[1] + PbActivity.this.hmY) - (aQ - h), 50);
                        if (PbActivity.this.bJr().bMp() != null) {
                            PbActivity.this.hns.alT().setVisibility(8);
                            PbActivity.this.bJr().bMp().Y(AnonymousClass39.this.hoG, AnonymousClass39.this.hoH, PbActivity.this.bJr().bMs());
                            com.baidu.tbadk.editortools.pb.g bKJ = PbActivity.this.bJr().bMp().bKJ();
                            if (bKJ != null && PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                                bKJ.a(PbActivity.this.hna.getPbData().getAnti());
                            }
                            if (PbActivity.this.hni.bNB() == null && PbActivity.this.bJr().bMp().bKJ().amU() != null) {
                                PbActivity.this.bJr().bMp().bKJ().amU().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hni != null && PbActivity.this.hni.bNA() != null) {
                                            if (!PbActivity.this.hni.bNA().cnY()) {
                                                PbActivity.this.hni.oa(false);
                                            }
                                            PbActivity.this.hni.bNA().qV(false);
                                        }
                                    }
                                });
                                PbActivity.this.hni.l(PbActivity.this.bJr().bMp().bKJ().amU().getInputView());
                                PbActivity.this.bJr().bMp().bKJ().a(PbActivity.this.hnx);
                            }
                        }
                        PbActivity.this.bJr().bNj();
                    }
                }, 0L);
            }
        }
    }

    public boolean bJy() {
        if (this.gyL == null || this.hna.getPbData() == null || this.hna.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyL.hm(this.hna.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean wd(int i) {
        if (this.gyL == null || this.hna.getPbData() == null || this.hna.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyL.S(this.hna.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.hna != null && this.hna.getPbData() != null && postData.cer() != 1) {
            String bKS = this.hna.bKS();
            String id = postData.getId();
            int bIm = this.hna.getPbData() != null ? this.hna.getPbData().bIm() : 0;
            c zQ = zQ(id);
            if (zQ != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bKS, id, "pb", true, null, false, null, bIm, postData.bOO(), this.hna.getPbData().getAnti(), false, postData.YR() != null ? postData.YR().getIconInfo() : null).addBigImageData(zQ.hoX, zQ.hoY, zQ.hoZ, zQ.index);
                addBigImageData.setKeyPageStartFrom(this.hna.bLA());
                addBigImageData.setFromFrsForumId(this.hna.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJz() {
        if (this.hna.getPbData() == null || this.hna.getPbData().bIa() == null) {
            return -1;
        }
        return this.hna.getPbData().bIa().ZB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJA() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.BX(this.hna.getForumId()) && this.hna.getPbData() != null && this.hna.getPbData().getForum() != null) {
            if (this.hna.getPbData().getForum().isLike() == 1) {
                this.hna.bLw().dP(this.hna.getForumId(), this.hna.bKS());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hna == null || this.hna.getPbData() == null) {
            return false;
        }
        return ((this.hna.getPbData().bIm() != 0) || this.hna.getPbData().bIa() == null || this.hna.getPbData().bIa().YR() == null || TextUtils.equals(this.hna.getPbData().bIa().YR().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bJB() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.s.v.apI()) {
            return "";
        }
        PostData bIh = bIh();
        if (this.hna == null || (pbData = this.hna.getPbData()) == null || pbData.getUserData() == null || pbData.bIa() == null || bIh == null || bIh.YR() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bIh.YR().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bIa().Yy() == 0) {
            return "";
        }
        if (pbData.bIa().Yy() == 0) {
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
        if (this.hna == null || this.hna.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hna.getPbData();
        if (pbData.bIm() != 0) {
            return pbData.bIm() != 3;
        }
        List<com.baidu.tbadk.core.data.bc> bIv = pbData.bIv();
        if (com.baidu.tbadk.core.util.v.S(bIv) > 0) {
            for (com.baidu.tbadk.core.data.bc bcVar : bIv) {
                if (bcVar != null && (vVar = bcVar.bAy) != null && vVar.byr && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    private boolean nl(boolean z) {
        return (z || this.hna == null || this.hna.getPbData() == null || this.hna.getPbData().bIm() == 0 || this.hna.getPbData().bIm() == 3) ? false : true;
    }

    public void bJC() {
        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIa() != null && this.hna.getPbData().bIa().YR() != null) {
            if (this.hnd != null) {
                this.hnd.bMn();
            }
            bg bIa = this.hna.getPbData().bIa();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bIa.YR().getUserId());
            ab abVar = new ab();
            int bIm = this.hna.getPbData().bIm();
            if (bIm == 1 || bIm == 3) {
                abVar.hud = true;
                abVar.huc = true;
                abVar.huk = bIa.YM() == 1;
                abVar.huj = bIa.YN() == 1;
            } else {
                abVar.hud = false;
                abVar.huc = false;
            }
            if (bIm == 1002 && !equals) {
                abVar.huo = true;
            }
            abVar.hue = nk(equals);
            abVar.huf = bJD();
            abVar.hug = nl(equals);
            abVar.qV = this.hna.bKT();
            abVar.hub = true;
            abVar.hua = nj(equals);
            abVar.hum = bJB();
            abVar.htZ = equals && this.hnd.bMS();
            abVar.huh = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hui = true;
            abVar.isHostOnly = this.hna.getHostMode();
            abVar.hul = true;
            if (bIa.Zi() == null) {
                abVar.hun = true;
            } else {
                abVar.hun = false;
            }
            this.hnd.hvU.a(abVar);
        }
    }

    private boolean bJD() {
        if (this.hna != null && this.hna.bKT()) {
            return this.hna.getPageData() == null || this.hna.getPageData().XL() != 0;
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

    public int bJE() {
        if (bJr() == null || bJr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bJr().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) mVar).mType == com.baidu.tieba.pb.data.h.hkI) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJF() {
        if (bJr() == null || bJr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bJr().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.iGk) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        bJM();
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
                    PbActivity.this.bKx.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hna.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aaZ();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hnd.bMM();
        this.hna.nA(z);
        if (this.hnc != null) {
            this.hnc.cZ(z);
            if (markData != null) {
                this.hnc.a(markData);
            }
        }
        if (this.hna.Vb()) {
            bJK();
        } else {
            this.hnd.o(this.hna.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wb(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN(String str) {
        this.hnb.Al(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hna.bKY()) {
                    antiData.setBlock_forum_name(this.hna.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hna.getPbData().getForum().getId());
                    antiData.setUser_name(this.hna.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hna.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bJr() != null) {
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLk));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLk));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLk));
            }
        } else if (i == 230277) {
            oW(str);
        } else {
            this.hnd.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.iIK) ? bVar.iIK : getString(d.j.delete_fail);
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
                this.hnd.a(0, bVar.Id, bVar.iIK, z);
            }
            if (bVar.Id) {
                if (bVar.eFR == 1) {
                    ArrayList<PostData> bIc = this.hna.getPbData().bIc();
                    int size = bIc.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bIc.get(i).getId())) {
                            i++;
                        } else {
                            bIc.remove(i);
                            break;
                        }
                    }
                    this.hna.getPbData().bIa().gr(this.hna.getPbData().bIa().YI() - 1);
                    this.hnd.o(this.hna.getPbData());
                } else if (bVar.eFR == 0) {
                    bJG();
                } else if (bVar.eFR == 2) {
                    ArrayList<PostData> bIc2 = this.hna.getPbData().bIc();
                    int size2 = bIc2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bIc2.get(i2).ceo().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bIc2.get(i2).ceo().get(i3).getId())) {
                                i3++;
                            } else {
                                bIc2.get(i2).ceo().remove(i3);
                                bIc2.get(i2).ceq();
                                z2 = true;
                                break;
                            }
                        }
                        bIc2.get(i2).CB(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hnd.o(this.hna.getPbData());
                    }
                    a(bVar, this.hnd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hnd.a(this.eja.getLoadDataMode(), gVar.Id, gVar.iIK, false);
            if (gVar.Id) {
                this.hnf = true;
                if (i == 2 || i == 3) {
                    this.hng = true;
                    this.hnh = false;
                } else if (i == 4 || i == 5) {
                    this.hng = false;
                    this.hnh = true;
                }
                if (i == 2) {
                    this.hna.getPbData().bIa().gu(1);
                    this.hna.setIsGood(1);
                } else if (i == 3) {
                    this.hna.getPbData().bIa().gu(0);
                    this.hna.setIsGood(0);
                } else if (i == 4) {
                    this.hna.getPbData().bIa().gt(1);
                    this.hna.oE(1);
                } else if (i == 5) {
                    this.hna.getPbData().bIa().gt(0);
                    this.hna.oE(0);
                }
                this.hnd.d(this.hna.getPbData(), this.hna.bKT());
            }
        }
    }

    private void bJG() {
        if (this.hna.bKU() || this.hna.bKW()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hna.bKS());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hna.bKS()));
        if (bJL()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJH() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bIj;
        boolean z = false;
        if (this.hnd != null) {
            this.hnd.bNa();
        }
        if (this.hna != null && this.hna.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hna.getPbData().bIa().getId();
            if (this.hna.isShareThread() && this.hna.getPbData().bIa().bDt != null) {
                historyMessage.threadName = this.hna.getPbData().bIa().bDt.showText;
            } else {
                historyMessage.threadName = this.hna.getPbData().bIa().getTitle();
            }
            if (this.hna.isShareThread() && !bIR()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hna.getPbData().getForum().getName();
            }
            ArrayList<PostData> bIc = this.hna.getPbData().bIc();
            int bMO = this.hnd != null ? this.hnd.bMO() : 0;
            if (bIc != null && bMO >= 0 && bMO < bIc.size()) {
                historyMessage.postID = bIc.get(bMO).getId();
            }
            historyMessage.isHostOnly = this.hna.getHostMode();
            historyMessage.isSquence = this.hna.bKT();
            historyMessage.isShareThread = this.hna.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hns != null) {
            this.hns.onDestroy();
        }
        if (this.hmG && bJr() != null) {
            bJr().bNt();
        }
        if (this.hna != null && (this.hna.bKU() || this.hna.bKW())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hna.bKS());
            if (this.hnf) {
                if (this.hnh) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hna.aWl());
                }
                if (this.hng) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hna.getIsGood());
                }
            }
            if (this.hna.getPbData() != null && System.currentTimeMillis() - this.hmJ >= 40000 && (bIj = this.hna.getPbData().bIj()) != null && !com.baidu.tbadk.core.util.v.T(bIj.getDataList())) {
                intent.putExtra("guess_like_data", bIj);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hnG);
            }
            setResult(-1, intent);
        }
        if (bJL()) {
            if (this.hna != null && this.hnd != null && this.hnd.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hna.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bIg() && !this.hmP) {
                        aj bMb = aj.bMb();
                        com.baidu.tieba.pb.data.d bLa = this.hna.bLa();
                        Parcelable onSaveInstanceState = this.hnd.getListView().onSaveInstanceState();
                        boolean bKT = this.hna.bKT();
                        boolean hostMode = this.hna.getHostMode();
                        if (this.hnd.bMy() != null && this.hnd.bMy().getVisibility() == 0) {
                            z = true;
                        }
                        bMb.a(bLa, onSaveInstanceState, bKT, hostMode, z);
                        if (this.hnF >= 0 || this.hna.bLC() != null) {
                            aj.bMb().l(this.hna.bLC());
                            aj.bMb().k(this.hna.bLD());
                            aj.bMb().ww(this.hna.bLE());
                        }
                    }
                }
            } else {
                aj.bMb().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hnd == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hnd.wB(i)) {
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
            this.hnd.bMn();
            this.hnd.bMp().bKF();
            this.hnd.nU(false);
        }
        this.hnd.bMq();
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
                        this.hns.resetData();
                        this.hns.b(writeData);
                        this.hns.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k jw = this.hns.alT().jw(6);
                        if (jw != null && jw.ciu != null) {
                            jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hns.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hnd.bMp() != null && this.hnd.bMp().bKJ() != null) {
                            com.baidu.tbadk.editortools.pb.g bKJ = this.hnd.bMp().bKJ();
                            bKJ.b(writeData);
                            bKJ.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k jw2 = bKJ.alT().jw(6);
                            if (jw2 != null && jw2.ciu != null) {
                                jw2.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bKJ.amM();
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
        this.hns.onActivityResult(i, i2, intent);
        if (this.hmT != null) {
            this.hmT.onActivityResult(i, i2, intent);
        }
        if (bJr().bMp() != null) {
            bJr().bMp().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bJJ();
                    return;
                case 13008:
                    aj.bMb().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hna != null) {
                                PbActivity.this.hna.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bWp().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hna != null) {
                        a(bJI(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ad(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bWp().x(getPageContext());
                        bJA();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.foI != null && shareItem != null && shareItem.linkUrl != null) {
                            this.foI.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
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
                    this.hnd.nh(false);
                    if (this.hna.getPbData() != null && this.hna.getPbData().bIa() != null && this.hna.getPbData().bIa().Zl() != null) {
                        this.hna.getPbData().bIa().Zl().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hnv = emotionImageData;
                        if (wd(com.baidu.tbadk.core.util.aj.bKu)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hnd != null && this.hnd.hvU != null) {
                        this.hnd.hvU.Qk();
                        this.hnd.hvU.bNU();
                        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIa() != null) {
                            this.hna.getPbData().bIa().gp(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hmU != null) {
                        this.hnd.ct(this.hmU);
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
            if (this.hmT == null) {
                this.hmT = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hmT.b(this.ckl);
                this.hmT.c(this.cks);
            }
            this.hmT.a(emotionImageData, bJb(), bJb().getPbData());
        }
    }

    private ShareFromPBMsgData bJI() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] el = this.hna.getPbData().el(getPageContext().getPageActivity());
        PostData bMt = this.hnd.bMt();
        String str = "";
        if (bMt != null) {
            str = bMt.getId();
            String ew = bMt.ew(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ew)) {
                el[1] = ew;
            }
        }
        String Zh = this.hna.getPbData().bIa().Zh();
        if (Zh != null && Zh.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(el[1]);
        shareFromPBMsgData.setImageUrl(el[0]);
        shareFromPBMsgData.setForumName(this.hna.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hna.getPbData().bIa().getId());
        shareFromPBMsgData.setTitle(this.hna.getPbData().bIa().getTitle());
        return shareFromPBMsgData;
    }

    private void ad(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bJI(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIa() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.gF(1);
            aVar.az(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null) {
                        com.baidu.tbadk.core.util.am bJ = new com.baidu.tbadk.core.util.am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).T("obj_param1", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hna.getForumId()).bJ("tid", PbActivity.this.hna.bKS());
                        if (PbActivity.this.e(PbActivity.this.hna.getPbData()) != 0) {
                            bJ.T("obj_type", PbActivity.this.e(PbActivity.this.hna.getPbData()));
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
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), this.hna.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIa() != null) {
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
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), this.hna.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        MarkData wt;
        if (this.hnc != null && (wt = this.hna.wt(this.hnd.bMP())) != null) {
            if (!wt.isApp() || (wt = this.hna.wt(this.hnd.bMP() + 1)) != null) {
                this.hnd.bMK();
                this.hnc.a(wt);
                if (!this.hnc.Vb()) {
                    this.hnc.Vd();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hnc.Vc();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJK() {
        com.baidu.tieba.pb.data.d pbData = this.hna.getPbData();
        this.hna.nA(true);
        if (this.hnc != null) {
            pbData.zI(this.hnc.Va());
        }
        this.hnd.o(pbData);
    }

    private boolean bJL() {
        if (this.hna == null) {
            return true;
        }
        if (this.hna.Vb()) {
            final MarkData bLk = this.hna.bLk();
            if (bLk == null || !this.hna.getIsFromMark()) {
                return true;
            }
            final MarkData wt = this.hna.wt(this.hnd.bMO());
            if (wt == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bLk);
                setResult(-1, intent);
                return true;
            } else if (wt.getPostId() == null || wt.getPostId().equals(bLk.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bLk);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ly(getPageContext().getString(d.j.alert_update_mark));
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hnc != null) {
                            if (PbActivity.this.hnc.Vb()) {
                                PbActivity.this.hnc.Vc();
                                PbActivity.this.hnc.cZ(false);
                            }
                            PbActivity.this.hnc.a(wt);
                            PbActivity.this.hnc.cZ(true);
                            PbActivity.this.hnc.Vd();
                        }
                        bLk.setPostId(wt.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bLk);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bJH();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bLk);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bJH();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hnd != null && PbActivity.this.hnd.getView() != null) {
                            PbActivity.this.hnd.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bLk);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bJH();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.aaZ();
                return false;
            }
        } else if (this.hna.getPbData() == null || this.hna.getPbData().bIc() == null || this.hna.getPbData().bIc().size() <= 0 || !this.hna.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hnd == null) {
            return null;
        }
        return this.hnd.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ate() {
        if (this.hnd == null) {
            return 0;
        }
        return this.hnd.bMY();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> atf() {
        if (this.cAv == null) {
            this.cAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean WC = com.baidu.tbadk.core.i.Wy().WC();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(d.C0236d.common_color_10220));
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
                        foreDrawableImageView.setDefaultBgResource(d.C0236d.common_color_10220);
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
                        foreDrawableImageView.setDefaultBgResource(d.C0236d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.cAv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atg() {
        if (this.cDk == null) {
            this.cDk = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ath() {
        if (this.cAw == null) {
            this.cAw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKg */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbActivity.this.getPageContext().getPageActivity());
                    boolean WC = com.baidu.tbadk.core.i.Wy().WC();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(d.C0236d.common_color_10220));
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
                    gifView.setDefaultBgResource(d.C0236d.common_color_10220);
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
                    gifView.ann();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(d.C0236d.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cAw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ati() {
        if (this.cDl == null) {
            this.cDl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKh */
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
                    ((PlayVoiceBntNew) view).cfB();
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
        return this.cDl;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atk() {
        this.cDn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bKi */
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
        return this.cDn;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afd() {
        if (this.bTR == null) {
            this.bTR = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTR;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void az(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hmN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (av.Ad(str) && this.hna != null && this.hna.bKS() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").T("obj_param1", 1).bJ("post_id", this.hna.bKS()));
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
            av.bND().d(getPageContext(), str);
        }
        this.hmN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aA(Context context, String str) {
        av.bND().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hmN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aB(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Rect rect) {
        if (rect != null && this.hnd != null && this.hnd.bNo() != null && rect.top <= this.hnd.bNo().getHeight()) {
            rect.top += this.hnd.bNo().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hna.getPbData();
            TbRichText bh = bh(str, i);
            if (bh != null && (tbRichTextData = bh.asx().get(this.hok)) != null) {
                cVar.hoX = new ArrayList<>();
                cVar.hoY = new ConcurrentHashMap<>();
                if (!tbRichTextData.asE().asQ()) {
                    cVar.hpa = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hoX.add(b2);
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
                    imageUrlData.mIsReserver = this.hna.bLi();
                    imageUrlData.mIsSeeHost = this.hna.getHostMode();
                    cVar.hoY.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bIa() != null) {
                            cVar.threadId = pbData.bIa().getId();
                        }
                        cVar.hoZ = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.hpa = true;
                int size = pbData.bIc().size();
                this.hol = false;
                cVar.index = -1;
                if (pbData.bIh() != null) {
                    PostData bIh = pbData.bIh();
                    TbRichText cet = bIh.cet();
                    if (!ap.m(bIh)) {
                        i2 = a(cet, bh, i, i, cVar.hoX, cVar.hoY);
                    } else {
                        i2 = a(bIh, i, cVar.hoX, cVar.hoY);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bIc().get(i4);
                    if (postData.getId() == null || pbData.bIh() == null || pbData.bIh().getId() == null || !postData.getId().equals(pbData.bIh().getId())) {
                        TbRichText cet2 = postData.cet();
                        if (!ap.m(postData)) {
                            i3 = a(cet2, bh, i3, i, cVar.hoX, cVar.hoY);
                        } else {
                            i3 = a(postData, i3, cVar.hoX, cVar.hoY);
                        }
                    }
                }
                if (cVar.hoX.size() > 0) {
                    cVar.lastId = cVar.hoX.get(cVar.hoX.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bIa() != null) {
                        cVar.threadId = pbData.bIa().getId();
                    }
                    cVar.hoZ = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asE() == null) {
            return null;
        }
        return tbRichTextData.asE().asV();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asE() == null) {
            return 0L;
        }
        return tbRichTextData.asE().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asE() == null) {
            return false;
        }
        return tbRichTextData.asE().asW();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.asE() == null) {
            return false;
        }
        return tbRichTextData.asE().asX();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo asE;
        String str;
        if (tbRichText == tbRichText2) {
            this.hol = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.asx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.asx().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.asE().getWidth() * aR;
                    int height = aR * tbRichTextData.asE().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.asE().asQ()) {
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
                            if (tbRichTextData != null && (asE = tbRichTextData.asE()) != null) {
                                String asS = asE.asS();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = asE.asT();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = asS;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hna.bKS(), -1L);
                                imageUrlData.mIsReserver = this.hna.bLi();
                                imageUrlData.mIsSeeHost = this.hna.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hol) {
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
        com.baidu.tieba.tbadkCore.data.i ceA;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cdW;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cdW = (ceA = postData.ceA()).cdW()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cdW.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cdW.get(i3);
                if (kVar != null) {
                    String cea = kVar.cea();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(cea)) {
                        arrayList.add(cea);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cea;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cdZ();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hna.bKS(), -1L);
                        imageUrlData.mIsReserver = this.hna.bLi();
                        imageUrlData.mIsSeeHost = this.hna.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = ceA.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cea, imageUrlData);
                        }
                        if (!this.hol) {
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
            if (postData.getId() != null && postData.getId().equals(this.hna.Za())) {
                z = true;
            }
            MarkData j = this.hna.j(postData);
            if (j != null) {
                this.hnd.bMK();
                if (this.hnc != null) {
                    this.hnc.a(j);
                    if (!z) {
                        this.hnc.Vd();
                    } else {
                        this.hnc.Vc();
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
        if (this.hna == null || this.hna.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hna.getPbData();
        if (pbData.bIh() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bIh());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bIc = pbData.bIc();
            a(pbData, bIc);
            return a(bIc, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bIl() != null && dVar.bIl().hkX != null && (list = dVar.bIl().hkX) != null && arrayList != null) {
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

    private long zO(String str) {
        ArrayList<PostData> bIc;
        com.baidu.tieba.pb.data.d pbData = this.hna.getPbData();
        if (pbData != null && (bIc = pbData.bIc()) != null && !bIc.isEmpty()) {
            Iterator<PostData> it = bIc.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i ceA = next.ceA();
                if (ceA != null && ceA.iFR) {
                    Iterator<TbRichTextData> it2 = next.cet().asx().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.asN().getLink().equals(str)) {
                            return ceA.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> asx;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cet = arrayList.get(i2).cet();
            if (cet != null && (asx = cet.asx()) != null) {
                int size = asx.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (asx.get(i4) != null && asx.get(i4).getType() == 8) {
                        i3++;
                        if (asx.get(i4).asE().asS().equals(str) || asx.get(i4).asE().asT().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = asx.get(i4).asE().getWidth() * aR;
                            int height = asx.get(i4).asE().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hok = i4;
                            return cet;
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
            this.hmx = str;
            if (this.hmI == null) {
                bJv();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hmI.gK(1).setVisibility(8);
            } else {
                this.hmI.gK(1).setVisibility(0);
            }
            this.hmI.abc();
            this.hmN = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJM() {
        hideNetRefreshView(this.hnd.getView());
        bJN();
        if (this.hna.aov()) {
            this.hnd.bMK();
        }
    }

    private void bJN() {
        showLoadingView(this.hnd.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View anD = getLoadingView().anD();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anD.getLayoutParams();
        layoutParams.addRule(3, this.hnd.bNo().getId());
        anD.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcN() {
        if (this.eYS != null) {
            this.eYS.stopPlay();
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
    /* JADX WARN: Removed duplicated region for block: B:36:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wg(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.hna.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hna.getPbData();
            pbData.getForum().getName();
            String title = pbData.bIa().getTitle();
            int i2 = this.hna.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.BX(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hna.bKS() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] el = pbData.el(getPageContext().getPageActivity());
                    str = el[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = el[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bJz() == 1) {
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
                    dVar.extData = this.hna.bKS();
                    dVar.cbB = 3;
                    dVar.cbA = i;
                    dVar.fid = this.hna.getForumId();
                    dVar.tid = this.hna.bKS();
                    dVar.cbF = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hna.getPbData().bIa());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.cbB);
                    bundle.putInt("obj_type", dVar.cbF);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.D(bundle);
                    if (!com.baidu.tbadk.plugins.c.b(getPageContext(), "com.baidu.tieba.pluginCore")) {
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                        shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialogInterface) {
                                if (PbActivity.this.hna != null && PbActivity.this.hna.getPbData() != null && PbActivity.this.hna.getPbData().bIy() && !UtilHelper.isOnePlus6()) {
                                    PbActivity.this.hnd.getView().setSystemUiVisibility(4);
                                }
                            }
                        });
                        com.baidu.tieba.c.e.aSu().a(shareDialogConfig);
                        return;
                    }
                    return;
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hna.bKS() + "?share=9105&fr=share&see_lz=" + i2;
            String[] el2 = pbData.el(getPageContext().getPageActivity());
            str = el2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = el2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bJz() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.cbj = true;
            dVar2.cbq = z;
            dVar2.extData = this.hna.bKS();
            dVar2.cbB = 3;
            dVar2.cbA = i;
            dVar2.fid = this.hna.getForumId();
            dVar2.tid = this.hna.bKS();
            dVar2.cbF = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hna.getPbData().bIa());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.cbB);
            bundle2.putInt("obj_type", dVar2.cbF);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.D(bundle2);
            if (!com.baidu.tbadk.plugins.c.b(getPageContext(), "com.baidu.tieba.pluginCore")) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bIa() != null) {
            if (dVar.bIa().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bIa().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        com.baidu.tbadk.util.aa.a(new com.baidu.tbadk.util.z<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.BY(PbActivity.this.hna.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hnd.bNu();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> atj() {
        if (this.cDm == null) {
            this.cDm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKj */
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
        return this.cDm;
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

    public void bcO() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bbJ() {
        if (this.hna == null || this.hna.getPbData() == null) {
            return null;
        }
        return this.hna.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.abb() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.abb();
            int intValue = ((Integer) sparseArray.get(aq.hxG)).intValue();
            if (intValue == aq.hxH) {
                if (!this.eja.cfd()) {
                    this.hnd.bMH();
                    String str = (String) sparseArray.get(d.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eja.CH(com.baidu.tbadk.core.util.ap.x(jSONArray));
                    }
                    this.eja.a(this.hna.getPbData().getForum().getId(), this.hna.getPbData().getForum().getName(), this.hna.getPbData().bIa().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hxI || intValue == aq.hxK) {
                if (this.hna.bLt() != null) {
                    this.hna.bLt().wj(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hxI) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hnA);
        userMuteAddAndDelCustomMessage.setTag(this.hnA);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean zP(String str) {
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
        this.hnm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJP() {
        ArrayList<PostData> bIc;
        int S;
        if (this.hna == null || this.hna.getPbData() == null || this.hna.getPbData().bIc() == null || (S = com.baidu.tbadk.core.util.v.S((bIc = this.hna.getPbData().bIc()))) == 0) {
            return "";
        }
        if (this.hna.bLi()) {
            Iterator<PostData> it = bIc.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cer() == 1) {
                    return next.getId();
                }
            }
        }
        int bMO = this.hnd.bMO();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bIc, bMO);
        if (postData == null || postData.YR() == null) {
            return "";
        }
        if (this.hna.zT(postData.YR().getUserId())) {
            return postData.getId();
        }
        for (int i = bMO - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bIc, i);
            if (postData2 == null || postData2.YR() == null || postData2.YR().getUserId() == null) {
                break;
            } else if (this.hna.zT(postData2.YR().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bMO + 1; i2 < S; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bIc, i2);
            if (postData3 == null || postData3.YR() == null || postData3.YR().getUserId() == null) {
                return "";
            }
            if (this.hna.zT(postData3.YR().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aD(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.adD().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(zO(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hna.getPbData().getForum().getId(), this.hna.getPbData().getForum().getName(), this.hna.getPbData().bIa().getTid());
            }
            this.hmN = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hna.bLs() != null) {
                    PbActivity.this.hna.bLs().dD(j);
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
    public c zQ(String str) {
        String str2;
        if (this.hna.getPbData() == null || this.hna.getPbData().bIc() == null || this.hna.getPbData().bIc().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hna.getPbData().bIc().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hna.getPbData().bIc().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hna.getPbData().bIc().get(i);
        if (postData.cet() == null || postData.cet().asx() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cet().asx().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.asE() != null) {
                    str2 = next.asE().asS();
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
        if (this.hmE) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hmE = false;
        } else if (bJQ()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hmE) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hmE = false;
        } else if (bJQ()) {
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
        if (pageStayDurationItem != null && this.hna != null) {
            if (this.hna.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hna.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hna.bKS(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bJQ() {
        return (!this.hmC && this.hos == -1 && this.hot == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hov = oVar;
            this.hmC = true;
            this.hnd.bMz();
            this.hnd.Ab(this.hou);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJR() {
        if (this.hov != null) {
            if (this.hos == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hov.getCartoonId(), this.hos, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJS() {
        if (this.hov != null) {
            if (this.hot == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hov.getCartoonId(), this.hot, 0)));
                finish();
            }
        }
    }

    public int bJT() {
        return this.hos;
    }

    public int bJU() {
        return this.hot;
    }

    private void bnZ() {
        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIa() != null && this.hna.getPbData().bIa().ZL()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bJV() {
        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIa() != null && this.hna.getPbData().bIa().ZL()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bJW() {
        if (this.hmF) {
            this.hmS = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hna.getPbData() != null && this.hna.getPbData().bIa() != null && this.hna.getPbData().bIa().Yx() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hna.getPbData().bIa().Yx().getThreadId(), this.hna.getPbData().bIa().Yx().getTaskId(), this.hna.getPbData().bIa().Yx().getForumId(), this.hna.getPbData().bIa().Yx().getForumName(), this.hna.getPbData().bIa().YM(), this.hna.getPbData().bIa().YN())));
            this.hmE = true;
            finish();
        }
    }

    public String bJX() {
        return this.hmQ;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bJY() {
        return this.hmZ;
    }

    public void nn(boolean z) {
        this.hmR = z;
    }

    public boolean bJZ() {
        if (this.hna != null) {
            return this.hna.bKU();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKa() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ly(getResources().getString(d.j.mute_is_super_member_function));
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hny).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hny.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hny).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hny != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hny.getPageActivity());
            aVar.ly(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hny).aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hnd.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hny.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.ly(this.hny.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.ly(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hnd.showLoadingDialog();
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
        aVar.b(this.hny).aaZ();
    }

    public void bKb() {
        if (this.hna != null && this.hna.getPbData() != null && this.hna.getPbData().bIa() != null && this.hna.getPbData().bIa().aab() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.gD(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hna.getPbData().bIa().aab().channelId, true, PbActivity.this.getUniqueId())));
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
                if (av.Ad(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.hnd != null) {
            this.hnd.onConfigurationChanged(configuration);
        }
        if (this.hnj != null) {
            this.hnj.dismiss();
        }
    }

    public boolean bKc() {
        if (this.hna != null) {
            return this.hna.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hna.getPbData().bIl().hkX;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).ceo().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).ceo().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).ceo().remove(i2);
                    list.get(i).ceq();
                    z = true;
                    break;
                }
            }
            list.get(i).CB(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.o(this.hna.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bIE().getId();
        List<PostData> list = this.hna.getPbData().bIl().hkX;
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
                ArrayList<PostData> bII = jVar.bII();
                postData.zt(jVar.getTotalCount());
                if (postData.ceo() != null) {
                    postData.ceo().clear();
                    postData.ceo().addAll(bII);
                }
            }
        }
        if (!this.hna.getIsFromMark()) {
            this.hnd.o(this.hna.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bIQ() {
        return this.hne;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIR() {
        if (this.hna == null) {
            return false;
        }
        return this.hna.bIR();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIS() {
        if (this.hna != null) {
            return this.hna.bIS();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIT() {
        if (this.hna == null || this.hna.getPbData() == null) {
            return 0;
        }
        return this.hna.getPbData().bIm();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zK(String str) {
        return this.hna != null && this.hna.zT(str);
    }

    public void bKd() {
        if (this.hnd != null) {
            this.hnd.bMn();
            bcO();
        }
    }

    public PostData bIh() {
        return this.hnd.c(this.hna.hsw, this.hna.bKT());
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
        if (this.hnH != null && !this.hnH.isEmpty()) {
            int size = this.hnH.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hnH.get(i).onBackPressed()) {
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
            if (this.hnH == null) {
                this.hnH = new ArrayList();
            }
            if (!this.hnH.contains(aVar)) {
                this.hnH.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hnH == null) {
                this.hnH = new ArrayList();
            }
            if (!this.hnH.contains(aVar)) {
                this.hnH.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hnH != null) {
            this.hnH.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKe() {
        if (this.hna != null && !com.baidu.tbadk.core.util.ap.isEmpty(this.hna.bKS())) {
            com.baidu.tbadk.BdToken.c.TZ().f(com.baidu.tbadk.BdToken.b.bqC, com.baidu.adp.lib.g.b.d(this.hna.bKS(), 0L));
        }
    }
}
