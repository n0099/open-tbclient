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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PostPraiseView;
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
import com.baidu.tbadk.p.ax;
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
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
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
/* loaded from: classes6.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<PbActivity> {
    private com.baidu.adp.lib.e.b<TbImageView> aKN;
    private com.baidu.adp.lib.e.b<ImageView> brD;
    private com.baidu.adp.lib.e.b<TextView> brE;
    private com.baidu.adp.lib.e.b<View> brF;
    private com.baidu.adp.lib.e.b<LinearLayout> brG;
    private com.baidu.adp.lib.e.b<RelativeLayout> brH;
    private com.baidu.adp.lib.e.b<GifView> brI;
    private com.baidu.tbadk.core.util.b.a bzf;
    private com.baidu.tieba.f.b cvK;
    private com.baidu.tbadk.core.dialog.h dIO;
    private VoiceManager dIc;
    private com.baidu.tieba.pb.pb.main.b.b fSB;
    private com.baidu.tieba.pb.pb.main.emotion.model.a fSR;
    private View fSS;
    private com.baidu.tieba.pb.pb.report.a fSV;
    private String fSv;
    public at fTc;
    private y fTd;
    private boolean fTf;
    private com.baidu.tieba.tbadkCore.data.e fTi;
    private com.baidu.tbadk.editortools.pb.f fTj;
    private com.baidu.tbadk.editortools.pb.d fTk;
    private EmotionImageData fTm;
    private com.baidu.adp.base.e fTp;
    private com.baidu.tbadk.core.view.g fTq;
    private BdUniqueId fTr;
    private Runnable fTs;
    private av fTt;
    private com.baidu.adp.widget.ImageView.a fTu;
    private String fTv;
    private TbRichTextMemeInfo fTw;
    private List<a> fTz;
    private boolean fUb;
    private String fUm;
    private com.baidu.tbadk.core.data.m fUn;
    public com.baidu.tbadk.core.util.aj ffd;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.aCN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.aCN));
        }
    };
    private static final b.a fUh = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
        @Override // com.baidu.tieba.f.b.a
        public void fW(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bhb();
            } else {
                com.baidu.tieba.pb.a.b.bha();
            }
        }
    };
    private boolean fSA = false;
    private boolean fSC = false;
    private boolean fSD = false;
    private boolean fwf = false;
    private boolean fSE = true;
    private int fSF = 0;
    private com.baidu.tbadk.core.dialog.b fSG = null;
    private long doE = -1;
    private long bfV = 0;
    private long fSH = 0;
    private long createTime = 0;
    private long bfN = 0;
    private boolean fSI = false;
    private com.baidu.tbadk.l.b fSJ = null;
    private long fSK = 0;
    private boolean fSL = false;
    private long fSM = 0;
    private String aZV = null;
    private boolean fSN = false;
    private boolean isFullScreen = false;
    private String fSO = "";
    private boolean fSP = true;
    private boolean fSQ = false;
    private String source = "";
    private int mSkinType = 3;
    private PbInterviewStatusView.a fST = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void O(boolean z) {
            PbActivity.this.fSX.ll(!PbActivity.this.fSP);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.fSU != null && PbActivity.this.fSU.wq()) {
                        PbActivity.this.bhX();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel fSU = null;
    private com.baidu.tbadk.baseEditMark.a fSW = null;
    private ForumManageModel cVI = null;
    private com.baidu.tbadk.coreExtra.model.a aCb = null;
    private ShareSuccessReplyToServerModel dXG = null;
    private ar fSX = null;
    public final com.baidu.tieba.pb.pb.main.b.a fSY = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean fSZ = false;
    private boolean fTa = false;
    private boolean fTb = false;
    private boolean fTe = false;
    private boolean fTg = false;
    private boolean fTh = false;
    private boolean fTl = false;
    public boolean fTn = false;
    private com.baidu.tbadk.editortools.pb.c aZY = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Mv() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aZZ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Mu() {
            if (PbActivity.this.fTc == null || PbActivity.this.fTc.blM() == null || !PbActivity.this.fTc.blM().bMW()) {
                return !PbActivity.this.sd(com.baidu.tbadk.core.util.aj.aBW);
            }
            PbActivity.this.showToast(PbActivity.this.fTc.blM().bMY());
            if (PbActivity.this.fTk != null && (PbActivity.this.fTk.MJ() || PbActivity.this.fTk.MK())) {
                PbActivity.this.fTk.a(false, PbActivity.this.fTc.blP());
            }
            PbActivity.this.fTc.lx(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b fTo = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Mu() {
            if (PbActivity.this.fTc == null || PbActivity.this.fTc.blN() == null || !PbActivity.this.fTc.blN().bMW()) {
                return !PbActivity.this.sd(com.baidu.tbadk.core.util.aj.aBX);
            }
            PbActivity.this.showToast(PbActivity.this.fTc.blN().bMY());
            if (PbActivity.this.fSX != null && PbActivity.this.fSX.bkz() != null && PbActivity.this.fSX.bkz().biV() != null && PbActivity.this.fSX.bkz().biV().MK()) {
                PbActivity.this.fSX.bkz().biV().a(PbActivity.this.fTc.blP());
            }
            PbActivity.this.fTc.ly(true);
            return true;
        }
    };
    private int mLastScrollState = -1;
    private boolean dIK = false;
    private int fTx = 0;
    private int fTy = -1;
    private final a fTA = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.fSX != null && PbActivity.this.fSX.bkz() != null) {
                s bkz = PbActivity.this.fSX.bkz();
                if (bkz.biS()) {
                    bkz.biR();
                    return true;
                }
            }
            if (PbActivity.this.fSX != null && PbActivity.this.fSX.bls()) {
                PbActivity.this.fSX.blt();
                return true;
            }
            return false;
        }
    };
    private r.a fTB = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
    };
    private AddExperiencedModel.a dIT = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo == null || !contriInfo.isShowToast()) {
                PbActivity.this.bib();
            } else {
                PbActivity.this.a(contriInfo);
            }
        }
    };
    private final z.a fTC = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void P(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void j(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.fSX.showToast(str);
            }
        }
    };
    private final CustomMessageListener fTD = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fSU != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.fTk != null) {
                    PbActivity.this.fSX.lq(PbActivity.this.fTk.MD());
                }
                PbActivity.this.fSX.bkA();
                PbActivity.this.fSX.bll();
            }
        }
    };
    CustomMessageListener dJl = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                PbActivity.this.fSU.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                if (PbActivity.this.fSX != null && PbActivity.this.fSU != null) {
                    PbActivity.this.fSX.d(PbActivity.this.fSU.getPbData(), PbActivity.this.fSU.bje(), PbActivity.this.fSU.getRequestType());
                }
                if (PbActivity.this.fSX != null && PbActivity.this.fSX.bkR() != null) {
                    PbActivity.this.fSX.bkR().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fTE = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.fSX != null) {
                    if (booleanValue) {
                        PbActivity.this.fSX.aSv();
                    } else {
                        PbActivity.this.fSX.aSu();
                    }
                }
            }
        }
    };
    private CustomMessageListener fTF = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.fTk != null) {
                    PbActivity.this.fSX.lq(PbActivity.this.fTk.MD());
                }
                PbActivity.this.fSX.ls(false);
            }
        }
    };
    private CustomMessageListener fTG = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
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
    private CustomMessageListener fTH = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fSX != null && PbActivity.this.fSX.bkR() != null) {
                PbActivity.this.fSX.bkR().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener eJa = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener akA = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.fSD) {
                PbActivity.this.bir();
            }
        }
    };
    private h.a fTI = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void n(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.sf(2);
                aj.bkl().reset();
                PbActivity.this.fSU.bjw();
                boolean z2 = false;
                ArrayList<PostData> bgl = PbActivity.this.fSU.getPbData().bgl();
                if (bgl != null) {
                    Iterator<PostData> it = bgl.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (aq.k(next) && next.bDA().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.fSX.n(PbActivity.this.fSU.getPbData());
                    }
                    PbActivity.this.showToast(e.j.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(e.j.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(e.j.operation_failed);
        }
    };
    private View.OnClickListener baG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.aZV);
        }
    };
    private CustomMessageListener fTJ = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y)) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                am.a aVar = new am.a();
                aVar.giftId = yVar.id;
                aVar.giftName = yVar.name;
                aVar.thumbnailUrl = yVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fSU.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.fSU.bjn() != null && PbActivity.this.fSU.bjn().getUserIdLong() == yVar.toUserId) {
                        PbActivity.this.fSX.a(yVar.sendCount, PbActivity.this.fSU.getPbData(), PbActivity.this.fSU.bje(), PbActivity.this.fSU.getRequestType());
                    }
                    if (pbData.bgl() != null && pbData.bgl().size() >= 1 && pbData.bgl().get(0) != null) {
                        long d2 = com.baidu.adp.lib.g.b.d(pbData.bgl().get(0).getId(), 0L);
                        long d3 = com.baidu.adp.lib.g.b.d(PbActivity.this.fSU.bjd(), 0L);
                        if (d2 == yVar.postId && d3 == yVar.threadId) {
                            com.baidu.tbadk.core.data.am bDz = pbData.bgl().get(0).bDz();
                            if (bDz == null) {
                                bDz = new com.baidu.tbadk.core.data.am();
                            }
                            ArrayList<am.a> yR = bDz.yR();
                            if (yR == null) {
                                yR = new ArrayList<>();
                            }
                            yR.add(0, aVar);
                            bDz.setTotal(yVar.sendCount + bDz.getTotal());
                            bDz.k(yR);
                            pbData.bgl().get(0).a(bDz);
                            PbActivity.this.fSX.bkR().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eaE = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null) {
                PbActivity.this.sO((String) customResponsedMessage.getData());
                PbActivity.this.fSU.bjt();
                if (PbActivity.this.fSX.bkR() != null) {
                    PbActivity.this.fSX.n(PbActivity.this.fSU.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a fTK = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                if (aVar.avV() != null && !aVar.avV().isEmpty()) {
                    PbActivity.this.fSX.a(aVar, PbActivity.this.fTM);
                }
                PbActivity.this.fSX.a(aVar, PbActivity.this.fSU.getForumId());
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.blW()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a fTL = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void P(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.I(list) && PbActivity.this.fSX != null) {
                PbActivity.this.fSX.dn(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a fTM = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bJ(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.jA().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18.1
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
    private boolean fTN = false;
    private PraiseModel fTO = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void kc(String str) {
            PbActivity.this.fTN = false;
            if (PbActivity.this.fTO != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fSU.getPbData();
                if (pbData.bgj().zt().getIsLike() == 1) {
                    PbActivity.this.mV(0);
                } else {
                    PbActivity.this.mV(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bgj()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void M(int i, String str) {
            PbActivity.this.fTN = false;
            if (PbActivity.this.fTO != null && str != null) {
                if (AntiHelper.ai(i, str)) {
                    AntiHelper.aJ(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long fTP = 0;
    private boolean fTQ = true;
    private b.a fTR = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void kL(boolean z) {
            PbActivity.this.kK(z);
            if (PbActivity.this.fSX.bly() != null && z) {
                PbActivity.this.fSX.ll(false);
            }
            PbActivity.this.fSX.ln(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().aPr != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().aPr, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.aCN));
                        }
                    } else if (updateAttentionMessage.getData().Jr) {
                        if (PbActivity.this.bgq().zG() != null && PbActivity.this.bgq().zG().getGodUserData() != null) {
                            PbActivity.this.bgq().zG().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgj() != null && PbActivity.this.fSU.getPbData().bgj().zG() != null) {
                            PbActivity.this.fSU.getPbData().bgj().zG().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a cvb = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.fSX.akP();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.sg(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.aJG();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(e.j.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c brN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            PbActivity.this.bhH();
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == e.g.richText) {
                    if (PbActivity.this.bs(view)) {
                        return true;
                    }
                } else if (view.getId() == e.g.pb_floor_item_layout) {
                    if (view.getTag(e.g.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(e.g.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != e.g.pb_post_header_layout) {
                    if (PbActivity.this.fSX != null && PbActivity.this.fSX.bhF() && view.getId() == e.g.pb_head_user_info_root) {
                        if (view.getTag(e.g.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").aA(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(e.g.tag_user_id)));
                        }
                        if (PbActivity.this.fSY != null && PbActivity.this.fSY.eig != null) {
                            PbActivity.this.fSY.eig.onClick(view);
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
            if (PbActivity.this.fTk != null) {
                PbActivity.this.fSX.lq(PbActivity.this.fTk.MD());
            }
            PbActivity.this.fSX.bkA();
            PbActivity.this.fSX.bll();
            return true;
        }
    });
    private CustomMessageListener fTS = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fTr) {
                PbActivity.this.fSX.akP();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.fSU.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bgx().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fTq.e(PbActivity.this.fTp.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.fTp.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    PbActivity.this.hT(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bin();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ao.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.fTp.getResources().getString(e.j.mute_fail);
                    }
                    PbActivity.this.fTq.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fTT = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fTr) {
                PbActivity.this.fSX.akP();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.fTq.e(PbActivity.this.fTp.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ao.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.fTp.getResources().getString(e.j.un_mute_fail);
                }
                PbActivity.this.fTq.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fTU = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.fTr) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.fSX.akP();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.hzw;
                if (aVar.error == 0 && dataRes != null) {
                    int l = com.baidu.adp.lib.g.b.l(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = l == 1;
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        sparseArray.put(e.g.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(e.g.tag_user_mute_msg, str);
                    }
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(e.g.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(e.g.tag_from)).intValue();
                if (intValue == 0) {
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.fSX.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener fTV = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.fSX.bkB() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bhH();
            }
        }
    };
    private CustomMessageListener dJs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.dIK = true;
                }
            }
        }
    };
    public a.b fGX = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.aAY();
            com.baidu.tbadk.core.data.al pageData = PbActivity.this.fSU.getPageData();
            int pageNum = PbActivity.this.fSX.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(e.j.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.yK()) {
                PbActivity.this.fSX.bll();
                PbActivity.this.sf(2);
                PbActivity.this.aAX();
                PbActivity.this.fSX.bkV();
                if (com.baidu.adp.lib.util.j.kV()) {
                    PbActivity.this.fSU.sn(PbActivity.this.fSX.getPageNum());
                    if (PbActivity.this.fSB != null) {
                        PbActivity.this.fSB.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(e.j.pb_page_error);
            }
        }
    };
    public final View.OnClickListener dJU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Multi-variable search result rejected for r2v175, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v179, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v206, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v315, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            String name;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String str;
            int i;
            bg bgVar;
            String[] strArr;
            boolean p;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.fSX.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.fSU.kU(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.fSX.bkW();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bke()) {
                        if (view == PbActivity.this.fSX.gbT.bhS) {
                            if (PbActivity.this.fSX.lp(PbActivity.this.fSU.bjk())) {
                                PbActivity.this.aAX();
                                return;
                            }
                            PbActivity.this.fSE = false;
                            PbActivity.this.fSC = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.fSX.gbT.bhS);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.fSX.bkT() && (PbActivity.this.fSX.gbT.bmi() == null || (view != PbActivity.this.fSX.gbT.bmi().bkd() && view != PbActivity.this.fSX.gbT.bmi().bkb()))) {
                            if (view == PbActivity.this.fSX.blo()) {
                                if (PbActivity.this.fSU != null) {
                                    com.baidu.tbadk.browser.a.ad(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fSU.getPbData().bgj().zF().getLink());
                                }
                            } else if (view != PbActivity.this.fSX.gbT.ggU && view.getId() != e.g.view_forum_name) {
                                if (view == PbActivity.this.fSX.gbT.ggV) {
                                    if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null) {
                                        ArrayList<PostData> bgl = PbActivity.this.fSU.getPbData().bgl();
                                        if ((bgl == null || bgl.size() <= 0) && PbActivity.this.fSU.bje()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").aA("tid", PbActivity.this.fSU.bjd()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getForumId()));
                                        if (!PbActivity.this.fSX.blD()) {
                                            PbActivity.this.fSX.bkA();
                                        }
                                        PbActivity.this.bhP();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() != e.g.pb_god_user_tip_content) {
                                    if (PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bjP()) {
                                        if ((PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bka()) && view.getId() != e.g.floor_owner_reply && view.getId() != e.g.reply_title) {
                                            if (PbActivity.this.fSX.gbT.bmi() == null || (view != PbActivity.this.fSX.gbT.bmi().getCancelView() && view != PbActivity.this.fSX.gbT.bmi().bjZ())) {
                                                if (view != PbActivity.this.fSX.gbT.ggW && view.getId() != e.g.share_num_container) {
                                                    if (PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bjX()) {
                                                        if ((PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bkg()) && view.getId() != e.g.pb_sort) {
                                                            if (PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bjY()) {
                                                                if (PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bkh()) {
                                                                    if (PbActivity.this.fTd == null || view != PbActivity.this.fTd.bjR()) {
                                                                        if (PbActivity.this.fTd == null || view != PbActivity.this.fTd.bjP()) {
                                                                            if (PbActivity.this.fTd == null || view != PbActivity.this.fTd.bjS()) {
                                                                                if (PbActivity.this.fTd == null || view != PbActivity.this.fTd.bjT()) {
                                                                                    if (PbActivity.this.fTd == null || view != PbActivity.this.fTd.bjV()) {
                                                                                        if (PbActivity.this.fTd == null || view != PbActivity.this.fTd.bjW()) {
                                                                                            if (PbActivity.this.fTd == null || view != PbActivity.this.fTd.bjU()) {
                                                                                                if (PbActivity.this.fSX.bly() == view) {
                                                                                                    if (PbActivity.this.fSX.bly().getIndicateStatus()) {
                                                                                                        com.baidu.tieba.pb.data.d pbData = PbActivity.this.fSU.getPbData();
                                                                                                        if (pbData != null && pbData.bgj() != null && pbData.bgj().zn() != null) {
                                                                                                            String yg = pbData.bgj().zn().yg();
                                                                                                            if (StringUtils.isNull(yg)) {
                                                                                                                yg = pbData.bgj().zn().getTaskId();
                                                                                                            }
                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").aA(VideoPlayActivityConfig.OBJ_ID, yg));
                                                                                                        }
                                                                                                    } else {
                                                                                                        com.baidu.tieba.tbadkCore.d.a.cL("c10725", null);
                                                                                                    }
                                                                                                    PbActivity.this.bij();
                                                                                                } else if (PbActivity.this.fSX.bkQ() != view) {
                                                                                                    if (PbActivity.this.fTd == null || view != PbActivity.this.fTd.bjQ()) {
                                                                                                        if (PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bkf()) {
                                                                                                            if (PbActivity.this.fSX.gbT.bmi() != null && view == PbActivity.this.fSX.gbT.bmi().bkc()) {
                                                                                                                if (com.baidu.adp.lib.util.j.kV()) {
                                                                                                                    SparseArray<Object> c2 = PbActivity.this.fSX.c(PbActivity.this.fSU.getPbData(), PbActivity.this.fSU.bje(), 1);
                                                                                                                    if (c2 != null) {
                                                                                                                        if (StringUtils.isNull((String) c2.get(e.g.tag_del_multi_forum))) {
                                                                                                                            PbActivity.this.fSX.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                                        } else {
                                                                                                                            PbActivity.this.fSX.a(((Integer) c2.get(e.g.tag_del_post_type)).intValue(), (String) c2.get(e.g.tag_del_post_id), ((Integer) c2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(e.g.tag_del_post_is_self)).booleanValue(), (String) c2.get(e.g.tag_del_multi_forum));
                                                                                                                        }
                                                                                                                    }
                                                                                                                    PbActivity.this.fSX.gbT.dismissPopMenu();
                                                                                                                } else {
                                                                                                                    PbActivity.this.showToast(e.j.network_not_available);
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else if (view.getId() != e.g.sub_pb_more && view.getId() != e.g.sub_pb_item && view.getId() != e.g.pb_floor_reply_more && view.getId() != e.g.new_sub_pb_list_richText) {
                                                                                                                if (view != PbActivity.this.fSX.bhy()) {
                                                                                                                    if (view == PbActivity.this.fSX.gbT.bmj()) {
                                                                                                                        PbActivity.this.fSX.bld();
                                                                                                                    } else {
                                                                                                                        int id = view.getId();
                                                                                                                        if (id == e.g.pb_u9_text_view) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin() && (bgVar = (bg) view.getTag()) != null && !StringUtils.isNull(bgVar.Bu())) {
                                                                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                ay.Ef().c(PbActivity.this.getPageContext(), new String[]{bgVar.Bu()});
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.replybtn || id == e.g.cover_reply_content || id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right || id == e.g.image_more_tip) {
                                                                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                                                                PostData postData = null;
                                                                                                                                if (view != null && view.getTag() != null) {
                                                                                                                                    postData = (PostData) ((SparseArray) view.getTag()).get(e.g.tag_load_sub_data);
                                                                                                                                    if (PbActivity.this.fTd == null) {
                                                                                                                                        PbActivity.this.fTd = new y(PbActivity.this.getPageContext(), PbActivity.this.dJU);
                                                                                                                                        PbActivity.this.fSX.bE(PbActivity.this.fTd.getView());
                                                                                                                                        PbActivity.this.fTd.kY(PbActivity.this.mIsLogin);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fTd.showDialog();
                                                                                                                                    if (id == e.g.replybtn_top_right || id == e.g.cover_reply_content_top_right) {
                                                                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").aA("tid", PbActivity.this.fSU.fYa));
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray = new SparseArray();
                                                                                                                                    sparseArray.put(e.g.tag_clip_board, (PostData) ((SparseArray) view.getTag()).get(e.g.tag_clip_board));
                                                                                                                                    sparseArray.put(e.g.tag_is_subpb, false);
                                                                                                                                    PbActivity.this.fTd.bjP().setTag(sparseArray);
                                                                                                                                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                                                                    boolean booleanValue = ((Boolean) sparseArray2.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                                                                    boolean booleanValue2 = ((Boolean) sparseArray2.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                                                    boolean booleanValue3 = ((Boolean) sparseArray2.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                                                                    if (!(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                        z = false;
                                                                                                                                    } else {
                                                                                                                                        z = ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                    }
                                                                                                                                    String str2 = null;
                                                                                                                                    if (sparseArray2.get(e.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                        str2 = (String) sparseArray2.get(e.g.tag_forbid_user_post_id);
                                                                                                                                    }
                                                                                                                                    if (booleanValue) {
                                                                                                                                        SparseArray sparseArray3 = new SparseArray();
                                                                                                                                        sparseArray3.put(e.g.tag_should_manage_visible, true);
                                                                                                                                        sparseArray3.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_name, sparseArray2.get(e.g.tag_forbid_user_name));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_name_show, sparseArray2.get(e.g.tag_forbid_user_name_show));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_portrait, sparseArray2.get(e.g.tag_forbid_user_portrait));
                                                                                                                                        sparseArray3.put(e.g.tag_forbid_user_post_id, str2);
                                                                                                                                        if (booleanValue2) {
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_visible, true);
                                                                                                                                            sparseArray3.put(e.g.tag_is_mem, sparseArray2.get(e.g.tag_is_mem));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_userid, sparseArray2.get(e.g.tag_user_mute_mute_userid));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_username, sparseArray2.get(e.g.tag_user_mute_mute_username));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_mute_nameshow, sparseArray2.get(e.g.tag_user_mute_mute_nameshow));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_post_id, sparseArray2.get(e.g.tag_user_mute_post_id));
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_thread_id, sparseArray2.get(e.g.tag_user_mute_thread_id));
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        }
                                                                                                                                        if (booleanValue3) {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, true);
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                            sparseArray3.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                            PbActivity.this.fTd.bjS().setVisibility(0);
                                                                                                                                        } else {
                                                                                                                                            sparseArray3.put(e.g.tag_should_delete_visible, false);
                                                                                                                                            PbActivity.this.fTd.bjS().setVisibility(8);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fTd.bjQ().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fTd.bjS().setTag(sparseArray3);
                                                                                                                                        PbActivity.this.fTd.bjQ().setText(e.j.bar_manager);
                                                                                                                                        PbActivity.this.fTd.bjQ().setVisibility(0);
                                                                                                                                    } else if (!booleanValue3) {
                                                                                                                                        PbActivity.this.fTd.bjQ().setVisibility(8);
                                                                                                                                        PbActivity.this.fTd.bjS().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        SparseArray sparseArray4 = new SparseArray();
                                                                                                                                        sparseArray4.put(e.g.tag_should_manage_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_user_mute_visible, false);
                                                                                                                                        sparseArray4.put(e.g.tag_should_delete_visible, true);
                                                                                                                                        sparseArray4.put(e.g.tag_manage_user_identity, sparseArray2.get(e.g.tag_manage_user_identity));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_id, sparseArray2.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray4.put(e.g.tag_del_post_type, sparseArray2.get(e.g.tag_del_post_type));
                                                                                                                                        PbActivity.this.fTd.bjQ().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fTd.bjS().setTag(sparseArray4);
                                                                                                                                        PbActivity.this.fTd.bjQ().setText(e.j.delete);
                                                                                                                                        PbActivity.this.fTd.bjS().setVisibility(0);
                                                                                                                                        if (PbActivity.this.fSU.getPbData().bgv() != 1002 || z) {
                                                                                                                                            PbActivity.this.fTd.bjS().setText(e.j.delete);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fTd.bjS().setText(e.j.report_text);
                                                                                                                                        }
                                                                                                                                        PbActivity.this.fTd.bjQ().setVisibility(8);
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                                                    if (!(sparseArray5.get(e.g.tag_user_mute_visible) instanceof Boolean)) {
                                                                                                                                        z2 = false;
                                                                                                                                    } else {
                                                                                                                                        z2 = ((Boolean) sparseArray5.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                                                    }
                                                                                                                                    if (!((Boolean) sparseArray5.get(e.g.tag_should_manage_visible)).booleanValue() && z2) {
                                                                                                                                        SparseArray sparseArray6 = new SparseArray();
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_visible, true);
                                                                                                                                        sparseArray6.put(e.g.tag_is_mem, sparseArray5.get(e.g.tag_is_mem));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_userid, sparseArray5.get(e.g.tag_user_mute_mute_userid));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_username, sparseArray5.get(e.g.tag_user_mute_mute_username));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_mute_nameshow, sparseArray5.get(e.g.tag_user_mute_mute_nameshow));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_post_id, sparseArray5.get(e.g.tag_user_mute_post_id));
                                                                                                                                        sparseArray6.put(e.g.tag_user_mute_thread_id, sparseArray5.get(e.g.tag_user_mute_thread_id));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_is_self, sparseArray5.get(e.g.tag_del_post_is_self));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_type, sparseArray5.get(e.g.tag_del_post_type));
                                                                                                                                        sparseArray6.put(e.g.tag_del_post_id, sparseArray5.get(e.g.tag_del_post_id));
                                                                                                                                        sparseArray6.put(e.g.tag_manage_user_identity, sparseArray5.get(e.g.tag_manage_user_identity));
                                                                                                                                        PbActivity.this.fTd.bjR().setTag(sparseArray6);
                                                                                                                                        PbActivity.this.fTd.bjR().setVisibility(0);
                                                                                                                                        PbActivity.this.fTd.bjQ().setVisibility(8);
                                                                                                                                        PbActivity.this.fTd.bjR().setText(e.j.mute_option);
                                                                                                                                    } else {
                                                                                                                                        if (!(sparseArray5.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                                                                            z3 = false;
                                                                                                                                        } else {
                                                                                                                                            z3 = ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue();
                                                                                                                                        }
                                                                                                                                        String str3 = null;
                                                                                                                                        if (sparseArray5.get(e.g.tag_forbid_user_post_id) instanceof String) {
                                                                                                                                            str3 = (String) sparseArray5.get(e.g.tag_forbid_user_post_id);
                                                                                                                                        }
                                                                                                                                        boolean kG = PbActivity.this.kG(z3) & PbActivity.this.isLogin();
                                                                                                                                        PbActivity.this.fUe = (PostData) sparseArray5.get(e.g.tag_clip_board);
                                                                                                                                        if (aq.k(PbActivity.this.fUe) ? false : kG) {
                                                                                                                                            PbActivity.this.fTd.bjR().setVisibility(0);
                                                                                                                                            PbActivity.this.fTd.bjR().setTag(str3);
                                                                                                                                        } else {
                                                                                                                                            PbActivity.this.fTd.bjR().setVisibility(8);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                                                                                                                    long j = 0;
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                                                                        z4 = false;
                                                                                                                                    } else {
                                                                                                                                        z4 = ((Boolean) sparseArray7.get(e.g.tag_should_hide_chudian_visible)).booleanValue();
                                                                                                                                    }
                                                                                                                                    if (sparseArray7.get(e.g.tag_chudian_template_id) instanceof Long) {
                                                                                                                                        j = ((Long) sparseArray7.get(e.g.tag_chudian_template_id)).longValue();
                                                                                                                                    }
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_chudian_monitor_id) instanceof String)) {
                                                                                                                                        str = "";
                                                                                                                                    } else {
                                                                                                                                        str = (String) sparseArray7.get(e.g.tag_chudian_monitor_id);
                                                                                                                                    }
                                                                                                                                    if (!(sparseArray7.get(e.g.tag_chudian_hide_day) instanceof Integer)) {
                                                                                                                                        i = 0;
                                                                                                                                    } else {
                                                                                                                                        i = ((Integer) sparseArray7.get(e.g.tag_chudian_hide_day)).intValue();
                                                                                                                                    }
                                                                                                                                    if (z4) {
                                                                                                                                        PbActivity.this.fTd.bjU().setVisibility(0);
                                                                                                                                        PbActivity.this.fTd.bjU().setTag(e.g.tag_chudian_template_id, Long.valueOf(j));
                                                                                                                                        PbActivity.this.fTd.bjU().setTag(e.g.tag_chudian_monitor_id, str);
                                                                                                                                        PbActivity.this.fTd.bjU().setTag(e.g.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fTd.bjU().setVisibility(8);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                boolean z5 = false;
                                                                                                                                if (PbActivity.this.fSU.getPbData().wq()) {
                                                                                                                                    String wp = PbActivity.this.fSU.getPbData().wp();
                                                                                                                                    if (postData != null && !com.baidu.adp.lib.util.k.isEmpty(wp) && wp.equals(postData.getId())) {
                                                                                                                                        z5 = true;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (z5) {
                                                                                                                                    PbActivity.this.fTd.bjP().setText(e.j.remove_mark);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.fTd.bjP().setText(e.j.mark);
                                                                                                                                }
                                                                                                                                PbActivity.this.fTd.bjW().setVisibility(8);
                                                                                                                                PbActivity.this.fTd.bjV().setVisibility(8);
                                                                                                                                if (postData != null) {
                                                                                                                                    if (postData.bDt() == null || postData.bDt().toString().length() <= 0) {
                                                                                                                                        PbActivity.this.fTd.bjT().setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        PbActivity.this.fTd.bjT().setVisibility(0);
                                                                                                                                    }
                                                                                                                                    PbActivity.this.fUe = postData;
                                                                                                                                }
                                                                                                                                PbActivity.this.fTd.refreshUI();
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_act_btn) {
                                                                                                                            if (PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgj() != null && PbActivity.this.fSU.getPbData().bgj().getActUrl() != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), PbActivity.this.fSU.getPbData().bgj().getActUrl());
                                                                                                                                if (PbActivity.this.fSU.getPbData().bgj().Ak() != 1) {
                                                                                                                                    if (PbActivity.this.fSU.getPbData().bgj().Ak() == 2) {
                                                                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "pb");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.lottery_tail) {
                                                                                                                            if (view.getTag(e.g.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                                                String str4 = (String) view.getTag(e.g.tag_pb_lottery_tail_link);
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getPbData().getForumId()).aA("tid", PbActivity.this.fSU.getPbData().getThreadId()).aA("lotterytail", StringUtils.string(str4, BaseRequestAction.SPLITE, TbadkCoreApplication.getCurrentAccount())));
                                                                                                                                if (PbActivity.this.fSU.getPbData().getThreadId().equals(str4)) {
                                                                                                                                    PbActivity.this.fSX.setSelection(0);
                                                                                                                                } else {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.pb_item_tail_content) {
                                                                                                                            if (ba.bJ(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                                                String string = TbadkCoreApplication.getInst().getString(e.j.tail_web_view_title);
                                                                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                                                                if (!StringUtils.isNull(string2)) {
                                                                                                                                    TiebaStatic.log("c10056");
                                                                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                                                                }
                                                                                                                                PbActivity.this.fSX.bkA();
                                                                                                                            }
                                                                                                                        } else if (id == e.g.join_vote_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                if (PbActivity.this.bhM() == 1 && PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getPbData().getForumId()).aA("tid", PbActivity.this.fSU.getPbData().getThreadId()).aA("uid", currentAccount));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.look_all_tv) {
                                                                                                                            if (view != null) {
                                                                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                                                com.baidu.tbadk.browser.a.ad(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                                                                if (PbActivity.this.bhM() == 1 && PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null) {
                                                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getPbData().getForumId()).aA("tid", PbActivity.this.fSU.getPbData().getThreadId()).aA("uid", currentAccount2));
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.manga_prev_btn) {
                                                                                                                            PbActivity.this.bie();
                                                                                                                        } else if (id == e.g.manga_next_btn) {
                                                                                                                            PbActivity.this.bif();
                                                                                                                        } else if (id == e.g.yule_head_img_img) {
                                                                                                                            if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgD() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.fSU.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").aA(ImageViewerConfig.FORUM_ID, pbData2.getForumId()));
                                                                                                                                ay.Ef().c(PbActivity.this.getPageContext(), new String[]{pbData2.bgD().bgM()});
                                                                                                                            }
                                                                                                                        } else if (id == e.g.yule_head_img_all_rank) {
                                                                                                                            if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgD() != null) {
                                                                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.fSU.getPbData();
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").aA(ImageViewerConfig.FORUM_ID, pbData3.getForumId()));
                                                                                                                                ay.Ef().c(PbActivity.this.getPageContext(), new String[]{pbData3.bgD().bgM()});
                                                                                                                            }
                                                                                                                        } else if (PbActivity.this.fSX.gbT.bmi() != null && view == PbActivity.this.fSX.gbT.bmi().bki()) {
                                                                                                                            if (PbActivity.this.fSU == null || PbActivity.this.fSU.getPbData() == null || PbActivity.this.fSU.getPbData().bgj() == null) {
                                                                                                                                PbActivity.this.fSX.gbT.dismissPopMenu();
                                                                                                                                return;
                                                                                                                            } else if (!com.baidu.adp.lib.util.l.ll()) {
                                                                                                                                PbActivity.this.showToast(e.j.neterror);
                                                                                                                                return;
                                                                                                                            } else {
                                                                                                                                int i2 = 1;
                                                                                                                                if (PbActivity.this.fSU.getPbData().bgj().zo() == 0) {
                                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fSU.bjd(), 25028)));
                                                                                                                                } else {
                                                                                                                                    BdToast.a(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(e.j.haved_fans_called)).BN();
                                                                                                                                    i2 = 2;
                                                                                                                                }
                                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").x("obj_locate", PbActivity.this.al(PbActivity.this.fSU.getPbData().bgj())).aA("tid", PbActivity.this.fSU.getPbData().bgj().getTid()).x("obj_type", i2));
                                                                                                                            }
                                                                                                                        } else if (id == e.g.tv_pb_reply_more) {
                                                                                                                            if (PbActivity.this.fTx >= 0) {
                                                                                                                                if (PbActivity.this.fSU != null) {
                                                                                                                                    PbActivity.this.fSU.bjJ();
                                                                                                                                }
                                                                                                                                if (PbActivity.this.fSX.bkR() != null) {
                                                                                                                                    PbActivity.this.fSX.bkR().a(PbActivity.this.fSU.getPbData(), false);
                                                                                                                                }
                                                                                                                                PbActivity.this.fSX.getListView().setSelection(PbActivity.this.fSU.bjM());
                                                                                                                                PbActivity.this.fTx = 0;
                                                                                                                                if (PbActivity.this.fSU != null) {
                                                                                                                                    PbActivity.this.fSU.bx(0, 0);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else if (id == e.g.single_bar_tips) {
                                                                                                                            PbActivity.this.fSX.blH();
                                                                                                                        } else if (id == e.g.pb_post_recommend_live_layout) {
                                                                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                                                                TiebaStatic.log("c12640");
                                                                                                                            }
                                                                                                                        } else if (id == e.g.thread_info_commont_container) {
                                                                                                                            PbActivity.this.fSX.bkF();
                                                                                                                        } else if (id == e.g.new_sub_pb_list_richText) {
                                                                                                                            SparseArray sparseArray8 = null;
                                                                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                                                                sparseArray8 = (SparseArray) view.getTag();
                                                                                                                            }
                                                                                                                            if (sparseArray8 != null) {
                                                                                                                                PbActivity.this.c(sparseArray8);
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.d(PbActivity.this.fSU.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.d(PbActivity.this.fSU.bjd(), 0L), com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.fSU.getPbData().bgj().Ab())));
                                                                                                                }
                                                                                                            } else if (PbActivity.this.checkUpIsLogin()) {
                                                                                                                if (PbActivity.this.fSU.getPbData() != null) {
                                                                                                                    PbActivity.this.fSX.bll();
                                                                                                                    SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                                                                                    PostData postData2 = (PostData) sparseArray9.get(e.g.tag_load_sub_data);
                                                                                                                    View view2 = (View) sparseArray9.get(e.g.tag_load_sub_view);
                                                                                                                    if (postData2 != null && view2 != null) {
                                                                                                                        if (postData2.bDD() == 1) {
                                                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                                                        }
                                                                                                                        String bjd = PbActivity.this.fSU.bjd();
                                                                                                                        String id2 = postData2.getId();
                                                                                                                        int i3 = 0;
                                                                                                                        if (PbActivity.this.fSU.getPbData() != null) {
                                                                                                                            i3 = PbActivity.this.fSU.getPbData().bgv();
                                                                                                                        }
                                                                                                                        PbActivity.this.aAX();
                                                                                                                        if (view.getId() == e.g.replybtn) {
                                                                                                                            c sT = PbActivity.this.sT(id2);
                                                                                                                            if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && sT != null) {
                                                                                                                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bjd, id2, "pb", true, null, true, null, i3, postData2.bmX(), PbActivity.this.fSU.getPbData().yE(), false, postData2.zG().getIconInfo()).addBigImageData(sT.fUO, sT.fUP, sT.fUQ, sT.index);
                                                                                                                                addBigImageData.setKeyPageStartFrom(PbActivity.this.fSU.bjI());
                                                                                                                                addBigImageData.setFromFrsForumId(PbActivity.this.fSU.getFromForumId());
                                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            TiebaStatic.log("c11742");
                                                                                                                            c sT2 = PbActivity.this.sT(id2);
                                                                                                                            if (postData2 != null && PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && sT2 != null) {
                                                                                                                                SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bjd, id2, "pb", true, null, false, null, i3, postData2.bmX(), PbActivity.this.fSU.getPbData().yE(), false, postData2.zG().getIconInfo()).addBigImageData(sT2.fUO, sT2.fUP, sT2.fUQ, sT2.index);
                                                                                                                                addBigImageData2.setKeyPageStartFrom(PbActivity.this.fSU.bjI());
                                                                                                                                addBigImageData2.setFromFrsForumId(PbActivity.this.fSU.getFromForumId());
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
                                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 3).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getPbData().getForumId()));
                                                                                                                return;
                                                                                                            }
                                                                                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                                                                                            PbActivity.this.fSX.bll();
                                                                                                            SparseArray<Object> c3 = PbActivity.this.fSX.c(PbActivity.this.fSU.getPbData(), PbActivity.this.fSU.bje(), 1);
                                                                                                            if (c3 != null) {
                                                                                                                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fSU.getPbData().bgh().getId(), PbActivity.this.fSU.getPbData().bgh().getName(), PbActivity.this.fSU.getPbData().bgj().getId(), String.valueOf(PbActivity.this.fSU.getPbData().getUserData().getUserId()), (String) c3.get(e.g.tag_forbid_user_name), (String) c3.get(e.g.tag_forbid_user_name_show), (String) c3.get(e.g.tag_forbid_user_post_id), (String) c3.get(e.g.tag_forbid_user_portrait))));
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else {
                                                                                                            PbActivity.this.showToast(e.j.network_not_available);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else if (!com.baidu.adp.lib.util.j.kV()) {
                                                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        SparseArray<Object> sparseArray10 = (SparseArray) view.getTag();
                                                                                                        if (sparseArray10 != null) {
                                                                                                            boolean booleanValue4 = ((Boolean) sparseArray10.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                                            boolean booleanValue5 = ((Boolean) sparseArray10.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                                            boolean booleanValue6 = ((Boolean) sparseArray10.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                                            if (booleanValue4) {
                                                                                                                if (booleanValue6) {
                                                                                                                    sparseArray10.put(e.g.tag_from, 1);
                                                                                                                    sparseArray10.put(e.g.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.b(sparseArray10);
                                                                                                                } else {
                                                                                                                    sparseArray10.put(e.g.tag_check_mute_from, 2);
                                                                                                                    PbActivity.this.fSX.bC(view);
                                                                                                                }
                                                                                                            } else if (booleanValue5) {
                                                                                                                PbActivity.this.fSX.a(((Integer) sparseArray10.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray10.get(e.g.tag_del_post_id), ((Integer) sparseArray10.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                                            }
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                } else if (!PbActivity.this.checkUpIsLogin()) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getPbData().getForumId()));
                                                                                                    return;
                                                                                                } else {
                                                                                                    PbActivity.this.bhA();
                                                                                                }
                                                                                            } else {
                                                                                                long j2 = -1;
                                                                                                String str5 = "";
                                                                                                int i4 = 0;
                                                                                                if (view.getTag(e.g.tag_chudian_template_id) instanceof Long) {
                                                                                                    j2 = ((Long) view.getTag(e.g.tag_chudian_template_id)).longValue();
                                                                                                }
                                                                                                if (view.getTag(e.g.tag_chudian_monitor_id) instanceof String) {
                                                                                                    str5 = (String) view.getTag(e.g.tag_chudian_monitor_id);
                                                                                                }
                                                                                                if (view.getTag(e.g.tag_chudian_hide_day) instanceof Integer) {
                                                                                                    i4 = ((Integer) view.getTag(e.g.tag_chudian_hide_day)).intValue();
                                                                                                }
                                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.fSU.getPbData();
                                                                                                String str6 = null;
                                                                                                String str7 = null;
                                                                                                String str8 = null;
                                                                                                if (pbData4 != null && pbData4.bgh() != null) {
                                                                                                    str6 = pbData4.bgh().getId();
                                                                                                    str7 = pbData4.bgh().getName();
                                                                                                    str8 = pbData4.getThreadId();
                                                                                                }
                                                                                                com.baidu.tieba.pb.a.a(j2, str5, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str6, str7, str8);
                                                                                                PbActivity.this.a(j2, str5, str6, str7, str8, i4);
                                                                                            }
                                                                                        } else if (PbActivity.this.fTu != null && !TextUtils.isEmpty(PbActivity.this.fTv)) {
                                                                                            if (PbActivity.this.bzf == null) {
                                                                                                PbActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                                                                                            }
                                                                                            PbActivity.this.bzf.Et();
                                                                                            PbActivity.this.bzf.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                            if (!PbActivity.this.bzf.A(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                                if (PbActivity.this.fTt == null) {
                                                                                                    PbActivity.this.fTt = new av(PbActivity.this.getPageContext());
                                                                                                }
                                                                                                PbActivity.this.fTt.i(PbActivity.this.fTv, PbActivity.this.fTu.os());
                                                                                                PbActivity.this.fTu = null;
                                                                                                PbActivity.this.fTv = null;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.fTu != null && !TextUtils.isEmpty(PbActivity.this.fTv)) {
                                                                                        if (PbActivity.this.fTw == null) {
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fTv));
                                                                                        } else {
                                                                                            d.a aVar = new d.a();
                                                                                            aVar.url = PbActivity.this.fTv;
                                                                                            aVar.pkgId = PbActivity.this.fTw.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fTw.memeInfo.pck_id;
                                                                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                                        }
                                                                                        PbActivity.this.fTu = null;
                                                                                        PbActivity.this.fTv = null;
                                                                                    }
                                                                                } else if (PbActivity.this.fUe != null) {
                                                                                    PbActivity.this.fUe.cZ(PbActivity.this.getPageContext().getPageActivity());
                                                                                    PbActivity.this.fUe = null;
                                                                                }
                                                                            } else {
                                                                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                                                                if (sparseArray11 != null) {
                                                                                    if ((sparseArray11.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_id) instanceof String) && (sparseArray11.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray11.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                                        PbActivity.this.fSX.a(((Integer) sparseArray11.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray11.get(e.g.tag_del_post_id), ((Integer) sparseArray11.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").x("obj_locate", 2));
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                PbActivity.this.bu(view);
                                                                                if (PbActivity.this.fSU.getPbData().bgj() != null && PbActivity.this.fSU.getPbData().bgj().zG() != null && PbActivity.this.fSU.getPbData().bgj().zG().getUserId() != null && PbActivity.this.fSW != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").aA("tid", PbActivity.this.fSU.fYa).x("obj_locate", 2).aA(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fSU.getPbData().bgj().zG().getUserId()).x("obj_type", PbActivity.this.fSW.wq() ? 0 : 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fSU.getPbData())));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (!com.baidu.adp.lib.util.j.kV()) {
                                                                        PbActivity.this.showToast(e.j.network_not_available);
                                                                        return;
                                                                    } else {
                                                                        Object tag = view.getTag();
                                                                        if (tag instanceof String) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13079"));
                                                                            PbActivity.this.sQ((String) tag);
                                                                        } else if (tag instanceof SparseArray) {
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").x("obj_locate", 4));
                                                                            SparseArray<Object> sparseArray12 = (SparseArray) tag;
                                                                            if ((sparseArray12.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray12.get(e.g.tag_user_mute_visible)).booleanValue()) {
                                                                                sparseArray12.put(e.g.tag_from, 0);
                                                                                sparseArray12.put(e.g.tag_check_mute_from, 2);
                                                                                PbActivity.this.b(sparseArray12);
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                                    if (skinType == 1) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(0);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").x("obj_type", 0).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    } else if (skinType == 0) {
                                                                        PbActivity.this.onChangeSkinType(skinType);
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").x("obj_type", 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                                    }
                                                                    PbActivity.this.fSX.gbT.bmh();
                                                                }
                                                            } else if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgj() != null) {
                                                                PbActivity.this.fSX.gbT.dismissPopMenu();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                                PbActivity.this.sQ(PbActivity.this.fSU.getPbData().bgj().zX());
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            PbActivity.this.fSX.bll();
                                                            if (com.baidu.adp.lib.util.j.kV()) {
                                                                if (PbActivity.this.mIsLoading) {
                                                                    view.setTag(Integer.valueOf(PbActivity.this.fSU.bjr()));
                                                                    return;
                                                                }
                                                                PbActivity.this.sf(2);
                                                                PbActivity.this.aAX();
                                                                PbActivity.this.fSX.bkV();
                                                                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(PbActivity.this.getPageContext().getPageActivity());
                                                                if (PbActivity.this.fSU.getPbData().fQu == null || PbActivity.this.fSU.getPbData().fQu.size() <= 0) {
                                                                    strArr = new String[]{PbActivity.this.getResources().getString(e.j.sort_type_new), PbActivity.this.getResources().getString(e.j.sort_type_old)};
                                                                } else {
                                                                    String[] strArr2 = new String[PbActivity.this.fSU.getPbData().fQu.size()];
                                                                    int i5 = 0;
                                                                    while (true) {
                                                                        int i6 = i5;
                                                                        if (i6 >= PbActivity.this.fSU.getPbData().fQu.size()) {
                                                                            break;
                                                                        }
                                                                        strArr2[i6] = PbActivity.this.fSU.getPbData().fQu.get(i6).sort_name + PbActivity.this.getResources().getString(e.j.sort_static);
                                                                        i5 = i6 + 1;
                                                                    }
                                                                    strArr = strArr2;
                                                                }
                                                                bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                                                                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i7, View view3) {
                                                                        int i8 = 2;
                                                                        if (PbActivity.this.fSU.abZ() == 1 && i7 == 1) {
                                                                            i8 = 0;
                                                                        } else if (PbActivity.this.fSU.abZ() == 2 && i7 == 0) {
                                                                            i8 = 1;
                                                                        } else if (PbActivity.this.fSU.abZ() != 3 || i7 == 2) {
                                                                            i8 = (i7 != 2 || PbActivity.this.fSU.abZ() == 3) ? 0 : 3;
                                                                        }
                                                                        TiebaStatic.log("c12097");
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != e.g.pb_sort ? 1 : 0).x("obj_type", i8));
                                                                        if (PbActivity.this.fSU.getPbData().fQu != null && PbActivity.this.fSU.getPbData().fQu.size() > i7) {
                                                                            i7 = PbActivity.this.fSU.getPbData().fQu.get(i7).sort_type.intValue();
                                                                        }
                                                                        boolean ss = PbActivity.this.fSU.ss(i7);
                                                                        view.setTag(Integer.valueOf(PbActivity.this.fSU.bjr()));
                                                                        if (ss) {
                                                                            PbActivity.this.mIsLoading = true;
                                                                            PbActivity.this.fSX.lg(true);
                                                                        }
                                                                        bVar2.dismiss();
                                                                    }
                                                                });
                                                                bVar.d(PbActivity.this.getPageContext()).BI();
                                                            } else {
                                                                PbActivity.this.showToast(e.j.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        PbActivity.this.fSX.bll();
                                                        if (PbActivity.this.bhn().getPbData().fQv != 2) {
                                                            if (PbActivity.this.fSU.getPageData() != null) {
                                                                PbActivity.this.fSX.a(PbActivity.this.fSU.getPageData(), PbActivity.this.fGX);
                                                            }
                                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            PbActivity.this.showToast(e.j.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (ax.jJ() || PbActivity.this.checkUpIsLogin()) {
                                                    if (PbActivity.this.fSU != null) {
                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12386");
                                                        amVar.aA("tid", PbActivity.this.fSU.bjd());
                                                        amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                                                        amVar.aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getForumId());
                                                        amVar.x("obj_locate", 6);
                                                        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        TiebaStatic.log(amVar);
                                                    }
                                                    if (com.baidu.adp.lib.util.l.ll()) {
                                                        if (PbActivity.this.fSU.getPbData() != null) {
                                                            ArrayList<PostData> bgl2 = PbActivity.this.fSU.getPbData().bgl();
                                                            if ((bgl2 != null && bgl2.size() > 0) || !PbActivity.this.fSU.bje()) {
                                                                PbActivity.this.fSX.bll();
                                                                PbActivity.this.aAX();
                                                                PbActivity.this.sf(2);
                                                                if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgD() != null && !StringUtils.isNull(PbActivity.this.fSU.getPbData().bgD().ys(), true)) {
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getPbData().getForumId()));
                                                                }
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                                if (ax.jJ()) {
                                                                    PbActivity.this.sg(2);
                                                                } else {
                                                                    PbActivity.this.fSX.showLoadingDialog();
                                                                    PbActivity.this.fSU.bjD().j(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                                }
                                                            } else {
                                                                com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(e.j.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        PbActivity.this.showToast(e.j.neterror);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.fSX.gbT.dismissPopMenu();
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                            PbActivity.this.fSX.bll();
                                            if (PbActivity.this.fSX.gbT.bmi() != null && view == PbActivity.this.fSX.gbT.bmi().bka() && !PbActivity.this.fSX.blD()) {
                                                PbActivity.this.fSX.bkA();
                                            }
                                            if (!PbActivity.this.mIsLoading) {
                                                PbActivity.this.aAX();
                                                PbActivity.this.fSX.bkV();
                                                if (view.getId() == e.g.floor_owner_reply) {
                                                    p = PbActivity.this.fSU.p(true, PbActivity.this.bic());
                                                } else {
                                                    p = view.getId() == e.g.reply_title ? PbActivity.this.fSU.p(false, PbActivity.this.bic()) : PbActivity.this.fSU.sU(PbActivity.this.bic());
                                                }
                                                view.setTag(Boolean.valueOf(p));
                                                if (p) {
                                                    PbActivity.this.fSX.kP(true);
                                                    PbActivity.this.fSX.aSv();
                                                    PbActivity.this.mIsLoading = true;
                                                    PbActivity.this.fSX.lg(true);
                                                }
                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                                PbActivity.this.sf(2);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbActivity.this.showToast(e.j.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.kV()) {
                                        PbActivity.this.fSX.bll();
                                        if (PbActivity.this.se(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.fSU.st(PbActivity.this.fSX.bla()) != null) {
                                            PbActivity.this.bhW();
                                            if (PbActivity.this.fSU.getPbData().bgj() != null && PbActivity.this.fSU.getPbData().bgj().zG() != null && PbActivity.this.fSU.getPbData().bgj().zG().getUserId() != null && PbActivity.this.fSW != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").aA("tid", PbActivity.this.fSU.fYa).x("obj_locate", 1).aA(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.fSU.getPbData().bgj().zG().getUserId()).x("obj_type", PbActivity.this.fSW.wq() ? 0 : 1).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.d(PbActivity.this.fSU.getPbData())));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(e.j.network_not_available);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.kV()) {
                                    PbActivity.this.fSX.kP(true);
                                    PbActivity.this.fSX.bkA();
                                    if (!PbActivity.this.mIsLoading) {
                                        PbActivity.this.mIsLoading = true;
                                        PbActivity.this.fSX.aSv();
                                        PbActivity.this.aAX();
                                        PbActivity.this.fSX.bkV();
                                        PbActivity.this.fSU.sU(PbActivity.this.bic());
                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        PbActivity.this.sf(2);
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(e.j.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgj() != null && PbActivity.this.fSU.getPbData().bgj().Au() && PbActivity.this.fSU.getPbData().bgj().zY() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.fSU.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.fSU.bhe()) && PbActivity.this.fSU.getAppealInfo() != null) {
                                        name = PbActivity.this.fSU.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.fSU.getPbData().bgh().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bhe = PbActivity.this.fSU.bhe();
                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.fSU.bjf() && bhe != null && bhe.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.kV()) {
                            if (PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgv() == 1 && !PbActivity.this.cVI.bEc()) {
                                PbActivity.this.fSX.bll();
                                int i7 = 0;
                                if (PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bkb()) {
                                    if (PbActivity.this.fSX.gbT.bmi() == null || view != PbActivity.this.fSX.gbT.bmi().bkd()) {
                                        if (view == PbActivity.this.fSX.bkT()) {
                                            i7 = 2;
                                        }
                                    } else if (PbActivity.this.fSU.getPbData().bgj().zC() == 1) {
                                        i7 = 3;
                                    } else {
                                        i7 = 6;
                                    }
                                } else if (PbActivity.this.fSU.getPbData().bgj().zB() == 1) {
                                    i7 = 5;
                                } else {
                                    i7 = 4;
                                }
                                ForumData bgh = PbActivity.this.fSU.getPbData().bgh();
                                String name2 = bgh.getName();
                                String id3 = bgh.getId();
                                String id4 = PbActivity.this.fSU.getPbData().bgj().getId();
                                PbActivity.this.fSX.bkS();
                                PbActivity.this.cVI.a(id3, name2, id4, i7, PbActivity.this.fSX.bkU());
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(e.j.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.kV()) {
                        PbActivity.this.fSX.bll();
                        PbActivity.this.aAX();
                        PbActivity.this.fSX.bkV();
                        PbActivity.this.fSX.showLoadingDialog();
                        if (PbActivity.this.fSX.bkI() != null) {
                            PbActivity.this.fSX.bkI().setVisibility(8);
                        }
                        PbActivity.this.fSU.sn(1);
                        if (PbActivity.this.fSB != null) {
                            PbActivity.this.fSB.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(e.j.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(e.j.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == e.g.reply_god_title_group) {
                        String bhJ = PbActivity.this.bhJ();
                        if (!TextUtils.isEmpty(bhJ)) {
                            ay.Ef().c(PbActivity.this.getPageContext(), new String[]{bhJ});
                        }
                    }
                } else if (PbActivity.this.fSL) {
                    PbActivity.this.fSL = false;
                } else {
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(e.g.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData3 = (PostData) obj;
                            if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.bhE().bky() != null && postData3.zG() != null && postData3.bDr() != 1 && PbActivity.this.checkUpIsLogin()) {
                                if (PbActivity.this.bhE().bkz() != null) {
                                    PbActivity.this.bhE().bkz().biQ();
                                }
                                com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                                jVar.a(PbActivity.this.fSU.getPbData().bgh());
                                jVar.aa(PbActivity.this.fSU.getPbData().bgj());
                                jVar.e(postData3);
                                PbActivity.this.bhE().bky().d(jVar);
                                PbActivity.this.bhE().bky().setPostId(postData3.getId());
                                PbActivity.this.a(view, postData3.zG().getUserId(), "");
                                TiebaStatic.log("c11743");
                                if (PbActivity.this.fTk != null) {
                                    PbActivity.this.fSX.lq(PbActivity.this.fTk.MD());
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d baf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.w wVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null) {
                    amVar.aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getPbData().getForumId());
                }
                if (PbActivity.this.fSU != null) {
                    amVar.aA("tid", PbActivity.this.fSU.bjd());
                }
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.aAX();
            PbActivity.this.fSX.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.p.ao.PB() && PbActivity.this.bhn() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bhn().sX(postWriteCallBackData.getPostId());
                    PbActivity.this.fTx = PbActivity.this.fSX.bkD();
                    if (PbActivity.this.fSU != null) {
                        PbActivity.this.fSU.bx(PbActivity.this.fTx, PbActivity.this.fSX.bkE());
                    }
                }
                PbActivity.this.fSX.bll();
                PbActivity.this.fTc.blL();
                if (PbActivity.this.fTk != null) {
                    PbActivity.this.fSX.lq(PbActivity.this.fTk.MD());
                }
                PbActivity.this.fSX.bkx();
                PbActivity.this.fSX.ls(true);
                PbActivity.this.fSU.bjt();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.fSU.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.fSU.getPbData();
                            if (pbData != null && pbData.bgj() != null && pbData.bgj().zG() != null && (userId = pbData.bgj().zG().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.p.ao.PB() && PbActivity.this.fSU.bjm()) {
                                PbActivity.this.fSX.bkV();
                            }
                        } else if (!com.baidu.tbadk.p.ao.PB() && PbActivity.this.fSU.bjm()) {
                            PbActivity.this.fSX.bkV();
                        }
                    } else if (floor != null) {
                        PbActivity.this.fSX.n(PbActivity.this.fSU.getPbData());
                    }
                    if (PbActivity.this.fSU.bji()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").aA("tid", PbActivity.this.fSU.bjd()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.fTk.MJ() || PbActivity.this.fTk.MK()) {
                    PbActivity.this.fTk.a(false, postWriteCallBackData);
                }
                PbActivity.this.fTc.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.ffd != null) {
                    PbActivity.this.ffd.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (wVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d fTW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.w wVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null) {
                    amVar.aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getPbData().getForumId());
                }
                if (PbActivity.this.fSU != null) {
                    amVar.aA("tid", PbActivity.this.fSU.bjd());
                }
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    PbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
                if (PbActivity.this.fTc != null) {
                    PbActivity.this.fTc.blK();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.ffd != null) {
                    PbActivity.this.ffd.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.fTc != null) {
                if (PbActivity.this.fSX != null && PbActivity.this.fSX.bkz() != null && PbActivity.this.fSX.bkz().biV() != null && PbActivity.this.fSX.bkz().biV().MK()) {
                    PbActivity.this.fSX.bkz().biV().a(postWriteCallBackData);
                }
                PbActivity.this.fTc.g(postWriteCallBackData);
            }
        }
    };
    private final PbModel.a fTX = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g fH;
            if (!z || dVar == null || dVar.bgt() != null || com.baidu.tbadk.core.util.v.H(dVar.bgl()) >= 1) {
                PbActivity.this.fwf = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.fSX.bkX();
                if (dVar == null || !dVar.bgp()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.fSX.getView());
                }
                PbActivity.this.fSX.aSu();
                if (PbActivity.this.isFullScreen || PbActivity.this.fSX.blD()) {
                    PbActivity.this.fSX.blu();
                } else if (!PbActivity.this.fSX.blr()) {
                    PbActivity.this.fSX.ls(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.fTe = true;
                    PbActivity.this.hideNetRefreshView(PbActivity.this.fSX.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.fSX.amN();
                    if (dVar.bgj() != null && dVar.bgj().AB() != null) {
                        PbActivity.this.a(dVar.bgj().AB());
                    }
                    PbActivity.this.bhB();
                    if (PbActivity.this.fTk != null) {
                        PbActivity.this.fSX.lq(PbActivity.this.fTk.MD());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bgl() != null && dVar.bgl().size() >= 1 && dVar.bgl().get(0) != null) {
                        PbActivity.this.fSU.sW(dVar.bgl().get(0).getId());
                    } else if (dVar.bgt() != null) {
                        PbActivity.this.fSU.sW(dVar.bgt().getId());
                    }
                    if (PbActivity.this.fTk != null) {
                        PbActivity.this.fTk.a(dVar.yE());
                        PbActivity.this.fTk.a(dVar.bgh(), dVar.getUserData());
                        PbActivity.this.fTk.a(PbActivity.this.fSU.bjn(), PbActivity.this.fSU.bjd(), PbActivity.this.fSU.bjF());
                        if (dVar.bgj() != null) {
                            PbActivity.this.fTk.cx(dVar.bgj().AR());
                        }
                    }
                    if (PbActivity.this.fSW != null) {
                        PbActivity.this.fSW.aP(dVar.wq());
                    }
                    if (dVar == null || dVar.bgw() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.fSX.lr(PbActivity.this.mIsFromCDN);
                    PbActivity.this.fSX.a(dVar, i2, i3, PbActivity.this.fSU.bje(), i4, PbActivity.this.fSU.getIsFromMark());
                    PbActivity.this.fSX.d(dVar, PbActivity.this.fSU.bje());
                    PbActivity.this.fSX.lo(PbActivity.this.fSU.getHostMode());
                    AntiData yE = dVar.yE();
                    if (yE != null) {
                        PbActivity.this.aZV = yE.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.aZV) && PbActivity.this.fTk != null && PbActivity.this.fTk.LX() != null && (fH = PbActivity.this.fTk.LX().fH(6)) != null && !TextUtils.isEmpty(PbActivity.this.aZV)) {
                            ((View) fH).setOnClickListener(PbActivity.this.baG);
                        }
                    }
                    if (PbActivity.this.fTg) {
                        PbActivity.this.fTg = false;
                        final int bhR = PbActivity.this.bhR();
                        if (dVar.bgI()) {
                            final int aO = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bhR, aO);
                                    }
                                }
                            });
                        } else {
                            PbActivity.this.bhE().sz(bhR);
                        }
                    }
                    if (PbActivity.this.fTh) {
                        PbActivity.this.fTh = false;
                        final int bhR2 = PbActivity.this.bhR();
                        final boolean z2 = bhR2 != -1;
                        if (!z2) {
                            bhR2 = PbActivity.this.bhS();
                        }
                        if (PbActivity.this.bhE() != null) {
                            if (dVar.bgI()) {
                                final int aO2 = (int) (com.baidu.adp.lib.util.l.aO(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bhR2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.getListView().setSelectionFromTop(bhR2, aO2);
                                            } else {
                                                PbActivity.this.getListView().setSelectionFromTop(bhR2 - 1, aO2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.bhE().lt(true);
                            } else {
                                PbActivity.this.bhE().sz(bhR2);
                            }
                        }
                    } else {
                        PbActivity.this.fSX.blb();
                    }
                    PbActivity.this.fSU.a(dVar.bgh(), PbActivity.this.fTK);
                    PbActivity.this.fSU.a(PbActivity.this.fTL);
                    if (PbActivity.this.ffd != null && dVar.bgj() != null && dVar.bgj().zG() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bgj().zG());
                        PbActivity.this.ffd.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.fTe && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.fSU != null && PbActivity.this.fSU.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.fSU.getAppealInfo().fPM)) {
                                    PbActivity.this.fSX.a(PbActivity.this.fSU.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.fSX.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.fSX.getView(), PbActivity.this.getPageContext().getResources().getString(e.j.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
                            }
                            PbActivity.this.fSX.blu();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.fSU.bjd());
                            jSONObject.put(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getForumId());
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
                        PbActivity.this.fSX.ta(PbActivity.this.getResources().getString(e.j.list_no_more_new));
                    } else {
                        PbActivity.this.fSX.ta("");
                    }
                    PbActivity.this.fSX.Fd();
                }
                PbActivity.this.bfV = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bhn().bje() || PbActivity.this.bhn().getPbData().yS().yQ() != 0 || PbActivity.this.bhn().bjz()) {
                    PbActivity.this.fTl = true;
                    return;
                }
                return;
            }
            PbActivity.this.fSU.sn(1);
            if (PbActivity.this.fSB != null) {
                PbActivity.this.fSB.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void f(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.fSX.n(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.l.m.Pk().Pl()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.doE : j;
                com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, PbActivity.this.bfN, PbActivity.this.createTime, PbActivity.this.bfV, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.bfN = 0L;
                if (iVar != null) {
                    iVar.Ph();
                }
                if (z2) {
                    iVar.bge = currentTimeMillis;
                    iVar.cL(true);
                }
                if (!z2 && PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgj() != null) {
                    int threadType = PbActivity.this.fSU.getPbData().bgj().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fSO, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ao.equals(PbActivity.this.fSO, "from_frs")) {
                                com.baidu.tbadk.l.i iVar2 = new com.baidu.tbadk.l.i();
                                iVar2.gi(1000);
                                iVar2.bgg = currentTimeMillis;
                                iVar2.gj(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.l.d dVar = new com.baidu.tbadk.l.d();
                        dVar.pageType = 1;
                        dVar.gi(1005);
                        dVar.bgg = currentTimeMillis;
                        dVar.gj(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener fTY = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bhN();
            }
        }
    };
    private final a.InterfaceC0154a fTZ = new a.InterfaceC0154a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
        public void a(boolean z, boolean z2, String str) {
            PbActivity.this.fSX.bkX();
            if (z) {
                if (PbActivity.this.fSW != null) {
                    PbActivity.this.fSW.aP(z2);
                }
                PbActivity.this.fSU.kW(z2);
                if (PbActivity.this.fSU.wq()) {
                    PbActivity.this.bhX();
                } else {
                    PbActivity.this.fSX.n(PbActivity.this.fSU.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.fSW != null && PbActivity.this.fSW.wt() != null && PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgj() != null && PbActivity.this.fSU.getPbData().bgj().zG() != null) {
                        MarkData wt = PbActivity.this.fSW.wt();
                        MetaData zG = PbActivity.this.fSU.getPbData().bgj().zG();
                        if (wt != null && zG != null) {
                            if (!com.baidu.tbadk.core.util.ao.equals(TbadkCoreApplication.getCurrentAccount(), zG.getUserId()) && !zG.hadConcerned()) {
                                PbActivity.this.b(zG);
                                return;
                            } else {
                                PbActivity.this.showToast(e.j.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(e.j.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.sb(PbActivity.this.mLastScrollState) && PbActivity.this.sb(i)) {
                if (PbActivity.this.fSX != null) {
                    PbActivity.this.fSX.bll();
                    if (PbActivity.this.fTk != null && !PbActivity.this.fSX.bkB()) {
                        PbActivity.this.fSX.lq(PbActivity.this.fTk.MD());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.fSX.bkA();
                    }
                }
                if (!PbActivity.this.fSI) {
                    PbActivity.this.fSI = true;
                    PbActivity.this.fSX.blq();
                }
            }
            PbActivity.this.fSX.onScrollStateChanged(absListView, i);
            if (PbActivity.this.fSB != null) {
                PbActivity.this.fSB.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.fSJ == null) {
                PbActivity.this.fSJ = new com.baidu.tbadk.l.b();
                PbActivity.this.fSJ.gi(1001);
            }
            if (i == 0) {
                PbActivity.this.fSJ.Pb();
            } else {
                PbActivity.this.fSJ.Pa();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bgl;
            if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSX != null && PbActivity.this.fSX.bkR() != null) {
                PbActivity.this.fSX.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.fSB != null) {
                    PbActivity.this.fSB.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.fSU.bjv() && (bgl = PbActivity.this.fSU.getPbData().bgl()) != null && !bgl.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.fSX.bkR().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.fSU.getPbData();
                    if (pbData != null) {
                        if (pbData.bgm() != null && pbData.bgm().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bgn() != null && pbData.bgn().hasData()) {
                            headerCount--;
                        }
                        int size = bgl.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d cVM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.cVI.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.fSU.bjt();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.giK != 1002 || bVar.eni) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.fSX.a(1, dVar.HZ, dVar.hnI, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.cVI.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.fSX.a(PbActivity.this.cVI.getLoadDataMode(), gVar.HZ, gVar.hnI, false);
                        PbActivity.this.fSX.ap(gVar.hnL);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.fSX.a(PbActivity.this.cVI.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d fUa = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
    };
    private final j.b bDz = new j.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            if (PbActivity.this.bid()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.fSU.kV(true)) {
                PbActivity.this.fSX.bkY();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e ebe = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.fUb && PbActivity.this.bid()) {
                PbActivity.this.bif();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.fSU.kU(false)) {
                    PbActivity.this.fSX.bkW();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.fSU.getPbData() != null) {
                    PbActivity.this.fSX.blp();
                }
                PbActivity.this.fUb = true;
            }
        }
    };
    private int fUc = 0;
    private final TbRichTextView.h brM = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
        /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z) {
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.fSX.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(e.g.tag_rich_text_meme_info) != null && (view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    PbActivity.this.fSS = view;
                    return;
                }
                c cVar = new c();
                PbActivity.this.a(str, i, cVar);
                if (cVar.fUR) {
                    TbRichText aL = PbActivity.this.aL(str, i);
                    if (aL != null && PbActivity.this.fUc >= 0 && PbActivity.this.fUc < aL.RZ().size()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        String b2 = com.baidu.tieba.pb.data.e.b(aL.RZ().get(PbActivity.this.fUc));
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cVar.fUO.size()) {
                                break;
                            } else if (!cVar.fUO.get(i3).equals(b2)) {
                                i2 = i3 + 1;
                            } else {
                                cVar.index = i3;
                                arrayList.add(b2);
                                break;
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!com.baidu.tbadk.core.util.v.I(arrayList)) {
                            String str2 = arrayList.get(0);
                            concurrentHashMap.put(str2, cVar.fUP.get(str2));
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fUQ, cVar.lastId, PbActivity.this.fSU.bjq(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbActivity.this.l(rect);
                        createConfig.setIsHotSort(PbActivity.this.fSU.abZ() == 2);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(com.baidu.tbadk.core.util.v.d(cVar.fUO, 0));
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                if (!com.baidu.tbadk.core.util.v.I(arrayList2)) {
                    String str3 = (String) arrayList2.get(0);
                    concurrentHashMap2.put(str3, cVar.fUP.get(str3));
                }
                ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.fUQ, cVar.fUO.get(0), PbActivity.this.fSU.bjq(), concurrentHashMap2, true, false, z);
                createConfig2.getIntent().putExtra("from", "pb");
                createConfig2.setIsCanDrag(false);
                createConfig2.setIsHotSort(PbActivity.this.fSU.abZ() == 2);
                PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean fUd = false;
    PostData fUe = null;
    private final b.InterfaceC0158b fUf = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fUe != null) {
                if (i == 0) {
                    PbActivity.this.fUe.cZ(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.fUe = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.fUe);
                }
            }
        }
    };
    private final b.InterfaceC0158b fUg = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (PbActivity.this.fTu != null && !TextUtils.isEmpty(PbActivity.this.fTv)) {
                if (i == 0) {
                    if (PbActivity.this.fTw == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.fTv));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.fTv;
                        aVar.pkgId = PbActivity.this.fTw.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.fTw.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.bzf == null) {
                        PbActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.bzf.Et();
                    PbActivity.this.bzf.c(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.bzf.A(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fTt == null) {
                            PbActivity.this.fTt = new av(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fTt.i(PbActivity.this.fTv, PbActivity.this.fTu.os());
                    } else {
                        return;
                    }
                }
                PbActivity.this.fTu = null;
                PbActivity.this.fTv = null;
            }
        }
    };
    private final View.OnLongClickListener aTo = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        /* JADX WARN: Removed duplicated region for block: B:122:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0190  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            SparseArray<Object> sparseArray;
            boolean z;
            SparseArray<Object> sparseArray2;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (PbActivity.this.bv(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.fTu = ((TbImageView) view).getBdImage();
                        PbActivity.this.fTv = ((TbImageView) view).getUrl();
                        if (PbActivity.this.fTu != null && !TextUtils.isEmpty(PbActivity.this.fTv)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fTw = null;
                            } else {
                                PbActivity.this.fTw = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                PbActivity.this.fSX.a(PbActivity.this.fUg, PbActivity.this.fTu.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                sparseArray = sparseArray2;
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.fTu = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.fTv = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.fTw = null;
                            } else {
                                PbActivity.this.fTw = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.fTu = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.fTv = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.fTw = null;
                        } else {
                            PbActivity.this.fTw = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                        }
                    }
                    if (!(view.getParent() instanceof TbRichTextView)) {
                    }
                    if (sparseArray2 != null) {
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 != null) {
                }
                return true;
            }
            PbActivity.this.fUe = (PostData) sparseArray.get(e.g.tag_clip_board);
            if (PbActivity.this.fUe != null) {
                if (PbActivity.this.fUe.bDr() != 1 || !PbActivity.this.bv(view)) {
                    if (PbActivity.this.fSW != null) {
                        boolean z2 = PbActivity.this.fSW.wq() && PbActivity.this.fUe.getId() != null && PbActivity.this.fUe.getId().equals(PbActivity.this.fSU.zQ());
                        if (view == null || sparseArray == null) {
                            z = false;
                        } else {
                            if (PbActivity.this.fTd == null) {
                                PbActivity.this.fTd = new y(PbActivity.this.getPageContext(), PbActivity.this.dJU);
                                PbActivity.this.fSX.bE(PbActivity.this.fTd.getView());
                                PbActivity.this.fTd.kY(PbActivity.this.mIsLogin);
                            }
                            if (PbActivity.this.fUe.bDr() == 1) {
                                PbActivity.this.fSX.a(PbActivity.this.fUf, z2, false);
                            } else {
                                PbActivity.this.fTd.showDialog();
                                z = PbActivity.this.kG(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & PbActivity.this.isLogin();
                            }
                        }
                        boolean booleanValue = sparseArray.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            PbActivity.this.fTd.bjP().setText(e.j.remove_mark);
                        } else {
                            PbActivity.this.fTd.bjP().setText(e.j.mark);
                        }
                        if (booleanValue) {
                            PbActivity.this.fTd.bjP().setVisibility(8);
                        } else {
                            PbActivity.this.fTd.bjP().setVisibility(0);
                        }
                        if (PbActivity.this.bv(view)) {
                            if (PbActivity.this.fTu != null && !PbActivity.this.fTu.isGif()) {
                                sparseArray.put(e.g.tag_richtext_image, true);
                            } else {
                                sparseArray.put(e.g.tag_richtext_image, false);
                            }
                            sparseArray.put(e.g.tag_richtext_emotion, true);
                        } else {
                            sparseArray.put(e.g.tag_richtext_image, false);
                            sparseArray.put(e.g.tag_richtext_emotion, false);
                        }
                        PbActivity.this.fTd.a(sparseArray, PbActivity.this.fSU.getPbData().bgv(), z);
                        PbActivity.this.fTd.refreshUI();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").aA("tid", PbActivity.this.fSU.fYa).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getForumId()).aA("uid", PbActivity.this.fSU.getPbData().bgj().zG().getUserId()).aA("post_id", PbActivity.this.fSU.Ms()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, booleanValue ? 2 : 1));
                    }
                } else {
                    PbActivity.this.fSX.a(PbActivity.this.fUg, PbActivity.this.fTu.isGif());
                }
            }
            return true;
        }
    };
    private final NoNetworkView.a dFP = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (!PbActivity.this.fSD && z && !PbActivity.this.fSU.bjl()) {
                PbActivity.this.bhZ();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(PbActivity.this.getApplicationContext(), e.C0210e.ds200));
        }
    };
    public View.OnTouchListener biM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.cvK.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0214a cvL = new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
        final int cHa;

        {
            this.cHa = (int) PbActivity.this.getResources().getDimension(e.C0210e.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void aq(int i, int i2) {
            if (ag(i2) && PbActivity.this.fSX != null && PbActivity.this.fSB != null) {
                PbActivity.this.fSX.blv();
                PbActivity.this.fSB.gN(false);
                PbActivity.this.fSB.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (ag(i2) && PbActivity.this.fSX != null && PbActivity.this.fSB != null) {
                PbActivity.this.fSB.gN(true);
                if (Math.abs(i2) > this.cHa) {
                    PbActivity.this.fSB.hideFloatingView();
                }
                if (PbActivity.this.bid()) {
                    PbActivity.this.fSX.bkN();
                    PbActivity.this.fSX.bkO();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String fUi = null;
    private final m.a fUj = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void k(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(e.j.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(e.j.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.fUi = str2;
                PbActivity.this.fSX.tb(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int fUk = -1;
    private int fUl = -1;
    private CustomMessageListener fUo = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.aoH == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0156a) {
                    if (aVar.aoI != null && !aVar.aoI.hasError() && aVar.aoI.getError() == 0) {
                        if (PbActivity.this.fSX != null) {
                            PbActivity.this.fSX.n(((a.C0156a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bio();
                        }
                    } else if (z) {
                        if (aVar.aoI != null && aVar.aoI.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aoI.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.aoI != null && !aVar.aoI.hasError() && aVar.aoI.getError() == 0) {
                        if (PbActivity.this.fSX != null && PbActivity.this.fSX != null) {
                            PbActivity.this.fSX.n(((a.C0156a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.aoI != null && aVar.aoI.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.aoI.getErrorString());
                        } else {
                            PbActivity.this.showToast(e.j.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.aoI == null || aVar.aoI.hasError() || aVar.aoI.getError() != 0) {
                        if (z) {
                            if (aVar.aoI != null && aVar.aoI.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.aoI.getErrorString());
                            } else {
                                PbActivity.this.showToast(e.j.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_need_push), 1).show();
                    }
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void m(Object obj);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public ArrayList<String> fUO;
        public ConcurrentHashMap<String, ImageUrlData> fUP;
        public boolean fUR;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean fUQ = false;
        public boolean fUS = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes6.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d bhz() {
        return this.fTk;
    }

    public void b(com.baidu.tieba.pb.data.j jVar) {
        MetaData metaData;
        boolean z = true;
        if (jVar.bgQ() != null) {
            String id = jVar.bgQ().getId();
            ArrayList<PostData> bgl = this.fSU.getPbData().bgl();
            int i = 0;
            while (true) {
                if (i >= bgl.size()) {
                    break;
                }
                PostData postData = bgl.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bgU = jVar.bgU();
                    postData.vu(jVar.getTotalCount());
                    if (postData.bDo() != null && bgU != null) {
                        Iterator<PostData> it = bgU.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.zG() != null && (metaData = postData.getUserMap().get(next.zG().getUserId())) != null) {
                                next.a(metaData);
                                next.nu(true);
                                next.a(getPageContext(), this.fSU.sV(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bgU.size() != postData.bDo().size();
                        postData.bDo().clear();
                        postData.bDo().addAll(bgU);
                        z = z2;
                    }
                    if (postData.bDk() != null) {
                        postData.bDl();
                    }
                }
            }
            if (!this.fSU.getIsFromMark() && z) {
                this.fSX.n(this.fSU.getPbData());
            }
            if (z) {
                c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sO(String str) {
        com.baidu.tieba.tbadkCore.data.l bgz;
        if (!TextUtils.isEmpty(str) && (bgz = this.fSU.getPbData().bgz()) != null && str.equals(bgz.getAdId())) {
            if (bgz.bDf() != null) {
                bgz.bDf().legoCard = null;
            }
            this.fSU.getPbData().bgA();
        }
    }

    public void bhA() {
        com.baidu.tieba.pb.data.d pbData;
        bb bgj;
        if (!this.fTN) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                showToast(e.j.no_network_guide);
            } else if (this.fTQ) {
                this.fTN = true;
                if (this.fSU != null && (pbData = this.fSU.getPbData()) != null && (bgj = pbData.bgj()) != null) {
                    int isLike = bgj.zt() == null ? 0 : bgj.zt().getIsLike();
                    if (isLike == 0) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10796").aA("tid", bgj.getId()));
                    }
                    if (this.fTO != null) {
                        this.fTO.a(bgj.zX(), bgj.getId(), isLike, "pb");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer)) {
            final String str = (String) sparseArray.get(e.g.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
                bVar.de(e.j.operation);
                int i = -1;
                if (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    String[] strArr = new String[2];
                    strArr[0] = getResources().getString(e.j.delete);
                    strArr[1] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    PbActivity.this.fSX.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                    break;
                                case 1:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fTr);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fTr);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                } else {
                    String[] strArr2 = new String[1];
                    strArr2[0] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
                    bVar.a(strArr2, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                        public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                            switch (i2) {
                                case 0:
                                    String str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                                    userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(e.g.tag_user_mute_thread_id), (String) sparseArray.get(e.g.tag_user_mute_post_id), 1, str, PbActivity.this.fTr);
                                    userMuteAddAndDelCustomMessage.setTag(PbActivity.this.fTr);
                                    PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow));
                                    break;
                            }
                            bVar2.dismiss();
                        }
                    });
                }
                bVar.d(getPageContext()).BI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV(int i) {
        bb bgj;
        String str;
        String U;
        if (this.fSU != null && this.fSU.getPbData() != null && (bgj = this.fSU.getPbData().bgj()) != null) {
            if (i == 1) {
                PraiseData zt = bgj.zt();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (zt == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bgj.a(praiseData);
                    } else {
                        bgj.zt().getUser().add(0, metaData);
                        bgj.zt().setNum(bgj.zt().getNum() + 1);
                        bgj.zt().setIsLike(i);
                    }
                }
                if (bgj.zt() != null) {
                    if (bgj.zt().getNum() < 1) {
                        U = getResources().getString(e.j.zan);
                    } else {
                        U = com.baidu.tbadk.core.util.ao.U(bgj.zt().getNum());
                    }
                    this.fSX.W(U, true);
                }
            } else if (bgj.zt() != null) {
                bgj.zt().setIsLike(i);
                bgj.zt().setNum(bgj.zt().getNum() - 1);
                ArrayList<MetaData> user = bgj.zt().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bgj.zt().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bgj.zt().getNum() < 1) {
                    str = getResources().getString(e.j.zan);
                } else {
                    str = bgj.zt().getNum() + "";
                }
                this.fSX.W(str, false);
            }
            if (this.fSU.bje()) {
                this.fSX.bkR().notifyDataSetChanged();
            } else {
                this.fSX.o(this.fSU.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fSU.G(bundle);
        if (this.dIc != null) {
            this.dIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.fTk.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.fSH = System.currentTimeMillis();
        this.fTp = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.doE = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.fSO = intent.getStringExtra("from");
            if (StringUtils.isNull(this.fSO) && intent.getData() != null) {
                this.fSO = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.fSO)) {
                this.fSC = true;
            }
            this.fUk = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.fUl = intent.getIntExtra("key_manga_next_chapter", -1);
            this.fUm = intent.getStringExtra("key_manga_title");
            this.fTg = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.fTh = intent.getBooleanExtra("key_jump_to_comment_area", false);
            if (bid()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ao.isEmpty(this.source) ? "" : this.source;
            this.fTy = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.doE = System.currentTimeMillis();
        }
        this.bfN = this.fSH - this.doE;
        super.onCreate(bundle);
        this.fSF = 0;
        F(bundle);
        if (this.fSU != null && this.fSU.getPbData() != null) {
            this.fSU.getPbData().sM(this.source);
        }
        initUI();
        if (intent != null && this.fSX != null) {
            this.fSX.gbM = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.fTs == null) {
                    this.fTs = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.fSX.td("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.fTs, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.fSU != null && this.fSU.getPbData() != null) {
                this.fSU.sY(stringExtra);
            }
        }
        this.dIc = new VoiceManager();
        this.dIc.onCreate(getPageContext());
        initData(bundle);
        this.fTj = new com.baidu.tbadk.editortools.pb.f();
        bhB();
        this.fTk = (com.baidu.tbadk.editortools.pb.d) this.fTj.bM(getActivity());
        this.fTk.b(this);
        this.fTk.a(this.baf);
        this.fTk.a(this.aZY);
        this.fTk.a(this, bundle);
        this.fTk.LX().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.fTk.LX().cq(true);
        kF(true);
        this.fSX.setEditorTools(this.fTk.LX());
        this.fTk.a(this.fSU.bjn(), this.fSU.bjd(), this.fSU.bjF());
        registerListener(this.fTF);
        if (!this.fSU.bjk()) {
            this.fTk.hO(this.fSU.bjd());
        }
        if (this.fSU.bjG()) {
            this.fTk.hM(getPageContext().getString(e.j.pb_reply_hint_from_smart_frs));
        } else {
            this.fTk.hM(getPageContext().getString(e.j.pb_reply_hint));
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.fTE);
        registerListener(this.fTG);
        registerListener(this.fTH);
        registerListener(this.dJl);
        registerListener(this.fTV);
        registerListener(this.fTD);
        this.fTi = new com.baidu.tieba.tbadkCore.data.e("pb", com.baidu.tieba.tbadkCore.data.e.hkM);
        this.fTi.bCS();
        registerListener(this.fTJ);
        registerListener(this.mAttentionListener);
        if (this.fSU != null) {
            this.fSU.bjx();
        }
        registerListener(this.fTY);
        registerListener(this.fUo);
        registerListener(this.dJs);
        if (this.fSX != null && this.fSX.blz() != null && this.fSX.blA() != null) {
            this.fSB = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.fSX.blz(), this.fSX.blA(), this.fSX.bkI());
            this.fSB.a(this.fTR);
        }
        if (this.fSA && this.fSX != null && this.fSX.blA() != null) {
            this.fSX.blA().setVisibility(8);
        }
        this.fTq = new com.baidu.tbadk.core.view.g();
        this.fTq.aHc = 1000L;
        registerListener(this.fTU);
        registerListener(this.fTS);
        registerListener(this.fTT);
        registerListener(this.eaE);
        registerListener(this.akA);
        this.fTr = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.fTr;
        userMuteAddAndDelCustomMessage.setTag(this.fTr);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.fTr;
        userMuteCheckCustomMessage.setTag(this.fTr);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.fSU.bjD().a(this.cvb);
        this.fTc = new at();
        if (this.fTk.Mw() != null) {
            this.fTc.g(this.fTk.Mw().getInputView());
        }
        this.fTk.a(this.aZZ);
        this.dXG = new ShareSuccessReplyToServerModel();
        a(this.fTA);
        this.ffd = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.ffd.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.aBW) {
                        PbActivity.this.fTk.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.aBX && PbActivity.this.fSX != null && PbActivity.this.fSX.bkz() != null && PbActivity.this.fSX.bkz().biV() != null) {
                        PbActivity.this.fSX.bkz().biV().MP();
                    } else if (i == com.baidu.tbadk.core.util.aj.aBY) {
                        PbActivity.this.c(PbActivity.this.fTm);
                    }
                }
            }
        });
        this.fSV = new com.baidu.tieba.pb.pb.report.a(this);
        this.fSV.o(getUniqueId());
        this.createTime = System.currentTimeMillis() - this.fSH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhB() {
        if (this.fTj != null && this.fSU != null) {
            this.fTj.setForumName(this.fSU.bhe());
            if (this.fSU.getPbData() != null && this.fSU.getPbData().bgh() != null) {
                this.fTj.a(this.fSU.getPbData().bgh());
            }
            this.fTj.setFrom("pb");
            this.fTj.a(this.fSU);
        }
    }

    public String bhC() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bhD() {
        return this.fSB;
    }

    private void kF(boolean z) {
        this.fTk.cu(z);
        this.fTk.cv(z);
        this.fTk.cw(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgI() && !z && this.fSX != null && this.fSX.getView() != null) {
            this.fSX.getView().setSystemUiVisibility(4);
        }
        this.fTn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dIc != null) {
            this.dIc.onStart(getPageContext());
        }
    }

    public ar bhE() {
        return this.fSX;
    }

    public PbModel bhn() {
        return this.fSU;
    }

    public void sP(String str) {
        if (this.fSU != null && !StringUtils.isNull(str) && this.fSX != null) {
            this.fSX.lv(true);
            this.fSU.sP(str);
            this.fSN = true;
            this.fSX.bll();
            this.fSX.blu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.fSD = false;
        } else {
            this.fSD = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.fSF = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.fSF == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.dIc != null) {
            this.dIc.onPause(getPageContext());
        }
        if (this.fSX != null) {
            this.fSX.onPause();
        }
        if (!this.fSU.bjk()) {
            this.fTk.hN(this.fSU.bjd());
        }
        if (this.fSU != null) {
            this.fSU.bjy();
        }
        com.baidu.tbadk.BdToken.c.vu().vv();
        MessageManager.getInstance().unRegisterListener(this.eJa);
        aMe();
        MessageManager.getInstance().unRegisterListener(this.fTS);
        MessageManager.getInstance().unRegisterListener(this.fTT);
        MessageManager.getInstance().unRegisterListener(this.fTU);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bhF() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.fSU.getPbData(), this.fSU.bje(), this.fSU.getRequestType());
        return (a2 == null || a2.zG() == null || a2.zG().getGodUserData() == null || a2.zG().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.fSD = false;
        super.onResume();
        if (this.fSQ) {
            this.fSQ = false;
            bij();
        }
        if (bhF()) {
            this.fSK = System.currentTimeMillis();
        } else {
            this.fSK = -1L;
        }
        if (this.fSX != null && this.fSX.getView() != null) {
            if (!this.fwf) {
                bia();
            } else {
                hideLoadingView(this.fSX.getView());
            }
            this.fSX.onResume();
        }
        if (this.fSF == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.fSX != null) {
            noNetworkView = this.fSX.bkw();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.kV()) {
            noNetworkView.bE(false);
        }
        if (this.dIc != null) {
            this.dIc.onResume(getPageContext());
        }
        registerListener(this.eJa);
        this.fTf = false;
        bii();
        registerListener(this.fTS);
        registerListener(this.fTT);
        registerListener(this.fTU);
        if (this.dIK) {
            bhZ();
            this.dIK = false;
        }
        bir();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fSX.lj(z);
        if (this.fTd != null) {
            this.fTd.kY(z);
        }
        if (z && this.fTf) {
            this.fSX.bkW();
            this.fSU.kU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fSK > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").aA("obj_duration", (System.currentTimeMillis() - this.fSK) + ""));
            this.fSK = 0L;
        }
        if (bhE().bkz() != null) {
            bhE().bkz().onStop();
        }
        if (this.fSX.gbT != null && !this.fSX.gbT.aqk()) {
            this.fSX.gbT.aXt();
        }
        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgh() != null && this.fSU.getPbData().bgj() != null) {
            com.baidu.tbadk.distribute.a.LK().a(getPageContext().getPageActivity(), "pb", this.fSU.getPbData().bgh().getId(), com.baidu.adp.lib.g.b.d(this.fSU.getPbData().bgj().getId(), 0L));
        }
        if (this.dIc != null) {
            this.dIc.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aA(ImageViewerConfig.FORUM_ID, this.fSU.getPbData().getForumId());
            amVar.aA("tid", this.fSU.bjd());
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.fSI && this.fSX != null) {
            this.fSI = true;
            this.fSX.blq();
            a(false, (PostData) null);
        }
        if (this.fSU != null) {
            this.fSU.cancelLoadData();
            this.fSU.destory();
            if (this.fSU.bjC() != null) {
                this.fSU.bjC().onDestroy();
            }
        }
        if (this.fTk != null) {
            this.fTk.onDestroy();
        }
        if (this.cVI != null) {
            this.cVI.cancelLoadData();
        }
        if (this.fSX != null) {
            this.fSX.onDestroy();
            if (this.fSX.gbT != null) {
                this.fSX.gbT.aXt();
            }
        }
        if (this.fSJ != null) {
            this.fSJ.Pc();
        }
        if (this.fSB != null) {
            this.fSB.Qc();
        }
        super.onDestroy();
        if (this.dIc != null) {
            this.dIc.onDestory(getPageContext());
        }
        this.fSX.bll();
        MessageManager.getInstance().unRegisterListener(this.fTS);
        MessageManager.getInstance().unRegisterListener(this.fTT);
        MessageManager.getInstance().unRegisterListener(this.fTU);
        MessageManager.getInstance().unRegisterListener(this.fTr);
        MessageManager.getInstance().unRegisterListener(this.fTV);
        MessageManager.getInstance().unRegisterListener(this.dJs);
        MessageManager.getInstance().unRegisterListener(this.eaE);
        this.fTp = null;
        this.fTq = null;
        com.baidu.tieba.recapp.d.a.bvo().bvq();
        if (this.fTs != null) {
            getSafeHandler().removeCallbacks(this.fTs);
        }
        if (this.fSR != null) {
            this.fSR.cancelLoadData();
        }
        if (this.fSX != null && this.fSX.gbT != null) {
            this.fSX.gbT.bmm();
        }
        if (this.dXG != null) {
            this.dXG.cancelLoadData();
        }
        this.fTc.onDestroy();
        if (this.dIO != null) {
            this.dIO.onDestroy();
        }
        if (this.fSU != null && this.fSU.bjE() != null) {
            this.fSU.bjE().onDestroy();
        }
        if (this.ffd != null) {
            this.ffd.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bkR;
        ArrayList<PostData> biH;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.Gt() && this.fSX != null && (bkR = this.fSX.bkR()) != null && (biH = bkR.biH()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = biH.iterator();
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
                        bVar.cXH = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.auk == 1 && !TextUtils.isEmpty(id)) {
                    next.auk = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.cXH = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.fSU == null || this.fSU.getPbData() == null || this.fSU.getPbData().bgh() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.fSU.getPbData().bgh().getFirst_class();
                    str2 = this.fSU.getPbData().bgh().getSecond_class();
                    str = this.fSU.getPbData().bgh().getId();
                    str4 = this.fSU.bjd();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.Gw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.fSX.onChangeSkinType(i);
            if (this.fTk != null && this.fTk.LX() != null) {
                this.fTk.LX().onChangeSkinType(i);
            }
            if (this.fSX.bkw() != null) {
                this.fSX.bkw().onChangeSkinType(getPageContext(), i);
            }
            this.fTc.onChangeSkinType();
            if (this.dIO != null) {
                this.dIO.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.fSX = new ar(this, this.dJU, this.brN);
        this.cvK = new com.baidu.tieba.f.b(getActivity());
        this.cvK.a(fUh);
        this.cvK.a(this.cvL);
        this.fSX.setOnScrollListener(this.mOnScrollListener);
        this.fSX.e(this.ebe);
        this.fSX.a(this.bDz);
        this.fSX.kz(com.baidu.tbadk.core.i.xE().xI());
        this.fSX.setOnImageClickListener(this.brM);
        this.fSX.b(this.aTo);
        this.fSX.h(this.dFP);
        this.fSX.a(this.fUa);
        this.fSX.lj(this.mIsLogin);
        if (getIntent() != null) {
            this.fSX.lw(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.fSX.bky().setFromForumId(this.fSU.getFromForumId());
    }

    public void bhG() {
        if (this.fSX != null && this.fSU != null) {
            if (this.fSU.getPbData() != null || this.fSU.getPbData().bgH() != null) {
                TiebaStatic.log(bhK().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_locate", 4).x(VideoPlayActivityConfig.OBJ_ID, bhn().getPbData().bgH().bgN() ? 0 : 1));
                if (checkUpIsLogin() && this.fSX.bkR() != null && this.fSX.bkR().biM() != null) {
                    this.fSX.bkR().biM().gq(this.fSU.bjd());
                }
            }
        }
    }

    public void bhH() {
        TiebaStatic.log("c12181");
        if (this.fSX != null && this.fSU != null) {
            if (this.fSX == null || this.fSX.bkB()) {
                if (this.fSU.getPbData() != null || this.fSU.getPbData().bgH() != null) {
                    com.baidu.tieba.pb.data.i bgH = this.fSU.getPbData().bgH();
                    TiebaStatic.log(bhK().x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_locate", 4).x(VideoPlayActivityConfig.OBJ_ID, bgH.bgN() ? 0 : 1));
                    if (checkUpIsLogin()) {
                        if ((!bgH.bgN() || bgH.AV() != 2) && this.fSX.bkR() != null && this.fSX.bkR().biM() != null) {
                            this.fSX.bkR().biM().gq(this.fSU.bjd());
                        }
                        if (System.currentTimeMillis() - this.fSM > SystemScreenshotManager.DELAY_TIME) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).lR(false);
                            this.fSM = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(e.g.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.hlo && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.xE().xI()) {
                    return sS(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.fSU == null || this.fSU.getPbData() == null) {
                        return true;
                    }
                    if (bhE().bkz() != null) {
                        bhE().bkz().biQ();
                    }
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.a(this.fSU.getPbData().bgh());
                    jVar.aa(this.fSU.getPbData().bgj());
                    jVar.e(postData);
                    bhE().bky().d(jVar);
                    bhE().bky().setPostId(postData.getId());
                    a(view, postData.zG().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.fTk != null) {
                        this.fSX.lq(this.fTk.MD());
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
        if (this.fSX != null) {
            if (z && !this.fwf) {
                bia();
            } else {
                hideLoadingView(this.fSX.getView());
            }
            if (z && this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgI() && this.fSX.getView() != null) {
                this.fSX.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bhI() {
        if (this.fSG == null) {
            this.fSG = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.fSG.a(new String[]{getPageContext().getString(e.j.call_phone), getPageContext().getString(e.j.sms_phone), getPageContext().getString(e.j.search_in_baidu)}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.fSv = PbActivity.this.fSv.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fSv);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fSU.bjd(), PbActivity.this.fSv, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.fSv = PbActivity.this.fSv.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fSv);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.fSU.bjd(), PbActivity.this.fSv, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.fSv = PbActivity.this.fSv.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fSv);
                        bVar.dismiss();
                    }
                }
            }).df(b.a.awO).dg(17).d(getPageContext());
        }
    }

    private void F(Bundle bundle) {
        this.fSU = new PbModel(this);
        this.fSU.a(this.fTX);
        if (this.fSU.bjB() != null) {
            this.fSU.bjB().a(this.fUj);
        }
        if (this.fSU.bjA() != null) {
            this.fSU.bjA().a(this.fTI);
        }
        if (this.fSU.bjC() != null) {
            this.fSU.bjC().b(this.fTC);
        }
        if (bundle != null) {
            this.fSU.initWithBundle(bundle);
        } else {
            this.fSU.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.fSU.kX(true);
        }
        aj.bkl().V(this.fSU.bjc(), this.fSU.getIsFromMark());
        if (StringUtils.isNull(this.fSU.bjd())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.fSO) && this.fSO != null) {
            this.fSU.su(6);
        }
        this.fSU.Ow();
    }

    private void initData(Bundle bundle) {
        this.fSW = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fSW != null) {
            this.fSW.a(this.fTZ);
        }
        this.cVI = new ForumManageModel(this);
        this.cVI.setLoadDataCallBack(this.cVM);
        this.aCb = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.fSX.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    PbActivity.this.showToast(e.j.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.fSU.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.fSU.getPbData().bgh().getId(), PbActivity.this.fSU.getPbData().bgh().getName(), PbActivity.this.fSU.getPbData().bgj().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.fTO.setUniqueId(getUniqueId());
        this.fTO.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.fSX.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d((String) sparseArray.get(e.g.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.fTr;
        userMuteCheckCustomMessage.setTag(this.fTr);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bhJ() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.fSU != null && (pbData = this.fSU.getPbData()) != null) {
            return pbData.bgu().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bgj() != null) {
            if (dVar.bgj().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bgj().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bgj().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    public PostData bt(View view) {
        PostData postData;
        if (checkUpIsLogin() && (postData = (PostData) view.getTag(e.g.tag_clip_board)) != null) {
            if (view instanceof PostPraiseView) {
                ((PostPraiseView) view).L(view);
                return postData;
            }
            return postData;
        }
        return null;
    }

    public com.baidu.tbadk.core.util.am bhK() {
        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12003");
        amVar.aA("tid", this.fSU.fYa);
        amVar.x("obj_type", 0);
        amVar.aA(ImageViewerConfig.FORUM_ID, this.fSU.getForumId());
        amVar.x("obj_param1", this.fSU.getPbData().bgj().getThreadType() == 40 ? 2 : 1);
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aA("obj_param2", TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && bhL()) {
            final int[] iArr = new int[2];
            final int measuredHeight = view.getMeasuredHeight();
            view.getLocationOnScreen(iArr);
            getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                @Override // java.lang.Runnable
                public void run() {
                    int h;
                    int aQ = (com.baidu.adp.lib.util.l.aQ(PbActivity.this.getPageContext().getPageActivity()) - iArr[1]) - measuredHeight;
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        h = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0210e.ds120);
                    } else {
                        h = com.baidu.adp.lib.util.l.h(PbActivity.this.getPageContext().getPageActivity(), e.C0210e.ds640);
                    }
                    int i = h - aQ;
                    if (i > 0) {
                        PbActivity.this.bhE().getListView().smoothScrollBy(i, 0);
                    }
                    if (PbActivity.this.bhE().bkz() != null) {
                        PbActivity.this.fTk.LX().setVisibility(8);
                        PbActivity.this.bhE().bkz().cn(str, str2);
                        com.baidu.tbadk.editortools.pb.g biV = PbActivity.this.bhE().bkz().biV();
                        if (biV != null && PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null) {
                            biV.a(PbActivity.this.fSU.getPbData().yE());
                        }
                        if (PbActivity.this.fTc.blO() == null && PbActivity.this.bhE().bkz().biV().MX() != null) {
                            PbActivity.this.bhE().bkz().biV().MX().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    if (PbActivity.this.fTc != null && PbActivity.this.fTc.blN() != null) {
                                        if (!PbActivity.this.fTc.blN().bMX()) {
                                            PbActivity.this.fTc.ly(false);
                                        }
                                        PbActivity.this.fTc.blN().or(false);
                                    }
                                }
                            });
                            PbActivity.this.fTc.h(PbActivity.this.bhE().bkz().biV().MX().getInputView());
                            PbActivity.this.bhE().bkz().biV().a(PbActivity.this.fTo);
                        }
                    }
                    PbActivity.this.bhE().blu();
                }
            }, 500L);
        }
    }

    public boolean bhL() {
        if (this.ffd == null || this.fSU.getPbData() == null || this.fSU.getPbData().yE() == null) {
            return true;
        }
        return this.ffd.dK(this.fSU.getPbData().yE().replyPrivateFlag);
    }

    public boolean sd(int i) {
        if (this.ffd == null || this.fSU.getPbData() == null || this.fSU.getPbData().yE() == null) {
            return true;
        }
        return this.ffd.x(this.fSU.getPbData().yE().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(e.g.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null && this.fSU != null && this.fSU.getPbData() != null && postData.bDr() != 1) {
            String bjd = this.fSU.bjd();
            String id = postData.getId();
            int bgv = this.fSU.getPbData() != null ? this.fSU.getPbData().bgv() : 0;
            c sT = sT(id);
            if (sT != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bjd, id, "pb", true, null, false, null, bgv, postData.bmX(), this.fSU.getPbData().yE(), false, postData.zG() != null ? postData.zG().getIconInfo() : null).addBigImageData(sT.fUO, sT.fUP, sT.fUQ, sT.index);
                addBigImageData.setKeyPageStartFrom(this.fSU.bjI());
                addBigImageData.setFromFrsForumId(this.fSU.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bhM() {
        if (this.fSU.getPbData() == null || this.fSU.getPbData().bgj() == null) {
            return -1;
        }
        return this.fSU.getPbData().bgj().Ak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhN() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.uX(this.fSU.getForumId()) && this.fSU.getPbData() != null && this.fSU.getPbData().bgh() != null) {
            if (this.fSU.getPbData().bgh().isLike() == 1) {
                this.fSU.bjE().cE(this.fSU.getForumId(), this.fSU.bjd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kG(boolean z) {
        if (this.fSU == null || this.fSU.getPbData() == null) {
            return false;
        }
        return ((this.fSU.getPbData().bgv() != 0) || this.fSU.getPbData().bgj() == null || this.fSU.getPbData().bgj().zG() == null || TextUtils.equals(this.fSU.getPbData().bgj().zG().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bhO() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.p.u.PC()) {
            return "";
        }
        PostData bgq = bgq();
        if (this.fSU == null || (pbData = this.fSU.getPbData()) == null || pbData.getUserData() == null || pbData.bgj() == null || bgq == null || bgq.zG() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bgq.zG().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bgj().zo() == 0) {
            return "";
        }
        if (pbData.bgj().zo() == 0) {
            return getPageContext().getString(e.j.fans_call);
        }
        return getPageContext().getString(e.j.haved_fans_call);
    }

    private boolean kH(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.t tVar;
        if (z) {
            return true;
        }
        if (this.fSU == null || this.fSU.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.fSU.getPbData();
        if (pbData.bgv() == 0) {
            List<com.baidu.tbadk.core.data.ay> bgF = pbData.bgF();
            if (com.baidu.tbadk.core.util.v.H(bgF) > 0) {
                for (com.baidu.tbadk.core.data.ay ayVar : bgF) {
                    if (ayVar != null && (tVar = ayVar.ata) != null && tVar.ara && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
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

    private boolean kI(boolean z) {
        return (z || this.fSU == null || this.fSU.getPbData() == null || this.fSU.getPbData().bgv() == 0) ? false : true;
    }

    public void bhP() {
        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null && this.fSU.getPbData().bgj().zG() != null) {
            if (this.fSX != null) {
                this.fSX.bkx();
            }
            bb bgj = this.fSU.getPbData().bgj();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgj.zG().getUserId());
            ab abVar = new ab();
            int bgv = this.fSU.getPbData().bgv();
            if (bgv == 1) {
                abVar.gac = true;
                abVar.gab = true;
                abVar.gaj = bgj.zB() == 1;
                abVar.gai = bgj.zC() == 1;
            } else {
                abVar.gac = false;
                abVar.gab = false;
            }
            if (bgv == 1002 && !equals) {
                abVar.gan = true;
            }
            abVar.fZZ = TbadkCoreApplication.getInst().appResponseToCmd(2015005);
            abVar.gad = kH(equals);
            abVar.gae = bhQ();
            abVar.gaf = kI(equals);
            abVar.qZ = this.fSU.bje();
            abVar.gaa = true;
            abVar.fQS = this.fSW != null && this.fSW.wq();
            abVar.fZY = kG(equals);
            abVar.gal = bhO();
            abVar.fZX = equals && this.fSX.ble();
            abVar.gag = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.gah = true;
            abVar.isHostOnly = this.fSU.getHostMode();
            abVar.gak = true;
            if (bgj.zY() == null) {
                abVar.gam = true;
            } else {
                abVar.gam = false;
            }
            this.fSX.gbT.a(abVar);
        }
    }

    private boolean bhQ() {
        if (this.fSU != null && this.fSU.bje()) {
            return this.fSU.getPageData() == null || this.fSU.getPageData().yQ() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    public int bhR() {
        if (bhE() == null || bhE().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bhE().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof com.baidu.tieba.pb.data.h) && ((com.baidu.tieba.pb.data.h) hVar).mType == com.baidu.tieba.pb.data.h.fQF) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bhS() {
        if (bhE() == null || bhE().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bhE().getListView();
        List<com.baidu.adp.widget.ListView.h> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.h hVar = data.get(i);
            if ((hVar instanceof PostData) && hVar.getType() == PostData.hln) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bhZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.eA(getResources().getString(e.j.mark_done));
            aVar.bm(true);
            aVar.eB(getResources().getString(e.j.mark_like));
            aVar.bl(true);
            aVar.bf(false);
            aVar.b(getResources().getString(e.j.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").aA(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).x("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(e.j.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").aA(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).x("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.aCb.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.fSU.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).BF();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.fSX.bkX();
        this.fSU.kW(z);
        if (this.fSW != null) {
            this.fSW.aP(z);
            if (markData != null) {
                this.fSW.a(markData);
            }
        }
        if (this.fSU.wq()) {
            bhX();
        } else {
            this.fSX.n(this.fSU.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sb(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sQ(String str) {
        this.fSV.tm(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
                if (!this.fSU.bjk()) {
                    antiData.setBlock_forum_name(this.fSU.getPbData().bgh().getName());
                    antiData.setBlock_forum_id(this.fSU.getPbData().bgh().getId());
                    antiData.setUser_name(this.fSU.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.fSU.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                a(postWriteCallBackData.getContriInfo());
            } else if (bhE() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.ai(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.aCL));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.aCL));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.aCL));
            }
        } else if (i == 230277) {
            hT(str);
        } else {
            this.fSX.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.hnI) ? bVar.hnI : getString(e.j.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.eB(string);
                aVar.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.bf(true);
                aVar.b(getPageContext());
                aVar.BF();
            } else {
                this.fSX.a(0, bVar.HZ, bVar.hnI, z);
            }
            if (bVar.HZ) {
                if (bVar.hnG == 1) {
                    ArrayList<PostData> bgl = this.fSU.getPbData().bgl();
                    int size = bgl.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bgl.get(i).getId())) {
                            i++;
                        } else {
                            bgl.remove(i);
                            break;
                        }
                    }
                    this.fSX.n(this.fSU.getPbData());
                } else if (bVar.hnG == 0) {
                    bhT();
                } else if (bVar.hnG == 2) {
                    ArrayList<PostData> bgl2 = this.fSU.getPbData().bgl();
                    int size2 = bgl2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bgl2.get(i2).bDo().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bgl2.get(i2).bDo().get(i3).getId())) {
                                i3++;
                            } else {
                                bgl2.get(i2).bDo().remove(i3);
                                bgl2.get(i2).bDq();
                                z2 = true;
                                break;
                            }
                        }
                        bgl2.get(i2).vD(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.fSX.n(this.fSU.getPbData());
                    }
                    a(bVar, this.fSX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.fSX.a(this.cVI.getLoadDataMode(), gVar.HZ, gVar.hnI, false);
            if (gVar.HZ) {
                this.fSZ = true;
                if (i == 2 || i == 3) {
                    this.fTa = true;
                    this.fTb = false;
                } else if (i == 4 || i == 5) {
                    this.fTa = false;
                    this.fTb = true;
                }
                if (i == 2) {
                    this.fSU.getPbData().bgj().cS(1);
                    this.fSU.setIsGood(1);
                } else if (i == 3) {
                    this.fSU.getPbData().bgj().cS(0);
                    this.fSU.setIsGood(0);
                } else if (i == 4) {
                    this.fSU.getPbData().bgj().cR(1);
                    this.fSU.kO(1);
                } else if (i == 5) {
                    this.fSU.getPbData().bgj().cR(0);
                    this.fSU.kO(0);
                }
                this.fSX.c(this.fSU.getPbData(), this.fSU.bje());
            }
        }
    }

    private void bhT() {
        if (this.fSU.bjf() || this.fSU.bjh()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.fSU.bjd());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.fSU.bjd()));
        if (bhY()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhU() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bgs;
        boolean z = false;
        if (this.fSX != null) {
            this.fSX.bll();
        }
        if (this.fSU != null && this.fSU.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.fSU.getPbData().bgj().getId();
            if (this.fSU.isShareThread() && this.fSU.getPbData().bgj().avt != null) {
                historyMessage.threadName = this.fSU.getPbData().bgj().avt.showText;
            } else {
                historyMessage.threadName = this.fSU.getPbData().bgj().getTitle();
            }
            if (this.fSU.isShareThread() && !bhd()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.fSU.getPbData().bgh().getName();
            }
            ArrayList<PostData> bgl = this.fSU.getPbData().bgl();
            int bkZ = this.fSX != null ? this.fSX.bkZ() : 0;
            if (bgl != null && bkZ >= 0 && bkZ < bgl.size()) {
                historyMessage.postID = bgl.get(bkZ).getId();
            }
            historyMessage.isHostOnly = this.fSU.getHostMode();
            historyMessage.isSquence = this.fSU.bje();
            historyMessage.isShareThread = this.fSU.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.fTk != null) {
            this.fTk.onDestroy();
        }
        if (this.fSE && bhE() != null) {
            bhE().blE();
        }
        if (this.fSU != null && (this.fSU.bjf() || this.fSU.bjh())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.fSU.bjd());
            if (this.fSZ) {
                if (this.fTb) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.fSU.bjj());
                }
                if (this.fTa) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.fSU.getIsGood());
                }
            }
            if (this.fSU.getPbData() != null && System.currentTimeMillis() - this.fSH >= 40000 && (bgs = this.fSU.getPbData().bgs()) != null && !com.baidu.tbadk.core.util.v.I(bgs.getDataList())) {
                intent.putExtra("guess_like_data", bgs);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.fTy);
            }
            setResult(-1, intent);
        }
        if (bhY()) {
            if (this.fSU != null && this.fSX != null && this.fSX.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.fSU.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bgp() && !this.fSN) {
                        aj bkl = aj.bkl();
                        com.baidu.tieba.pb.data.d pbData2 = this.fSU.getPbData();
                        Parcelable onSaveInstanceState = this.fSX.getListView().onSaveInstanceState();
                        boolean bje = this.fSU.bje();
                        boolean hostMode = this.fSU.getHostMode();
                        if (this.fSX.bkI() != null && this.fSX.bkI().getVisibility() == 0) {
                            z = true;
                        }
                        bkl.a(pbData2, onSaveInstanceState, bje, hostMode, z);
                        if (this.fTx >= 0 || this.fSU.bjK() != null) {
                            aj.bkl().j(this.fSU.bjK());
                            aj.bkl().i(this.fSU.bjL());
                            aj.bkl().sw(this.fSU.bjM());
                        }
                    }
                }
            } else {
                aj.bkl().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.fSX == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.fSX.sA(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean se(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.fSX.bkx();
            this.fSX.bkz().biQ();
            this.fSX.ls(false);
        }
        this.fSX.bkA();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.fTk.resetData();
                        this.fTk.b(writeData);
                        this.fTk.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k fK = this.fTk.LX().fK(6);
                        if (fK != null && fK.aYi != null) {
                            fK.aYi.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.fTk.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.fSX.bkz() != null && this.fSX.bkz().biV() != null) {
                            com.baidu.tbadk.editortools.pb.g biV = this.fSX.bkz().biV();
                            biV.b(writeData);
                            biV.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k fK2 = biV.LX().fK(6);
                            if (fK2 != null && fK2.aYi != null) {
                                fK2.aYi.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                biV.MP();
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
        this.fTk.onActivityResult(i, i2, intent);
        if (this.fSR != null) {
            this.fSR.onActivityResult(i, i2, intent);
        }
        if (bhE().bkz() != null) {
            bhE().bkz().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bhW();
                    return;
                case 13008:
                    aj.bkl().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.fSU != null) {
                                PbActivity.this.fSU.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.bug().x(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.fSU != null) {
                        a(bhV(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.bug().x(getPageContext());
                        bhN();
                        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.dXG != null && shareItem != null && shareItem.linkUrl != null) {
                            this.dXG.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void IY() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57.1
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
                    this.fSX.kE(false);
                    if (this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null && this.fSU.getPbData().bgj().Ab() != null) {
                        this.fSU.getPbData().bgj().Ab().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.fTm = emotionImageData;
                        if (sd(com.baidu.tbadk.core.util.aj.aBY)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.fSX != null && this.fSX.gbT != null) {
                        this.fSX.gbT.dismissPopMenu();
                        this.fSX.gbT.bmg();
                        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null) {
                            this.fSU.getPbData().bgj().cN(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.fSS != null) {
                        this.fSX.bD(this.fSS);
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
            if (this.fSR == null) {
                this.fSR = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.fSR.b(this.aZY);
                this.fSR.c(this.baf);
            }
            this.fSR.a(emotionImageData, bhn(), bhn().getPbData());
        }
    }

    private ShareFromPBMsgData bhV() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] cP = this.fSU.getPbData().cP(getPageContext().getPageActivity());
        PostData bkC = this.fSX.bkC();
        String str = "";
        if (bkC != null) {
            str = bkC.getId();
            String da = bkC.da(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(da)) {
                cP[1] = da;
            }
        }
        String zX = this.fSU.getPbData().bgj().zX();
        if (zX != null && zX.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(cP[1]);
        shareFromPBMsgData.setImageUrl(cP[0]);
        shareFromPBMsgData.setForumName(this.fSU.getPbData().bgh().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.fSU.getPbData().bgj().getId());
        shareFromPBMsgData.setTitle(this.fSU.getPbData().bgj().getTitle());
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bhV(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null) {
                        com.baidu.tbadk.core.util.am aA = new com.baidu.tbadk.core.util.am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_param1", 3).aA(ImageViewerConfig.FORUM_ID, PbActivity.this.fSU.getForumId()).aA("tid", PbActivity.this.fSU.bjd());
                        if (PbActivity.this.e(PbActivity.this.fSU.getPbData()) != 0) {
                            aA.x("obj_type", PbActivity.this.e(PbActivity.this.fSU.getPbData()));
                        }
                        TiebaStatic.log(aA);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(getPageContext()).BF();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.N(shareFromPBMsgData.getImageUrl(), this.fSU.getPbData().bgw() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(getPageContext()).BF();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.N(shareFromPBMsgData.getImageUrl(), this.fSU.getPbData().bgw() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhW() {
        MarkData st;
        if (this.fSW != null && (st = this.fSU.st(this.fSX.bla())) != null) {
            if (!st.isApp() || (st = this.fSU.st(this.fSX.bla() + 1)) != null) {
                this.fSX.bkV();
                this.fSW.a(st);
                if (!this.fSW.wq()) {
                    this.fSW.ws();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.fSW.wr();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhX() {
        com.baidu.tieba.pb.data.d pbData = this.fSU.getPbData();
        this.fSU.kW(true);
        if (this.fSW != null) {
            pbData.sL(this.fSW.wp());
        }
        this.fSX.n(pbData);
    }

    private boolean bhY() {
        if (this.fSU == null) {
            return true;
        }
        if (this.fSU.wq()) {
            final MarkData bjs = this.fSU.bjs();
            if (bjs == null || !this.fSU.getIsFromMark()) {
                return true;
            }
            final MarkData st = this.fSU.st(this.fSX.bkZ());
            if (st == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bjs);
                setResult(-1, intent);
                return true;
            } else if (st.getPostId() == null || st.getPostId().equals(bjs.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bjs);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.eB(getPageContext().getString(e.j.alert_update_mark));
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.fSW != null) {
                            if (PbActivity.this.fSW.wq()) {
                                PbActivity.this.fSW.wr();
                                PbActivity.this.fSW.aP(false);
                            }
                            PbActivity.this.fSW.a(st);
                            PbActivity.this.fSW.aP(true);
                            PbActivity.this.fSW.ws();
                        }
                        bjs.setPostId(st.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bjs);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bhU();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bjs);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bhU();
                    }
                });
                aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.fSX != null && PbActivity.this.fSX.getView() != null) {
                            PbActivity.this.fSX.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bjs);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bhU();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.BF();
                return false;
            }
        } else if (this.fSU.getPbData() == null || this.fSU.getPbData().bgl() == null || this.fSU.getPbData().bgl().size() <= 0 || !this.fSU.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.fSX == null) {
            return null;
        }
        return this.fSX.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int SG() {
        if (this.fSX == null) {
            return 0;
        }
        return this.fSX.blj();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> SH() {
        if (this.brD == null) {
            this.brD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: alU */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean xI = com.baidu.tbadk.core.i.xE().xI();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(e.d.common_color_10220));
                    if (xI) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(e.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public void u(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public ImageView v(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.xE().xI()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(e.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public ImageView w(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.brD;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> SI() {
        if (this.brE == null) {
            this.brE = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.brE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> SJ() {
        if (this.brI == null) {
            this.brI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bit */
                public GifView jz() {
                    return new GifView(PbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void u(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView v(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView w(GifView gifView) {
                    gifView.release();
                    gifView.setImageDrawable(null);
                    gifView.Nr();
                    gifView.setBackgroundDrawable(null);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.brI;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> SK() {
        if (this.brF == null) {
            this.brF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: biu */
                public View jz() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0210e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: by */
                public View v(View view) {
                    ((PlayVoiceBntNew) view).bEB();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bz */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.brF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> SM() {
        this.brH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: biv */
            public RelativeLayout jz() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout v(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout w(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.brH;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Fv() {
        if (this.aKN == null) {
            this.aKN = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aKN;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.fSL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (aw.te(str) && this.fSU != null && this.fSU.bjd() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").x("obj_param1", 1).aA("post_id", this.fSU.bjd()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                iVar.mLink = str;
                iVar.type = 3;
                iVar.aXm = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
            }
        } else {
            aw.blQ().c(getPageContext(), str);
        }
        this.fSL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
        aw.blQ().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.fSL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Rect rect) {
        if (rect != null && this.fSX != null && this.fSX.blz() != null && rect.top <= this.fSX.blz().getHeight()) {
            rect.top += this.fSX.blz().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.fSU.getPbData();
            TbRichText aL = aL(str, i);
            if (aL != null && (tbRichTextData = aL.RZ().get(this.fUc)) != null) {
                cVar.fUO = new ArrayList<>();
                cVar.fUP = new ConcurrentHashMap<>();
                if (!tbRichTextData.Sf().Sr()) {
                    cVar.fUR = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.fUO.add(b2);
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
                    imageUrlData.postId = aL.getPostId();
                    imageUrlData.mIsReserver = this.fSU.bjq();
                    imageUrlData.mIsSeeHost = this.fSU.getHostMode();
                    cVar.fUP.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.bgh() != null) {
                            cVar.forumName = pbData.bgh().getName();
                            cVar.forumId = pbData.bgh().getId();
                        }
                        if (pbData.bgj() != null) {
                            cVar.threadId = pbData.bgj().getId();
                        }
                        cVar.fUQ = pbData.bgw() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(cVar.threadId, -1L);
                    return;
                }
                cVar.fUR = true;
                int size = pbData.bgl().size();
                this.fUd = false;
                cVar.index = -1;
                if (pbData.bgq() != null) {
                    PostData bgq = pbData.bgq();
                    TbRichText bDt = bgq.bDt();
                    if (!aq.k(bgq)) {
                        i2 = a(bDt, aL, i, i, cVar.fUO, cVar.fUP);
                    } else {
                        i2 = a(bgq, i, cVar.fUO, cVar.fUP);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bgl().get(i4);
                    if (postData.getId() == null || pbData.bgq() == null || pbData.bgq().getId() == null || !postData.getId().equals(pbData.bgq().getId())) {
                        TbRichText bDt2 = postData.bDt();
                        if (!aq.k(postData)) {
                            i3 = a(bDt2, aL, i3, i, cVar.fUO, cVar.fUP);
                        } else {
                            i3 = a(postData, i3, cVar.fUO, cVar.fUP);
                        }
                    }
                }
                if (cVar.fUO.size() > 0) {
                    cVar.lastId = cVar.fUO.get(cVar.fUO.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.bgh() != null) {
                        cVar.forumName = pbData.bgh().getName();
                        cVar.forumId = pbData.bgh().getId();
                    }
                    if (pbData.bgj() != null) {
                        cVar.threadId = pbData.bgj().getId();
                    }
                    cVar.fUQ = pbData.bgw() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Sf() == null) {
            return null;
        }
        return tbRichTextData.Sf().Sx();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Sf() == null) {
            return 0L;
        }
        return tbRichTextData.Sf().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Sf() == null) {
            return false;
        }
        return tbRichTextData.Sf().Sy();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.Sf() == null) {
            return false;
        }
        return tbRichTextData.Sf().Sz();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Sf;
        String str;
        if (tbRichText == tbRichText2) {
            this.fUd = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.RZ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.RZ().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.Sf().getWidth() * aR;
                    int height = aR * tbRichTextData.Sf().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.Sf().Sr()) {
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
                            if (tbRichTextData != null && (Sf = tbRichTextData.Sf()) != null) {
                                String Su = Sf.Su();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = Sf.Sv();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = Su;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fSU.bjd(), -1L);
                                imageUrlData.mIsReserver = this.fSU.bjq();
                                imageUrlData.mIsSeeHost = this.fSU.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.fUd) {
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
        com.baidu.tieba.tbadkCore.data.h bDA;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> bCW;
        if (postData != null && arrayList != null && concurrentHashMap != null && (bCW = (bDA = postData.bDA()).bCW()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == bCW.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.j jVar = bCW.get(i3);
                if (jVar != null) {
                    String bDa = jVar.bDa();
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(bDa)) {
                        arrayList.add(bDa);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = bDa;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = jVar.bCZ();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.fSU.bjd(), -1L);
                        imageUrlData.mIsReserver = this.fSU.bjq();
                        imageUrlData.mIsSeeHost = this.fSU.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = bDA.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(bDa, imageUrlData);
                        }
                        if (!this.fUd) {
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
            if (postData.getId() != null && postData.getId().equals(this.fSU.zQ())) {
                z = true;
            }
            MarkData h = this.fSU.h(postData);
            if (h != null) {
                this.fSX.bkV();
                if (this.fSW != null) {
                    this.fSW.a(h);
                    if (!z) {
                        this.fSW.ws();
                    } else {
                        this.fSW.wr();
                    }
                }
            }
        }
    }

    public boolean bv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aL(String str, int i) {
        TbRichText tbRichText = null;
        if (this.fSU == null || this.fSU.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.fSU.getPbData();
        if (pbData.bgq() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bgq());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bgl = pbData.bgl();
            a(pbData, bgl);
            return a(bgl, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bgu() != null && dVar.bgu().fQU != null && (list = dVar.bgu().fQU) != null && arrayList != null) {
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

    private long sR(String str) {
        ArrayList<PostData> bgl;
        com.baidu.tieba.pb.data.d pbData = this.fSU.getPbData();
        if (pbData != null && (bgl = pbData.bgl()) != null && !bgl.isEmpty()) {
            Iterator<PostData> it = bgl.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.h bDA = next.bDA();
                if (bDA != null && bDA.hkU) {
                    Iterator<TbRichTextData> it2 = next.bDt().RZ().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.So().getLink().equals(str)) {
                            return bDA.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> RZ;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText bDt = arrayList.get(i2).bDt();
            if (bDt != null && (RZ = bDt.RZ()) != null) {
                int size = RZ.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (RZ.get(i4) != null && RZ.get(i4).getType() == 8) {
                        i3++;
                        if (RZ.get(i4).Sf().Su().equals(str) || RZ.get(i4).Sf().Sv().equals(str)) {
                            int aR = (int) com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
                            int width = RZ.get(i4).Sf().getWidth() * aR;
                            int height = RZ.get(i4).Sf().getHeight() * aR;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.fUc = i4;
                            return bDt;
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
    public void i(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.fSv = str;
            if (this.fSG == null) {
                bhI();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.fSG.dj(1).setVisibility(8);
            } else {
                this.fSG.dj(1).setVisibility(0);
            }
            this.fSG.BI();
            this.fSL = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dIc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhZ() {
        hideNetRefreshView(this.fSX.getView());
        bia();
        if (this.fSU.Ow()) {
            this.fSX.bkV();
        }
    }

    private void bia() {
        showLoadingView(this.fSX.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds400));
        View NJ = getLoadingView().NJ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) NJ.getLayoutParams();
        layoutParams.addRule(3, this.fSX.blz().getId());
        NJ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAX() {
        if (this.dIc != null) {
            this.dIc.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sf(int i) {
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
    public void sg(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        if (this.fSU.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.fSU.getPbData();
            pbData.bgh().getName();
            String title = pbData.bgj().getTitle();
            int i2 = this.fSU.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.bgh() != null) {
                if ((pbData.bgh().isLike() == 1) && AddExperiencedModel.uX(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.fSU.bjd() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] cP = pbData.cP(getPageContext().getPageActivity());
                    str = cP[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = cP[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bhM() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").aA(ImageViewerConfig.FORUM_ID, pbData.getForumId()).aA("tid", pbData.getThreadId()).aA("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                    dVar.title = title;
                    dVar.content = str2;
                    dVar.linkUrl = str3;
                    dVar.aRY = true;
                    dVar.aSd = z;
                    dVar.extData = this.fSU.bjd();
                    dVar.aSm = 3;
                    dVar.aSl = i;
                    dVar.fid = this.fSU.getForumId();
                    dVar.tid = this.fSU.bjd();
                    dVar.aSn = e(pbData);
                    dVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        dVar.imageUri = parse;
                    }
                    dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fSU.getPbData().bgj());
                    TbadkCoreApplication.getInst().setShareItem(dVar);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", dVar.aSm);
                    bundle.putInt("obj_type", dVar.aSn);
                    bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
                    bundle.putString("tid", dVar.tid);
                    bundle.putString("uid", dVar.uid);
                    dVar.k(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgI()) {
                                PbActivity.this.fSX.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.aro().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.fSU.bjd() + "?share=9105&fr=share&see_lz=" + i2;
            String[] cP2 = pbData.cP(getPageContext().getPageActivity());
            str = cP2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = cP2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bhM() == 1) {
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = title;
            dVar2.content = str2;
            dVar2.linkUrl = str32;
            dVar2.aRY = true;
            dVar2.aSd = z;
            dVar2.extData = this.fSU.bjd();
            dVar2.aSm = 3;
            dVar2.aSl = i;
            dVar2.fid = this.fSU.getForumId();
            dVar2.tid = this.fSU.bjd();
            dVar2.aSn = e(pbData);
            dVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            dVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.fSU.getPbData().bgj());
            TbadkCoreApplication.getInst().setShareItem(dVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", dVar2.aSm);
            bundle2.putInt("obj_type", dVar2.aSn);
            bundle2.putString(ImageViewerConfig.FORUM_ID, dVar2.fid);
            bundle2.putString("tid", dVar2.tid);
            bundle2.putString("uid", dVar2.uid);
            dVar2.k(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.fSU != null && PbActivity.this.fSU.getPbData() != null && PbActivity.this.fSU.getPbData().bgI()) {
                        PbActivity.this.fSX.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.aro().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bgj() != null) {
            if (dVar.bgj().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bgj().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bib() {
        com.baidu.tbadk.util.x.a(new com.baidu.tbadk.util.w<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.uY(PbActivity.this.fSU.getForumId()));
            }
        }, new com.baidu.tbadk.util.h<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.fSX.blF();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> SL() {
        if (this.brG == null) {
            this.brG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: biw */
                public LinearLayout jz() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
                    linearLayout.setId(e.g.pb_text_voice_layout);
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
                public void u(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout v(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout w(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.brG;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fSX.bkQ() == view) {
            if (!TbadkCoreApplication.isLogin()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).aA(ImageViewerConfig.FORUM_ID, this.fSU.getPbData().getForumId()));
            } else {
                bb bgj = this.fSU.getPbData().bgj();
                if (view != null) {
                    boolean z = bgj.zt() == null || bgj.zt().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - this.fTP > 1000) {
                            this.fTQ = true;
                            bw(view);
                        } else {
                            this.fTQ = false;
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            k(view, this.fTQ);
                        } else {
                            j(view, this.fTQ);
                        }
                    } else if (motionEvent.getAction() == 2) {
                        j(view, this.fTQ);
                    } else if (motionEvent.getAction() == 3) {
                        j(view, this.fTQ);
                    }
                }
            }
        }
        return false;
    }

    private void j(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale2));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fTP = System.currentTimeMillis();
                }
            }, 200L);
        }
    }

    private void k(View view, boolean z) {
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale3));
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
                @Override // java.lang.Runnable
                public void run() {
                    PbActivity.this.fTP = System.currentTimeMillis();
                }
            }, 600L);
        }
    }

    private void bw(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getPageContext().getPageActivity(), e.a.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void aAY() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData azX() {
        if (this.fSU == null || this.fSU.getPbData() == null) {
            return null;
        }
        return this.fSU.getPbData().yE();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.BH() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.BH();
            int intValue = ((Integer) sparseArray.get(ar.gdG)).intValue();
            if (intValue == ar.gdH) {
                if (!this.cVI.bEc()) {
                    this.fSX.bkS();
                    String str = (String) sparseArray.get(e.g.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.cVI.vJ(com.baidu.tbadk.core.util.ao.i(jSONArray));
                    }
                    this.cVI.a(this.fSU.getPbData().bgh().getId(), this.fSU.getPbData().bgh().getName(), this.fSU.getPbData().bgj().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == ar.gdI || intValue == ar.gdK) {
                if (this.fSU.bjB() != null) {
                    this.fSU.bjB().sj(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ar.gdI) {
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
        if (sparseArray.get(e.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(e.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(e.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(e.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(e.g.tag_user_mute_post_id);
        }
        if (sparseArray.get(e.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(e.g.tag_user_mute_msg);
        }
        if (sparseArray.get(e.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.fTr);
        userMuteAddAndDelCustomMessage.setTag(this.fTr);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean sS(String str) {
        if (!StringUtils.isNull(str) && ba.bJ(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(e.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void kJ(boolean z) {
        this.fTf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bic() {
        ArrayList<PostData> bgl;
        int H;
        if (this.fSU == null || this.fSU.getPbData() == null || this.fSU.getPbData().bgl() == null || (H = com.baidu.tbadk.core.util.v.H((bgl = this.fSU.getPbData().bgl()))) == 0) {
            return "";
        }
        if (this.fSU.bjq()) {
            Iterator<PostData> it = bgl.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.bDr() == 1) {
                    return next.getId();
                }
            }
        }
        int bkZ = this.fSX.bkZ();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bgl, bkZ);
        if (postData == null || postData.zG() == null) {
            return "";
        }
        if (this.fSU.sV(postData.zG().getUserId())) {
            return postData.getId();
        }
        for (int i = bkZ - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(bgl, i);
            if (postData2 == null || postData2.zG() == null || postData2.zG().getUserId() == null) {
                break;
            } else if (this.fSU.sV(postData2.zG().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bkZ + 1; i2 < H; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(bgl, i2);
            if (postData3 == null || postData3.zG() == null || postData3.zG().getUserId() == null) {
                return "";
            }
            if (this.fSU.sV(postData3.zG().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ar(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ay.Ef().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(sR(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.fSU.getPbData().bgh().getId(), this.fSU.getPbData().bgh().getName(), this.fSU.getPbData().bgj().getTid());
            }
            this.fSL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.eB(getResources().getString(e.j.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.eB(getResources().getString(e.j.make_sure_hide));
        }
        aVar.a(getResources().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.fSU.bjA() != null) {
                    PbActivity.this.fSU.bjA().cT(j);
                }
            }
        });
        aVar.b(getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.bg(false);
        aVar.b(getPageContext());
        aVar.BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c sT(String str) {
        String str2;
        if (this.fSU.getPbData() == null || this.fSU.getPbData().bgl() == null || this.fSU.getPbData().bgl().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.fSU.getPbData().bgl().size()) {
                i = 0;
                break;
            } else if (str.equals(this.fSU.getPbData().bgl().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.fSU.getPbData().bgl().get(i);
        if (postData.bDt() == null || postData.bDt().RZ() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.bDt().RZ().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.Sf() != null) {
                    str2 = next.Sf().Su();
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
        if (this.fSC) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.fSC = false;
        } else if (bid()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fSC) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.fSC = false;
        } else if (bid()) {
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
        if (pageStayDurationItem != null && this.fSU != null) {
            if (this.fSU.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.fSU.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.fSU.bjd(), 0L));
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bid() {
        return (!this.fSA && this.fUk == -1 && this.fUl == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            this.fUn = mVar;
            this.fSA = true;
            this.fSX.bkJ();
            this.fSX.tc(this.fUm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bie() {
        if (this.fUn != null) {
            if (this.fUk == -1) {
                showToast(e.j.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fUn.getCartoonId(), this.fUk, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bif() {
        if (this.fUn != null) {
            if (this.fUl == -1) {
                showToast(e.j.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.fUn.getCartoonId(), this.fUl, 0)));
                finish();
            }
        }
    }

    public int big() {
        return this.fUk;
    }

    public int bih() {
        return this.fUl;
    }

    private void aMe() {
        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null && this.fSU.getPbData().bgj().Au()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bii() {
        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null && this.fSU.getPbData().bgj().Au()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bij() {
        if (this.fSD) {
            this.fSQ = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null && this.fSU.getPbData().bgj().zn() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fSU.getPbData().bgj().zn().getThreadId(), this.fSU.getPbData().bgj().zn().getTaskId(), this.fSU.getPbData().bgj().zn().getForumId(), this.fSU.getPbData().bgj().zn().getForumName(), this.fSU.getPbData().bgj().zB(), this.fSU.getPbData().bgj().zC())));
            this.fSC = true;
            finish();
        }
    }

    public String bik() {
        return this.fSO;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bil() {
        return this.fST;
    }

    public void kK(boolean z) {
        this.fSP = z;
    }

    public boolean bim() {
        if (this.fSU != null) {
            return this.fSU.bjf();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bin() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.eB(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.fTp).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.fTp.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fTp).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT(String str) {
        if (str == null) {
            str = "";
        }
        if (this.fTp != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fTp.getPageActivity());
            aVar.eB(str);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fTp).BF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.fSX.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fTp.getPageActivity());
        if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            aVar.eB(this.fTp.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.eB(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.fSX.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fTp).BF();
    }

    public void bio() {
        if (this.fSU != null && this.fSU.getPbData() != null && this.fSU.getPbData().bgj() != null && this.fSU.getPbData().bgj().AJ() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.db(e.j.channel_open_push_message);
            aVar.a(e.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.fSU.getPbData().bgj().AJ().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(e.j.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.BF();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (aw.te(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_pb_wenxue)) != null) {
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
        if (this.fSX != null) {
            this.fSX.onConfigurationChanged(configuration);
        }
        if (this.fTd != null) {
            this.fTd.dismiss();
        }
    }

    public boolean bip() {
        if (this.fSU != null) {
            return this.fSU.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ar arVar) {
        boolean z;
        List<PostData> list = this.fSU.getPbData().bgu().fQU;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).bDo().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).bDo().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).bDo().remove(i2);
                    list.get(i).bDq();
                    z = true;
                    break;
                }
            }
            list.get(i).vD(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            arVar.n(this.fSU.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.j jVar) {
        String id = jVar.bgQ().getId();
        List<PostData> list = this.fSU.getPbData().bgu().fQU;
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
                ArrayList<PostData> bgU = jVar.bgU();
                postData.vu(jVar.getTotalCount());
                if (postData.bDo() != null) {
                    postData.bDo().clear();
                    postData.bDo().addAll(bgU);
                }
            }
        }
        if (!this.fSU.getIsFromMark()) {
            this.fSX.n(this.fSU.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bhc() {
        return this.fSY;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bhd() {
        if (this.fSU == null) {
            return false;
        }
        return this.fSU.bhd();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bhe() {
        if (this.fSU != null) {
            return this.fSU.bhe();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bhf() {
        if (this.fSU == null || this.fSU.getPbData() == null) {
            return 0;
        }
        return this.fSU.getPbData().bgv();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean sN(String str) {
        return this.fSU != null && this.fSU.sV(str);
    }

    public void biq() {
        if (this.fSX != null) {
            this.fSX.bkx();
            aAY();
        }
    }

    public PostData bgq() {
        return this.fSX.b(this.fSU.fYu, this.fSU.bje());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.isLinkThread()) {
                return 3;
            }
            if (bbVar.AL()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.fTz != null && !this.fTz.isEmpty()) {
            int size = this.fTz.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.fTz.get(i).onBackPressed()) {
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
            if (this.fTz == null) {
                this.fTz = new ArrayList();
            }
            if (!this.fTz.contains(aVar)) {
                this.fTz.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.fTz == null) {
                this.fTz = new ArrayList();
            }
            if (!this.fTz.contains(aVar)) {
                this.fTz.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.fTz != null) {
            this.fTz.remove(aVar);
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dIO == null) {
            this.dIO = new com.baidu.tbadk.core.dialog.h(getPageContext());
            this.dIO.a(new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.97
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bn(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dIO.a(contriInfo, -1L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        com.baidu.tbadk.core.util.ad.a(kVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bir() {
        if (this.fSU != null && !com.baidu.tbadk.core.util.ao.isEmpty(this.fSU.bjd())) {
            com.baidu.tbadk.BdToken.c.vu().f(com.baidu.tbadk.BdToken.b.ajO, com.baidu.adp.lib.g.b.d(this.fSU.bjd(), 0L));
        }
    }
}
