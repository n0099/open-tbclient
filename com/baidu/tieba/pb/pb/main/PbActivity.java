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
    private com.baidu.adp.lib.e.b<TbImageView> bTV;
    private com.baidu.adp.lib.e.b<ImageView> cAv;
    private com.baidu.adp.lib.e.b<GifView> cAw;
    private com.baidu.adp.lib.e.b<TextView> cDk;
    private com.baidu.adp.lib.e.b<View> cDl;
    private com.baidu.adp.lib.e.b<LinearLayout> cDm;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDn;
    private com.baidu.tieba.f.b dLJ;
    private VoiceManager eYE;
    private com.baidu.tieba.frs.profession.permission.c fci;
    private au fzF;
    public com.baidu.tbadk.core.util.aj gyy;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hmC;
    private View hmD;
    int hmF;
    private com.baidu.tieba.pb.pb.report.a hmI;
    public as hmP;
    private com.baidu.tbadk.core.dialog.g hmQ;
    private com.baidu.tbadk.core.dialog.i hmR;
    private boolean hmT;
    private com.baidu.tieba.tbadkCore.data.f hmX;
    private com.baidu.tbadk.editortools.pb.f hmY;
    private com.baidu.tbadk.editortools.pb.d hmZ;
    private String hmg;
    private com.baidu.tieba.pb.pb.main.b.b hmm;
    private boolean hnQ;
    private com.baidu.tieba.frs.profession.permission.c hnb;
    private EmotionImageData hnc;
    private com.baidu.adp.base.e hnf;
    private com.baidu.tbadk.core.view.e hng;
    private BdUniqueId hnh;
    private Runnable hni;
    private com.baidu.adp.widget.ImageView.a hnj;
    private String hnk;
    private TbRichTextMemeInfo hnl;
    private List<a> hno;
    private String hob;
    private com.baidu.tbadk.core.data.o hoc;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLq));
        }
    };
    private static final b.a hnW = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // com.baidu.tieba.f.b.a
        public void it(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bIL();
            } else {
                com.baidu.tieba.pb.a.b.bIK();
            }
        }
    };
    private boolean hml = false;
    private boolean hmn = false;
    private boolean hmo = false;
    private boolean gPS = false;
    private boolean hmp = true;
    private int hmq = 0;
    private com.baidu.tbadk.core.dialog.b hmr = null;
    private long eCx = -1;
    private long cqy = 0;
    private long hms = 0;
    private long createTime = 0;
    private long cqq = 0;
    private boolean hmt = false;
    private com.baidu.tbadk.o.b hmu = null;
    private long hmv = 0;
    private boolean hmw = false;
    private long hmx = 0;
    private String ckl = null;
    private boolean hmy = false;
    private boolean isFullScreen = false;
    private String hmz = "";
    private boolean hmA = true;
    private boolean hmB = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hmE = new int[2];
    private PbInterviewStatusView.a hmG = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.hmK.nN(!PbActivity.this.hmA);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hmH != null && PbActivity.this.hmH.UY()) {
                        PbActivity.this.bJG();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hmH = null;
    private com.baidu.tbadk.baseEditMark.a hmJ = null;
    private ForumManageModel eiJ = null;
    private com.baidu.tbadk.coreExtra.model.a bKB = null;
    private ShareSuccessReplyToServerModel fot = null;
    private aq hmK = null;
    public final com.baidu.tieba.pb.pb.main.b.a hmL = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hmM = false;
    private boolean hmN = false;
    private boolean hmO = false;
    private boolean hmS = false;
    private boolean hmU = false;
    private boolean hmV = false;
    private boolean hmW = false;
    private boolean hna = false;
    public boolean hnd = false;
    private com.baidu.tbadk.editortools.pb.c cko = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void amo() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b ckp = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amn() {
            if (PbActivity.this.hmP == null || PbActivity.this.hmP.bNw() == null || !PbActivity.this.hmP.bNw().cnY()) {
                return !PbActivity.this.vZ(com.baidu.tbadk.core.util.aj.bKw);
            }
            PbActivity.this.showToast(PbActivity.this.hmP.bNw().coa());
            if (PbActivity.this.hmZ != null && (PbActivity.this.hmZ.amC() || PbActivity.this.hmZ.amD())) {
                PbActivity.this.hmZ.a(false, PbActivity.this.hmP.bNz());
            }
            PbActivity.this.hmP.nZ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hne = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean amn() {
            if (PbActivity.this.hmP == null || PbActivity.this.hmP.bNx() == null || !PbActivity.this.hmP.bNx().cnY()) {
                return !PbActivity.this.vZ(com.baidu.tbadk.core.util.aj.bKx);
            }
            PbActivity.this.showToast(PbActivity.this.hmP.bNx().coa());
            if (PbActivity.this.hmK != null && PbActivity.this.hmK.bMl() != null && PbActivity.this.hmK.bMl().bKF() != null && PbActivity.this.hmK.bMl().bKF().amD()) {
                PbActivity.this.hmK.bMl().bKF().a(PbActivity.this.hmP.bNz());
            }
            PbActivity.this.hmP.oa(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean eZt = false;
    private int hnm = 0;
    private int hnn = -1;
    private final a hnp = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hmK != null && PbActivity.this.hmK.bMl() != null) {
                s bMl = PbActivity.this.hmK.bMl();
                if (bMl.bKD()) {
                    bMl.bKC();
                    return true;
                }
            }
            if (PbActivity.this.hmK != null && PbActivity.this.hmK.bNe()) {
                PbActivity.this.hmK.bNf();
                return true;
            }
            return false;
        }
    };
    private r.a hnq = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
    };
    private AddExperiencedModel.a eZD = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bJK();
        }
    };
    private final z.a hnr = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void ac(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hmK.showToast(str);
            }
        }
    };
    private final CustomMessageListener hns = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmH != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hmZ != null) {
                    PbActivity.this.hmK.nS(PbActivity.this.hmZ.amw());
                }
                PbActivity.this.hmK.bMm();
                PbActivity.this.hmK.bMX();
            }
        }
    };
    CustomMessageListener eZW = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hmH.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hmK != null && PbActivity.this.hmH != null) {
                    PbActivity.this.hmK.d(PbActivity.this.hmH.getPbData(), PbActivity.this.hmH.bKP(), PbActivity.this.hmH.getRequestType());
                }
                if (PbActivity.this.hmK != null && PbActivity.this.hmK.bMC() != null) {
                    PbActivity.this.hmK.bMC().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hnt = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hmK != null) {
                    if (booleanValue) {
                        PbActivity.this.hmK.bul();
                    } else {
                        PbActivity.this.hmK.buk();
                    }
                }
            }
        }
    };
    private CustomMessageListener hnu = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hmZ != null) {
                    PbActivity.this.hmK.nS(PbActivity.this.hmZ.amw());
                }
                PbActivity.this.hmK.nU(false);
            }
        }
    };
    private CustomMessageListener hnv = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener hnw = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmK != null && PbActivity.this.hmK.bMC() != null) {
                PbActivity.this.hmK.bMC().notifyDataSetChanged();
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
    private final CustomMessageListener brt = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hmo) {
                PbActivity.this.bKa();
            }
        }
    };
    private h.a hnx = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void n(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.wb(2);
                aj.bLX().reset();
                PbActivity.this.hmH.bLk();
                boolean z2 = false;
                ArrayList<PostData> bHY = PbActivity.this.hmH.getPbData().bHY();
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
                        PbActivity.this.hmK.n(PbActivity.this.hmH.getPbData());
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
    private View.OnClickListener ckZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.ckl);
        }
    };
    private CustomMessageListener hny = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmH.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hmH.bLb() != null && PbActivity.this.hmH.bLb().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hmK.a(aaVar.sendCount, PbActivity.this.hmH.getPbData(), PbActivity.this.hmH.bKP(), PbActivity.this.hmH.getRequestType());
                    }
                    if (pbData.bHY() != null && pbData.bHY().size() >= 1 && pbData.bHY().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bHY().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.hmH.bKO(), 0L);
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
                            PbActivity.this.hmK.bMC().notifyDataSetChanged();
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
            if (customResponsedMessage != null && PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                PbActivity.this.zI((String) customResponsedMessage.getData());
                PbActivity.this.hmH.bLh();
                if (PbActivity.this.hmK.bMC() != null) {
                    PbActivity.this.hmK.n(PbActivity.this.hmH.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hnz = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
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
    private GetSugMatchWordsModel.a hnA = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ac(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.T(list) && PbActivity.this.hmK != null) {
                PbActivity.this.hmK.dA(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hnB = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
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
    private boolean hnC = false;
    private PraiseModel hnD = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void rd(String str) {
            PbActivity.this.hnC = false;
            if (PbActivity.this.hnD != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmH.getPbData();
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
            PbActivity.this.hnC = false;
            if (PbActivity.this.hnD != null && str != null) {
                if (AntiHelper.aD(i, str)) {
                    AntiHelper.aU(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hnE = 0;
    private boolean hnF = true;
    private b.a hnG = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void no(boolean z) {
            PbActivity.this.nn(z);
            if (PbActivity.this.hmK.bNk() != null && z) {
                PbActivity.this.hmK.nN(false);
            }
            PbActivity.this.hmK.nP(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().bYC != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().bYC, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLq));
                        }
                    } else if (updateAttentionMessage.getData().Jy) {
                        if (PbActivity.this.bId().YO() != null && PbActivity.this.bId().YO().getGodUserData() != null) {
                            PbActivity.this.bId().YO().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().YO() != null) {
                            PbActivity.this.hmH.getPbData().bHW().YO().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a dLa = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hmK.aMt();
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
    private com.baidu.tieba.pb.a.c ccb = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
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
                    if (PbActivity.this.hmK != null && PbActivity.this.hmK.bJo() && view.getId() == d.g.pb_head_user_info_root) {
                        if (view.getTag(d.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").bJ(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.tag_user_id)));
                        }
                        if (PbActivity.this.hmL != null && PbActivity.this.hmL.fzX != null) {
                            PbActivity.this.hmL.fzX.onClick(view);
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
            if (PbActivity.this.hmZ != null) {
                PbActivity.this.hmK.nS(PbActivity.this.hmZ.amw());
            }
            PbActivity.this.hmK.bMm();
            PbActivity.this.hmK.bMX();
            return true;
        }
    });
    private CustomMessageListener hnH = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnh) {
                PbActivity.this.hmK.aMt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmH.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bIj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hng.i(PbActivity.this.hnf.getResources().getString(d.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hnf.getResources().getString(d.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.oX(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bJW();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hnf.getResources().getString(d.j.mute_fail);
                    }
                    PbActivity.this.hng.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hnI = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnh) {
                PbActivity.this.hmK.aMt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hng.i(PbActivity.this.hnf.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hnf.getResources().getString(d.j.un_mute_fail);
                }
                PbActivity.this.hng.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hnJ = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hnh) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hmK.aMt();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.iUe;
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
                    PbActivity.this.hmK.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hnK = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hmK.bMn() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bJq();
            }
        }
    };
    private CustomMessageListener fad = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.eZt = true;
                }
            }
        }
    };
    public a.b hbc = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bcL();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hmH.getPageData();
            int pageNum = PbActivity.this.hmK.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(d.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.XC()) {
                PbActivity.this.hmK.bMX();
                PbActivity.this.wb(2);
                PbActivity.this.bcK();
                PbActivity.this.hmK.bMG();
                if (com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.hmH.wj(PbActivity.this.hmK.getPageNum());
                    if (PbActivity.this.hmm != null) {
                        PbActivity.this.hmm.showFloatingView();
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
                    if (view == PbActivity.this.hmK.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hmH.ny(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hmK.bMH();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLS()) {
                        if (view == PbActivity.this.hmK.hvB.csE) {
                            if (PbActivity.this.hmK.nR(PbActivity.this.hmH.bKU())) {
                                PbActivity.this.bcK();
                                return;
                            }
                            PbActivity.this.hmp = false;
                            PbActivity.this.hmn = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hmK.hvB.csE);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hmK.bME() && (PbActivity.this.hmK.hvB.bNT() == null || (view != PbActivity.this.hmK.hvB.bNT().bLR() && view != PbActivity.this.hmK.hvB.bNT().bLP()))) {
                            if (view == PbActivity.this.hmK.bNa()) {
                                if (PbActivity.this.hmH != null) {
                                    com.baidu.tbadk.browser.a.ar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmH.getPbData().bHW().YN().getLink());
                                }
                            } else if (view != PbActivity.this.hmK.hvB.hAA) {
                                if (view == PbActivity.this.hmK.hvB.hAB) {
                                    if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                                        ArrayList<PostData> bHY = PbActivity.this.hmH.getPbData().bHY();
                                        if ((bHY == null || bHY.size() <= 0) && PbActivity.this.hmH.bKP()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").bJ("tid", PbActivity.this.hmH.bKO()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId()));
                                        if (!PbActivity.this.hmK.bNp()) {
                                            PbActivity.this.hmK.bMm();
                                        }
                                        PbActivity.this.bJy();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(d.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == d.g.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.kY()) {
                                        PbActivity.this.hmK.ns(true);
                                        PbActivity.this.hmK.bMm();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hmK.bul();
                                            PbActivity.this.bcK();
                                            PbActivity.this.hmK.bMG();
                                            PbActivity.this.hmH.zP(PbActivity.this.bJL());
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
                                    if ((PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLO()) && view.getId() != d.g.floor_owner_reply && view.getId() != d.g.reply_title) {
                                        if (PbActivity.this.hmK.hvB.bNT() != null && view == PbActivity.this.hmK.hvB.bNT().getCancelView()) {
                                            PbActivity.this.hmK.hvB.Qi();
                                        } else if (view.getId() != d.g.pb_editor_tool_share && view.getId() != d.g.share_num_container) {
                                            if (PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLM()) {
                                                if ((PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLU()) && view.getId() != d.g.pb_sort) {
                                                    if (PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLN()) {
                                                        if (PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLV()) {
                                                            if (PbActivity.this.hmK.bNk() == view) {
                                                                if (PbActivity.this.hmK.bNk().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmH.getPbData();
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
                                                            } else if (PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLT()) {
                                                                if (PbActivity.this.hmK.hvB.bNT() != null && view == PbActivity.this.hmK.hvB.bNT().bLQ()) {
                                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hmK.c(PbActivity.this.hmH.getPbData(), PbActivity.this.hmH.bKP(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(d.g.tag_del_multi_forum))) {
                                                                                PbActivity.this.hmK.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hmK.a(((Integer) c2.get(d.g.tag_del_post_type)).intValue(), (String) c2.get(d.g.tag_del_post_id), ((Integer) c2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(d.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(d.g.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hmK.hvB.Qi();
                                                                    } else {
                                                                        PbActivity.this.showToast(d.j.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.sub_pb_more || view.getId() == d.g.sub_pb_item || view.getId() == d.g.pb_floor_reply_more || view.getId() == d.g.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hmH != null && view.getId() == d.g.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar.bJ("tid", PbActivity.this.hmH.bKO());
                                                                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
                                                                        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar.T("obj_locate", 4);
                                                                        TiebaStatic.log(amVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hmH.getPbData() != null) {
                                                                            PbActivity.this.hmK.bMX();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(d.g.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(d.g.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.ceB() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                }
                                                                                if (postData.iGH != null) {
                                                                                    com.baidu.tbadk.core.util.am adg = postData.iGH.adg();
                                                                                    adg.delete("obj_locate");
                                                                                    if (view.getId() == d.g.new_sub_pb_list_richText) {
                                                                                        adg.T("obj_locate", 6);
                                                                                    } else if (view.getId() == d.g.pb_floor_reply_more) {
                                                                                        adg.T("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(adg);
                                                                                }
                                                                                String bKO = PbActivity.this.hmH.bKO();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hmH.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hmH.getPbData().bIi();
                                                                                }
                                                                                PbActivity.this.bcK();
                                                                                if (view.getId() == d.g.replybtn) {
                                                                                    c zN = PbActivity.this.zN(id);
                                                                                    if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && zN != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKO, id, "pb", true, null, true, null, i4, postData.bOL(), PbActivity.this.hmH.getPbData().getAnti(), false, postData.YO().getIconInfo()).addBigImageData(zN.hoE, zN.hoF, zN.hoG, zN.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hmH.bLw());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hmH.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c zN2 = PbActivity.this.zN(id);
                                                                                    if (postData != null && PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && zN2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKO, id, "pb", true, null, false, null, i4, postData.bOL(), PbActivity.this.hmH.getPbData().getAnti(), false, postData.YO().getIconInfo()).addBigImageData(zN2.hoE, zN2.hoF, zN2.hoG, zN2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hmH.bLw());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hmH.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").T("obj_locate", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == d.g.pb_post_reply_count) {
                                                                    if (PbActivity.this.hmH != null) {
                                                                        com.baidu.tbadk.core.util.am amVar2 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar2.bJ("tid", PbActivity.this.hmH.bKO());
                                                                        amVar2.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
                                                                        amVar2.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar2.T("obj_locate", 5);
                                                                        TiebaStatic.log(amVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                                                                                    String bKO2 = PbActivity.this.hmH.bKO();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hmH.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hmH.getPbData().bIi();
                                                                                    }
                                                                                    c zN3 = PbActivity.this.zN(id2);
                                                                                    if (zN3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bKO2, id2, "pb", true, null, false, null, i5, postData2.bOL(), PbActivity.this.hmH.getPbData().getAnti(), false, postData2.YO().getIconInfo()).addBigImageData(zN3.hoE, zN3.hoF, zN3.hoG, zN3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hmH.bLw());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hmH.getFromForumId());
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
                                                                    if (PbActivity.this.hmH != null) {
                                                                        com.baidu.tbadk.core.util.am amVar3 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar3.bJ("tid", PbActivity.this.hmH.bKO());
                                                                        amVar3.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
                                                                        amVar3.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar3.T("obj_locate", 6);
                                                                        TiebaStatic.log(amVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(d.g.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(d.g.tag_load_sub_data);
                                                                                if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.bJn().bMk() != null && postData3.YO() != null && postData3.cep() != 1) {
                                                                                    if (PbActivity.this.bJn().bMl() != null) {
                                                                                        PbActivity.this.bJn().bMl().bKB();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                                                                    jVar.a(PbActivity.this.hmH.getPbData().getForum());
                                                                                    jVar.ai(PbActivity.this.hmH.getPbData().bHW());
                                                                                    jVar.e(postData3);
                                                                                    PbActivity.this.bJn().bMk().d(jVar);
                                                                                    PbActivity.this.bJn().bMk().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.YO().getUserId(), "");
                                                                                    if (PbActivity.this.hmZ != null) {
                                                                                        PbActivity.this.hmK.nS(PbActivity.this.hmZ.amw());
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
                                                                } else if (view != PbActivity.this.hmK.bJi()) {
                                                                    if (view == PbActivity.this.hmK.hvB.bNU()) {
                                                                        PbActivity.this.hmK.bMN();
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").bJ("tid", PbActivity.this.hmH.hrH));
                                                                                    }
                                                                                    if (PbActivity.this.hmR == null) {
                                                                                        PbActivity.this.hmR = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                                                                                        PbActivity.this.hmR.a(PbActivity.this.hnV);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cm(view);
                                                                                    if (!PbActivity.this.cm(view) || PbActivity.this.hnj == null || !PbActivity.this.hnj.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hmR);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                                                                                        fVar4.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(fVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cer() != null && postData4.cer().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hmR);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(d.g.tag_clip_board, postData4);
                                                                                            fVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(fVar5);
                                                                                        }
                                                                                        PbActivity.this.fPE = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hmH.getPbData().UY()) {
                                                                                        String UX = PbActivity.this.hmH.getPbData().UX();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(UX) && UX.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hmR);
                                                                                            } else {
                                                                                                fVar = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hmR);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(d.g.tag_clip_board, PbActivity.this.fPE);
                                                                                            sparseArray6.put(d.g.tag_is_subpb, false);
                                                                                            fVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(fVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hmR);
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
                                                                                                        com.baidu.tbadk.core.dialog.f fVar7 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hmR);
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
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hmR);
                                                                                                        fVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(d.g.tag_should_delete_visible, false);
                                                                                                        fVar2 = null;
                                                                                                    }
                                                                                                    fVar3 = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hmR);
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
                                                                                                    if (PbActivity.this.hmH.getPbData().bIi() == 1002 && !z3) {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hmR);
                                                                                                    } else {
                                                                                                        fVar2 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hmR);
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
                                                                                            PbActivity.this.hmR.P(arrayList);
                                                                                            PbActivity.this.hmQ = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hmR.abh());
                                                                                            PbActivity.this.hmQ.showDialog();
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
                                                                                    PbActivity.this.hmR.P(arrayList);
                                                                                    PbActivity.this.hmQ = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hmR.abh());
                                                                                    PbActivity.this.hmQ.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_act_btn) {
                                                                            if (PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), PbActivity.this.hmH.getPbData().bHW().getActUrl());
                                                                                if (PbActivity.this.hmH.getPbData().bHW().Zy() != 1) {
                                                                                    if (PbActivity.this.hmH.getPbData().bHW().Zy() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.lottery_tail) {
                                                                            if (view.getTag(d.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(d.g.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()).bJ("tid", PbActivity.this.hmH.getPbData().getThreadId()).bJ("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hmH.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hmK.setSelection(0);
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
                                                                                PbActivity.this.hmK.bMm();
                                                                            }
                                                                        } else if (id3 == d.g.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bJv() == 1 && PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()).bJ("tid", PbActivity.this.hmH.getPbData().getThreadId()).bJ("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.ar(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bJv() == 1 && PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()).bJ("tid", PbActivity.this.hmH.getPbData().getThreadId()).bJ("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == d.g.manga_prev_btn) {
                                                                            PbActivity.this.bJN();
                                                                        } else if (id3 == d.g.manga_next_btn) {
                                                                            PbActivity.this.bJO();
                                                                        } else if (id3 == d.g.yule_head_img_img) {
                                                                            if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bIp() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hmH.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").bJ(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                ba.adA().c(PbActivity.this.getPageContext(), new String[]{pbData2.bIp().bIw()});
                                                                            }
                                                                        } else if (id3 == d.g.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bIp() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hmH.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                ba.adA().c(PbActivity.this.getPageContext(), new String[]{pbData3.bIp().bIw()});
                                                                            }
                                                                        } else if (PbActivity.this.hmK.hvB.bNT() != null && view == PbActivity.this.hmK.hvB.bNT().bLW()) {
                                                                            if (PbActivity.this.hmH == null || PbActivity.this.hmH.getPbData() == null || PbActivity.this.hmH.getPbData().bHW() == null) {
                                                                                PbActivity.this.hmK.hvB.Qi();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.lo()) {
                                                                                PbActivity.this.showToast(d.j.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hmH.getPbData().bHW().Yv() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmH.bKO(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(d.j.haved_fans_called)).abe();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").T("obj_locate", PbActivity.this.aw(PbActivity.this.hmH.getPbData().bHW())).bJ("tid", PbActivity.this.hmH.getPbData().bHW().getTid()).T("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == d.g.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hnm >= 0) {
                                                                                if (PbActivity.this.hmH != null) {
                                                                                    PbActivity.this.hmH.bLx();
                                                                                }
                                                                                if (PbActivity.this.hmK.bMC() != null) {
                                                                                    PbActivity.this.hmK.bMC().a(PbActivity.this.hmH.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hmK.getListView().setSelection(PbActivity.this.hmH.bLA());
                                                                                PbActivity.this.hnm = 0;
                                                                                if (PbActivity.this.hmH != null) {
                                                                                    PbActivity.this.hmH.bU(0, 0);
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
                                                                            if (PbActivity.this.hmK.getListView() != null && PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hmK.getListView().getFirstVisiblePosition();
                                                                                int top = PbActivity.this.hmK.getListView().getChildAt(0).getTop();
                                                                                boolean bIu = PbActivity.this.hmH.getPbData().bIu();
                                                                                boolean z8 = PbActivity.this.hmK.hvv != null && PbActivity.this.hmK.hvv.bPb();
                                                                                boolean bMU = PbActivity.this.hmK.bMU();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bIu && PbActivity.this.hmK.hvv != null && PbActivity.this.hmK.hvv.aBz() != null) {
                                                                                    int aO = ((int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d)) - PbActivity.this.hmK.hvv.bPc();
                                                                                    z9 = firstVisiblePosition == 0 && (top == aO || top == PbActivity.this.hmK.hvv.aBz().getHeight() - PbActivity.this.hmK.hvv.bPc());
                                                                                    i7 = aO;
                                                                                }
                                                                                if ((PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().YF() <= 0) || (bMU && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bJs();
                                                                                        if (PbActivity.this.hmH.getPbData().bHW().YO() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmH.hrH).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hmH.getPbData().bHW().YO().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int aQ = (int) (com.baidu.adp.lib.util.l.aQ(PbActivity.this) * 0.6d);
                                                                                    if (bIu) {
                                                                                        if (PbActivity.this.hmK.hxk != null && PbActivity.this.hmK.hxk.hys != null && PbActivity.this.hmK.hxk.hys.getView() != null) {
                                                                                            if (PbActivity.this.hmK.hxk.hys.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bJB();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hmK.hvv.aBz() != null) {
                                                                                                    i8 = PbActivity.this.hmK.hvv.aBz().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hmK.hxk.hys.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hmK.bMu() != null) {
                                                                                        z10 = PbActivity.this.hmK.bMu().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hmK.hxk != null && PbActivity.this.hmK.hxk.hys != null && PbActivity.this.hmK.hxk.hys.getView() != null && PbActivity.this.hmK.hxk.hys.getView().getParent() != null && PbActivity.this.hmK.hvB != null && PbActivity.this.hmK.hvB.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hmK.hxk.hys.getView().getTop() - PbActivity.this.hmK.hvB.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bMU) {
                                                                                        int bJB = PbActivity.this.bJB();
                                                                                        if (PbActivity.this.bJA() != -1) {
                                                                                            bJB--;
                                                                                        }
                                                                                        int h = com.baidu.adp.lib.util.l.h(PbActivity.this, d.e.tbds116);
                                                                                        if (bJB < 0) {
                                                                                            i2 = PbActivity.this.hmK.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.S(PbActivity.this.hmK.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bJB;
                                                                                            i3 = h;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bIu || PbActivity.this.hmK.hvv.aBz() == null) {
                                                                                            if (PbActivity.this.hmK.hvB != null && PbActivity.this.hmK.hvB.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hmK.hvB.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hmK.hvv.aBz().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hmK.hxk == null || PbActivity.this.hmK.hxk.hys == null || PbActivity.this.hmK.hxk.hys.getView() == null || PbActivity.this.hmK.hxk.hys.getView().getParent() == null) {
                                                                                            PbActivity.this.hmK.getListView().setSelectionFromTop(i2, i3 + aQ);
                                                                                            PbActivity.this.hmK.getListView().smoothScrollBy(aQ, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hmK.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hmK.getListView().smoothScrollBy(PbActivity.this.hmK.hxk.hys.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-aQ))) {
                                                                                        PbActivity.this.hmK.getListView().setSelectionFromTop(0, i7 - aQ);
                                                                                        PbActivity.this.hmK.getListView().smoothScrollBy(-aQ, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hmK.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().YO() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmH.hrH).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()).T("obj_locate", 2).bJ("uid", PbActivity.this.hmH.getPbData().bHW().YO().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.pb_nav_title_forum_image || id3 == d.g.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(PbActivity.this.hmH.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hmH.bLw() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hmH.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar4 = new com.baidu.tbadk.core.util.am("c13401");
                                                                                amVar4.bJ("tid", PbActivity.this.hmH.bKO());
                                                                                amVar4.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
                                                                                amVar4.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == d.g.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hmH.bLw() == 3 && PbActivity.this.bIN() && PbActivity.this.hmH.getPbData() != null && com.baidu.tbadk.core.util.v.T(PbActivity.this.hmH.getPbData().bIr())) {
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
                                                                            if (PbActivity.this.hmH != null) {
                                                                                com.baidu.tbadk.core.util.am amVar6 = new com.baidu.tbadk.core.util.am("c13398");
                                                                                amVar6.bJ("tid", PbActivity.this.hmH.bKO());
                                                                                amVar6.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
                                                                                amVar6.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                amVar6.T("obj_locate", 2);
                                                                                TiebaStatic.log(amVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.hmH.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.hmH.bKO(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hmH.getPbData().bHW().Zi())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.kY()) {
                                                                PbActivity.this.hmK.bMX();
                                                                SparseArray<Object> c3 = PbActivity.this.hmK.c(PbActivity.this.hmH.getPbData(), PbActivity.this.hmH.bKP(), 1);
                                                                if (c3 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmH.getPbData().getForum().getId(), PbActivity.this.hmH.getPbData().getForum().getName(), PbActivity.this.hmH.getPbData().bHW().getId(), String.valueOf(PbActivity.this.hmH.getPbData().getUserData().getUserId()), (String) c3.get(d.g.tag_forbid_user_name), (String) c3.get(d.g.tag_forbid_user_name_show), (String) c3.get(d.g.tag_forbid_user_post_id), (String) c3.get(d.g.tag_forbid_user_portrait))));
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
                                                            PbActivity.this.hmK.hvB.bNS();
                                                        }
                                                    } else if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bHW() != null) {
                                                        PbActivity.this.hmK.hvB.Qi();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                        PbActivity.this.zK(PbActivity.this.hmH.getPbData().bHW().Ze());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hmK.bMX();
                                                    if (com.baidu.adp.lib.util.j.kY()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hmH.bLf()));
                                                            return;
                                                        }
                                                        PbActivity.this.wb(2);
                                                        PbActivity.this.bcK();
                                                        PbActivity.this.hmK.bMG();
                                                        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hmH.getPbData().hkj == null || PbActivity.this.hmH.getPbData().hkj.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(d.j.sort_type_new), PbActivity.this.getResources().getString(d.j.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hmH.getPbData().hkj.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hmH.getPbData().hkj.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hmH.getPbData().hkj.get(i10).sort_name + PbActivity.this.getResources().getString(d.j.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        gVar.a(null, strArr, new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37.1
                                                            @Override // com.baidu.tbadk.core.dialog.i.c
                                                            public void a(com.baidu.tbadk.core.dialog.i iVar, int i11, View view3) {
                                                                int i12 = 2;
                                                                gVar.dismiss();
                                                                if (PbActivity.this.hmH.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hmH.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hmH.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hmH.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != d.g.pb_sort ? 1 : 0).T("obj_type", i12));
                                                                if (PbActivity.this.hmH.getPbData().hkj != null && PbActivity.this.hmH.getPbData().hkj.size() > i11) {
                                                                    i11 = PbActivity.this.hmH.getPbData().hkj.get(i11).sort_type.intValue();
                                                                }
                                                                boolean wo = PbActivity.this.hmH.wo(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hmH.bLf()));
                                                                if (wo) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hmK.nJ(true);
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
                                                PbActivity.this.hmK.bMX();
                                                if (PbActivity.this.bIX().getPbData().hkk != 2) {
                                                    if (PbActivity.this.hmH.getPageData() != null) {
                                                        PbActivity.this.hmK.a(PbActivity.this.hmH.getPageData(), PbActivity.this.hbc);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(d.j.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (az.jK() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().YO() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmH.hrH).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()).T("obj_locate", 4).bJ("uid", PbActivity.this.hmH.getPbData().bHW().YO().getUserId()));
                                            }
                                            if (PbActivity.this.hmH != null) {
                                                com.baidu.tbadk.core.util.am amVar7 = new com.baidu.tbadk.core.util.am("c12386");
                                                amVar7.bJ("tid", PbActivity.this.hmH.bKO());
                                                amVar7.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                                                amVar7.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
                                                amVar7.T("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    amVar7.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(amVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.lo()) {
                                                if (PbActivity.this.hmH.getPbData() != null) {
                                                    ArrayList<PostData> bHY2 = PbActivity.this.hmH.getPbData().bHY();
                                                    if ((bHY2 != null && bHY2.size() > 0) || !PbActivity.this.hmH.bKP()) {
                                                        PbActivity.this.hmK.bMX();
                                                        PbActivity.this.bcK();
                                                        PbActivity.this.wb(2);
                                                        if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bIp() != null && !StringUtils.isNull(PbActivity.this.hmH.getPbData().bIp().Xk(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                        if (az.jK()) {
                                                            PbActivity.this.wc(2);
                                                        } else {
                                                            PbActivity.this.hmK.showLoadingDialog();
                                                            PbActivity.this.hmH.bLr().m(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hmK.bMX();
                                        if (PbActivity.this.hmK.hvB.bNT() != null && view == PbActivity.this.hmK.hvB.bNT().bLO() && !PbActivity.this.hmK.bNp()) {
                                            PbActivity.this.hmK.bMm();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bcK();
                                            PbActivity.this.hmK.bMG();
                                            if (view.getId() == d.g.floor_owner_reply) {
                                                u = PbActivity.this.hmH.u(true, PbActivity.this.bJL());
                                            } else {
                                                u = view.getId() == d.g.reply_title ? PbActivity.this.hmH.u(false, PbActivity.this.bJL()) : PbActivity.this.hmH.zP(PbActivity.this.bJL());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hmK.ns(true);
                                                PbActivity.this.hmK.bul();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hmK.nJ(true);
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
                                    PbActivity.this.hmK.bMX();
                                    if (PbActivity.this.wa(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.hmH.wp(PbActivity.this.hmK.bML()) != null) {
                                        PbActivity.this.bJF();
                                        if (PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().YO() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bJ("tid", PbActivity.this.hmH.hrH).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId()).T("obj_locate", 3).bJ("uid", PbActivity.this.hmH.getPbData().bHW().YO().getUserId()));
                                        }
                                        if (PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().YO() != null && PbActivity.this.hmH.getPbData().bHW().YO().getUserId() != null && PbActivity.this.hmJ != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hmH.hrH).T("obj_locate", 1).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hmH.getPbData().bHW().YO().getUserId()).T("obj_type", PbActivity.this.hmJ.UY() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hmH.getPbData())));
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
                                if (PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().ZI() && PbActivity.this.hmH.getPbData().bHW().Zf() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.hmH.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hmH.bIO()) && PbActivity.this.hmH.getAppealInfo() != null) {
                                        name = PbActivity.this.hmH.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hmH.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bIO = PbActivity.this.hmH.bIO();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hmH.bKQ() && bIO != null && bIO.equals(name)) {
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
                            if (PbActivity.this.hmH.getPbData() != null) {
                                if ((PbActivity.this.hmH.getPbData().bIi() == 1 || PbActivity.this.hmH.getPbData().bIi() == 3) && !PbActivity.this.eiJ.cfb()) {
                                    PbActivity.this.hmK.bMX();
                                    int i11 = 0;
                                    if (PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLP()) {
                                        if (PbActivity.this.hmK.hvB.bNT() == null || view != PbActivity.this.hmK.hvB.bNT().bLR()) {
                                            if (view == PbActivity.this.hmK.bME()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hmH.getPbData().bHW().YK() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hmH.getPbData().bHW().YJ() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hmH.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hmH.getPbData().bHW().getId();
                                    PbActivity.this.hmK.bMD();
                                    PbActivity.this.eiJ.a(id4, name2, id5, i11, PbActivity.this.hmK.bMF());
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
                        PbActivity.this.hmK.bMX();
                        PbActivity.this.bcK();
                        PbActivity.this.hmK.bMG();
                        PbActivity.this.hmK.showLoadingDialog();
                        if (PbActivity.this.hmK.bMu() != null) {
                            PbActivity.this.hmK.bMu().setVisibility(8);
                        }
                        PbActivity.this.hmH.wj(1);
                        if (PbActivity.this.hmm != null) {
                            PbActivity.this.hmm.showFloatingView();
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
                if (PbActivity.this.hmH != null) {
                    com.baidu.tbadk.core.util.am amVar8 = new com.baidu.tbadk.core.util.am("c13398");
                    amVar8.bJ("tid", PbActivity.this.hmH.bKO());
                    amVar8.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
                    amVar8.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar8.T("obj_locate", 1);
                    TiebaStatic.log(amVar8);
                }
                if (PbActivity.this.hmw) {
                    PbActivity.this.hmw = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(d.g.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.bJn().bMk() != null && postData5.YO() != null && postData5.cep() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bJn().bMl() != null) {
                                PbActivity.this.bJn().bMl().bKB();
                            }
                            com.baidu.tieba.pb.data.j jVar2 = new com.baidu.tieba.pb.data.j();
                            jVar2.a(PbActivity.this.hmH.getPbData().getForum());
                            jVar2.ai(PbActivity.this.hmH.getPbData().bHW());
                            jVar2.e(postData5);
                            PbActivity.this.bJn().bMk().d(jVar2);
                            PbActivity.this.bJn().bMk().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.YO().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hmH.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hmZ != null) {
                                PbActivity.this.hmK.nS(PbActivity.this.hmZ.amw());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d ckv = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId());
                }
                if (PbActivity.this.hmH != null) {
                    amVar.bJ("tid", PbActivity.this.hmH.bKO());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.bcK();
            PbActivity.this.hmK.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.s.ap.apD() && PbActivity.this.bIX() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bIX().zS(postWriteCallBackData.getPostId());
                    PbActivity.this.hnm = PbActivity.this.hmK.bMq();
                    if (PbActivity.this.hmH != null) {
                        PbActivity.this.hmH.bU(PbActivity.this.hnm, PbActivity.this.hmK.bMr());
                    }
                }
                PbActivity.this.hmK.bMX();
                PbActivity.this.hmP.bNv();
                if (PbActivity.this.hmZ != null) {
                    PbActivity.this.hmK.nS(PbActivity.this.hmZ.amw());
                }
                PbActivity.this.hmK.bMj();
                PbActivity.this.hmK.nU(true);
                PbActivity.this.hmH.bLh();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hmH.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmH.getPbData();
                            if (pbData != null && pbData.bHW() != null && pbData.bHW().YO() != null && (userId = pbData.bHW().YO().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.s.ap.apD() && PbActivity.this.hmH.bKY()) {
                                PbActivity.this.hmK.bMG();
                            }
                        } else if (!com.baidu.tbadk.s.ap.apD() && PbActivity.this.hmH.bKY()) {
                            PbActivity.this.hmK.bMG();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hmK.n(PbActivity.this.hmH.getPbData());
                    }
                    if (PbActivity.this.hmH.bKT()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").bJ("tid", PbActivity.this.hmH.bKO()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hmZ.amC() || PbActivity.this.hmZ.amD()) {
                    PbActivity.this.hmZ.a(false, postWriteCallBackData);
                }
                PbActivity.this.hmP.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gyy != null) {
                    PbActivity.this.gyy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hnL = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                    amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getPbData().getForumId());
                }
                if (PbActivity.this.hmH != null) {
                    amVar.bJ("tid", PbActivity.this.hmH.bKO());
                }
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (PbActivity.this.hmP != null) {
                    PbActivity.this.hmP.bNu();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gyy != null) {
                    PbActivity.this.gyy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hmP != null) {
                if (PbActivity.this.hmK != null && PbActivity.this.hmK.bMl() != null && PbActivity.this.hmK.bMl().bKF() != null && PbActivity.this.hmK.bMl().bKF().amD()) {
                    PbActivity.this.hmK.bMl().bKF().a(postWriteCallBackData);
                }
                PbActivity.this.hmP.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a hnM = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g js;
            if (!z || dVar == null || dVar.bIg() != null || com.baidu.tbadk.core.util.v.S(dVar.bHY()) >= 1) {
                PbActivity.this.gPS = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hmK.bMI();
                if (dVar == null || !dVar.bIc()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hmK.getView());
                }
                PbActivity.this.hmK.buk();
                if (PbActivity.this.isFullScreen || PbActivity.this.hmK.bNp()) {
                    PbActivity.this.hmK.bNg();
                } else if (!PbActivity.this.hmK.bNd()) {
                    PbActivity.this.hmK.nU(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hmS = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hmK.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hmK.aOs();
                    if (dVar.bHW() != null && dVar.bHW().ZR() != null) {
                        PbActivity.this.a(dVar.bHW().ZR());
                    }
                    PbActivity.this.bJk();
                    if (PbActivity.this.hmZ != null) {
                        PbActivity.this.hmK.nS(PbActivity.this.hmZ.amw());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bHY() != null && dVar.bHY().size() >= 1 && dVar.bHY().get(0) != null) {
                        PbActivity.this.hmH.zR(dVar.bHY().get(0).getId());
                    } else if (dVar.bIg() != null) {
                        PbActivity.this.hmH.zR(dVar.bIg().getId());
                    }
                    if (PbActivity.this.hmZ != null) {
                        PbActivity.this.hmZ.a(dVar.getAnti());
                        PbActivity.this.hmZ.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hmZ.a(PbActivity.this.hmH.bLb(), PbActivity.this.hmH.bKO(), PbActivity.this.hmH.bLt());
                        if (dVar.bHW() != null) {
                            PbActivity.this.hmZ.eO(dVar.bHW().aag());
                        }
                    }
                    if (PbActivity.this.hmJ != null) {
                        PbActivity.this.hmJ.cZ(dVar.UY());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hmK.nT(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hmK.a(dVar, i2, i3, PbActivity.this.hmH.bKP(), i4, PbActivity.this.hmH.getIsFromMark());
                    PbActivity.this.hmK.e(dVar, PbActivity.this.hmH.bKP());
                    PbActivity.this.hmK.nQ(PbActivity.this.hmH.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.ckl = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.ckl) && PbActivity.this.hmZ != null && PbActivity.this.hmZ.alP() != null && (js = PbActivity.this.hmZ.alP().js(6)) != null && !TextUtils.isEmpty(PbActivity.this.ckl)) {
                            ((View) js).setOnClickListener(PbActivity.this.ckZ);
                        }
                    }
                    if (PbActivity.this.hmU) {
                        PbActivity.this.hmU = false;
                        final int bJA = PbActivity.this.bJA();
                        if (!dVar.bIu()) {
                            PbActivity.this.hmK.wv(bJA);
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
                    if (PbActivity.this.hmV) {
                        PbActivity.this.hmV = false;
                        final int bJA2 = PbActivity.this.bJA();
                        final boolean z2 = bJA2 != -1;
                        if (!z2) {
                            bJA2 = PbActivity.this.bJB();
                        }
                        if (PbActivity.this.hmK != null) {
                            if (!dVar.bIu()) {
                                PbActivity.this.hmK.wv(bJA2);
                            } else {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bJA2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hmK.setSelectionFromTop(bJA2, aO2);
                                            } else {
                                                PbActivity.this.hmK.setSelectionFromTop(bJA2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hmK.nV(true);
                            }
                        }
                    } else if (PbActivity.this.hmW) {
                        PbActivity.this.hmW = false;
                        PbActivity.this.hmK.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hmK.bMM();
                    }
                    PbActivity.this.hmH.a(dVar.getForum(), PbActivity.this.hnz);
                    PbActivity.this.hmH.a(PbActivity.this.hnA);
                    if (PbActivity.this.gyy != null && dVar.bHW() != null && dVar.bHW().YO() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bHW().YO());
                        PbActivity.this.gyy.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hmS && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hmH != null && PbActivity.this.hmH.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hmH.getAppealInfo().hjD)) {
                                    PbActivity.this.hmK.a(PbActivity.this.hmH.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hmK.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hmK.getView(), PbActivity.this.getPageContext().getResources().getString(d.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
                            }
                            PbActivity.this.hmK.bNg();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hmH.bKO());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
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
                        PbActivity.this.hmK.zV("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                            arrayList = PbActivity.this.hmH.getPbData().bHY();
                        }
                        if (com.baidu.tbadk.core.util.v.S(arrayList) != 0 && (com.baidu.tbadk.core.util.v.S(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cep() != 1)) {
                            PbActivity.this.hmK.zV(PbActivity.this.getResources().getString(d.j.list_no_more_new));
                        } else if (PbActivity.this.bJY()) {
                            PbActivity.this.hmK.zW(PbActivity.this.getResources().getString(d.j.pb_no_host_reply));
                        } else {
                            PbActivity.this.hmK.zW(PbActivity.this.getResources().getString(d.j.pb_no_replay));
                        }
                    }
                    PbActivity.this.hmK.aeA();
                }
                PbActivity.this.cqy = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bIX().bKP() || PbActivity.this.bIX().getPbData().getPage().XI() != 0 || PbActivity.this.bIX().bLn()) {
                    PbActivity.this.hna = true;
                    return;
                }
                return;
            }
            PbActivity.this.hmH.wj(1);
            if (PbActivity.this.hmm != null) {
                PbActivity.this.hmm.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hmK.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.o.m.apg().aph()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eCx : j;
                com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(i, z, responsedMessage, PbActivity.this.cqq, PbActivity.this.createTime, PbActivity.this.cqy, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cqq = 0L;
                if (iVar != null) {
                    iVar.apd();
                }
                if (z2) {
                    iVar.cqH = currentTimeMillis;
                    iVar.fe(true);
                }
                if (!z2 && PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bHW() != null) {
                    int threadType = PbActivity.this.hmH.getPbData().bHW().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmz, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hmz, "from_frs")) {
                                com.baidu.tbadk.o.i iVar2 = new com.baidu.tbadk.o.i();
                                iVar2.jW(1000);
                                iVar2.cqJ = currentTimeMillis;
                                iVar2.jX(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.o.d dVar = new com.baidu.tbadk.o.d();
                        dVar.pageType = 1;
                        dVar.jW(1005);
                        dVar.cqJ = currentTimeMillis;
                        dVar.jX(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hnN = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bJw();
            }
        }
    };
    private final a.InterfaceC0221a hnO = new a.InterfaceC0221a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0221a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hmK.bMI();
            if (z) {
                if (PbActivity.this.hmJ != null) {
                    PbActivity.this.hmJ.cZ(z2);
                }
                PbActivity.this.hmH.nA(z2);
                if (PbActivity.this.hmH.UY()) {
                    PbActivity.this.bJG();
                } else {
                    PbActivity.this.hmK.n(PbActivity.this.hmH.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hmJ != null && PbActivity.this.hmJ.Vb() != null && PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().YO() != null) {
                        MarkData Vb = PbActivity.this.hmJ.Vb();
                        MetaData YO = PbActivity.this.hmH.getPbData().bHW().YO();
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
                if (PbActivity.this.hmK != null) {
                    PbActivity.this.hmK.bMX();
                    if (PbActivity.this.hmZ != null && !PbActivity.this.hmK.bMn()) {
                        PbActivity.this.hmK.nS(PbActivity.this.hmZ.amw());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hmK.bMm();
                    }
                }
                if (!PbActivity.this.hmt) {
                    PbActivity.this.hmt = true;
                    PbActivity.this.hmK.bNc();
                }
            }
            PbActivity.this.hmK.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hmm != null) {
                PbActivity.this.hmm.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hmu == null) {
                PbActivity.this.hmu = new com.baidu.tbadk.o.b();
                PbActivity.this.hmu.jW(1001);
            }
            if (i == 0) {
                PbActivity.this.hmu.aoX();
            } else {
                PbActivity.this.hmu.aoW();
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
            if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmK != null && PbActivity.this.hmK.bMC() != null) {
                PbActivity.this.hmK.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hmm != null) {
                    PbActivity.this.hmm.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hmH.bLj() && (bHY = PbActivity.this.hmH.getPbData().bHY()) != null && !bHY.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hmK.bMC().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmH.getPbData();
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
    private final com.baidu.adp.base.d eiN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eiJ.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hmH.bLh();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hCu != 1002 || bVar.fCT) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hmK.a(1, dVar.Id, dVar.iIo, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eiJ.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hmK.a(PbActivity.this.eiJ.getLoadDataMode(), gVar.Id, gVar.iIo, false);
                        PbActivity.this.hmK.at(gVar.iIr);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hmK.a(PbActivity.this.eiJ.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hnP = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final h.c cPx = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (PbActivity.this.bJM()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hmH.nz(true)) {
                PbActivity.this.hmK.bMJ();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fsD = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hnQ && PbActivity.this.bJM()) {
                PbActivity.this.bJO();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hmH.ny(false)) {
                    PbActivity.this.hmK.bMH();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hmH.getPbData() != null) {
                    PbActivity.this.hmK.bNb();
                }
                PbActivity.this.hnQ = true;
            }
        }
    };
    private int hnR = 0;
    private final TbRichTextView.h cAE = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bMC;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hmH != null) {
                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                        amVar.bJ("tid", PbActivity.this.hmH.bKO());
                        amVar.bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId());
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
                        PbActivity.this.hmD = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hoH) {
                        TbRichText bh = PbActivity.this.bh(str, i);
                        if (bh != null && PbActivity.this.hnR >= 0 && PbActivity.this.hnR < bh.ast().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bh.ast().get(PbActivity.this.hnR));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hoE.size()) {
                                    break;
                                } else if (!cVar.hoE.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bh.getPostId() != 0 && (bMC = PbActivity.this.hmK.bMC()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bMC.getDataList();
                                if (com.baidu.tbadk.core.util.v.S(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bh.getPostId() == com.baidu.adp.lib.g.b.d(((PostData) next).getId(), 0L)) {
                                            if (bh.getPostId() != com.baidu.adp.lib.g.b.d(PbActivity.this.hmH.bLt(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hmH.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.T(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hoF.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoG, cVar.lastId, PbActivity.this.hmH.bLe(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.m(rect);
                            createConfig.setIsHotSort(PbActivity.this.hmH.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hoE, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.T(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hoF.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hoG, cVar.hoE.get(0), PbActivity.this.hmH.bLe(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hmH.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hmK.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hnS = false;
    PostData fPE = null;
    private final b.InterfaceC0225b hnT = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
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
    private final b.InterfaceC0225b hnU = new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hnj != null && !TextUtils.isEmpty(PbActivity.this.hnk)) {
                if (i == 0) {
                    if (PbActivity.this.hnl == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnk));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hnk;
                        aVar.pkgId = PbActivity.this.hnl.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnl.memeInfo.pck_id;
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
                        PbActivity.this.fzF.h(PbActivity.this.hnk, PbActivity.this.hnj.oB());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hnj = null;
                PbActivity.this.hnk = null;
            }
        }
    };
    private final View.OnLongClickListener cdg = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
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
                        PbActivity.this.hnj = ((TbImageView) view).getBdImage();
                        PbActivity.this.hnk = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hnj == null || TextUtils.isEmpty(PbActivity.this.hnk)) {
                            return true;
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnl = null;
                        } else {
                            PbActivity.this.hnl = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hnj = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hnk = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hnl = null;
                            } else {
                                PbActivity.this.hnl = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hnj = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hnk = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(d.g.tag_rich_text_meme_info) == null || !(view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hnl = null;
                        } else {
                            PbActivity.this.hnl = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        PbActivity.this.hmK.a(PbActivity.this.hnU, PbActivity.this.hnj.isGif());
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
                if (PbActivity.this.hmJ != null) {
                    if (!PbActivity.this.hmJ.UY() || PbActivity.this.fPE.getId() == null || !PbActivity.this.fPE.getId().equals(PbActivity.this.hmH.YX())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.fPE.cep() == 1) {
                        PbActivity.this.hmK.a(PbActivity.this.hnT, z, false);
                        return true;
                    }
                    if (PbActivity.this.hmR == null) {
                        PbActivity.this.hmR = new com.baidu.tbadk.core.dialog.i(PbActivity.this);
                        PbActivity.this.hmR.a(PbActivity.this.hnV);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cm = PbActivity.this.cm(view);
                        boolean z3 = (!PbActivity.this.cm(view) || PbActivity.this.hnj == null || PbActivity.this.hnj.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.f fVar3 = new com.baidu.tbadk.core.dialog.f(0, PbActivity.this.getString(d.j.no_interesting), PbActivity.this.hmR);
                            fVar3.mTextView.setTag(d.g.tag_chudian_template_id, Long.valueOf(j));
                            fVar3.mTextView.setTag(d.g.tag_chudian_monitor_id, str2);
                            fVar3.mTextView.setTag(d.g.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(fVar3);
                        }
                        if (cm) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(1, PbActivity.this.getString(d.j.save_to_emotion), PbActivity.this.hmR));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.f(2, PbActivity.this.getString(d.j.save_to_local), PbActivity.this.hmR));
                        }
                        if (!cm && !z3) {
                            com.baidu.tbadk.core.dialog.f fVar4 = new com.baidu.tbadk.core.dialog.f(3, PbActivity.this.getString(d.j.copy), PbActivity.this.hmR);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(d.g.tag_clip_board, PbActivity.this.fPE);
                            fVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(fVar4);
                        }
                        if (!z4) {
                            if (z) {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.remove_mark), PbActivity.this.hmR);
                            } else {
                                fVar2 = new com.baidu.tbadk.core.dialog.f(4, PbActivity.this.getString(d.j.mark), PbActivity.this.hmR);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(d.g.tag_clip_board, PbActivity.this.fPE);
                            sparseArray4.put(d.g.tag_is_subpb, false);
                            fVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(fVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.f fVar5 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.mute_option), PbActivity.this.hmR);
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
                                    com.baidu.tbadk.core.dialog.f fVar6 = new com.baidu.tbadk.core.dialog.f(5, PbActivity.this.getString(d.j.report_text), PbActivity.this.hmR);
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
                                    fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hmR);
                                    fVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(d.g.tag_should_delete_visible, false);
                                }
                                fVar = new com.baidu.tbadk.core.dialog.f(7, PbActivity.this.getString(d.j.bar_manager), PbActivity.this.hmR);
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
                                    if (PbActivity.this.hmH.getPbData().bIi() == 1002 && !z5) {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.report_text), PbActivity.this.hmR);
                                    } else {
                                        fVar7 = new com.baidu.tbadk.core.dialog.f(6, PbActivity.this.getString(d.j.delete), PbActivity.this.hmR);
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
                        PbActivity.this.hmR.P(arrayList);
                        PbActivity.this.hmQ = new com.baidu.tbadk.core.dialog.g(PbActivity.this.getPageContext(), PbActivity.this.hmR.abh());
                        PbActivity.this.hmQ.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").bJ("tid", PbActivity.this.hmH.hrH).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId()).bJ("uid", PbActivity.this.hmH.getPbData().bHW().YO().getUserId()).bJ("post_id", PbActivity.this.hmH.aml()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hmK.a(PbActivity.this.hnU, PbActivity.this.hnj.isGif());
            return true;
        }
    };
    private i.c hnV = new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.i.c
        public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
            if (PbActivity.this.hmQ != null) {
                PbActivity.this.hmQ.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hmH.getPbData();
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
                    if (PbActivity.this.hnj != null && !TextUtils.isEmpty(PbActivity.this.hnk)) {
                        if (PbActivity.this.hnl == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hnk));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hnk;
                            aVar.pkgId = PbActivity.this.hnl.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hnl.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hnj = null;
                        PbActivity.this.hnk = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hnj != null && !TextUtils.isEmpty(PbActivity.this.hnk)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.adN();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.Y(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fzF == null) {
                                PbActivity.this.fzF = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fzF.h(PbActivity.this.hnk, PbActivity.this.hnj.oB());
                            PbActivity.this.hnj = null;
                            PbActivity.this.hnk = null;
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
                        if (PbActivity.this.hmH.getPbData().bHW() != null && PbActivity.this.hmH.getPbData().bHW().YO() != null && PbActivity.this.hmH.getPbData().bHW().YO().getUserId() != null && PbActivity.this.hmJ != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bJ("tid", PbActivity.this.hmH.hrH).T("obj_locate", 2).bJ(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hmH.getPbData().bHW().YO().getUserId()).T("obj_type", PbActivity.this.hmJ.UY() ? 0 : 1).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.hmH.getPbData())));
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
                        PbActivity.this.hmK.a(((Integer) sparseArray2.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(d.g.tag_del_post_id), ((Integer) sparseArray2.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(d.g.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hmK.cs(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hmK.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a eWq = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (!PbActivity.this.hmo && z && !PbActivity.this.hmH.bKV()) {
                PbActivity.this.bJI();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), d.e.ds360));
        }
    };
    public View.OnTouchListener ccX = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.dLJ.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0284a dLK = new a.InterfaceC0284a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        final int dVJ;

        {
            this.dVJ = (int) PbActivity.this.getResources().getDimension(d.e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            if (av(i2) && PbActivity.this.hmK != null && PbActivity.this.hmm != null) {
                PbActivity.this.hmK.bNh();
                PbActivity.this.hmm.jr(false);
                PbActivity.this.hmm.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aS(int i, int i2) {
            if (av(i2) && PbActivity.this.hmK != null && PbActivity.this.hmm != null) {
                PbActivity.this.hmm.jr(true);
                if (Math.abs(i2) > this.dVJ) {
                    PbActivity.this.hmm.hideFloatingView();
                }
                if (PbActivity.this.bJM()) {
                    PbActivity.this.hmK.bMz();
                    PbActivity.this.hmK.bMA();
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
    private String hnX = null;
    private final m.a hnY = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void k(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(d.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(d.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hnX = str2;
                PbActivity.this.hmK.zX(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hnZ = -1;
    private int hoa = -1;
    private CustomMessageListener hod = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bvZ == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0223a) {
                    if (aVar.bwa != null && !aVar.bwa.hasError() && aVar.bwa.getError() == 0) {
                        if (PbActivity.this.hmK != null) {
                            PbActivity.this.hmK.s(((a.C0223a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bJX();
                        }
                    } else if (z) {
                        if (aVar.bwa != null && aVar.bwa.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bwa.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bwa != null && !aVar.bwa.hasError() && aVar.bwa.getError() == 0) {
                        if (PbActivity.this.hmK != null && PbActivity.this.hmK != null) {
                            PbActivity.this.hmK.s(((a.C0223a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bwa != null && aVar.bwa.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bwa.getErrorString());
                        } else {
                            PbActivity.this.showToast(d.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bwa == null || aVar.bwa.hasError() || aVar.bwa.getError() != 0) {
                        if (z) {
                            if (aVar.bwa != null && aVar.bwa.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bwa.getErrorString());
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
        public ArrayList<String> hoE;
        public ConcurrentHashMap<String, ImageUrlData> hoF;
        public boolean hoH;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hoG = false;
        public boolean hoI = false;
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
        return this.hmZ;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bIA() != null) {
            String id = jVar.bIA().getId();
            ArrayList<PostData> bHY = this.hmH.getPbData().bHY();
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
                                next.a(getPageContext(), this.hmH.zQ(metaData.getUserId()));
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
            if (!this.hmH.getIsFromMark() && z) {
                this.hmK.n(this.hmH.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zI(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bIl = this.hmH.getPbData().bIl();
            if (bIl != null && str.equals(bIl.getAdId())) {
                if (bIl.ced() != null) {
                    bIl.ced().legoCard = null;
                }
                this.hmH.getPbData().bIm();
            }
            com.baidu.tieba.tbadkCore.data.m bKZ = this.hmH.bKZ();
            if (bKZ != null && str.equals(bKZ.getAdId())) {
                this.hmH.bLa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(d.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer)) {
            if (this.hmQ != null && this.hmQ.isShowing()) {
                this.hmQ.dismiss();
                this.hmQ = null;
            }
            final String str = (String) sparseArray.get(d.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(d.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this);
                iVar.a(new i.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                    @Override // com.baidu.tbadk.core.dialog.i.c
                    public void a(com.baidu.tbadk.core.dialog.i iVar2, int i, View view) {
                        if (PbActivity.this.hmQ != null) {
                            PbActivity.this.hmQ.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hmK.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(d.g.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(d.g.tag_user_mute_thread_id), (String) sparseArray.get(d.g.tag_user_mute_post_id), 1, str, PbActivity.this.hnh);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hnh);
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
                this.hmQ = new com.baidu.tbadk.core.dialog.g(getPageContext(), iVar.abh());
                this.hmQ.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(int i) {
        bg bHW;
        if (this.hmH != null && this.hmH.getPbData() != null && (bHW = this.hmH.getPbData().bHW()) != null) {
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
            if (this.hmH.bKP()) {
                this.hmK.bMC().notifyDataSetChanged();
            } else {
                this.hmK.o(this.hmH.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hmH.aa(bundle);
        if (this.eYE != null) {
            this.eYE.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hmZ.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hms = System.currentTimeMillis();
        this.hnf = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eCx = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hmz = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hmz) && intent.getData() != null) {
                this.hmz = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hmz)) {
                this.hmn = true;
            }
            this.hnZ = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hoa = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hob = intent.getStringExtra("key_manga_title");
            this.hmU = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hmV = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hmW = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bJM()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.hnn = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eCx = System.currentTimeMillis();
        }
        this.cqq = this.hms - this.eCx;
        super.onCreate(bundle);
        this.hmq = 0;
        Z(bundle);
        if (this.hmH != null && this.hmH.getPbData() != null) {
            this.hmH.getPbData().zG(this.source);
        }
        initUI();
        if (intent != null && this.hmK != null) {
            this.hmK.hvu = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hni == null) {
                    this.hni = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hmK.zZ("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hni, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hmH != null && this.hmH.getPbData() != null) {
                this.hmH.zT(stringExtra);
            }
        }
        this.eYE = new VoiceManager();
        this.eYE.onCreate(getPageContext());
        initData(bundle);
        this.hmY = new com.baidu.tbadk.editortools.pb.f();
        bJk();
        this.hmZ = (com.baidu.tbadk.editortools.pb.d) this.hmY.dd(getActivity());
        this.hmZ.b(this);
        this.hmZ.a(this.ckv);
        this.hmZ.a(this.cko);
        this.hmZ.a(this, bundle);
        this.hmZ.alP().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hmZ.alP().eH(true);
        ni(true);
        this.hmK.setEditorTools(this.hmZ.alP());
        this.hmZ.a(this.hmH.bLb(), this.hmH.bKO(), this.hmH.bLt());
        registerListener(this.hnu);
        if (!this.hmH.bKU()) {
            this.hmZ.oS(this.hmH.bKO());
        }
        if (this.hmH.bLu()) {
            this.hmZ.oQ(getPageContext().getString(d.j.pb_reply_hint_from_smart_frs));
        } else if (this.hmK != null) {
            this.hmZ.oQ(this.hmK.bMo());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hnt);
        registerListener(this.hnv);
        registerListener(this.hnw);
        registerListener(this.eZW);
        registerListener(this.hnK);
        registerListener(this.hns);
        this.hmX = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.iFm);
        this.hmX.cdQ();
        registerListener(this.hny);
        registerListener(this.mAttentionListener);
        if (this.hmH != null) {
            this.hmH.bLl();
        }
        registerListener(this.hnN);
        registerListener(this.hod);
        registerListener(this.fad);
        if (this.hmK != null && this.hmK.bNl() != null && this.hmK.bNm() != null) {
            this.hmm = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hmK.bNl(), this.hmK.bNm(), this.hmK.bMu());
            this.hmm.a(this.hnG);
        }
        if (this.hml && this.hmK != null && this.hmK.bNm() != null) {
            this.hmK.bNm().setVisibility(8);
        }
        this.hng = new com.baidu.tbadk.core.view.e();
        this.hng.bPR = 1000L;
        registerListener(this.hnJ);
        registerListener(this.hnH);
        registerListener(this.hnI);
        registerListener(this.frv);
        registerListener(this.brt);
        this.hnh = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hnh;
        userMuteAddAndDelCustomMessage.setTag(this.hnh);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hnh;
        userMuteCheckCustomMessage.setTag(this.hnh);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hmH.bLr().a(this.dLa);
        this.hmP = new as();
        if (this.hmZ.amp() != null) {
            this.hmP.k(this.hmZ.amp().getInputView());
        }
        this.hmZ.a(this.ckp);
        this.fot = new ShareSuccessReplyToServerModel();
        a(this.hnp);
        this.gyy = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gyy.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bKw) {
                        PbActivity.this.hmZ.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bKx && PbActivity.this.hmK != null && PbActivity.this.hmK.bMl() != null && PbActivity.this.hmK.bMl().bKF() != null) {
                        PbActivity.this.hmK.bMl().bKF().amI();
                    } else if (i == com.baidu.tbadk.core.util.aj.bKy) {
                        PbActivity.this.c(PbActivity.this.hnc);
                    }
                }
            }
        });
        this.hmI = new com.baidu.tieba.pb.pb.report.a(this);
        this.hmI.p(getUniqueId());
        com.baidu.tieba.q.c.cdp().s(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.hms;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJk() {
        if (this.hmY != null && this.hmH != null) {
            this.hmY.setForumName(this.hmH.bIO());
            if (this.hmH.getPbData() != null && this.hmH.getPbData().getForum() != null) {
                this.hmY.a(this.hmH.getPbData().getForum());
            }
            this.hmY.setFrom("pb");
            this.hmY.a(this.hmH);
        }
    }

    public String bJl() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bJm() {
        return this.hmm;
    }

    private void ni(boolean z) {
        this.hmZ.eL(z);
        this.hmZ.eM(z);
        this.hmZ.eN(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bIu() && !z && this.hmK != null && this.hmK.getView() != null && !UtilHelper.isOnePlus6()) {
            this.hmK.getView().setSystemUiVisibility(4);
        }
        this.hnd = z;
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
        if (this.eYE != null) {
            this.eYE.onStart(getPageContext());
        }
    }

    public aq bJn() {
        return this.hmK;
    }

    public PbModel bIX() {
        return this.hmH;
    }

    public void zJ(String str) {
        if (this.hmH != null && !StringUtils.isNull(str) && this.hmK != null) {
            this.hmK.nX(true);
            this.hmH.zJ(str);
            this.hmy = true;
            this.hmK.bMX();
            this.hmK.bNg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hmo = false;
        } else {
            this.hmo = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hmq = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hmq == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.eYE != null) {
            this.eYE.onPause(getPageContext());
        }
        if (this.hmK != null) {
            this.hmK.onPause();
        }
        if (!this.hmH.bKU()) {
            this.hmZ.oR(this.hmH.bKO());
        }
        if (this.hmH != null) {
            this.hmH.bLm();
        }
        com.baidu.tbadk.BdToken.c.TX().TY();
        MessageManager.getInstance().unRegisterListener(this.gct);
        bnV();
        MessageManager.getInstance().unRegisterListener(this.hnH);
        MessageManager.getInstance().unRegisterListener(this.hnI);
        MessageManager.getInstance().unRegisterListener(this.hnJ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bJo() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hmH.getPbData(), this.hmH.bKP(), this.hmH.getRequestType());
        return (a2 == null || a2.YO() == null || a2.YO().getGodUserData() == null || a2.YO().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hmo = false;
        super.onResume();
        if (this.hmB) {
            this.hmB = false;
            bJS();
        }
        if (bJo()) {
            this.hmv = System.currentTimeMillis();
        } else {
            this.hmv = -1L;
        }
        if (this.hmK != null && this.hmK.getView() != null) {
            if (!this.gPS) {
                bJJ();
            } else {
                hideLoadingView(this.hmK.getView());
            }
            this.hmK.onResume();
        }
        if (this.hmq == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hmK != null) {
            noNetworkView = this.hmK.bMi();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kY()) {
            noNetworkView.dO(false);
        }
        if (this.eYE != null) {
            this.eYE.onResume(getPageContext());
        }
        registerListener(this.gct);
        this.hmT = false;
        bJR();
        registerListener(this.hnH);
        registerListener(this.hnI);
        registerListener(this.hnJ);
        if (this.eZt) {
            bJI();
            this.eZt = false;
        }
        bKa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hmK.nM(z);
        if (this.hmQ != null) {
            this.hmQ.dismiss();
        }
        if (z && this.hmT) {
            this.hmK.bMH();
            this.hmH.ny(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hmv > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").bJ("obj_duration", (System.currentTimeMillis() - this.hmv) + ""));
            this.hmv = 0L;
        }
        if (bJn().bMl() != null) {
            bJn().bMl().onStop();
        }
        if (this.hmK.hvB != null && !this.hmK.hvB.aRm()) {
            this.hmK.hvB.bzk();
        }
        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().getForum() != null && this.hmH.getPbData().bHW() != null) {
            com.baidu.tbadk.distribute.a.alC().a(getPageContext().getPageActivity(), "pb", this.hmH.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmH.getPbData().bHW().getId(), 0L));
        }
        if (this.eYE != null) {
            this.eYE.onStop(getPageContext());
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
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hmH.getPbData().getForumId());
            amVar.bJ("tid", this.hmH.bKO());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hmt && this.hmK != null) {
            this.hmt = true;
            this.hmK.bNc();
            a(false, (PostData) null);
        }
        if (this.hmH != null) {
            this.hmH.cancelLoadData();
            this.hmH.destory();
            if (this.hmH.bLq() != null) {
                this.hmH.bLq().onDestroy();
            }
        }
        if (this.hmZ != null) {
            this.hmZ.onDestroy();
        }
        if (this.eiJ != null) {
            this.eiJ.cancelLoadData();
        }
        if (this.hmK != null) {
            this.hmK.onDestroy();
            if (this.hmK.hvB != null) {
                this.hmK.hvB.bzk();
            }
        }
        if (this.hmu != null) {
            this.hmu.aoY();
        }
        if (this.hmm != null) {
            this.hmm.aqh();
        }
        super.onDestroy();
        if (this.eYE != null) {
            this.eYE.onDestory(getPageContext());
        }
        this.hmK.bMX();
        MessageManager.getInstance().unRegisterListener(this.hnH);
        MessageManager.getInstance().unRegisterListener(this.hnI);
        MessageManager.getInstance().unRegisterListener(this.hnJ);
        MessageManager.getInstance().unRegisterListener(this.hnh);
        MessageManager.getInstance().unRegisterListener(this.hnK);
        MessageManager.getInstance().unRegisterListener(this.fad);
        MessageManager.getInstance().unRegisterListener(this.frv);
        this.hnf = null;
        this.hng = null;
        com.baidu.tieba.recapp.d.a.bXv().bXx();
        if (this.hni != null) {
            getSafeHandler().removeCallbacks(this.hni);
        }
        if (this.hmC != null) {
            this.hmC.cancelLoadData();
        }
        if (this.hmK != null && this.hmK.hvB != null) {
            this.hmK.hvB.bNX();
        }
        if (this.fot != null) {
            this.fot.cancelLoadData();
        }
        this.hmP.onDestroy();
        if (this.hmH != null && this.hmH.bLs() != null) {
            this.hmH.bLs().onDestroy();
        }
        if (this.gyy != null) {
            this.gyy.onDestroy();
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
        if (adAdSense != null && adAdSense.afX() && this.hmK != null && (bMC = this.hmK.bMC()) != null && (bKq = bMC.bKq()) != null) {
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
                        bVar.ekG = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bCk == 1 && !TextUtils.isEmpty(id)) {
                    next.bCk = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.ekG = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hmH == null || this.hmH.getPbData() == null || this.hmH.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hmH.getPbData().getForum().getFirst_class();
                    str2 = this.hmH.getPbData().getForum().getSecond_class();
                    str = this.hmH.getPbData().getForum().getId();
                    str4 = this.hmH.bKO();
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
            this.hmK.onChangeSkinType(i);
            if (this.hmZ != null && this.hmZ.alP() != null) {
                this.hmZ.alP().onChangeSkinType(i);
            }
            if (this.hmK.bMi() != null) {
                this.hmK.bMi().onChangeSkinType(getPageContext(), i);
            }
            this.hmP.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hmK = new aq(this, this.faL, this.ccb);
        this.dLJ = new com.baidu.tieba.f.b(getActivity());
        this.dLJ.a(hnW);
        this.dLJ.a(this.dLK);
        this.hmK.setOnScrollListener(this.mOnScrollListener);
        this.hmK.e(this.fsD);
        this.hmK.setListPullRefreshListener(this.cPx);
        this.hmK.nc(com.baidu.tbadk.core.i.Wv().Wz());
        this.hmK.setOnImageClickListener(this.cAE);
        this.hmK.b(this.cdg);
        this.hmK.h(this.eWq);
        this.hmK.a(this.hnP);
        this.hmK.nM(this.mIsLogin);
        if (getIntent() != null) {
            this.hmK.nY(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hmK.bMk().setFromForumId(this.hmH.getFromForumId());
    }

    public void bJp() {
        if (this.hmK != null && this.hmH != null) {
            if ((this.hmH.getPbData() != null || this.hmH.getPbData().bIt() != null) && checkUpIsLogin() && this.hmK.bMC() != null && this.hmK.bMC().bKv() != null) {
                this.hmK.bMC().bKv().ns(this.hmH.bKO());
            }
        }
    }

    public void bJq() {
        TiebaStatic.log("c12181");
        if (this.hmK != null && this.hmH != null) {
            if (this.hmK == null || this.hmK.bMn()) {
                if (this.hmH.getPbData() != null || this.hmH.getPbData().bIt() != null) {
                    com.baidu.tieba.pb.data.i bIt = this.hmH.getPbData().bIt();
                    if (checkUpIsLogin()) {
                        if ((!bIt.bIx() || bIt.aak() != 2) && this.hmK.bMC() != null && this.hmK.bMC().bKv() != null) {
                            this.hmK.bMC().bKv().ns(this.hmH.bKO());
                        }
                        if (System.currentTimeMillis() - this.hmx > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).or(false);
                            this.hmx = System.currentTimeMillis();
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
                if (postData.getType() != PostData.iFO && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.Wv().Wz()) {
                    return zM(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hmH == null || this.hmH.getPbData() == null) {
                        return true;
                    }
                    if (bJn().bMl() != null) {
                        bJn().bMl().bKB();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.hmH.getPbData().getForum());
                    jVar.ai(this.hmH.getPbData().bHW());
                    jVar.e(postData);
                    bJn().bMk().d(jVar);
                    bJn().bMk().setPostId(postData.getId());
                    a(view, postData.YO().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hmZ != null) {
                        this.hmK.nS(this.hmZ.amw());
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
        if (this.hmK != null) {
            if (z && !this.gPS) {
                bJJ();
            } else {
                hideLoadingView(this.hmK.getView());
            }
            if (z && this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bIu() && this.hmK.getView() != null && !UtilHelper.isOnePlus6()) {
                this.hmK.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bJr() {
        if (this.hmr == null) {
            this.hmr = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hmr.a(new String[]{getPageContext().getString(d.j.call_phone), getPageContext().getString(d.j.sms_phone), getPageContext().getString(d.j.search_in_baidu)}, new b.InterfaceC0225b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hmg = PbActivity.this.hmg.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmg);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hmH.bKO(), PbActivity.this.hmg, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hmg = PbActivity.this.hmg.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmg);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hmH.bKO(), PbActivity.this.hmg, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hmg = PbActivity.this.hmg.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmg);
                        bVar.dismiss();
                    }
                }
            }).gG(b.a.bFd).gH(17).d(getPageContext());
        }
    }

    private void Z(Bundle bundle) {
        this.hmH = new PbModel(this);
        this.hmH.a(this.hnM);
        if (this.hmH.bLp() != null) {
            this.hmH.bLp().a(this.hnY);
        }
        if (this.hmH.bLo() != null) {
            this.hmH.bLo().a(this.hnx);
        }
        if (this.hmH.bLq() != null) {
            this.hmH.bLq().b(this.hnr);
        }
        if (bundle != null) {
            this.hmH.initWithBundle(bundle);
        } else {
            this.hmH.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hmH.nB(true);
        }
        aj.bLX().ao(this.hmH.bKM(), this.hmH.getIsFromMark());
        if (StringUtils.isNull(this.hmH.bKO())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hmz) && this.hmz != null) {
            this.hmH.wq(6);
        }
        this.hmH.aor();
    }

    private void initData(Bundle bundle) {
        this.hmJ = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hmJ != null) {
            this.hmJ.a(this.hnO);
        }
        this.eiJ = new ForumManageModel(this);
        this.eiJ.setLoadDataCallBack(this.eiN);
        this.bKB = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hmK.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    PbActivity.this.showToast(d.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hmH.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hmH.getPbData().getForum().getId(), PbActivity.this.hmH.getPbData().getForum().getName(), PbActivity.this.hmH.getPbData().bHW().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hnD.setUniqueId(getUniqueId());
        this.hnD.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hmK.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(d.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hnh;
        userMuteCheckCustomMessage.setTag(this.hnh);
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
                            PbActivity.this.hmK.bnj();
                        }
                    }
                });
            }
            if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().getForum() != null) {
                this.fci.q(this.hmH.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmH.bKO(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJt() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hmH != null && (pbData = this.hmH.getPbData()) != null) {
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
                ((View) view.getParent()).getLocationOnScreen(this.hmE);
                this.hmF = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hnb == null) {
                this.hnb = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hnb.ra(1);
                this.hnb.a(new AnonymousClass39(str, str2));
            }
            if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().getForum() != null) {
                this.hnb.q(this.hmH.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.d(this.hmH.bKO(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$39  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String hon;
        final /* synthetic */ String hoo;

        AnonymousClass39(String str, String str2) {
            this.hon = str;
            this.hoo = str2;
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
                        PbActivity.this.bJn().getListView().smoothScrollBy((PbActivity.this.hmE[1] + PbActivity.this.hmF) - (aQ - h), 50);
                        if (PbActivity.this.bJn().bMl() != null) {
                            PbActivity.this.hmZ.alP().setVisibility(8);
                            PbActivity.this.bJn().bMl().Y(AnonymousClass39.this.hon, AnonymousClass39.this.hoo, PbActivity.this.bJn().bMo());
                            com.baidu.tbadk.editortools.pb.g bKF = PbActivity.this.bJn().bMl().bKF();
                            if (bKF != null && PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                                bKF.a(PbActivity.this.hmH.getPbData().getAnti());
                            }
                            if (PbActivity.this.hmP.bNy() == null && PbActivity.this.bJn().bMl().bKF().amQ() != null) {
                                PbActivity.this.bJn().bMl().bKF().amQ().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hmP != null && PbActivity.this.hmP.bNx() != null) {
                                            if (!PbActivity.this.hmP.bNx().cnZ()) {
                                                PbActivity.this.hmP.oa(false);
                                            }
                                            PbActivity.this.hmP.bNx().qV(false);
                                        }
                                    }
                                });
                                PbActivity.this.hmP.l(PbActivity.this.bJn().bMl().bKF().amQ().getInputView());
                                PbActivity.this.bJn().bMl().bKF().a(PbActivity.this.hne);
                            }
                        }
                        PbActivity.this.bJn().bNg();
                    }
                }, 0L);
            }
        }
    }

    public boolean bJu() {
        if (this.gyy == null || this.hmH.getPbData() == null || this.hmH.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyy.hl(this.hmH.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean vZ(int i) {
        if (this.gyy == null || this.hmH.getPbData() == null || this.hmH.getPbData().getAnti() == null) {
            return true;
        }
        return this.gyy.S(this.hmH.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(d.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(d.g.tag_clip_board)) != null && this.hmH != null && this.hmH.getPbData() != null && postData.cep() != 1) {
            String bKO = this.hmH.bKO();
            String id = postData.getId();
            int bIi = this.hmH.getPbData() != null ? this.hmH.getPbData().bIi() : 0;
            c zN = zN(id);
            if (zN != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bKO, id, "pb", true, null, false, null, bIi, postData.bOL(), this.hmH.getPbData().getAnti(), false, postData.YO() != null ? postData.YO().getIconInfo() : null).addBigImageData(zN.hoE, zN.hoF, zN.hoG, zN.index);
                addBigImageData.setKeyPageStartFrom(this.hmH.bLw());
                addBigImageData.setFromFrsForumId(this.hmH.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJv() {
        if (this.hmH.getPbData() == null || this.hmH.getPbData().bHW() == null) {
            return -1;
        }
        return this.hmH.getPbData().bHW().Zy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJw() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.BU(this.hmH.getForumId()) && this.hmH.getPbData() != null && this.hmH.getPbData().getForum() != null) {
            if (this.hmH.getPbData().getForum().isLike() == 1) {
                this.hmH.bLs().dP(this.hmH.getForumId(), this.hmH.bKO());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hmH == null || this.hmH.getPbData() == null) {
            return false;
        }
        return ((this.hmH.getPbData().bIi() != 0) || this.hmH.getPbData().bHW() == null || this.hmH.getPbData().bHW().YO() == null || TextUtils.equals(this.hmH.getPbData().bHW().YO().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bJx() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.s.v.apE()) {
            return "";
        }
        PostData bId = bId();
        if (this.hmH == null || (pbData = this.hmH.getPbData()) == null || pbData.getUserData() == null || pbData.bHW() == null || bId == null || bId.YO() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bId.YO().isBigV()) {
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
        if (this.hmH == null || this.hmH.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hmH.getPbData();
        if (pbData.bIi() != 0) {
            return pbData.bIi() != 3;
        }
        List<com.baidu.tbadk.core.data.bc> bIr = pbData.bIr();
        if (com.baidu.tbadk.core.util.v.S(bIr) > 0) {
            for (com.baidu.tbadk.core.data.bc bcVar : bIr) {
                if (bcVar != null && (vVar = bcVar.bAE) != null && vVar.byx && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }

    private boolean nl(boolean z) {
        return (z || this.hmH == null || this.hmH.getPbData() == null || this.hmH.getPbData().bIi() == 0 || this.hmH.getPbData().bIi() == 3) ? false : true;
    }

    public void bJy() {
        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null && this.hmH.getPbData().bHW().YO() != null) {
            if (this.hmK != null) {
                this.hmK.bMj();
            }
            bg bHW = this.hmH.getPbData().bHW();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bHW.YO().getUserId());
            ab abVar = new ab();
            int bIi = this.hmH.getPbData().bIi();
            if (bIi == 1 || bIi == 3) {
                abVar.htK = true;
                abVar.htJ = true;
                abVar.htR = bHW.YJ() == 1;
                abVar.htQ = bHW.YK() == 1;
            } else {
                abVar.htK = false;
                abVar.htJ = false;
            }
            if (bIi == 1002 && !equals) {
                abVar.htV = true;
            }
            abVar.htL = nk(equals);
            abVar.htM = bJz();
            abVar.htN = nl(equals);
            abVar.qV = this.hmH.bKP();
            abVar.htI = true;
            abVar.htH = nj(equals);
            abVar.htT = bJx();
            abVar.htG = equals && this.hmK.bMO();
            abVar.htO = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.htP = true;
            abVar.isHostOnly = this.hmH.getHostMode();
            abVar.htS = true;
            if (bHW.Zf() == null) {
                abVar.htU = true;
            } else {
                abVar.htU = false;
            }
            this.hmK.hvB.a(abVar);
        }
    }

    private boolean bJz() {
        if (this.hmH != null && this.hmH.bKP()) {
            return this.hmH.getPageData() == null || this.hmH.getPageData().XI() != 0;
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
            if ((mVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) mVar).mType == com.baidu.tieba.pb.data.h.hkv) {
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
            if ((mVar instanceof PostData) && mVar.getType() == PostData.iFN) {
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
                    PbActivity.this.bKB.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hmH.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aaW();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hmK.bMI();
        this.hmH.nA(z);
        if (this.hmJ != null) {
            this.hmJ.cZ(z);
            if (markData != null) {
                this.hmJ.a(markData);
            }
        }
        if (this.hmH.UY()) {
            bJG();
        } else {
            this.hmK.n(this.hmH.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vX(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zK(String str) {
        this.hmI.Ai(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hmH.bKU()) {
                    antiData.setBlock_forum_name(this.hmH.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hmH.getPbData().getForum().getId());
                    antiData.setUser_name(this.hmH.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hmH.getPbData().getUserData().getUserId());
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLo));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLo));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLo));
            }
        } else if (i == 230277) {
            oX(str);
        } else {
            this.hmK.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.iIo) ? bVar.iIo : getString(d.j.delete_fail);
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
                this.hmK.a(0, bVar.Id, bVar.iIo, z);
            }
            if (bVar.Id) {
                if (bVar.eFz == 1) {
                    ArrayList<PostData> bHY = this.hmH.getPbData().bHY();
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
                    this.hmH.getPbData().bHW().gq(this.hmH.getPbData().bHW().YF() - 1);
                    this.hmK.n(this.hmH.getPbData());
                } else if (bVar.eFz == 0) {
                    bJC();
                } else if (bVar.eFz == 2) {
                    ArrayList<PostData> bHY2 = this.hmH.getPbData().bHY();
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
                        this.hmK.n(this.hmH.getPbData());
                    }
                    a(bVar, this.hmK);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hmK.a(this.eiJ.getLoadDataMode(), gVar.Id, gVar.iIo, false);
            if (gVar.Id) {
                this.hmM = true;
                if (i == 2 || i == 3) {
                    this.hmN = true;
                    this.hmO = false;
                } else if (i == 4 || i == 5) {
                    this.hmN = false;
                    this.hmO = true;
                }
                if (i == 2) {
                    this.hmH.getPbData().bHW().gt(1);
                    this.hmH.setIsGood(1);
                } else if (i == 3) {
                    this.hmH.getPbData().bHW().gt(0);
                    this.hmH.setIsGood(0);
                } else if (i == 4) {
                    this.hmH.getPbData().bHW().gs(1);
                    this.hmH.oA(1);
                } else if (i == 5) {
                    this.hmH.getPbData().bHW().gs(0);
                    this.hmH.oA(0);
                }
                this.hmK.d(this.hmH.getPbData(), this.hmH.bKP());
            }
        }
    }

    private void bJC() {
        if (this.hmH.bKQ() || this.hmH.bKS()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hmH.bKO());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hmH.bKO()));
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
        if (this.hmK != null) {
            this.hmK.bMX();
        }
        if (this.hmH != null && this.hmH.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hmH.getPbData().bHW().getId();
            if (this.hmH.isShareThread() && this.hmH.getPbData().bHW().bDz != null) {
                historyMessage.threadName = this.hmH.getPbData().bHW().bDz.showText;
            } else {
                historyMessage.threadName = this.hmH.getPbData().bHW().getTitle();
            }
            if (this.hmH.isShareThread() && !bIN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hmH.getPbData().getForum().getName();
            }
            ArrayList<PostData> bHY = this.hmH.getPbData().bHY();
            int bMK = this.hmK != null ? this.hmK.bMK() : 0;
            if (bHY != null && bMK >= 0 && bMK < bHY.size()) {
                historyMessage.postID = bHY.get(bMK).getId();
            }
            historyMessage.isHostOnly = this.hmH.getHostMode();
            historyMessage.isSquence = this.hmH.bKP();
            historyMessage.isShareThread = this.hmH.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hmZ != null) {
            this.hmZ.onDestroy();
        }
        if (this.hmp && bJn() != null) {
            bJn().bNq();
        }
        if (this.hmH != null && (this.hmH.bKQ() || this.hmH.bKS())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hmH.bKO());
            if (this.hmM) {
                if (this.hmO) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hmH.aWi());
                }
                if (this.hmN) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hmH.getIsGood());
                }
            }
            if (this.hmH.getPbData() != null && System.currentTimeMillis() - this.hms >= 40000 && (bIf = this.hmH.getPbData().bIf()) != null && !com.baidu.tbadk.core.util.v.T(bIf.getDataList())) {
                intent.putExtra("guess_like_data", bIf);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hnn);
            }
            setResult(-1, intent);
        }
        if (bJH()) {
            if (this.hmH != null && this.hmK != null && this.hmK.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hmH.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bIc() && !this.hmy) {
                        aj bLX = aj.bLX();
                        com.baidu.tieba.pb.data.d bKW = this.hmH.bKW();
                        Parcelable onSaveInstanceState = this.hmK.getListView().onSaveInstanceState();
                        boolean bKP = this.hmH.bKP();
                        boolean hostMode = this.hmH.getHostMode();
                        if (this.hmK.bMu() != null && this.hmK.bMu().getVisibility() == 0) {
                            z = true;
                        }
                        bLX.a(bKW, onSaveInstanceState, bKP, hostMode, z);
                        if (this.hnm >= 0 || this.hmH.bLy() != null) {
                            aj.bLX().l(this.hmH.bLy());
                            aj.bLX().k(this.hmH.bLz());
                            aj.bLX().ws(this.hmH.bLA());
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
        if (keyEvent == null || this.hmK == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hmK.wx(i)) {
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
            this.hmK.bMj();
            this.hmK.bMl().bKB();
            this.hmK.nU(false);
        }
        this.hmK.bMm();
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
                        this.hmZ.resetData();
                        this.hmZ.b(writeData);
                        this.hmZ.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k jv = this.hmZ.alP().jv(6);
                        if (jv != null && jv.cix != null) {
                            jv.cix.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hmZ.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hmK.bMl() != null && this.hmK.bMl().bKF() != null) {
                            com.baidu.tbadk.editortools.pb.g bKF = this.hmK.bMl().bKF();
                            bKF.b(writeData);
                            bKF.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k jv2 = bKF.alP().jv(6);
                            if (jv2 != null && jv2.cix != null) {
                                jv2.cix.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
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
        this.hmZ.onActivityResult(i, i2, intent);
        if (this.hmC != null) {
            this.hmC.onActivityResult(i, i2, intent);
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
                            if (PbActivity.this.hmH != null) {
                                PbActivity.this.hmH.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bWn().w(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hmH != null) {
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
                    this.hmK.nh(false);
                    if (this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null && this.hmH.getPbData().bHW().Zi() != null) {
                        this.hmH.getPbData().bHW().Zi().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hnc = emotionImageData;
                        if (vZ(com.baidu.tbadk.core.util.aj.bKy)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hmK != null && this.hmK.hvB != null) {
                        this.hmK.hvB.Qi();
                        this.hmK.hvB.bNR();
                        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null) {
                            this.hmH.getPbData().bHW().go(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hmD != null) {
                        this.hmK.ct(this.hmD);
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
            if (this.hmC == null) {
                this.hmC = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hmC.b(this.cko);
                this.hmC.c(this.ckv);
            }
            this.hmC.a(emotionImageData, bIX(), bIX().getPbData());
        }
    }

    private ShareFromPBMsgData bJE() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ek = this.hmH.getPbData().ek(getPageContext().getPageActivity());
        PostData bMp = this.hmK.bMp();
        String str = "";
        if (bMp != null) {
            str = bMp.getId();
            String ev = bMp.ev(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ev)) {
                ek[1] = ev;
            }
        }
        String Ze = this.hmH.getPbData().bHW().Ze();
        if (Ze != null && Ze.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ek[1]);
        shareFromPBMsgData.setImageUrl(ek[0]);
        shareFromPBMsgData.setForumName(this.hmH.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hmH.getPbData().bHW().getId());
        shareFromPBMsgData.setTitle(this.hmH.getPbData().bHW().getTitle());
        return shareFromPBMsgData;
    }

    private void ad(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bJE(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.gE(1);
            aVar.az(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null) {
                        com.baidu.tbadk.core.util.am bJ = new com.baidu.tbadk.core.util.am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).T("obj_param1", 3).bJ(ImageViewerConfig.FORUM_ID, PbActivity.this.hmH.getForumId()).bJ("tid", PbActivity.this.hmH.bKO());
                        if (PbActivity.this.e(PbActivity.this.hmH.getPbData()) != 0) {
                            bJ.T("obj_type", PbActivity.this.e(PbActivity.this.hmH.getPbData()));
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
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), this.hmH.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null) {
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
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), this.hmH.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJF() {
        MarkData wp;
        if (this.hmJ != null && (wp = this.hmH.wp(this.hmK.bML())) != null) {
            if (!wp.isApp() || (wp = this.hmH.wp(this.hmK.bML() + 1)) != null) {
                this.hmK.bMG();
                this.hmJ.a(wp);
                if (!this.hmJ.UY()) {
                    this.hmJ.Va();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hmJ.UZ();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        com.baidu.tieba.pb.data.d pbData = this.hmH.getPbData();
        this.hmH.nA(true);
        if (this.hmJ != null) {
            pbData.zF(this.hmJ.UX());
        }
        this.hmK.n(pbData);
    }

    private boolean bJH() {
        if (this.hmH == null) {
            return true;
        }
        if (this.hmH.UY()) {
            final MarkData bLg = this.hmH.bLg();
            if (bLg == null || !this.hmH.getIsFromMark()) {
                return true;
            }
            final MarkData wp = this.hmH.wp(this.hmK.bMK());
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
                        if (PbActivity.this.hmJ != null) {
                            if (PbActivity.this.hmJ.UY()) {
                                PbActivity.this.hmJ.UZ();
                                PbActivity.this.hmJ.cZ(false);
                            }
                            PbActivity.this.hmJ.a(wp);
                            PbActivity.this.hmJ.cZ(true);
                            PbActivity.this.hmJ.Va();
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
                        if (PbActivity.this.hmK != null && PbActivity.this.hmK.getView() != null) {
                            PbActivity.this.hmK.getView().getLocationOnScreen(iArr);
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
        } else if (this.hmH.getPbData() == null || this.hmH.getPbData().bHY() == null || this.hmH.getPbData().bHY().size() <= 0 || !this.hmH.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hmK == null) {
            return null;
        }
        return this.hmK.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ata() {
        if (this.hmK == null) {
            return 0;
        }
        return this.hmK.bMV();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> atb() {
        if (this.cAv == null) {
            this.cAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
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
        return this.cAv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atc() {
        if (this.cDk == null) {
            this.cDk = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cDk;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atd() {
        if (this.cAw == null) {
            this.cAw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
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
        return this.cAw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ate() {
        if (this.cDl == null) {
            this.cDl = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
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
        return this.cDl;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atg() {
        this.cDn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
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
        return this.cDn;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afa() {
        if (this.bTV == null) {
            this.bTV = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTV;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ay(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hmw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (av.Aa(str) && this.hmH != null && this.hmH.bKO() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").T("obj_param1", 1).bJ("post_id", this.hmH.bKO()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.chx = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            av.bNA().c(getPageContext(), str);
        }
        this.hmw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void az(Context context, String str) {
        av.bNA().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hmw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aB(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aA(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Rect rect) {
        if (rect != null && this.hmK != null && this.hmK.bNl() != null && rect.top <= this.hmK.bNl().getHeight()) {
            rect.top += this.hmK.bNl().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hmH.getPbData();
            TbRichText bh = bh(str, i);
            if (bh != null && (tbRichTextData = bh.ast().get(this.hnR)) != null) {
                cVar.hoE = new ArrayList<>();
                cVar.hoF = new ConcurrentHashMap<>();
                if (!tbRichTextData.asA().asM()) {
                    cVar.hoH = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hoE.add(b2);
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
                    imageUrlData.mIsReserver = this.hmH.bLe();
                    imageUrlData.mIsSeeHost = this.hmH.getHostMode();
                    cVar.hoF.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bHW() != null) {
                            cVar.threadId = pbData.bHW().getId();
                        }
                        cVar.hoG = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.hoH = true;
                int size = pbData.bHY().size();
                this.hnS = false;
                cVar.index = -1;
                if (pbData.bId() != null) {
                    PostData bId = pbData.bId();
                    TbRichText cer = bId.cer();
                    if (!ap.m(bId)) {
                        i2 = a(cer, bh, i, i, cVar.hoE, cVar.hoF);
                    } else {
                        i2 = a(bId, i, cVar.hoE, cVar.hoF);
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
                            i3 = a(cer2, bh, i3, i, cVar.hoE, cVar.hoF);
                        } else {
                            i3 = a(postData, i3, cVar.hoE, cVar.hoF);
                        }
                    }
                }
                if (cVar.hoE.size() > 0) {
                    cVar.lastId = cVar.hoE.get(cVar.hoE.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bHW() != null) {
                        cVar.threadId = pbData.bHW().getId();
                    }
                    cVar.hoG = pbData.getIsNewUrl() == 1;
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
            this.hnS = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hmH.bKO(), -1L);
                                imageUrlData.mIsReserver = this.hmH.bLe();
                                imageUrlData.mIsSeeHost = this.hmH.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hnS) {
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
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.hmH.bKO(), -1L);
                        imageUrlData.mIsReserver = this.hmH.bLe();
                        imageUrlData.mIsSeeHost = this.hmH.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cey.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cdY, imageUrlData);
                        }
                        if (!this.hnS) {
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
            if (postData.getId() != null && postData.getId().equals(this.hmH.YX())) {
                z = true;
            }
            MarkData j = this.hmH.j(postData);
            if (j != null) {
                this.hmK.bMG();
                if (this.hmJ != null) {
                    this.hmJ.a(j);
                    if (!z) {
                        this.hmJ.Va();
                    } else {
                        this.hmJ.UZ();
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
        if (this.hmH == null || this.hmH.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hmH.getPbData();
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
        if (dVar != null && dVar.bIh() != null && dVar.bIh().hkK != null && (list = dVar.bIh().hkK) != null && arrayList != null) {
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
        com.baidu.tieba.pb.data.d pbData = this.hmH.getPbData();
        if (pbData != null && (bHY = pbData.bHY()) != null && !bHY.isEmpty()) {
            Iterator<PostData> it = bHY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cey = next.cey();
                if (cey != null && cey.iFu) {
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
                            this.hnR = i4;
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
            this.hmg = str;
            if (this.hmr == null) {
                bJr();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hmr.gJ(1).setVisibility(8);
            } else {
                this.hmr.gJ(1).setVisibility(0);
            }
            this.hmr.aaZ();
            this.hmw = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJI() {
        hideNetRefreshView(this.hmK.getView());
        bJJ();
        if (this.hmH.aor()) {
            this.hmK.bMG();
        }
    }

    private void bJJ() {
        showLoadingView(this.hmK.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds400));
        View anz = getLoadingView().anz();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anz.getLayoutParams();
        layoutParams.addRule(3, this.hmK.bNl().getId());
        anz.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcK() {
        if (this.eYE != null) {
            this.eYE.stopPlay();
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
        if (this.hmH.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hmH.getPbData();
            pbData.getForum().getName();
            String title = pbData.bHW().getTitle();
            int i2 = this.hmH.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.BU(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hmH.bKO() + "?share=9105&fr=share&see_lz=" + i2;
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
                    dVar.cbm = true;
                    dVar.cbt = z;
                    dVar.extData = this.hmH.bKO();
                    dVar.cbE = 3;
                    dVar.cbD = i;
                    dVar.fid = this.hmH.getForumId();
                    dVar.tid = this.hmH.bKO();
                    dVar.cbI = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hmH.getPbData().bHW());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.cbE);
                    bundle.putInt("obj_type", dVar.cbI);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.D(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bIu() && !UtilHelper.isOnePlus6()) {
                                PbActivity.this.hmK.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.aSr().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hmH.bKO() + "?share=9105&fr=share&see_lz=" + i2;
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
            dVar2.cbm = true;
            dVar2.cbt = z;
            dVar2.extData = this.hmH.bKO();
            dVar2.cbE = 3;
            dVar2.cbD = i;
            dVar2.fid = this.hmH.getForumId();
            dVar2.tid = this.hmH.bKO();
            dVar2.cbI = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.hmH.getPbData().bHW());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.cbE);
            bundle2.putInt("obj_type", dVar2.cbI);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.D(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hmH != null && PbActivity.this.hmH.getPbData() != null && PbActivity.this.hmH.getPbData().bIu() && !UtilHelper.isOnePlus6()) {
                        PbActivity.this.hmK.getView().setSystemUiVisibility(4);
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
                return Boolean.valueOf(AddExperiencedModel.BV(PbActivity.this.hmH.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hmK.bNr();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> atf() {
        if (this.cDm == null) {
            this.cDm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
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
        if (this.hmH == null || this.hmH.getPbData() == null) {
            return null;
        }
        return this.hmH.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.aaY() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.aaY();
            int intValue = ((Integer) sparseArray.get(aq.hxo)).intValue();
            if (intValue == aq.hxp) {
                if (!this.eiJ.cfb()) {
                    this.hmK.bMD();
                    String str = (String) sparseArray.get(d.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eiJ.CE(com.baidu.tbadk.core.util.ap.x(jSONArray));
                    }
                    this.eiJ.a(this.hmH.getPbData().getForum().getId(), this.hmH.getPbData().getForum().getName(), this.hmH.getPbData().bHW().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hxq || intValue == aq.hxs) {
                if (this.hmH.bLp() != null) {
                    this.hmH.bLp().wf(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hxq) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hnh);
        userMuteAddAndDelCustomMessage.setTag(this.hnh);
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
        this.hmT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bJL() {
        ArrayList<PostData> bHY;
        int S;
        if (this.hmH == null || this.hmH.getPbData() == null || this.hmH.getPbData().bHY() == null || (S = com.baidu.tbadk.core.util.v.S((bHY = this.hmH.getPbData().bHY()))) == 0) {
            return "";
        }
        if (this.hmH.bLe()) {
            Iterator<PostData> it = bHY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cep() == 1) {
                    return next.getId();
                }
            }
        }
        int bMK = this.hmK.bMK();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bHY, bMK);
        if (postData == null || postData.YO() == null) {
            return "";
        }
        if (this.hmH.zQ(postData.YO().getUserId())) {
            return postData.getId();
        }
        for (int i = bMK - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bHY, i);
            if (postData2 == null || postData2.YO() == null || postData2.YO().getUserId() == null) {
                break;
            } else if (this.hmH.zQ(postData2.YO().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bMK + 1; i2 < S; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bHY, i2);
            if (postData3 == null || postData3.YO() == null || postData3.YO().getUserId() == null) {
                return "";
            }
            if (this.hmH.zQ(postData3.YO().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.adA().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(zL(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hmH.getPbData().getForum().getId(), this.hmH.getPbData().getForum().getName(), this.hmH.getPbData().bHW().getTid());
            }
            this.hmw = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hmH.bLo() != null) {
                    PbActivity.this.hmH.bLo().dD(j);
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
        if (this.hmH.getPbData() == null || this.hmH.getPbData().bHY() == null || this.hmH.getPbData().bHY().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hmH.getPbData().bHY().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hmH.getPbData().bHY().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hmH.getPbData().bHY().get(i);
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
        if (this.hmn) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hmn = false;
        } else if (bJM()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hmn) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hmn = false;
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
        if (pageStayDurationItem != null && this.hmH != null) {
            if (this.hmH.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.hmH.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.hmH.bKO(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bJM() {
        return (!this.hml && this.hnZ == -1 && this.hoa == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hoc = oVar;
            this.hml = true;
            this.hmK.bMv();
            this.hmK.zY(this.hob);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJN() {
        if (this.hoc != null) {
            if (this.hnZ == -1) {
                showToast(d.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hoc.getCartoonId(), this.hnZ, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        if (this.hoc != null) {
            if (this.hoa == -1) {
                showToast(d.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hoc.getCartoonId(), this.hoa, 0)));
                finish();
            }
        }
    }

    public int bJP() {
        return this.hnZ;
    }

    public int bJQ() {
        return this.hoa;
    }

    private void bnV() {
        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null && this.hmH.getPbData().bHW().ZI()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bJR() {
        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null && this.hmH.getPbData().bHW().ZI()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bJS() {
        if (this.hmo) {
            this.hmB = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null && this.hmH.getPbData().bHW().Yu() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hmH.getPbData().bHW().Yu().getThreadId(), this.hmH.getPbData().bHW().Yu().getTaskId(), this.hmH.getPbData().bHW().Yu().getForumId(), this.hmH.getPbData().bHW().Yu().getForumName(), this.hmH.getPbData().bHW().YJ(), this.hmH.getPbData().bHW().YK())));
            this.hmn = true;
            finish();
        }
    }

    public String bJT() {
        return this.hmz;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bJU() {
        return this.hmG;
    }

    public void nn(boolean z) {
        this.hmA = z;
    }

    public boolean bJV() {
        if (this.hmH != null) {
            return this.hmH.bKQ();
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
                    ((TbPageContext) PbActivity.this.hnf).showToast(d.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hnf.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hnf).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oX(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hnf != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnf.getPageActivity());
            aVar.lz(str);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hnf).aaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hmK.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnf.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.lz(this.hnf.getResources().getString(d.j.block_mute_message_alert, str3));
        } else {
            aVar.lz(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hmK.showLoadingDialog();
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
        aVar.b(this.hnf).aaW();
    }

    public void bJX() {
        if (this.hmH != null && this.hmH.getPbData() != null && this.hmH.getPbData().bHW() != null && this.hmH.getPbData().bHW().ZY() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.gC(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hmH.getPbData().bHW().ZY().channelId, true, PbActivity.this.getUniqueId())));
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
        if (this.hmK != null) {
            this.hmK.onConfigurationChanged(configuration);
        }
        if (this.hmQ != null) {
            this.hmQ.dismiss();
        }
    }

    public boolean bJY() {
        if (this.hmH != null) {
            return this.hmH.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hmH.getPbData().bIh().hkK;
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
            aqVar.n(this.hmH.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bIA().getId();
        List<PostData> list = this.hmH.getPbData().bIh().hkK;
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
        if (!this.hmH.getIsFromMark()) {
            this.hmK.n(this.hmH.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bIM() {
        return this.hmL;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bIN() {
        if (this.hmH == null) {
            return false;
        }
        return this.hmH.bIN();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bIO() {
        if (this.hmH != null) {
            return this.hmH.bIO();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bIP() {
        if (this.hmH == null || this.hmH.getPbData() == null) {
            return 0;
        }
        return this.hmH.getPbData().bIi();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean zH(String str) {
        return this.hmH != null && this.hmH.zQ(str);
    }

    public void bJZ() {
        if (this.hmK != null) {
            this.hmK.bMj();
            bcL();
        }
    }

    public PostData bId() {
        return this.hmK.c(this.hmH.hsd, this.hmH.bKP());
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
        if (this.hno != null && !this.hno.isEmpty()) {
            int size = this.hno.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hno.get(i).onBackPressed()) {
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
            if (this.hno == null) {
                this.hno = new ArrayList();
            }
            if (!this.hno.contains(aVar)) {
                this.hno.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hno == null) {
                this.hno = new ArrayList();
            }
            if (!this.hno.contains(aVar)) {
                this.hno.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hno != null) {
            this.hno.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKa() {
        if (this.hmH != null && !com.baidu.tbadk.core.util.ap.isEmpty(this.hmH.bKO())) {
            com.baidu.tbadk.BdToken.c.TX().f(com.baidu.tbadk.BdToken.b.bqH, com.baidu.adp.lib.g.b.d(this.hmH.bKO(), 0L));
        }
    }
}
