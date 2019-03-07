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
    public com.baidu.tbadk.core.util.aj gyK;
    private com.baidu.tieba.pb.pb.main.b.b hmC;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hmS;
    private View hmT;
    private int hmU;
    private int hmV;
    int hmX;
    private String hmw;
    private Runnable hnA;
    private com.baidu.adp.widget.ImageView.a hnB;
    private String hnC;
    private TbRichTextMemeInfo hnD;
    private List<a> hnG;
    private com.baidu.tieba.pb.pb.report.a hna;
    public as hnh;
    private com.baidu.tbadk.core.dialog.g hni;
    private com.baidu.tbadk.core.dialog.i hnj;
    private boolean hnl;
    private com.baidu.tieba.tbadkCore.data.f hnp;
    private com.baidu.tbadk.editortools.pb.f hnq;
    private com.baidu.tbadk.editortools.pb.d hnr;
    private com.baidu.tieba.frs.profession.permission.c hnt;
    private EmotionImageData hnu;
    private com.baidu.adp.base.e hnx;
    private com.baidu.tbadk.core.view.e hny;
    private BdUniqueId hnz;
    private boolean hoi;
    private String hot;
    private com.baidu.tbadk.core.data.o hou;
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
    private static final b.a hoo = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // com.baidu.tieba.f.b.a
        public void it(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bIO();
            } else {
                com.baidu.tieba.pb.a.b.bIN();
            }
        }
    };
    private boolean hmB = false;
    private boolean hmD = false;
    private boolean hmE = false;
    private boolean gQe = false;
    private boolean hmF = true;
    private int hmG = 0;
    private com.baidu.tbadk.core.dialog.b hmH = null;
    private long eCP = -1;
    private long cqv = 0;
    private long hmI = 0;
    private long createTime = 0;
    private long cqn = 0;
    private boolean hmJ = false;
    private com.baidu.tbadk.o.b hmK = null;
    private long hmL = 0;
    private boolean hmM = false;
    private long hmN = 0;
    private String cki = null;
    private boolean hmO = false;
    private boolean isFullScreen = false;
    private String hmP = "";
    private boolean hmQ = true;
    private boolean hmR = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hmW = new int[2];
    private PbInterviewStatusView.a hmY = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.hnc.nN(!PbActivity.this.hmQ);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.Vb()) {
                        PbActivity.this.bJJ();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hmZ = null;
    private com.baidu.tbadk.baseEditMark.a hnb = null;
    private ForumManageModel eja = null;
    private com.baidu.tbadk.coreExtra.model.a bKx = null;
    private ShareSuccessReplyToServerModel foI = null;
    private aq hnc = null;
    public final com.baidu.tieba.pb.pb.main.b.a hnd = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hne = false;
    private boolean hnf = false;
    private boolean hng = false;
    private boolean hnk = false;
    private boolean hnm = false;
    private boolean hnn = false;
    private boolean hno = false;
    private boolean hns = false;
    public boolean hnv = false;
    private com.baidu.tbadk.editortools.pb.c ckl = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void ams() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ckm = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amr() {
            if (PbActivity.this.hnh == null || PbActivity.this.hnh.bNy() == null || !PbActivity.this.hnh.bNy().cnN()) {
                return !PbActivity.this.wd(com.baidu.tbadk.core.util.aj.bKs);
            }
            PbActivity.this.showToast(PbActivity.this.hnh.bNy().cnP());
            if (PbActivity.this.hnr != null && (PbActivity.this.hnr.amG() || PbActivity.this.hnr.amH())) {
                PbActivity.this.hnr.a(false, PbActivity.this.hnh.bNB());
            }
            PbActivity.this.hnh.nZ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hnw = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amr() {
            if (PbActivity.this.hnh == null || PbActivity.this.hnh.bNz() == null || !PbActivity.this.hnh.bNz().cnN()) {
                return !PbActivity.this.wd(com.baidu.tbadk.core.util.aj.bKt);
            }
            PbActivity.this.showToast(PbActivity.this.hnh.bNz().cnP());
            if (PbActivity.this.hnc != null && PbActivity.this.hnc.bMo() != null && PbActivity.this.hnc.bMo().bKI() != null && PbActivity.this.hnc.bMo().bKI().amH()) {
                PbActivity.this.hnc.bMo().bKI().a(PbActivity.this.hnh.bNB());
            }
            PbActivity.this.hnh.oa(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean eZH = false;
    private int hnE = 0;
    private int hnF = -1;
    private final a hnH = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hnc != null && PbActivity.this.hnc.bMo() != null) {
                s bMo = PbActivity.this.hnc.bMo();
                if (bMo.bKG()) {
                    bMo.bKF();
                    return true;
                }
            }
            if (PbActivity.this.hnc != null && PbActivity.this.hnc.bNg()) {
                PbActivity.this.hnc.bNh();
                return true;
            }
            return false;
        }
    };
    private r.a hnI = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
    };
    private AddExperiencedModel.a eZR = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bJN();
        }
    };
    private final z.a hnJ = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hnc.showToast(str);
            }
        }
    };
    private final CustomMessageListener hnK = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmZ != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hnr != null) {
                    PbActivity.this.hnc.nS(PbActivity.this.hnr.amA());
                }
                PbActivity.this.hnc.bMp();
                PbActivity.this.hnc.bMZ();
            }
        }
    };
    CustomMessageListener fak = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hmZ.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hnc != null && PbActivity.this.hmZ != null) {
                    PbActivity.this.hnc.d(PbActivity.this.hmZ.getPbData(), PbActivity.this.hmZ.bKS(), PbActivity.this.hmZ.getRequestType());
                }
                if (PbActivity.this.hnc != null && PbActivity.this.hnc.bMF() != null) {
                    PbActivity.this.hnc.bMF().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hnL = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hnc != null) {
                    if (booleanValue) {
                        PbActivity.this.hnc.buo();
                    } else {
                        PbActivity.this.hnc.bun();
                    }
                }
            }
        }
    };
    private CustomMessageListener hnM = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hnr != null) {
                    PbActivity.this.hnc.nS(PbActivity.this.hnr.amA());
                }
                PbActivity.this.hnc.nU(false);
            }
        }
    };
    private CustomMessageListener hnN = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener hnO = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hnc != null && PbActivity.this.hnc.bMF() != null) {
                PbActivity.this.hnc.bMF().notifyDataSetChanged();
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
    private final CustomMessageListener bro = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hmE) {
                PbActivity.this.bKd();
            }
        }
    };
    private h.a hnP = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void n(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.wf(2);
                aj.bMa().reset();
                PbActivity.this.hmZ.bLn();
                boolean z2 = false;
                ArrayList<PostData> bIb = PbActivity.this.hmZ.getPbData().bIb();
                if (bIb != null) {
                    Iterator<PostData> it = bIb.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cez().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hnc.o(PbActivity.this.hmZ.getPbData());
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
    private CustomMessageListener hnQ = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmZ.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hmZ.bLe() != null && PbActivity.this.hmZ.bLe().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hnc.a(aaVar.sendCount, PbActivity.this.hmZ.getPbData(), PbActivity.this.hmZ.bKS(), PbActivity.this.hmZ.getRequestType());
                    }
                    if (pbData.bIb() != null && pbData.bIb().size() >= 1 && pbData.bIb().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bIb().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.hmZ.bKR(), 0L);
                        if (d2 == aaVar.postId && d3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cey = pbData.bIb().get(0).cey();
                            if (cey == null) {
                                cey = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> XM = cey.XM();
                            if (XM == null) {
                                XM = new ArrayList<>();
                            }
                            XM.add(0, aVar);
                            cey.setTotal(aaVar.sendCount + cey.getTotal());
                            cey.m(XM);
                            pbData.bIb().get(0).a(cey);
                            PbActivity.this.hnc.bMF().notifyDataSetChanged();
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
            if (customResponsedMessage != null && PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                PbActivity.this.zK((String) customResponsedMessage.getData());
                PbActivity.this.hmZ.bLk();
                if (PbActivity.this.hnc.bMF() != null) {
                    PbActivity.this.hnc.o(PbActivity.this.hmZ.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hnR = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bNI()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hnS = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ac(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.T(list) && PbActivity.this.hnc != null) {
                PbActivity.this.hnc.dD(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hnT = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
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
    private boolean hnU = false;
    private PraiseModel hnV = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void rd(String str) {
            PbActivity.this.hnU = false;
            if (PbActivity.this.hnV != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmZ.getPbData();
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
            PbActivity.this.hnU = false;
            if (PbActivity.this.hnV != null && str != null) {
                if (AntiHelper.aB(i, str)) {
                    AntiHelper.aV(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hnW = 0;
    private boolean hnX = true;
    private b.a hnY = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void no(boolean z) {
            PbActivity.this.nn(z);
            if (PbActivity.this.hnc.bNm() != null && z) {
                PbActivity.this.hnc.nN(false);
            }
            PbActivity.this.hnc.nP(z);
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
                        if (PbActivity.this.bIg().YR() != null && PbActivity.this.bIg().YR().getGodUserData() != null) {
                            PbActivity.this.bIg().YR().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().YR() != null) {
                            PbActivity.this.hmZ.getPbData().bHZ().YR().setHadConcerned(updateAttentionMessage.isAttention());
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
            PbActivity.this.hnc.aME();
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
                    if (PbActivity.this.hnc != null && PbActivity.this.hnc.bJr() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").bJ(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.hnd != null && PbActivity.this.hnd.fAk != null) {
                            PbActivity.this.hnd.fAk.onClick(view);
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
            if (PbActivity.this.hnr != null) {
                PbActivity.this.hnc.nS(PbActivity.this.hnr.amA());
            }
            PbActivity.this.hnc.bMp();
            PbActivity.this.hnc.bMZ();
            return true;
        }
    });
    private CustomMessageListener hnZ = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnz) {
                PbActivity.this.hnc.aME();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmZ.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bIm().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hny.i(PbActivity.this.hnx.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hnx.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.oW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bJZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hnx.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.hny.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hoa = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnz) {
                PbActivity.this.hnc.aME();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hny.i(PbActivity.this.hnx.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hnx.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.hny.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hob = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnz) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hnc.aME();
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
                    PbActivity.this.hnc.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hoc = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hnc.bMq() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bJt();
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
    public a.b hbo = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bcN();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hmZ.getPageData();
            int pageNum = PbActivity.this.hnc.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.XF()) {
                PbActivity.this.hnc.bMZ();
                PbActivity.this.wf(2);
                PbActivity.this.bcM();
                PbActivity.this.hnc.bMJ();
                if (com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.hmZ.wn(PbActivity.this.hnc.getPageNum());
                    if (PbActivity.this.hmC != null) {
                        PbActivity.this.hmC.showFloatingView();
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
                    if (view == PbActivity.this.hnc.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hmZ.ny(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hnc.bMK();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLV()) {
                        if (view == PbActivity.this.hnc.hvT.csE) {
                            if (PbActivity.this.hnc.nR(PbActivity.this.hmZ.bKX())) {
                                PbActivity.this.bcM();
                                return;
                            }
                            PbActivity.this.hmF = false;
                            PbActivity.this.hmD = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hnc.hvT.csE);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hnc.bMH() && (PbActivity.this.hnc.hvT.bNV() == null || (view != PbActivity.this.hnc.hvT.bNV().bLU() && view != PbActivity.this.hnc.hvT.bNV().bLS()))) {
                            if (view == PbActivity.this.hnc.bNc()) {
                                if (PbActivity.this.hmZ != null) {
                                    com.baidu.tbadk.browser.a.ar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmZ.getPbData().bHZ().YQ().getLink());
                                }
                            } else if (view != PbActivity.this.hnc.hvT.hAS) {
                                if (view == PbActivity.this.hnc.hvT.hAT) {
                                    if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                                        ArrayList<PostData> bIb = PbActivity.this.hmZ.getPbData().bIb();
                                        if ((bIb == null || bIb.size() <= 0) && PbActivity.this.hmZ.bKS()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").bJ("tid", PbActivity.this.hmZ.bKR()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId()));
                                        if (!PbActivity.this.hnc.bNr()) {
                                            PbActivity.this.hnc.bMp();
                                        }
                                        PbActivity.this.bJB();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == d.g.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.kY()) {
                                        PbActivity.this.hnc.ns(true);
                                        PbActivity.this.hnc.bMp();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hnc.buo();
                                            PbActivity.this.bcM();
                                            PbActivity.this.hnc.bMJ();
                                            PbActivity.this.hmZ.zR(PbActivity.this.bJO());
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
                                    if ((PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLR()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                        if (PbActivity.this.hnc.hvT.bNV() != null && view == PbActivity.this.hnc.hvT.bNV().getCancelView()) {
                                            PbActivity.this.hnc.hvT.Qk();
                                        } else if (view.getId() != d.g.pb_editor_tool_share && view.getId() != d.g.share_num_container) {
                                            if (PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLP()) {
                                                if ((PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLX()) && view.getId() != d.g.pb_sort) {
                                                    if (PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLQ()) {
                                                        if (PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLY()) {
                                                            if (PbActivity.this.hnc.bNm() == view) {
                                                                if (PbActivity.this.hnc.bNm().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmZ.getPbData();
                                                                    if (pbData != null && pbData.bHZ() != null && pbData.bHZ().Yx() != null) {
                                                                        String Yo = pbData.bHZ().Yx().Yo();
                                                                        if (StringUtils.isNull(Yo)) {
                                                                            Yo = pbData.bHZ().Yx().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").bJ(VideoPlayActivityConfig.OBJ_ID, Yo));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.dX("c10725", null);
                                                                }
                                                                PbActivity.this.bJV();
                                                            } else if (PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLW()) {
                                                                if (PbActivity.this.hnc.hvT.bNV() != null && view == PbActivity.this.hnc.hvT.bNV().bLT()) {
                                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hnc.c(PbActivity.this.hmZ.getPbData(), PbActivity.this.hmZ.bKS(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                PbActivity.this.hnc.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hnc.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hnc.hvT.Qk();
                                                                    } else {
                                                                        PbActivity.this.showToast(d.j.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.sub_pb_more || view.getId() == d.g.sub_pb_item || view.getId() == d.g.pb_floor_reply_more || view.getId() == d.g.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hmZ != null && view.getId() == d.g.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar.bJ("tid", PbActivity.this.hmZ.bKR());
                                                                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
                                                                        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar.T("obj_locate", 4);
                                                                        TiebaStatic.log(amVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hmZ.getPbData() != null) {
                                                                            PbActivity.this.hnc.bMZ();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(d.g.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(d.g.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.ceC() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                }
                                                                                if (postData.iHd != null) {
                                                                                    com.baidu.tbadk.core.util.am adj = postData.iHd.adj();
                                                                                    adj.delete("obj_locate");
                                                                                    if (view.getId() == d.g.new_sub_pb_list_richText) {
                                                                                        adj.T("obj_locate", 6);
                                                                                    } else if (view.getId() == d.g.pb_floor_reply_more) {
                                                                                        adj.T("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(adj);
                                                                                }
                                                                                String bKR = PbActivity.this.hmZ.bKR();
                                                                                String id = postData.getId();
                                                                                int i2 = 0;
                                                                                if (PbActivity.this.hmZ.getPbData() != null) {
                                                                                    i2 = PbActivity.this.hmZ.getPbData().bIl();
                                                                                }
                                                                                PbActivity.this.bcM();
                                                                                if (view.getId() == d.g.replybtn) {
                                                                                    c zP = PbActivity.this.zP(id);
                                                                                    if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && zP != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKR, id, "pb", true, null, true, null, i2, postData.bON(), PbActivity.this.hmZ.getPbData().getAnti(), false, postData.YR().getIconInfo()).addBigImageData(zP.hoW, zP.hoX, zP.hoY, zP.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hmZ.bLz());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hmZ.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c zP2 = PbActivity.this.zP(id);
                                                                                    if (postData != null && PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && zP2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKR, id, "pb", true, null, false, null, i2, postData.bON(), PbActivity.this.hmZ.getPbData().getAnti(), false, postData.YR().getIconInfo()).addBigImageData(zP2.hoW, zP2.hoX, zP2.hoY, zP2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hmZ.bLz());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hmZ.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.pb_post_reply_count) {
                                                                    if (PbActivity.this.hmZ != null) {
                                                                        com.baidu.tbadk.core.util.am amVar2 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar2.bJ("tid", PbActivity.this.hmZ.bKR());
                                                                        amVar2.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
                                                                        amVar2.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar2.T("obj_locate", 5);
                                                                        TiebaStatic.log(amVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                                                                                    String bKR2 = PbActivity.this.hmZ.bKR();
                                                                                    String id2 = postData2.getId();
                                                                                    int i3 = 0;
                                                                                    if (PbActivity.this.hmZ.getPbData() != null) {
                                                                                        i3 = PbActivity.this.hmZ.getPbData().bIl();
                                                                                    }
                                                                                    c zP3 = PbActivity.this.zP(id2);
                                                                                    if (zP3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKR2, id2, "pb", true, null, false, null, i3, postData2.bON(), PbActivity.this.hmZ.getPbData().getAnti(), false, postData2.YR().getIconInfo()).addBigImageData(zP3.hoW, zP3.hoX, zP3.hoY, zP3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hmZ.bLz());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hmZ.getFromForumId());
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
                                                                    if (PbActivity.this.hmZ != null) {
                                                                        com.baidu.tbadk.core.util.am amVar3 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar3.bJ("tid", PbActivity.this.hmZ.bKR());
                                                                        amVar3.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
                                                                        amVar3.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar3.T("obj_locate", 6);
                                                                        TiebaStatic.log(amVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.bJq().bMn() != null && postData3.YR() != null && postData3.ceq() != 1) {
                                                                                    if (PbActivity.this.bJq().bMo() != null) {
                                                                                        PbActivity.this.bJq().bMo().bKE();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                                                                    jVar.a(PbActivity.this.hmZ.getPbData().getForum());
                                                                                    jVar.aj(PbActivity.this.hmZ.getPbData().bHZ());
                                                                                    jVar.e(postData3);
                                                                                    PbActivity.this.bJq().bMn().d(jVar);
                                                                                    PbActivity.this.bJq().bMn().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.YR().getUserId(), "");
                                                                                    if (PbActivity.this.hnr != null) {
                                                                                        PbActivity.this.hnc.nS(PbActivity.this.hnr.amA());
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
                                                                } else if (view != PbActivity.this.hnc.bJl()) {
                                                                    if (view == PbActivity.this.hnc.hvT.bNW()) {
                                                                        PbActivity.this.hnc.bMQ();
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").bJ("tid", PbActivity.this.hmZ.hrZ));
                                                                                    }
                                                                                    if (PbActivity.this.hnj == null) {
                                                                                        PbActivity.this.hnj = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                                                                                        PbActivity.this.hnj.a(PbActivity.this.hon);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cm(view);
                                                                                    if (!PbActivity.this.cm(view) || PbActivity.this.hnB == null || !PbActivity.this.hnB.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hnj);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(fVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.ces() != null && postData4.ces().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hnj);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(d.g.tag_clip_board, postData4);
                                                                                            fVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(fVar5);
                                                                                        }
                                                                                        PbActivity.this.fPQ = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hmZ.getPbData().Vb()) {
                                                                                        String Va = PbActivity.this.hmZ.getPbData().Va();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(Va) && Va.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hnj);
                                                                                            } else {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hnj);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(d.g.tag_clip_board, PbActivity.this.fPQ);
                                                                                            sparseArray6.put(d.g.tag_is_subpb, false);
                                                                                            fVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(fVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hnj);
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
                                                                                                        com.baidu.tbadk.core.dialog.f fVar7 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnj);
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
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnj);
                                                                                                        fVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(d.g.tag_should_delete_visible, false);
                                                                                                        fVar2 = null;
                                                                                                    }
                                                                                                    fVar3 = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hnj);
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
                                                                                                    if (PbActivity.this.hmZ.getPbData().bIl() == 1002 && !z3) {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnj);
                                                                                                    } else {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnj);
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
                                                                                            PbActivity.this.hnj.P(arrayList);
                                                                                            if (PbActivity.this.hni != null) {
                                                                                                PbActivity.this.hni = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hnj.abk());
                                                                                            } else {
                                                                                                PbActivity.this.hni.setContentView(PbActivity.this.hnj.abk());
                                                                                            }
                                                                                            PbActivity.this.hni.showDialog();
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
                                                                                    PbActivity.this.hnj.P(arrayList);
                                                                                    if (PbActivity.this.hni != null) {
                                                                                    }
                                                                                    PbActivity.this.hni.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_act_btn) {
                                                                            if (PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), PbActivity.this.hmZ.getPbData().bHZ().getActUrl());
                                                                                if (PbActivity.this.hmZ.getPbData().bHZ().ZB() != 1) {
                                                                                    if (PbActivity.this.hmZ.getPbData().bHZ().ZB() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.lottery_tail) {
                                                                            if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()).bJ("tid", PbActivity.this.hmZ.getPbData().getThreadId()).bJ("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hmZ.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hnc.setSelection(0);
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
                                                                                PbActivity.this.hnc.bMp();
                                                                            }
                                                                        } else if (id3 == d.g.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bJy() == 1 && PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()).bJ("tid", PbActivity.this.hmZ.getPbData().getThreadId()).bJ("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bJy() == 1 && PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()).bJ("tid", PbActivity.this.hmZ.getPbData().getThreadId()).bJ("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.manga_prev_btn) {
                                                                            PbActivity.this.bJQ();
                                                                        } else if (id3 == d.g.manga_next_btn) {
                                                                            PbActivity.this.bJR();
                                                                        } else if (id3 == d.g.yule_head_img_img) {
                                                                            if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bIs() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hmZ.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").bJ(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                ba.adD().c(PbActivity.this.getPageContext(), new String[]{pbData2.bIs().bIz()});
                                                                            }
                                                                        } else if (id3 == d.g.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bIs() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hmZ.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                ba.adD().c(PbActivity.this.getPageContext(), new String[]{pbData3.bIs().bIz()});
                                                                            }
                                                                        } else if (PbActivity.this.hnc.hvT.bNV() != null && view == PbActivity.this.hnc.hvT.bNV().bLZ()) {
                                                                            if (PbActivity.this.hmZ == null || PbActivity.this.hmZ.getPbData() == null || PbActivity.this.hmZ.getPbData().bHZ() == null) {
                                                                                PbActivity.this.hnc.hvT.Qk();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.lo()) {
                                                                                PbActivity.this.showToast(d.j.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i4 = 1;
                                                                                if (PbActivity.this.hmZ.getPbData().bHZ().Yy() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmZ.bKR(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).abh();
                                                                                    i4 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").T("obj_locate", PbActivity.this.ax(PbActivity.this.hmZ.getPbData().bHZ())).bJ("tid", PbActivity.this.hmZ.getPbData().bHZ().getTid()).T("obj_type", i4));
                                                                            }
                                                                        } else if (id3 == d.g.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hnE >= 0) {
                                                                                if (PbActivity.this.hmZ != null) {
                                                                                    PbActivity.this.hmZ.bLA();
                                                                                }
                                                                                if (PbActivity.this.hnc.bMF() != null) {
                                                                                    PbActivity.this.hnc.bMF().a(PbActivity.this.hmZ.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hnc.getListView().setSelection(PbActivity.this.hmZ.bLD());
                                                                                PbActivity.this.hnE = 0;
                                                                                if (PbActivity.this.hmZ != null) {
                                                                                    PbActivity.this.hmZ.bU(0, 0);
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
                                                                            if (PbActivity.this.hmZ.getPbData().bHZ().YI() > 0) {
                                                                                if (PbActivity.this.mLastScrollState == 0) {
                                                                                    int firstVisiblePosition = PbActivity.this.hnc.getListView().getFirstVisiblePosition();
                                                                                    int top = PbActivity.this.hnc.getListView().getChildAt(0).getTop();
                                                                                    if (firstVisiblePosition != 0 || top != 0 || PbActivity.this.hmV != 0 || PbActivity.this.hmU != 0) {
                                                                                        if (firstVisiblePosition == 0 && top <= 0 && top >= (-PbActivity.this.getResources().getDimension(d.e.tbds66))) {
                                                                                            if (PbActivity.this.hnc.getListView().getChildAt(PbActivity.this.hmV) != null) {
                                                                                                PbActivity.this.hnc.getListView().smoothScrollToPosition(PbActivity.this.hmV, PbActivity.this.hmU, 200);
                                                                                            } else {
                                                                                                PbActivity.this.hnc.getListView().setSelectionFromTop(PbActivity.this.hmV, PbActivity.this.hmU + ((int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d)));
                                                                                                PbActivity.this.hnc.getListView().smoothScrollBy((int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d), 500);
                                                                                            }
                                                                                        } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-com.baidu.adp.lib.util.l.aQ(PbActivity.this)) * 0.6d)) {
                                                                                            PbActivity.this.hnc.getListView().setSelectionFromTop(0, -((int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d)));
                                                                                            PbActivity.this.hnc.getListView().smoothScrollBy(-((int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d)), 500);
                                                                                        } else {
                                                                                            PbActivity.this.hnc.getListView().smoothScrollToPosition(0, 0, 500);
                                                                                        }
                                                                                        PbActivity.this.hmV = firstVisiblePosition;
                                                                                        PbActivity.this.hmU = top;
                                                                                        if (PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().YR() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmZ.hrZ).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bJv();
                                                                                if (PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().YR() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmZ.hrZ).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId()));
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_nav_title_forum_image || id3 == d.g.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(PbActivity.this.hmZ.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hmZ.bLz() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hmZ.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar4 = new com.baidu.tbadk.core.util.am("c13401");
                                                                                amVar4.bJ("tid", PbActivity.this.hmZ.bKR());
                                                                                amVar4.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
                                                                                amVar4.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hmZ.bLz() == 3 && PbActivity.this.bIQ() && PbActivity.this.hmZ.getPbData() != null && com.baidu.tbadk.core.util.v.T(PbActivity.this.hmZ.getPbData().bIu())) {
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
                                                                            if (PbActivity.this.hmZ != null) {
                                                                                com.baidu.tbadk.core.util.am amVar6 = new com.baidu.tbadk.core.util.am("c13398");
                                                                                amVar6.bJ("tid", PbActivity.this.hmZ.bKR());
                                                                                amVar6.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
                                                                                amVar6.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                amVar6.T("obj_locate", 2);
                                                                                TiebaStatic.log(amVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.hmZ.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.hmZ.bKR(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hmZ.getPbData().bHZ().Zl())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.kY()) {
                                                                PbActivity.this.hnc.bMZ();
                                                                SparseArray<Object> c3 = PbActivity.this.hnc.c(PbActivity.this.hmZ.getPbData(), PbActivity.this.hmZ.bKS(), 1);
                                                                if (c3 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmZ.getPbData().getForum().getId(), PbActivity.this.hmZ.getPbData().getForum().getName(), PbActivity.this.hmZ.getPbData().bHZ().getId(), String.valueOf(PbActivity.this.hmZ.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_name_show), (String) c3.get(d.g.tag_forbid_user_post_id), (String) c3.get(d.g.tag_forbid_user_portrait))));
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
                                                            PbActivity.this.hnc.hvT.bNU();
                                                        }
                                                    } else if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null) {
                                                        PbActivity.this.hnc.hvT.Qk();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                        PbActivity.this.zM(PbActivity.this.hmZ.getPbData().bHZ().Zh());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hnc.bMZ();
                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hmZ.bLi()));
                                                            return;
                                                        }
                                                        PbActivity.this.wf(2);
                                                        PbActivity.this.bcM();
                                                        PbActivity.this.hnc.bMJ();
                                                        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hmZ.getPbData().hkv == null || PbActivity.this.hmZ.getPbData().hkv.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(d.j.sort_type_new), PbActivity.this.getResources().getString(d.j.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hmZ.getPbData().hkv.size()];
                                                            int i5 = 0;
                                                            while (true) {
                                                                int i6 = i5;
                                                                if (i6 >= PbActivity.this.hmZ.getPbData().hkv.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i6] = PbActivity.this.hmZ.getPbData().hkv.get(i6).sort_name + PbActivity.this.getResources().getString(d.j.sort_static);
                                                                i5 = i6 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        gVar.a(null, strArr, new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                                            @Override // com.baidu.tbadk.core.dialog.i.c
                                                            public void a(com.baidu.tbadk.core.dialog.i iVar, int i7, View view3) {
                                                                int i8 = 2;
                                                                gVar.dismiss();
                                                                if (PbActivity.this.hmZ.getSortType() == 1 && i7 == 1) {
                                                                    i8 = 0;
                                                                } else if (PbActivity.this.hmZ.getSortType() == 2 && i7 == 0) {
                                                                    i8 = 1;
                                                                } else if (PbActivity.this.hmZ.getSortType() != 3 || i7 == 2) {
                                                                    i8 = (i7 != 2 || PbActivity.this.hmZ.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != d.g.pb_sort ? 1 : 0).T("obj_type", i8));
                                                                if (PbActivity.this.hmZ.getPbData().hkv != null && PbActivity.this.hmZ.getPbData().hkv.size() > i7) {
                                                                    i7 = PbActivity.this.hmZ.getPbData().hkv.get(i7).sort_type.intValue();
                                                                }
                                                                boolean ws = PbActivity.this.hmZ.ws(i7);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hmZ.bLi()));
                                                                if (ws) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hnc.nJ(true);
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
                                                PbActivity.this.hnc.bMZ();
                                                if (PbActivity.this.bJa().getPbData().hkw != 2) {
                                                    if (PbActivity.this.hmZ.getPageData() != null) {
                                                        PbActivity.this.hnc.a(PbActivity.this.hmZ.getPageData(), PbActivity.this.hbo);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(d.j.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (az.jK() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().YR() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmZ.hrZ).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()).T("obj_locate", 4).bJ("uid", PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId()));
                                            }
                                            if (PbActivity.this.hmZ != null) {
                                                com.baidu.tbadk.core.util.am amVar7 = new com.baidu.tbadk.core.util.am("c12386");
                                                amVar7.bJ("tid", PbActivity.this.hmZ.bKR());
                                                amVar7.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                amVar7.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
                                                amVar7.T("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    amVar7.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(amVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.lo()) {
                                                if (PbActivity.this.hmZ.getPbData() != null) {
                                                    ArrayList<PostData> bIb2 = PbActivity.this.hmZ.getPbData().bIb();
                                                    if ((bIb2 != null && bIb2.size() > 0) || !PbActivity.this.hmZ.bKS()) {
                                                        PbActivity.this.hnc.bMZ();
                                                        PbActivity.this.bcM();
                                                        PbActivity.this.wf(2);
                                                        if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bIs() != null && !StringUtils.isNull(PbActivity.this.hmZ.getPbData().bIs().Xn(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                        if (az.jK()) {
                                                            PbActivity.this.wg(2);
                                                        } else {
                                                            PbActivity.this.hnc.showLoadingDialog();
                                                            PbActivity.this.hmZ.bLu().m(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hnc.bMZ();
                                        if (PbActivity.this.hnc.hvT.bNV() != null && view == PbActivity.this.hnc.hvT.bNV().bLR() && !PbActivity.this.hnc.bNr()) {
                                            PbActivity.this.hnc.bMp();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bcM();
                                            PbActivity.this.hnc.bMJ();
                                            if (view.getId() == d.g.floor_owner_reply) {
                                                u = PbActivity.this.hmZ.u(true, PbActivity.this.bJO());
                                            } else {
                                                u = view.getId() == d.g.reply_title ? PbActivity.this.hmZ.u(false, PbActivity.this.bJO()) : PbActivity.this.hmZ.zR(PbActivity.this.bJO());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hnc.ns(true);
                                                PbActivity.this.hnc.buo();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hnc.nJ(true);
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
                                    PbActivity.this.hnc.bMZ();
                                    if (PbActivity.this.we(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && com.baidu.tbadk.plugins.c.b(PbActivity.this.getPageContext(), "com.baidu.tieba.pluginCore") && PbActivity.this.hmZ.wt(PbActivity.this.hnc.bMO()) != null) {
                                        PbActivity.this.bJI();
                                        if (PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().YR() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmZ.hrZ).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId()).T("obj_locate", 3).bJ("uid", PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId()));
                                        }
                                        if (PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().YR() != null && PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId() != null && PbActivity.this.hnb != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hmZ.hrZ).T("obj_locate", 1).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId()).T("obj_type", PbActivity.this.hnb.Vb() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hmZ.getPbData())));
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
                                if (PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().ZL() && PbActivity.this.hmZ.getPbData().bHZ().Zi() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.hmZ.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hmZ.bIR()) && PbActivity.this.hmZ.getAppealInfo() != null) {
                                        name = PbActivity.this.hmZ.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hmZ.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bIR = PbActivity.this.hmZ.bIR();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hmZ.bKT() && bIR != null && bIR.equals(name)) {
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
                            if (PbActivity.this.hmZ.getPbData() != null) {
                                if ((PbActivity.this.hmZ.getPbData().bIl() == 1 || PbActivity.this.hmZ.getPbData().bIl() == 3) && !PbActivity.this.eja.cfc()) {
                                    PbActivity.this.hnc.bMZ();
                                    int i7 = 0;
                                    if (PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLS()) {
                                        if (PbActivity.this.hnc.hvT.bNV() == null || view != PbActivity.this.hnc.hvT.bNV().bLU()) {
                                            if (view == PbActivity.this.hnc.bMH()) {
                                                i7 = 2;
                                            }
                                        } else if (PbActivity.this.hmZ.getPbData().bHZ().YN() == 1) {
                                            i7 = 3;
                                        } else {
                                            i7 = 6;
                                        }
                                    } else if (PbActivity.this.hmZ.getPbData().bHZ().YM() == 1) {
                                        i7 = 5;
                                    } else {
                                        i7 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hmZ.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hmZ.getPbData().bHZ().getId();
                                    PbActivity.this.hnc.bMG();
                                    PbActivity.this.eja.a(id4, name2, id5, i7, PbActivity.this.hnc.bMI());
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
                        PbActivity.this.hnc.bMZ();
                        PbActivity.this.bcM();
                        PbActivity.this.hnc.bMJ();
                        PbActivity.this.hnc.showLoadingDialog();
                        if (PbActivity.this.hnc.bMx() != null) {
                            PbActivity.this.hnc.bMx().setVisibility(8);
                        }
                        PbActivity.this.hmZ.wn(1);
                        if (PbActivity.this.hmC != null) {
                            PbActivity.this.hmC.showFloatingView();
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
                if (PbActivity.this.hmZ != null) {
                    com.baidu.tbadk.core.util.am amVar8 = new com.baidu.tbadk.core.util.am("c13398");
                    amVar8.bJ("tid", PbActivity.this.hmZ.bKR());
                    amVar8.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
                    amVar8.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar8.T("obj_locate", 1);
                    TiebaStatic.log(amVar8);
                }
                if (PbActivity.this.hmM) {
                    PbActivity.this.hmM = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.bJq().bMn() != null && postData5.YR() != null && postData5.ceq() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bJq().bMo() != null) {
                                PbActivity.this.bJq().bMo().bKE();
                            }
                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                            jVar2.a(PbActivity.this.hmZ.getPbData().getForum());
                            jVar2.aj(PbActivity.this.hmZ.getPbData().bHZ());
                            jVar2.e(postData5);
                            PbActivity.this.bJq().bMn().d(jVar2);
                            PbActivity.this.bJq().bMn().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.YR().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hmZ.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hnr != null) {
                                PbActivity.this.hnc.nS(PbActivity.this.hnr.amA());
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
                if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId());
                }
                if (PbActivity.this.hmZ != null) {
                    amVar.bJ("tid", PbActivity.this.hmZ.bKR());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.bcM();
            PbActivity.this.hnc.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.s.ap.apH() && PbActivity.this.bJa() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bJa().zU(postWriteCallBackData.getPostId());
                    PbActivity.this.hnE = PbActivity.this.hnc.bMt();
                    if (PbActivity.this.hmZ != null) {
                        PbActivity.this.hmZ.bU(PbActivity.this.hnE, PbActivity.this.hnc.bMu());
                    }
                }
                PbActivity.this.hnc.bMZ();
                PbActivity.this.hnh.bNx();
                if (PbActivity.this.hnr != null) {
                    PbActivity.this.hnc.nS(PbActivity.this.hnr.amA());
                }
                PbActivity.this.hnc.bMm();
                PbActivity.this.hnc.nU(true);
                PbActivity.this.hmZ.bLk();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hmZ.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmZ.getPbData();
                            if (pbData != null && pbData.bHZ() != null && pbData.bHZ().YR() != null && (userId = pbData.bHZ().YR().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.s.ap.apH() && PbActivity.this.hmZ.bLb()) {
                                PbActivity.this.hnc.bMJ();
                            }
                        } else if (!com.baidu.tbadk.s.ap.apH() && PbActivity.this.hmZ.bLb()) {
                            PbActivity.this.hnc.bMJ();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hnc.o(PbActivity.this.hmZ.getPbData());
                    }
                    if (PbActivity.this.hmZ.bKW()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").bJ("tid", PbActivity.this.hmZ.bKR()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hnr.amG() || PbActivity.this.hnr.amH()) {
                    PbActivity.this.hnr.a(false, postWriteCallBackData);
                }
                PbActivity.this.hnh.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gyK != null) {
                    PbActivity.this.gyK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hod = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getPbData().getForumId());
                }
                if (PbActivity.this.hmZ != null) {
                    amVar.bJ("tid", PbActivity.this.hmZ.bKR());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (PbActivity.this.hnh != null) {
                    PbActivity.this.hnh.bNw();
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
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hnh != null) {
                if (PbActivity.this.hnc != null && PbActivity.this.hnc.bMo() != null && PbActivity.this.hnc.bMo().bKI() != null && PbActivity.this.hnc.bMo().bKI().amH()) {
                    PbActivity.this.hnc.bMo().bKI().a(postWriteCallBackData);
                }
                PbActivity.this.hnh.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a hoe = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g jt;
            if (!z || dVar == null || dVar.bIj() != null || com.baidu.tbadk.core.util.v.S(dVar.bIb()) >= 1) {
                PbActivity.this.gQe = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hnc.bML();
                if (dVar == null || !dVar.bIf()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hnc.getView());
                }
                PbActivity.this.hnc.bun();
                if (PbActivity.this.isFullScreen || PbActivity.this.hnc.bNr()) {
                    PbActivity.this.hnc.bNi();
                } else if (!PbActivity.this.hnc.bNf()) {
                    PbActivity.this.hnc.nU(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hnk = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hnc.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hnc.aOA();
                    if (dVar.bHZ() != null && dVar.bHZ().ZU() != null) {
                        PbActivity.this.a(dVar.bHZ().ZU());
                    }
                    PbActivity.this.bJn();
                    if (PbActivity.this.hnr != null) {
                        PbActivity.this.hnc.nS(PbActivity.this.hnr.amA());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bIb() != null && dVar.bIb().size() >= 1 && dVar.bIb().get(0) != null) {
                        PbActivity.this.hmZ.zT(dVar.bIb().get(0).getId());
                    } else if (dVar.bIj() != null) {
                        PbActivity.this.hmZ.zT(dVar.bIj().getId());
                    }
                    if (PbActivity.this.hnr != null) {
                        PbActivity.this.hnr.a(dVar.getAnti());
                        PbActivity.this.hnr.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hnr.a(PbActivity.this.hmZ.bLe(), PbActivity.this.hmZ.bKR(), PbActivity.this.hmZ.bLw());
                        if (dVar.bHZ() != null) {
                            PbActivity.this.hnr.eO(dVar.bHZ().aaj());
                        }
                    }
                    if (PbActivity.this.hnb != null) {
                        PbActivity.this.hnb.cZ(dVar.Vb());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hnc.nT(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hnc.a(dVar, i2, i3, PbActivity.this.hmZ.bKS(), i4, PbActivity.this.hmZ.getIsFromMark());
                    PbActivity.this.hnc.e(dVar, PbActivity.this.hmZ.bKS());
                    PbActivity.this.hnc.nQ(PbActivity.this.hmZ.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.cki = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.cki) && PbActivity.this.hnr != null && PbActivity.this.hnr.alT() != null && (jt = PbActivity.this.hnr.alT().jt(6)) != null && !TextUtils.isEmpty(PbActivity.this.cki)) {
                            ((View) jt).setOnClickListener(PbActivity.this.ckW);
                        }
                    }
                    if (PbActivity.this.hnm) {
                        PbActivity.this.hnm = false;
                        final int bJD = PbActivity.this.bJD();
                        if (!dVar.bIx()) {
                            PbActivity.this.hnc.wz(bJD);
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
                    if (PbActivity.this.hnn) {
                        PbActivity.this.hnn = false;
                        final int bJD2 = PbActivity.this.bJD();
                        final boolean z2 = bJD2 != -1;
                        if (!z2) {
                            bJD2 = PbActivity.this.bJE();
                        }
                        if (PbActivity.this.hnc != null) {
                            if (!dVar.bIx()) {
                                PbActivity.this.hnc.wz(bJD2);
                            } else {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bJD2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hnc.setSelectionFromTop(bJD2, aO2);
                                            } else {
                                                PbActivity.this.hnc.setSelectionFromTop(bJD2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hnc.nV(true);
                            }
                        }
                    } else if (PbActivity.this.hno) {
                        PbActivity.this.hno = false;
                        PbActivity.this.hnc.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hnc.bMP();
                    }
                    PbActivity.this.hmZ.a(dVar.getForum(), PbActivity.this.hnR);
                    PbActivity.this.hmZ.a(PbActivity.this.hnS);
                    if (PbActivity.this.gyK != null && dVar.bHZ() != null && dVar.bHZ().YR() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bHZ().YR());
                        PbActivity.this.gyK.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hnk && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hmZ.getAppealInfo().hjP)) {
                                    PbActivity.this.hnc.a(PbActivity.this.hmZ.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hnc.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hnc.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                            }
                            PbActivity.this.hnc.bNi();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hmZ.bKR());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
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
                        PbActivity.this.hnc.zX("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                            arrayList = PbActivity.this.hmZ.getPbData().bIb();
                        }
                        if (com.baidu.tbadk.core.util.v.S(arrayList) != 0 && (com.baidu.tbadk.core.util.v.S(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).ceq() != 1)) {
                            PbActivity.this.hnc.zX(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                        } else if (PbActivity.this.bKb()) {
                            PbActivity.this.hnc.zY(PbActivity.this.getResources().getString(d.j.pb_no_host_reply));
                        } else {
                            PbActivity.this.hnc.zY(PbActivity.this.getResources().getString(d.j.pb_no_replay));
                        }
                    }
                    PbActivity.this.hnc.aeD();
                }
                PbActivity.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bJa().bKS() || PbActivity.this.bJa().getPbData().getPage().XL() != 0 || PbActivity.this.bJa().bLq()) {
                    PbActivity.this.hns = true;
                    return;
                }
                return;
            }
            PbActivity.this.hmZ.wn(1);
            if (PbActivity.this.hmC != null) {
                PbActivity.this.hmC.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hnc.o(dVar);
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
                if (!z2 && PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null) {
                    int threadType = PbActivity.this.hmZ.getPbData().bHZ().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmP, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmP, "from_frs")) {
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
    private CustomMessageListener hof = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bJz();
            }
        }
    };
    private final a.InterfaceC0187a hog = new a.InterfaceC0187a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0187a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hnc.bML();
            if (z) {
                if (PbActivity.this.hnb != null) {
                    PbActivity.this.hnb.cZ(z2);
                }
                PbActivity.this.hmZ.nA(z2);
                if (PbActivity.this.hmZ.Vb()) {
                    PbActivity.this.bJJ();
                } else {
                    PbActivity.this.hnc.o(PbActivity.this.hmZ.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hnb != null && PbActivity.this.hnb.Ve() != null && PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().YR() != null) {
                        MarkData Ve = PbActivity.this.hnb.Ve();
                        MetaData YR = PbActivity.this.hmZ.getPbData().bHZ().YR();
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
                if (PbActivity.this.hnc != null) {
                    PbActivity.this.hnc.bMZ();
                    if (PbActivity.this.hnr != null && !PbActivity.this.hnc.bMq()) {
                        PbActivity.this.hnc.nS(PbActivity.this.hnr.amA());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hnc.bMp();
                    }
                }
                if (!PbActivity.this.hmJ) {
                    PbActivity.this.hmJ = true;
                    PbActivity.this.hnc.bNe();
                }
            }
            PbActivity.this.hnc.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hmC != null) {
                PbActivity.this.hmC.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hmK == null) {
                PbActivity.this.hmK = new com.baidu.tbadk.o.b();
                PbActivity.this.hmK.jX(1001);
            }
            if (i == 0) {
                PbActivity.this.hmK.apb();
            } else {
                PbActivity.this.hmK.apa();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.cdq().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bIb;
            if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hnc != null && PbActivity.this.hnc.bMF() != null) {
                PbActivity.this.hnc.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hmC != null) {
                    PbActivity.this.hmC.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hmZ.bLm() && (bIb = PbActivity.this.hmZ.getPbData().bIb()) != null && !bIb.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hnc.bMF().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmZ.getPbData();
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
    private final com.baidu.adp.base.d eje = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eja.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hmZ.bLk();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCM != 1002 || bVar.fDg) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hnc.a(1, dVar.Id, dVar.iIJ, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eja.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hnc.a(PbActivity.this.eja.getLoadDataMode(), gVar.Id, gVar.iIJ, false);
                        PbActivity.this.hnc.at(gVar.iIM);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hnc.a(PbActivity.this.eja.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hoh = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final h.c cPx = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (PbActivity.this.bJP()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hmZ.nz(true)) {
                PbActivity.this.hnc.bMM();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fsS = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hoi && PbActivity.this.bJP()) {
                PbActivity.this.bJR();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hmZ.ny(false)) {
                    PbActivity.this.hnc.bMK();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hmZ.getPbData() != null) {
                    PbActivity.this.hnc.bNd();
                }
                PbActivity.this.hoi = true;
            }
        }
    };
    private int hoj = 0;
    private final TbRichTextView.h cAE = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bMF;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hmZ != null) {
                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                        amVar.bJ("tid", PbActivity.this.hmZ.bKR());
                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId());
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
                        PbActivity.this.hmT = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hoZ) {
                        TbRichText bh = PbActivity.this.bh(str, i);
                        if (bh != null && PbActivity.this.hoj >= 0 && PbActivity.this.hoj < bh.asw().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bh.asw().get(PbActivity.this.hoj));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hoW.size()) {
                                    break;
                                } else if (!cVar.hoW.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bh.getPostId() != 0 && (bMF = PbActivity.this.hnc.bMF()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bMF.getDataList();
                                if (com.baidu.tbadk.core.util.v.S(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bh.getPostId() == com.baidu.adp.lib.g.b.d(((PostData) next).getId(), 0L)) {
                                            if (bh.getPostId() != com.baidu.adp.lib.g.b.d(PbActivity.this.hmZ.bLw(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hmZ.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.T(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hoX.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoY, cVar.lastId, PbActivity.this.hmZ.bLh(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.m(rect);
                            createConfig.setIsHotSort(PbActivity.this.hmZ.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hoW, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.T(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hoX.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoY, cVar.hoW.get(0), PbActivity.this.hmZ.bLh(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hmZ.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hnc.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hok = false;
    PostData fPQ = null;
    private final b.InterfaceC0191b hol = new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.fPQ != null) {
                if (i == 0) {
                    PbActivity.this.fPQ.ev(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fPQ = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fPQ);
                }
            }
        }
    };
    private final b.InterfaceC0191b hom = new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hnB != null && !TextUtils.isEmpty(PbActivity.this.hnC)) {
                if (i == 0) {
                    if (com.baidu.tbadk.plugins.c.b(PbActivity.this.getPageContext(), "com.baidu.tieba.pluginResource")) {
                        if (PbActivity.this.hnD == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnC));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hnC;
                            aVar.pkgId = PbActivity.this.hnD.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnD.memeInfo.pck_id;
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
                        PbActivity.this.fzS.h(PbActivity.this.hnC, PbActivity.this.hnB.oB());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hnB = null;
                PbActivity.this.hnC = null;
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
                        PbActivity.this.hnB = ((TbImageView) view).getBdImage();
                        PbActivity.this.hnC = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hnB == null || TextUtils.isEmpty(PbActivity.this.hnC)) {
                            return true;
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnD = null;
                        } else {
                            PbActivity.this.hnD = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hnB = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hnC = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hnD = null;
                            } else {
                                PbActivity.this.hnD = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hnB = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hnC = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnD = null;
                        } else {
                            PbActivity.this.hnD = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        PbActivity.this.hnc.a(PbActivity.this.hom, PbActivity.this.hnB.isGif());
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
            if (PbActivity.this.fPQ.ceq() != 1 || !PbActivity.this.cm(view)) {
                if (PbActivity.this.hnb != null) {
                    if (!PbActivity.this.hnb.Vb() || PbActivity.this.fPQ.getId() == null || !PbActivity.this.fPQ.getId().equals(PbActivity.this.hmZ.Za())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.fPQ.ceq() == 1) {
                        PbActivity.this.hnc.a(PbActivity.this.hol, z, false);
                        return true;
                    }
                    if (PbActivity.this.hnj == null) {
                        PbActivity.this.hnj = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                        PbActivity.this.hnj.a(PbActivity.this.hon);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cm = PbActivity.this.cm(view);
                        boolean z3 = (!PbActivity.this.cm(view) || PbActivity.this.hnB == null || PbActivity.this.hnB.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hnj);
                            fVar3.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                            fVar3.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                            fVar3.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(fVar3);
                        }
                        if (cm) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, PbActivity.this.getString(d.j.save_to_emotion), PbActivity.this.hnj));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(2, PbActivity.this.getString(d.j.save_to_local), PbActivity.this.hnj));
                        }
                        if (!cm && !z3) {
                            com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hnj);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(d.g.tag_clip_board, PbActivity.this.fPQ);
                            fVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(fVar4);
                        }
                        if (!z4) {
                            if (z) {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hnj);
                            } else {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hnj);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(d.g.tag_clip_board, PbActivity.this.fPQ);
                            sparseArray4.put(d.g.tag_is_subpb, false);
                            fVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(fVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hnj);
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
                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnj);
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
                                    fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnj);
                                    fVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(d.g.tag_should_delete_visible, false);
                                }
                                fVar = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hnj);
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
                                    if (PbActivity.this.hmZ.getPbData().bIl() == 1002 && !z5) {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hnj);
                                    } else {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hnj);
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
                        PbActivity.this.hnj.P(arrayList);
                        if (PbActivity.this.hni == null) {
                            PbActivity.this.hni = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hnj.abk());
                        } else {
                            PbActivity.this.hni.setContentView(PbActivity.this.hnj.abk());
                        }
                        PbActivity.this.hni.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").bJ("tid", PbActivity.this.hmZ.hrZ).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId()).bJ("uid", PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId()).bJ("post_id", PbActivity.this.hmZ.amp()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hnc.a(PbActivity.this.hom, PbActivity.this.hnB.isGif());
            return true;
        }
    };
    private i.c hon = new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.i.c
        public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
            if (PbActivity.this.hni != null) {
                PbActivity.this.hni.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmZ.getPbData();
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
                    if (PbActivity.this.hnB != null && !TextUtils.isEmpty(PbActivity.this.hnC)) {
                        if (PbActivity.this.hnD == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnC));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hnC;
                            aVar.pkgId = PbActivity.this.hnD.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnD.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hnB = null;
                        PbActivity.this.hnC = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hnB != null && !TextUtils.isEmpty(PbActivity.this.hnC)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.adQ();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.Y(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fzS == null) {
                                PbActivity.this.fzS = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fzS.h(PbActivity.this.hnC, PbActivity.this.hnB.oB());
                            PbActivity.this.hnB = null;
                            PbActivity.this.hnC = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.fPQ != null) {
                        PbActivity.this.fPQ.ev(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.fPQ = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").T("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.cl(view);
                        if (PbActivity.this.hmZ.getPbData().bHZ() != null && PbActivity.this.hmZ.getPbData().bHZ().YR() != null && PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId() != null && PbActivity.this.hnb != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hmZ.hrZ).T("obj_locate", 2).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hmZ.getPbData().bHZ().YR().getUserId()).T("obj_type", PbActivity.this.hnb.Vb() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hmZ.getPbData())));
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
                        PbActivity.this.zM((String) tag);
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
                        PbActivity.this.hnc.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hnc.cs(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hnc.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
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
            if (!PbActivity.this.hmE && z && !PbActivity.this.hmZ.bKY()) {
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
            if (av(i2) && PbActivity.this.hnc != null && PbActivity.this.hmC != null) {
                PbActivity.this.hnc.bNj();
                PbActivity.this.hmC.jr(false);
                PbActivity.this.hmC.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aS(int i, int i2) {
            if (av(i2) && PbActivity.this.hnc != null && PbActivity.this.hmC != null) {
                PbActivity.this.hmC.jr(true);
                if (Math.abs(i2) > this.dWo) {
                    PbActivity.this.hmC.hideFloatingView();
                }
                if (PbActivity.this.bJP()) {
                    PbActivity.this.hnc.bMC();
                    PbActivity.this.hnc.bMD();
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
    private String hop = null;
    private final m.a hoq = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void k(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hop = str2;
                PbActivity.this.hnc.zZ(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hor = -1;
    private int hos = -1;
    private CustomMessageListener hov = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bvT == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0189a) {
                    if (aVar.bvU != null && !aVar.bvU.hasError() && aVar.bvU.getError() == 0) {
                        if (PbActivity.this.hnc != null) {
                            PbActivity.this.hnc.s(((a.C0189a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bKa();
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
                        if (PbActivity.this.hnc != null && PbActivity.this.hnc != null) {
                            PbActivity.this.hnc.s(((a.C0189a) aVar).channelId, 2);
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
        public ArrayList<String> hoW;
        public ConcurrentHashMap<String, ImageUrlData> hoX;
        public boolean hoZ;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hoY = false;
        public boolean hpa = false;
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
        return this.hnr;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bID() != null) {
            String id = jVar.bID().getId();
            ArrayList<PostData> bIb = this.hmZ.getPbData().bIb();
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
                    if (postData.cen() != null && bIH != null) {
                        Iterator<PostData> it = bIH.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.YR() != null && (metaData = postData.getUserMap().get(next.YR().getUserId())) != null) {
                                next.a(metaData);
                                next.pY(true);
                                next.a(getPageContext(), this.hmZ.zS(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bIH.size() != postData.cen().size();
                        postData.cen().clear();
                        postData.cen().addAll(bIH);
                        z = z2;
                    }
                    if (postData.cej() != null) {
                        postData.cek();
                    }
                }
            }
            if (!this.hmZ.getIsFromMark() && z) {
                this.hnc.o(this.hmZ.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zK(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bIo = this.hmZ.getPbData().bIo();
            if (bIo != null && str.equals(bIo.getAdId())) {
                if (bIo.cee() != null) {
                    bIo.cee().legoCard = null;
                }
                this.hmZ.getPbData().bIp();
            }
            com.baidu.tieba.tbadkCore.data.m bLc = this.hmZ.bLc();
            if (bLc != null && str.equals(bLc.getAdId())) {
                this.hmZ.bLd();
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
                        if (PbActivity.this.hni != null) {
                            PbActivity.this.hni.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hnc.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.hnz);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hnz);
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
                if (this.hni == null) {
                    this.hni = new com.baidu.tbadk.core.dialog.g(getPageContext(), iVar.abk());
                } else {
                    this.hni.setContentView(iVar.abk());
                }
                this.hni.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        bg bHZ;
        if (this.hmZ != null && this.hmZ.getPbData() != null && (bHZ = this.hmZ.getPbData().bHZ()) != null) {
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
            if (this.hmZ.bKS()) {
                this.hnc.bMF().notifyDataSetChanged();
            } else {
                this.hnc.p(this.hmZ.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hmZ.aa(bundle);
        if (this.eYS != null) {
            this.eYS.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hnr.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hmI = System.currentTimeMillis();
        this.hnx = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eCP = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hmP = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hmP) && intent.getData() != null) {
                this.hmP = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hmP)) {
                this.hmD = true;
            }
            this.hor = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hos = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hot = intent.getStringExtra("key_manga_title");
            this.hnm = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hnn = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hno = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bJP()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.hnF = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eCP = System.currentTimeMillis();
        }
        this.cqn = this.hmI - this.eCP;
        super.onCreate(bundle);
        this.hmG = 0;
        Z(bundle);
        if (this.hmZ != null && this.hmZ.getPbData() != null) {
            this.hmZ.getPbData().zI(this.source);
        }
        initUI();
        if (intent != null && this.hnc != null) {
            this.hnc.hvM = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hnA == null) {
                    this.hnA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hnc.Ab("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hnA, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hmZ != null && this.hmZ.getPbData() != null) {
                this.hmZ.zV(stringExtra);
            }
        }
        this.eYS = new VoiceManager();
        this.eYS.onCreate(getPageContext());
        initData(bundle);
        this.hnq = new com.baidu.tbadk.editortools.pb.f();
        bJn();
        this.hnr = (com.baidu.tbadk.editortools.pb.d) this.hnq.dd(getActivity());
        this.hnr.b(this);
        this.hnr.a(this.cks);
        this.hnr.a(this.ckl);
        this.hnr.a(this, bundle);
        this.hnr.alT().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hnr.alT().eH(true);
        ni(true);
        this.hnc.setEditorTools(this.hnr.alT());
        this.hnr.a(this.hmZ.bLe(), this.hmZ.bKR(), this.hmZ.bLw());
        registerListener(this.hnM);
        if (!this.hmZ.bKX()) {
            this.hnr.oR(this.hmZ.bKR());
        }
        if (this.hmZ.bLx()) {
            this.hnr.oP(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else if (this.hnc != null) {
            this.hnr.oP(this.hnc.bMr());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hnL);
        registerListener(this.hnN);
        registerListener(this.hnO);
        registerListener(this.fak);
        registerListener(this.hoc);
        registerListener(this.hnK);
        this.hnp = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.iFI);
        this.hnp.cdR();
        registerListener(this.hnQ);
        registerListener(this.mAttentionListener);
        if (this.hmZ != null) {
            this.hmZ.bLo();
        }
        registerListener(this.hof);
        registerListener(this.hov);
        registerListener(this.far);
        if (this.hnc != null && this.hnc.bNn() != null && this.hnc.bNo() != null) {
            this.hmC = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hnc.bNn(), this.hnc.bNo(), this.hnc.bMx());
            this.hmC.a(this.hnY);
        }
        if (this.hmB && this.hnc != null && this.hnc.bNo() != null) {
            this.hnc.bNo().setVisibility(8);
        }
        this.hny = new com.baidu.tbadk.core.view.e();
        this.hny.bPN = 1000L;
        registerListener(this.hob);
        registerListener(this.hnZ);
        registerListener(this.hoa);
        registerListener(this.frK);
        registerListener(this.bro);
        this.hnz = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hnz;
        userMuteAddAndDelCustomMessage.setTag(this.hnz);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hnz;
        userMuteCheckCustomMessage.setTag(this.hnz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hmZ.bLu().a(this.dLM);
        this.hnh = new as();
        if (this.hnr.amt() != null) {
            this.hnh.k(this.hnr.amt().getInputView());
        }
        this.hnr.a(this.ckm);
        this.foI = new ShareSuccessReplyToServerModel();
        a(this.hnH);
        this.gyK = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gyK.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bKs) {
                        PbActivity.this.hnr.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bKt && PbActivity.this.hnc != null && PbActivity.this.hnc.bMo() != null && PbActivity.this.hnc.bMo().bKI() != null) {
                        PbActivity.this.hnc.bMo().bKI().amM();
                    } else if (i == com.baidu.tbadk.core.util.aj.bKu) {
                        PbActivity.this.c(PbActivity.this.hnu);
                    }
                }
            }
        });
        this.hna = new com.baidu.tieba.pb.pb.report.a(this);
        this.hna.p(getUniqueId());
        com.baidu.tieba.q.c.cdq().s(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.hmI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJn() {
        if (this.hnq != null && this.hmZ != null) {
            this.hnq.setForumName(this.hmZ.bIR());
            if (this.hmZ.getPbData() != null && this.hmZ.getPbData().getForum() != null) {
                this.hnq.a(this.hmZ.getPbData().getForum());
            }
            this.hnq.setFrom("pb");
            this.hnq.a(this.hmZ);
        }
    }

    public String bJo() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bJp() {
        return this.hmC;
    }

    private void ni(boolean z) {
        this.hnr.eL(z);
        this.hnr.eM(z);
        this.hnr.eN(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bIx() && !z && this.hnc != null && this.hnc.getView() != null && !UtilHelper.isOnePlus6()) {
            this.hnc.getView().setSystemUiVisibility(4);
        }
        this.hnv = z;
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

    public aq bJq() {
        return this.hnc;
    }

    public PbModel bJa() {
        return this.hmZ;
    }

    public void zL(String str) {
        if (this.hmZ != null && !StringUtils.isNull(str) && this.hnc != null) {
            this.hnc.nX(true);
            this.hmZ.zL(str);
            this.hmO = true;
            this.hnc.bMZ();
            this.hnc.bNi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hmE = false;
        } else {
            this.hmE = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hmG = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hmG == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.eYS != null) {
            this.eYS.onPause(getPageContext());
        }
        if (this.hnc != null) {
            this.hnc.onPause();
        }
        if (!this.hmZ.bKX()) {
            this.hnr.oQ(this.hmZ.bKR());
        }
        if (this.hmZ != null) {
            this.hmZ.bLp();
        }
        com.baidu.tbadk.BdToken.c.TZ().Ua();
        MessageManager.getInstance().unRegisterListener(this.gcF);
        bnY();
        MessageManager.getInstance().unRegisterListener(this.hnZ);
        MessageManager.getInstance().unRegisterListener(this.hoa);
        MessageManager.getInstance().unRegisterListener(this.hob);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bJr() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hmZ.getPbData(), this.hmZ.bKS(), this.hmZ.getRequestType());
        return (a2 == null || a2.YR() == null || a2.YR().getGodUserData() == null || a2.YR().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hmE = false;
        super.onResume();
        if (this.hmR) {
            this.hmR = false;
            bJV();
        }
        if (bJr()) {
            this.hmL = System.currentTimeMillis();
        } else {
            this.hmL = -1L;
        }
        if (this.hnc != null && this.hnc.getView() != null) {
            if (!this.gQe) {
                bJM();
            } else {
                hideLoadingView(this.hnc.getView());
            }
            this.hnc.onResume();
        }
        if (this.hmG == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hnc != null) {
            noNetworkView = this.hnc.bMl();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kY()) {
            noNetworkView.dO(false);
        }
        if (this.eYS != null) {
            this.eYS.onResume(getPageContext());
        }
        registerListener(this.gcF);
        this.hnl = false;
        bJU();
        registerListener(this.hnZ);
        registerListener(this.hoa);
        registerListener(this.hob);
        if (this.eZH) {
            bJL();
            this.eZH = false;
        }
        bKd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hnc.nM(z);
        if (this.hni != null) {
            this.hni.dismiss();
        }
        if (z && this.hnl) {
            this.hnc.bMK();
            this.hmZ.ny(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hmL > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").bJ("obj_duration", (System.currentTimeMillis() - this.hmL) + ""));
            this.hmL = 0L;
        }
        if (bJq().bMo() != null) {
            bJq().bMo().onStop();
        }
        if (this.hnc.hvT != null && !this.hnc.hvT.aRo()) {
            this.hnc.hvT.bzn();
        }
        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().getForum() != null && this.hmZ.getPbData().bHZ() != null) {
            com.baidu.tbadk.distribute.a.alG().a(getPageContext().getPageActivity(), "pb", this.hmZ.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmZ.getPbData().bHZ().getId(), 0L));
        }
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.cdq().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.cdq().t(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hmZ.getPbData().getForumId());
            amVar.bJ("tid", this.hmZ.bKR());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hmJ && this.hnc != null) {
            this.hmJ = true;
            this.hnc.bNe();
            a(false, (PostData) null);
        }
        if (this.hmZ != null) {
            this.hmZ.cancelLoadData();
            this.hmZ.destory();
            if (this.hmZ.bLt() != null) {
                this.hmZ.bLt().onDestroy();
            }
        }
        if (this.hnr != null) {
            this.hnr.onDestroy();
        }
        if (this.eja != null) {
            this.eja.cancelLoadData();
        }
        if (this.hnc != null) {
            this.hnc.onDestroy();
            if (this.hnc.hvT != null) {
                this.hnc.hvT.bzn();
            }
        }
        if (this.hmK != null) {
            this.hmK.apc();
        }
        if (this.hmC != null) {
            this.hmC.aqk();
        }
        super.onDestroy();
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
        this.hnc.bMZ();
        MessageManager.getInstance().unRegisterListener(this.hnZ);
        MessageManager.getInstance().unRegisterListener(this.hoa);
        MessageManager.getInstance().unRegisterListener(this.hob);
        MessageManager.getInstance().unRegisterListener(this.hnz);
        MessageManager.getInstance().unRegisterListener(this.hoc);
        MessageManager.getInstance().unRegisterListener(this.far);
        MessageManager.getInstance().unRegisterListener(this.frK);
        this.hnx = null;
        this.hny = null;
        com.baidu.tieba.recapp.d.a.bXw().bXy();
        if (this.hnA != null) {
            getSafeHandler().removeCallbacks(this.hnA);
        }
        if (this.hmS != null) {
            this.hmS.cancelLoadData();
        }
        if (this.hnc != null && this.hnc.hvT != null) {
            this.hnc.hvT.bNZ();
        }
        if (this.foI != null) {
            this.foI.cancelLoadData();
        }
        this.hnh.onDestroy();
        if (this.hmZ != null && this.hmZ.bLv() != null) {
            this.hmZ.bLv().onDestroy();
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
        if (adAdSense != null && adAdSense.aga() && this.hnc != null && (bMF = this.hnc.bMF()) != null && (bKt = bMF.bKt()) != null) {
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
                if (this.hmZ == null || this.hmZ.getPbData() == null || this.hmZ.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hmZ.getPbData().getForum().getFirst_class();
                    str2 = this.hmZ.getPbData().getForum().getSecond_class();
                    str = this.hmZ.getPbData().getForum().getId();
                    str4 = this.hmZ.bKR();
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
            this.hnc.onChangeSkinType(i);
            if (this.hnr != null && this.hnr.alT() != null) {
                this.hnr.alT().onChangeSkinType(i);
            }
            if (this.hnc.bMl() != null) {
                this.hnc.bMl().onChangeSkinType(getPageContext(), i);
            }
            this.hnh.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hnc = new aq(this, this.faZ, this.cbY);
        this.dMv = new com.baidu.tieba.f.b(getActivity());
        this.dMv.a(hoo);
        this.dMv.a(this.dMw);
        this.hnc.setOnScrollListener(this.mOnScrollListener);
        this.hnc.e(this.fsS);
        this.hnc.setListPullRefreshListener(this.cPx);
        this.hnc.nc(com.baidu.tbadk.core.i.Wy().WC());
        this.hnc.setOnImageClickListener(this.cAE);
        this.hnc.b(this.cdd);
        this.hnc.h(this.eWE);
        this.hnc.a(this.hoh);
        this.hnc.nM(this.mIsLogin);
        if (getIntent() != null) {
            this.hnc.nY(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hnc.bMn().setFromForumId(this.hmZ.getFromForumId());
    }

    public void bJs() {
        if (this.hnc != null && this.hmZ != null) {
            if ((this.hmZ.getPbData() != null || this.hmZ.getPbData().bIw() != null) && checkUpIsLogin() && this.hnc.bMF() != null && this.hnc.bMF().bKy() != null) {
                this.hnc.bMF().bKy().nr(this.hmZ.bKR());
            }
        }
    }

    public void bJt() {
        TiebaStatic.log("c12181");
        if (this.hnc != null && this.hmZ != null) {
            if (this.hnc == null || this.hnc.bMq()) {
                if (this.hmZ.getPbData() != null || this.hmZ.getPbData().bIw() != null) {
                    com.baidu.tieba.pb.data.i bIw = this.hmZ.getPbData().bIw();
                    if (checkUpIsLogin()) {
                        if ((!bIw.bIA() || bIw.aan() != 2) && this.hnc.bMF() != null && this.hnc.bMF().bKy() != null) {
                            this.hnc.bMF().bKy().nr(this.hmZ.bKR());
                        }
                        if (System.currentTimeMillis() - this.hmN > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).or(false);
                            this.hmN = System.currentTimeMillis();
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
                if (postData.getType() != PostData.iGk && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.Wy().WC()) {
                    return zO(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hmZ == null || this.hmZ.getPbData() == null) {
                        return true;
                    }
                    if (bJq().bMo() != null) {
                        bJq().bMo().bKE();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.hmZ.getPbData().getForum());
                    jVar.aj(this.hmZ.getPbData().bHZ());
                    jVar.e(postData);
                    bJq().bMn().d(jVar);
                    bJq().bMn().setPostId(postData.getId());
                    a(view, postData.YR().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hnr != null) {
                        this.hnc.nS(this.hnr.amA());
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
        if (this.hnc != null) {
            if (z && !this.gQe) {
                bJM();
            } else {
                hideLoadingView(this.hnc.getView());
            }
            if (z && this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bIx() && this.hnc.getView() != null && !UtilHelper.isOnePlus6()) {
                this.hnc.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bJu() {
        if (this.hmH == null) {
            this.hmH = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hmH.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0191b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hmw = PbActivity.this.hmw.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmw);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hmZ.bKR(), PbActivity.this.hmw, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hmw = PbActivity.this.hmw.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmw);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hmZ.bKR(), PbActivity.this.hmw, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hmw = PbActivity.this.hmw.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmw);
                        bVar.dismiss();
                    }
                }
            }).gH(b.a.bEY).gI(17).d(getPageContext());
        }
    }

    private void Z(Bundle bundle) {
        this.hmZ = new PbModel(this);
        this.hmZ.a(this.hoe);
        if (this.hmZ.bLs() != null) {
            this.hmZ.bLs().a(this.hoq);
        }
        if (this.hmZ.bLr() != null) {
            this.hmZ.bLr().a(this.hnP);
        }
        if (this.hmZ.bLt() != null) {
            this.hmZ.bLt().b(this.hnJ);
        }
        if (bundle != null) {
            this.hmZ.initWithBundle(bundle);
        } else {
            this.hmZ.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hmZ.nB(true);
        }
        aj.bMa().an(this.hmZ.bKP(), this.hmZ.getIsFromMark());
        if (StringUtils.isNull(this.hmZ.bKR())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hmP) && this.hmP != null) {
            this.hmZ.wu(6);
        }
        this.hmZ.aov();
    }

    private void initData(Bundle bundle) {
        this.hnb = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hnb != null) {
            this.hnb.a(this.hog);
        }
        this.eja = new ForumManageModel(this);
        this.eja.setLoadDataCallBack(this.eje);
        this.bKx = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hnc.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hmZ.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmZ.getPbData().getForum().getId(), PbActivity.this.hmZ.getPbData().getForum().getName(), PbActivity.this.hmZ.getPbData().bHZ().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hnV.setUniqueId(getUniqueId());
        this.hnV.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hnc.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hnz;
        userMuteCheckCustomMessage.setTag(this.hnz);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bJv() {
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
                            PbActivity.this.hnc.bnm();
                        }
                    }
                });
            }
            if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().getForum() != null) {
                this.fcw.q(this.hmZ.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmZ.bKR(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJw() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hmZ != null && (pbData = this.hmZ.getPbData()) != null) {
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
                ((View) view.getParent()).getLocationOnScreen(this.hmW);
                this.hmX = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hnt == null) {
                this.hnt = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hnt.re(1);
                this.hnt.a(new AnonymousClass39(str, str2));
            }
            if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().getForum() != null) {
                this.hnt.q(this.hmZ.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmZ.bKR(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$39  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String hoF;
        final /* synthetic */ String hoG;

        AnonymousClass39(String str, String str2) {
            this.hoF = str;
            this.hoG = str2;
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
                        PbActivity.this.bJq().getListView().smoothScrollBy((PbActivity.this.hmW[1] + PbActivity.this.hmX) - (aQ - h), 50);
                        if (PbActivity.this.bJq().bMo() != null) {
                            PbActivity.this.hnr.alT().setVisibility(8);
                            PbActivity.this.bJq().bMo().Y(AnonymousClass39.this.hoF, AnonymousClass39.this.hoG, PbActivity.this.bJq().bMr());
                            com.baidu.tbadk.editortools.pb.g bKI = PbActivity.this.bJq().bMo().bKI();
                            if (bKI != null && PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                                bKI.a(PbActivity.this.hmZ.getPbData().getAnti());
                            }
                            if (PbActivity.this.hnh.bNA() == null && PbActivity.this.bJq().bMo().bKI().amU() != null) {
                                PbActivity.this.bJq().bMo().bKI().amU().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hnh != null && PbActivity.this.hnh.bNz() != null) {
                                            if (!PbActivity.this.hnh.bNz().cnO()) {
                                                PbActivity.this.hnh.oa(false);
                                            }
                                            PbActivity.this.hnh.bNz().qV(false);
                                        }
                                    }
                                });
                                PbActivity.this.hnh.l(PbActivity.this.bJq().bMo().bKI().amU().getInputView());
                                PbActivity.this.bJq().bMo().bKI().a(PbActivity.this.hnw);
                            }
                        }
                        PbActivity.this.bJq().bNi();
                    }
                }, 0L);
            }
        }
    }

    public boolean bJx() {
        if (this.gyK == null || this.hmZ.getPbData() == null || this.hmZ.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyK.hm(this.hmZ.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean wd(int i) {
        if (this.gyK == null || this.hmZ.getPbData() == null || this.hmZ.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyK.S(this.hmZ.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.hmZ != null && this.hmZ.getPbData() != null && postData.ceq() != 1) {
            String bKR = this.hmZ.bKR();
            String id = postData.getId();
            int bIl = this.hmZ.getPbData() != null ? this.hmZ.getPbData().bIl() : 0;
            c zP = zP(id);
            if (zP != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bKR, id, "pb", true, null, false, null, bIl, postData.bON(), this.hmZ.getPbData().getAnti(), false, postData.YR() != null ? postData.YR().getIconInfo() : null).addBigImageData(zP.hoW, zP.hoX, zP.hoY, zP.index);
                addBigImageData.setKeyPageStartFrom(this.hmZ.bLz());
                addBigImageData.setFromFrsForumId(this.hmZ.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJy() {
        if (this.hmZ.getPbData() == null || this.hmZ.getPbData().bHZ() == null) {
            return -1;
        }
        return this.hmZ.getPbData().bHZ().ZB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJz() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.BW(this.hmZ.getForumId()) && this.hmZ.getPbData() != null && this.hmZ.getPbData().getForum() != null) {
            if (this.hmZ.getPbData().getForum().isLike() == 1) {
                this.hmZ.bLv().dP(this.hmZ.getForumId(), this.hmZ.bKR());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hmZ == null || this.hmZ.getPbData() == null) {
            return false;
        }
        return ((this.hmZ.getPbData().bIl() != 0) || this.hmZ.getPbData().bHZ() == null || this.hmZ.getPbData().bHZ().YR() == null || TextUtils.equals(this.hmZ.getPbData().bHZ().YR().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bJA() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.s.v.apI()) {
            return "";
        }
        PostData bIg = bIg();
        if (this.hmZ == null || (pbData = this.hmZ.getPbData()) == null || pbData.getUserData() == null || pbData.bHZ() == null || bIg == null || bIg.YR() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bIg.YR().isBigV()) {
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
        if (this.hmZ == null || this.hmZ.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hmZ.getPbData();
        if (pbData.bIl() != 0) {
            return pbData.bIl() != 3;
        }
        List<com.baidu.tbadk.core.data.bc> bIu = pbData.bIu();
        if (com.baidu.tbadk.core.util.v.S(bIu) > 0) {
            for (com.baidu.tbadk.core.data.bc bcVar : bIu) {
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
        return (z || this.hmZ == null || this.hmZ.getPbData() == null || this.hmZ.getPbData().bIl() == 0 || this.hmZ.getPbData().bIl() == 3) ? false : true;
    }

    public void bJB() {
        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null && this.hmZ.getPbData().bHZ().YR() != null) {
            if (this.hnc != null) {
                this.hnc.bMm();
            }
            bg bHZ = this.hmZ.getPbData().bHZ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bHZ.YR().getUserId());
            ab abVar = new ab();
            int bIl = this.hmZ.getPbData().bIl();
            if (bIl == 1 || bIl == 3) {
                abVar.huc = true;
                abVar.hub = true;
                abVar.huj = bHZ.YM() == 1;
                abVar.hui = bHZ.YN() == 1;
            } else {
                abVar.huc = false;
                abVar.hub = false;
            }
            if (bIl == 1002 && !equals) {
                abVar.hun = true;
            }
            abVar.hud = nk(equals);
            abVar.hue = bJC();
            abVar.huf = nl(equals);
            abVar.qV = this.hmZ.bKS();
            abVar.hua = true;
            abVar.htZ = nj(equals);
            abVar.hul = bJA();
            abVar.htY = equals && this.hnc.bMR();
            abVar.hug = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.huh = true;
            abVar.isHostOnly = this.hmZ.getHostMode();
            abVar.huk = true;
            if (bHZ.Zi() == null) {
                abVar.hum = true;
            } else {
                abVar.hum = false;
            }
            this.hnc.hvT.a(abVar);
        }
    }

    private boolean bJC() {
        if (this.hmZ != null && this.hmZ.bKS()) {
            return this.hmZ.getPageData() == null || this.hmZ.getPageData().XL() != 0;
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
            if ((mVar instanceof PostData) && mVar.getType() == PostData.iGj) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
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
                    PbActivity.this.bKx.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hmZ.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aaZ();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hnc.bML();
        this.hmZ.nA(z);
        if (this.hnb != null) {
            this.hnb.cZ(z);
            if (markData != null) {
                this.hnb.a(markData);
            }
        }
        if (this.hmZ.Vb()) {
            bJJ();
        } else {
            this.hnc.o(this.hmZ.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wb(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(String str) {
        this.hna.Ak(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hmZ.bKX()) {
                    antiData.setBlock_forum_name(this.hmZ.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hmZ.getPbData().getForum().getId());
                    antiData.setUser_name(this.hmZ.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hmZ.getPbData().getUserData().getUserId());
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
            this.hnc.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.iIJ) ? bVar.iIJ : getString(d.j.delete_fail);
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
                this.hnc.a(0, bVar.Id, bVar.iIJ, z);
            }
            if (bVar.Id) {
                if (bVar.eFR == 1) {
                    ArrayList<PostData> bIb = this.hmZ.getPbData().bIb();
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
                    this.hmZ.getPbData().bHZ().gr(this.hmZ.getPbData().bHZ().YI() - 1);
                    this.hnc.o(this.hmZ.getPbData());
                } else if (bVar.eFR == 0) {
                    bJF();
                } else if (bVar.eFR == 2) {
                    ArrayList<PostData> bIb2 = this.hmZ.getPbData().bIb();
                    int size2 = bIb2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bIb2.get(i2).cen().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bIb2.get(i2).cen().get(i3).getId())) {
                                i3++;
                            } else {
                                bIb2.get(i2).cen().remove(i3);
                                bIb2.get(i2).cep();
                                z2 = true;
                                break;
                            }
                        }
                        bIb2.get(i2).CA(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hnc.o(this.hmZ.getPbData());
                    }
                    a(bVar, this.hnc);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hnc.a(this.eja.getLoadDataMode(), gVar.Id, gVar.iIJ, false);
            if (gVar.Id) {
                this.hne = true;
                if (i == 2 || i == 3) {
                    this.hnf = true;
                    this.hng = false;
                } else if (i == 4 || i == 5) {
                    this.hnf = false;
                    this.hng = true;
                }
                if (i == 2) {
                    this.hmZ.getPbData().bHZ().gu(1);
                    this.hmZ.setIsGood(1);
                } else if (i == 3) {
                    this.hmZ.getPbData().bHZ().gu(0);
                    this.hmZ.setIsGood(0);
                } else if (i == 4) {
                    this.hmZ.getPbData().bHZ().gt(1);
                    this.hmZ.oE(1);
                } else if (i == 5) {
                    this.hmZ.getPbData().bHZ().gt(0);
                    this.hmZ.oE(0);
                }
                this.hnc.d(this.hmZ.getPbData(), this.hmZ.bKS());
            }
        }
    }

    private void bJF() {
        if (this.hmZ.bKT() || this.hmZ.bKV()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hmZ.bKR());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hmZ.bKR()));
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
        if (this.hnc != null) {
            this.hnc.bMZ();
        }
        if (this.hmZ != null && this.hmZ.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hmZ.getPbData().bHZ().getId();
            if (this.hmZ.isShareThread() && this.hmZ.getPbData().bHZ().bDt != null) {
                historyMessage.threadName = this.hmZ.getPbData().bHZ().bDt.showText;
            } else {
                historyMessage.threadName = this.hmZ.getPbData().bHZ().getTitle();
            }
            if (this.hmZ.isShareThread() && !bIQ()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hmZ.getPbData().getForum().getName();
            }
            ArrayList<PostData> bIb = this.hmZ.getPbData().bIb();
            int bMN = this.hnc != null ? this.hnc.bMN() : 0;
            if (bIb != null && bMN >= 0 && bMN < bIb.size()) {
                historyMessage.postID = bIb.get(bMN).getId();
            }
            historyMessage.isHostOnly = this.hmZ.getHostMode();
            historyMessage.isSquence = this.hmZ.bKS();
            historyMessage.isShareThread = this.hmZ.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hnr != null) {
            this.hnr.onDestroy();
        }
        if (this.hmF && bJq() != null) {
            bJq().bNs();
        }
        if (this.hmZ != null && (this.hmZ.bKT() || this.hmZ.bKV())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hmZ.bKR());
            if (this.hne) {
                if (this.hng) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hmZ.aWk());
                }
                if (this.hnf) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hmZ.getIsGood());
                }
            }
            if (this.hmZ.getPbData() != null && System.currentTimeMillis() - this.hmI >= 40000 && (bIi = this.hmZ.getPbData().bIi()) != null && !com.baidu.tbadk.core.util.v.T(bIi.getDataList())) {
                intent.putExtra("guess_like_data", bIi);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hnF);
            }
            setResult(-1, intent);
        }
        if (bJK()) {
            if (this.hmZ != null && this.hnc != null && this.hnc.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hmZ.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bIf() && !this.hmO) {
                        aj bMa = aj.bMa();
                        com.baidu.tieba.pb.data.d bKZ = this.hmZ.bKZ();
                        Parcelable onSaveInstanceState = this.hnc.getListView().onSaveInstanceState();
                        boolean bKS = this.hmZ.bKS();
                        boolean hostMode = this.hmZ.getHostMode();
                        if (this.hnc.bMx() != null && this.hnc.bMx().getVisibility() == 0) {
                            z = true;
                        }
                        bMa.a(bKZ, onSaveInstanceState, bKS, hostMode, z);
                        if (this.hnE >= 0 || this.hmZ.bLB() != null) {
                            aj.bMa().l(this.hmZ.bLB());
                            aj.bMa().k(this.hmZ.bLC());
                            aj.bMa().ww(this.hmZ.bLD());
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
        if (keyEvent == null || this.hnc == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hnc.wB(i)) {
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
            this.hnc.bMm();
            this.hnc.bMo().bKE();
            this.hnc.nU(false);
        }
        this.hnc.bMp();
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
                        this.hnr.resetData();
                        this.hnr.b(writeData);
                        this.hnr.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k jw = this.hnr.alT().jw(6);
                        if (jw != null && jw.ciu != null) {
                            jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hnr.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hnc.bMo() != null && this.hnc.bMo().bKI() != null) {
                            com.baidu.tbadk.editortools.pb.g bKI = this.hnc.bMo().bKI();
                            bKI.b(writeData);
                            bKI.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k jw2 = bKI.alT().jw(6);
                            if (jw2 != null && jw2.ciu != null) {
                                jw2.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bKI.amM();
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
        this.hnr.onActivityResult(i, i2, intent);
        if (this.hmS != null) {
            this.hmS.onActivityResult(i, i2, intent);
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
                            if (PbActivity.this.hmZ != null) {
                                PbActivity.this.hmZ.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bWo().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hmZ != null) {
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
                        com.baidu.tieba.n.a.bWo().x(getPageContext());
                        bJz();
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
                    this.hnc.nh(false);
                    if (this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null && this.hmZ.getPbData().bHZ().Zl() != null) {
                        this.hmZ.getPbData().bHZ().Zl().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hnu = emotionImageData;
                        if (wd(com.baidu.tbadk.core.util.aj.bKu)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hnc != null && this.hnc.hvT != null) {
                        this.hnc.hvT.Qk();
                        this.hnc.hvT.bNT();
                        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null) {
                            this.hmZ.getPbData().bHZ().gp(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hmT != null) {
                        this.hnc.ct(this.hmT);
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
            if (this.hmS == null) {
                this.hmS = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hmS.b(this.ckl);
                this.hmS.c(this.cks);
            }
            this.hmS.a(emotionImageData, bJa(), bJa().getPbData());
        }
    }

    private ShareFromPBMsgData bJH() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] el = this.hmZ.getPbData().el(getPageContext().getPageActivity());
        PostData bMs = this.hnc.bMs();
        String str = "";
        if (bMs != null) {
            str = bMs.getId();
            String ew = bMs.ew(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ew)) {
                el[1] = ew;
            }
        }
        String Zh = this.hmZ.getPbData().bHZ().Zh();
        if (Zh != null && Zh.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(el[1]);
        shareFromPBMsgData.setImageUrl(el[0]);
        shareFromPBMsgData.setForumName(this.hmZ.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hmZ.getPbData().bHZ().getId());
        shareFromPBMsgData.setTitle(this.hmZ.getPbData().bHZ().getTitle());
        return shareFromPBMsgData;
    }

    private void ad(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bJH(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.gF(1);
            aVar.az(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null) {
                        com.baidu.tbadk.core.util.am bJ = new com.baidu.tbadk.core.util.am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).T("obj_param1", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmZ.getForumId()).bJ("tid", PbActivity.this.hmZ.bKR());
                        if (PbActivity.this.e(PbActivity.this.hmZ.getPbData()) != 0) {
                            bJ.T("obj_type", PbActivity.this.e(PbActivity.this.hmZ.getPbData()));
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
                thread2GroupShareView.af(shareFromPBMsgData.getImageUrl(), this.hmZ.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null) {
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
                thread2GroupShareView.af(shareFromPBMsgData.getImageUrl(), this.hmZ.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJI() {
        MarkData wt;
        if (this.hnb != null && (wt = this.hmZ.wt(this.hnc.bMO())) != null) {
            if (!wt.isApp() || (wt = this.hmZ.wt(this.hnc.bMO() + 1)) != null) {
                this.hnc.bMJ();
                this.hnb.a(wt);
                if (!this.hnb.Vb()) {
                    this.hnb.Vd();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hnb.Vc();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        com.baidu.tieba.pb.data.d pbData = this.hmZ.getPbData();
        this.hmZ.nA(true);
        if (this.hnb != null) {
            pbData.zH(this.hnb.Va());
        }
        this.hnc.o(pbData);
    }

    private boolean bJK() {
        if (this.hmZ == null) {
            return true;
        }
        if (this.hmZ.Vb()) {
            final MarkData bLj = this.hmZ.bLj();
            if (bLj == null || !this.hmZ.getIsFromMark()) {
                return true;
            }
            final MarkData wt = this.hmZ.wt(this.hnc.bMN());
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
                        if (PbActivity.this.hnb != null) {
                            if (PbActivity.this.hnb.Vb()) {
                                PbActivity.this.hnb.Vc();
                                PbActivity.this.hnb.cZ(false);
                            }
                            PbActivity.this.hnb.a(wt);
                            PbActivity.this.hnb.cZ(true);
                            PbActivity.this.hnb.Vd();
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
                        if (PbActivity.this.hnc != null && PbActivity.this.hnc.getView() != null) {
                            PbActivity.this.hnc.getView().getLocationOnScreen(iArr);
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
        } else if (this.hmZ.getPbData() == null || this.hmZ.getPbData().bIb() == null || this.hmZ.getPbData().bIb().size() <= 0 || !this.hmZ.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hnc == null) {
            return null;
        }
        return this.hnc.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int atd() {
        if (this.hnc == null) {
            return 0;
        }
        return this.hnc.bMX();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ate() {
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
    public com.baidu.adp.lib.e.b<TextView> atf() {
        if (this.cDk == null) {
            this.cDk = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atg() {
        if (this.cAw == null) {
            this.cAw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bKf */
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
    public com.baidu.adp.lib.e.b<View> ath() {
        if (this.cDl == null) {
            this.cDl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
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
                    ((PlayVoiceBntNew) view).cfA();
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
    public com.baidu.adp.lib.e.b<RelativeLayout> atj() {
        this.cDn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
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
        this.hmM = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (av.Ac(str) && this.hmZ != null && this.hmZ.bKR() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").T("obj_param1", 1).bJ("post_id", this.hmZ.bKR()));
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
            av.bNC().d(getPageContext(), str);
        }
        this.hmM = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aA(Context context, String str) {
        av.bNC().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hmM = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aB(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Rect rect) {
        if (rect != null && this.hnc != null && this.hnc.bNn() != null && rect.top <= this.hnc.bNn().getHeight()) {
            rect.top += this.hnc.bNn().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hmZ.getPbData();
            TbRichText bh = bh(str, i);
            if (bh != null && (tbRichTextData = bh.asw().get(this.hoj)) != null) {
                cVar.hoW = new ArrayList<>();
                cVar.hoX = new ConcurrentHashMap<>();
                if (!tbRichTextData.asD().asP()) {
                    cVar.hoZ = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hoW.add(b2);
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
                    imageUrlData.mIsReserver = this.hmZ.bLh();
                    imageUrlData.mIsSeeHost = this.hmZ.getHostMode();
                    cVar.hoX.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bHZ() != null) {
                            cVar.threadId = pbData.bHZ().getId();
                        }
                        cVar.hoY = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.hoZ = true;
                int size = pbData.bIb().size();
                this.hok = false;
                cVar.index = -1;
                if (pbData.bIg() != null) {
                    PostData bIg = pbData.bIg();
                    TbRichText ces = bIg.ces();
                    if (!ap.m(bIg)) {
                        i2 = a(ces, bh, i, i, cVar.hoW, cVar.hoX);
                    } else {
                        i2 = a(bIg, i, cVar.hoW, cVar.hoX);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bIb().get(i4);
                    if (postData.getId() == null || pbData.bIg() == null || pbData.bIg().getId() == null || !postData.getId().equals(pbData.bIg().getId())) {
                        TbRichText ces2 = postData.ces();
                        if (!ap.m(postData)) {
                            i3 = a(ces2, bh, i3, i, cVar.hoW, cVar.hoX);
                        } else {
                            i3 = a(postData, i3, cVar.hoW, cVar.hoX);
                        }
                    }
                }
                if (cVar.hoW.size() > 0) {
                    cVar.lastId = cVar.hoW.get(cVar.hoW.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bHZ() != null) {
                        cVar.threadId = pbData.bHZ().getId();
                    }
                    cVar.hoY = pbData.getIsNewUrl() == 1;
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
            this.hok = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hmZ.bKR(), -1L);
                                imageUrlData.mIsReserver = this.hmZ.bLh();
                                imageUrlData.mIsSeeHost = this.hmZ.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hok) {
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
        com.baidu.tieba.tbadkCore.data.i cez;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cdV;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cdV = (cez = postData.cez()).cdV()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cdV.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cdV.get(i3);
                if (kVar != null) {
                    String cdZ = kVar.cdZ();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(cdZ)) {
                        arrayList.add(cdZ);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cdZ;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cdY();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hmZ.bKR(), -1L);
                        imageUrlData.mIsReserver = this.hmZ.bLh();
                        imageUrlData.mIsSeeHost = this.hmZ.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cez.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cdZ, imageUrlData);
                        }
                        if (!this.hok) {
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
            if (postData.getId() != null && postData.getId().equals(this.hmZ.Za())) {
                z = true;
            }
            MarkData j = this.hmZ.j(postData);
            if (j != null) {
                this.hnc.bMJ();
                if (this.hnb != null) {
                    this.hnb.a(j);
                    if (!z) {
                        this.hnb.Vd();
                    } else {
                        this.hnb.Vc();
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
        if (this.hmZ == null || this.hmZ.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hmZ.getPbData();
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

    private long zN(String str) {
        ArrayList<PostData> bIb;
        com.baidu.tieba.pb.data.d pbData = this.hmZ.getPbData();
        if (pbData != null && (bIb = pbData.bIb()) != null && !bIb.isEmpty()) {
            Iterator<PostData> it = bIb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cez = next.cez();
                if (cez != null && cez.iFQ) {
                    Iterator<TbRichTextData> it2 = next.ces().asw().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.asM().getLink().equals(str)) {
                            return cez.getTemplateId();
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
            TbRichText ces = arrayList.get(i2).ces();
            if (ces != null && (asw = ces.asw()) != null) {
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
                            this.hoj = i4;
                            return ces;
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
            this.hmw = str;
            if (this.hmH == null) {
                bJu();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hmH.gK(1).setVisibility(8);
            } else {
                this.hmH.gK(1).setVisibility(0);
            }
            this.hmH.abc();
            this.hmM = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        hideNetRefreshView(this.hnc.getView());
        bJM();
        if (this.hmZ.aov()) {
            this.hnc.bMJ();
        }
    }

    private void bJM() {
        showLoadingView(this.hnc.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View anD = getLoadingView().anD();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anD.getLayoutParams();
        layoutParams.addRule(3, this.hnc.bNn().getId());
        anD.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcM() {
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
        if (this.hmZ.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hmZ.getPbData();
            pbData.getForum().getName();
            String title = pbData.bHZ().getTitle();
            int i2 = this.hmZ.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.BW(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hmZ.bKR() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] el = pbData.el(getPageContext().getPageActivity());
                    str = el[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = el[1];
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
                    dVar.extData = this.hmZ.bKR();
                    dVar.cbB = 3;
                    dVar.cbA = i;
                    dVar.fid = this.hmZ.getForumId();
                    dVar.tid = this.hmZ.bKR();
                    dVar.cbF = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hmZ.getPbData().bHZ());
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
                                if (PbActivity.this.hmZ != null && PbActivity.this.hmZ.getPbData() != null && PbActivity.this.hmZ.getPbData().bIx() && !UtilHelper.isOnePlus6()) {
                                    PbActivity.this.hnc.getView().setSystemUiVisibility(4);
                                }
                            }
                        });
                        com.baidu.tieba.c.e.aSt().a(shareDialogConfig);
                        return;
                    }
                    return;
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hmZ.bKR() + "?share=9105&fr=share&see_lz=" + i2;
            String[] el2 = pbData.el(getPageContext().getPageActivity());
            str = el2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = el2[1];
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
            dVar2.extData = this.hmZ.bKR();
            dVar2.cbB = 3;
            dVar2.cbA = i;
            dVar2.fid = this.hmZ.getForumId();
            dVar2.tid = this.hmZ.bKR();
            dVar2.cbF = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hmZ.getPbData().bHZ());
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
                return Boolean.valueOf(AddExperiencedModel.BX(PbActivity.this.hmZ.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hnc.bNt();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ati() {
        if (this.cDm == null) {
            this.cDm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
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
        if (this.hmZ == null || this.hmZ.getPbData() == null) {
            return null;
        }
        return this.hmZ.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.abb() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.abb();
            int intValue = ((Integer) sparseArray.get(aq.hxF)).intValue();
            if (intValue == aq.hxG) {
                if (!this.eja.cfc()) {
                    this.hnc.bMG();
                    String str = (String) sparseArray.get(d.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eja.CG(com.baidu.tbadk.core.util.ap.x(jSONArray));
                    }
                    this.eja.a(this.hmZ.getPbData().getForum().getId(), this.hmZ.getPbData().getForum().getName(), this.hmZ.getPbData().bHZ().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hxH || intValue == aq.hxJ) {
                if (this.hmZ.bLs() != null) {
                    this.hmZ.bLs().wj(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hxH) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hnz);
        userMuteAddAndDelCustomMessage.setTag(this.hnz);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean zO(String str) {
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
        this.hnl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJO() {
        ArrayList<PostData> bIb;
        int S;
        if (this.hmZ == null || this.hmZ.getPbData() == null || this.hmZ.getPbData().bIb() == null || (S = com.baidu.tbadk.core.util.v.S((bIb = this.hmZ.getPbData().bIb()))) == 0) {
            return "";
        }
        if (this.hmZ.bLh()) {
            Iterator<PostData> it = bIb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.ceq() == 1) {
                    return next.getId();
                }
            }
        }
        int bMN = this.hnc.bMN();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bIb, bMN);
        if (postData == null || postData.YR() == null) {
            return "";
        }
        if (this.hmZ.zS(postData.YR().getUserId())) {
            return postData.getId();
        }
        for (int i = bMN - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bIb, i);
            if (postData2 == null || postData2.YR() == null || postData2.YR().getUserId() == null) {
                break;
            } else if (this.hmZ.zS(postData2.YR().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bMN + 1; i2 < S; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bIb, i2);
            if (postData3 == null || postData3.YR() == null || postData3.YR().getUserId() == null) {
                return "";
            }
            if (this.hmZ.zS(postData3.YR().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aD(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.adD().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(zN(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hmZ.getPbData().getForum().getId(), this.hmZ.getPbData().getForum().getName(), this.hmZ.getPbData().bHZ().getTid());
            }
            this.hmM = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hmZ.bLr() != null) {
                    PbActivity.this.hmZ.bLr().dD(j);
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
    public c zP(String str) {
        String str2;
        if (this.hmZ.getPbData() == null || this.hmZ.getPbData().bIb() == null || this.hmZ.getPbData().bIb().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hmZ.getPbData().bIb().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hmZ.getPbData().bIb().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hmZ.getPbData().bIb().get(i);
        if (postData.ces() == null || postData.ces().asw() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.ces().asw().iterator();
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
        if (this.hmD) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hmD = false;
        } else if (bJP()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hmD) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hmD = false;
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
        if (pageStayDurationItem != null && this.hmZ != null) {
            if (this.hmZ.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hmZ.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hmZ.bKR(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bJP() {
        return (!this.hmB && this.hor == -1 && this.hos == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hou = oVar;
            this.hmB = true;
            this.hnc.bMy();
            this.hnc.Aa(this.hot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJQ() {
        if (this.hou != null) {
            if (this.hor == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hou.getCartoonId(), this.hor, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJR() {
        if (this.hou != null) {
            if (this.hos == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hou.getCartoonId(), this.hos, 0)));
                finish();
            }
        }
    }

    public int bJS() {
        return this.hor;
    }

    public int bJT() {
        return this.hos;
    }

    private void bnY() {
        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null && this.hmZ.getPbData().bHZ().ZL()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bJU() {
        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null && this.hmZ.getPbData().bHZ().ZL()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bJV() {
        if (this.hmE) {
            this.hmR = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null && this.hmZ.getPbData().bHZ().Yx() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hmZ.getPbData().bHZ().Yx().getThreadId(), this.hmZ.getPbData().bHZ().Yx().getTaskId(), this.hmZ.getPbData().bHZ().Yx().getForumId(), this.hmZ.getPbData().bHZ().Yx().getForumName(), this.hmZ.getPbData().bHZ().YM(), this.hmZ.getPbData().bHZ().YN())));
            this.hmD = true;
            finish();
        }
    }

    public String bJW() {
        return this.hmP;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bJX() {
        return this.hmY;
    }

    public void nn(boolean z) {
        this.hmQ = z;
    }

    public boolean bJY() {
        if (this.hmZ != null) {
            return this.hmZ.bKT();
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
                    ((TbPageContext) PbActivity.this.hnx).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hnx.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hnx).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hnx != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnx.getPageActivity());
            aVar.ly(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hnx).aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hnc.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnx.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.ly(this.hnx.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.ly(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hnc.showLoadingDialog();
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
        aVar.b(this.hnx).aaZ();
    }

    public void bKa() {
        if (this.hmZ != null && this.hmZ.getPbData() != null && this.hmZ.getPbData().bHZ() != null && this.hmZ.getPbData().bHZ().aab() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.gD(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hmZ.getPbData().bHZ().aab().channelId, true, PbActivity.this.getUniqueId())));
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
                if (av.Ac(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_wenxue)) != null) {
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
        if (this.hnc != null) {
            this.hnc.onConfigurationChanged(configuration);
        }
        if (this.hni != null) {
            this.hni.dismiss();
        }
    }

    public boolean bKb() {
        if (this.hmZ != null) {
            return this.hmZ.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hmZ.getPbData().bIk().hkW;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cen().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cen().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cen().remove(i2);
                    list.get(i).cep();
                    z = true;
                    break;
                }
            }
            list.get(i).CA(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.o(this.hmZ.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bID().getId();
        List<PostData> list = this.hmZ.getPbData().bIk().hkW;
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
                if (postData.cen() != null) {
                    postData.cen().clear();
                    postData.cen().addAll(bIH);
                }
            }
        }
        if (!this.hmZ.getIsFromMark()) {
            this.hnc.o(this.hmZ.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bIP() {
        return this.hnd;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIQ() {
        if (this.hmZ == null) {
            return false;
        }
        return this.hmZ.bIQ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIR() {
        if (this.hmZ != null) {
            return this.hmZ.bIR();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIS() {
        if (this.hmZ == null || this.hmZ.getPbData() == null) {
            return 0;
        }
        return this.hmZ.getPbData().bIl();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zJ(String str) {
        return this.hmZ != null && this.hmZ.zS(str);
    }

    public void bKc() {
        if (this.hnc != null) {
            this.hnc.bMm();
            bcN();
        }
    }

    public PostData bIg() {
        return this.hnc.c(this.hmZ.hsv, this.hmZ.bKS());
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
        if (this.hnG != null && !this.hnG.isEmpty()) {
            int size = this.hnG.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hnG.get(i).onBackPressed()) {
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
            if (this.hnG == null) {
                this.hnG = new ArrayList();
            }
            if (!this.hnG.contains(aVar)) {
                this.hnG.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hnG == null) {
                this.hnG = new ArrayList();
            }
            if (!this.hnG.contains(aVar)) {
                this.hnG.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hnG != null) {
            this.hnG.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKd() {
        if (this.hmZ != null && !com.baidu.tbadk.core.util.ap.isEmpty(this.hmZ.bKR())) {
            com.baidu.tbadk.BdToken.c.TZ().f(com.baidu.tbadk.BdToken.b.bqC, com.baidu.adp.lib.g.b.d(this.hmZ.bKR(), 0L));
        }
    }
}
